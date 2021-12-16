package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.ldap.StartTlsRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.xml.sax.SAXException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class XVerPackegeFixer {
  
  private static final String R5_FOLDER = "C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r5.core\\package";
  private static final String R4_FOLDER = "C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.core\\package";
  private static final String R3_FOLDER = "C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.core\\package";
  private static final String R2B_FOLDER = "C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.core\\package";
  private static final String R2_FOLDER = "C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.core\\package";
  private static int mod;
  
  private static Map<String, org.hl7.fhir.r5.model.StructureDefinition> map5 = new HashMap<>();
  private static Map<String, org.hl7.fhir.r4.model.StructureDefinition> map4 = new HashMap<>();
  private static Map<String, org.hl7.fhir.dstu3.model.StructureDefinition> map3 = new HashMap<>();
  private static Map<String, org.hl7.fhir.dstu2.model.StructureDefinition> map2 = new HashMap<>();
  private static Map<String, org.hl7.fhir.dstu2016may.model.StructureDefinition> map2b = new HashMap<>();

  public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
    mod = 0;
    for (File f : new File(args[0]).listFiles()) {
      if (f.getName().startsWith("xver-")) {
        JsonObject j = JsonTrackingParser.parseJson(f);
        fixUp(j, f.getName());
        JsonTrackingParser.write(j, f, true);
      }
    }
    System.out.println("all done: "+mod+" modifiers");
  }

  private static void fixUp(JsonObject j, String name) throws FHIRFormatError, FileNotFoundException, IOException {
    name = name.replace(".json",  "");
    System.out.println("Process "+name);
    String version = name.substring(name.lastIndexOf("-")+1);
    int i = 0;
    for (Entry<String, JsonElement> e : j.entrySet()) {
      if (i == 50) {
        i = 0;
        System.out.print(".");
      }
      i++;
      String n = e.getKey();
      JsonObject o = ((JsonObject) e.getValue());
      boolean ok = (o.has("types") && o.getAsJsonArray("types").size() > 0) || (o.has("elements") && o.getAsJsonArray("elements").size() > 0);
      if (!ok) {
        List<String> types = new ArrayList<>(); 
        List<String> elements = new ArrayList<>();
        getElementInfo(version, n, types, elements);
        if (elements.size() > 0) {
          JsonArray arr = o.getAsJsonArray("elements");
          if (arr == null) {
            arr = new JsonArray();
            o.add("elements", arr);
          }
          for (String s : types) {
            arr.add(s);
          }
        } else if (types.size() > 0) {
          JsonArray arr = o.getAsJsonArray("types");
          if (arr == null) {
            arr = new JsonArray();
            o.add("types", arr);
          }
          for (String s : types) {
            arr.add(s);
          }
        }
      }
    }    
    System.out.println("done");
  }

  private static boolean getElementInfo(String version, String n, List<String> types, List<String> elements) throws FHIRFormatError, FileNotFoundException, IOException {
    if ("contained".equals(n.substring(n.indexOf(".")+1))) {
      return false;
    }
    switch (version) {
    case "4.6": return getElementInfoR5(n, types, elements);
    case "4.0": return getElementInfoR4(n, types, elements);
    case "3.0": return getElementInfoR3(n, types, elements);
    case "1.4": return getElementInfoR2B(n, types, elements);
    case "1.0": return getElementInfoR2(n, types, elements);
    }
    return false;
  }

  private static Object tail(String value) {
    return value.contains("/") ? value.substring(value.lastIndexOf("/")+1) : value;
  }

  private static boolean getElementInfoR5(String n, List<String> types, List<String> elements) throws FHIRFormatError, FileNotFoundException, IOException {    
    String tn = n.substring(0, n.indexOf("."));
    org.hl7.fhir.r5.model.StructureDefinition sd = null;
    if (map5.containsKey(tn)) {
      sd = map5.get(tn);
    } else {
      sd = (org.hl7.fhir.r5.model.StructureDefinition) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(R5_FOLDER, "StructureDefinition-"+tn+".json")));
      map5.put(tn, sd);
    }
    for (org.hl7.fhir.r5.model.ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(n)) {
        List<org.hl7.fhir.r5.model.ElementDefinition> children = listChildrenR5(sd.getSnapshot().getElement(), ed);
        if (children.size() > 0) {
          for (org.hl7.fhir.r5.model.ElementDefinition c : children) {
            String en = c.getPath().substring(ed.getPath().length()+1);
            elements.add(en);
          }
        } else {
          for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : ed.getType()) {
            if (t.hasTargetProfile()) {
              StringBuilder b = new StringBuilder();
              b.append(t.getWorkingCode());
              b.append("(");
              boolean first = true;
              for (org.hl7.fhir.r5.model.CanonicalType u : t.getTargetProfile()) {
                if (first) first = false; else b.append("|");
                b.append(tail(u.getValue()));
              }
              b.append(")");
              types.add(b.toString());
            } else {
              types.add(t.getWorkingCode());
            }
          }
        }
      }
    }
    return false;
  }


  private static List<org.hl7.fhir.r5.model.ElementDefinition> listChildrenR5(List<org.hl7.fhir.r5.model.ElementDefinition> list, org.hl7.fhir.r5.model.ElementDefinition ed) {
    List<org.hl7.fhir.r5.model.ElementDefinition> res = new ArrayList<>();
    for (org.hl7.fhir.r5.model.ElementDefinition t : list) {
      String p = t.getPath();
      if (p.startsWith(ed.getPath()+".")) {
        p = p.substring(ed.getPath().length()+1);
        if (!p.contains(".")) {
          res.add(t);
        }
      }
    }
    return res;
  }
  
  private static boolean getElementInfoR4(String n, List<String> types, List<String> elements) throws FHIRFormatError, FileNotFoundException, IOException {    
    String tn = n.substring(0, n.indexOf("."));
    org.hl7.fhir.r4.model.StructureDefinition sd = null;
    if (map4.containsKey(tn)) {
      sd = map4.get(tn);
    } else {
      sd = (org.hl7.fhir.r4.model.StructureDefinition) new org.hl7.fhir.r4.formats.JsonParser().parse(new FileInputStream(Utilities.path(R4_FOLDER, "StructureDefinition-"+tn+".json")));
      map4.put(tn, sd);
    }
    for (org.hl7.fhir.r4.model.ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(n)) {
        List<org.hl7.fhir.r4.model.ElementDefinition> children = listChildrenR4(sd.getSnapshot().getElement(), ed);
        if (children.size() > 0) {
          for (org.hl7.fhir.r4.model.ElementDefinition c : children) {
            String en = c.getPath().substring(ed.getPath().length()+1);
            elements.add(en);
          }
        } else {
          for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : ed.getType()) {
            if (t.hasTargetProfile()) {
              StringBuilder b = new StringBuilder();
              b.append(t.getWorkingCode());
              b.append("(");
              boolean first = true;
              for (org.hl7.fhir.r4.model.CanonicalType u : t.getTargetProfile()) {
                if (first) first = false; else b.append("|");
                b.append(tail(u.getValue()));
              }
              b.append(")");
              types.add(b.toString());
            } else {
              types.add(t.getWorkingCode());
            }
          }
        }
      }
    }
    return false;
  }


  private static List<org.hl7.fhir.r4.model.ElementDefinition> listChildrenR4(List<org.hl7.fhir.r4.model.ElementDefinition> list, org.hl7.fhir.r4.model.ElementDefinition ed) {
    List<org.hl7.fhir.r4.model.ElementDefinition> res = new ArrayList<>();
    for (org.hl7.fhir.r4.model.ElementDefinition t : list) {
      String p = t.getPath();
      if (p.startsWith(ed.getPath()+".")) {
        p = p.substring(ed.getPath().length()+1);
        if (!p.contains(".")) {
          res.add(t);
        }
      }
    }
    return res;
  }
 

  private static boolean getElementInfoR3(String n, List<String> types, List<String> elements) throws FHIRFormatError, FileNotFoundException, IOException {    
    String tn = n.substring(0, n.indexOf("."));
    org.hl7.fhir.dstu3.model.StructureDefinition sd = null;
    if (map3.containsKey(tn)) {
      sd = map3.get(tn);
    } else {
      sd = (org.hl7.fhir.dstu3.model.StructureDefinition) new org.hl7.fhir.dstu3.formats.JsonParser().parse(new FileInputStream(Utilities.path(R3_FOLDER, "StructureDefinition-"+tn+".json")));
      map3.put(tn, sd);
    }
    for (org.hl7.fhir.dstu3.model.ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(n)) {
        List<org.hl7.fhir.dstu3.model.ElementDefinition> children = listChildrenR3(sd.getSnapshot().getElement(), ed);
        if (children.size() > 0) {
          for (org.hl7.fhir.dstu3.model.ElementDefinition c : children) {
            String en = c.getPath().substring(ed.getPath().length()+1);
            elements.add(en);
          }
        } else {
          for (org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent t : ed.getType()) {
            if (t.hasTargetProfile()) {
              StringBuilder b = new StringBuilder();
              b.append(t.getCode());
              b.append("(");
              b.append(tail(t.getTargetProfile()));
              b.append(")");
              types.add(b.toString());
            } else {
              types.add(t.getCode());
            }
          }
        }
      }
    }
    return false;
  }


  private static List<org.hl7.fhir.dstu3.model.ElementDefinition> listChildrenR3(List<org.hl7.fhir.dstu3.model.ElementDefinition> list, org.hl7.fhir.dstu3.model.ElementDefinition ed) {
    List<org.hl7.fhir.dstu3.model.ElementDefinition> res = new ArrayList<>();
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : list) {
      String p = t.getPath();
      if (p.startsWith(ed.getPath()+".")) {
        p = p.substring(ed.getPath().length()+1);
        if (!p.contains(".")) {
          res.add(t);
        }
      }
    }
    return res;
  }
  

  private static boolean getElementInfoR2(String n, List<String> types, List<String> elements) throws FHIRFormatError, FileNotFoundException, IOException {    
    String tn = n.substring(0, n.indexOf("."));
    org.hl7.fhir.dstu2.model.StructureDefinition sd = null;
    if (map2.containsKey(tn)) {
      sd = map2.get(tn);
    } else {
      sd = (org.hl7.fhir.dstu2.model.StructureDefinition) new org.hl7.fhir.dstu2.formats.JsonParser().parse(new FileInputStream(Utilities.path(R2_FOLDER, "StructureDefinition-"+tn+".json")));
      map2.put(tn, sd);
    }
    for (org.hl7.fhir.dstu2.model.ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(n)) {
        List<org.hl7.fhir.dstu2.model.ElementDefinition> children = listChildrenR2(sd.getSnapshot().getElement(), ed);
        if (children.size() > 0) {
          for (org.hl7.fhir.dstu2.model.ElementDefinition c : children) {
            String en = c.getPath().substring(ed.getPath().length()+1);
            elements.add(en);
          }
        } else {
          for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : ed.getType()) {
            if (t.hasProfile()) {
              StringBuilder b = new StringBuilder();
              b.append(t.getCode());
              b.append("(");
              boolean first = true;
              for (org.hl7.fhir.dstu2.model.UriType u : t.getProfile()) {
                if (first) first = false; else b.append("|");
                b.append(tail(u.getValue()));
              }
              b.append(")");
              types.add(b.toString());
            } else {
              types.add(t.getCode());
            }
          }
        }
      }
    }
    return false;
  }


  private static List<org.hl7.fhir.dstu2.model.ElementDefinition> listChildrenR2(List<org.hl7.fhir.dstu2.model.ElementDefinition> list, org.hl7.fhir.dstu2.model.ElementDefinition ed) {
    List<org.hl7.fhir.dstu2.model.ElementDefinition> res = new ArrayList<>();
    for (org.hl7.fhir.dstu2.model.ElementDefinition t : list) {
      String p = t.getPath();
      if (p.startsWith(ed.getPath()+".")) {
        p = p.substring(ed.getPath().length()+1);
        if (!p.contains(".")) {
          res.add(t);
        }
      }
    }
    return res;
  }
  

  private static boolean getElementInfoR2B(String n, List<String> types, List<String> elements) throws FHIRFormatError, FileNotFoundException, IOException {    
    String tn = n.substring(0, n.indexOf("."));
    org.hl7.fhir.dstu2016may.model.StructureDefinition sd = null;
    if (map2b.containsKey(tn)) {
      sd = map2b.get(tn);
    } else {
      sd = (org.hl7.fhir.dstu2016may.model.StructureDefinition) new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new FileInputStream(Utilities.path(R2B_FOLDER, "StructureDefinition-"+tn+".json")));
      map2b.put(tn, sd);
    }
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(n)) {
        List<org.hl7.fhir.dstu2016may.model.ElementDefinition> children = listChildrenR2B(sd.getSnapshot().getElement(), ed);
        if (children.size() > 0) {
          for (org.hl7.fhir.dstu2016may.model.ElementDefinition c : children) {
            String en = c.getPath().substring(ed.getPath().length()+1);
            elements.add(en);
          }
        } else {
          for (org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent t : ed.getType()) {
            if (t.hasProfile()) {
              StringBuilder b = new StringBuilder();
              b.append(t.getCode());
              b.append("(");
              boolean first = true;
              for (org.hl7.fhir.dstu2016may.model.UriType u : t.getProfile()) {
                if (first) first = false; else b.append("|");
                b.append(tail(u.getValue()));
              }              
              b.append(")");
              types.add(b.toString());
            } else {
              types.add(t.getCode());
            }
          }
        }
      }
    }
    return false;
  }


  private static List<org.hl7.fhir.dstu2016may.model.ElementDefinition> listChildrenR2B(List<org.hl7.fhir.dstu2016may.model.ElementDefinition> list, org.hl7.fhir.dstu2016may.model.ElementDefinition ed) {
    List<org.hl7.fhir.dstu2016may.model.ElementDefinition> res = new ArrayList<>();
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : list) {
      String p = t.getPath();
      if (p.startsWith(ed.getPath()+".")) {
        p = p.substring(ed.getPath().length()+1);
        if (!p.contains(".")) {
          res.add(t);
        }
      }
    }
    return res;
  }
  

}
