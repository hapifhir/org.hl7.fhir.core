package org.hl7.fhir.r5.model;


import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
/**
 * Used for extensions of type 'named-elements'
 */

public class NamedElementExtension extends Element  {

  private static final long serialVersionUID = -3624826962424387196L;
  final private String elementName;
  private StructureDefinition definition; // if known
  private Base value;


  /**
   * Constructor
   */
  public NamedElementExtension(String elementName) {
    super();
    this.elementName =elementName;
  }

  /**
   * Constructor
   */
  public NamedElementExtension(String elementName, Base value) {
    this.elementName = elementName;
    setValue(value);
  }


  /**
   * @return Element name
   */
  public String getElementName() { 
    return this.elementName;
  }

  public boolean hasValue() { 
    return this.value != null && !this.value.isEmpty();
  }

  /**
   * @return {@link #value} (Value of extension)
   */
  public Base getValue() { 
    return this.value;
  }

  public NamedElementExtension setValue(Base value) { 
    this.value = value;
    return this;
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("value[x]", "Base", "Value of extension", 0, 1, value));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case 111972721: /*value*/  return new Property("value", "Base", "Value of extension", 0, 1, value);
    default: return super.getNamedProperty(_hash, _name, _checkValid);
    }
  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
    default: return super.getProperty(hash, name, checkValid);
    }
  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 111972721: // value
      this.value = value; // DataType
      return value;
    default: return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("value[x]")) {
      this.value = TypeConvertor.castToType(value); // DataType
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 111972721: /*value*/ return new String[] {"Base"};
    default: return super.getTypesForProperty(hash, name);
    }

  }

  public String fhirType() {
    return "NamedElementExtension";

  }

  public NamedElementExtension copy() {
    NamedElementExtension dst = new NamedElementExtension(elementName);
    copyValues(dst);
    return dst;
  }

  public void copyValues(NamedElementExtension dst) {
    super.copyValues(dst);
    dst.value = value == null ? null : value.copy();
  }

  protected NamedElementExtension typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof NamedElementExtension))
      return false;
    NamedElementExtension o = (NamedElementExtension) other_;
    return compareDeep(elementName, o.elementName, true) && compareDeep(value, o.value, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof NamedElementExtension))
      return false;
    NamedElementExtension o = (NamedElementExtension) other_;
    return compareDeep(elementName, o.elementName, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value);
  }


}

