package org.hl7.fhir.convertors.misc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r4.model.ValueSet.FilterOperator;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.formats.XmlParserBase.XmlVersion;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r4.model.CodeSystem.PropertyType;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r4.utils.ToolingExtensions;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JSONUtil;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ICD11Generator {

  public static void main(String[] args) throws IOException {
    new ICD11Generator().execute(args[0], args[1]);
  }
  
  private void execute(String base, String dest) throws IOException {
    CodeSystem cs = makeMMSCodeSystem();
    JsonObject version = fetchJson(Utilities.pathURL(base, "/icd/release/11/mms"));
    String[] p = version.get("latestRelease").getAsString().split("\\/");
    cs.setVersion(p[6]);
    JsonObject root = fetchJson(url(base, version.get("latestRelease").getAsString()));
    cs.setDateElement(new DateTimeType(root.get("releaseDate").getAsString()));
    for (JsonElement child : root.getAsJsonArray("child")) {
      processMMSEntity(cs, base, child.getAsString(), cs.addConcept(), dest);
      System.out.println();
    }
    new XmlParser(XmlVersion.V1_1).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "icd-11-mms.xml")), cs);
    makeFullVs(dest, cs);
    
    cs = makeEntityCodeSystem();
    root = fetchJson(Utilities.pathURL(base, "/icd/entity"));
    cs.setVersion(root.get("releaseId").getAsString());
    cs.setDateElement(new DateTimeType(root.get("releaseDate").getAsString()));
    cs.setTitle(readString(root,  "title"));
    Set<String> ids = new HashSet<>();    
    for (JsonElement child : root.getAsJsonArray("child")) {
       processEntity(cs, ids, base, tail(child.getAsString()), dest);
       System.out.println();
    }
    new XmlParser(XmlVersion.V1_1).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "icd-11-foundation.xml")), cs);
    makeFullVs2(dest, cs);
    System.out.println("finished");
  }

  private void processEntity(CodeSystem cs, Set<String> ids, String base, String id, String dest) throws IOException {
    if (!ids.contains(id)) {
      System.out.print(".");     
      ids.add(id);
      org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc = cs.addConcept().setCode(id);
      JsonObject entity = fetchJson(Utilities.pathURL(base, "icd", "entity", id));
      cc.setDisplay(readString(entity, "title"));
      String d = readString(entity, "definition");
      if (d != null) {
        cc.setDefinition(d);
      }
      if (entity.has("inclusion")) {
        for (JsonElement child : entity.getAsJsonArray("inclusion")) {
          JsonObject co = (JsonObject) child;
          String v = readString(co, "label");
          if (v != null) {
            if (co.has("foundationReference")) {
              cc.addProperty().setValue(new Coding().setSystem("http://id.who.int/icd11/foundation").setCode(tail(co.get("foundationReference").getAsString())).setDisplay(v)).setCode("inclusion");
            }
          }
        }
      }
      if (entity.has("exclusion")) {
        for (JsonElement child : entity.getAsJsonArray("exclusion")) {
          JsonObject co = (JsonObject) child;
          String v = readString(co, "label");
          if (v != null) {
            if (co.has("foundationReference")) {
              cc.addProperty().setValue(new Coding().setSystem("http://id.who.int/icd11/foundation").setCode(tail(co.get("foundationReference").getAsString())).setDisplay(v)).setCode("exclusion");
            }
          }
        }
      }
      if (entity.has("narrowerTerm")) {
        for (JsonElement child : entity.getAsJsonArray("narrowerTerm")) {
          JsonObject co = (JsonObject) child;
          String v = readString(co, "label");
          if (v != null) {
            if (co.has("narrowerTerm")) {
              cc.addProperty().setValue(new Coding().setSystem("http://id.who.int/icd11/foundation").setCode(tail(co.get("foundationReference").getAsString())).setDisplay(v)).setCode("narrowerTerm");
            }
          }
        }
      }
      addDesignation(readString(entity, "longDefinition"), cc, "http://id.who.int/icd11/mms/designation", "longDefinition");
      addDesignation(readString(entity, "fullySpecifiedName"), cc, "http://snomed.info/sct", "900000000000003001");
      if (entity.has("synonym")) {
        for (JsonElement j : entity.getAsJsonArray("synonym")) {
          String v = readString((JsonObject) j, "label");
          if (v != null && !v.equals(cc.getDisplay())) {
            addDesignation(v, cc, "http://id.who.int/icd11/mms/designation", "synonym");
          }
        }
      }
      for (JsonElement j : entity.getAsJsonArray("parent")) {
        String v = j.getAsString();
        if (!"http://id.who.int/icd/entity".equals(v)) {
          cc.addProperty().setValue(new CodeType(tail(v))).setCode("narrowerTerm");
        }
      }     
      if (entity.has("child")) {
        for (JsonElement j : entity.getAsJsonArray("child")) {
          String v = j.getAsString();
          cc.addProperty().setValue(new CodeType(tail(v))).setCode("child");
          processEntity(cs, ids, base, tail(v), dest);
        }      
      }
    }
  }

  private void makeFullVs(String dest, CodeSystem cs) throws FileNotFoundException, IOException {
    String url = "http://id.who.int/icd11/ValueSet/all-MMS";
    ValueSet vs = new ValueSet();
    vs.setId("all-MMS");
    vs.setUrl(url);
    vs.setName("ICDMMSAll");
    vs.setTitle("Value Set for all ICD MMS Codes");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setExperimental(false);
    vs.setDate(cs.getDate());
    vs.setPublisher("WHO");
    vs.setCopyright("Consult WHO For terms of use");
    vs.setVersion(cs.getVersion());
    vs.setStatus(cs.getStatus());
    ConceptSetComponent inc = vs.getCompose().addInclude();
    inc.setSystem(cs.getUrl());
    new XmlParser(XmlVersion.V1_1).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "vs-all-MMS.xml")), vs);
  }

  private void makeFullVs2(String dest, CodeSystem cs) throws FileNotFoundException, IOException {
    String url = "http://id.who.int/icd11/ValueSet/all-foundation";
    ValueSet vs = new ValueSet();
    vs.setId("all-foundation");
    vs.setUrl(url);
    vs.setName("ICDFoundationAll");
    vs.setTitle("Value Set for all ICD Foundation Concepts");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setExperimental(false);
    vs.setDate(cs.getDate());
    vs.setPublisher("WHO");
    vs.setCopyright("Consult WHO For terms of use");
    vs.setVersion(cs.getVersion());
    vs.setStatus(cs.getStatus());
    ConceptSetComponent inc = vs.getCompose().addInclude();
    inc.setSystem(cs.getUrl());
    new XmlParser(XmlVersion.V1_1).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "vs-all-foundation.xml")), vs);
  }

  private void processMMSEntity(CodeSystem cs, String base, String ref, org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc, String dest) throws IOException {
    System.out.print(".");
    JsonObject entity = fetchJson(url(base, ref));
    cc.setId(tail(ref));
    if (entity.has("code") && !Utilities.noString(entity.get("code").getAsString())) {
      cc.setCode(entity.get("code").getAsString());
    } else if (entity.has("blockId") && !Utilities.noString(entity.get("blockId").getAsString())) {
      cc.setCode(entity.get("blockId").getAsString());
    }  else {
      cc.setCode(cc.getId());
      cc.addProperty().setCode("abstract").setValue(new BooleanType(true));        
    }
    if (entity.has("classKind") && !Utilities.noString(entity.get("classKind").getAsString()) && !"category".equals(entity.get("classKind").getAsString())) {
      cc.addProperty().setCode("kind").setValue(new CodeType(entity.get("classKind").getAsString()));
    }
    cc.setDisplay(readString(entity, "title"));
    StringBuilder defn = new StringBuilder();
    String d = readString(entity, "definition");
    if (d != null) {
      defn.append(d);
    }
    if (d == null && (entity.has("inclusion") || entity.has("exclusion"))) {
      defn.append(cc.getDisplay());
    }
    if (entity.has("inclusion")) {
      defn.append(". Includes: ");
      boolean first = true;
      for (JsonElement child : entity.getAsJsonArray("inclusion")) {
        if (first) first = false; else defn.append(", ");
        defn.append(readString((JsonObject) child, "label"));
      }
    }
    if (entity.has("exclusion")) {
      defn.append(". Excludes: ");
      boolean first = true;
      for (JsonElement child : entity.getAsJsonArray("exclusion")) {
        if (first) first = false; else defn.append(", ");
        JsonObject co = (JsonObject) child;
        String v = readString(co, "label");
        if (v != null) {
          defn.append(v);
          if (co.has("linearizationReference")) {
            cc.addProperty().setValue(new Coding().setSystem("http://id.who.int/icd11/mms").setCode(tail(co.get("linearizationReference").getAsString())).setDisplay(v)).setCode("exclusion");
          }
        }
      }
    }
    cc.setDefinition(defn.toString());
    addDesignation(readString(entity, "longDefinition"), cc, "http://id.who.int/icd11/mms/designation", "longDefinition");
    addDesignation(readString(entity, "fullySpecifiedName"), cc, "http://snomed.info/sct", "900000000000003001");
    addProperty(readString(entity, "codingNote"), cc, "codingNote");
    if (entity.has("indexTerm")) {
//      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("; ");
//      for (JsonElement child : entity.getAsJsonArray("indexTerm")) {
//        processIndexTerm(cc, b, (JsonObject) child);    
//      }
//      if (b.length() > 0) {
//        cc.addProperty().setCode("terms").setValue(new StringType(b.toString()));        
//      }
      for (JsonElement child : entity.getAsJsonArray("indexTerm")) {
        processIndexTerm(cc, (JsonObject) child);    
      }
    }
    if (entity.has("postcoordinationScale")) {
      for (JsonElement child : entity.getAsJsonArray("postcoordinationScale")) {
        JsonObject o = (JsonObject) child;
        String name = tail(o.get("axisName").getAsString());
        ConceptPropertyComponent prop = cc.addProperty();
        prop.setCode("postcoordinationScale");
        prop.setValue(new CodeType(name));
        ToolingExtensions.addBooleanExtension(prop, "http://id.who.int/icd11/extensions/required", o.get("requiredPostcoordination").getAsBoolean());
        ToolingExtensions.addBooleanExtension(prop, "http://id.who.int/icd11/extensions/repeats", o.get("allowMultipleValues").getAsBoolean());
        if (o.has("scaleEntity")) {
          ToolingExtensions.addUriExtension(prop, "http://id.who.int/icd11/extensions/valueSet", buildValueSet(cs, cc.getCode(), name, o, dest));
        }
      }
    }
    if (entity.has("child")) {
      for (JsonElement child : entity.getAsJsonArray("child")) {
        processMMSEntity(cs, base, child.getAsString(), cc.addConcept(), dest);
      }
    }
  }

  private String buildValueSet(CodeSystem cs, String code, String name, JsonObject o, String dest) throws FileNotFoundException, IOException {
    String id = code+"-"+name;
    String url = "http://id.who.int/icd11/ValueSet/"+id;
    ValueSet vs = new ValueSet();
    vs.setId(id);
    vs.setUrl(url);
    vs.setName("VS"+name+"4"+code);
    vs.setTitle("Value Set for "+name+" on "+code);
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setExperimental(false);
    vs.setDate(cs.getDate());
    vs.setPublisher("WHO");
    vs.setCopyright("Consult WHO For terms of use");
    vs.setVersion(cs.getVersion());
    vs.setStatus(cs.getStatus());
    ConceptSetComponent inc = vs.getCompose().addInclude();
    inc.setSystem(cs.getUrl());
    for (JsonElement e : o.getAsJsonArray("scaleEntity")) {
      inc.addFilter().setProperty("concept").setOp(FilterOperator.ISA).setValue(tail(e.getAsString()));
    }    
    new XmlParser(XmlVersion.V1_1).setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "vs-"+id+".xml")), vs);
    return url;
  }

  private void processIndexTerm(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc, JsonObject child) {
    String s = readString(child, "label");
    if (s != null) {
      if (!s.equals(cc.getDisplay())) {
        cc.addDesignation().setValue(s).setUse(new Coding().setSystem("http://id.who.int/icd11/mms/designation").setCode("term"));        
      }
    }    
  }

