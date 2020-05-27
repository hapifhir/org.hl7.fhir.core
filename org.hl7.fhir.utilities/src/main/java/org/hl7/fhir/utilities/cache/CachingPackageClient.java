package org.hl7.fhir.utilities.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JSONUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Implementation of a package client that keeps a local disk cache of downloaded artifacts
 * in order to avoid re-downloading things
 */
public class CachingPackageClient extends BasePackageClient {

  private String cacheFolder;


  public CachingPackageClient(String address) {
    super(address);
    try {
      cacheFolder = Utilities.path(System.getProperty("user.home"), ".fhir", "package-client");
      Utilities.createDirectory(cacheFolder);
    } catch (IOException e) {
    }
  }

  public boolean exists(String id, String ver) throws IOException {
    List<PackageInfo> vl = getVersions(id);
    for (PackageInfo pi : vl) {
      if (ver.equals(pi.getVersion())) {
        return true;
      }
    }
    return false;
  }

  public InputStream fetchCached(String url) throws IOException {
    File cacheFile = new File(Utilities.path(cacheFolder, fn(url)));
    if (cacheFile.exists()) {
      return new FileInputStream(cacheFile);
    }
    InputStream fetchedPackage = super.fetchCached(url);
    TextFile.bytesToFile(TextFile.streamToBytes(fetchedPackage), cacheFile);
    return new FileInputStream(cacheFile);
  }


  public Date getNewPackages(Date lastCalled, List<PackageInfo> updates) {
    return null;
  }



}