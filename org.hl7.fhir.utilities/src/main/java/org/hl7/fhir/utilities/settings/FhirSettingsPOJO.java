package org.hl7.fhir.utilities.settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
public class FhirSettingsPOJO {


  protected static final String TX_SERVER_PROD = "https://tx.fhir.org";
  protected static final String TX_SERVER_DEV = "https://tx-dev.fhir.org";
  protected static final String TX_SERVER_LOCAL = "http://local.fhir.org:3001";
  
  private String fhirDirectory;
  private Map<String, String> apiKeys;

  private String npmPath;

  private String rubyPath;
  
  private String gemPath;

  private String fhirTestCasesPath;

  private String diffToolPath;

  private String tempPath;

  private String testIgsPath;

  private Boolean prohibitNetworkAccess;

  private String txFhirProduction;
  private String txFhirDevelopment;
  private String txFhirLocal;

  private Boolean ignoreDefaultPackageServers;

  /**
   * This globally turns off the following:
   *   * requiring all web access to be via https protocol
   *   * preventing access to private and non-public servers
   *  WARNING: By default this is TRUE, and it is not recommended to set this to false. It is left as a setting intended
   *  for use in testing, and never in production.
   */
  private Boolean ssrfProtectionEnabled;

  private List<ServerDetailsPOJO> servers;
  private List<String> certificateSources;

  /**
   * The default combination logic used by {@link #combineWith(BinaryOperator, FhirSettingsPOJO...)} when no other
   * logic is supplied. Scalar fields take the second argument's value when it is non-null, otherwise the first
   * argument's value. List fields ({@link #servers} and {@link #certificateSources}) are concatenated, first
   * argument then second.
   * <p/>
   * This is the logic used by {@code org.hl7.fhir.utilities.http.ManagedWebAccess#loadFromFHIRSettings(FhirSettingsPOJO)}.
   */
  public static final BinaryOperator<FhirSettingsPOJO> DEFAULT_COMBINATION_LOGIC =
    (a, b) -> FhirSettingsPOJO.builder()
      .fhirDirectory(overlay(a.getFhirDirectory(), b.getFhirDirectory()))
      .apiKeys(overlay(a.getApiKeys(), b.getApiKeys()))
      .npmPath(overlay(a.getNpmPath(), b.getNpmPath()))
      .rubyPath(overlay(a.getRubyPath(), b.getRubyPath()))
      .gemPath(overlay(a.getGemPath(), b.getGemPath()))
      .fhirTestCasesPath(overlay(a.getFhirTestCasesPath(), b.getFhirTestCasesPath()))
      .diffToolPath(overlay(a.getDiffToolPath(), b.getDiffToolPath()))
      .tempPath(overlay(a.getTempPath(), b.getTempPath()))
      .testIgsPath(overlay(a.getTestIgsPath(), b.getTestIgsPath()))
      .prohibitNetworkAccess(overlay(a.getProhibitNetworkAccess(), b.getProhibitNetworkAccess()))
      .txFhirProduction(overlay(a.getTxFhirProduction(), b.getTxFhirProduction()))
      .txFhirDevelopment(overlay(a.getTxFhirDevelopment(), b.getTxFhirDevelopment()))
      .txFhirLocal(overlay(a.getTxFhirLocal(), b.getTxFhirLocal()))
      .ignoreDefaultPackageServers(overlay(a.getIgnoreDefaultPackageServers(), b.getIgnoreDefaultPackageServers()))
      .ssrfProtectionEnabled(overlay(a.getSsrfProtectionEnabled(), b.getSsrfProtectionEnabled()))
      .servers(concat(a.getServers(), b.getServers()))
      .certificateSources(concat(a.getCertificateSources(), b.getCertificateSources()))
      .build();

  private static <T> T overlay(T a, T b) {
    return b != null ? b : a;
  }

  private static <T> List<T> concat(List<T> a, List<T> b) {
    Stream<T> aStream = a == null ? Stream.empty() : a.stream();
    Stream<T> bStream = b == null ? Stream.empty() : b.stream();
    return Stream.concat(aStream, bStream).toList();
  }

  /**
   * Combines this {@link FhirSettingsPOJO} with one or more others, in order, using the given combination logic.
   * <p/>
   * Example: {@code pojoA.combineWith(logic, pojoB)} or {@code pojoA.combineWith(logic, pojoB, pojoC)}.
   *
   * @param combinationLogic a function that takes the running result and the next {@link FhirSettingsPOJO} and
   *                          returns the combined result
   * @param others           the {@link FhirSettingsPOJO}s to combine into this one, in order
   * @return the combined {@link FhirSettingsPOJO}
   */
  public FhirSettingsPOJO combineWith(BinaryOperator<FhirSettingsPOJO> combinationLogic, FhirSettingsPOJO... others) {
    FhirSettingsPOJO result = this;
    for (FhirSettingsPOJO other : others) {
      result = combinationLogic.apply(result, other);
    }
    return result;
  }

  /**
   * Returns a deep copy, with new {@link #apiKeys}, {@link #servers} and {@link #certificateSources} collections
   * (each server also deep-copied), so that mutating the copy cannot affect this instance.
   */
  public FhirSettingsPOJO copy() {
    return toBuilder()
      .apiKeys(apiKeys == null ? null : new HashMap<>(apiKeys))
      .servers(servers == null ? null : servers.stream().map(ServerDetailsPOJO::copy).collect(Collectors.toList()))
      .certificateSources(certificateSources == null ? null : new ArrayList<>(certificateSources))
      .build();
  }

  protected FhirSettingsPOJO() {
    apiKeys = null;
    npmPath = null;
    rubyPath = null;
    gemPath = null;
    fhirTestCasesPath = null;
    diffToolPath = null;
    tempPath = null;
    testIgsPath = null;
    txFhirProduction = TX_SERVER_PROD;
    txFhirDevelopment = TX_SERVER_DEV;
    txFhirLocal = TX_SERVER_LOCAL;
    ssrfProtectionEnabled = true;
    servers = new ArrayList<>();
    certificateSources = new ArrayList<>();
  }
}
