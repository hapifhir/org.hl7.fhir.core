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

// Generated on Tue, Dec 31, 2019 12:12+1100 for FHIR vcurrent

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
 * The subscription resource describes a particular client's request to be notified about a Topic.
 */
@ResourceDef(name="Subscription", profile="http://hl7.org/fhir/StructureDefinition/Subscription")
public class Subscription extends DomainResource {

    public enum SubscriptionFilterByMatchType {
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
        public static SubscriptionFilterByMatchType fromCode(String codeString) throws FHIRException {
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
          throw new FHIRException("Unknown SubscriptionFilterByMatchType code '"+codeString+"'");
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
            case EQUAL: return "http://hl7.org/fhir/subscription-operator";
            case IN: return "http://hl7.org/fhir/subscription-operator";
            case NOTIN: return "http://hl7.org/fhir/subscription-operator";
            case ABOVE: return "http://hl7.org/fhir/subscription-operator";
            case BELOW: return "http://hl7.org/fhir/subscription-operator";
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

  public static class SubscriptionFilterByMatchTypeEnumFactory implements EnumFactory<SubscriptionFilterByMatchType> {
    public SubscriptionFilterByMatchType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return SubscriptionFilterByMatchType.EQUAL;
        if ("in".equals(codeString))
          return SubscriptionFilterByMatchType.IN;
        if ("not-in".equals(codeString))
          return SubscriptionFilterByMatchType.NOTIN;
        if ("above".equals(codeString))
          return SubscriptionFilterByMatchType.ABOVE;
        if ("below".equals(codeString))
          return SubscriptionFilterByMatchType.BELOW;
        throw new IllegalArgumentException("Unknown SubscriptionFilterByMatchType code '"+codeString+"'");
        }
        public Enumeration<SubscriptionFilterByMatchType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionFilterByMatchType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("=".equals(codeString))
          return new Enumeration<SubscriptionFilterByMatchType>(this, SubscriptionFilterByMatchType.EQUAL);
        if ("in".equals(codeString))
          return new Enumeration<SubscriptionFilterByMatchType>(this, SubscriptionFilterByMatchType.IN);
        if ("not-in".equals(codeString))
          return new Enumeration<SubscriptionFilterByMatchType>(this, SubscriptionFilterByMatchType.NOTIN);
        if ("above".equals(codeString))
          return new Enumeration<SubscriptionFilterByMatchType>(this, SubscriptionFilterByMatchType.ABOVE);
        if ("below".equals(codeString))
          return new Enumeration<SubscriptionFilterByMatchType>(this, SubscriptionFilterByMatchType.BELOW);
        throw new FHIRException("Unknown SubscriptionFilterByMatchType code '"+codeString+"'");
        }
    public String toCode(SubscriptionFilterByMatchType code) {
      if (code == SubscriptionFilterByMatchType.EQUAL)
        return "=";
      if (code == SubscriptionFilterByMatchType.IN)
        return "in";
      if (code == SubscriptionFilterByMatchType.NOTIN)
        return "not-in";
      if (code == SubscriptionFilterByMatchType.ABOVE)
        return "above";
      if (code == SubscriptionFilterByMatchType.BELOW)
        return "below";
      return "?";
      }
    public String toSystem(SubscriptionFilterByMatchType code) {
      return code.getSystem();
      }
    }

