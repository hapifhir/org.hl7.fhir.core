package org.hl7.fhir.model.utilities.formats;

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


import org.hl7.fhir.utilities.Utilities;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A little implementation of a json write to replace Gson .... because Gson screws up decimal values, and *we care*
 * 
 * @author Grahame Grieve
 *
 */
public class JsonCreatorDirect implements JsonCreator {

  /**
   * Composition is a long run of tiny writes, so the output is collected here and handed to the writer in
   * blocks. Small on purpose: this buffer is allocated per composition, and most compositions are small
   * (a Coding for a cache key, an element for a diff). At 8192 chars the allocation and zeroing of the
   * buffer cost more than everything else in a small composition put together - it was about 2us of the
   * 3.2us it took to compose an empty Coding. Larger buffers do not measurably help large documents
   */
  private static final int BUFFER_SIZE = 256;

  /**
   * "\r\n" followed by two spaces per level, for the depths a resource actually reaches. Writing the
   * newline and the indent as one string beats a loop that writes "  " once per level
   */
  private static final String[] INDENTS = makeIndents(64);

  private static String[] makeIndents(int depth) {
    String[] res = new String[depth];
    StringBuilder b = new StringBuilder("\r\n");
    for (int i = 0; i < depth; i++) {
      res[i] = b.toString();
      b.append("  ");
    }
    return res;
  }

  private Writer writer;
  private boolean pretty;
  private boolean comments;
  private boolean named;
  private int indent;
  private List<String> commentList = new ArrayList<>(); 

  private final char[] buffer = new char[BUFFER_SIZE];
  private int length;

  /**
   * whether the object or array at each depth has had a value written yet, so checkState knows if it owes a
   * comma. A stack, pushed and popped at every brace - it used to be an ArrayList&lt;Boolean&gt; indexed at
   * 0, which meant an arraycopy of the whole stack on every push and pop
   */
  private boolean[] valued = new boolean[64];
  private int depth;
  
  public JsonCreatorDirect(Writer writer, boolean pretty, boolean comments) {
    super();
    // No BufferedWriter: this class buffers into its own char[] (see BUFFER_SIZE), which costs neither a
    // synchronized call nor a charset encode per token, and does not allocate a BufferedWriter's 8192 char
    // buffer per composition. finish() flushes, so every caller that finishes is safe (note:
    // JsonCreatorCanonical must call jj.finish())
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

  private void append(String s) throws IOException {
    int n = s.length();
    if (length + n > BUFFER_SIZE) {
      flushBuffer();
      if (n > BUFFER_SIZE) {
        writer.write(s);
        return;
      }
    }
    s.getChars(0, n, buffer, length);
    length = length + n;
  }

  private void flushBuffer() throws IOException {
    if (length > 0) {
      writer.write(buffer, 0, length);
      length = 0;
    }
  }

  private void push() {
    if (depth == valued.length) {
      valued = Arrays.copyOf(valued, valued.length * 2);
    }
    valued[depth++] = false;
  }

  private void pop() {
    if (depth > 0) {
      depth--;
    }
  }

  private boolean valued() {
    return depth > 0 && valued[depth - 1];
  }

  private void setValued(boolean value) {
    if (depth > 0) {
      valued[depth - 1] = value;
    }
  }

  private void writeIndent() throws IOException {
    append(indent < INDENTS.length ? INDENTS[indent] : makeIndent(indent));
  }

  private String makeIndent(int level) {
    StringBuilder b = new StringBuilder("\r\n");
    for (int i = 0; i < level; i++) {
      b.append("  ");
    }
    return b.toString();
  }

  @Override
  public void beginObject() throws IOException {
    checkState();
    append("{");
    stepIn();
    setValued(true);
    push();
  }

  private void commitComments() throws IOException {
    if (comments) {
      for (String s : commentList) {
        append("// ");
        append(s);
        writeIndent();
      }
      commentList.clear();
    }
  }


  public void stepIn() throws IOException {
    if (pretty) {
      indent++;
      writeIndent();
    }
  }

  public void stepOut() throws IOException {
    if (pretty) {
      indent--;
      writeIndent();
    }
  }

  private void checkState() throws IOException {
    commitComments();
    if (named) {
      append(pretty ? " : " : ":");
      named = false;
    }
    if (valued()) {
      append(",");
      if (pretty) {
        writeIndent();
      }
      setValued(false);
    }
  }

  @Override
  public void endObject() throws IOException {
    stepOut();
    append("}");
    pop();
  }

  @Override
  public void nullValue() throws IOException {
    checkState();
    append("null");
    setValued(true);
  }

  @Override
  public void name(String name) throws IOException {
    checkState();
    append("\"");
    append(name);
    append("\"");
    named = true;
  }

  @Override
  public void value(String value) throws IOException {
    checkState();
    append("\"");
    append(Utilities.escapeJson(value));
    append("\"");
    setValued(true);
  }

  @Override
  public void value(Boolean value) throws IOException {
    checkState();
    if (value == null)
      append("null");
    else if (value.booleanValue())
      append("true");
    else
      append("false");
    setValued(true);
  }

  @Override
  public void value(BigDecimal value) throws IOException {
    checkState();
    if (value == null)
      append("null");
    else 
      append(value.toString());
    setValued(true);
  }

  @Override
  public void valueNum(String value) throws IOException {
    checkState();
    if (value == null)
      append("null");
    else 
      append(value);
    setValued(true);
  }

  @Override
  public void value(Integer value) throws IOException {
    checkState();
    if (value == null)
      append("null");
    else 
      append(value.toString());
    setValued(true);
  }

  @Override
  public void beginArray() throws IOException {
    checkState();
    append("[");
    setValued(true);
    push();
  }

  @Override
  public void endArray() throws IOException {
    append("]");
    pop();
  }

  @Override
  public void finish() throws IOException {
    flushBuffer();
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

  @Override
  public boolean canElide() { return false; }

  @Override
  public void elide() {
    // not used
  }
  
  @Override
  public boolean isCanonical() {
    return false;
  }

  
}