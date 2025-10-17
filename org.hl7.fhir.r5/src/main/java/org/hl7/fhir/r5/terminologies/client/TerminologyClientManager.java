package org.hl7.fhir.r5.terminologies.client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.ILoggingService;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.ImplicitValueSets;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext.TerminologyClientContextUseType;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.SourcedCodeSystem;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.SourcedValueSet;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@MarkedToMoveToAdjunctPackage
public class TerminologyClientManager {

  private ImplicitValueSets implicitValueSets;

  public class ServerOptionList {
    private List<String> authoritative = new ArrayList<String>();
    private List<String> candidates = new ArrayList<String>();
    
    public ServerOptionList(String address) {
      candidates.add(address);
    }
    
    public ServerOptionList() {
    }

    public ServerOptionList(List<String> auth, List<String> cand) {
      authoritative.addAll(auth);
      candidates.addAll(cand);
    }

    public void replace(String src, String dst) {
      for (int i = 0; i < candidates.size(); i++) {
        if (candidates.get(i).contains("://"+src)) {
          candidates.set(i, candidates.get(i).replace("://"+src, "://"+dst));
        }
      }
      for (int i = 0; i < authoritative.size(); i++) {
        if (authoritative.get(i).contains("://"+src)) {
          authoritative.set(i, authoritative.get(i).replace("://"+src, "://"+dst));
        }
      }      
    }

    @Override
    public String toString() {
      return "auth = " + CommaSeparatedStringBuilder.join("|", authoritative)+ ", candidates=" + CommaSeparatedStringBuilder.join("|", candidates);
    }    
    
  }

  public ITerminologyClientFactory getFactory() {
    return factory;
  }

  public interface ITerminologyClientFactory {
    ITerminologyClient makeClient(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException;
    String getVersion();
  }
  
  public class InternalLogEvent {
    private boolean error;
    private String message;
    private String server;
    private String vs;
    private String systems;
    private String choices;
    private String context;
    private String request;
    protected InternalLogEvent(String message, String server, String vs, String systems, String choices) {
      super();
      this.message = message;
      this.server = server;
      this.vs = vs;
      this.systems = systems;
      this.choices = choices;
    }
    protected InternalLogEvent(String message, String ctxt, String request) {
      super();
      error = true;
      this.message = message;
      this.context = ctxt;
      this.request = request;
    }
    public String getMessage() {
      return message;
    }
    public String getVs() {
      return vs;
    }
    public String getSystems() {
      return systems;
    }
    public String getChoices() {
      return choices;
    }
    public String getServer() {
      return server;
    }
    public boolean isError() {
      return error;
    }
    public String getContext() {
      return context;
    }
    public String getRequest() {
      return request;
    }
  }

  public static final String UNRESOLVED_VALUESET = "--unknown--";

  private static final boolean IGNORE_TX_REGISTRY = false;
  
  private ITerminologyClientFactory factory;
  private String cacheId;
  private List<TerminologyClientContext> serverList = new ArrayList<>(); // clients by server address
  private Map<String, TerminologyClientContext> serverMap = new HashMap<>(); // clients by server address
  private Map<String, ServerOptionList> resMap = new HashMap<>(); // client resolution list
  private List<InternalLogEvent> internalLog = new ArrayList<>();
  protected Parameters expParameters;

  private TerminologyCache cache;

  private File cacheFile;
  private String usage;

  private String monitorServiceURL;

  private boolean useEcosystem;

  private ILoggingService logger;

  private int ecosystemfailCount;

  public TerminologyClientManager(ITerminologyClientFactory factory, String cacheId, ILoggingService logger) {
    super();
    this.factory = factory;
    this.cacheId = cacheId;
    this.logger = logger;
    implicitValueSets = new ImplicitValueSets(null);
  }
  
  public String getCacheId() {
    return cacheId; 
  }
  
