package org.hl7.fhir.utilities.npm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.hl7.fhir.utilities.http.HTTPAuthenticationMode;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import lombok.Getter;

public class PackageServer {


  public enum PackageServerType {
    FHIR,
    NPM
  }

  public PackageServer(String url) {
    this.url = url;
    authenticationMode = HTTPAuthenticationMode.NONE;
    serverType = PackageServerType.FHIR;
  }

  @Getter
  private String url;

  @Getter
  private HTTPAuthenticationMode authenticationMode;

  @Getter
  private PackageServerType serverType;

  @Getter
  private String username;

  @Getter
  private String password;

  @Getter
  private String token;

  @Getter
  private String apiKey;



  public static final String SECONDARY_SERVER = "https://packages.fhir.org";
  //public static final String PRIMARY_SERVER = "https://packages2.fhir.org/packages";
  public static final String PRIMARY_SERVER = "https://fs.get-ig.org/pkgs";

  public static PackageServer primaryServer() {
    return new PackageServer(PRIMARY_SERVER).withServerType(PackageServerType.NPM);
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

  public static PackageServer getPackageServerFromPOJO(ServerDetailsPOJO pojo) {
    return new PackageServer(pojo.getUrl())
      .withAuthenticationMode(getModeFromPOJO(pojo))
      .withServerType(
        getPackageServerType(pojo.getType())
      )
      .withUsername(pojo.getUsername())
      .withPassword(pojo.getPassword())
      .withToken(pojo.getToken())
      .withApiKey(pojo.getApikey());

  }

  private static boolean isPackageServer(String serverType) {
    if (serverType == null) {
      return false;
    }
    if (serverType.equals("fhir-package")) {
      return true;
    }
    if (serverType.equals("npm-package")) {
      return true;
    }
    return false;
  }

  private static PackageServerType getPackageServerType(String serverType) {
    if (serverType == null) {
      return null;
    }
    if (serverType.equals("fhir-package")) {
      return PackageServerType.FHIR;
    }
    if (serverType.equals("npm-package")) {
      return PackageServerType.NPM;
    }
    return null;
  }

  @Nullable
  private static HTTPAuthenticationMode getModeFromPOJO(ServerDetailsPOJO pojo) {
    if (pojo.getAuthenticationType().equalsIgnoreCase("basic")) return HTTPAuthenticationMode.BASIC;
    if (pojo.getAuthenticationType().equalsIgnoreCase("token")) return HTTPAuthenticationMode.TOKEN;
    if (pojo.getAuthenticationType().equalsIgnoreCase("apikey")) return HTTPAuthenticationMode.APIKEY;
    return null;
  }

  public static List<PackageServer> getConfiguredServers() {
    return FhirSettings.getServers().stream()
      .filter(serverDetailsPOJO -> isPackageServer(serverDetailsPOJO.getType()))
      .map(PackageServer::getPackageServerFromPOJO)
      .collect(Collectors.toList());
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
    packageServer.apiKey = this.apiKey;
    return packageServer;
  }

  public PackageServer withAuthenticationMode(HTTPAuthenticationMode mode) {
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

  public PackageServer withApiKey(String apiKey) {
    PackageServer packageServer = this.copy();
    packageServer.apiKey = apiKey;
    return packageServer;
  }
}