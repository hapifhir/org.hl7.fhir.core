package org.hl7.fhir.r5.formats;

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



import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;

/**
 * A little implementation of a json write to replace Gson .... because Gson screws up decimal values, and *we care*
 * 
 * @author Grahame Grieve
 *
 */
public class JsonCreatorDirect implements JsonCreator {

  private Writer writer;
  private boolean pretty;
  private boolean comments;
  private boolean named;
  private List<Boolean> valued = new ArrayList<Boolean>();
  private int indent;
  private List<String> commentList = new ArrayList<>(); 
  
  public JsonCreatorDirect(Writer writer, boolean pretty, boolean comments) {
    super();
    this.writer = writer;
    this.pretty = pretty;
    this.comments = pretty && comments;
  }

  @Override
  public void comment(String content) {
    if (comments) {
      commentList.add(content);
    }
  }

  @Override
  public void beginObject() throws IOException {
    checkState();
    writer.write("{");
    stepIn();
    if (!valued.isEmpty()) {
      valued.set(0, true);      
    }
    valued.add(0, false);
  }

  private void commitComments() throws IOException {
    if (comments) {
      for (String s : commentList) {
        writer.write("// ");
        writer.write(s);
        writer.write("\r\n");
        for (int i = 0; i < indent; i++) {
          writer.write("  ");
        }
      }
      commentList.clear();
    }
  }


  public void stepIn() throws IOException {
    if (pretty) {
      indent++;
      writer.write("\r\n");
      for (int i = 0; i < indent; i++) {
        writer.write("  ");
      }
    }
  }

  public void stepOut() throws IOException {
    if (pretty) {
      indent--;
      writer.write("\r\n");
      for (int i = 0; i < indent; i++) {
        writer.write("  ");
      }
    }
  }

  private void checkState() throws IOException {
    commitComments();
    if (named) {
      if (pretty)
        writer.write(" : ");
      else
        writer.write(":");
      named = false;
    }
    if (!valued.isEmpty() && valued.get(0)) {
      writer.write(",");
      if (pretty) {
        writer.write("\r\n");
        for (int i = 0; i < indent; i++) {
          writer.write("  ");
        }        
      }
      valued.set(0, false);
    }
  }

  @Override
  public void endObject() throws IOException {
    stepOut();
    writer.write("}");    
    valued.remove(0);
  }

  @Override
  public void nullValue() throws IOException {
    checkState();
    writer.write("null");
    valued.set(0, true);
  }

  @Override
  public void name(String name) throws IOException {
    checkState();
    writer.write("\""+name+"\"");
    named = true;
  }

  @Override
  public void value(String value) throws IOException {
    checkState();
    writer.write("\""+Utilities.escapeJson(value)+"\"");    
    valued.set(0, true);
  }

  @Override
  public void value(Boolean value) throws IOException {
    checkState();
    if (value == null)
      writer.write("null");
    else if (value.booleanValue())
      writer.write("true");
    else
      writer.write("false");
    valued.set(0, true);
  }

  @Override
  public void value(BigDecimal value) throws IOException {
    checkState();
    if (value == null)
      writer.write("null");
    else 
      writer.write(value.toString());    
    valued.set(0, true);
  }

  @Override
  public void valueNum(String value) throws IOException {
    checkState();
    if (value == null)
      writer.write("null");
    else 
      writer.write(value);    
    valued.set(0, true);
  }

  @Override
  public void value(Integer value) throws IOException {
    checkState();
    if (value == null)
      writer.write("null");
    else 
      writer.write(value.toString());    
    valued.set(0, true);
  }

  @Override
  public void beginArray() throws IOException {
    checkState();
    writer.write("[");    
    if (!valued.isEmpty()) {
      valued.set(0, true);      
    }
    valued.add(0, false);
  }

  @Override
  public void endArray() throws IOException {
    writer.write("]");        
    valued.remove(0);
  }

  @Override
  public void finish() throws IOException {
    writer.flush();
  }

  @Override
  public void link(String href) {
    // not used
    
  }

  @Override
  public void anchor(String name) {
    // not used
  }
       

  @Override
  public void externalLink(String string) {
    // not used
  }
}