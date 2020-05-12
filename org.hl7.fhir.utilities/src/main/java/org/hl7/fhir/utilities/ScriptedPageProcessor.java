package org.hl7.fhir.utilities;

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



import org.hl7.fhir.exceptions.FHIRException;

/**
 * This object processes a string that contains <%%> or [%%] where each of these 
 * represents a 'command' that either does something, or inserts content into the
 * string - which is then reprocessed 
 * 
 * The outcome is a string. 
 * 
 * This is a base class that is expected to be subclassed for various context
 * specific processors
 * 
 * @author Grahame Grieve
 *
 */
public abstract class ScriptedPageProcessor {

  protected String title;
  protected int level;
  
  public ScriptedPageProcessor(String title, int level) {
    super();
    this.title = title;
    this.level = level;
  }

  public String process(String content) throws Exception {
    StringBuilder outcome = new StringBuilder();
    int cursor = 0;
    while (cursor < content.length()) {
      if (nextIs(content, cursor, "[%")) {
        cursor = processEntry(outcome, content, cursor, "%]");
      } else if (nextIs(content, cursor, "<%")) {
        cursor = processEntry(outcome, content, cursor, "%>");        
      } else {
        outcome.append(content.charAt(cursor));
        cursor++;
      }
    }
    return outcome.toString();
  }

  private int processEntry(StringBuilder outcome, String content, int cursor, String endText) throws Exception {
    int start = cursor+endText.length();
    int end = start;
    while (end < content.length()) {
      if (nextIs(content, end, endText)) {
        outcome.append(process(getContent(content.substring(start, end))));
        return end+endText.length();
      }
      end++;
    }
    throw new FHIRException("unterminated insert sequence");
  }

  private String getContent(String command) throws Exception {
    if (Utilities.noString(command) || command.startsWith("!"))
      return "";
    
    String[] parts = command.split("\\ ");
    return processCommand(command, parts);
  }

  protected String processCommand(String command, String[] com) throws Exception {
    if (com[0].equals("title"))
      return title;
    else if (com[0].equals("xtitle"))
      return Utilities.escapeXml(title);
    else if (com[0].equals("level"))
      return genlevel();  
    else if (com[0].equals("settitle")) {
      title = command.substring(9).replace("{", "<%").replace("}", "%>");
      return "";
    }
    else
      throw new FHIRException("Unknown command "+com[0]);
  }

  private boolean nextIs(String content, int cursor, String value) {
    if (cursor + value.length() > content.length())
      return false;
    else {
      String v = content.substring(cursor, cursor+value.length());
      return v.equals(value);
    }
  }
 
  public String genlevel() {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < level; i++) {
      b.append("../");
    }
    return b.toString();
  }


}