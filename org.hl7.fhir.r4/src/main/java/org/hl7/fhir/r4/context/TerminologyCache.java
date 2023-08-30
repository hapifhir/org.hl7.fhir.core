package org.hl7.fhir.r4.context;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r4.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r4.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * This implements a two level cache. 
 *  - a temporary cache for remmbering previous local operations
 *  - a persistent cache for rembering tx server operations
 *  
 * the cache is a series of pairs: a map, and a list. the map is the loaded cache, the list is the persiistent cache, carefully maintained in order for version control consistency
 * 
 * @author graha
 *
 */
public class TerminologyCache {
  public static final boolean TRANSIENT = false;
  public static final boolean PERMANENT = true;
  private static final String NAME_FOR_NO_SYSTEM = "all-systems";
  private static final String ENTRY_MARKER = "-------------------------------------------------------------------------------------";
  private static final String BREAK = "####";

  private SystemNameKeyGenerator systemNameKeyGenerator = new SystemNameKeyGenerator();

  protected SystemNameKeyGenerator getSystemNameKeyGenerator() {
    return systemNameKeyGenerator;
  }

  public class SystemNameKeyGenerator {
    public static final String SNOMED_SCT_CODESYSTEM_URL = "http://snomed.info/sct";
    public static final String RXNORM_CODESYSTEM_URL = "http://www.nlm.nih.gov/research/umls/rxnorm";
    public static final String LOINC_CODESYSTEM_URL = "http://loinc.org";
    public static final String UCUM_CODESYSTEM_URL = "http://unitsofmeasure.org";

    public static final String HL7_TERMINOLOGY_CODESYSTEM_BASE_URL = "http://terminology.hl7.org/CodeSystem/";
    public static final String HL7_SID_CODESYSTEM_BASE_URL = "http://hl7.org/fhir/sid/";
    public static final String HL7_FHIR_CODESYSTEM_BASE_URL = "http://hl7.org/fhir/";

    public static final String ISO_CODESYSTEM_URN = "urn:iso:std:iso:";
    public static final String LANG_CODESYSTEM_URN = "urn:ietf:bcp:47";
    public static final String MIMETYPES_CODESYSTEM_URN = "urn:ietf:bcp:13";

    public static final String _11073_CODESYSTEM_URN = "urn:iso:std:iso:11073:10101";
    public static final String DICOM_CODESYSTEM_URL = "http://dicom.nema.org/resources/ontology/DCM";

    public String getNameForSystem(String system) {
      final int lastPipe = system.lastIndexOf('|');
      final String systemBaseName = lastPipe == -1 ? system : system.substring(0,lastPipe);
      final String systemVersion = lastPipe == -1 ? null : system.substring(lastPipe + 1);

      if (systemBaseName.equals(SNOMED_SCT_CODESYSTEM_URL))
        return getVersionedSystem("snomed", systemVersion);
      if (systemBaseName.equals(RXNORM_CODESYSTEM_URL))
        return getVersionedSystem("rxnorm", systemVersion);
      if (systemBaseName.equals(LOINC_CODESYSTEM_URL))
        return getVersionedSystem("loinc", systemVersion);
      if (systemBaseName.equals(UCUM_CODESYSTEM_URL))
        return getVersionedSystem("ucum", systemVersion);
      if (systemBaseName.startsWith(HL7_SID_CODESYSTEM_BASE_URL))
        return getVersionedSystem(normalizeBaseURL(HL7_SID_CODESYSTEM_BASE_URL, systemBaseName), systemVersion);
      if (systemBaseName.equals(_11073_CODESYSTEM_URN))
        return getVersionedSystem("11073", systemVersion);
      if (systemBaseName.startsWith(ISO_CODESYSTEM_URN))
        return getVersionedSystem("iso"+systemBaseName.substring(ISO_CODESYSTEM_URN.length()).replace(":", ""), systemVersion);
      if (systemBaseName.startsWith(HL7_TERMINOLOGY_CODESYSTEM_BASE_URL))
        return getVersionedSystem(normalizeBaseURL(HL7_TERMINOLOGY_CODESYSTEM_BASE_URL, systemBaseName), systemVersion);
      if (systemBaseName.startsWith(HL7_FHIR_CODESYSTEM_BASE_URL))
        return getVersionedSystem(normalizeBaseURL(HL7_FHIR_CODESYSTEM_BASE_URL, systemBaseName), systemVersion);
      if (systemBaseName.equals(LANG_CODESYSTEM_URN))
        return getVersionedSystem("lang", systemVersion);
      if (systemBaseName.equals(MIMETYPES_CODESYSTEM_URN))
        return getVersionedSystem("mimetypes", systemVersion);
      if (systemBaseName.equals(DICOM_CODESYSTEM_URL))
        return getVersionedSystem("dicom", systemVersion);
      return getVersionedSystem(systemBaseName.replace("/", "_").replace(":", "_").replace("?", "X").replace("#", "X"), systemVersion);
    }

