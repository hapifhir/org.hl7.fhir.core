package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

@Slf4j
public abstract class BasePackageCacheManager implements IPackageCacheManager {

  protected final List<PackageServer> myPackageServers;
  private Function<PackageServer, PackageClient> myClientFactory = server -> new PackageClient(server);

  /**
   * Constructor
   */
  public BasePackageCacheManager() {
    super();
    myPackageServers = new ArrayList<>();
  }

  protected BasePackageCacheManager(@Nonnull List<PackageServer> thePackageServers) {
    myPackageServers = thePackageServers;
  }
  /**
   * Provide a new client factory implementation
   */
  public void setClientFactory(Function<PackageServer, PackageClient> theClientFactory) {
    Validate.notNull(theClientFactory, "theClientFactory must not be null");
    myClientFactory = theClientFactory;
  }

  public List<PackageServer> getPackageServers() {
    return myPackageServers;
  }

  /**
   * Add a package server that can be used to fetch remote packages
   */
  public void addPackageServer(@Nonnull PackageServer thePackageServer) {
    Validate.notNull(thePackageServer, "thePackageServer must not be null or empty");
    if (!myPackageServers.contains(thePackageServer)) {
      myPackageServers.add(thePackageServer);
    }
  }


  /**
   * Load the latest version of the identified package from the cache - it it exists
   */
  public NpmPackage loadPackageFromCacheOnly(String id) throws IOException {
    return loadPackageFromCacheOnly(id, null);
  }

  /**
   * Try to load a package from all registered package servers, and return <code>null</code>
   * if it can not be found at any of them.
   */
  @Nullable
  protected InputStreamWithSrc loadFromPackageServer(String id, String version) {

    for (PackageServer nextPackageServer : getPackageServers()) {
      if (okToUsePackageServer(nextPackageServer.getUrl(), id)) {
        PackageClient packageClient = myClientFactory.apply(nextPackageServer);
        try {
          if (Utilities.noString(version)) {
            version = packageClient.getLatestVersion(id, false);
          }
          if (VersionUtilities.versionHasWildcards(version)) {
            version = packageClient.getLatestVersion(id, version);
            if (version == null) {
              return null;
            }
          }

          InputStream stream = packageClient.fetch(id, version);
          String url = packageClient.url(id, version);
          return new InputStreamWithSrc(stream, url, version);
        } catch (IOException e) {
          log.debug("Failed to resolve package {}#{} from server: {} ({})", id, version, nextPackageServer, e.getMessage());
        }
      }
    }

    return null;
  }

  // hack - we have a hacked 1.4.0 out there. Only packages2.fhir.org has it.
  // this is not a long term thing, but it's not clear how to release patches for 
  // 1.4.0
  private boolean okToUsePackageServer(String server, String id) {
    if (PackageServer.PRIMARY_SERVER.equals(server) && "hl7.fhir.r2b.core".equals(id)) {
      return false;
    }
    return true;
  }

  public abstract NpmPackage loadPackageFromCacheOnly(String id, @Nullable String version) throws IOException;

  @Override
  public String getPackageUrl(String packageId) throws IOException {
    packageId = stripAlias(packageId);
    String result = null;
    NpmPackage npm = loadPackageFromCacheOnly(packageId);
    if (npm != null) {
      return npm.canonical();
    }

    for (PackageServer nextPackageServer : getPackageServers()) {
      result = getPackageUrl(packageId, nextPackageServer);
      if (result != null) {
        return result;
      }
    }

    return result;
  }


  private String getPackageUrl(String packageId, PackageServer server) throws IOException {
    PackageClient pc = myClientFactory.apply(server);
    List<PackageInfo> res = pc.search(packageId, null, null, false, null);
    if (res.size() == 0) {
      return null;
    } else {
      return res.get(0).getUrl();
    }
  }


  @Override
  public String getPackageId(String canonicalUrl) throws IOException {
    String result = null;

    for (PackageServer nextPackageServer : getPackageServers()) {
      result = getPackageId(canonicalUrl, nextPackageServer);
      if (result != null) {
        break;
      }
    }

    return result;
  }

  private String getPackageId(String canonical, PackageServer server) throws IOException {
    if (canonical == null) {
      return null;
    }
    PackageClient pc = myClientFactory.apply(server);
    List<PackageInfo> res = pc.search(null, canonical, null, false, null);
    if (res.size() == 0) {
      return null;
    } else {
      // this is driven by HL7 Australia (http://hl7.org.au/fhir/ is the canonical url for the base package, and the root for all the others)
      for (PackageInfo pi : res) {
        if (canonical.equals(pi.getCanonical())) {
          return pi.getId();
        }
      }
      return res.get(0).getId();
    }
  }

  public static class InputStreamWithSrc {

    public InputStream stream;
    public String url;
    public String version;

    public InputStreamWithSrc(InputStream stream, String url, String version) {
      this.stream = stream;
      this.url = url;
      this.version = version;
    }
  }

  @Override
  public NpmPackage loadPackage(String idAndVer) throws FHIRException, IOException {
    idAndVer = stripAlias(idAndVer);
    return loadPackage(idAndVer, null);
  }


  /**
   * The NPM Alias format is:
   *   npm install <alias>@npm:<name>:
   *   
   * (see https://docs.npmjs.com/cli/v8/commands/npm-install)
   * 
   * We're using that format to allow us to use more than one version of the same package in packages.json,
   * but what the prefix actually is is irrelevant here - we just load the actual package the user 
   * is interested in
   * 
   * Corollary: you will get a different package name than you asked for when using aliases
   * 
   * @param id
   * @return
   */
  protected String stripAlias(String id) {
    if (id != null && id.contains("@npm:")) {
      return id.substring(id.indexOf("@npm:")+5);
    } else {
      return id;
    }
  }
}
