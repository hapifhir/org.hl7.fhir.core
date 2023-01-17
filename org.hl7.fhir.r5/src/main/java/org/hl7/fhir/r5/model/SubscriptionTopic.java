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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

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
 * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
 */
@ResourceDef(name="SubscriptionTopic", profile="http://hl7.org/fhir/StructureDefinition/SubscriptionTopic")
public class SubscriptionTopic extends CanonicalResource {

    public enum CriteriaNotExistsBehavior {
        /**
         * The requested conditional statement will pass if a matching state does not exist (e.g., previous state during create).
         */
        TESTPASSES, 
        /**
         * The requested conditional statement will fail if a matching state does not exist (e.g., previous state during create).
         */
        TESTFAILS, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CriteriaNotExistsBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("test-passes".equals(codeString))
          return TESTPASSES;
        if ("test-fails".equals(codeString))
          return TESTFAILS;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CriteriaNotExistsBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case TESTPASSES: return "test-passes";
            case TESTFAILS: return "test-fails";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case TESTPASSES: return "http://hl7.org/fhir/subscriptiontopic-cr-behavior";
            case TESTFAILS: return "http://hl7.org/fhir/subscriptiontopic-cr-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case TESTPASSES: return "The requested conditional statement will pass if a matching state does not exist (e.g., previous state during create).";
            case TESTFAILS: return "The requested conditional statement will fail if a matching state does not exist (e.g., previous state during create).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case TESTPASSES: return "test passes";
            case TESTFAILS: return "test fails";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CriteriaNotExistsBehaviorEnumFactory implements EnumFactory<CriteriaNotExistsBehavior> {
    public CriteriaNotExistsBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("test-passes".equals(codeString))
          return CriteriaNotExistsBehavior.TESTPASSES;
        if ("test-fails".equals(codeString))
          return CriteriaNotExistsBehavior.TESTFAILS;
        throw new IllegalArgumentException("Unknown CriteriaNotExistsBehavior code '"+codeString+"'");
        }
        public Enumeration<CriteriaNotExistsBehavior> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CriteriaNotExistsBehavior>(this, CriteriaNotExistsBehavior.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<CriteriaNotExistsBehavior>(this, CriteriaNotExistsBehavior.NULL, code);
        if ("test-passes".equals(codeString))
          return new Enumeration<CriteriaNotExistsBehavior>(this, CriteriaNotExistsBehavior.TESTPASSES, code);
        if ("test-fails".equals(codeString))
          return new Enumeration<CriteriaNotExistsBehavior>(this, CriteriaNotExistsBehavior.TESTFAILS, code);
        throw new FHIRException("Unknown CriteriaNotExistsBehavior code '"+codeString+"'");
        }
    public String toCode(CriteriaNotExistsBehavior code) {
      if (code == CriteriaNotExistsBehavior.TESTPASSES)
        return "test-passes";
      if (code == CriteriaNotExistsBehavior.TESTFAILS)
        return "test-fails";
      return "?";
      }
    public String toSystem(CriteriaNotExistsBehavior code) {
      return code.getSystem();
      }
    }

    public enum InteractionTrigger {
        /**
         * Create a new resource with a server assigned id.
         */
        CREATE, 
        /**
         * Update an existing resource by its id (or create it if it is new).
         */
        UPDATE, 
        /**
         * Delete a resource.
         */
        DELETE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static InteractionTrigger fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return CREATE;
        if ("update".equals(codeString))
          return UPDATE;
        if ("delete".equals(codeString))
          return DELETE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown InteractionTrigger code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CREATE: return "http://hl7.org/fhir/restful-interaction";
            case UPDATE: return "http://hl7.org/fhir/restful-interaction";
            case DELETE: return "http://hl7.org/fhir/restful-interaction";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CREATE: return "Create a new resource with a server assigned id.";
            case UPDATE: return "Update an existing resource by its id (or create it if it is new).";
            case DELETE: return "Delete a resource.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class InteractionTriggerEnumFactory implements EnumFactory<InteractionTrigger> {
    public InteractionTrigger fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return InteractionTrigger.CREATE;
        if ("update".equals(codeString))
          return InteractionTrigger.UPDATE;
        if ("delete".equals(codeString))
          return InteractionTrigger.DELETE;
        throw new IllegalArgumentException("Unknown InteractionTrigger code '"+codeString+"'");
        }
        public Enumeration<InteractionTrigger> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InteractionTrigger>(this, InteractionTrigger.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<InteractionTrigger>(this, InteractionTrigger.NULL, code);
        if ("create".equals(codeString))
          return new Enumeration<InteractionTrigger>(this, InteractionTrigger.CREATE, code);
        if ("update".equals(codeString))
          return new Enumeration<InteractionTrigger>(this, InteractionTrigger.UPDATE, code);
        if ("delete".equals(codeString))
          return new Enumeration<InteractionTrigger>(this, InteractionTrigger.DELETE, code);
        throw new FHIRException("Unknown InteractionTrigger code '"+codeString+"'");
        }
    public String toCode(InteractionTrigger code) {
      if (code == InteractionTrigger.CREATE)
        return "create";
      if (code == InteractionTrigger.UPDATE)
        return "update";
      if (code == InteractionTrigger.DELETE)
        return "delete";
      return "?";
      }
    public String toSystem(InteractionTrigger code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SubscriptionTopicResourceTriggerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The human readable description of this resource trigger for the SubscriptionTopic -  for example, "An Encounter enters the 'in-progress' state".
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text representation of the resource trigger", formalDefinition="The human readable description of this resource trigger for the SubscriptionTopic -  for example, \"An Encounter enters the 'in-progress' state\"." )
        protected MarkdownType description;