//  private void processIndexTerm(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc, CommaSeparatedStringBuilder b, JsonObject child) {
//    String s = readString(child, "label");
//    if (s != null) {
//      if (!s.equals(cc.getDisplay())) {
//        b.append(s);        
//      }
//    }
//    
//  }
//
  private String tail(String ref) {
    return ref.substring(ref.lastIndexOf("/")+1);
  }

  private void addExtension(String v, org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc, String url) {
    if (v != null) {
      ToolingExtensions.setStringExtension(cc, url, v);
    }    
  }

  private void addDesignation(String v, org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc, String system, String code) {
    if (v != null) {
      cc.addDesignation().setValue(v.replace("\r", "").replace("\n", "")).setUse(new Coding().setSystem(system).setCode(code));
    }
  }

  private void addProperty(String v, org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent cc, String code) {
    if (v != null) {
      cc.addProperty().setValue(new StringType(v.replace("\r", " ").replace("\n", ""))).setCode(code);
    }
  }

  private String readString(JsonObject obj, String name) {
   JsonObject p = obj.getAsJsonObject(name);
   if (p == null) {
     return null;
   }
   if (p.has("@value")) {
     return p.get("@value").getAsString();
   }
   return null;
  }

  private String url(String base, String u) {
    return u.replace("http://id.who.int", base);
  }

  private CodeSystem makeMMSCodeSystem() {
    CodeSystem cs = new CodeSystem();
    cs.setId("icd11-mms");
    cs.setUrl("http://id.who.int/icd11/mms");
    cs.setName("ICD11MMS");
    cs.setTitle("ICD-11 MMS Linearization");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setExperimental(false);
    cs.setDate(new Date());
    cs.setPublisher("WHO");
    cs.setCopyright("Consult WHO For terms of use");
    cs.setCaseSensitive(true);
    cs.setHierarchyMeaning(CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
    cs.setCompositional(true);
    cs.setVersionNeeded(true);
    cs.setValueSet("http://id.who.int/icd11/ValueSet/all-MMS");
    cs.setContent(CodeSystemContentMode.COMPLETE);
    CodeSystemUtilities.defineCodeSystemProperty(cs, "kind", "The kind of artifact this concept represents", PropertyType.CODE).setUri("http://id.who.int/icd11/properties#kind");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "terms", "Other keywords for searching", PropertyType.STRING).setUri("http://id.who.int/icd11/properties#terms");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "codingNote", "Coding advice for this concept", PropertyType.STRING).setUri("http://id.who.int/icd11/properties#codingNote");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "exclusion", "References to diseases that are excluded from this concept", PropertyType.CODING).setUri("http://id.who.int/icd11/properties#exclusion");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "abstract", "If concept is abstract", PropertyType.BOOLEAN);
    CodeSystemUtilities.defineCodeSystemProperty(cs, "postcoordinationScale", "", PropertyType.CODE).setUri("http://id.who.int/icd11/properties#postcoordinationScale");
    return cs;
  }

  private CodeSystem makeEntityCodeSystem() {
    CodeSystem cs = new CodeSystem();
    cs.setId("icd11-foundation");
    cs.setUrl("http://id.who.int/icd11/foundation");
    cs.setName("ICD11Entity");
    cs.setTitle("ICD-11 Entities (Foundation)");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setExperimental(false);
    cs.setDate(new Date());
    cs.setPublisher("WHO");
    cs.setCopyright("Consult WHO For terms of use");
    cs.setCaseSensitive(true);
    cs.setHierarchyMeaning(CodeSystemHierarchyMeaning.ISA); // though we aren't going to have a heirarchy
//    cs.setCompositional(true);
//    cs.setVersionNeeded(true);
    cs.setValueSet("http://id.who.int/icd11/ValueSet/all-foundation");
    cs.setContent(CodeSystemContentMode.COMPLETE);
    CodeSystemUtilities.defineCodeSystemProperty(cs, "exclusion", "References to diseases that are excluded from this concept", PropertyType.CODING).setUri("http://id.who.int/icd11/properties#exclusion");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "inclusion", "References to diseases that are included from this concept", PropertyType.CODING).setUri("http://id.who.int/icd11/properties#inclusion");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "narrowerTerm", "Narrower terms for this entity", PropertyType.CODE).setUri("http://id.who.int/icd11/properties#narrowerTerm");
    CodeSystemUtilities.defineCodeSystemProperty(cs, "parent", "Parent for this concept", PropertyType.CODE);
    CodeSystemUtilities.defineCodeSystemProperty(cs, "child", "Child for this concept", PropertyType.CODE);
    return cs;
  }


  private JsonObject fetchJson(String source) throws IOException {
    URL url = new URL(source);
    URLConnection c = url.openConnection();
    c.addRequestProperty("Accept", "application/json");
    c.addRequestProperty("API-Version", "v2");
    c.addRequestProperty("Accept-Language", "en");
    return (JsonObject) new com.google.gson.JsonParser().parse(TextFile.streamToString(c.getInputStream()));
  }
  

}