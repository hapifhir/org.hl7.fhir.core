package org.hl7.fhir.r5.context;

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
import java.util.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * This implements a two level cache. 
 *  - a temporary cache for remembering previous local operations
 *  - a persistent cache for remembering tx server operations
 *  
 * the cache is a series of pairs: a map, and a list. the map is the loaded cache, the list is the persistent cache, carefully maintained in order for version control consistency
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
  private static final String CACHE_FILE_EXTENSION = ".cache";
  private static final String CAPABILITY_STATEMENT_TITLE = ".capabilityStatement";
  private static final String TERMINOLOGY_CAPABILITIES_TITLE = ".terminologyCapabilities";


  private SystemNameKeyGenerator systemNameKeyGenerator = new SystemNameKeyGenerator();

  public class CacheToken {
    @Getter
    private String name;
    private String key;
    @Getter
    private String request;
    @Accessors(fluent = true)
    @Getter
    private boolean hasVersion;

    public void setName(String n) {
      String systemName = getSystemNameKeyGenerator().getNameForSystem(n);
      if (name == null)
        name = systemName;
      else if (!systemName.equals(name))
        name = NAME_FOR_NO_SYSTEM;
    }
  }

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
  @Getter private int requestCount;
  @Getter private int hitCount;
  @Getter private int networkCount;
  private CapabilityStatement capabilityStatementCache = null;
  private TerminologyCapabilities terminologyCapabilitiesCache = null;
  private Map<String, NamedCache> caches = new HashMap<String, NamedCache>();
  @Getter @Setter private static boolean noCaching;

  @Getter @Setter private static boolean cacheErrors;


  // use lock from the context
  public TerminologyCache(Object lock, String folder) throws FileNotFoundException, IOException, FHIRException {
    super();
    this.lock = lock;
    this.folder = folder;
    requestCount = 0;
    hitCount = 0;
    networkCount = 0;

    if (folder != null) {
      load();
    }
  }

  public boolean hasCapabilityStatement() {
    return capabilityStatementCache != null;
  }

  public CapabilityStatement getCapabilityStatement() {
    return capabilityStatementCache;
  }

  public void cacheCapabilityStatement(CapabilityStatement capabilityStatement) {
    if (noCaching) {
      return;
    } 
    this.capabilityStatementCache = capabilityStatement;
    save(capabilityStatementCache, CAPABILITY_STATEMENT_TITLE);
  }


  public boolean hasTerminologyCapabilities() {
    return terminologyCapabilitiesCache != null;
  }

  public TerminologyCapabilities getTerminologyCapabilities() {
    return terminologyCapabilitiesCache;
  }

  public void cacheTerminologyCapabilities(TerminologyCapabilities terminologyCapabilities) {
    if (noCaching) {
      return;
    }
    this.terminologyCapabilitiesCache = terminologyCapabilities;
    save(terminologyCapabilitiesCache, TERMINOLOGY_CAPABILITIES_TITLE);
  }


  public void clear() {
    caches.clear();
  }

  public CacheToken generateValidationToken(ValidationOptions options, Coding code, ValueSet vs, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      if (code.hasSystem()) {
        ct.setName(code.getSystem());
        ct.hasVersion = code.hasVersion();
      }
      else
        ct.name = NAME_FOR_NO_SYSTEM;
      nameCacheToken(vs, ct);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = json.composeString(expParameters);

      if (vs != null && vs.hasUrl() && vs.hasVersion()) {
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())
        +"\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\""+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}\r\n";
      } else if (options.getVsAsUrl()) {
        ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+extracted(json, vs)+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      } else {
        ValueSet vsc = getVSEssense(vs);
        ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+(vsc == null ? "null" : extracted(json, vsc))+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      }
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
  }

  public CacheToken generateValidationToken(ValidationOptions options, Coding code, String vsUrl, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      if (code.hasSystem()) {
        ct.setName(code.getSystem());
        ct.hasVersion = code.hasVersion();
      }
      else
        ct.name = NAME_FOR_NO_SYSTEM;
      ct.setName(vsUrl);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = json.composeString(expParameters);

      ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+(vsUrl == null ? "null" : vsUrl)+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
  }

  public String extracted(JsonParser json, ValueSet vsc) throws IOException {
    String s = null;
    if (vsc.getExpansion().getContains().size() > 1000 || vsc.getCompose().getIncludeFirstRep().getConcept().size() > 1000) {      
      s =  vsc.getUrl();
    } else {
      s = json.composeString(vsc);
    }
    return s;
  }

  public CacheToken generateValidationToken(ValidationOptions options, CodeableConcept code, ValueSet vs, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      for (Coding c : code.getCoding()) {
        if (c.hasSystem()) {
          ct.setName(c.getSystem());
          ct.hasVersion = c.hasVersion();
        }
      }
      nameCacheToken(vs, ct);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = json.composeString(expParameters);
      if (vs != null && vs.hasUrl() && vs.hasVersion()) {
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())+
            "\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\""+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}\r\n";      
      } else {
        ValueSet vsc = getVSEssense(vs);
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"valueSet\" :"+extracted(json, vsc)+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      }
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
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

  public CacheToken generateExpandToken(ValueSet vs, boolean hierarchical) {
    CacheToken ct = new CacheToken();
    nameCacheToken(vs, ct);
    if (vs.hasUrl() && vs.hasVersion()) {
      ct.request = "{\"hierarchical\" : "+(hierarchical ? "true" : "false")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())+"\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\"}\r\n";      
    } else {
      ValueSet vsc = getVSEssense(vs);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      try {
        ct.request = "{\"hierarchical\" : "+(hierarchical ? "true" : "false")+", \"valueSet\" :"+extracted(json, vsc)+"}\r\n";
      } catch (IOException e) {
        throw new Error(e);
      }
    }
    ct.key = String.valueOf(hashJson(ct.request));
    return ct;
  }

  public void nameCacheToken(ValueSet vs, CacheToken ct) {
    if (vs != null) {
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        if (inc.hasSystem()) {
          ct.setName(inc.getSystem());
          ct.hasVersion = inc.hasVersion();
        }
      }
      for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
        if (inc.hasSystem()) {
          ct.setName(inc.getSystem());
          ct.hasVersion = inc.hasVersion();
        }
      }
      for (ValueSetExpansionContainsComponent inc : vs.getExpansion().getContains()) {
        if (inc.hasSystem()) {
          ct.setName(inc.getSystem());
          ct.hasVersion = inc.hasVersion();
        }
      }
    }
  }

  private String normalizeSystemPath(String path) {
    return path.replace("/", "").replace('|','X');
  }



  public NamedCache getNamedCache(CacheToken cacheToken) {

    final String cacheName = cacheToken.name == null ? "null" : cacheToken.name;

    NamedCache nc = caches.get(cacheName);

    if (nc == null) {
      nc = new NamedCache();
      nc.name = cacheName;
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
    if (noCaching) {
      return;
    }

    if ( !cacheErrors &&
        ( e.v!= null
        && e.v.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED
        && !cacheToken.hasVersion)) {
      return;
    }

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
    if (cacheToken.key == null) {
      return null;
    }
    synchronized (lock) {
      requestCount++;
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null) {
        networkCount++;
        return null;
      } else {
        hitCount++;
        return e.v;
      }
    }
  }

  public void cacheValidation(CacheToken cacheToken, ValidationResult res, boolean persistent) {
    if (cacheToken.key != null) {
      synchronized (lock) {      
        NamedCache nc = getNamedCache(cacheToken);
        CacheEntry e = new CacheEntry();
        e.request = cacheToken.request;
        e.persistent = persistent;
        e.v = res;
        store(cacheToken, persistent, nc, e);
      }    
    }
  }


  // persistence

  public void save() {

  }

  private <K extends Resource> void save(K resource, String title) {
    if (folder == null)
      return;

    try {
      OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(Utilities.path(folder, title + CACHE_FILE_EXTENSION)), "UTF-8");

      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);

      sw.write(json.composeString(resource).trim());
      sw.close();
    } catch (Exception e) {
      System.out.println("error saving capability statement "+e.getMessage());
    }
  }

  private void save(NamedCache nc) {
    if (folder == null)
      return;

    try {
      OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(Utilities.path(folder, nc.name+CACHE_FILE_EXTENSION)), "UTF-8");
      sw.write(ENTRY_MARKER+"\r\n");
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      for (CacheEntry ce : nc.list) {
        sw.write(ce.request.trim());
        sw.write(BREAK+"\r\n");
        if (ce.e != null) {
          sw.write("e: {\r\n");
          if (ce.e.isFromServer())
            sw.write("  \"from-server\" : true,\r\n");
          if (ce.e.getValueset() != null)
            sw.write("  \"valueSet\" : "+json.composeString(ce.e.getValueset()).trim()+",\r\n");
          sw.write("  \"error\" : \""+Utilities.escapeJson(ce.e.getError()).trim()+"\"\r\n}\r\n");
        } else {
          sw.write("v: {\r\n");
          boolean first = true;
          if (ce.v.getDisplay() != null) {            
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"display\" : \""+Utilities.escapeJson(ce.v.getDisplay()).trim()+"\"");
          }
          if (ce.v.getCode() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"code\" : \""+Utilities.escapeJson(ce.v.getCode()).trim()+"\"");
          }
          if (ce.v.getSystem() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"system\" : \""+Utilities.escapeJson(ce.v.getSystem()).trim()+"\"");
          }
          if (ce.v.getVersion() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"version\" : \""+Utilities.escapeJson(ce.v.getVersion()).trim()+"\"");
          }
          if (ce.v.getSeverity() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"severity\" : "+"\""+ce.v.getSeverity().toCode().trim()+"\""+"");
          }
          if (ce.v.getMessage() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"error\" : \""+Utilities.escapeJson(ce.v.getMessage()).trim()+"\"");
          }
          if (ce.v.getErrorClass() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"class\" : \""+Utilities.escapeJson(ce.v.getErrorClass().toString())+"\"");
          }
          if (ce.v.getDefinition() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"definition\" : \""+Utilities.escapeJson(ce.v.getDefinition()).trim()+"\"");
          }
          if (ce.v.getUnknownSystems() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"unknown-systems\" : \""+Utilities.escapeJson(CommaSeparatedStringBuilder.join(",", ce.v.getUnknownSystems())).trim()+"\"");
          }
          if (ce.v.getIssues() != null) {
            if (first) first = false; else sw.write(",\r\n");
            OperationOutcome oo = new OperationOutcome();
            oo.setIssue(ce.v.getIssues());
            sw.write("  \"issues\" : "+json.composeString(oo).trim()+"\r\n");
          }
          sw.write("\r\n}\r\n");
        }
        sw.write(ENTRY_MARKER+"\r\n");
      }      
      sw.close();
    } catch (Exception e) {
      System.out.println("error saving "+nc.name+": "+e.getMessage());
    }
  }

  private boolean isCapabilityCache(String fn) {
    if (fn == null) {
      return false;
    }
    return fn.startsWith(CAPABILITY_STATEMENT_TITLE) || fn.startsWith(TERMINOLOGY_CAPABILITIES_TITLE);
  }

  private void loadCapabilityCache(String fn) {
    try {
      String src = TextFile.fileToString(Utilities.path(folder, fn));

      JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(src);
      Resource resource = new JsonParser().parse(o);

      if (fn.startsWith(CAPABILITY_STATEMENT_TITLE)) {
        this.capabilityStatementCache = (CapabilityStatement) resource;
      } else if (fn.startsWith(TERMINOLOGY_CAPABILITIES_TITLE)) {
        this.terminologyCapabilitiesCache = (TerminologyCapabilities) resource;
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new FHIRException("Error loading " + fn + ": " + e.getMessage(), e);
    }
  }

  private CacheEntry getCacheEntry(String request, String resultString) throws IOException {
    CacheEntry ce = new CacheEntry();
    ce.persistent = true;
    ce.request = request;
    boolean e = resultString.charAt(0) == 'e';
    resultString = resultString.substring(3);
    JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(resultString);
    String error = loadJS(o.get("error"));
    if (e) {
      if (o.has("valueSet"))
        ce.e = new ValueSetExpansionOutcome((ValueSet) new JsonParser().parse(o.getAsJsonObject("valueSet")), error, TerminologyServiceErrorClass.UNKNOWN, o.has("from-server"));
      else
        ce.e = new ValueSetExpansionOutcome(error, TerminologyServiceErrorClass.UNKNOWN, o.has("from-server"));
    } else {
      String t = loadJS(o.get("severity"));
      IssueSeverity severity = t == null ? null :  IssueSeverity.fromCode(t);
      String display = loadJS(o.get("display"));
      String code = loadJS(o.get("code"));
      String system = loadJS(o.get("system"));
      String version = loadJS(o.get("version"));
      String definition = loadJS(o.get("definition"));
      String unknownSystems = loadJS(o.get("unknown-systems"));
      OperationOutcome oo = o.has("issues") ? (OperationOutcome) new JsonParser().parse(o.getAsJsonObject("issues")) : null;
      t = loadJS(o.get("class")); 
      TerminologyServiceErrorClass errorClass = t == null ? null : TerminologyServiceErrorClass.valueOf(t) ;
      ce.v = new ValidationResult(severity, error, system, version, new ConceptDefinitionComponent().setDisplay(display).setDefinition(definition).setCode(code), display, null).setErrorClass(errorClass);
      ce.v.setUnknownSystems(CommaSeparatedStringBuilder.toSet(unknownSystems));
      if (oo != null) {
        ce.v.setIssues(oo.getIssue());
      }
    }
    return ce;
  }

  private void loadNamedCache(String fn) {
    int c = 0;
    try {
      String src = TextFile.fileToString(Utilities.path(folder, fn));
      String title = fn.substring(0, fn.lastIndexOf("."));

      NamedCache nc = new NamedCache();
      nc.name = title;

      if (src.startsWith("?"))
        src = src.substring(1);
      int i = src.indexOf(ENTRY_MARKER);
      while (i > -1) {
        c++;
        String s = src.substring(0, i);
        src = src.substring(i + ENTRY_MARKER.length() + 1);
        i = src.indexOf(ENTRY_MARKER);
        if (!Utilities.noString(s)) {
          int j = s.indexOf(BREAK);
          String request = s.substring(0, j);
          String p = s.substring(j + BREAK.length() + 1).trim();

          CacheEntry cacheEntry = getCacheEntry(request, p);

          nc.map.put(String.valueOf(hashJson(cacheEntry.request)), cacheEntry);
          nc.list.add(cacheEntry);
        }
        caches.put(nc.name, nc);
      }        
    } catch (Exception e) {
      System.out.println("Error loading "+fn+": "+e.getMessage()+" entry "+c+" - ignoring it");
      e.printStackTrace();
    }
  }

  private void load() throws FHIRException {
    for (String fn : new File(folder).list()) {
      if (fn.endsWith(CACHE_FILE_EXTENSION) && !fn.equals("validation" + CACHE_FILE_EXTENSION)) {
        try {
          if (isCapabilityCache(fn)) {
            loadCapabilityCache(fn);
          } else {
            loadNamedCache(fn);
          }
        } catch (FHIRException e) {
          throw e;
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

  protected String hashJson(String s) {
    return String.valueOf(s.trim().hashCode());
  }

  // management

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
        s = s + f.getProperty()+" "+(f.hasOp() ? f.getOp().toCode() : "?")+" "+f.getValue();
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

  public void removeCS(String url) {
    synchronized (lock) {
      String name = getSystemNameKeyGenerator().getNameForSystem(url);
      if (caches.containsKey(name)) {
        caches.remove(name);
      }
    }   
  }

  public String getFolder() {
    return folder;
  }


}