package org.hl7.fhir.convertors.baseAdaptors;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_N;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_50_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.model.core.BaseDateTimeType;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ICoding;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.model.TypeConvertor;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * this class maps the RN base to an R5 implementation
 *
 * this means that engines such as the FML engine that are internally based on R6 can be applied to
 * an R5 object model
 *
 * Usage Notes:
 *  - This class ignores format comments and validation information - they are not wrapped
 *  - This class doesn't cache wrappers, so iterating the children will produce  a new wrapper each time.
 *  - User data is stored on the wrapped R5 object, not the wrapper, so it survives re-wrapping, and is
 *    visible to R5 code working on the same objects. copy() honours CopyObjectOptions.USER_DATA (and nothing
 *    else - see above)
 *  - User data values are not translated between versions: they are opaque, and passed through as is. An R5
 *    object that R5 code stored comes back as that R5 object (not converted, and not wrapped in an adaptor),
 *    and an R6 object stored through the adaptor is what R5 code sees. Copies (copy() and copyUserData())
 *    share the values rather than copying them, as R6 does
 *  - Choice types: getNamedProperty accepts the type specific names (e.g. valueQuantity) as well as the
 *    stem (value) and the [x] name (value[x]), but for the open choice types (the ones that allow any type -
 *    Extension.value[x], Parameters.parameter.value[x], Task.input/output.value[x], the ElementDefinition
 *    defaultValue[x]/fixed[x]/pattern[x]/example.value[x], and StructureMap.group.rule.source.defaultValue[x]) the
 *    R5 generated code only knows the type specific names for the primitive types. So, for example,
 *    getNamedProperty("valueAge", true) on an Extension throws (and returns null if checkValid is false),
 *    where R6 returns the property. Use the stem or the [x] name for these - they work everywhere
 */

public class BaseNAdaptorR5 extends Base {

  private final org.hl7.fhir.r5.model.Base wrapped;

  public BaseNAdaptorR5(IModelContext context, org.hl7.fhir.r5.model.Base base) {
    super(context);
    this.wrapped = base;
  }

  public BaseNAdaptorR5(IModelContext context, String type) {
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
    // R5 copy() never copies user data. Comments and validation information aren't wrapped, so those options are ignored
    org.hl7.fhir.r5.model.Base copy = wrapped.copy();
    if (options != null && options.contains(CopyObjectOptions.USER_DATA)) {
      copyUserDataDeep(wrapped, copy);
    }
    return new BaseNAdaptorR5(modelContext, copy);
  }

