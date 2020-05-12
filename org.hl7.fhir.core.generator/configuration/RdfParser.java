package org.hl7.fhir.r5.formats;


// generated

{{license}}

{{startMark}}

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.formats.Turtle.Complex;
import java.io.IOException;

public class RdfParser extends RdfParserBase {

  public RdfParser() {
    super();
  }

  public RdfParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  private void composeEnum(Complex parent, String parentType, String name, Enumeration<? extends Enum> value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
    decorateCode(t, value);
  }


  protected void composeDate(Complex parent, String parentType, String name, DateType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeDateTime(Complex parent, String parentType, String name, DateTimeType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeCode(Complex parent, String parentType, String name, CodeType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
    decorateCode(t, value);
  }

  protected void composeString(Complex parent, String parentType, String name, StringType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeInteger(Complex parent, String parentType, String name, IntegerType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeInteger64(Complex parent, String parentType, String name, Integer64Type value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeOid(Complex parent, String parentType, String name, OidType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeCanonical(Complex parent, String parentType, String name, CanonicalType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeUri(Complex parent, String parentType, String name, UriType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeUuid(Complex parent, String parentType, String name, UuidType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeUrl(Complex parent, String parentType, String name, UrlType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeInstant(Complex parent, String parentType, String name, InstantType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeBoolean(Complex parent, String parentType, String name, BooleanType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeBase64Binary(Complex parent, String parentType, String name, Base64BinaryType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeUnsignedInt(Complex parent, String parentType, String name, UnsignedIntType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeMarkdown(Complex parent, String parentType, String name, MarkdownType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeTime(Complex parent, String parentType, String name, TimeType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeId(Complex parent, String parentType, String name, IdType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composePositiveInt(Complex parent, String parentType, String name, PositiveIntType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

  protected void composeDecimal(Complex parent, String parentType, String name, DecimalType value, int index) {
    if (value == null)
      return;
    Complex t = parent.predicate("fhir:"+parentType+"."+name);
    t.predicate("fhir:value", ttlLiteral(value.asStringValue()));
    composeElement(t, parentType, name, value, index);
  }

{{composer}}


  @Override
  protected void composeResource(Complex parent, Resource resource) {
    if (parent == null) {
      throw new Error("parent == null");
    } else if (resource == null) {
      throw new Error("resource == null");
{{compose-resource}}      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeType(Complex parent, String parentType, String name, DataType value, int index) {
    if (parent == null) {
      throw new Error("parent == null");
    } else if (parentType == null) {
      throw new Error("parentType == null");
    } else if (name == null) {
      throw new Error("name == null");
    } else if (value == null) {
      throw new Error("value == null");
    } else if (value instanceof DateType) {
      composeDate(parent, parentType, name, (DateType)value, index);
    } else if (value instanceof DateTimeType) {
      composeDateTime(parent, parentType, name, (DateTimeType)value, index);
    } else if (value instanceof CodeType) {
      composeCode(parent, parentType, name, (CodeType)value, index);
    } else if (value instanceof StringType) {
      composeString(parent, parentType, name, (StringType)value, index);
    } else if (value instanceof IntegerType) {
      composeInteger(parent, parentType, name, (IntegerType)value, index);
    } else if (value instanceof Integer64Type) {
      composeInteger64(parent, parentType, name, (Integer64Type)value, index);
    } else if (value instanceof OidType) {
      composeOid(parent, parentType, name, (OidType)value, index);
    } else if (value instanceof CanonicalType) {
      composeCanonical(parent, parentType, name, (CanonicalType)value, index);
    } else if (value instanceof UriType) {
      composeUri(parent, parentType, name, (UriType)value, index);
    } else if (value instanceof UuidType) {
      composeUuid(parent, parentType, name, (UuidType)value, index);
    } else if (value instanceof UrlType) {
      composeUrl(parent, parentType, name, (UrlType)value, index);
    } else if (value instanceof InstantType) {
      composeInstant(parent, parentType, name, (InstantType)value, index);
    } else if (value instanceof BooleanType) {
      composeBoolean(parent, parentType, name, (BooleanType)value, index);
    } else if (value instanceof Base64BinaryType) {
      composeBase64Binary(parent, parentType, name, (Base64BinaryType)value, index);
    } else if (value instanceof UnsignedIntType) {
      composeUnsignedInt(parent, parentType, name, (UnsignedIntType)value, index);
    } else if (value instanceof MarkdownType) {
      composeMarkdown(parent, parentType, name, (MarkdownType)value, index);
    } else if (value instanceof TimeType) {
      composeTime(parent, parentType, name, (TimeType)value, index);
    } else if (value instanceof IdType) {
      composeId(parent, parentType, name, (IdType)value, index);
    } else if (value instanceof PositiveIntType) {
      composePositiveInt(parent, parentType, name, (PositiveIntType)value, index);
    } else if (value instanceof DecimalType) {
      composeDecimal(parent, parentType, name, (DecimalType)value, index);
{{compose-type}}      
    } else {
      throw new Error("Unhandled type");
    }
  }

}