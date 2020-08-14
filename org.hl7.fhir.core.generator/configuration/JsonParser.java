package org.hl7.fhir.r5.formats;

// generated

{{license}}

{{startMark}}

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.json.JsonTrackingParser.PresentedBigDecimal;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.IOException;

public class JsonParser extends JsonParserBase {

  public JsonParser() {
    super();
  }

  public JsonParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  public JsonParser(boolean allowUnknownContent, boolean allowComments) {
    super();
    setAllowUnknownContent(allowUnknownContent);
    setAllowComments(allowComments);
  }

  protected void parseBaseProperties(JsonObject json, Base res) throws IOException, FHIRFormatError {
    // nothing
  }

  @SuppressWarnings("unchecked")
  protected <E extends Enum<E>> Enumeration<E> parseEnumeration(String s, E item, EnumFactory e) throws IOException, FHIRFormatError {
    Enumeration<E> res = new Enumeration<E>(e);
    if (s != null)
      res.setValue((E) e.fromCode(s));
    return res;
  }

  protected DateType parseDate(String v) throws IOException, FHIRFormatError {
    DateType res = new DateType(v);
    return res;
  }

  protected DateTimeType parseDateTime(String v) throws IOException, FHIRFormatError {
    DateTimeType res = new DateTimeType(v);
    return res;
  }

  protected CodeType parseCode(String v) throws IOException, FHIRFormatError {
    CodeType res = new CodeType(v);
    return res;
  }

  protected StringType parseString(String v) throws IOException, FHIRFormatError {
    StringType res = new StringType(v);
    return res;
  }

  protected IntegerType parseInteger(java.lang.Long v) throws IOException, FHIRFormatError {
    IntegerType res = new IntegerType(v);
    return res;
  }

  protected Integer64Type parseInteger64(java.lang.Long v) throws IOException, FHIRFormatError {
    Integer64Type res = new Integer64Type(v);
    return res;
  }

  protected OidType parseOid(String v) throws IOException, FHIRFormatError {
    OidType res = new OidType(v);
    return res;
  }

  protected CanonicalType parseCanonical(String v) throws IOException, FHIRFormatError {
    CanonicalType res = new CanonicalType(v);
    return res;
  }

  protected UriType parseUri(String v) throws IOException, FHIRFormatError {
    UriType res = new UriType(v);
    return res;
  }

  protected UuidType parseUuid(String v) throws IOException, FHIRFormatError {
    UuidType res = new UuidType(v);
    return res;
  }

  protected UrlType parseUrl(String v) throws IOException, FHIRFormatError {
    UrlType res = new UrlType(v);
    return res;
  }

  protected InstantType parseInstant(String v) throws IOException, FHIRFormatError {
    InstantType res = new InstantType(v);
    return res;
  }

  protected BooleanType parseBoolean(java.lang.Boolean v) throws IOException, FHIRFormatError {
    BooleanType res = new BooleanType(v);
    return res;
  }

  protected Base64BinaryType parseBase64Binary(String v) throws IOException, FHIRFormatError {
    Base64BinaryType res = new Base64BinaryType(v);
    return res;
  }

  protected UnsignedIntType parseUnsignedInt(String v) throws IOException, FHIRFormatError {
    UnsignedIntType res = new UnsignedIntType(v);
    return res;
  }

  protected MarkdownType parseMarkdown(String v) throws IOException, FHIRFormatError {
    MarkdownType res = new MarkdownType(v);
    return res;
  }

  protected TimeType parseTime(String v) throws IOException, FHIRFormatError {
    TimeType res = new TimeType(v);
    return res;
  }

  protected IdType parseId(String v) throws IOException, FHIRFormatError {
    IdType res = new IdType(v);
    return res;
  }

  protected PositiveIntType parsePositiveInt(String v) throws IOException, FHIRFormatError {
    PositiveIntType res = new PositiveIntType(v);
    return res;
  }

  protected DecimalType parseDecimal(java.math.BigDecimal v) throws IOException, FHIRFormatError {
    DecimalType res = new DecimalType(v);
    if (v instanceof PresentedBigDecimal)
      res.setRepresentation(((PresentedBigDecimal) v).getPresentation());
    return res;
  }



{{parser}}
  
