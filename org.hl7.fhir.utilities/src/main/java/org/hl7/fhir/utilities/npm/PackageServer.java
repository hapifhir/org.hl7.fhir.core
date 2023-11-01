package org.hl7.fhir.utilities.npm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.settings.PackageServerPOJO;

import lombok.Getter;

public class PackageServer {


  public enum PackageServerType {
    FHIR,
    NPM
  }

  public PackageServer(String url) {
    this.url = url;
    authenticationMode = SimpleHTTPClient.AuthenticationMode.NONE;
    serverType = PackageServerType.FHIR;
  }

  private String url;

  @Getter
  private  SimpleHTTPClient.AuthenticationMode authenticationMode;

  @Getter
  private PackageServerType serverType;

  @Getter
  private String username;

  @Getter
  private String password;

  @Getter
  private String token;
  public String getUrl() {
    return url;
  }

  public static final String PRIMARY_SERVER = "https://packages.fhir.org";
  public static final String SECONDARY_SERVER = "https://packages2.fhir.org/packages";

  public static PackageServer primaryServer() {
    return new PackageServer(PRIMARY_SERVER);
  }

  public static PackageServer secondaryServer() {
    return new PackageServer(SECONDARY_SERVER);
  }
  
  public static List<PackageServer> defaultServers() {
    List<PackageServer> servers = new ArrayList<>();
    servers.add(primaryServer());
    servers.add(secondaryServer());
    return servers;
  }

  public static PackageServer getPackageServerFromPOJO(PackageServerPOJO pojo) {
    return new PackageServer(pojo.getUrl())
      .withAuthenticationMode(getModeFromPOJO(pojo))
      .withServerType(
        pojo.getServerType() != null && pojo.getServerType().equalsIgnoreCase("npm") ? PackageServerType.NPM : PackageServerType.FHIR
      )
      .withUsername(pojo.getUsername())
      .withPassword(pojo.getPassword())
      .withToken(pojo.getToken());
  }

  @Nullable
  private static SimpleHTTPClient.AuthenticationMode getModeFromPOJO(PackageServerPOJO pojo) {
    if (pojo.getAuthenticationType().equalsIgnoreCase("basic")) return  SimpleHTTPClient.AuthenticationMode.BASIC;
    if (pojo.getAuthenticationType().equalsIgnoreCase("token")) return  SimpleHTTPClient.AuthenticationMode.TOKEN;
    return null;
  }

  public static List<PackageServer> getConfiguredServers() {
    return FhirSettings.getPackageServers().stream().map(
      PackageServer::getPackageServerFromPOJO
    ).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return url;
  }

  public PackageServer copy() {
    PackageServer packageServer = new PackageServer(url);
    packageServer.authenticationMode = this.authenticationMode;
    packageServer.serverType = this.serverType;
    packageServer.username = this.username;
    packageServer.password = this.password;
    packageServer.token = this.token;
    return packageServer;
  }

  public PackageServer withAuthenticationMode( SimpleHTTPClient.AuthenticationMode mode) {
    PackageServer packageServer = this.copy();
    packageServer.authenticationMode = mode;
    return packageServer;
  }

  public PackageServer withServerType(PackageServerType serverType) {
    PackageServer packageServer = this.copy();
    packageServer.serverType = serverType;
    return packageServer;
  }

  public PackageServer withPassword(String password) {
    PackageServer packageServer = this.copy();
    packageServer.password = password;
    return packageServer;
  }

  public PackageServer withUsername(String username) {
    PackageServer packageServer = this.copy();
    packageServer.username = username;
    return packageServer;
  }

  public PackageServer withToken(String token) {
    PackageServer packageServer = this.copy();
    packageServer.token = token;
    return packageServer;
  }
}