  /**
   * copy the user data from every node in src onto the matching node in dst - which is a copy of src, so has the same shape
   */
  private static void copyUserDataDeep(org.hl7.fhir.r5.model.Base src, org.hl7.fhir.r5.model.Base dst) {
    for (String n : src.getUserDataNames()) {
      dst.setUserData(n, src.getUserData(n));
    }
    List<org.hl7.fhir.r5.model.Property> srcChildren = src.children();
    List<org.hl7.fhir.r5.model.Property> dstChildren = dst.children();
    for (int i = 0; i < srcChildren.size() && i < dstChildren.size(); i++) {
      List<org.hl7.fhir.r5.model.Base> srcValues = srcChildren.get(i).getValues();
      List<org.hl7.fhir.r5.model.Base> dstValues = dstChildren.get(i).getValues();
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
    // R5's hasUserData is true for an entry with a null value; here, as in R6, it isn't
    return wrapped.getUserData(name) != null;
  }

  @Override
  public String getUserString(String name) {
    return wrapped.getUserString(name);
  }

  @Override
  public int getUserInt(String name) {
    // not delegated: R5's version fails on an entry with a null value, where R6 returns 0
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
    // R5's hasType doesn't understand the FHIR.[type] / CDA.[type] forms. The Base implementation works off fhirType(), which is delegated
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
    org.hl7.fhir.r5.model.BaseDateTimeType r5 = wrapped.dateTimeValue();
    return r5 == null ? null : (BaseDateTimeType) VersionConvertorFactory_50_N.convertType(r5, new BaseAdvisor_50_N());
  }

  @Override
  public boolean isEmpty() {
    return wrapped.isEmpty();
  }

  @Override
  public boolean isMetadataBased() {
    // there is still an element model for R5, but it is not supported, nor does it make sense to use it here
    return false;
  }

  @Override
  public DataType asType() {
    // this is not supported in R5 (metadata related)
    return null;
  }

  @Override
  public ICoding getAsICoding() {
    org.hl7.fhir.r5.model.Coding r5;
    try {
      r5 = TypeConvertor.castToCoding(wrapped);
    } catch (FHIRException e) {
      // R5 throws if the object can't be a coding; the contract here is to return null
      return null;
    }
    return r5 == null ? null : (Coding) VersionConvertorFactory_50_N.convertType(r5, new BaseAdvisor_50_N());
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
      List<org.hl7.fhir.r5.model.Property> r5Children = wrapped.children();
      for (org.hl7.fhir.r5.model.Property r5Property : r5Children) {
          Property property = new Property(r5Property.getName(), r5Property.getTypeCode(), r5Property.getDefinition(), r5Property.getMinCardinality(), r5Property.getMaxCardinality());
          for (org.hl7.fhir.r5.model.Base r5base : r5Property.getValues()) {
              property.getValues().add(new BaseNAdaptorR5(modelContext, r5base));
          }
          result.add(property);
      }
  }

  @Override
  public Property getNamedProperty(String _name, boolean _checkValid) throws FHIRException {
    org.hl7.fhir.r5.model.Property r5Property = wrapped.getNamedProperty(_name.hashCode(), _name, _checkValid);
    if (r5Property == null) {
      return null;
    }
    Property property = new Property(r5Property.getName(), r5Property.getTypeCode(), r5Property.getDefinition(), r5Property.getMinCardinality(), r5Property.getMaxCardinality());
    for (org.hl7.fhir.r5.model.Base r5base : r5Property.getValues()) {
      property.getValues().add(new BaseNAdaptorR5(modelContext, r5base));
    }
    return property;
  }

  @Override
  public Base[] getNamedValue(String name, boolean checkValid) throws FHIRException {
    org.hl7.fhir.r5.model.Base[] r5 = wrapped.getProperty(name.hashCode(), name, checkValid);
    if (r5 == null) {
      return null;
    }
    Base[] result = new Base[r5.length];
    for (int i = 0; i < r5.length; i++) {
      result[i] = new BaseNAdaptorR5(modelContext, r5[i]);
    }
    return result;
  }

    @Override
  public Base addChild(String name) throws FHIRException {
    org.hl7.fhir.r5.model.Base r5 = wrapped.addChild(name);
    return r5 == null ? null : new BaseNAdaptorR5(modelContext, r5);
  }

  @Override
  public Base makeProperty(String name) throws FHIRException {
    org.hl7.fhir.r5.model.Base r5 = wrapped.makeProperty(name.hashCode(), name);
    return r5 == null ? null : new BaseNAdaptorR5(modelContext, r5);
  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    org.hl7.fhir.r5.model.Base v = getBaseAsR5(value);
    // the string form, not the hash form: choice properties are named "[x]" here (as in R6), and only the R5 string form accepts that
    org.hl7.fhir.r5.model.Base r5 = wrapped.setProperty(name, v);
    return r5 == null ? null : new BaseNAdaptorR5(modelContext, r5);
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    org.hl7.fhir.r5.model.Base v = getBaseAsR5(value);
    wrapped.removeChild(name, v);

  }

  private static org.hl7.fhir.r5.model.@Nullable Base getBaseAsR5(Base value) {
    org.hl7.fhir.r5.model.Base v = null;
    if (value != null) {
      if (value instanceof BaseNAdaptorR5) {
        v = ((BaseNAdaptorR5) value).wrapped;
      } else if (value instanceof DataType) {
        v = VersionConvertorFactory_50_N.convertType((DataType) value, new BaseAdvisor_50_N());
      } else {
        throw new FHIRException("unable to set value of type " + value.fhirType() + " in R5 adaptor");
      }
    }
    return v;
  }
}