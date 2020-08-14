package org.hl7.fhir.utilities.graphql;

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
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Argument {
  public enum ArgumentListStatus {NOT_SPECIFIED, SINGLETON, REPEATING}
  String name;
  private List<Value> values = new ArrayList<Value>();
  ArgumentListStatus listStatus;
  public Argument() {
    super();
  }
  public Argument(String name, Value value) {
    super();
    this.name = name;
    this.values.add(value);
  }
  public Argument(String name, JsonElement json) throws EGraphQLException {
    super();
    this.name = name;
    valuesFromNode(json);
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public ArgumentListStatus getListStatus() {
    return listStatus;
  }
  public void setListStatus(ArgumentListStatus listStatus) {
    this.listStatus = listStatus;
  }
  public List<Value> getValues() {
    return values;
  }
  public void addValue(Value value){ 
    values.add(value);
  }

  public boolean hasValue(String value) {
    for (Value v : values ) 
      if (v.isValue(value)) 
        return true;
    return false;
  }

  public void valuesFromNode(JsonElement json) throws EGraphQLException {
    if (json instanceof JsonPrimitive && ((JsonPrimitive) json).isString())
      values.add(new StringValue(((JsonPrimitive)json).getAsString()));
    else if (json instanceof JsonPrimitive && ((JsonPrimitive) json).isNumber())
      values.add(new NumberValue(((JsonPrimitive)json).getAsString()));
    else if (json instanceof JsonPrimitive && ((JsonPrimitive) json).isBoolean())
      values.add(new NameValue(((JsonPrimitive)json).getAsBoolean()));
    else if (json instanceof JsonObject)
      values.add(new ObjectValue((JsonObject) json));
    else if (json instanceof JsonArray) {
      for (JsonElement v : (JsonArray) json)
        valuesFromNode(v);
    } else
      throw new EGraphQLException("Unexpected JSON type for \""+name+"\": "+json.getClass().getName());
  }

  public void write(StringBuilder b, int indent) throws EGraphQLException, EGraphEngine {
    b.append("\"");
    for (char ch : name.toCharArray()) {
      if (ch == '"') b.append("\"");
      else if (ch == '\\') b.append("\\");
      else if (ch == '\r') b.append("\\r");
      else if (ch == '\n') b.append("\\n");
      else if (ch == '\t') b.append("\\t");
      else if (ch < 32)
        b.append("\\u"+Integer.toHexString(ch));
      else
        b.append(ch);
    }
    b.append("\":");
    if (listStatus == ArgumentListStatus.REPEATING) {
      b.append("[");
      boolean first = true;
      for (Value v : values) {
        if (first) first = false; else b.append(",");
        v.write(b, indent);
      }
      b.append("]");
    } else {
      if (values.size() > 1)
        throw new EGraphQLException("Internal error: non list \""+name+"\" has "+Integer.toString(values.size())+" values");
      if (values.size() == 0)
        b.append("null");
      else
        values.get(0).write(b, indent);
    }
  }
}