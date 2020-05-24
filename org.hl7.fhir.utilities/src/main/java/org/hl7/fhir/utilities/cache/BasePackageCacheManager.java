package org.hl7.fhir.utilities.cache;

import org.apache.commons.lang3.Validate;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePackageCacheManager implements IPackageCacheManager {

  private List<String> myPackageServers = new ArrayList<>();

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


  @Override
  public String getPackageId(String canonical) throws IOException {
    String result = null;

    for (String nextPackageServer : getPackageServers()) {
      result = getPackageId(canonical, nextPackageServer);
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