  public void copy(TerminologyClientManager other) {
    cacheId = other.cacheId;  
    serverList.addAll(other.serverList);
    serverMap.putAll(other.serverMap);
    resMap.putAll(other.resMap);
    useEcosystem = other.useEcosystem;
    monitorServiceURL = other.monitorServiceURL;
    factory = other.factory;
    usage = other.usage;
    internalLog = other.internalLog;
  }


  public TerminologyClientContext chooseServer(ValueSet vs, Set<String> systems, boolean expand) throws TerminologyServiceException {
    if (serverList.isEmpty()) {
      return null;
    }
    if (systems.contains(UNRESOLVED_VALUESET) || systems.isEmpty()) {
      return serverList.get(0);
    }
    
    List<ServerOptionList> choices = new ArrayList<>();
    for (String s : systems) {
      choices.add(findServerForSystem(s, expand));
    }    
    
    // first we look for a server that's authoritative for all of them
    for (ServerOptionList ol : choices) {
      for (String s : ol.authoritative) {
        boolean ok = true;
        for (ServerOptionList t : choices) {
          if (!t.authoritative.contains(s)) {
            ok = false;
          }
        }
        if (ok) {
          log(vs, s, systems, choices, "Found authoritative server "+s);
          return findClient(s, systems, expand);
        }
      }
    }
    
    // now we look for a server that's authoritative for one of them and a candidate for the others
    for (ServerOptionList ol : choices) {
      for (String s : ol.authoritative) {
        boolean ok = true;
        for (ServerOptionList t : choices) {
          if (!t.authoritative.contains(s) && !t.candidates.contains(s)) {
            ok = false;
          }
        }
        if (ok) {
          log(vs, s, systems, choices, "Found partially authoritative server "+s);
          return findClient(s, systems, expand);
        }
      }
    }

    // now we look for a server that's a candidate for all of them
    for (ServerOptionList ol : choices) {
      for (String s : ol.candidates) {
        boolean ok = true;
        for (ServerOptionList t : choices) {
          if (!t.candidates.contains(s)) {
            ok = false;
          }
        }
        if (ok) {
          log(vs, s, systems, choices, "Found candidate server " + s);
          return findClient(s, systems, expand);
        }
      }
    }
    
    for (String sys : systems) {
      String uri = sys.contains("|") ? sys.substring(0, sys.indexOf("|")) : sys;
      // this list is the list of code systems that have special handling on tx.fhir.org, and might not be resolved above.
      // we don't want them to go to secondary servers (e.g. VSAC) by accident (they might go deliberately above)
      if (Utilities.existsInList(uri, "http://unitsofmeasure.org", "http://loinc.org", "http://snomed.info/sct",
          "http://www.nlm.nih.gov/research/umls/rxnorm", "http://hl7.org/fhir/sid/cvx", "urn:ietf:bcp:13", "urn:ietf:bcp:47",
          "urn:ietf:rfc:3986", "http://www.ama-assn.org/go/cpt", "urn:oid:1.2.36.1.2001.1005.17", "urn:iso:std:iso:3166", 
          "http://varnomen.hgvs.org", "http://unstats.un.org/unsd/methods/m49/m49.htm", "urn:iso:std:iso:4217", 
          "http://hl7.org/fhir/sid/ndc", "http://fhir.ohdsi.org/CodeSystem/concepts", "http://fdasis.nlm.nih.gov", "https://www.usps.com/")) {
        log(vs, serverList.get(0).getAddress(), systems, choices, "Use primary server for "+uri);
        return serverList.get(0);
      }
    }


    // no agreement - take the one that is must authoritative
    Map<String, Integer> counts = new HashMap<>();
    for (ServerOptionList ol : choices) {
      for (String s : ol.authoritative) {
        counts.put(s, counts.getOrDefault(s, 0) + 1);
      }
    }
    // Find the maximum
    String max = counts.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
    if (max != null) {
      log(vs, max, systems, choices, "Found most authoritative server "+max);
      return findClient(max, systems, expand);
    }

    // no agreement? Then what we do depends     
    if (vs != null) {
      if (vs.hasUserData(UserDataNames.render_external_link)) {
        String el = vs.getUserString(UserDataNames.render_external_link);
        if ("https://vsac.nlm.nih.gov".equals(el)) {
          el = getMaster().getAddress();
        }
        if (systems.size() == 1) {
          log(vs, el, systems, choices, "Not handled by any servers. Using source @ '"+el+"'");
        } else {
          log(vs, el, systems, choices, "Handled by multiple servers. Using source @ '"+el+"'");
        }        
        return findClient(el, systems, expand);
      } else {
        if (systems.size() == 1) {
          log(vs, serverList.get(0).getAddress(), systems, choices, "System not handled by any servers. Using primary server");
        } else {
          log(vs, serverList.get(0).getAddress(), systems, choices, "Systems handled by multiple servers. Using primary server");
        }
        return findClient(serverList.get(0).getAddress(), systems, expand);
      }      
    } else {
      if (systems.size() == 1) {
        log(vs, serverList.get(0).getAddress(), systems, choices, "System not handled by any servers. Using primary server");
      } else {
        log(vs, serverList.get(0).getAddress(), systems, choices, "Systems handled by multiple servers. Using primary server");
      }
      log(vs, serverList.get(0).getAddress(), systems, choices, "Fallback: primary server");
      return findClient(serverList.get(0).getAddress(), systems, expand);
    }
  }

