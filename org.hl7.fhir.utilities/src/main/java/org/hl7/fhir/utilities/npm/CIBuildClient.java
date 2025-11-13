package org.hl7.fhir.utilities.npm;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class CIBuildClient {

  private static final String DEFAULT_ROOT_URL = "https://build.fhir.org";
  private static final long DEFAULT_CI_QUERY_INTERVAL = 1000 * 60 * 60;
  private final long ciQueryInterval;

  @Getter
  private long ciLastQueriedTimeStamp = 0;

  @Getter
  private JsonArray ciBuildInfo;

  @Getter
  private final String rootUrl;

  /**
   * key = packageId
   * value = url of built package on https://build.fhir.org/ig/
   **/
  private final Map<String, String> ciPackageUrls = new HashMap<>();

  public CIBuildClient() {
   this(DEFAULT_ROOT_URL, DEFAULT_CI_QUERY_INTERVAL, false);
  }

  public CIBuildClient(String rootUrl, long ciQueryInterval, boolean silent) {
    this.rootUrl = rootUrl;
    this.ciQueryInterval = ciQueryInterval;
  }

  String getPackageId(String canonical) {
    if (canonical == null) {
      return null;
    }
    checkCIServerQueried();
    if (ciBuildInfo != null) {
      for (JsonElement n : ciBuildInfo) {
        JsonObject o = (JsonObject) n;
        if (canonical.equals(o.asString("url"))) {
          return o.asString("package-id");
        }
      }
      for (JsonElement n : ciBuildInfo) {
        JsonObject o = (JsonObject) n;
        if (o.asString("url").startsWith(canonical + "/ImplementationGuide/")) {
          return o.asString("package-id");
        }
      }
    }
    return null;
  }

  String getPackageUrl(String packageId) {
    checkCIServerQueried();
    for (JsonObject o : ciBuildInfo.asJsonObjects()) {
      if (packageId.equals(o.asString("package-id"))) {
        return o.asString("url");
      }
    }
    return null;
  }

  public boolean isCurrent(String id, NpmPackage npmPackage) throws IOException {
    checkCIServerQueried();
    String packageManifestUrl = ciPackageUrls.get(id);
    JsonObject packageManifestJson = JsonParser.parseObjectFromUrl(Utilities.pathURL(packageManifestUrl, "package.manifest.json"));
    String currentDate = packageManifestJson.asString("date");
    String packageDate = npmPackage.date();
    return currentDate.equals(packageDate); // nup, we need a new copy
  }

  BasePackageCacheManager.InputStreamWithSrc loadFromCIBuild(String id, String branch) {
    checkCIServerQueried();

    if (ciPackageUrls.containsKey(id)) {
      String packageBaseUrl = ciPackageUrls.get(id);
      if (branch == null) {
        InputStream stream;
        try {
          stream = fetchFromUrlSpecific(Utilities.pathURL(packageBaseUrl, "package.tgz"));
        } catch (Exception e) {
          stream = fetchFromUrlSpecific(Utilities.pathURL(packageBaseUrl, "branches", "main", "package.tgz"));
        }
        return new BasePackageCacheManager.InputStreamWithSrc(stream, Utilities.pathURL(packageBaseUrl, "package.tgz"), "current");
      } else {
        InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(packageBaseUrl, "branches", branch, "package.tgz"));
        return new BasePackageCacheManager.InputStreamWithSrc(stream, Utilities.pathURL(packageBaseUrl, "branches", branch, "package.tgz"), "current$" + branch);
      }
    } else if (id.startsWith("hl7.fhir.r6")) {
      InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(rootUrl, id + ".tgz"));
      return new BasePackageCacheManager.InputStreamWithSrc(stream, Utilities.pathURL(rootUrl, id + ".tgz"), "current");
    } else if (Utilities.endsWithInList(id, ".r3", ".r4", ".r4b", ".r5", ".r6")) {
      String npid = id.substring(0, id.lastIndexOf("."));
      String url = ciPackageUrls.get(npid);
      if (url == null) {
        throw new FHIRException("The package '" + id + "' has no entry on the current build server (" + ciPackageUrls + ")");        
      } else {
        url = Utilities.pathURL(url, id+".tgz");
        InputStream stream = fetchFromUrlSpecific(url);
        return new BasePackageCacheManager.InputStreamWithSrc(stream, url, "current");
      }
    } else {
      throw new FHIRException("The package '" + id + "' has no entry on the current build server (" + ciPackageUrls + ")");
    }
  }

  private InputStream fetchFromUrlSpecific(String source) throws FHIRException {
    try {
      HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), source);
      res.checkThrowException();
      return new ByteArrayInputStream(res.getContent());
    } catch (Exception e) {
        throw new FHIRException("Unable to fetch: " + e.getMessage(), e);
    }
  }

  private void checkCIServerQueried() {
    if (System.currentTimeMillis() - ciLastQueriedTimeStamp > ciQueryInterval) {
      try {
        updateFromCIServer();
      } catch (Exception e) {
        try {
          // we always pause a second and try again - the most common reason to be here is that the file was being changed on the server
          Thread.sleep(1000);
          updateFromCIServer();
        } catch (Exception e2) {
          log.debug("Error connecting to build server - running without build (" + e2.getMessage() + ")");
        }
      }
    }
  }

  private void updateFromCIServer() throws IOException {
    try {
      HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), rootUrl + "/ig/qas.json?nocache=" + System.currentTimeMillis());
      res.checkThrowException();

      ciBuildInfo = (JsonArray) JsonParser.parse(FileUtilities.bytesToString(res.getContent()));

      List<BuildRecord> builds = new ArrayList<>();

      for (JsonElement n : ciBuildInfo) {
        JsonObject j = (JsonObject) n;
        if (j.has("url") && j.has("package-id") && j.asString("package-id").contains(".")) {
          String packageUrl = j.asString("url");
          if (packageUrl.contains("/ImplementationGuide/"))
            packageUrl = packageUrl.substring(0, packageUrl.indexOf("/ImplementationGuide/"));
          builds.add(new BuildRecord(packageUrl, j.asString("package-id"), getRepo(j.asString("repo")), readDate(j.asString("date"))));
        }
      }
      Collections.sort(builds, new BuildRecordSorter());
      for (BuildRecord build : builds) {
        if (!ciPackageUrls.containsKey(build.getPackageId())) {
          ciPackageUrls.put(build.getPackageId(), rootUrl + "/ig/" + build.getRepo());
        }
      }
    } catch (IOException e) {
      ciLastQueriedTimeStamp = System.currentTimeMillis();
      throw e;
    } finally {
      ciLastQueriedTimeStamp = System.currentTimeMillis();
    }
  }

  private String getRepo(String path) {
    String[] p = path.split("/");
    return p[0] + "/" + p[1];
  }

  private Date readDate(String s) {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM, yyyy HH:mm:ss Z", new Locale("en", "US"));
    try {
      return sdf.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
      return new Date();
    }
  }

  public static class BuildRecord {

    private final String url;
    private final String packageId;
    private final String repo;
    private final Date date;

    public BuildRecord(String url, String packageId, String repo, Date date) {
      super();
      this.url = url;
      this.packageId = packageId;
      this.repo = repo;
      this.date = date;
    }

    public String getUrl() {
      return url;
    }

    public String getPackageId() {
      return packageId;
    }

    public String getRepo() {
      return repo;
    }

    public Date getDate() {
      return date;
    }

  }

  public static class BuildRecordSorter implements Comparator<BuildRecord> {

    @Override
    public int compare(BuildRecord arg0, BuildRecord arg1) {
      return arg1.date.compareTo(arg0.date);
    }
  }
}
