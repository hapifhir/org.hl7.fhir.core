package org.hl7.fhir.utilities.json.parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonBoolean;
import org.hl7.fhir.utilities.json.model.JsonComment;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonElementType;
import org.hl7.fhir.utilities.json.model.JsonLocationData;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonNumber;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonPrimitive;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.model.JsonString;
import org.hl7.fhir.utilities.json.parser.JsonLexer.State;
import org.hl7.fhir.utilities.json.parser.JsonLexer.TokenType;

/**
 * Simple parser for JSON. This parser is not particularly quick (though it's not slow)
 * The focus for this parser is to faithfully record the line/col number of json elements
 * so that the FHIR validator can report issues by line number 
 * 
 * Also, for the validator, the parser will accept duplicate property names 
 * 
 * JSON5: When running in Json5 mode, the parser accepts
 *   * unquoted strings for both fields and values 
 *   * missing commas in objects and arrays 
 *   * comments - anything starting // will be processed as a comma to the end of the line
 *   
 * Other JSON5 features might be added in the future
 *   
 * The FHIR Validator uses this parser in Json5 mode, and the object model is marked up 
 * with deviations from base JSON spec so that the validator can record them as errors 
 * (this is better than blowing up parsing the JSON)
 *   
 * @author grahamegrieve
 *
 */
public class JsonParser {

  public static JsonObject parseObject(InputStream stream) throws IOException, JsonException {
    return parseObject(TextFile.streamToString(stream));
  }
  
  public static JsonObject parseObject(byte[] stream) throws IOException, JsonException {
    return parseObject(TextFile.bytesToString(stream));
  }

  public static JsonObject parseObject(String source) throws IOException, JsonException {
    return parseObject(source, false);
  }
  
  public static JsonObject parseObject(File source) throws IOException, JsonException {
    return parseObject(TextFile.fileToString(source));
  }
  
  public static JsonObject parseObjectFromFile(String source) throws IOException, JsonException {
    return parseObject(TextFile.fileToString(source));
  }
  
  public static JsonObject parseObjectFromUrl(String source) throws IOException, JsonException {
    return parseObject(fetch(source));
  }
  
  public static JsonObject parseObject(InputStream stream, boolean isJson5) throws IOException, JsonException {
    return parseObject(TextFile.streamToString(stream), isJson5);
  }
  
  public static JsonObject parseObject(byte[] stream, boolean isJson5) throws IOException, JsonException {
    return parseObject(TextFile.bytesToString(stream), isJson5);
  }
    
  public static JsonObject parseObject(String source, boolean isJson5) throws IOException, JsonException {
    return parseObject(source, isJson5, false);
  }
  
  public static JsonObject parseObjectFromUrl(String source, boolean isJson5) throws IOException, JsonException {
    return parseObject(fetch(source), isJson5);
  }
  
  public static JsonObject parseObject(InputStream stream, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    return parseObject(TextFile.streamToString(stream), isJson5, allowDuplicates);
  }
  
  public static JsonObject parseObject(byte[] stream, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    return parseObject(TextFile.bytesToString(stream), isJson5, allowDuplicates);
  }
    
  public static JsonObject parseObject(String source, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    return new JsonParser().parseJsonObject(source, isJson5, allowDuplicates);
  }
  
  // ================================================================
  
  public static JsonElement parse(InputStream stream) throws IOException, JsonException {
    return parse(TextFile.streamToString(stream));
  }
  
  public static JsonElement parse(byte[] stream) throws IOException, JsonException {
    return parse(TextFile.bytesToString(stream));
  }

  public static JsonElement parse(String source) throws IOException, JsonException {
    return parse(source, false);
  }
  
  public static JsonElement parse(File source) throws IOException, JsonException {
    return parse(TextFile.fileToString(source));
  }
  
  public static JsonElement parseFromFile(String source) throws IOException, JsonException {
    return parse(TextFile.fileToString(source));
  }
  
  public static JsonElement parseFromUrl(String source) throws IOException, JsonException {
    return parse(fetch(source));
  }
  
  public static JsonElement parse(InputStream stream, boolean isJson5) throws IOException, JsonException {
    return parse(TextFile.streamToString(stream), isJson5);
  }
  
  public static JsonElement parse(byte[] stream, boolean isJson5) throws IOException, JsonException {
    return parse(TextFile.bytesToString(stream), isJson5);
  }
    
  public static JsonElement parse(String source, boolean isJson5) throws IOException, JsonException {
    return parse(source, isJson5, false);
  }
  
