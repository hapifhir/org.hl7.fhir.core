package org.hl7.fhir.r4.utils;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4.model.ImplementationGuide;
import org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.PackageGenerator.PackageType;
import org.hl7.fhir.utilities.cache.ToolsVersion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class NPMPackageGenerator {

  public enum Category {
    RESOURCE, EXAMPLE, OPENAPI, SCHEMATRON, RDF, OTHER, TOOL, TEMPLATE, JEKYLL;
    
    private String getDirectory() {
      switch (this) {
      case RESOURCE: return "/package/";
      case EXAMPLE: return "/example/";
      case OPENAPI: return "/openapi/";
      case SCHEMATRON: return "/xml/";
      case RDF: return "/rdf/";      
      case OTHER: return "/other/";      
      case TEMPLATE: return "/other/";      
      case JEKYLL: return "/jekyll/";      
      case TOOL: return "/bin/";      
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
  
  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, String genDate) throws FHIRException, IOException {
    super();
    System.out.println("create package file at "+destFile);
    this.destFile = destFile;
    start();
    List<String> fhirVersion = new ArrayList<>();
    for (Enumeration<FHIRVersion> v : ig.getFhirVersion())
      fhirVersion.add(v.asStringValue());
    buildPackageJson(canonical, kind, url, genDate, ig, fhirVersion);
  }
  
  public static NPMPackageGenerator subset(NPMPackageGenerator master, String destFile, String id, String name) throws FHIRException, IOException {
    JsonObject p = master.packageJ.deepCopy();
    p.remove("name");
    p.addProperty("name", id);
    p.remove("type");
    p.addProperty("type", PackageType.SUBSET.getCode());    
    p.remove("title");
    p.addProperty("title", name);    
    return new NPMPackageGenerator(destFile, p);
  }
  
  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, String genDate, List<String> fhirVersion) throws FHIRException, IOException {
    super();
    System.out.println("create package file at "+destFile);
    this.destFile = destFile;
    start();
    buildPackageJson(canonical, kind, url, genDate, ig, fhirVersion);
  }
  
  public NPMPackageGenerator(String destFile, JsonObject npm) throws FHIRException, IOException {
    super();
    System.out.println("create package file at "+destFile);
    this.destFile = destFile;
    start();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(npm);
    try {
      addFile(Category.RESOURCE, "package.json", json.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
    }
    packageJ = npm;
  }
  
  private void buildPackageJson(String canonical, PackageType kind, String web, String genDate, ImplementationGuide ig, List<String> fhirVersion) throws FHIRException, IOException {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (!ig.hasPackageId())
      b.append("packageId");
    if (!ig.hasVersion())
      b.append("version");
    if (!ig.hasFhirVersion())
      b.append("fhirVersion");
    if (!ig.hasLicense())
      b.append("license");
    for (ImplementationGuideDependsOnComponent d : ig.getDependsOn()) {
      if (!d.hasVersion()) {
        b.append("dependsOn.version("+d.getUri()+")");
      }
    }

    JsonObject npm = new JsonObject();
    npm.addProperty("name", ig.getPackageId());
    npm.addProperty("version", ig.getVersion());
    npm.addProperty("tools-version", ToolsVersion.TOOLS_VERSION);
    npm.addProperty("type", kind.getCode());
    if (ig.hasLicense())
      npm.addProperty("license", ig.getLicense().toCode());
    npm.addProperty("canonical", canonical);
    npm.addProperty("url", web);
    if (ig.hasTitle())
      npm.addProperty("title", ig.getTitle());
    if (ig.hasDescription())
      npm.addProperty("description", ig.getDescription()+ " (built "+genDate+timezone()+")");
    if (kind != PackageType.CORE) {
      JsonObject dep = new JsonObject();
      npm.add("dependencies", dep);
      for (String v : fhirVersion) { // TODO: fix for multiple versions
        dep.addProperty("hl7.fhir.core", v);
      }
      for (ImplementationGuideDependsOnComponent d : ig.getDependsOn()) {
        dep.addProperty(d.getPackageId(), d.getVersion());
      }
    }
    if (ig.hasPublisher())
      npm.addProperty("author", ig.getPublisher());
    JsonArray m = new JsonArray();
    for (ContactDetail t : ig.getContact()) {
      String email = email(t.getTelecom());
      String url = url(t.getTelecom());
      if (t.hasName() & (email != null || url != null)) {
        JsonObject md = new JsonObject();
        m.add(md);
        md.addProperty("name", t.getName());
        if (email != null)
          md.addProperty("email", email);
        if (url != null)
          md.addProperty("url", url);
      }
    }
    if (m.size() > 0)
      npm.add("maintainers", m);
    if (ig.getManifest().hasRendering())
      npm.addProperty("homepage", ig.getManifest().getRendering());
    JsonObject dir = new JsonObject();
    npm.add("directories", dir);
    dir.addProperty("lib", "package");
    dir.addProperty("example", "example");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(npm);
    try {
      addFile(Category.RESOURCE, "package.json", json.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
    }
    packageJ = npm;
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
  }


  public void addFile(Category cat, String name, byte[] content) throws IOException {
    String path = cat.getDirectory()+name;
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
  
  public void finish() throws IOException {
    tar.finish();
    tar.close();
    gzipOutputStream.close();
    bufferedOutputStream.close();
    OutputStream.close();
    TextFile.bytesToFile(OutputStream.toByteArray(), destFile);
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
  
  
}