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
 * A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.
 */
@ResourceDef(name="ExampleScenario", profile="http://hl7.org/fhir/StructureDefinition/ExampleScenario")
public class ExampleScenario extends CanonicalResource {

    @Block()
    public static class ExampleScenarioActorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A unique string within the scenario that is used to reference the actor.
         */
        @Child(name = "key", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ID or acronym of the actor", formalDefinition="A unique string within the scenario that is used to reference the actor." )
        protected StringType key;

        /**
         * The category of actor - person or system.
         */
        @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="person | system", formalDefinition="The category of actor - person or system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/examplescenario-actor-type")
        protected Enumeration<ExampleScenarioActorType> type;

        /**
         * The human-readable name for the actor used when rendering the scenario.
         */
        @Child(name = "title", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for actor when rendering", formalDefinition="The human-readable name for the actor used when rendering the scenario." )
        protected StringType title;

        /**
         * An explanation of who/what the actor is and its role in the scenario.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Details about actor", formalDefinition="An explanation of who/what the actor is and its role in the scenario." )
        protected MarkdownType description;

        private static final long serialVersionUID = 267911906L;

    /**
     * Constructor
     */
      public ExampleScenarioActorComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioActorComponent(String key, ExampleScenarioActorType type, String title) {
        super();
        this.setKey(key);
        this.setType(type);
        this.setTitle(title);
      }

        /**
         * @return {@link #key} (A unique string within the scenario that is used to reference the actor.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public StringType getKeyElement() { 
          if (this.key == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioActorComponent.key");
            else if (Configuration.doAutoCreate())
              this.key = new StringType(); // bb
          return this.key;
        }

        public boolean hasKeyElement() { 
          return this.key != null && !this.key.isEmpty();
        }

        public boolean hasKey() { 
          return this.key != null && !this.key.isEmpty();
        }

        /**
         * @param value {@link #key} (A unique string within the scenario that is used to reference the actor.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public ExampleScenarioActorComponent setKeyElement(StringType value) { 
          this.key = value;
          return this;
        }

        /**
         * @return A unique string within the scenario that is used to reference the actor.
         */
        public String getKey() { 
          return this.key == null ? null : this.key.getValue();
        }

        /**
         * @param value A unique string within the scenario that is used to reference the actor.
         */
        public ExampleScenarioActorComponent setKey(String value) { 
            if (this.key == null)
              this.key = new StringType();
            this.key.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (The category of actor - person or system.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
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
         * @param value {@link #type} (The category of actor - person or system.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ExampleScenarioActorComponent setTypeElement(Enumeration<ExampleScenarioActorType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The category of actor - person or system.
         */
        public ExampleScenarioActorType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The category of actor - person or system.
         */
        public ExampleScenarioActorComponent setType(ExampleScenarioActorType value) { 
            if (this.type == null)
              this.type = new Enumeration<ExampleScenarioActorType>(new ExampleScenarioActorTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #title} (The human-readable name for the actor used when rendering the scenario.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioActorComponent.title");
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
         * @param value {@link #title} (The human-readable name for the actor used when rendering the scenario.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioActorComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The human-readable name for the actor used when rendering the scenario.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The human-readable name for the actor used when rendering the scenario.
         */
        public ExampleScenarioActorComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (An explanation of who/what the actor is and its role in the scenario.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
         * @param value {@link #description} (An explanation of who/what the actor is and its role in the scenario.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioActorComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return An explanation of who/what the actor is and its role in the scenario.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value An explanation of who/what the actor is and its role in the scenario.
         */
        public ExampleScenarioActorComponent setDescription(String value) { 
          if (Utilities.noString(value))
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
          children.add(new Property("key", "string", "A unique string within the scenario that is used to reference the actor.", 0, 1, key));
          children.add(new Property("type", "code", "The category of actor - person or system.", 0, 1, type));
          children.add(new Property("title", "string", "The human-readable name for the actor used when rendering the scenario.", 0, 1, title));
          children.add(new Property("description", "markdown", "An explanation of who/what the actor is and its role in the scenario.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106079: /*key*/  return new Property("key", "string", "A unique string within the scenario that is used to reference the actor.", 0, 1, key);
          case 3575610: /*type*/  return new Property("type", "code", "The category of actor - person or system.", 0, 1, type);
          case 110371416: /*title*/  return new Property("title", "string", "The human-readable name for the actor used when rendering the scenario.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "An explanation of who/what the actor is and its role in the scenario.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ExampleScenarioActorType>
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106079: // key
          this.key = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new ExampleScenarioActorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ExampleScenarioActorType>
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("key")) {
          this.key = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new ExampleScenarioActorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ExampleScenarioActorType>
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079:  return getKeyElement();
        case 3575610:  return getTypeElement();
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.actor.key");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.actor.type");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.actor.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.actor.description");
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
        dst.key = key == null ? null : key.copy();
        dst.type = type == null ? null : type.copy();
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioActorComponent))
          return false;
        ExampleScenarioActorComponent o = (ExampleScenarioActorComponent) other_;
        return compareDeep(key, o.key, true) && compareDeep(type, o.type, true) && compareDeep(title, o.title, true)
           && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioActorComponent))
          return false;
        ExampleScenarioActorComponent o = (ExampleScenarioActorComponent) other_;
        return compareValues(key, o.key, true) && compareValues(type, o.type, true) && compareValues(title, o.title, true)
           && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, type, title, description
          );
      }

  public String fhirType() {
    return "ExampleScenario.actor";

  }

  }

    @Block()
    public static class ExampleScenarioInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A unique string within the scenario that is used to reference the instance.
         */
        @Child(name = "key", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ID or acronym of the instance", formalDefinition="A unique string within the scenario that is used to reference the instance." )
        protected StringType key;

        /**
         * A code indicating the kind of data structure (FHIR resource or some other standard) this is an instance of.
         */
        @Child(name = "structureType", type = {Coding.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Data structure for example", formalDefinition="A code indicating the kind of data structure (FHIR resource or some other standard) this is an instance of." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/examplescenario-instance-type")
        protected Coding structureType;

        /**
         * Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.
         */
        @Child(name = "structureVersion", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. 4.0.1", formalDefinition="Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with." )
        protected StringType structureVersion;

        /**
         * Refers to a profile, template or other ruleset the instance adheres to.
         */
        @Child(name = "structureProfile", type = {CanonicalType.class, UriType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Rules instance adheres to", formalDefinition="Refers to a profile, template or other ruleset the instance adheres to." )
        protected DataType structureProfile;

        /**
         * A short descriptive label the instance to be used in tables or diagrams.
         */
        @Child(name = "title", type = {StringType.class}, order=5, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for instance", formalDefinition="A short descriptive label the instance to be used in tables or diagrams." )
        protected StringType title;

        /**
         * An explanation of what the instance contains and what it's for.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-friendly description of the instance", formalDefinition="An explanation of what the instance contains and what it's for." )
        protected MarkdownType description;

        /**
         * Points to an instance (typically an example) that shows the data that would corespond to this instance.
         */
        @Child(name = "content", type = {Reference.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Example instance data", formalDefinition="Points to an instance (typically an example) that shows the data that would corespond to this instance." )
        protected Reference content;

        /**
         * Represents the instance as it was at a specific time-point.
         */
        @Child(name = "version", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Snapshot of instance that changes", formalDefinition="Represents the instance as it was at a specific time-point." )
        protected List<ExampleScenarioInstanceVersionComponent> version;

        /**
         * References to other instances that can be found within this instance (e.g. the observations contained in a bundle).
         */
        @Child(name = "containedInstance", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Resources contained in the instance", formalDefinition="References to other instances that can be found within this instance (e.g. the observations contained in a bundle)." )
        protected List<ExampleScenarioInstanceContainedInstanceComponent> containedInstance;

        private static final long serialVersionUID = -1366610733L;

    /**
     * Constructor
     */
      public ExampleScenarioInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioInstanceComponent(String key, Coding structureType, String title) {
        super();
        this.setKey(key);
        this.setStructureType(structureType);
        this.setTitle(title);
      }

        /**
         * @return {@link #key} (A unique string within the scenario that is used to reference the instance.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public StringType getKeyElement() { 
          if (this.key == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.key");
            else if (Configuration.doAutoCreate())
              this.key = new StringType(); // bb
          return this.key;
        }

        public boolean hasKeyElement() { 
          return this.key != null && !this.key.isEmpty();
        }

        public boolean hasKey() { 
          return this.key != null && !this.key.isEmpty();
        }

        /**
         * @param value {@link #key} (A unique string within the scenario that is used to reference the instance.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setKeyElement(StringType value) { 
          this.key = value;
          return this;
        }

        /**
         * @return A unique string within the scenario that is used to reference the instance.
         */
        public String getKey() { 
          return this.key == null ? null : this.key.getValue();
        }

        /**
         * @param value A unique string within the scenario that is used to reference the instance.
         */
        public ExampleScenarioInstanceComponent setKey(String value) { 
            if (this.key == null)
              this.key = new StringType();
            this.key.setValue(value);
          return this;
        }

        /**
         * @return {@link #structureType} (A code indicating the kind of data structure (FHIR resource or some other standard) this is an instance of.)
         */
        public Coding getStructureType() { 
          if (this.structureType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.structureType");
            else if (Configuration.doAutoCreate())
              this.structureType = new Coding(); // cc
          return this.structureType;
        }

        public boolean hasStructureType() { 
          return this.structureType != null && !this.structureType.isEmpty();
        }

        /**
         * @param value {@link #structureType} (A code indicating the kind of data structure (FHIR resource or some other standard) this is an instance of.)
         */
        public ExampleScenarioInstanceComponent setStructureType(Coding value) { 
          this.structureType = value;
          return this;
        }

        /**
         * @return {@link #structureVersion} (Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.). This is the underlying object with id, value and extensions. The accessor "getStructureVersion" gives direct access to the value
         */
        public StringType getStructureVersionElement() { 
          if (this.structureVersion == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.structureVersion");
            else if (Configuration.doAutoCreate())
              this.structureVersion = new StringType(); // bb
          return this.structureVersion;
        }

        public boolean hasStructureVersionElement() { 
          return this.structureVersion != null && !this.structureVersion.isEmpty();
        }

        public boolean hasStructureVersion() { 
          return this.structureVersion != null && !this.structureVersion.isEmpty();
        }

        /**
         * @param value {@link #structureVersion} (Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.). This is the underlying object with id, value and extensions. The accessor "getStructureVersion" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setStructureVersionElement(StringType value) { 
          this.structureVersion = value;
          return this;
        }

        /**
         * @return Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.
         */
        public String getStructureVersion() { 
          return this.structureVersion == null ? null : this.structureVersion.getValue();
        }

        /**
         * @param value Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.
         */
        public ExampleScenarioInstanceComponent setStructureVersion(String value) { 
          if (Utilities.noString(value))
            this.structureVersion = null;
          else {
            if (this.structureVersion == null)
              this.structureVersion = new StringType();
            this.structureVersion.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #structureProfile} (Refers to a profile, template or other ruleset the instance adheres to.)
         */
        public DataType getStructureProfile() { 
          return this.structureProfile;
        }

        /**
         * @return {@link #structureProfile} (Refers to a profile, template or other ruleset the instance adheres to.)
         */
        public CanonicalType getStructureProfileCanonicalType() throws FHIRException { 
          if (this.structureProfile == null)
            this.structureProfile = new CanonicalType();
          if (!(this.structureProfile instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.structureProfile.getClass().getName()+" was encountered");
          return (CanonicalType) this.structureProfile;
        }

        public boolean hasStructureProfileCanonicalType() { 
          return this != null && this.structureProfile instanceof CanonicalType;
        }

        /**
         * @return {@link #structureProfile} (Refers to a profile, template or other ruleset the instance adheres to.)
         */
        public UriType getStructureProfileUriType() throws FHIRException { 
          if (this.structureProfile == null)
            this.structureProfile = new UriType();
          if (!(this.structureProfile instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.structureProfile.getClass().getName()+" was encountered");
          return (UriType) this.structureProfile;
        }

        public boolean hasStructureProfileUriType() { 
          return this != null && this.structureProfile instanceof UriType;
        }

        public boolean hasStructureProfile() { 
          return this.structureProfile != null && !this.structureProfile.isEmpty();
        }

        /**
         * @param value {@link #structureProfile} (Refers to a profile, template or other ruleset the instance adheres to.)
         */
        public ExampleScenarioInstanceComponent setStructureProfile(DataType value) { 
          if (value != null && !(value instanceof CanonicalType || value instanceof UriType))
            throw new FHIRException("Not the right type for ExampleScenario.instance.structureProfile[x]: "+value.fhirType());
          this.structureProfile = value;
          return this;
        }

        /**
         * @return {@link #title} (A short descriptive label the instance to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.title");
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
         * @param value {@link #title} (A short descriptive label the instance to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A short descriptive label the instance to be used in tables or diagrams.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A short descriptive label the instance to be used in tables or diagrams.
         */
        public ExampleScenarioInstanceComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (An explanation of what the instance contains and what it's for.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
         * @param value {@link #description} (An explanation of what the instance contains and what it's for.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioInstanceComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return An explanation of what the instance contains and what it's for.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value An explanation of what the instance contains and what it's for.
         */
        public ExampleScenarioInstanceComponent setDescription(String value) { 
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
         * @return {@link #content} (Points to an instance (typically an example) that shows the data that would corespond to this instance.)
         */
        public Reference getContent() { 
          if (this.content == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceComponent.content");
            else if (Configuration.doAutoCreate())
              this.content = new Reference(); // cc
          return this.content;
        }

        public boolean hasContent() { 
          return this.content != null && !this.content.isEmpty();
        }

        /**
         * @param value {@link #content} (Points to an instance (typically an example) that shows the data that would corespond to this instance.)
         */
        public ExampleScenarioInstanceComponent setContent(Reference value) { 
          this.content = value;
          return this;
        }

        /**
         * @return {@link #version} (Represents the instance as it was at a specific time-point.)
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
         * @return {@link #containedInstance} (References to other instances that can be found within this instance (e.g. the observations contained in a bundle).)
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
          children.add(new Property("key", "string", "A unique string within the scenario that is used to reference the instance.", 0, 1, key));
          children.add(new Property("structureType", "Coding", "A code indicating the kind of data structure (FHIR resource or some other standard) this is an instance of.", 0, 1, structureType));
          children.add(new Property("structureVersion", "string", "Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.", 0, 1, structureVersion));
          children.add(new Property("structureProfile[x]", "canonical|uri", "Refers to a profile, template or other ruleset the instance adheres to.", 0, 1, structureProfile));
          children.add(new Property("title", "string", "A short descriptive label the instance to be used in tables or diagrams.", 0, 1, title));
          children.add(new Property("description", "markdown", "An explanation of what the instance contains and what it's for.", 0, 1, description));
          children.add(new Property("content", "Reference", "Points to an instance (typically an example) that shows the data that would corespond to this instance.", 0, 1, content));
          children.add(new Property("version", "", "Represents the instance as it was at a specific time-point.", 0, java.lang.Integer.MAX_VALUE, version));
          children.add(new Property("containedInstance", "", "References to other instances that can be found within this instance (e.g. the observations contained in a bundle).", 0, java.lang.Integer.MAX_VALUE, containedInstance));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106079: /*key*/  return new Property("key", "string", "A unique string within the scenario that is used to reference the instance.", 0, 1, key);
          case -222609587: /*structureType*/  return new Property("structureType", "Coding", "A code indicating the kind of data structure (FHIR resource or some other standard) this is an instance of.", 0, 1, structureType);
          case 872091621: /*structureVersion*/  return new Property("structureVersion", "string", "Conveys the version of the data structure instantiated.  I.e. what release of FHIR, X12, OpenEHR, etc. is instance compliant with.", 0, 1, structureVersion);
          case -207739894: /*structureProfile[x]*/  return new Property("structureProfile[x]", "canonical|uri", "Refers to a profile, template or other ruleset the instance adheres to.", 0, 1, structureProfile);
          case 211057846: /*structureProfile*/  return new Property("structureProfile[x]", "canonical|uri", "Refers to a profile, template or other ruleset the instance adheres to.", 0, 1, structureProfile);
          case -1044433698: /*structureProfileCanonical*/  return new Property("structureProfile[x]", "canonical", "Refers to a profile, template or other ruleset the instance adheres to.", 0, 1, structureProfile);
          case -207745834: /*structureProfileUri*/  return new Property("structureProfile[x]", "uri", "Refers to a profile, template or other ruleset the instance adheres to.", 0, 1, structureProfile);
          case 110371416: /*title*/  return new Property("title", "string", "A short descriptive label the instance to be used in tables or diagrams.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "An explanation of what the instance contains and what it's for.", 0, 1, description);
          case 951530617: /*content*/  return new Property("content", "Reference", "Points to an instance (typically an example) that shows the data that would corespond to this instance.", 0, 1, content);
          case 351608024: /*version*/  return new Property("version", "", "Represents the instance as it was at a specific time-point.", 0, java.lang.Integer.MAX_VALUE, version);
          case -417062360: /*containedInstance*/  return new Property("containedInstance", "", "References to other instances that can be found within this instance (e.g. the observations contained in a bundle).", 0, java.lang.Integer.MAX_VALUE, containedInstance);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // StringType
        case -222609587: /*structureType*/ return this.structureType == null ? new Base[0] : new Base[] {this.structureType}; // Coding
        case 872091621: /*structureVersion*/ return this.structureVersion == null ? new Base[0] : new Base[] {this.structureVersion}; // StringType
        case 211057846: /*structureProfile*/ return this.structureProfile == null ? new Base[0] : new Base[] {this.structureProfile}; // DataType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // Reference
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // ExampleScenarioInstanceVersionComponent
        case -417062360: /*containedInstance*/ return this.containedInstance == null ? new Base[0] : this.containedInstance.toArray(new Base[this.containedInstance.size()]); // ExampleScenarioInstanceContainedInstanceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106079: // key
          this.key = TypeConvertor.castToString(value); // StringType
          return value;
        case -222609587: // structureType
          this.structureType = TypeConvertor.castToCoding(value); // Coding
          return value;
        case 872091621: // structureVersion
          this.structureVersion = TypeConvertor.castToString(value); // StringType
          return value;
        case 211057846: // structureProfile
          this.structureProfile = TypeConvertor.castToType(value); // DataType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 951530617: // content
          this.content = TypeConvertor.castToReference(value); // Reference
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
        if (name.equals("key")) {
          this.key = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("structureType")) {
          this.structureType = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("structureVersion")) {
          this.structureVersion = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("structureProfile[x]")) {
          this.structureProfile = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("content")) {
          this.content = TypeConvertor.castToReference(value); // Reference
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
        case 106079:  return getKeyElement();
        case -222609587:  return getStructureType();
        case 872091621:  return getStructureVersionElement();
        case -207739894:  return getStructureProfile();
        case 211057846:  return getStructureProfile();
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case 951530617:  return getContent();
        case 351608024:  return addVersion(); 
        case -417062360:  return addContainedInstance(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"string"};
        case -222609587: /*structureType*/ return new String[] {"Coding"};
        case 872091621: /*structureVersion*/ return new String[] {"string"};
        case 211057846: /*structureProfile*/ return new String[] {"canonical", "uri"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 951530617: /*content*/ return new String[] {"Reference"};
        case 351608024: /*version*/ return new String[] {};
        case -417062360: /*containedInstance*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.key");
        }
        else if (name.equals("structureType")) {
          this.structureType = new Coding();
          return this.structureType;
        }
        else if (name.equals("structureVersion")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.structureVersion");
        }
        else if (name.equals("structureProfileCanonical")) {
          this.structureProfile = new CanonicalType();
          return this.structureProfile;
        }
        else if (name.equals("structureProfileUri")) {
          this.structureProfile = new UriType();
          return this.structureProfile;
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.description");
        }
        else if (name.equals("content")) {
          this.content = new Reference();
          return this.content;
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
        dst.key = key == null ? null : key.copy();
        dst.structureType = structureType == null ? null : structureType.copy();
        dst.structureVersion = structureVersion == null ? null : structureVersion.copy();
        dst.structureProfile = structureProfile == null ? null : structureProfile.copy();
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        dst.content = content == null ? null : content.copy();
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
        return compareDeep(key, o.key, true) && compareDeep(structureType, o.structureType, true) && compareDeep(structureVersion, o.structureVersion, true)
           && compareDeep(structureProfile, o.structureProfile, true) && compareDeep(title, o.title, true)
           && compareDeep(description, o.description, true) && compareDeep(content, o.content, true) && compareDeep(version, o.version, true)
           && compareDeep(containedInstance, o.containedInstance, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceComponent))
          return false;
        ExampleScenarioInstanceComponent o = (ExampleScenarioInstanceComponent) other_;
        return compareValues(key, o.key, true) && compareValues(structureVersion, o.structureVersion, true)
           && compareValues(title, o.title, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, structureType, structureVersion
          , structureProfile, title, description, content, version, containedInstance);
      }

  public String fhirType() {
    return "ExampleScenario.instance";

  }

  }

    @Block()
    public static class ExampleScenarioInstanceVersionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A unique string within the instance that is used to reference the version of the instance.
         */
        @Child(name = "key", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ID or acronym of the version", formalDefinition="A unique string within the instance that is used to reference the version of the instance." )
        protected StringType key;

        /**
         * A short descriptive label the version to be used in tables or diagrams.
         */
        @Child(name = "title", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for instance version", formalDefinition="A short descriptive label the version to be used in tables or diagrams." )
        protected StringType title;

        /**
         * An explanation of what this specific version of the instance contains and represents.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Details about version", formalDefinition="An explanation of what this specific version of the instance contains and represents." )
        protected MarkdownType description;

        /**
         * Points to an instance (typically an example) that shows the data that would flow at this point in the scenario.
         */
        @Child(name = "content", type = {Reference.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Example instance version data", formalDefinition="Points to an instance (typically an example) that shows the data that would flow at this point in the scenario." )
        protected Reference content;

        private static final long serialVersionUID = -1218548928L;

    /**
     * Constructor
     */
      public ExampleScenarioInstanceVersionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioInstanceVersionComponent(String key, String title) {
        super();
        this.setKey(key);
        this.setTitle(title);
      }

        /**
         * @return {@link #key} (A unique string within the instance that is used to reference the version of the instance.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public StringType getKeyElement() { 
          if (this.key == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceVersionComponent.key");
            else if (Configuration.doAutoCreate())
              this.key = new StringType(); // bb
          return this.key;
        }

        public boolean hasKeyElement() { 
          return this.key != null && !this.key.isEmpty();
        }

        public boolean hasKey() { 
          return this.key != null && !this.key.isEmpty();
        }

        /**
         * @param value {@link #key} (A unique string within the instance that is used to reference the version of the instance.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public ExampleScenarioInstanceVersionComponent setKeyElement(StringType value) { 
          this.key = value;
          return this;
        }

        /**
         * @return A unique string within the instance that is used to reference the version of the instance.
         */
        public String getKey() { 
          return this.key == null ? null : this.key.getValue();
        }

        /**
         * @param value A unique string within the instance that is used to reference the version of the instance.
         */
        public ExampleScenarioInstanceVersionComponent setKey(String value) { 
            if (this.key == null)
              this.key = new StringType();
            this.key.setValue(value);
          return this;
        }

        /**
         * @return {@link #title} (A short descriptive label the version to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceVersionComponent.title");
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
         * @param value {@link #title} (A short descriptive label the version to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioInstanceVersionComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A short descriptive label the version to be used in tables or diagrams.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A short descriptive label the version to be used in tables or diagrams.
         */
        public ExampleScenarioInstanceVersionComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (An explanation of what this specific version of the instance contains and represents.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
         * @param value {@link #description} (An explanation of what this specific version of the instance contains and represents.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioInstanceVersionComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return An explanation of what this specific version of the instance contains and represents.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value An explanation of what this specific version of the instance contains and represents.
         */
        public ExampleScenarioInstanceVersionComponent setDescription(String value) { 
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
         * @return {@link #content} (Points to an instance (typically an example) that shows the data that would flow at this point in the scenario.)
         */
        public Reference getContent() { 
          if (this.content == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceVersionComponent.content");
            else if (Configuration.doAutoCreate())
              this.content = new Reference(); // cc
          return this.content;
        }

        public boolean hasContent() { 
          return this.content != null && !this.content.isEmpty();
        }

        /**
         * @param value {@link #content} (Points to an instance (typically an example) that shows the data that would flow at this point in the scenario.)
         */
        public ExampleScenarioInstanceVersionComponent setContent(Reference value) { 
          this.content = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("key", "string", "A unique string within the instance that is used to reference the version of the instance.", 0, 1, key));
          children.add(new Property("title", "string", "A short descriptive label the version to be used in tables or diagrams.", 0, 1, title));
          children.add(new Property("description", "markdown", "An explanation of what this specific version of the instance contains and represents.", 0, 1, description));
          children.add(new Property("content", "Reference", "Points to an instance (typically an example) that shows the data that would flow at this point in the scenario.", 0, 1, content));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106079: /*key*/  return new Property("key", "string", "A unique string within the instance that is used to reference the version of the instance.", 0, 1, key);
          case 110371416: /*title*/  return new Property("title", "string", "A short descriptive label the version to be used in tables or diagrams.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "An explanation of what this specific version of the instance contains and represents.", 0, 1, description);
          case 951530617: /*content*/  return new Property("content", "Reference", "Points to an instance (typically an example) that shows the data that would flow at this point in the scenario.", 0, 1, content);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106079: // key
          this.key = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 951530617: // content
          this.content = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("key")) {
          this.key = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("content")) {
          this.content = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079:  return getKeyElement();
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case 951530617:  return getContent();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 951530617: /*content*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.version.key");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.version.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.version.description");
        }
        else if (name.equals("content")) {
          this.content = new Reference();
          return this.content;
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
        dst.key = key == null ? null : key.copy();
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        dst.content = content == null ? null : content.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceVersionComponent))
          return false;
        ExampleScenarioInstanceVersionComponent o = (ExampleScenarioInstanceVersionComponent) other_;
        return compareDeep(key, o.key, true) && compareDeep(title, o.title, true) && compareDeep(description, o.description, true)
           && compareDeep(content, o.content, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceVersionComponent))
          return false;
        ExampleScenarioInstanceVersionComponent o = (ExampleScenarioInstanceVersionComponent) other_;
        return compareValues(key, o.key, true) && compareValues(title, o.title, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, title, description
          , content);
      }

  public String fhirType() {
    return "ExampleScenario.instance.version";

  }

  }

    @Block()
    public static class ExampleScenarioInstanceContainedInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A reference to the key of an instance found within this one.
         */
        @Child(name = "instanceReference", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Key of contained instance", formalDefinition="A reference to the key of an instance found within this one." )
        protected StringType instanceReference;

        /**
         * A reference to the key of a specific version of an instance in this instance.
         */
        @Child(name = "versionReference", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Key of contained instance version", formalDefinition="A reference to the key of a specific version of an instance in this instance." )
        protected StringType versionReference;

        private static final long serialVersionUID = 520704935L;

    /**
     * Constructor
     */
      public ExampleScenarioInstanceContainedInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioInstanceContainedInstanceComponent(String instanceReference) {
        super();
        this.setInstanceReference(instanceReference);
      }

        /**
         * @return {@link #instanceReference} (A reference to the key of an instance found within this one.). This is the underlying object with id, value and extensions. The accessor "getInstanceReference" gives direct access to the value
         */
        public StringType getInstanceReferenceElement() { 
          if (this.instanceReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceContainedInstanceComponent.instanceReference");
            else if (Configuration.doAutoCreate())
              this.instanceReference = new StringType(); // bb
          return this.instanceReference;
        }

        public boolean hasInstanceReferenceElement() { 
          return this.instanceReference != null && !this.instanceReference.isEmpty();
        }

        public boolean hasInstanceReference() { 
          return this.instanceReference != null && !this.instanceReference.isEmpty();
        }

        /**
         * @param value {@link #instanceReference} (A reference to the key of an instance found within this one.). This is the underlying object with id, value and extensions. The accessor "getInstanceReference" gives direct access to the value
         */
        public ExampleScenarioInstanceContainedInstanceComponent setInstanceReferenceElement(StringType value) { 
          this.instanceReference = value;
          return this;
        }

        /**
         * @return A reference to the key of an instance found within this one.
         */
        public String getInstanceReference() { 
          return this.instanceReference == null ? null : this.instanceReference.getValue();
        }

        /**
         * @param value A reference to the key of an instance found within this one.
         */
        public ExampleScenarioInstanceContainedInstanceComponent setInstanceReference(String value) { 
            if (this.instanceReference == null)
              this.instanceReference = new StringType();
            this.instanceReference.setValue(value);
          return this;
        }

        /**
         * @return {@link #versionReference} (A reference to the key of a specific version of an instance in this instance.). This is the underlying object with id, value and extensions. The accessor "getVersionReference" gives direct access to the value
         */
        public StringType getVersionReferenceElement() { 
          if (this.versionReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioInstanceContainedInstanceComponent.versionReference");
            else if (Configuration.doAutoCreate())
              this.versionReference = new StringType(); // bb
          return this.versionReference;
        }

        public boolean hasVersionReferenceElement() { 
          return this.versionReference != null && !this.versionReference.isEmpty();
        }

        public boolean hasVersionReference() { 
          return this.versionReference != null && !this.versionReference.isEmpty();
        }

        /**
         * @param value {@link #versionReference} (A reference to the key of a specific version of an instance in this instance.). This is the underlying object with id, value and extensions. The accessor "getVersionReference" gives direct access to the value
         */
        public ExampleScenarioInstanceContainedInstanceComponent setVersionReferenceElement(StringType value) { 
          this.versionReference = value;
          return this;
        }

        /**
         * @return A reference to the key of a specific version of an instance in this instance.
         */
        public String getVersionReference() { 
          return this.versionReference == null ? null : this.versionReference.getValue();
        }

        /**
         * @param value A reference to the key of a specific version of an instance in this instance.
         */
        public ExampleScenarioInstanceContainedInstanceComponent setVersionReference(String value) { 
          if (Utilities.noString(value))
            this.versionReference = null;
          else {
            if (this.versionReference == null)
              this.versionReference = new StringType();
            this.versionReference.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("instanceReference", "string", "A reference to the key of an instance found within this one.", 0, 1, instanceReference));
          children.add(new Property("versionReference", "string", "A reference to the key of a specific version of an instance in this instance.", 0, 1, versionReference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1675877834: /*instanceReference*/  return new Property("instanceReference", "string", "A reference to the key of an instance found within this one.", 0, 1, instanceReference);
          case 357512531: /*versionReference*/  return new Property("versionReference", "string", "A reference to the key of a specific version of an instance in this instance.", 0, 1, versionReference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1675877834: /*instanceReference*/ return this.instanceReference == null ? new Base[0] : new Base[] {this.instanceReference}; // StringType
        case 357512531: /*versionReference*/ return this.versionReference == null ? new Base[0] : new Base[] {this.versionReference}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1675877834: // instanceReference
          this.instanceReference = TypeConvertor.castToString(value); // StringType
          return value;
        case 357512531: // versionReference
          this.versionReference = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("instanceReference")) {
          this.instanceReference = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("versionReference")) {
          this.versionReference = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1675877834:  return getInstanceReferenceElement();
        case 357512531:  return getVersionReferenceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1675877834: /*instanceReference*/ return new String[] {"string"};
        case 357512531: /*versionReference*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("instanceReference")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.containedInstance.instanceReference");
        }
        else if (name.equals("versionReference")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.instance.containedInstance.versionReference");
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
        dst.instanceReference = instanceReference == null ? null : instanceReference.copy();
        dst.versionReference = versionReference == null ? null : versionReference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceContainedInstanceComponent))
          return false;
        ExampleScenarioInstanceContainedInstanceComponent o = (ExampleScenarioInstanceContainedInstanceComponent) other_;
        return compareDeep(instanceReference, o.instanceReference, true) && compareDeep(versionReference, o.versionReference, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioInstanceContainedInstanceComponent))
          return false;
        ExampleScenarioInstanceContainedInstanceComponent o = (ExampleScenarioInstanceContainedInstanceComponent) other_;
        return compareValues(instanceReference, o.instanceReference, true) && compareValues(versionReference, o.versionReference, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(instanceReference, versionReference
          );
      }

  public String fhirType() {
    return "ExampleScenario.instance.containedInstance";

  }

  }

    @Block()
    public static class ExampleScenarioProcessComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A short descriptive label the process to be used in tables or diagrams.
         */
        @Child(name = "title", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Label for procss", formalDefinition="A short descriptive label the process to be used in tables or diagrams." )
        protected StringType title;

        /**
         * An explanation of what the process represents and what it does.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-friendly description of the process", formalDefinition="An explanation of what the process represents and what it does." )
        protected MarkdownType description;

        /**
         * Description of the initial state of the actors, environment and data before the process starts.
         */
        @Child(name = "preConditions", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Status before process starts", formalDefinition="Description of the initial state of the actors, environment and data before the process starts." )
        protected MarkdownType preConditions;

        /**
         * Description of the final state of the actors, environment and data after the process has been successfully completed.
         */
        @Child(name = "postConditions", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Status after successful completion", formalDefinition="Description of the final state of the actors, environment and data after the process has been successfully completed." )
        protected MarkdownType postConditions;

        /**
         * A significant action that occurs as part of the process.
         */
        @Child(name = "step", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Event within of the process", formalDefinition="A significant action that occurs as part of the process." )
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
         * @return {@link #title} (A short descriptive label the process to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
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
         * @param value {@link #title} (A short descriptive label the process to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A short descriptive label the process to be used in tables or diagrams.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A short descriptive label the process to be used in tables or diagrams.
         */
        public ExampleScenarioProcessComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (An explanation of what the process represents and what it does.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
         * @param value {@link #description} (An explanation of what the process represents and what it does.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return An explanation of what the process represents and what it does.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value An explanation of what the process represents and what it does.
         */
        public ExampleScenarioProcessComponent setDescription(String value) { 
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
         * @return {@link #preConditions} (Description of the initial state of the actors, environment and data before the process starts.). This is the underlying object with id, value and extensions. The accessor "getPreConditions" gives direct access to the value
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
         * @param value {@link #preConditions} (Description of the initial state of the actors, environment and data before the process starts.). This is the underlying object with id, value and extensions. The accessor "getPreConditions" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setPreConditionsElement(MarkdownType value) { 
          this.preConditions = value;
          return this;
        }

        /**
         * @return Description of the initial state of the actors, environment and data before the process starts.
         */
        public String getPreConditions() { 
          return this.preConditions == null ? null : this.preConditions.getValue();
        }

        /**
         * @param value Description of the initial state of the actors, environment and data before the process starts.
         */
        public ExampleScenarioProcessComponent setPreConditions(String value) { 
          if (Utilities.noString(value))
            this.preConditions = null;
          else {
            if (this.preConditions == null)
              this.preConditions = new MarkdownType();
            this.preConditions.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #postConditions} (Description of the final state of the actors, environment and data after the process has been successfully completed.). This is the underlying object with id, value and extensions. The accessor "getPostConditions" gives direct access to the value
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
         * @param value {@link #postConditions} (Description of the final state of the actors, environment and data after the process has been successfully completed.). This is the underlying object with id, value and extensions. The accessor "getPostConditions" gives direct access to the value
         */
        public ExampleScenarioProcessComponent setPostConditionsElement(MarkdownType value) { 
          this.postConditions = value;
          return this;
        }

        /**
         * @return Description of the final state of the actors, environment and data after the process has been successfully completed.
         */
        public String getPostConditions() { 
          return this.postConditions == null ? null : this.postConditions.getValue();
        }

        /**
         * @param value Description of the final state of the actors, environment and data after the process has been successfully completed.
         */
        public ExampleScenarioProcessComponent setPostConditions(String value) { 
          if (Utilities.noString(value))
            this.postConditions = null;
          else {
            if (this.postConditions == null)
              this.postConditions = new MarkdownType();
            this.postConditions.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #step} (A significant action that occurs as part of the process.)
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
          children.add(new Property("title", "string", "A short descriptive label the process to be used in tables or diagrams.", 0, 1, title));
          children.add(new Property("description", "markdown", "An explanation of what the process represents and what it does.", 0, 1, description));
          children.add(new Property("preConditions", "markdown", "Description of the initial state of the actors, environment and data before the process starts.", 0, 1, preConditions));
          children.add(new Property("postConditions", "markdown", "Description of the final state of the actors, environment and data after the process has been successfully completed.", 0, 1, postConditions));
          children.add(new Property("step", "", "A significant action that occurs as part of the process.", 0, java.lang.Integer.MAX_VALUE, step));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "A short descriptive label the process to be used in tables or diagrams.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "An explanation of what the process represents and what it does.", 0, 1, description);
          case -1006692933: /*preConditions*/  return new Property("preConditions", "markdown", "Description of the initial state of the actors, environment and data before the process starts.", 0, 1, preConditions);
          case 1738302328: /*postConditions*/  return new Property("postConditions", "markdown", "Description of the final state of the actors, environment and data after the process has been successfully completed.", 0, 1, postConditions);
          case 3540684: /*step*/  return new Property("step", "", "A significant action that occurs as part of the process.", 0, java.lang.Integer.MAX_VALUE, step);
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
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.description");
        }
        else if (name.equals("preConditions")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.preConditions");
        }
        else if (name.equals("postConditions")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.postConditions");
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
         * The sequential number of the step, e.g. 1.2.5.
         */
        @Child(name = "number", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Sequential number of the step", formalDefinition="The sequential number of the step, e.g. 1.2.5." )
        protected StringType number;

        /**
         * Indicates that the step is a complex sub-process with its own steps.
         */
        @Child(name = "process", type = {ExampleScenarioProcessComponent.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Step is nested process", formalDefinition="Indicates that the step is a complex sub-process with its own steps." )
        protected ExampleScenarioProcessComponent process;

        /**
         * Indicates that the step is defined by a seaparate scenario instance.
         */
        @Child(name = "workflow", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Step is nested workflow", formalDefinition="Indicates that the step is defined by a seaparate scenario instance." )
        protected CanonicalType workflow;

        /**
         * The step represents a single operation invoked on receiver by sender.
         */
        @Child(name = "operation", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Step is simple action", formalDefinition="The step represents a single operation invoked on receiver by sender." )
        protected ExampleScenarioProcessStepOperationComponent operation;

        /**
         * Indicates an alternative step that can be taken instead of the sub-process, scenario or operation.  E.g. to represent non-happy-path/exceptional/atypical circumstances.
         */
        @Child(name = "alternative", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Alternate non-typical step action", formalDefinition="Indicates an alternative step that can be taken instead of the sub-process, scenario or operation.  E.g. to represent non-happy-path/exceptional/atypical circumstances." )
        protected List<ExampleScenarioProcessStepAlternativeComponent> alternative;

        /**
         * If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).
         */
        @Child(name = "pause", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pause in the flow?", formalDefinition="If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event)." )
        protected BooleanType pause;

        private static final long serialVersionUID = 674607242L;

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepComponent() {
        super();
      }

        /**
         * @return {@link #number} (The sequential number of the step, e.g. 1.2.5.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public StringType getNumberElement() { 
          if (this.number == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepComponent.number");
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
         * @param value {@link #number} (The sequential number of the step, e.g. 1.2.5.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public ExampleScenarioProcessStepComponent setNumberElement(StringType value) { 
          this.number = value;
          return this;
        }

        /**
         * @return The sequential number of the step, e.g. 1.2.5.
         */
        public String getNumber() { 
          return this.number == null ? null : this.number.getValue();
        }

        /**
         * @param value The sequential number of the step, e.g. 1.2.5.
         */
        public ExampleScenarioProcessStepComponent setNumber(String value) { 
          if (Utilities.noString(value))
            this.number = null;
          else {
            if (this.number == null)
              this.number = new StringType();
            this.number.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #process} (Indicates that the step is a complex sub-process with its own steps.)
         */
        public ExampleScenarioProcessComponent getProcess() { 
          if (this.process == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepComponent.process");
            else if (Configuration.doAutoCreate())
              this.process = new ExampleScenarioProcessComponent(); // cc
          return this.process;
        }

        public boolean hasProcess() { 
          return this.process != null && !this.process.isEmpty();
        }

        /**
         * @param value {@link #process} (Indicates that the step is a complex sub-process with its own steps.)
         */
        public ExampleScenarioProcessStepComponent setProcess(ExampleScenarioProcessComponent value) { 
          this.process = value;
          return this;
        }

        /**
         * @return {@link #workflow} (Indicates that the step is defined by a seaparate scenario instance.). This is the underlying object with id, value and extensions. The accessor "getWorkflow" gives direct access to the value
         */
        public CanonicalType getWorkflowElement() { 
          if (this.workflow == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepComponent.workflow");
            else if (Configuration.doAutoCreate())
              this.workflow = new CanonicalType(); // bb
          return this.workflow;
        }

        public boolean hasWorkflowElement() { 
          return this.workflow != null && !this.workflow.isEmpty();
        }

        public boolean hasWorkflow() { 
          return this.workflow != null && !this.workflow.isEmpty();
        }

        /**
         * @param value {@link #workflow} (Indicates that the step is defined by a seaparate scenario instance.). This is the underlying object with id, value and extensions. The accessor "getWorkflow" gives direct access to the value
         */
        public ExampleScenarioProcessStepComponent setWorkflowElement(CanonicalType value) { 
          this.workflow = value;
          return this;
        }

        /**
         * @return Indicates that the step is defined by a seaparate scenario instance.
         */
        public String getWorkflow() { 
          return this.workflow == null ? null : this.workflow.getValue();
        }

        /**
         * @param value Indicates that the step is defined by a seaparate scenario instance.
         */
        public ExampleScenarioProcessStepComponent setWorkflow(String value) { 
          if (Utilities.noString(value))
            this.workflow = null;
          else {
            if (this.workflow == null)
              this.workflow = new CanonicalType();
            this.workflow.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #operation} (The step represents a single operation invoked on receiver by sender.)
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
         * @param value {@link #operation} (The step represents a single operation invoked on receiver by sender.)
         */
        public ExampleScenarioProcessStepComponent setOperation(ExampleScenarioProcessStepOperationComponent value) { 
          this.operation = value;
          return this;
        }

        /**
         * @return {@link #alternative} (Indicates an alternative step that can be taken instead of the sub-process, scenario or operation.  E.g. to represent non-happy-path/exceptional/atypical circumstances.)
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

        /**
         * @return {@link #pause} (If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).). This is the underlying object with id, value and extensions. The accessor "getPause" gives direct access to the value
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
         * @param value {@link #pause} (If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).). This is the underlying object with id, value and extensions. The accessor "getPause" gives direct access to the value
         */
        public ExampleScenarioProcessStepComponent setPauseElement(BooleanType value) { 
          this.pause = value;
          return this;
        }

        /**
         * @return If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).
         */
        public boolean getPause() { 
          return this.pause == null || this.pause.isEmpty() ? false : this.pause.getValue();
        }

        /**
         * @param value If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).
         */
        public ExampleScenarioProcessStepComponent setPause(boolean value) { 
            if (this.pause == null)
              this.pause = new BooleanType();
            this.pause.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("number", "string", "The sequential number of the step, e.g. 1.2.5.", 0, 1, number));
          children.add(new Property("process", "@ExampleScenario.process", "Indicates that the step is a complex sub-process with its own steps.", 0, 1, process));
          children.add(new Property("workflow", "canonical(ExampleScenario)", "Indicates that the step is defined by a seaparate scenario instance.", 0, 1, workflow));
          children.add(new Property("operation", "", "The step represents a single operation invoked on receiver by sender.", 0, 1, operation));
          children.add(new Property("alternative", "", "Indicates an alternative step that can be taken instead of the sub-process, scenario or operation.  E.g. to represent non-happy-path/exceptional/atypical circumstances.", 0, java.lang.Integer.MAX_VALUE, alternative));
          children.add(new Property("pause", "boolean", "If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).", 0, 1, pause));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1034364087: /*number*/  return new Property("number", "string", "The sequential number of the step, e.g. 1.2.5.", 0, 1, number);
          case -309518737: /*process*/  return new Property("process", "@ExampleScenario.process", "Indicates that the step is a complex sub-process with its own steps.", 0, 1, process);
          case 35379135: /*workflow*/  return new Property("workflow", "canonical(ExampleScenario)", "Indicates that the step is defined by a seaparate scenario instance.", 0, 1, workflow);
          case 1662702951: /*operation*/  return new Property("operation", "", "The step represents a single operation invoked on receiver by sender.", 0, 1, operation);
          case -196794451: /*alternative*/  return new Property("alternative", "", "Indicates an alternative step that can be taken instead of the sub-process, scenario or operation.  E.g. to represent non-happy-path/exceptional/atypical circumstances.", 0, java.lang.Integer.MAX_VALUE, alternative);
          case 106440182: /*pause*/  return new Property("pause", "boolean", "If true, indicates that, following this step, there is a pause in the flow and the subsequent step will occur at some later time (triggered by some event).", 0, 1, pause);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1034364087: /*number*/ return this.number == null ? new Base[0] : new Base[] {this.number}; // StringType
        case -309518737: /*process*/ return this.process == null ? new Base[0] : new Base[] {this.process}; // ExampleScenarioProcessComponent
        case 35379135: /*workflow*/ return this.workflow == null ? new Base[0] : new Base[] {this.workflow}; // CanonicalType
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : new Base[] {this.operation}; // ExampleScenarioProcessStepOperationComponent
        case -196794451: /*alternative*/ return this.alternative == null ? new Base[0] : this.alternative.toArray(new Base[this.alternative.size()]); // ExampleScenarioProcessStepAlternativeComponent
        case 106440182: /*pause*/ return this.pause == null ? new Base[0] : new Base[] {this.pause}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1034364087: // number
          this.number = TypeConvertor.castToString(value); // StringType
          return value;
        case -309518737: // process
          this.process = (ExampleScenarioProcessComponent) value; // ExampleScenarioProcessComponent
          return value;
        case 35379135: // workflow
          this.workflow = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1662702951: // operation
          this.operation = (ExampleScenarioProcessStepOperationComponent) value; // ExampleScenarioProcessStepOperationComponent
          return value;
        case -196794451: // alternative
          this.getAlternative().add((ExampleScenarioProcessStepAlternativeComponent) value); // ExampleScenarioProcessStepAlternativeComponent
          return value;
        case 106440182: // pause
          this.pause = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("number")) {
          this.number = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("process")) {
          this.process = (ExampleScenarioProcessComponent) value; // ExampleScenarioProcessComponent
        } else if (name.equals("workflow")) {
          this.workflow = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("operation")) {
          this.operation = (ExampleScenarioProcessStepOperationComponent) value; // ExampleScenarioProcessStepOperationComponent
        } else if (name.equals("alternative")) {
          this.getAlternative().add((ExampleScenarioProcessStepAlternativeComponent) value);
        } else if (name.equals("pause")) {
          this.pause = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1034364087:  return getNumberElement();
        case -309518737:  return getProcess();
        case 35379135:  return getWorkflowElement();
        case 1662702951:  return getOperation();
        case -196794451:  return addAlternative(); 
        case 106440182:  return getPauseElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1034364087: /*number*/ return new String[] {"string"};
        case -309518737: /*process*/ return new String[] {"@ExampleScenario.process"};
        case 35379135: /*workflow*/ return new String[] {"canonical"};
        case 1662702951: /*operation*/ return new String[] {};
        case -196794451: /*alternative*/ return new String[] {};
        case 106440182: /*pause*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.number");
        }
        else if (name.equals("process")) {
          this.process = new ExampleScenarioProcessComponent();
          return this.process;
        }
        else if (name.equals("workflow")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.workflow");
        }
        else if (name.equals("operation")) {
          this.operation = new ExampleScenarioProcessStepOperationComponent();
          return this.operation;
        }
        else if (name.equals("alternative")) {
          return addAlternative();
        }
        else if (name.equals("pause")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.pause");
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
        dst.number = number == null ? null : number.copy();
        dst.process = process == null ? null : process.copy();
        dst.workflow = workflow == null ? null : workflow.copy();
        dst.operation = operation == null ? null : operation.copy();
        if (alternative != null) {
          dst.alternative = new ArrayList<ExampleScenarioProcessStepAlternativeComponent>();
          for (ExampleScenarioProcessStepAlternativeComponent i : alternative)
            dst.alternative.add(i.copy());
        };
        dst.pause = pause == null ? null : pause.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepComponent))
          return false;
        ExampleScenarioProcessStepComponent o = (ExampleScenarioProcessStepComponent) other_;
        return compareDeep(number, o.number, true) && compareDeep(process, o.process, true) && compareDeep(workflow, o.workflow, true)
           && compareDeep(operation, o.operation, true) && compareDeep(alternative, o.alternative, true) && compareDeep(pause, o.pause, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepComponent))
          return false;
        ExampleScenarioProcessStepComponent o = (ExampleScenarioProcessStepComponent) other_;
        return compareValues(number, o.number, true) && compareValues(workflow, o.workflow, true) && compareValues(pause, o.pause, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(number, process, workflow
          , operation, alternative, pause);
      }

  public String fhirType() {
    return "ExampleScenario.process.step";

  }

  }

    @Block()
    public static class ExampleScenarioProcessStepOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The standardized type of action (FHIR or otherwise).
         */
        @Child(name = "type", type = {Coding.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Kind of action", formalDefinition="The standardized type of action (FHIR or otherwise)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-operation-codes")
        protected Coding type;

        /**
         * A short descriptive label the step to be used in tables or diagrams.
         */
        @Child(name = "title", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for step", formalDefinition="A short descriptive label the step to be used in tables or diagrams." )
        protected StringType title;

        /**
         * The system that invokes the action/transmits the data.
         */
        @Child(name = "initiator", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who starts the operation", formalDefinition="The system that invokes the action/transmits the data." )
        protected StringType initiator;

        /**
         * The system on which the action is invoked/receives the data.
         */
        @Child(name = "receiver", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who receives the operation", formalDefinition="The system on which the action is invoked/receives the data." )
        protected StringType receiver;

        /**
         * An explanation of what the operation represents and what it does.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-friendly description of the operation", formalDefinition="An explanation of what the operation represents and what it does." )
        protected MarkdownType description;

        /**
         * If false, the initiator is deactivated right after the operation.
         */
        @Child(name = "initiatorActive", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Initiator stays active?", formalDefinition="If false, the initiator is deactivated right after the operation." )
        protected BooleanType initiatorActive;

        /**
         * If false, the receiver is deactivated right after the operation.
         */
        @Child(name = "receiverActive", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Receiver stays active?", formalDefinition="If false, the receiver is deactivated right after the operation." )
        protected BooleanType receiverActive;

        /**
         * A reference to the instance that is transmitted from requester to receiver as part of the invocation of the operation.
         */
        @Child(name = "request", type = {ExampleScenarioInstanceContainedInstanceComponent.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Instance transmitted on invocation", formalDefinition="A reference to the instance that is transmitted from requester to receiver as part of the invocation of the operation." )
        protected ExampleScenarioInstanceContainedInstanceComponent request;

        /**
         * A reference to the instance that is transmitted from receiver to requester as part of the operation's synchronous response (if any).
         */
        @Child(name = "response", type = {ExampleScenarioInstanceContainedInstanceComponent.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Instance transmitted on invocation response", formalDefinition="A reference to the instance that is transmitted from receiver to requester as part of the operation's synchronous response (if any)." )
        protected ExampleScenarioInstanceContainedInstanceComponent response;

        private static final long serialVersionUID = -252586646L;

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepOperationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ExampleScenarioProcessStepOperationComponent(String title) {
        super();
        this.setTitle(title);
      }

        /**
         * @return {@link #type} (The standardized type of action (FHIR or otherwise).)
         */
        public Coding getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Coding(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The standardized type of action (FHIR or otherwise).)
         */
        public ExampleScenarioProcessStepOperationComponent setType(Coding value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #title} (A short descriptive label the step to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ExampleScenarioProcessStepOperationComponent.title");
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
         * @param value {@link #title} (A short descriptive label the step to be used in tables or diagrams.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A short descriptive label the step to be used in tables or diagrams.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A short descriptive label the step to be used in tables or diagrams.
         */
        public ExampleScenarioProcessStepOperationComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          return this;
        }

        /**
         * @return {@link #initiator} (The system that invokes the action/transmits the data.). This is the underlying object with id, value and extensions. The accessor "getInitiator" gives direct access to the value
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
         * @param value {@link #initiator} (The system that invokes the action/transmits the data.). This is the underlying object with id, value and extensions. The accessor "getInitiator" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setInitiatorElement(StringType value) { 
          this.initiator = value;
          return this;
        }

        /**
         * @return The system that invokes the action/transmits the data.
         */
        public String getInitiator() { 
          return this.initiator == null ? null : this.initiator.getValue();
        }

        /**
         * @param value The system that invokes the action/transmits the data.
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
         * @return {@link #receiver} (The system on which the action is invoked/receives the data.). This is the underlying object with id, value and extensions. The accessor "getReceiver" gives direct access to the value
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
         * @param value {@link #receiver} (The system on which the action is invoked/receives the data.). This is the underlying object with id, value and extensions. The accessor "getReceiver" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setReceiverElement(StringType value) { 
          this.receiver = value;
          return this;
        }

        /**
         * @return The system on which the action is invoked/receives the data.
         */
        public String getReceiver() { 
          return this.receiver == null ? null : this.receiver.getValue();
        }

        /**
         * @param value The system on which the action is invoked/receives the data.
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
         * @return {@link #description} (An explanation of what the operation represents and what it does.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
         * @param value {@link #description} (An explanation of what the operation represents and what it does.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return An explanation of what the operation represents and what it does.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value An explanation of what the operation represents and what it does.
         */
        public ExampleScenarioProcessStepOperationComponent setDescription(String value) { 
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
         * @return {@link #initiatorActive} (If false, the initiator is deactivated right after the operation.). This is the underlying object with id, value and extensions. The accessor "getInitiatorActive" gives direct access to the value
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
         * @param value {@link #initiatorActive} (If false, the initiator is deactivated right after the operation.). This is the underlying object with id, value and extensions. The accessor "getInitiatorActive" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setInitiatorActiveElement(BooleanType value) { 
          this.initiatorActive = value;
          return this;
        }

        /**
         * @return If false, the initiator is deactivated right after the operation.
         */
        public boolean getInitiatorActive() { 
          return this.initiatorActive == null || this.initiatorActive.isEmpty() ? false : this.initiatorActive.getValue();
        }

        /**
         * @param value If false, the initiator is deactivated right after the operation.
         */
        public ExampleScenarioProcessStepOperationComponent setInitiatorActive(boolean value) { 
            if (this.initiatorActive == null)
              this.initiatorActive = new BooleanType();
            this.initiatorActive.setValue(value);
          return this;
        }

        /**
         * @return {@link #receiverActive} (If false, the receiver is deactivated right after the operation.). This is the underlying object with id, value and extensions. The accessor "getReceiverActive" gives direct access to the value
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
         * @param value {@link #receiverActive} (If false, the receiver is deactivated right after the operation.). This is the underlying object with id, value and extensions. The accessor "getReceiverActive" gives direct access to the value
         */
        public ExampleScenarioProcessStepOperationComponent setReceiverActiveElement(BooleanType value) { 
          this.receiverActive = value;
          return this;
        }

        /**
         * @return If false, the receiver is deactivated right after the operation.
         */
        public boolean getReceiverActive() { 
          return this.receiverActive == null || this.receiverActive.isEmpty() ? false : this.receiverActive.getValue();
        }

        /**
         * @param value If false, the receiver is deactivated right after the operation.
         */
        public ExampleScenarioProcessStepOperationComponent setReceiverActive(boolean value) { 
            if (this.receiverActive == null)
              this.receiverActive = new BooleanType();
            this.receiverActive.setValue(value);
          return this;
        }

        /**
         * @return {@link #request} (A reference to the instance that is transmitted from requester to receiver as part of the invocation of the operation.)
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
         * @param value {@link #request} (A reference to the instance that is transmitted from requester to receiver as part of the invocation of the operation.)
         */
        public ExampleScenarioProcessStepOperationComponent setRequest(ExampleScenarioInstanceContainedInstanceComponent value) { 
          this.request = value;
          return this;
        }

        /**
         * @return {@link #response} (A reference to the instance that is transmitted from receiver to requester as part of the operation's synchronous response (if any).)
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
         * @param value {@link #response} (A reference to the instance that is transmitted from receiver to requester as part of the operation's synchronous response (if any).)
         */
        public ExampleScenarioProcessStepOperationComponent setResponse(ExampleScenarioInstanceContainedInstanceComponent value) { 
          this.response = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "Coding", "The standardized type of action (FHIR or otherwise).", 0, 1, type));
          children.add(new Property("title", "string", "A short descriptive label the step to be used in tables or diagrams.", 0, 1, title));
          children.add(new Property("initiator", "string", "The system that invokes the action/transmits the data.", 0, 1, initiator));
          children.add(new Property("receiver", "string", "The system on which the action is invoked/receives the data.", 0, 1, receiver));
          children.add(new Property("description", "markdown", "An explanation of what the operation represents and what it does.", 0, 1, description));
          children.add(new Property("initiatorActive", "boolean", "If false, the initiator is deactivated right after the operation.", 0, 1, initiatorActive));
          children.add(new Property("receiverActive", "boolean", "If false, the receiver is deactivated right after the operation.", 0, 1, receiverActive));
          children.add(new Property("request", "@ExampleScenario.instance.containedInstance", "A reference to the instance that is transmitted from requester to receiver as part of the invocation of the operation.", 0, 1, request));
          children.add(new Property("response", "@ExampleScenario.instance.containedInstance", "A reference to the instance that is transmitted from receiver to requester as part of the operation's synchronous response (if any).", 0, 1, response));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "Coding", "The standardized type of action (FHIR or otherwise).", 0, 1, type);
          case 110371416: /*title*/  return new Property("title", "string", "A short descriptive label the step to be used in tables or diagrams.", 0, 1, title);
          case -248987089: /*initiator*/  return new Property("initiator", "string", "The system that invokes the action/transmits the data.", 0, 1, initiator);
          case -808719889: /*receiver*/  return new Property("receiver", "string", "The system on which the action is invoked/receives the data.", 0, 1, receiver);
          case -1724546052: /*description*/  return new Property("description", "markdown", "An explanation of what the operation represents and what it does.", 0, 1, description);
          case 384339477: /*initiatorActive*/  return new Property("initiatorActive", "boolean", "If false, the initiator is deactivated right after the operation.", 0, 1, initiatorActive);
          case -285284907: /*receiverActive*/  return new Property("receiverActive", "boolean", "If false, the receiver is deactivated right after the operation.", 0, 1, receiverActive);
          case 1095692943: /*request*/  return new Property("request", "@ExampleScenario.instance.containedInstance", "A reference to the instance that is transmitted from requester to receiver as part of the invocation of the operation.", 0, 1, request);
          case -340323263: /*response*/  return new Property("response", "@ExampleScenario.instance.containedInstance", "A reference to the instance that is transmitted from receiver to requester as part of the operation's synchronous response (if any).", 0, 1, response);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Coding
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
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
        case 3575610: // type
          this.type = TypeConvertor.castToCoding(value); // Coding
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
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
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
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
        case 3575610:  return getType();
        case 110371416:  return getTitleElement();
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
        case 3575610: /*type*/ return new String[] {"Coding"};
        case 110371416: /*title*/ return new String[] {"string"};
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
        if (name.equals("type")) {
          this.type = new Coding();
          return this.type;
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.operation.title");
        }
        else if (name.equals("initiator")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.operation.initiator");
        }
        else if (name.equals("receiver")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.operation.receiver");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.operation.description");
        }
        else if (name.equals("initiatorActive")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.operation.initiatorActive");
        }
        else if (name.equals("receiverActive")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.operation.receiverActive");
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
        dst.type = type == null ? null : type.copy();
        dst.title = title == null ? null : title.copy();
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
        return compareDeep(type, o.type, true) && compareDeep(title, o.title, true) && compareDeep(initiator, o.initiator, true)
           && compareDeep(receiver, o.receiver, true) && compareDeep(description, o.description, true) && compareDeep(initiatorActive, o.initiatorActive, true)
           && compareDeep(receiverActive, o.receiverActive, true) && compareDeep(request, o.request, true)
           && compareDeep(response, o.response, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExampleScenarioProcessStepOperationComponent))
          return false;
        ExampleScenarioProcessStepOperationComponent o = (ExampleScenarioProcessStepOperationComponent) other_;
        return compareValues(title, o.title, true) && compareValues(initiator, o.initiator, true) && compareValues(receiver, o.receiver, true)
           && compareValues(description, o.description, true) && compareValues(initiatorActive, o.initiatorActive, true)
           && compareValues(receiverActive, o.receiverActive, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, title, initiator, receiver
          , description, initiatorActive, receiverActive, request, response);
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
        @Description(shortDefinition="Human-readable description of option", formalDefinition="A human-readable description of the alternative explaining when the alternative should occur rather than the base step." )
        protected MarkdownType description;

        /**
         * Indicates the operation, sub-process or scenario that happens if the alternative option is selected.
         */
        @Child(name = "step", type = {ExampleScenarioProcessStepComponent.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Alternative action(s)", formalDefinition="Indicates the operation, sub-process or scenario that happens if the alternative option is selected." )
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
         * @return {@link #step} (Indicates the operation, sub-process or scenario that happens if the alternative option is selected.)
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
          children.add(new Property("step", "@ExampleScenario.process.step", "Indicates the operation, sub-process or scenario that happens if the alternative option is selected.", 0, java.lang.Integer.MAX_VALUE, step));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "The label to display for the alternative that gives a sense of the circumstance in which the alternative should be invoked.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A human-readable description of the alternative explaining when the alternative should occur rather than the base step.", 0, 1, description);
          case 3540684: /*step*/  return new Property("step", "@ExampleScenario.process.step", "Indicates the operation, sub-process or scenario that happens if the alternative option is selected.", 0, java.lang.Integer.MAX_VALUE, step);
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
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.alternative.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.process.step.alternative.description");
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
     * An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this example scenario, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers." )
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
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * Temporarily retained for tooling purposes.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="To be removed?", formalDefinition="Temporarily retained for tooling purposes." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the ExampleScenario.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this example scenario (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the ExampleScenario." )
    protected StringType title;

    /**
     * The status of this example scenario. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this example scenario. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition')." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.
     */
    @Child(name = "publisher", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the ExampleScenario from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Natural language description of the ExampleScenario", formalDefinition="A free text natural language description of the ExampleScenario from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the example scenario is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for example scenario (if applicable)", formalDefinition="A legal or geographic region in which the example scenario is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The purpose of the example, e.g. to illustrate a scenario", formalDefinition="What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * A system or person who shares or receives an instance within the scenario.
     */
    @Child(name = "actor", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Individual involved in exchange", formalDefinition="A system or person who shares or receives an instance within the scenario." )
    protected List<ExampleScenarioActorComponent> actor;

    /**
     * A single data collection that is shared as part of the scenario.
     */
    @Child(name = "instance", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Data used in the scenario", formalDefinition="A single data collection that is shared as part of the scenario." )
    protected List<ExampleScenarioInstanceComponent> instance;

    /**
     * A group of operations that represents a significant step within a scenario.
     */
    @Child(name = "process", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Major process within scenario", formalDefinition="A group of operations that represents a significant step within a scenario." )
    protected List<ExampleScenarioProcessComponent> process;

    private static final long serialVersionUID = 292494233L;

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
     * @return {@link #url} (An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
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
     * @param value {@link #url} (An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ExampleScenario setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.
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
    public ExampleScenario setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for ExampleScenario.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (Temporarily retained for tooling purposes.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
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
     * @param value {@link #name} (Temporarily retained for tooling purposes.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ExampleScenario setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return Temporarily retained for tooling purposes.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value Temporarily retained for tooling purposes.
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the ExampleScenario.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the ExampleScenario.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ExampleScenario setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the ExampleScenario.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the ExampleScenario.
     */
    public ExampleScenario setTitle(String value) { 
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
     * @return {@link #date} (The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
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
     * @param value {@link #date} (The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ExampleScenario setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public ExampleScenario setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.
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
     * @return {@link #description} (A free text natural language description of the ExampleScenario from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExampleScenario.description");
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
     * @param value {@link #description} (A free text natural language description of the ExampleScenario from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ExampleScenario setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the ExampleScenario from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the ExampleScenario from a consumer's perspective.
     */
    public ExampleScenario setDescription(String value) { 
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
          throw new Error("Attempt to auto-create ExampleScenario.copyrightLabel");
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
    public ExampleScenario setCopyrightLabelElement(StringType value) { 
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
    public ExampleScenario setCopyrightLabel(String value) { 
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
     * @return {@link #actor} (A system or person who shares or receives an instance within the scenario.)
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
     * @return {@link #instance} (A single data collection that is shared as part of the scenario.)
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
     * @return {@link #process} (A group of operations that represents a significant step within a scenario.)
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "Temporarily retained for tooling purposes.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the ExampleScenario.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this example scenario. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the ExampleScenario from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the example scenario is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("actor", "", "A system or person who shares or receives an instance within the scenario.", 0, java.lang.Integer.MAX_VALUE, actor));
        children.add(new Property("instance", "", "A single data collection that is shared as part of the scenario.", 0, java.lang.Integer.MAX_VALUE, instance));
        children.add(new Property("process", "", "A group of operations that represents a significant step within a scenario.", 0, java.lang.Integer.MAX_VALUE, process));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this example scenario when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this example scenario is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the example scenario is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this example scenario when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the example scenario when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the example scenario author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "Temporarily retained for tooling purposes.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the ExampleScenario.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this example scenario. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this example scenario is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the example scenario was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the example scenario changes. (e.g. the 'content logical definition').", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the example scenario.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the ExampleScenario from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate example scenario instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the example scenario is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "What the example scenario resource is created for. This should not be used to show the business purpose of the scenario itself, but the purpose of documenting a scenario.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the example scenario and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the example scenario.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 92645877: /*actor*/  return new Property("actor", "", "A system or person who shares or receives an instance within the scenario.", 0, java.lang.Integer.MAX_VALUE, actor);
        case 555127957: /*instance*/  return new Property("instance", "", "A single data collection that is shared as part of the scenario.", 0, java.lang.Integer.MAX_VALUE, instance);
        case -309518737: /*process*/  return new Property("process", "", "A group of operations that represents a significant step within a scenario.", 0, java.lang.Integer.MAX_VALUE, process);
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
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : this.actor.toArray(new Base[this.actor.size()]); // ExampleScenarioActorComponent
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : this.instance.toArray(new Base[this.instance.size()]); // ExampleScenarioInstanceComponent
        case -309518737: /*process*/ return this.process == null ? new Base[0] : this.process.toArray(new Base[this.process.size()]); // ExampleScenarioProcessComponent
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
        case 92645877: // actor
          this.getActor().add((ExampleScenarioActorComponent) value); // ExampleScenarioActorComponent
          return value;
        case 555127957: // instance
          this.getInstance().add((ExampleScenarioInstanceComponent) value); // ExampleScenarioInstanceComponent
          return value;
        case -309518737: // process
          this.getProcess().add((ExampleScenarioProcessComponent) value); // ExampleScenarioProcessComponent
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
        } else if (name.equals("actor")) {
          this.getActor().add((ExampleScenarioActorComponent) value);
        } else if (name.equals("instance")) {
          this.getInstance().add((ExampleScenarioInstanceComponent) value);
        } else if (name.equals("process")) {
          this.getProcess().add((ExampleScenarioProcessComponent) value);
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
        case -115699031:  return getVersionAlgorithm();
        case 1508158071:  return getVersionAlgorithm();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
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
        case 92645877:  return addActor(); 
        case 555127957:  return addInstance(); 
        case -309518737:  return addProcess(); 
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
        case 92645877: /*actor*/ return new String[] {};
        case 555127957: /*instance*/ return new String[] {};
        case -309518737: /*process*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.version");
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
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a singleton property ExampleScenario.copyrightLabel");
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
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
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
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(actor, o.actor, true) && compareDeep(instance, o.instance, true) && compareDeep(process, o.process, true)
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
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, experimental, date, publisher, contact
          , description, useContext, jurisdiction, purpose, copyright, copyrightLabel, actor
          , instance, process);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ExampleScenario;
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

