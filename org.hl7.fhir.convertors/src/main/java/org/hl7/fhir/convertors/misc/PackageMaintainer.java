package org.hl7.fhir.convertors.misc;

/*-
 * #%L
 * org.hl7.fhir.convertors
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
