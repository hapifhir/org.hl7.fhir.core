package org.hl7.fhir.r5.terminologies.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext.TerminologyClientContextUseCount;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.ENoDump;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.VersionUtilities;

@MarkedToMoveToAdjunctPackage
public class TerminologyClientContext {
  
  public enum TerminologyClientContextUseType {
    expand, validate, readVS, readCS
  }
  public class TerminologyClientContextUseCount {
    private int expands;
    private int validates;
    private int readVS;
    private int readCS;

    public int getReadVS() {
      return readVS;
    }
    public void setReadVS(int readVS) {
      this.readVS = readVS;
    }
    public int getReadCS() {
      return readCS;
    }
    public void setReadCS(int readCS) {
      this.readCS = readCS;
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

  private static final String MIN_TEST_VERSION = "1.6.0";
  private static boolean allowNonConformantServers = false;
  private static boolean canAllowNonConformantServers = false;

  private static boolean canUseCacheId;

  private ITerminologyClient client;
  private boolean initialised = false;
  private CapabilityStatement capabilitiesStatement;
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

  public void seeUse(Set<String> systems, TerminologyClientContextUseType useType) {
    if (systems != null) {
      for (String s : systems) {
        seeUse(s, useType);
      }
    }
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
    case readCS:
      uc.readCS++;
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
      capabilitiesStatement = client.getCapabilitiesStatement();
      checkFeature();
      if (txCache != null && txCache.hasTerminologyCapabilities(getAddress())) {
        txcaps = txCache.getTerminologyCapabilities(getAddress());
        if (txcaps.getSoftware().hasVersion() && !txcaps.getSoftware().getVersion().equals(capabilitiesStatement.getSoftware().getVersion())) {
          txcaps = null;
        }
      } 
      if (txcaps == null) {
        txcaps = client.getTerminologyCapabilities();
        if (txCache != null) {
          txCache.cacheTerminologyCapabilities(getAddress(), txcaps);
        }
      }
      if (txcaps != null && TerminologyClientContext.canUseCacheId) {
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

  private void checkFeature() {
    if (!allowNonConformantServers && capabilitiesStatement != null) {
      String testVersion = null;
      boolean csParams = false;

      for (Extension t : capabilitiesStatement.getExtension()) {
        if (ToolingExtensions.EXT_FEATURE.equals(t.getUrl())) {
          String defn = t.getExtensionString("definition");
          if (ToolingExtensions.FEATURE_TX_TEST_VERSION.equals(defn)) {
            testVersion = t.getExtensionString("value");
          } else if (ToolingExtensions.FEATURE_TX_CS_PARAMS.equals(defn)) {
            csParams = "true".equals(t.getExtensionString("value"));
          } 
        }
      }

      if (testVersion == null) {
        if (canAllowNonConformantServers) {
          throw new ENoDump("The terminology server "+client.getAddress()+" is not approved for use with this software (it does not pass the required tests).\r\nIf you wish to use this server, add the parameter -authorise-non-conformant-tx-servers to the command line parameters");
        } else {
          throw new ENoDump("The terminology server "+client.getAddress()+" is not approved for use with this software (it does not pass the required tests)");
        }
      } else if (!VersionUtilities.isThisOrLater(MIN_TEST_VERSION, testVersion)) {
        if (canAllowNonConformantServers) {
          throw new ENoDump("The terminology server "+client.getAddress()+" is not approved for use with this software as it is too old (test version = "+testVersion+").\r\nIf you wish to use this server, add the parameter -authorise-non-conformant-tx-servers to the command line parameters");
        } else {
          throw new ENoDump("The terminology server "+client.getAddress()+" is not approved for use with this software as it is too old (test version = "+testVersion+")");          
        }
      } else if (!csParams) {
        if (canAllowNonConformantServers) {
          throw new ENoDump("The terminology server "+client.getAddress()+" is not approved for use as it does not accept code systems in the tx-resource parameter.\r\nIf you wish to use this server, add the parameter -authorise-non-conformant-tx-servers to the command line parameters");
        } else {
          throw new ENoDump("The terminology server "+client.getAddress()+" is not approved for use as it does not accept code systems in the tx-resource parameter");          
        }
      } else {
        // all good
      }
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

  @Override
  public String toString() {
    return client.getAddress();
  }

  public static boolean isCanUseCacheId() {
    return canUseCacheId;
  }

  public static void setCanUseCacheId(boolean canUseCacheId) {
    TerminologyClientContext.canUseCacheId = canUseCacheId;
  }

  public String getHost() {
    try {
      URL uri = new URL(getAddress());
      return uri.getHost();
    } catch (MalformedURLException e) {
      return getAddress();
    }
  }

  public static boolean isAllowNonConformantServers() {
    return allowNonConformantServers;
  }

  public static void setAllowNonConformantServers(boolean allowNonConformantServers) {
    TerminologyClientContext.allowNonConformantServers = allowNonConformantServers;
  }

  public static boolean isCanAllowNonConformantServers() {
    return canAllowNonConformantServers;
  }

  public static void setCanAllowNonConformantServers(boolean canAllowNonConformantServers) {
    TerminologyClientContext.canAllowNonConformantServers = canAllowNonConformantServers;
  }
  
}
