package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.Utilities;

public class PackageInfo {
  private final String id;
  private final String version;
  private final String fhirVersion;
  private final String description;
  private final String url;
  private final String canonical;

  public PackageInfo(String id, String version, String fhirVersion, String description, String url, String canonical) {
    this(id, version, fhirVersion, description, url, canonical, null);
  }

  public PackageInfo(String id, String version, String fhirVersion, String description, String url, String canonical, String address) {
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

  @Override
  public String toString() {
    return id + "#" + (version == null ? "?pc-pi?" : version) + (fhirVersion == null ? "" : " (" + canonical + ") for FHIR " + fhirVersion) + (url == null ? "" : " @" + url) + (description == null ? "" : " '" + description + "'");
  }
}
