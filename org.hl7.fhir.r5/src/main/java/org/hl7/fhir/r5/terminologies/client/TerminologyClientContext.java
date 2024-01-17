package org.hl7.fhir.r5.terminologies.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext.TerminologyClientContextUseCount;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;

public class TerminologyClientContext {
  public enum TerminologyClientContextUseType {
    expand, validate, readVS
  }
  public class TerminologyClientContextUseCount {
    private int expands;
    private int validates;
    private int readVS;
    
    public int getReadVS() {
      return readVS;
    }
    public void setReadVS(int readVS) {
      this.readVS = readVS;
    }
    public int getExpands() {
      return expands;
    }
    public void setExpands(int expands) {
      this.expands = expands;
    }
    public int getValidates() {
      return validates;
    }
    public void setValidates(int validates) {
      this.validates = validates;
    }
    
  }

  private ITerminologyClient client;
  private boolean initialised = false;
  private CapabilityStatement capabilitiesStatementQuick;
  private TerminologyCapabilities txcaps;
  private TerminologyCache txCache;
  
  private Map<String, TerminologyClientContextUseCount> useCounts = new HashMap<>();
  private boolean isTxCaching;
  private final Set<String> cached = new HashSet<>();
  private boolean master;
  private String cacheId;

  protected TerminologyClientContext(ITerminologyClient client, String cacheId, boolean master) {
    super();
    this.client = client;
    this.cacheId = cacheId;
    this.master = master;
  }

  public Map<String, TerminologyClientContextUseCount> getUseCounts() {
    return useCounts;
  }

  public boolean isMaster() {
    return master;
  }

  public ITerminologyClient getClient() {
    return client;
  }

  public void seeUse(String s, TerminologyClientContextUseType useType) {
    TerminologyClientContextUseCount uc = useCounts.get(s);
    if (uc == null) {
      uc = new TerminologyClientContextUseCount();
      useCounts.put(s,uc);
    }
    switch (useType) {
    case expand:
      uc.expands++;
      break;
    case readVS:
      uc.readVS++;
      break;
    case validate:
      uc.validates++;
      break;
    default:
      break;
    }
  }

  public TerminologyCapabilities getTxCapabilities() {
    return txcaps;
  }

  public void setTxCapabilities(TerminologyCapabilities txcaps) {
    this.txcaps = txcaps;
  }

  public Set<String> getCached() {
    return cached;
  }

  public boolean alreadyCached(CanonicalResource cr) {
    return cached.contains(cr.getVUrl());
  }

  public void addToCache(CanonicalResource cr) {
    cached.add(cr.getVUrl());
  }

  public String getAddress() {
    return client.getAddress();
  }

  public int getUseCount() {
    return getClient().getUseCount();
  }

  public boolean isTxCaching() {
    return isTxCaching;
  }
  
  public void setTxCaching(boolean isTxCaching) {
    this.isTxCaching = isTxCaching;
  }

  public boolean usingCache() {
    return isTxCaching && cacheId != null;
  }

  public String getCacheId() {
    return cacheId;
  }

  public TerminologyCache getTxCache() {
    return txCache;
  }

  public void setTxCache(TerminologyCache txCache) {
    this.txCache = txCache;
  }

  public void initialize() throws IOException {
    if (!initialised) {
      // we don't cache the quick CS - we want to know that the server is with us. 
      capabilitiesStatementQuick =  client.getCapabilitiesStatementQuick();
      if (txCache != null && txCache.hasTerminologyCapabilities(getAddress())) {
        txcaps = txCache.getTerminologyCapabilities(getAddress());
        if (txcaps.getSoftware().hasVersion() && !txcaps.getSoftware().getVersion().equals(capabilitiesStatementQuick.getSoftware().getVersion())) {
          txcaps = null;
        }
      } 
      if (txcaps == null) {
        txcaps = client.getTerminologyCapabilities();
        if (txCache != null) {
          txCache.cacheTerminologyCapabilities(getAddress(), txcaps);
        }
      }
      if (txcaps != null) {
        for (TerminologyCapabilitiesExpansionParameterComponent t : txcaps.getExpansion().getParameter()) {
          if ("cache-id".equals(t.getName())) {
            setTxCaching(true);
            break;
          }
        }
      }
      initialised = true;
    }    
  }

  public boolean supportsSystem(String system) throws IOException {
    initialize();
    for (TerminologyCapabilitiesCodeSystemComponent tccs : txcaps.getCodeSystem()) {
      if (system.equals(tccs.getUri())) {
        return true;
      }
    }
    return false;
  }
}
