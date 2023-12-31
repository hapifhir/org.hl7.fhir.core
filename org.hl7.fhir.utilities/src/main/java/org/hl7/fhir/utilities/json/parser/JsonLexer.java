package org.hl7.fhir.utilities.json.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonComment;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonLocationData;

public class JsonLexer {
  public static class State {
    private String name;
    private boolean isProp;
    public State(String name, boolean isProp) {
      super();
      this.name = name;
      this.isProp = isProp;
    }
    public String getName() {
      return name;
    }
    public boolean isProp() {
      return isProp;
    }
  }
  
  public enum TokenType {
    Open, Close, String, Number, Colon, Comma, OpenArray, CloseArray, Eof, Null, Boolean;

    boolean isValueType() {
      return this == Open || this == String || this == Number || this == OpenArray || this == Boolean || this == Null;
    }
  }
  
  private String source;
  private int cursor;
  private String peek;
  private String value;
  private TokenType type;
  private Stack<State> states = new Stack<State>();
  private JsonLocationData lastLocationBWS;
  private JsonLocationData lastLocationAWS;
  private JsonLocationData location;
  private StringBuilder b = new StringBuilder();
  private boolean allowComments;
  private boolean allowUnquotedStrings;
  private List<JsonComment> comments = new ArrayList<>();
  private boolean isUnquoted;
  private String sourceName;

  public JsonLexer(String source, boolean allowComments, boolean allowUnquotedStrings) throws IOException {
    this.source = source;
    this.allowComments = allowComments;
    this.allowUnquotedStrings = allowUnquotedStrings;
    cursor = -1;
    location = new JsonLocationData(1, 1);  
    start();
  }

  private boolean more() {
    return peek != null || cursor < source.length(); 
  }

  private String getNext(int length) throws IOException {
    String result = "";
    if (peek != null) {
      if (peek.length() > length) {
        result = peek.substring(0, length);
        peek = peek.substring(length);
      } else {
        result = peek;
        peek = null;
      }
    }
    if (result.length() < length) {
      int len = length - result.length(); 
      if (cursor > source.length() - len) 
        throw error("Attempt to read past end of source");
      result = result + source.substring(cursor+1, cursor+len+1);
      cursor = cursor + len;
    }
    for (char ch : result.toCharArray())
      if (ch == '\n')
        location.newLine();
      else
        location.incCol();
    return result;
  }

  private char getNextChar() throws IOException {
    char ch;
    if (peek != null) {
      ch = peek.charAt(0);
      peek = peek.length() == 1 ? null : peek.substring(1);
    } else {
      cursor++;
      if (cursor >= source.length()) {
        ch = 0;
      } else {
        ch = source.charAt(cursor);
      }
    }
    if (ch == '\n') {
      location.newLine();
    } else {
      location.incCol();
    }
    return ch;
  }

  private void push(char ch){
    peek = peek == null ? String.valueOf(ch) : String.valueOf(ch)+peek;
    location.back();
  }

  public IOException error(String msg) {
    return new IOException("Error parsing JSON source: "+msg+" at Line "+Integer.toString(location.getLine())+" (path=["+path()+"])"+(sourceName == null ? "" : " from '"+sourceName+"'"));
  }

  private String path() {
    if (states.empty())
      return value;
    else {
      String result = "";
      for (State s : states) 
        result = result + '/'+ s.getName();
      result = result + value;
      return result;
    }
  }

  public void start() throws IOException {
    //      char ch = getNextChar();
    //      if (ch = '\.uEF')
    //      begin
    //        // skip BOM
    //        getNextChar();
    //        getNextChar();
    //      end
    //      else
    //        push(ch);
    next();
  }

  public TokenType getType() {
    return type;
  }

  public String getValue() {
    return value;
  }


  public JsonLocationData getLastLocationBWS() {
    return lastLocationBWS;
  }

  public JsonLocationData getLastLocationAWS() {
    return lastLocationAWS;
  }