    public enum SubscriptionPayloadContent {
        /**
         * No resource content is transacted in the notification payload.
         */
        EMPTY, 
        /**
         * Only the resource id is transacted in the notification payload.
         */
        IDONLY, 
        /**
         * The entire resource is transacted in the notification payload.
         */
        FULLRESOURCE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SubscriptionPayloadContent fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("empty".equals(codeString))
          return EMPTY;
        if ("id-only".equals(codeString))
          return IDONLY;
        if ("full-resource".equals(codeString))
          return FULLRESOURCE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SubscriptionPayloadContent code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EMPTY: return "empty";
            case IDONLY: return "id-only";
            case FULLRESOURCE: return "full-resource";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EMPTY: return "http://hl7.org/fhir/subscription-payload-content";
            case IDONLY: return "http://hl7.org/fhir/subscription-payload-content";
            case FULLRESOURCE: return "http://hl7.org/fhir/subscription-payload-content";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EMPTY: return "No resource content is transacted in the notification payload.";
            case IDONLY: return "Only the resource id is transacted in the notification payload.";
            case FULLRESOURCE: return "The entire resource is transacted in the notification payload.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EMPTY: return "empty";
            case IDONLY: return "id-only";
            case FULLRESOURCE: return "full-resource";
            default: return "?";
          }
        }
    }

  public static class SubscriptionPayloadContentEnumFactory implements EnumFactory<SubscriptionPayloadContent> {
    public SubscriptionPayloadContent fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("empty".equals(codeString))
          return SubscriptionPayloadContent.EMPTY;
        if ("id-only".equals(codeString))
          return SubscriptionPayloadContent.IDONLY;
        if ("full-resource".equals(codeString))
          return SubscriptionPayloadContent.FULLRESOURCE;
        throw new IllegalArgumentException("Unknown SubscriptionPayloadContent code '"+codeString+"'");
        }
        public Enumeration<SubscriptionPayloadContent> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionPayloadContent>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("empty".equals(codeString))
          return new Enumeration<SubscriptionPayloadContent>(this, SubscriptionPayloadContent.EMPTY);
        if ("id-only".equals(codeString))
          return new Enumeration<SubscriptionPayloadContent>(this, SubscriptionPayloadContent.IDONLY);
        if ("full-resource".equals(codeString))
          return new Enumeration<SubscriptionPayloadContent>(this, SubscriptionPayloadContent.FULLRESOURCE);
        throw new FHIRException("Unknown SubscriptionPayloadContent code '"+codeString+"'");
        }
    public String toCode(SubscriptionPayloadContent code) {
      if (code == SubscriptionPayloadContent.EMPTY)
        return "empty";
      if (code == SubscriptionPayloadContent.IDONLY)
        return "id-only";
      if (code == SubscriptionPayloadContent.FULLRESOURCE)
        return "full-resource";
      return "?";
      }
    public String toSystem(SubscriptionPayloadContent code) {
      return code.getSystem();
      }
    }

    public enum SubscriptionStatus {
        /**
         * The client has requested the subscription, and the server has not yet set it up.
         */
        REQUESTED, 
        /**
         * The subscription is active.
         */
        ACTIVE, 
        /**
         * The server has an error executing the notification.
         */
        ERROR, 
        /**
         * Too many errors have occurred or the subscription has expired.
         */
        OFF, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SubscriptionStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("requested".equals(codeString))
          return REQUESTED;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("error".equals(codeString))
          return ERROR;
        if ("off".equals(codeString))
          return OFF;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SubscriptionStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REQUESTED: return "requested";
            case ACTIVE: return "active";
            case ERROR: return "error";
            case OFF: return "off";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REQUESTED: return "http://hl7.org/fhir/subscription-status";
            case ACTIVE: return "http://hl7.org/fhir/subscription-status";
            case ERROR: return "http://hl7.org/fhir/subscription-status";
            case OFF: return "http://hl7.org/fhir/subscription-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REQUESTED: return "The client has requested the subscription, and the server has not yet set it up.";
            case ACTIVE: return "The subscription is active.";
            case ERROR: return "The server has an error executing the notification.";
            case OFF: return "Too many errors have occurred or the subscription has expired.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REQUESTED: return "Requested";
            case ACTIVE: return "Active";
            case ERROR: return "Error";
            case OFF: return "Off";
            default: return "?";
          }
        }
    }

  public static class SubscriptionStatusEnumFactory implements EnumFactory<SubscriptionStatus> {
    public SubscriptionStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("requested".equals(codeString))
          return SubscriptionStatus.REQUESTED;
        if ("active".equals(codeString))
          return SubscriptionStatus.ACTIVE;
        if ("error".equals(codeString))
          return SubscriptionStatus.ERROR;
        if ("off".equals(codeString))
          return SubscriptionStatus.OFF;
        throw new IllegalArgumentException("Unknown SubscriptionStatus code '"+codeString+"'");
        }
        public Enumeration<SubscriptionStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("requested".equals(codeString))
          return new Enumeration<SubscriptionStatus>(this, SubscriptionStatus.REQUESTED);
        if ("active".equals(codeString))
          return new Enumeration<SubscriptionStatus>(this, SubscriptionStatus.ACTIVE);
        if ("error".equals(codeString))
          return new Enumeration<SubscriptionStatus>(this, SubscriptionStatus.ERROR);
        if ("off".equals(codeString))
          return new Enumeration<SubscriptionStatus>(this, SubscriptionStatus.OFF);
        throw new FHIRException("Unknown SubscriptionStatus code '"+codeString+"'");
        }
    public String toCode(SubscriptionStatus code) {
      if (code == SubscriptionStatus.REQUESTED)
        return "requested";
      if (code == SubscriptionStatus.ACTIVE)
        return "active";
      if (code == SubscriptionStatus.ERROR)
        return "error";
      if (code == SubscriptionStatus.OFF)
        return "off";
      return "?";
      }
    public String toSystem(SubscriptionStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SubscriptionFilterByComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Filter label defined in Topic", formalDefinition="The filter label (=key) as defined in the `Topic.canFilterBy.name`  element." )
        protected StringType name;

        /**
         * The operator to apply to the filter value when determining matches (Search modifiers).
         */
        @Child(name = "matchType", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="= | in | not-in | above | below", formalDefinition="The operator to apply to the filter value when determining matches (Search modifiers)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-operator")
        protected Enumeration<SubscriptionFilterByMatchType> matchType;

        /**
         * The literal value or resource path as is legal in search - for example, "Patient/123" or "le1950".
         */
        @Child(name = "value", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Literal value or resource path", formalDefinition="The literal value or resource path as is legal in search - for example, \"Patient/123\" or \"le1950\"." )
        protected StringType value;

        private static final long serialVersionUID = -1805389171L;

    /**
     * Constructor
     */
      public SubscriptionFilterByComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionFilterByComponent(String name, String value) {
        super();
        this.setName(name);
        this.setValue(value);
      }

        /**
         * @return {@link #name} (The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionFilterByComponent.name");
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
         * @param value {@link #name} (The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public SubscriptionFilterByComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.
         */
        public SubscriptionFilterByComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #matchType} (The operator to apply to the filter value when determining matches (Search modifiers).). This is the underlying object with id, value and extensions. The accessor "getMatchType" gives direct access to the value
         */
        public Enumeration<SubscriptionFilterByMatchType> getMatchTypeElement() { 
          if (this.matchType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionFilterByComponent.matchType");
            else if (Configuration.doAutoCreate())
              this.matchType = new Enumeration<SubscriptionFilterByMatchType>(new SubscriptionFilterByMatchTypeEnumFactory()); // bb
          return this.matchType;
        }

        public boolean hasMatchTypeElement() { 
          return this.matchType != null && !this.matchType.isEmpty();
        }

        public boolean hasMatchType() { 
          return this.matchType != null && !this.matchType.isEmpty();
        }

        /**
         * @param value {@link #matchType} (The operator to apply to the filter value when determining matches (Search modifiers).). This is the underlying object with id, value and extensions. The accessor "getMatchType" gives direct access to the value
         */
        public SubscriptionFilterByComponent setMatchTypeElement(Enumeration<SubscriptionFilterByMatchType> value) { 
          this.matchType = value;
          return this;
        }

        /**
         * @return The operator to apply to the filter value when determining matches (Search modifiers).
         */
        public SubscriptionFilterByMatchType getMatchType() { 
          return this.matchType == null ? null : this.matchType.getValue();
        }

        /**
         * @param value The operator to apply to the filter value when determining matches (Search modifiers).
         */
        public SubscriptionFilterByComponent setMatchType(SubscriptionFilterByMatchType value) { 
          if (value == null)
            this.matchType = null;
          else {
            if (this.matchType == null)
              this.matchType = new Enumeration<SubscriptionFilterByMatchType>(new SubscriptionFilterByMatchTypeEnumFactory());
            this.matchType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #value} (The literal value or resource path as is legal in search - for example, "Patient/123" or "le1950".). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionFilterByComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The literal value or resource path as is legal in search - for example, "Patient/123" or "le1950".). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public SubscriptionFilterByComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The literal value or resource path as is legal in search - for example, "Patient/123" or "le1950".
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The literal value or resource path as is legal in search - for example, "Patient/123" or "le1950".
         */
        public SubscriptionFilterByComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.", 0, 1, name));
          children.add(new Property("matchType", "code", "The operator to apply to the filter value when determining matches (Search modifiers).", 0, 1, matchType));
          children.add(new Property("value", "string", "The literal value or resource path as is legal in search - for example, \"Patient/123\" or \"le1950\".", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The filter label (=key) as defined in the `Topic.canFilterBy.name`  element.", 0, 1, name);
          case 614036127: /*matchType*/  return new Property("matchType", "code", "The operator to apply to the filter value when determining matches (Search modifiers).", 0, 1, matchType);
          case 111972721: /*value*/  return new Property("value", "string", "The literal value or resource path as is legal in search - for example, \"Patient/123\" or \"le1950\".", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 614036127: /*matchType*/ return this.matchType == null ? new Base[0] : new Base[] {this.matchType}; // Enumeration<SubscriptionFilterByMatchType>
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
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
          value = new SubscriptionFilterByMatchTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.matchType = (Enumeration) value; // Enumeration<SubscriptionFilterByMatchType>
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("matchType")) {
          value = new SubscriptionFilterByMatchTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.matchType = (Enumeration) value; // Enumeration<SubscriptionFilterByMatchType>
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 614036127:  return getMatchTypeElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 614036127: /*matchType*/ return new String[] {"code"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.filterBy.name");
        }
        else if (name.equals("matchType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.filterBy.matchType");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.filterBy.value");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionFilterByComponent copy() {
        SubscriptionFilterByComponent dst = new SubscriptionFilterByComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionFilterByComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.matchType = matchType == null ? null : matchType.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionFilterByComponent))
          return false;
        SubscriptionFilterByComponent o = (SubscriptionFilterByComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(matchType, o.matchType, true) && compareDeep(value, o.value, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionFilterByComponent))
          return false;
        SubscriptionFilterByComponent o = (SubscriptionFilterByComponent) other_;
        return compareValues(name, o.name, true) && compareValues(matchType, o.matchType, true) && compareValues(value, o.value, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, matchType, value);
      }

  public String fhirType() {
    return "Subscription.filterBy";

  }

  }

    @Block()
    public static class SubscriptionChannelComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of channel to send notifications on.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="rest-hook | websocket | email | message", formalDefinition="The type of channel to send notifications on." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-channel-type")
        protected CodeableConcept type;

        /**
         * The url that describes the actual end-point to send messages to.
         */
        @Child(name = "endpoint", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Where the channel points to", formalDefinition="The url that describes the actual end-point to send messages to." )
        protected UrlType endpoint;

        /**
         * Additional headers / information to send as part of the notification.
         */
        @Child(name = "header", type = {StringType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Usage depends on the channel type", formalDefinition="Additional headers / information to send as part of the notification." )
        protected List<StringType> header;

        /**
         * If present,  a 'hearbeat" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.
         */
        @Child(name = "heartbeatPeriod", type = {UnsignedIntType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Interval in seconds to send 'heartbeat' notification", formalDefinition="If present,  a 'hearbeat\" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent." )
        protected UnsignedIntType heartbeatPeriod;

        /**
         * The payload mimetype and content.  If the payload is not present, then there is no payload in the notification, just a notification.
         */
        @Child(name = "payload", type = {}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Payload definition", formalDefinition="The payload mimetype and content.  If the payload is not present, then there is no payload in the notification, just a notification." )
        protected SubscriptionChannelPayloadComponent payload;

        private static final long serialVersionUID = -1807149281L;

    /**
     * Constructor
     */
      public SubscriptionChannelComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionChannelComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The type of channel to send notifications on.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionChannelComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of channel to send notifications on.)
         */
        public SubscriptionChannelComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #endpoint} (The url that describes the actual end-point to send messages to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
         */
        public UrlType getEndpointElement() { 
          if (this.endpoint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionChannelComponent.endpoint");
            else if (Configuration.doAutoCreate())
              this.endpoint = new UrlType(); // bb
          return this.endpoint;
        }

        public boolean hasEndpointElement() { 
          return this.endpoint != null && !this.endpoint.isEmpty();
        }

        public boolean hasEndpoint() { 
          return this.endpoint != null && !this.endpoint.isEmpty();
        }

        /**
         * @param value {@link #endpoint} (The url that describes the actual end-point to send messages to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
         */
        public SubscriptionChannelComponent setEndpointElement(UrlType value) { 
          this.endpoint = value;
          return this;
        }

        /**
         * @return The url that describes the actual end-point to send messages to.
         */
        public String getEndpoint() { 
          return this.endpoint == null ? null : this.endpoint.getValue();
        }

        /**
         * @param value The url that describes the actual end-point to send messages to.
         */
        public SubscriptionChannelComponent setEndpoint(String value) { 
          if (Utilities.noString(value))
            this.endpoint = null;
          else {
            if (this.endpoint == null)
              this.endpoint = new UrlType();
            this.endpoint.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #header} (Additional headers / information to send as part of the notification.)
         */
        public List<StringType> getHeader() { 
          if (this.header == null)
            this.header = new ArrayList<StringType>();
          return this.header;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubscriptionChannelComponent setHeader(List<StringType> theHeader) { 
          this.header = theHeader;
          return this;
        }

        public boolean hasHeader() { 
          if (this.header == null)
            return false;
          for (StringType item : this.header)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #header} (Additional headers / information to send as part of the notification.)
         */
        public StringType addHeaderElement() {//2 
          StringType t = new StringType();
          if (this.header == null)
            this.header = new ArrayList<StringType>();
          this.header.add(t);
          return t;
        }

        /**
         * @param value {@link #header} (Additional headers / information to send as part of the notification.)
         */
        public SubscriptionChannelComponent addHeader(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.header == null)
            this.header = new ArrayList<StringType>();
          this.header.add(t);
          return this;
        }

        /**
         * @param value {@link #header} (Additional headers / information to send as part of the notification.)
         */
        public boolean hasHeader(String value) { 
          if (this.header == null)
            return false;
          for (StringType v : this.header)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #heartbeatPeriod} (If present,  a 'hearbeat" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.). This is the underlying object with id, value and extensions. The accessor "getHeartbeatPeriod" gives direct access to the value
         */
        public UnsignedIntType getHeartbeatPeriodElement() { 
          if (this.heartbeatPeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionChannelComponent.heartbeatPeriod");
            else if (Configuration.doAutoCreate())
              this.heartbeatPeriod = new UnsignedIntType(); // bb
          return this.heartbeatPeriod;
        }

        public boolean hasHeartbeatPeriodElement() { 
          return this.heartbeatPeriod != null && !this.heartbeatPeriod.isEmpty();
        }

        public boolean hasHeartbeatPeriod() { 
          return this.heartbeatPeriod != null && !this.heartbeatPeriod.isEmpty();
        }

        /**
         * @param value {@link #heartbeatPeriod} (If present,  a 'hearbeat" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.). This is the underlying object with id, value and extensions. The accessor "getHeartbeatPeriod" gives direct access to the value
         */
        public SubscriptionChannelComponent setHeartbeatPeriodElement(UnsignedIntType value) { 
          this.heartbeatPeriod = value;
          return this;
        }

        /**
         * @return If present,  a 'hearbeat" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.
         */
        public int getHeartbeatPeriod() { 
          return this.heartbeatPeriod == null || this.heartbeatPeriod.isEmpty() ? 0 : this.heartbeatPeriod.getValue();
        }

        /**
         * @param value If present,  a 'hearbeat" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.
         */
        public SubscriptionChannelComponent setHeartbeatPeriod(int value) { 
            if (this.heartbeatPeriod == null)
              this.heartbeatPeriod = new UnsignedIntType();
            this.heartbeatPeriod.setValue(value);
          return this;
        }

        /**
         * @return {@link #payload} (The payload mimetype and content.  If the payload is not present, then there is no payload in the notification, just a notification.)
         */
        public SubscriptionChannelPayloadComponent getPayload() { 
          if (this.payload == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionChannelComponent.payload");
            else if (Configuration.doAutoCreate())
              this.payload = new SubscriptionChannelPayloadComponent(); // cc
          return this.payload;
        }

        public boolean hasPayload() { 
          return this.payload != null && !this.payload.isEmpty();
        }

        /**
         * @param value {@link #payload} (The payload mimetype and content.  If the payload is not present, then there is no payload in the notification, just a notification.)
         */
        public SubscriptionChannelComponent setPayload(SubscriptionChannelPayloadComponent value) { 
          this.payload = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type of channel to send notifications on.", 0, 1, type));
          children.add(new Property("endpoint", "url", "The url that describes the actual end-point to send messages to.", 0, 1, endpoint));
          children.add(new Property("header", "string", "Additional headers / information to send as part of the notification.", 0, java.lang.Integer.MAX_VALUE, header));
          children.add(new Property("heartbeatPeriod", "unsignedInt", "If present,  a 'hearbeat\" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.", 0, 1, heartbeatPeriod));
          children.add(new Property("payload", "", "The payload mimetype and content.  If the payload is not present, then there is no payload in the notification, just a notification.", 0, 1, payload));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of channel to send notifications on.", 0, 1, type);
          case 1741102485: /*endpoint*/  return new Property("endpoint", "url", "The url that describes the actual end-point to send messages to.", 0, 1, endpoint);
          case -1221270899: /*header*/  return new Property("header", "string", "Additional headers / information to send as part of the notification.", 0, java.lang.Integer.MAX_VALUE, header);
          case -938465827: /*heartbeatPeriod*/  return new Property("heartbeatPeriod", "unsignedInt", "If present,  a 'hearbeat\" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.", 0, 1, heartbeatPeriod);
          case -786701938: /*payload*/  return new Property("payload", "", "The payload mimetype and content.  If the payload is not present, then there is no payload in the notification, just a notification.", 0, 1, payload);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : new Base[] {this.endpoint}; // UrlType
        case -1221270899: /*header*/ return this.header == null ? new Base[0] : this.header.toArray(new Base[this.header.size()]); // StringType
        case -938465827: /*heartbeatPeriod*/ return this.heartbeatPeriod == null ? new Base[0] : new Base[] {this.heartbeatPeriod}; // UnsignedIntType
        case -786701938: /*payload*/ return this.payload == null ? new Base[0] : new Base[] {this.payload}; // SubscriptionChannelPayloadComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1741102485: // endpoint
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case -1221270899: // header
          this.getHeader().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -938465827: // heartbeatPeriod
          this.heartbeatPeriod = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -786701938: // payload
          this.payload = (SubscriptionChannelPayloadComponent) value; // SubscriptionChannelPayloadComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("endpoint")) {
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("header")) {
          this.getHeader().add(TypeConvertor.castToString(value));
        } else if (name.equals("heartbeatPeriod")) {
          this.heartbeatPeriod = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("payload")) {
          this.payload = (SubscriptionChannelPayloadComponent) value; // SubscriptionChannelPayloadComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 1741102485:  return getEndpointElement();
        case -1221270899:  return addHeaderElement();
        case -938465827:  return getHeartbeatPeriodElement();
        case -786701938:  return getPayload();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1741102485: /*endpoint*/ return new String[] {"url"};
        case -1221270899: /*header*/ return new String[] {"string"};
        case -938465827: /*heartbeatPeriod*/ return new String[] {"unsignedInt"};
        case -786701938: /*payload*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("endpoint")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.channel.endpoint");
        }
        else if (name.equals("header")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.channel.header");
        }
        else if (name.equals("heartbeatPeriod")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.channel.heartbeatPeriod");
        }
        else if (name.equals("payload")) {
          this.payload = new SubscriptionChannelPayloadComponent();
          return this.payload;
        }
        else
          return super.addChild(name);
      }

      public SubscriptionChannelComponent copy() {
        SubscriptionChannelComponent dst = new SubscriptionChannelComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionChannelComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.endpoint = endpoint == null ? null : endpoint.copy();
        if (header != null) {
          dst.header = new ArrayList<StringType>();
          for (StringType i : header)
            dst.header.add(i.copy());
        };
        dst.heartbeatPeriod = heartbeatPeriod == null ? null : heartbeatPeriod.copy();
        dst.payload = payload == null ? null : payload.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionChannelComponent))
          return false;
        SubscriptionChannelComponent o = (SubscriptionChannelComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(endpoint, o.endpoint, true) && compareDeep(header, o.header, true)
           && compareDeep(heartbeatPeriod, o.heartbeatPeriod, true) && compareDeep(payload, o.payload, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionChannelComponent))
          return false;
        SubscriptionChannelComponent o = (SubscriptionChannelComponent) other_;
        return compareValues(endpoint, o.endpoint, true) && compareValues(header, o.header, true) && compareValues(heartbeatPeriod, o.heartbeatPeriod, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, endpoint, header, heartbeatPeriod
          , payload);
      }

  public String fhirType() {
    return "Subscription.channel";

  }

  }

    @Block()
    public static class SubscriptionChannelPayloadComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.
         */
        @Child(name = "contentType", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="MIME type to send, or omit for no payload", formalDefinition="The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types \"text/plain\" and \"text/html\" may also be used for Email subscriptions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected CodeType contentType;

        /**
         * How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.
         */
        @Child(name = "content", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="empty | id-only | full-resource", formalDefinition="How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-payload-content")
        protected Enumeration<SubscriptionPayloadContent> content;

        private static final long serialVersionUID = -1128800132L;

    /**
     * Constructor
     */
      public SubscriptionChannelPayloadComponent() {
        super();
      }

        /**
         * @return {@link #contentType} (The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
         */
        public CodeType getContentTypeElement() { 
          if (this.contentType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionChannelPayloadComponent.contentType");
            else if (Configuration.doAutoCreate())
              this.contentType = new CodeType(); // bb
          return this.contentType;
        }

        public boolean hasContentTypeElement() { 
          return this.contentType != null && !this.contentType.isEmpty();
        }

        public boolean hasContentType() { 
          return this.contentType != null && !this.contentType.isEmpty();
        }

        /**
         * @param value {@link #contentType} (The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
         */
        public SubscriptionChannelPayloadComponent setContentTypeElement(CodeType value) { 
          this.contentType = value;
          return this;
        }

        /**
         * @return The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.
         */
        public String getContentType() { 
          return this.contentType == null ? null : this.contentType.getValue();
        }

        /**
         * @param value The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.
         */
        public SubscriptionChannelPayloadComponent setContentType(String value) { 
          if (Utilities.noString(value))
            this.contentType = null;
          else {
            if (this.contentType == null)
              this.contentType = new CodeType();
            this.contentType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #content} (How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.). This is the underlying object with id, value and extensions. The accessor "getContent" gives direct access to the value
         */
        public Enumeration<SubscriptionPayloadContent> getContentElement() { 
          if (this.content == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionChannelPayloadComponent.content");
            else if (Configuration.doAutoCreate())
              this.content = new Enumeration<SubscriptionPayloadContent>(new SubscriptionPayloadContentEnumFactory()); // bb
          return this.content;
        }

        public boolean hasContentElement() { 
          return this.content != null && !this.content.isEmpty();
        }

        public boolean hasContent() { 
          return this.content != null && !this.content.isEmpty();
        }

        /**
         * @param value {@link #content} (How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.). This is the underlying object with id, value and extensions. The accessor "getContent" gives direct access to the value
         */
        public SubscriptionChannelPayloadComponent setContentElement(Enumeration<SubscriptionPayloadContent> value) { 
          this.content = value;
          return this;
        }

        /**
         * @return How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.
         */
        public SubscriptionPayloadContent getContent() { 
          return this.content == null ? null : this.content.getValue();
        }

        /**
         * @param value How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.
         */
        public SubscriptionChannelPayloadComponent setContent(SubscriptionPayloadContent value) { 
          if (value == null)
            this.content = null;
          else {
            if (this.content == null)
              this.content = new Enumeration<SubscriptionPayloadContent>(new SubscriptionPayloadContentEnumFactory());
            this.content.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("contentType", "code", "The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types \"text/plain\" and \"text/html\" may also be used for Email subscriptions.", 0, 1, contentType));
          children.add(new Property("content", "code", "How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.", 0, 1, content));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -389131437: /*contentType*/  return new Property("contentType", "code", "The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types \"text/plain\" and \"text/html\" may also be used for Email subscriptions.", 0, 1, contentType);
          case 951530617: /*content*/  return new Property("content", "code", "How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.", 0, 1, content);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -389131437: /*contentType*/ return this.contentType == null ? new Base[0] : new Base[] {this.contentType}; // CodeType
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // Enumeration<SubscriptionPayloadContent>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -389131437: // contentType
          this.contentType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 951530617: // content
          value = new SubscriptionPayloadContentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.content = (Enumeration) value; // Enumeration<SubscriptionPayloadContent>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("contentType")) {
          this.contentType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("content")) {
          value = new SubscriptionPayloadContentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.content = (Enumeration) value; // Enumeration<SubscriptionPayloadContent>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -389131437:  return getContentTypeElement();
        case 951530617:  return getContentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -389131437: /*contentType*/ return new String[] {"code"};
        case 951530617: /*content*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("contentType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.channel.payload.contentType");
        }
        else if (name.equals("content")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.channel.payload.content");
        }
        else
          return super.addChild(name);
      }

      public SubscriptionChannelPayloadComponent copy() {
        SubscriptionChannelPayloadComponent dst = new SubscriptionChannelPayloadComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionChannelPayloadComponent dst) {
        super.copyValues(dst);
        dst.contentType = contentType == null ? null : contentType.copy();
        dst.content = content == null ? null : content.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionChannelPayloadComponent))
          return false;
        SubscriptionChannelPayloadComponent o = (SubscriptionChannelPayloadComponent) other_;
        return compareDeep(contentType, o.contentType, true) && compareDeep(content, o.content, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionChannelPayloadComponent))
          return false;
        SubscriptionChannelPayloadComponent o = (SubscriptionChannelPayloadComponent) other_;
        return compareValues(contentType, o.contentType, true) && compareValues(content, o.content, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(contentType, content);
      }

  public String fhirType() {
    return "Subscription.channel.payload";

  }

  }

    /**
     * A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifiers (business identifier)", formalDefinition="A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * A natural language name identifying the subscription.
     */
    @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human readable name for this subscription", formalDefinition="A natural language name identifying the subscription." )
    protected StringType name;

    /**
     * The status of the subscription, which marks the server state for managing the subscription.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="requested | active | error | off", formalDefinition="The status of the subscription, which marks the server state for managing the subscription." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-status")
    protected Enumeration<SubscriptionStatus> status;

    /**
     * The reference to the topic to be notified about.
     */
    @Child(name = "topic", type = {Topic.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the topic being subscribed to", formalDefinition="The reference to the topic to be notified about." )
    protected Reference topic;

    /**
     * Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting.
     */
    @Child(name = "contact", type = {ContactPoint.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for source (e.g. troubleshooting)", formalDefinition="Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting." )
    protected List<ContactPoint> contact;

    /**
     * The time for the server to turn the subscription off.
     */
    @Child(name = "end", type = {InstantType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When to automatically delete the subscription", formalDefinition="The time for the server to turn the subscription off." )
    protected InstantType end;

    /**
     * A description of why this subscription is defined.
     */
    @Child(name = "reason", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Description of why this subscription was created", formalDefinition="A description of why this subscription is defined." )
    protected StringType reason;

    /**
     * The filter properties to be applied to narrow the topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).
     */
    @Child(name = "filterBy", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Criteria for narrowing the topic stream", formalDefinition="The filter properties to be applied to narrow the topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND)." )
    protected List<SubscriptionFilterByComponent> filterBy;

    /**
     * A record of the last error that occurred when the server processed a notification.
     */
    @Child(name = "error", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Latest error code or note", formalDefinition="A record of the last error that occurred when the server processed a notification." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-error")
    protected List<CodeableConcept> error;

    /**
     * A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an "active" or "error" state -- not "requested" or "off").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.
     */
    @Child(name = "eventCount", type = {UnsignedIntType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Notification event counter", formalDefinition="A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an \"active\" or \"error\" state -- not \"requested\" or \"off\").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values." )
    protected UnsignedIntType eventCount;

    /**
     * Details where to send notifications when resources are received that meet the criteria.
     */
    @Child(name = "channel", type = {}, order=10, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The channel on which to report matches to the criteria", formalDefinition="Details where to send notifications when resources are received that meet the criteria." )
    protected SubscriptionChannelComponent channel;

    private static final long serialVersionUID = -1374014223L;

  /**
   * Constructor
   */
    public Subscription() {
      super();
    }

  /**
   * Constructor
   */
    public Subscription(SubscriptionStatus status, Reference topic, SubscriptionChannelComponent channel) {
      super();
      this.setStatus(status);
      this.setTopic(topic);
      this.setChannel(channel);
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Subscription setIdentifier(List<Identifier> theIdentifier) { 
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

    public Subscription addIdentifier(Identifier t) { //3
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
     * @return {@link #name} (A natural language name identifying the subscription.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.name");
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
     * @param value {@link #name} (A natural language name identifying the subscription.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Subscription setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the subscription.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the subscription.
     */
    public Subscription setName(String value) { 
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
     * @return {@link #status} (The status of the subscription, which marks the server state for managing the subscription.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<SubscriptionStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<SubscriptionStatus>(new SubscriptionStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the subscription, which marks the server state for managing the subscription.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Subscription setStatusElement(Enumeration<SubscriptionStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the subscription, which marks the server state for managing the subscription.
     */
    public SubscriptionStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the subscription, which marks the server state for managing the subscription.
     */
    public Subscription setStatus(SubscriptionStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<SubscriptionStatus>(new SubscriptionStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #topic} (The reference to the topic to be notified about.)
     */
    public Reference getTopic() { 
      if (this.topic == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.topic");
        else if (Configuration.doAutoCreate())
          this.topic = new Reference(); // cc
      return this.topic;
    }

    public boolean hasTopic() { 
      return this.topic != null && !this.topic.isEmpty();
    }

    /**
     * @param value {@link #topic} (The reference to the topic to be notified about.)
     */
    public Subscription setTopic(Reference value) { 
      this.topic = value;
      return this;
    }

    /**
     * @return {@link #contact} (Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting.)
     */
    public List<ContactPoint> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Subscription setContact(List<ContactPoint> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactPoint item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactPoint addContact() { //3
      ContactPoint t = new ContactPoint();
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      this.contact.add(t);
      return t;
    }

    public Subscription addContact(ContactPoint t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactPoint getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #end} (The time for the server to turn the subscription off.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public InstantType getEndElement() { 
      if (this.end == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.end");
        else if (Configuration.doAutoCreate())
          this.end = new InstantType(); // bb
      return this.end;
    }

    public boolean hasEndElement() { 
      return this.end != null && !this.end.isEmpty();
    }

    public boolean hasEnd() { 
      return this.end != null && !this.end.isEmpty();
    }

    /**
     * @param value {@link #end} (The time for the server to turn the subscription off.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public Subscription setEndElement(InstantType value) { 
      this.end = value;
      return this;
    }

    /**
     * @return The time for the server to turn the subscription off.
     */
    public Date getEnd() { 
      return this.end == null ? null : this.end.getValue();
    }

    /**
     * @param value The time for the server to turn the subscription off.
     */
    public Subscription setEnd(Date value) { 
      if (value == null)
        this.end = null;
      else {
        if (this.end == null)
          this.end = new InstantType();
        this.end.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #reason} (A description of why this subscription is defined.). This is the underlying object with id, value and extensions. The accessor "getReason" gives direct access to the value
     */
    public StringType getReasonElement() { 
      if (this.reason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.reason");
        else if (Configuration.doAutoCreate())
          this.reason = new StringType(); // bb
      return this.reason;
    }

    public boolean hasReasonElement() { 
      return this.reason != null && !this.reason.isEmpty();
    }

    public boolean hasReason() { 
      return this.reason != null && !this.reason.isEmpty();
    }

    /**
     * @param value {@link #reason} (A description of why this subscription is defined.). This is the underlying object with id, value and extensions. The accessor "getReason" gives direct access to the value
     */
    public Subscription setReasonElement(StringType value) { 
      this.reason = value;
      return this;
    }

    /**
     * @return A description of why this subscription is defined.
     */
    public String getReason() { 
      return this.reason == null ? null : this.reason.getValue();
    }

    /**
     * @param value A description of why this subscription is defined.
     */
    public Subscription setReason(String value) { 
      if (Utilities.noString(value))
        this.reason = null;
      else {
        if (this.reason == null)
          this.reason = new StringType();
        this.reason.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #filterBy} (The filter properties to be applied to narrow the topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).)
     */
    public List<SubscriptionFilterByComponent> getFilterBy() { 
      if (this.filterBy == null)
        this.filterBy = new ArrayList<SubscriptionFilterByComponent>();
      return this.filterBy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Subscription setFilterBy(List<SubscriptionFilterByComponent> theFilterBy) { 
      this.filterBy = theFilterBy;
      return this;
    }

    public boolean hasFilterBy() { 
      if (this.filterBy == null)
        return false;
      for (SubscriptionFilterByComponent item : this.filterBy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubscriptionFilterByComponent addFilterBy() { //3
      SubscriptionFilterByComponent t = new SubscriptionFilterByComponent();
      if (this.filterBy == null)
        this.filterBy = new ArrayList<SubscriptionFilterByComponent>();
      this.filterBy.add(t);
      return t;
    }

    public Subscription addFilterBy(SubscriptionFilterByComponent t) { //3
      if (t == null)
        return this;
      if (this.filterBy == null)
        this.filterBy = new ArrayList<SubscriptionFilterByComponent>();
      this.filterBy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #filterBy}, creating it if it does not already exist {3}
     */
    public SubscriptionFilterByComponent getFilterByFirstRep() { 
      if (getFilterBy().isEmpty()) {
        addFilterBy();
      }
      return getFilterBy().get(0);
    }

    /**
     * @return {@link #error} (A record of the last error that occurred when the server processed a notification.)
     */
    public List<CodeableConcept> getError() { 
      if (this.error == null)
        this.error = new ArrayList<CodeableConcept>();
      return this.error;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Subscription setError(List<CodeableConcept> theError) { 
      this.error = theError;
      return this;
    }

    public boolean hasError() { 
      if (this.error == null)
        return false;
      for (CodeableConcept item : this.error)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addError() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.error == null)
        this.error = new ArrayList<CodeableConcept>();
      this.error.add(t);
      return t;
    }

    public Subscription addError(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.error == null)
        this.error = new ArrayList<CodeableConcept>();
      this.error.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #error}, creating it if it does not already exist {3}
     */
    public CodeableConcept getErrorFirstRep() { 
      if (getError().isEmpty()) {
        addError();
      }
      return getError().get(0);
    }

    /**
     * @return {@link #eventCount} (A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an "active" or "error" state -- not "requested" or "off").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.). This is the underlying object with id, value and extensions. The accessor "getEventCount" gives direct access to the value
     */
    public UnsignedIntType getEventCountElement() { 
      if (this.eventCount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.eventCount");
        else if (Configuration.doAutoCreate())
          this.eventCount = new UnsignedIntType(); // bb
      return this.eventCount;
    }

    public boolean hasEventCountElement() { 
      return this.eventCount != null && !this.eventCount.isEmpty();
    }

    public boolean hasEventCount() { 
      return this.eventCount != null && !this.eventCount.isEmpty();
    }

    /**
     * @param value {@link #eventCount} (A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an "active" or "error" state -- not "requested" or "off").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.). This is the underlying object with id, value and extensions. The accessor "getEventCount" gives direct access to the value
     */
    public Subscription setEventCountElement(UnsignedIntType value) { 
      this.eventCount = value;
      return this;
    }

    /**
     * @return A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an "active" or "error" state -- not "requested" or "off").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.
     */
    public int getEventCount() { 
      return this.eventCount == null || this.eventCount.isEmpty() ? 0 : this.eventCount.getValue();
    }

    /**
     * @param value A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an "active" or "error" state -- not "requested" or "off").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.
     */
    public Subscription setEventCount(int value) { 
        if (this.eventCount == null)
          this.eventCount = new UnsignedIntType();
        this.eventCount.setValue(value);
      return this;
    }

    /**
     * @return {@link #channel} (Details where to send notifications when resources are received that meet the criteria.)
     */
    public SubscriptionChannelComponent getChannel() { 
      if (this.channel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.channel");
        else if (Configuration.doAutoCreate())
          this.channel = new SubscriptionChannelComponent(); // cc
      return this.channel;
    }

    public boolean hasChannel() { 
      return this.channel != null && !this.channel.isEmpty();
    }

    /**
     * @param value {@link #channel} (Details where to send notifications when resources are received that meet the criteria.)
     */
    public Subscription setChannel(SubscriptionChannelComponent value) { 
      this.channel = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("name", "string", "A natural language name identifying the subscription.", 0, 1, name));
        children.add(new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status));
        children.add(new Property("topic", "Reference(Topic)", "The reference to the topic to be notified about.", 0, 1, topic));
        children.add(new Property("contact", "ContactPoint", "Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("end", "instant", "The time for the server to turn the subscription off.", 0, 1, end));
        children.add(new Property("reason", "string", "A description of why this subscription is defined.", 0, 1, reason));
        children.add(new Property("filterBy", "", "The filter properties to be applied to narrow the topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).", 0, java.lang.Integer.MAX_VALUE, filterBy));
        children.add(new Property("error", "CodeableConcept", "A record of the last error that occurred when the server processed a notification.", 0, java.lang.Integer.MAX_VALUE, error));
        children.add(new Property("eventCount", "unsignedInt", "A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an \"active\" or \"error\" state -- not \"requested\" or \"off\").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.", 0, 1, eventCount));
        children.add(new Property("channel", "", "Details where to send notifications when resources are received that meet the criteria.", 0, 1, channel));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the subscription.", 0, 1, name);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status);
        case 110546223: /*topic*/  return new Property("topic", "Reference(Topic)", "The reference to the topic to be notified about.", 0, 1, topic);
        case 951526432: /*contact*/  return new Property("contact", "ContactPoint", "Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 100571: /*end*/  return new Property("end", "instant", "The time for the server to turn the subscription off.", 0, 1, end);
        case -934964668: /*reason*/  return new Property("reason", "string", "A description of why this subscription is defined.", 0, 1, reason);
        case -721168913: /*filterBy*/  return new Property("filterBy", "", "The filter properties to be applied to narrow the topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).", 0, java.lang.Integer.MAX_VALUE, filterBy);
        case 96784904: /*error*/  return new Property("error", "CodeableConcept", "A record of the last error that occurred when the server processed a notification.", 0, java.lang.Integer.MAX_VALUE, error);
        case 958365333: /*eventCount*/  return new Property("eventCount", "unsignedInt", "A record of  the number of events for which the server has attempted delivery on this subscription (i.e., the number of events that occurred while the subscription is in an \"active\" or \"error\" state -- not \"requested\" or \"off\").   Server Initializes to 0 for a new subscription.  Repeated attempts at delivery of the *same* event notification do not increment this counter.  Valid values are unsigned integers (0+).  The decmial type is used to ensure that counts can grow larger than 32-bit values.", 0, 1, eventCount);
        case 738950403: /*channel*/  return new Property("channel", "", "Details where to send notifications when resources are received that meet the criteria.", 0, 1, channel);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<SubscriptionStatus>
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : new Base[] {this.topic}; // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactPoint
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // InstantType
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // StringType
        case -721168913: /*filterBy*/ return this.filterBy == null ? new Base[0] : this.filterBy.toArray(new Base[this.filterBy.size()]); // SubscriptionFilterByComponent
        case 96784904: /*error*/ return this.error == null ? new Base[0] : this.error.toArray(new Base[this.error.size()]); // CodeableConcept
        case 958365333: /*eventCount*/ return this.eventCount == null ? new Base[0] : new Base[] {this.eventCount}; // UnsignedIntType
        case 738950403: /*channel*/ return this.channel == null ? new Base[0] : new Base[] {this.channel}; // SubscriptionChannelComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new SubscriptionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SubscriptionStatus>
          return value;
        case 110546223: // topic
          this.topic = TypeConvertor.castToReference(value); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case 100571: // end
          this.end = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case -934964668: // reason
          this.reason = TypeConvertor.castToString(value); // StringType
          return value;
        case -721168913: // filterBy
          this.getFilterBy().add((SubscriptionFilterByComponent) value); // SubscriptionFilterByComponent
          return value;
        case 96784904: // error
          this.getError().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 958365333: // eventCount
          this.eventCount = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 738950403: // channel
          this.channel = (SubscriptionChannelComponent) value; // SubscriptionChannelComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new SubscriptionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SubscriptionStatus>
        } else if (name.equals("topic")) {
          this.topic = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("filterBy")) {
          this.getFilterBy().add((SubscriptionFilterByComponent) value);
        } else if (name.equals("error")) {
          this.getError().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("eventCount")) {
          this.eventCount = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("channel")) {
          this.channel = (SubscriptionChannelComponent) value; // SubscriptionChannelComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3373707:  return getNameElement();
        case -892481550:  return getStatusElement();
        case 110546223:  return getTopic();
        case 951526432:  return addContact(); 
        case 100571:  return getEndElement();
        case -934964668:  return getReasonElement();
        case -721168913:  return addFilterBy(); 
        case 96784904:  return addError(); 
        case 958365333:  return getEventCountElement();
        case 738950403:  return getChannel();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 110546223: /*topic*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ContactPoint"};
        case 100571: /*end*/ return new String[] {"instant"};
        case -934964668: /*reason*/ return new String[] {"string"};
        case -721168913: /*filterBy*/ return new String[] {};
        case 96784904: /*error*/ return new String[] {"CodeableConcept"};
        case 958365333: /*eventCount*/ return new String[] {"unsignedInt"};
        case 738950403: /*channel*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.name");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.status");
        }
        else if (name.equals("topic")) {
          this.topic = new Reference();
          return this.topic;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.end");
        }
        else if (name.equals("reason")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.reason");
        }
        else if (name.equals("filterBy")) {
          return addFilterBy();
        }
        else if (name.equals("error")) {
          return addError();
        }
        else if (name.equals("eventCount")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.eventCount");
        }
        else if (name.equals("channel")) {
          this.channel = new SubscriptionChannelComponent();
          return this.channel;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Subscription";

  }

      public Subscription copy() {
        Subscription dst = new Subscription();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Subscription dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.status = status == null ? null : status.copy();
        dst.topic = topic == null ? null : topic.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactPoint>();
          for (ContactPoint i : contact)
            dst.contact.add(i.copy());
        };
        dst.end = end == null ? null : end.copy();
        dst.reason = reason == null ? null : reason.copy();
        if (filterBy != null) {
          dst.filterBy = new ArrayList<SubscriptionFilterByComponent>();
          for (SubscriptionFilterByComponent i : filterBy)
            dst.filterBy.add(i.copy());
        };
        if (error != null) {
          dst.error = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : error)
            dst.error.add(i.copy());
        };
        dst.eventCount = eventCount == null ? null : eventCount.copy();
        dst.channel = channel == null ? null : channel.copy();
      }

      protected Subscription typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Subscription))
          return false;
        Subscription o = (Subscription) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(name, o.name, true) && compareDeep(status, o.status, true)
           && compareDeep(topic, o.topic, true) && compareDeep(contact, o.contact, true) && compareDeep(end, o.end, true)
           && compareDeep(reason, o.reason, true) && compareDeep(filterBy, o.filterBy, true) && compareDeep(error, o.error, true)
           && compareDeep(eventCount, o.eventCount, true) && compareDeep(channel, o.channel, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Subscription))
          return false;
        Subscription o = (Subscription) other_;
        return compareValues(name, o.name, true) && compareValues(status, o.status, true) && compareValues(end, o.end, true)
           && compareValues(reason, o.reason, true) && compareValues(eventCount, o.eventCount, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, name, status
          , topic, contact, end, reason, filterBy, error, eventCount, channel);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Subscription;
   }

 /**
   * Search parameter: <b>contact</b>
   * <p>
   * Description: <b>Contact details for the subscription</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.contact</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contact", path="Subscription.contact", description="Contact details for the subscription", type="token" )
  public static final String SP_CONTACT = "contact";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contact</b>
   * <p>
   * Description: <b>Contact details for the subscription</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.contact</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTACT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTACT);

 /**
   * Search parameter: <b>payload</b>
   * <p>
   * Description: <b>The mime-type of the notification payload</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.channel.payload.contentType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="payload", path="Subscription.channel.payload.contentType", description="The mime-type of the notification payload", type="token" )
  public static final String SP_PAYLOAD = "payload";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>payload</b>
   * <p>
   * Description: <b>The mime-type of the notification payload</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.channel.payload.contentType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PAYLOAD = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PAYLOAD);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current state of the subscription</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Subscription.status", description="The current state of the subscription", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current state of the subscription</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The type of channel for the sent notifications</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.channel.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Subscription.channel.type", description="The type of channel for the sent notifications", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The type of channel for the sent notifications</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Subscription.channel.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that will receive the notifications</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Subscription.channel.endpoint</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="Subscription.channel.endpoint", description="The uri that will receive the notifications", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that will receive the notifications</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Subscription.channel.endpoint</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);


}

