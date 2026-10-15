package org.hl7.fhir.convertors.baseAdaptors;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.model.core.BaseDateTimeType;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ICoding;
import org.hl7.fhir.r4.model.Constants;
import org.hl7.fhir.r4.model.Factory;
import org.hl7.fhir.r4.model.ResourceFactory;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.util.*;

/**
 * this class maps the RN base to an R4 implementation
 *
 * this means that engines such as the FML engine that are internally based on R6 can be applied to
 * an R4 object model
 *
 * Usage Notes:
 *  - This class ignores format comments and validation information - they are not wrapped
 *  - This class doesn't cache wrappers, so iterating the children will produce  a new wrapper each time.
 *  - User data is stored on the wrapped R4 object, not the wrapper, so it survives re-wrapping, and is
 *    visible to R4 code working on the same objects. copy() honours CopyObjectOptions.USER_DATA (and nothing
 *    else - see above)
 *  - User data values are not translated between versions: they are opaque, and passed through as is. An R4
 *    object that R4 code stored comes back as that R4 object (not converted, and not wrapped in an adaptor),
 *    and an R6 object stored through the adaptor is what R4 code sees. Copies (copy() and copyUserData())
 *    share the values rather than copying them, as R6 does
 *  - Choice types: getNamedProperty accepts the type specific names (e.g. valueQuantity) as well as the
 *    stem (value) and the [x] name (value[x]), but for the open choice types (the ones that allow any type -
 *    Extension.value[x], Parameters.parameter.value[x], Task.input/output.value[x], the ElementDefinition
 *    defaultValue[x]/fixed[x]/pattern[x]/example.value[x], and StructureMap.group.rule.source.defaultValue[x]) the
 *    R4 generated code only knows the type specific names for the primitive types. So, for example,
 *    getNamedProperty("valueAge", true) on an Extension throws (and returns null if checkValid is false),
 *    where R6 returns the property. Use the stem or the [x] name for these - they work everywhere
 */

public class BaseNAdaptorR4 extends Base {

  private final org.hl7.fhir.r4.model.Base wrapped;

  public BaseNAdaptorR4(IModelContext context, org.hl7.fhir.r4.model.Base base) {
    super(context);
    this.wrapped = base;
  }

  public BaseNAdaptorR4(IModelContext context, String type) {
    super(context);
    this.wrapped = ResourceFactory.createResourceOrType(type);
  }

  @Override
  public String getFHIRVersion() {
    return Constants.VERSION;
  }
  @Override
  public String getIdBase() {
    return wrapped.getIdBase();
  }

  @Override
  public void setIdBase(String value) {
    wrapped.setIdBase(value);
  }

  @Override
  public Base copy(EnumSet<CopyObjectOptions> options) {
    // R4 copy() never copies user data. Comments and validation information aren't wrapped, so those options are ignored
    org.hl7.fhir.r4.model.Base copy = wrapped.copy();
    if (options != null && options.contains(CopyObjectOptions.USER_DATA)) {
      copyUserDataDeep(wrapped, copy);
    }
    return new BaseNAdaptorR4(modelContext, copy);
  }

  /**
   * copy the user data from every node in src onto the matching node in dst - which is a copy of src, so has the same shape
   */
  private static void copyUserDataDeep(org.hl7.fhir.r4.model.Base src, org.hl7.fhir.r4.model.Base dst) {
    for (String n : src.getUserDataNames()) {
      dst.setUserData(n, src.getUserData(n));
    }
    List<org.hl7.fhir.r4.model.Property> srcChildren = src.children();
    List<org.hl7.fhir.r4.model.Property> dstChildren = dst.children();
    for (int i = 0; i < srcChildren.size() && i < dstChildren.size(); i++) {
      List<org.hl7.fhir.r4.model.Base> srcValues = srcChildren.get(i).getValues();
      List<org.hl7.fhir.r4.model.Base> dstValues = dstChildren.get(i).getValues();
      for (int j = 0; j < srcValues.size() && j < dstValues.size(); j++) {
        if (srcValues.get(j) != null && dstValues.get(j) != null) {
          copyUserDataDeep(srcValues.get(j), dstValues.get(j));
        }
      }
    }
  }

  @Override
  public Object getUserData(String name) {
    return wrapped.getUserData(name);
  }

  @Override
  public void setUserData(String name, Object value) {
    wrapped.setUserData(name, value);
  }

  @Override
  public void clearUserData(String name) {
    wrapped.clearUserData(name);
  }

  @Override
  public void clearUserData() {
    wrapped.clearUserData();
  }

  @Override
  public void setUserDataINN(String name, Object value) {
    wrapped.setUserDataINN(name, value);
  }

  @Override
  public boolean hasUserData(String name) {
    // R4's hasUserData is true for an entry with a null value; here, as in R6, it isn't
    return wrapped.getUserData(name) != null;
  }

  @Override
  public String getUserString(String name) {
    return wrapped.getUserString(name);
  }

  @Override
  public int getUserInt(String name) {
    // not delegated: R4's version fails on an entry with a null value, where R6 returns 0
    return super.getUserInt(name);
  }

  @Override
  public void copyUserData(Base other) {
    // merge, as R6 does: names only on this object are kept
    for (String n : other.getUserDataNames()) {
      wrapped.setUserData(n, other.getUserData(n));
    }
  }

  @Override
  public Set<String> getUserDataNames() {
    return wrapped.getUserDataNames();
  }

  @Override
  public String fhirType() {
    return wrapped.fhirType();
  }

