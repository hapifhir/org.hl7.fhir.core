package org.hl7.fhir.r4b.model;

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

import org.hl7.fhir.exceptions.FHIRException;

public class Tuple extends Base {

  private static final long serialVersionUID = -8402411970797277451L;
  private Map<String, List<Base>> properties = new HashMap<>();

  public static Tuple fromMapList(Map<String, List<Base>> map) {
    Tuple res = new Tuple();
    res.properties.putAll(map);
    return res;
  }

  public static Tuple fromMap(Map<String, Base> map) {
    Tuple res = new Tuple();
    for (String key : map.keySet()) {
      List<Base> list = new ArrayList<>();
      list.add(map.get(key));
      res.properties.put(key, list);
    }
    return res;
  }

  @Override
  public String fhirType() {
    return "Tuple";
  }

  @Override
  protected void listChildren(List<Property> result) {
    for (String s : properties.keySet()) {
      result.add(new Property(s, "Base", null, 0, 1, properties.get(s)));
    }
  }

  @Override
  public String getIdBase() {
    return null;
  }

  @Override
  public void setIdBase(String value) {
  }

  public void addProperty(String s, List<Base> list) {
    properties.put(s, list);
  }

  public Base[] listChildrenByName(String name, boolean checkValid) throws FHIRException {
    if (name.equals("*")) {
      List<Property> children = new ArrayList<Property>();
      listChildren(children);
      List<Base> result = new ArrayList<Base>();
      for (Property c : children)
        result.addAll(c.getValues());
      return result.toArray(new Base[result.size()]);
    } else if (properties.containsKey(name)) {
      return properties.get(name).toArray(new Base[0]);
    }
    return getProperty(name.hashCode(), name, checkValid);
  }

  @Override
  public Base copy() {
    Tuple tuple = new Tuple();
    copyValues(tuple);
    return tuple;
  }

}