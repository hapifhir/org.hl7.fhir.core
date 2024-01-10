package org.hl7.fhir.r4b.fhirpath;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.SourceLocation;
import org.hl7.fhir.utilities.Utilities;

// shared lexer for concrete syntaxes 
// - FluentPath
// - Mapping language

public class FHIRLexer {
  public class FHIRLexerException extends FHIRException {

    private SourceLocation location;

//    public FHIRLexerException() {
//      super();
//    }
//
//    public FHIRLexerException(String message, Throwable cause) {
//      super(message, cause);
//    }
//
//    public FHIRLexerException(String message) {
//      super(message);
//    }
//
//    public FHIRLexerException(Throwable cause) {
//      super(cause);
//    }

    public FHIRLexerException(String message, SourceLocation location) {
      super(message);
      this.location = location;
    }

    public SourceLocation getLocation() {
      return location;
    }

  }
  private String source;
  private int cursor;
  private int currentStart;
  private String current;
  private List<String> comments = new ArrayList<>();
  private SourceLocation currentLocation;
  private SourceLocation currentStartLocation;
  private int id;
  private String name;
  private boolean liquidMode; // in liquid mode, || terminates the expression and hands the parser back to the host
  private SourceLocation commentLocation;
  private boolean metadataFormat;
  private boolean allowDoubleQuotes;

  public FHIRLexer(String source, String name) throws FHIRLexerException {
    this.source = source == null ? "" : source;
    this.name = name == null ? "??" : name;
    currentLocation = new SourceLocation(1, 1);
    next();
  }
  public FHIRLexer(String source, int i) throws FHIRLexerException {
    this.source = source;
    this.cursor = i;
    currentLocation = new SourceLocation(1, 1);
    next();
  }
  public FHIRLexer(String source, int i, boolean allowDoubleQuotes) throws FHIRLexerException {
    this.source = source;
    this.cursor = i;
    this.allowDoubleQuotes =  allowDoubleQuotes;
    currentLocation = new SourceLocation(1, 1);
    next();
  }
  public FHIRLexer(String source, String name, boolean metadataFormat, boolean allowDoubleQuotes) throws FHIRLexerException {
    this.source = source == null ? "" : source;
    this.name = name == null ? "??" : name;
    this.metadataFormat = metadataFormat;
    this.allowDoubleQuotes =  allowDoubleQuotes;
    currentLocation = new SourceLocation(1, 1);
    next();
  }
  public String getCurrent() {
    return current;
  }
  public SourceLocation getCurrentLocation() {
    return currentLocation;
  }

  public boolean isConstant() {
    return FHIRPathConstant.isFHIRPathConstant(current);
  }

  public boolean isFixedName() {
    return FHIRPathConstant.isFHIRPathFixedName(current);
  }

  public boolean isStringConstant() {
    return FHIRPathConstant.isFHIRPathStringConstant(current);
  }

  public String take() throws FHIRLexerException {
    String s = current;
    next();
    return s;
  }

  public int takeInt() throws FHIRLexerException {
    String s = current;
    if (!Utilities.isInteger(s))
      throw error("Found "+current+" expecting an integer");
    next();
    return Integer.parseInt(s);
  }

  public boolean isToken() {
    if (Utilities.noString(current))
      return false;

    if (current.startsWith("$"))
      return true;

    if (current.equals("*") || current.equals("**"))
      return true;

    if ((current.charAt(0) >= 'A' && current.charAt(0) <= 'Z') || (current.charAt(0) >= 'a' && current.charAt(0) <= 'z')) {
      for (int i = 1; i < current.length(); i++) 
        if (!( (current.charAt(1) >= 'A' && current.charAt(1) <= 'Z') || (current.charAt(1) >= 'a' && current.charAt(1) <= 'z') ||
            (current.charAt(1) >= '0' && current.charAt(1) <= '9')))
          return false;
      return true;
    }
    return false;
  }

  public FHIRLexerException error(String msg) {
    return error(msg, currentLocation.toString(), currentLocation);
  }

  public FHIRLexerException error(String msg, String location, SourceLocation loc) {
    return new FHIRLexerException("Error @"+location+": "+msg, loc);
  }