  public void next() throws IOException {
    lastLocationBWS = location.copy();
    char ch;
    do {
      ch = getNextChar();
      if (allowComments && ch == '/') {
        JsonLocationData start = location.prev();
        char ch1 = getNextChar();
        if (ch1 == '/') {
          StringBuilder b = new StringBuilder();
          boolean first = true;
          while (more() && !Utilities.charInSet(ch, '\r', '\n')) {
            if (first) first = false; else b.append(ch);
            ch = getNextChar();
          }
          comments.add(new JsonComment(b.toString().trim(), start, location.prev()));
        } else {
          push(ch1);
        }         
      }
    } while (more() && Utilities.charInSet(ch, ' ', '\r', '\n', '\t'));
    lastLocationAWS = location.copy().prev();
    isUnquoted = false;
    
    if (!more()) {
      type = TokenType.Eof;
    } else {
      switch (ch) {
      case '{' : 
        type = TokenType.Open;
        break;
      case '}' : 
        type = TokenType.Close;
        break;
      case '"' :
        type = TokenType.String;
        b.setLength(0);
        do {
          ch = getNextChar();
          if (ch == '\\') {
            ch = getNextChar();
            switch (ch) {
            case '"': b.append('"'); break;
            case '\'': b.append('\''); break;
            case '\\': b.append('\\'); break;
            case '/': b.append('/'); break;
            case 'n': b.append('\n'); break;
            case 'r': b.append('\r'); break;
            case 't': b.append('\t'); break;
            case 'u': b.append((char) Integer.parseInt(getNext(4), 16)); break;
            default :
              throw error("unknown escape sequence: \\"+ch);
            }
            ch = ' ';
          } else if (ch != '"')
            b.append(ch);
        } while (more() && (ch != '"'));
        if (!more())
          throw error("premature termination of json stream during a string");
        value = b.toString();
        break;
      case ':' : 
        type = TokenType.Colon;
        break;
      case ',' : 
        type = TokenType.Comma;
        break;
      case '[' : 
        type = TokenType.OpenArray;
        break;
      case ']' : 
        type = TokenType.CloseArray;
        break;
      default:
        if ((ch >= '0' && ch <= '9') || ch == '-') {
          type = TokenType.Number;
          b.setLength(0);
          while (more() && ((ch >= '0' && ch <= '9') || ch == '-' || ch == '.') || ch == '+' || ch == 'e' || ch == 'E') {
            b.append(ch);
            ch = getNextChar();
          }
          value = b.toString();
          push(ch);
        } else if (Utilities.isAlphabetic(ch) || (ch == '_')) {
          type = TokenType.String;
          isUnquoted = true;
          b.setLength(0);
          while (more() && (Utilities.isAlphabetic(ch) || Utilities.isDigit(ch) || Utilities.existsInList(ch, '_', '.', '-'))) {
            b.append(ch);
            ch = getNextChar();
          }
          value = b.toString();
          push(ch);
          if ("true".equals(value) || "false".equals(value)) {
            this.type = TokenType.Boolean;
            isUnquoted = false;
          } else if ("null".equals(value)) {
            this.type = TokenType.Null;
            isUnquoted = false;
          } else if (!allowUnquotedStrings) {
            throw error("Unexpected token '"+value+"' in json stream");
          } 
        }
      }
    }
  }

  public String consume(TokenType type) throws IOException {
    if (this.type != type)
      throw error("JSON syntax error - found "+this.type.toString()+" expecting "+type.toString());
    String result = value;
    next();
    return result;
  }

  public JsonLocationData getLocation() {
    return location;
  }

  public Stack<State> getStates() {
    return states;
  }

  public void takeComments(JsonElement child) {
    if (!comments.isEmpty()) {
      child.getComments().addAll(comments);
      comments.clear();
    }
  }

  public boolean isUnquoted() {
    return isUnquoted;
  }

  @Override
  public String toString() {
    return "JsonLexer [cursor=" + cursor + ", peek=" + peek + ", type=" + type + ", location=" + location.toString() + "]";
  }

  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }


}
