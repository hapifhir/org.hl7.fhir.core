package org.hl7.fhir.convertors.misc;

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



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class PackageMaintainer {
  
  
  private static final String PATH = "C:\\work\\org.hl7.fhir\\packages\\core";

  public static void main(String[] args) throws IOException {
    new PackageMaintainer().check("r4");
    new PackageMaintainer().check("r2");
    new PackageMaintainer().check("r3");
    new PackageMaintainer().check("r2b");
  }

  private void check(String ver) throws IOException {
    System.out.println("Check "+ver);
    List<String> allIds = listResources(Utilities.path(PATH, "hl7.fhir."+ver+".examples", "package"));
    List<String> coreIds = listResources(Utilities.path(PATH, "hl7.fhir."+ver+".core", "package"));
    for (String s : coreIds) {
      if (!allIds.contains(s)) {
        System.out.println("Core contains "+s+" but allIds doesn't");
      }
    }
    for (String s : allIds) {
      if (!coreIds.contains(s)) {
        String c = s.substring(0, s.indexOf("-"));
        if (Utilities.existsInList(c, "CodeSystem", "ValueSet", "ConceptMap", "StructureDefinition", "StructureMap", "NamingSystem", "SearchParameter", "OperationDefinition", "CapabilityStatement", "Conformance"))
          System.out.println("Examples contains "+s+" but core doesn't");
      }
    }
    strip(new File(Utilities.path(PATH, "hl7.fhir."+ver+".core", "package")));
    strip(new File(Utilities.path(PATH, "hl7.fhir."+ver+".expansions", "package")));
    if (!ver.equals("r2b"))
      strip(new File(Utilities.path(PATH, "hl7.fhir."+ver+".elements", "package")));
  }

  
  private List<String> listResources(String dir) {
    File folder = new File(dir);
    List<String> res = new ArrayList<>();
    for (String fn : folder.list()) {      
      if (fn.endsWith(".json") && fn.contains("-")) {
        String s = fn;
        s = s.substring(0, s.indexOf("."));
        res.add(s);
      }
    }
    return res;
  }

  private void strip(File folder) throws IOException {
    for (File f : folder.listFiles()) {
      if (f.isDirectory())
        strip(f);
      else if (f.getName().endsWith(".json")) {
        JsonObject json = JsonTrackingParser.parseJson(f);
        if (json.has("resourceType") && json.has("text")) {
          json.remove("text");
          Gson gson = new GsonBuilder().create();
          String src = gson.toJson(json);
          TextFile.stringToFile(src, f.getAbsolutePath());
        }
      }
    }    
  }
 
}