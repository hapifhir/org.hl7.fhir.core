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



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.hl7.fhir.utilities.TextFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Writer extends BaseWriter {

  private OutputStream stream;
  
  public Writer(OutputStream stream) {
    super( new JsonObject());
    this.stream = stream;
    object.addProperty("openapi", "3.0.2");
  }
  
  public Writer(OutputStream stream, InputStream template) throws JsonSyntaxException, IOException {
    super(parse(template));
    this.stream = stream;
    object.addProperty("openapi", "3.0.2");
  }
  
  private static JsonObject parse(InputStream template) throws JsonSyntaxException, IOException {
    JsonParser parser = new com.google.gson.JsonParser();
    return parser.parse(TextFile.streamToString(template)).getAsJsonObject();
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

  public InfoWriter info() {
    return new InfoWriter(ensureObject("info"));
  }

  public PathItemWriter path(String path) {
    return new PathItemWriter(ensureMapObject("paths", path));
  }

  public Writer pathRef(String path, String url) {
    ensureMapObject("paths", path).addProperty("$ref", url);
    return this;
  }


  public ServerWriter server(String url) {
    return new ServerWriter(ensureArrayObject("servers", "url", url)); 
  }
   

  public TagWriter tag(String name) {
    return new TagWriter(ensureArrayObject("tags", "name", name)); 
  }
   
  public ExternalDocsWriter externalDocs() {
    return new ExternalDocsWriter(ensureObject("externalDocs"));            
  }


  public ComponentsWriter components() {
    return new ComponentsWriter(ensureObject("components"));
  }

}