  public static JsonElement parseFromUrl(String source, boolean isJson5) throws IOException, JsonException {
    return parse(fetch(source), isJson5);
  }
  
  public static JsonElement parse(InputStream stream, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    return parse(TextFile.streamToString(stream), isJson5, allowDuplicates);
  }
  
  public static JsonElement parse(byte[] stream, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    return parse(TextFile.bytesToString(stream), isJson5, allowDuplicates);
  }
    
  public static JsonElement parse(String source, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    return new JsonParser().parseJsonElement(source, isJson5, allowDuplicates);
  }
  

  // ================================================================
  
  public static String compose(JsonElement element) {
    return compose(element, false);
  }
  
  public static void compose(JsonElement element, OutputStream stream) throws IOException {
    compose(element, stream, false);    
  }
  
  public static void compose(JsonElement element, File file) throws IOException {
    FileOutputStream fo = new FileOutputStream(file);
    compose(element, fo, false);
    fo.close();
  }
  
  public static byte[] composeBytes(JsonElement element) {
    return composeBytes(element, false);    
  }

  public static String compose(JsonElement element, boolean pretty) {
    return new JsonParser().write(element, pretty);
  }

  public static void compose(JsonElement element, OutputStream stream, boolean pretty) throws IOException {
    byte[] cnt = composeBytes(element, pretty);
    stream.write(cnt);
  }
  public static void compose(JsonElement element, File file, boolean pretty) throws IOException {
    byte[] cnt = composeBytes(element, pretty);
    FileOutputStream fo = new FileOutputStream(file);
    fo.write(cnt);
    fo.close();
  }

  public static byte[] composeBytes(JsonElement element, boolean pretty) {
    String s = compose(element, pretty); 
    return s.getBytes(StandardCharsets.UTF_8);
  }
  
  // ================================================================

  enum ItemType {
    Object, String, Number, Boolean, Array, End, Eof, Null;
  }
  private JsonLexer lexer;
  private ItemType itemType = ItemType.Object;
  private String itemName;
  private String itemValue;
  private boolean allowDuplicates = true;
  private boolean allowComments = false;
  private boolean allowNoComma = false;
  private JsonLocationData startProperty;
  private JsonLocationData endProperty;
  private boolean itemNoComma;
  private boolean allowUnquotedStrings;
  private boolean itemUnquoted;
  private boolean valueUnquoted;

  private JsonObject parseJsonObject(String source, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    this.allowDuplicates = allowDuplicates;
    this.allowComments = isJson5;
    this.allowNoComma = isJson5;
    this.allowUnquotedStrings = isJson5;
    return parseSource(Utilities.stripBOM(source));
  }

  private JsonObject parseSource(String source) throws IOException, JsonException {
    lexer = new JsonLexer(source, allowComments, allowUnquotedStrings);
    JsonObject result = new JsonObject();
    lexer.takeComments(result);
    result.setStart(lexer.getLastLocationAWS().copy());
    if (lexer.getType() == TokenType.Open) {
      lexer.next();
      lexer.getStates().push(new State("", true));
    } 
    else if (lexer.getType() != null) {
      throw lexer.error("Unexpected content at start of JSON: "+lexer.getType().toString());
    } else {
      throw lexer.error("Unexpected content at start of JSON");      
    }

    if (lexer.getType() != TokenType.Close) {
      parseProperty();
      readObject("$", result, true);
    }
    result.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
    return result;
  }
  
  private JsonElement parseJsonElement(String source, boolean isJson5, boolean allowDuplicates) throws IOException, JsonException {
    this.allowDuplicates = allowDuplicates;
    this.allowComments = isJson5;
    this.allowNoComma = isJson5;
    this.allowUnquotedStrings = isJson5;
    return parseSourceElement(Utilities.stripBOM(source));
  }
  