  public TerminologyClientContext chooseServer(String vs, boolean expand) throws TerminologyServiceException {
    if (serverList.isEmpty()) {
      return null;
    }
    if (IGNORE_TX_REGISTRY || !useEcosystem) {
      return findClient(getMasterClient().getAddress(), null, expand);
    }
    String request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&valueSet="+Utilities.URLEncode(vs));
    if (usage != null) {
      request = request + "&usage="+usage;
    } 
    try {
      JsonObject json = JsonParser.parseObjectFromUrl(request);
      for (JsonObject item : json.getJsonObjects("authoritative")) {
        return findClient(item.asString("url"), null, expand);
      }
      for (JsonObject item : json.getJsonObjects("candidates")) {
        return findClient(item.asString("url"), null, expand);
      }
    } catch (Exception e) {
      String msg = "Error resolving valueSet "+vs+": "+e.getMessage();
      if (!hasMessage(msg)) {
        internalLog.add(new InternalLogEvent(msg, vs, request));
      }
      logger.logDebugMessage(ILoggingService.LogCategory.TX, ExceptionUtils.getStackTrace(e));
    }
    return null; 
  }

  private void log(ValueSet vs, String server, Set<String> systems, List<ServerOptionList> choices, String message) {
    String svs = (vs == null ? "null" : vs.getVersionedUrl());
    String sys = systems.isEmpty() ? "--" : systems.size() == 1 ? systems.iterator().next() : systems.toString();
    String sch = choices.isEmpty() ? "--" : choices.size() == 1 ? choices.iterator().next().toString() : choices.toString();
    internalLog.add(new InternalLogEvent(message, server, svs, sys, sch));
  }

  private TerminologyClientContext findClient(String server, Set<String> systems, boolean expand) {
    server = ManagedWebAccess.makeSecureRef(server);
    TerminologyClientContext client = serverMap.get(server);
    if (client == null) {
      try {
        client = new TerminologyClientContext(factory.makeClient("id"+(serverList.size()+1), server, getMasterClient().getUserAgent(), getMasterClient().getLogger()), cache, cacheId, false);
      } catch (Exception e) {
        throw new TerminologyServiceException("Error accessing "+server+" for "+CommaSeparatedStringBuilder.join(",", systems)+": "+e.getMessage(), e);
      }
      //client.setTxCache(cache);
      serverList.add(client);
      serverMap.put(server, client);
    }
    client.seeUse(systems, expand ? TerminologyClientContextUseType.expand : TerminologyClientContextUseType.validate);
    return client;
  }

