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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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
 * An authorization for the provision of glasses and/or contact lenses to a patient.
 */
@ResourceDef(name="VisionPrescription", profile="http://hl7.org/fhir/StructureDefinition/VisionPrescription")
public class VisionPrescription extends DomainResource {

    public enum VisionBase {
        /**
         * top.
         */
        UP, 
        /**
         * bottom.
         */
        DOWN, 
        /**
         * inner edge.
         */
        IN, 
        /**
         * outer edge.
         */
        OUT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static VisionBase fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("up".equals(codeString))
          return UP;
        if ("down".equals(codeString))
          return DOWN;
        if ("in".equals(codeString))
          return IN;
        if ("out".equals(codeString))
          return OUT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown VisionBase code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case UP: return "up";
            case DOWN: return "down";
            case IN: return "in";
            case OUT: return "out";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case UP: return "http://hl7.org/fhir/vision-base-codes";
            case DOWN: return "http://hl7.org/fhir/vision-base-codes";
            case IN: return "http://hl7.org/fhir/vision-base-codes";
            case OUT: return "http://hl7.org/fhir/vision-base-codes";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case UP: return "top.";
            case DOWN: return "bottom.";
            case IN: return "inner edge.";
            case OUT: return "outer edge.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case UP: return "Up";
            case DOWN: return "Down";
            case IN: return "In";
            case OUT: return "Out";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class VisionBaseEnumFactory implements EnumFactory<VisionBase> {
    public VisionBase fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("up".equals(codeString))
          return VisionBase.UP;
        if ("down".equals(codeString))
          return VisionBase.DOWN;
        if ("in".equals(codeString))
          return VisionBase.IN;
        if ("out".equals(codeString))
          return VisionBase.OUT;
        throw new IllegalArgumentException("Unknown VisionBase code '"+codeString+"'");
        }
        public Enumeration<VisionBase> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<VisionBase>(this, VisionBase.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<VisionBase>(this, VisionBase.NULL, code);
        if ("up".equals(codeString))
          return new Enumeration<VisionBase>(this, VisionBase.UP, code);
        if ("down".equals(codeString))
          return new Enumeration<VisionBase>(this, VisionBase.DOWN, code);
        if ("in".equals(codeString))
          return new Enumeration<VisionBase>(this, VisionBase.IN, code);
        if ("out".equals(codeString))
          return new Enumeration<VisionBase>(this, VisionBase.OUT, code);
        throw new FHIRException("Unknown VisionBase code '"+codeString+"'");
        }
    public String toCode(VisionBase code) {
      if (code == VisionBase.UP)
        return "up";
      if (code == VisionBase.DOWN)
        return "down";
      if (code == VisionBase.IN)
        return "in";
      if (code == VisionBase.OUT)
        return "out";
      return "?";
      }
    public String toSystem(VisionBase code) {
      return code.getSystem();
      }
    }