  private JsonElement parseSourceElement(String source) throws IOException, JsonException {
    lexer = new JsonLexer(source, allowComments, allowUnquotedStrings);
    switch (lexer.getType()) {
    case Boolean:
      JsonBoolean bool = new JsonBoolean(lexer.getValue().equals("true"));
      lexer.takeComments(bool);
      bool.setStart(lexer.getLastLocationAWS().copy());
      bool.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
      return bool;   
    case Null:
      JsonNull nll = new JsonNull();
      lexer.takeComments(nll);
      nll.setStart(lexer.getLastLocationAWS().copy());
      nll.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
      return nll;   
    case Number:
      JsonNumber num = new JsonNumber(lexer.getValue());
      lexer.takeComments(num);
      num.setStart(lexer.getLastLocationAWS().copy());
      num.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
      return num;   
    case Open:
      JsonObject obj = new JsonObject();
      lexer.takeComments(obj);
      obj.setStart(lexer.getLastLocationAWS().copy());
      if (lexer.getType() == TokenType.Open) {
        lexer.next();
        lexer.getStates().push(new State("", true));
      } 
      else
        throw lexer.error("Unexpected content at start of JSON: "+lexer.getType().toString());

      if (lexer.getType() != TokenType.Close) {
        parseProperty();
        readObject("$", obj, true);
      }
      obj.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
      return obj;   
    case OpenArray:
      JsonArray arr = new JsonArray();
      lexer.takeComments(arr);
      arr.setStart(lexer.getLastLocationAWS().copy());
      lexer.next();
      lexer.getStates().push(new State("", false));
      if (lexer.getType() != TokenType.CloseArray) {
        parseProperty();
        readArray("$", arr, true);
      }
      arr.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
      return arr; 
    case String:
      JsonString str = new JsonString(lexer.getValue());
      lexer.takeComments(str);
      str.setStart(lexer.getLastLocationAWS().copy());
      str.setEnd(endProperty != null ? endProperty.copy() : lexer.getLocation().copy());
      return str;   
    default:
    }
    throw lexer.error("Unexpected content at start of JSON: "+lexer.getType().toString());    
  }

  private void readObject(String path, JsonObject obj, boolean root) throws IOException, JsonException {
    while (!(itemType == ItemType.End) || (root && (itemType == ItemType.Eof))) {
      obj.setExtraComma(false);
      switch (itemType) {
      case Object:
        JsonObject child = new JsonObject(); //(obj.path+'.'+ItemName);
        child.setStart(startProperty.copy());
        lexer.takeComments(child);
        if (obj.has(itemName) && !allowDuplicates)
          throw lexer.error("Duplicated property name: "+itemName+ " @ "+path);
        obj.addForParser(itemName, child, itemNoComma, itemUnquoted, valueUnquoted);
        next();
        readObject(path+"."+itemName, child, false);
        child.setEnd(endProperty.copy());
        break;
      case Boolean :
        JsonBoolean childB = new JsonBoolean(Boolean.valueOf(itemValue));
        childB.setStart(startProperty.copy());
        lexer.takeComments(childB);
        if (obj.has(itemName) && !allowDuplicates)
          throw lexer.error("Duplicated property name: "+itemName+ " @ "+path);
        obj.addForParser(itemName, childB, itemNoComma, itemUnquoted, valueUnquoted);
        childB.setEnd(endProperty.copy());
        break;
      case String:
        JsonString childS = new JsonString(itemValue);
        childS.setStart(startProperty.copy());
        lexer.takeComments(childS);
        if (obj.has(itemName) && !allowDuplicates)
          throw lexer.error("Duplicated property name: "+itemName+ " @ "+path);
        obj.addForParser(itemName, childS, itemNoComma, itemUnquoted, valueUnquoted);
        childS.setEnd(endProperty.copy());
        break;
      case Number:
        JsonNumber childN = new JsonNumber(itemValue);
        childN.setStart(startProperty.copy());
        lexer.takeComments(childN);
        if (obj.has(itemName) && !allowDuplicates)
          throw lexer.error("Duplicated property name: "+itemName+ " @ "+path);
        obj.addForParser(itemName, childN, itemNoComma, itemUnquoted, valueUnquoted);
        childN.setEnd(endProperty.copy());
        break;
      case Null:
        JsonNull childn = new JsonNull();
        childn.setStart(startProperty.copy());
        lexer.takeComments(childn);
        if (obj.has(itemName) && !allowDuplicates)
          throw lexer.error("Duplicated property name: "+itemName+ " @ "+path);
        obj.addForParser(itemName, childn, itemNoComma, itemUnquoted, valueUnquoted);
        childn.setEnd(endProperty.copy());
        break;
      case Array:
        JsonArray childA = new JsonArray(); // (obj.path+'.'+ItemName);
        childA.setStart(startProperty.copy());
        lexer.takeComments(childA);
        if (obj.has(itemName) && !allowDuplicates)
          throw lexer.error("Duplicated property name: "+itemName+ " @ "+path);
        obj.addForParser(itemName, childA, itemNoComma, itemUnquoted, valueUnquoted);
        next();
        if (!readArray(path+"."+itemName, childA, false))
          next(true);
        if (childA.getEnd() == null) {
          childA.setEnd(endProperty.copy());
        }
        break;
      case Eof : 
        throw lexer.error("Unexpected End of File");
      case End:
        throw lexer.error("Unexpected End"); // Don't think we can get here
      }
      itemNoComma = false;
      endProperty = lexer.getLocation().copy();
      obj.setExtraComma(lexer.getType() == TokenType.Comma);
      next();
    }
  }

