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



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MimeType {

  private String source;
  private String base;
  private Map<String, String> params = new HashMap<String, String>();

  public MimeType(String s) {
    source = s;
    for (String p : s.split("\\;"))
      if (base == null)
        base = p;
      else
        params.put(p.substring(0, p.indexOf("=")), p.substring(p.indexOf("=")+1));
    if ("xml".equals(base))
      base = "application/fhir+xml";
    if ("json".equals(base))
      base = "application/fhir+json";
    if ("ttl".equals(base))
      base = "application/fhir+ttl";
  }

  public String main() {
    if (base.contains("/"))
      return base.substring(0, base.indexOf("/"));
    else
      return base;
  }

  public String sub() {
    if (base.contains("/"))
      return base.substring(base.indexOf("/")+1);
    else
      return null;
  }

  public boolean hasParam(String name) {
    return params.containsKey(name);
  }

  public boolean isValid() {
    return (Utilities.existsInList(main(), "application", "audio", "font", "example", "image", "message", "model", "multipart", "text", "video") || main().startsWith("x-")) && !Utilities.noString(sub());
  }

  public static List<MimeType> parseList(String s) {
    List<MimeType> result = new ArrayList<MimeType>();
    for (String e : s.split("\\,"))
        result.add(new MimeType(e));
    return result;
  }

  public String display() {
    return source;
  }

}