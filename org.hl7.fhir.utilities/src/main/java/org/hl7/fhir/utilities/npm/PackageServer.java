package org.hl7.fhir.utilities.npm;

import java.util.ArrayList;
import java.util.List;

public class PackageServer {

  public enum PackageServerAuthenticationMode {
    NONE
  }
  
  public PackageServer(String url) {
    this.url = url;
    mode = PackageServerAuthenticationMode.NONE;
  }
  private String url;
  private PackageServerAuthenticationMode mode;
  private String username;
  private String password;
  public String getUrl() {
    return url;
  }
  public PackageServerAuthenticationMode getMode() {
    return mode;
  }
  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
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
 
}