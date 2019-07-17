package org.hl7.fhir.r5.openapi;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
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