  private boolean readArray(String path, JsonArray arr, boolean root) throws IOException, JsonException {
    boolean res = false;
    while (!((itemType == ItemType.End) || (root && (itemType == ItemType.Eof)))) {
      res  = true;
      arr.setExtraComma(false);
      switch (itemType) {
      case Object:
        JsonObject obj  = new JsonObject(); // (arr.path+'['+inttostr(i)+']');
        obj.setStart(startProperty.copy());
        lexer.takeComments(obj);
        arr.addForParser(obj, itemNoComma, valueUnquoted);
        next();
        readObject(path+"["+(arr.size()-1)+"]", obj, false);
        obj.setEnd(endProperty.copy());
        break;
      case String:
        JsonString s = new JsonString(itemValue);
        s.setStart(startProperty.copy());
        lexer.takeComments(s);
        arr.addForParser(s, itemNoComma, valueUnquoted);
        s.setEnd(endProperty.copy());
        break;
      case Number:
        JsonNumber n = new JsonNumber(itemValue);
        n.setStart(startProperty.copy());
        lexer.takeComments(n);
        arr.addForParser(n, itemNoComma, valueUnquoted);
        n.setEnd(endProperty.copy());
        break;
      case Boolean:
        JsonBoolean b = new JsonBoolean("true".equals(itemValue));
        b.setStart(startProperty.copy());
        lexer.takeComments(b);
        arr.addForParser(b, itemNoComma, valueUnquoted);
        b.setEnd(endProperty.copy());
        break;
      case Null :
        JsonNull nn = new JsonNull();
        nn.setStart(startProperty.copy());
        lexer.takeComments(nn);
        arr.addForParser(nn, itemNoComma, valueUnquoted);
        nn.setEnd(endProperty.copy());
        break;
      case Array:
        JsonArray child = new JsonArray(); // (arr.path+'['+inttostr(i)+']');
        child.setStart(startProperty.copy());
        lexer.takeComments(child);
        arr.addForParser(child, itemNoComma, valueUnquoted);
        next();
        readArray(path+"["+(arr.size()-1)+"]", child, false);
        child.setEnd(endProperty.copy());
        break;
      case Eof : 
        throw lexer.error("Unexpected End of File");
      case End:
        throw lexer.error("Can't get here");
      }
      itemNoComma = false;
      arr.setEnd(lexer.getLocation().copy());
      arr.setExtraComma(lexer.getType() == TokenType.Comma);
      next();
    }
    return res;
  }

  private void next() throws IOException {
    next(false);
  }
  
  private void next(boolean noPop) throws IOException {
    switch (itemType) {
    case Object :
      lexer.consume(TokenType.Open);
      lexer.getStates().push(new State(itemName, true));
      if (lexer.getType() == TokenType.Close) {
        itemType = ItemType.End;
        lexer.next();
      } else
        parseProperty();
      break;
    case Null:
    case String:
    case Number: 
    case End: 
    case Boolean :
      if (itemType == ItemType.End && !noPop)
        lexer.getStates().pop();
      if (lexer.getType() == TokenType.Comma) {
        lexer.next();
        if (allowNoComma && (lexer.getType() == TokenType.CloseArray || lexer.getType() == TokenType.Close)) {
          itemType = ItemType.End;
          lexer.next();
        } else {
          parseProperty();
        }
      } else if (lexer.getType() == TokenType.Close) {
        itemType = ItemType.End;
        lexer.next();
      } else if (lexer.getType() == TokenType.CloseArray) {
        itemType = ItemType.End;
        lexer.next();
      } else if (lexer.getType() == TokenType.Eof) {
        itemType = ItemType.Eof;
      } else if (allowNoComma && (lexer.getType() == TokenType.String || (!lexer.getStates().peek().isProp()) && lexer.getType().isValueType())) {
        itemNoComma = true;
        parseProperty();        
      } else {
        throw lexer.error("Unexpected JSON syntax");
      }
      break;
    case Array :
      lexer.next();
      lexer.getStates().push(new State(itemName+"[]", false));
      parseProperty();
      break;
    case Eof :
      throw lexer.error("JSON Syntax Error - attempt to read past end of json stream");
    default:
      throw lexer.error("not done yet (a): "+itemType.toString());
    }
  }

