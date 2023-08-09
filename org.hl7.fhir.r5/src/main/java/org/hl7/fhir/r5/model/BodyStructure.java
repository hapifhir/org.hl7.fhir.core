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

import org.hl7.fhir.utilities.Utilities;
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
         * Body locations in relation to a specific body landmark (tatoo, scar, other body structure).
         */
        @Child(name = "bodyLandmarkOrientation", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Landmark relative location", formalDefinition="Body locations in relation to a specific body landmark (tatoo, scar, other body structure)." )
        protected List<BodyStructureIncludedStructureBodyLandmarkOrientationComponent> bodyLandmarkOrientation;

        /**
         * XY or XYZ-coordinate orientation for structure.
         */
        @Child(name = "spatialReference", type = {ImagingSelection.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Cartesian reference for structure", formalDefinition="XY or XYZ-coordinate orientation for structure." )
        protected List<Reference> spatialReference;

        /**
         * Code that represents the included structure qualifier.
         */
        @Child(name = "qualifier", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Code that represents the included structure qualifier", formalDefinition="Code that represents the included structure qualifier." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-relative-location")
        protected List<CodeableConcept> qualifier;

        private static final long serialVersionUID = -1341852782L;

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
         * @return {@link #bodyLandmarkOrientation} (Body locations in relation to a specific body landmark (tatoo, scar, other body structure).)
         */
        public List<BodyStructureIncludedStructureBodyLandmarkOrientationComponent> getBodyLandmarkOrientation() { 
          if (this.bodyLandmarkOrientation == null)
            this.bodyLandmarkOrientation = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationComponent>();
          return this.bodyLandmarkOrientation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureComponent setBodyLandmarkOrientation(List<BodyStructureIncludedStructureBodyLandmarkOrientationComponent> theBodyLandmarkOrientation) { 
          this.bodyLandmarkOrientation = theBodyLandmarkOrientation;
          return this;
        }

        public boolean hasBodyLandmarkOrientation() { 
          if (this.bodyLandmarkOrientation == null)
            return false;
          for (BodyStructureIncludedStructureBodyLandmarkOrientationComponent item : this.bodyLandmarkOrientation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent addBodyLandmarkOrientation() { //3
          BodyStructureIncludedStructureBodyLandmarkOrientationComponent t = new BodyStructureIncludedStructureBodyLandmarkOrientationComponent();
          if (this.bodyLandmarkOrientation == null)
            this.bodyLandmarkOrientation = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationComponent>();
          this.bodyLandmarkOrientation.add(t);
          return t;
        }

        public BodyStructureIncludedStructureComponent addBodyLandmarkOrientation(BodyStructureIncludedStructureBodyLandmarkOrientationComponent t) { //3
          if (t == null)
            return this;
          if (this.bodyLandmarkOrientation == null)
            this.bodyLandmarkOrientation = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationComponent>();
          this.bodyLandmarkOrientation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #bodyLandmarkOrientation}, creating it if it does not already exist {3}
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent getBodyLandmarkOrientationFirstRep() { 
          if (getBodyLandmarkOrientation().isEmpty()) {
            addBodyLandmarkOrientation();
          }
          return getBodyLandmarkOrientation().get(0);
        }

        /**
         * @return {@link #spatialReference} (XY or XYZ-coordinate orientation for structure.)
         */
        public List<Reference> getSpatialReference() { 
          if (this.spatialReference == null)
            this.spatialReference = new ArrayList<Reference>();
          return this.spatialReference;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureComponent setSpatialReference(List<Reference> theSpatialReference) { 
          this.spatialReference = theSpatialReference;
          return this;
        }

        public boolean hasSpatialReference() { 
          if (this.spatialReference == null)
            return false;
          for (Reference item : this.spatialReference)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSpatialReference() { //3
          Reference t = new Reference();
          if (this.spatialReference == null)
            this.spatialReference = new ArrayList<Reference>();
          this.spatialReference.add(t);
          return t;
        }

        public BodyStructureIncludedStructureComponent addSpatialReference(Reference t) { //3
          if (t == null)
            return this;
          if (this.spatialReference == null)
            this.spatialReference = new ArrayList<Reference>();
          this.spatialReference.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #spatialReference}, creating it if it does not already exist {3}
         */
        public Reference getSpatialReferenceFirstRep() { 
          if (getSpatialReference().isEmpty()) {
            addSpatialReference();
          }
          return getSpatialReference().get(0);
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
          children.add(new Property("bodyLandmarkOrientation", "", "Body locations in relation to a specific body landmark (tatoo, scar, other body structure).", 0, java.lang.Integer.MAX_VALUE, bodyLandmarkOrientation));
          children.add(new Property("spatialReference", "Reference(ImagingSelection)", "XY or XYZ-coordinate orientation for structure.", 0, java.lang.Integer.MAX_VALUE, spatialReference));
          children.add(new Property("qualifier", "CodeableConcept", "Code that represents the included structure qualifier.", 0, java.lang.Integer.MAX_VALUE, qualifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 144518515: /*structure*/  return new Property("structure", "CodeableConcept", "Code that represents the included structure.", 0, 1, structure);
          case -170291817: /*laterality*/  return new Property("laterality", "CodeableConcept", "Code that represents the included structure laterality.", 0, 1, laterality);
          case -994716042: /*bodyLandmarkOrientation*/  return new Property("bodyLandmarkOrientation", "", "Body locations in relation to a specific body landmark (tatoo, scar, other body structure).", 0, java.lang.Integer.MAX_VALUE, bodyLandmarkOrientation);
          case 784017063: /*spatialReference*/  return new Property("spatialReference", "Reference(ImagingSelection)", "XY or XYZ-coordinate orientation for structure.", 0, java.lang.Integer.MAX_VALUE, spatialReference);
          case -1247940438: /*qualifier*/  return new Property("qualifier", "CodeableConcept", "Code that represents the included structure qualifier.", 0, java.lang.Integer.MAX_VALUE, qualifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 144518515: /*structure*/ return this.structure == null ? new Base[0] : new Base[] {this.structure}; // CodeableConcept
        case -170291817: /*laterality*/ return this.laterality == null ? new Base[0] : new Base[] {this.laterality}; // CodeableConcept
        case -994716042: /*bodyLandmarkOrientation*/ return this.bodyLandmarkOrientation == null ? new Base[0] : this.bodyLandmarkOrientation.toArray(new Base[this.bodyLandmarkOrientation.size()]); // BodyStructureIncludedStructureBodyLandmarkOrientationComponent
        case 784017063: /*spatialReference*/ return this.spatialReference == null ? new Base[0] : this.spatialReference.toArray(new Base[this.spatialReference.size()]); // Reference
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
        case -994716042: // bodyLandmarkOrientation
          this.getBodyLandmarkOrientation().add((BodyStructureIncludedStructureBodyLandmarkOrientationComponent) value); // BodyStructureIncludedStructureBodyLandmarkOrientationComponent
          return value;
        case 784017063: // spatialReference
          this.getSpatialReference().add(TypeConvertor.castToReference(value)); // Reference
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
        } else if (name.equals("bodyLandmarkOrientation")) {
          this.getBodyLandmarkOrientation().add((BodyStructureIncludedStructureBodyLandmarkOrientationComponent) value);
        } else if (name.equals("spatialReference")) {
          this.getSpatialReference().add(TypeConvertor.castToReference(value));
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
        case -994716042:  return addBodyLandmarkOrientation(); 
        case 784017063:  return addSpatialReference(); 
        case -1247940438:  return addQualifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 144518515: /*structure*/ return new String[] {"CodeableConcept"};
        case -170291817: /*laterality*/ return new String[] {"CodeableConcept"};
        case -994716042: /*bodyLandmarkOrientation*/ return new String[] {};
        case 784017063: /*spatialReference*/ return new String[] {"Reference"};
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
        else if (name.equals("bodyLandmarkOrientation")) {
          return addBodyLandmarkOrientation();
        }
        else if (name.equals("spatialReference")) {
          return addSpatialReference();
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
        if (bodyLandmarkOrientation != null) {
          dst.bodyLandmarkOrientation = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationComponent>();
          for (BodyStructureIncludedStructureBodyLandmarkOrientationComponent i : bodyLandmarkOrientation)
            dst.bodyLandmarkOrientation.add(i.copy());
        };
        if (spatialReference != null) {
          dst.spatialReference = new ArrayList<Reference>();
          for (Reference i : spatialReference)
            dst.spatialReference.add(i.copy());
        };
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
           && compareDeep(bodyLandmarkOrientation, o.bodyLandmarkOrientation, true) && compareDeep(spatialReference, o.spatialReference, true)
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(structure, laterality, bodyLandmarkOrientation
          , spatialReference, qualifier);
      }

  public String fhirType() {
    return "BodyStructure.includedStructure";

  }

  }

    @Block()
    public static class BodyStructureIncludedStructureBodyLandmarkOrientationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A description of a landmark on the body used as a reference to locate something else.
         */
        @Child(name = "landmarkDescription", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Body ]andmark description", formalDefinition="A description of a landmark on the body used as a reference to locate something else." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected List<CodeableConcept> landmarkDescription;

        /**
         * An description of the direction away from a landmark something is located based on a radial clock dial.
         */
        @Child(name = "clockFacePosition", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Clockface orientation", formalDefinition="An description of the direction away from a landmark something is located based on a radial clock dial." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-bodylandmarkorientation-clockface-position")
        protected List<CodeableConcept> clockFacePosition;

        /**
         * The distance in centimeters a certain observation is made from a body landmark.
         */
        @Child(name = "distanceFromLandmark", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Landmark relative location", formalDefinition="The distance in centimeters a certain observation is made from a body landmark." )
        protected List<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent> distanceFromLandmark;

        /**
         * The surface area a body location is in relation to a landmark.
         */
        @Child(name = "surfaceOrientation", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Relative landmark surface orientation", formalDefinition="The surface area a body location is in relation to a landmark." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodystructure-relative-location")
        protected List<CodeableConcept> surfaceOrientation;

        private static final long serialVersionUID = -365770277L;

    /**
     * Constructor
     */
      public BodyStructureIncludedStructureBodyLandmarkOrientationComponent() {
        super();
      }

        /**
         * @return {@link #landmarkDescription} (A description of a landmark on the body used as a reference to locate something else.)
         */
        public List<CodeableConcept> getLandmarkDescription() { 
          if (this.landmarkDescription == null)
            this.landmarkDescription = new ArrayList<CodeableConcept>();
          return this.landmarkDescription;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent setLandmarkDescription(List<CodeableConcept> theLandmarkDescription) { 
          this.landmarkDescription = theLandmarkDescription;
          return this;
        }

        public boolean hasLandmarkDescription() { 
          if (this.landmarkDescription == null)
            return false;
          for (CodeableConcept item : this.landmarkDescription)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addLandmarkDescription() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.landmarkDescription == null)
            this.landmarkDescription = new ArrayList<CodeableConcept>();
          this.landmarkDescription.add(t);
          return t;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent addLandmarkDescription(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.landmarkDescription == null)
            this.landmarkDescription = new ArrayList<CodeableConcept>();
          this.landmarkDescription.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #landmarkDescription}, creating it if it does not already exist {3}
         */
        public CodeableConcept getLandmarkDescriptionFirstRep() { 
          if (getLandmarkDescription().isEmpty()) {
            addLandmarkDescription();
          }
          return getLandmarkDescription().get(0);
        }

        /**
         * @return {@link #clockFacePosition} (An description of the direction away from a landmark something is located based on a radial clock dial.)
         */
        public List<CodeableConcept> getClockFacePosition() { 
          if (this.clockFacePosition == null)
            this.clockFacePosition = new ArrayList<CodeableConcept>();
          return this.clockFacePosition;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent setClockFacePosition(List<CodeableConcept> theClockFacePosition) { 
          this.clockFacePosition = theClockFacePosition;
          return this;
        }

        public boolean hasClockFacePosition() { 
          if (this.clockFacePosition == null)
            return false;
          for (CodeableConcept item : this.clockFacePosition)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClockFacePosition() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.clockFacePosition == null)
            this.clockFacePosition = new ArrayList<CodeableConcept>();
          this.clockFacePosition.add(t);
          return t;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent addClockFacePosition(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.clockFacePosition == null)
            this.clockFacePosition = new ArrayList<CodeableConcept>();
          this.clockFacePosition.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #clockFacePosition}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClockFacePositionFirstRep() { 
          if (getClockFacePosition().isEmpty()) {
            addClockFacePosition();
          }
          return getClockFacePosition().get(0);
        }

        /**
         * @return {@link #distanceFromLandmark} (The distance in centimeters a certain observation is made from a body landmark.)
         */
        public List<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent> getDistanceFromLandmark() { 
          if (this.distanceFromLandmark == null)
            this.distanceFromLandmark = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent>();
          return this.distanceFromLandmark;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent setDistanceFromLandmark(List<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent> theDistanceFromLandmark) { 
          this.distanceFromLandmark = theDistanceFromLandmark;
          return this;
        }

        public boolean hasDistanceFromLandmark() { 
          if (this.distanceFromLandmark == null)
            return false;
          for (BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent item : this.distanceFromLandmark)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent addDistanceFromLandmark() { //3
          BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent t = new BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent();
          if (this.distanceFromLandmark == null)
            this.distanceFromLandmark = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent>();
          this.distanceFromLandmark.add(t);
          return t;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent addDistanceFromLandmark(BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent t) { //3
          if (t == null)
            return this;
          if (this.distanceFromLandmark == null)
            this.distanceFromLandmark = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent>();
          this.distanceFromLandmark.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #distanceFromLandmark}, creating it if it does not already exist {3}
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent getDistanceFromLandmarkFirstRep() { 
          if (getDistanceFromLandmark().isEmpty()) {
            addDistanceFromLandmark();
          }
          return getDistanceFromLandmark().get(0);
        }

        /**
         * @return {@link #surfaceOrientation} (The surface area a body location is in relation to a landmark.)
         */
        public List<CodeableConcept> getSurfaceOrientation() { 
          if (this.surfaceOrientation == null)
            this.surfaceOrientation = new ArrayList<CodeableConcept>();
          return this.surfaceOrientation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent setSurfaceOrientation(List<CodeableConcept> theSurfaceOrientation) { 
          this.surfaceOrientation = theSurfaceOrientation;
          return this;
        }

        public boolean hasSurfaceOrientation() { 
          if (this.surfaceOrientation == null)
            return false;
          for (CodeableConcept item : this.surfaceOrientation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addSurfaceOrientation() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.surfaceOrientation == null)
            this.surfaceOrientation = new ArrayList<CodeableConcept>();
          this.surfaceOrientation.add(t);
          return t;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationComponent addSurfaceOrientation(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.surfaceOrientation == null)
            this.surfaceOrientation = new ArrayList<CodeableConcept>();
          this.surfaceOrientation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #surfaceOrientation}, creating it if it does not already exist {3}
         */
        public CodeableConcept getSurfaceOrientationFirstRep() { 
          if (getSurfaceOrientation().isEmpty()) {
            addSurfaceOrientation();
          }
          return getSurfaceOrientation().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("landmarkDescription", "CodeableConcept", "A description of a landmark on the body used as a reference to locate something else.", 0, java.lang.Integer.MAX_VALUE, landmarkDescription));
          children.add(new Property("clockFacePosition", "CodeableConcept", "An description of the direction away from a landmark something is located based on a radial clock dial.", 0, java.lang.Integer.MAX_VALUE, clockFacePosition));
          children.add(new Property("distanceFromLandmark", "", "The distance in centimeters a certain observation is made from a body landmark.", 0, java.lang.Integer.MAX_VALUE, distanceFromLandmark));
          children.add(new Property("surfaceOrientation", "CodeableConcept", "The surface area a body location is in relation to a landmark.", 0, java.lang.Integer.MAX_VALUE, surfaceOrientation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1187892644: /*landmarkDescription*/  return new Property("landmarkDescription", "CodeableConcept", "A description of a landmark on the body used as a reference to locate something else.", 0, java.lang.Integer.MAX_VALUE, landmarkDescription);
          case 133476820: /*clockFacePosition*/  return new Property("clockFacePosition", "CodeableConcept", "An description of the direction away from a landmark something is located based on a radial clock dial.", 0, java.lang.Integer.MAX_VALUE, clockFacePosition);
          case 1350792599: /*distanceFromLandmark*/  return new Property("distanceFromLandmark", "", "The distance in centimeters a certain observation is made from a body landmark.", 0, java.lang.Integer.MAX_VALUE, distanceFromLandmark);
          case 1408496355: /*surfaceOrientation*/  return new Property("surfaceOrientation", "CodeableConcept", "The surface area a body location is in relation to a landmark.", 0, java.lang.Integer.MAX_VALUE, surfaceOrientation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1187892644: /*landmarkDescription*/ return this.landmarkDescription == null ? new Base[0] : this.landmarkDescription.toArray(new Base[this.landmarkDescription.size()]); // CodeableConcept
        case 133476820: /*clockFacePosition*/ return this.clockFacePosition == null ? new Base[0] : this.clockFacePosition.toArray(new Base[this.clockFacePosition.size()]); // CodeableConcept
        case 1350792599: /*distanceFromLandmark*/ return this.distanceFromLandmark == null ? new Base[0] : this.distanceFromLandmark.toArray(new Base[this.distanceFromLandmark.size()]); // BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent
        case 1408496355: /*surfaceOrientation*/ return this.surfaceOrientation == null ? new Base[0] : this.surfaceOrientation.toArray(new Base[this.surfaceOrientation.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1187892644: // landmarkDescription
          this.getLandmarkDescription().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 133476820: // clockFacePosition
          this.getClockFacePosition().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1350792599: // distanceFromLandmark
          this.getDistanceFromLandmark().add((BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent) value); // BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent
          return value;
        case 1408496355: // surfaceOrientation
          this.getSurfaceOrientation().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("landmarkDescription")) {
          this.getLandmarkDescription().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("clockFacePosition")) {
          this.getClockFacePosition().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("distanceFromLandmark")) {
          this.getDistanceFromLandmark().add((BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent) value);
        } else if (name.equals("surfaceOrientation")) {
          this.getSurfaceOrientation().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1187892644:  return addLandmarkDescription(); 
        case 133476820:  return addClockFacePosition(); 
        case 1350792599:  return addDistanceFromLandmark(); 
        case 1408496355:  return addSurfaceOrientation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1187892644: /*landmarkDescription*/ return new String[] {"CodeableConcept"};
        case 133476820: /*clockFacePosition*/ return new String[] {"CodeableConcept"};
        case 1350792599: /*distanceFromLandmark*/ return new String[] {};
        case 1408496355: /*surfaceOrientation*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("landmarkDescription")) {
          return addLandmarkDescription();
        }
        else if (name.equals("clockFacePosition")) {
          return addClockFacePosition();
        }
        else if (name.equals("distanceFromLandmark")) {
          return addDistanceFromLandmark();
        }
        else if (name.equals("surfaceOrientation")) {
          return addSurfaceOrientation();
        }
        else
          return super.addChild(name);
      }

      public BodyStructureIncludedStructureBodyLandmarkOrientationComponent copy() {
        BodyStructureIncludedStructureBodyLandmarkOrientationComponent dst = new BodyStructureIncludedStructureBodyLandmarkOrientationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BodyStructureIncludedStructureBodyLandmarkOrientationComponent dst) {
        super.copyValues(dst);
        if (landmarkDescription != null) {
          dst.landmarkDescription = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : landmarkDescription)
            dst.landmarkDescription.add(i.copy());
        };
        if (clockFacePosition != null) {
          dst.clockFacePosition = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : clockFacePosition)
            dst.clockFacePosition.add(i.copy());
        };
        if (distanceFromLandmark != null) {
          dst.distanceFromLandmark = new ArrayList<BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent>();
          for (BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent i : distanceFromLandmark)
            dst.distanceFromLandmark.add(i.copy());
        };
        if (surfaceOrientation != null) {
          dst.surfaceOrientation = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : surfaceOrientation)
            dst.surfaceOrientation.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BodyStructureIncludedStructureBodyLandmarkOrientationComponent))
          return false;
        BodyStructureIncludedStructureBodyLandmarkOrientationComponent o = (BodyStructureIncludedStructureBodyLandmarkOrientationComponent) other_;
        return compareDeep(landmarkDescription, o.landmarkDescription, true) && compareDeep(clockFacePosition, o.clockFacePosition, true)
           && compareDeep(distanceFromLandmark, o.distanceFromLandmark, true) && compareDeep(surfaceOrientation, o.surfaceOrientation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BodyStructureIncludedStructureBodyLandmarkOrientationComponent))
          return false;
        BodyStructureIncludedStructureBodyLandmarkOrientationComponent o = (BodyStructureIncludedStructureBodyLandmarkOrientationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(landmarkDescription, clockFacePosition
          , distanceFromLandmark, surfaceOrientation);
      }

  public String fhirType() {
    return "BodyStructure.includedStructure.bodyLandmarkOrientation";

  }

  }

    @Block()
    public static class BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An instrument, tool, analyzer, etc. used in the measurement.
         */
        @Child(name = "device", type = {CodeableReference.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Measurement device", formalDefinition="An instrument, tool, analyzer, etc. used in the measurement." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-type")
        protected List<CodeableReference> device;

        /**
         * The measured distance (e.g., in cm) from a body landmark.
         */
        @Child(name = "value", type = {Quantity.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Measured distance from body landmark", formalDefinition="The measured distance (e.g., in cm) from a body landmark." )
        protected List<Quantity> value;

        private static final long serialVersionUID = 1883586968L;

    /**
     * Constructor
     */
      public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent() {
        super();
      }

        /**
         * @return {@link #device} (An instrument, tool, analyzer, etc. used in the measurement.)
         */
        public List<CodeableReference> getDevice() { 
          if (this.device == null)
            this.device = new ArrayList<CodeableReference>();
          return this.device;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent setDevice(List<CodeableReference> theDevice) { 
          this.device = theDevice;
          return this;
        }

        public boolean hasDevice() { 
          if (this.device == null)
            return false;
          for (CodeableReference item : this.device)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addDevice() { //3
          CodeableReference t = new CodeableReference();
          if (this.device == null)
            this.device = new ArrayList<CodeableReference>();
          this.device.add(t);
          return t;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent addDevice(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.device == null)
            this.device = new ArrayList<CodeableReference>();
          this.device.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #device}, creating it if it does not already exist {3}
         */
        public CodeableReference getDeviceFirstRep() { 
          if (getDevice().isEmpty()) {
            addDevice();
          }
          return getDevice().get(0);
        }

        /**
         * @return {@link #value} (The measured distance (e.g., in cm) from a body landmark.)
         */
        public List<Quantity> getValue() { 
          if (this.value == null)
            this.value = new ArrayList<Quantity>();
          return this.value;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent setValue(List<Quantity> theValue) { 
          this.value = theValue;
          return this;
        }

        public boolean hasValue() { 
          if (this.value == null)
            return false;
          for (Quantity item : this.value)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Quantity addValue() { //3
          Quantity t = new Quantity();
          if (this.value == null)
            this.value = new ArrayList<Quantity>();
          this.value.add(t);
          return t;
        }

        public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent addValue(Quantity t) { //3
          if (t == null)
            return this;
          if (this.value == null)
            this.value = new ArrayList<Quantity>();
          this.value.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #value}, creating it if it does not already exist {3}
         */
        public Quantity getValueFirstRep() { 
          if (getValue().isEmpty()) {
            addValue();
          }
          return getValue().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("device", "CodeableReference(Device)", "An instrument, tool, analyzer, etc. used in the measurement.", 0, java.lang.Integer.MAX_VALUE, device));
          children.add(new Property("value", "Quantity", "The measured distance (e.g., in cm) from a body landmark.", 0, java.lang.Integer.MAX_VALUE, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1335157162: /*device*/  return new Property("device", "CodeableReference(Device)", "An instrument, tool, analyzer, etc. used in the measurement.", 0, java.lang.Integer.MAX_VALUE, device);
          case 111972721: /*value*/  return new Property("value", "Quantity", "The measured distance (e.g., in cm) from a body landmark.", 0, java.lang.Integer.MAX_VALUE, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : this.device.toArray(new Base[this.device.size()]); // CodeableReference
        case 111972721: /*value*/ return this.value == null ? new Base[0] : this.value.toArray(new Base[this.value.size()]); // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1335157162: // device
          this.getDevice().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 111972721: // value
          this.getValue().add(TypeConvertor.castToQuantity(value)); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("device")) {
          this.getDevice().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("value")) {
          this.getValue().add(TypeConvertor.castToQuantity(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1335157162:  return addDevice(); 
        case 111972721:  return addValue(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1335157162: /*device*/ return new String[] {"CodeableReference"};
        case 111972721: /*value*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("device")) {
          return addDevice();
        }
        else if (name.equals("value")) {
          return addValue();
        }
        else
          return super.addChild(name);
      }

      public BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent copy() {
        BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent dst = new BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent dst) {
        super.copyValues(dst);
        if (device != null) {
          dst.device = new ArrayList<CodeableReference>();
          for (CodeableReference i : device)
            dst.device.add(i.copy());
        };
        if (value != null) {
          dst.value = new ArrayList<Quantity>();
          for (Quantity i : value)
            dst.value.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent))
          return false;
        BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent o = (BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent) other_;
        return compareDeep(device, o.device, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent))
          return false;
        BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent o = (BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(device, value);
      }

  public String fhirType() {
    return "BodyStructure.includedStructure.bodyLandmarkOrientation.distanceFromLandmark";

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
    @Child(name = "excludedStructure", type = {BodyStructureIncludedStructureComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Excluded anatomic locations(s)", formalDefinition="The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure." )
    protected List<BodyStructureIncludedStructureComponent> excludedStructure;

    /**
     * A summary, characterization or explanation of the body structure.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Text description", formalDefinition="A summary, characterization or explanation of the body structure." )
    protected MarkdownType description;

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

    private static final long serialVersionUID = -1014863022L;

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
    public List<BodyStructureIncludedStructureComponent> getExcludedStructure() { 
      if (this.excludedStructure == null)
        this.excludedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
      return this.excludedStructure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BodyStructure setExcludedStructure(List<BodyStructureIncludedStructureComponent> theExcludedStructure) { 
      this.excludedStructure = theExcludedStructure;
      return this;
    }

    public boolean hasExcludedStructure() { 
      if (this.excludedStructure == null)
        return false;
      for (BodyStructureIncludedStructureComponent item : this.excludedStructure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public BodyStructureIncludedStructureComponent addExcludedStructure() { //3
      BodyStructureIncludedStructureComponent t = new BodyStructureIncludedStructureComponent();
      if (this.excludedStructure == null)
        this.excludedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
      this.excludedStructure.add(t);
      return t;
    }

    public BodyStructure addExcludedStructure(BodyStructureIncludedStructureComponent t) { //3
      if (t == null)
        return this;
      if (this.excludedStructure == null)
        this.excludedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
      this.excludedStructure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #excludedStructure}, creating it if it does not already exist {3}
     */
    public BodyStructureIncludedStructureComponent getExcludedStructureFirstRep() { 
      if (getExcludedStructure().isEmpty()) {
        addExcludedStructure();
      }
      return getExcludedStructure().get(0);
    }

    /**
     * @return {@link #description} (A summary, characterization or explanation of the body structure.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BodyStructure.description");
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
     * @param value {@link #description} (A summary, characterization or explanation of the body structure.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public BodyStructure setDescriptionElement(MarkdownType value) { 
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
          this.description = new MarkdownType();
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
        children.add(new Property("excludedStructure", "@BodyStructure.includedStructure", "The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure.", 0, java.lang.Integer.MAX_VALUE, excludedStructure));
        children.add(new Property("description", "markdown", "A summary, characterization or explanation of the body structure.", 0, 1, description));
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
        case 1192252105: /*excludedStructure*/  return new Property("excludedStructure", "@BodyStructure.includedStructure", "The anatomical location(s) or region(s) not occupied or represented by the specimen, lesion, or body structure.", 0, java.lang.Integer.MAX_VALUE, excludedStructure);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A summary, characterization or explanation of the body structure.", 0, 1, description);
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
        case 1192252105: /*excludedStructure*/ return this.excludedStructure == null ? new Base[0] : this.excludedStructure.toArray(new Base[this.excludedStructure.size()]); // BodyStructureIncludedStructureComponent
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
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
          this.getExcludedStructure().add((BodyStructureIncludedStructureComponent) value); // BodyStructureIncludedStructureComponent
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
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
          this.getExcludedStructure().add((BodyStructureIncludedStructureComponent) value);
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
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
        case 1192252105: /*excludedStructure*/ return new String[] {"@BodyStructure.includedStructure"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
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
          throw new FHIRException("Cannot call addChild on a singleton property BodyStructure.active");
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
          throw new FHIRException("Cannot call addChild on a singleton property BodyStructure.description");
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
          dst.excludedStructure = new ArrayList<BodyStructureIncludedStructureComponent>();
          for (BodyStructureIncludedStructureComponent i : excludedStructure)
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
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
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
   * the path value of "<b>BodyStructure:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("BodyStructure:patient").toLocked();


}

