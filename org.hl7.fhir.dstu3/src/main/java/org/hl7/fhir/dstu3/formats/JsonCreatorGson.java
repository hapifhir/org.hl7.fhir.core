package org.hl7.fhir.dstu3.formats;

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
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

import com.google.gson.stream.JsonWriter;

public class JsonCreatorGson implements JsonCreator {

  JsonWriter gson;
  
  public JsonCreatorGson(OutputStreamWriter osw) {
    gson = new JsonWriter(osw);
  }

  @Override
  public void setIndent(String indent) {
    gson.setIndent(indent);
  }

  @Override
  public void beginObject() throws IOException {
    gson.beginObject();    
  }

  @Override
  public void endObject() throws IOException {
    gson.endObject();
  }

  @Override
  public void nullValue() throws IOException {
    gson.nullValue();
  }

  @Override
  public void name(String name) throws IOException {
    gson.name(name);
  }

  @Override
  public void value(String value) throws IOException {
    gson.value(value);
  }

  @Override
  public void value(Boolean value) throws IOException {
    gson.value(value);
  }

  @Override
  public void value(BigDecimal value) throws IOException {
    gson.value(value);
  }

  @Override
  public void value(Integer value) throws IOException {
    gson.value(value);
  }

  @Override
  public void beginArray() throws IOException {
    gson.beginArray();
  }

  @Override
  public void endArray() throws IOException {
    gson.endArray();
  }

  @Override
  public void finish() {
    // nothing to do here
    
  }

  @Override
  public void link(String href) {
    // not used
  }

}