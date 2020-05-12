package org.hl7.fhir.utilities.cache;

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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class PackageGenerator {

  public enum PackageType {
    CORE, IG, TOOL, TEMPLATE, SUBSET;

    public String getCode() {
      switch (this) {
      case CORE: return "fhir.core";
      case IG: return "fhir.ig";
      case TOOL: return "fhir.tool";
      case TEMPLATE: return "fhir.template";
      case SUBSET: return "fhir.subset";  
      }
      throw new Error("Unknown Type");
    }
  }
  private OutputStream stream;
  private JsonObject object;

  public PackageGenerator(OutputStream stream) {
    super();
    this.stream = stream;
    object = new JsonObject();
  }
  
  public PackageGenerator(OutputStream stream, InputStream template) throws JsonSyntaxException, IOException {
    super();
    this.stream = stream;
    JsonParser parser = new com.google.gson.JsonParser();
    object = parser.parse(TextFile.streamToString(template)).getAsJsonObject();

  }
  
  public void commit() throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(object);
    OutputStreamWriter sw = new OutputStreamWriter(stream, "UTF-8");
    sw.write('\ufeff');  // Unicode BOM, translates to UTF-8 with the configured outputstreamwriter
    sw.write(json);
    sw.flush();
    sw.close();
  }
  
  public PackageGenerator name(String value) {
    object.addProperty("name", "@fhir/"+value);
    return this;
  }
   
  public PackageGenerator version(String value) {
    object.addProperty("version", value);
    return this;
  }
  
  public PackageGenerator toolsVersion(int value) {
    object.addProperty("tools-version", value);
    return this;
  }
  
  public PackageGenerator description(String value) {
    object.addProperty("description", value);
    return this;    
  }
  
  public PackageGenerator license(String value) {
    object.addProperty("license", value);
    return this;        
  }
  
  public PackageGenerator homepage(String value) {
    object.addProperty("homepage", value);
    return this;            
  }
  
  public PackageGenerator bugs(String value) {
    object.addProperty("bugs", value);
    return this;            
  }
  
  public PackageGenerator author(String name, String email, String url) {
    JsonObject person = new JsonObject();
    person.addProperty("name", name);
    if (!Utilities.noString(email))
      person.addProperty("email", email);
    if (!Utilities.noString(url))
      person.addProperty("url", url);
    object.add("author", person);
    return this;            
  }
  
  public PackageGenerator contributor(String name, String email, String url) {
    JsonObject person = new JsonObject();
    person.addProperty("name", name);
    if (!Utilities.noString(email))
      person.addProperty("email", email);
    if (!Utilities.noString(url))
      person.addProperty("url", url);
    JsonArray c = object.getAsJsonArray("contributors");
    if (c == null) {
      c = new JsonArray();
      object.add("contributors", c);
    }
    c.add(person);
    return this;
  }
  
  public PackageGenerator dependency(String name, String version) {
    JsonObject dep = object.getAsJsonObject("dependencies");
    if (dep == null) {
      dep = new JsonObject();
      object.add("dependencies", dep);
    }
    dep.addProperty(name, version);
    return this;
  }
  
  public PackageGenerator file(String name) {
    JsonArray files = object.getAsJsonArray("files");
    if (files == null) {
      files = new JsonArray();
      object.add("files", files);
    }
    files.add(new JsonPrimitive(name));
    return this;
  }

  public PackageGenerator kind(PackageType kind) {
    object.addProperty("type", kind.getCode());
    return this;     
  }
  
  
}