package org.hl7.fhir.utilities.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
public class FhirSettingsPOJO {


  protected static final String TX_SERVER_PROD = "http://tx.fhir.org";
  protected static final String TX_SERVER_DEV = "http://tx-dev.fhir.org";
  protected static final String TX_SERVER_LOCAL = "http://local.fhir.org";  
  
  private String fhirDirectory;
  private Map<String, String> apiKeys;

  private String npmPath;

  private String rubyPath;

  private String fhirTestCasesPath;

  private String diffToolPath;

  private String tempPath;

  private String testIgsPath;

  private Boolean prohibitNetworkAccess;

  private String txFhirProduction;
  private String txFhirDevelopment;
  private String txFhirLocal;

  private List<PackageServerPOJO> packageServers;

  protected FhirSettingsPOJO() {
    apiKeys = null;
    npmPath = null;
    rubyPath = null;
    fhirTestCasesPath = null;
    diffToolPath = null;
    tempPath = null;
    testIgsPath = null;
    txFhirProduction = TX_SERVER_PROD;
    txFhirDevelopment = TX_SERVER_DEV;
    txFhirLocal = TX_SERVER_LOCAL;

    packageServers = null;
  }
}