  public void next() throws FHIRLexerException {
    skipWhitespaceAndComments();
    current = null;
    currentStart = cursor;
    currentStartLocation = currentLocation;
    if (cursor < source.length()) {
      char ch = source.charAt(cursor);
      if (ch == '!' || ch == '>' || ch == '<' || ch == ':' || ch == '-' || ch == '=')  {
        cursor++;
        if (cursor < source.length() && (source.charAt(cursor) == '=' || source.charAt(cursor) == '~' || source.charAt(cursor) == '-') || (ch == '-' && source.charAt(cursor) == '>')) 
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch == '.' ) {
        cursor++;
        if (cursor < source.length() && (source.charAt(cursor) == '.')) 
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch >= '0' && ch <= '9') {
          cursor++;
        boolean dotted = false;
        while (cursor < source.length() && ((source.charAt(cursor) >= '0' && source.charAt(cursor) <= '9') || (source.charAt(cursor) == '.') && !dotted)) {
          if (source.charAt(cursor) == '.')
            dotted = true;
          cursor++;
        }
        if (source.charAt(cursor-1) == '.')
          cursor--;
        current = source.substring(currentStart, cursor);
      }  else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        while (cursor < source.length() && ((source.charAt(cursor) >= 'A' && source.charAt(cursor) <= 'Z') || (source.charAt(cursor) >= 'a' && source.charAt(cursor) <= 'z') || 
            (source.charAt(cursor) >= '0' && source.charAt(cursor) <= '9') || source.charAt(cursor) == '_')) 
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch == '%') {
        cursor++;
        if (cursor < source.length() && (source.charAt(cursor) == '`')) {
          cursor++;
          while (cursor < source.length() && (source.charAt(cursor) != '`'))
            cursor++;
          cursor++;
        } else
        while (cursor < source.length() && ((source.charAt(cursor) >= 'A' && source.charAt(cursor) <= 'Z') || (source.charAt(cursor) >= 'a' && source.charAt(cursor) <= 'z') || 
            (source.charAt(cursor) >= '0' && source.charAt(cursor) <= '9') || source.charAt(cursor) == ':' || source.charAt(cursor) == '-'))
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch == '/') {
        cursor++;
        if (cursor < source.length() && (source.charAt(cursor) == '/')) {
          // we've run into metadata
          cursor++;
          cursor++;
          current = source.substring(currentStart, cursor);
        } else {
          current = source.substring(currentStart, cursor);
        }
      } else if (ch == '$') {
        cursor++;
        while (cursor < source.length() && (source.charAt(cursor) >= 'a' && source.charAt(cursor) <= 'z'))
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch == '{') {
        cursor++;
        ch = source.charAt(cursor);
        if (ch == '}')
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch == '"' && allowDoubleQuotes) {
        cursor++;
        boolean escape = false;
        while (cursor < source.length() && (escape || source.charAt(cursor) != '"')) {
          if (escape)
            escape = false;
          else 
            escape = (source.charAt(cursor) == '\\');
          cursor++;
        }
        if (cursor == source.length())
          throw error("Unterminated string");
        cursor++;
        current = "\""+source.substring(currentStart+1, cursor-1)+"\"";
      } else if (ch == '`') {
        cursor++;
        boolean escape = false;
        while (cursor < source.length() && (escape || source.charAt(cursor) != '`')) {
          if (escape)
            escape = false;
          else 
            escape = (source.charAt(cursor) == '\\');
          cursor++;
        }
        if (cursor == source.length())
          throw error("Unterminated string");
        cursor++;
        current = "`"+source.substring(currentStart+1, cursor-1)+"`";
      } else if (ch == '\''){
        cursor++;
        char ech = ch;
        boolean escape = false;
        while (cursor < source.length() && (escape || source.charAt(cursor) != ech)) {
          if (escape)
            escape = false;
          else 
            escape = (source.charAt(cursor) == '\\');
          cursor++;
        }
        if (cursor == source.length())
          throw error("Unterminated string");
        cursor++;
        current = source.substring(currentStart, cursor);
        if (ech == '\'')
          current = "\'"+current.substring(1, current.length() - 1)+"\'";
      } else if (ch == '`') {
        cursor++;
        boolean escape = false;
        while (cursor < source.length() && (escape || source.charAt(cursor) != '`')) {
          if (escape)
            escape = false;
          else 
            escape = (source.charAt(cursor) == '\\');
          cursor++;
        }
        if (cursor == source.length())
          throw error("Unterminated string");
        cursor++;
        current = "`"+source.substring(currentStart+1, cursor-1)+"`";
      } else if (ch == '|' && liquidMode) {
        cursor++;
        ch = source.charAt(cursor);
        if (ch == '|')
          cursor++;
        current = source.substring(currentStart, cursor);
      } else if (ch == '@'){
        int start = cursor;
        cursor++;
        while (cursor < source.length() && isDateChar(source.charAt(cursor), start))
          cursor++;          
        current = source.substring(currentStart, cursor);
      } else { // if CharInSet(ch, ['.', ',', '(', ')', '=', '$']) then
        cursor++;
        current = source.substring(currentStart, cursor);
      }
    }
  }

  private void skipWhitespaceAndComments() {
    comments.clear();
    commentLocation = null;
    boolean last13 = false;
    boolean done = false;
    while (cursor < source.length() && !done) {
      if (cursor < source.length() -1 && "//".equals(source.substring(cursor, cursor+2)) && !isMetadataStart()) {
        if (commentLocation == null) {
          commentLocation = currentLocation.copy();
        }
        int start = cursor+2;
        while (cursor < source.length() && !((source.charAt(cursor) == '\r') || source.charAt(cursor) == '\n')) { 
          cursor++;        
        }
        comments.add(source.substring(start, cursor).trim());
      } else if (cursor < source.length() - 1 && "/*".equals(source.substring(cursor, cursor+2))) {
        if (commentLocation == null) {
          commentLocation = currentLocation.copy();
        }
        int start = cursor+2;
        while (cursor < source.length() - 1 && !"*/".equals(source.substring(cursor, cursor+2))) { 
          last13 = currentLocation.checkChar(source.charAt(cursor), last13);
          cursor++;        
        }
        if (cursor >= source.length() -1) {
          error("Unfinished comment");
        } else {
          comments.add(source.substring(start, cursor).trim());
          cursor = cursor + 2;
        }
      } else if (Utilities.isWhitespace(source.charAt(cursor))) {
        last13 = currentLocation.checkChar(source.charAt(cursor), last13);
        cursor++;
      } else {
        done = true;
      }
    }
  }
  
  private boolean isMetadataStart() {
    return metadataFormat && cursor < source.length() - 2 && "///".equals(source.substring(cursor, cursor+3));
  }
  
  private boolean isDateChar(char ch,int start) {
    int eot = source.charAt(start+1) == 'T' ? 10 : 20;
    
    return ch == '-' || ch == ':' || ch == 'T' || ch == '+' || ch == 'Z' || Character.isDigit(ch) || (cursor-start == eot && ch == '.' && cursor < source.length()-1&& Character.isDigit(source.charAt(cursor+1)));
  }
  public boolean isOp() {
    return ExpressionNode.Operation.fromCode(current) != null;
  }
  public boolean done() {
    return currentStart >= source.length();
  }
  public int nextId() {
    id++;
    return id;
  }
  public SourceLocation getCurrentStartLocation() {
    return currentStartLocation;
  }
  
  // special case use
  public void setCurrent(String current) {
    this.current = current;
  }

  public boolean hasComments() {
    return comments.size() > 0;
  }

  public List<String> getComments() {
    return comments;
  }

  public String getAllComments() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("\r\n");
    b.addAll(comments);
    comments.clear();
    return b.toString();
  }

  public String getFirstComment() {
    if (hasComments()) {
      String s = comments.get(0);
      comments.remove(0);
      return s;      
    } else {
      return null;
    }
  }

  public boolean hasToken(String kw) {
    return !done() && kw.equals(current);
  }
  public boolean hasToken(String... names) {
    if (done()) 
      return false;
    for (String s : names)
      if (s.equals(current))
        return true;
    return false;
  }
  
  public void token(String kw) throws FHIRLexerException {
    if (!kw.equals(current)) 
      throw error("Found \""+current+"\" expecting \""+kw+"\"");
    next();
  }
  
  public String readConstant(String desc) throws FHIRLexerException {
    if (!isStringConstant())
      throw error("Found "+current+" expecting \"["+desc+"]\"");

    return processConstant(take());
  }

  public String readFixedName(String desc) throws FHIRLexerException {
    if (!isFixedName())
      throw error("Found "+current+" expecting \"["+desc+"]\"");

    return processFixedName(take());
  }

  public String processConstant(String s) throws FHIRLexerException {
    StringBuilder b = new StringBuilder();
    int i = 1;
    while (i < s.length()-1) {
      char ch = s.charAt(i);
      if (ch == '\\') {
        i++;
        switch (s.charAt(i)) {
        case 't': 
          b.append('\t');
          break;
        case 'r':
          b.append('\r');
          break;
        case 'n': 
          b.append('\n');
          break;
        case 'f': 
          b.append('\f');
          break;
        case '\'':
          b.append('\'');
          break;
        case '"':
          b.append('"');
          break;
        case '`':
          b.append('`');
          break;
        case '\\': 
          b.append('\\');
          break;
        case '/': 
          b.append('/');
          break;
        case 'u':
          i++;
          int uc = Integer.parseInt(s.substring(i, i+4), 16);
          b.append(Character.toString(uc));
          i = i + 4;
          break;
        default:
          throw new FHIRLexerException("Unknown character escape \\"+s.charAt(i), currentLocation);
        }
      } else {
        b.append(ch);
        i++;
      }
    }
    return b.toString();
  }
  
  public String processFixedName(String s) throws FHIRLexerException {
    StringBuilder b = new StringBuilder();
    int i = 1;
    while (i < s.length()-1) {
      char ch = s.charAt(i);
      if (ch == '\\') {
        i++;
        switch (s.charAt(i)) {
        case 't': 
          b.append('\t');
          break;
        case 'r':
          b.append('\r');
          break;
        case 'n': 
          b.append('\n');
          break;
        case 'f': 
          b.append('\f');
          break;
        case '\'':
          b.append('\'');
          break;
        case '"':
          b.append('"');
          break;
        case '\\': 
          b.append('\\');
          break;
        case '/': 
          b.append('/');
          break;
        case 'u':
          i++;
          int uc = Integer.parseInt(s.substring(i, i+4), 16);
          b.append(Character.toString(uc));
          i = i + 4;
          break;
        default:
          throw new FHIRLexerException("Unknown character escape \\"+s.charAt(i), currentLocation);
        }
      } else {
        b.append(ch);
        i++;
      }
    }
    return b.toString();
  }

  public void skipToken(String token) throws FHIRLexerException {
    if (getCurrent().equals(token))
      next();
    
  }
  public String takeDottedToken() throws FHIRLexerException {
    StringBuilder b = new StringBuilder();
    b.append(take());
    while (!done() && getCurrent().equals(".")) {
      b.append(take());
      b.append(take());
    }
    return b.toString();
  }
  
  public int getCurrentStart() {
    return currentStart;
  }
  public String getSource() {
    return source;
  }
  public boolean isLiquidMode() {
    return liquidMode;
  }
  public void setLiquidMode(boolean liquidMode) {
    this.liquidMode = liquidMode;
  }
  public SourceLocation getCommentLocation() {
    return this.commentLocation;
  }
  public boolean isMetadataFormat() {
    return metadataFormat;
  }
  public void setMetadataFormat(boolean metadataFormat) {
    this.metadataFormat = metadataFormat;
  }
  public List<String> cloneComments() {
    List<String> res = new ArrayList<>();
    res.addAll(getComments());
    return res;
  }
  public String tokenWithTrailingComment(String token) {
    int line = getCurrentLocation().getLine();
    token(token);
    if (getComments().size() > 0 && getCommentLocation().getLine() == line) {
      return getFirstComment();
    } else {
      return null;
    }
  }
  public boolean isAllowDoubleQuotes() {
    return allowDoubleQuotes;
  }
}