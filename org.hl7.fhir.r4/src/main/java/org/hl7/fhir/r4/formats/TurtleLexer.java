package org.hl7.fhir.r4.formats;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



public class TurtleLexer {

  public enum TurtleTokenType {
    NULL, 
    TOKEN, SPECIAL, LITERAL
  }

  private String source;
  private int cursor; 
  private String token;
  private TurtleTokenType type;
  
  public TurtleLexer(String source) throws Exception {
    this.source = source;
    cursor = 0;
    readNext();
  }

  private void readNext() throws Exception {    
    if (cursor >= source.length()) {
      token = null;
      type = TurtleTokenType.NULL;
    } else if (source.charAt(cursor) == '"')
      readLiteral();
    else if (source.charAt(cursor) == '[' || source.charAt(cursor) == ']')
      readDelimiter();
    else if (source.charAt(cursor) == '(')
      throw new Exception("not supported yet");
    else if (source.charAt(cursor) == ';' || source.charAt(cursor) == '.' || source.charAt(cursor) == ',')
      readDelimiter();
    else if (Character.isLetter(source.charAt(cursor)))
      readToken();
    
  }

  private void readLiteral() {
    StringBuilder b = new StringBuilder();
    cursor++; // skip "        
    while (cursor < source.length() && source.charAt(cursor) != '"') {
      if (source.charAt(cursor) == '\\') {
        b.append(source.charAt(cursor));
        cursor++;        
      } 
      b.append(source.charAt(cursor));
      cursor++;
    }
    token = "\""+b.toString()+"\"";
    type = TurtleTokenType.LITERAL;
    cursor++; // skip "
    while (cursor < source.length() && Character.isWhitespace(source.charAt(cursor))) 
      cursor++;    
  }

  private void readDelimiter() {
    StringBuilder b = new StringBuilder();
    b.append(source.charAt(cursor));
    cursor++;
    token = b.toString();
    type = TurtleTokenType.SPECIAL;
    while (cursor < source.length() && Character.isWhitespace(source.charAt(cursor))) 
      cursor++;
  }

  private void readToken() {
    StringBuilder b = new StringBuilder();
    while (cursor < source.length() && isValidTokenChar(source.charAt(cursor))) {
      if (source.charAt(cursor) == '\\') {
        b.append(source.charAt(cursor));
        cursor++;        
      } 
      b.append(source.charAt(cursor));
      cursor++;
    }
    token = b.toString();
    type = TurtleTokenType.TOKEN;
    if (token.endsWith(".")) {
      cursor--;
      token = token.substring(0, token.length()-1);
    }
    while (cursor < source.length() && Character.isWhitespace(source.charAt(cursor))) 
      cursor++;
  }

  private boolean isValidTokenChar(char c) {
    return Character.isLetter(c) || Character.isDigit(c) || c == ':' || c == '\\' || c == '.';
  }

  public boolean done() {
    return type == TurtleTokenType.NULL;
  }

  public String next() throws Exception {
    String res = token;
    readNext();
    return res;
  }

  public String peek() throws Exception {
    return token;
  }

  public TurtleTokenType peekType() {
    return type;
  }
  
  
}