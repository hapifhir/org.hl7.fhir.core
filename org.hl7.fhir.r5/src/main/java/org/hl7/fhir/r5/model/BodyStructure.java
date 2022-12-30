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
 * Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.
 */
@ResourceDef(name="BodyStructure", profile="http://hl7.org/fhir/StructureDefinition/BodyStructure")
public class BodyStructure extends DomainResource {

    @Block()
    public static class BodyStructureIncludedStructureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code that represents the included structure.
         */
        @Child(name = "structure", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Code that represents the included structure", formalDefinition="Code that represents the included structure." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected CodeableConcept structure;

        /**
         * Code that represents the included structure laterality.
         */
        @Child(name = "laterality", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code that represents the included structure laterality", formalDefinition="Code that represents the included structure laterality." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-relative-location")
        protected CodeableConcept laterality;

        /**
         * Code that represents the included structure qualifier.
         */
        @Child(name = "qualifier", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Code that represents the included structure qualifier", formalDefinition="Code that represents the included structure qualifier." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-relative-location")
        protected List<CodeableConcept> qualifier;

        private static final long serialVersionUID = -2036673377L;

    /**
     * Constructor
     */
      public BodyStructureIncludedStructureComponent() {
        super();
      }

    /**
     * Constructor
     */
      public BodyStructureIncludedStructureComponent(CodeableConcept structure) {
        super();
        this.setStructure(structure);
      }

        /**
         * @return {@link #structure} (Code that represents the included structure.)
         */
        public CodeableConcept getStructure() { 
          if (this.structure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BodyStructureIncludedStructureComponent.structure");
            else if (Configuration.doAutoCreate())
              this.structure = new CodeableConcept(); // cc
          return this.structure;
        }

        public boolean hasStructure() { 
          return this.structure != null && !this.structure.isEmpty();
        }

        /**
         * @param value {@link #structure} (Code that represents the included structure.)
         */
        public BodyStructureIncludedStructureComponent setStructure(CodeableConcept value) { 
          this.structure = value;
          return this;
        }

        /**
         * @return {@link #laterality} (Code that represents the included structure laterality.)
         */
        public CodeableConcept getLaterality() { 
          if (this.laterality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BodyStructureIncludedStructureComponent.laterality");
            else if (Configuration.doAutoCreate())
              this.laterality = new CodeableConcept(); // cc
          return this.laterality;
        }

        public boolean hasLaterality() { 
          return this.laterality != null && !this.laterality.isEmpty();
        }

        /**
         * @param value {@link #laterality} (Code that represents the included structure laterality.)
         */
        public BodyStructureIncludedStructureComponent setLaterality(CodeableConcept value) { 
          this.laterality = value;
          return this;
        }

        /**
         * @return {@link #qualifier} (Code that represents the included structure qualifier.)
         */
        public List<CodeableConcept> getQualifier() { 
          if (this.qualifier == null)
            this.qualifier = new ArrayList<CodeableConcept>();
          return this.qualifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureComponent setQualifier(List<CodeableConcept> theQualifier) { 
          this.qualifier = theQualifier;
          return this;
        }

        public boolean hasQualifier() { 
          if (this.qualifier == null)
            return false;
          for (CodeableConcept item : this.qualifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addQualifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.qualifier == null)
            this.qualifier = new ArrayList<CodeableConcept>();
          this.qualifier.add(t);
          return t;
        }

        public BodyStructureIncludedStructureComponent addQualifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.qualifier == null)
            this.qualifier = new ArrayList<CodeableConcept>();
          this.qualifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #qualifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getQualifierFirstRep() { 
          if (getQualifier().isEmpty()) {
            addQualifier();
          }
          return getQualifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("structure", "CodeableConcept", "Code that represents the included structure.", 0, 1, structure));
          children.add(new Property("laterality", "CodeableConcept", "Code that represents the included structure laterality.", 0, 1, laterality));
          children.add(new Property("qualifier", "CodeableConcept", "Code that represents the included structure qualifier.", 0, java.lang.Integer.MAX_VALUE, qualifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 144518515: /*structure*/  return new Property("structure", "CodeableConcept", "Code that represents the included structure.", 0, 1, structure);
          case -170291817: /*laterality*/  return new Property("laterality", "CodeableConcept", "Code that represents the included structure laterality.", 0, 1, laterality);
          case -1247940438: /*qualifier*/  return new Property("qualifier", "CodeableConcept", "Code that represents the included structure qualifier.", 0, java.lang.Integer.MAX_VALUE, qualifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 144518515: /*structure*/ return this.structure == null ? new Base[0] : new Base[] {this.structure}; // CodeableConcept
        case -170291817: /*laterality*/ return this.laterality == null ? new Base[0] : new Base[] {this.laterality}; // CodeableConcept
        case -1247940438: /*qualifier*/ return this.qualifier == null ? new Base[0] : this.qualifier.toArray(new Base[this.qualifier.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 144518515: // structure
          this.structure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -170291817: // laterality
          this.laterality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1247940438: // qualifier
          this.getQualifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("structure")) {
          this.structure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("laterality")) {
          this.laterality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("qualifier")) {
          this.getQualifier().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 144518515:  return getStructure();
        case -170291817:  return getLaterality();
        case -1247940438:  return addQualifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 144518515: /*structure*/ return new String[] {"CodeableConcept"};
        case -170291817: /*laterality*/ return new String[] {"CodeableConcept"};
        case -1247940438: /*qualifier*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("structure")) {
          this.structure = new CodeableConcept();
          return this.structure;
        }
        else if (name.equals("laterality")) {
          this.laterality = new CodeableConcept();
          return this.laterality;
        }
        else if (name.equals("qualifier")) {
          return addQualifier();
        }
        else
          return super.addChild(name);
      }

      public BodyStructureIncludedStructureComponent copy() {
        BodyStructureIncludedStructureComponent dst = new BodyStructureIncludedStructureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BodyStructureIncludedStructureComponent dst) {
        super.copyValues(dst);
        dst.structure = structure == null ? null : structure.copy();
        dst.laterality = laterality == null ? null : laterality.copy();
        if (qualifier != null) {
          dst.qualifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : qualifier)
            dst.qualifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BodyStructureIncludedStructureComponent))
          return false;
        BodyStructureIncludedStructureComponent o = (BodyStructureIncludedStructureComponent) other_;
        return compareDeep(structure, o.structure, true) && compareDeep(laterality, o.laterality, true)
           && compareDeep(qualifier, o.qualifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BodyStructureIncludedStructureComponent))
          return false;
        BodyStructureIncludedStructureComponent o = (BodyStructureIncludedStructureComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(structure, laterality, qualifier
          );
      }

  public String fhirType() {
    return "BodyStructure.includedStructure";

  }

  }

    @Block()
    public static class BodyStructureExcludedStructureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code that represents the excluded structure.
         */
        @Child(name = "structure", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Code that represents the excluded structure", formalDefinition="Code that represents the excluded structure." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected CodeableConcept structure;

        /**
         * Code that represents the excluded structure laterality.
         */
        @Child(name = "laterality", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code that represents the excluded structure laterality", formalDefinition="Code that represents the excluded structure laterality." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-relative-location")
        protected CodeableConcept laterality;

        /**
         * Code that represents the excluded structure qualifier.
         */
        @Child(name = "qualifier", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Code that represents the excluded structure qualifier", formalDefinition="Code that represents the excluded structure qualifier." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-relative-location")
        protected List<CodeableConcept> qualifier;

        private static final long serialVersionUID = -2036673377L;

    /**
     * Constructor
     */
      public BodyStructureExcludedStructureComponent() {
        super();
      }

    /**
     * Constructor
     */
      public BodyStructureExcludedStructureComponent(CodeableConcept structure) {
        super();
        this.setStructure(structure);
      }

        /**
         * @return {@link #structure} (Code that represents the excluded structure.)
         */
        public CodeableConcept getStructure() { 
          if (this.structure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BodyStructureExcludedStructureComponent.structure");
            else if (Configuration.doAutoCreate())
              this.structure = new CodeableConcept(); // cc
          return this.structure;
        }

        public boolean hasStructure() { 
          return this.structure != null && !this.structure.isEmpty();
        }

        /**
         * @param value {@link #structure} (Code that represents the excluded structure.)
         */
        public BodyStructureExcludedStructureComponent setStructure(CodeableConcept value) { 
          this.structure = value;
          return this;
        }

        /**
         * @return {@link #laterality} (Code that represents the excluded structure laterality.)
         */
        public CodeableConcept getLaterality() { 
          if (this.laterality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BodyStructureExcludedStructureComponent.laterality");
            else if (Configuration.doAutoCreate())
              this.laterality = new CodeableConcept(); // cc
          return this.laterality;
        }

        public boolean hasLaterality() { 
          return this.laterality != null && !this.laterality.isEmpty();
        }

        /**
         * @param value {@link #laterality} (Code that represents the excluded structure laterality.)
         */
        public BodyStructureExcludedStructureComponent setLaterality(CodeableConcept value) { 
          this.laterality = value;
          return this;
        }

        /**
         * @return {@link #qualifier} (Code that represents the excluded structure qualifier.)
         */
        public List<CodeableConcept> getQualifier() { 
          if (this.qualifier == null)
            this.qualifier = new ArrayList<CodeableConcept>();
          return this.qualifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureExcludedStructureComponent setQualifier(List<CodeableConcept> theQualifier) { 
          this.qualifier = theQualifier;
          return this;
        }

        public boolean hasQualifier() { 
          if (this.qualifier == null)
            return false;
          for (CodeableConcept item : this.qualifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addQualifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.qualifier == null)
            this.qualifier = new ArrayList<CodeableConcept>();
          this.qualifier.add(t);
          return t;
        }

        public BodyStructureExcludedStructureComponent addQualifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.qualifier == null)
            this.qualifier = new ArrayList<CodeableConcept>();
          this.qualifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #qualifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getQualifierFirstRep() { 
          if (getQualifier().isEmpty()) {
            addQualifier();
          }
          return getQualifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("structure", "CodeableConcept", "Code that represents the excluded structure.", 0, 1, structure));
          children.add(new Property("laterality", "CodeableConcept", "Code that represents the excluded structure laterality.", 0, 1, laterality));
          children.add(new Property("qualifier", "CodeableConcept", "Code that represents the excluded structure qualifier.", 0, java.lang.Integer.MAX_VALUE, qualifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 144518515: /*structure*/  return new Property("structure", "CodeableConcept", "Code that represents the excluded structure.", 0, 1, structure);
          case -170291817: /*laterality*/  return new Property("laterality", "CodeableConcept", "Code that represents the excluded structure laterality.", 0, 1, laterality);
          case -1247940438: /*qualifier*/  return new Property("qualifier", "CodeableConcept", "Code that represents the excluded structure qualifier.", 0, java.lang.Integer.MAX_VALUE, qualifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 144518515: /*structure*/ return this.structure == null ? new Base[0] : new Base[] {this.structure}; // CodeableConcept
        case -170291817: /*laterality*/ return this.laterality == null ? new Base[0] : new Base[] {this.laterality}; // CodeableConcept
        case -1247940438: /*qualifier*/ return this.qualifier == null ? new Base[0] : this.qualifier.toArray(new Base[this.qualifier.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 144518515: // structure
          this.structure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -170291817: // laterality
          this.laterality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1247940438: // qualifier
          this.getQualifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("structure")) {
          this.structure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("laterality")) {
          this.laterality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("qualifier")) {
          this.getQualifier().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 144518515:  return getStructure();
        case -170291817:  return getLaterality();
        case -1247940438:  return addQualifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 144518515: /*structure*/ return new String[] {"CodeableConcept"};
        case -170291817: /*laterality*/ return new String[] {"CodeableConcept"};
        case -1247940438: /*qualifier*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("structure")) {
          this.structure = new CodeableConcept();
          return this.structure;
        }
        else if (name.equals("laterality")) {
          this.laterality = new CodeableConcept();
          return this.laterality;
        }
        else if (name.equals("qualifier")) {
          return addQualifier();
        }
        else
          return super.addChild(name);
      }

      public BodyStructureExcludedStructureComponent copy() {
        BodyStructureExcludedStructureComponent dst = new BodyStructureExcludedStructureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BodyStructureExcludedStructureComponent dst) {
        super.copyValues(dst);
        dst.structure = structure == null ? null : structure.copy();
        dst.laterality = laterality == null ? null : laterality.copy();
        if (qualifier != null) {
          dst.qualifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : qualifier)
            dst.qualifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BodyStructureExcludedStructureComponent))
          return false;
        BodyStructureExcludedStructureComponent o = (BodyStructureExcludedStructureComponent) other_;
        return compareDeep(structure, o.structure, true) && compareDeep(laterality, o.laterality, true)
           && compareDeep(qualifier, o.qualifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BodyStructureExcludedStructureComponent))
          return false;
        BodyStructureExcludedStructureComponent o = (BodyStructureExcludedStructureComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(structure, laterality, qualifier
          );
      }

  public String fhirType() {
    return "BodyStructure.excludedStructure";

  }

  }

    /**
     * Identifier for this instance of the anatomical structure.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Bodystructure identifier", formalDefinition="Identifier for this instance of the anatomical structure." )
    protected List<Identifier> identifier;

    /**
     * Whether this body site is in active use.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Whether this record is in active use", formalDefinition="Whether this body site is in active use." )
    protected BooleanType active;

    /**
     * The kind of structure being represented by the body structure at `BodyStructure.location`.  This can define both normal and abnormal morphologies.
     */
    @Child(name = "morphology", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of Structure", formalDefinition="The kind of structure being represented by the body structure at `BodyStructure.location`.  This can define both normal and abnormal morphologies." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-code")
    protected CodeableConcept morphology;

    /**
     * The anatomical location(s) or region(s) of the specimen, lesion, or body structure.
     */
    @Child(name = "includedStructure", type = {}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Included anatomic location(s)", formalDefinition="The anatomical location(s) or region(s) of the specimen, lesion, or body structure." )
    protected List<BodyStructureIncludedStructureComponent> includedStructure;

    /**
     * The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure.
     */
    @Child(name = "excludedStructure", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Excluded anatomic locations(s)", formalDefinition="The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure." )
    protected List<BodyStructureExcludedStructureComponent> excludedStructure;

    /**
     * A summary, characterization or explanation of the body structure.
     */
    @Child(name = "description", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Text description", formalDefinition="A summary, characterization or explanation of the body structure." )
    protected StringType description;

    /**
     * Image or images used to identify a location.
     */
    @Child(name = "image", type = {Attachment.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Attached images", formalDefinition="Image or images used to identify a location." )
    protected List<Attachment> image;

    /**
     * The person to which the body site belongs.
     */
    @Child(name = "patient", type = {Patient.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who this is about", formalDefinition="The person to which the body site belongs." )
    protected Reference patient;

    private static final long serialVersionUID = 1630541250L;

  /**
   * Constructor
   */
    public BodyStructure() {
      super();
    }

  /**
   * Constructor
   */
    public BodyStructure(BodyStructureIncludedStructureComponent includedStructure, Reference patient) {
      super();
      this.addIncludedStructure(includedStructure);
      this.setPatient(patient);
    }

    /**
     * @return {@link #identifier} (Identifier for this instance of the anatomical structure.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BodyStructure setIdentifier(List<Identifier> theIdentifier) { 
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

    public BodyStructure addIdentifier(Identifier t) { //3
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
     * @return {@link #active} (Whether this body site is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BodyStructure.active");
        else if (Configuration.doAutoCreate())
          this.active = new BooleanType(); // bb
      return this.active;
    }

    public boolean hasActiveElement() { 
      return this.active != null && !this.active.isEmpty();
    }

    public boolean hasActive() { 
      return this.active != null && !this.active.isEmpty();
    }

    /**
     * @param value {@link #active} (Whether this body site is in active use.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BodyStructure setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return Whether this body site is in active use.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value Whether this body site is in active use.
     */
    public BodyStructure setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #morphology} (The kind of structure being represented by the body structure at `BodyStructure.location`.  This can define both normal and abnormal morphologies.)
     */
    public CodeableConcept getMorphology() { 
      if (this.morphology == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BodyStructure.morphology");
        else if (Configuration.doAutoCreate())
          this.morphology = new CodeableConcept(); // cc
      return this.morphology;
    }

    public boolean hasMorphology() { 
      return this.morphology != null && !this.morphology.isEmpty();
    }

    /**
     * @param value {@link #morphology} (The kind of structure being represented by the body structure at `BodyStructure.location`.  This can define both normal and abnormal morphologies.)
     */
    public BodyStructure setMorphology(CodeableConcept value) { 
      this.morphology = value;
      return this;
    }

    /**
     * @return {@link #includedStructure} (The anatomical location(s) or region(s) of the specimen, lesion, or body structure.)
     */
    public List<BodyStructureIncludedStructureComponent> getIncludedStructure() { 
      if (this.includedStructure == null)
        this.includedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
      return this.includedStructure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BodyStructure setIncludedStructure(List<BodyStructureIncludedStructureComponent> theIncludedStructure) { 
      this.includedStructure = theIncludedStructure;
      return this;
    }

    public boolean hasIncludedStructure() { 
      if (this.includedStructure == null)
        return false;
      for (BodyStructureIncludedStructureComponent item : this.includedStructure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public BodyStructureIncludedStructureComponent addIncludedStructure() { //3
      BodyStructureIncludedStructureComponent t = new BodyStructureIncludedStructureComponent();
      if (this.includedStructure == null)
        this.includedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
      this.includedStructure.add(t);
      return t;
    }

    public BodyStructure addIncludedStructure(BodyStructureIncludedStructureComponent t) { //3
      if (t == null)
        return this;
      if (this.includedStructure == null)
        this.includedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
      this.includedStructure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #includedStructure}, creating it if it does not already exist {3}
     */
    public BodyStructureIncludedStructureComponent getIncludedStructureFirstRep() { 
      if (getIncludedStructure().isEmpty()) {
        addIncludedStructure();
      }
      return getIncludedStructure().get(0);
    }

    /**
     * @return {@link #excludedStructure} (The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure.)
     */
    public List<BodyStructureExcludedStructureComponent> getExcludedStructure() { 
      if (this.excludedStructure == null)
        this.excludedStructure = new ArrayList<BodyStructureExcludedStructureComponent>();
      return this.excludedStructure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BodyStructure setExcludedStructure(List<BodyStructureExcludedStructureComponent> theExcludedStructure) { 
      this.excludedStructure = theExcludedStructure;
      return this;
    }

    public boolean hasExcludedStructure() { 
      if (this.excludedStructure == null)
        return false;
      for (BodyStructureExcludedStructureComponent item : this.excludedStructure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public BodyStructureExcludedStructureComponent addExcludedStructure() { //3
      BodyStructureExcludedStructureComponent t = new BodyStructureExcludedStructureComponent();
      if (this.excludedStructure == null)
        this.excludedStructure = new ArrayList<BodyStructureExcludedStructureComponent>();
      this.excludedStructure.add(t);
      return t;
    }

    public BodyStructure addExcludedStructure(BodyStructureExcludedStructureComponent t) { //3
      if (t == null)
        return this;
      if (this.excludedStructure == null)
        this.excludedStructure = new ArrayList<BodyStructureExcludedStructureComponent>();
      this.excludedStructure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #excludedStructure}, creating it if it does not already exist {3}
     */
    public BodyStructureExcludedStructureComponent getExcludedStructureFirstRep() { 
      if (getExcludedStructure().isEmpty()) {
        addExcludedStructure();
      }
      return getExcludedStructure().get(0);
    }

    /**
     * @return {@link #description} (A summary, characterization or explanation of the body structure.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BodyStructure.description");
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
     * @param value {@link #description} (A summary, characterization or explanation of the body structure.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public BodyStructure setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A summary, characterization or explanation of the body structure.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A summary, characterization or explanation of the body structure.
     */
    public BodyStructure setDescription(String value) { 
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
     * @return {@link #image} (Image or images used to identify a location.)
     */
    public List<Attachment> getImage() { 
      if (this.image == null)
        this.image = new ArrayList<Attachment>();
      return this.image;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BodyStructure setImage(List<Attachment> theImage) { 
      this.image = theImage;
      return this;
    }

    public boolean hasImage() { 
      if (this.image == null)
        return false;
      for (Attachment item : this.image)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Attachment addImage() { //3
      Attachment t = new Attachment();
      if (this.image == null)
        this.image = new ArrayList<Attachment>();
      this.image.add(t);
      return t;
    }

    public BodyStructure addImage(Attachment t) { //3
      if (t == null)
        return this;
      if (this.image == null)
        this.image = new ArrayList<Attachment>();
      this.image.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #image}, creating it if it does not already exist {3}
     */
    public Attachment getImageFirstRep() { 
      if (getImage().isEmpty()) {
        addImage();
      }
      return getImage().get(0);
    }

    /**
     * @return {@link #patient} (The person to which the body site belongs.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BodyStructure.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The person to which the body site belongs.)
     */
    public BodyStructure setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier for this instance of the anatomical structure.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", "Whether this body site is in active use.", 0, 1, active));
        children.add(new Property("morphology", "CodeableConcept", "The kind of structure being represented by the body structure at `BodyStructure.location`.  This can define both normal and abnormal morphologies.", 0, 1, morphology));
        children.add(new Property("includedStructure", "", "The anatomical location(s) or region(s) of the specimen, lesion, or body structure.", 0, java.lang.Integer.MAX_VALUE, includedStructure));
        children.add(new Property("excludedStructure", "", "The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure.", 0, java.lang.Integer.MAX_VALUE, excludedStructure));
        children.add(new Property("description", "string", "A summary, characterization or explanation of the body structure.", 0, 1, description));
        children.add(new Property("image", "Attachment", "Image or images used to identify a location.", 0, java.lang.Integer.MAX_VALUE, image));
        children.add(new Property("patient", "Reference(Patient)", "The person to which the body site belongs.", 0, 1, patient));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for this instance of the anatomical structure.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", "Whether this body site is in active use.", 0, 1, active);
        case 1807231644: /*morphology*/  return new Property("morphology", "CodeableConcept", "The kind of structure being represented by the body structure at `BodyStructure.location`.  This can define both normal and abnormal morphologies.", 0, 1, morphology);
        case -1174069225: /*includedStructure*/  return new Property("includedStructure", "", "The anatomical location(s) or region(s) of the specimen, lesion, or body structure.", 0, java.lang.Integer.MAX_VALUE, includedStructure);
        case 1192252105: /*excludedStructure*/  return new Property("excludedStructure", "", "The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure.", 0, java.lang.Integer.MAX_VALUE, excludedStructure);
        case -1724546052: /*description*/  return new Property("description", "string", "A summary, characterization or explanation of the body structure.", 0, 1, description);
        case 100313435: /*image*/  return new Property("image", "Attachment", "Image or images used to identify a location.", 0, java.lang.Integer.MAX_VALUE, image);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The person to which the body site belongs.", 0, 1, patient);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1422950650: /*active*/ return this.active == null ? new Base[0] : new Base[] {this.active}; // BooleanType
        case 1807231644: /*morphology*/ return this.morphology == null ? new Base[0] : new Base[] {this.morphology}; // CodeableConcept
        case -1174069225: /*includedStructure*/ return this.includedStructure == null ? new Base[0] : this.includedStructure.toArray(new Base[this.includedStructure.size()]); // BodyStructureIncludedStructureComponent
        case 1192252105: /*excludedStructure*/ return this.excludedStructure == null ? new Base[0] : this.excludedStructure.toArray(new Base[this.excludedStructure.size()]); // BodyStructureExcludedStructureComponent
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 100313435: /*image*/ return this.image == null ? new Base[0] : this.image.toArray(new Base[this.image.size()]); // Attachment
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1422950650: // active
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1807231644: // morphology
          this.morphology = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1174069225: // includedStructure
          this.getIncludedStructure().add((BodyStructureIncludedStructureComponent) value); // BodyStructureIncludedStructureComponent
          return value;
        case 1192252105: // excludedStructure
          this.getExcludedStructure().add((BodyStructureExcludedStructureComponent) value); // BodyStructureExcludedStructureComponent
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 100313435: // image
          this.getImage().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("active")) {
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("morphology")) {
          this.morphology = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("includedStructure")) {
          this.getIncludedStructure().add((BodyStructureIncludedStructureComponent) value);
        } else if (name.equals("excludedStructure")) {
          this.getExcludedStructure().add((BodyStructureExcludedStructureComponent) value);
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("image")) {
          this.getImage().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1422950650:  return getActiveElement();
        case 1807231644:  return getMorphology();
        case -1174069225:  return addIncludedStructure(); 
        case 1192252105:  return addExcludedStructure(); 
        case -1724546052:  return getDescriptionElement();
        case 100313435:  return addImage(); 
        case -791418107:  return getPatient();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1422950650: /*active*/ return new String[] {"boolean"};
        case 1807231644: /*morphology*/ return new String[] {"CodeableConcept"};
        case -1174069225: /*includedStructure*/ return new String[] {};
        case 1192252105: /*excludedStructure*/ return new String[] {};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 100313435: /*image*/ return new String[] {"Attachment"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("active")) {
          throw new FHIRException("Cannot call addChild on a primitive type BodyStructure.active");
        }
        else if (name.equals("morphology")) {
          this.morphology = new CodeableConcept();
          return this.morphology;
        }
        else if (name.equals("includedStructure")) {
          return addIncludedStructure();
        }
        else if (name.equals("excludedStructure")) {
          return addExcludedStructure();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type BodyStructure.description");
        }
        else if (name.equals("image")) {
          return addImage();
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "BodyStructure";

  }

      public BodyStructure copy() {
        BodyStructure dst = new BodyStructure();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BodyStructure dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.active = active == null ? null : active.copy();
        dst.morphology = morphology == null ? null : morphology.copy();
        if (includedStructure != null) {
          dst.includedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
          for (BodyStructureIncludedStructureComponent i : includedStructure)
            dst.includedStructure.add(i.copy());
        };
        if (excludedStructure != null) {
          dst.excludedStructure = new ArrayList<BodyStructureExcludedStructureComponent>();
          for (BodyStructureExcludedStructureComponent i : excludedStructure)
            dst.excludedStructure.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (image != null) {
          dst.image = new ArrayList<Attachment>();
          for (Attachment i : image)
            dst.image.add(i.copy());
        };
        dst.patient = patient == null ? null : patient.copy();
      }

      protected BodyStructure typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BodyStructure))
          return false;
        BodyStructure o = (BodyStructure) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(morphology, o.morphology, true)
           && compareDeep(includedStructure, o.includedStructure, true) && compareDeep(excludedStructure, o.excludedStructure, true)
           && compareDeep(description, o.description, true) && compareDeep(image, o.image, true) && compareDeep(patient, o.patient, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BodyStructure))
          return false;
        BodyStructure o = (BodyStructure) other_;
        return compareValues(active, o.active, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, morphology
          , includedStructure, excludedStructure, description, image, patient);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.BodyStructure;
   }

 /**
   * Search parameter: <b>excluded_structure</b>
   * <p>
   * Description: <b>Body site excludedStructure structure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.excludedStructure.structure</b><br>
   * </p>
   */
  @SearchParamDefinition(name="excluded_structure", path="BodyStructure.excludedStructure.structure", description="Body site excludedStructure structure", type="token" )
  public static final String SP_EXCLUDEDSTRUCTURE = "excluded_structure";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>excluded_structure</b>
   * <p>
   * Description: <b>Body site excludedStructure structure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.excludedStructure.structure</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXCLUDEDSTRUCTURE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EXCLUDEDSTRUCTURE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Bodystructure identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="BodyStructure.identifier", description="Bodystructure identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Bodystructure identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>included_structure</b>
   * <p>
   * Description: <b>Body site includedStructure structure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.includedStructure.structure</b><br>
   * </p>
   */
  @SearchParamDefinition(name="included_structure", path="BodyStructure.includedStructure.structure", description="Body site includedStructure structure", type="token" )
  public static final String SP_INCLUDEDSTRUCTURE = "included_structure";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>included_structure</b>
   * <p>
   * Description: <b>Body site includedStructure structure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.includedStructure.structure</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INCLUDEDSTRUCTURE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INCLUDEDSTRUCTURE);

 /**
   * Search parameter: <b>morphology</b>
   * <p>
   * Description: <b>Kind of Structure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.morphology</b><br>
   * </p>
   */
  @SearchParamDefinition(name="morphology", path="BodyStructure.morphology", description="Kind of Structure", type="token" )
  public static final String SP_MORPHOLOGY = "morphology";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>morphology</b>
   * <p>
   * Description: <b>Kind of Structure</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BodyStructure.morphology</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MORPHOLOGY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MORPHOLOGY);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Who this is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BodyStructure.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="BodyStructure.patient", description="Who this is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Who this is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BodyStructure.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>BodyStructure:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("BodyStructure:patient").toLocked();


}

