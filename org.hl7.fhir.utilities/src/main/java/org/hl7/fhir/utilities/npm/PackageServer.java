package org.hl7.fhir.utilities.npm;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hl7.fhir.utilities.settings.FhirSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PackageServer {

  public enum PackageServerAuthenticationMode {
    NONE,
    BASIC
  }
  
  public PackageServer(String url) {
    this.url = url;
    mode = PackageServerAuthenticationMode.NONE;
  }

  private String url;

  @Getter
  private PackageServerAuthenticationMode mode;

  @Getter
  private String username;

  @Getter
  private String password;
  public String getUrl() {
    return url;
  }

  public static final String PRIMARY_SERVER = "http://packages.fhir.org";
  public static final String SECONDARY_SERVER = "https://packages2.fhir.org/packages";

  public static PackageServer primaryServer() {
    return new PackageServer(PRIMARY_SERVER);
  }

  public static PackageServer secondaryServer() {
    return new PackageServer(SECONDARY_SERVER);
  }
  
  public static List<PackageServer> publicServers() {
    List<PackageServer> servers = new ArrayList<>();
    servers.add(primaryServer());
    servers.add(secondaryServer());
    return servers;
  }

  public static List<PackageServer> getConfiguredServers() {
    return FhirSettings.getPackageServers().stream().map(
      pojo ->
        new PackageServer(pojo.getUrl())
          .withMode(pojo.getAuthenticationType() != null && pojo.getAuthenticationType().equalsIgnoreCase("basic") ?
            PackageServer.PackageServerAuthenticationMode.BASIC : null)
          .withUsername(pojo.getUsername())
          .withPassword(pojo.getPassword())
    ).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return url;
  }

  public PackageServer copy() {
    PackageServer packageServer = new PackageServer(url);
    packageServer.mode = this.mode;
    packageServer.username = this.username;
    packageServer.password = this.password;
    return packageServer;
  }

  public PackageServer withMode(PackageServerAuthenticationMode mode) {
    PackageServer packageServer = this.copy();
    packageServer.mode = mode;
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
}