  @Override
  protected Resource parseResource(JsonObject json) throws IOException, FHIRFormatError {
    if (!json.has("resourceType")) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
    }
    String t = json.get("resourceType").getAsString();
    if (Utilities.noString(t)) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
{{parse-resource}}
    } else {
      throw new FHIRFormatError("Unknown.Unrecognised resource type '"+t+"' (in property 'resourceType')");
    }
  }

  protected DataType parseType(String prefix, JsonObject json) throws IOException, FHIRFormatError {
    if (json.has(prefix+"Date") || json.has("_"+prefix+"Date")) {
      DataType t = json.has(prefix+"Date") ? parseDate(json.get(prefix+"Date").getAsString()) : new DateType();
      if (json.has("_"+prefix+"Date"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Date"), t);
      return t;
    }
    else if (json.has(prefix+"DateTime") || json.has("_"+prefix+"DateTime")) {
      DataType t = json.has(prefix+"DateTime") ? parseDateTime(json.get(prefix+"DateTime").getAsString()) : new DateTimeType();
      if (json.has("_"+prefix+"DateTime"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"DateTime"), t);
      return t;
    }
    else if (json.has(prefix+"Code") || json.has("_"+prefix+"Code")) {
      DataType t = json.has(prefix+"Code") ? parseCode(json.get(prefix+"Code").getAsString()) : new CodeType();
      if (json.has("_"+prefix+"Code"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Code"), t);
      return t;
    }
    else if (json.has(prefix+"String") || json.has("_"+prefix+"String")) {
      DataType t = json.has(prefix+"String") ? parseString(json.get(prefix+"String").getAsString()) : new StringType();
      if (json.has("_"+prefix+"String"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"String"), t);
      return t;
    }
    else if (json.has(prefix+"Integer") || json.has("_"+prefix+"Integer")) {
      DataType t = json.has(prefix+"Integer") ? parseInteger(json.get(prefix+"Integer").getAsLong()) : new IntegerType();
      if (json.has("_"+prefix+"Integer"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Integer"), t);
      return t;
    }
    else if (json.has(prefix+"Integer64") || json.has("_"+prefix+"Integer64")) {
      DataType t = json.has(prefix+"Integer64") ? parseInteger64(json.get(prefix+"Integer64").getAsLong()) : new Integer64Type();
      if (json.has("_"+prefix+"Integer64"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Integer64"), t);
      return t;
    }
    else if (json.has(prefix+"Oid") || json.has("_"+prefix+"Oid")) {
      DataType t = json.has(prefix+"Oid") ? parseOid(json.get(prefix+"Oid").getAsString()) : new OidType();
      if (json.has("_"+prefix+"Oid"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Oid"), t);
      return t;
    }
    else if (json.has(prefix+"Canonical") || json.has("_"+prefix+"Canonical")) {
      DataType t = json.has(prefix+"Canonical") ? parseCanonical(json.get(prefix+"Canonical").getAsString()) : new CanonicalType();
      if (json.has("_"+prefix+"Canonical"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Canonical"), t);
      return t;
    }
    else if (json.has(prefix+"Uri") || json.has("_"+prefix+"Uri")) {
      DataType t = json.has(prefix+"Uri") ? parseUri(json.get(prefix+"Uri").getAsString()) : new UriType();
      if (json.has("_"+prefix+"Uri"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Uri"), t);
      return t;
    }
    else if (json.has(prefix+"Uuid") || json.has("_"+prefix+"Uuid")) {
      DataType t = json.has(prefix+"Uuid") ? parseUuid(json.get(prefix+"Uuid").getAsString()) : new UuidType();
      if (json.has("_"+prefix+"Uuid"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Uuid"), t);
      return t;
    }
    else if (json.has(prefix+"Url") || json.has("_"+prefix+"Url")) {
      DataType t = json.has(prefix+"Url") ? parseUrl(json.get(prefix+"Url").getAsString()) : new UrlType();
      if (json.has("_"+prefix+"Url"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Url"), t);
      return t;
    }
    else if (json.has(prefix+"Instant") || json.has("_"+prefix+"Instant")) {
      DataType t = json.has(prefix+"Instant") ? parseInstant(json.get(prefix+"Instant").getAsString()) : new InstantType();
      if (json.has("_"+prefix+"Instant"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Instant"), t);
      return t;
    }
    else if (json.has(prefix+"Boolean") || json.has("_"+prefix+"Boolean")) {
      DataType t = json.has(prefix+"Boolean") ? parseBoolean(json.get(prefix+"Boolean").getAsBoolean()) : new BooleanType();
      if (json.has("_"+prefix+"Boolean"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Boolean"), t);
      return t;
    }
    else if (json.has(prefix+"Base64Binary") || json.has("_"+prefix+"Base64Binary")) {
      DataType t = json.has(prefix+"Base64Binary") ? parseBase64Binary(json.get(prefix+"Base64Binary").getAsString()) : new Base64BinaryType();
      if (json.has("_"+prefix+"Base64Binary"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Base64Binary"), t);
      return t;
    }
    else if (json.has(prefix+"UnsignedInt") || json.has("_"+prefix+"UnsignedInt")) {
      DataType t = json.has(prefix+"UnsignedInt") ? parseUnsignedInt(json.get(prefix+"UnsignedInt").getAsString()) : new UnsignedIntType();
      if (json.has("_"+prefix+"UnsignedInt"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"UnsignedInt"), t);
      return t;
    }
    else if (json.has(prefix+"Markdown") || json.has("_"+prefix+"Markdown")) {
      DataType t = json.has(prefix+"Markdown") ? parseMarkdown(json.get(prefix+"Markdown").getAsString()) : new MarkdownType();
      if (json.has("_"+prefix+"Markdown"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Markdown"), t);
      return t;
    }
    else if (json.has(prefix+"Time") || json.has("_"+prefix+"Time")) {
      DataType t = json.has(prefix+"Time") ? parseTime(json.get(prefix+"Time").getAsString()) : new TimeType();
      if (json.has("_"+prefix+"Time"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Time"), t);
      return t;
    }
    else if (json.has(prefix+"Id") || json.has("_"+prefix+"Id")) {
      DataType t = json.has(prefix+"Id") ? parseId(json.get(prefix+"Id").getAsString()) : new IdType();
      if (json.has("_"+prefix+"Id"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Id"), t);
      return t;
    }
    else if (json.has(prefix+"PositiveInt") || json.has("_"+prefix+"PositiveInt")) {
      DataType t = json.has(prefix+"PositiveInt") ? parsePositiveInt(json.get(prefix+"PositiveInt").getAsString()) : new PositiveIntType();
      if (json.has("_"+prefix+"PositiveInt"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"PositiveInt"), t);
      return t;
    }
    else if (json.has(prefix+"Decimal") || json.has("_"+prefix+"Decimal")) {
      DataType t = json.has(prefix+"Decimal") ? parseDecimal(json.get(prefix+"Decimal").getAsBigDecimal()) : new DecimalType();
      if (json.has("_"+prefix+"Decimal"))
        parseElementProperties(json.getAsJsonObject("_"+prefix+"Decimal"), t);
      return t;
{{parse-type-pfx}}
    } else {
      return null;
    }
  }

  protected DataType parseAnyType(JsonObject json, String type) throws IOException, FHIRFormatError {
    return parseType(json, type);
  }

  protected DataType parseType(JsonObject json, String type) throws IOException, FHIRFormatError {
    if (Utilities.noString(type)) {
      throw new FHIRFormatError("Unable to parse type - type not specified"); 
{{parse-type}}
    } else {
      throw new FHIRFormatError("Unknown Type "+type);
    }
  }

  protected boolean hasTypeName(JsonObject json, String prefix) {
{{parse-has-type}}
    if (json.has(prefix+"Date") || json.has("_"+prefix+"Date"))
      return true;
    if (json.has(prefix+"DateTime") || json.has("_"+prefix+"DateTime"))
      return true;
    if (json.has(prefix+"Code") || json.has("_"+prefix+"Code"))
      return true;
    if (json.has(prefix+"String") || json.has("_"+prefix+"String"))
      return true;
    if (json.has(prefix+"Integer") || json.has("_"+prefix+"Integer"))
      return true;
    if (json.has(prefix+"Integer64") || json.has("_"+prefix+"Integer64"))
      return true;
    if (json.has(prefix+"Oid") || json.has("_"+prefix+"Oid"))
      return true;
    if (json.has(prefix+"Canonical") || json.has("_"+prefix+"Canonical"))
      return true;
    if (json.has(prefix+"Uri") || json.has("_"+prefix+"Uri"))
      return true;
    if (json.has(prefix+"Uuid") || json.has("_"+prefix+"Uuid"))
      return true;
    if (json.has(prefix+"Url") || json.has("_"+prefix+"Url"))
      return true;
    if (json.has(prefix+"Instant") || json.has("_"+prefix+"Instant"))
      return true;
    if (json.has(prefix+"Boolean") || json.has("_"+prefix+"Boolean"))
      return true;
    if (json.has(prefix+"Base64Binary") || json.has("_"+prefix+"Base64Binary"))
      return true;
    if (json.has(prefix+"UnsignedInt") || json.has("_"+prefix+"UnsignedInt"))
      return true;
    if (json.has(prefix+"Markdown") || json.has("_"+prefix+"Markdown"))
      return true;
    if (json.has(prefix+"Time") || json.has("_"+prefix+"Time"))
      return true;
    if (json.has(prefix+"Id") || json.has("_"+prefix+"Id"))
      return true;
    if (json.has(prefix+"PositiveInt") || json.has("_"+prefix+"PositiveInt"))
      return true;
    if (json.has(prefix+"Decimal") || json.has("_"+prefix+"Decimal"))
      return true;
    return false;
  }

// -- compose ---------------------------------------------------------------------------------------------------------------------

  protected void composeBaseProperties(Base element) throws IOException {
  }


  protected <E extends Enum<E>> void composeEnumerationCore(String name, Enumeration<E> value, EnumFactory e, boolean inArray) throws IOException {
    if (value != null && value.getValue() != null) {
      prop(name, e.toCode(value.getValue()));
    } else if (inArray)   
      writeNull(name);
  }    

  protected <E extends Enum<E>> void composeEnumerationExtras(String name, Enumeration<E> value, EnumFactory e, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    } else if (inArray)   
      writeNull(name);
  }    

  protected void composeDateCore(String name, DateType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.asStringValue());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeDateExtras(String name, DateType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeDateTimeCore(String name, DateTimeType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.asStringValue());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeDateTimeExtras(String name, DateTimeType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeCodeCore(String name, CodeType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeCodeExtras(String name, CodeType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeStringCore(String name, StringType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeStringExtras(String name, StringType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeIntegerCore(String name, IntegerType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, Integer.valueOf(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeIntegerExtras(String name, IntegerType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeInteger64Core(String name, Integer64Type value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.getValue().toString());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeInteger64Extras(String name, Integer64Type value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeOidCore(String name, OidType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeOidExtras(String name, OidType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeCanonicalCore(String name, CanonicalType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeCanonicalExtras(String name, CanonicalType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeUriCore(String name, UriType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeUriExtras(String name, UriType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeUuidCore(String name, UuidType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeUuidExtras(String name, UuidType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeUrlCore(String name, UrlType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeUrlExtras(String name, UrlType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeInstantCore(String name, InstantType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.asStringValue());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeInstantExtras(String name, InstantType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeBooleanCore(String name, BooleanType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.getValue());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeBooleanExtras(String name, BooleanType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeBase64BinaryCore(String name, Base64BinaryType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeBase64BinaryExtras(String name, Base64BinaryType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeUnsignedIntCore(String name, UnsignedIntType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, Integer.valueOf(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeUnsignedIntExtras(String name, UnsignedIntType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeMarkdownCore(String name, MarkdownType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeMarkdownExtras(String name, MarkdownType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeTimeCore(String name, TimeType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.asStringValue());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeTimeExtras(String name, TimeType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeIdCore(String name, IdType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, toString(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeIdExtras(String name, IdType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composePositiveIntCore(String name, PositiveIntType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, Integer.valueOf(value.getValue()));
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composePositiveIntExtras(String name, PositiveIntType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

  protected void composeDecimalCore(String name, DecimalType value, boolean inArray) throws IOException {
    if (value != null && value.hasValue()) {
        prop(name, value.getValue());
    }    
    else if (inArray) 
      writeNull(name); 
  }    

  protected void composeDecimalExtras(String name, DecimalType value, boolean inArray) throws IOException {
    if (value != null && (!Utilities.noString(value.getId()) || ExtensionHelper.hasExtensions(value) || makeComments(value))) {
      open(inArray ? null : "_"+name);
      composeElementProperties(value);
      close();
    }
    else if (inArray) 
      writeNull(name); 
  }

{{composer}}

  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
{{compose-resource}} 
    } else
      throw new Error("Unhandled resource type "+resource.getClass().getName());
  }

  protected void composeNamedReference(String name, Resource resource) throws IOException {
    if (resource == null) {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
{{compose-resource-named}} 
    } else
      throw new Error("Unhandled resource type "+resource.getClass().getName());
  }

  protected void composeType(String prefix, DataType type) throws IOException {
    if (type == null) {
      ;
{{compose-type}} 
    } else if (type instanceof CodeType) {
      composeCodeCore(prefix+"Code", (CodeType) type, false);
      composeCodeExtras(prefix+"Code", (CodeType) type, false);
    }
    else if (type instanceof OidType) {
      composeOidCore(prefix+"Oid", (OidType) type, false);
      composeOidExtras(prefix+"Oid", (OidType) type, false);
    }
    else if (type instanceof CanonicalType) {
      composeCanonicalCore(prefix+"Canonical", (CanonicalType) type, false);
      composeCanonicalExtras(prefix+"Canonical", (CanonicalType) type, false);
    }
    else if (type instanceof UuidType) {
      composeUuidCore(prefix+"Uuid", (UuidType) type, false);
      composeUuidExtras(prefix+"Uuid", (UuidType) type, false);
    }
    else if (type instanceof UrlType) {
      composeUrlCore(prefix+"Url", (UrlType) type, false);
      composeUrlExtras(prefix+"Url", (UrlType) type, false);
    }
    else if (type instanceof UnsignedIntType) {
      composeUnsignedIntCore(prefix+"UnsignedInt", (UnsignedIntType) type, false);
      composeUnsignedIntExtras(prefix+"UnsignedInt", (UnsignedIntType) type, false);
    }
    else if (type instanceof MarkdownType) {
      composeMarkdownCore(prefix+"Markdown", (MarkdownType) type, false);
      composeMarkdownExtras(prefix+"Markdown", (MarkdownType) type, false);
    }
    else if (type instanceof IdType) {
      composeIdCore(prefix+"Id", (IdType) type, false);
      composeIdExtras(prefix+"Id", (IdType) type, false);
    }
    else if (type instanceof PositiveIntType) {
      composePositiveIntCore(prefix+"PositiveInt", (PositiveIntType) type, false);
      composePositiveIntExtras(prefix+"PositiveInt", (PositiveIntType) type, false);
    }
    else if (type instanceof DateType) {
      composeDateCore(prefix+"Date", (DateType) type, false);
      composeDateExtras(prefix+"Date", (DateType) type, false);
    }
    else if (type instanceof DateTimeType) {
      composeDateTimeCore(prefix+"DateTime", (DateTimeType) type, false);
      composeDateTimeExtras(prefix+"DateTime", (DateTimeType) type, false);
    }
    else if (type instanceof StringType) {
      composeStringCore(prefix+"String", (StringType) type, false);
      composeStringExtras(prefix+"String", (StringType) type, false);
    }
    else if (type instanceof IntegerType) {
      composeIntegerCore(prefix+"Integer", (IntegerType) type, false);
      composeIntegerExtras(prefix+"Integer", (IntegerType) type, false);
    }
    else if (type instanceof Integer64Type) {
      composeInteger64Core(prefix+"Integer64", (Integer64Type) type, false);
      composeInteger64Extras(prefix+"Integer64", (Integer64Type) type, false);
    }
    else if (type instanceof UriType) {
      composeUriCore(prefix+"Uri", (UriType) type, false);
      composeUriExtras(prefix+"Uri", (UriType) type, false);
    }
    else if (type instanceof InstantType) {
      composeInstantCore(prefix+"Instant", (InstantType) type, false);
      composeInstantExtras(prefix+"Instant", (InstantType) type, false);
    }
    else if (type instanceof BooleanType) {
      composeBooleanCore(prefix+"Boolean", (BooleanType) type, false);
      composeBooleanExtras(prefix+"Boolean", (BooleanType) type, false);
    }
    else if (type instanceof Base64BinaryType) {
      composeBase64BinaryCore(prefix+"Base64Binary", (Base64BinaryType) type, false);
      composeBase64BinaryExtras(prefix+"Base64Binary", (Base64BinaryType) type, false);
    }
    else if (type instanceof TimeType) {
      composeTimeCore(prefix+"Time", (TimeType) type, false);
      composeTimeExtras(prefix+"Time", (TimeType) type, false);
    }
    else if (type instanceof DecimalType) {
      composeDecimalCore(prefix+"Decimal", (DecimalType) type, false);
      composeDecimalExtras(prefix+"Decimal", (DecimalType) type, false);
    } else
      throw new Error("Unhandled type");
  }

  protected void composeTypeInner(DataType type) throws IOException {
    if (type == null) {
      ;
{{compose-type-inner}} 
    } else
      throw new Error("Unhandled type: "+type.fhirType());
  }

}