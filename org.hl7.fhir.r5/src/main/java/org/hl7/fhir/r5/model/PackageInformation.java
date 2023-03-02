package org.hl7.fhir.r5.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.utilities.npm.NpmPackage;

public class PackageInformation {
  private String id;
  private String version;
  private Date date;

  private String name;
  private String canonical;
  private String web;

  private List<String> dependencies = new ArrayList<>();

  public PackageInformation(String id, String version, Date date, String name, String canonical, String web) {
    super();
    this.id = id;
    this.version = version;
    this.date = date;
    this.name = name;
    this.canonical = canonical;
    this.web = web;
  }

  public PackageInformation(String src, Date date) {
    super();
    this.id = src;
    this.date = date;
  }

  public PackageInformation(NpmPackage pi) {
    super();
    this.id = pi.name();
    this.version = pi.version();
    this.date = pi.dateAsDate();
    this.name = pi.title();
    this.canonical = pi.canonical();
    this.web = pi.getWebLocation();
    dependencies.addAll(pi.dependencies());
  }

  public PackageInformation(String id, String version, Date date) {
    super();
    this.id = id;
    this.version = version;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public String getVersion() {
    return version;
  }

  public Date getDate() {
    return date;
  }

  public String getName() {
    return name;
  }

  public String getCanonical() {
    return canonical;
  }

  public String getWeb() {
    return web;
  }

  public List<String> getDependencies() {
    return dependencies;
  }

  public boolean isExamplesPackage() {
    boolean b = id.startsWith("hl7.fhir.") && id.endsWith(".examples");
    return b;
  }

  public boolean isHTO() {
    boolean b = id.startsWith("hl7.terminology.r");
    return b;
  }

  public String getVID() {
    return id+"#"+version;
  }

  public String toString() {
    return getVID();
  }
}
