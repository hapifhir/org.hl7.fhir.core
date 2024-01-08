package org.hl7.fhir.r5.terminologies.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext.TerminologyClientContextUseCount;

public class TerminologyClientContext {
  public class TerminologyClientContextUseCount {
    private int expands;
    private int validates;
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
  Map<String, TerminologyClientContextUseCount> useCounts = new HashMap<>();
  private TerminologyCapabilities txcaps;
  private final Set<String> cached = new HashSet<>();
  private boolean master;

  protected TerminologyClientContext(ITerminologyClient client, boolean master) {
    super();
    this.client = client;
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

  public void seeUse(String s, boolean expand) {
    TerminologyClientContextUseCount uc = useCounts.get(s);
    if (uc == null) {
      uc = new TerminologyClientContextUseCount();
      useCounts.put(s,uc);
    }
    if (expand) {
      uc.expands++;
    } else {
      uc.validates++;
    }
  }

  public TerminologyCapabilities getTxcaps() {
    return txcaps;
  }

  public void setTxcaps(TerminologyCapabilities txcaps) {
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

}
