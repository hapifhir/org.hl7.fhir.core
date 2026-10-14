package org.hl7.fhir.utilities.http;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.BinaryOperator;

import lombok.Getter;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.settings.FhirSettingsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import static org.hl7.fhir.utilities.Utilities.existsInList;

/**
 * see security.md - manages web access by the FHIR HAPI Core library
 * <p/>
 * By using accessPolicy, allowedDomains and accessor, a host java application can control 
 * whether this library has direct access to the web (and which domains it is allowed to access),
 * or whether the host application provides controlled access, or whether no access is allowed at all
 * (in which case other information providers need to be provided).
 * <p/>
 * Web access with these managed features is provided through the following four methods:
 * <ul>
 *   <li>{@link #accessor(Iterable)}</li>
 *   <li>{@link #accessor(Iterable, IHTTPAuthenticationProvider)}</li>
 *   <li>{@link #fhirAccessor()}</li>
 *   <li>{@link #fhirAccessor(IHTTPAuthenticationProvider)}</li>
 * </ul>
 * @author Grahame
 *
 */
@Slf4j
public class ManagedWebAccess {

  public interface IWebAccessor {
    HTTPResult get(Iterable<String> serverTypes, String url, String accept, Map<String, String> headers) throws IOException;
    HTTPResult post(Iterable<String> serverTypes, String url, byte[] bytes, String contentType, String accept, Map<String, String> headers) throws IOException;
    HTTPResult put(Iterable<String> serverTypes, String url, byte[] bytes, String contentType, String accept, Map<String, String> headers) throws IOException;
  }

  public interface IFhirWebAccessor {
    HTTPResult httpCall(HTTPRequest httpRequest);
  }

  public enum WebAccessPolicy {
    DIRECT, // access to the web with using policies set via FhirSettings
    MANAGED, // no access except by the IWebAccessor
    PROHIBITED, // no access at all to the web
  }

  @Getter
  private static WebAccessPolicy accessPolicy = WebAccessPolicy.DIRECT; // for legacy reasons

  @Getter
  private static boolean ssrfProtectionEnabled = true;

  //TODO get this from fhir settings
  private static List<String> allowedDomains = new ArrayList<>();
  @Getter
  private static IWebAccessor accessor;

  @Getter
  private static IFhirWebAccessor fhirWebAccessor;

  @Getter
  private static String userAgent;

  private static List<ServerDetailsPOJO> serverDetailsList;
  private static IHTTPAuthenticationProvider defaultAuthenticationProvider;

  /**
   * @param accessPolicy the global policy for accessing web resources.
   */
  public static void setAccessPolicy(WebAccessPolicy accessPolicy) {
    ManagedWebAccess.accessPolicy = accessPolicy;
  }

  /**
   * This globally turns off the following:
   *  * requiring all web access to be via https protocol
   *  * preventing access to private and non-public servers
   * WARNING: By default this is TRUE. Only set to FALSE if no untrusted party can influence any of the content being processed, or the validator runs where internal network access poses no risk.
   * @param ssrfProtectionEnabled whether to enable ssrf protection
   */
  public static void setSsrfProtectionEnabled(boolean ssrfProtectionEnabled) {
    if (!ssrfProtectionEnabled) {
      log.warn("SSRF protection is disabled. Content being validated (including packages and other dependencies) can direct the validator to fetch URLs of the content's choosing, including internal network addresses. Only run in this mode if no untrusted party can influence any of the content being processed, or the validator runs where internal network access poses no risk.");
    }
    ManagedWebAccess.ssrfProtectionEnabled = ssrfProtectionEnabled;
  }

  static boolean inAllowedPaths(String pathname) {
    if (allowedDomains.isEmpty()) {
      return true;
    }
    for (String s : allowedDomains) {
      if (pathname.startsWith(s)) {
        return true;
      }
    }
    return false;
  }

  public static void setUserAgent(String userAgent) {
    ManagedWebAccess.userAgent = userAgent;
  }

  /**
   * Get an accessor for non-FHIR web servers. This web accessor will use the server settings in fhir-settings.json to
   * manage authentication.
   *
   * @param serverTypes server types to be considered by a client
   * @return a web accessor
   */
  public static ManagedWebAccessor accessor(Iterable<String> serverTypes) {
    return new ManagedWebAccessor(serverTypes, userAgent, defaultAuthenticationProvider);
  }

  /**
   * Get an accessor for non-FHIR web servers. This web accessor will only use the provided authenticationProvider to
   * manage authentication. If you need to combine your own authentication provider with the server settings in
   * fhir-settings.json, consider using {@link HTTPAuthenticationProviderChain} to chain your
   * implementation with {@link ServerDetailsPOJOHTTPAuthProvider}
   *
   * @param serverTypes server types to be considered by a client
   * @param authenticationProvider provides necessary headers for authenticating http requests
   * @return a web accessor
   */
  public static ManagedWebAccessor accessor(Iterable<String> serverTypes, IHTTPAuthenticationProvider authenticationProvider) {
    return new ManagedWebAccessor(serverTypes, userAgent, authenticationProvider);
  }

  /**
   * Get an accessor for FHIR servers. This accessor will use the server settings in fhir-settings.json to manage
   * authentication.
   *
   * @return a FHIR accessor
   */
  public static ManagedFhirWebAccessor fhirAccessor() {
    return new ManagedFhirWebAccessor(userAgent, defaultAuthenticationProvider);
  }

