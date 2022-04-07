package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.naming.ldap.StartTlsRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.misc.XVerPackegeFixer.References;
import org.hl7.fhir.dstu2.model.ElementDefinition;
import org.hl7.fhir.dstu2.model.StructureDefinition;
import org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.xml.sax.SAXException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class XVerPackegeFixer {
  
  public static class References {
    private boolean modifier;
    private boolean inherited;

    public boolean getModifier() {
      return modifier;
    }

    public void setModifier(boolean value) {
      this.modifier = value;
    }

    public boolean getInherited() {
      return inherited;
    }

    public void setInherited(boolean inherited) {
      this.inherited = inherited;
    }
    
  }


  private static final String R5_FOLDER =  "/Users/grahamegrieve/work/packages/hl7.fhir.rX/hl7.fhir.r5.core/package";
  private static final String R4_FOLDER =  "/Users/grahamegrieve/work/packages/hl7.fhir.rX/hl7.fhir.r4.core/package";
  private static final String R3_FOLDER =  "/Users/grahamegrieve/work/packages/hl7.fhir.rX/hl7.fhir.r3.core/package";
  private static final String R2B_FOLDER = "/Users/grahamegrieve/work/packages/hl7.fhir.rX/hl7.fhir.r2b.core/package";
  private static final String R2_FOLDER =  "/Users/grahamegrieve/work/packages/hl7.fhir.rX/hl7.fhir.r2.core/package";
  private static int modCount;
  
  private static Map<String, org.hl7.fhir.r5.model.StructureDefinition> map5 = new HashMap<>();
  private static Map<String, org.hl7.fhir.r4.model.StructureDefinition> map4 = new HashMap<>();
  private static Map<String, org.hl7.fhir.dstu3.model.StructureDefinition> map3 = new HashMap<>();
  private static Map<String, org.hl7.fhir.dstu2.model.StructureDefinition> map2 = new HashMap<>();
  private static Map<String, org.hl7.fhir.dstu2016may.model.StructureDefinition> map2b = new HashMap<>();

  public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
    modCount = 0;
    for (File f : new File(args[0]).listFiles()) {
      if (f.getName().startsWith("xver-") && f.getName().contains("1.0")) {
        JsonObject j = JsonTrackingParser.parseJson(f);
        fixUp(j, f.getName());
        JsonTrackingParser.write(j, f, true);
      }
    }
    System.out.println("all done: "+modCount+" modifiers");
  }

  private static void fixUp(JsonObject j, String name) throws FHIRFormatError, FileNotFoundException, IOException {
    name = name.replace(".json",  "");
    System.out.println("Process "+name);
    String version = name.substring(name.lastIndexOf("-")+1);
    Set<String> pr = new HashSet<>();
    
    int i = 0;
    for (Entry<String, JsonElement> e : j.entrySet()) {
      if (i == 50) {
        i = 0;
        System.out.print(".");
      }
      i++;
      String n = e.getKey();
      JsonObject o = ((JsonObject) e.getValue());
      // boolean ok = (o.has("types") && o.getAsJsonArray("types").size() > 0) || (o.has("elements") && o.getAsJsonArray("elements").size() > 0);
//      if (!ok) {
      if (o.has("types")) {
        o.remove("types");
      }
      if (o.has("elements")) {
        o.remove("elements");
      }
      if (o.has("modifier")) {
        o.remove("modifier");
      }
        List<String> types = new ArrayList<>(); 
        List<String> elements = new ArrayList<>();
        References mod = new References();
        getElementInfo(version, n, types, elements, mod);
        if (mod.getInherited()) {
          pr.add(n);
        }
        if (elements.size() > 0) {
          JsonArray arr = o.getAsJsonArray("elements");
          if (arr == null) {
            arr = new JsonArray();
            o.add("elements", arr);
          }
          for (String s : elements) {
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
        if (mod.getModifier()) {
          o.addProperty("modifier", true);
          modCount++;
        }
//      }
    }    
    for (String s : pr) {
      j.remove(s);
    }
    System.out.println("done");
  }

  private static boolean getElementInfo(String version, String n, List<String> types, List<String> elements, References mod) throws FHIRFormatError, FileNotFoundException, IOException {
//    if ("contained".equals(n.substring(n.indexOf(".")+1))) {
//      return false;
//    }
    switch (version) {
    case "4.6": return getElementInfoR5(n, types, elements, mod);
    case "4.0": return getElementInfoR4(n, types, elements, mod);
    case "3.0": return getElementInfoR3(n, types, elements, mod);
    case "1.4": return getElementInfoR2B(n, types, elements, mod);
    case "1.0": return getElementInfoR2(n, types, elements, mod);
    }
    return false;
  }

  private static String tail(String value) {
    return value.contains("/") ? value.substring(value.lastIndexOf("/")+1) : value;
  }

  private static boolean getElementInfoR5(String n, List<String> types, List<String> elements, References mod) throws FHIRFormatError, FileNotFoundException, IOException {    
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
        mod.setModifier(ed.getIsModifier());
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
  
  private static boolean getElementInfoR4(String n, List<String> types, List<String> elements, References mod) throws FHIRFormatError, FileNotFoundException, IOException {    
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
        mod.setModifier(ed.getIsModifier());
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
 

  private static boolean getElementInfoR3(String n, List<String> types, List<String> elements, References mod) throws FHIRFormatError, FileNotFoundException, IOException {    
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
        mod.setModifier(ed.getIsModifier());
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
  

  private static boolean getElementInfoR2(String n, List<String> types, List<String> elements, References mod) throws FHIRFormatError, FileNotFoundException, IOException {    
    String tn = n.substring(0, n.indexOf("."));
    org.hl7.fhir.dstu2.model.StructureDefinition sd = null;
    sd = loadType(tn);
    mod.setInherited(isInherited(n, sd));
    for (org.hl7.fhir.dstu2.model.ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(n)) {
        mod.setModifier(ed.getIsModifier());
        List<org.hl7.fhir.dstu2.model.ElementDefinition> children = listChildrenR2(sd.getSnapshot().getElement(), ed);
        if (children.size() > 0) {
          for (org.hl7.fhir.dstu2.model.ElementDefinition c : children) {
            String en = c.getPath().substring(ed.getPath().length()+1);
            elements.add(en);
          }
        } else {
          boolean isReference = false;
          StringBuilder r = new StringBuilder();
          r.append("Reference(");
          for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : ed.getType()) {
            if (t.hasProfile()) {
              if ("Reference".equals(t.getCode())) {
                for (org.hl7.fhir.dstu2.model.UriType u : t.getProfile()) {
                  if (isReference) 
                    r.append("|");
                  r.append(tail(u.getValue()));
                  isReference = true;
                }              
              } else {
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
              }
            } else {
              types.add(t.getCode());
            }
          }
          if (isReference) {
            r.append(")");
            types.add(r.toString());              
          }
        }
      }
    }
    return false;
  }

  private static org.hl7.fhir.dstu2.model.StructureDefinition loadType(String tn)
      throws IOException, FileNotFoundException {
    org.hl7.fhir.dstu2.model.StructureDefinition sd;
    if (map2.containsKey(tn)) {
      sd = map2.get(tn);
    } else {
      sd = (org.hl7.fhir.dstu2.model.StructureDefinition) new org.hl7.fhir.dstu2.formats.JsonParser().parse(new FileInputStream(Utilities.path(R2_FOLDER, "StructureDefinition-"+tn+".json")));
      map2.put(tn, sd);
    }
    return sd;
  }


  private static boolean isInherited(String n, StructureDefinition sd) throws FileNotFoundException, IOException {
    String tail = n.substring(n.indexOf(".")+1);
    while (sd != null) {
      sd = sd.hasBase() ? loadType(tail(sd.getBase())) : null;
      if (sd != null && hasPath(sd.getSnapshot(), sd.getName()+"."+tail)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasPath(StructureDefinitionSnapshotComponent snapshot, String path) {
    for (ElementDefinition ed : snapshot.getElement()) {
      if (ed.getPath().equals(path)) {
        return true;
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
  

  private static boolean getElementInfoR2B(String n, List<String> types, List<String> elements, References mod) throws FHIRFormatError, FileNotFoundException, IOException {    
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
        mod.setModifier(ed.getIsModifier());
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
