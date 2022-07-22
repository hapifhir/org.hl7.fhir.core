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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR v5.0.0-snapshot2

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
 * The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.
 */
@ResourceDef(name="Subscription", profile="http://hl7.org/fhir/StructureDefinition/Subscription")
public class Subscription extends DomainResource {

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
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EMPTY: return "http://hl7.org/fhir/subscription-payload-content";
            case IDONLY: return "http://hl7.org/fhir/subscription-payload-content";
            case FULLRESOURCE: return "http://hl7.org/fhir/subscription-payload-content";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EMPTY: return "No resource content is transacted in the notification payload.";
            case IDONLY: return "Only the resource id is transacted in the notification payload.";
            case FULLRESOURCE: return "The entire resource is transacted in the notification payload.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EMPTY: return "empty";
            case IDONLY: return "id-only";
            case FULLRESOURCE: return "full-resource";
            case NULL: return null;
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

    @Block()
    public static class SubscriptionFilterByComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * If the element is a reference to another resource, this element contains "Reference", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).
         */
        @Child(name = "resourceType", type = {UriType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allowed Data type or Resource (reference to definition) for this Subscription", formalDefinition="If the element is a reference to another resource, this element contains \"Reference\", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/defined-types")
        protected UriType resourceType;

        /**
         * The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.
         */
        @Child(name = "filterParameter", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Filter label defined in SubscriptionTopic", formalDefinition="The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element." )
        protected StringType filterParameter;

        /**
         * Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.
         */
        @Child(name = "modifier", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="= | eq | ne | gt | lt | ge | le | sa | eb | ap | above | below | in | not-in | of-type", formalDefinition="Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-search-modifier")
        protected Enumeration<SubscriptionSearchModifier> modifier;

        /**
         * The literal value or resource path as is legal in search - for example, "Patient/123" or "le1950".
         */
        @Child(name = "value", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Literal value or resource path", formalDefinition="The literal value or resource path as is legal in search - for example, \"Patient/123\" or \"le1950\"." )
        protected StringType value;

        private static final long serialVersionUID = -642146252L;

    /**
     * Constructor
     */
      public SubscriptionFilterByComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionFilterByComponent(String filterParameter, String value) {
        super();
        this.setFilterParameter(filterParameter);
        this.setValue(value);
      }

        /**
         * @return {@link #resourceType} (If the element is a reference to another resource, this element contains "Reference", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).). This is the underlying object with id, value and extensions. The accessor "getResourceType" gives direct access to the value
         */
        public UriType getResourceTypeElement() { 
          if (this.resourceType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionFilterByComponent.resourceType");
            else if (Configuration.doAutoCreate())
              this.resourceType = new UriType(); // bb
          return this.resourceType;
        }

        public boolean hasResourceTypeElement() { 
          return this.resourceType != null && !this.resourceType.isEmpty();
        }

        public boolean hasResourceType() { 
          return this.resourceType != null && !this.resourceType.isEmpty();
        }

        /**
         * @param value {@link #resourceType} (If the element is a reference to another resource, this element contains "Reference", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).). This is the underlying object with id, value and extensions. The accessor "getResourceType" gives direct access to the value
         */
        public SubscriptionFilterByComponent setResourceTypeElement(UriType value) { 
          this.resourceType = value;
          return this;
        }

        /**
         * @return If the element is a reference to another resource, this element contains "Reference", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).
         */
        public String getResourceType() { 
          return this.resourceType == null ? null : this.resourceType.getValue();
        }

        /**
         * @param value If the element is a reference to another resource, this element contains "Reference", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).
         */
        public SubscriptionFilterByComponent setResourceType(String value) { 
          if (Utilities.noString(value))
            this.resourceType = null;
          else {
            if (this.resourceType == null)
              this.resourceType = new UriType();
            this.resourceType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #filterParameter} (The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.). This is the underlying object with id, value and extensions. The accessor "getFilterParameter" gives direct access to the value
         */
        public StringType getFilterParameterElement() { 
          if (this.filterParameter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionFilterByComponent.filterParameter");
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
         * @param value {@link #filterParameter} (The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.). This is the underlying object with id, value and extensions. The accessor "getFilterParameter" gives direct access to the value
         */
        public SubscriptionFilterByComponent setFilterParameterElement(StringType value) { 
          this.filterParameter = value;
          return this;
        }

        /**
         * @return The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.
         */
        public String getFilterParameter() { 
          return this.filterParameter == null ? null : this.filterParameter.getValue();
        }

        /**
         * @param value The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.
         */
        public SubscriptionFilterByComponent setFilterParameter(String value) { 
            if (this.filterParameter == null)
              this.filterParameter = new StringType();
            this.filterParameter.setValue(value);
          return this;
        }

        /**
         * @return {@link #modifier} (Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.). This is the underlying object with id, value and extensions. The accessor "getModifier" gives direct access to the value
         */
        public Enumeration<SubscriptionSearchModifier> getModifierElement() { 
          if (this.modifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionFilterByComponent.modifier");
            else if (Configuration.doAutoCreate())
              this.modifier = new Enumeration<SubscriptionSearchModifier>(new SubscriptionSearchModifierEnumFactory()); // bb
          return this.modifier;
        }

        public boolean hasModifierElement() { 
          return this.modifier != null && !this.modifier.isEmpty();
        }

        public boolean hasModifier() { 
          return this.modifier != null && !this.modifier.isEmpty();
        }

        /**
         * @param value {@link #modifier} (Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.). This is the underlying object with id, value and extensions. The accessor "getModifier" gives direct access to the value
         */
        public SubscriptionFilterByComponent setModifierElement(Enumeration<SubscriptionSearchModifier> value) { 
          this.modifier = value;
          return this;
        }

        /**
         * @return Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.
         */
        public SubscriptionSearchModifier getModifier() { 
          return this.modifier == null ? null : this.modifier.getValue();
        }

        /**
         * @param value Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.
         */
        public SubscriptionFilterByComponent setModifier(SubscriptionSearchModifier value) { 
          if (value == null)
            this.modifier = null;
          else {
            if (this.modifier == null)
              this.modifier = new Enumeration<SubscriptionSearchModifier>(new SubscriptionSearchModifierEnumFactory());
            this.modifier.setValue(value);
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
          children.add(new Property("resourceType", "uri", "If the element is a reference to another resource, this element contains \"Reference\", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).", 0, 1, resourceType));
          children.add(new Property("filterParameter", "string", "The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.", 0, 1, filterParameter));
          children.add(new Property("modifier", "code", "Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.", 0, 1, modifier));
          children.add(new Property("value", "string", "The literal value or resource path as is legal in search - for example, \"Patient/123\" or \"le1950\".", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -384364440: /*resourceType*/  return new Property("resourceType", "uri", "If the element is a reference to another resource, this element contains \"Reference\", and the targetProfile element defines what resources can be referenced. The targetProfile may be a reference to the general definition of a resource (e.g. http://hl7.org/fhir/StructureDefinition/Patient).", 0, 1, resourceType);
          case 618257: /*filterParameter*/  return new Property("filterParameter", "string", "The filter label (=key) as defined in the `SubscriptionTopic.canfilterBy.filterParameter`  element.", 0, 1, filterParameter);
          case -615513385: /*modifier*/  return new Property("modifier", "code", "Operator to apply when determining matches (Search Modifiers), from the list of allowed modifiers for this filter in the relevant SubscriptionTopic.", 0, 1, modifier);
          case 111972721: /*value*/  return new Property("value", "string", "The literal value or resource path as is legal in search - for example, \"Patient/123\" or \"le1950\".", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -384364440: /*resourceType*/ return this.resourceType == null ? new Base[0] : new Base[] {this.resourceType}; // UriType
        case 618257: /*filterParameter*/ return this.filterParameter == null ? new Base[0] : new Base[] {this.filterParameter}; // StringType
        case -615513385: /*modifier*/ return this.modifier == null ? new Base[0] : new Base[] {this.modifier}; // Enumeration<SubscriptionSearchModifier>
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -384364440: // resourceType
          this.resourceType = TypeConvertor.castToUri(value); // UriType
          return value;
        case 618257: // filterParameter
          this.filterParameter = TypeConvertor.castToString(value); // StringType
          return value;
        case -615513385: // modifier
          value = new SubscriptionSearchModifierEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.modifier = (Enumeration) value; // Enumeration<SubscriptionSearchModifier>
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("resourceType")) {
          this.resourceType = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("filterParameter")) {
          this.filterParameter = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("modifier")) {
          value = new SubscriptionSearchModifierEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.modifier = (Enumeration) value; // Enumeration<SubscriptionSearchModifier>
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -384364440:  return getResourceTypeElement();
        case 618257:  return getFilterParameterElement();
        case -615513385:  return getModifierElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -384364440: /*resourceType*/ return new String[] {"uri"};
        case 618257: /*filterParameter*/ return new String[] {"string"};
        case -615513385: /*modifier*/ return new String[] {"code"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("resourceType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.filterBy.resourceType");
        }
        else if (name.equals("filterParameter")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.filterBy.filterParameter");
        }
        else if (name.equals("modifier")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.filterBy.modifier");
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
        dst.resourceType = resourceType == null ? null : resourceType.copy();
        dst.filterParameter = filterParameter == null ? null : filterParameter.copy();
        dst.modifier = modifier == null ? null : modifier.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionFilterByComponent))
          return false;
        SubscriptionFilterByComponent o = (SubscriptionFilterByComponent) other_;
        return compareDeep(resourceType, o.resourceType, true) && compareDeep(filterParameter, o.filterParameter, true)
           && compareDeep(modifier, o.modifier, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionFilterByComponent))
          return false;
        SubscriptionFilterByComponent o = (SubscriptionFilterByComponent) other_;
        return compareValues(resourceType, o.resourceType, true) && compareValues(filterParameter, o.filterParameter, true)
           && compareValues(modifier, o.modifier, true) && compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(resourceType, filterParameter
          , modifier, value);
      }

  public String fhirType() {
    return "Subscription.filterBy";

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
    @Description(shortDefinition="requested | active | error | off | entered-in-error", formalDefinition="The status of the subscription, which marks the server state for managing the subscription." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-status")
    protected Enumeration<SubscriptionStatusCodes> status;

    /**
     * The reference to the subscription topic to be notified about.
     */
    @Child(name = "topic", type = {CanonicalType.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the subscription topic being subscribed to", formalDefinition="The reference to the subscription topic to be notified about." )
    protected CanonicalType topic;

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
     * The filter properties to be applied to narrow the subscription topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).
     */
    @Child(name = "filterBy", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Criteria for narrowing the subscription topic stream", formalDefinition="The filter properties to be applied to narrow the subscription topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND)." )
    protected List<SubscriptionFilterByComponent> filterBy;

    /**
     * The type of channel to send notifications on.
     */
    @Child(name = "channelType", type = {Coding.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Channel type for notifications", formalDefinition="The type of channel to send notifications on." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-channel-type")
    protected Coding channelType;

    /**
     * The url that describes the actual end-point to send messages to.
     */
    @Child(name = "endpoint", type = {UrlType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where the channel points to", formalDefinition="The url that describes the actual end-point to send messages to." )
    protected UrlType endpoint;

    /**
     * Additional headers / information to send as part of the notification.
     */
    @Child(name = "header", type = {StringType.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Usage depends on the channel type", formalDefinition="Additional headers / information to send as part of the notification." )
    protected List<StringType> header;

    /**
     * If present,  a 'hearbeat" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.
     */
    @Child(name = "heartbeatPeriod", type = {UnsignedIntType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Interval in seconds to send 'heartbeat' notification", formalDefinition="If present,  a 'hearbeat\" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent." )
    protected UnsignedIntType heartbeatPeriod;

    /**
     * If present, the maximum amount of time a server will allow before failing a notification attempt.
     */
    @Child(name = "timeout", type = {UnsignedIntType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Timeout in seconds to attempt notification delivery", formalDefinition="If present, the maximum amount of time a server will allow before failing a notification attempt." )
    protected UnsignedIntType timeout;

    /**
     * The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.
     */
    @Child(name = "contentType", type = {CodeType.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="MIME type to send, or omit for no payload", formalDefinition="The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types \"text/plain\" and \"text/html\" may also be used for Email subscriptions." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected CodeType contentType;

    /**
     * How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.
     */
    @Child(name = "content", type = {CodeType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="empty | id-only | full-resource", formalDefinition="How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-payload-content")
    protected Enumeration<SubscriptionPayloadContent> content;

    /**
     * If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.
     */
    @Child(name = "maxCount", type = {PositiveIntType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Maximum number of triggering resources included in notification bundles", formalDefinition="If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included." )
    protected PositiveIntType maxCount;

    private static final long serialVersionUID = -881003340L;

  /**
   * Constructor
   */
    public Subscription() {
      super();
    }

  /**
   * Constructor
   */
    public Subscription(SubscriptionStatusCodes status, String topic, Coding channelType) {
      super();
      this.setStatus(status);
      this.setTopic(topic);
      this.setChannelType(channelType);
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
    public Enumeration<SubscriptionStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<SubscriptionStatusCodes>(new SubscriptionStatusCodesEnumFactory()); // bb
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
    public Subscription setStatusElement(Enumeration<SubscriptionStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the subscription, which marks the server state for managing the subscription.
     */
    public SubscriptionStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the subscription, which marks the server state for managing the subscription.
     */
    public Subscription setStatus(SubscriptionStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<SubscriptionStatusCodes>(new SubscriptionStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #topic} (The reference to the subscription topic to be notified about.). This is the underlying object with id, value and extensions. The accessor "getTopic" gives direct access to the value
     */
    public CanonicalType getTopicElement() { 
      if (this.topic == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.topic");
        else if (Configuration.doAutoCreate())
          this.topic = new CanonicalType(); // bb
      return this.topic;
    }

    public boolean hasTopicElement() { 
      return this.topic != null && !this.topic.isEmpty();
    }

    public boolean hasTopic() { 
      return this.topic != null && !this.topic.isEmpty();
    }

    /**
     * @param value {@link #topic} (The reference to the subscription topic to be notified about.). This is the underlying object with id, value and extensions. The accessor "getTopic" gives direct access to the value
     */
    public Subscription setTopicElement(CanonicalType value) { 
      this.topic = value;
      return this;
    }

    /**
     * @return The reference to the subscription topic to be notified about.
     */
    public String getTopic() { 
      return this.topic == null ? null : this.topic.getValue();
    }

    /**
     * @param value The reference to the subscription topic to be notified about.
     */
    public Subscription setTopic(String value) { 
        if (this.topic == null)
          this.topic = new CanonicalType();
        this.topic.setValue(value);
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
     * @return {@link #filterBy} (The filter properties to be applied to narrow the subscription topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).)
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
     * @return {@link #channelType} (The type of channel to send notifications on.)
     */
    public Coding getChannelType() { 
      if (this.channelType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.channelType");
        else if (Configuration.doAutoCreate())
          this.channelType = new Coding(); // cc
      return this.channelType;
    }

    public boolean hasChannelType() { 
      return this.channelType != null && !this.channelType.isEmpty();
    }

    /**
     * @param value {@link #channelType} (The type of channel to send notifications on.)
     */
    public Subscription setChannelType(Coding value) { 
      this.channelType = value;
      return this;
    }

    /**
     * @return {@link #endpoint} (The url that describes the actual end-point to send messages to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
     */
    public UrlType getEndpointElement() { 
      if (this.endpoint == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.endpoint");
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
    public Subscription setEndpointElement(UrlType value) { 
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
    public Subscription setEndpoint(String value) { 
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
    public Subscription setHeader(List<StringType> theHeader) { 
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
    public Subscription addHeader(String value) { //1
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
          throw new Error("Attempt to auto-create Subscription.heartbeatPeriod");
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
    public Subscription setHeartbeatPeriodElement(UnsignedIntType value) { 
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
    public Subscription setHeartbeatPeriod(int value) { 
        if (this.heartbeatPeriod == null)
          this.heartbeatPeriod = new UnsignedIntType();
        this.heartbeatPeriod.setValue(value);
      return this;
    }

    /**
     * @return {@link #timeout} (If present, the maximum amount of time a server will allow before failing a notification attempt.). This is the underlying object with id, value and extensions. The accessor "getTimeout" gives direct access to the value
     */
    public UnsignedIntType getTimeoutElement() { 
      if (this.timeout == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.timeout");
        else if (Configuration.doAutoCreate())
          this.timeout = new UnsignedIntType(); // bb
      return this.timeout;
    }

    public boolean hasTimeoutElement() { 
      return this.timeout != null && !this.timeout.isEmpty();
    }

    public boolean hasTimeout() { 
      return this.timeout != null && !this.timeout.isEmpty();
    }

    /**
     * @param value {@link #timeout} (If present, the maximum amount of time a server will allow before failing a notification attempt.). This is the underlying object with id, value and extensions. The accessor "getTimeout" gives direct access to the value
     */
    public Subscription setTimeoutElement(UnsignedIntType value) { 
      this.timeout = value;
      return this;
    }

    /**
     * @return If present, the maximum amount of time a server will allow before failing a notification attempt.
     */
    public int getTimeout() { 
      return this.timeout == null || this.timeout.isEmpty() ? 0 : this.timeout.getValue();
    }

    /**
     * @param value If present, the maximum amount of time a server will allow before failing a notification attempt.
     */
    public Subscription setTimeout(int value) { 
        if (this.timeout == null)
          this.timeout = new UnsignedIntType();
        this.timeout.setValue(value);
      return this;
    }

    /**
     * @return {@link #contentType} (The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types "text/plain" and "text/html" may also be used for Email subscriptions.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
     */
    public CodeType getContentTypeElement() { 
      if (this.contentType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.contentType");
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
    public Subscription setContentTypeElement(CodeType value) { 
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
    public Subscription setContentType(String value) { 
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
          throw new Error("Attempt to auto-create Subscription.content");
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
    public Subscription setContentElement(Enumeration<SubscriptionPayloadContent> value) { 
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
    public Subscription setContent(SubscriptionPayloadContent value) { 
      if (value == null)
        this.content = null;
      else {
        if (this.content == null)
          this.content = new Enumeration<SubscriptionPayloadContent>(new SubscriptionPayloadContentEnumFactory());
        this.content.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #maxCount} (If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.). This is the underlying object with id, value and extensions. The accessor "getMaxCount" gives direct access to the value
     */
    public PositiveIntType getMaxCountElement() { 
      if (this.maxCount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Subscription.maxCount");
        else if (Configuration.doAutoCreate())
          this.maxCount = new PositiveIntType(); // bb
      return this.maxCount;
    }

    public boolean hasMaxCountElement() { 
      return this.maxCount != null && !this.maxCount.isEmpty();
    }

    public boolean hasMaxCount() { 
      return this.maxCount != null && !this.maxCount.isEmpty();
    }

    /**
     * @param value {@link #maxCount} (If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.). This is the underlying object with id, value and extensions. The accessor "getMaxCount" gives direct access to the value
     */
    public Subscription setMaxCountElement(PositiveIntType value) { 
      this.maxCount = value;
      return this;
    }

    /**
     * @return If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.
     */
    public int getMaxCount() { 
      return this.maxCount == null || this.maxCount.isEmpty() ? 0 : this.maxCount.getValue();
    }

    /**
     * @param value If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.
     */
    public Subscription setMaxCount(int value) { 
        if (this.maxCount == null)
          this.maxCount = new PositiveIntType();
        this.maxCount.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("name", "string", "A natural language name identifying the subscription.", 0, 1, name));
        children.add(new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status));
        children.add(new Property("topic", "canonical(SubscriptionTopic)", "The reference to the subscription topic to be notified about.", 0, 1, topic));
        children.add(new Property("contact", "ContactPoint", "Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("end", "instant", "The time for the server to turn the subscription off.", 0, 1, end));
        children.add(new Property("reason", "string", "A description of why this subscription is defined.", 0, 1, reason));
        children.add(new Property("filterBy", "", "The filter properties to be applied to narrow the subscription topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).", 0, java.lang.Integer.MAX_VALUE, filterBy));
        children.add(new Property("channelType", "Coding", "The type of channel to send notifications on.", 0, 1, channelType));
        children.add(new Property("endpoint", "url", "The url that describes the actual end-point to send messages to.", 0, 1, endpoint));
        children.add(new Property("header", "string", "Additional headers / information to send as part of the notification.", 0, java.lang.Integer.MAX_VALUE, header));
        children.add(new Property("heartbeatPeriod", "unsignedInt", "If present,  a 'hearbeat\" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.", 0, 1, heartbeatPeriod));
        children.add(new Property("timeout", "unsignedInt", "If present, the maximum amount of time a server will allow before failing a notification attempt.", 0, 1, timeout));
        children.add(new Property("contentType", "code", "The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types \"text/plain\" and \"text/html\" may also be used for Email subscriptions.", 0, 1, contentType));
        children.add(new Property("content", "code", "How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.", 0, 1, content));
        children.add(new Property("maxCount", "positiveInt", "If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.", 0, 1, maxCount));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this code system when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the subscription.", 0, 1, name);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status);
        case 110546223: /*topic*/  return new Property("topic", "canonical(SubscriptionTopic)", "The reference to the subscription topic to be notified about.", 0, 1, topic);
        case 951526432: /*contact*/  return new Property("contact", "ContactPoint", "Contact details for a human to contact about the subscription. The primary use of this for system administrator troubleshooting.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 100571: /*end*/  return new Property("end", "instant", "The time for the server to turn the subscription off.", 0, 1, end);
        case -934964668: /*reason*/  return new Property("reason", "string", "A description of why this subscription is defined.", 0, 1, reason);
        case -721168913: /*filterBy*/  return new Property("filterBy", "", "The filter properties to be applied to narrow the subscription topic stream.  When multiple filters are applied, evaluates to true if all the conditions are met; otherwise it returns false.   (i.e., logical AND).", 0, java.lang.Integer.MAX_VALUE, filterBy);
        case 274155229: /*channelType*/  return new Property("channelType", "Coding", "The type of channel to send notifications on.", 0, 1, channelType);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "url", "The url that describes the actual end-point to send messages to.", 0, 1, endpoint);
        case -1221270899: /*header*/  return new Property("header", "string", "Additional headers / information to send as part of the notification.", 0, java.lang.Integer.MAX_VALUE, header);
        case -938465827: /*heartbeatPeriod*/  return new Property("heartbeatPeriod", "unsignedInt", "If present,  a 'hearbeat\" notification (keepalive) is sent via this channel with an the interval period equal to this elements integer value in seconds.    If not present, a heartbeat notification is not sent.", 0, 1, heartbeatPeriod);
        case -1313911455: /*timeout*/  return new Property("timeout", "unsignedInt", "If present, the maximum amount of time a server will allow before failing a notification attempt.", 0, 1, timeout);
        case -389131437: /*contentType*/  return new Property("contentType", "code", "The mime type to send the payload in - either application/fhir+xml, or application/fhir+json. The MIME types \"text/plain\" and \"text/html\" may also be used for Email subscriptions.", 0, 1, contentType);
        case 951530617: /*content*/  return new Property("content", "code", "How much of the resource content to deliver in the notification payload. The choices are an empty payload, only the resource id, or the full resource content.", 0, 1, content);
        case 382106123: /*maxCount*/  return new Property("maxCount", "positiveInt", "If present, the maximum number of triggering resources that will be included in a notification bundle (e.g., a server will not include more than this number of trigger resources in a single notification).  Note that this is not a strict limit on the number of entries in a bundle, as dependent resources can be included.", 0, 1, maxCount);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<SubscriptionStatusCodes>
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : new Base[] {this.topic}; // CanonicalType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactPoint
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // InstantType
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // StringType
        case -721168913: /*filterBy*/ return this.filterBy == null ? new Base[0] : this.filterBy.toArray(new Base[this.filterBy.size()]); // SubscriptionFilterByComponent
        case 274155229: /*channelType*/ return this.channelType == null ? new Base[0] : new Base[] {this.channelType}; // Coding
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : new Base[] {this.endpoint}; // UrlType
        case -1221270899: /*header*/ return this.header == null ? new Base[0] : this.header.toArray(new Base[this.header.size()]); // StringType
        case -938465827: /*heartbeatPeriod*/ return this.heartbeatPeriod == null ? new Base[0] : new Base[] {this.heartbeatPeriod}; // UnsignedIntType
        case -1313911455: /*timeout*/ return this.timeout == null ? new Base[0] : new Base[] {this.timeout}; // UnsignedIntType
        case -389131437: /*contentType*/ return this.contentType == null ? new Base[0] : new Base[] {this.contentType}; // CodeType
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // Enumeration<SubscriptionPayloadContent>
        case 382106123: /*maxCount*/ return this.maxCount == null ? new Base[0] : new Base[] {this.maxCount}; // PositiveIntType
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
          value = new SubscriptionStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SubscriptionStatusCodes>
          return value;
        case 110546223: // topic
          this.topic = TypeConvertor.castToCanonical(value); // CanonicalType
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
        case 274155229: // channelType
          this.channelType = TypeConvertor.castToCoding(value); // Coding
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
        case -1313911455: // timeout
          this.timeout = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -389131437: // contentType
          this.contentType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 951530617: // content
          value = new SubscriptionPayloadContentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.content = (Enumeration) value; // Enumeration<SubscriptionPayloadContent>
          return value;
        case 382106123: // maxCount
          this.maxCount = TypeConvertor.castToPositiveInt(value); // PositiveIntType
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
          value = new SubscriptionStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SubscriptionStatusCodes>
        } else if (name.equals("topic")) {
          this.topic = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("filterBy")) {
          this.getFilterBy().add((SubscriptionFilterByComponent) value);
        } else if (name.equals("channelType")) {
          this.channelType = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("endpoint")) {
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("header")) {
          this.getHeader().add(TypeConvertor.castToString(value));
        } else if (name.equals("heartbeatPeriod")) {
          this.heartbeatPeriod = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("timeout")) {
          this.timeout = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("contentType")) {
          this.contentType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("content")) {
          value = new SubscriptionPayloadContentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.content = (Enumeration) value; // Enumeration<SubscriptionPayloadContent>
        } else if (name.equals("maxCount")) {
          this.maxCount = TypeConvertor.castToPositiveInt(value); // PositiveIntType
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
        case 110546223:  return getTopicElement();
        case 951526432:  return addContact(); 
        case 100571:  return getEndElement();
        case -934964668:  return getReasonElement();
        case -721168913:  return addFilterBy(); 
        case 274155229:  return getChannelType();
        case 1741102485:  return getEndpointElement();
        case -1221270899:  return addHeaderElement();
        case -938465827:  return getHeartbeatPeriodElement();
        case -1313911455:  return getTimeoutElement();
        case -389131437:  return getContentTypeElement();
        case 951530617:  return getContentElement();
        case 382106123:  return getMaxCountElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 110546223: /*topic*/ return new String[] {"canonical"};
        case 951526432: /*contact*/ return new String[] {"ContactPoint"};
        case 100571: /*end*/ return new String[] {"instant"};
        case -934964668: /*reason*/ return new String[] {"string"};
        case -721168913: /*filterBy*/ return new String[] {};
        case 274155229: /*channelType*/ return new String[] {"Coding"};
        case 1741102485: /*endpoint*/ return new String[] {"url"};
        case -1221270899: /*header*/ return new String[] {"string"};
        case -938465827: /*heartbeatPeriod*/ return new String[] {"unsignedInt"};
        case -1313911455: /*timeout*/ return new String[] {"unsignedInt"};
        case -389131437: /*contentType*/ return new String[] {"code"};
        case 951530617: /*content*/ return new String[] {"code"};
        case 382106123: /*maxCount*/ return new String[] {"positiveInt"};
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
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.topic");
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
        else if (name.equals("channelType")) {
          this.channelType = new Coding();
          return this.channelType;
        }
        else if (name.equals("endpoint")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.endpoint");
        }
        else if (name.equals("header")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.header");
        }
        else if (name.equals("heartbeatPeriod")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.heartbeatPeriod");
        }
        else if (name.equals("timeout")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.timeout");
        }
        else if (name.equals("contentType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.contentType");
        }
        else if (name.equals("content")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.content");
        }
        else if (name.equals("maxCount")) {
          throw new FHIRException("Cannot call addChild on a primitive type Subscription.maxCount");
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
        dst.channelType = channelType == null ? null : channelType.copy();
        dst.endpoint = endpoint == null ? null : endpoint.copy();
        if (header != null) {
          dst.header = new ArrayList<StringType>();
          for (StringType i : header)
            dst.header.add(i.copy());
        };
        dst.heartbeatPeriod = heartbeatPeriod == null ? null : heartbeatPeriod.copy();
        dst.timeout = timeout == null ? null : timeout.copy();
        dst.contentType = contentType == null ? null : contentType.copy();
        dst.content = content == null ? null : content.copy();
        dst.maxCount = maxCount == null ? null : maxCount.copy();
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
           && compareDeep(reason, o.reason, true) && compareDeep(filterBy, o.filterBy, true) && compareDeep(channelType, o.channelType, true)
           && compareDeep(endpoint, o.endpoint, true) && compareDeep(header, o.header, true) && compareDeep(heartbeatPeriod, o.heartbeatPeriod, true)
           && compareDeep(timeout, o.timeout, true) && compareDeep(contentType, o.contentType, true) && compareDeep(content, o.content, true)
           && compareDeep(maxCount, o.maxCount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Subscription))
          return false;
        Subscription o = (Subscription) other_;
        return compareValues(name, o.name, true) && compareValues(status, o.status, true) && compareValues(topic, o.topic, true)
           && compareValues(end, o.end, true) && compareValues(reason, o.reason, true) && compareValues(endpoint, o.endpoint, true)
           && compareValues(header, o.header, true) && compareValues(heartbeatPeriod, o.heartbeatPeriod, true)
           && compareValues(timeout, o.timeout, true) && compareValues(contentType, o.contentType, true) && compareValues(content, o.content, true)
           && compareValues(maxCount, o.maxCount, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, name, status
          , topic, contact, end, reason, filterBy, channelType, endpoint, header, heartbeatPeriod
          , timeout, contentType, content, maxCount);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Subscription;
   }


}

