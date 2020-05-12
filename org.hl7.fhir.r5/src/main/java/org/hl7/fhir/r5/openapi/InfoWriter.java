package org.hl7.fhir.r5.openapi;

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

import com.google.gson.JsonObject;

public class InfoWriter extends BaseWriter {


  public InfoWriter(JsonObject object) {
    super(object);
  }

  public InfoWriter title(String value) {
    if (!Utilities.noString(value))
      object.addProperty("title", value);
    return this;            
  }

  public InfoWriter description(String value) {
    if (!Utilities.noString(value))
      object.addProperty("description", value);
    return this;            
  }
  
  public InfoWriter termsOfService(String value) {
    if (!Utilities.noString(value))
      object.addProperty("termsOfService", value);
    return this;            
  }

  public InfoWriter version(String value) {
    if (!Utilities.noString(value))
      object.addProperty("version", value);
    return this;            
  }

  public InfoWriter contact(String name, String email, String url) {
    if (name != null && !object.has("contact")) {
      JsonObject person = new JsonObject();
      person.addProperty("name", name);
      if (!Utilities.noString(email))
        person.addProperty("email", email);
      if (!Utilities.noString(url))
        person.addProperty("url", url);
      object.add("contact", person);
    }
    return this;            
  }
  
  public InfoWriter license(String name, String url) {
    JsonObject license = new JsonObject();
    license.addProperty("name", name);
    if (!Utilities.noString(url))
      license.addProperty("url", url);
    object.add("license", license);
    return this;            
  }
  
  
}