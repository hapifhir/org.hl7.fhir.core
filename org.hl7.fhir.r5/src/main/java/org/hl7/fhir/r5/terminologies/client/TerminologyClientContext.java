package org.hl7.fhir.r5.terminologies.client;

import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r5.model.TerminologyCapabilities;

public class TerminologyClientContext {
  private String cacheId;
  private boolean isTxCaching;
  private int serverQueryCount = 0;
  private final Set<String> cached = new HashSet<>();
  protected String server;
  private ITerminologyClient client;
  private TerminologyCapabilities txcaps;

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
  
  public int getServerQueryCount() {
    return serverQueryCount;
  }
  
  public void setServerQueryCount(int serverQueryCount) {
    this.serverQueryCount = serverQueryCount;
  }
  
  public Set<String> getCached() {
    return cached;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public ITerminologyClient getClient() {
    return client;
  }

  public void setClient(ITerminologyClient client) {
    this.client = client;
  }
    
  public TerminologyCapabilities getTxcaps() {
    return txcaps;
  }

  public void setTxcaps(TerminologyCapabilities txcaps) {
    this.txcaps = txcaps;
  }

  public void copy(TerminologyClientContext other) {
    cacheId = other.cacheId;  
    isTxCaching = other.isTxCaching;
    cached.addAll(other.cached);
//    tsServer = other.tsServer;
    client = other.client;
    txcaps = other.txcaps;

  }

  
  
}