  private ServerOptionList findServerForSystem(String s, boolean expand) throws TerminologyServiceException {
    ServerOptionList serverList = resMap.get(s);
    if (serverList == null) {
      serverList = decideWhichServer(s);
      // testing support
      try {
        serverList.replace("tx.fhir.org", host());
      } catch (MalformedURLException e) {
      }
      // resMap.put(s, serverList);
      save();
    }
    return serverList;
  }

  private String host() throws MalformedURLException {
    URL url = new URL(getMasterClient().getAddress());
    if (url.getPort() > 0) {
      return url.getHost()+":"+url.getPort();
    } else {
      return url.getHost();
    }
  }

  private ServerOptionList decideWhichServer(String url) {
    if (IGNORE_TX_REGISTRY || !useEcosystem) {
      return new ServerOptionList(getMasterClient().getAddress());
    }
    if (expParameters != null) {
      if (!url.contains("|")) {
        // the client hasn't specified an explicit version, but the expansion parameters might
        for (ParametersParameterComponent p : expParameters.getParameter()) {
          if (Utilities.existsInList(p.getName(), "system-version", "force-system-version") && p.hasValuePrimitive() && p.getValue().primitiveValue().startsWith(url+"|")) {
            url = p.getValue().primitiveValue();
          }
        }
      } else {
        // the expansion parameters might override the version
        for (ParametersParameterComponent p : expParameters.getParameter()) {
          if (Utilities.existsInList(p.getName(), "force-system-version") && p.hasValueCanonicalType() && p.getValue().primitiveValue().startsWith(url+"|")) {
            url = p.getValue().primitiveValue();
          }
        }
      }
    }
    String request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&url="+Utilities.URLEncode(url));
    if (usage != null) {
      request = request + "&usage="+usage;
    } 
    try {
      ServerOptionList ret = new ServerOptionList();
      JsonObject json = JsonParser.parseObjectFromUrl(request);
      for (JsonObject item : json.getJsonObjects("authoritative")) {
        ret.authoritative.add(item.asString("url"));
      }
      for (JsonObject item : json.getJsonObjects("candidates")) {
        ret.candidates.add(item.asString("url"));
      }
      return ret;
    } catch (Exception e) {
      String msg = "Error resolving system "+url+": "+e.getMessage();
      if (!hasMessage(msg)) {
        internalLog.add(new InternalLogEvent(msg, url, request));
      }
      logger.logDebugMessage(ILoggingService.LogCategory.TX, ExceptionUtils.getStackTrace(e));
    }
    return new ServerOptionList( getMasterClient().getAddress());
    
  }

  private boolean hasMessage(String msg) {
    for (InternalLogEvent log : internalLog) {
      if (msg.equals(log.message)) {
        return true;
      }
    }
    return false;
  }

  public List<TerminologyClientContext> serverList() {
    return serverList;
  }
  
  public boolean hasClient() {
    return !serverList.isEmpty();
  }

  public int getRetryCount() {
    return hasClient() ? getMasterClient().getRetryCount() : 0;
  }

  public void setRetryCount(int value) {
    if (hasClient()) {
      getMasterClient().setRetryCount(value);
    }
  }

  public void setUserAgent(String value) {
    if (hasClient()) {
      getMasterClient().setUserAgent(value);
    }
  }

  public void setLogger(ToolingClientLogger txLog) {
    if (hasClient()) {
      getMasterClient().setLogger(txLog);
    }
  }

  public TerminologyClientContext setMasterClient(ITerminologyClient client, boolean useEcosystem) throws IOException {
    this.useEcosystem = useEcosystem;
    TerminologyClientContext terminologyClientContext = new TerminologyClientContext(client, cache, cacheId,true);
    serverList.clear();
    serverList.add(terminologyClientContext);
    serverMap.put(client.getAddress(), terminologyClientContext);
    monitorServiceURL = Utilities.pathURL(Utilities.getDirectoryForURL(client.getAddress()), "tx-reg");
    return terminologyClientContext;
  }
  
  public TerminologyClientContext getMaster() {
    return serverList.isEmpty() ? null : serverList.get(0);
  }