    public enum VisionEyes {
        /**
         * Right Eye.
         */
        RIGHT, 
        /**
         * Left Eye.
         */
        LEFT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static VisionEyes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("right".equals(codeString))
          return RIGHT;
        if ("left".equals(codeString))
          return LEFT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown VisionEyes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case RIGHT: return "right";
            case LEFT: return "left";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case RIGHT: return "http://hl7.org/fhir/vision-eye-codes";
            case LEFT: return "http://hl7.org/fhir/vision-eye-codes";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case RIGHT: return "Right Eye.";
            case LEFT: return "Left Eye.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RIGHT: return "Right Eye";
            case LEFT: return "Left Eye";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class VisionEyesEnumFactory implements EnumFactory<VisionEyes> {
    public VisionEyes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("right".equals(codeString))
          return VisionEyes.RIGHT;
        if ("left".equals(codeString))
          return VisionEyes.LEFT;
        throw new IllegalArgumentException("Unknown VisionEyes code '"+codeString+"'");
        }
        public Enumeration<VisionEyes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<VisionEyes>(this, VisionEyes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<VisionEyes>(this, VisionEyes.NULL, code);
        if ("right".equals(codeString))
          return new Enumeration<VisionEyes>(this, VisionEyes.RIGHT, code);
        if ("left".equals(codeString))
          return new Enumeration<VisionEyes>(this, VisionEyes.LEFT, code);
        throw new FHIRException("Unknown VisionEyes code '"+codeString+"'");
        }
    public String toCode(VisionEyes code) {
      if (code == VisionEyes.RIGHT)
        return "right";
      if (code == VisionEyes.LEFT)
        return "left";
      return "?";
      }
    public String toSystem(VisionEyes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class VisionPrescriptionLensSpecificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the type of vision correction product which is required for the patient.
         */
        @Child(name = "product", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Product to be supplied", formalDefinition="Identifies the type of vision correction product which is required for the patient." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/vision-product")
        protected CodeableConcept product;

        /**
         * The eye for which the lens specification applies.
         */
        @Child(name = "eye", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="right | left", formalDefinition="The eye for which the lens specification applies." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/vision-eye-codes")
        protected Enumeration<VisionEyes> eye;

        /**
         * Lens power measured in dioptres (0.25 units).
         */
        @Child(name = "sphere", type = {DecimalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Power of the lens", formalDefinition="Lens power measured in dioptres (0.25 units)." )
        protected DecimalType sphere;

        /**
         * Power adjustment for astigmatism measured in dioptres (0.25 units).
         */
        @Child(name = "cylinder", type = {DecimalType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Lens power for astigmatism", formalDefinition="Power adjustment for astigmatism measured in dioptres (0.25 units)." )
        protected DecimalType cylinder;

        /**
         * Adjustment for astigmatism measured in integer degrees.
         */
        @Child(name = "axis", type = {IntegerType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Lens meridian which contain no power for astigmatism", formalDefinition="Adjustment for astigmatism measured in integer degrees." )
        protected IntegerType axis;

        /**
         * Allows for adjustment on two axis.
         */
        @Child(name = "prism", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Eye alignment compensation", formalDefinition="Allows for adjustment on two axis." )
        protected List<PrismComponent> prism;

        /**
         * Power adjustment for multifocal lenses measured in dioptres (0.25 units).
         */
        @Child(name = "add", type = {DecimalType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Added power for multifocal levels", formalDefinition="Power adjustment for multifocal lenses measured in dioptres (0.25 units)." )
        protected DecimalType add;

        /**
         * Contact lens power measured in dioptres (0.25 units).
         */
        @Child(name = "power", type = {DecimalType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Contact lens power", formalDefinition="Contact lens power measured in dioptres (0.25 units)." )
        protected DecimalType power;

        /**
         * Back curvature measured in millimetres.
         */
        @Child(name = "backCurve", type = {DecimalType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Contact lens back curvature", formalDefinition="Back curvature measured in millimetres." )
        protected DecimalType backCurve;

        /**
         * Contact lens diameter measured in millimetres.
         */
        @Child(name = "diameter", type = {DecimalType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Contact lens diameter", formalDefinition="Contact lens diameter measured in millimetres." )
        protected DecimalType diameter;

        /**
         * The recommended maximum wear period for the lens.
         */
        @Child(name = "duration", type = {Quantity.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Lens wear duration", formalDefinition="The recommended maximum wear period for the lens." )
        protected Quantity duration;

        /**
         * Special color or pattern.
         */
        @Child(name = "color", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Color required", formalDefinition="Special color or pattern." )
        protected StringType color;

        /**
         * Brand recommendations or restrictions.
         */
        @Child(name = "brand", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Brand required", formalDefinition="Brand recommendations or restrictions." )
        protected StringType brand;

        /**
         * Notes for special requirements such as coatings and lens materials.
         */
        @Child(name = "note", type = {Annotation.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Notes for coatings", formalDefinition="Notes for special requirements such as coatings and lens materials." )
        protected List<Annotation> note;

        private static final long serialVersionUID = 688924460L;

    /**
     * Constructor
     */
      public VisionPrescriptionLensSpecificationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public VisionPrescriptionLensSpecificationComponent(CodeableConcept product, VisionEyes eye) {
        super();
        this.setProduct(product);
        this.setEye(eye);
      }

        /**
         * @return {@link #product} (Identifies the type of vision correction product which is required for the patient.)
         */
        public CodeableConcept getProduct() { 
          if (this.product == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.product");
            else if (Configuration.doAutoCreate())
              this.product = new CodeableConcept(); // cc
          return this.product;
        }

        public boolean hasProduct() { 
          return this.product != null && !this.product.isEmpty();
        }

        /**
         * @param value {@link #product} (Identifies the type of vision correction product which is required for the patient.)
         */
        public VisionPrescriptionLensSpecificationComponent setProduct(CodeableConcept value) { 
          this.product = value;
          return this;
        }

        /**
         * @return {@link #eye} (The eye for which the lens specification applies.). This is the underlying object with id, value and extensions. The accessor "getEye" gives direct access to the value
         */
        public Enumeration<VisionEyes> getEyeElement() { 
          if (this.eye == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.eye");
            else if (Configuration.doAutoCreate())
              this.eye = new Enumeration<VisionEyes>(new VisionEyesEnumFactory()); // bb
          return this.eye;
        }

        public boolean hasEyeElement() { 
          return this.eye != null && !this.eye.isEmpty();
        }

        public boolean hasEye() { 
          return this.eye != null && !this.eye.isEmpty();
        }

        /**
         * @param value {@link #eye} (The eye for which the lens specification applies.). This is the underlying object with id, value and extensions. The accessor "getEye" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setEyeElement(Enumeration<VisionEyes> value) { 
          this.eye = value;
          return this;
        }

        /**
         * @return The eye for which the lens specification applies.
         */
        public VisionEyes getEye() { 
          return this.eye == null ? null : this.eye.getValue();
        }

        /**
         * @param value The eye for which the lens specification applies.
         */
        public VisionPrescriptionLensSpecificationComponent setEye(VisionEyes value) { 
            if (this.eye == null)
              this.eye = new Enumeration<VisionEyes>(new VisionEyesEnumFactory());
            this.eye.setValue(value);
          return this;
        }

        /**
         * @return {@link #sphere} (Lens power measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getSphere" gives direct access to the value
         */
        public DecimalType getSphereElement() { 
          if (this.sphere == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.sphere");
            else if (Configuration.doAutoCreate())
              this.sphere = new DecimalType(); // bb
          return this.sphere;
        }

        public boolean hasSphereElement() { 
          return this.sphere != null && !this.sphere.isEmpty();
        }

        public boolean hasSphere() { 
          return this.sphere != null && !this.sphere.isEmpty();
        }

        /**
         * @param value {@link #sphere} (Lens power measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getSphere" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setSphereElement(DecimalType value) { 
          this.sphere = value;
          return this;
        }

        /**
         * @return Lens power measured in dioptres (0.25 units).
         */
        public BigDecimal getSphere() { 
          return this.sphere == null ? null : this.sphere.getValue();
        }

        /**
         * @param value Lens power measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setSphere(BigDecimal value) { 
          if (value == null)
            this.sphere = null;
          else {
            if (this.sphere == null)
              this.sphere = new DecimalType();
            this.sphere.setValue(value);
          }
          return this;
        }

        /**
         * @param value Lens power measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setSphere(long value) { 
              this.sphere = new DecimalType();
            this.sphere.setValue(value);
          return this;
        }

        /**
         * @param value Lens power measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setSphere(double value) { 
              this.sphere = new DecimalType();
            this.sphere.setValue(value);
          return this;
        }

        /**
         * @return {@link #cylinder} (Power adjustment for astigmatism measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getCylinder" gives direct access to the value
         */
        public DecimalType getCylinderElement() { 
          if (this.cylinder == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.cylinder");
            else if (Configuration.doAutoCreate())
              this.cylinder = new DecimalType(); // bb
          return this.cylinder;
        }

        public boolean hasCylinderElement() { 
          return this.cylinder != null && !this.cylinder.isEmpty();
        }

        public boolean hasCylinder() { 
          return this.cylinder != null && !this.cylinder.isEmpty();
        }

        /**
         * @param value {@link #cylinder} (Power adjustment for astigmatism measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getCylinder" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setCylinderElement(DecimalType value) { 
          this.cylinder = value;
          return this;
        }

        /**
         * @return Power adjustment for astigmatism measured in dioptres (0.25 units).
         */
        public BigDecimal getCylinder() { 
          return this.cylinder == null ? null : this.cylinder.getValue();
        }

        /**
         * @param value Power adjustment for astigmatism measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setCylinder(BigDecimal value) { 
          if (value == null)
            this.cylinder = null;
          else {
            if (this.cylinder == null)
              this.cylinder = new DecimalType();
            this.cylinder.setValue(value);
          }
          return this;
        }

        /**
         * @param value Power adjustment for astigmatism measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setCylinder(long value) { 
              this.cylinder = new DecimalType();
            this.cylinder.setValue(value);
          return this;
        }

        /**
         * @param value Power adjustment for astigmatism measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setCylinder(double value) { 
              this.cylinder = new DecimalType();
            this.cylinder.setValue(value);
          return this;
        }

        /**
         * @return {@link #axis} (Adjustment for astigmatism measured in integer degrees.). This is the underlying object with id, value and extensions. The accessor "getAxis" gives direct access to the value
         */
        public IntegerType getAxisElement() { 
          if (this.axis == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.axis");
            else if (Configuration.doAutoCreate())
              this.axis = new IntegerType(); // bb
          return this.axis;
        }

        public boolean hasAxisElement() { 
          return this.axis != null && !this.axis.isEmpty();
        }

        public boolean hasAxis() { 
          return this.axis != null && !this.axis.isEmpty();
        }

        /**
         * @param value {@link #axis} (Adjustment for astigmatism measured in integer degrees.). This is the underlying object with id, value and extensions. The accessor "getAxis" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setAxisElement(IntegerType value) { 
          this.axis = value;
          return this;
        }

        /**
         * @return Adjustment for astigmatism measured in integer degrees.
         */
        public int getAxis() { 
          return this.axis == null || this.axis.isEmpty() ? 0 : this.axis.getValue();
        }

        /**
         * @param value Adjustment for astigmatism measured in integer degrees.
         */
        public VisionPrescriptionLensSpecificationComponent setAxis(int value) { 
            if (this.axis == null)
              this.axis = new IntegerType();
            this.axis.setValue(value);
          return this;
        }

        /**
         * @return {@link #prism} (Allows for adjustment on two axis.)
         */
        public List<PrismComponent> getPrism() { 
          if (this.prism == null)
            this.prism = new ArrayList<PrismComponent>();
          return this.prism;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public VisionPrescriptionLensSpecificationComponent setPrism(List<PrismComponent> thePrism) { 
          this.prism = thePrism;
          return this;
        }

        public boolean hasPrism() { 
          if (this.prism == null)
            return false;
          for (PrismComponent item : this.prism)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PrismComponent addPrism() { //3
          PrismComponent t = new PrismComponent();
          if (this.prism == null)
            this.prism = new ArrayList<PrismComponent>();
          this.prism.add(t);
          return t;
        }

        public VisionPrescriptionLensSpecificationComponent addPrism(PrismComponent t) { //3
          if (t == null)
            return this;
          if (this.prism == null)
            this.prism = new ArrayList<PrismComponent>();
          this.prism.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #prism}, creating it if it does not already exist {3}
         */
        public PrismComponent getPrismFirstRep() { 
          if (getPrism().isEmpty()) {
            addPrism();
          }
          return getPrism().get(0);
        }

        /**
         * @return {@link #add} (Power adjustment for multifocal lenses measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getAdd" gives direct access to the value
         */
        public DecimalType getAddElement() { 
          if (this.add == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.add");
            else if (Configuration.doAutoCreate())
              this.add = new DecimalType(); // bb
          return this.add;
        }

        public boolean hasAddElement() { 
          return this.add != null && !this.add.isEmpty();
        }

        public boolean hasAdd() { 
          return this.add != null && !this.add.isEmpty();
        }

        /**
         * @param value {@link #add} (Power adjustment for multifocal lenses measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getAdd" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setAddElement(DecimalType value) { 
          this.add = value;
          return this;
        }

        /**
         * @return Power adjustment for multifocal lenses measured in dioptres (0.25 units).
         */
        public BigDecimal getAdd() { 
          return this.add == null ? null : this.add.getValue();
        }

        /**
         * @param value Power adjustment for multifocal lenses measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setAdd(BigDecimal value) { 
          if (value == null)
            this.add = null;
          else {
            if (this.add == null)
              this.add = new DecimalType();
            this.add.setValue(value);
          }
          return this;
        }

        /**
         * @param value Power adjustment for multifocal lenses measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setAdd(long value) { 
              this.add = new DecimalType();
            this.add.setValue(value);
          return this;
        }

        /**
         * @param value Power adjustment for multifocal lenses measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setAdd(double value) { 
              this.add = new DecimalType();
            this.add.setValue(value);
          return this;
        }

        /**
         * @return {@link #power} (Contact lens power measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getPower" gives direct access to the value
         */
        public DecimalType getPowerElement() { 
          if (this.power == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.power");
            else if (Configuration.doAutoCreate())
              this.power = new DecimalType(); // bb
          return this.power;
        }

        public boolean hasPowerElement() { 
          return this.power != null && !this.power.isEmpty();
        }

        public boolean hasPower() { 
          return this.power != null && !this.power.isEmpty();
        }

        /**
         * @param value {@link #power} (Contact lens power measured in dioptres (0.25 units).). This is the underlying object with id, value and extensions. The accessor "getPower" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setPowerElement(DecimalType value) { 
          this.power = value;
          return this;
        }

        /**
         * @return Contact lens power measured in dioptres (0.25 units).
         */
        public BigDecimal getPower() { 
          return this.power == null ? null : this.power.getValue();
        }

        /**
         * @param value Contact lens power measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setPower(BigDecimal value) { 
          if (value == null)
            this.power = null;
          else {
            if (this.power == null)
              this.power = new DecimalType();
            this.power.setValue(value);
          }
          return this;
        }

        /**
         * @param value Contact lens power measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setPower(long value) { 
              this.power = new DecimalType();
            this.power.setValue(value);
          return this;
        }

        /**
         * @param value Contact lens power measured in dioptres (0.25 units).
         */
        public VisionPrescriptionLensSpecificationComponent setPower(double value) { 
              this.power = new DecimalType();
            this.power.setValue(value);
          return this;
        }

        /**
         * @return {@link #backCurve} (Back curvature measured in millimetres.). This is the underlying object with id, value and extensions. The accessor "getBackCurve" gives direct access to the value
         */
        public DecimalType getBackCurveElement() { 
          if (this.backCurve == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.backCurve");
            else if (Configuration.doAutoCreate())
              this.backCurve = new DecimalType(); // bb
          return this.backCurve;
        }

        public boolean hasBackCurveElement() { 
          return this.backCurve != null && !this.backCurve.isEmpty();
        }

        public boolean hasBackCurve() { 
          return this.backCurve != null && !this.backCurve.isEmpty();
        }

        /**
         * @param value {@link #backCurve} (Back curvature measured in millimetres.). This is the underlying object with id, value and extensions. The accessor "getBackCurve" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setBackCurveElement(DecimalType value) { 
          this.backCurve = value;
          return this;
        }

        /**
         * @return Back curvature measured in millimetres.
         */
        public BigDecimal getBackCurve() { 
          return this.backCurve == null ? null : this.backCurve.getValue();
        }

        /**
         * @param value Back curvature measured in millimetres.
         */
        public VisionPrescriptionLensSpecificationComponent setBackCurve(BigDecimal value) { 
          if (value == null)
            this.backCurve = null;
          else {
            if (this.backCurve == null)
              this.backCurve = new DecimalType();
            this.backCurve.setValue(value);
          }
          return this;
        }

        /**
         * @param value Back curvature measured in millimetres.
         */
        public VisionPrescriptionLensSpecificationComponent setBackCurve(long value) { 
              this.backCurve = new DecimalType();
            this.backCurve.setValue(value);
          return this;
        }

        /**
         * @param value Back curvature measured in millimetres.
         */
        public VisionPrescriptionLensSpecificationComponent setBackCurve(double value) { 
              this.backCurve = new DecimalType();
            this.backCurve.setValue(value);
          return this;
        }

        /**
         * @return {@link #diameter} (Contact lens diameter measured in millimetres.). This is the underlying object with id, value and extensions. The accessor "getDiameter" gives direct access to the value
         */
        public DecimalType getDiameterElement() { 
          if (this.diameter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.diameter");
            else if (Configuration.doAutoCreate())
              this.diameter = new DecimalType(); // bb
          return this.diameter;
        }

        public boolean hasDiameterElement() { 
          return this.diameter != null && !this.diameter.isEmpty();
        }

        public boolean hasDiameter() { 
          return this.diameter != null && !this.diameter.isEmpty();
        }

        /**
         * @param value {@link #diameter} (Contact lens diameter measured in millimetres.). This is the underlying object with id, value and extensions. The accessor "getDiameter" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setDiameterElement(DecimalType value) { 
          this.diameter = value;
          return this;
        }

        /**
         * @return Contact lens diameter measured in millimetres.
         */
        public BigDecimal getDiameter() { 
          return this.diameter == null ? null : this.diameter.getValue();
        }

        /**
         * @param value Contact lens diameter measured in millimetres.
         */
        public VisionPrescriptionLensSpecificationComponent setDiameter(BigDecimal value) { 
          if (value == null)
            this.diameter = null;
          else {
            if (this.diameter == null)
              this.diameter = new DecimalType();
            this.diameter.setValue(value);
          }
          return this;
        }

        /**
         * @param value Contact lens diameter measured in millimetres.
         */
        public VisionPrescriptionLensSpecificationComponent setDiameter(long value) { 
              this.diameter = new DecimalType();
            this.diameter.setValue(value);
          return this;
        }

        /**
         * @param value Contact lens diameter measured in millimetres.
         */
        public VisionPrescriptionLensSpecificationComponent setDiameter(double value) { 
              this.diameter = new DecimalType();
            this.diameter.setValue(value);
          return this;
        }

        /**
         * @return {@link #duration} (The recommended maximum wear period for the lens.)
         */
        public Quantity getDuration() { 
          if (this.duration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.duration");
            else if (Configuration.doAutoCreate())
              this.duration = new Quantity(); // cc
          return this.duration;
        }

        public boolean hasDuration() { 
          return this.duration != null && !this.duration.isEmpty();
        }

        /**
         * @param value {@link #duration} (The recommended maximum wear period for the lens.)
         */
        public VisionPrescriptionLensSpecificationComponent setDuration(Quantity value) { 
          this.duration = value;
          return this;
        }

        /**
         * @return {@link #color} (Special color or pattern.). This is the underlying object with id, value and extensions. The accessor "getColor" gives direct access to the value
         */
        public StringType getColorElement() { 
          if (this.color == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.color");
            else if (Configuration.doAutoCreate())
              this.color = new StringType(); // bb
          return this.color;
        }

        public boolean hasColorElement() { 
          return this.color != null && !this.color.isEmpty();
        }

        public boolean hasColor() { 
          return this.color != null && !this.color.isEmpty();
        }

        /**
         * @param value {@link #color} (Special color or pattern.). This is the underlying object with id, value and extensions. The accessor "getColor" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setColorElement(StringType value) { 
          this.color = value;
          return this;
        }

        /**
         * @return Special color or pattern.
         */
        public String getColor() { 
          return this.color == null ? null : this.color.getValue();
        }

        /**
         * @param value Special color or pattern.
         */
        public VisionPrescriptionLensSpecificationComponent setColor(String value) { 
          if (Utilities.noString(value))
            this.color = null;
          else {
            if (this.color == null)
              this.color = new StringType();
            this.color.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #brand} (Brand recommendations or restrictions.). This is the underlying object with id, value and extensions. The accessor "getBrand" gives direct access to the value
         */
        public StringType getBrandElement() { 
          if (this.brand == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create VisionPrescriptionLensSpecificationComponent.brand");
            else if (Configuration.doAutoCreate())
              this.brand = new StringType(); // bb
          return this.brand;
        }

        public boolean hasBrandElement() { 
          return this.brand != null && !this.brand.isEmpty();
        }

        public boolean hasBrand() { 
          return this.brand != null && !this.brand.isEmpty();
        }

        /**
         * @param value {@link #brand} (Brand recommendations or restrictions.). This is the underlying object with id, value and extensions. The accessor "getBrand" gives direct access to the value
         */
        public VisionPrescriptionLensSpecificationComponent setBrandElement(StringType value) { 
          this.brand = value;
          return this;
        }

        /**
         * @return Brand recommendations or restrictions.
         */
        public String getBrand() { 
          return this.brand == null ? null : this.brand.getValue();
        }

        /**
         * @param value Brand recommendations or restrictions.
         */
        public VisionPrescriptionLensSpecificationComponent setBrand(String value) { 
          if (Utilities.noString(value))
            this.brand = null;
          else {
            if (this.brand == null)
              this.brand = new StringType();
            this.brand.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #note} (Notes for special requirements such as coatings and lens materials.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public VisionPrescriptionLensSpecificationComponent setNote(List<Annotation> theNote) { 
          this.note = theNote;
          return this;
        }

        public boolean hasNote() { 
          if (this.note == null)
            return false;
          for (Annotation item : this.note)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Annotation addNote() { //3
          Annotation t = new Annotation();
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          this.note.add(t);
          return t;
        }

        public VisionPrescriptionLensSpecificationComponent addNote(Annotation t) { //3
          if (t == null)
            return this;
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          this.note.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
         */
        public Annotation getNoteFirstRep() { 
          if (getNote().isEmpty()) {
            addNote();
          }
          return getNote().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("product", "CodeableConcept", "Identifies the type of vision correction product which is required for the patient.", 0, 1, product));
          children.add(new Property("eye", "code", "The eye for which the lens specification applies.", 0, 1, eye));
          children.add(new Property("sphere", "decimal", "Lens power measured in dioptres (0.25 units).", 0, 1, sphere));
          children.add(new Property("cylinder", "decimal", "Power adjustment for astigmatism measured in dioptres (0.25 units).", 0, 1, cylinder));
          children.add(new Property("axis", "integer", "Adjustment for astigmatism measured in integer degrees.", 0, 1, axis));
          children.add(new Property("prism", "", "Allows for adjustment on two axis.", 0, java.lang.Integer.MAX_VALUE, prism));
          children.add(new Property("add", "decimal", "Power adjustment for multifocal lenses measured in dioptres (0.25 units).", 0, 1, add));
          children.add(new Property("power", "decimal", "Contact lens power measured in dioptres (0.25 units).", 0, 1, power));
          children.add(new Property("backCurve", "decimal", "Back curvature measured in millimetres.", 0, 1, backCurve));
          children.add(new Property("diameter", "decimal", "Contact lens diameter measured in millimetres.", 0, 1, diameter));
          children.add(new Property("duration", "Quantity", "The recommended maximum wear period for the lens.", 0, 1, duration));
          children.add(new Property("color", "string", "Special color or pattern.", 0, 1, color));
          children.add(new Property("brand", "string", "Brand recommendations or restrictions.", 0, 1, brand));
          children.add(new Property("note", "Annotation", "Notes for special requirements such as coatings and lens materials.", 0, java.lang.Integer.MAX_VALUE, note));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -309474065: /*product*/  return new Property("product", "CodeableConcept", "Identifies the type of vision correction product which is required for the patient.", 0, 1, product);
          case 100913: /*eye*/  return new Property("eye", "code", "The eye for which the lens specification applies.", 0, 1, eye);
          case -895981619: /*sphere*/  return new Property("sphere", "decimal", "Lens power measured in dioptres (0.25 units).", 0, 1, sphere);
          case -349378602: /*cylinder*/  return new Property("cylinder", "decimal", "Power adjustment for astigmatism measured in dioptres (0.25 units).", 0, 1, cylinder);
          case 3008417: /*axis*/  return new Property("axis", "integer", "Adjustment for astigmatism measured in integer degrees.", 0, 1, axis);
          case 106935105: /*prism*/  return new Property("prism", "", "Allows for adjustment on two axis.", 0, java.lang.Integer.MAX_VALUE, prism);
          case 96417: /*add*/  return new Property("add", "decimal", "Power adjustment for multifocal lenses measured in dioptres (0.25 units).", 0, 1, add);
          case 106858757: /*power*/  return new Property("power", "decimal", "Contact lens power measured in dioptres (0.25 units).", 0, 1, power);
          case 1309344840: /*backCurve*/  return new Property("backCurve", "decimal", "Back curvature measured in millimetres.", 0, 1, backCurve);
          case -233204595: /*diameter*/  return new Property("diameter", "decimal", "Contact lens diameter measured in millimetres.", 0, 1, diameter);
          case -1992012396: /*duration*/  return new Property("duration", "Quantity", "The recommended maximum wear period for the lens.", 0, 1, duration);
          case 94842723: /*color*/  return new Property("color", "string", "Special color or pattern.", 0, 1, color);
          case 93997959: /*brand*/  return new Property("brand", "string", "Brand recommendations or restrictions.", 0, 1, brand);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Notes for special requirements such as coatings and lens materials.", 0, java.lang.Integer.MAX_VALUE, note);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -309474065: /*product*/ return this.product == null ? new Base[0] : new Base[] {this.product}; // CodeableConcept
        case 100913: /*eye*/ return this.eye == null ? new Base[0] : new Base[] {this.eye}; // Enumeration<VisionEyes>
        case -895981619: /*sphere*/ return this.sphere == null ? new Base[0] : new Base[] {this.sphere}; // DecimalType
        case -349378602: /*cylinder*/ return this.cylinder == null ? new Base[0] : new Base[] {this.cylinder}; // DecimalType
        case 3008417: /*axis*/ return this.axis == null ? new Base[0] : new Base[] {this.axis}; // IntegerType
        case 106935105: /*prism*/ return this.prism == null ? new Base[0] : this.prism.toArray(new Base[this.prism.size()]); // PrismComponent
        case 96417: /*add*/ return this.add == null ? new Base[0] : new Base[] {this.add}; // DecimalType
        case 106858757: /*power*/ return this.power == null ? new Base[0] : new Base[] {this.power}; // DecimalType
        case 1309344840: /*backCurve*/ return this.backCurve == null ? new Base[0] : new Base[] {this.backCurve}; // DecimalType
        case -233204595: /*diameter*/ return this.diameter == null ? new Base[0] : new Base[] {this.diameter}; // DecimalType
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // Quantity
        case 94842723: /*color*/ return this.color == null ? new Base[0] : new Base[] {this.color}; // StringType
        case 93997959: /*brand*/ return this.brand == null ? new Base[0] : new Base[] {this.brand}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -309474065: // product
          this.product = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 100913: // eye
          value = new VisionEyesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.eye = (Enumeration) value; // Enumeration<VisionEyes>
          return value;
        case -895981619: // sphere
          this.sphere = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -349378602: // cylinder
          this.cylinder = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 3008417: // axis
          this.axis = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 106935105: // prism
          this.getPrism().add((PrismComponent) value); // PrismComponent
          return value;
        case 96417: // add
          this.add = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 106858757: // power
          this.power = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 1309344840: // backCurve
          this.backCurve = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -233204595: // diameter
          this.diameter = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1992012396: // duration
          this.duration = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 94842723: // color
          this.color = TypeConvertor.castToString(value); // StringType
          return value;
        case 93997959: // brand
          this.brand = TypeConvertor.castToString(value); // StringType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("product")) {
          this.product = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("eye")) {
          value = new VisionEyesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.eye = (Enumeration) value; // Enumeration<VisionEyes>
        } else if (name.equals("sphere")) {
          this.sphere = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("cylinder")) {
          this.cylinder = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("axis")) {
          this.axis = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("prism")) {
          this.getPrism().add((PrismComponent) value);
        } else if (name.equals("add")) {
          this.add = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("power")) {
          this.power = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("backCurve")) {
          this.backCurve = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("diameter")) {
          this.diameter = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("duration")) {
          this.duration = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("color")) {
          this.color = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("brand")) {
          this.brand = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309474065:  return getProduct();
        case 100913:  return getEyeElement();
        case -895981619:  return getSphereElement();
        case -349378602:  return getCylinderElement();
        case 3008417:  return getAxisElement();
        case 106935105:  return addPrism(); 
        case 96417:  return getAddElement();
        case 106858757:  return getPowerElement();
        case 1309344840:  return getBackCurveElement();
        case -233204595:  return getDiameterElement();
        case -1992012396:  return getDuration();
        case 94842723:  return getColorElement();
        case 93997959:  return getBrandElement();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -309474065: /*product*/ return new String[] {"CodeableConcept"};
        case 100913: /*eye*/ return new String[] {"code"};
        case -895981619: /*sphere*/ return new String[] {"decimal"};
        case -349378602: /*cylinder*/ return new String[] {"decimal"};
        case 3008417: /*axis*/ return new String[] {"integer"};
        case 106935105: /*prism*/ return new String[] {};
        case 96417: /*add*/ return new String[] {"decimal"};
        case 106858757: /*power*/ return new String[] {"decimal"};
        case 1309344840: /*backCurve*/ return new String[] {"decimal"};
        case -233204595: /*diameter*/ return new String[] {"decimal"};
        case -1992012396: /*duration*/ return new String[] {"Quantity"};
        case 94842723: /*color*/ return new String[] {"string"};
        case 93997959: /*brand*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("product")) {
          this.product = new CodeableConcept();
          return this.product;
        }
        else if (name.equals("eye")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.eye");
        }
        else if (name.equals("sphere")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.sphere");
        }
        else if (name.equals("cylinder")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.cylinder");
        }
        else if (name.equals("axis")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.axis");
        }
        else if (name.equals("prism")) {
          return addPrism();
        }
        else if (name.equals("add")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.add");
        }
        else if (name.equals("power")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.power");
        }
        else if (name.equals("backCurve")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.backCurve");
        }
        else if (name.equals("diameter")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.diameter");
        }
        else if (name.equals("duration")) {
          this.duration = new Quantity();
          return this.duration;
        }
        else if (name.equals("color")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.color");
        }
        else if (name.equals("brand")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.brand");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

      public VisionPrescriptionLensSpecificationComponent copy() {
        VisionPrescriptionLensSpecificationComponent dst = new VisionPrescriptionLensSpecificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(VisionPrescriptionLensSpecificationComponent dst) {
        super.copyValues(dst);
        dst.product = product == null ? null : product.copy();
        dst.eye = eye == null ? null : eye.copy();
        dst.sphere = sphere == null ? null : sphere.copy();
        dst.cylinder = cylinder == null ? null : cylinder.copy();
        dst.axis = axis == null ? null : axis.copy();
        if (prism != null) {
          dst.prism = new ArrayList<PrismComponent>();
          for (PrismComponent i : prism)
            dst.prism.add(i.copy());
        };
        dst.add = add == null ? null : add.copy();
        dst.power = power == null ? null : power.copy();
        dst.backCurve = backCurve == null ? null : backCurve.copy();
        dst.diameter = diameter == null ? null : diameter.copy();
        dst.duration = duration == null ? null : duration.copy();
        dst.color = color == null ? null : color.copy();
        dst.brand = brand == null ? null : brand.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof VisionPrescriptionLensSpecificationComponent))
          return false;
        VisionPrescriptionLensSpecificationComponent o = (VisionPrescriptionLensSpecificationComponent) other_;
        return compareDeep(product, o.product, true) && compareDeep(eye, o.eye, true) && compareDeep(sphere, o.sphere, true)
           && compareDeep(cylinder, o.cylinder, true) && compareDeep(axis, o.axis, true) && compareDeep(prism, o.prism, true)
           && compareDeep(add, o.add, true) && compareDeep(power, o.power, true) && compareDeep(backCurve, o.backCurve, true)
           && compareDeep(diameter, o.diameter, true) && compareDeep(duration, o.duration, true) && compareDeep(color, o.color, true)
           && compareDeep(brand, o.brand, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof VisionPrescriptionLensSpecificationComponent))
          return false;
        VisionPrescriptionLensSpecificationComponent o = (VisionPrescriptionLensSpecificationComponent) other_;
        return compareValues(eye, o.eye, true) && compareValues(sphere, o.sphere, true) && compareValues(cylinder, o.cylinder, true)
           && compareValues(axis, o.axis, true) && compareValues(add, o.add, true) && compareValues(power, o.power, true)
           && compareValues(backCurve, o.backCurve, true) && compareValues(diameter, o.diameter, true) && compareValues(color, o.color, true)
           && compareValues(brand, o.brand, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(product, eye, sphere, cylinder
          , axis, prism, add, power, backCurve, diameter, duration, color, brand, note
          );
      }

  public String fhirType() {
    return "VisionPrescription.lensSpecification";

  }

  }

    @Block()
    public static class PrismComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Amount of prism to compensate for eye alignment in fractional units.
         */
        @Child(name = "amount", type = {DecimalType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Amount of adjustment", formalDefinition="Amount of prism to compensate for eye alignment in fractional units." )
        protected DecimalType amount;

        /**
         * The relative base, or reference lens edge, for the prism.
         */
        @Child(name = "base", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="up | down | in | out", formalDefinition="The relative base, or reference lens edge, for the prism." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/vision-base-codes")
        protected Enumeration<VisionBase> base;

        private static final long serialVersionUID = 1677247628L;

    /**
     * Constructor
     */
      public PrismComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PrismComponent(BigDecimal amount, VisionBase base) {
        super();
        this.setAmount(amount);
        this.setBase(base);
      }

        /**
         * @return {@link #amount} (Amount of prism to compensate for eye alignment in fractional units.). This is the underlying object with id, value and extensions. The accessor "getAmount" gives direct access to the value
         */
        public DecimalType getAmountElement() { 
          if (this.amount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PrismComponent.amount");
            else if (Configuration.doAutoCreate())
              this.amount = new DecimalType(); // bb
          return this.amount;
        }

        public boolean hasAmountElement() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (Amount of prism to compensate for eye alignment in fractional units.). This is the underlying object with id, value and extensions. The accessor "getAmount" gives direct access to the value
         */
        public PrismComponent setAmountElement(DecimalType value) { 
          this.amount = value;
          return this;
        }

        /**
         * @return Amount of prism to compensate for eye alignment in fractional units.
         */
        public BigDecimal getAmount() { 
          return this.amount == null ? null : this.amount.getValue();
        }

        /**
         * @param value Amount of prism to compensate for eye alignment in fractional units.
         */
        public PrismComponent setAmount(BigDecimal value) { 
            if (this.amount == null)
              this.amount = new DecimalType();
            this.amount.setValue(value);
          return this;
        }

        /**
         * @param value Amount of prism to compensate for eye alignment in fractional units.
         */
        public PrismComponent setAmount(long value) { 
              this.amount = new DecimalType();
            this.amount.setValue(value);
          return this;
        }

        /**
         * @param value Amount of prism to compensate for eye alignment in fractional units.
         */
        public PrismComponent setAmount(double value) { 
              this.amount = new DecimalType();
            this.amount.setValue(value);
          return this;
        }

        /**
         * @return {@link #base} (The relative base, or reference lens edge, for the prism.). This is the underlying object with id, value and extensions. The accessor "getBase" gives direct access to the value
         */
        public Enumeration<VisionBase> getBaseElement() { 
          if (this.base == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PrismComponent.base");
            else if (Configuration.doAutoCreate())
              this.base = new Enumeration<VisionBase>(new VisionBaseEnumFactory()); // bb
          return this.base;
        }

        public boolean hasBaseElement() { 
          return this.base != null && !this.base.isEmpty();
        }

        public boolean hasBase() { 
          return this.base != null && !this.base.isEmpty();
        }

        /**
         * @param value {@link #base} (The relative base, or reference lens edge, for the prism.). This is the underlying object with id, value and extensions. The accessor "getBase" gives direct access to the value
         */
        public PrismComponent setBaseElement(Enumeration<VisionBase> value) { 
          this.base = value;
          return this;
        }

        /**
         * @return The relative base, or reference lens edge, for the prism.
         */
        public VisionBase getBase() { 
          return this.base == null ? null : this.base.getValue();
        }

        /**
         * @param value The relative base, or reference lens edge, for the prism.
         */
        public PrismComponent setBase(VisionBase value) { 
            if (this.base == null)
              this.base = new Enumeration<VisionBase>(new VisionBaseEnumFactory());
            this.base.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("amount", "decimal", "Amount of prism to compensate for eye alignment in fractional units.", 0, 1, amount));
          children.add(new Property("base", "code", "The relative base, or reference lens edge, for the prism.", 0, 1, base));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1413853096: /*amount*/  return new Property("amount", "decimal", "Amount of prism to compensate for eye alignment in fractional units.", 0, 1, amount);
          case 3016401: /*base*/  return new Property("base", "code", "The relative base, or reference lens edge, for the prism.", 0, 1, base);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // DecimalType
        case 3016401: /*base*/ return this.base == null ? new Base[0] : new Base[] {this.base}; // Enumeration<VisionBase>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1413853096: // amount
          this.amount = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 3016401: // base
          value = new VisionBaseEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.base = (Enumeration) value; // Enumeration<VisionBase>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("amount")) {
          this.amount = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("base")) {
          value = new VisionBaseEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.base = (Enumeration) value; // Enumeration<VisionBase>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1413853096:  return getAmountElement();
        case 3016401:  return getBaseElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1413853096: /*amount*/ return new String[] {"decimal"};
        case 3016401: /*base*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("amount")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.prism.amount");
        }
        else if (name.equals("base")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.lensSpecification.prism.base");
        }
        else
          return super.addChild(name);
      }

      public PrismComponent copy() {
        PrismComponent dst = new PrismComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PrismComponent dst) {
        super.copyValues(dst);
        dst.amount = amount == null ? null : amount.copy();
        dst.base = base == null ? null : base.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PrismComponent))
          return false;
        PrismComponent o = (PrismComponent) other_;
        return compareDeep(amount, o.amount, true) && compareDeep(base, o.base, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PrismComponent))
          return false;
        PrismComponent o = (PrismComponent) other_;
        return compareValues(amount, o.amount, true) && compareValues(base, o.base, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(amount, base);
      }

  public String fhirType() {
    return "VisionPrescription.lensSpecification.prism";

  }

  }

    /**
     * A unique identifier assigned to this vision prescription.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Business Identifier for vision prescription", formalDefinition="A unique identifier assigned to this vision prescription." )
    protected List<Identifier> identifier;

    /**
     * The status of the resource instance.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | cancelled | draft | entered-in-error", formalDefinition="The status of the resource instance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fm-status")
    protected Enumeration<FinancialResourceStatusCodes> status;

    /**
     * The date this resource was created.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Response creation date", formalDefinition="The date this resource was created." )
    protected DateTimeType created;

    /**
     * A resource reference to the person to whom the vision prescription applies.
     */
    @Child(name = "patient", type = {Patient.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who prescription is for", formalDefinition="A resource reference to the person to whom the vision prescription applies." )
    protected Reference patient;

    /**
     * A reference to a resource that identifies the particular occurrence of contact between patient and health care provider during which the prescription was issued.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Created during encounter / admission / stay", formalDefinition="A reference to a resource that identifies the particular occurrence of contact between patient and health care provider during which the prescription was issued." )
    protected Reference encounter;

    /**
     * The date (and perhaps time) when the prescription was written.
     */
    @Child(name = "dateWritten", type = {DateTimeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When prescription was authorized", formalDefinition="The date (and perhaps time) when the prescription was written." )
    protected DateTimeType dateWritten;

    /**
     * The healthcare professional responsible for authorizing the prescription.
     */
    @Child(name = "prescriber", type = {Practitioner.class, PractitionerRole.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who authorized the vision prescription", formalDefinition="The healthcare professional responsible for authorizing the prescription." )
    protected Reference prescriber;

    /**
     * Contain the details of  the individual lens specifications and serves as the authorization for the fullfillment by certified professionals.
     */
    @Child(name = "lensSpecification", type = {}, order=7, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Vision lens authorization", formalDefinition="Contain the details of  the individual lens specifications and serves as the authorization for the fullfillment by certified professionals." )
    protected List<VisionPrescriptionLensSpecificationComponent> lensSpecification;

    private static final long serialVersionUID = -194296688L;

  /**
   * Constructor
   */
    public VisionPrescription() {
      super();
    }

  /**
   * Constructor
   */
    public VisionPrescription(FinancialResourceStatusCodes status, Date created, Reference patient, Date dateWritten, Reference prescriber, VisionPrescriptionLensSpecificationComponent lensSpecification) {
      super();
      this.setStatus(status);
      this.setCreated(created);
      this.setPatient(patient);
      this.setDateWritten(dateWritten);
      this.setPrescriber(prescriber);
      this.addLensSpecification(lensSpecification);
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this vision prescription.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public VisionPrescription setIdentifier(List<Identifier> theIdentifier) { 
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

    public VisionPrescription addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FinancialResourceStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VisionPrescription.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FinancialResourceStatusCodes>(new FinancialResourceStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public VisionPrescription setStatusElement(Enumeration<FinancialResourceStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the resource instance.
     */
    public FinancialResourceStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the resource instance.
     */
    public VisionPrescription setStatus(FinancialResourceStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<FinancialResourceStatusCodes>(new FinancialResourceStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #created} (The date this resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VisionPrescription.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (The date this resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public VisionPrescription setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return The date this resource was created.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value The date this resource was created.
     */
    public VisionPrescription setCreated(Date value) { 
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      return this;
    }

    /**
     * @return {@link #patient} (A resource reference to the person to whom the vision prescription applies.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VisionPrescription.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (A resource reference to the person to whom the vision prescription applies.)
     */
    public VisionPrescription setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #encounter} (A reference to a resource that identifies the particular occurrence of contact between patient and health care provider during which the prescription was issued.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VisionPrescription.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (A reference to a resource that identifies the particular occurrence of contact between patient and health care provider during which the prescription was issued.)
     */
    public VisionPrescription setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #dateWritten} (The date (and perhaps time) when the prescription was written.). This is the underlying object with id, value and extensions. The accessor "getDateWritten" gives direct access to the value
     */
    public DateTimeType getDateWrittenElement() { 
      if (this.dateWritten == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VisionPrescription.dateWritten");
        else if (Configuration.doAutoCreate())
          this.dateWritten = new DateTimeType(); // bb
      return this.dateWritten;
    }

    public boolean hasDateWrittenElement() { 
      return this.dateWritten != null && !this.dateWritten.isEmpty();
    }

    public boolean hasDateWritten() { 
      return this.dateWritten != null && !this.dateWritten.isEmpty();
    }

    /**
     * @param value {@link #dateWritten} (The date (and perhaps time) when the prescription was written.). This is the underlying object with id, value and extensions. The accessor "getDateWritten" gives direct access to the value
     */
    public VisionPrescription setDateWrittenElement(DateTimeType value) { 
      this.dateWritten = value;
      return this;
    }

    /**
     * @return The date (and perhaps time) when the prescription was written.
     */
    public Date getDateWritten() { 
      return this.dateWritten == null ? null : this.dateWritten.getValue();
    }

    /**
     * @param value The date (and perhaps time) when the prescription was written.
     */
    public VisionPrescription setDateWritten(Date value) { 
        if (this.dateWritten == null)
          this.dateWritten = new DateTimeType();
        this.dateWritten.setValue(value);
      return this;
    }

    /**
     * @return {@link #prescriber} (The healthcare professional responsible for authorizing the prescription.)
     */
    public Reference getPrescriber() { 
      if (this.prescriber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VisionPrescription.prescriber");
        else if (Configuration.doAutoCreate())
          this.prescriber = new Reference(); // cc
      return this.prescriber;
    }

    public boolean hasPrescriber() { 
      return this.prescriber != null && !this.prescriber.isEmpty();
    }

    /**
     * @param value {@link #prescriber} (The healthcare professional responsible for authorizing the prescription.)
     */
    public VisionPrescription setPrescriber(Reference value) { 
      this.prescriber = value;
      return this;
    }

    /**
     * @return {@link #lensSpecification} (Contain the details of  the individual lens specifications and serves as the authorization for the fullfillment by certified professionals.)
     */
    public List<VisionPrescriptionLensSpecificationComponent> getLensSpecification() { 
      if (this.lensSpecification == null)
        this.lensSpecification = new ArrayList<VisionPrescriptionLensSpecificationComponent>();
      return this.lensSpecification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public VisionPrescription setLensSpecification(List<VisionPrescriptionLensSpecificationComponent> theLensSpecification) { 
      this.lensSpecification = theLensSpecification;
      return this;
    }

    public boolean hasLensSpecification() { 
      if (this.lensSpecification == null)
        return false;
      for (VisionPrescriptionLensSpecificationComponent item : this.lensSpecification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public VisionPrescriptionLensSpecificationComponent addLensSpecification() { //3
      VisionPrescriptionLensSpecificationComponent t = new VisionPrescriptionLensSpecificationComponent();
      if (this.lensSpecification == null)
        this.lensSpecification = new ArrayList<VisionPrescriptionLensSpecificationComponent>();
      this.lensSpecification.add(t);
      return t;
    }

    public VisionPrescription addLensSpecification(VisionPrescriptionLensSpecificationComponent t) { //3
      if (t == null)
        return this;
      if (this.lensSpecification == null)
        this.lensSpecification = new ArrayList<VisionPrescriptionLensSpecificationComponent>();
      this.lensSpecification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #lensSpecification}, creating it if it does not already exist {3}
     */
    public VisionPrescriptionLensSpecificationComponent getLensSpecificationFirstRep() { 
      if (getLensSpecification().isEmpty()) {
        addLensSpecification();
      }
      return getLensSpecification().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this vision prescription.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of the resource instance.", 0, 1, status));
        children.add(new Property("created", "dateTime", "The date this resource was created.", 0, 1, created));
        children.add(new Property("patient", "Reference(Patient)", "A resource reference to the person to whom the vision prescription applies.", 0, 1, patient));
        children.add(new Property("encounter", "Reference(Encounter)", "A reference to a resource that identifies the particular occurrence of contact between patient and health care provider during which the prescription was issued.", 0, 1, encounter));
        children.add(new Property("dateWritten", "dateTime", "The date (and perhaps time) when the prescription was written.", 0, 1, dateWritten));
        children.add(new Property("prescriber", "Reference(Practitioner|PractitionerRole)", "The healthcare professional responsible for authorizing the prescription.", 0, 1, prescriber));
        children.add(new Property("lensSpecification", "", "Contain the details of  the individual lens specifications and serves as the authorization for the fullfillment by certified professionals.", 0, java.lang.Integer.MAX_VALUE, lensSpecification));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this vision prescription.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the resource instance.", 0, 1, status);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "The date this resource was created.", 0, 1, created);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "A resource reference to the person to whom the vision prescription applies.", 0, 1, patient);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "A reference to a resource that identifies the particular occurrence of contact between patient and health care provider during which the prescription was issued.", 0, 1, encounter);
        case -1496880759: /*dateWritten*/  return new Property("dateWritten", "dateTime", "The date (and perhaps time) when the prescription was written.", 0, 1, dateWritten);
        case 1430631077: /*prescriber*/  return new Property("prescriber", "Reference(Practitioner|PractitionerRole)", "The healthcare professional responsible for authorizing the prescription.", 0, 1, prescriber);
        case -1767318363: /*lensSpecification*/  return new Property("lensSpecification", "", "Contain the details of  the individual lens specifications and serves as the authorization for the fullfillment by certified professionals.", 0, java.lang.Integer.MAX_VALUE, lensSpecification);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FinancialResourceStatusCodes>
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1496880759: /*dateWritten*/ return this.dateWritten == null ? new Base[0] : new Base[] {this.dateWritten}; // DateTimeType
        case 1430631077: /*prescriber*/ return this.prescriber == null ? new Base[0] : new Base[] {this.prescriber}; // Reference
        case -1767318363: /*lensSpecification*/ return this.lensSpecification == null ? new Base[0] : this.lensSpecification.toArray(new Base[this.lensSpecification.size()]); // VisionPrescriptionLensSpecificationComponent
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
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
          return value;
        case 1028554472: // created
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1496880759: // dateWritten
          this.dateWritten = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1430631077: // prescriber
          this.prescriber = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1767318363: // lensSpecification
          this.getLensSpecification().add((VisionPrescriptionLensSpecificationComponent) value); // VisionPrescriptionLensSpecificationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("dateWritten")) {
          this.dateWritten = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("prescriber")) {
          this.prescriber = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("lensSpecification")) {
          this.getLensSpecification().add((VisionPrescriptionLensSpecificationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 1028554472:  return getCreatedElement();
        case -791418107:  return getPatient();
        case 1524132147:  return getEncounter();
        case -1496880759:  return getDateWrittenElement();
        case 1430631077:  return getPrescriber();
        case -1767318363:  return addLensSpecification(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1496880759: /*dateWritten*/ return new String[] {"dateTime"};
        case 1430631077: /*prescriber*/ return new String[] {"Reference"};
        case -1767318363: /*lensSpecification*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.status");
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.created");
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("dateWritten")) {
          throw new FHIRException("Cannot call addChild on a primitive type VisionPrescription.dateWritten");
        }
        else if (name.equals("prescriber")) {
          this.prescriber = new Reference();
          return this.prescriber;
        }
        else if (name.equals("lensSpecification")) {
          return addLensSpecification();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "VisionPrescription";

  }

      public VisionPrescription copy() {
        VisionPrescription dst = new VisionPrescription();
        copyValues(dst);
        return dst;
      }

      public void copyValues(VisionPrescription dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.created = created == null ? null : created.copy();
        dst.patient = patient == null ? null : patient.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.dateWritten = dateWritten == null ? null : dateWritten.copy();
        dst.prescriber = prescriber == null ? null : prescriber.copy();
        if (lensSpecification != null) {
          dst.lensSpecification = new ArrayList<VisionPrescriptionLensSpecificationComponent>();
          for (VisionPrescriptionLensSpecificationComponent i : lensSpecification)
            dst.lensSpecification.add(i.copy());
        };
      }

      protected VisionPrescription typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof VisionPrescription))
          return false;
        VisionPrescription o = (VisionPrescription) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(created, o.created, true)
           && compareDeep(patient, o.patient, true) && compareDeep(encounter, o.encounter, true) && compareDeep(dateWritten, o.dateWritten, true)
           && compareDeep(prescriber, o.prescriber, true) && compareDeep(lensSpecification, o.lensSpecification, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof VisionPrescription))
          return false;
        VisionPrescription o = (VisionPrescription) other_;
        return compareValues(status, o.status, true) && compareValues(created, o.created, true) && compareValues(dateWritten, o.dateWritten, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, created
          , patient, encounter, dateWritten, prescriber, lensSpecification);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.VisionPrescription;
   }

 /**
   * Search parameter: <b>datewritten</b>
   * <p>
   * Description: <b>Return prescriptions written on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>VisionPrescription.dateWritten</b><br>
   * </p>
   */
  @SearchParamDefinition(name="datewritten", path="VisionPrescription.dateWritten", description="Return prescriptions written on this date", type="date" )
  public static final String SP_DATEWRITTEN = "datewritten";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>datewritten</b>
   * <p>
   * Description: <b>Return prescriptions written on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>VisionPrescription.dateWritten</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATEWRITTEN = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATEWRITTEN);

 /**
   * Search parameter: <b>prescriber</b>
   * <p>
   * Description: <b>Who authorized the vision prescription</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>VisionPrescription.prescriber</b><br>
   * </p>
   */
  @SearchParamDefinition(name="prescriber", path="VisionPrescription.prescriber", description="Who authorized the vision prescription", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Practitioner.class, PractitionerRole.class } )
  public static final String SP_PRESCRIBER = "prescriber";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>prescriber</b>
   * <p>
   * Description: <b>Who authorized the vision prescription</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>VisionPrescription.prescriber</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRESCRIBER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRESCRIBER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>VisionPrescription:prescriber</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRESCRIBER = new ca.uhn.fhir.model.api.Include("VisionPrescription:prescriber").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the vision prescription</b><br>
   * Type: <b>token</b><br>
   * Path: <b>VisionPrescription.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="VisionPrescription.status", description="The status of the vision prescription", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the vision prescription</b><br>
   * Type: <b>token</b><br>
   * Path: <b>VisionPrescription.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent\r\n* [CarePlan](careplan.html): The Encounter during which this CarePlan was created\r\n* [ChargeItem](chargeitem.html): Encounter associated with event\r\n* [Claim](claim.html): Encounters associated with a billed line item\r\n* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created\r\n* [Communication](communication.html): The Encounter during which this Communication was created\r\n* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created\r\n* [Composition](composition.html): Context of the Composition\r\n* [Condition](condition.html): The Encounter during which this Condition was created\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values\r\n* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [ImagingStudy](imagingstudy.html): The context of the study\r\n* [List](list.html): Context in which list created\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [Provenance](provenance.html): Encounter related to the Provenance\r\n* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response\r\n* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [Task](task.html): Search by encounter\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>VisionPrescription:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("VisionPrescription:encounter").toLocked();

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
   * the path value of "<b>VisionPrescription:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("VisionPrescription:patient").toLocked();


}

