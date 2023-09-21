package org.hl7.fhir.utilities;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

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



/**
 * Encapsulates StringBuilder to build strings of values separated by comma
 * @author Ewout
 */

public class CommaSeparatedStringBuilder {

  boolean first = true;
  String sep = ", ";
  StringBuilder b = new StringBuilder();
  int count = 0;
  String pending = null;
  private String lastSep;

  public CommaSeparatedStringBuilder() {
    this.sep = ", ";
    this.lastSep = ", ";
  }
  
  public CommaSeparatedStringBuilder(String sep) {
    this.sep = sep;
    this.lastSep = sep;
  }

  public CommaSeparatedStringBuilder(String sep, String lastSep) {
    this.sep = sep;
    this.lastSep = lastSep;
  }

  private void commit(boolean last) {
    if (pending != null) {
      if (!first) {
        if (last) {
          b.append(lastSep);
        } else {
          b.append(sep);
        }
      }
      b.append(pending);
      pending = null;
      first = false;  
    }
  }
  public void append(String value) {
    commit(false);
    pending = value;
    count++;    
  }
  
  public int length() {
    commit(false);
    return b.length();
  }
  
  public int count() {
    return count;
  }

  @Override
  public String toString() {
    commit(true);
    return b.toString();
  }

  public void appendIfNotNull(String s) {
   if (!Utilities.noString(s))
     append(s);
    
  }

  public void addAll(List<String> list) {
    for (String s : list) {
      appendIfNotNull(s);
    }
    
  }

  public static String join(String sep, Collection<String> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(sep);
    for (String s : list) {
      b.append(s);
    }
    return b.toString();
  }

  public static String join(String sep, String[] list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(sep);
    for (String s : list) {
      b.append(s);
    }
    return b.toString();
  }

  public static String build(List<String> list) {
    CommaSeparatedStringBuilder self = new CommaSeparatedStringBuilder();
    for (String s : list) {
      self.append(s);
    }
    return self.toString();
  }


  public static String buildObjects(List<? extends Object> list) {
    CommaSeparatedStringBuilder self = new CommaSeparatedStringBuilder();
    for (Object s : list) {
      self.append(s.toString());
    }
    return self.toString();
  }
  
  public static Set<String> toSet(String source) {
    if (source == null) {
      return null;
    }
    Set<String> res = new HashSet<>();
    if (!Utilities.noString(source)) {
      for (String s : source.split("\\,")) {
        res.add(s.trim());
      }
    }
    return res;
  }
}