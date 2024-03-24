package org.hl7.fhir.r5.terminologies.client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.CanonicalResourceManager;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext.TerminologyClientContextUseType;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager.ServerOptionList;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.SourcedValueSet;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class TerminologyClientManager {
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

  public static final String UNRESOLVED_VALUESET = "--unknown--";

  private static final boolean IGNORE_TX_REGISTRY = false;
  
  private ITerminologyClientFactory factory;
  private String cacheId;
  private List<TerminologyClientContext> serverList = new ArrayList<>(); // clients by server address
  private Map<String, TerminologyClientContext> serverMap = new HashMap<>(); // clients by server address
  private Map<String, ServerOptionList> resMap = new HashMap<>(); // client resolution list
  private List<String> internalLog = new ArrayList<>();
  protected Parameters expParameters;

  private TerminologyCache cache;

  private File cacheFile;
  private String usage;

  private String monitorServiceURL;

  public TerminologyClientManager(ITerminologyClientFactory factory, String cacheId) {
    super();
    this.factory = factory;
    this.cacheId = cacheId;
  }
  
  public String getCacheId() {
    return cacheId; 
  }
  
  public void copy(TerminologyClientManager other) {
    cacheId = other.cacheId;  
    serverList.addAll(other.serverList);
    serverMap.putAll(other.serverMap);
    resMap.putAll(other.resMap);
    monitorServiceURL = other.monitorServiceURL;
    factory = other.factory;
    usage = other.usage;
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
          return findClient(s, systems, expand);
        }
      }
    }
    
    // no agreement? Then what we do depends     
    if (vs != null) {
      if (vs.hasUserData("External.Link")) {
        if (systems.size() == 1) {
          internalLog.add(vs.getVersionedUrl()+" uses the system "+systems.toString()+" not handled by any servers. Using source @ '"+vs.getUserString("External.Link")+"'");
        } else {
          internalLog.add(vs.getVersionedUrl()+" includes multiple systems "+systems.toString()+" best handled by multiple servers: "+choices.toString()+". Using source @ '"+vs.getUserString("External.Link")+"'");
        }
        return findClient(vs.getUserString("External.Link"), systems, expand);
      } else {
        if (systems.size() == 1) {
          internalLog.add(vs.getVersionedUrl()+" uses the system "+systems.toString()+" not handled by any servers. Using master @ '"+serverList.get(0)+"'");
        } else {
          internalLog.add(vs.getVersionedUrl()+" includes multiple systems "+systems.toString()+" best handled by multiple servers: "+choices.toString()+". Using master @ '"+serverList.get(0)+"'");
        }
        return findClient(serverList.get(0).getAddress(), systems, expand);
      }      
    } else {
      if (systems.size() == 1) {
        internalLog.add("Request for system "+systems.toString()+" not handled by any servers. Using master @ '"+serverList.get(0)+"'");
      } else {
        internalLog.add("Request for multiple systems "+systems.toString()+" best handled by multiple servers: "+choices.toString()+". Using master @ '"+serverList.get(0)+"'");
      }
      return findClient(serverList.get(0).getAddress(), systems, expand);
    }
  }

  private TerminologyClientContext findClient(String server, Set<String> systems, boolean expand) {
    TerminologyClientContext client = serverMap.get(server);
    if (client == null) {
      try {
        client = new TerminologyClientContext(factory.makeClient("id"+(serverList.size()+1), server, getMasterClient().getUserAgent(), getMasterClient().getLogger()), cacheId, false);
      } catch (URISyntaxException e) {
        throw new TerminologyServiceException(e);
      }
      client.setTxCache(cache);
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
        serverList.replace("tx.fhir.org", new URL(getMasterClient().getAddress()).getHost());
      } catch (MalformedURLException e) {
      }
      resMap.put(s, serverList);
      save();
    }
    return serverList;
  }

  private ServerOptionList decideWhichServer(String url) {
    if (IGNORE_TX_REGISTRY) {
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
      String msg = "Error resolving system "+url+": "+e.getMessage()+" ("+request+")";
      if (!internalLog.contains(msg)) {
        internalLog.add(msg);
      }
      if (!monitorServiceURL.contains("tx.fhir.org")) {
        e.printStackTrace();
      }
    }
    return new ServerOptionList( getMasterClient().getAddress());
    
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

  public TerminologyClientContext setMasterClient(ITerminologyClient client) {
    TerminologyClientContext details = new TerminologyClientContext(client, cacheId, true);
    details.setTxCache(cache);
    serverList.clear();
    serverList.add(details);
    serverMap.put(client.getAddress(), details);  
    monitorServiceURL = Utilities.pathURL(Utilities.getDirectoryForURL(client.getAddress()), "tx-reg");
    return details;
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
        cacheFile = new File(Utilities.path(cache.getFolder(), "system-map.json"));
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

  public List<String> getInternalLog() {
    return internalLog;
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
    String request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&valueSet="+Utilities.URLEncode(canonical));
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
          server = server.replace("tx.fhir.org", new URL(getMasterClient().getAddress()).getHost());
        } catch (MalformedURLException e) {
        }
      }
      TerminologyClientContext client = serverMap.get(server);
      if (client == null) {
        try {
          client = new TerminologyClientContext(factory.makeClient("id"+(serverList.size()+1), server, getMasterClient().getUserAgent(), getMasterClient().getLogger()), cacheId, false);
        } catch (URISyntaxException e) {
          throw new TerminologyServiceException(e);
        }
        client.setTxCache(cache);
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
        return null;
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
      e.printStackTrace();
      String msg = "Error resolving valueSet "+canonical+": "+e.getMessage()+" ("+request+")";
      if (!internalLog.contains(msg)) {
        internalLog.add(msg);
      }
      e.printStackTrace();
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
  
}