    public String normalizeBaseURL(String baseUrl, String fullUrl) {
      return fullUrl.substring(baseUrl.length()).replace("/", "");
    }

    public String getVersionedSystem(String baseSystem, String version) {
      if (version != null) {
        return baseSystem + "_" + version;
      }
      return baseSystem;
    }
  }

  public class CacheToken {
    private String name;
    private String key;
    private String request;
    public void setName(String n) {
      String systemName = getSystemNameKeyGenerator().getNameForSystem(n);
      if (name == null)
        name = systemName;
      else if (!systemName.equals(name))
        name = NAME_FOR_NO_SYSTEM;
    }

    public String getName() {
      return name;
    }
  }

  private class CacheEntry {
    private String request;
    private boolean persistent;
    private ValidationResult v;
    private ValueSetExpansionOutcome e;
  }
  
  private class NamedCache {
    private String name; 
    private List<CacheEntry> list = new ArrayList<CacheEntry>(); // persistent entries
    private Map<String, CacheEntry> map = new HashMap<String, CacheEntry>();
  }
  

  private Object lock;
  private String folder;
  private Map<String, NamedCache> caches = new HashMap<String, NamedCache>();
  
  // use lock from the context
  public TerminologyCache(Object lock, String folder) throws FileNotFoundException, IOException, FHIRException {
    super();
    this.lock = lock;
    this.folder = folder;
    if (folder != null)
      load();
  }
  
