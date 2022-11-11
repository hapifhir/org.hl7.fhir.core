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

// Generated on Sat, Nov 5, 2022 10:47+1100 for FHIR v5.0.0-ballot

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

    public enum ImagingSelection2DGraphicType {
        /**
         * A single location denoted by a single (x,y) pair.
         */
        POINT, 
        /**
         * A series of connected line segments with ordered vertices denoted by (x,y) triplets; the points need not be coplanar.
         */
        POLYLINE, 
        /**
         * An n-tuple list of (x,y) pair end points between which some form of implementation dependent curved lines are to be drawn. The rendered line shall pass through all the specified points.
         */
        INTERPOLATED, 
        /**
         * Two points shall be present; the first point is to be interpreted as the center and the second point as a point on the circumference of a circle, some form of implementation dependent representation of which is to be drawn.
         */
        CIRCLE, 
        /**
         * An ellipse defined by four (x,y) pairs, the first two pairs specifying the endpoints of the major axis and the second two pairs specifying the endpoints of the minor axis.
         */
        ELLIPSE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ImagingSelection2DGraphicType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("point".equals(codeString))
          return POINT;
        if ("polyline".equals(codeString))
          return POLYLINE;
        if ("interpolated".equals(codeString))
          return INTERPOLATED;
        if ("circle".equals(codeString))
          return CIRCLE;
        if ("ellipse".equals(codeString))
          return ELLIPSE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImagingSelection2DGraphicType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case POINT: return "point";
            case POLYLINE: return "polyline";
            case INTERPOLATED: return "interpolated";
            case CIRCLE: return "circle";
            case ELLIPSE: return "ellipse";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case POINT: return "http://hl7.org/fhir/imagingselection-2dgraphictype";
            case POLYLINE: return "http://hl7.org/fhir/imagingselection-2dgraphictype";
            case INTERPOLATED: return "http://hl7.org/fhir/imagingselection-2dgraphictype";
            case CIRCLE: return "http://hl7.org/fhir/imagingselection-2dgraphictype";
            case ELLIPSE: return "http://hl7.org/fhir/imagingselection-2dgraphictype";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case POINT: return "A single location denoted by a single (x,y) pair.";
            case POLYLINE: return "A series of connected line segments with ordered vertices denoted by (x,y) triplets; the points need not be coplanar.";
            case INTERPOLATED: return "An n-tuple list of (x,y) pair end points between which some form of implementation dependent curved lines are to be drawn. The rendered line shall pass through all the specified points.";
            case CIRCLE: return "Two points shall be present; the first point is to be interpreted as the center and the second point as a point on the circumference of a circle, some form of implementation dependent representation of which is to be drawn.";
            case ELLIPSE: return "An ellipse defined by four (x,y) pairs, the first two pairs specifying the endpoints of the major axis and the second two pairs specifying the endpoints of the minor axis.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case POINT: return "POINT";
            case POLYLINE: return "POLYLINE";
            case INTERPOLATED: return "INTERPOLATED";
            case CIRCLE: return "CIRCLE";
            case ELLIPSE: return "ELLIPSE";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ImagingSelection2DGraphicTypeEnumFactory implements EnumFactory<ImagingSelection2DGraphicType> {
    public ImagingSelection2DGraphicType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("point".equals(codeString))
          return ImagingSelection2DGraphicType.POINT;
        if ("polyline".equals(codeString))
          return ImagingSelection2DGraphicType.POLYLINE;
        if ("interpolated".equals(codeString))
          return ImagingSelection2DGraphicType.INTERPOLATED;
        if ("circle".equals(codeString))
          return ImagingSelection2DGraphicType.CIRCLE;
        if ("ellipse".equals(codeString))
          return ImagingSelection2DGraphicType.ELLIPSE;
        throw new IllegalArgumentException("Unknown ImagingSelection2DGraphicType code '"+codeString+"'");
        }
        public Enumeration<ImagingSelection2DGraphicType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingSelection2DGraphicType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("point".equals(codeString))
          return new Enumeration<ImagingSelection2DGraphicType>(this, ImagingSelection2DGraphicType.POINT);
        if ("polyline".equals(codeString))
          return new Enumeration<ImagingSelection2DGraphicType>(this, ImagingSelection2DGraphicType.POLYLINE);
        if ("interpolated".equals(codeString))
          return new Enumeration<ImagingSelection2DGraphicType>(this, ImagingSelection2DGraphicType.INTERPOLATED);
        if ("circle".equals(codeString))
          return new Enumeration<ImagingSelection2DGraphicType>(this, ImagingSelection2DGraphicType.CIRCLE);
        if ("ellipse".equals(codeString))
          return new Enumeration<ImagingSelection2DGraphicType>(this, ImagingSelection2DGraphicType.ELLIPSE);
        throw new FHIRException("Unknown ImagingSelection2DGraphicType code '"+codeString+"'");
        }
    public String toCode(ImagingSelection2DGraphicType code) {
      if (code == ImagingSelection2DGraphicType.POINT)
        return "point";
      if (code == ImagingSelection2DGraphicType.POLYLINE)
        return "polyline";
      if (code == ImagingSelection2DGraphicType.INTERPOLATED)
        return "interpolated";
      if (code == ImagingSelection2DGraphicType.CIRCLE)
        return "circle";
      if (code == ImagingSelection2DGraphicType.ELLIPSE)
        return "ellipse";
      return "?";
      }
    public String toSystem(ImagingSelection2DGraphicType code) {
      return code.getSystem();
      }
    }

    public enum ImagingSelection3DGraphicType {
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
        public static ImagingSelection3DGraphicType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("point".equals(codeString))
          return POINT;
        if ("multipoint".equals(codeString))
          return MULTIPOINT;
        if ("polyline".equals(codeString))
          return POLYLINE;
        if ("polygon".equals(codeString))
          return POLYGON;
        if ("ellipse".equals(codeString))
          return ELLIPSE;
        if ("ellipsoid".equals(codeString))
          return ELLIPSOID;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImagingSelection3DGraphicType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case POINT: return "point";
            case MULTIPOINT: return "multipoint";
            case POLYLINE: return "polyline";
            case POLYGON: return "polygon";
            case ELLIPSE: return "ellipse";
            case ELLIPSOID: return "ellipsoid";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case POINT: return "http://hl7.org/fhir/imagingselection-3dgraphictype";
            case MULTIPOINT: return "http://hl7.org/fhir/imagingselection-3dgraphictype";
            case POLYLINE: return "http://hl7.org/fhir/imagingselection-3dgraphictype";
            case POLYGON: return "http://hl7.org/fhir/imagingselection-3dgraphictype";
            case ELLIPSE: return "http://hl7.org/fhir/imagingselection-3dgraphictype";
            case ELLIPSOID: return "http://hl7.org/fhir/imagingselection-3dgraphictype";
            case NULL: return null;
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
            case NULL: return null;
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
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ImagingSelection3DGraphicTypeEnumFactory implements EnumFactory<ImagingSelection3DGraphicType> {
    public ImagingSelection3DGraphicType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("point".equals(codeString))
          return ImagingSelection3DGraphicType.POINT;
        if ("multipoint".equals(codeString))
          return ImagingSelection3DGraphicType.MULTIPOINT;
        if ("polyline".equals(codeString))
          return ImagingSelection3DGraphicType.POLYLINE;
        if ("polygon".equals(codeString))
          return ImagingSelection3DGraphicType.POLYGON;
        if ("ellipse".equals(codeString))
          return ImagingSelection3DGraphicType.ELLIPSE;
        if ("ellipsoid".equals(codeString))
          return ImagingSelection3DGraphicType.ELLIPSOID;
        throw new IllegalArgumentException("Unknown ImagingSelection3DGraphicType code '"+codeString+"'");
        }
        public Enumeration<ImagingSelection3DGraphicType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingSelection3DGraphicType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("point".equals(codeString))
          return new Enumeration<ImagingSelection3DGraphicType>(this, ImagingSelection3DGraphicType.POINT);
        if ("multipoint".equals(codeString))
          return new Enumeration<ImagingSelection3DGraphicType>(this, ImagingSelection3DGraphicType.MULTIPOINT);
        if ("polyline".equals(codeString))
          return new Enumeration<ImagingSelection3DGraphicType>(this, ImagingSelection3DGraphicType.POLYLINE);
        if ("polygon".equals(codeString))
          return new Enumeration<ImagingSelection3DGraphicType>(this, ImagingSelection3DGraphicType.POLYGON);
        if ("ellipse".equals(codeString))
          return new Enumeration<ImagingSelection3DGraphicType>(this, ImagingSelection3DGraphicType.ELLIPSE);
        if ("ellipsoid".equals(codeString))
          return new Enumeration<ImagingSelection3DGraphicType>(this, ImagingSelection3DGraphicType.ELLIPSOID);
        throw new FHIRException("Unknown ImagingSelection3DGraphicType code '"+codeString+"'");
        }
    public String toCode(ImagingSelection3DGraphicType code) {
      if (code == ImagingSelection3DGraphicType.POINT)
        return "point";
      if (code == ImagingSelection3DGraphicType.MULTIPOINT)
        return "multipoint";
      if (code == ImagingSelection3DGraphicType.POLYLINE)
        return "polyline";
      if (code == ImagingSelection3DGraphicType.POLYGON)
        return "polygon";
      if (code == ImagingSelection3DGraphicType.ELLIPSE)
        return "ellipse";
      if (code == ImagingSelection3DGraphicType.ELLIPSOID)
        return "ellipsoid";
      return "?";
      }
    public String toSystem(ImagingSelection3DGraphicType code) {
      return code.getSystem();
      }
    }

    public enum ImagingSelectionStatus {
        /**
         * The selected resources are available..
         */
        AVAILABLE, 
        /**
         * The imaging selection has been withdrawn following a release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * The system does not know which of the status values currently applies for this request. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ImagingSelectionStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("available".equals(codeString))
          return AVAILABLE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImagingSelectionStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AVAILABLE: return "available";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AVAILABLE: return "http://hl7.org/fhir/imagingselection-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/imagingselection-status";
            case UNKNOWN: return "http://hl7.org/fhir/imagingselection-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AVAILABLE: return "The selected resources are available..";
            case ENTEREDINERROR: return "The imaging selection has been withdrawn following a release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The system does not know which of the status values currently applies for this request. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AVAILABLE: return "Available";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ImagingSelectionStatusEnumFactory implements EnumFactory<ImagingSelectionStatus> {
    public ImagingSelectionStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("available".equals(codeString))
          return ImagingSelectionStatus.AVAILABLE;
        if ("entered-in-error".equals(codeString))
          return ImagingSelectionStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return ImagingSelectionStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown ImagingSelectionStatus code '"+codeString+"'");
        }
        public Enumeration<ImagingSelectionStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingSelectionStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("available".equals(codeString))
          return new Enumeration<ImagingSelectionStatus>(this, ImagingSelectionStatus.AVAILABLE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ImagingSelectionStatus>(this, ImagingSelectionStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<ImagingSelectionStatus>(this, ImagingSelectionStatus.UNKNOWN);
        throw new FHIRException("Unknown ImagingSelectionStatus code '"+codeString+"'");
        }
    public String toCode(ImagingSelectionStatus code) {
      if (code == ImagingSelectionStatus.AVAILABLE)
        return "available";
      if (code == ImagingSelectionStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == ImagingSelectionStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(ImagingSelectionStatus code) {
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
        @Child(name = "uid", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="DICOM SOP Instance UID", formalDefinition="The SOP Instance UID for the selected DICOM instance." )
        protected IdType uid;

        /**
         * The Instance Number for the selected DICOM instance.
         */
        @Child(name = "number", type = {UnsignedIntType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="DICOM Instance Number", formalDefinition="The Instance Number for the selected DICOM instance." )
        protected UnsignedIntType number;

        /**
         * The SOP Class UID for the selected DICOM instance.
         */
        @Child(name = "sopClass", type = {Coding.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="DICOM SOP Class UID", formalDefinition="The SOP Class UID for the selected DICOM instance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part04/sect_B.5.html#table_B.5-1")
        protected Coding sopClass;

        /**
         * Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.
       May be one of:
       - A list of frame numbers selected from a multiframe SOP Instance.
       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.
       - A list of segment numbers selected from a segmentation SOP Instance.
       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.
         */
        @Child(name = "subset", type = {StringType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The selected subset of the SOP Instance", formalDefinition="Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.\n       May be one of:\n       - A list of frame numbers selected from a multiframe SOP Instance.\n       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.\n       - A list of segment numbers selected from a segmentation SOP Instance.\n       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance." )
        protected List<StringType> subset;

        /**
         * Each imaging selection instance or frame list might includes an image region, specified by a region type and a set of 2D coordinates.
       If the parent imagingSelection.instance contains a subset element of type frame, the image region applies to all frames in the subset list.
         */
        @Child(name = "imageRegion", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A specific 2D region in a DICOM image / frame", formalDefinition="Each imaging selection instance or frame list might includes an image region, specified by a region type and a set of 2D coordinates.\n       If the parent imagingSelection.instance contains a subset element of type frame, the image region applies to all frames in the subset list." )
        protected List<ImagingSelectionInstanceImageRegionComponent> imageRegion;

        private static final long serialVersionUID = -1933369423L;

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
        public IdType getUidElement() { 
          if (this.uid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.uid");
            else if (Configuration.doAutoCreate())
              this.uid = new IdType(); // bb
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
        public ImagingSelectionInstanceComponent setUidElement(IdType value) { 
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
              this.uid = new IdType();
            this.uid.setValue(value);
          return this;
        }

        /**
         * @return {@link #number} (The Instance Number for the selected DICOM instance.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public UnsignedIntType getNumberElement() { 
          if (this.number == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceComponent.number");
            else if (Configuration.doAutoCreate())
              this.number = new UnsignedIntType(); // bb
          return this.number;
        }

        public boolean hasNumberElement() { 
          return this.number != null && !this.number.isEmpty();
        }

        public boolean hasNumber() { 
          return this.number != null && !this.number.isEmpty();
        }

        /**
         * @param value {@link #number} (The Instance Number for the selected DICOM instance.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public ImagingSelectionInstanceComponent setNumberElement(UnsignedIntType value) { 
          this.number = value;
          return this;
        }

        /**
         * @return The Instance Number for the selected DICOM instance.
         */
        public int getNumber() { 
          return this.number == null || this.number.isEmpty() ? 0 : this.number.getValue();
        }

        /**
         * @param value The Instance Number for the selected DICOM instance.
         */
        public ImagingSelectionInstanceComponent setNumber(int value) { 
            if (this.number == null)
              this.number = new UnsignedIntType();
            this.number.setValue(value);
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
         * @return {@link #subset} (Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.
       May be one of:
       - A list of frame numbers selected from a multiframe SOP Instance.
       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.
       - A list of segment numbers selected from a segmentation SOP Instance.
       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.)
         */
        public List<StringType> getSubset() { 
          if (this.subset == null)
            this.subset = new ArrayList<StringType>();
          return this.subset;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingSelectionInstanceComponent setSubset(List<StringType> theSubset) { 
          this.subset = theSubset;
          return this;
        }

        public boolean hasSubset() { 
          if (this.subset == null)
            return false;
          for (StringType item : this.subset)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #subset} (Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.
       May be one of:
       - A list of frame numbers selected from a multiframe SOP Instance.
       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.
       - A list of segment numbers selected from a segmentation SOP Instance.
       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.)
         */
        public StringType addSubsetElement() {//2 
          StringType t = new StringType();
          if (this.subset == null)
            this.subset = new ArrayList<StringType>();
          this.subset.add(t);
          return t;
        }

        /**
         * @param value {@link #subset} (Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.
       May be one of:
       - A list of frame numbers selected from a multiframe SOP Instance.
       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.
       - A list of segment numbers selected from a segmentation SOP Instance.
       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.)
         */
        public ImagingSelectionInstanceComponent addSubset(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.subset == null)
            this.subset = new ArrayList<StringType>();
          this.subset.add(t);
          return this;
        }

        /**
         * @param value {@link #subset} (Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.
       May be one of:
       - A list of frame numbers selected from a multiframe SOP Instance.
       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.
       - A list of segment numbers selected from a segmentation SOP Instance.
       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.)
         */
        public boolean hasSubset(String value) { 
          if (this.subset == null)
            return false;
          for (StringType v : this.subset)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #imageRegion} (Each imaging selection instance or frame list might includes an image region, specified by a region type and a set of 2D coordinates.
       If the parent imagingSelection.instance contains a subset element of type frame, the image region applies to all frames in the subset list.)
         */
        public List<ImagingSelectionInstanceImageRegionComponent> getImageRegion() { 
          if (this.imageRegion == null)
            this.imageRegion = new ArrayList<ImagingSelectionInstanceImageRegionComponent>();
          return this.imageRegion;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingSelectionInstanceComponent setImageRegion(List<ImagingSelectionInstanceImageRegionComponent> theImageRegion) { 
          this.imageRegion = theImageRegion;
          return this;
        }

        public boolean hasImageRegion() { 
          if (this.imageRegion == null)
            return false;
          for (ImagingSelectionInstanceImageRegionComponent item : this.imageRegion)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ImagingSelectionInstanceImageRegionComponent addImageRegion() { //3
          ImagingSelectionInstanceImageRegionComponent t = new ImagingSelectionInstanceImageRegionComponent();
          if (this.imageRegion == null)
            this.imageRegion = new ArrayList<ImagingSelectionInstanceImageRegionComponent>();
          this.imageRegion.add(t);
          return t;
        }

        public ImagingSelectionInstanceComponent addImageRegion(ImagingSelectionInstanceImageRegionComponent t) { //3
          if (t == null)
            return this;
          if (this.imageRegion == null)
            this.imageRegion = new ArrayList<ImagingSelectionInstanceImageRegionComponent>();
          this.imageRegion.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #imageRegion}, creating it if it does not already exist {3}
         */
        public ImagingSelectionInstanceImageRegionComponent getImageRegionFirstRep() { 
          if (getImageRegion().isEmpty()) {
            addImageRegion();
          }
          return getImageRegion().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("uid", "id", "The SOP Instance UID for the selected DICOM instance.", 0, 1, uid));
          children.add(new Property("number", "unsignedInt", "The Instance Number for the selected DICOM instance.", 0, 1, number));
          children.add(new Property("sopClass", "Coding", "The SOP Class UID for the selected DICOM instance.", 0, 1, sopClass));
          children.add(new Property("subset", "string", "Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.\n       May be one of:\n       - A list of frame numbers selected from a multiframe SOP Instance.\n       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.\n       - A list of segment numbers selected from a segmentation SOP Instance.\n       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.", 0, java.lang.Integer.MAX_VALUE, subset));
          children.add(new Property("imageRegion", "", "Each imaging selection instance or frame list might includes an image region, specified by a region type and a set of 2D coordinates.\n       If the parent imagingSelection.instance contains a subset element of type frame, the image region applies to all frames in the subset list.", 0, java.lang.Integer.MAX_VALUE, imageRegion));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 115792: /*uid*/  return new Property("uid", "id", "The SOP Instance UID for the selected DICOM instance.", 0, 1, uid);
          case -1034364087: /*number*/  return new Property("number", "unsignedInt", "The Instance Number for the selected DICOM instance.", 0, 1, number);
          case 1560041540: /*sopClass*/  return new Property("sopClass", "Coding", "The SOP Class UID for the selected DICOM instance.", 0, 1, sopClass);
          case -891529694: /*subset*/  return new Property("subset", "string", "Selected subset of the SOP Instance. The content and format of the subset item is determined by the SOP Class of the selected instance.\n       May be one of:\n       - A list of frame numbers selected from a multiframe SOP Instance.\n       - A list of Content Item Observation UID values selected from a DICOM SR or other structured document SOP Instance.\n       - A list of segment numbers selected from a segmentation SOP Instance.\n       - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP Instance.", 0, java.lang.Integer.MAX_VALUE, subset);
          case 2132544559: /*imageRegion*/  return new Property("imageRegion", "", "Each imaging selection instance or frame list might includes an image region, specified by a region type and a set of 2D coordinates.\n       If the parent imagingSelection.instance contains a subset element of type frame, the image region applies to all frames in the subset list.", 0, java.lang.Integer.MAX_VALUE, imageRegion);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // IdType
        case -1034364087: /*number*/ return this.number == null ? new Base[0] : new Base[] {this.number}; // UnsignedIntType
        case 1560041540: /*sopClass*/ return this.sopClass == null ? new Base[0] : new Base[] {this.sopClass}; // Coding
        case -891529694: /*subset*/ return this.subset == null ? new Base[0] : this.subset.toArray(new Base[this.subset.size()]); // StringType
        case 2132544559: /*imageRegion*/ return this.imageRegion == null ? new Base[0] : this.imageRegion.toArray(new Base[this.imageRegion.size()]); // ImagingSelectionInstanceImageRegionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = TypeConvertor.castToId(value); // IdType
          return value;
        case -1034364087: // number
          this.number = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 1560041540: // sopClass
          this.sopClass = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -891529694: // subset
          this.getSubset().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 2132544559: // imageRegion
          this.getImageRegion().add((ImagingSelectionInstanceImageRegionComponent) value); // ImagingSelectionInstanceImageRegionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("number")) {
          this.number = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("sopClass")) {
          this.sopClass = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("subset")) {
          this.getSubset().add(TypeConvertor.castToString(value));
        } else if (name.equals("imageRegion")) {
          this.getImageRegion().add((ImagingSelectionInstanceImageRegionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUidElement();
        case -1034364087:  return getNumberElement();
        case 1560041540:  return getSopClass();
        case -891529694:  return addSubsetElement();
        case 2132544559:  return addImageRegion(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"id"};
        case -1034364087: /*number*/ return new String[] {"unsignedInt"};
        case 1560041540: /*sopClass*/ return new String[] {"Coding"};
        case -891529694: /*subset*/ return new String[] {"string"};
        case 2132544559: /*imageRegion*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.uid");
        }
        else if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.number");
        }
        else if (name.equals("sopClass")) {
          this.sopClass = new Coding();
          return this.sopClass;
        }
        else if (name.equals("subset")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.subset");
        }
        else if (name.equals("imageRegion")) {
          return addImageRegion();
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
        dst.number = number == null ? null : number.copy();
        dst.sopClass = sopClass == null ? null : sopClass.copy();
        if (subset != null) {
          dst.subset = new ArrayList<StringType>();
          for (StringType i : subset)
            dst.subset.add(i.copy());
        };
        if (imageRegion != null) {
          dst.imageRegion = new ArrayList<ImagingSelectionInstanceImageRegionComponent>();
          for (ImagingSelectionInstanceImageRegionComponent i : imageRegion)
            dst.imageRegion.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionInstanceComponent))
          return false;
        ImagingSelectionInstanceComponent o = (ImagingSelectionInstanceComponent) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(number, o.number, true) && compareDeep(sopClass, o.sopClass, true)
           && compareDeep(subset, o.subset, true) && compareDeep(imageRegion, o.imageRegion, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionInstanceComponent))
          return false;
        ImagingSelectionInstanceComponent o = (ImagingSelectionInstanceComponent) other_;
        return compareValues(uid, o.uid, true) && compareValues(number, o.number, true) && compareValues(subset, o.subset, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, number, sopClass, subset
          , imageRegion);
      }

  public String fhirType() {
    return "ImagingSelection.instance";

  }

  }

    @Block()
    public static class ImagingSelectionInstanceImageRegionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Specifies the type of image region.
         */
        @Child(name = "regionType", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="point | polyline | interpolated | circle | ellipse", formalDefinition="Specifies the type of image region." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingselection-2dgraphictype")
        protected Enumeration<ImagingSelection2DGraphicType> regionType;

        /**
         * The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.
       The origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0, and the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The values must be within the range 0\0 to the number of columns\rows in the image / frames.
         */
        @Child(name = "coordinate", type = {DecimalType.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specifies the coordinates that define the image region", formalDefinition="The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.\n       The origin at the TLHC of the TLHC pixel is 0.0\\0.0, the BRHC of the TLHC pixel is 1.0\\1.0, and the BRHC of the BRHC pixel is the number of columns\\rows in the image / frames. The values must be within the range 0\\0 to the number of columns\\rows in the image / frames." )
        protected List<DecimalType> coordinate;

        private static final long serialVersionUID = 1518695052L;

    /**
     * Constructor
     */
      public ImagingSelectionInstanceImageRegionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingSelectionInstanceImageRegionComponent(ImagingSelection2DGraphicType regionType, BigDecimal coordinate) {
        super();
        this.setRegionType(regionType);
        this.addCoordinate(coordinate);
      }

        /**
         * @return {@link #regionType} (Specifies the type of image region.). This is the underlying object with id, value and extensions. The accessor "getRegionType" gives direct access to the value
         */
        public Enumeration<ImagingSelection2DGraphicType> getRegionTypeElement() { 
          if (this.regionType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingSelectionInstanceImageRegionComponent.regionType");
            else if (Configuration.doAutoCreate())
              this.regionType = new Enumeration<ImagingSelection2DGraphicType>(new ImagingSelection2DGraphicTypeEnumFactory()); // bb
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
        public ImagingSelectionInstanceImageRegionComponent setRegionTypeElement(Enumeration<ImagingSelection2DGraphicType> value) { 
          this.regionType = value;
          return this;
        }

        /**
         * @return Specifies the type of image region.
         */
        public ImagingSelection2DGraphicType getRegionType() { 
          return this.regionType == null ? null : this.regionType.getValue();
        }

        /**
         * @param value Specifies the type of image region.
         */
        public ImagingSelectionInstanceImageRegionComponent setRegionType(ImagingSelection2DGraphicType value) { 
            if (this.regionType == null)
              this.regionType = new Enumeration<ImagingSelection2DGraphicType>(new ImagingSelection2DGraphicTypeEnumFactory());
            this.regionType.setValue(value);
          return this;
        }

        /**
         * @return {@link #coordinate} (The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.
       The origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0, and the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The values must be within the range 0\0 to the number of columns\rows in the image / frames.)
         */
        public List<DecimalType> getCoordinate() { 
          if (this.coordinate == null)
            this.coordinate = new ArrayList<DecimalType>();
          return this.coordinate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingSelectionInstanceImageRegionComponent setCoordinate(List<DecimalType> theCoordinate) { 
          this.coordinate = theCoordinate;
          return this;
        }

        public boolean hasCoordinate() { 
          if (this.coordinate == null)
            return false;
          for (DecimalType item : this.coordinate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #coordinate} (The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.
       The origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0, and the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The values must be within the range 0\0 to the number of columns\rows in the image / frames.)
         */
        public DecimalType addCoordinateElement() {//2 
          DecimalType t = new DecimalType();
          if (this.coordinate == null)
            this.coordinate = new ArrayList<DecimalType>();
          this.coordinate.add(t);
          return t;
        }

        /**
         * @param value {@link #coordinate} (The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.
       The origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0, and the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The values must be within the range 0\0 to the number of columns\rows in the image / frames.)
         */
        public ImagingSelectionInstanceImageRegionComponent addCoordinate(BigDecimal value) { //1
          DecimalType t = new DecimalType();
          t.setValue(value);
          if (this.coordinate == null)
            this.coordinate = new ArrayList<DecimalType>();
          this.coordinate.add(t);
          return this;
        }

        /**
         * @param value {@link #coordinate} (The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.
       The origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0, and the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The values must be within the range 0\0 to the number of columns\rows in the image / frames.)
         */
        public boolean hasCoordinate(BigDecimal value) { 
          if (this.coordinate == null)
            return false;
          for (DecimalType v : this.coordinate)
            if (v.getValue().equals(value)) // decimal
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("regionType", "code", "Specifies the type of image region.", 0, 1, regionType));
          children.add(new Property("coordinate", "decimal", "The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.\n       The origin at the TLHC of the TLHC pixel is 0.0\\0.0, the BRHC of the TLHC pixel is 1.0\\1.0, and the BRHC of the BRHC pixel is the number of columns\\rows in the image / frames. The values must be within the range 0\\0 to the number of columns\\rows in the image / frames.", 0, java.lang.Integer.MAX_VALUE, coordinate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1990487986: /*regionType*/  return new Property("regionType", "code", "Specifies the type of image region.", 0, 1, regionType);
          case 198931832: /*coordinate*/  return new Property("coordinate", "decimal", "The coordinates describing the image region. Encoded as a set of (column, row) pairs that denote positions in the selected image / frames specified with sub-pixel resolution.\n       The origin at the TLHC of the TLHC pixel is 0.0\\0.0, the BRHC of the TLHC pixel is 1.0\\1.0, and the BRHC of the BRHC pixel is the number of columns\\rows in the image / frames. The values must be within the range 0\\0 to the number of columns\\rows in the image / frames.", 0, java.lang.Integer.MAX_VALUE, coordinate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1990487986: /*regionType*/ return this.regionType == null ? new Base[0] : new Base[] {this.regionType}; // Enumeration<ImagingSelection2DGraphicType>
        case 198931832: /*coordinate*/ return this.coordinate == null ? new Base[0] : this.coordinate.toArray(new Base[this.coordinate.size()]); // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1990487986: // regionType
          value = new ImagingSelection2DGraphicTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.regionType = (Enumeration) value; // Enumeration<ImagingSelection2DGraphicType>
          return value;
        case 198931832: // coordinate
          this.getCoordinate().add(TypeConvertor.castToDecimal(value)); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("regionType")) {
          value = new ImagingSelection2DGraphicTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.regionType = (Enumeration) value; // Enumeration<ImagingSelection2DGraphicType>
        } else if (name.equals("coordinate")) {
          this.getCoordinate().add(TypeConvertor.castToDecimal(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1990487986:  return getRegionTypeElement();
        case 198931832:  return addCoordinateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1990487986: /*regionType*/ return new String[] {"code"};
        case 198931832: /*coordinate*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("regionType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.imageRegion.regionType");
        }
        else if (name.equals("coordinate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.instance.imageRegion.coordinate");
        }
        else
          return super.addChild(name);
      }

      public ImagingSelectionInstanceImageRegionComponent copy() {
        ImagingSelectionInstanceImageRegionComponent dst = new ImagingSelectionInstanceImageRegionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImagingSelectionInstanceImageRegionComponent dst) {
        super.copyValues(dst);
        dst.regionType = regionType == null ? null : regionType.copy();
        if (coordinate != null) {
          dst.coordinate = new ArrayList<DecimalType>();
          for (DecimalType i : coordinate)
            dst.coordinate.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionInstanceImageRegionComponent))
          return false;
        ImagingSelectionInstanceImageRegionComponent o = (ImagingSelectionInstanceImageRegionComponent) other_;
        return compareDeep(regionType, o.regionType, true) && compareDeep(coordinate, o.coordinate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelectionInstanceImageRegionComponent))
          return false;
        ImagingSelectionInstanceImageRegionComponent o = (ImagingSelectionInstanceImageRegionComponent) other_;
        return compareValues(regionType, o.regionType, true) && compareValues(coordinate, o.coordinate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(regionType, coordinate);
      }

  public String fhirType() {
    return "ImagingSelection.instance.imageRegion";

  }

  }

    @Block()
    public static class ImageRegionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Specifies the type of image region.
         */
        @Child(name = "regionType", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="point | multipoint | polyline | polygon | ellipse | ellipsoid", formalDefinition="Specifies the type of image region." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingselection-3dgraphictype")
        protected Enumeration<ImagingSelection3DGraphicType> regionType;

        /**
         * The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.
         */
        @Child(name = "coordinate", type = {DecimalType.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specifies the coordinates that define the image region", formalDefinition="The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element." )
        protected List<DecimalType> coordinate;

        private static final long serialVersionUID = 1532227853L;

    /**
     * Constructor
     */
      public ImageRegionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImageRegionComponent(ImagingSelection3DGraphicType regionType, BigDecimal coordinate) {
        super();
        this.setRegionType(regionType);
        this.addCoordinate(coordinate);
      }

        /**
         * @return {@link #regionType} (Specifies the type of image region.). This is the underlying object with id, value and extensions. The accessor "getRegionType" gives direct access to the value
         */
        public Enumeration<ImagingSelection3DGraphicType> getRegionTypeElement() { 
          if (this.regionType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImageRegionComponent.regionType");
            else if (Configuration.doAutoCreate())
              this.regionType = new Enumeration<ImagingSelection3DGraphicType>(new ImagingSelection3DGraphicTypeEnumFactory()); // bb
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
        public ImageRegionComponent setRegionTypeElement(Enumeration<ImagingSelection3DGraphicType> value) { 
          this.regionType = value;
          return this;
        }

        /**
         * @return Specifies the type of image region.
         */
        public ImagingSelection3DGraphicType getRegionType() { 
          return this.regionType == null ? null : this.regionType.getValue();
        }

        /**
         * @param value Specifies the type of image region.
         */
        public ImageRegionComponent setRegionType(ImagingSelection3DGraphicType value) { 
            if (this.regionType == null)
              this.regionType = new Enumeration<ImagingSelection3DGraphicType>(new ImagingSelection3DGraphicTypeEnumFactory());
            this.regionType.setValue(value);
          return this;
        }

        /**
         * @return {@link #coordinate} (The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.)
         */
        public List<DecimalType> getCoordinate() { 
          if (this.coordinate == null)
            this.coordinate = new ArrayList<DecimalType>();
          return this.coordinate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImageRegionComponent setCoordinate(List<DecimalType> theCoordinate) { 
          this.coordinate = theCoordinate;
          return this;
        }

        public boolean hasCoordinate() { 
          if (this.coordinate == null)
            return false;
          for (DecimalType item : this.coordinate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #coordinate} (The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.)
         */
        public DecimalType addCoordinateElement() {//2 
          DecimalType t = new DecimalType();
          if (this.coordinate == null)
            this.coordinate = new ArrayList<DecimalType>();
          this.coordinate.add(t);
          return t;
        }

        /**
         * @param value {@link #coordinate} (The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.)
         */
        public ImageRegionComponent addCoordinate(BigDecimal value) { //1
          DecimalType t = new DecimalType();
          t.setValue(value);
          if (this.coordinate == null)
            this.coordinate = new ArrayList<DecimalType>();
          this.coordinate.add(t);
          return this;
        }

        /**
         * @param value {@link #coordinate} (The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.)
         */
        public boolean hasCoordinate(BigDecimal value) { 
          if (this.coordinate == null)
            return false;
          for (DecimalType v : this.coordinate)
            if (v.getValue().equals(value)) // decimal
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("regionType", "code", "Specifies the type of image region.", 0, 1, regionType));
          children.add(new Property("coordinate", "decimal", "The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.", 0, java.lang.Integer.MAX_VALUE, coordinate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1990487986: /*regionType*/  return new Property("regionType", "code", "Specifies the type of image region.", 0, 1, regionType);
          case 198931832: /*coordinate*/  return new Property("coordinate", "decimal", "The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets (in mm and may be negative) that define a region of interest in the patient-relative Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.", 0, java.lang.Integer.MAX_VALUE, coordinate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1990487986: /*regionType*/ return this.regionType == null ? new Base[0] : new Base[] {this.regionType}; // Enumeration<ImagingSelection3DGraphicType>
        case 198931832: /*coordinate*/ return this.coordinate == null ? new Base[0] : this.coordinate.toArray(new Base[this.coordinate.size()]); // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1990487986: // regionType
          value = new ImagingSelection3DGraphicTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.regionType = (Enumeration) value; // Enumeration<ImagingSelection3DGraphicType>
          return value;
        case 198931832: // coordinate
          this.getCoordinate().add(TypeConvertor.castToDecimal(value)); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("regionType")) {
          value = new ImagingSelection3DGraphicTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.regionType = (Enumeration) value; // Enumeration<ImagingSelection3DGraphicType>
        } else if (name.equals("coordinate")) {
          this.getCoordinate().add(TypeConvertor.castToDecimal(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1990487986:  return getRegionTypeElement();
        case 198931832:  return addCoordinateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1990487986: /*regionType*/ return new String[] {"code"};
        case 198931832: /*coordinate*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("regionType")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.imageRegion.regionType");
        }
        else if (name.equals("coordinate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.imageRegion.coordinate");
        }
        else
          return super.addChild(name);
      }

      public ImageRegionComponent copy() {
        ImageRegionComponent dst = new ImageRegionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImageRegionComponent dst) {
        super.copyValues(dst);
        dst.regionType = regionType == null ? null : regionType.copy();
        if (coordinate != null) {
          dst.coordinate = new ArrayList<DecimalType>();
          for (DecimalType i : coordinate)
            dst.coordinate.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImageRegionComponent))
          return false;
        ImageRegionComponent o = (ImageRegionComponent) other_;
        return compareDeep(regionType, o.regionType, true) && compareDeep(coordinate, o.coordinate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImageRegionComponent))
          return false;
        ImageRegionComponent o = (ImageRegionComponent) other_;
        return compareValues(regionType, o.regionType, true) && compareValues(coordinate, o.coordinate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(regionType, coordinate);
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
     * The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="available | entered-in-error | unknown", formalDefinition="The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingselection-status")
    protected Enumeration<ImagingSelectionStatus> status;

    /**
     * The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, Specimen.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Subject of the selected instances", formalDefinition="The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed." )
    protected Reference subject;

    /**
     * The date and time this imaging selection was created.
     */
    @Child(name = "issued", type = {InstantType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date / Time when this imaging selection was created", formalDefinition="The date and time this imaging selection was created." )
    protected InstantType issued;

    /**
     * Selector of the instances – human or machine.
     */
    @Child(name = "performer", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Selector of the instances (human or machine)", formalDefinition="Selector of the instances – human or machine." )
    protected List<ImagingSelectionPerformerComponent> performer;

    /**
     * A list of the diagnostic requests that resulted in this imaging selection being performed.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ServiceRequest.class, Appointment.class, AppointmentResponse.class, Task.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Associated request", formalDefinition="A list of the diagnostic requests that resulted in this imaging selection being performed." )
    protected List<Reference> basedOn;

    /**
     * Classifies the imaging selection.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classifies the imaging selection", formalDefinition="Classifies the imaging selection." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_7010.html")
    protected List<CodeableConcept> category;

    /**
     * Reason for referencing the selected content.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Imaging Selection purpose text or code", formalDefinition="Reason for referencing the selected content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_7010.html")
    protected CodeableConcept code;

    /**
     * The Study Instance UID for the DICOM Study from which the images were selected.
     */
    @Child(name = "studyUid", type = {IdType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="DICOM Study Instance UID", formalDefinition="The Study Instance UID for the DICOM Study from which the images were selected." )
    protected IdType studyUid;

    /**
     * The imaging study from which the imaging selection is made.
     */
    @Child(name = "derivedFrom", type = {ImagingStudy.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The imaging study from which the imaging selection is derived", formalDefinition="The imaging study from which the imaging selection is made." )
    protected List<Reference> derivedFrom;

    /**
     * The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The network service providing retrieval for the images referenced in the imaging selection", formalDefinition="The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints." )
    protected List<Reference> endpoint;

    /**
     * The Series Instance UID for the DICOM Series from which the images were selected.
     */
    @Child(name = "seriesUid", type = {IdType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="DICOM Series Instance UID", formalDefinition="The Series Instance UID for the DICOM Series from which the images were selected." )
    protected IdType seriesUid;

    /**
     * The Series Number for the DICOM Series from which the images were selected.
     */
    @Child(name = "seriesNumber", type = {UnsignedIntType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="DICOM Series Number", formalDefinition="The Series Number for the DICOM Series from which the images were selected." )
    protected UnsignedIntType seriesNumber;

    /**
     * The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.
     */
    @Child(name = "frameOfReferenceUid", type = {IdType.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Frame of Reference UID for the selected images", formalDefinition="The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames." )
    protected IdType frameOfReferenceUid;

    /**
     * The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.
     */
    @Child(name = "bodySite", type = {CodeableReference.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Body part examined", formalDefinition="The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected CodeableReference bodySite;

    /**
     * The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.
     */
    @Child(name = "focus", type = {ImagingSelection.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Related resource that is the focus for the imaging selection", formalDefinition="The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus." )
    protected List<Reference> focus;

    /**
     * Each imaging selection includes one or more selected DICOM SOP instances.
     */
    @Child(name = "instance", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The selected instances", formalDefinition="Each imaging selection includes one or more selected DICOM SOP instances." )
    protected List<ImagingSelectionInstanceComponent> instance;

    /**
     * Each imaging selection might includes a 3D image region, specified by a region type and a set of 3D coordinates.
     */
    @Child(name = "imageRegion", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A specific 3D region in a DICOM frame of reference", formalDefinition="Each imaging selection might includes a 3D image region, specified by a region type and a set of 3D coordinates." )
    protected List<ImageRegionComponent> imageRegion;

    private static final long serialVersionUID = -347117045L;

  /**
   * Constructor
   */
    public ImagingSelection() {
      super();
    }

  /**
   * Constructor
   */
    public ImagingSelection(ImagingSelectionStatus status, CodeableConcept code) {
      super();
      this.setStatus(status);
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
     * @return {@link #status} (The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ImagingSelectionStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ImagingSelectionStatus>(new ImagingSelectionStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ImagingSelection setStatusElement(Enumeration<ImagingSelectionStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.
     */
    public ImagingSelectionStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.
     */
    public ImagingSelection setStatus(ImagingSelectionStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<ImagingSelectionStatus>(new ImagingSelectionStatusEnumFactory());
        this.status.setValue(value);
      return this;
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
     * @return {@link #performer} (Selector of the instances – human or machine.)
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
     * @return {@link #category} (Classifies the imaging selection.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public ImagingSelection addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #code} (Reason for referencing the selected content.)
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
     * @param value {@link #code} (Reason for referencing the selected content.)
     */
    public ImagingSelection setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #studyUid} (The Study Instance UID for the DICOM Study from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getStudyUid" gives direct access to the value
     */
    public IdType getStudyUidElement() { 
      if (this.studyUid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.studyUid");
        else if (Configuration.doAutoCreate())
          this.studyUid = new IdType(); // bb
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
    public ImagingSelection setStudyUidElement(IdType value) { 
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
          this.studyUid = new IdType();
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
    public IdType getSeriesUidElement() { 
      if (this.seriesUid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.seriesUid");
        else if (Configuration.doAutoCreate())
          this.seriesUid = new IdType(); // bb
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
    public ImagingSelection setSeriesUidElement(IdType value) { 
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
          this.seriesUid = new IdType();
        this.seriesUid.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #seriesNumber} (The Series Number for the DICOM Series from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getSeriesNumber" gives direct access to the value
     */
    public UnsignedIntType getSeriesNumberElement() { 
      if (this.seriesNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.seriesNumber");
        else if (Configuration.doAutoCreate())
          this.seriesNumber = new UnsignedIntType(); // bb
      return this.seriesNumber;
    }

    public boolean hasSeriesNumberElement() { 
      return this.seriesNumber != null && !this.seriesNumber.isEmpty();
    }

    public boolean hasSeriesNumber() { 
      return this.seriesNumber != null && !this.seriesNumber.isEmpty();
    }

    /**
     * @param value {@link #seriesNumber} (The Series Number for the DICOM Series from which the images were selected.). This is the underlying object with id, value and extensions. The accessor "getSeriesNumber" gives direct access to the value
     */
    public ImagingSelection setSeriesNumberElement(UnsignedIntType value) { 
      this.seriesNumber = value;
      return this;
    }

    /**
     * @return The Series Number for the DICOM Series from which the images were selected.
     */
    public int getSeriesNumber() { 
      return this.seriesNumber == null || this.seriesNumber.isEmpty() ? 0 : this.seriesNumber.getValue();
    }

    /**
     * @param value The Series Number for the DICOM Series from which the images were selected.
     */
    public ImagingSelection setSeriesNumber(int value) { 
        if (this.seriesNumber == null)
          this.seriesNumber = new UnsignedIntType();
        this.seriesNumber.setValue(value);
      return this;
    }

    /**
     * @return {@link #frameOfReferenceUid} (The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.). This is the underlying object with id, value and extensions. The accessor "getFrameOfReferenceUid" gives direct access to the value
     */
    public IdType getFrameOfReferenceUidElement() { 
      if (this.frameOfReferenceUid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.frameOfReferenceUid");
        else if (Configuration.doAutoCreate())
          this.frameOfReferenceUid = new IdType(); // bb
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
    public ImagingSelection setFrameOfReferenceUidElement(IdType value) { 
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
          this.frameOfReferenceUid = new IdType();
        this.frameOfReferenceUid.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.)
     */
    public CodeableReference getBodySite() { 
      if (this.bodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingSelection.bodySite");
        else if (Configuration.doAutoCreate())
          this.bodySite = new CodeableReference(); // cc
      return this.bodySite;
    }

    public boolean hasBodySite() { 
      return this.bodySite != null && !this.bodySite.isEmpty();
    }

    /**
     * @param value {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.)
     */
    public ImagingSelection setBodySite(CodeableReference value) { 
      this.bodySite = value;
      return this;
    }

    /**
     * @return {@link #focus} (The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.)
     */
    public List<Reference> getFocus() { 
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      return this.focus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setFocus(List<Reference> theFocus) { 
      this.focus = theFocus;
      return this;
    }

    public boolean hasFocus() { 
      if (this.focus == null)
        return false;
      for (Reference item : this.focus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addFocus() { //3
      Reference t = new Reference();
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      this.focus.add(t);
      return t;
    }

    public ImagingSelection addFocus(Reference t) { //3
      if (t == null)
        return this;
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      this.focus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #focus}, creating it if it does not already exist {3}
     */
    public Reference getFocusFirstRep() { 
      if (getFocus().isEmpty()) {
        addFocus();
      }
      return getFocus().get(0);
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
     * @return {@link #imageRegion} (Each imaging selection might includes a 3D image region, specified by a region type and a set of 3D coordinates.)
     */
    public List<ImageRegionComponent> getImageRegion() { 
      if (this.imageRegion == null)
        this.imageRegion = new ArrayList<ImageRegionComponent>();
      return this.imageRegion;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingSelection setImageRegion(List<ImageRegionComponent> theImageRegion) { 
      this.imageRegion = theImageRegion;
      return this;
    }

    public boolean hasImageRegion() { 
      if (this.imageRegion == null)
        return false;
      for (ImageRegionComponent item : this.imageRegion)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ImageRegionComponent addImageRegion() { //3
      ImageRegionComponent t = new ImageRegionComponent();
      if (this.imageRegion == null)
        this.imageRegion = new ArrayList<ImageRegionComponent>();
      this.imageRegion.add(t);
      return t;
    }

    public ImagingSelection addImageRegion(ImageRegionComponent t) { //3
      if (t == null)
        return this;
      if (this.imageRegion == null)
        this.imageRegion = new ArrayList<ImageRegionComponent>();
      this.imageRegion.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #imageRegion}, creating it if it does not already exist {3}
     */
    public ImageRegionComponent getImageRegionFirstRep() { 
      if (getImageRegion().isEmpty()) {
        addImageRegion();
      }
      return getImageRegion().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this imaging selection.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.", 0, 1, status));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|Specimen)", "The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.", 0, 1, subject));
        children.add(new Property("issued", "instant", "The date and time this imaging selection was created.", 0, 1, issued));
        children.add(new Property("performer", "", "Selector of the instances – human or machine.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging selection being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("category", "CodeableConcept", "Classifies the imaging selection.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "Reason for referencing the selected content.", 0, 1, code));
        children.add(new Property("studyUid", "id", "The Study Instance UID for the DICOM Study from which the images were selected.", 0, 1, studyUid));
        children.add(new Property("derivedFrom", "Reference(ImagingStudy)", "The imaging study from which the imaging selection is made.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("endpoint", "Reference(Endpoint)", "The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.", 0, java.lang.Integer.MAX_VALUE, endpoint));
        children.add(new Property("seriesUid", "id", "The Series Instance UID for the DICOM Series from which the images were selected.", 0, 1, seriesUid));
        children.add(new Property("seriesNumber", "unsignedInt", "The Series Number for the DICOM Series from which the images were selected.", 0, 1, seriesNumber));
        children.add(new Property("frameOfReferenceUid", "id", "The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.", 0, 1, frameOfReferenceUid));
        children.add(new Property("bodySite", "CodeableReference(BodyStructure)", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.", 0, 1, bodySite));
        children.add(new Property("focus", "Reference(ImagingSelection)", "The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.", 0, java.lang.Integer.MAX_VALUE, focus));
        children.add(new Property("instance", "", "Each imaging selection includes one or more selected DICOM SOP instances.", 0, java.lang.Integer.MAX_VALUE, instance));
        children.add(new Property("imageRegion", "", "Each imaging selection might includes a 3D image region, specified by a region type and a set of 3D coordinates.", 0, java.lang.Integer.MAX_VALUE, imageRegion));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this imaging selection.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the ImagingSelection resource. This is not the status of any ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.", 0, 1, status);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|Specimen)", "The patient, or group of patients, location, device, organization, procedure or practitioner this imaging selection is about and into whose or what record the imaging selection is placed.", 0, 1, subject);
        case -1179159893: /*issued*/  return new Property("issued", "instant", "The date and time this imaging selection was created.", 0, 1, issued);
        case 481140686: /*performer*/  return new Property("performer", "", "Selector of the instances – human or machine.", 0, java.lang.Integer.MAX_VALUE, performer);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging selection being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Classifies the imaging selection.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Reason for referencing the selected content.", 0, 1, code);
        case 1876590023: /*studyUid*/  return new Property("studyUid", "id", "The Study Instance UID for the DICOM Study from which the images were selected.", 0, 1, studyUid);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(ImagingStudy)", "The imaging study from which the imaging selection is made.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "The network service providing retrieval access to the selected images, frames, etc. See implementation notes for information about using DICOM endpoints.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        case -569596327: /*seriesUid*/  return new Property("seriesUid", "id", "The Series Instance UID for the DICOM Series from which the images were selected.", 0, 1, seriesUid);
        case 382652576: /*seriesNumber*/  return new Property("seriesNumber", "unsignedInt", "The Series Number for the DICOM Series from which the images were selected.", 0, 1, seriesNumber);
        case 828378953: /*frameOfReferenceUid*/  return new Property("frameOfReferenceUid", "id", "The Frame of Reference UID identifying the coordinate system that conveys spatial and/or temporal information for the selected images or frames.", 0, 1, frameOfReferenceUid);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableReference(BodyStructure)", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings.", 0, 1, bodySite);
        case 97604824: /*focus*/  return new Property("focus", "Reference(ImagingSelection)", "The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.", 0, java.lang.Integer.MAX_VALUE, focus);
        case 555127957: /*instance*/  return new Property("instance", "", "Each imaging selection includes one or more selected DICOM SOP instances.", 0, java.lang.Integer.MAX_VALUE, instance);
        case 2132544559: /*imageRegion*/  return new Property("imageRegion", "", "Each imaging selection might includes a 3D image region, specified by a region type and a set of 3D coordinates.", 0, java.lang.Integer.MAX_VALUE, imageRegion);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ImagingSelectionStatus>
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -1179159893: /*issued*/ return this.issued == null ? new Base[0] : new Base[] {this.issued}; // InstantType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // ImagingSelectionPerformerComponent
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 1876590023: /*studyUid*/ return this.studyUid == null ? new Base[0] : new Base[] {this.studyUid}; // IdType
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case -569596327: /*seriesUid*/ return this.seriesUid == null ? new Base[0] : new Base[] {this.seriesUid}; // IdType
        case 382652576: /*seriesNumber*/ return this.seriesNumber == null ? new Base[0] : new Base[] {this.seriesNumber}; // UnsignedIntType
        case 828378953: /*frameOfReferenceUid*/ return this.frameOfReferenceUid == null ? new Base[0] : new Base[] {this.frameOfReferenceUid}; // IdType
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableReference
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : this.focus.toArray(new Base[this.focus.size()]); // Reference
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : this.instance.toArray(new Base[this.instance.size()]); // ImagingSelectionInstanceComponent
        case 2132544559: /*imageRegion*/ return this.imageRegion == null ? new Base[0] : this.imageRegion.toArray(new Base[this.imageRegion.size()]); // ImageRegionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new ImagingSelectionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImagingSelectionStatus>
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
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1876590023: // studyUid
          this.studyUid = TypeConvertor.castToId(value); // IdType
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -569596327: // seriesUid
          this.seriesUid = TypeConvertor.castToId(value); // IdType
          return value;
        case 382652576: // seriesNumber
          this.seriesNumber = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 828378953: // frameOfReferenceUid
          this.frameOfReferenceUid = TypeConvertor.castToId(value); // IdType
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 97604824: // focus
          this.getFocus().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 555127957: // instance
          this.getInstance().add((ImagingSelectionInstanceComponent) value); // ImagingSelectionInstanceComponent
          return value;
        case 2132544559: // imageRegion
          this.getImageRegion().add((ImageRegionComponent) value); // ImageRegionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new ImagingSelectionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImagingSelectionStatus>
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("issued")) {
          this.issued = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("performer")) {
          this.getPerformer().add((ImagingSelectionPerformerComponent) value);
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("studyUid")) {
          this.studyUid = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else if (name.equals("seriesUid")) {
          this.seriesUid = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("seriesNumber")) {
          this.seriesNumber = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("frameOfReferenceUid")) {
          this.frameOfReferenceUid = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("focus")) {
          this.getFocus().add(TypeConvertor.castToReference(value));
        } else if (name.equals("instance")) {
          this.getInstance().add((ImagingSelectionInstanceComponent) value);
        } else if (name.equals("imageRegion")) {
          this.getImageRegion().add((ImageRegionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -1867885268:  return getSubject();
        case -1179159893:  return getIssuedElement();
        case 481140686:  return addPerformer(); 
        case -332612366:  return addBasedOn(); 
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case 1876590023:  return getStudyUidElement();
        case 1077922663:  return addDerivedFrom(); 
        case 1741102485:  return addEndpoint(); 
        case -569596327:  return getSeriesUidElement();
        case 382652576:  return getSeriesNumberElement();
        case 828378953:  return getFrameOfReferenceUidElement();
        case 1702620169:  return getBodySite();
        case 97604824:  return addFocus(); 
        case 555127957:  return addInstance(); 
        case 2132544559:  return addImageRegion(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -1179159893: /*issued*/ return new String[] {"instant"};
        case 481140686: /*performer*/ return new String[] {};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1876590023: /*studyUid*/ return new String[] {"id"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case -569596327: /*seriesUid*/ return new String[] {"id"};
        case 382652576: /*seriesNumber*/ return new String[] {"unsignedInt"};
        case 828378953: /*frameOfReferenceUid*/ return new String[] {"id"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableReference"};
        case 97604824: /*focus*/ return new String[] {"Reference"};
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
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.status");
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
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("category")) {
          return addCategory();
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
        else if (name.equals("seriesNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.seriesNumber");
        }
        else if (name.equals("frameOfReferenceUid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingSelection.frameOfReferenceUid");
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableReference();
          return this.bodySite;
        }
        else if (name.equals("focus")) {
          return addFocus();
        }
        else if (name.equals("instance")) {
          return addInstance();
        }
        else if (name.equals("imageRegion")) {
          return addImageRegion();
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
        dst.status = status == null ? null : status.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.issued = issued == null ? null : issued.copy();
        if (performer != null) {
          dst.performer = new ArrayList<ImagingSelectionPerformerComponent>();
          for (ImagingSelectionPerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
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
        dst.seriesNumber = seriesNumber == null ? null : seriesNumber.copy();
        dst.frameOfReferenceUid = frameOfReferenceUid == null ? null : frameOfReferenceUid.copy();
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        if (focus != null) {
          dst.focus = new ArrayList<Reference>();
          for (Reference i : focus)
            dst.focus.add(i.copy());
        };
        if (instance != null) {
          dst.instance = new ArrayList<ImagingSelectionInstanceComponent>();
          for (ImagingSelectionInstanceComponent i : instance)
            dst.instance.add(i.copy());
        };
        if (imageRegion != null) {
          dst.imageRegion = new ArrayList<ImageRegionComponent>();
          for (ImageRegionComponent i : imageRegion)
            dst.imageRegion.add(i.copy());
        };
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(subject, o.subject, true)
           && compareDeep(issued, o.issued, true) && compareDeep(performer, o.performer, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(studyUid, o.studyUid, true)
           && compareDeep(derivedFrom, o.derivedFrom, true) && compareDeep(endpoint, o.endpoint, true) && compareDeep(seriesUid, o.seriesUid, true)
           && compareDeep(seriesNumber, o.seriesNumber, true) && compareDeep(frameOfReferenceUid, o.frameOfReferenceUid, true)
           && compareDeep(bodySite, o.bodySite, true) && compareDeep(focus, o.focus, true) && compareDeep(instance, o.instance, true)
           && compareDeep(imageRegion, o.imageRegion, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingSelection))
          return false;
        ImagingSelection o = (ImagingSelection) other_;
        return compareValues(status, o.status, true) && compareValues(issued, o.issued, true) && compareValues(studyUid, o.studyUid, true)
           && compareValues(seriesUid, o.seriesUid, true) && compareValues(seriesNumber, o.seriesNumber, true)
           && compareValues(frameOfReferenceUid, o.frameOfReferenceUid, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, subject
          , issued, performer, basedOn, category, code, studyUid, derivedFrom, endpoint
          , seriesUid, seriesNumber, frameOfReferenceUid, bodySite, focus, instance, imageRegion
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImagingSelection;
   }

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>The request associated with an imaging selection</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="ImagingSelection.basedOn", description="The request associated with an imaging selection", type="reference", target={Appointment.class, AppointmentResponse.class, CarePlan.class, ServiceRequest.class, Task.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>The request associated with an imaging selection</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingSelection:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("ImagingSelection:based-on").toLocked();

 /**
   * Search parameter: <b>body-site</b>
   * <p>
   * Description: <b>The body site associated with the imaging selection</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.bodySite.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="body-site", path="ImagingSelection.bodySite.concept", description="The body site associated with the imaging selection", type="token" )
  public static final String SP_BODY_SITE = "body-site";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>body-site</b>
   * <p>
   * Description: <b>The body site associated with the imaging selection</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.bodySite.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BODY_SITE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BODY_SITE);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The imaging selection status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="ImagingSelection.status", description="The imaging selection status", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The imaging selection status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>derived-from</b>
   * <p>
   * Description: <b>The imaging study from which the imaging selection was derived</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.derivedFrom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="derived-from", path="ImagingSelection.derivedFrom", description="The imaging study from which the imaging selection was derived", type="reference", target={ImagingStudy.class } )
  public static final String SP_DERIVED_FROM = "derived-from";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-from</b>
   * <p>
   * Description: <b>The imaging study from which the imaging selection was derived</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.derivedFrom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DERIVED_FROM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DERIVED_FROM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingSelection:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include("ImagingSelection:derived-from").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Identifiers for the imaging selection</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ImagingSelection.identifier", description="Identifiers for the imaging selection", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Identifiers for the imaging selection</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>issued</b>
   * <p>
   * Description: <b>The date / time the imaging selection was created</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ImagingSelection.issued</b><br>
   * </p>
   */
  @SearchParamDefinition(name="issued", path="ImagingSelection.issued", description="The date / time the imaging selection was created", type="date" )
  public static final String SP_ISSUED = "issued";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>issued</b>
   * <p>
   * Description: <b>The date / time the imaging selection was created</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ImagingSelection.issued</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam ISSUED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_ISSUED);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="ImagingSelection.subject.where(resolve() is Patient)", description="Who the study is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingSelection:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ImagingSelection:patient").toLocked();

 /**
   * Search parameter: <b>study-uid</b>
   * <p>
   * Description: <b>The DICOM Study Instance UID from which the images were selected</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.studyUid</b><br>
   * </p>
   */
  @SearchParamDefinition(name="study-uid", path="ImagingSelection.studyUid", description="The DICOM Study Instance UID from which the images were selected", type="token" )
  public static final String SP_STUDY_UID = "study-uid";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>study-uid</b>
   * <p>
   * Description: <b>The DICOM Study Instance UID from which the images were selected</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingSelection.studyUid</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STUDY_UID = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STUDY_UID);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject of the Imaging Selection, such as the associated Patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ImagingSelection.subject", description="The subject of the Imaging Selection, such as the associated Patient", type="reference", target={Device.class, Group.class, Location.class, Medication.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Specimen.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject of the Imaging Selection, such as the associated Patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingSelection.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingSelection:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ImagingSelection:subject").toLocked();


}

