package org.hl7.fhir.r5.formats;

// generated

{{license}}

{{startMark}}

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.xmlpull.v1.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.FHIRException;
import java.io.IOException;

public class XmlParser extends XmlParserBase {

  public XmlParser() {
    super();
  }

  public XmlParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  protected boolean parseBaseContent(int eventType, XmlPullParser xpp, Base res) throws XmlPullParserException, IOException, FHIRFormatError {
    return false;
  }

  @SuppressWarnings("unchecked")
  protected <E extends Enum<E>> Enumeration<E> parseEnumeration(XmlPullParser xpp, E item, EnumFactory e) throws XmlPullParserException, IOException, FHIRFormatError {
    Enumeration<E> res = new Enumeration<E>(e);
    parseElementAttributes(xpp, res);
    res.setValue((E) e.fromCode(xpp.getAttributeValue(null, "value")));
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected DateType parseDate(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DateType res = new DateType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected DateTimeType parseDateTime(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DateTimeType res = new DateTimeType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected CodeType parseCode(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CodeType res = new CodeType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected StringType parseString(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    StringType res = new StringType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected IntegerType parseInteger(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    IntegerType res = new IntegerType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected Integer64Type parseInteger64(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    Integer64Type res = new Integer64Type(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected OidType parseOid(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    OidType res = new OidType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected CanonicalType parseCanonical(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CanonicalType res = new CanonicalType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected UriType parseUri(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    UriType res = new UriType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected UuidType parseUuid(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    UuidType res = new UuidType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected UrlType parseUrl(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    UrlType res = new UrlType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected InstantType parseInstant(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    InstantType res = new InstantType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected BooleanType parseBoolean(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    BooleanType res = new BooleanType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected Base64BinaryType parseBase64Binary(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    Base64BinaryType res = new Base64BinaryType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected UnsignedIntType parseUnsignedInt(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    UnsignedIntType res = new UnsignedIntType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected MarkdownType parseMarkdown(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    MarkdownType res = new MarkdownType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected TimeType parseTime(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TimeType res = new TimeType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected IdType parseId(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    IdType res = new IdType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected PositiveIntType parsePositiveInt(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    PositiveIntType res = new PositiveIntType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected DecimalType parseDecimal(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    DecimalType res = new DecimalType(xpp.getAttributeValue(null, "value"));
    parseElementAttributes(xpp, res);
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

{{parser}}
  
  @Override
  protected Resource parseResource(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    if (xpp == null) {
      throw new IOException("xpp == null!");
{{parse-resource}}
    } else {
      throw new FHIRFormatError("Unknown resource type "+xpp.getName()+"");
    }
  }

  protected DataType parseType(String prefix, XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    if (prefix == null) {
      throw new IOException("prefix == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (xpp.getName().equals(prefix+"Date")) {
      return parseDate(xpp);
    } else if (xpp.getName().equals(prefix+"DateTime")) {
      return parseDateTime(xpp);
    } else if (xpp.getName().equals(prefix+"Code")) {
      return parseCode(xpp);
    } else if (xpp.getName().equals(prefix+"String")) {
      return parseString(xpp);
    } else if (xpp.getName().equals(prefix+"Integer")) {
      return parseInteger(xpp);
    } else if (xpp.getName().equals(prefix+"Integer64")) {
      return parseInteger64(xpp);
    } else if (xpp.getName().equals(prefix+"Oid")) {
      return parseOid(xpp);
    } else if (xpp.getName().equals(prefix+"Canonical")) {
      return parseCanonical(xpp);
    } else if (xpp.getName().equals(prefix+"Uri")) {
      return parseUri(xpp);
    } else if (xpp.getName().equals(prefix+"Uuid")) {
      return parseUuid(xpp);
    } else if (xpp.getName().equals(prefix+"Url")) {
      return parseUrl(xpp);
    } else if (xpp.getName().equals(prefix+"Instant")) {
      return parseInstant(xpp);
    } else if (xpp.getName().equals(prefix+"Boolean")) {
      return parseBoolean(xpp);
    } else if (xpp.getName().equals(prefix+"Base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (xpp.getName().equals(prefix+"UnsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (xpp.getName().equals(prefix+"Markdown")) {
      return parseMarkdown(xpp);
    } else if (xpp.getName().equals(prefix+"Time")) {
      return parseTime(xpp);
    } else if (xpp.getName().equals(prefix+"Id")) {
      return parseId(xpp);
    } else if (xpp.getName().equals(prefix+"PositiveInt")) {
      return parsePositiveInt(xpp);
    } else if (xpp.getName().equals(prefix+"Decimal")) {
      return parseDecimal(xpp);
{{parse-type-prefix}}
    } else {
      throw new FHIRFormatError("Unknown type "+xpp.getName());
    }
  }

  protected DataType parseType(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    if (type == null) {
      throw new IOException("type == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (type.equals("date")) {
      return parseDate(xpp);
    } else if (type.equals("dateTime")) {
      return parseDateTime(xpp);
    } else if (type.equals("code")) {
      return parseCode(xpp);
    } else if (type.equals("string")) {
      return parseString(xpp);
    } else if (type.equals("integer")) {
      return parseInteger(xpp);
    } else if (type.equals("integer64")) {
      return parseInteger64(xpp);
    } else if (type.equals("oid")) {
      return parseOid(xpp);
    } else if (type.equals("canonical")) {
      return parseCanonical(xpp);
    } else if (type.equals("uri")) {
      return parseUri(xpp);
    } else if (type.equals("uuid")) {
      return parseUuid(xpp);
    } else if (type.equals("url")) {
      return parseUrl(xpp);
    } else if (type.equals("instant")) {
      return parseInstant(xpp);
    } else if (type.equals("boolean")) {
      return parseBoolean(xpp);
    } else if (type.equals("base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (type.equals("unsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (type.equals("markdown")) {
      return parseMarkdown(xpp);
    } else if (type.equals("time")) {
      return parseTime(xpp);
    } else if (type.equals("id")) {
      return parseId(xpp);
    } else if (type.equals("positiveInt")) {
      return parsePositiveInt(xpp);
    } else if (type.equals("decimal")) {
      return parseDecimal(xpp);
{{parse-type}}
    } else {
      throw new FHIRFormatError("Unknown type "+type);
    }
  }

  public Base parseFragment(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    if (type == null) {
      throw new IOException("type == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
{{parse-fragment}}      
    } else if (type.equals("date")) {
      return parseDate(xpp);
    } else if (type.equals("dateTime")) {
      return parseDateTime(xpp);
    } else if (type.equals("code")) {
      return parseCode(xpp);
    } else if (type.equals("string")) {
      return parseString(xpp);
    } else if (type.equals("integer")) {
      return parseInteger(xpp);
    } else if (type.equals("integer64")) {
      return parseInteger64(xpp);
    } else if (type.equals("oid")) {
      return parseOid(xpp);
    } else if (type.equals("canonical")) {
      return parseCanonical(xpp);
    } else if (type.equals("uri")) {
      return parseUri(xpp);
    } else if (type.equals("uuid")) {
      return parseUuid(xpp);
    } else if (type.equals("url")) {
      return parseUrl(xpp);
    } else if (type.equals("instant")) {
      return parseInstant(xpp);
    } else if (type.equals("boolean")) {
      return parseBoolean(xpp);
    } else if (type.equals("base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (type.equals("unsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (type.equals("markdown")) {
      return parseMarkdown(xpp);
    } else if (type.equals("time")) {
      return parseTime(xpp);
    } else if (type.equals("id")) {
      return parseId(xpp);
    } else if (type.equals("positiveInt")) {
      return parsePositiveInt(xpp);
    } else if (type.equals("decimal")) {
      return parseDecimal(xpp);
    } else {
      throw new FHIRFormatError("Unknown type "+type);
    }
  }

  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) throws IOException {  
    if (prefix == null) {
      throw new IOException("prefix == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
{{check-type}}
    } else if (xpp.getName().equals(prefix+"Date")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DateTime")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Code")) {
      return true;
    } else if (xpp.getName().equals(prefix+"String")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Integer")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Integer64")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Oid")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Canonical")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Uri")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Uuid")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Url")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Instant")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Boolean")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Base64Binary")) {
      return true;
    } else if (xpp.getName().equals(prefix+"UnsignedInt")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Markdown")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Time")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Id")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PositiveInt")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Decimal")) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected DataType parseAnyType(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    return parseType(xpp, type);
  }


//----------------- Composer -------------------------------------------------------------------------------------------

  protected <E extends Enum<E>> void composeEnumeration(String name, Enumeration<E> value, EnumFactory e) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", e.toCode(value.getValue()));
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeDate(String name, DateType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {// date
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeDateTime(String name, DateTimeType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {// dateTime
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeCode(String name, CodeType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// code
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeString(String name, StringType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// string
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeInteger(String name, IntegerType value) throws IOException  {
    if (value != null) { // integer
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeInteger64(String name, Integer64Type value) throws IOException  {
    if (value != null) { // integer
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeOid(String name, OidType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// oid
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeCanonical(String name, CanonicalType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// canonical
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeUri(String name, UriType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {// uri
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeUuid(String name, UuidType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// uuid
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeUrl(String name, UrlType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// url
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeInstant(String name, InstantType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {// instant
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeBoolean(String name, BooleanType value) throws IOException  {
    if (value != null) { // boolean
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeBase64Binary(String name, Base64BinaryType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {// base64Binary
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeUnsignedInt(String name, UnsignedIntType value) throws IOException  {
    if (value != null) { // unsignedInt
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeMarkdown(String name, MarkdownType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// markdown
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeTime(String name, TimeType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// time
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeId(String name, IdType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || !Utilities.noString(value.getValue()))) {// id
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composePositiveInt(String name, PositiveIntType value) throws IOException  {
    if (value != null) { // positiveInt
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

  protected void composeDecimal(String name, DecimalType value) throws IOException  {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || value.getValue() != null)) {// decimal
      composeElementAttributes(value);
      if (value.asStringValue() != null) 
        xml.attribute("value", value.asStringValue());
        
      xml.enter(FHIR_NS, name);
      composeElementElements(value);
      composeElementClose(value);
      xml.exit(FHIR_NS, name);
    }    
  }    

{{composer}}

  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new IOException("resource == null");
{{compose-resource}}      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeResource(String name, Resource resource) throws IOException {
    if (name == null) {
      throw new IOException("name == null");
    } else if (resource == null) {
      throw new IOException("resource == null");
{{compose-resource-name}}      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeType(String prefix, DataType type) throws IOException {
    if (prefix == null) {
      throw new IOException("prefix == null");
    } else if (type == null) {
      throw new IOException("type == null");
{{compose-type}}
    } else if (type instanceof CodeType) {
       composeCode(prefix+"Code", (CodeType) type);
    } else if (type instanceof OidType) {
       composeOid(prefix+"Oid", (OidType) type);
    } else if (type instanceof CanonicalType) {
       composeCanonical(prefix+"Canonical", (CanonicalType) type);
    } else if (type instanceof UuidType) {
       composeUuid(prefix+"Uuid", (UuidType) type);
    } else if (type instanceof UrlType) {
       composeUrl(prefix+"Url", (UrlType) type);
    } else if (type instanceof UnsignedIntType) {
       composeUnsignedInt(prefix+"UnsignedInt", (UnsignedIntType) type);
    } else if (type instanceof MarkdownType) {
       composeMarkdown(prefix+"Markdown", (MarkdownType) type);
    } else if (type instanceof IdType) {
       composeId(prefix+"Id", (IdType) type);
    } else if (type instanceof PositiveIntType) {
       composePositiveInt(prefix+"PositiveInt", (PositiveIntType) type);
    } else if (type instanceof DateType) {
       composeDate(prefix+"Date", (DateType) type);
    } else if (type instanceof DateTimeType) {
       composeDateTime(prefix+"DateTime", (DateTimeType) type);
    } else if (type instanceof StringType) {
       composeString(prefix+"String", (StringType) type);
    } else if (type instanceof IntegerType) {
      composeInteger(prefix+"Integer", (IntegerType) type);
    } else if (type instanceof Integer64Type) {
      composeInteger64(prefix+"Integer64", (Integer64Type) type);
    } else if (type instanceof UriType) {
       composeUri(prefix+"Uri", (UriType) type);
    } else if (type instanceof InstantType) {
       composeInstant(prefix+"Instant", (InstantType) type);
    } else if (type instanceof BooleanType) {
       composeBoolean(prefix+"Boolean", (BooleanType) type);
    } else if (type instanceof Base64BinaryType) {
       composeBase64Binary(prefix+"Base64Binary", (Base64BinaryType) type);
    } else if (type instanceof TimeType) {
       composeTime(prefix+"Time", (TimeType) type);
    } else if (type instanceof DecimalType) {
       composeDecimal(prefix+"Decimal", (DecimalType) type);
    } else {
      throw new Error("Unhandled type "+type.fhirType());
    }
  }

}