package org.hl7.fhir.r5.terminologies.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;

import org.hl7.fhir.utilities.ENoDump;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.VersionUtilities;

@MarkedToMoveToAdjunctPackage
public class TerminologyClientContext {
  public static final String MIN_TEST_VERSION = "1.6.0";
  public static final String TX_BATCH_VERSION = "1.7.8"; // actually, it's 17.7., but there was an error in the tx.fhir.org code around this
  public static final String LATEST_VERSION = "1.9.0";

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

  @Getter
  private static boolean allowNonConformantServers = false;
  @Getter
  @Setter
  private static boolean canAllowNonConformantServers = false;

  @Getter
  private static boolean canUseCacheId;

  private ITerminologyClient client;

  private CapabilityStatement capabilitiesStatement;
  private TerminologyCapabilities txcaps;
  @Getter
  private final TerminologyCache txCache;
  private String testVersion;
  
  private Map<String, TerminologyClientContextUseCount> useCounts = new HashMap<>();
  private boolean isTxCaching;
  private final Set<String> cached = new HashSet<>();
  private boolean master;
  private String cacheId;

  protected TerminologyClientContext(ITerminologyClient client, TerminologyCache txCache, String cacheId, boolean master) throws IOException {
    super();
    this.client = client;
    this.txCache = txCache;
    this.cacheId = cacheId;
    this.master = master;
    initialize();
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
    try {
      new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/temp/txcaps.json"), txcaps);
    } catch (IOException e) {

    }
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

  private void initialize() throws IOException {

      // we don't cache the quick CS - we want to know that the server is with us. 
      capabilitiesStatement = client.getCapabilitiesStatement();
      checkFeature();
      if (txCache != null && txCache.hasTerminologyCapabilities(getAddress())) {
        txcaps = txCache.getTerminologyCapabilities(getAddress());
        try {
          new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/temp/txcaps.json"), txcaps);
        } catch (IOException e) {

        }
        if (txcaps.getSoftware().hasVersion() && !txcaps.getSoftware().getVersion().equals(capabilitiesStatement.getSoftware().getVersion())) {
          txcaps = null;
        }
      } 
      if (txcaps == null) {
        txcaps = client.getTerminologyCapabilities();
        if (txCache != null) {
          try {
            txCache.cacheTerminologyCapabilities(getAddress(), txcaps);
          } catch (IOException e) {
            e.printStackTrace();
          }
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

  }

  private void checkFeature() {
    if (!allowNonConformantServers && capabilitiesStatement != null) {
      boolean csParams = false;

      for (Extension t : capabilitiesStatement.getExtension()) {
        if (ExtensionDefinitions.EXT_FEATURE.equals(t.getUrl())) {
          String defn = t.getExtensionString("definition");
          if (ExtensionDefinitions.FEATURE_TX_TEST_VERSION.equals(defn)) {
            testVersion = t.getExtensionString("value");
          } else if (ExtensionDefinitions.FEATURE_TX_CS_PARAMS.equals(defn)) {
            csParams = "true".equals(t.getExtensionString("value"));
          } 
        }
      }

      if (testVersion == null) {
        if (canAllowNonConformantServers) {
          throw new TerminologyServiceException("The terminology server "+client.getAddress()+" is not approved for use with this software (it does not pass the required tests).\r\nIf you wish to use this server, add the parameter -authorise-non-conformant-tx-servers to the command line parameters");
        } else {
          throw new TerminologyServiceException("The terminology server "+client.getAddress()+" is not approved for use with this software (it does not pass the required tests)");
        }
      } else if (!VersionUtilities.isThisOrLater(MIN_TEST_VERSION, testVersion, VersionUtilities.VersionPrecision.MINOR)) {
        if (canAllowNonConformantServers) {
          throw new TerminologyServiceException("The terminology server "+client.getAddress()+" is not approved for use with this software as it is too old (test version = "+testVersion+").\r\nIf you wish to use this server, add the parameter -authorise-non-conformant-tx-servers to the command line parameters");
        } else {
          throw new TerminologyServiceException("The terminology server "+client.getAddress()+" is not approved for use with this software as it is too old (test version = "+testVersion+")");
        }
      } else if (!csParams) {
        if (canAllowNonConformantServers) {
          throw new TerminologyServiceException("The terminology server "+client.getAddress()+" is not approved for use as it does not accept code systems in the tx-resource parameter.\r\nIf you wish to use this server, add the parameter -authorise-non-conformant-tx-servers to the command line parameters");
        } else {
          throw new TerminologyServiceException("The terminology server "+client.getAddress()+" is not approved for use as it does not accept code systems in the tx-resource parameter");
        }
      } else {
        // all good
      }
    }
  }

  public boolean supportsSystem(String system) throws IOException {
    try {
      new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/temp/txcaps.json"), txcaps);
    } catch (IOException e) {

    }
    for (TerminologyCapabilitiesCodeSystemComponent tccs : txcaps.getCodeSystem()) {
      if (system.equals(tccs.getUri()) || (tccs.hasVersion() && system.equals(CanonicalType.urlWithVersion(tccs.getUri(), tccs.getVersionFirstRep().getCode())))) {
        return true;
      }
      if (system.startsWith(tccs.getUri()+"|")) {
        if (tccs.hasVersion()) {
          for (TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent v : tccs.getVersion()) {
            if (system.equals(CanonicalType.urlWithVersion(tccs.getUri(), v.getCode()))) {
              return true;
            }
          }
          for (TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent v : tccs.getVersion()) {
            if (system.startsWith("http://snomed.info/sct") && CanonicalType.urlWithVersion(tccs.getUri(), v.getCode()).startsWith(system) && v.getIsDefault()) {
              return true;
            }
          }
          for (TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent v : tccs.getVersion()) {
            if (system.startsWith("http://snomed.info/sct") && CanonicalType.urlWithVersion(tccs.getUri(), v.getCode()).startsWith(system)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public String getTxTestVersion() {
    try {
      return testVersion;
    } catch (Exception e) {
      // debug?
      return null;
    }
  }

  @Override
  public String toString() {
    return client.getAddress();
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

  public static void setAllowNonConformantServers(boolean allowNonConformantServers) {
    TerminologyClientContext.allowNonConformantServers = allowNonConformantServers;
  }

}
