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
 * Example of workflow instance.
 */
@ResourceDef(name="ExampleScenario", profile="http://hl7.org/fhir/StructureDefinition/ExampleScenario")
public class ExampleScenario extends CanonicalResource {

    public enum ExampleScenarioActorType {
        /**
         * A person.
         */
        PERSON, 
        /**
         * A system.
         */
        ENTITY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ExampleScenarioActorType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return PERSON;
        if ("entity".equals(codeString))
          return ENTITY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ExampleScenarioActorType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PERSON: return "person";
            case ENTITY: return "entity";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PERSON: return "http://hl7.org/fhir/examplescenario-actor-type";
            case ENTITY: return "http://hl7.org/fhir/examplescenario-actor-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PERSON: return "A person.";
            case ENTITY: return "A system.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PERSON: return "Person";
            case ENTITY: return "System";
            default: return "?";
          }
        }
    }

  public static class ExampleScenarioActorTypeEnumFactory implements EnumFactory<ExampleScenarioActorType> {
    public ExampleScenarioActorType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return ExampleScenarioActorType.PERSON;
        if ("entity".equals(codeString))
          return ExampleScenarioActorType.ENTITY;
        throw new IllegalArgumentException("Unknown ExampleScenarioActorType code '"+codeString+"'");
        }
        public Enumeration<ExampleScenarioActorType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ExampleScenarioActorType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("person".equals(codeString))
          return new Enumeration<ExampleScenarioActorType>(this, ExampleScenarioActorType.PERSON);
        if ("entity".equals(codeString))
          return new Enumeration<ExampleScenarioActorType>(this, ExampleScenarioActorType.ENTITY);
        throw new FHIRException("Unknown ExampleScenarioActorType code '"+codeString+"'");
        }
    public String toCode(ExampleScenarioActorType code) {
      if (code == ExampleScenarioActorType.PERSON)
        return "person";
      if (code == ExampleScenarioActorType.ENTITY)
        return "entity";
      return "?";
      }
    public String toSystem(ExampleScenarioActorType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ExampleScenarioActorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * ID or acronym of actor.
         */
        @Child(name = "actorId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ID or acronym of the actor", formalDefinition="ID or acronym of actor." )
        protected StringType actorId;

        /**
         * The type of actor - person or system.
         */
        @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="person | entity", formalDefinition="The type of actor - person or system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/examplescenario-actor-type")
        protected Enumeration<ExampleScenarioActorType> type;

        /**
         * The name of the actor as shown in the page.
         */
        @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The name of the actor as shown in the page", formalDefinition="The name of the actor as shown in the page." )
        protected StringType name;

        /**
         * The description of the actor.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The description of the actor", formalDefinition="The description of the actor." )
        protected MarkdownType description;

        private static final long serialVersionUID = 1348364162L;

    /**
     * Constructor
     */
      public ExampleScenarioActorComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioActorComponent(String actorId, ExampleScenarioActorType type) {
        super();
        this.setActorId(actorId);
        this.setType(type);
      }

        /**
         * @return {@link #actorId} (ID or acronym of actor.). This is the underlying object with id, value and extensions. The accessor "getActorId" gives direct access to the value
         */
        public StringType getActorIdElement() { 
          if (this.actorId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioActorComponent.actorId");
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
         * @param value {@link #actorId} (ID or acronym of actor.). This is the underlying object with id, value and extensions. The accessor "getActorId" gives direct access to the value
         */
        public ExampleScenarioActorComponent setActorIdElement(StringType value) { 
          this.actorId = value;
          return this;
        }

        /**
         * @return ID or acronym of actor.
         */
        public String getActorId() { 
          return this.actorId == null ? null : this.actorId.getValue();
        }

        /**
         * @param value ID or acronym of actor.
         */
        public ExampleScenarioActorComponent setActorId(String value) { 
            if (this.actorId == null)
              this.actorId = new StringType();
            this.actorId.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (The type of actor - person or system.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ExampleScenarioActorType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioActorComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ExampleScenarioActorType>(new ExampleScenarioActorTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of actor - person or system.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ExampleScenarioActorComponent setTypeElement(Enumeration<ExampleScenarioActorType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of actor - person or system.
         */
        public ExampleScenarioActorType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of actor - person or system.
         */
        public ExampleScenarioActorComponent setType(ExampleScenarioActorType value) { 
            if (this.type == null)
              this.type = new Enumeration<ExampleScenarioActorType>(new ExampleScenarioActorTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #name} (The name of the actor as shown in the page.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioActorComponent.name");
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
         * @param value {@link #name} (The name of the actor as shown in the page.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ExampleScenarioActorComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of the actor as shown in the page.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of the actor as shown in the page.
         */
        public ExampleScenarioActorComponent setName(String value) { 
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
         * @return {@link #description} (The description of the actor.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioActorComponent.description");
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
         * @param value {@link #description} (The description of the actor.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioActorComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The description of the actor.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The description of the actor.
         */
        public ExampleScenarioActorComponent setDescription(String value) { 
          if (value == null)
            this.description = null;
          else {
            if (this.description == null)
              this.description = new MarkdownType();
            this.description.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("actorId", "string", "ID or acronym of actor.", 0, 1, actorId));
          children.add(new Property("type", "code", "The type of actor - person or system.", 0, 1, type));
          children.add(new Property("name", "string", "The name of the actor as shown in the page.", 0, 1, name));
          children.add(new Property("description", "markdown", "The description of the actor.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1161623056: /*actorId*/  return new Property("actorId", "string", "ID or acronym of actor.", 0, 1, actorId);
          case 3575610: /*type*/  return new Property("type", "code", "The type of actor - person or system.", 0, 1, type);
          case 3373707: /*name*/  return new Property("name", "string", "The name of the actor as shown in the page.", 0, 1, name);
          case -1724546052: /*description*/  return new Property("description", "markdown", "The description of the actor.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1161623056: /*actorId*/ return this.actorId == null ? new Base[0] : new Base[] {this.actorId}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ExampleScenarioActorType>
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
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
          value = new ExampleScenarioActorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ExampleScenarioActorType>
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("actorId")) {
          this.actorId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new ExampleScenarioActorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ExampleScenarioActorType>
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1161623056:  return getActorIdElement();
        case 3575610:  return getTypeElement();
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1161623056: /*actorId*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("actorId")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.actor.actorId");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.actor.type");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.actor.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.actor.description");
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioActorComponent copy() {
        ExampleScenarioActorComponent dst = new ExampleScenarioActorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioActorComponent dst) {
        super.copyValues(dst);
        dst.actorId = actorId == null ? null : actorId.copy();
        dst.type = type == null ? null : type.copy();
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioActorComponent))
          return false;
        ExampleScenarioActorComponent o = (ExampleScenarioActorComponent) other_;
        return compareDeep(actorId, o.actorId, true) && compareDeep(type, o.type, true) && compareDeep(name, o.name, true)
           && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioActorComponent))
          return false;
        ExampleScenarioActorComponent o = (ExampleScenarioActorComponent) other_;
        return compareValues(actorId, o.actorId, true) && compareValues(type, o.type, true) && compareValues(name, o.name, true)
           && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(actorId, type, name, description
          );
      }

  public String fhirType() {
    return "ExampleScenario.actor";

  }

  }

    @Block()
    public static class ExampleScenarioInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The id of the resource for referencing.
         */
        @Child(name = "resourceId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The id of the resource for referencing", formalDefinition="The id of the resource for referencing." )
        protected StringType resourceId;

        /**
         * The type of the resource.
         */
        @Child(name = "resourceType", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of the resource", formalDefinition="The type of the resource." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
        protected CodeType resourceType;

        /**
         * A short name for the resource instance.
         */
        @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A short name for the resource instance", formalDefinition="A short name for the resource instance." )
        protected StringType name;

        /**
         * Human-friendly description of the resource instance.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-friendly description of the resource instance", formalDefinition="Human-friendly description of the resource instance." )
        protected MarkdownType description;

        /**
         * A specific version of the resource.
         */
        @Child(name = "version", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A specific version of the resource", formalDefinition="A specific version of the resource." )
        protected List<ExampleScenarioInstanceVersionComponent> version;

        /**
         * Resources contained in the instance (e.g. the observations contained in a bundle).
         */
        @Child(name = "containedInstance", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Resources contained in the instance", formalDefinition="Resources contained in the instance (e.g. the observations contained in a bundle)." )
        protected List<ExampleScenarioInstanceContainedInstanceComponent> containedInstance;

        private static final long serialVersionUID = -1928273130L;

    /**
     * Constructor
     */
      public ExampleScenarioInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioInstanceComponent(String resourceId, String resourceType) {
        super();
        this.setResourceId(resourceId);
        this.setResourceType(resourceType);
      }

        /**
         * @return {@link #resourceId} (The id of the resource for referencing.). This is the underlying object with id, value and extensions. The accessor "getResourceId" gives direct access to the value
         */
        public StringType getResourceIdElement() { 
          if (this.resourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.resourceId");
            else if (Configuration.doAutoCreate())
              this.resourceId = new StringType(); // bb
          return this.resourceId;
        }

        public boolean hasResourceIdElement() { 
          return this.resourceId != null && !this.resourceId.isEmpty();
        }

        public boolean hasResourceId() { 
          return this.resourceId != null && !this.resourceId.isEmpty();
        }

        /**
         * @param value {@link #resourceId} (The id of the resource for referencing.). This is the underlying object with id, value and extensions. The accessor "getResourceId" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setResourceIdElement(StringType value) { 
          this.resourceId = value;
          return this;
        }

        /**
         * @return The id of the resource for referencing.
         */
        public String getResourceId() { 
          return this.resourceId == null ? null : this.resourceId.getValue();
        }

        /**
         * @param value The id of the resource for referencing.
         */
        public ExampleScenarioInstanceComponent setResourceId(String value) { 
            if (this.resourceId == null)
              this.resourceId = new StringType();
            this.resourceId.setValue(value);
          return this;
        }

        /**
         * @return {@link #resourceType} (The type of the resource.). This is the underlying object with id, value and extensions. The accessor "getResourceType" gives direct access to the value
         */
        public CodeType getResourceTypeElement() { 
          if (this.resourceType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.resourceType");
            else if (Configuration.doAutoCreate())
              this.resourceType = new CodeType(); // bb
          return this.resourceType;
        }

        public boolean hasResourceTypeElement() { 
          return this.resourceType != null && !this.resourceType.isEmpty();
        }

        public boolean hasResourceType() { 
          return this.resourceType != null && !this.resourceType.isEmpty();
        }

        /**
         * @param value {@link #resourceType} (The type of the resource.). This is the underlying object with id, value and extensions. The accessor "getResourceType" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setResourceTypeElement(CodeType value) { 
          this.resourceType = value;
          return this;
        }

        /**
         * @return The type of the resource.
         */
        public String getResourceType() { 
          return this.resourceType == null ? null : this.resourceType.getValue();
        }

        /**
         * @param value The type of the resource.
         */
        public ExampleScenarioInstanceComponent setResourceType(String value) { 
            if (this.resourceType == null)
              this.resourceType = new CodeType();
            this.resourceType.setValue(value);
          return this;
        }

        /**
         * @return {@link #name} (A short name for the resource instance.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.name");
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
         * @param value {@link #name} (A short name for the resource instance.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A short name for the resource instance.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A short name for the resource instance.
         */
        public ExampleScenarioInstanceComponent setName(String value) { 
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
         * @return {@link #description} (Human-friendly description of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.description");
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
         * @param value {@link #description} (Human-friendly description of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Human-friendly description of the resource instance.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Human-friendly description of the resource instance.
         */
        public ExampleScenarioInstanceComponent setDescription(String value) { 
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
         * @return {@link #version} (A specific version of the resource.)
         */
        public List<ExampleScenarioInstanceVersionComponent> getVersion() { 
          if (this.version == null)
            this.version = new ArrayList<ExampleScenarioInstanceVersionComponent>();
          return this.version;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ExampleScenarioInstanceComponent setVersion(List<ExampleScenarioInstanceVersionComponent> theVersion) { 
          this.version = theVersion;
          return this;
        }

        public boolean hasVersion() { 
          if (this.version == null)
            return false;
          for (ExampleScenarioInstanceVersionComponent item : this.version)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ExampleScenarioInstanceVersionComponent addVersion() { //3
          ExampleScenarioInstanceVersionComponent t = new ExampleScenarioInstanceVersionComponent();
          if (this.version == null)
            this.version = new ArrayList<ExampleScenarioInstanceVersionComponent>();
          this.version.add(t);
          return t;
        }

        public ExampleScenarioInstanceComponent addVersion(ExampleScenarioInstanceVersionComponent t) { //3
          if (t == null)
            return this;
          if (this.version == null)
            this.version = new ArrayList<ExampleScenarioInstanceVersionComponent>();
          this.version.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #version}, creating it if it does not already exist {3}
         */
        public ExampleScenarioInstanceVersionComponent getVersionFirstRep() { 
          if (getVersion().isEmpty()) {
            addVersion();
          }
          return getVersion().get(0);
        }

        /**
         * @return {@link #containedInstance} (Resources contained in the instance (e.g. the observations contained in a bundle).)
         */
        public List<ExampleScenarioInstanceContainedInstanceComponent> getContainedInstance() { 
          if (this.containedInstance == null)
            this.containedInstance = new ArrayList<ExampleScenarioInstanceContainedInstanceComponent>();
          return this.containedInstance;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ExampleScenarioInstanceComponent setContainedInstance(List<ExampleScenarioInstanceContainedInstanceComponent> theContainedInstance) { 
          this.containedInstance = theContainedInstance;
          return this;
        }

        public boolean hasContainedInstance() { 
          if (this.containedInstance == null)
            return false;
          for (ExampleScenarioInstanceContainedInstanceComponent item : this.containedInstance)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ExampleScenarioInstanceContainedInstanceComponent addContainedInstance() { //3
          ExampleScenarioInstanceContainedInstanceComponent t = new ExampleScenarioInstanceContainedInstanceComponent();
          if (this.containedInstance == null)
            this.containedInstance = new ArrayList<ExampleScenarioInstanceContainedInstanceComponent>();
          this.containedInstance.add(t);
          return t;
        }

        public ExampleScenarioInstanceComponent addContainedInstance(ExampleScenarioInstanceContainedInstanceComponent t) { //3
          if (t == null)
            return this;
          if (this.containedInstance == null)
            this.containedInstance = new ArrayList<ExampleScenarioInstanceContainedInstanceComponent>();
          this.containedInstance.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #containedInstance}, creating it if it does not already exist {3}
         */
        public ExampleScenarioInstanceContainedInstanceComponent getContainedInstanceFirstRep() { 
          if (getContainedInstance().isEmpty()) {
            addContainedInstance();
          }
          return getContainedInstance().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("resourceId", "string", "The id of the resource for referencing.", 0, 1, resourceId));
          children.add(new Property("resourceType", "code", "The type of the resource.", 0, 1, resourceType));
          children.add(new Property("name", "string", "A short name for the resource instance.", 0, 1, name));
          children.add(new Property("description", "markdown", "Human-friendly description of the resource instance.", 0, 1, description));
          children.add(new Property("version", "", "A specific version of the resource.", 0, java.lang.Integer.MAX_VALUE, version));
          children.add(new Property("containedInstance", "", "Resources contained in the instance (e.g. the observations contained in a bundle).", 0, java.lang.Integer.MAX_VALUE, containedInstance));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1345650231: /*resourceId*/  return new Property("resourceId", "string", "The id of the resource for referencing.", 0, 1, resourceId);
          case -384364440: /*resourceType*/  return new Property("resourceType", "code", "The type of the resource.", 0, 1, resourceType);
          case 3373707: /*name*/  return new Property("name", "string", "A short name for the resource instance.", 0, 1, name);
          case -1724546052: /*description*/  return new Property("description", "markdown", "Human-friendly description of the resource instance.", 0, 1, description);
          case 351608024: /*version*/  return new Property("version", "", "A specific version of the resource.", 0, java.lang.Integer.MAX_VALUE, version);
          case -417062360: /*containedInstance*/  return new Property("containedInstance", "", "Resources contained in the instance (e.g. the observations contained in a bundle).", 0, java.lang.Integer.MAX_VALUE, containedInstance);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1345650231: /*resourceId*/ return this.resourceId == null ? new Base[0] : new Base[] {this.resourceId}; // StringType
        case -384364440: /*resourceType*/ return this.resourceType == null ? new Base[0] : new Base[] {this.resourceType}; // CodeType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // ExampleScenarioInstanceVersionComponent
        case -417062360: /*containedInstance*/ return this.containedInstance == null ? new Base[0] : this.containedInstance.toArray(new Base[this.containedInstance.size()]); // ExampleScenarioInstanceContainedInstanceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1345650231: // resourceId
          this.resourceId = TypeConvertor.castToString(value); // StringType
          return value;
        case -384364440: // resourceType
          this.resourceType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 351608024: // version
          this.getVersion().add((ExampleScenarioInstanceVersionComponent) value); // ExampleScenarioInstanceVersionComponent
          return value;
        case -417062360: // containedInstance
          this.getContainedInstance().add((ExampleScenarioInstanceContainedInstanceComponent) value); // ExampleScenarioInstanceContainedInstanceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("resourceId")) {
          this.resourceId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resourceType")) {
          this.resourceType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("version")) {
          this.getVersion().add((ExampleScenarioInstanceVersionComponent) value);
        } else if (name.equals("containedInstance")) {
          this.getContainedInstance().add((ExampleScenarioInstanceContainedInstanceComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1345650231:  return getResourceIdElement();
        case -384364440:  return getResourceTypeElement();
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case 351608024:  return addVersion(); 
        case -417062360:  return addContainedInstance(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1345650231: /*resourceId*/ return new String[] {"string"};
        case -384364440: /*resourceType*/ return new String[] {"code"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 351608024: /*version*/ return new String[] {};
        case -417062360: /*containedInstance*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("resourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.resourceId");
        }
        else if (name.equals("resourceType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.resourceType");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.description");
        }
        else if (name.equals("version")) {
          return addVersion();
        }
        else if (name.equals("containedInstance")) {
          return addContainedInstance();
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioInstanceComponent copy() {
        ExampleScenarioInstanceComponent dst = new ExampleScenarioInstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioInstanceComponent dst) {
        super.copyValues(dst);
        dst.resourceId = resourceId == null ? null : resourceId.copy();
        dst.resourceType = resourceType == null ? null : resourceType.copy();
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        if (version != null) {
          dst.version = new ArrayList<ExampleScenarioInstanceVersionComponent>();
          for (ExampleScenarioInstanceVersionComponent i : version)
            dst.version.add(i.copy());
        };
        if (containedInstance != null) {
          dst.containedInstance = new ArrayList<ExampleScenarioInstanceContainedInstanceComponent>();
          for (ExampleScenarioInstanceContainedInstanceComponent i : containedInstance)
            dst.containedInstance.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceComponent))
          return false;
        ExampleScenarioInstanceComponent o = (ExampleScenarioInstanceComponent) other_;
        return compareDeep(resourceId, o.resourceId, true) && compareDeep(resourceType, o.resourceType, true)
           && compareDeep(name, o.name, true) && compareDeep(description, o.description, true) && compareDeep(version, o.version, true)
           && compareDeep(containedInstance, o.containedInstance, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceComponent))
          return false;
        ExampleScenarioInstanceComponent o = (ExampleScenarioInstanceComponent) other_;
        return compareValues(resourceId, o.resourceId, true) && compareValues(resourceType, o.resourceType, true)
           && compareValues(name, o.name, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(resourceId, resourceType, name
          , description, version, containedInstance);
      }

  public String fhirType() {
    return "ExampleScenario.instance";

  }

  }

    @Block()
    public static class ExampleScenarioInstanceVersionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The identifier of a specific version of a resource.
         */
        @Child(name = "versionId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The identifier of a specific version of a resource", formalDefinition="The identifier of a specific version of a resource." )
        protected StringType versionId;

        /**
         * The description of the resource version.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The description of the resource version", formalDefinition="The description of the resource version." )
        protected MarkdownType description;

        private static final long serialVersionUID = 960821913L;

    /**
     * Constructor
     */
      public ExampleScenarioInstanceVersionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioInstanceVersionComponent(String versionId, String description) {
        super();
        this.setVersionId(versionId);
        this.setDescription(description);
      }

        /**
         * @return {@link #versionId} (The identifier of a specific version of a resource.). This is the underlying object with id, value and extensions. The accessor "getVersionId" gives direct access to the value
         */
        public StringType getVersionIdElement() { 
          if (this.versionId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceVersionComponent.versionId");
            else if (Configuration.doAutoCreate())
              this.versionId = new StringType(); // bb
          return this.versionId;
        }

        public boolean hasVersionIdElement() { 
          return this.versionId != null && !this.versionId.isEmpty();
        }

        public boolean hasVersionId() { 
          return this.versionId != null && !this.versionId.isEmpty();
        }

        /**
         * @param value {@link #versionId} (The identifier of a specific version of a resource.). This is the underlying object with id, value and extensions. The accessor "getVersionId" gives direct access to the value
         */
        public ExampleScenarioInstanceVersionComponent setVersionIdElement(StringType value) { 
          this.versionId = value;
          return this;
        }

        /**
         * @return The identifier of a specific version of a resource.
         */
        public String getVersionId() { 
          return this.versionId == null ? null : this.versionId.getValue();
        }

        /**
         * @param value The identifier of a specific version of a resource.
         */
        public ExampleScenarioInstanceVersionComponent setVersionId(String value) { 
            if (this.versionId == null)
              this.versionId = new StringType();
            this.versionId.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (The description of the resource version.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceVersionComponent.description");
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
         * @param value {@link #description} (The description of the resource version.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioInstanceVersionComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The description of the resource version.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The description of the resource version.
         */
        public ExampleScenarioInstanceVersionComponent setDescription(String value) { 
            if (this.description == null)
              this.description = new MarkdownType();
            this.description.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("versionId", "string", "The identifier of a specific version of a resource.", 0, 1, versionId));
          children.add(new Property("description", "markdown", "The description of the resource version.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1407102957: /*versionId*/  return new Property("versionId", "string", "The identifier of a specific version of a resource.", 0, 1, versionId);
          case -1724546052: /*description*/  return new Property("description", "markdown", "The description of the resource version.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1407102957: /*versionId*/ return this.versionId == null ? new Base[0] : new Base[] {this.versionId}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1407102957: // versionId
          this.versionId = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("versionId")) {
          this.versionId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1407102957:  return getVersionIdElement();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1407102957: /*versionId*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("versionId")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.version.versionId");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.version.description");
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioInstanceVersionComponent copy() {
        ExampleScenarioInstanceVersionComponent dst = new ExampleScenarioInstanceVersionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioInstanceVersionComponent dst) {
        super.copyValues(dst);
        dst.versionId = versionId == null ? null : versionId.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceVersionComponent))
          return false;
        ExampleScenarioInstanceVersionComponent o = (ExampleScenarioInstanceVersionComponent) other_;
        return compareDeep(versionId, o.versionId, true) && compareDeep(description, o.description, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceVersionComponent))
          return false;
        ExampleScenarioInstanceVersionComponent o = (ExampleScenarioInstanceVersionComponent) other_;
        return compareValues(versionId, o.versionId, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(versionId, description);
      }

  public String fhirType() {
    return "ExampleScenario.instance.version";

  }

  }

    @Block()
    public static class ExampleScenarioInstanceContainedInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Each resource contained in the instance.
         */
        @Child(name = "resourceId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Each resource contained in the instance", formalDefinition="Each resource contained in the instance." )
        protected StringType resourceId;

        /**
         * A specific version of a resource contained in the instance.
         */
        @Child(name = "versionId", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A specific version of a resource contained in the instance", formalDefinition="A specific version of a resource contained in the instance." )
        protected StringType versionId;

        private static final long serialVersionUID = 908084124L;

    /**
     * Constructor
     */
      public ExampleScenarioInstanceContainedInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioInstanceContainedInstanceComponent(String resourceId) {
        super();
        this.setResourceId(resourceId);
      }

        /**
         * @return {@link #resourceId} (Each resource contained in the instance.). This is the underlying object with id, value and extensions. The accessor "getResourceId" gives direct access to the value
         */
        public StringType getResourceIdElement() { 
          if (this.resourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceContainedInstanceComponent.resourceId");
            else if (Configuration.doAutoCreate())
              this.resourceId = new StringType(); // bb
          return this.resourceId;
        }

        public boolean hasResourceIdElement() { 
          return this.resourceId != null && !this.resourceId.isEmpty();
        }

        public boolean hasResourceId() { 
          return this.resourceId != null && !this.resourceId.isEmpty();
        }

        /**
         * @param value {@link #resourceId} (Each resource contained in the instance.). This is the underlying object with id, value and extensions. The accessor "getResourceId" gives direct access to the value
         */
        public ExampleScenarioInstanceContainedInstanceComponent setResourceIdElement(StringType value) { 
          this.resourceId = value;
          return this;
        }

        /**
         * @return Each resource contained in the instance.
         */
        public String getResourceId() { 
          return this.resourceId == null ? null : this.resourceId.getValue();
        }

        /**
         * @param value Each resource contained in the instance.
         */
        public ExampleScenarioInstanceContainedInstanceComponent setResourceId(String value) { 
            if (this.resourceId == null)
              this.resourceId = new StringType();
            this.resourceId.setValue(value);
          return this;
        }

        /**
         * @return {@link #versionId} (A specific version of a resource contained in the instance.). This is the underlying object with id, value and extensions. The accessor "getVersionId" gives direct access to the value
         */
        public StringType getVersionIdElement() { 
          if (this.versionId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceContainedInstanceComponent.versionId");
            else if (Configuration.doAutoCreate())
              this.versionId = new StringType(); // bb
          return this.versionId;
        }

        public boolean hasVersionIdElement() { 
          return this.versionId != null && !this.versionId.isEmpty();
        }

        public boolean hasVersionId() { 
          return this.versionId != null && !this.versionId.isEmpty();
        }

        /**
         * @param value {@link #versionId} (A specific version of a resource contained in the instance.). This is the underlying object with id, value and extensions. The accessor "getVersionId" gives direct access to the value
         */
        public ExampleScenarioInstanceContainedInstanceComponent setVersionIdElement(StringType value) { 
          this.versionId = value;
          return this;
        }

        /**
         * @return A specific version of a resource contained in the instance.
         */
        public String getVersionId() { 
          return this.versionId == null ? null : this.versionId.getValue();
        }

        /**
         * @param value A specific version of a resource contained in the instance.
         */
        public ExampleScenarioInstanceContainedInstanceComponent setVersionId(String value) { 
          if (Utilities.noString(value))
            this.versionId = null;
          else {
            if (this.versionId == null)
              this.versionId = new StringType();
            this.versionId.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("resourceId", "string", "Each resource contained in the instance.", 0, 1, resourceId));
          children.add(new Property("versionId", "string", "A specific version of a resource contained in the instance.", 0, 1, versionId));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1345650231: /*resourceId*/  return new Property("resourceId", "string", "Each resource contained in the instance.", 0, 1, resourceId);
          case -1407102957: /*versionId*/  return new Property("versionId", "string", "A specific version of a resource contained in the instance.", 0, 1, versionId);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1345650231: /*resourceId*/ return this.resourceId == null ? new Base[0] : new Base[] {this.resourceId}; // StringType
        case -1407102957: /*versionId*/ return this.versionId == null ? new Base[0] : new Base[] {this.versionId}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1345650231: // resourceId
          this.resourceId = TypeConvertor.castToString(value); // StringType
          return value;
        case -1407102957: // versionId
          this.versionId = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("resourceId")) {
          this.resourceId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("versionId")) {
          this.versionId = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1345650231:  return getResourceIdElement();
        case -1407102957:  return getVersionIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1345650231: /*resourceId*/ return new String[] {"string"};
        case -1407102957: /*versionId*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("resourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.containedInstance.resourceId");
        }
        else if (name.equals("versionId")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.instance.containedInstance.versionId");
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioInstanceContainedInstanceComponent copy() {
        ExampleScenarioInstanceContainedInstanceComponent dst = new ExampleScenarioInstanceContainedInstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioInstanceContainedInstanceComponent dst) {
        super.copyValues(dst);
        dst.resourceId = resourceId == null ? null : resourceId.copy();
        dst.versionId = versionId == null ? null : versionId.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceContainedInstanceComponent))
          return false;
        ExampleScenarioInstanceContainedInstanceComponent o = (ExampleScenarioInstanceContainedInstanceComponent) other_;
        return compareDeep(resourceId, o.resourceId, true) && compareDeep(versionId, o.versionId, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceContainedInstanceComponent))
          return false;
        ExampleScenarioInstanceContainedInstanceComponent o = (ExampleScenarioInstanceContainedInstanceComponent) other_;
        return compareValues(resourceId, o.resourceId, true) && compareValues(versionId, o.versionId, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(resourceId, versionId);
      }

  public String fhirType() {
    return "ExampleScenario.instance.containedInstance";

  }

  }

    @Block()
    public static class ExampleScenarioProcessComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The diagram title of the group of operations.
         */
        @Child(name = "title", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The diagram title of the group of operations", formalDefinition="The diagram title of the group of operations." )
        protected StringType title;

        /**
         * A longer description of the group of operations.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A longer description of the group of operations", formalDefinition="A longer description of the group of operations." )
        protected MarkdownType description;

        /**
         * Description of initial status before the process starts.
         */
        @Child(name = "preConditions", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of initial status before the process starts", formalDefinition="Description of initial status before the process starts." )
        protected MarkdownType preConditions;

        /**
         * Description of final status after the process ends.
         */
        @Child(name = "postConditions", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of final status after the process ends", formalDefinition="Description of final status after the process ends." )
        protected MarkdownType postConditions;

        /**
         * Each step of the process.
         */
        @Child(name = "step", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Each step of the process", formalDefinition="Each step of the process." )
        protected List<ExampleScenarioProcessStepComponent> step;

        private static final long serialVersionUID = 325578043L;

    /**
     * Constructor
     */
      public ExampleScenarioProcessComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioProcessComponent(String title) {
        super();
        this.setTitle(title);
      }

        /**
         * @return {@link #title} (The diagram title of the group of operations.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessComponent.title");
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
         * @param value {@link #title} (The diagram title of the group of operations.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The diagram title of the group of operations.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The diagram title of the group of operations.
         */
        public ExampleScenarioProcessComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (A longer description of the group of operations.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessComponent.description");
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
         * @param value {@link #description} (A longer description of the group of operations.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A longer description of the group of operations.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A longer description of the group of operations.
         */
        public ExampleScenarioProcessComponent setDescription(String value) { 
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
         * @return {@link #preConditions} (Description of initial status before the process starts.). This is the underlying object with id, value and extensions. The accessor "getPreConditions" gives direct access to the value
         */
        public MarkdownType getPreConditionsElement() { 
          if (this.preConditions == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessComponent.preConditions");
            else if (Configuration.doAutoCreate())
              this.preConditions = new MarkdownType(); // bb
          return this.preConditions;
        }

        public boolean hasPreConditionsElement() { 
          return this.preConditions != null && !this.preConditions.isEmpty();
        }

        public boolean hasPreConditions() { 
          return this.preConditions != null && !this.preConditions.isEmpty();
        }

        /**
         * @param value {@link #preConditions} (Description of initial status before the process starts.). This is the underlying object with id, value and extensions. The accessor "getPreConditions" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setPreConditionsElement(MarkdownType value) { 
          this.preConditions = value;
          return this;
        }

        /**
         * @return Description of initial status before the process starts.
         */
        public String getPreConditions() { 
          return this.preConditions == null ? null : this.preConditions.getValue();
        }

        /**
         * @param value Description of initial status before the process starts.
         */
        public ExampleScenarioProcessComponent setPreConditions(String value) { 
          if (value == null)
            this.preConditions = null;
          else {
            if (this.preConditions == null)
              this.preConditions = new MarkdownType();
            this.preConditions.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #postConditions} (Description of final status after the process ends.). This is the underlying object with id, value and extensions. The accessor "getPostConditions" gives direct access to the value
         */
        public MarkdownType getPostConditionsElement() { 
          if (this.postConditions == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessComponent.postConditions");
            else if (Configuration.doAutoCreate())
              this.postConditions = new MarkdownType(); // bb
          return this.postConditions;
        }

        public boolean hasPostConditionsElement() { 
          return this.postConditions != null && !this.postConditions.isEmpty();
        }

        public boolean hasPostConditions() { 
          return this.postConditions != null && !this.postConditions.isEmpty();
        }

        /**
         * @param value {@link #postConditions} (Description of final status after the process ends.). This is the underlying object with id, value and extensions. The accessor "getPostConditions" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setPostConditionsElement(MarkdownType value) { 
          this.postConditions = value;
          return this;
        }

        /**
         * @return Description of final status after the process ends.
         */
        public String getPostConditions() { 
          return this.postConditions == null ? null : this.postConditions.getValue();
        }

        /**
         * @param value Description of final status after the process ends.
         */
        public ExampleScenarioProcessComponent setPostConditions(String value) { 
          if (value == null)
            this.postConditions = null;
          else {
            if (this.postConditions == null)
              this.postConditions = new MarkdownType();
            this.postConditions.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #step} (Each step of the process.)
         */
        public List<ExampleScenarioProcessStepComponent> getStep() { 
          if (this.step == null)
            this.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          return this.step;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ExampleScenarioProcessComponent setStep(List<ExampleScenarioProcessStepComponent> theStep) { 
          this.step = theStep;
          return this;
        }

        public boolean hasStep() { 
          if (this.step == null)
            return false;
          for (ExampleScenarioProcessStepComponent item : this.step)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ExampleScenarioProcessStepComponent addStep() { //3
          ExampleScenarioProcessStepComponent t = new ExampleScenarioProcessStepComponent();
          if (this.step == null)
            this.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          this.step.add(t);
          return t;
        }

        public ExampleScenarioProcessComponent addStep(ExampleScenarioProcessStepComponent t) { //3
          if (t == null)
            return this;
          if (this.step == null)
            this.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          this.step.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #step}, creating it if it does not already exist {3}
         */
        public ExampleScenarioProcessStepComponent getStepFirstRep() { 
          if (getStep().isEmpty()) {
            addStep();
          }
          return getStep().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("title", "string", "The diagram title of the group of operations.", 0, 1, title));
          children.add(new Property("description", "markdown", "A longer description of the group of operations.", 0, 1, description));
          children.add(new Property("preConditions", "markdown", "Description of initial status before the process starts.", 0, 1, preConditions));
          children.add(new Property("postConditions", "markdown", "Description of final status after the process ends.", 0, 1, postConditions));
          children.add(new Property("step", "", "Each step of the process.", 0, java.lang.Integer.MAX_VALUE, step));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "The diagram title of the group of operations.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A longer description of the group of operations.", 0, 1, description);
          case -1006692933: /*preConditions*/  return new Property("preConditions", "markdown", "Description of initial status before the process starts.", 0, 1, preConditions);
          case 1738302328: /*postConditions*/  return new Property("postConditions", "markdown", "Description of final status after the process ends.", 0, 1, postConditions);
          case 3540684: /*step*/  return new Property("step", "", "Each step of the process.", 0, java.lang.Integer.MAX_VALUE, step);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1006692933: /*preConditions*/ return this.preConditions == null ? new Base[0] : new Base[] {this.preConditions}; // MarkdownType
        case 1738302328: /*postConditions*/ return this.postConditions == null ? new Base[0] : new Base[] {this.postConditions}; // MarkdownType
        case 3540684: /*step*/ return this.step == null ? new Base[0] : this.step.toArray(new Base[this.step.size()]); // ExampleScenarioProcessStepComponent
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
        case -1006692933: // preConditions
          this.preConditions = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1738302328: // postConditions
          this.postConditions = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3540684: // step
          this.getStep().add((ExampleScenarioProcessStepComponent) value); // ExampleScenarioProcessStepComponent
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
        } else if (name.equals("preConditions")) {
          this.preConditions = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("postConditions")) {
          this.postConditions = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("step")) {
          this.getStep().add((ExampleScenarioProcessStepComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case -1006692933:  return getPreConditionsElement();
        case 1738302328:  return getPostConditionsElement();
        case 3540684:  return addStep(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1006692933: /*preConditions*/ return new String[] {"markdown"};
        case 1738302328: /*postConditions*/ return new String[] {"markdown"};
        case 3540684: /*step*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.description");
        }
        else if (name.equals("preConditions")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.preConditions");
        }
        else if (name.equals("postConditions")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.postConditions");
        }
        else if (name.equals("step")) {
          return addStep();
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioProcessComponent copy() {
        ExampleScenarioProcessComponent dst = new ExampleScenarioProcessComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioProcessComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        dst.preConditions = preConditions == null ? null : preConditions.copy();
        dst.postConditions = postConditions == null ? null : postConditions.copy();
        if (step != null) {
          dst.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          for (ExampleScenarioProcessStepComponent i : step)
            dst.step.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessComponent))
          return false;
        ExampleScenarioProcessComponent o = (ExampleScenarioProcessComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(description, o.description, true) && compareDeep(preConditions, o.preConditions, true)
           && compareDeep(postConditions, o.postConditions, true) && compareDeep(step, o.step, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessComponent))
          return false;
        ExampleScenarioProcessComponent o = (ExampleScenarioProcessComponent) other_;
        return compareValues(title, o.title, true) && compareValues(description, o.description, true) && compareValues(preConditions, o.preConditions, true)
           && compareValues(postConditions, o.postConditions, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, description, preConditions
          , postConditions, step);
      }

  public String fhirType() {
    return "ExampleScenario.process";

  }

  }

    @Block()
    public static class ExampleScenarioProcessStepComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Nested process.
         */
        @Child(name = "process", type = {ExampleScenarioProcessComponent.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Nested process", formalDefinition="Nested process." )
        protected List<ExampleScenarioProcessComponent> process;

        /**
         * If there is a pause in the flow.
         */
        @Child(name = "pause", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If there is a pause in the flow", formalDefinition="If there is a pause in the flow." )
        protected BooleanType pause;

        /**
         * Each interaction or action.
         */
        @Child(name = "operation", type = {}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Each interaction or action", formalDefinition="Each interaction or action." )
        protected ExampleScenarioProcessStepOperationComponent operation;

        /**
         * Indicates an alternative step that can be taken instead of the operations on the base step in exceptional/atypical circumstances.
         */
        @Child(name = "alternative", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Alternate non-typical step action", formalDefinition="Indicates an alternative step that can be taken instead of the operations on the base step in exceptional/atypical circumstances." )
        protected List<ExampleScenarioProcessStepAlternativeComponent> alternative;

        private static final long serialVersionUID = -894029605L;

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepComponent() {
        super();
      }

        /**
         * @return {@link #process} (Nested process.)
         */
        public List<ExampleScenarioProcessComponent> getProcess() { 
          if (this.process == null)
            this.process = new ArrayList<ExampleScenarioProcessComponent>();
          return this.process;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ExampleScenarioProcessStepComponent setProcess(List<ExampleScenarioProcessComponent> theProcess) { 
          this.process = theProcess;
          return this;
        }

        public boolean hasProcess() { 
          if (this.process == null)
            return false;
          for (ExampleScenarioProcessComponent item : this.process)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ExampleScenarioProcessComponent addProcess() { //3
          ExampleScenarioProcessComponent t = new ExampleScenarioProcessComponent();
          if (this.process == null)
            this.process = new ArrayList<ExampleScenarioProcessComponent>();
          this.process.add(t);
          return t;
        }

        public ExampleScenarioProcessStepComponent addProcess(ExampleScenarioProcessComponent t) { //3
          if (t == null)
            return this;
          if (this.process == null)
            this.process = new ArrayList<ExampleScenarioProcessComponent>();
          this.process.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #process}, creating it if it does not already exist {3}
         */
        public ExampleScenarioProcessComponent getProcessFirstRep() { 
          if (getProcess().isEmpty()) {
            addProcess();
          }
          return getProcess().get(0);
        }

        /**
         * @return {@link #pause} (If there is a pause in the flow.). This is the underlying object with id, value and extensions. The accessor "getPause" gives direct access to the value
         */
        public BooleanType getPauseElement() { 
          if (this.pause == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepComponent.pause");
            else if (Configuration.doAutoCreate())
              this.pause = new BooleanType(); // bb
          return this.pause;
        }

        public boolean hasPauseElement() { 
          return this.pause != null && !this.pause.isEmpty();
        }

        public boolean hasPause() { 
          return this.pause != null && !this.pause.isEmpty();
        }

        /**
         * @param value {@link #pause} (If there is a pause in the flow.). This is the underlying object with id, value and extensions. The accessor "getPause" gives direct access to the value
         */
        public ExampleScenarioProcessStepComponent setPauseElement(BooleanType value) { 
          this.pause = value;
          return this;
        }

        /**
         * @return If there is a pause in the flow.
         */
        public boolean getPause() { 
          return this.pause == null || this.pause.isEmpty() ? false : this.pause.getValue();
        }

        /**
         * @param value If there is a pause in the flow.
         */
        public ExampleScenarioProcessStepComponent setPause(boolean value) { 
            if (this.pause == null)
              this.pause = new BooleanType();
            this.pause.setValue(value);
          return this;
        }

        /**
         * @return {@link #operation} (Each interaction or action.)
         */
        public ExampleScenarioProcessStepOperationComponent getOperation() { 
          if (this.operation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepComponent.operation");
            else if (Configuration.doAutoCreate())
              this.operation = new ExampleScenarioProcessStepOperationComponent(); // cc
          return this.operation;
        }

        public boolean hasOperation() { 
          return this.operation != null && !this.operation.isEmpty();
        }

        /**
         * @param value {@link #operation} (Each interaction or action.)
         */
        public ExampleScenarioProcessStepComponent setOperation(ExampleScenarioProcessStepOperationComponent value) { 
          this.operation = value;
          return this;
        }

        /**
         * @return {@link #alternative} (Indicates an alternative step that can be taken instead of the operations on the base step in exceptional/atypical circumstances.)
         */
        public List<ExampleScenarioProcessStepAlternativeComponent> getAlternative() { 
          if (this.alternative == null)
            this.alternative = new ArrayList<ExampleScenarioProcessStepAlternativeComponent>();
          return this.alternative;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ExampleScenarioProcessStepComponent setAlternative(List<ExampleScenarioProcessStepAlternativeComponent> theAlternative) { 
          this.alternative = theAlternative;
          return this;
        }

        public boolean hasAlternative() { 
          if (this.alternative == null)
            return false;
          for (ExampleScenarioProcessStepAlternativeComponent item : this.alternative)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ExampleScenarioProcessStepAlternativeComponent addAlternative() { //3
          ExampleScenarioProcessStepAlternativeComponent t = new ExampleScenarioProcessStepAlternativeComponent();
          if (this.alternative == null)
            this.alternative = new ArrayList<ExampleScenarioProcessStepAlternativeComponent>();
          this.alternative.add(t);
          return t;
        }

        public ExampleScenarioProcessStepComponent addAlternative(ExampleScenarioProcessStepAlternativeComponent t) { //3
          if (t == null)
            return this;
          if (this.alternative == null)
            this.alternative = new ArrayList<ExampleScenarioProcessStepAlternativeComponent>();
          this.alternative.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #alternative}, creating it if it does not already exist {3}
         */
        public ExampleScenarioProcessStepAlternativeComponent getAlternativeFirstRep() { 
          if (getAlternative().isEmpty()) {
            addAlternative();
          }
          return getAlternative().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("process", "@ExampleScenario.process", "Nested process.", 0, java.lang.Integer.MAX_VALUE, process));
          children.add(new Property("pause", "boolean", "If there is a pause in the flow.", 0, 1, pause));
          children.add(new Property("operation", "", "Each interaction or action.", 0, 1, operation));
          children.add(new Property("alternative", "", "Indicates an alternative step that can be taken instead of the operations on the base step in exceptional/atypical circumstances.", 0, java.lang.Integer.MAX_VALUE, alternative));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -309518737: /*process*/  return new Property("process", "@ExampleScenario.process", "Nested process.", 0, java.lang.Integer.MAX_VALUE, process);
          case 106440182: /*pause*/  return new Property("pause", "boolean", "If there is a pause in the flow.", 0, 1, pause);
          case 1662702951: /*operation*/  return new Property("operation", "", "Each interaction or action.", 0, 1, operation);
          case -196794451: /*alternative*/  return new Property("alternative", "", "Indicates an alternative step that can be taken instead of the operations on the base step in exceptional/atypical circumstances.", 0, java.lang.Integer.MAX_VALUE, alternative);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -309518737: /*process*/ return this.process == null ? new Base[0] : this.process.toArray(new Base[this.process.size()]); // ExampleScenarioProcessComponent
        case 106440182: /*pause*/ return this.pause == null ? new Base[0] : new Base[] {this.pause}; // BooleanType
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : new Base[] {this.operation}; // ExampleScenarioProcessStepOperationComponent
        case -196794451: /*alternative*/ return this.alternative == null ? new Base[0] : this.alternative.toArray(new Base[this.alternative.size()]); // ExampleScenarioProcessStepAlternativeComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -309518737: // process
          this.getProcess().add((ExampleScenarioProcessComponent) value); // ExampleScenarioProcessComponent
          return value;
        case 106440182: // pause
          this.pause = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1662702951: // operation
          this.operation = (ExampleScenarioProcessStepOperationComponent) value; // ExampleScenarioProcessStepOperationComponent
          return value;
        case -196794451: // alternative
          this.getAlternative().add((ExampleScenarioProcessStepAlternativeComponent) value); // ExampleScenarioProcessStepAlternativeComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("process")) {
          this.getProcess().add((ExampleScenarioProcessComponent) value);
        } else if (name.equals("pause")) {
          this.pause = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("operation")) {
          this.operation = (ExampleScenarioProcessStepOperationComponent) value; // ExampleScenarioProcessStepOperationComponent
        } else if (name.equals("alternative")) {
          this.getAlternative().add((ExampleScenarioProcessStepAlternativeComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309518737:  return addProcess(); 
        case 106440182:  return getPauseElement();
        case 1662702951:  return getOperation();
        case -196794451:  return addAlternative(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309518737: /*process*/ return new String[] {"@ExampleScenario.process"};
        case 106440182: /*pause*/ return new String[] {"boolean"};
        case 1662702951: /*operation*/ return new String[] {};
        case -196794451: /*alternative*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("process")) {
          return addProcess();
        }
        else if (name.equals("pause")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.pause");
        }
        else if (name.equals("operation")) {
          this.operation = new ExampleScenarioProcessStepOperationComponent();
          return this.operation;
        }
        else if (name.equals("alternative")) {
          return addAlternative();
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioProcessStepComponent copy() {
        ExampleScenarioProcessStepComponent dst = new ExampleScenarioProcessStepComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioProcessStepComponent dst) {
        super.copyValues(dst);
        if (process != null) {
          dst.process = new ArrayList<ExampleScenarioProcessComponent>();
          for (ExampleScenarioProcessComponent i : process)
            dst.process.add(i.copy());
        };
        dst.pause = pause == null ? null : pause.copy();
        dst.operation = operation == null ? null : operation.copy();
        if (alternative != null) {
          dst.alternative = new ArrayList<ExampleScenarioProcessStepAlternativeComponent>();
          for (ExampleScenarioProcessStepAlternativeComponent i : alternative)
            dst.alternative.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepComponent))
          return false;
        ExampleScenarioProcessStepComponent o = (ExampleScenarioProcessStepComponent) other_;
        return compareDeep(process, o.process, true) && compareDeep(pause, o.pause, true) && compareDeep(operation, o.operation, true)
           && compareDeep(alternative, o.alternative, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepComponent))
          return false;
        ExampleScenarioProcessStepComponent o = (ExampleScenarioProcessStepComponent) other_;
        return compareValues(pause, o.pause, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(process, pause, operation
          , alternative);
      }

  public String fhirType() {
    return "ExampleScenario.process.step";

  }

  }

    @Block()
    public static class ExampleScenarioProcessStepOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The sequential number of the interaction, e.g. 1.2.5.
         */
        @Child(name = "number", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The sequential number of the interaction", formalDefinition="The sequential number of the interaction, e.g. 1.2.5." )
        protected StringType number;

        /**
         * The type of operation - CRUD.
         */
        @Child(name = "type", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of operation - CRUD", formalDefinition="The type of operation - CRUD." )
        protected StringType type;

        /**
         * The human-friendly name of the interaction.
         */
        @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The human-friendly name of the interaction", formalDefinition="The human-friendly name of the interaction." )
        protected StringType name;

        /**
         * Who starts the transaction.
         */
        @Child(name = "initiator", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who starts the transaction", formalDefinition="Who starts the transaction." )
        protected StringType initiator;

        /**
         * Who receives the transaction.
         */
        @Child(name = "receiver", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who receives the transaction", formalDefinition="Who receives the transaction." )
        protected StringType receiver;

        /**
         * A comment to be inserted in the diagram.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A comment to be inserted in the diagram", formalDefinition="A comment to be inserted in the diagram." )
        protected MarkdownType description;

        /**
         * Whether the initiator is deactivated right after the transaction.
         */
        @Child(name = "initiatorActive", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the initiator is deactivated right after the transaction", formalDefinition="Whether the initiator is deactivated right after the transaction." )
        protected BooleanType initiatorActive;

        /**
         * Whether the receiver is deactivated right after the transaction.
         */
        @Child(name = "receiverActive", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the receiver is deactivated right after the transaction", formalDefinition="Whether the receiver is deactivated right after the transaction." )
        protected BooleanType receiverActive;

        /**
         * Each resource instance used by the initiator.
         */
        @Child(name = "request", type = {ExampleScenarioInstanceContainedInstanceComponent.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Each resource instance used by the initiator", formalDefinition="Each resource instance used by the initiator." )
        protected ExampleScenarioInstanceContainedInstanceComponent request;

        /**
         * Each resource instance used by the responder.
         */
        @Child(name = "response", type = {ExampleScenarioInstanceContainedInstanceComponent.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Each resource instance used by the responder", formalDefinition="Each resource instance used by the responder." )
        protected ExampleScenarioInstanceContainedInstanceComponent response;

        private static final long serialVersionUID = 911241906L;

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepOperationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepOperationComponent(String number) {
        super();
        this.setNumber(number);
      }

        /**
         * @return {@link #number} (The sequential number of the interaction, e.g. 1.2.5.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public StringType getNumberElement() { 
          if (this.number == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.number");
            else if (Configuration.doAutoCreate())
              this.number = new StringType(); // bb
          return this.number;
        }

        public boolean hasNumberElement() { 
          return this.number != null && !this.number.isEmpty();
        }

        public boolean hasNumber() { 
          return this.number != null && !this.number.isEmpty();
        }

        /**
         * @param value {@link #number} (The sequential number of the interaction, e.g. 1.2.5.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setNumberElement(StringType value) { 
          this.number = value;
          return this;
        }

        /**
         * @return The sequential number of the interaction, e.g. 1.2.5.
         */
        public String getNumber() { 
          return this.number == null ? null : this.number.getValue();
        }

        /**
         * @param value The sequential number of the interaction, e.g. 1.2.5.
         */
        public ExampleScenarioProcessStepOperationComponent setNumber(String value) { 
            if (this.number == null)
              this.number = new StringType();
            this.number.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (The type of operation - CRUD.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public StringType getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new StringType(); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of operation - CRUD.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setTypeElement(StringType value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of operation - CRUD.
         */
        public String getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of operation - CRUD.
         */
        public ExampleScenarioProcessStepOperationComponent setType(String value) { 
          if (Utilities.noString(value))
            this.type = null;
          else {
            if (this.type == null)
              this.type = new StringType();
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #name} (The human-friendly name of the interaction.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.name");
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
         * @param value {@link #name} (The human-friendly name of the interaction.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The human-friendly name of the interaction.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The human-friendly name of the interaction.
         */
        public ExampleScenarioProcessStepOperationComponent setName(String value) { 
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
         * @return {@link #initiator} (Who starts the transaction.). This is the underlying object with id, value and extensions. The accessor "getInitiator" gives direct access to the value
         */
        public StringType getInitiatorElement() { 
          if (this.initiator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.initiator");
            else if (Configuration.doAutoCreate())
              this.initiator = new StringType(); // bb
          return this.initiator;
        }

        public boolean hasInitiatorElement() { 
          return this.initiator != null && !this.initiator.isEmpty();
        }

        public boolean hasInitiator() { 
          return this.initiator != null && !this.initiator.isEmpty();
        }

        /**
         * @param value {@link #initiator} (Who starts the transaction.). This is the underlying object with id, value and extensions. The accessor "getInitiator" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setInitiatorElement(StringType value) { 
          this.initiator = value;
          return this;
        }

        /**
         * @return Who starts the transaction.
         */
        public String getInitiator() { 
          return this.initiator == null ? null : this.initiator.getValue();
        }

        /**
         * @param value Who starts the transaction.
         */
        public ExampleScenarioProcessStepOperationComponent setInitiator(String value) { 
          if (Utilities.noString(value))
            this.initiator = null;
          else {
            if (this.initiator == null)
              this.initiator = new StringType();
            this.initiator.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #receiver} (Who receives the transaction.). This is the underlying object with id, value and extensions. The accessor "getReceiver" gives direct access to the value
         */
        public StringType getReceiverElement() { 
          if (this.receiver == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.receiver");
            else if (Configuration.doAutoCreate())
              this.receiver = new StringType(); // bb
          return this.receiver;
        }

        public boolean hasReceiverElement() { 
          return this.receiver != null && !this.receiver.isEmpty();
        }

        public boolean hasReceiver() { 
          return this.receiver != null && !this.receiver.isEmpty();
        }

        /**
         * @param value {@link #receiver} (Who receives the transaction.). This is the underlying object with id, value and extensions. The accessor "getReceiver" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setReceiverElement(StringType value) { 
          this.receiver = value;
          return this;
        }

        /**
         * @return Who receives the transaction.
         */
        public String getReceiver() { 
          return this.receiver == null ? null : this.receiver.getValue();
        }

        /**
         * @param value Who receives the transaction.
         */
        public ExampleScenarioProcessStepOperationComponent setReceiver(String value) { 
          if (Utilities.noString(value))
            this.receiver = null;
          else {
            if (this.receiver == null)
              this.receiver = new StringType();
            this.receiver.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #description} (A comment to be inserted in the diagram.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.description");
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
         * @param value {@link #description} (A comment to be inserted in the diagram.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A comment to be inserted in the diagram.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A comment to be inserted in the diagram.
         */
        public ExampleScenarioProcessStepOperationComponent setDescription(String value) { 
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
         * @return {@link #initiatorActive} (Whether the initiator is deactivated right after the transaction.). This is the underlying object with id, value and extensions. The accessor "getInitiatorActive" gives direct access to the value
         */
        public BooleanType getInitiatorActiveElement() { 
          if (this.initiatorActive == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.initiatorActive");
            else if (Configuration.doAutoCreate())
              this.initiatorActive = new BooleanType(); // bb
          return this.initiatorActive;
        }

        public boolean hasInitiatorActiveElement() { 
          return this.initiatorActive != null && !this.initiatorActive.isEmpty();
        }

        public boolean hasInitiatorActive() { 
          return this.initiatorActive != null && !this.initiatorActive.isEmpty();
        }

        /**
         * @param value {@link #initiatorActive} (Whether the initiator is deactivated right after the transaction.). This is the underlying object with id, value and extensions. The accessor "getInitiatorActive" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setInitiatorActiveElement(BooleanType value) { 
          this.initiatorActive = value;
          return this;
        }

        /**
         * @return Whether the initiator is deactivated right after the transaction.
         */
        public boolean getInitiatorActive() { 
          return this.initiatorActive == null || this.initiatorActive.isEmpty() ? false : this.initiatorActive.getValue();
        }

        /**
         * @param value Whether the initiator is deactivated right after the transaction.
         */
        public ExampleScenarioProcessStepOperationComponent setInitiatorActive(boolean value) { 
            if (this.initiatorActive == null)
              this.initiatorActive = new BooleanType();
            this.initiatorActive.setValue(value);
          return this;
        }

        /**
         * @return {@link #receiverActive} (Whether the receiver is deactivated right after the transaction.). This is the underlying object with id, value and extensions. The accessor "getReceiverActive" gives direct access to the value
         */
        public BooleanType getReceiverActiveElement() { 
          if (this.receiverActive == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.receiverActive");
            else if (Configuration.doAutoCreate())
              this.receiverActive = new BooleanType(); // bb
          return this.receiverActive;
        }

        public boolean hasReceiverActiveElement() { 
          return this.receiverActive != null && !this.receiverActive.isEmpty();
        }

        public boolean hasReceiverActive() { 
          return this.receiverActive != null && !this.receiverActive.isEmpty();
        }

        /**
         * @param value {@link #receiverActive} (Whether the receiver is deactivated right after the transaction.). This is the underlying object with id, value and extensions. The accessor "getReceiverActive" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setReceiverActiveElement(BooleanType value) { 
          this.receiverActive = value;
          return this;
        }

        /**
         * @return Whether the receiver is deactivated right after the transaction.
         */
        public boolean getReceiverActive() { 
          return this.receiverActive == null || this.receiverActive.isEmpty() ? false : this.receiverActive.getValue();
        }

        /**
         * @param value Whether the receiver is deactivated right after the transaction.
         */
        public ExampleScenarioProcessStepOperationComponent setReceiverActive(boolean value) { 
            if (this.receiverActive == null)
              this.receiverActive = new BooleanType();
            this.receiverActive.setValue(value);
          return this;
        }

        /**
         * @return {@link #request} (Each resource instance used by the initiator.)
         */
        public ExampleScenarioInstanceContainedInstanceComponent getRequest() { 
          if (this.request == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.request");
            else if (Configuration.doAutoCreate())
              this.request = new ExampleScenarioInstanceContainedInstanceComponent(); // cc
          return this.request;
        }

        public boolean hasRequest() { 
          return this.request != null && !this.request.isEmpty();
        }

        /**
         * @param value {@link #request} (Each resource instance used by the initiator.)
         */
        public ExampleScenarioProcessStepOperationComponent setRequest(ExampleScenarioInstanceContainedInstanceComponent value) { 
          this.request = value;
          return this;
        }

        /**
         * @return {@link #response} (Each resource instance used by the responder.)
         */
        public ExampleScenarioInstanceContainedInstanceComponent getResponse() { 
          if (this.response == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.response");
            else if (Configuration.doAutoCreate())
              this.response = new ExampleScenarioInstanceContainedInstanceComponent(); // cc
          return this.response;
        }

        public boolean hasResponse() { 
          return this.response != null && !this.response.isEmpty();
        }

        /**
         * @param value {@link #response} (Each resource instance used by the responder.)
         */
        public ExampleScenarioProcessStepOperationComponent setResponse(ExampleScenarioInstanceContainedInstanceComponent value) { 
          this.response = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("number", "string", "The sequential number of the interaction, e.g. 1.2.5.", 0, 1, number));
          children.add(new Property("type", "string", "The type of operation - CRUD.", 0, 1, type));
          children.add(new Property("name", "string", "The human-friendly name of the interaction.", 0, 1, name));
          children.add(new Property("initiator", "string", "Who starts the transaction.", 0, 1, initiator));
          children.add(new Property("receiver", "string", "Who receives the transaction.", 0, 1, receiver));
          children.add(new Property("description", "markdown", "A comment to be inserted in the diagram.", 0, 1, description));
          children.add(new Property("initiatorActive", "boolean", "Whether the initiator is deactivated right after the transaction.", 0, 1, initiatorActive));
          children.add(new Property("receiverActive", "boolean", "Whether the receiver is deactivated right after the transaction.", 0, 1, receiverActive));
          children.add(new Property("request", "@ExampleScenario.instance.containedInstance", "Each resource instance used by the initiator.", 0, 1, request));
          children.add(new Property("response", "@ExampleScenario.instance.containedInstance", "Each resource instance used by the responder.", 0, 1, response));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1034364087: /*number*/  return new Property("number", "string", "The sequential number of the interaction, e.g. 1.2.5.", 0, 1, number);
          case 3575610: /*type*/  return new Property("type", "string", "The type of operation - CRUD.", 0, 1, type);
          case 3373707: /*name*/  return new Property("name", "string", "The human-friendly name of the interaction.", 0, 1, name);
          case -248987089: /*initiator*/  return new Property("initiator", "string", "Who starts the transaction.", 0, 1, initiator);
          case -808719889: /*receiver*/  return new Property("receiver", "string", "Who receives the transaction.", 0, 1, receiver);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A comment to be inserted in the diagram.", 0, 1, description);
          case 384339477: /*initiatorActive*/  return new Property("initiatorActive", "boolean", "Whether the initiator is deactivated right after the transaction.", 0, 1, initiatorActive);
          case -285284907: /*receiverActive*/  return new Property("receiverActive", "boolean", "Whether the receiver is deactivated right after the transaction.", 0, 1, receiverActive);
          case 1095692943: /*request*/  return new Property("request", "@ExampleScenario.instance.containedInstance", "Each resource instance used by the initiator.", 0, 1, request);
          case -340323263: /*response*/  return new Property("response", "@ExampleScenario.instance.containedInstance", "Each resource instance used by the responder.", 0, 1, response);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1034364087: /*number*/ return this.number == null ? new Base[0] : new Base[] {this.number}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -248987089: /*initiator*/ return this.initiator == null ? new Base[0] : new Base[] {this.initiator}; // StringType
        case -808719889: /*receiver*/ return this.receiver == null ? new Base[0] : new Base[] {this.receiver}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 384339477: /*initiatorActive*/ return this.initiatorActive == null ? new Base[0] : new Base[] {this.initiatorActive}; // BooleanType
        case -285284907: /*receiverActive*/ return this.receiverActive == null ? new Base[0] : new Base[] {this.receiverActive}; // BooleanType
        case 1095692943: /*request*/ return this.request == null ? new Base[0] : new Base[] {this.request}; // ExampleScenarioInstanceContainedInstanceComponent
        case -340323263: /*response*/ return this.response == null ? new Base[0] : new Base[] {this.response}; // ExampleScenarioInstanceContainedInstanceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1034364087: // number
          this.number = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -248987089: // initiator
          this.initiator = TypeConvertor.castToString(value); // StringType
          return value;
        case -808719889: // receiver
          this.receiver = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 384339477: // initiatorActive
          this.initiatorActive = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -285284907: // receiverActive
          this.receiverActive = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1095692943: // request
          this.request = (ExampleScenarioInstanceContainedInstanceComponent) value; // ExampleScenarioInstanceContainedInstanceComponent
          return value;
        case -340323263: // response
          this.response = (ExampleScenarioInstanceContainedInstanceComponent) value; // ExampleScenarioInstanceContainedInstanceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("number")) {
          this.number = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("initiator")) {
          this.initiator = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("receiver")) {
          this.receiver = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("initiatorActive")) {
          this.initiatorActive = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("receiverActive")) {
          this.receiverActive = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("request")) {
          this.request = (ExampleScenarioInstanceContainedInstanceComponent) value; // ExampleScenarioInstanceContainedInstanceComponent
        } else if (name.equals("response")) {
          this.response = (ExampleScenarioInstanceContainedInstanceComponent) value; // ExampleScenarioInstanceContainedInstanceComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1034364087:  return getNumberElement();
        case 3575610:  return getTypeElement();
        case 3373707:  return getNameElement();
        case -248987089:  return getInitiatorElement();
        case -808719889:  return getReceiverElement();
        case -1724546052:  return getDescriptionElement();
        case 384339477:  return getInitiatorActiveElement();
        case -285284907:  return getReceiverActiveElement();
        case 1095692943:  return getRequest();
        case -340323263:  return getResponse();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1034364087: /*number*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -248987089: /*initiator*/ return new String[] {"string"};
        case -808719889: /*receiver*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 384339477: /*initiatorActive*/ return new String[] {"boolean"};
        case -285284907: /*receiverActive*/ return new String[] {"boolean"};
        case 1095692943: /*request*/ return new String[] {"@ExampleScenario.instance.containedInstance"};
        case -340323263: /*response*/ return new String[] {"@ExampleScenario.instance.containedInstance"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.number");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.type");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.name");
        }
        else if (name.equals("initiator")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.initiator");
        }
        else if (name.equals("receiver")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.receiver");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.description");
        }
        else if (name.equals("initiatorActive")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.initiatorActive");
        }
        else if (name.equals("receiverActive")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.operation.receiverActive");
        }
        else if (name.equals("request")) {
          this.request = new ExampleScenarioInstanceContainedInstanceComponent();
          return this.request;
        }
        else if (name.equals("response")) {
          this.response = new ExampleScenarioInstanceContainedInstanceComponent();
          return this.response;
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioProcessStepOperationComponent copy() {
        ExampleScenarioProcessStepOperationComponent dst = new ExampleScenarioProcessStepOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioProcessStepOperationComponent dst) {
        super.copyValues(dst);
        dst.number = number == null ? null : number.copy();
        dst.type = type == null ? null : type.copy();
        dst.name = name == null ? null : name.copy();
        dst.initiator = initiator == null ? null : initiator.copy();
        dst.receiver = receiver == null ? null : receiver.copy();
        dst.description = description == null ? null : description.copy();
        dst.initiatorActive = initiatorActive == null ? null : initiatorActive.copy();
        dst.receiverActive = receiverActive == null ? null : receiverActive.copy();
        dst.request = request == null ? null : request.copy();
        dst.response = response == null ? null : response.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepOperationComponent))
          return false;
        ExampleScenarioProcessStepOperationComponent o = (ExampleScenarioProcessStepOperationComponent) other_;
        return compareDeep(number, o.number, true) && compareDeep(type, o.type, true) && compareDeep(name, o.name, true)
           && compareDeep(initiator, o.initiator, true) && compareDeep(receiver, o.receiver, true) && compareDeep(description, o.description, true)
           && compareDeep(initiatorActive, o.initiatorActive, true) && compareDeep(receiverActive, o.receiverActive, true)
           && compareDeep(request, o.request, true) && compareDeep(response, o.response, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepOperationComponent))
          return false;
        ExampleScenarioProcessStepOperationComponent o = (ExampleScenarioProcessStepOperationComponent) other_;
        return compareValues(number, o.number, true) && compareValues(type, o.type, true) && compareValues(name, o.name, true)
           && compareValues(initiator, o.initiator, true) && compareValues(receiver, o.receiver, true) && compareValues(description, o.description, true)
           && compareValues(initiatorActive, o.initiatorActive, true) && compareValues(receiverActive, o.receiverActive, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(number, type, name, initiator
          , receiver, description, initiatorActive, receiverActive, request, response);
      }

  public String fhirType() {
    return "ExampleScenario.process.step.operation";

  }

  }

    @Block()
    public static class ExampleScenarioProcessStepAlternativeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.
         */
        @Child(name = "title", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for alternative", formalDefinition="The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked." )
        protected StringType title;

        /**
         * A human-readable description of the alternative explaining when the alternative should occur rather than the base step.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A human-readable description of each option", formalDefinition="A human-readable description of the alternative explaining when the alternative should occur rather than the base step." )
        protected MarkdownType description;

        /**
         * What happens in each alternative option.
         */
        @Child(name = "step", type = {ExampleScenarioProcessStepComponent.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What happens in each alternative option", formalDefinition="What happens in each alternative option." )
        protected List<ExampleScenarioProcessStepComponent> step;

        private static final long serialVersionUID = -254687460L;

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepAlternativeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepAlternativeComponent(String title) {
        super();
        this.setTitle(title);
      }

        /**
         * @return {@link #title} (The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepAlternativeComponent.title");
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
         * @param value {@link #title} (The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioProcessStepAlternativeComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.
         */
        public ExampleScenarioProcessStepAlternativeComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (A human-readable description of the alternative explaining when the alternative should occur rather than the base step.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepAlternativeComponent.description");
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
         * @param value {@link #description} (A human-readable description of the alternative explaining when the alternative should occur rather than the base step.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioProcessStepAlternativeComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A human-readable description of the alternative explaining when the alternative should occur rather than the base step.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A human-readable description of the alternative explaining when the alternative should occur rather than the base step.
         */
        public ExampleScenarioProcessStepAlternativeComponent setDescription(String value) { 
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
         * @return {@link #step} (What happens in each alternative option.)
         */
        public List<ExampleScenarioProcessStepComponent> getStep() { 
          if (this.step == null)
            this.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          return this.step;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ExampleScenarioProcessStepAlternativeComponent setStep(List<ExampleScenarioProcessStepComponent> theStep) { 
          this.step = theStep;
          return this;
        }

        public boolean hasStep() { 
          if (this.step == null)
            return false;
          for (ExampleScenarioProcessStepComponent item : this.step)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ExampleScenarioProcessStepComponent addStep() { //3
          ExampleScenarioProcessStepComponent t = new ExampleScenarioProcessStepComponent();
          if (this.step == null)
            this.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          this.step.add(t);
          return t;
        }

        public ExampleScenarioProcessStepAlternativeComponent addStep(ExampleScenarioProcessStepComponent t) { //3
          if (t == null)
            return this;
          if (this.step == null)
            this.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          this.step.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #step}, creating it if it does not already exist {3}
         */
        public ExampleScenarioProcessStepComponent getStepFirstRep() { 
          if (getStep().isEmpty()) {
            addStep();
          }
          return getStep().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("title", "string", "The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.", 0, 1, title));
          children.add(new Property("description", "markdown", "A human-readable description of the alternative explaining when the alternative should occur rather than the base step.", 0, 1, description));
          children.add(new Property("step", "@ExampleScenario.process.step", "What happens in each alternative option.", 0, java.lang.Integer.MAX_VALUE, step));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A human-readable description of the alternative explaining when the alternative should occur rather than the base step.", 0, 1, description);
          case 3540684: /*step*/  return new Property("step", "@ExampleScenario.process.step", "What happens in each alternative option.", 0, java.lang.Integer.MAX_VALUE, step);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3540684: /*step*/ return this.step == null ? new Base[0] : this.step.toArray(new Base[this.step.size()]); // ExampleScenarioProcessStepComponent
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
        case 3540684: // step
          this.getStep().add((ExampleScenarioProcessStepComponent) value); // ExampleScenarioProcessStepComponent
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
        } else if (name.equals("step")) {
          this.getStep().add((ExampleScenarioProcessStepComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case 3540684:  return addStep(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3540684: /*step*/ return new String[] {"@ExampleScenario.process.step"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.alternative.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.process.step.alternative.description");
        }
        else if (name.equals("step")) {
          return addStep();
        }
        else
          return super.addChild(name);
      }

      public ExampleScenarioProcessStepAlternativeComponent copy() {
        ExampleScenarioProcessStepAlternativeComponent dst = new ExampleScenarioProcessStepAlternativeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenarioProcessStepAlternativeComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        if (step != null) {
          dst.step = new ArrayList<ExampleScenarioProcessStepComponent>();
          for (ExampleScenarioProcessStepComponent i : step)
            dst.step.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepAlternativeComponent))
          return false;
        ExampleScenarioProcessStepAlternativeComponent o = (ExampleScenarioProcessStepAlternativeComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(description, o.description, true) && compareDeep(step, o.step, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepAlternativeComponent))
          return false;
        ExampleScenarioProcessStepAlternativeComponent o = (ExampleScenarioProcessStepAlternativeComponent) other_;
        return compareValues(title, o.title, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, description, step
          );
      }

  public String fhirType() {
    return "ExampleScenario.process.step.alternative";

  }

  }

    /**
     * An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this example scenario, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the example scenario", formalDefinition="A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the example scenario", formalDefinition="The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this example scenario (computer friendly)", formalDefinition="A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * The status of this example scenario. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this example scenario. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition')." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the example scenario.
     */
    @Child(name = "publisher", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the example scenario." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the example scenario is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for example scenario (if applicable)", formalDefinition="A legal or geographic region in which the example scenario is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The purpose of the example, e.g. to illustrate a scenario", formalDefinition="What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario." )
    protected MarkdownType copyright;

    /**
     * Actor participating in the resource.
     */
    @Child(name = "actor", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Actor participating in the resource", formalDefinition="Actor participating in the resource." )
    protected List<ExampleScenarioActorComponent> actor;

    /**
     * Each resource and each version that is present in the workflow.
     */
    @Child(name = "instance", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Each resource and each version that is present in the workflow", formalDefinition="Each resource and each version that is present in the workflow." )
    protected List<ExampleScenarioInstanceComponent> instance;

    /**
     * Each major process - a group of operations.
     */
    @Child(name = "process", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Each major process - a group of operations", formalDefinition="Each major process - a group of operations." )
    protected List<ExampleScenarioProcessComponent> process;

    /**
     * Another nested workflow.
     */
    @Child(name = "workflow", type = {CanonicalType.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Another nested workflow", formalDefinition="Another nested workflow." )
    protected List<CanonicalType> workflow;

    private static final long serialVersionUID = 1725952195L;

  /**
   * Constructor
   */
    public ExampleScenario() {
      super();
    }

  /**
   * Constructor
   */
    public ExampleScenario(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ExampleScenario setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.
     */
    public ExampleScenario setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setIdentifier(List<Identifier> theIdentifier) { 
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

    public ExampleScenario addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public ExampleScenario setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public ExampleScenario setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.name");
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
     * @param value {@link #name} (A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ExampleScenario setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public ExampleScenario setName(String value) { 
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
     * @return {@link #status} (The status of this example scenario. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.status");
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
     * @param value {@link #status} (The status of this example scenario. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ExampleScenario setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this example scenario. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this example scenario. Enables tracking the life-cycle of the content.
     */
    public ExampleScenario setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public ExampleScenario setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public ExampleScenario setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ExampleScenario setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').
     */
    public ExampleScenario setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual that published the example scenario.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual that published the example scenario.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public ExampleScenario setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the example scenario.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the example scenario.
     */
    public ExampleScenario setPublisher(String value) { 
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
    public ExampleScenario setContact(List<ContactDetail> theContact) { 
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

    public ExampleScenario addContact(ContactDetail t) { //3
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setUseContext(List<UsageContext> theUseContext) { 
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

    public ExampleScenario addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the example scenario is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public ExampleScenario addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.purpose");
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
     * @param value {@link #purpose} (What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public ExampleScenario setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.
     */
    public ExampleScenario setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public ExampleScenario setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.
     */
    public ExampleScenario setCopyright(String value) { 
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
     * @return {@link #actor} (Actor participating in the resource.)
     */
    public List<ExampleScenarioActorComponent> getActor() { 
      if (this.actor == null)
        this.actor = new ArrayList<ExampleScenarioActorComponent>();
      return this.actor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setActor(List<ExampleScenarioActorComponent> theActor) { 
      this.actor = theActor;
      return this;
    }

    public boolean hasActor() { 
      if (this.actor == null)
        return false;
      for (ExampleScenarioActorComponent item : this.actor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ExampleScenarioActorComponent addActor() { //3
      ExampleScenarioActorComponent t = new ExampleScenarioActorComponent();
      if (this.actor == null)
        this.actor = new ArrayList<ExampleScenarioActorComponent>();
      this.actor.add(t);
      return t;
    }

    public ExampleScenario addActor(ExampleScenarioActorComponent t) { //3
      if (t == null)
        return this;
      if (this.actor == null)
        this.actor = new ArrayList<ExampleScenarioActorComponent>();
      this.actor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #actor}, creating it if it does not already exist {3}
     */
    public ExampleScenarioActorComponent getActorFirstRep() { 
      if (getActor().isEmpty()) {
        addActor();
      }
      return getActor().get(0);
    }

    /**
     * @return {@link #instance} (Each resource and each version that is present in the workflow.)
     */
    public List<ExampleScenarioInstanceComponent> getInstance() { 
      if (this.instance == null)
        this.instance = new ArrayList<ExampleScenarioInstanceComponent>();
      return this.instance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setInstance(List<ExampleScenarioInstanceComponent> theInstance) { 
      this.instance = theInstance;
      return this;
    }

    public boolean hasInstance() { 
      if (this.instance == null)
        return false;
      for (ExampleScenarioInstanceComponent item : this.instance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ExampleScenarioInstanceComponent addInstance() { //3
      ExampleScenarioInstanceComponent t = new ExampleScenarioInstanceComponent();
      if (this.instance == null)
        this.instance = new ArrayList<ExampleScenarioInstanceComponent>();
      this.instance.add(t);
      return t;
    }

    public ExampleScenario addInstance(ExampleScenarioInstanceComponent t) { //3
      if (t == null)
        return this;
      if (this.instance == null)
        this.instance = new ArrayList<ExampleScenarioInstanceComponent>();
      this.instance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #instance}, creating it if it does not already exist {3}
     */
    public ExampleScenarioInstanceComponent getInstanceFirstRep() { 
      if (getInstance().isEmpty()) {
        addInstance();
      }
      return getInstance().get(0);
    }

    /**
     * @return {@link #process} (Each major process - a group of operations.)
     */
    public List<ExampleScenarioProcessComponent> getProcess() { 
      if (this.process == null)
        this.process = new ArrayList<ExampleScenarioProcessComponent>();
      return this.process;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setProcess(List<ExampleScenarioProcessComponent> theProcess) { 
      this.process = theProcess;
      return this;
    }

    public boolean hasProcess() { 
      if (this.process == null)
        return false;
      for (ExampleScenarioProcessComponent item : this.process)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ExampleScenarioProcessComponent addProcess() { //3
      ExampleScenarioProcessComponent t = new ExampleScenarioProcessComponent();
      if (this.process == null)
        this.process = new ArrayList<ExampleScenarioProcessComponent>();
      this.process.add(t);
      return t;
    }

    public ExampleScenario addProcess(ExampleScenarioProcessComponent t) { //3
      if (t == null)
        return this;
      if (this.process == null)
        this.process = new ArrayList<ExampleScenarioProcessComponent>();
      this.process.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #process}, creating it if it does not already exist {3}
     */
    public ExampleScenarioProcessComponent getProcessFirstRep() { 
      if (getProcess().isEmpty()) {
        addProcess();
      }
      return getProcess().get(0);
    }

    /**
     * @return {@link #workflow} (Another nested workflow.)
     */
    public List<CanonicalType> getWorkflow() { 
      if (this.workflow == null)
        this.workflow = new ArrayList<CanonicalType>();
      return this.workflow;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExampleScenario setWorkflow(List<CanonicalType> theWorkflow) { 
      this.workflow = theWorkflow;
      return this;
    }

    public boolean hasWorkflow() { 
      if (this.workflow == null)
        return false;
      for (CanonicalType item : this.workflow)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #workflow} (Another nested workflow.)
     */
    public CanonicalType addWorkflowElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.workflow == null)
        this.workflow = new ArrayList<CanonicalType>();
      this.workflow.add(t);
      return t;
    }

    /**
     * @param value {@link #workflow} (Another nested workflow.)
     */
    public ExampleScenario addWorkflow(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.workflow == null)
        this.workflow = new ArrayList<CanonicalType>();
      this.workflow.add(t);
      return this;
    }

    /**
     * @param value {@link #workflow} (Another nested workflow.)
     */
    public boolean hasWorkflow(String value) { 
      if (this.workflow == null)
        return false;
      for (CanonicalType v : this.workflow)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTitleMax() { 
      return 0;
    }
    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the example scenario.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"title\"");
    }

    public boolean hasTitleElement() { 
      return false;
    }
    public boolean hasTitle() {
      return false;
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the example scenario.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ExampleScenario setTitleElement(StringType value) { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"title\"");
    }
    public String getTitle() { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"title\"");
    }
    /**
     * @param value A short, descriptive, user-friendly title for the example scenario.
     */
    public ExampleScenario setTitle(String value) { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"title\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getDescriptionMax() { 
      return 0;
    }
    /**
     * @return {@link #description} (A free text natural language description of the example scenario from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"description\"");
    }

    public boolean hasDescriptionElement() { 
      return false;
    }
    public boolean hasDescription() {
      return false;
    }

    /**
     * @param value {@link #description} (A free text natural language description of the example scenario from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ExampleScenario setDescriptionElement(MarkdownType value) { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"description\"");
    }
    public String getDescription() { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"description\"");
    }
    /**
     * @param value A free text natural language description of the example scenario from a consumer's perspective.
     */
    public ExampleScenario setDescription(String value) { 
      throw new Error("The resource type \"ExampleScenario\" does not implement the property \"description\"");
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("status", "code", "The status of this example scenario. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the example scenario.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the example scenario is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.", 0, 1, copyright));
        children.add(new Property("actor", "", "Actor participating in the resource.", 0, java.lang.Integer.MAX_VALUE, actor));
        children.add(new Property("instance", "", "Each resource and each version that is present in the workflow.", 0, java.lang.Integer.MAX_VALUE, instance));
        children.add(new Property("process", "", "Each major process - a group of operations.", 0, java.lang.Integer.MAX_VALUE, process));
        children.add(new Property("workflow", "canonical(ExampleScenario)", "Another nested workflow.", 0, java.lang.Integer.MAX_VALUE, workflow));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the example scenario. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this example scenario. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the example scenario was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the example scenario.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the example scenario is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.", 0, 1, copyright);
        case 92645877: /*actor*/  return new Property("actor", "", "Actor participating in the resource.", 0, java.lang.Integer.MAX_VALUE, actor);
        case 555127957: /*instance*/  return new Property("instance", "", "Each resource and each version that is present in the workflow.", 0, java.lang.Integer.MAX_VALUE, instance);
        case -309518737: /*process*/  return new Property("process", "", "Each major process - a group of operations.", 0, java.lang.Integer.MAX_VALUE, process);
        case 35379135: /*workflow*/  return new Property("workflow", "canonical(ExampleScenario)", "Another nested workflow.", 0, java.lang.Integer.MAX_VALUE, workflow);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : this.actor.toArray(new Base[this.actor.size()]); // ExampleScenarioActorComponent
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : this.instance.toArray(new Base[this.instance.size()]); // ExampleScenarioInstanceComponent
        case -309518737: /*process*/ return this.process == null ? new Base[0] : this.process.toArray(new Base[this.process.size()]); // ExampleScenarioProcessComponent
        case 35379135: /*workflow*/ return this.workflow == null ? new Base[0] : this.workflow.toArray(new Base[this.workflow.size()]); // CanonicalType
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
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
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
        case 92645877: // actor
          this.getActor().add((ExampleScenarioActorComponent) value); // ExampleScenarioActorComponent
          return value;
        case 555127957: // instance
          this.getInstance().add((ExampleScenarioInstanceComponent) value); // ExampleScenarioInstanceComponent
          return value;
        case -309518737: // process
          this.getProcess().add((ExampleScenarioProcessComponent) value); // ExampleScenarioProcessComponent
          return value;
        case 35379135: // workflow
          this.getWorkflow().add(TypeConvertor.castToCanonical(value)); // CanonicalType
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
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
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
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("actor")) {
          this.getActor().add((ExampleScenarioActorComponent) value);
        } else if (name.equals("instance")) {
          this.getInstance().add((ExampleScenarioInstanceComponent) value);
        } else if (name.equals("process")) {
          this.getProcess().add((ExampleScenarioProcessComponent) value);
        } else if (name.equals("workflow")) {
          this.getWorkflow().add(TypeConvertor.castToCanonical(value));
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
        case 3373707:  return getNameElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 92645877:  return addActor(); 
        case 555127957:  return addInstance(); 
        case -309518737:  return addProcess(); 
        case 35379135:  return addWorkflowElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 92645877: /*actor*/ return new String[] {};
        case 555127957: /*instance*/ return new String[] {};
        case -309518737: /*process*/ return new String[] {};
        case 35379135: /*workflow*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.name");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.copyright");
        }
        else if (name.equals("actor")) {
          return addActor();
        }
        else if (name.equals("instance")) {
          return addInstance();
        }
        else if (name.equals("process")) {
          return addProcess();
        }
        else if (name.equals("workflow")) {
          throw new FHIRException("Cannot call addChild on a primitive type ExampleScenario.workflow");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ExampleScenario";

  }

      public ExampleScenario copy() {
        ExampleScenario dst = new ExampleScenario();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExampleScenario dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
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
        if (actor != null) {
          dst.actor = new ArrayList<ExampleScenarioActorComponent>();
          for (ExampleScenarioActorComponent i : actor)
            dst.actor.add(i.copy());
        };
        if (instance != null) {
          dst.instance = new ArrayList<ExampleScenarioInstanceComponent>();
          for (ExampleScenarioInstanceComponent i : instance)
            dst.instance.add(i.copy());
        };
        if (process != null) {
          dst.process = new ArrayList<ExampleScenarioProcessComponent>();
          for (ExampleScenarioProcessComponent i : process)
            dst.process.add(i.copy());
        };
        if (workflow != null) {
          dst.workflow = new ArrayList<CanonicalType>();
          for (CanonicalType i : workflow)
            dst.workflow.add(i.copy());
        };
      }

      protected ExampleScenario typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenario))
          return false;
        ExampleScenario o = (ExampleScenario) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(actor, o.actor, true)
           && compareDeep(instance, o.instance, true) && compareDeep(process, o.process, true) && compareDeep(workflow, o.workflow, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenario))
          return false;
        ExampleScenario o = (ExampleScenario) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true)
           && compareValues(publisher, o.publisher, true) && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true)
           && compareValues(workflow, o.workflow, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, status, experimental, date, publisher, contact, useContext, jurisdiction
          , purpose, copyright, actor, instance, process, workflow);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ExampleScenario;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the example scenario</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the example scenario", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the example scenario</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the example scenario</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ExampleScenario.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ExampleScenario.useContext", description="A use context type and quantity- or range-based value assigned to the example scenario", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the example scenario</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ExampleScenario.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the example scenario</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ExampleScenario.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ExampleScenario.useContext", description="A use context type and value assigned to the example scenario", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the example scenario</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ExampleScenario.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ExampleScenario.useContext.code", description="A type of use context assigned to the example scenario", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ExampleScenario.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ExampleScenario.useContext.value as CodeableConcept)", description="A use context assigned to the example scenario", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ExampleScenario.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The example scenario publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ExampleScenario.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ExampleScenario.date", description="The example scenario publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The example scenario publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ExampleScenario.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ExampleScenario.identifier", description="External identifier for the example scenario", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ExampleScenario.jurisdiction", description="Intended jurisdiction for the example scenario", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the example scenario</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ExampleScenario.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ExampleScenario.name", description="Computationally friendly name of the example scenario", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the example scenario</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ExampleScenario.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the example scenario</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ExampleScenario.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ExampleScenario.publisher", description="Name of the publisher of the example scenario", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the example scenario</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ExampleScenario.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ExampleScenario.status", description="The current status of the example scenario", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the example scenario</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ExampleScenario.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ExampleScenario.url", description="The uri that identifies the example scenario", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the example scenario</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ExampleScenario.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ExampleScenario.version", description="The business version of the example scenario", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the example scenario</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ExampleScenario.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}