  private void parseProperty() throws IOException {
    if (lexer.getStates().peek().isProp()) {
      itemUnquoted = lexer.isUnquoted();
      itemName = lexer.consume(TokenType.String);
      itemValue = null;
      lexer.consume(TokenType.Colon);
    }
    startProperty = lexer.getLastLocationAWS().copy();
    endProperty = lexer.getLocation().copy();
    valueUnquoted = lexer.isUnquoted();
    switch (lexer.getType()) {
    case Null :
      itemType = ItemType.Null;
      itemValue = lexer.getValue();
      lexer.next();
      break;
    case String :
      itemType = ItemType.String;
      itemValue = lexer.getValue();
      lexer.next();
      break;
    case Boolean :
      itemType = ItemType.Boolean;
      itemValue = lexer.getValue();
      lexer.next();
      break;
    case Number :
      itemType = ItemType.Number;
      itemValue = lexer.getValue();
      lexer.next();
      break;
    case Open :
      itemType = ItemType.Object;
      break;
    case OpenArray :
      itemType = ItemType.Array;
      break;
    case CloseArray :
      itemType = ItemType.End;
      break;
      // case Close, , case Colon, case Comma, case OpenArray,       !
    default:
      throw lexer.error("not done yet (b): "+lexer.getType().toString());
    }
  }

  private String write(JsonElement element, boolean pretty) {
    StringBuilder b = new StringBuilder();
    if (pretty && element.hasComments()) {
      writeComments(b, element.getComments(), 0);
    }
    write(b, element, pretty, 0);
    if (pretty) {
      b.append("\n");
    }
    return b.toString();
  }

  private void writeComments(StringBuilder b, List<JsonComment> comments, int indent) {
    for (JsonComment s : comments) {
      b.append("// ");
      b.append(s.getContent());
      b.append("\n");
      b.append(Utilities.padLeft("", ' ', indent));
    }
  }

  private void write(StringBuilder b, JsonElement e, boolean pretty, int indent) {
    switch (e.type()) {
    case ARRAY:
      JsonArray arr = (JsonArray) e;
      b.append("[");
      boolean first = true;
      boolean complex = arr.size() > 6; // arbitrary cut off
      if (!complex) {
        int length = 0;
        for (JsonElement i : arr.getItems()) {
          if (i instanceof JsonPrimitive) {
            length = length + ((JsonPrimitive)i).toJson().length();
          }
          if (i.type() == JsonElementType.ARRAY || i.type() == JsonElementType.OBJECT
              || i.hasComments()) { // 20 is a somewhat arbitrary cut off
            complex = true;
          }
        }
        if (length > 60) {
          complex = true;
        }
      }
      for (JsonElement i : arr.getItems()) {
        if (first) first = false; else b.append(pretty && !complex ? ", " : ",");
        if (pretty && complex) {
          b.append("\n");
          b.append(Utilities.padLeft("", ' ', indent+2));
          if (i.hasComments()) {
            writeComments(b, i.getComments(), indent+2);
          }
        }
        write(b, i, pretty && complex, indent+2);
      }
      if (pretty && complex) {
        b.append("\n");
        b.append(Utilities.padLeft("", ' ', indent));
      }
      b.append("]");
      break;
    case BOOLEAN:
      b.append(((JsonBoolean) e).getValue());
      break;
    case NULL:
      b.append(((JsonNull) e).getValue());
      break;
    case NUMBER:
      b.append(((JsonNumber) e).getValue());
      break;
    case OBJECT:
      b.append("{");
      first = true;
      for (JsonProperty p : ((JsonObject) e).getProperties()) {
        if (first) first = false; else b.append(",");
        if (pretty) {
          b.append("\n");
          b.append(Utilities.padLeft("", ' ', indent+2));
          if (p.getValue().hasComments()) {
            writeComments(b, p.getValue().getComments(), indent+2);
          }
        }
        b.append("\"");
        b.append(p.getName());
        b.append(pretty ? "\" : " : "\":");
        write(b, p.getValue(), pretty, indent+2);
      }
      if (pretty) {
        b.append("\n");
        b.append(Utilities.padLeft("", ' ', indent));
      }
      b.append("}");
      break;
    case STRING:
      b.append("\"");
      b.append(Utilities.escapeJson(((JsonString) e).getValue()));
      b.append("\"");
      break;
    default:
      throw new Error("Can't get here");    
    }
  }

  private static byte[] fetch(String source) throws IOException {
    SimpleHTTPClient fetcher = new SimpleHTTPClient();
    fetcher.addHeader("accept", "application/json, application/fhir+json");
    HTTPResult res = fetcher.get(source+"?nocache=" + System.currentTimeMillis());
    res.checkThrowException();
    return res.getContent();
  }
}