  @Override
  public boolean hasType(String... names) {
    // R4's hasType doesn't understand the FHIR.[type] / CDA.[type] forms. The Base implementation works off fhirType(), which is delegated
    return super.hasType(names);
  }

  @Override
  public boolean isResource() {
    return wrapped.isResource();
  }

  @Override
  public boolean isPrimitive() {
    return wrapped.isPrimitive();
  }

  @Override
  public boolean hasPrimitiveValue() {
    return wrapped.primitiveValue() != null;
  }

  @Override
  public boolean canHavePrimitiveValue() {
    return wrapped.isPrimitive();
  }

  @Override
  public String primitiveValue() {
    return wrapped.primitiveValue();
  }

  @Override
  public boolean isBooleanPrimitive() {
    return wrapped.isBooleanPrimitive();
  }

  @Override
  public boolean isDateTime() {
    return wrapped.isDateTime();
  }

  @Override
  public BaseDateTimeType dateTimeValue() {
    org.hl7.fhir.r4.model.BaseDateTimeType r4 = wrapped.dateTimeValue();
    return r4 == null ? null : (BaseDateTimeType) VersionConvertorFactory_40_N.convertType(r4, new BaseAdvisor_40_N());
  }

  @Override
  public boolean isEmpty() {
    return wrapped.isEmpty();
  }

  @Override
  public boolean isMetadataBased() {
    // there is still an element model for R4, but it is not supported, nor does it make sense to use it here
    return false;
  }

  @Override
  public DataType asType() {
    // this is not supported in R4 (metadata related)
    return null;
  }

  @Override
  public ICoding getAsICoding() {
    org.hl7.fhir.r4.model.Coding r4;
    try {
      r4 = wrapped.castToCoding(wrapped);
    } catch (FHIRException e) {
      // R4 throws if the object can't be a coding; the contract here is to return null
      return null;
    }
    return r4 == null ? null : (Coding) VersionConvertorFactory_40_N.convertType(r4, new BaseAdvisor_40_N());
  }

  @Override
  public XhtmlNode getXhtml() {
    return wrapped.getXhtml();
  }

  @Override
  public Base setXhtml(XhtmlNode node) {
    wrapped.setXhtml(node);
    return this;
  }

  @Override
  protected void listChildren(List<Property> result) {
    List<org.hl7.fhir.r4.model.Property> r4Children = wrapped.children();
    for (org.hl7.fhir.r4.model.Property r4Property : r4Children) {
      Property property = new Property(r4Property.getName(), r4Property.getTypeCode(), r4Property.getDefinition(), r4Property.getMinCardinality(), r4Property.getMaxCardinality());
      for (org.hl7.fhir.r4.model.Base r4base : r4Property.getValues()) {
        property.getValues().add(new BaseNAdaptorR4(modelContext, r4base));
      }
      result.add(property);
    }
  }

  @Override
  public Property getNamedProperty(String _name, boolean _checkValid) throws FHIRException {
    org.hl7.fhir.r4.model.Property r4Property = wrapped.getNamedProperty(_name.hashCode(), _name, _checkValid);
    if (r4Property == null) {
      return null;
    }
    Property property = new Property(r4Property.getName(), r4Property.getTypeCode(), r4Property.getDefinition(), r4Property.getMinCardinality(), r4Property.getMaxCardinality());
    for (org.hl7.fhir.r4.model.Base r4base : r4Property.getValues()) {
      property.getValues().add(new BaseNAdaptorR4(modelContext, r4base));
    }
    return property;
  }

  @Override
  public Base[] getNamedValue(String name, boolean checkValid) throws FHIRException {
    org.hl7.fhir.r4.model.Base[] r4 = wrapped.getProperty(name.hashCode(), name, checkValid);
    if (r4 == null) {
      return null;
    }
    Base[] result = new Base[r4.length];
    for (int i = 0; i < r4.length; i++) {
      result[i] = new BaseNAdaptorR4(modelContext, r4[i]);
    }
    return result;
  }

  @Override
  public Base addChild(String name) throws FHIRException {
    org.hl7.fhir.r4.model.Base r4 = wrapped.addChild(name);
    return r4 == null ? null : new BaseNAdaptorR4(modelContext, r4);
  }

  @Override
  public Base makeProperty(String name) throws FHIRException {
    org.hl7.fhir.r4.model.Base r4 = wrapped.makeProperty(name.hashCode(), name);
    return r4 == null ? null : new BaseNAdaptorR4(modelContext, r4);
  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    org.hl7.fhir.r4.model.Base v = getBaseAsR4(value);
    // the string form, not the hash form: choice properties are named "[x]" here (as in R6), and only the R4 string form accepts that
    org.hl7.fhir.r4.model.Base r4 = wrapped.setProperty(name, v);
    return r4 == null ? null : new BaseNAdaptorR4(modelContext, r4);
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    org.hl7.fhir.r4.model.Base v = getBaseAsR4(value);
    wrapped.removeChild(name, v);

  }

  private static org.hl7.fhir.r4.model.@Nullable Base getBaseAsR4(Base value) {
    org.hl7.fhir.r4.model.Base v = null;
    if (value != null) {
      if (value instanceof BaseNAdaptorR4) {
        v = ((BaseNAdaptorR4) value).wrapped;
      } else if (value instanceof DataType) {
        v = VersionConvertorFactory_40_N.convertType((DataType) value, new BaseAdvisor_40_N());
      } else {
        throw new FHIRException("unable to set value of type " + value.fhirType() + " in R4 adaptor");
      }
    }
    return v;
  }
}