  /**
   * Get an accessor for FHIR servers. This web accessor will only use the provided authenticationProvider to
   * manage authentication. If you need to combine your own authentication provider with the server settings in
   * fhir-settings.json, consider using {@link HTTPAuthenticationProviderChain} to chain your
   * implementation with {@link ServerDetailsPOJOHTTPAuthProvider}
   *
   * @param authenticationProvider provides necessary headers for authenticating http requests
   * @return a FHIR accessor
   */
  public static ManagedFhirWebAccessor fhirAccessor(IHTTPAuthenticationProvider authenticationProvider) {
    return new ManagedFhirWebAccessor(userAgent, authenticationProvider);
  }

  public static HTTPResult get(Iterable<String> serverTypes, String url) throws IOException {
    return accessor(serverTypes).get(url);
  }

  public static HTTPResult get(Iterable<String> serverTypes, String url, String accept) throws IOException {
    return accessor(serverTypes).get(url, accept);
  }

  public static HTTPResult post(Iterable<String> serverTypes, String url, byte[] content, String contentType, String accept) throws IOException {
    return accessor(serverTypes).post(url, content, contentType, accept);
  }

  public static HTTPResult put(Iterable<String> serverTypes, String url, byte[] content, String contentType, String accept) throws IOException {
    return accessor(serverTypes).put(url, content, contentType, accept);
  }

  public static HTTPResult httpCall(HTTPRequest httpRequest) throws IOException {
    return fhirAccessor().httpCall(httpRequest);
  }

  /**
   * Loads settings from {@link FhirSettings} alone.
   */
  public static void loadFromFHIRSettings() {
    applySettings(FhirSettings.getFhirSettingsPOJO());
  }

  /**
   * Loads settings from {@link FhirSettings}, combined with the given {@code overrides} using
   * {@link FhirSettingsPOJO#DEFAULT_COMBINATION_LOGIC} (i.e. {@code overrides} takes precedence over
   * {@link FhirSettings} for any non-null scalar field, and its {@code servers} and {@code certificateSources}
   * are appended to those from {@link FhirSettings}).
   *
   * @param overrides a {@link FhirSettingsPOJO} to combine with the settings from {@link FhirSettings}
   */
  public static void loadFromFHIRSettings(FhirSettingsPOJO overrides) {
    loadFromFHIRSettings(FhirSettingsPOJO.DEFAULT_COMBINATION_LOGIC, overrides);
  }

  /**
   * Loads settings from {@link FhirSettings}, combined with the given {@code overrides} using the given
   * {@code combinationLogic}.
   *
   * @param combinationLogic a function that takes the settings from {@link FhirSettings} and {@code overrides}
   *                          and returns the combined result
   * @param overrides        a {@link FhirSettingsPOJO} to combine with the settings from {@link FhirSettings}
   */
  public static void loadFromFHIRSettings(BinaryOperator<FhirSettingsPOJO> combinationLogic, FhirSettingsPOJO overrides) {
    applySettings(FhirSettings.getFhirSettingsPOJO().combineWith(combinationLogic, overrides));
  }

  /**
   * Loads settings from the given {@link FhirSettingsPOJO} alone, ignoring {@link FhirSettings}.
   *
   * @param settings the {@link FhirSettingsPOJO} to load settings from
   */
  public static void loadFromSettings(FhirSettingsPOJO settings) {
    applySettings(settings);
  }

  private static void applySettings(FhirSettingsPOJO settings) {
    setAccessPolicy(settings.getProhibitNetworkAccess() != null && settings.getProhibitNetworkAccess() ? WebAccessPolicy.PROHIBITED : WebAccessPolicy.DIRECT);
    setSsrfProtectionEnabled(settings.getSsrfProtectionEnabled() == null || settings.getSsrfProtectionEnabled());
    setUserAgent("hapi-fhir-tooling-client");
    serverDetailsList = new ArrayList<>(settings.getServers() == null ? Collections.emptyList() : settings.getServers());
    defaultAuthenticationProvider = new ServerDetailsPOJOHTTPAuthProvider(serverDetailsList);
  }

  /**
   * Returns a secure https url for the provided url unless a matching URL is included in fhir-settings.json
   *
   * @param url an http or https url
   * @return an https url
   */
  public static String makeSecureRef(String url) {
    if (url == null || !url.startsWith("http://") || isDefinedInSettings(url)) {
      return url;
    } else {
      return url.replace("http://", "https://");
    }
  }

  private static boolean isDefinedInSettings(String url) {
    URI uri;
    try {
      uri = new URI(url);
      
      // Check if this URL matches a configured server with allowHttp: true
      // This allows HTTP for trusted internal servers (e.g., Docker service names)
      if (serverDetailsList != null) {
        for (ServerDetailsPOJO server : serverDetailsList) {
          if (server.getAllowHttp() != null && server.getAllowHttp() && server.getUrl() != null && !server.getUrl().isEmpty()) {
            // Match if the URL starts with the configured server URL

            if (ManagedWebAccessUtils.urlMatchesOrigin(url, server.getUrl())) {
              return true;
            }
          }
        }
      }
      
      // Fall back to hardcoded local addresses
      return existsInList(uri.getHost(), "localhost", "local.fhir.org", "127.0.0.1", "[::1]") || (uri.getHost() != null && uri.getHost().endsWith(".localhost"));
    } catch (URISyntaxException e) {
      return false;
    }
  }
}