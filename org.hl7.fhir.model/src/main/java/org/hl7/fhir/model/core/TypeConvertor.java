package org.hl7.fhir.model.core;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.regex.PrimitiveRegexes;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class TypeConvertor {

  // -- converters for property setters
  
  public static DataType castToType(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    if (b instanceof DataType)
      return (DataType) b;
    else if (b.isMetadataBased())
      return b.asType();
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a DataType");
  }
  

  public static BooleanType castToBoolean(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof BooleanType) {
      return (BooleanType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || "true".equals(s) || "false".equals(s)) {
        BooleanType t = new BooleanType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Boolean");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Boolean");
    }
  }

  public static IntegerType castToInteger(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof IntegerType) {
      return (IntegerType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || isInteger(s, Integer.MIN_VALUE)) {
        IntegerType t = new IntegerType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Integer");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Integer");
    }
  }

  public static Integer64Type castToInteger64(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof Integer64Type) {
      return (Integer64Type) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || isInteger64(s)) {
        Integer64Type t = new Integer64Type();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Integer64");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Integer64");
    }
  }

  public static DecimalType castToDecimal(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof DecimalType) {
      return (DecimalType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || Utilities.isDecimal(s, true)) {
        DecimalType t = new DecimalType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Decimal");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Decimal");
    }
  }

  public static Base64BinaryType castToBase64Binary(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof Base64BinaryType) {
      return (Base64BinaryType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || isBase64(s)) {
        Base64BinaryType t = new Base64BinaryType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Base64Binary");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Base64Binary");
    }
  }

  public static InstantType castToInstant(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof InstantType) {
      return (InstantType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || parses(new InstantType(), s)) {
        InstantType t = new InstantType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Instant");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Instant");
    }
  }

  public static StringType castToString(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof StringType) {
      return (StringType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      StringType t = new StringType();
      if (s != null) {
        t.setValueAsString(s);
      }
      copyIdAndExtensions(v, t);
      return t;
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a String");
    }
  }

  public static UriType castToUri(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof UriType) {
      return (UriType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || !containsWhitespace(s)) {
        UriType t = new UriType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Uri");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Uri");
    }
  }

  public static UrlType castToUrl(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof UrlType) {
      return (UrlType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || !containsWhitespace(s)) {
        UrlType t = new UrlType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Url");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Url");
    }
  }

  public static UuidType castToUuid(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof UuidType) {
      return (UuidType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || hasFormat(UUID_REGEX, s)) {
        UuidType t = new UuidType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Uuid");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Uuid");
    }
  }

  public static CanonicalType castToCanonical(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof CanonicalType) {
      return (CanonicalType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || !containsWhitespace(s)) {
        CanonicalType t = new CanonicalType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Canonical");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Canonical");
    }
  }

  public static DateType castToDate(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof DateType) {
      return (DateType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || parses(new DateType(), s)) {
        DateType t = new DateType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Date");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Date");
    }
  }

  public static DateTimeType castToDateTime(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof DateTimeType) {
      return (DateTimeType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || parses(new DateTimeType(), s)) {
        DateTimeType t = new DateTimeType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a DateTime");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a DateTime");
    }
  }

  public static TimeType castToTime(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof TimeType) {
      return (TimeType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || isTime(s)) {
        TimeType t = new TimeType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Time");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Time");
    }
  }

  public static CodeType castToCode(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof CodeType) {
      return (CodeType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || hasFormat(CODE_REGEX, s)) {
        CodeType t = new CodeType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Code");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Code");
    }
  }

  public static OidType castToOid(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof OidType) {
      return (OidType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || hasFormat(OID_REGEX, s)) {
        OidType t = new OidType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Oid");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Oid");
    }
  }

  public static IdType castToId(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof IdType) {
      return (IdType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || hasFormat(ID_REGEX, s)) {
        IdType t = new IdType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a Id");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Id");
    }
  }

  public static UnsignedIntType castToUnsignedInt(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof UnsignedIntType) {
      return (UnsignedIntType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || isInteger(s, 0)) {
        UnsignedIntType t = new UnsignedIntType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a UnsignedInt");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a UnsignedInt");
    }
  }

  public static PositiveIntType castToPositiveInt(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof PositiveIntType) {
      return (PositiveIntType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (s == null || isInteger(s, 1)) {
        PositiveIntType t = new PositiveIntType();
        if (s != null) {
          t.setValueAsString(s);
        }
        copyIdAndExtensions(v, t);
        return t;
      } else {
        throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") with value '" + s + "' to a PositiveInt");
      }
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a PositiveInt");
    }
  }

  public static MarkdownType castToMarkdown(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }
    Base v = b.isMetadataBased() ? b.asType() : b;
    if (v instanceof MarkdownType) {
      return (MarkdownType) v;
    }
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      MarkdownType t = new MarkdownType();
      if (s != null) {
        t.setValueAsString(s);
      }
      copyIdAndExtensions(v, t);
      return t;
    } else {
      throw new FHIRException("Unable to convert a " + b.fhirType() + "(" + b.getClass().getName() + ") to a Markdown");
    }
  }

  // -- support for the primitive casts --------------------------------------------------------

  // the spec's regexes for the primitive types with format rules the classes don't enforce. These are
  // evaluated by PrimitiveRegexes' hand written equivalents, so no regex is compiled or run here
  private static final String UUID_REGEX = "urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
  private static final String CODE_REGEX = "[^\\s]+( [^\\s]+)*";
  private static final String OID_REGEX = "urn:oid:[0-2](\\.(0|[1-9][0-9]*))+";
  private static final String ID_REGEX = "[A-Za-z0-9\\-\\.]{1,64}";

  private static boolean hasFormat(String regex, String s) {
    Boolean ok = PrimitiveRegexes.matchesRegex(regex, s);
    if (ok == null) {
      throw new Error("No hand written equivalent for the regex " + regex);
    }
    return ok;
  }

  /** base64, allowing whitespace (the same decoding the parsers use) */
  private static boolean isBase64(String s) {
    try {
      Utilities.decodeBase64(s, false);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  /** hh:mm:ss with optional fractional seconds (up to 9 digits) - the spec's regex for time */
  private static boolean isTime(String s) {
    if (s.length() < 8 || s.charAt(2) != ':' || s.charAt(5) != ':') {
      return false;
    }
    if (!isDigits(s, 0, 2) || !isDigits(s, 3, 5) || !isDigits(s, 6, 8)) {
      return false;
    }
    int hh = Integer.parseInt(s.substring(0, 2));
    int mm = Integer.parseInt(s.substring(3, 5));
    int ss = Integer.parseInt(s.substring(6, 8));
    if (hh > 23 || mm > 59 || ss > 60) {
      return false;
    }
    if (s.length() == 8) {
      return true;
    }
    return s.charAt(8) == '.' && s.length() > 9 && s.length() <= 18 && isDigits(s, 9, s.length());
  }

  private static boolean isDigits(String s, int start, int end) {
    for (int i = start; i < end; i++) {
      if (!Character.isDigit(s.charAt(i)) || s.charAt(i) > '9') {
        return false;
      }
    }
    return true;
  }

  /**
   * copy the id and extensions of the source primitive to the new one, so that a conversion
   * between primitive types doesn't lose them
   */
  private static void copyIdAndExtensions(Base src, PrimitiveType<?> tgt) {
    if (src instanceof Element) {
      Element e = (Element) src;
      tgt.setId(e.getId());
      for (Extension ext : e.getExtensionList()) {
        tgt.addExtension(ext.copy(Base.COPY_DATA));
      }
    }
  }

  /** a 32 bit integer, no less than min (Utilities.isInteger alone doesn't catch all overflows) */
  private static boolean isInteger(String s, int min) {
    if (!Utilities.isInteger(s)) {
      return false;
    }
    try {
      return Integer.parseInt(s) >= min;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isInteger64(String s) {
    if (!Utilities.isLong(s)) {
      return false;
    }
    try {
      Long.parseLong(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /** the date/time classes check the format when they are given a value */
  private static boolean parses(PrimitiveType<?> t, String s) {
    try {
      t.setValueAsString(s);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean containsWhitespace(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isWhitespace(c)) {
        return true;
      }
    }
    return false;
  }

  public static Annotation castToAnnotation(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Annotation)
      return (Annotation) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Annotation");
  }
  
  public static Dosage castToDosage(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Dosage)
      return (Dosage) b;
    else      
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an DosageInstruction");
  }
  
  
  public static Attachment castToAttachment(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Attachment)
      return (Attachment) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Attachment");
  }
  
  public static Identifier castToIdentifier(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Identifier)
      return (Identifier) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Identifier");
  }
  
  public static CodeableConcept castToCodeableConcept(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof CodeableConcept)
      return (CodeableConcept) b;
    else if (b.isMetadataBased()) {
      return castToCodeableConcept(b.asType());
    } else if (b instanceof CodeType) {
      CodeableConcept cc = new CodeableConcept();
      cc.addCoding().setCode(((CodeType) b).asStringValue());
      return cc;
    } else if(b instanceof StringType) {
      CodeableConcept cc = new CodeableConcept();
      cc.addCoding().setCode(((StringType) b).asStringValue());
      return cc;
    } else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a CodeableConcept");
  }
  
  public static CodeableReference castToCodeableReference(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof CodeableReference) {
      return (CodeableReference) b;
    } else if (b instanceof CodeType) {
      CodeableReference cc = new CodeableReference();
      cc.getConcept().addCoding().setCode(((CodeType) b).asStringValue());
      return cc;
    } else if (b instanceof Reference) {
      CodeableReference cc = new CodeableReference();
      cc.setReference((Reference) b);
      return cc;
    } else if(b instanceof StringType) {
      CodeableReference cc = new CodeableReference();
      cc.getConcept().addCoding().setCode(((StringType) b).asStringValue());
      return cc;
    } else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a CodeableConcept");
  }
  
  public static Coding castToCoding(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Coding)
      return (Coding) b;
    else if (b.isMetadataBased()) {
      ICoding c = b.getAsICoding();
      if (c != null) {
        return new Coding().setCode(c.getCode()).setSystem(c.getSystem()).setVersion(c.getVersion()).setDisplay(c.getDisplay());
      }
      return castToCoding(b.asType());
    } else if (b instanceof ICoding) {
      ICoding c = (ICoding) b;
      return new Coding().setCode(c.getCode()).setSystem(c.getSystem()).setVersion(c.getVersion()).setDisplay(c.getDisplay());
    } else if (b instanceof PrimitiveType<?>) {
      PrimitiveType<?> p = (PrimitiveType<?>) b;
      Coding cc = new Coding();
      cc.setCode(b.primitiveValue()).setId(p.getId()).getExtension().addAll(p.getExtension());
      return cc;
    } else if (b.isPrimitive()) {  
      return new Coding().setCode(b.primitiveValue());
    } else {
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Coding");
    }
  }
  
  public static Quantity castToQuantity(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Quantity)
      return (Quantity) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Quantity");
  }
  
  public static Count castToCount(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Count)
      return (Count) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Count");
  }
  
  public static Money castToMoney(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Money)
      return (Money) b;
    else if (b.isMetadataBased() && Utilities.tail(b.fhirType()).equals("Money"))
      return castToMoney(b.asType());
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Money");
  }
  
  public static Duration castToDuration(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Duration)
      return (Duration) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an Duration");
  }
  
  public static SimpleQuantity castToSimpleQuantity(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof SimpleQuantity)
      return (SimpleQuantity) b;
    else if (b instanceof Quantity) {
      Quantity q = (Quantity) b;
      SimpleQuantity sq = new SimpleQuantity();
      sq.setValueElement(q.getValueElement());
      sq.setComparatorElement(q.getComparatorElement());
      sq.setUnitElement(q.getUnitElement());
      sq.setSystemElement(q.getSystemElement());
      sq.setCodeElement(q.getCodeElement());
      return sq;
    } else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to an SimpleQuantity");
  }
  
  public static Range castToRange(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Range)
      return (Range) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Range");
  }
  
  public static Period castToPeriod(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Period)
      return (Period) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Period");
  }
  
  public static Ratio castToRatio(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Ratio)
      return (Ratio) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Ratio");
  }
  
  public static SampledData castToSampledData(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof SampledData)
      return (SampledData) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a SampledData");
  }
  
  public static Signature castToSignature(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Signature)
      return (Signature) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Signature");
  }
  
  public static HumanName castToHumanName(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof HumanName)
      return (HumanName) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a HumanName");
  }
  
  public static Address castToAddress(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Address)
      return (Address) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Address");
  }
  
  public static ContactDetail castToContactDetail(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof ContactDetail)
      return (ContactDetail) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a ContactDetail");
  }


  public static UsageContext castToUsageContext(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof UsageContext)
      return (UsageContext) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a UsageContext");
  }

  public static RelatedArtifact castToRelatedArtifact(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof RelatedArtifact)
      return (RelatedArtifact) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a RelatedArtifact");
  }

  public static ContactPoint castToContactPoint(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof ContactPoint)
      return (ContactPoint) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a ContactPoint");
  }
  
  public static Timing castToTiming(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Timing)
      return (Timing) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Timing");
  }
  
  public static Reference castToReference(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Reference)
      return (Reference) b;
    else if (b.isMetadataBased() && Utilities.tail(b.fhirType()).equals("Reference"))
      return castToReference(b.asType());
    else if (b.isPrimitive() && Utilities.isURL(b.primitiveValue()))
      return new Reference().setReference(b.primitiveValue());
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Reference");
  }
  
  public static Meta castToMeta(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Meta)
      return (Meta) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Meta");
  }
    
  
  public static MarketingStatus castToMarketingStatus(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof MarketingStatus)
      return (MarketingStatus) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a MarketingStatus");
  }

  
  public static ProductShelfLife castToProductShelfLife(Base b) throws FHIRException {   
    if (b == null) {
      return null;
    }

    if (b instanceof ProductShelfLife)
      return (ProductShelfLife) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a ProductShelfLife");
  }


  public static Extension castToExtension(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Extension)
      return (Extension) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Extension");
  }
  
  public static Resource castToResource(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Resource)
      return (Resource) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Resource");
  }
  
  public static Narrative castToNarrative(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Narrative)
      return (Narrative) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Narrative");
  }
  
  
  public static ElementDefinition castToElementDefinition(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof ElementDefinition)
      return (ElementDefinition) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a ElementDefinition");
  }

  public static DataRequirement castToDataRequirement(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof DataRequirement)
      return (DataRequirement) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a DataRequirement");
  }

  public static Expression castToExpression(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Expression)
      return (Expression) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Expression");
  }

  
  public static ParameterDefinition castToParameterDefinition(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof ParameterDefinition)
      return (ParameterDefinition) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a ParameterDefinition");
  }

  public static TriggerDefinition castToTriggerDefinition(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof TriggerDefinition)
      return (TriggerDefinition) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a TriggerDefinition");
  }
  
  public static ExtendedContactDetail castToExtendedContactDetail(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof ExtendedContactDetail)
      return (ExtendedContactDetail) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a ExtendedContactDetail");
  }
  
  
  

  public static XhtmlNode castToXhtml(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Element) {
      return ((Element) b).getXhtml();
    } else if (b instanceof XhtmlType) {
      return ((XhtmlType) b).getXhtml();
    } else if (b instanceof StringType) {
      try {
        return new XhtmlParser().parseFragment(((StringType) b).asStringValue());
      } catch (IOException e) {
        throw new FHIRException(e);
      }
    } else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to XHtml");
  }
  
  public static String castToXhtmlString(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof XhtmlType) {
      return new XhtmlComposer(true).compose(((XhtmlType) b).getXhtml());
    } else if (b instanceof StringType) {
      return ((StringType) b).asStringValue();
    } else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to XHtml string");
  }


  public static VirtualServiceDetail castToVirtualServiceDetail(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof VirtualServiceDetail)
      return (VirtualServiceDetail) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a VirtualServiceDetail");
  }


  public static Availability castToAvailability(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof Availability)
      return (Availability) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a Availability");
  }


  public static MonetaryComponent castToMonetaryComponent(Base b) throws FHIRException {
    if (b == null) {
      return null;
    }

    if (b instanceof MonetaryComponent)
      return (MonetaryComponent) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a MonetaryComponent");
  }

  public static DosageCondition castToDosageCondition(Base b) {
    if (b == null) {
      return null;
    }

    if (b instanceof DosageCondition)
      return (DosageCondition) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a DosageCondition");
  }

  public static DosageSafety castToDosageSafety(Base b) {
    if (b == null) {
      return null;
    }

    if (b instanceof DosageSafety)
      return (DosageSafety) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a DosageSafety");
  }

  public static RelativeTime castToRelativeTime(Base b) {
    if (b == null) {
      return null;
    }

    if (b instanceof RelativeTime)
      return (RelativeTime) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a RelativeTime");
  }

  public static DosageDetails castToDosageDetails(Base b) {
    if (b == null) {
      return null;
    }

    if (b instanceof DosageDetails)
      return (DosageDetails) b;
    else
      throw new FHIRException("Unable to convert a "+b.fhirType()+"("+b.getClass().getName()+") to a DosageDetails");
  }
}