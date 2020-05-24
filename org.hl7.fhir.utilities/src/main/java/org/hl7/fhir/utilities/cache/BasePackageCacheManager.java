package org.hl7.fhir.utilities.cache;

import org.apache.commons.lang3.Validate;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePackageCacheManager implements IPackageCacheManager {

  private List<String> myPackageServers = new ArrayList<>();

  /**
   * Constructor
   */
  public BasePackageCacheManager() {
    super();
  }

  public List<String> getPackageServers() {
    return myPackageServers;
  }

  /**
   * Add a package server that can be used to fetch remote packages
   */
  public void addPackageServer(@Nonnull String thePackageServer) {
    Validate.notBlank(thePackageServer, "thePackageServer must not be null or empty");
    if (!myPackageServers.contains(thePackageServer)) {
      myPackageServers.add(thePackageServer);
    }
  }


  /**
   * Load the latest version of the identified package from the cache - it it exists
   *
   * @param id
   * @return
   * @throws IOException
   */
  public NpmPackage loadPackageFromCacheOnly(String id) throws IOException {
    return loadPackageFromCacheOnly(id, null);
  }

  protected abstract NpmPackage loadPackageFromCacheOnly(String id, String version) throws IOException;

  @Override
  public String getPackageUrl(String packageId) throws IOException {
    String result = null;
    NpmPackage npm = loadPackageFromCacheOnly(packageId);
    if (npm != null) {
      return npm.canonical();
    }

    for (String nextPackageServer : getPackageServers()) {
      result = getPackageUrl(packageId, nextPackageServer);
      if (result != null) {
        return result;
      }
    }

    return result;
  }


  private String getPackageUrl(String packageId, String server) throws IOException {
    PackageClient pc = new PackageClient(server);
    List<PackageClient.PackageInfo> res = pc.search(packageId, null, null, false);
    if (res.size() == 0) {
      return null;
    } else {
      return res.get(0).getUrl();
    }
  }


  @Override
  public String getPackageId(String canonicalUrl) throws IOException {
    String result = null;

    for (String nextPackageServer : getPackageServers()) {
      result = getPackageId(canonicalUrl, nextPackageServer);
      if (result != null) {
        break;
      }
    }

    return result;
  }

  private String getPackageId(String canonical, String server) throws IOException {
    PackageClient pc = new PackageClient(server);
    List<PackageClient.PackageInfo> res = pc.search(null, canonical, null, false);
    if (res.size() == 0) {
      return null;
    } else {
      // this is driven by HL7 Australia (http://hl7.org.au/fhir/ is the canonical url for the base package, and the root for all the others)
      for (PackageClient.PackageInfo pi : res) {
        if (canonical.equals(pi.getCanonical())) {
          return pi.getId();
        }
      }
      return res.get(0).getId();
    }
  }


}
