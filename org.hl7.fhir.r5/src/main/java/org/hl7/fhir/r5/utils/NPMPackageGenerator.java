package org.hl7.fhir.r5.utils;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonString;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;
import org.hl7.fhir.utilities.npm.ToolsVersion;

public class NPMPackageGenerator {

  public enum Category {
    RESOURCE, EXAMPLE, OPENAPI, SCHEMATRON, RDF, OTHER, TOOL, TEMPLATE, JEKYLL;

    private String getDirectory() {
      switch (this) {
      case RESOURCE: return "package/";
      case EXAMPLE: return "package/example/";
      case OPENAPI: return "package/openapi/";
      case SCHEMATRON: return "package/xml/";
      case RDF: return "package/rdf/";      
      case OTHER: return "package/other/";      
      case TEMPLATE: return "package/other/";      
      case JEKYLL: return "package/jekyll/";      
      case TOOL: return "package/bin/";      
      }
      return "/";
    }
  }

  private String destFile;
  private Set<String> created = new HashSet<String>();
  private TarArchiveOutputStream tar;
  private ByteArrayOutputStream OutputStream;
  private BufferedOutputStream bufferedOutputStream;
  private GzipCompressorOutputStream gzipOutputStream;
  private JsonObject packageJ;
  private JsonObject packageManifest;
  private NpmPackageIndexBuilder indexer;
  private String igVersion;
  private String indexdb;


  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, Date date, boolean notForPublication) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    List<String> fhirVersion = new ArrayList<>();
    for (Enumeration<FHIRVersion> v : ig.getFhirVersion())
      fhirVersion.add(v.asStringValue());
    buildPackageJson(canonical, kind, url, date, ig, fhirVersion, notForPublication);
  }

  public static NPMPackageGenerator subset(NPMPackageGenerator master, String destFile, String id, String name, Date date, boolean notForPublication) throws FHIRException, IOException {
    JsonObject p = master.packageJ.deepCopy();
    p.remove("name");
    p.add("name", id);
    p.remove("type");
    p.add("type", PackageType.CONFORMANCE.getCode());    
    p.remove("title");
    p.add("title", name);
    if (notForPublication) {
      p.add("notForPublication", true);
    }

    return new NPMPackageGenerator(destFile, p, date, notForPublication);
  }

  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, Date date, List<String> fhirVersion, boolean notForPublication) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    buildPackageJson(canonical, kind, url, date, ig, fhirVersion, notForPublication);
  }

  public NPMPackageGenerator(String destFile, JsonObject npm, Date date, boolean notForPublication) throws FHIRException, IOException {
    super();
    String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    packageJ = npm;
    packageManifest = new JsonObject();
    packageManifest.set("version", npm.asString("version"));
    packageManifest.set("date", dt);
    if (notForPublication) {
      packageManifest.add("notForPublication", true);
    }
    npm.set("date", dt);
    packageManifest.set("name", npm.asString("name"));
    this.destFile = destFile;
    start();
    String json = JsonParser.compose(npm, true);
    try {
      addFile(Category.RESOURCE, "package.json", json.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
    }
  }

  private void buildPackageJson(String canonical, PackageType kind, String web, Date date, ImplementationGuide ig, List<String> fhirVersion, boolean notForPublication) throws FHIRException, IOException {
    String dtHuman = new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(date);
    String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (!ig.hasPackageId()) {
      b.append("packageId");
    }
    if (!ig.hasVersion()) {
      b.append("version");
    }
    if (!ig.hasFhirVersion()) {
      b.append("fhirVersion");
    }
    if (!ig.hasLicense()) {
      b.append("license");
    }
    for (ImplementationGuideDependsOnComponent d : ig.getDependsOn()) {
      if (!d.hasVersion()) {
        b.append("dependsOn.version("+d.getUri()+")");
      }
    }

    JsonObject npm = new JsonObject();
    npm.add("name", ig.getPackageId());
    npm.add("version", ig.getVersion());
    igVersion = ig.getVersion();
    npm.add("tools-version", ToolsVersion.TOOLS_VERSION);
    npm.add("type", kind.getCode());
    npm.add("date", dt);
    if (ig.hasLicense()) {
      npm.add("license", ig.getLicense().toCode());
    }
    npm.add("canonical", canonical);
    if (notForPublication) {
      npm.add("notForPublication", true);
    }
    npm.add("url", web);
    if (ig.hasTitle()) {
      npm.add("title", ig.getTitle());
    }
    if (ig.hasDescription()) {
      npm.add("description", ig.getDescription()+ " (built "+dtHuman+timezone()+")");
    }
    JsonArray vl = new JsonArray();
    
    npm.add("fhirVersions", vl);
    for (String v : fhirVersion) { 
      vl.add(new JsonString(v));
    }
    
    if (kind != PackageType.CORE) {
      JsonObject dep = new JsonObject();
      npm.add("dependencies", dep);
      for (String v : fhirVersion) { 
        String vp = packageForVersion(v);
        if (vp != null ) {
          dep.add(vp, v);
        }
      }
      for (ImplementationGuideDependsOnComponent d : ig.getDependsOn()) {
        dep.add(d.getPackageId(), d.getVersion());
      }
    }
    if (ig.hasPublisher()) {
      npm.add("author", ig.getPublisher());
    }
    JsonArray m = new JsonArray();
    for (ContactDetail t : ig.getContact()) {
      String email = email(t.getTelecom());
      String url = url(t.getTelecom());
      if (t.hasName() & (email != null || url != null)) {
        JsonObject md = new JsonObject();
        m.add(md);
        md.add("name", t.getName());
        if (email != null)
          md.add("email", email);
        if (url != null)
          md.add("url", url);
      }
    }
    if (m.size() > 0)
      npm.add("maintainers", m);
    if (ig.getManifest().hasRendering())
      npm.add("homepage", ig.getManifest().getRendering());
    JsonObject dir = new JsonObject();
    npm.add("directories", dir);
    dir.add("lib", "package");
    dir.add("example", "example");
    String json = JsonParser.compose(npm, true);
    try {
      addFile(Category.RESOURCE, "package.json", json.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
    }
    packageJ = npm;

    packageManifest = new JsonObject();
    packageManifest.add("version", ig.getVersion());
    JsonArray fv = new JsonArray();
    for (String v : fhirVersion) {
      fv.add(v);
    }
    packageManifest.add("fhirVersion", fv);
    packageManifest.add("date", dt);
    packageManifest.add("name", ig.getPackageId());

  }


  private String packageForVersion(String v) {
    if (v == null)
      return null;
    if (v.startsWith("1.0"))
      return "hl7.fhir.r2.core";
    if (v.startsWith("1.4"))
      return "hl7.fhir.r2b.core";
    if (v.startsWith("3.0"))
      return "hl7.fhir.r3.core";
    if (v.startsWith("4.0"))
      return "hl7.fhir.r4.core";
    if (v.startsWith("4.1") || v.startsWith("4.3"))
      return "hl7.fhir.r4b.core";
    return null;
  }

  private String timezone() {
    TimeZone tz = TimeZone.getDefault();  
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
    offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

    return offset;
  }


  private String url(List<ContactPoint> telecom) {
    for (ContactPoint cp : telecom) {
      if (cp.getSystem() == ContactPointSystem.URL)
        return cp.getValue();
    }
    return null;
  }


  private String email(List<ContactPoint> telecom) {
    for (ContactPoint cp : telecom) {
      if (cp.getSystem() == ContactPointSystem.EMAIL)
        return cp.getValue();
    }
    return null;
  }

  private void start() throws IOException {
    OutputStream = new ByteArrayOutputStream();
    bufferedOutputStream = new BufferedOutputStream(OutputStream);
    gzipOutputStream = new GzipCompressorOutputStream(bufferedOutputStream);
    tar = new TarArchiveOutputStream(gzipOutputStream);
    indexdb = Utilities.path("[tmp]", "tmp-"+UUID.randomUUID().toString()+".db");
    indexer = new NpmPackageIndexBuilder();
    indexer.start(indexdb);
  }


  public void addFile(Category cat, String name, byte[] content) throws IOException {
    String path = cat.getDirectory()+name;
    if (path.length() > 100) {
      name = name.substring(0, name.indexOf("-"))+"-"+UUID.randomUUID().toString()+".json";
      path = cat.getDirectory()+name;      
    }
      
    if (created.contains(path)) {
      System.out.println("Duplicate package file "+path);
    } else {
      created.add(path);
      TarArchiveEntry entry = new TarArchiveEntry(path);
      entry.setSize(content.length);
      tar.putArchiveEntry(entry);
      tar.write(content);
      tar.closeArchiveEntry();
      if(cat == Category.RESOURCE) {
        indexer.seeFile(name, content);
      }
    }
  }

  public void addFile(String folder, String name, byte[] content) throws IOException {
    if (!folder.equals("package")) {
      folder = "package/"+folder;
    }
    String path = folder+"/"+name;
    if (path.length() > 100) {
      name = name.substring(0, name.indexOf("-"))+"-"+UUID.randomUUID().toString()+".json";
      path = folder+"/"+name;      
    }
      
    if (created.contains(path)) {
      System.out.println("Duplicate package file "+path);
    } else {
      created.add(path);
      TarArchiveEntry entry = new TarArchiveEntry(path);
      entry.setSize(content.length);
      tar.putArchiveEntry(entry);
      tar.write(content);
      tar.closeArchiveEntry();
      if(folder == "package") {
        indexer.seeFile(name, content);
      }
    }
  }

  public void finish() throws IOException {
    buildIndexJson();
    tar.finish();
    tar.close();
    gzipOutputStream.close();
    bufferedOutputStream.close();
    OutputStream.close();
    TextFile.bytesToFile(OutputStream.toByteArray(), destFile);
    // also, for cache management on current builds, generate a little manifest
    String json = JsonParser.compose(packageManifest, true);
    TextFile.stringToFile(json, Utilities.changeFileExt(destFile, ".manifest.json"), false);
  }

  private void buildIndexJson() throws IOException {
    byte[] content = TextFile.stringToBytes(indexer.build(), false);
    addFile(Category.RESOURCE, ".index.json", content); 
    content = TextFile.fileToBytes(indexdb);
    new File(indexdb).delete();
    addFile(Category.RESOURCE, ".index.db", content); 
  }

  public String filename() {
    return destFile;
  }

  public void loadDir(String rootDir, String name) throws IOException {
    loadFiles(rootDir, new File(Utilities.path(rootDir, name)));
  }

  public void loadFiles(String root, File dir, String... noload) throws IOException {
    for (File f : dir.listFiles()) {
      if (!Utilities.existsInList(f.getName(), noload)) {
        if (f.isDirectory()) {
          loadFiles(root, f);
        } else {
          String path = f.getAbsolutePath().substring(root.length()+1);
          byte[] content = TextFile.fileToBytes(f);
          if (created.contains(path)) 
            System.out.println("Duplicate package file "+path);
          else {
            created.add(path);
            TarArchiveEntry entry = new TarArchiveEntry(path);
            entry.setSize(content.length);
            tar.putArchiveEntry(entry);
            tar.write(content);
            tar.closeArchiveEntry();
          }
        }
      }
    }
  }

  public String version() {
    return igVersion;
  }


}