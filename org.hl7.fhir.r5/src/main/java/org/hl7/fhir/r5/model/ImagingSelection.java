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

// Generated on Tue, Dec 21, 2021 05:44+1100 for FHIR v5.0.0-snapshot1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;
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
 * A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.
 */
@ResourceDef(name="ImagingSelection", profile="http://hl7.org/fhir/StructureDefinition/ImagingSelection")
public class ImagingSelection extends DomainResource {

    public enum ImagingSelectionCoordinateType {
        /**
         * The selected image region is defined in a 2D coordinate system.
         */
        _2D, 
        /**
         * The selected image region is defined in a 3D coordinate system.
         */
        _3D, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ImagingSelectionCoordinateType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("2d".equals(codeString))
          return _2D;
        if ("3d".equals(codeString))
          return _3D;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImagingSelectionCoordinateType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _2D: return "2d";
            case _3D: return "3d";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case _2D: return "http://hl7.org/fhir/imagingselection-coordinatetype";
            case _3D: return "http://hl7.org/fhir/imagingselection-coordinatetype";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case _2D: return "The selected image region is defined in a 2D coordinate system.";
            case _3D: return "The selected image region is defined in a 3D coordinate system.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _2D: return "2D";
            case _3D: return "3D";
            default: return "?";
          }
        }
    }

  public static class ImagingSelectionCoordinateTypeEnumFactory implements EnumFactory<ImagingSelectionCoordinateType> {
    public ImagingSelectionCoordinateType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("2d".equals(codeString))
          return ImagingSelectionCoordinateType._2D;
        if ("3d".equals(codeString))
          return ImagingSelectionCoordinateType._3D;
        throw new IllegalArgumentException("Unknown ImagingSelectionCoordinateType code '"+codeString+"'");
        }
        public Enumeration<ImagingSelectionCoordinateType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingSelectionCoordinateType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("2d".equals(codeString))
          return new Enumeration<ImagingSelectionCoordinateType>(this, ImagingSelectionCoordinateType._2D);
        if ("3d".equals(codeString))
          return new Enumeration<ImagingSelectionCoordinateType>(this, ImagingSelectionCoordinateType._3D);
        throw new FHIRException("Unknown ImagingSelectionCoordinateType code '"+codeString+"'");
        }
    public String toCode(ImagingSelectionCoordinateType code) {
      if (code == ImagingSelectionCoordinateType._2D)
        return "2d";
      if (code == ImagingSelectionCoordinateType._3D)
        return "3d";
      return "?";
      }
    public String toSystem(ImagingSelectionCoordinateType code) {
      return code.getSystem();
      }
    }

    public enum ImagingSelectionGraphicType {
        /**
         * A single location denoted by a single (x,y,z) triplet.
         */
        POINT, 
        /**
         * multiple locations each denoted by an (x,y,z) triplet; the points need not be coplanar.
         */
        MULTIPOINT, 
        /**
         * a series of connected line segments with ordered vertices denoted by (x,y,z) triplets; the points need not be coplanar.
         */
        POLYLINE, 
        /**
         * a series of connected line segments with ordered vertices denoted by (x,y,z) triplets, where the first and last vertices shall be the same forming a polygon; the points shall be coplanar.
         */
        POLYGON, 
        /**
         * an ellipse defined by four (x,y,z) triplets, the first two triplets specifying the endpoints of the major axis and the second two triplets specifying the endpoints of the minor axis.
         */
        ELLIPSE, 
        /**
         * a three-dimensional geometric surface whose plane sections are either ellipses or circles and contains three intersecting orthogonal axes, \"a\", \"b\", and \"c\"; the ellipsoid is defined by six (x,y,z) triplets, the first and second triplets specifying the endpoints of axis \"a\", the third and fourth triplets specifying the endpoints of axis \"b\", and the fifth and sixth triplets specifying the endpoints of axis \"c\".
         */
        ELLIPSOID, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ImagingSelectionGraphicType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("POINT".equals(codeString))
          return POINT;
        if ("MULTIPOINT".equals(codeString))
          return MULTIPOINT;
        if ("POLYLINE".equals(codeString))
          return POLYLINE;
        if ("POLYGON".equals(codeString))
          return POLYGON;
        if ("ELLIPSE".equals(codeString))
          return ELLIPSE;
        if ("ELLIPSOID".equals(codeString))
          return ELLIPSOID;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImagingSelectionGraphicType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case POINT: return "POINT";
            case MULTIPOINT: return "MULTIPOINT";
            case POLYLINE: return "POLYLINE";
            case POLYGON: return "POLYGON";
            case ELLIPSE: return "ELLIPSE";
            case ELLIPSOID: return "ELLIPSOID";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case POINT: return "http://hl7.org/fhir/imagingselection-graphictype";
            case MULTIPOINT: return "http://hl7.org/fhir/imagingselection-graphictype";
            case POLYLINE: return "http://hl7.org/fhir/imagingselection-graphictype";
            case POLYGON: return "http://hl7.org/fhir/imagingselection-graphictype";
            case ELLIPSE: return "http://hl7.org/fhir/imagingselection-graphictype";
            case ELLIPSOID: return "http://hl7.org/fhir/imagingselection-graphictype";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case POINT: return "A single location denoted by a single (x,y,z) triplet.";
            case MULTIPOINT: return "multiple locations each denoted by an (x,y,z) triplet; the points need not be coplanar.";
            case POLYLINE: return "a series of connected line segments with ordered vertices denoted by (x,y,z) triplets; the points need not be coplanar.";
            case POLYGON: return "a series of connected line segments with ordered vertices denoted by (x,y,z) triplets, where the first and last vertices shall be the same forming a polygon; the points shall be coplanar.";
            case ELLIPSE: return "an ellipse defined by four (x,y,z) triplets, the first two triplets specifying the endpoints of the major axis and the second two triplets specifying the endpoints of the minor axis.";
            case ELLIPSOID: return "a three-dimensional geometric surface whose plane sections are either ellipses or circles and contains three intersecting orthogonal axes, \"a\", \"b\", and \"c\"; the ellipsoid is defined by six (x,y,z) triplets, the first and second triplets specifying the endpoints of axis \"a\", the third and fourth triplets specifying the endpoints of axis \"b\", and the fifth and sixth triplets specifying the endpoints of axis \"c\".";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case POINT: return "POINT";
            case MULTIPOINT: return "MULTIPOINT";
            case POLYLINE: return "POLYLINE";
            case POLYGON: return "POLYGON";
            case ELLIPSE: return "ELLIPSE";
            case ELLIPSOID: return "ELLIPSOID";
            default: return "?";
          }
        }
    }

  public static class ImagingSelectionGraphicTypeEnumFactory implements EnumFactory<ImagingSelectionGraphicType> {
    public ImagingSelectionGraphicType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("POINT".equals(codeString))
          return ImagingSelectionGraphicType.POINT;
        if ("MULTIPOINT".equals(codeString))
          return ImagingSelectionGraphicType.MULTIPOINT;
        if ("POLYLINE".equals(codeString))
          return ImagingSelectionGraphicType.POLYLINE;
        if ("POLYGON".equals(codeString))
          return ImagingSelectionGraphicType.POLYGON;
        if ("ELLIPSE".equals(codeString))
          return ImagingSelectionGraphicType.ELLIPSE;
        if ("ELLIPSOID".equals(codeString))
          return ImagingSelectionGraphicType.ELLIPSOID;
        throw new IllegalArgumentException("Unknown ImagingSelectionGraphicType code '"+codeString+"'");
        }
        public Enumeration<ImagingSelectionGraphicType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingSelectionGraphicType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("POINT".equals(codeString))
          return new Enumeration<ImagingSelectionGraphicType>(this, ImagingSelectionGraphicType.POINT);
        if ("MULTIPOINT".equals(codeString))
          return new Enumeration<ImagingSelectionGraphicType>(this, ImagingSelectionGraphicType.MULTIPOINT);
        if ("POLYLINE".equals(codeString))
          return new Enumeration<ImagingSelectionGraphicType>(this, ImagingSelectionGraphicType.POLYLINE);
        if ("POLYGON".equals(codeString))
          return new Enumeration<ImagingSelectionGraphicType>(this, ImagingSelectionGraphicType.POLYGON);
        if ("ELLIPSE".equals(codeString))
          return new Enumeration<ImagingSelectionGraphicType>(this, ImagingSelectionGraphicType.ELLIPSE);
        if ("ELLIPSOID".equals(codeString))
          return new Enumeration<ImagingSelectionGraphicType>(this, ImagingSelectionGraphicType.ELLIPSOID);
        throw new FHIRException("Unknown ImagingSelectionGraphicType code '"+codeString+"'");
        }
    public String toCode(ImagingSelectionGraphicType code) {
      if (code == ImagingSelectionGraphicType.POINT)
        return "POINT";
      if (code == ImagingSelectionGraphicType.MULTIPOINT)
        return "MULTIPOINT";
      if (code == ImagingSelectionGraphicType.POLYLINE)
        return "POLYLINE";
      if (code == ImagingSelectionGraphicType.POLYGON)
        return "POLYGON";
      if (code == ImagingSelectionGraphicType.ELLIPSE)
        return "ELLIPSE";
      if (code == ImagingSelectionGraphicType.ELLIPSOID)
        return "ELLIPSOID";
      return "?";
      }
    public String toSystem(ImagingSelectionGraphicType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ImagingSelectionPerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of involvement of the performer.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of performer", formalDefinition="Distinguishes the type of involvement of the performer." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/series-performer-function")
        protected CodeableConcept function;

        /**
         * Author – human or machine.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Device.class, Organization.class, CareTeam.class, Patient.class, RelatedPerson.class, HealthcareService.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Author (human or machine)", formalDefinition="Author – human or machine." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public ImagingSelectionPerformerComponent() {
        super();
      }

        /**
         * @return {@link #function} (Distinguishes the type of involvement of the performer.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionPerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the performer.)
         */
        public ImagingSelectionPerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Author – human or machine.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionPerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Author – human or machine.)
         */
        public ImagingSelectionPerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Device|Organization|CareTeam|Patient|RelatedPerson|HealthcareService)", "Author – human or machine.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Device|Organization|CareTeam|Patient|RelatedPerson|HealthcareService)", "Author – human or machine.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction();
        case 92645877:  return getActor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public ImagingSelectionPerformerComponent copy() {
        ImagingSelectionPerformerComponent dst = new ImagingSelectionPerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImagingSelectionPerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionPerformerComponent))
          return false;
        ImagingSelectionPerformerComponent o = (ImagingSelectionPerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionPerformerComponent))
          return false;
        ImagingSelectionPerformerComponent o = (ImagingSelectionPerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "ImagingSelection.performer";

  }

  }

    @Block()
    public static class ImagingSelectionInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The SOP Instance UID for the selected DICOM instance.
         */
        @Child(name = "uid", type = {OidType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="DICOM SOP Instance UID", formalDefinition="The SOP Instance UID for the selected DICOM instance." )
        protected OidType uid;

        /**
         * The SOP Class UID for the selected DICOM instance.
         */
        @Child(name = "sopClass", type = {Coding.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="DICOM SOP Class UID", formalDefinition="The SOP Class UID for the selected DICOM instance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part04/sect_B.5.html#table_B.5-1")
        protected Coding sopClass;

        /**
         * The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.
         */
        @Child(name = "frameList", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="List of selected frames encoded as a comma separated list of one or more non duplicate frame numbers", formalDefinition="The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection." )
        protected StringType frameList;

        /**
         * The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.
         */
        @Child(name = "observationUid", type = {OidType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Selected observations in a DICOM SR", formalDefinition="The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection." )
        protected List<OidType> observationUid;

        /**
         * The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.
         */
        @Child(name = "segmentList", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="List of selected segments encoded as a comma separated list of one or more non duplicate segnent numbers", formalDefinition="The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection." )
        protected StringType segmentList;

        /**
         * The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.
         */
        @Child(name = "roiList", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="List of selected regions of interest (ROI) encoded as a comma separated list of one or more non duplicate ROI numbers", formalDefinition="The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection." )
        protected StringType roiList;

        private static final long serialVersionUID = -1574362633L;

    /**
     * Constructor
     */
      public ImagingSelectionInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingSelectionInstanceComponent(String uid) {
        super();
        this.setUid(uid);
      }

        /**
         * @return {@link #uid} (The SOP Instance UID for the selected DICOM instance.). This is the underlying object with id, value and extensions. The accessor "getUid" gives direct access to the value
         */
        public OidType getUidElement() { 
          if (this.uid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.uid");
            else if (Configuration.doAutoCreate())
              this.uid = new OidType(); // bb
          return this.uid;
        }

        public boolean hasUidElement() { 
          return this.uid != null && !this.uid.isEmpty();
        }

        public boolean hasUid() { 
          return this.uid != null && !this.uid.isEmpty();
        }

        /**
         * @param value {@link #uid} (The SOP Instance UID for the selected DICOM instance.). This is the underlying object with id, value and extensions. The accessor "getUid" gives direct access to the value
         */
        public ImagingSelectionInstanceComponent setUidElement(OidType value) { 
          this.uid = value;
          return this;
        }

        /**
         * @return The SOP Instance UID for the selected DICOM instance.
         */
        public String getUid() { 
          return this.uid == null ? null : this.uid.getValue();
        }

        /**
         * @param value The SOP Instance UID for the selected DICOM instance.
         */
        public ImagingSelectionInstanceComponent setUid(String value) { 
            if (this.uid == null)
              this.uid = new OidType();
            this.uid.setValue(value);
          return this;
        }

        /**
         * @return {@link #sopClass} (The SOP Class UID for the selected DICOM instance.)
         */
        public Coding getSopClass() { 
          if (this.sopClass == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.sopClass");
            else if (Configuration.doAutoCreate())
              this.sopClass = new Coding(); // cc
          return this.sopClass;
        }

        public boolean hasSopClass() { 
          return this.sopClass != null && !this.sopClass.isEmpty();
        }

        /**
         * @param value {@link #sopClass} (The SOP Class UID for the selected DICOM instance.)
         */
        public ImagingSelectionInstanceComponent setSopClass(Coding value) { 
          this.sopClass = value;
          return this;
        }

        /**
         * @return {@link #frameList} (The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.). This is the underlying object with id, value and extensions. The accessor "getFrameList" gives direct access to the value
         */
        public StringType getFrameListElement() { 
          if (this.frameList == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.frameList");
            else if (Configuration.doAutoCreate())
              this.frameList = new StringType(); // bb
          return this.frameList;
        }

        public boolean hasFrameListElement() { 
          return this.frameList != null && !this.frameList.isEmpty();
        }

        public boolean hasFrameList() { 
          return this.frameList != null && !this.frameList.isEmpty();
        }

        /**
         * @param value {@link #frameList} (The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.). This is the underlying object with id, value and extensions. The accessor "getFrameList" gives direct access to the value
         */
        public ImagingSelectionInstanceComponent setFrameListElement(StringType value) { 
          this.frameList = value;
          return this;
        }

        /**
         * @return The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.
         */
        public String getFrameList() { 
          return this.frameList == null ? null : this.frameList.getValue();
        }

        /**
         * @param value The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.
         */
        public ImagingSelectionInstanceComponent setFrameList(String value) { 
          if (Utilities.noString(value))
            this.frameList = null;
          else {
            if (this.frameList == null)
              this.frameList = new StringType();
            this.frameList.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #observationUid} (The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.)
         */
        public List<OidType> getObservationUid() { 
          if (this.observationUid == null)
            this.observationUid = new ArrayList<OidType>();
          return this.observationUid;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingSelectionInstanceComponent setObservationUid(List<OidType> theObservationUid) { 
          this.observationUid = theObservationUid;
          return this;
        }

        public boolean hasObservationUid() { 
          if (this.observationUid == null)
            return false;
          for (OidType item : this.observationUid)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #observationUid} (The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.)
         */
        public OidType addObservationUidElement() {//2 
          OidType t = new OidType();
          if (this.observationUid == null)
            this.observationUid = new ArrayList<OidType>();
          this.observationUid.add(t);
          return t;
        }

        /**
         * @param value {@link #observationUid} (The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.)
         */
        public ImagingSelectionInstanceComponent addObservationUid(String value) { //1
          OidType t = new OidType();
          t.setValue(value);
          if (this.observationUid == null)
            this.observationUid = new ArrayList<OidType>();
          this.observationUid.add(t);
          return this;
        }

        /**
         * @param value {@link #observationUid} (The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.)
         */
        public boolean hasObservationUid(String value) { 
          if (this.observationUid == null)
            return false;
          for (OidType v : this.observationUid)
            if (v.getValue().equals(value)) // oid
              return true;
          return false;
        }

        /**
         * @return {@link #segmentList} (The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.). This is the underlying object with id, value and extensions. The accessor "getSegmentList" gives direct access to the value
         */
        public StringType getSegmentListElement() { 
          if (this.segmentList == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.segmentList");
            else if (Configuration.doAutoCreate())
              this.segmentList = new StringType(); // bb
          return this.segmentList;
        }

        public boolean hasSegmentListElement() { 
          return this.segmentList != null && !this.segmentList.isEmpty();
        }

        public boolean hasSegmentList() { 
          return this.segmentList != null && !this.segmentList.isEmpty();
        }

        /**
         * @param value {@link #segmentList} (The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.). This is the underlying object with id, value and extensions. The accessor "getSegmentList" gives direct access to the value
         */
        public ImagingSelectionInstanceComponent setSegmentListElement(StringType value) { 
          this.segmentList = value;
          return this;
        }

        /**
         * @return The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.
         */
        public String getSegmentList() { 
          return this.segmentList == null ? null : this.segmentList.getValue();
        }

        /**
         * @param value The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.
         */
        public ImagingSelectionInstanceComponent setSegmentList(String value) { 
          if (Utilities.noString(value))
            this.segmentList = null;
          else {
            if (this.segmentList == null)
              this.segmentList = new StringType();
            this.segmentList.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #roiList} (The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.). This is the underlying object with id, value and extensions. The accessor "getRoiList" gives direct access to the value
         */
        public StringType getRoiListElement() { 
          if (this.roiList == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.roiList");
            else if (Configuration.doAutoCreate())
              this.roiList = new StringType(); // bb
          return this.roiList;
        }

        public boolean hasRoiListElement() { 
          return this.roiList != null && !this.roiList.isEmpty();
        }

        public boolean hasRoiList() { 
          return this.roiList != null && !this.roiList.isEmpty();
        }

        /**
         * @param value {@link #roiList} (The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.). This is the underlying object with id, value and extensions. The accessor "getRoiList" gives direct access to the value
         */
        public ImagingSelectionInstanceComponent setRoiListElement(StringType value) { 
          this.roiList = value;
          return this;
        }

        /**
         * @return The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.
         */
        public String getRoiList() { 
          return this.roiList == null ? null : this.roiList.getValue();
        }

        /**
         * @param value The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.
         */
        public ImagingSelectionInstanceComponent setRoiList(String value) { 
          if (Utilities.noString(value))
            this.roiList = null;
          else {
            if (this.roiList == null)
              this.roiList = new StringType();
            this.roiList.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("uid", "oid", "The SOP Instance UID for the selected DICOM instance.", 0, 1, uid));
          children.add(new Property("sopClass", "Coding", "The SOP Class UID for the selected DICOM instance.", 0, 1, sopClass));
          children.add(new Property("frameList", "string", "The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.", 0, 1, frameList));
          children.add(new Property("observationUid", "oid", "The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.", 0, java.lang.Integer.MAX_VALUE, observationUid));
          children.add(new Property("segmentList", "string", "The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.", 0, 1, segmentList));
          children.add(new Property("roiList", "string", "The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.", 0, 1, roiList));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 115792: /*uid*/  return new Property("uid", "oid", "The SOP Instance UID for the selected DICOM instance.", 0, 1, uid);
          case 1560041540: /*sopClass*/  return new Property("sopClass", "Coding", "The SOP Class UID for the selected DICOM instance.", 0, 1, sopClass);
          case 544886699: /*frameList*/  return new Property("frameList", "string", "The set of frames within a multi-frame SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate frame numbers.       If this is absent, all frames within the referenced SOP Instance are included in the selection.", 0, 1, frameList);
          case -1631882108: /*observationUid*/  return new Property("observationUid", "oid", "The unique identifier for the observation Content Item (and its subsidiary Content Items, if any) that are included in the imaging selection.", 0, java.lang.Integer.MAX_VALUE, observationUid);
          case -953159055: /*segmentList*/  return new Property("segmentList", "string", "The set of segments within a segmentation SOP Instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate segment numbers.       If this is absent, all segments within the referenced segmentation SOP Instance are included in the selection.", 0, 1, segmentList);
          case 1373378698: /*roiList*/  return new Property("roiList", "string", "The set of regions of interest (ROI) within a radiotherapy structure set instance that are included in the imaging selection.       Encoded as a comma separated list of one or more non duplicate ROI numbers.       If this is absent, all ROIs within the referenced radiotherapy structure set SOP Instance are included in the selection.", 0, 1, roiList);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // OidType
        case 1560041540: /*sopClass*/ return this.sopClass == null ? new Base[0] : new Base[] {this.sopClass}; // Coding
        case 544886699: /*frameList*/ return this.frameList == null ? new Base[0] : new Base[] {this.frameList}; // StringType
        case -1631882108: /*observationUid*/ return this.observationUid == null ? new Base[0] : this.observationUid.toArray(new Base[this.observationUid.size()]); // OidType
        case -953159055: /*segmentList*/ return this.segmentList == null ? new Base[0] : new Base[] {this.segmentList}; // StringType
        case 1373378698: /*roiList*/ return this.roiList == null ? new Base[0] : new Base[] {this.roiList}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = TypeConvertor.castToOid(value); // OidType
          return value;
        case 1560041540: // sopClass
          this.sopClass = TypeConvertor.castToCoding(value); // Coding
          return value;
        case 544886699: // frameList
          this.frameList = TypeConvertor.castToString(value); // StringType
          return value;
        case -1631882108: // observationUid
          this.getObservationUid().add(TypeConvertor.castToOid(value)); // OidType
          return value;
        case -953159055: // segmentList
          this.segmentList = TypeConvertor.castToString(value); // StringType
          return value;
        case 1373378698: // roiList
          this.roiList = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = TypeConvertor.castToOid(value); // OidType
        } else if (name.equals("sopClass")) {
          this.sopClass = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("frameList")) {
          this.frameList = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("observationUid")) {
          this.getObservationUid().add(TypeConvertor.castToOid(value));
        } else if (name.equals("segmentList")) {
          this.segmentList = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("roiList")) {
          this.roiList = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUidElement();
        case 1560041540:  return getSopClass();
        case 544886699:  return getFrameListElement();
        case -1631882108:  return addObservationUidElement();
        case -953159055:  return getSegmentListElement();
        case 1373378698:  return getRoiListElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"oid"};
        case 1560041540: /*sopClass*/ return new String[] {"Coding"};
        case 544886699: /*frameList*/ return new String[] {"string"};
        case -1631882108: /*observationUid*/ return new String[] {"oid"};
        case -953159055: /*segmentList*/ return new String[] {"string"};
        case 1373378698: /*roiList*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.uid");
        }
        else if (name.equals("sopClass")) {
          this.sopClass = new Coding();
          return this.sopClass;
        }
        else if (name.equals("frameList")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.frameList");
        }
        else if (name.equals("observationUid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.observationUid");
        }
        else if (name.equals("segmentList")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.segmentList");
        }
        else if (name.equals("roiList")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.roiList");
        }
        else
          return super.addChild(name);
      }

      public ImagingSelectionInstanceComponent copy() {
        ImagingSelectionInstanceComponent dst = new ImagingSelectionInstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImagingSelectionInstanceComponent dst) {
        super.copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        dst.sopClass = sopClass == null ? null : sopClass.copy();
        dst.frameList = frameList == null ? null : frameList.copy();
        if (observationUid != null) {
          dst.observationUid = new ArrayList<OidType>();
          for (OidType i : observationUid)
            dst.observationUid.add(i.copy());
        };
        dst.segmentList = segmentList == null ? null : segmentList.copy();
        dst.roiList = roiList == null ? null : roiList.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionInstanceComponent))
          return false;
        ImagingSelectionInstanceComponent o = (ImagingSelectionInstanceComponent) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(sopClass, o.sopClass, true) && compareDeep(frameList, o.frameList, true)
           && compareDeep(observationUid, o.observationUid, true) && compareDeep(segmentList, o.segmentList, true)
           && compareDeep(roiList, o.roiList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionInstanceComponent))
          return false;
        ImagingSelectionInstanceComponent o = (ImagingSelectionInstanceComponent) other_;
        return compareValues(uid, o.uid, true) && compareValues(frameList, o.frameList, true) && compareValues(observationUid, o.observationUid, true)
           && compareValues(segmentList, o.segmentList, true) && compareValues(roiList, o.roiList, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, sopClass, frameList
          , observationUid, segmentList, roiList);
      }

  public String fhirType() {
    return "ImagingSelection.instance";

  }

  }

    @Block()
    public static class ImagingSelectionImageRegionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Specifies the type of image region.
         */
        @Child(name = "regionType", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="POINT | MULTIPOINT | POLYLINE | POLYGON | ELLIPSE | ELLIPSOID", formalDefinition="Specifies the type of image region." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingselection-graphictype")
        protected Enumeration<ImagingSelectionGraphicType> regionType;

        /**
         * Specifies the type of coordinate system that define the image region.
         */
        @Child(name = "coordinateType", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="2d | 3d", formalDefinition="Specifies the type of coordinate system that define the image region." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingselection-coordinatetype")
        protected Enumeration<ImagingSelectionCoordinateType> coordinateType;

        /**
         * The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.
         */
        @Child(name = "coordinates", type = {DecimalType.class}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specifies the type of coordinates that define the image region 2d | 3d", formalDefinition="The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element." )
        protected List<DecimalType> coordinates;

        private static final long serialVersionUID = -1266111852L;

    /**
     * Constructor
     */
      public ImagingSelectionImageRegionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingSelectionImageRegionComponent(ImagingSelectionGraphicType regionType, ImagingSelectionCoordinateType coordinateType, BigDecimal coordinates) {
        super();
        this.setRegionType(regionType);
        this.setCoordinateType(coordinateType);
        this.addCoordinates(coordinates);
      }

        /**
         * @return {@link #regionType} (Specifies the type of image region.). This is the underlying object with id, value and extensions. The accessor "getRegionType" gives direct access to the value
         */
        public Enumeration<ImagingSelectionGraphicType> getRegionTypeElement() { 
          if (this.regionType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionImageRegionComponent.regionType");
            else if (Configuration.doAutoCreate())
              this.regionType = new Enumeration<ImagingSelectionGraphicType>(new ImagingSelectionGraphicTypeEnumFactory()); // bb
          return this.regionType;
        }

        public boolean hasRegionTypeElement() { 
          return this.regionType != null && !this.regionType.isEmpty();
        }

        public boolean hasRegionType() { 
          return this.regionType != null && !this.regionType.isEmpty();
        }

        /**
         * @param value {@link #regionType} (Specifies the type of image region.). This is the underlying object with id, value and extensions. The accessor "getRegionType" gives direct access to the value
         */
        public ImagingSelectionImageRegionComponent setRegionTypeElement(Enumeration<ImagingSelectionGraphicType> value) { 
          this.regionType = value;
          return this;
        }

        /**
         * @return Specifies the type of image region.
         */
        public ImagingSelectionGraphicType getRegionType() { 
          return this.regionType == null ? null : this.regionType.getValue();
        }

        /**
         * @param value Specifies the type of image region.
         */
        public ImagingSelectionImageRegionComponent setRegionType(ImagingSelectionGraphicType value) { 
            if (this.regionType == null)
              this.regionType = new Enumeration<ImagingSelectionGraphicType>(new ImagingSelectionGraphicTypeEnumFactory());
            this.regionType.setValue(value);
          return this;
        }

        /**
         * @return {@link #coordinateType} (Specifies the type of coordinate system that define the image region.). This is the underlying object with id, value and extensions. The accessor "getCoordinateType" gives direct access to the value
         */
        public Enumeration<ImagingSelectionCoordinateType> getCoordinateTypeElement() { 
          if (this.coordinateType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionImageRegionComponent.coordinateType");
            else if (Configuration.doAutoCreate())
              this.coordinateType = new Enumeration<ImagingSelectionCoordinateType>(new ImagingSelectionCoordinateTypeEnumFactory()); // bb
          return this.coordinateType;
        }

        public boolean hasCoordinateTypeElement() { 
          return this.coordinateType != null && !this.coordinateType.isEmpty();
        }

        public boolean hasCoordinateType() { 
          return this.coordinateType != null && !this.coordinateType.isEmpty();
        }

        /**
         * @param value {@link #coordinateType} (Specifies the type of coordinate system that define the image region.). This is the underlying object with id, value and extensions. The accessor "getCoordinateType" gives direct access to the value
         */
        public ImagingSelectionImageRegionComponent setCoordinateTypeElement(Enumeration<ImagingSelectionCoordinateType> value) { 
          this.coordinateType = value;
          return this;
        }

        /**
         * @return Specifies the type of coordinate system that define the image region.
         */
        public ImagingSelectionCoordinateType getCoordinateType() { 
          return this.coordinateType == null ? null : this.coordinateType.getValue();
        }

        /**
         * @param value Specifies the type of coordinate system that define the image region.
         */
        public ImagingSelectionImageRegionComponent setCoordinateType(ImagingSelectionCoordinateType value) { 
            if (this.coordinateType == null)
              this.coordinateType = new Enumeration<ImagingSelectionCoordinateType>(new ImagingSelectionCoordinateTypeEnumFactory());
            this.coordinateType.setValue(value);
          return this;
        }

        /**
         * @return {@link #coordinates} (The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.)
         */
        public List<DecimalType> getCoordinates() { 
          if (this.coordinates == null)
            this.coordinates = new ArrayList<DecimalType>();
          return this.coordinates;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingSelectionImageRegionComponent setCoordinates(List<DecimalType> theCoordinates) { 
          this.coordinates = theCoordinates;
          return this;
        }

        public boolean hasCoordinates() { 
          if (this.coordinates == null)
            return false;
          for (DecimalType item : this.coordinates)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #coordinates} (The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.)
         */
        public DecimalType addCoordinatesElement() {//2 
          DecimalType t = new DecimalType();
          if (this.coordinates == null)
            this.coordinates = new ArrayList<DecimalType>();
          this.coordinates.add(t);
          return t;
        }

        /**
         * @param value {@link #coordinates} (The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.)
         */
        public ImagingSelectionImageRegionComponent addCoordinates(BigDecimal value) { //1
          DecimalType t = new DecimalType();
          t.setValue(value);
          if (this.coordinates == null)
            this.coordinates = new ArrayList<DecimalType>();
          this.coordinates.add(t);
          return this;
        }

        /**
         * @param value {@link #coordinates} (The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.)
         */
        public boolean hasCoordinates(BigDecimal value) { 
          if (this.coordinates == null)
            return false;
          for (DecimalType v : this.coordinates)
            if (v.getValue().equals(value)) // decimal
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("regionType", "code", "Specifies the type of image region.", 0, 1, regionType));
          children.add(new Property("coordinateType", "code", "Specifies the type of coordinate system that define the image region.", 0, 1, coordinateType));
          children.add(new Property("coordinates", "decimal", "The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.", 0, java.lang.Integer.MAX_VALUE, coordinates));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1990487986: /*regionType*/  return new Property("regionType", "code", "Specifies the type of image region.", 0, 1, regionType);
          case 500956370: /*coordinateType*/  return new Property("coordinateType", "code", "Specifies the type of coordinate system that define the image region.", 0, 1, coordinateType);
          case 1871919611: /*coordinates*/  return new Property("coordinates", "decimal", "The coordinates describing the image region.       If coordinateType is 2D this specifies sequence of (x,y) coordinates in the coordinate system of the image specified by the instance.uid element that contains this image region.       If coordinateType is 3D this specifies sequence of (x,y,z) coordinates in the coordinate system specified by the frameOfReferenceUid element.", 0, java.lang.Integer.MAX_VALUE, coordinates);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1990487986: /*regionType*/ return this.regionType == null ? new Base[0] : new Base[] {this.regionType}; // Enumeration<ImagingSelectionGraphicType>
        case 500956370: /*coordinateType*/ return this.coordinateType == null ? new Base[0] : new Base[] {this.coordinateType}; // Enumeration<ImagingSelectionCoordinateType>
        case 1871919611: /*coordinates*/ return this.coordinates == null ? new Base[0] : this.coordinates.toArray(new Base[this.coordinates.size()]); // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1990487986: // regionType
          value = new ImagingSelectionGraphicTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.regionType = (Enumeration) value; // Enumeration<ImagingSelectionGraphicType>
          return value;
        case 500956370: // coordinateType
          value = new ImagingSelectionCoordinateTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.coordinateType = (Enumeration) value; // Enumeration<ImagingSelectionCoordinateType>
          return value;
        case 1871919611: // coordinates
          this.getCoordinates().add(TypeConvertor.castToDecimal(value)); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("regionType")) {
          value = new ImagingSelectionGraphicTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.regionType = (Enumeration) value; // Enumeration<ImagingSelectionGraphicType>
        } else if (name.equals("coordinateType")) {
          value = new ImagingSelectionCoordinateTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.coordinateType = (Enumeration) value; // Enumeration<ImagingSelectionCoordinateType>
        } else if (name.equals("coordinates")) {
          this.getCoordinates().add(TypeConvertor.castToDecimal(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1990487986:  return getRegionTypeElement();
        case 500956370:  return getCoordinateTypeElement();
        case 1871919611:  return addCoordinatesElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1990487986: /*regionType*/ return new String[] {"code"};
        case 500956370: /*coordinateType*/ return new String[] {"code"};
        case 1871919611: /*coordinates*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("regionType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.imageRegion.regionType");
        }
        else if (name.equals("coordinateType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.imageRegion.coordinateType");
        }
        else if (name.equals("coordinates")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.imageRegion.coordinates");
        }
        else
          return super.addChild(name);
      }

      public ImagingSelectionImageRegionComponent copy() {
        ImagingSelectionImageRegionComponent dst = new ImagingSelectionImageRegionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImagingSelectionImageRegionComponent dst) {
        super.copyValues(dst);
        dst.regionType = regionType == null ? null : regionType.copy();
        dst.coordinateType = coordinateType == null ? null : coordinateType.copy();
        if (coordinates != null) {
          dst.coordinates = new ArrayList<DecimalType>();
          for (DecimalType i : coordinates)
            dst.coordinates.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionImageRegionComponent))
          return false;
        ImagingSelectionImageRegionComponent o = (ImagingSelectionImageRegionComponent) other_;
        return compareDeep(regionType, o.regionType, true) && compareDeep(coordinateType, o.coordinateType, true)
           && compareDeep(coordinates, o.coordinates, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionImageRegionComponent))
          return false;
        ImagingSelectionImageRegionComponent o = (ImagingSelectionImageRegionComponent) other_;
        return compareValues(regionType, o.regionType, true) && compareValues(coordinateType, o.coordinateType, true)
           && compareValues(coordinates, o.coordinates, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(regionType, coordinateType
          , coordinates);
      }

  public String fhirType() {
    return "ImagingSelection.imageRegion";

  }

  }

    /**
     * A unique identifier assigned to this imaging selection.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for Imaging Selection", formalDefinition="A unique identifier assigned to this imaging selection." )
    protected List<Identifier> identifier;

    /**
     * A list of the diagnostic requests that resulted in this imaging selection being performed.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ServiceRequest.class, Appointment.class, AppointmentResponse.class, Task.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Associated request", formalDefinition="A list of the diagnostic requests that resulted in this imaging selection being performed." )
    protected List<Reference> basedOn;

    /**
     * The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, Specimen.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Subject of the selected instances and / or frames", formalDefinition="The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed." )
    protected Reference subject;

    /**
     * The date and time this imaging selection was created.
     */
    @Child(name = "issued", type = {InstantType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date / Time when the selection of instances was made", formalDefinition="The date and time this imaging selection was created." )
    protected InstantType issued;

    /**
     * Author – human or machine.
     */
    @Child(name = "performer", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Author (human or machine)", formalDefinition="Author – human or machine." )
    protected List<ImagingSelectionPerformerComponent> performer;

    /**
     * Describes the imaging selection.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Imaging Selection description text or code", formalDefinition="Describes the imaging selection." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_7010.html")
    protected CodeableConcept code;

    /**
     * The Study Instance UID for the DICOM Study from which the images were selected.
     */
    @Child(name = "studyUid", type = {OidType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="DICOM Study Instance UID", formalDefinition="The Study Instance UID for the DICOM Study from which the images were selected." )
    protected OidType studyUid;

    /**
     * The imaging study from which the imaging selection is made.
     */
    @Child(name = "derivedFrom", type = {ImagingStudy.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The imaging study from which the imaging selection is derived", formalDefinition="The imaging study from which the imaging selection is made." )
    protected List<Reference> derivedFrom;

    /**
     * The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The network service providing retrieval for the images referenced in the imaging selection", formalDefinition="The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints." )
    protected List<Reference> endpoint;

    /**
     * The Series Instance UID for the DICOM Series from which the images were selected.
     */
    @Child(name = "seriesUid", type = {OidType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="DICOM Series Instance UID", formalDefinition="The Series Instance UID for the DICOM Series from which the images were selected." )
    protected OidType seriesUid;

    /**
     * The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.
     */
    @Child(name = "frameOfReferenceUid", type = {OidType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Frame of Reference UID for the selected images", formalDefinition="The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames." )
    protected OidType frameOfReferenceUid;

    /**
     * The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.
     */
    @Child(name = "bodySite", type = {Coding.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Body part examined", formalDefinition="The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected Coding bodySite;

    /**
     * Each imaging selection includes one or more selected DICOM SOP instances.
     */
    @Child(name = "instance", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The selected instances", formalDefinition="Each imaging selection includes one or more selected DICOM SOP instances." )
    protected List<ImagingSelectionInstanceComponent> instance;

    /**
     * Each imaging selection might includes one or more image regions. Image regions are specified by a region type and a set of 2D or 3D coordinates.
     */
    @Child(name = "imageRegion", type = {}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A specific region in a DICOM image / frame", formalDefinition="Each imaging selection might includes one or more image regions. Image regions are specified by a region type and a set of 2D or 3D coordinates." )
    protected ImagingSelectionImageRegionComponent imageRegion;

    private static final long serialVersionUID = 4408161L;

  /**
   * Constructor
   */
    public ImagingSelection() {
      super();
    }

  /**
   * Constructor
   */
    public ImagingSelection(CodeableConcept code) {
      super();
      this.setCode(code);
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this imaging selection.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setIdentifier(List<Identifier> theIdentifier) { 
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

    public ImagingSelection addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A list of the diagnostic requests that resulted in this imaging selection being performed.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setBasedOn(List<Reference> theBasedOn) { 
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

    public ImagingSelection addBasedOn(Reference t) { //3
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
     * @return {@link #subject} (The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.)
     */
    public ImagingSelection setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #issued} (The date and time this imaging selection was created.). This is the underlying object with id, value and extensions. The accessor "getIssued" gives direct access to the value
     */
    public InstantType getIssuedElement() { 
      if (this.issued == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.issued");
        else if (Configuration.doAutoCreate())
          this.issued = new InstantType(); // bb
      return this.issued;
    }

    public boolean hasIssuedElement() { 
      return this.issued != null && !this.issued.isEmpty();
    }

    public boolean hasIssued() { 
      return this.issued != null && !this.issued.isEmpty();
    }

    /**
     * @param value {@link #issued} (The date and time this imaging selection was created.). This is the underlying object with id, value and extensions. The accessor "getIssued" gives direct access to the value
     */
    public ImagingSelection setIssuedElement(InstantType value) { 
      this.issued = value;
      return this;
    }

    /**
     * @return The date and time this imaging selection was created.
     */
    public Date getIssued() { 
      return this.issued == null ? null : this.issued.getValue();
    }

    /**
     * @param value The date and time this imaging selection was created.
     */
    public ImagingSelection setIssued(Date value) { 
      if (value == null)
        this.issued = null;
      else {
        if (this.issued == null)
          this.issued = new InstantType();
        this.issued.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #performer} (Author – human or machine.)
     */
    public List<ImagingSelectionPerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<ImagingSelectionPerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setPerformer(List<ImagingSelectionPerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (ImagingSelectionPerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ImagingSelectionPerformerComponent addPerformer() { //3
      ImagingSelectionPerformerComponent t = new ImagingSelectionPerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<ImagingSelectionPerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public ImagingSelection addPerformer(ImagingSelectionPerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<ImagingSelectionPerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public ImagingSelectionPerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #code} (Describes the imaging selection.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Describes the imaging selection.)
     */
    public ImagingSelection setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #studyUid} (The Study Instance UID for the DICOM Study from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getStudyUid" gives direct access to the value
     */
    public OidType getStudyUidElement() { 
      if (this.studyUid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.studyUid");
        else if (Configuration.doAutoCreate())
          this.studyUid = new OidType(); // bb
      return this.studyUid;
    }

    public boolean hasStudyUidElement() { 
      return this.studyUid != null && !this.studyUid.isEmpty();
    }

    public boolean hasStudyUid() { 
      return this.studyUid != null && !this.studyUid.isEmpty();
    }

    /**
     * @param value {@link #studyUid} (The Study Instance UID for the DICOM Study from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getStudyUid" gives direct access to the value
     */
    public ImagingSelection setStudyUidElement(OidType value) { 
      this.studyUid = value;
      return this;
    }

    /**
     * @return The Study Instance UID for the DICOM Study from which the images were selected.
     */
    public String getStudyUid() { 
      return this.studyUid == null ? null : this.studyUid.getValue();
    }

    /**
     * @param value The Study Instance UID for the DICOM Study from which the images were selected.
     */
    public ImagingSelection setStudyUid(String value) { 
      if (Utilities.noString(value))
        this.studyUid = null;
      else {
        if (this.studyUid == null)
          this.studyUid = new OidType();
        this.studyUid.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #derivedFrom} (The imaging study from which the imaging selection is made.)
     */
    public List<Reference> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setDerivedFrom(List<Reference> theDerivedFrom) { 
      this.derivedFrom = theDerivedFrom;
      return this;
    }

    public boolean hasDerivedFrom() { 
      if (this.derivedFrom == null)
        return false;
      for (Reference item : this.derivedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addDerivedFrom() { //3
      Reference t = new Reference();
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return t;
    }

    public ImagingSelection addDerivedFrom(Reference t) { //3
      if (t == null)
        return this;
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #derivedFrom}, creating it if it does not already exist {3}
     */
    public Reference getDerivedFromFirstRep() { 
      if (getDerivedFrom().isEmpty()) {
        addDerivedFrom();
      }
      return getDerivedFrom().get(0);
    }

    /**
     * @return {@link #endpoint} (The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.)
     */
    public List<Reference> getEndpoint() { 
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      return this.endpoint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setEndpoint(List<Reference> theEndpoint) { 
      this.endpoint = theEndpoint;
      return this;
    }

    public boolean hasEndpoint() { 
      if (this.endpoint == null)
        return false;
      for (Reference item : this.endpoint)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEndpoint() { //3
      Reference t = new Reference();
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return t;
    }

    public ImagingSelection addEndpoint(Reference t) { //3
      if (t == null)
        return this;
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist {3}
     */
    public Reference getEndpointFirstRep() { 
      if (getEndpoint().isEmpty()) {
        addEndpoint();
      }
      return getEndpoint().get(0);
    }

    /**
     * @return {@link #seriesUid} (The Series Instance UID for the DICOM Series from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getSeriesUid" gives direct access to the value
     */
    public OidType getSeriesUidElement() { 
      if (this.seriesUid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.seriesUid");
        else if (Configuration.doAutoCreate())
          this.seriesUid = new OidType(); // bb
      return this.seriesUid;
    }

    public boolean hasSeriesUidElement() { 
      return this.seriesUid != null && !this.seriesUid.isEmpty();
    }

    public boolean hasSeriesUid() { 
      return this.seriesUid != null && !this.seriesUid.isEmpty();
    }

    /**
     * @param value {@link #seriesUid} (The Series Instance UID for the DICOM Series from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getSeriesUid" gives direct access to the value
     */
    public ImagingSelection setSeriesUidElement(OidType value) { 
      this.seriesUid = value;
      return this;
    }

    /**
     * @return The Series Instance UID for the DICOM Series from which the images were selected.
     */
    public String getSeriesUid() { 
      return this.seriesUid == null ? null : this.seriesUid.getValue();
    }

    /**
     * @param value The Series Instance UID for the DICOM Series from which the images were selected.
     */
    public ImagingSelection setSeriesUid(String value) { 
      if (Utilities.noString(value))
        this.seriesUid = null;
      else {
        if (this.seriesUid == null)
          this.seriesUid = new OidType();
        this.seriesUid.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #frameOfReferenceUid} (The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.). This is the underlying object with id, value and extensions. The accessor "getFrameOfReferenceUid" gives direct access to the value
     */
    public OidType getFrameOfReferenceUidElement() { 
      if (this.frameOfReferenceUid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.frameOfReferenceUid");
        else if (Configuration.doAutoCreate())
          this.frameOfReferenceUid = new OidType(); // bb
      return this.frameOfReferenceUid;
    }

    public boolean hasFrameOfReferenceUidElement() { 
      return this.frameOfReferenceUid != null && !this.frameOfReferenceUid.isEmpty();
    }

    public boolean hasFrameOfReferenceUid() { 
      return this.frameOfReferenceUid != null && !this.frameOfReferenceUid.isEmpty();
    }

    /**
     * @param value {@link #frameOfReferenceUid} (The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.). This is the underlying object with id, value and extensions. The accessor "getFrameOfReferenceUid" gives direct access to the value
     */
    public ImagingSelection setFrameOfReferenceUidElement(OidType value) { 
      this.frameOfReferenceUid = value;
      return this;
    }

    /**
     * @return The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.
     */
    public String getFrameOfReferenceUid() { 
      return this.frameOfReferenceUid == null ? null : this.frameOfReferenceUid.getValue();
    }

    /**
     * @param value The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.
     */
    public ImagingSelection setFrameOfReferenceUid(String value) { 
      if (Utilities.noString(value))
        this.frameOfReferenceUid = null;
      else {
        if (this.frameOfReferenceUid == null)
          this.frameOfReferenceUid = new OidType();
        this.frameOfReferenceUid.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.)
     */
    public Coding getBodySite() { 
      if (this.bodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.bodySite");
        else if (Configuration.doAutoCreate())
          this.bodySite = new Coding(); // cc
      return this.bodySite;
    }

    public boolean hasBodySite() { 
      return this.bodySite != null && !this.bodySite.isEmpty();
    }

    /**
     * @param value {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.)
     */
    public ImagingSelection setBodySite(Coding value) { 
      this.bodySite = value;
      return this;
    }

    /**
     * @return {@link #instance} (Each imaging selection includes one or more selected DICOM SOP instances.)
     */
    public List<ImagingSelectionInstanceComponent> getInstance() { 
      if (this.instance == null)
        this.instance = new ArrayList<ImagingSelectionInstanceComponent>();
      return this.instance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setInstance(List<ImagingSelectionInstanceComponent> theInstance) { 
      this.instance = theInstance;
      return this;
    }

    public boolean hasInstance() { 
      if (this.instance == null)
        return false;
      for (ImagingSelectionInstanceComponent item : this.instance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ImagingSelectionInstanceComponent addInstance() { //3
      ImagingSelectionInstanceComponent t = new ImagingSelectionInstanceComponent();
      if (this.instance == null)
        this.instance = new ArrayList<ImagingSelectionInstanceComponent>();
      this.instance.add(t);
      return t;
    }

    public ImagingSelection addInstance(ImagingSelectionInstanceComponent t) { //3
      if (t == null)
        return this;
      if (this.instance == null)
        this.instance = new ArrayList<ImagingSelectionInstanceComponent>();
      this.instance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #instance}, creating it if it does not already exist {3}
     */
    public ImagingSelectionInstanceComponent getInstanceFirstRep() { 
      if (getInstance().isEmpty()) {
        addInstance();
      }
      return getInstance().get(0);
    }

    /**
     * @return {@link #imageRegion} (Each imaging selection might includes one or more image regions. Image regions are specified by a region type and a set of 2D or 3D coordinates.)
     */
    public ImagingSelectionImageRegionComponent getImageRegion() { 
      if (this.imageRegion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.imageRegion");
        else if (Configuration.doAutoCreate())
          this.imageRegion = new ImagingSelectionImageRegionComponent(); // cc
      return this.imageRegion;
    }

    public boolean hasImageRegion() { 
      return this.imageRegion != null && !this.imageRegion.isEmpty();
    }

    /**
     * @param value {@link #imageRegion} (Each imaging selection might includes one or more image regions. Image regions are specified by a region type and a set of 2D or 3D coordinates.)
     */
    public ImagingSelection setImageRegion(ImagingSelectionImageRegionComponent value) { 
      this.imageRegion = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this imaging selection.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging selection being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|Specimen)", "The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.", 0, 1, subject));
        children.add(new Property("issued", "instant", "The date and time this imaging selection was created.", 0, 1, issued));
        children.add(new Property("performer", "", "Author – human or machine.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("code", "CodeableConcept", "Describes the imaging selection.", 0, 1, code));
        children.add(new Property("studyUid", "oid", "The Study Instance UID for the DICOM Study from which the images were selected.", 0, 1, studyUid));
        children.add(new Property("derivedFrom", "Reference(ImagingStudy)", "The imaging study from which the imaging selection is made.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("endpoint", "Reference(Endpoint)", "The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.", 0, java.lang.Integer.MAX_VALUE, endpoint));
        children.add(new Property("seriesUid", "oid", "The Series Instance UID for the DICOM Series from which the images were selected.", 0, 1, seriesUid));
        children.add(new Property("frameOfReferenceUid", "oid", "The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.", 0, 1, frameOfReferenceUid));
        children.add(new Property("bodySite", "Coding", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.", 0, 1, bodySite));
        children.add(new Property("instance", "", "Each imaging selection includes one or more selected DICOM SOP instances.", 0, java.lang.Integer.MAX_VALUE, instance));
        children.add(new Property("imageRegion", "", "Each imaging selection might includes one or more image regions. Image regions are specified by a region type and a set of 2D or 3D coordinates.", 0, 1, imageRegion));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this imaging selection.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging selection being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|Specimen)", "The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.", 0, 1, subject);
        case -1179159893: /*issued*/  return new Property("issued", "instant", "The date and time this imaging selection was created.", 0, 1, issued);
        case 481140686: /*performer*/  return new Property("performer", "", "Author – human or machine.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Describes the imaging selection.", 0, 1, code);
        case 1876590023: /*studyUid*/  return new Property("studyUid", "oid", "The Study Instance UID for the DICOM Study from which the images were selected.", 0, 1, studyUid);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(ImagingStudy)", "The imaging study from which the imaging selection is made.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        case -569596327: /*seriesUid*/  return new Property("seriesUid", "oid", "The Series Instance UID for the DICOM Series from which the images were selected.", 0, 1, seriesUid);
        case 828378953: /*frameOfReferenceUid*/  return new Property("frameOfReferenceUid", "oid", "The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.", 0, 1, frameOfReferenceUid);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "Coding", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.", 0, 1, bodySite);
        case 555127957: /*instance*/  return new Property("instance", "", "Each imaging selection includes one or more selected DICOM SOP instances.", 0, java.lang.Integer.MAX_VALUE, instance);
        case 2132544559: /*imageRegion*/  return new Property("imageRegion", "", "Each imaging selection might includes one or more image regions. Image regions are specified by a region type and a set of 2D or 3D coordinates.", 0, 1, imageRegion);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -1179159893: /*issued*/ return this.issued == null ? new Base[0] : new Base[] {this.issued}; // InstantType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // ImagingSelectionPerformerComponent
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 1876590023: /*studyUid*/ return this.studyUid == null ? new Base[0] : new Base[] {this.studyUid}; // OidType
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case -569596327: /*seriesUid*/ return this.seriesUid == null ? new Base[0] : new Base[] {this.seriesUid}; // OidType
        case 828378953: /*frameOfReferenceUid*/ return this.frameOfReferenceUid == null ? new Base[0] : new Base[] {this.frameOfReferenceUid}; // OidType
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // Coding
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : this.instance.toArray(new Base[this.instance.size()]); // ImagingSelectionInstanceComponent
        case 2132544559: /*imageRegion*/ return this.imageRegion == null ? new Base[0] : new Base[] {this.imageRegion}; // ImagingSelectionImageRegionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1179159893: // issued
          this.issued = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 481140686: // performer
          this.getPerformer().add((ImagingSelectionPerformerComponent) value); // ImagingSelectionPerformerComponent
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1876590023: // studyUid
          this.studyUid = TypeConvertor.castToOid(value); // OidType
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -569596327: // seriesUid
          this.seriesUid = TypeConvertor.castToOid(value); // OidType
          return value;
        case 828378953: // frameOfReferenceUid
          this.frameOfReferenceUid = TypeConvertor.castToOid(value); // OidType
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCoding(value); // Coding
          return value;
        case 555127957: // instance
          this.getInstance().add((ImagingSelectionInstanceComponent) value); // ImagingSelectionInstanceComponent
          return value;
        case 2132544559: // imageRegion
          this.imageRegion = (ImagingSelectionImageRegionComponent) value; // ImagingSelectionImageRegionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("issued")) {
          this.issued = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("performer")) {
          this.getPerformer().add((ImagingSelectionPerformerComponent) value);
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("studyUid")) {
          this.studyUid = TypeConvertor.castToOid(value); // OidType
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else if (name.equals("seriesUid")) {
          this.seriesUid = TypeConvertor.castToOid(value); // OidType
        } else if (name.equals("frameOfReferenceUid")) {
          this.frameOfReferenceUid = TypeConvertor.castToOid(value); // OidType
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("instance")) {
          this.getInstance().add((ImagingSelectionInstanceComponent) value);
        } else if (name.equals("imageRegion")) {
          this.imageRegion = (ImagingSelectionImageRegionComponent) value; // ImagingSelectionImageRegionComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -1867885268:  return getSubject();
        case -1179159893:  return getIssuedElement();
        case 481140686:  return addPerformer(); 
        case 3059181:  return getCode();
        case 1876590023:  return getStudyUidElement();
        case 1077922663:  return addDerivedFrom(); 
        case 1741102485:  return addEndpoint(); 
        case -569596327:  return getSeriesUidElement();
        case 828378953:  return getFrameOfReferenceUidElement();
        case 1702620169:  return getBodySite();
        case 555127957:  return addInstance(); 
        case 2132544559:  return getImageRegion();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -1179159893: /*issued*/ return new String[] {"instant"};
        case 481140686: /*performer*/ return new String[] {};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1876590023: /*studyUid*/ return new String[] {"oid"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case -569596327: /*seriesUid*/ return new String[] {"oid"};
        case 828378953: /*frameOfReferenceUid*/ return new String[] {"oid"};
        case 1702620169: /*bodySite*/ return new String[] {"Coding"};
        case 555127957: /*instance*/ return new String[] {};
        case 2132544559: /*imageRegion*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("issued")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.issued");
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("studyUid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.studyUid");
        }
        else if (name.equals("derivedFrom")) {
          return addDerivedFrom();
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("seriesUid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.seriesUid");
        }
        else if (name.equals("frameOfReferenceUid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.frameOfReferenceUid");
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new Coding();
          return this.bodySite;
        }
        else if (name.equals("instance")) {
          return addInstance();
        }
        else if (name.equals("imageRegion")) {
          this.imageRegion = new ImagingSelectionImageRegionComponent();
          return this.imageRegion;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ImagingSelection";

  }

      public ImagingSelection copy() {
        ImagingSelection dst = new ImagingSelection();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImagingSelection dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.issued = issued == null ? null : issued.copy();
        if (performer != null) {
          dst.performer = new ArrayList<ImagingSelectionPerformerComponent>();
          for (ImagingSelectionPerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.studyUid = studyUid == null ? null : studyUid.copy();
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<Reference>();
          for (Reference i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
        dst.seriesUid = seriesUid == null ? null : seriesUid.copy();
        dst.frameOfReferenceUid = frameOfReferenceUid == null ? null : frameOfReferenceUid.copy();
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        if (instance != null) {
          dst.instance = new ArrayList<ImagingSelectionInstanceComponent>();
          for (ImagingSelectionInstanceComponent i : instance)
            dst.instance.add(i.copy());
        };
        dst.imageRegion = imageRegion == null ? null : imageRegion.copy();
      }

      protected ImagingSelection typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingSelection))
          return false;
        ImagingSelection o = (ImagingSelection) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(subject, o.subject, true)
           && compareDeep(issued, o.issued, true) && compareDeep(performer, o.performer, true) && compareDeep(code, o.code, true)
           && compareDeep(studyUid, o.studyUid, true) && compareDeep(derivedFrom, o.derivedFrom, true) && compareDeep(endpoint, o.endpoint, true)
           && compareDeep(seriesUid, o.seriesUid, true) && compareDeep(frameOfReferenceUid, o.frameOfReferenceUid, true)
           && compareDeep(bodySite, o.bodySite, true) && compareDeep(instance, o.instance, true) && compareDeep(imageRegion, o.imageRegion, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelection))
          return false;
        ImagingSelection o = (ImagingSelection) other_;
        return compareValues(issued, o.issued, true) && compareValues(studyUid, o.studyUid, true) && compareValues(seriesUid, o.seriesUid, true)
           && compareValues(frameOfReferenceUid, o.frameOfReferenceUid, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, subject
          , issued, performer, code, studyUid, derivedFrom, endpoint, seriesUid, frameOfReferenceUid
          , bodySite, instance, imageRegion);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImagingSelection;
   }


}

