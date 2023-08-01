package org.hl7.fhir.r4b.model;

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

// Generated on Mon, Jun 13, 2022 17:19+0300 for FHIR v4.3.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.r4b.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Base StructureDefinition for ProductShelfLife Type: The shelf-life and
 * storage information for a medicinal product item or container can be
 * described using this class.
 */
@DatatypeDef(name = "ProductShelfLife")
public class ProductShelfLife extends BackboneType implements ICompositeType {

  /**
   * This describes the shelf life, taking into account various scenarios such as
   * shelf life of the packaged Medicinal Product itself, shelf life after
   * transformation where necessary and shelf life after the first opening of a
   * bottle, etc. The shelf life type shall be specified using an appropriate
   * controlled vocabulary The controlled term and the controlled term identifier
   * shall be specified.
   */
  @Child(name = "type", type = { CodeableConcept.class }, order = 0, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "This describes the shelf life, taking into account various scenarios such as shelf life of the packaged Medicinal Product itself, shelf life after transformation where necessary and shelf life after the first opening of a bottle, etc. The shelf life type shall be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified", formalDefinition = "This describes the shelf life, taking into account various scenarios such as shelf life of the packaged Medicinal Product itself, shelf life after transformation where necessary and shelf life after the first opening of a bottle, etc. The shelf life type shall be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified.")
  protected CodeableConcept type;

