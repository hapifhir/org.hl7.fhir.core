package org.hl7.fhir.r5.model;


/*
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0

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
@ResourceDef(name="Topic", profile="http://hl7.org/fhir/StructureDefinition/Topic")
public class Topic extends DomainResource {

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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CREATE: return "http://hl7.org/fhir/restful-interaction";
            case UPDATE: return "http://hl7.org/fhir/restful-interaction";
            case DELETE: return "http://hl7.org/fhir/restful-interaction";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CREATE: return "Create a new resource with a server assigned id.";
            case UPDATE: return "Update an existing resource by its id (or create it if it is new).";
            case DELETE: return "Delete a resource.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
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
        public Enumeration<InteractionTrigger> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InteractionTrigger>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("create".equals(codeString))
          return new Enumeration<InteractionTrigger>(this, InteractionTrigger.CREATE);
        if ("update".equals(codeString))
          return new Enumeration<InteractionTrigger>(this, InteractionTrigger.UPDATE);
        if ("delete".equals(codeString))
          return new Enumeration<InteractionTrigger>(this, InteractionTrigger.DELETE);
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

    public enum TopicFilterByMatchType {
        /**
         * Used to match a value according to FHIR Search rules (e.g., Patient/123, Encounter/2002).
         */
        EQUAL, 
        /**
         * The key value in the topic stream is an active members of the reference set identified by the concept provided as the filter value.
         */
        IN, 
        /**
         * The key value in the topic stream is NOT an active members of the reference set identified by the concept provided as the filter value.
         */
        NOTIN, 
        /**
         * The key value is subsumes the value in the filter value.
         */
        ABOVE, 
        /**
         * The key value is subsumed by the value in the filter value.
         */
        BELOW, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TopicFilterByMatchType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return EQUAL;
        if ("in".equals(codeString))
          return IN;
        if ("not-in".equals(codeString))
          return NOTIN;
        if ("above".equals(codeString))
          return ABOVE;
        if ("below".equals(codeString))
          return BELOW;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TopicFilterByMatchType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EQUAL: return "=";
            case IN: return "in";
            case NOTIN: return "not-in";
            case ABOVE: return "above";
            case BELOW: return "below";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EQUAL: return "http://hl7.org/fhir/topic-match-operator";
            case IN: return "http://hl7.org/fhir/topic-match-operator";
            case NOTIN: return "http://hl7.org/fhir/topic-match-operator";
            case ABOVE: return "http://hl7.org/fhir/topic-match-operator";
            case BELOW: return "http://hl7.org/fhir/topic-match-operator";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EQUAL: return "Used to match a value according to FHIR Search rules (e.g., Patient/123, Encounter/2002).";
            case IN: return "The key value in the topic stream is an active members of the reference set identified by the concept provided as the filter value.";
            case NOTIN: return "The key value in the topic stream is NOT an active members of the reference set identified by the concept provided as the filter value.";
            case ABOVE: return "The key value is subsumes the value in the filter value.";
            case BELOW: return "The key value is subsumed by the value in the filter value.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EQUAL: return "=";
            case IN: return "in";
            case NOTIN: return "not-in";
            case ABOVE: return "above";
            case BELOW: return "below";
            default: return "?";
          }
        }
    }

  public static class TopicFilterByMatchTypeEnumFactory implements EnumFactory<TopicFilterByMatchType> {
    public TopicFilterByMatchType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return TopicFilterByMatchType.EQUAL;
        if ("in".equals(codeString))
          return TopicFilterByMatchType.IN;
        if ("not-in".equals(codeString))
          return TopicFilterByMatchType.NOTIN;
        if ("above".equals(codeString))
          return TopicFilterByMatchType.ABOVE;
        if ("below".equals(codeString))
          return TopicFilterByMatchType.BELOW;
        throw new IllegalArgumentException("Unknown TopicFilterByMatchType code '"+codeString+"'");
        }
        public Enumeration<TopicFilterByMatchType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TopicFilterByMatchType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("=".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.EQUAL);
        if ("in".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.IN);
        if ("not-in".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.NOTIN);
        if ("above".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.ABOVE);
        if ("below".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.BELOW);
        throw new FHIRException("Unknown TopicFilterByMatchType code '"+codeString+"'");
        }
    public String toCode(TopicFilterByMatchType code) {
      if (code == TopicFilterByMatchType.EQUAL)
        return "=";
      if (code == TopicFilterByMatchType.IN)
        return "in";
      if (code == TopicFilterByMatchType.NOTIN)
        return "not-in";
      if (code == TopicFilterByMatchType.ABOVE)
        return "above";
      if (code == TopicFilterByMatchType.BELOW)
        return "below";
      return "?";
      }
    public String toSystem(TopicFilterByMatchType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class TopicResourceTriggerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text representation of the trigger", formalDefinition="The human readable description of what triggers inclusion into this topic -  for example, \"Beginning of a clinical encounter\"." )
        protected StringType description;

        /**
         * The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.
         */
        @Child(name = "resourceType", type = {CodeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Candidate types for this topic", formalDefinition="The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
        protected List<CodeType> resourceType;

        /**
         * The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "methodCriteria", type = {CodeType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="create | update | delete", formalDefinition="The REST interaction based rules that the server should use to determine when to trigger a notification for this topic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-trigger")
        protected List<Enumeration<InteractionTrigger>> methodCriteria;

        /**
         * The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "queryCriteria", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Query based trigger rule", formalDefinition="The FHIR query based rules that the server should use to determine when to trigger a notification for this topic." )
        protected TopicResourceTriggerQueryCriteriaComponent queryCriteria;

        /**
         * The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "fhirPathCriteria", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath based trigger rule", formalDefinition="The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic." )
        protected StringType fhirPathCriteria;

        private static final long serialVersionUID = 1020326735L;

    /**
     * Constructor
     */
      public TopicResourceTriggerComponent() {
        super();
      }

        /**
         * @return {@link #description} (The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerComponent.description");
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
         * @param value {@link #description} (The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TopicResourceTriggerComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".
         */
        public TopicResourceTriggerComponent setDescription(String value) { 
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
         * @return {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public List<CodeType> getResourceType() { 
          if (this.resourceType == null)
            this.resourceType = new ArrayList<CodeType>();
          return this.resourceType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TopicResourceTriggerComponent setResourceType(List<CodeType> theResourceType) { 
          this.resourceType = theResourceType;
          return this;
        }

        public boolean hasResourceType() { 
          if (this.resourceType == null)
            return false;
          for (CodeType item : this.resourceType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public CodeType addResourceTypeElement() {//2 
          CodeType t = new CodeType();
          if (this.resourceType == null)
            this.resourceType = new ArrayList<CodeType>();
          this.resourceType.add(t);
          return t;
        }

        /**
         * @param value {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public TopicResourceTriggerComponent addResourceType(String value) { //1
          CodeType t = new CodeType();
          t.setValue(value);
          if (this.resourceType == null)
            this.resourceType = new ArrayList<CodeType>();
          this.resourceType.add(t);
          return this;
        }

        /**
         * @param value {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public boolean hasResourceType(String value) { 
          if (this.resourceType == null)
            return false;
          for (CodeType v : this.resourceType)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public List<Enumeration<InteractionTrigger>> getMethodCriteria() { 
          if (this.methodCriteria == null)
            this.methodCriteria = new ArrayList<Enumeration<InteractionTrigger>>();
          return this.methodCriteria;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TopicResourceTriggerComponent setMethodCriteria(List<Enumeration<InteractionTrigger>> theMethodCriteria) { 
          this.methodCriteria = theMethodCriteria;
          return this;
        }

        public boolean hasMethodCriteria() { 
          if (this.methodCriteria == null)
            return false;
          for (Enumeration<InteractionTrigger> item : this.methodCriteria)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public Enumeration<InteractionTrigger> addMethodCriteriaElement() {//2 
          Enumeration<InteractionTrigger> t = new Enumeration<InteractionTrigger>(new InteractionTriggerEnumFactory());
          if (this.methodCriteria == null)
            this.methodCriteria = new ArrayList<Enumeration<InteractionTrigger>>();
          this.methodCriteria.add(t);
          return t;
        }

        /**
         * @param value {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public TopicResourceTriggerComponent addMethodCriteria(InteractionTrigger value) { //1
          Enumeration<InteractionTrigger> t = new Enumeration<InteractionTrigger>(new InteractionTriggerEnumFactory());
          t.setValue(value);
          if (this.methodCriteria == null)
            this.methodCriteria = new ArrayList<Enumeration<InteractionTrigger>>();
          this.methodCriteria.add(t);
          return this;
        }

        /**
         * @param value {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public boolean hasMethodCriteria(InteractionTrigger value) { 
          if (this.methodCriteria == null)
            return false;
          for (Enumeration<InteractionTrigger> v : this.methodCriteria)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #queryCriteria} (The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public TopicResourceTriggerQueryCriteriaComponent getQueryCriteria() { 
          if (this.queryCriteria == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerComponent.queryCriteria");
            else if (Configuration.doAutoCreate())
              this.queryCriteria = new TopicResourceTriggerQueryCriteriaComponent(); // cc
          return this.queryCriteria;
        }

        public boolean hasQueryCriteria() { 
          return this.queryCriteria != null && !this.queryCriteria.isEmpty();
        }

        /**
         * @param value {@link #queryCriteria} (The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public TopicResourceTriggerComponent setQueryCriteria(TopicResourceTriggerQueryCriteriaComponent value) { 
          this.queryCriteria = value;
          return this;
        }

        /**
         * @return {@link #fhirPathCriteria} (The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.). This is the underlying object with id, value and extensions. The accessor "getFhirPathCriteria" gives direct access to the value
         */
        public StringType getFhirPathCriteriaElement() { 
          if (this.fhirPathCriteria == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerComponent.fhirPathCriteria");
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
        public TopicResourceTriggerComponent setFhirPathCriteriaElement(StringType value) { 
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
        public TopicResourceTriggerComponent setFhirPathCriteria(String value) { 
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
          children.add(new Property("description", "string", "The human readable description of what triggers inclusion into this topic -  for example, \"Beginning of a clinical encounter\".", 0, 1, description));
          children.add(new Property("resourceType", "code", "The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.", 0, java.lang.Integer.MAX_VALUE, resourceType));
          children.add(new Property("methodCriteria", "code", "The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.", 0, java.lang.Integer.MAX_VALUE, methodCriteria));
          children.add(new Property("queryCriteria", "", "The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, queryCriteria));
          children.add(new Property("fhirPathCriteria", "string", "The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, fhirPathCriteria));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "The human readable description of what triggers inclusion into this topic -  for example, \"Beginning of a clinical encounter\".", 0, 1, description);
          case -384364440: /*resourceType*/  return new Property("resourceType", "code", "The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.", 0, java.lang.Integer.MAX_VALUE, resourceType);
          case -1924160672: /*methodCriteria*/  return new Property("methodCriteria", "code", "The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.", 0, java.lang.Integer.MAX_VALUE, methodCriteria);
          case -545123257: /*queryCriteria*/  return new Property("queryCriteria", "", "The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, queryCriteria);
          case 1929785263: /*fhirPathCriteria*/  return new Property("fhirPathCriteria", "string", "The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, fhirPathCriteria);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -384364440: /*resourceType*/ return this.resourceType == null ? new Base[0] : this.resourceType.toArray(new Base[this.resourceType.size()]); // CodeType
        case -1924160672: /*methodCriteria*/ return this.methodCriteria == null ? new Base[0] : this.methodCriteria.toArray(new Base[this.methodCriteria.size()]); // Enumeration<InteractionTrigger>
        case -545123257: /*queryCriteria*/ return this.queryCriteria == null ? new Base[0] : new Base[] {this.queryCriteria}; // TopicResourceTriggerQueryCriteriaComponent
        case 1929785263: /*fhirPathCriteria*/ return this.fhirPathCriteria == null ? new Base[0] : new Base[] {this.fhirPathCriteria}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -384364440: // resourceType
          this.getResourceType().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case -1924160672: // methodCriteria
          value = new InteractionTriggerEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getMethodCriteria().add((Enumeration) value); // Enumeration<InteractionTrigger>
          return value;
        case -545123257: // queryCriteria
          this.queryCriteria = (TopicResourceTriggerQueryCriteriaComponent) value; // TopicResourceTriggerQueryCriteriaComponent
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
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resourceType")) {
          this.getResourceType().add(TypeConvertor.castToCode(value));
        } else if (name.equals("methodCriteria")) {
          value = new InteractionTriggerEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getMethodCriteria().add((Enumeration) value);
        } else if (name.equals("queryCriteria")) {
          this.queryCriteria = (TopicResourceTriggerQueryCriteriaComponent) value; // TopicResourceTriggerQueryCriteriaComponent
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
        case -384364440:  return addResourceTypeElement();
        case -1924160672:  return addMethodCriteriaElement();
        case -545123257:  return getQueryCriteria();
        case 1929785263:  return getFhirPathCriteriaElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case -384364440: /*resourceType*/ return new String[] {"code"};
        case -1924160672: /*methodCriteria*/ return new String[] {"code"};
        case -545123257: /*queryCriteria*/ return new String[] {};
        case 1929785263: /*fhirPathCriteria*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.description");
        }
        else if (name.equals("resourceType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.resourceType");
        }
        else if (name.equals("methodCriteria")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.methodCriteria");
        }
        else if (name.equals("queryCriteria")) {
          this.queryCriteria = new TopicResourceTriggerQueryCriteriaComponent();
          return this.queryCriteria;
        }
        else if (name.equals("fhirPathCriteria")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.fhirPathCriteria");
        }
        else
          return super.addChild(name);
      }

      public TopicResourceTriggerComponent copy() {
        TopicResourceTriggerComponent dst = new TopicResourceTriggerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TopicResourceTriggerComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (resourceType != null) {
          dst.resourceType = new ArrayList<CodeType>();
          for (CodeType i : resourceType)
            dst.resourceType.add(i.copy());
        };
        if (methodCriteria != null) {
          dst.methodCriteria = new ArrayList<Enumeration<InteractionTrigger>>();
          for (Enumeration<InteractionTrigger> i : methodCriteria)
            dst.methodCriteria.add(i.copy());
        };
        dst.queryCriteria = queryCriteria == null ? null : queryCriteria.copy();
        dst.fhirPathCriteria = fhirPathCriteria == null ? null : fhirPathCriteria.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerComponent))
          return false;
        TopicResourceTriggerComponent o = (TopicResourceTriggerComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(resourceType, o.resourceType, true)
           && compareDeep(methodCriteria, o.methodCriteria, true) && compareDeep(queryCriteria, o.queryCriteria, true)
           && compareDeep(fhirPathCriteria, o.fhirPathCriteria, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerComponent))
          return false;
        TopicResourceTriggerComponent o = (TopicResourceTriggerComponent) other_;
        return compareValues(description, o.description, true) && compareValues(resourceType, o.resourceType, true)
           && compareValues(methodCriteria, o.methodCriteria, true) && compareValues(fhirPathCriteria, o.fhirPathCriteria, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, resourceType
          , methodCriteria, queryCriteria, fhirPathCriteria);
      }

  public String fhirType() {
    return "Topic.resourceTrigger";

  }

  }

    @Block()
    public static class TopicResourceTriggerQueryCriteriaComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The FHIR query based rules are applied to the previous resource state.
         */
        @Child(name = "previous", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule applied to previous resource state", formalDefinition="The FHIR query based rules are applied to the previous resource state." )
        protected StringType previous;

        /**
         * The FHIR query based rules are applied to the current resource state.
         */
        @Child(name = "current", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule applied to current resource state", formalDefinition="The FHIR query based rules are applied to the current resource state." )
        protected StringType current;

        /**
         * If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        @Child(name = "requireBoth", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Both must be true flag", formalDefinition="If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true." )
        protected BooleanType requireBoth;

        private static final long serialVersionUID = -1611265114L;

    /**
     * Constructor
     */
      public TopicResourceTriggerQueryCriteriaComponent() {
        super();
      }

        /**
         * @return {@link #previous} (The FHIR query based rules are applied to the previous resource state.). This is the underlying object with id, value and extensions. The accessor "getPrevious" gives direct access to the value
         */
        public StringType getPreviousElement() { 
          if (this.previous == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerQueryCriteriaComponent.previous");
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
         * @param value {@link #previous} (The FHIR query based rules are applied to the previous resource state.). This is the underlying object with id, value and extensions. The accessor "getPrevious" gives direct access to the value
         */
        public TopicResourceTriggerQueryCriteriaComponent setPreviousElement(StringType value) { 
          this.previous = value;
          return this;
        }

        /**
         * @return The FHIR query based rules are applied to the previous resource state.
         */
        public String getPrevious() { 
          return this.previous == null ? null : this.previous.getValue();
        }

        /**
         * @param value The FHIR query based rules are applied to the previous resource state.
         */
        public TopicResourceTriggerQueryCriteriaComponent setPrevious(String value) { 
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
         * @return {@link #current} (The FHIR query based rules are applied to the current resource state.). This is the underlying object with id, value and extensions. The accessor "getCurrent" gives direct access to the value
         */
        public StringType getCurrentElement() { 
          if (this.current == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerQueryCriteriaComponent.current");
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
         * @param value {@link #current} (The FHIR query based rules are applied to the current resource state.). This is the underlying object with id, value and extensions. The accessor "getCurrent" gives direct access to the value
         */
        public TopicResourceTriggerQueryCriteriaComponent setCurrentElement(StringType value) { 
          this.current = value;
          return this;
        }

        /**
         * @return The FHIR query based rules are applied to the current resource state.
         */
        public String getCurrent() { 
          return this.current == null ? null : this.current.getValue();
        }

        /**
         * @param value The FHIR query based rules are applied to the current resource state.
         */
        public TopicResourceTriggerQueryCriteriaComponent setCurrent(String value) { 
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
         * @return {@link #requireBoth} (If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.). This is the underlying object with id, value and extensions. The accessor "getRequireBoth" gives direct access to the value
         */
        public BooleanType getRequireBothElement() { 
          if (this.requireBoth == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerQueryCriteriaComponent.requireBoth");
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
        public TopicResourceTriggerQueryCriteriaComponent setRequireBothElement(BooleanType value) { 
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
        public TopicResourceTriggerQueryCriteriaComponent setRequireBoth(boolean value) { 
            if (this.requireBoth == null)
              this.requireBoth = new BooleanType();
            this.requireBoth.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("previous", "string", "The FHIR query based rules are applied to the previous resource state.", 0, 1, previous));
          children.add(new Property("current", "string", "The FHIR query based rules are applied to the current resource state.", 0, 1, current));
          children.add(new Property("requireBoth", "boolean", "If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.", 0, 1, requireBoth));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1273775369: /*previous*/  return new Property("previous", "string", "The FHIR query based rules are applied to the previous resource state.", 0, 1, previous);
          case 1126940025: /*current*/  return new Property("current", "string", "The FHIR query based rules are applied to the current resource state.", 0, 1, current);
          case 362116742: /*requireBoth*/  return new Property("requireBoth", "boolean", "If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.", 0, 1, requireBoth);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1273775369: /*previous*/ return this.previous == null ? new Base[0] : new Base[] {this.previous}; // StringType
        case 1126940025: /*current*/ return this.current == null ? new Base[0] : new Base[] {this.current}; // StringType
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
        case 1126940025: // current
          this.current = TypeConvertor.castToString(value); // StringType
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
        } else if (name.equals("current")) {
          this.current = TypeConvertor.castToString(value); // StringType
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
        case 1126940025:  return getCurrentElement();
        case 362116742:  return getRequireBothElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1273775369: /*previous*/ return new String[] {"string"};
        case 1126940025: /*current*/ return new String[] {"string"};
        case 362116742: /*requireBoth*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("previous")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.queryCriteria.previous");
        }
        else if (name.equals("current")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.queryCriteria.current");
        }
        else if (name.equals("requireBoth")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceTrigger.queryCriteria.requireBoth");
        }
        else
          return super.addChild(name);
      }

      public TopicResourceTriggerQueryCriteriaComponent copy() {
        TopicResourceTriggerQueryCriteriaComponent dst = new TopicResourceTriggerQueryCriteriaComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TopicResourceTriggerQueryCriteriaComponent dst) {
        super.copyValues(dst);
        dst.previous = previous == null ? null : previous.copy();
        dst.current = current == null ? null : current.copy();
        dst.requireBoth = requireBoth == null ? null : requireBoth.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerQueryCriteriaComponent))
          return false;
        TopicResourceTriggerQueryCriteriaComponent o = (TopicResourceTriggerQueryCriteriaComponent) other_;
        return compareDeep(previous, o.previous, true) && compareDeep(current, o.current, true) && compareDeep(requireBoth, o.requireBoth, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerQueryCriteriaComponent))
          return false;
        TopicResourceTriggerQueryCriteriaComponent o = (TopicResourceTriggerQueryCriteriaComponent) other_;
        return compareValues(previous, o.previous, true) && compareValues(current, o.current, true) && compareValues(requireBoth, o.requireBoth, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(previous, current, requireBoth
          );
      }

  public String fhirType() {
    return "Topic.resourceTrigger.queryCriteria";

  }

  }

    @Block()
    public static class TopicCanFilterByComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A search parameter (like "patient") which is a label for the filter.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Search parameter that serves as filter key", formalDefinition="A search parameter (like \"patient\") which is a label for the filter." )
        protected StringType name;

        /**
         * Allowable operators to apply when determining matches (Search Modifiers).
         */
        @Child(name = "matchType", type = {CodeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="= | in | not-in | above | below", formalDefinition="Allowable operators to apply when determining matches (Search Modifiers)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/topic-match-operator")
        protected List<Enumeration<TopicFilterByMatchType>> matchType;

        /**
         * Description of how this filter parameter is intended to be used.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Description of this filter parameter", formalDefinition="Description of how this filter parameter is intended to be used." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -9356414L;

    /**
     * Constructor
     */
      public TopicCanFilterByComponent() {
        super();
      }

        /**
         * @return {@link #name} (A search parameter (like "patient") which is a label for the filter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicCanFilterByComponent.name");
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
         * @param value {@link #name} (A search parameter (like "patient") which is a label for the filter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TopicCanFilterByComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A search parameter (like "patient") which is a label for the filter.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A search parameter (like "patient") which is a label for the filter.
         */
        public TopicCanFilterByComponent setName(String value) { 
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
         * @return {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public List<Enumeration<TopicFilterByMatchType>> getMatchType() { 
          if (this.matchType == null)
            this.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          return this.matchType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TopicCanFilterByComponent setMatchType(List<Enumeration<TopicFilterByMatchType>> theMatchType) { 
          this.matchType = theMatchType;
          return this;
        }

        public boolean hasMatchType() { 
          if (this.matchType == null)
            return false;
          for (Enumeration<TopicFilterByMatchType> item : this.matchType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public Enumeration<TopicFilterByMatchType> addMatchTypeElement() {//2 
          Enumeration<TopicFilterByMatchType> t = new Enumeration<TopicFilterByMatchType>(new TopicFilterByMatchTypeEnumFactory());
          if (this.matchType == null)
            this.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          this.matchType.add(t);
          return t;
        }

        /**
         * @param value {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public TopicCanFilterByComponent addMatchType(TopicFilterByMatchType value) { //1
          Enumeration<TopicFilterByMatchType> t = new Enumeration<TopicFilterByMatchType>(new TopicFilterByMatchTypeEnumFactory());
          t.setValue(value);
          if (this.matchType == null)
            this.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          this.matchType.add(t);
          return this;
        }

        /**
         * @param value {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public boolean hasMatchType(TopicFilterByMatchType value) { 
          if (this.matchType == null)
            return false;
          for (Enumeration<TopicFilterByMatchType> v : this.matchType)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #documentation} (Description of how this filter parameter is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicCanFilterByComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Description of how this filter parameter is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public TopicCanFilterByComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Description of how this filter parameter is intended to be used.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Description of how this filter parameter is intended to be used.
         */
        public TopicCanFilterByComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "A search parameter (like \"patient\") which is a label for the filter.", 0, 1, name));
          children.add(new Property("matchType", "code", "Allowable operators to apply when determining matches (Search Modifiers).", 0, java.lang.Integer.MAX_VALUE, matchType));
          children.add(new Property("documentation", "markdown", "Description of how this filter parameter is intended to be used.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "A search parameter (like \"patient\") which is a label for the filter.", 0, 1, name);
          case 614036127: /*matchType*/  return new Property("matchType", "code", "Allowable operators to apply when determining matches (Search Modifiers).", 0, java.lang.Integer.MAX_VALUE, matchType);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Description of how this filter parameter is intended to be used.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 614036127: /*matchType*/ return this.matchType == null ? new Base[0] : this.matchType.toArray(new Base[this.matchType.size()]); // Enumeration<TopicFilterByMatchType>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 614036127: // matchType
          value = new TopicFilterByMatchTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getMatchType().add((Enumeration) value); // Enumeration<TopicFilterByMatchType>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("matchType")) {
          value = new TopicFilterByMatchTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getMatchType().add((Enumeration) value);
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 614036127:  return addMatchTypeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 614036127: /*matchType*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.canFilterBy.name");
        }
        else if (name.equals("matchType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.canFilterBy.matchType");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.canFilterBy.documentation");
        }
        else
          return super.addChild(name);
      }

      public TopicCanFilterByComponent copy() {
        TopicCanFilterByComponent dst = new TopicCanFilterByComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TopicCanFilterByComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (matchType != null) {
          dst.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          for (Enumeration<TopicFilterByMatchType> i : matchType)
            dst.matchType.add(i.copy());
        };
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TopicCanFilterByComponent))
          return false;
        TopicCanFilterByComponent o = (TopicCanFilterByComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(matchType, o.matchType, true) && compareDeep(documentation, o.documentation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TopicCanFilterByComponent))
          return false;
        TopicCanFilterByComponent o = (TopicCanFilterByComponent) other_;
        return compareValues(name, o.name, true) && compareValues(matchType, o.matchType, true) && compareValues(documentation, o.documentation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, matchType, documentation
          );
      }

  public String fhirType() {
    return "Topic.canFilterBy";

  }

  }

    /**
     * An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Logical canonical URL to reference this Topic (globally unique)", formalDefinition="An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions)." )
    protected UriType url;

    /**
     * Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for Topic", formalDefinition="Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the Topic", formalDefinition="The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable." )
    protected StringType version;

    /**
     * A short, descriptive, user-friendly title for the Topic, for example, "admission".
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this Topic (Human friendly)", formalDefinition="A short, descriptive, user-friendly title for the Topic, for example, \"admission\"." )
    protected StringType title;

    /**
     * The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.
     */
    @Child(name = "derivedFromCanonical", type = {CanonicalType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on FHIR protocol or definition", formalDefinition="The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic." )
    protected List<CanonicalType> derivedFromCanonical;

    /**
     * The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.
     */
    @Child(name = "derivedFromUri", type = {UriType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on external protocol or definition", formalDefinition="The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition." )
    protected List<UriType> derivedFromUri;

    /**
     * The current state of the Topic.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The current state of the Topic." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="If for testing purposes, not real usage", formalDefinition="A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date status first applied", formalDefinition="For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal." )
    protected DateTimeType date;

    /**
     * Helps establish the "authority/credibility" of the Topic.  May also allow for contact.
     */
    @Child(name = "publisher", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The name of the individual or organization that published the Topic", formalDefinition="Helps establish the \"authority/credibility\" of the Topic.  May also allow for contact." )
    protected Reference publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the Topic from the consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the Topic", formalDefinition="A free text natural language description of the Topic from the consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Content intends to support these contexts", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions." )
    protected List<UsageContext> useContext;

    /**
     * A jurisdiction in which the Topic is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for Topic (if applicable)", formalDefinition="A jurisdiction in which the Topic is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explains why this Topic is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this Topic is defined", formalDefinition="Explains why this Topic is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic." )
    protected MarkdownType copyright;

    /**
     * The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When Topic approved by publisher", formalDefinition="The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Last review date for the Topic", formalDefinition="The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the Topic content was or is planned to be effective.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The effective date range for the Topic", formalDefinition="The period during which the Topic content was or is planned to be effective." )
    protected Period effectivePeriod;

    /**
     * The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.
     */
    @Child(name = "resourceTrigger", type = {}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Criteria for including a resource update in the topic", formalDefinition="The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression." )
    protected TopicResourceTriggerComponent resourceTrigger;

    /**
     * List of properties by which Subscriptions on the topic can be filtered.
     */
    @Child(name = "canFilterBy", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Properties by which a Subscription can further filter a Topic", formalDefinition="List of properties by which Subscriptions on the topic can be filtered." )
    protected List<TopicCanFilterByComponent> canFilterBy;

    private static final long serialVersionUID = -1683916811L;

  /**
   * Constructor
   */
    public Topic() {
      super();
    }

  /**
   * Constructor
   */
    public Topic(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.url");
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
     * @param value {@link #url} (An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Topic setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public Topic setUrl(String value) { 
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
     * @return {@link #identifier} (Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setIdentifier(List<Identifier> theIdentifier) { 
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

    public Topic addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Topic setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public Topic setVersion(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the Topic, for example, "admission".). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the Topic, for example, "admission".). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Topic setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the Topic, for example, "admission".
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the Topic, for example, "admission".
     */
    public Topic setTitle(String value) { 
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
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public List<CanonicalType> getDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      return this.derivedFromCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical) { 
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
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public CanonicalType addDerivedFromCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public Topic addDerivedFromCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
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
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<UriType> getDerivedFromUri() { 
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      return this.derivedFromUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setDerivedFromUri(List<UriType> theDerivedFromUri) { 
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
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public UriType addDerivedFromUriElement() {//2 
      UriType t = new UriType();
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public Topic addDerivedFromUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
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
     * @return {@link #status} (The current state of the Topic.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.status");
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
     * @param value {@link #status} (The current state of the Topic.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Topic setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the Topic.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the Topic.
     */
    public Topic setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.experimental");
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
     * @param value {@link #experimental} (A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Topic setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public Topic setExperimental(boolean value) { 
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
          throw new Error("Attempt to auto-create Topic.date");
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
    public Topic setDateElement(DateTimeType value) { 
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
    public Topic setDate(Date value) { 
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
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the Topic.  May also allow for contact.)
     */
    public Reference getPublisher() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new Reference(); // cc
      return this.publisher;
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the Topic.  May also allow for contact.)
     */
    public Topic setPublisher(Reference value) { 
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
    public Topic setContact(List<ContactDetail> theContact) { 
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

    public Topic addContact(ContactDetail t) { //3
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
          throw new Error("Attempt to auto-create Topic.description");
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
    public Topic setDescriptionElement(MarkdownType value) { 
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
    public Topic setDescription(String value) { 
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
    public Topic setUseContext(List<UsageContext> theUseContext) { 
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

    public Topic addUseContext(UsageContext t) { //3
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
    public Topic setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public Topic addJurisdiction(CodeableConcept t) { //3
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
          throw new Error("Attempt to auto-create Topic.purpose");
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
    public Topic setPurposeElement(MarkdownType value) { 
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
    public Topic setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Topic setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.
     */
    public Topic setCopyright(String value) { 
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
          throw new Error("Attempt to auto-create Topic.approvalDate");
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
    public Topic setApprovalDateElement(DateType value) { 
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
    public Topic setApprovalDate(Date value) { 
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
          throw new Error("Attempt to auto-create Topic.lastReviewDate");
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
    public Topic setLastReviewDateElement(DateType value) { 
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
    public Topic setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the Topic content was or is planned to be effective.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the Topic content was or is planned to be effective.)
     */
    public Topic setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #resourceTrigger} (The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.)
     */
    public TopicResourceTriggerComponent getResourceTrigger() { 
      if (this.resourceTrigger == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.resourceTrigger");
        else if (Configuration.doAutoCreate())
          this.resourceTrigger = new TopicResourceTriggerComponent(); // cc
      return this.resourceTrigger;
    }

    public boolean hasResourceTrigger() { 
      return this.resourceTrigger != null && !this.resourceTrigger.isEmpty();
    }

    /**
     * @param value {@link #resourceTrigger} (The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.)
     */
    public Topic setResourceTrigger(TopicResourceTriggerComponent value) { 
      this.resourceTrigger = value;
      return this;
    }

    /**
     * @return {@link #canFilterBy} (List of properties by which Subscriptions on the topic can be filtered.)
     */
    public List<TopicCanFilterByComponent> getCanFilterBy() { 
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
      return this.canFilterBy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setCanFilterBy(List<TopicCanFilterByComponent> theCanFilterBy) { 
      this.canFilterBy = theCanFilterBy;
      return this;
    }

    public boolean hasCanFilterBy() { 
      if (this.canFilterBy == null)
        return false;
      for (TopicCanFilterByComponent item : this.canFilterBy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TopicCanFilterByComponent addCanFilterBy() { //3
      TopicCanFilterByComponent t = new TopicCanFilterByComponent();
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
      this.canFilterBy.add(t);
      return t;
    }

    public Topic addCanFilterBy(TopicCanFilterByComponent t) { //3
      if (t == null)
        return this;
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
      this.canFilterBy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #canFilterBy}, creating it if it does not already exist {3}
     */
    public TopicCanFilterByComponent getCanFilterByFirstRep() { 
      if (getCanFilterBy().isEmpty()) {
        addCanFilterBy();
      }
      return getCanFilterBy().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the Topic, for example, \"admission\".", 0, 1, title));
        children.add(new Property("derivedFromCanonical", "canonical(Topic)", "The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical));
        children.add(new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri));
        children.add(new Property("status", "code", "The current state of the Topic.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date));
        children.add(new Property("publisher", "Reference(Practitioner|PractitionerRole|Organization)", "Helps establish the \"authority/credibility\" of the Topic.  May also allow for contact.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the Topic from the consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the Topic is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explains why this Topic is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the Topic content was or is planned to be effective.", 0, 1, effectivePeriod));
        children.add(new Property("resourceTrigger", "", "The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.", 0, 1, resourceTrigger));
        children.add(new Property("canFilterBy", "", "List of properties by which Subscriptions on the topic can be filtered.", 0, java.lang.Integer.MAX_VALUE, canFilterBy));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the Topic, for example, \"admission\".", 0, 1, title);
        case -978133683: /*derivedFromCanonical*/  return new Property("derivedFromCanonical", "canonical(Topic)", "The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical);
        case -1076333435: /*derivedFromUri*/  return new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the Topic.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "Reference(Practitioner|PractitionerRole|Organization)", "Helps establish the \"authority/credibility\" of the Topic.  May also allow for contact.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the Topic from the consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the Topic is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explains why this Topic is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the Topic content was or is planned to be effective.", 0, 1, effectivePeriod);
        case -424927798: /*resourceTrigger*/  return new Property("resourceTrigger", "", "The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.", 0, 1, resourceTrigger);
        case -1299519009: /*canFilterBy*/  return new Property("canFilterBy", "", "List of properties by which Subscriptions on the topic can be filtered.", 0, java.lang.Integer.MAX_VALUE, canFilterBy);
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
        case -978133683: /*derivedFromCanonical*/ return this.derivedFromCanonical == null ? new Base[0] : this.derivedFromCanonical.toArray(new Base[this.derivedFromCanonical.size()]); // CanonicalType
        case -1076333435: /*derivedFromUri*/ return this.derivedFromUri == null ? new Base[0] : this.derivedFromUri.toArray(new Base[this.derivedFromUri.size()]); // UriType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
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
        case -424927798: /*resourceTrigger*/ return this.resourceTrigger == null ? new Base[0] : new Base[] {this.resourceTrigger}; // TopicResourceTriggerComponent
        case -1299519009: /*canFilterBy*/ return this.canFilterBy == null ? new Base[0] : this.canFilterBy.toArray(new Base[this.canFilterBy.size()]); // TopicCanFilterByComponent
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
        case -424927798: // resourceTrigger
          this.resourceTrigger = (TopicResourceTriggerComponent) value; // TopicResourceTriggerComponent
          return value;
        case -1299519009: // canFilterBy
          this.getCanFilterBy().add((TopicCanFilterByComponent) value); // TopicCanFilterByComponent
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
        } else if (name.equals("derivedFromCanonical")) {
          this.getDerivedFromCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("derivedFromUri")) {
          this.getDerivedFromUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
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
        } else if (name.equals("resourceTrigger")) {
          this.resourceTrigger = (TopicResourceTriggerComponent) value; // TopicResourceTriggerComponent
        } else if (name.equals("canFilterBy")) {
          this.getCanFilterBy().add((TopicCanFilterByComponent) value);
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
        case -978133683:  return addDerivedFromCanonicalElement();
        case -1076333435:  return addDerivedFromUriElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
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
        case -424927798:  return getResourceTrigger();
        case -1299519009:  return addCanFilterBy(); 
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
        case -424927798: /*resourceTrigger*/ return new String[] {};
        case -1299519009: /*canFilterBy*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.version");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.title");
        }
        else if (name.equals("derivedFromCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.derivedFromCanonical");
        }
        else if (name.equals("derivedFromUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.derivedFromUri");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.date");
        }
        else if (name.equals("publisher")) {
          this.publisher = new Reference();
          return this.publisher;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("resourceTrigger")) {
          this.resourceTrigger = new TopicResourceTriggerComponent();
          return this.resourceTrigger;
        }
        else if (name.equals("canFilterBy")) {
          return addCanFilterBy();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Topic";

  }

      public Topic copy() {
        Topic dst = new Topic();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Topic dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
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
        dst.resourceTrigger = resourceTrigger == null ? null : resourceTrigger.copy();
        if (canFilterBy != null) {
          dst.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
          for (TopicCanFilterByComponent i : canFilterBy)
            dst.canFilterBy.add(i.copy());
        };
      }

      protected Topic typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Topic))
          return false;
        Topic o = (Topic) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(title, o.title, true) && compareDeep(derivedFromCanonical, o.derivedFromCanonical, true)
           && compareDeep(derivedFromUri, o.derivedFromUri, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(resourceTrigger, o.resourceTrigger, true)
           && compareDeep(canFilterBy, o.canFilterBy, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Topic))
          return false;
        Topic o = (Topic) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(title, o.title, true)
           && compareValues(derivedFromCanonical, o.derivedFromCanonical, true) && compareValues(derivedFromUri, o.derivedFromUri, true)
           && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true)
           && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , title, derivedFromCanonical, derivedFromUri, status, experimental, date, publisher
          , contact, description, useContext, jurisdiction, purpose, copyright, approvalDate
          , lastReviewDate, effectivePeriod, resourceTrigger, canFilterBy);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Topic;
   }

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Date status first applied</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Topic.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="Topic.date", description="Date status first applied", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Date status first applied</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Topic.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Topic.identifier", description="Business Identifier for Topic", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>The name of the individual or organization that published the Topic</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Topic.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="Topic.publisher", description="The name of the individual or organization that published the Topic", type="reference", target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>The name of the individual or organization that published the Topic</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Topic.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PUBLISHER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Topic:publisher</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PUBLISHER = new ca.uhn.fhir.model.api.Include("Topic:publisher").toLocked();

 /**
   * Search parameter: <b>resource-type</b>
   * <p>
   * Description: <b>Candidate types for this topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.resourceTrigger.resourceType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource-type", path="Topic.resourceTrigger.resourceType", description="Candidate types for this topic", type="token" )
  public static final String SP_RESOURCE_TYPE = "resource-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource-type</b>
   * <p>
   * Description: <b>Candidate types for this topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.resourceTrigger.resourceType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RESOURCE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RESOURCE_TYPE);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | retired | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Topic.status", description="draft | active | retired | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | retired | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Name for this Topic (Human friendly)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="Topic.title", description="Name for this Topic (Human friendly)", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Name for this Topic (Human friendly)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>trigger-description</b>
   * <p>
   * Description: <b>Text representation of the trigger</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.resourceTrigger.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="trigger-description", path="Topic.resourceTrigger.description", description="Text representation of the trigger", type="string" )
  public static final String SP_TRIGGER_DESCRIPTION = "trigger-description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>trigger-description</b>
   * <p>
   * Description: <b>Text representation of the trigger</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.resourceTrigger.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TRIGGER_DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TRIGGER_DESCRIPTION);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Logical canonical URL to reference this Topic (globally unique)</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Topic.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="Topic.url", description="Logical canonical URL to reference this Topic (globally unique)", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Logical canonical URL to reference this Topic (globally unique)</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Topic.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Business version of the Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="Topic.version", description="Business version of the Topic", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Business version of the Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}

