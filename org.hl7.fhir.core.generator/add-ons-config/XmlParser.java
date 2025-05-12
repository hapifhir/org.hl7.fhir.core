package {{pid}};

// generated

{{license}}

{{startMark}}

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.formats.*;
import org.xmlpull.v1.*;
import org.hl7.fhir.utilities.xml.IXMLWriter;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.FHIRException;
import java.io.IOException;
import java.util.Enumeration;

public class {{jname}}XmlParser extends org.hl7.fhir.r5.formats.XmlParser {

  public {{jname}}XmlParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  public {{jname}}XmlParser(IXMLWriter xml) {
    super();
    this.xml = xml;
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