  /**
   * The shelf life time period can be specified using a numerical value for the
   * period of time and its unit of time measurement The unit of measurement shall
   * be specified in accordance with ISO 11240 and the resulting terminology The
   * symbol and the symbol identifier shall be used.
   */
  @Child(name = "period", type = { Duration.class,
      StringType.class }, order = 1, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used", formalDefinition = "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used.")
  protected DataType period;

  /**
   * Special precautions for storage, if any, can be specified using an
   * appropriate controlled vocabulary The controlled term and the controlled term
   * identifier shall be specified.
   */
  @Child(name = "specialPrecautionsForStorage", type = {
      CodeableConcept.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Special precautions for storage, if any, can be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified", formalDefinition = "Special precautions for storage, if any, can be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified.")
  protected List<CodeableConcept> specialPrecautionsForStorage;

  private static final long serialVersionUID = 675017411L;

  /**
   * Constructor
   */
  public ProductShelfLife() {
    super();
  }

  /**
   * @return {@link #type} (This describes the shelf life, taking into account
   *         various scenarios such as shelf life of the packaged Medicinal
   *         Product itself, shelf life after transformation where necessary and
   *         shelf life after the first opening of a bottle, etc. The shelf life
   *         type shall be specified using an appropriate controlled vocabulary
   *         The controlled term and the controlled term identifier shall be
   *         specified.)
   */
  public CodeableConcept getType() {
    if (this.type == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ProductShelfLife.type");
      else if (Configuration.doAutoCreate())
        this.type = new CodeableConcept(); // cc
    return this.type;
  }

  public boolean hasType() {
    return this.type != null && !this.type.isEmpty();
  }

  /**
   * @param value {@link #type} (This describes the shelf life, taking into
   *              account various scenarios such as shelf life of the packaged
   *              Medicinal Product itself, shelf life after transformation where
   *              necessary and shelf life after the first opening of a bottle,
   *              etc. The shelf life type shall be specified using an appropriate
   *              controlled vocabulary The controlled term and the controlled
   *              term identifier shall be specified.)
   */
  public ProductShelfLife setType(CodeableConcept value) {
    this.type = value;
    return this;
  }

  /**
   * @return {@link #period} (The shelf life time period can be specified using a
   *         numerical value for the period of time and its unit of time
   *         measurement The unit of measurement shall be specified in accordance
   *         with ISO 11240 and the resulting terminology The symbol and the
   *         symbol identifier shall be used.)
   */
  public DataType getPeriod() {
    return this.period;
  }

  /**
   * @return {@link #period} (The shelf life time period can be specified using a
   *         numerical value for the period of time and its unit of time
   *         measurement The unit of measurement shall be specified in accordance
   *         with ISO 11240 and the resulting terminology The symbol and the
   *         symbol identifier shall be used.)
   */
  public Duration getPeriodDuration() throws FHIRException {
    if (this.period == null)
      this.period = new Duration();
    if (!(this.period instanceof Duration))
      throw new FHIRException("Type mismatch: the type Duration was expected, but " + this.period.getClass().getName()
          + " was encountered");
    return (Duration) this.period;
  }

  public boolean hasPeriodDuration() {
    return this != null && this.period instanceof Duration;
  }

  /**
   * @return {@link #period} (The shelf life time period can be specified using a
   *         numerical value for the period of time and its unit of time
   *         measurement The unit of measurement shall be specified in accordance
   *         with ISO 11240 and the resulting terminology The symbol and the
   *         symbol identifier shall be used.)
   */
  public StringType getPeriodStringType() throws FHIRException {
    if (this.period == null)
      this.period = new StringType();
    if (!(this.period instanceof StringType))
      throw new FHIRException("Type mismatch: the type StringType was expected, but " + this.period.getClass().getName()
          + " was encountered");
    return (StringType) this.period;
  }

  public boolean hasPeriodStringType() {
    return this != null && this.period instanceof StringType;
  }

  public boolean hasPeriod() {
    return this.period != null && !this.period.isEmpty();
  }

  /**
   * @param value {@link #period} (The shelf life time period can be specified
   *              using a numerical value for the period of time and its unit of
   *              time measurement The unit of measurement shall be specified in
   *              accordance with ISO 11240 and the resulting terminology The
   *              symbol and the symbol identifier shall be used.)
   */
  public ProductShelfLife setPeriod(DataType value) {
    if (value != null && !(value instanceof Duration || value instanceof StringType))
      throw new Error("Not the right type for ProductShelfLife.period[x]: " + value.fhirType());
    this.period = value;
    return this;
  }

  /**
   * @return {@link #specialPrecautionsForStorage} (Special precautions for
   *         storage, if any, can be specified using an appropriate controlled
   *         vocabulary The controlled term and the controlled term identifier
   *         shall be specified.)
   */
  public List<CodeableConcept> getSpecialPrecautionsForStorage() {
    if (this.specialPrecautionsForStorage == null)
      this.specialPrecautionsForStorage = new ArrayList<CodeableConcept>();
    return this.specialPrecautionsForStorage;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public ProductShelfLife setSpecialPrecautionsForStorage(List<CodeableConcept> theSpecialPrecautionsForStorage) {
    this.specialPrecautionsForStorage = theSpecialPrecautionsForStorage;
    return this;
  }

  public boolean hasSpecialPrecautionsForStorage() {
    if (this.specialPrecautionsForStorage == null)
      return false;
    for (CodeableConcept item : this.specialPrecautionsForStorage)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addSpecialPrecautionsForStorage() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.specialPrecautionsForStorage == null)
      this.specialPrecautionsForStorage = new ArrayList<CodeableConcept>();
    this.specialPrecautionsForStorage.add(t);
    return t;
  }

  public ProductShelfLife addSpecialPrecautionsForStorage(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.specialPrecautionsForStorage == null)
      this.specialPrecautionsForStorage = new ArrayList<CodeableConcept>();
    this.specialPrecautionsForStorage.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field
   *         {@link #specialPrecautionsForStorage}, creating it if it does not
   *         already exist {3}
   */
  public CodeableConcept getSpecialPrecautionsForStorageFirstRep() {
    if (getSpecialPrecautionsForStorage().isEmpty()) {
      addSpecialPrecautionsForStorage();
    }
    return getSpecialPrecautionsForStorage().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("type", "CodeableConcept",
        "This describes the shelf life, taking into account various scenarios such as shelf life of the packaged Medicinal Product itself, shelf life after transformation where necessary and shelf life after the first opening of a bottle, etc. The shelf life type shall be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified.",
        0, 1, type));
    children.add(new Property("period[x]", "Duration|string",
        "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used.",
        0, 1, period));
    children.add(new Property("specialPrecautionsForStorage", "CodeableConcept",
        "Special precautions for storage, if any, can be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified.",
        0, java.lang.Integer.MAX_VALUE, specialPrecautionsForStorage));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case 3575610:
      /* type */ return new Property("type", "CodeableConcept",
          "This describes the shelf life, taking into account various scenarios such as shelf life of the packaged Medicinal Product itself, shelf life after transformation where necessary and shelf life after the first opening of a bottle, etc. The shelf life type shall be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified.",
          0, 1, type);
    case 566594335:
      /* period[x] */ return new Property("period[x]", "Duration|string",
          "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used.",
          0, 1, period);
    case -991726143:
      /* period */ return new Property("period[x]", "Duration|string",
          "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used.",
          0, 1, period);
    case -850078091:
      /* periodDuration */ return new Property("period[x]", "Duration",
          "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used.",
          0, 1, period);
    case -41636558:
      /* periodString */ return new Property("period[x]", "string",
          "The shelf life time period can be specified using a numerical value for the period of time and its unit of time measurement The unit of measurement shall be specified in accordance with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be used.",
          0, 1, period);
    case 2103459492:
      /* specialPrecautionsForStorage */ return new Property("specialPrecautionsForStorage", "CodeableConcept",
          "Special precautions for storage, if any, can be specified using an appropriate controlled vocabulary The controlled term and the controlled term identifier shall be specified.",
          0, java.lang.Integer.MAX_VALUE, specialPrecautionsForStorage);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case 3575610:
      /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
    case -991726143:
      /* period */ return this.period == null ? new Base[0] : new Base[] { this.period }; // DataType
    case 2103459492:
      /* specialPrecautionsForStorage */ return this.specialPrecautionsForStorage == null ? new Base[0]
          : this.specialPrecautionsForStorage.toArray(new Base[this.specialPrecautionsForStorage.size()]); // CodeableConcept
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 3575610: // type
      this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      return value;
    case -991726143: // period
      this.period = TypeConvertor.castToType(value); // DataType
      return value;
    case 2103459492: // specialPrecautionsForStorage
      this.getSpecialPrecautionsForStorage().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("type")) {
      this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("period[x]")) {
      this.period = TypeConvertor.castToType(value); // DataType
    } else if (name.equals("specialPrecautionsForStorage")) {
      this.getSpecialPrecautionsForStorage().add(TypeConvertor.castToCodeableConcept(value));
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 3575610:
      return getType();
    case 566594335:
      return getPeriod();
    case -991726143:
      return getPeriod();
    case 2103459492:
      return addSpecialPrecautionsForStorage();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 3575610:
      /* type */ return new String[] { "CodeableConcept" };
    case -991726143:
      /* period */ return new String[] { "Duration", "string" };
    case 2103459492:
      /* specialPrecautionsForStorage */ return new String[] { "CodeableConcept" };
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("type")) {
      this.type = new CodeableConcept();
      return this.type;
    } else if (name.equals("periodDuration")) {
      this.period = new Duration();
      return this.period;
    } else if (name.equals("periodString")) {
      this.period = new StringType();
      return this.period;
    } else if (name.equals("specialPrecautionsForStorage")) {
      return addSpecialPrecautionsForStorage();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "ProductShelfLife";

  }

  public ProductShelfLife copy() {
    ProductShelfLife dst = new ProductShelfLife();
    copyValues(dst);
    return dst;
  }

  public void copyValues(ProductShelfLife dst) {
    super.copyValues(dst);
    dst.type = type == null ? null : type.copy();
    dst.period = period == null ? null : period.copy();
    if (specialPrecautionsForStorage != null) {
      dst.specialPrecautionsForStorage = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : specialPrecautionsForStorage)
        dst.specialPrecautionsForStorage.add(i.copy());
    }
    ;
  }

  protected ProductShelfLife typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof ProductShelfLife))
      return false;
    ProductShelfLife o = (ProductShelfLife) other_;
    return compareDeep(type, o.type, true) && compareDeep(period, o.period, true)
        && compareDeep(specialPrecautionsForStorage, o.specialPrecautionsForStorage, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof ProductShelfLife))
      return false;
    ProductShelfLife o = (ProductShelfLife) other_;
    return true;
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, period, specialPrecautionsForStorage);
  }

}