  public ITerminologyClient getMasterClient() {
    return serverList.isEmpty() ? null : serverList.get(0).getClient();
  }

  public Map<String, TerminologyClientContext> serverMap() {
    Map<String, TerminologyClientContext> map = new HashMap<>();
    for (TerminologyClientContext t : serverList) {
      map.put(t.getClient().getAddress(), t);
    }
    return map;
  }


  public void setFactory(ITerminologyClientFactory factory) {
    this.factory = factory;    
  }

  public void setCache(TerminologyCache cache) {
    this.cache = cache;
    this.cacheFile = null;

    if (cache != null && cache.getFolder() != null) {
      try {
        cacheFile = ManagedFileAccess.file(Utilities.path(cache.getFolder(), "system-map.json"));
        if (cacheFile.exists()) {
          JsonObject json = JsonParser.parseObject(cacheFile);
          for (JsonObject pair : json.getJsonObjects("systems")) {
            if (pair.has("server")) {
              resMap.put(pair.asString("system"), new ServerOptionList(pair.asString("server")));
            } else {
              resMap.put(pair.asString("system"), new ServerOptionList(pair.getStrings("authoritative"), pair.getStrings("candidates")));
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private void save() {
    if (cacheFile != null && cache.getFolder() != null) {
      JsonObject json = new JsonObject();
      for (String s : Utilities.sorted(resMap.keySet())) {
        JsonObject si = new JsonObject();
        json.forceArray("systems").add(si);
        si.add("system", s);
        si.add("authoritative", resMap.get(s).authoritative);
        si.add("candidates", resMap.get(s).candidates);
      }
      try {
        JsonParser.compose(json, cacheFile, true);
      } catch (IOException e) {
      }
    }
  }

  public List<TerminologyClientContext> getServerList() {
    return serverList;
  }

  public Map<String, TerminologyClientContext> getServerMap() {
    return serverMap;
  }

  public String getMonitorServiceURL() {
    return monitorServiceURL;
  }

  public Parameters getExpansionParameters() {
    return expParameters;
  }

  public void setExpansionParameters(Parameters expParameters) {
    this.expParameters = expParameters;
    implicitValueSets = new ImplicitValueSets(expParameters);
  }

  public String getUsage() {
    return usage;
  }

  public void setUsage(String usage) {
    this.usage = usage;
  }

  public SourcedValueSet findValueSetOnServer(String canonical) {
    if (IGNORE_TX_REGISTRY || getMasterClient() == null) {
      return null;
    }
    String request = null;
    boolean isImplicit = false;
    String iVersion = null;
    if (implicitValueSets.isImplicitSCTValueSet(canonical)) {
      isImplicit = true;
      iVersion = canonical.substring(0, canonical.indexOf("?fhir_vs"));
      if ("http://snomed.info/sct".equals(iVersion) && canonical.contains("|")) {
        iVersion = canonical.substring(canonical.indexOf("|")+1);
      } 
      iVersion = ValueSetUtilities.versionFromExpansionParams(expParameters, "http://snomed.info/sct", iVersion); 
      request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&url="+Utilities.URLEncode("http://snomed.info/sct"+(iVersion == null ? "": "|"+iVersion)));
    } else if (implicitValueSets.isImplicitLoincValueSet(canonical)) {
      isImplicit = true;
      iVersion = null;
      if (canonical.contains("|")) {
        iVersion = canonical.substring(canonical.indexOf("|")+1);
      } 
      iVersion = ValueSetUtilities.versionFromExpansionParams(expParameters, "http://loinc.org", iVersion); 
      request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&url="+Utilities.URLEncode("http://loinc.org"+(iVersion == null ? "": "|"+iVersion)));
    } else {
      request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&valueSet="+Utilities.URLEncode(canonical));
    }
    String server = null;
    try {
      if (!useEcosystem) {
        server = getMasterClient().getAddress();
      } else {
        ecosystemfailCount = 0; 
        try {
          if (usage != null) {
            request = request + "&usage="+usage;
          }
          JsonObject json = JsonParser.parseObjectFromUrl(request);
          for (JsonObject item : json.getJsonObjects("authoritative")) {
            if (server == null) {
              server = item.asString("url");
            }
          }
          for (JsonObject item : json.getJsonObjects("candidates")) {
            if (server == null) {
              server = item.asString("url");
            }
          }
          if (server == null) {
            server = getMasterClient().getAddress();
          }
          if (server.contains("://tx.fhir.org")) {
            try {
              server = server.replace("tx.fhir.org", host());
            } catch (MalformedURLException e) {
            }
          }
        } catch (Exception e) {
          // the ecosystem cal failed, so we're just going to fall back to 
          String msg = "Error resolving valueSet "+canonical+": "+e.getMessage();
          if (!hasMessage(msg)) {
            internalLog.add(new InternalLogEvent(msg, canonical, request));
          }
          logger.logDebugMessage(ILoggingService.LogCategory.TX, ExceptionUtils.getStackTrace(e));
          ecosystemfailCount++;
          if (ecosystemfailCount > 3) {
            useEcosystem = false;
          }
          server = getMasterClient().getAddress();
        }
      }
      TerminologyClientContext client = serverMap.get(server);
      if (client == null) {
        try {
          client = new TerminologyClientContext(factory.makeClient("id"+(serverList.size()+1), ManagedWebAccess.makeSecureRef(server), getMasterClient().getUserAgent(), getMasterClient().getLogger()), cache, cacheId, false);
        } catch (URISyntaxException | IOException e) {
          throw new TerminologyServiceException(e);
        }

        serverList.add(client);
        serverMap.put(server, client);
      }
      client.seeUse(canonical, TerminologyClientContextUseType.readVS);
      String criteria = canonical.contains("|") ? 
          "?_format=json&url="+Utilities.URLEncode(canonical.substring(0, canonical.lastIndexOf("|")))+"&version="+Utilities.URLEncode(canonical.substring(canonical.lastIndexOf("|")+1)): 
            "?_format=json&url="+Utilities.URLEncode(canonical);
      request = Utilities.pathURL(client.getAddress(), "ValueSet"+ criteria);
      Bundle bnd = client.getClient().search("ValueSet", criteria);
      String rid = null;
      if (bnd.getEntry().size() == 0) {
        if (isImplicit) {
          // couldn't find it, but can we expand on it? 
          Parameters p= new Parameters();
          p.addParameter("url", new UriType(canonical));
          p.addParameter("count", 0);
          p.addParameters(expParameters);
          try {
            ValueSet vs = client.getClient().expandValueset(null, p);
            if (vs != null) {
              return new SourcedValueSet(server, implicitValueSets.generateImplicitValueSet(canonical, iVersion));
            }
          } catch (Exception e) {
            return null;
          }
        } else {
          return null;
        }
      } else if (bnd.getEntry().size() > 1) {
        List<ValueSet> vslist = new ArrayList<>();
        for (BundleEntryComponent be : bnd.getEntry()) {
          if (be.hasResource() && be.getResource() instanceof ValueSet) {
            vslist.add((ValueSet) be.getResource());
          }
        }
        Collections.sort(vslist, new ValueSetUtilities.ValueSetSorter());
        rid = vslist.get(vslist.size()-1).getIdBase();
      } else {
        if (bnd.getEntryFirstRep().hasResource() && bnd.getEntryFirstRep().getResource() instanceof ValueSet) {
          rid = bnd.getEntryFirstRep().getResource().getIdBase();
        }
      }
      if (rid == null) {
        return null;
      }
      ValueSet vs = (ValueSet) client.getClient().read("ValueSet", rid);
      return new SourcedValueSet(server, vs);
    } catch (Exception e) {
      String msg = "Error resolving valueSet "+canonical+": "+e.getMessage();
      if (!hasMessage(msg)) {
        internalLog.add(new InternalLogEvent(msg, canonical, request));
      }
      logger.logDebugMessage(ILoggingService.LogCategory.TX, ExceptionUtils.getStackTrace(e));
      return null;
    }
  }
  public SourcedCodeSystem findCodeSystemOnServer(String canonical) {
    if (IGNORE_TX_REGISTRY || getMasterClient() == null || !useEcosystem) {
      return null;
    }
    String request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&url="+Utilities.URLEncode(canonical));
    if (usage != null) {
      request = request + "&usage="+usage;
    }
    String server = null;
    try {
      JsonObject json = JsonParser.parseObjectFromUrl(request);
      for (JsonObject item : json.getJsonObjects("authoritative")) {
        if (server == null) {
          server = item.asString("url");
        }
      }
      for (JsonObject item : json.getJsonObjects("candidates")) {
        if (server == null) {
          server = item.asString("url");
        }
      }
      if (server == null) {
        return null;
      }
      if (server.contains("://tx.fhir.org")) {
        try {
          server = server.replace("tx.fhir.org", host());
        } catch (MalformedURLException e) {
        }
      }
      TerminologyClientContext client = serverMap.get(server);
      if (client == null) {
        try {
          client = new TerminologyClientContext(factory.makeClient("id"+(serverList.size()+1), ManagedWebAccess.makeSecureRef(server), getMasterClient().getUserAgent(), getMasterClient().getLogger()), cache, cacheId, false);
        } catch (URISyntaxException | IOException e) {
          throw new TerminologyServiceException("Error accessing "+server+" for "+canonical+": "+e.getMessage(), e);
        }
        serverList.add(client);
        serverMap.put(server, client);
      }
      client.seeUse(canonical, TerminologyClientContextUseType.readCS);
      String criteria = canonical.contains("|") ? 
          "?_format=json&url="+Utilities.URLEncode(canonical.substring(0, canonical.lastIndexOf("|")))+(canonical.contains("|") ? "&version="+Utilities.URLEncode(canonical.substring(canonical.lastIndexOf("|")+1)) : "") : 
            "?_format=json&url="+Utilities.URLEncode(canonical);
      request = Utilities.pathURL(client.getAddress(), "CodeSystem"+ criteria);
      Bundle bnd = client.getClient().search("CodeSystem", criteria);
      String rid = null;
      if (bnd.getEntry().size() == 0) {
        return null;
      } else if (bnd.getEntry().size() > 1) {
        List<CodeSystem> cslist = new ArrayList<>();
        for (BundleEntryComponent be : bnd.getEntry()) {
          if (be.hasResource() && be.getResource() instanceof CodeSystem) {
            cslist.add((CodeSystem) be.getResource());
          }
        }
        Collections.sort(cslist, new CodeSystemUtilities.CodeSystemSorter());
        rid = cslist.get(cslist.size()-1).getIdBase();
      } else {
        if (bnd.getEntryFirstRep().hasResource() && bnd.getEntryFirstRep().getResource() instanceof CodeSystem) {
          rid = bnd.getEntryFirstRep().getResource().getIdBase();
        }
      }
      if (rid == null) {
        return null;
      }
      CodeSystem vs = (CodeSystem) client.getClient().read("CodeSystem", rid);
      return new SourcedCodeSystem(server, vs);
    } catch (Exception e) {
      String msg = "Error resolving CodeSystem "+canonical+": "+e.getMessage();
      if (!hasMessage(msg)) {
        internalLog.add(new InternalLogEvent(msg, canonical, request));
      }
      logger.logDebugMessage(ILoggingService.LogCategory.TX, ExceptionUtils.getStackTrace(e));
      return null;
    }
  }

  public boolean supportsSystem(String system) throws IOException {
    for (TerminologyClientContext client : serverList) {
      if (client.supportsSystem(system)) {
        return true;
      }
    }
    return false;
  }

  public List<InternalLogEvent> getInternalLog() {
    return internalLog;
  }

  public ILoggingService getLogger() {
    return logger;
  }

  public void setLogger(ILoggingService logger) {
    this.logger = logger;
  }

  
}