  public CacheToken generateValidationToken(ValidationOptions options, Coding code, ValueSet vs) {
    CacheToken ct = new CacheToken();
    if (code.hasSystem())
      ct.name = getSystemNameKeyGenerator().getNameForSystem(code.getSystem());
    else
      ct.name = NAME_FOR_NO_SYSTEM;
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY);
    ValueSet vsc = getVSEssense(vs);
    try {
      ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+(vsc == null ? "null" : json.composeString(vsc))+(options == null ? "" : ", "+options.toJson())+"}";
    } catch (IOException e) {
      throw new Error(e);
    }
    ct.key = String.valueOf(hashNWS(ct.request));
    return ct;
  }

  public CacheToken generateValidationToken(ValidationOptions options, CodeableConcept code, ValueSet vs) {
    CacheToken ct = new CacheToken();
    for (Coding c : code.getCoding()) {
      if (c.hasSystem())
        ct.setName(c.getSystem());
    }
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY);
    ValueSet vsc = getVSEssense(vs);
    try {
      ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"valueSet\" :"+json.composeString(vsc)+(options == null ? "" : ", "+options.toJson())+"}";
    } catch (IOException e) {
      throw new Error(e);
    }
    ct.key = String.valueOf(hashNWS(ct.request));
    return ct;
  }
  
  public ValueSet getVSEssense(ValueSet vs) {
    if (vs == null)
      return null;
    ValueSet vsc = new ValueSet();
    vsc.setCompose(vs.getCompose());
    if (vs.hasExpansion()) {
      vsc.getExpansion().getParameter().addAll(vs.getExpansion().getParameter());
      vsc.getExpansion().getContains().addAll(vs.getExpansion().getContains());
    }
    return vsc;
  }

  public CacheToken generateExpandToken(ValueSet vs, boolean heirarchical) {
    CacheToken ct = new CacheToken();
    ValueSet vsc = getVSEssense(vs);
    for (ConceptSetComponent inc : vs.getCompose().getInclude())
      if (inc.hasSystem())
        ct.setName(inc.getSystem());
    for (ConceptSetComponent inc : vs.getCompose().getExclude())
      if (inc.hasSystem())
        ct.setName(inc.getSystem());
    for (ValueSetExpansionContainsComponent inc : vs.getExpansion().getContains())
      if (inc.hasSystem())
        ct.setName(inc.getSystem());
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY);
    try {
      ct.request = "{\"hierarchical\" : "+(heirarchical ? "true" : "false")+", \"valueSet\" :"+json.composeString(vsc)+"}\r\n";
    } catch (IOException e) {
      throw new Error(e);
    }
    ct.key = String.valueOf(hashNWS(ct.request));
    return ct;
  }

  public NamedCache getNamedCache(CacheToken cacheToken) {
    NamedCache nc = caches.get(cacheToken.name);
    if (nc == null) {
      nc = new NamedCache();
      nc.name = cacheToken.name;
      caches.put(nc.name, nc);
    }
    return nc;
  }
  
  public ValueSetExpansionOutcome getExpansion(CacheToken cacheToken) {
    synchronized (lock) {
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null)
        return null;
      else
        return e.e;
    }
  }

  public void cacheExpansion(CacheToken cacheToken, ValueSetExpansionOutcome res, boolean persistent) {
    synchronized (lock) {      
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = new CacheEntry();
      e.request = cacheToken.request;
      e.persistent = persistent;
      e.e = res;
      store(cacheToken, persistent, nc, e);
    }    
  }

  public void store(CacheToken cacheToken, boolean persistent, NamedCache nc, CacheEntry e) {
    boolean n = nc.map.containsKey(cacheToken.key);
    nc.map.put(cacheToken.key, e);
    if (persistent) {
      if (n) {
        for (int i = nc.list.size()- 1; i>= 0; i--) {
          if (nc.list.get(i).request.equals(e.request)) {
            nc.list.remove(i);
          }
        }
      }
      nc.list.add(e);
      save(nc);  
    }
  }

  public ValidationResult getValidation(CacheToken cacheToken) {
    synchronized (lock) {
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null)
        return null;
      else
        return e.v;
    }
  }

  public void cacheValidation(CacheToken cacheToken, ValidationResult res, boolean persistent) {
    synchronized (lock) {      
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = new CacheEntry();
      e.request = cacheToken.request;
      e.persistent = persistent;
      e.v = res;
      store(cacheToken, persistent, nc, e);
    }    
  }

  
  // persistence
  
  public void save() {
    
  }
  
  private void save(NamedCache nc) {
    if (folder == null)
      return;
    
    try {
      OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(Utilities.path(folder, nc.name+".cache")), "UTF-8");
      sw.write(ENTRY_MARKER+"\r\n");
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      for (CacheEntry ce : nc.list) {
        sw.write(ce.request.trim());
        sw.write(BREAK+"\r\n");
        if (ce.e != null) {
          sw.write("e: {\r\n");
          if (ce.e.getValueset() != null)
            sw.write("  \"valueSet\" : "+json.composeString(ce.e.getValueset()).trim()+",\r\n");
          sw.write("  \"error\" : \""+Utilities.escapeJson(ce.e.getError()).trim()+"\"\r\n}\r\n");
        } else {
          sw.write("v: {\r\n");
          sw.write("  \"display\" : \""+Utilities.escapeJson(ce.v.getDisplay()).trim()+"\",\r\n");
          sw.write("  \"severity\" : "+(ce.v.getSeverity() == null ? "null" : "\""+ce.v.getSeverity().toCode().trim()+"\"")+",\r\n");
          sw.write("  \"error\" : \""+Utilities.escapeJson(ce.v.getMessage()).trim()+"\"\r\n}\r\n");
        }
        sw.write(ENTRY_MARKER+"\r\n");
      }      
      sw.close();
    } catch (Exception e) {
      System.out.println("error saving "+nc.name+": "+e.getMessage());
    }
  }

  private void load() throws FHIRException {
    for (String fn : new File(folder).list()) {
      if (fn.endsWith(".cache") && !fn.equals("validation.cache")) {
        try {
          //  System.out.println("Load "+fn);
          String title = fn.substring(0, fn.lastIndexOf("."));
          NamedCache nc = new NamedCache();
          nc.name = title;
          caches.put(title, nc);
          System.out.print(" - load "+title+".cache");
          String src = TextFile.fileToString(Utilities.path(folder, fn));
          if (src.startsWith("?"))
            src = src.substring(1);
          int i = src.indexOf(ENTRY_MARKER); 
          while (i > -1) {
            String s = src.substring(0, i);
            System.out.print(".");
            src = src.substring(i+ENTRY_MARKER.length()+1);
            i = src.indexOf(ENTRY_MARKER);
            if (!Utilities.noString(s)) {
              int j = s.indexOf(BREAK);
              String q = s.substring(0, j);
              String p = s.substring(j+BREAK.length()+1).trim();
              CacheEntry ce = new CacheEntry();
              ce.persistent = true;
              ce.request = q;
              boolean e = p.charAt(0) == 'e';
              p = p.substring(3);
              JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(p);
              String error = loadJS(o.get("error"));
              if (e) {
                if (o.has("valueSet"))
                  ce.e = new ValueSetExpansionOutcome((ValueSet) new JsonParser().parse(o.getAsJsonObject("valueSet")), error, TerminologyServiceErrorClass.UNKNOWN);
                else
                  ce.e = new ValueSetExpansionOutcome(error, TerminologyServiceErrorClass.UNKNOWN);
              } else {
                IssueSeverity severity = o.get("severity") instanceof JsonNull ? null :  IssueSeverity.fromCode(o.get("severity").getAsString());
                String display = loadJS(o.get("display"));
                ce.v = new ValidationResult(severity, error, new ConceptDefinitionComponent().setDisplay(display));
              }
              nc.map.put(String.valueOf(hashNWS(ce.request)), ce);
              nc.list.add(ce);
            }
          }        
          System.out.println("done");
        } catch (Exception e) {
          throw new FHIRException("Error loading "+fn+": "+e.getMessage(), e);
        }
      }
    }
  }
  
  private String loadJS(JsonElement e) {
    if (e == null)
      return null;
    if (!(e instanceof JsonPrimitive))
      return null;
    String s = e.getAsString();
    if ("".equals(s))
      return null;
    return s;
  }

  private String hashNWS(String s) {
    s = StringUtils.remove(s, ' ');
    s = StringUtils.remove(s, '\n');
    s = StringUtils.remove(s, '\r');
    return String.valueOf(s.hashCode());
  }

  // management
  
  public TerminologyCache copy() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public String summary(ValueSet vs) {
    if (vs == null)
      return "null";
    
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ConceptSetComponent cc : vs.getCompose().getInclude())
      b.append("Include "+getIncSummary(cc));
    for (ConceptSetComponent cc : vs.getCompose().getExclude())
      b.append("Exclude "+getIncSummary(cc));
    return b.toString();
  }

  private String getIncSummary(ConceptSetComponent cc) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (UriType vs : cc.getValueSet())
      b.append(vs.asStringValue());
    String vsd = b.length() > 0 ? " where the codes are in the value sets ("+b.toString()+")" : "";
    String system = cc.getSystem();
    if (cc.hasConcept())
      return Integer.toString(cc.getConcept().size())+" codes from "+system+vsd;
    if (cc.hasFilter()) {
      String s = "";
      for (ConceptSetFilterComponent f : cc.getFilter()) {
        if (!Utilities.noString(s))
          s = s + " & ";
        s = s + f.getProperty()+" "+f.getOp().toCode()+" "+f.getValue();
      }
      return "from "+system+" where "+s+vsd;
    }
    return "All codes from "+system+vsd;
  }

  public String summary(Coding code) {
    return code.getSystem()+"#"+code.getCode()+": \""+code.getDisplay()+"\"";
  }


  public String summary(CodeableConcept code) {
    StringBuilder b = new StringBuilder();
    b.append("{");
    boolean first = true;
    for (Coding c : code.getCoding()) {
      if (first) first = false; else b.append(",");
      b.append(summary(c));
    }
    b.append("}: \"");
    b.append(code.getText());
    b.append("\"");
    return b.toString();
  }
  
}