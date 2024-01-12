package org.hl7.fhir.r5.terminologies.client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class TerminologyClientManager {
  public ITerminologyClientFactory getFactory() {
    return factory;
  }

  public interface ITerminologyClientFactory {
    ITerminologyClient makeClient(String id, String url, String userAgent) throws URISyntaxException;
    String getVersion();
  }

  public static final String UNRESOLVED_VALUESET = "--unknown--";
  
  private ITerminologyClientFactory factory;
  private String cacheId;
  private boolean isTxCaching;
  private List<TerminologyClientContext> serverList = new ArrayList<>(); // clients by server address
  private Map<String, TerminologyClientContext> serverMap = new HashMap<>(); // clients by server address
  private Map<String, String> resMap = new HashMap<>(); // client resolution list
  private List<String> internalErrors = new ArrayList<>();
  protected Parameters expParameters;

  private TerminologyCache cache;

  private File cacheFile;
  private String usage;

  private String monitorServiceURL;

  public TerminologyClientManager(ITerminologyClientFactory factory) {
    super();
    this.factory = factory;
  }
  
  public String getCacheId() {
    return cacheId; 
  }
  
  public void setCacheId(String cacheId) {
    this.cacheId = cacheId;
  }
  
  public boolean isTxCaching() {
    return isTxCaching;
  }
  
  public void setTxCaching(boolean isTxCaching) {
    this.isTxCaching = isTxCaching;
  }
  
  public void copy(TerminologyClientManager other) {
    cacheId = other.cacheId;  
    isTxCaching = other.isTxCaching;
    serverList.addAll(other.serverList);
    serverMap.putAll(other.serverMap);
    resMap.putAll(other.resMap);
    monitorServiceURL = other.monitorServiceURL;
    factory = other.factory;
    usage = other.usage;
  }

  public boolean usingCache() {
    return isTxCaching && cacheId != null;
  }


  public TerminologyClientContext chooseServer(Set<String> systems, boolean expand) throws TerminologyServiceException {
    if (serverList.isEmpty()) {
      return null;
    }
    if (systems.contains(UNRESOLVED_VALUESET)) {
      return serverList.get(0);
    }
    
    Set<TerminologyClientContext> clients = new HashSet<>();
    for (String s : systems) {
      clients.add(findServerForSystem(s, expand));
    }
    if (clients.size() == 1) {
      return clients.iterator().next();
    } else {
      System.out.println("systems: "+systems.toString());
      return serverList.get(0);
    }
  }

  private TerminologyClientContext findServerForSystem(String s, boolean expand) throws TerminologyServiceException {
    String server = resMap.get(s);
    if (server == null) {
      server = decideWhichServer(s);
      // testing support
      if (server != null && server.contains("://tx.fhir.org")) {
        try {
          server = server.replace("tx.fhir.org", new URL(getMasterClient().getAddress()).getHost());
        } catch (MalformedURLException e) {
        }
      }
      resMap.put(s, server);
      save();
    }
    TerminologyClientContext client = serverMap.get(server);
    if (client == null) {
      try {
        client = new TerminologyClientContext(factory.makeClient("id"+(serverList.size()+1), server, getMasterClient().getUserAgent()), false);
      } catch (URISyntaxException e) {
        throw new TerminologyServiceException(e);
      }
      serverList.add(client);
      serverMap.put(server, client);
    }
    client.seeUse(s, expand);
    return client;
  }

  private String decideWhichServer(String url) {
    if (expParameters != null) {
      if (!url.contains("|")) {
        // the client hasn''t specified an explicit version, but the expansion parameters might
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
    String request = Utilities.pathURL(monitorServiceURL, "resolve?fhirVersion="+factory.getVersion()+"&url="+url);
    if (usage != null) {
      request = request + "&usage="+usage;
    } 
    try {
      JsonObject json = JsonParser.parseObjectFromUrl(request);
      for (JsonObject item : json.getJsonObjects("authoritative")) {
        return item.asString("url");
      }
      for (JsonObject item : json.getJsonObjects("candidate")) {
        return item.asString("url");
      }
    } catch (Exception e) {
      String msg = "Error resolving system "+url+": "+e.getMessage()+" ("+request+")";
      if (!internalErrors.contains(msg)) {
        internalErrors.add(msg);
      }
      if (!monitorServiceURL.contains("tx.fhir.org")) {
        e.printStackTrace();
      }
    }
    return getMasterClient().getAddress();
    
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

  public void setMasterClient(ITerminologyClient client) {
    TerminologyClientContext details = new TerminologyClientContext(client, true);
    serverList.clear();
    serverList.add(details);
    serverMap.put(client.getAddress(), details);  
    monitorServiceURL = Utilities.pathURL(Utilities.getDirectoryForURL(client.getAddress()), "tx-reg");
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

  public TerminologyCapabilities getTxCapabilities() {
    return hasClient() ? serverList.get(0).getTxcaps() : null;
  }

  public void setTxCapabilities(TerminologyCapabilities txCaps) {
    serverList.get(0).setTxcaps(txCaps);    
  }

  public void setFactory(ITerminologyClientFactory factory) {
    this.factory = factory;    
    System.out.println("tcc factory version = "+factory.getVersion());
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
            resMap.put(pair.asString("system"), pair.asString("server"));
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
        si.add("server", resMap.get(s));
      }
      try {
        JsonParser.compose(json, cacheFile, true);
      } catch (IOException e) {
      }
    }
  }

  public List<String> getInternalErrors() {
    return internalErrors;
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

}
