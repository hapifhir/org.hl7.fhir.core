package org.hl7.fhir.utilities.npm;

import java.time.Instant;
import java.util.Comparator;

import org.hl7.fhir.utilities.Utilities;

public class PackageInfo {
  private final String id;
  private final String version;
  private final String fhirVersion;
  private final String description;
  private final String url;
  private final String canonical;
  private Instant date;

  public PackageInfo(String id, String version, String fhirVersion, String description, String url, String canonical, Instant date) {
    this(id, version, fhirVersion, description, url, canonical, null, date);
  }

  public PackageInfo(String id, String version, String fhirVersion, String description, String url, String canonical, String address, Instant date) {
    super();
    this.id = id;
    this.version = version;
    this.fhirVersion = fhirVersion;
    this.description = description;
    if (url == null && id != null && version != null) {
      this.url = Utilities.pathURL(address, id, version);
    } else {
      this.url = url;
    }
    this.canonical = canonical;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public String getVersion() {
    return version;
  }

  public String getFhirVersion() {
    return fhirVersion;
  }

  public String getDescription() {
    return description;
  }

  public String getUrl() {
    return url;
  }

  public String getCanonical() {
    return canonical;
  }

  public Instant getDate() {
    return date;
  }

  @Override
  public String toString() {
    return id + "#" + (version == null ? "?pc-pi?" : version) + (fhirVersion == null ? "" : " (" + canonical + ") for FHIR " + fhirVersion) + (url == null ? "" : " @" + url) + (description == null ? "" : " '" + description + "'");
  }
  
  public static class PackageInfoSorter implements Comparator<PackageInfo> {


    private boolean byDate;

    public PackageInfoSorter(boolean byDate) {
      super();
      this.byDate = byDate;
    }

    @Override
    public int compare(PackageInfo o1, PackageInfo o2) {
      if (byDate) {
        return o1.date.compareTo(o2.date);
      } else {
        return o1.id.compareTo(o2.id);
      }
    }

  }
  
}