        /**
         * URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.
         */
        @Child(name = "resource", type = {UriType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Data Type or Resource (reference to definition) for this trigger definition", formalDefinition="URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, \"Patient\" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href=\"elementdefinition-definitions.html#ElementDefinition.type.code\">ElementDefinition.type.code</a>." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fhir-types")
        protected UriType resource;

        /**
         * The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).
         */
        @Child(name = "supportedInteraction", type = {CodeType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="create | update | delete", formalDefinition="The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-trigger")
        protected List<Enumeration<InteractionTrigger>> supportedInteraction;

        /**
         * The FHIR query based rules that the server should use to determine when to trigger a notification for this subscription topic.
         */
        @Child(name = "queryCriteria", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Query based trigger rule", formalDefinition="The FHIR query based rules that the server should use to determine when to trigger a notification for this subscription topic." )
        protected SubscriptionTopicResourceTriggerQueryCriteriaComponent queryCriteria;

        /**
         * The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "fhirPathCriteria", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath based trigger rule", formalDefinition="The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic." )
        protected StringType fhirPathCriteria;

        private static final long serialVersionUID = -1086940999L;

    /**
     * Constructor
     */
      public SubscriptionTopicResourceTriggerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionTopicResourceTriggerComponent(String resource) {
        super();
        this.setResource(resource);
      }

        /**
         * @return {@link #description} (The human readable description of this resource trigger for the SubscriptionTopic -  for example, "An Encounter enters the 'in-progress' state".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerComponent.description");
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
         * @param value {@link #description} (The human readable description of this resource trigger for the SubscriptionTopic -  for example, "An Encounter enters the 'in-progress' state".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The human readable description of this resource trigger for the SubscriptionTopic -  for example, "An Encounter enters the 'in-progress' state".
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The human readable description of this resource trigger for the SubscriptionTopic -  for example, "An Encounter enters the 'in-progress' state".
         */
        public SubscriptionTopicResourceTriggerComponent setDescription(String value) { 
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
         * @return {@link #resource} (URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public UriType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new UriType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerComponent setResourceElement(UriType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.
         */
        public SubscriptionTopicResourceTriggerComponent setResource(String value) { 
            if (this.resource == null)
              this.resource = new UriType();
            this.resource.setValue(value);
          return this;
        }

        /**
         * @return {@link #supportedInteraction} (The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).)
         */
        public List<Enumeration<InteractionTrigger>> getSupportedInteraction() { 
          if (this.supportedInteraction == null)
            this.supportedInteraction = new ArrayList<Enumeration<InteractionTrigger>>();
          return this.supportedInteraction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubscriptionTopicResourceTriggerComponent setSupportedInteraction(List<Enumeration<InteractionTrigger>> theSupportedInteraction) { 
          this.supportedInteraction = theSupportedInteraction;
          return this;
        }

        public boolean hasSupportedInteraction() { 
          if (this.supportedInteraction == null)
            return false;
          for (Enumeration<InteractionTrigger> item : this.supportedInteraction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #supportedInteraction} (The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).)
         */
        public Enumeration<InteractionTrigger> addSupportedInteractionElement() {//2 
          Enumeration<InteractionTrigger> t = new Enumeration<InteractionTrigger>(new InteractionTriggerEnumFactory());
          if (this.supportedInteraction == null)
            this.supportedInteraction = new ArrayList<Enumeration<InteractionTrigger>>();
          this.supportedInteraction.add(t);
          return t;
        }

        /**
         * @param value {@link #supportedInteraction} (The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).)
         */
        public SubscriptionTopicResourceTriggerComponent addSupportedInteraction(InteractionTrigger value) { //1
          Enumeration<InteractionTrigger> t = new Enumeration<InteractionTrigger>(new InteractionTriggerEnumFactory());
          t.setValue(value);
          if (this.supportedInteraction == null)
            this.supportedInteraction = new ArrayList<Enumeration<InteractionTrigger>>();
          this.supportedInteraction.add(t);
          return this;
        }

        /**
         * @param value {@link #supportedInteraction} (The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).)
         */
        public boolean hasSupportedInteraction(InteractionTrigger value) { 
          if (this.supportedInteraction == null)
            return false;
          for (Enumeration<InteractionTrigger> v : this.supportedInteraction)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #queryCriteria} (The FHIR query based rules that the server should use to determine when to trigger a notification for this subscription topic.)
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent getQueryCriteria() { 
          if (this.queryCriteria == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerComponent.queryCriteria");
            else if (Configuration.doAutoCreate())
              this.queryCriteria = new SubscriptionTopicResourceTriggerQueryCriteriaComponent(); // cc
          return this.queryCriteria;
        }

        public boolean hasQueryCriteria() { 
          return this.queryCriteria != null && !this.queryCriteria.isEmpty();
        }

        /**
         * @param value {@link #queryCriteria} (The FHIR query based rules that the server should use to determine when to trigger a notification for this subscription topic.)
         */
        public SubscriptionTopicResourceTriggerComponent setQueryCriteria(SubscriptionTopicResourceTriggerQueryCriteriaComponent value) { 
          this.queryCriteria = value;
          return this;
        }

        /**
         * @return {@link #fhirPathCriteria} (The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.). This is the underlying object with id, value and extensions. The accessor "getFhirPathCriteria" gives direct access to the value
         */
        public StringType getFhirPathCriteriaElement() { 
          if (this.fhirPathCriteria == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerComponent.fhirPathCriteria");
            else if (Configuration.doAutoCreate())
              this.fhirPathCriteria = new StringType(); // bb
          return this.fhirPathCriteria;
        }

        public boolean hasFhirPathCriteriaElement() { 
          return this.fhirPathCriteria != null && !this.fhirPathCriteria.isEmpty();
        }

        public boolean hasFhirPathCriteria() { 
          return this.fhirPathCriteria != null && !this.fhirPathCriteria.isEmpty();
        }

        /**
         * @param value {@link #fhirPathCriteria} (The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.). This is the underlying object with id, value and extensions. The accessor "getFhirPathCriteria" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerComponent setFhirPathCriteriaElement(StringType value) { 
          this.fhirPathCriteria = value;
          return this;
        }

        /**
         * @return The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        public String getFhirPathCriteria() { 
          return this.fhirPathCriteria == null ? null : this.fhirPathCriteria.getValue();
        }

        /**
         * @param value The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        public SubscriptionTopicResourceTriggerComponent setFhirPathCriteria(String value) { 
          if (Utilities.noString(value))
            this.fhirPathCriteria = null;
          else {
            if (this.fhirPathCriteria == null)
              this.fhirPathCriteria = new StringType();
            this.fhirPathCriteria.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "The human readable description of this resource trigger for the SubscriptionTopic -  for example, \"An Encounter enters the 'in-progress' state\".", 0, 1, description));
          children.add(new Property("resource", "uri", "URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, \"Patient\" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href=\"elementdefinition-definitions.html#ElementDefinition.type.code\">ElementDefinition.type.code</a>.", 0, 1, resource));
          children.add(new Property("supportedInteraction", "code", "The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).", 0, java.lang.Integer.MAX_VALUE, supportedInteraction));
          children.add(new Property("queryCriteria", "", "The FHIR query based rules that the server should use to determine when to trigger a notification for this subscription topic.", 0, 1, queryCriteria));
          children.add(new Property("fhirPathCriteria", "string", "The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, fhirPathCriteria));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "The human readable description of this resource trigger for the SubscriptionTopic -  for example, \"An Encounter enters the 'in-progress' state\".", 0, 1, description);
          case -341064690: /*resource*/  return new Property("resource", "uri", "URL of the Resource that is the type used in this resource trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, \"Patient\" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href=\"elementdefinition-definitions.html#ElementDefinition.type.code\">ElementDefinition.type.code</a>.", 0, 1, resource);
          case 1838450820: /*supportedInteraction*/  return new Property("supportedInteraction", "code", "The FHIR RESTful interaction which can be used to trigger a notification for the SubscriptionTopic. Multiple values are considered OR joined (e.g., CREATE or UPDATE).", 0, java.lang.Integer.MAX_VALUE, supportedInteraction);
          case -545123257: /*queryCriteria*/  return new Property("queryCriteria", "", "The FHIR query based rules that the server should use to determine when to trigger a notification for this subscription topic.", 0, 1, queryCriteria);
          case 1929785263: /*fhirPathCriteria*/  return new Property("fhirPathCriteria", "string", "The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, fhirPathCriteria);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // UriType
        case 1838450820: /*supportedInteraction*/ return this.supportedInteraction == null ? new Base[0] : this.supportedInteraction.toArray(new Base[this.supportedInteraction.size()]); // Enumeration<InteractionTrigger>
        case -545123257: /*queryCriteria*/ return this.queryCriteria == null ? new Base[0] : new Base[] {this.queryCriteria}; // SubscriptionTopicResourceTriggerQueryCriteriaComponent
        case 1929785263: /*fhirPathCriteria*/ return this.fhirPathCriteria == null ? new Base[0] : new Base[] {this.fhirPathCriteria}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -341064690: // resource
          this.resource = TypeConvertor.castToUri(value); // UriType
          return value;
        case 1838450820: // supportedInteraction
          value = new InteractionTriggerEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getSupportedInteraction().add((Enumeration) value); // Enumeration<InteractionTrigger>
          return value;
        case -545123257: // queryCriteria
          this.queryCriteria = (SubscriptionTopicResourceTriggerQueryCriteriaComponent) value; // SubscriptionTopicResourceTriggerQueryCriteriaComponent
          return value;
        case 1929785263: // fhirPathCriteria
          this.fhirPathCriteria = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("supportedInteraction")) {
          value = new InteractionTriggerEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getSupportedInteraction().add((Enumeration) value);
        } else if (name.equals("queryCriteria")) {
          this.queryCriteria = (SubscriptionTopicResourceTriggerQueryCriteriaComponent) value; // SubscriptionTopicResourceTriggerQueryCriteriaComponent
        } else if (name.equals("fhirPathCriteria")) {
          this.fhirPathCriteria = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -341064690:  return getResourceElement();
        case 1838450820:  return addSupportedInteractionElement();
        case -545123257:  return getQueryCriteria();
        case 1929785263:  return getFhirPathCriteriaElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -341064690: /*resource*/ return new String[] {"uri"};
        case 1838450820: /*supportedInteraction*/ return new String[] {"code"};
        case -545123257: /*queryCriteria*/ return new String[] {};
        case 1929785263: /*fhirPathCriteria*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.description");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.resource");
        }
        else if (name.equals("supportedInteraction")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.supportedInteraction");
        }
        else if (name.equals("queryCriteria")) {
          this.queryCriteria = new SubscriptionTopicResourceTriggerQueryCriteriaComponent();
          return this.queryCriteria;
        }
        else if (name.equals("fhirPathCriteria")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.fhirPathCriteria");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionTopicResourceTriggerComponent copy() {
        SubscriptionTopicResourceTriggerComponent dst = new SubscriptionTopicResourceTriggerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionTopicResourceTriggerComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.resource = resource == null ? null : resource.copy();
        if (supportedInteraction != null) {
          dst.supportedInteraction = new ArrayList<Enumeration<InteractionTrigger>>();
          for (Enumeration<InteractionTrigger> i : supportedInteraction)
            dst.supportedInteraction.add(i.copy());
        };
        dst.queryCriteria = queryCriteria == null ? null : queryCriteria.copy();
        dst.fhirPathCriteria = fhirPathCriteria == null ? null : fhirPathCriteria.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicResourceTriggerComponent))
          return false;
        SubscriptionTopicResourceTriggerComponent o = (SubscriptionTopicResourceTriggerComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(resource, o.resource, true)
           && compareDeep(supportedInteraction, o.supportedInteraction, true) && compareDeep(queryCriteria, o.queryCriteria, true)
           && compareDeep(fhirPathCriteria, o.fhirPathCriteria, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicResourceTriggerComponent))
          return false;
        SubscriptionTopicResourceTriggerComponent o = (SubscriptionTopicResourceTriggerComponent) other_;
        return compareValues(description, o.description, true) && compareValues(resource, o.resource, true)
           && compareValues(supportedInteraction, o.supportedInteraction, true) && compareValues(fhirPathCriteria, o.fhirPathCriteria, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, resource, supportedInteraction
          , queryCriteria, fhirPathCriteria);
      }

  public String fhirType() {
    return "SubscriptionTopic.resourceTrigger";

  }

  }

    @Block()
    public static class SubscriptionTopicResourceTriggerQueryCriteriaComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The FHIR query based rules are applied to the previous resource state (e.g., state before an update).
         */
        @Child(name = "previous", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule applied to previous resource state", formalDefinition="The FHIR query based rules are applied to the previous resource state (e.g., state before an update)." )
        protected StringType previous;

        /**
         * For "create" interactions, should the "previous" criteria count as an automatic pass or an automatic fail.
         */
        @Child(name = "resultForCreate", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="test-passes | test-fails", formalDefinition="For \"create\" interactions, should the \"previous\" criteria count as an automatic pass or an automatic fail." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscriptiontopic-cr-behavior")
        protected Enumeration<CriteriaNotExistsBehavior> resultForCreate;

        /**
         * The FHIR query based rules are applied to the current resource state (e.g., state after an update).
         */
        @Child(name = "current", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule applied to current resource state", formalDefinition="The FHIR query based rules are applied to the current resource state (e.g., state after an update)." )
        protected StringType current;

        /**
         * For "delete" interactions, should the "current" criteria count as an automatic pass or an automatic fail.
         */
        @Child(name = "resultForDelete", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="test-passes | test-fails", formalDefinition="For \"delete\" interactions, should the \"current\" criteria count as an automatic pass or an automatic fail." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscriptiontopic-cr-behavior")
        protected Enumeration<CriteriaNotExistsBehavior> resultForDelete;

        /**
         * If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        @Child(name = "requireBoth", type = {BooleanType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Both must be true flag", formalDefinition="If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true." )
        protected BooleanType requireBoth;

        private static final long serialVersionUID = -291746067L;

    /**
     * Constructor
     */
      public SubscriptionTopicResourceTriggerQueryCriteriaComponent() {
        super();
      }

        /**
         * @return {@link #previous} (The FHIR query based rules are applied to the previous resource state (e.g., state before an update).). This is the underlying object with id, value and extensions. The accessor "getPrevious" gives direct access to the value
         */
        public StringType getPreviousElement() { 
          if (this.previous == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerQueryCriteriaComponent.previous");
            else if (Configuration.doAutoCreate())
              this.previous = new StringType(); // bb
          return this.previous;
        }

        public boolean hasPreviousElement() { 
          return this.previous != null && !this.previous.isEmpty();
        }

        public boolean hasPrevious() { 
          return this.previous != null && !this.previous.isEmpty();
        }

        /**
         * @param value {@link #previous} (The FHIR query based rules are applied to the previous resource state (e.g., state before an update).). This is the underlying object with id, value and extensions. The accessor "getPrevious" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setPreviousElement(StringType value) { 
          this.previous = value;
          return this;
        }

        /**
         * @return The FHIR query based rules are applied to the previous resource state (e.g., state before an update).
         */
        public String getPrevious() { 
          return this.previous == null ? null : this.previous.getValue();
        }

        /**
         * @param value The FHIR query based rules are applied to the previous resource state (e.g., state before an update).
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setPrevious(String value) { 
          if (Utilities.noString(value))
            this.previous = null;
          else {
            if (this.previous == null)
              this.previous = new StringType();
            this.previous.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resultForCreate} (For "create" interactions, should the "previous" criteria count as an automatic pass or an automatic fail.). This is the underlying object with id, value and extensions. The accessor "getResultForCreate" gives direct access to the value
         */
        public Enumeration<CriteriaNotExistsBehavior> getResultForCreateElement() { 
          if (this.resultForCreate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerQueryCriteriaComponent.resultForCreate");
            else if (Configuration.doAutoCreate())
              this.resultForCreate = new Enumeration<CriteriaNotExistsBehavior>(new CriteriaNotExistsBehaviorEnumFactory()); // bb
          return this.resultForCreate;
        }

        public boolean hasResultForCreateElement() { 
          return this.resultForCreate != null && !this.resultForCreate.isEmpty();
        }

        public boolean hasResultForCreate() { 
          return this.resultForCreate != null && !this.resultForCreate.isEmpty();
        }

        /**
         * @param value {@link #resultForCreate} (For "create" interactions, should the "previous" criteria count as an automatic pass or an automatic fail.). This is the underlying object with id, value and extensions. The accessor "getResultForCreate" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setResultForCreateElement(Enumeration<CriteriaNotExistsBehavior> value) { 
          this.resultForCreate = value;
          return this;
        }

        /**
         * @return For "create" interactions, should the "previous" criteria count as an automatic pass or an automatic fail.
         */
        public CriteriaNotExistsBehavior getResultForCreate() { 
          return this.resultForCreate == null ? null : this.resultForCreate.getValue();
        }

        /**
         * @param value For "create" interactions, should the "previous" criteria count as an automatic pass or an automatic fail.
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setResultForCreate(CriteriaNotExistsBehavior value) { 
          if (value == null)
            this.resultForCreate = null;
          else {
            if (this.resultForCreate == null)
              this.resultForCreate = new Enumeration<CriteriaNotExistsBehavior>(new CriteriaNotExistsBehaviorEnumFactory());
            this.resultForCreate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #current} (The FHIR query based rules are applied to the current resource state (e.g., state after an update).). This is the underlying object with id, value and extensions. The accessor "getCurrent" gives direct access to the value
         */
        public StringType getCurrentElement() { 
          if (this.current == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerQueryCriteriaComponent.current");
            else if (Configuration.doAutoCreate())
              this.current = new StringType(); // bb
          return this.current;
        }

        public boolean hasCurrentElement() { 
          return this.current != null && !this.current.isEmpty();
        }

        public boolean hasCurrent() { 
          return this.current != null && !this.current.isEmpty();
        }

        /**
         * @param value {@link #current} (The FHIR query based rules are applied to the current resource state (e.g., state after an update).). This is the underlying object with id, value and extensions. The accessor "getCurrent" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setCurrentElement(StringType value) { 
          this.current = value;
          return this;
        }

        /**
         * @return The FHIR query based rules are applied to the current resource state (e.g., state after an update).
         */
        public String getCurrent() { 
          return this.current == null ? null : this.current.getValue();
        }

        /**
         * @param value The FHIR query based rules are applied to the current resource state (e.g., state after an update).
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setCurrent(String value) { 
          if (Utilities.noString(value))
            this.current = null;
          else {
            if (this.current == null)
              this.current = new StringType();
            this.current.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resultForDelete} (For "delete" interactions, should the "current" criteria count as an automatic pass or an automatic fail.). This is the underlying object with id, value and extensions. The accessor "getResultForDelete" gives direct access to the value
         */
        public Enumeration<CriteriaNotExistsBehavior> getResultForDeleteElement() { 
          if (this.resultForDelete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerQueryCriteriaComponent.resultForDelete");
            else if (Configuration.doAutoCreate())
              this.resultForDelete = new Enumeration<CriteriaNotExistsBehavior>(new CriteriaNotExistsBehaviorEnumFactory()); // bb
          return this.resultForDelete;
        }

        public boolean hasResultForDeleteElement() { 
          return this.resultForDelete != null && !this.resultForDelete.isEmpty();
        }

        public boolean hasResultForDelete() { 
          return this.resultForDelete != null && !this.resultForDelete.isEmpty();
        }

        /**
         * @param value {@link #resultForDelete} (For "delete" interactions, should the "current" criteria count as an automatic pass or an automatic fail.). This is the underlying object with id, value and extensions. The accessor "getResultForDelete" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setResultForDeleteElement(Enumeration<CriteriaNotExistsBehavior> value) { 
          this.resultForDelete = value;
          return this;
        }

        /**
         * @return For "delete" interactions, should the "current" criteria count as an automatic pass or an automatic fail.
         */
        public CriteriaNotExistsBehavior getResultForDelete() { 
          return this.resultForDelete == null ? null : this.resultForDelete.getValue();
        }

        /**
         * @param value For "delete" interactions, should the "current" criteria count as an automatic pass or an automatic fail.
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setResultForDelete(CriteriaNotExistsBehavior value) { 
          if (value == null)
            this.resultForDelete = null;
          else {
            if (this.resultForDelete == null)
              this.resultForDelete = new Enumeration<CriteriaNotExistsBehavior>(new CriteriaNotExistsBehaviorEnumFactory());
            this.resultForDelete.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #requireBoth} (If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.). This is the underlying object with id, value and extensions. The accessor "getRequireBoth" gives direct access to the value
         */
        public BooleanType getRequireBothElement() { 
          if (this.requireBoth == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicResourceTriggerQueryCriteriaComponent.requireBoth");
            else if (Configuration.doAutoCreate())
              this.requireBoth = new BooleanType(); // bb
          return this.requireBoth;
        }

        public boolean hasRequireBothElement() { 
          return this.requireBoth != null && !this.requireBoth.isEmpty();
        }

        public boolean hasRequireBoth() { 
          return this.requireBoth != null && !this.requireBoth.isEmpty();
        }

        /**
         * @param value {@link #requireBoth} (If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.). This is the underlying object with id, value and extensions. The accessor "getRequireBoth" gives direct access to the value
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setRequireBothElement(BooleanType value) { 
          this.requireBoth = value;
          return this;
        }

        /**
         * @return If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        public boolean getRequireBoth() { 
          return this.requireBoth == null || this.requireBoth.isEmpty() ? false : this.requireBoth.getValue();
        }

        /**
         * @param value If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        public SubscriptionTopicResourceTriggerQueryCriteriaComponent setRequireBoth(boolean value) { 
            if (this.requireBoth == null)
              this.requireBoth = new BooleanType();
            this.requireBoth.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("previous", "string", "The FHIR query based rules are applied to the previous resource state (e.g., state before an update).", 0, 1, previous));
          children.add(new Property("resultForCreate", "code", "For \"create\" interactions, should the \"previous\" criteria count as an automatic pass or an automatic fail.", 0, 1, resultForCreate));
          children.add(new Property("current", "string", "The FHIR query based rules are applied to the current resource state (e.g., state after an update).", 0, 1, current));
          children.add(new Property("resultForDelete", "code", "For \"delete\" interactions, should the \"current\" criteria count as an automatic pass or an automatic fail.", 0, 1, resultForDelete));
          children.add(new Property("requireBoth", "boolean", "If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.", 0, 1, requireBoth));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1273775369: /*previous*/  return new Property("previous", "string", "The FHIR query based rules are applied to the previous resource state (e.g., state before an update).", 0, 1, previous);
          case -407976056: /*resultForCreate*/  return new Property("resultForCreate", "code", "For \"create\" interactions, should the \"previous\" criteria count as an automatic pass or an automatic fail.", 0, 1, resultForCreate);
          case 1126940025: /*current*/  return new Property("current", "string", "The FHIR query based rules are applied to the current resource state (e.g., state after an update).", 0, 1, current);
          case -391140297: /*resultForDelete*/  return new Property("resultForDelete", "code", "For \"delete\" interactions, should the \"current\" criteria count as an automatic pass or an automatic fail.", 0, 1, resultForDelete);
          case 362116742: /*requireBoth*/  return new Property("requireBoth", "boolean", "If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.", 0, 1, requireBoth);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1273775369: /*previous*/ return this.previous == null ? new Base[0] : new Base[] {this.previous}; // StringType
        case -407976056: /*resultForCreate*/ return this.resultForCreate == null ? new Base[0] : new Base[] {this.resultForCreate}; // Enumeration<CriteriaNotExistsBehavior>
        case 1126940025: /*current*/ return this.current == null ? new Base[0] : new Base[] {this.current}; // StringType
        case -391140297: /*resultForDelete*/ return this.resultForDelete == null ? new Base[0] : new Base[] {this.resultForDelete}; // Enumeration<CriteriaNotExistsBehavior>
        case 362116742: /*requireBoth*/ return this.requireBoth == null ? new Base[0] : new Base[] {this.requireBoth}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1273775369: // previous
          this.previous = TypeConvertor.castToString(value); // StringType
          return value;
        case -407976056: // resultForCreate
          value = new CriteriaNotExistsBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resultForCreate = (Enumeration) value; // Enumeration<CriteriaNotExistsBehavior>
          return value;
        case 1126940025: // current
          this.current = TypeConvertor.castToString(value); // StringType
          return value;
        case -391140297: // resultForDelete
          value = new CriteriaNotExistsBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resultForDelete = (Enumeration) value; // Enumeration<CriteriaNotExistsBehavior>
          return value;
        case 362116742: // requireBoth
          this.requireBoth = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("previous")) {
          this.previous = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resultForCreate")) {
          value = new CriteriaNotExistsBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resultForCreate = (Enumeration) value; // Enumeration<CriteriaNotExistsBehavior>
        } else if (name.equals("current")) {
          this.current = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resultForDelete")) {
          value = new CriteriaNotExistsBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resultForDelete = (Enumeration) value; // Enumeration<CriteriaNotExistsBehavior>
        } else if (name.equals("requireBoth")) {
          this.requireBoth = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1273775369:  return getPreviousElement();
        case -407976056:  return getResultForCreateElement();
        case 1126940025:  return getCurrentElement();
        case -391140297:  return getResultForDeleteElement();
        case 362116742:  return getRequireBothElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1273775369: /*previous*/ return new String[] {"string"};
        case -407976056: /*resultForCreate*/ return new String[] {"code"};
        case 1126940025: /*current*/ return new String[] {"string"};
        case -391140297: /*resultForDelete*/ return new String[] {"code"};
        case 362116742: /*requireBoth*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("previous")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.queryCriteria.previous");
        }
        else if (name.equals("resultForCreate")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.queryCriteria.resultForCreate");
        }
        else if (name.equals("current")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.queryCriteria.current");
        }
        else if (name.equals("resultForDelete")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.queryCriteria.resultForDelete");
        }
        else if (name.equals("requireBoth")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.resourceTrigger.queryCriteria.requireBoth");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionTopicResourceTriggerQueryCriteriaComponent copy() {
        SubscriptionTopicResourceTriggerQueryCriteriaComponent dst = new SubscriptionTopicResourceTriggerQueryCriteriaComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionTopicResourceTriggerQueryCriteriaComponent dst) {
        super.copyValues(dst);
        dst.previous = previous == null ? null : previous.copy();
        dst.resultForCreate = resultForCreate == null ? null : resultForCreate.copy();
        dst.current = current == null ? null : current.copy();
        dst.resultForDelete = resultForDelete == null ? null : resultForDelete.copy();
        dst.requireBoth = requireBoth == null ? null : requireBoth.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicResourceTriggerQueryCriteriaComponent))
          return false;
        SubscriptionTopicResourceTriggerQueryCriteriaComponent o = (SubscriptionTopicResourceTriggerQueryCriteriaComponent) other_;
        return compareDeep(previous, o.previous, true) && compareDeep(resultForCreate, o.resultForCreate, true)
           && compareDeep(current, o.current, true) && compareDeep(resultForDelete, o.resultForDelete, true)
           && compareDeep(requireBoth, o.requireBoth, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicResourceTriggerQueryCriteriaComponent))
          return false;
        SubscriptionTopicResourceTriggerQueryCriteriaComponent o = (SubscriptionTopicResourceTriggerQueryCriteriaComponent) other_;
        return compareValues(previous, o.previous, true) && compareValues(resultForCreate, o.resultForCreate, true)
           && compareValues(current, o.current, true) && compareValues(resultForDelete, o.resultForDelete, true)
           && compareValues(requireBoth, o.requireBoth, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(previous, resultForCreate
          , current, resultForDelete, requireBoth);
      }

  public String fhirType() {
    return "SubscriptionTopic.resourceTrigger.queryCriteria";

  }

  }

    @Block()
    public static class SubscriptionTopicEventTriggerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, "Patient Admission, as defined in HL7v2 via message ADT^A01". Multiple values are considered OR joined (e.g., matching any single event listed).
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text representation of the event trigger", formalDefinition="The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, \"Patient Admission, as defined in HL7v2 via message ADT^A01\". Multiple values are considered OR joined (e.g., matching any single event listed)." )
        protected MarkdownType description;

        /**
         * A well-defined event which can be used to trigger notifications from the SubscriptionTopic.
         */
        @Child(name = "event", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Event which can trigger a notification from the SubscriptionTopic", formalDefinition="A well-defined event which can be used to trigger notifications from the SubscriptionTopic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0003")
        protected CodeableConcept event;

        /**
         * URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.
         */
        @Child(name = "resource", type = {UriType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Data Type or Resource (reference to definition) for this trigger definition", formalDefinition="URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, \"Patient\" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href=\"elementdefinition-definitions.html#ElementDefinition.type.code\">ElementDefinition.type.code</a>." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fhir-types")
        protected UriType resource;

        private static final long serialVersionUID = 1818872110L;

    /**
     * Constructor
     */
      public SubscriptionTopicEventTriggerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionTopicEventTriggerComponent(CodeableConcept event, String resource) {
        super();
        this.setEvent(event);
        this.setResource(resource);
      }

        /**
         * @return {@link #description} (The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, "Patient Admission, as defined in HL7v2 via message ADT^A01". Multiple values are considered OR joined (e.g., matching any single event listed).). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicEventTriggerComponent.description");
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
         * @param value {@link #description} (The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, "Patient Admission, as defined in HL7v2 via message ADT^A01". Multiple values are considered OR joined (e.g., matching any single event listed).). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SubscriptionTopicEventTriggerComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, "Patient Admission, as defined in HL7v2 via message ADT^A01". Multiple values are considered OR joined (e.g., matching any single event listed).
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, "Patient Admission, as defined in HL7v2 via message ADT^A01". Multiple values are considered OR joined (e.g., matching any single event listed).
         */
        public SubscriptionTopicEventTriggerComponent setDescription(String value) { 
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
         * @return {@link #event} (A well-defined event which can be used to trigger notifications from the SubscriptionTopic.)
         */
        public CodeableConcept getEvent() { 
          if (this.event == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicEventTriggerComponent.event");
            else if (Configuration.doAutoCreate())
              this.event = new CodeableConcept(); // cc
          return this.event;
        }

        public boolean hasEvent() { 
          return this.event != null && !this.event.isEmpty();
        }

        /**
         * @param value {@link #event} (A well-defined event which can be used to trigger notifications from the SubscriptionTopic.)
         */
        public SubscriptionTopicEventTriggerComponent setEvent(CodeableConcept value) { 
          this.event = value;
          return this;
        }

        /**
         * @return {@link #resource} (URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public UriType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicEventTriggerComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new UriType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SubscriptionTopicEventTriggerComponent setResourceElement(UriType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, "Patient" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href="elementdefinition-definitions.html#ElementDefinition.type.code">ElementDefinition.type.code</a>.
         */
        public SubscriptionTopicEventTriggerComponent setResource(String value) { 
            if (this.resource == null)
              this.resource = new UriType();
            this.resource.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, \"Patient Admission, as defined in HL7v2 via message ADT^A01\". Multiple values are considered OR joined (e.g., matching any single event listed).", 0, 1, description));
          children.add(new Property("event", "CodeableConcept", "A well-defined event which can be used to trigger notifications from the SubscriptionTopic.", 0, 1, event));
          children.add(new Property("resource", "uri", "URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, \"Patient\" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href=\"elementdefinition-definitions.html#ElementDefinition.type.code\">ElementDefinition.type.code</a>.", 0, 1, resource));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "The human readable description of an event to trigger a notification for the SubscriptionTopic - for example, \"Patient Admission, as defined in HL7v2 via message ADT^A01\". Multiple values are considered OR joined (e.g., matching any single event listed).", 0, 1, description);
          case 96891546: /*event*/  return new Property("event", "CodeableConcept", "A well-defined event which can be used to trigger notifications from the SubscriptionTopic.", 0, 1, event);
          case -341064690: /*resource*/  return new Property("resource", "uri", "URL of the Resource that is the focus type used in this event trigger.  Relative URLs are relative to the StructureDefinition root of the implemented FHIR version (e.g., http://hl7.org/fhir/StructureDefinition). For example, \"Patient\" maps to http://hl7.org/fhir/StructureDefinition/Patient.  For more information, see <a href=\"elementdefinition-definitions.html#ElementDefinition.type.code\">ElementDefinition.type.code</a>.", 0, 1, resource);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 96891546: /*event*/ return this.event == null ? new Base[0] : new Base[] {this.event}; // CodeableConcept
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 96891546: // event
          this.event = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -341064690: // resource
          this.resource = TypeConvertor.castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("event")) {
          this.event = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 96891546:  return getEvent();
        case -341064690:  return getResourceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 96891546: /*event*/ return new String[] {"CodeableConcept"};
        case -341064690: /*resource*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.eventTrigger.description");
        }
        else if (name.equals("event")) {
          this.event = new CodeableConcept();
          return this.event;
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.eventTrigger.resource");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionTopicEventTriggerComponent copy() {
        SubscriptionTopicEventTriggerComponent dst = new SubscriptionTopicEventTriggerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionTopicEventTriggerComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.event = event == null ? null : event.copy();
        dst.resource = resource == null ? null : resource.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicEventTriggerComponent))
          return false;
        SubscriptionTopicEventTriggerComponent o = (SubscriptionTopicEventTriggerComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(event, o.event, true) && compareDeep(resource, o.resource, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicEventTriggerComponent))
          return false;
        SubscriptionTopicEventTriggerComponent o = (SubscriptionTopicEventTriggerComponent) other_;
        return compareValues(description, o.description, true) && compareValues(resource, o.resource, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, event, resource
          );
      }

  public String fhirType() {
    return "SubscriptionTopic.eventTrigger";

  }

  }

    @Block()
    public static class SubscriptionTopicCanFilterByComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of how this filtering parameter is intended to be used.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Description of this filter parameter", formalDefinition="Description of how this filtering parameter is intended to be used." )
        protected MarkdownType description;

        /**
         * URL of the Resource that is the type used in this filter. This is the "focus" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.
         */
        @Child(name = "resource", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="URL of the triggering Resource that this filter applies to", formalDefinition="URL of the Resource that is the type used in this filter. This is the \"focus\" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fhir-types")
        protected UriType resource;

        /**
         * Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or topic-defined parameter (like "hub.event") which is a label for the filter.
         */
        @Child(name = "filterParameter", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Human-readable and computation-friendly name for a filter parameter usable by subscriptions on this topic, via Subscription.filterBy.filterParameter", formalDefinition="Either the canonical URL to a search parameter (like \"http://hl7.org/fhir/SearchParameter/encounter-patient\") or topic-defined parameter (like \"hub.event\") which is a label for the filter." )
        protected StringType filterParameter;

        /**
         * Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or the officially-defined URI for a shared filter concept (like "http://example.org/concepts/shared-common-event").
         */
        @Child(name = "filterDefinition", type = {UriType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Canonical URL for a filterParameter definition", formalDefinition="Either the canonical URL to a search parameter (like \"http://hl7.org/fhir/SearchParameter/encounter-patient\") or the officially-defined URI for a shared filter concept (like \"http://example.org/concepts/shared-common-event\")." )
        protected UriType filterDefinition;

        /**
         * Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.
         */
        @Child(name = "modifier", type = {CodeType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="= | eq | ne | gt | lt | ge | le | sa | eb | ap | above | below | in | not-in | of-type", formalDefinition="Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-search-modifier")
        protected List<Enumeration<SubscriptionSearchModifier>> modifier;

        private static final long serialVersionUID = 1579878218L;

    /**
     * Constructor
     */
      public SubscriptionTopicCanFilterByComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionTopicCanFilterByComponent(String filterParameter) {
        super();
        this.setFilterParameter(filterParameter);
      }

        /**
         * @return {@link #description} (Description of how this filtering parameter is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicCanFilterByComponent.description");
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
         * @param value {@link #description} (Description of how this filtering parameter is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SubscriptionTopicCanFilterByComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of how this filtering parameter is intended to be used.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of how this filtering parameter is intended to be used.
         */
        public SubscriptionTopicCanFilterByComponent setDescription(String value) { 
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
         * @return {@link #resource} (URL of the Resource that is the type used in this filter. This is the "focus" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public UriType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicCanFilterByComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new UriType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (URL of the Resource that is the type used in this filter. This is the "focus" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SubscriptionTopicCanFilterByComponent setResourceElement(UriType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return URL of the Resource that is the type used in this filter. This is the "focus" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value URL of the Resource that is the type used in this filter. This is the "focus" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.
         */
        public SubscriptionTopicCanFilterByComponent setResource(String value) { 
          if (Utilities.noString(value))
            this.resource = null;
          else {
            if (this.resource == null)
              this.resource = new UriType();
            this.resource.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #filterParameter} (Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or topic-defined parameter (like "hub.event") which is a label for the filter.). This is the underlying object with id, value and extensions. The accessor "getFilterParameter" gives direct access to the value
         */
        public StringType getFilterParameterElement() { 
          if (this.filterParameter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicCanFilterByComponent.filterParameter");
            else if (Configuration.doAutoCreate())
              this.filterParameter = new StringType(); // bb
          return this.filterParameter;
        }

        public boolean hasFilterParameterElement() { 
          return this.filterParameter != null && !this.filterParameter.isEmpty();
        }

        public boolean hasFilterParameter() { 
          return this.filterParameter != null && !this.filterParameter.isEmpty();
        }

        /**
         * @param value {@link #filterParameter} (Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or topic-defined parameter (like "hub.event") which is a label for the filter.). This is the underlying object with id, value and extensions. The accessor "getFilterParameter" gives direct access to the value
         */
        public SubscriptionTopicCanFilterByComponent setFilterParameterElement(StringType value) { 
          this.filterParameter = value;
          return this;
        }

        /**
         * @return Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or topic-defined parameter (like "hub.event") which is a label for the filter.
         */
        public String getFilterParameter() { 
          return this.filterParameter == null ? null : this.filterParameter.getValue();
        }

        /**
         * @param value Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or topic-defined parameter (like "hub.event") which is a label for the filter.
         */
        public SubscriptionTopicCanFilterByComponent setFilterParameter(String value) { 
            if (this.filterParameter == null)
              this.filterParameter = new StringType();
            this.filterParameter.setValue(value);
          return this;
        }

        /**
         * @return {@link #filterDefinition} (Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or the officially-defined URI for a shared filter concept (like "http://example.org/concepts/shared-common-event").). This is the underlying object with id, value and extensions. The accessor "getFilterDefinition" gives direct access to the value
         */
        public UriType getFilterDefinitionElement() { 
          if (this.filterDefinition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicCanFilterByComponent.filterDefinition");
            else if (Configuration.doAutoCreate())
              this.filterDefinition = new UriType(); // bb
          return this.filterDefinition;
        }

        public boolean hasFilterDefinitionElement() { 
          return this.filterDefinition != null && !this.filterDefinition.isEmpty();
        }

        public boolean hasFilterDefinition() { 
          return this.filterDefinition != null && !this.filterDefinition.isEmpty();
        }

        /**
         * @param value {@link #filterDefinition} (Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or the officially-defined URI for a shared filter concept (like "http://example.org/concepts/shared-common-event").). This is the underlying object with id, value and extensions. The accessor "getFilterDefinition" gives direct access to the value
         */
        public SubscriptionTopicCanFilterByComponent setFilterDefinitionElement(UriType value) { 
          this.filterDefinition = value;
          return this;
        }

        /**
         * @return Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or the officially-defined URI for a shared filter concept (like "http://example.org/concepts/shared-common-event").
         */
        public String getFilterDefinition() { 
          return this.filterDefinition == null ? null : this.filterDefinition.getValue();
        }

        /**
         * @param value Either the canonical URL to a search parameter (like "http://hl7.org/fhir/SearchParameter/encounter-patient") or the officially-defined URI for a shared filter concept (like "http://example.org/concepts/shared-common-event").
         */
        public SubscriptionTopicCanFilterByComponent setFilterDefinition(String value) { 
          if (Utilities.noString(value))
            this.filterDefinition = null;
          else {
            if (this.filterDefinition == null)
              this.filterDefinition = new UriType();
            this.filterDefinition.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #modifier} (Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.)
         */
        public List<Enumeration<SubscriptionSearchModifier>> getModifier() { 
          if (this.modifier == null)
            this.modifier = new ArrayList<Enumeration<SubscriptionSearchModifier>>();
          return this.modifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubscriptionTopicCanFilterByComponent setModifier(List<Enumeration<SubscriptionSearchModifier>> theModifier) { 
          this.modifier = theModifier;
          return this;
        }

        public boolean hasModifier() { 
          if (this.modifier == null)
            return false;
          for (Enumeration<SubscriptionSearchModifier> item : this.modifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #modifier} (Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.)
         */
        public Enumeration<SubscriptionSearchModifier> addModifierElement() {//2 
          Enumeration<SubscriptionSearchModifier> t = new Enumeration<SubscriptionSearchModifier>(new SubscriptionSearchModifierEnumFactory());
          if (this.modifier == null)
            this.modifier = new ArrayList<Enumeration<SubscriptionSearchModifier>>();
          this.modifier.add(t);
          return t;
        }

        /**
         * @param value {@link #modifier} (Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.)
         */
        public SubscriptionTopicCanFilterByComponent addModifier(SubscriptionSearchModifier value) { //1
          Enumeration<SubscriptionSearchModifier> t = new Enumeration<SubscriptionSearchModifier>(new SubscriptionSearchModifierEnumFactory());
          t.setValue(value);
          if (this.modifier == null)
            this.modifier = new ArrayList<Enumeration<SubscriptionSearchModifier>>();
          this.modifier.add(t);
          return this;
        }

        /**
         * @param value {@link #modifier} (Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.)
         */
        public boolean hasModifier(SubscriptionSearchModifier value) { 
          if (this.modifier == null)
            return false;
          for (Enumeration<SubscriptionSearchModifier> v : this.modifier)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "Description of how this filtering parameter is intended to be used.", 0, 1, description));
          children.add(new Property("resource", "uri", "URL of the Resource that is the type used in this filter. This is the \"focus\" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.", 0, 1, resource));
          children.add(new Property("filterParameter", "string", "Either the canonical URL to a search parameter (like \"http://hl7.org/fhir/SearchParameter/encounter-patient\") or topic-defined parameter (like \"hub.event\") which is a label for the filter.", 0, 1, filterParameter));
          children.add(new Property("filterDefinition", "uri", "Either the canonical URL to a search parameter (like \"http://hl7.org/fhir/SearchParameter/encounter-patient\") or the officially-defined URI for a shared filter concept (like \"http://example.org/concepts/shared-common-event\").", 0, 1, filterDefinition));
          children.add(new Property("modifier", "code", "Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.", 0, java.lang.Integer.MAX_VALUE, modifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Description of how this filtering parameter is intended to be used.", 0, 1, description);
          case -341064690: /*resource*/  return new Property("resource", "uri", "URL of the Resource that is the type used in this filter. This is the \"focus\" of the topic (or one of them if there are more than one). It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.", 0, 1, resource);
          case 618257: /*filterParameter*/  return new Property("filterParameter", "string", "Either the canonical URL to a search parameter (like \"http://hl7.org/fhir/SearchParameter/encounter-patient\") or topic-defined parameter (like \"hub.event\") which is a label for the filter.", 0, 1, filterParameter);
          case -1453988117: /*filterDefinition*/  return new Property("filterDefinition", "uri", "Either the canonical URL to a search parameter (like \"http://hl7.org/fhir/SearchParameter/encounter-patient\") or the officially-defined URI for a shared filter concept (like \"http://example.org/concepts/shared-common-event\").", 0, 1, filterDefinition);
          case -615513385: /*modifier*/  return new Property("modifier", "code", "Allowable operators to apply when determining matches (Search Modifiers).  If the filterParameter is a SearchParameter, this list of modifiers SHALL be a strict subset of the modifiers defined on that SearchParameter.", 0, java.lang.Integer.MAX_VALUE, modifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // UriType
        case 618257: /*filterParameter*/ return this.filterParameter == null ? new Base[0] : new Base[] {this.filterParameter}; // StringType
        case -1453988117: /*filterDefinition*/ return this.filterDefinition == null ? new Base[0] : new Base[] {this.filterDefinition}; // UriType
        case -615513385: /*modifier*/ return this.modifier == null ? new Base[0] : this.modifier.toArray(new Base[this.modifier.size()]); // Enumeration<SubscriptionSearchModifier>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -341064690: // resource
          this.resource = TypeConvertor.castToUri(value); // UriType
          return value;
        case 618257: // filterParameter
          this.filterParameter = TypeConvertor.castToString(value); // StringType
          return value;
        case -1453988117: // filterDefinition
          this.filterDefinition = TypeConvertor.castToUri(value); // UriType
          return value;
        case -615513385: // modifier
          value = new SubscriptionSearchModifierEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getModifier().add((Enumeration) value); // Enumeration<SubscriptionSearchModifier>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("filterParameter")) {
          this.filterParameter = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("filterDefinition")) {
          this.filterDefinition = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("modifier")) {
          value = new SubscriptionSearchModifierEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getModifier().add((Enumeration) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -341064690:  return getResourceElement();
        case 618257:  return getFilterParameterElement();
        case -1453988117:  return getFilterDefinitionElement();
        case -615513385:  return addModifierElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -341064690: /*resource*/ return new String[] {"uri"};
        case 618257: /*filterParameter*/ return new String[] {"string"};
        case -1453988117: /*filterDefinition*/ return new String[] {"uri"};
        case -615513385: /*modifier*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.canFilterBy.description");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.canFilterBy.resource");
        }
        else if (name.equals("filterParameter")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.canFilterBy.filterParameter");
        }
        else if (name.equals("filterDefinition")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.canFilterBy.filterDefinition");
        }
        else if (name.equals("modifier")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.canFilterBy.modifier");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionTopicCanFilterByComponent copy() {
        SubscriptionTopicCanFilterByComponent dst = new SubscriptionTopicCanFilterByComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionTopicCanFilterByComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.filterParameter = filterParameter == null ? null : filterParameter.copy();
        dst.filterDefinition = filterDefinition == null ? null : filterDefinition.copy();
        if (modifier != null) {
          dst.modifier = new ArrayList<Enumeration<SubscriptionSearchModifier>>();
          for (Enumeration<SubscriptionSearchModifier> i : modifier)
            dst.modifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicCanFilterByComponent))
          return false;
        SubscriptionTopicCanFilterByComponent o = (SubscriptionTopicCanFilterByComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(resource, o.resource, true)
           && compareDeep(filterParameter, o.filterParameter, true) && compareDeep(filterDefinition, o.filterDefinition, true)
           && compareDeep(modifier, o.modifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicCanFilterByComponent))
          return false;
        SubscriptionTopicCanFilterByComponent o = (SubscriptionTopicCanFilterByComponent) other_;
        return compareValues(description, o.description, true) && compareValues(resource, o.resource, true)
           && compareValues(filterParameter, o.filterParameter, true) && compareValues(filterDefinition, o.filterDefinition, true)
           && compareValues(modifier, o.modifier, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, resource, filterParameter
          , filterDefinition, modifier);
      }

  public String fhirType() {
    return "SubscriptionTopic.canFilterBy";

  }

  }

    @Block()
    public static class SubscriptionTopicNotificationShapeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * URL of the Resource that is the type used in this shape. This is the "focus" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.
         */
        @Child(name = "resource", type = {UriType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="URL of the Resource that is the focus (main) resource in a notification shape", formalDefinition="URL of the Resource that is the type used in this shape. This is the \"focus\" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fhir-types")
        protected UriType resource;

        /**
         * Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.
         */
        @Child(name = "include", type = {StringType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Include directives, rooted in the resource for this shape", formalDefinition="Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them." )
        protected List<StringType> include;

        /**
         * Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.
         */
        @Child(name = "revInclude", type = {StringType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Reverse include directives, rooted in the resource for this shape", formalDefinition="Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them." )
        protected List<StringType> revInclude;

        private static final long serialVersionUID = -1718592091L;

    /**
     * Constructor
     */
      public SubscriptionTopicNotificationShapeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionTopicNotificationShapeComponent(String resource) {
        super();
        this.setResource(resource);
      }

        /**
         * @return {@link #resource} (URL of the Resource that is the type used in this shape. This is the "focus" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public UriType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionTopicNotificationShapeComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new UriType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (URL of the Resource that is the type used in this shape. This is the "focus" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SubscriptionTopicNotificationShapeComponent setResourceElement(UriType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return URL of the Resource that is the type used in this shape. This is the "focus" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value URL of the Resource that is the type used in this shape. This is the "focus" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.
         */
        public SubscriptionTopicNotificationShapeComponent setResource(String value) { 
            if (this.resource == null)
              this.resource = new UriType();
            this.resource.setValue(value);
          return this;
        }

        /**
         * @return {@link #include} (Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public List<StringType> getInclude() { 
          if (this.include == null)
            this.include = new ArrayList<StringType>();
          return this.include;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubscriptionTopicNotificationShapeComponent setInclude(List<StringType> theInclude) { 
          this.include = theInclude;
          return this;
        }

        public boolean hasInclude() { 
          if (this.include == null)
            return false;
          for (StringType item : this.include)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #include} (Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public StringType addIncludeElement() {//2 
          StringType t = new StringType();
          if (this.include == null)
            this.include = new ArrayList<StringType>();
          this.include.add(t);
          return t;
        }

        /**
         * @param value {@link #include} (Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public SubscriptionTopicNotificationShapeComponent addInclude(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.include == null)
            this.include = new ArrayList<StringType>();
          this.include.add(t);
          return this;
        }

        /**
         * @param value {@link #include} (Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public boolean hasInclude(String value) { 
          if (this.include == null)
            return false;
          for (StringType v : this.include)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #revInclude} (Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public List<StringType> getRevInclude() { 
          if (this.revInclude == null)
            this.revInclude = new ArrayList<StringType>();
          return this.revInclude;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubscriptionTopicNotificationShapeComponent setRevInclude(List<StringType> theRevInclude) { 
          this.revInclude = theRevInclude;
          return this;
        }

        public boolean hasRevInclude() { 
          if (this.revInclude == null)
            return false;
          for (StringType item : this.revInclude)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #revInclude} (Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public StringType addRevIncludeElement() {//2 
          StringType t = new StringType();
          if (this.revInclude == null)
            this.revInclude = new ArrayList<StringType>();
          this.revInclude.add(t);
          return t;
        }

        /**
         * @param value {@link #revInclude} (Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public SubscriptionTopicNotificationShapeComponent addRevInclude(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.revInclude == null)
            this.revInclude = new ArrayList<StringType>();
          this.revInclude.add(t);
          return this;
        }

        /**
         * @param value {@link #revInclude} (Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.)
         */
        public boolean hasRevInclude(String value) { 
          if (this.revInclude == null)
            return false;
          for (StringType v : this.revInclude)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("resource", "uri", "URL of the Resource that is the type used in this shape. This is the \"focus\" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.", 0, 1, resource));
          children.add(new Property("include", "string", "Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.", 0, java.lang.Integer.MAX_VALUE, include));
          children.add(new Property("revInclude", "string", "Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.", 0, java.lang.Integer.MAX_VALUE, revInclude));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -341064690: /*resource*/  return new Property("resource", "uri", "URL of the Resource that is the type used in this shape. This is the \"focus\" of the topic (or one of them if there are more than one) and the root resource for this shape definition. It will be the same, a generality, or a specificity of SubscriptionTopic.resourceTrigger.resource or SubscriptionTopic.eventTrigger.resource when they are present.", 0, 1, resource);
          case 1942574248: /*include*/  return new Property("include", "string", "Search-style _include directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.", 0, java.lang.Integer.MAX_VALUE, include);
          case 8439429: /*revInclude*/  return new Property("revInclude", "string", "Search-style _revinclude directives, rooted in the resource for this shape. Servers SHOULD include resources listed here, if they exist and the user is authorized to receive them.  Clients SHOULD be prepared to receive these additional resources, but SHALL function properly without them.", 0, java.lang.Integer.MAX_VALUE, revInclude);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // UriType
        case 1942574248: /*include*/ return this.include == null ? new Base[0] : this.include.toArray(new Base[this.include.size()]); // StringType
        case 8439429: /*revInclude*/ return this.revInclude == null ? new Base[0] : this.revInclude.toArray(new Base[this.revInclude.size()]); // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -341064690: // resource
          this.resource = TypeConvertor.castToUri(value); // UriType
          return value;
        case 1942574248: // include
          this.getInclude().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 8439429: // revInclude
          this.getRevInclude().add(TypeConvertor.castToString(value)); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("resource")) {
          this.resource = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("include")) {
          this.getInclude().add(TypeConvertor.castToString(value));
        } else if (name.equals("revInclude")) {
          this.getRevInclude().add(TypeConvertor.castToString(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -341064690:  return getResourceElement();
        case 1942574248:  return addIncludeElement();
        case 8439429:  return addRevIncludeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -341064690: /*resource*/ return new String[] {"uri"};
        case 1942574248: /*include*/ return new String[] {"string"};
        case 8439429: /*revInclude*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.notificationShape.resource");
        }
        else if (name.equals("include")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.notificationShape.include");
        }
        else if (name.equals("revInclude")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.notificationShape.revInclude");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionTopicNotificationShapeComponent copy() {
        SubscriptionTopicNotificationShapeComponent dst = new SubscriptionTopicNotificationShapeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionTopicNotificationShapeComponent dst) {
        super.copyValues(dst);
        dst.resource = resource == null ? null : resource.copy();
        if (include != null) {
          dst.include = new ArrayList<StringType>();
          for (StringType i : include)
            dst.include.add(i.copy());
        };
        if (revInclude != null) {
          dst.revInclude = new ArrayList<StringType>();
          for (StringType i : revInclude)
            dst.revInclude.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicNotificationShapeComponent))
          return false;
        SubscriptionTopicNotificationShapeComponent o = (SubscriptionTopicNotificationShapeComponent) other_;
        return compareDeep(resource, o.resource, true) && compareDeep(include, o.include, true) && compareDeep(revInclude, o.revInclude, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopicNotificationShapeComponent))
          return false;
        SubscriptionTopicNotificationShapeComponent o = (SubscriptionTopicNotificationShapeComponent) other_;
        return compareValues(resource, o.resource, true) && compareValues(include, o.include, true) && compareValues(revInclude, o.revInclude, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(resource, include, revInclude
          );
      }

  public String fhirType() {
    return "SubscriptionTopic.notificationShape";

  }

  }

    /**
     * An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this subscription topic definition, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers." )
    protected UriType url;

    /**
     * Business identifiers assigned to this subscription topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for this subscription topic", formalDefinition="Business identifiers assigned to this subscription topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the subscription topic", formalDefinition="The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable." )
    protected StringType version;

    /**
     * A short, descriptive, user-friendly title for the SubscriptionTopic, for example, "admission".
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this subscription topic (Human friendly)", formalDefinition="A short, descriptive, user-friendly title for the SubscriptionTopic, for example, \"admission\"." )
    protected StringType title;

    /**
     * The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.
     */
    @Child(name = "derivedFrom", type = {CanonicalType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on FHIR protocol or definition", formalDefinition="The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic." )
    protected List<CanonicalType> derivedFrom;

    /**
     * The current state of the SubscriptionTopic.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The current state of the SubscriptionTopic." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If for testing purposes, not real usage", formalDefinition="A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date status first applied", formalDefinition="For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal." )
    protected DateTimeType date;

    /**
     * Helps establish the "authority/credibility" of the SubscriptionTopic.  May also allow for contact.
     */
    @Child(name = "publisher", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The name of the individual or organization that published the SubscriptionTopic", formalDefinition="Helps establish the \"authority/credibility\" of the SubscriptionTopic.  May also allow for contact." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the Topic from the consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the SubscriptionTopic", formalDefinition="A free text natural language description of the Topic from the consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Content intends to support these contexts", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions." )
    protected List<UsageContext> useContext;

    /**
     * A jurisdiction in which the Topic is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction of the SubscriptionTopic (if applicable)", formalDefinition="A jurisdiction in which the Topic is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explains why this Topic is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this SubscriptionTopic is defined", formalDefinition="Explains why this Topic is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When SubscriptionTopic is/was approved by publisher", formalDefinition="The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date the Subscription Topic was last reviewed by the publisher", formalDefinition="The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the SubscriptionTopic content was or is planned to be effective.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The effective date range for the SubscriptionTopic", formalDefinition="The period during which the SubscriptionTopic content was or is planned to be effective." )
    protected Period effectivePeriod;

    /**
     * A definition of a resource-based event that triggers a notification based on the SubscriptionTopic. The criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression. Multiple triggers are considered OR joined (e.g., a resource update matching ANY of the definitions will trigger a notification).
     */
    @Child(name = "resourceTrigger", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Definition of a resource-based trigger for the subscription topic", formalDefinition="A definition of a resource-based event that triggers a notification based on the SubscriptionTopic. The criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression. Multiple triggers are considered OR joined (e.g., a resource update matching ANY of the definitions will trigger a notification)." )
    protected List<SubscriptionTopicResourceTriggerComponent> resourceTrigger;

    /**
     * Event definition which can be used to trigger the SubscriptionTopic.
     */
    @Child(name = "eventTrigger", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Event definitions the SubscriptionTopic", formalDefinition="Event definition which can be used to trigger the SubscriptionTopic." )
    protected List<SubscriptionTopicEventTriggerComponent> eventTrigger;

    /**
     * List of properties by which Subscriptions on the SubscriptionTopic can be filtered. May be defined Search Parameters (e.g., Encounter.patient) or parameters defined within this SubscriptionTopic context (e.g., hub.event).
     */
    @Child(name = "canFilterBy", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Properties by which a Subscription can filter notifications from the SubscriptionTopic", formalDefinition="List of properties by which Subscriptions on the SubscriptionTopic can be filtered. May be defined Search Parameters (e.g., Encounter.patient) or parameters defined within this SubscriptionTopic context (e.g., hub.event)." )
    protected List<SubscriptionTopicCanFilterByComponent> canFilterBy;

    /**
     * List of properties to describe the shape (e.g., resources) included in notifications from this Subscription Topic.
     */
    @Child(name = "notificationShape", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Properties for describing the shape of notifications generated by this topic", formalDefinition="List of properties to describe the shape (e.g., resources) included in notifications from this Subscription Topic." )
    protected List<SubscriptionTopicNotificationShapeComponent> notificationShape;

    private static final long serialVersionUID = -117076104L;

  /**
   * Constructor
   */
    public SubscriptionTopic() {
      super();
    }

  /**
   * Constructor
   */
    public SubscriptionTopic(String url, PublicationStatus status) {
      super();
      this.setUrl(url);
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public SubscriptionTopic setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.
     */
    public SubscriptionTopic setUrl(String value) { 
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      return this;
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this subscription topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setIdentifier(List<Identifier> theIdentifier) { 
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

    public SubscriptionTopic addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public SubscriptionTopic setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public SubscriptionTopic setVersion(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the SubscriptionTopic, for example, "admission".). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the SubscriptionTopic, for example, "admission".). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public SubscriptionTopic setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the SubscriptionTopic, for example, "admission".
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the SubscriptionTopic, for example, "admission".
     */
    public SubscriptionTopic setTitle(String value) { 
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
     * @return {@link #derivedFrom} (The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.)
     */
    public List<CanonicalType> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<CanonicalType>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setDerivedFrom(List<CanonicalType> theDerivedFrom) { 
      this.derivedFrom = theDerivedFrom;
      return this;
    }

    public boolean hasDerivedFrom() { 
      if (this.derivedFrom == null)
        return false;
      for (CanonicalType item : this.derivedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFrom} (The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.)
     */
    public CanonicalType addDerivedFromElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<CanonicalType>();
      this.derivedFrom.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFrom} (The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.)
     */
    public SubscriptionTopic addDerivedFrom(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<CanonicalType>();
      this.derivedFrom.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFrom} (The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.)
     */
    public boolean hasDerivedFrom(String value) { 
      if (this.derivedFrom == null)
        return false;
      for (CanonicalType v : this.derivedFrom)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #status} (The current state of the SubscriptionTopic.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.status");
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
     * @param value {@link #status} (The current state of the SubscriptionTopic.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public SubscriptionTopic setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the SubscriptionTopic.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the SubscriptionTopic.
     */
    public SubscriptionTopic setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.experimental");
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
     * @param value {@link #experimental} (A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public SubscriptionTopic setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public SubscriptionTopic setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.date");
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
     * @param value {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public SubscriptionTopic setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public SubscriptionTopic setDate(Date value) { 
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
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the SubscriptionTopic.  May also allow for contact.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.publisher");
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
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the SubscriptionTopic.  May also allow for contact.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public SubscriptionTopic setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return Helps establish the "authority/credibility" of the SubscriptionTopic.  May also allow for contact.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value Helps establish the "authority/credibility" of the SubscriptionTopic.  May also allow for contact.
     */
    public SubscriptionTopic setPublisher(String value) { 
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
    public SubscriptionTopic setContact(List<ContactDetail> theContact) { 
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

    public SubscriptionTopic addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the Topic from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.description");
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
     * @param value {@link #description} (A free text natural language description of the Topic from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public SubscriptionTopic setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the Topic from the consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the Topic from the consumer's perspective.
     */
    public SubscriptionTopic setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setUseContext(List<UsageContext> theUseContext) { 
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

    public SubscriptionTopic addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A jurisdiction in which the Topic is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public SubscriptionTopic addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explains why this Topic is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.purpose");
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
     * @param value {@link #purpose} (Explains why this Topic is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public SubscriptionTopic setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explains why this Topic is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explains why this Topic is needed and why it has been designed as it has.
     */
    public SubscriptionTopic setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public SubscriptionTopic setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.
     */
    public SubscriptionTopic setCopyright(String value) { 
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
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.copyrightLabel");
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
    public SubscriptionTopic setCopyrightLabelElement(StringType value) { 
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
    public SubscriptionTopic setCopyrightLabel(String value) { 
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
     * @return {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.approvalDate");
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
    public SubscriptionTopic setApprovalDateElement(DateType value) { 
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
    public SubscriptionTopic setApprovalDate(Date value) { 
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
          throw new Error("Attempt to auto-create SubscriptionTopic.lastReviewDate");
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
    public SubscriptionTopic setLastReviewDateElement(DateType value) { 
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
    public SubscriptionTopic setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the SubscriptionTopic content was or is planned to be effective.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionTopic.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the SubscriptionTopic content was or is planned to be effective.)
     */
    public SubscriptionTopic setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #resourceTrigger} (A definition of a resource-based event that triggers a notification based on the SubscriptionTopic. The criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression. Multiple triggers are considered OR joined (e.g., a resource update matching ANY of the definitions will trigger a notification).)
     */
    public List<SubscriptionTopicResourceTriggerComponent> getResourceTrigger() { 
      if (this.resourceTrigger == null)
        this.resourceTrigger = new ArrayList<SubscriptionTopicResourceTriggerComponent>();
      return this.resourceTrigger;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setResourceTrigger(List<SubscriptionTopicResourceTriggerComponent> theResourceTrigger) { 
      this.resourceTrigger = theResourceTrigger;
      return this;
    }

    public boolean hasResourceTrigger() { 
      if (this.resourceTrigger == null)
        return false;
      for (SubscriptionTopicResourceTriggerComponent item : this.resourceTrigger)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubscriptionTopicResourceTriggerComponent addResourceTrigger() { //3
      SubscriptionTopicResourceTriggerComponent t = new SubscriptionTopicResourceTriggerComponent();
      if (this.resourceTrigger == null)
        this.resourceTrigger = new ArrayList<SubscriptionTopicResourceTriggerComponent>();
      this.resourceTrigger.add(t);
      return t;
    }

    public SubscriptionTopic addResourceTrigger(SubscriptionTopicResourceTriggerComponent t) { //3
      if (t == null)
        return this;
      if (this.resourceTrigger == null)
        this.resourceTrigger = new ArrayList<SubscriptionTopicResourceTriggerComponent>();
      this.resourceTrigger.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #resourceTrigger}, creating it if it does not already exist {3}
     */
    public SubscriptionTopicResourceTriggerComponent getResourceTriggerFirstRep() { 
      if (getResourceTrigger().isEmpty()) {
        addResourceTrigger();
      }
      return getResourceTrigger().get(0);
    }

    /**
     * @return {@link #eventTrigger} (Event definition which can be used to trigger the SubscriptionTopic.)
     */
    public List<SubscriptionTopicEventTriggerComponent> getEventTrigger() { 
      if (this.eventTrigger == null)
        this.eventTrigger = new ArrayList<SubscriptionTopicEventTriggerComponent>();
      return this.eventTrigger;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setEventTrigger(List<SubscriptionTopicEventTriggerComponent> theEventTrigger) { 
      this.eventTrigger = theEventTrigger;
      return this;
    }

    public boolean hasEventTrigger() { 
      if (this.eventTrigger == null)
        return false;
      for (SubscriptionTopicEventTriggerComponent item : this.eventTrigger)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubscriptionTopicEventTriggerComponent addEventTrigger() { //3
      SubscriptionTopicEventTriggerComponent t = new SubscriptionTopicEventTriggerComponent();
      if (this.eventTrigger == null)
        this.eventTrigger = new ArrayList<SubscriptionTopicEventTriggerComponent>();
      this.eventTrigger.add(t);
      return t;
    }

    public SubscriptionTopic addEventTrigger(SubscriptionTopicEventTriggerComponent t) { //3
      if (t == null)
        return this;
      if (this.eventTrigger == null)
        this.eventTrigger = new ArrayList<SubscriptionTopicEventTriggerComponent>();
      this.eventTrigger.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #eventTrigger}, creating it if it does not already exist {3}
     */
    public SubscriptionTopicEventTriggerComponent getEventTriggerFirstRep() { 
      if (getEventTrigger().isEmpty()) {
        addEventTrigger();
      }
      return getEventTrigger().get(0);
    }

    /**
     * @return {@link #canFilterBy} (List of properties by which Subscriptions on the SubscriptionTopic can be filtered. May be defined Search Parameters (e.g., Encounter.patient) or parameters defined within this SubscriptionTopic context (e.g., hub.event).)
     */
    public List<SubscriptionTopicCanFilterByComponent> getCanFilterBy() { 
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<SubscriptionTopicCanFilterByComponent>();
      return this.canFilterBy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setCanFilterBy(List<SubscriptionTopicCanFilterByComponent> theCanFilterBy) { 
      this.canFilterBy = theCanFilterBy;
      return this;
    }

    public boolean hasCanFilterBy() { 
      if (this.canFilterBy == null)
        return false;
      for (SubscriptionTopicCanFilterByComponent item : this.canFilterBy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubscriptionTopicCanFilterByComponent addCanFilterBy() { //3
      SubscriptionTopicCanFilterByComponent t = new SubscriptionTopicCanFilterByComponent();
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<SubscriptionTopicCanFilterByComponent>();
      this.canFilterBy.add(t);
      return t;
    }

    public SubscriptionTopic addCanFilterBy(SubscriptionTopicCanFilterByComponent t) { //3
      if (t == null)
        return this;
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<SubscriptionTopicCanFilterByComponent>();
      this.canFilterBy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #canFilterBy}, creating it if it does not already exist {3}
     */
    public SubscriptionTopicCanFilterByComponent getCanFilterByFirstRep() { 
      if (getCanFilterBy().isEmpty()) {
        addCanFilterBy();
      }
      return getCanFilterBy().get(0);
    }

    /**
     * @return {@link #notificationShape} (List of properties to describe the shape (e.g., resources) included in notifications from this Subscription Topic.)
     */
    public List<SubscriptionTopicNotificationShapeComponent> getNotificationShape() { 
      if (this.notificationShape == null)
        this.notificationShape = new ArrayList<SubscriptionTopicNotificationShapeComponent>();
      return this.notificationShape;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionTopic setNotificationShape(List<SubscriptionTopicNotificationShapeComponent> theNotificationShape) { 
      this.notificationShape = theNotificationShape;
      return this;
    }

    public boolean hasNotificationShape() { 
      if (this.notificationShape == null)
        return false;
      for (SubscriptionTopicNotificationShapeComponent item : this.notificationShape)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubscriptionTopicNotificationShapeComponent addNotificationShape() { //3
      SubscriptionTopicNotificationShapeComponent t = new SubscriptionTopicNotificationShapeComponent();
      if (this.notificationShape == null)
        this.notificationShape = new ArrayList<SubscriptionTopicNotificationShapeComponent>();
      this.notificationShape.add(t);
      return t;
    }

    public SubscriptionTopic addNotificationShape(SubscriptionTopicNotificationShapeComponent t) { //3
      if (t == null)
        return this;
      if (this.notificationShape == null)
        this.notificationShape = new ArrayList<SubscriptionTopicNotificationShapeComponent>();
      this.notificationShape.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #notificationShape}, creating it if it does not already exist {3}
     */
    public SubscriptionTopicNotificationShapeComponent getNotificationShapeFirstRep() { 
      if (getNotificationShape().isEmpty()) {
        addNotificationShape();
      }
      return getNotificationShape().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getVersionAlgorithmMax() { 
      return 0;
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmStringType() { 
      return false;////K 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmCoding() { 
      return false;////K 
    }
    public boolean hasVersionAlgorithm() { 
      return false;
    }
    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public SubscriptionTopic setVersionAlgorithm(DataType value) { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"versionAlgorithm[x]\""); 
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getNameMax() { 
      return 0;
    }
    /**
     * @return {@link #name} (A natural language name identifying the subscription topic. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"name\"");
    }

    public boolean hasNameElement() { 
      return false;
    }
    public boolean hasName() {
      return false;
    }

    /**
     * @param value {@link #name} (A natural language name identifying the subscription topic. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public SubscriptionTopic setNameElement(StringType value) { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"name\""); 
    }
    public String getName() { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"name\""); 
    }
    /**
     * @param value A natural language name identifying the subscription topic. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public SubscriptionTopic setName(String value) { 
      throw new Error("The resource type \"SubscriptionTopic\" does not implement the property \"name\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this subscription topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the SubscriptionTopic, for example, \"admission\".", 0, 1, title));
        children.add(new Property("derivedFrom", "canonical(SubscriptionTopic)", "The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("status", "code", "The current state of the SubscriptionTopic.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date));
        children.add(new Property("publisher", "string", "Helps establish the \"authority/credibility\" of the SubscriptionTopic.  May also allow for contact.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the Topic from the consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the Topic is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explains why this Topic is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the SubscriptionTopic content was or is planned to be effective.", 0, 1, effectivePeriod));
        children.add(new Property("resourceTrigger", "", "A definition of a resource-based event that triggers a notification based on the SubscriptionTopic. The criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression. Multiple triggers are considered OR joined (e.g., a resource update matching ANY of the definitions will trigger a notification).", 0, java.lang.Integer.MAX_VALUE, resourceTrigger));
        children.add(new Property("eventTrigger", "", "Event definition which can be used to trigger the SubscriptionTopic.", 0, java.lang.Integer.MAX_VALUE, eventTrigger));
        children.add(new Property("canFilterBy", "", "List of properties by which Subscriptions on the SubscriptionTopic can be filtered. May be defined Search Parameters (e.g., Encounter.patient) or parameters defined within this SubscriptionTopic context (e.g., hub.event).", 0, java.lang.Integer.MAX_VALUE, canFilterBy));
        children.add(new Property("notificationShape", "", "List of properties to describe the shape (e.g., resources) included in notifications from this Subscription Topic.", 0, java.lang.Integer.MAX_VALUE, notificationShape));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this subscription topic when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this subscription topic is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the subscription topic is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this subscription topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the subscription topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the SubscriptionTopic, for example, \"admission\".", 0, 1, title);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "canonical(SubscriptionTopic)", "The canonical URL pointing to another FHIR-defined SubscriptionTopic that is adhered to in whole or in part by this SubscriptionTopic.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the SubscriptionTopic.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A flag to indicate that this TopSubscriptionTopicic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "Helps establish the \"authority/credibility\" of the SubscriptionTopic.  May also allow for contact.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the Topic from the consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the Topic is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explains why this Topic is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the SubscriptionTopic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SubscriptionTopic.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the SubscriptionTopic content was or is planned to be effective.", 0, 1, effectivePeriod);
        case -424927798: /*resourceTrigger*/  return new Property("resourceTrigger", "", "A definition of a resource-based event that triggers a notification based on the SubscriptionTopic. The criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression. Multiple triggers are considered OR joined (e.g., a resource update matching ANY of the definitions will trigger a notification).", 0, java.lang.Integer.MAX_VALUE, resourceTrigger);
        case -151635522: /*eventTrigger*/  return new Property("eventTrigger", "", "Event definition which can be used to trigger the SubscriptionTopic.", 0, java.lang.Integer.MAX_VALUE, eventTrigger);
        case -1299519009: /*canFilterBy*/  return new Property("canFilterBy", "", "List of properties by which Subscriptions on the SubscriptionTopic can be filtered. May be defined Search Parameters (e.g., Encounter.patient) or parameters defined within this SubscriptionTopic context (e.g., hub.event).", 0, java.lang.Integer.MAX_VALUE, canFilterBy);
        case -1583369866: /*notificationShape*/  return new Property("notificationShape", "", "List of properties to describe the shape (e.g., resources) included in notifications from this Subscription Topic.", 0, java.lang.Integer.MAX_VALUE, notificationShape);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // CanonicalType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -424927798: /*resourceTrigger*/ return this.resourceTrigger == null ? new Base[0] : this.resourceTrigger.toArray(new Base[this.resourceTrigger.size()]); // SubscriptionTopicResourceTriggerComponent
        case -151635522: /*eventTrigger*/ return this.eventTrigger == null ? new Base[0] : this.eventTrigger.toArray(new Base[this.eventTrigger.size()]); // SubscriptionTopicEventTriggerComponent
        case -1299519009: /*canFilterBy*/ return this.canFilterBy == null ? new Base[0] : this.canFilterBy.toArray(new Base[this.canFilterBy.size()]); // SubscriptionTopicCanFilterByComponent
        case -1583369866: /*notificationShape*/ return this.notificationShape == null ? new Base[0] : this.notificationShape.toArray(new Base[this.notificationShape.size()]); // SubscriptionTopicNotificationShapeComponent
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
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToCanonical(value)); // CanonicalType
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
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
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
        case -424927798: // resourceTrigger
          this.getResourceTrigger().add((SubscriptionTopicResourceTriggerComponent) value); // SubscriptionTopicResourceTriggerComponent
          return value;
        case -151635522: // eventTrigger
          this.getEventTrigger().add((SubscriptionTopicEventTriggerComponent) value); // SubscriptionTopicEventTriggerComponent
          return value;
        case -1299519009: // canFilterBy
          this.getCanFilterBy().add((SubscriptionTopicCanFilterByComponent) value); // SubscriptionTopicCanFilterByComponent
          return value;
        case -1583369866: // notificationShape
          this.getNotificationShape().add((SubscriptionTopicNotificationShapeComponent) value); // SubscriptionTopicNotificationShapeComponent
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
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToCanonical(value));
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
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
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
        } else if (name.equals("resourceTrigger")) {
          this.getResourceTrigger().add((SubscriptionTopicResourceTriggerComponent) value);
        } else if (name.equals("eventTrigger")) {
          this.getEventTrigger().add((SubscriptionTopicEventTriggerComponent) value);
        } else if (name.equals("canFilterBy")) {
          this.getCanFilterBy().add((SubscriptionTopicCanFilterByComponent) value);
        } else if (name.equals("notificationShape")) {
          this.getNotificationShape().add((SubscriptionTopicNotificationShapeComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case 110371416:  return getTitleElement();
        case 1077922663:  return addDerivedFromElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case -424927798:  return addResourceTrigger(); 
        case -151635522:  return addEventTrigger(); 
        case -1299519009:  return addCanFilterBy(); 
        case -1583369866:  return addNotificationShape(); 
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
        case 1077922663: /*derivedFrom*/ return new String[] {"canonical"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -424927798: /*resourceTrigger*/ return new String[] {};
        case -151635522: /*eventTrigger*/ return new String[] {};
        case -1299519009: /*canFilterBy*/ return new String[] {};
        case -1583369866: /*notificationShape*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.version");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.title");
        }
        else if (name.equals("derivedFrom")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.derivedFrom");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.copyrightLabel");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionTopic.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("resourceTrigger")) {
          return addResourceTrigger();
        }
        else if (name.equals("eventTrigger")) {
          return addEventTrigger();
        }
        else if (name.equals("canFilterBy")) {
          return addCanFilterBy();
        }
        else if (name.equals("notificationShape")) {
          return addNotificationShape();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SubscriptionTopic";

  }

      public SubscriptionTopic copy() {
        SubscriptionTopic dst = new SubscriptionTopic();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionTopic dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.title = title == null ? null : title.copy();
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<CanonicalType>();
          for (CanonicalType i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
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
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (resourceTrigger != null) {
          dst.resourceTrigger = new ArrayList<SubscriptionTopicResourceTriggerComponent>();
          for (SubscriptionTopicResourceTriggerComponent i : resourceTrigger)
            dst.resourceTrigger.add(i.copy());
        };
        if (eventTrigger != null) {
          dst.eventTrigger = new ArrayList<SubscriptionTopicEventTriggerComponent>();
          for (SubscriptionTopicEventTriggerComponent i : eventTrigger)
            dst.eventTrigger.add(i.copy());
        };
        if (canFilterBy != null) {
          dst.canFilterBy = new ArrayList<SubscriptionTopicCanFilterByComponent>();
          for (SubscriptionTopicCanFilterByComponent i : canFilterBy)
            dst.canFilterBy.add(i.copy());
        };
        if (notificationShape != null) {
          dst.notificationShape = new ArrayList<SubscriptionTopicNotificationShapeComponent>();
          for (SubscriptionTopicNotificationShapeComponent i : notificationShape)
            dst.notificationShape.add(i.copy());
        };
      }

      protected SubscriptionTopic typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopic))
          return false;
        SubscriptionTopic o = (SubscriptionTopic) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(title, o.title, true) && compareDeep(derivedFrom, o.derivedFrom, true) && compareDeep(status, o.status, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(copyrightLabel, o.copyrightLabel, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
           && compareDeep(resourceTrigger, o.resourceTrigger, true) && compareDeep(eventTrigger, o.eventTrigger, true)
           && compareDeep(canFilterBy, o.canFilterBy, true) && compareDeep(notificationShape, o.notificationShape, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionTopic))
          return false;
        SubscriptionTopic o = (SubscriptionTopic) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(title, o.title, true)
           && compareValues(derivedFrom, o.derivedFrom, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , title, derivedFrom, status, experimental, date, publisher, contact, description
          , useContext, jurisdiction, purpose, copyright, copyrightLabel, approvalDate, lastReviewDate
          , effectivePeriod, resourceTrigger, eventTrigger, canFilterBy, notificationShape);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SubscriptionTopic;
   }

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
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
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
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
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
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
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
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
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
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url</b><br>
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
   * Search parameter: <b>derived-or-self</b>
   * <p>
   * Description: <b>A server defined search that matches either the url or derivedFrom</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>SubscriptionTopic.url | SubscriptionTopic.derivedFrom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="derived-or-self", path="SubscriptionTopic.url | SubscriptionTopic.derivedFrom", description="A server defined search that matches either the url or derivedFrom", type="uri" )
  public static final String SP_DERIVED_OR_SELF = "derived-or-self";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-or-self</b>
   * <p>
   * Description: <b>A server defined search that matches either the url or derivedFrom</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>SubscriptionTopic.url | SubscriptionTopic.derivedFrom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam DERIVED_OR_SELF = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_DERIVED_OR_SELF);

 /**
   * Search parameter: <b>resource</b>
   * <p>
   * Description: <b>Allowed Data type or Resource (reference to definition) for this definition, searches resourceTrigger, eventTrigger, and notificationShape for matches.</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>SubscriptionTopic.resourceTrigger.resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource", path="SubscriptionTopic.resourceTrigger.resource", description="Allowed Data type or Resource (reference to definition) for this definition, searches resourceTrigger, eventTrigger, and notificationShape for matches.", type="uri" )
  public static final String SP_RESOURCE = "resource";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource</b>
   * <p>
   * Description: <b>Allowed Data type or Resource (reference to definition) for this definition, searches resourceTrigger, eventTrigger, and notificationShape for matches.</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>SubscriptionTopic.resourceTrigger.resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam RESOURCE = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_RESOURCE);

 /**
   * Search parameter: <b>trigger-description</b>
   * <p>
   * Description: <b>Text representation of the trigger</b><br>
   * Type: <b>string</b><br>
   * Path: <b>SubscriptionTopic.resourceTrigger.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="trigger-description", path="SubscriptionTopic.resourceTrigger.description", description="Text representation of the trigger", type="string" )
  public static final String SP_TRIGGER_DESCRIPTION = "trigger-description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>trigger-description</b>
   * <p>
   * Description: <b>Text representation of the trigger</b><br>
   * Type: <b>string</b><br>
   * Path: <b>SubscriptionTopic.resourceTrigger.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TRIGGER_DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TRIGGER_DESCRIPTION);


}
