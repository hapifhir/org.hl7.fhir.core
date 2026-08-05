package org.hl7.fhir.r4b.utils;

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
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.ContactDetail;
import org.hl7.fhir.r4b.model.ContactPoint;
import org.hl7.fhir.r4b.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4b.model.ImplementationGuide;
import org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.r4b.utils.NPMPackageGenerator.Category;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class NPMPackageGenerator {

  public enum Category {
    RESOURCE, EXAMPLE, OPENAPI, SCHEMATRON, RDF, OTHER, TOOL, TEMPLATE, JEKYLL;

    private String getDirectory() {
      switch (this) {
      case RESOURCE:
        return "package/";
      case EXAMPLE:
        return "example/";
      case OPENAPI:
        return "openapi/";
      case SCHEMATRON:
        return "xml/";
      case RDF:
        return "rdf/";
      case OTHER:
        return "other/";
      case TEMPLATE:
        return "other/";
      case JEKYLL:
        return "jekyll/";
      case TOOL:
        return "bin/";
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

  public JsonObject getPackageJ() {
    return packageJ;
  }

  private JsonObject packageManifest;
  private NpmPackageIndexBuilder indexer;
  private String igVersion;
  private String indexdb;

  private final List<String> dependencyWarnings = new ArrayList<>();

  /** Package-private so NPMPackageGeneratorTest can assert what was reported. */
  List<String> getDependencyWarnings() {
    return dependencyWarnings;
  }

  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig,
      Date date, boolean notForPublication) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    List<String> fhirVersion = new ArrayList<>();
    for (Enumeration<FHIRVersion> v : ig.getFhirVersion())
      fhirVersion.add(v.asStringValue());
    buildPackageJson(canonical, kind, url, date, ig, fhirVersion, notForPublication);
  }

  public static NPMPackageGenerator subset(NPMPackageGenerator master, String destFile, String id, String name,
      Date date, boolean notForPublication) throws FHIRException, IOException {
    JsonObject p = master.packageJ.deepCopy();
    p.remove("name");
    p.addProperty("name", id);
    p.remove("type");
    p.addProperty("type", PackageType.CONFORMANCE.getCode());
    p.remove("title");
    p.addProperty("title", name);
    if (notForPublication) {
      p.addProperty("notForPublication", true);
    }

    return new NPMPackageGenerator(destFile, p, date, notForPublication);
  }

  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig,
      Date date, List<String> fhirVersion, boolean notForPublication) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    buildPackageJson(canonical, kind, url, date, ig, fhirVersion, notForPublication);
  }

  public NPMPackageGenerator(String destFile, JsonObject npm, Date date, boolean notForPublication)
      throws FHIRException, IOException {
    super();
    String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    packageJ = npm;
    packageManifest = new JsonObject();
    packageManifest.addProperty("version", npm.get("version").getAsString());
    packageManifest.addProperty("date", dt);
    if (notForPublication) {
      packageManifest.addProperty("notForPublication", true);
    }
    npm.addProperty("date", dt);
    packageManifest.addProperty("name", npm.get("name").getAsString());
    this.destFile = destFile;
    start();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(npm);
    try {
      addFile(Category.RESOURCE, "package.json", json.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
    }
  }

  private void buildPackageJson(String canonical, PackageType kind, String web, Date date, ImplementationGuide ig,
      List<String> fhirVersion, boolean notForPublication) throws FHIRException, IOException {
    String dtHuman = new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(date);
    String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

    JsonObject npm = new JsonObject();
    npm.addProperty("name", ig.getPackageId());
    npm.addProperty("version", ig.getVersion());
    igVersion = ig.getVersion();
    npm.addProperty("tools-version", ToolsVersion.TOOLS_VERSION);
    npm.addProperty("type", kind.getCode());
    npm.addProperty("date", dt);
    if (ig.hasLicense()) {
      npm.addProperty("license", ig.getLicense().toCode());
    }
    npm.addProperty("canonical", canonical);
    if (notForPublication) {
      npm.addProperty("notForPublication", true);
    }
    npm.addProperty("url", web);
    if (ig.hasTitle()) {
      npm.addProperty("title", ig.getTitle());
    }
    if (ig.hasDescription()) {
      npm.addProperty("description", ig.getDescription() + " (built " + dtHuman + timezone() + ")");
    }
    JsonArray vl = new JsonArray();

    npm.add("fhirVersions", vl);
    for (String v : fhirVersion) {
      vl.add(new JsonPrimitive(v));
    }

    // dep is nullable: a CORE package writes no dependencies object, but the dependsOn loop below
    // still has to run for it, because reporting a versionless dependsOn is independent of whether
    // anything is emitted. Hoisting the loop out keeps this fold behaviour-neutral.
    JsonObject dep = null;
    if (kind != PackageType.CORE) {
      dep = new JsonObject();
      npm.add("dependencies", dep);
      for (String v : fhirVersion) {
        String vp = packageForVersion(v);
        if (vp != null && !dep.has(vp)) {
          dep.addProperty(vp, v);
        }
      }
    }
    List<ImplementationGuideDependsOnComponent> dependsOn = ig.getDependsOn();
    for (int i = 0; i < dependsOn.size(); i++) {
      ImplementationGuideDependsOnComponent d = dependsOn.get(i);
      if (!d.hasVersion()) {
        // Gson stores addProperty(key, null) as JsonNull, and the serializer below has
        // serializeNulls off, so emitting it would drop the key from package.json entirely --
        // taking the auto-added core dependency with it when the packageId is a core package.
        dependencyWarnings.add(missingVersionMessage(ig, i, d));
        continue;
      }
      if (dep != null) {
        dep.addProperty(d.getPackageId(), d.getVersion());
      }
    }
    for (String w : dependencyWarnings) {
      log.warn(w);
    }
    if (ig.hasPublisher()) {
      npm.addProperty("author", ig.getPublisher());
    }
    JsonArray m = new JsonArray();
    for (ContactDetail t : ig.getContact()) {
      String email = email(t.getTelecom());
      String url = url(t.getTelecom());
      if (t.hasName() && (email != null || url != null)) {
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

    packageManifest = new JsonObject();
    packageManifest.addProperty("version", ig.getVersion());
    packageManifest.addProperty("fhirVersion", fhirVersion.toString());
    packageManifest.addProperty("date", dt);
    packageManifest.addProperty("name", ig.getPackageId());

  }

  static String missingVersionMessage(ImplementationGuide ig, int index, ImplementationGuideDependsOnComponent d) {
    StringBuilder msg = new StringBuilder("ImplementationGuide ")
        .append(ig.getPackageId())
        .append(": dependsOn[").append(index).append("]");
    if (d.hasPackageId()) {
      msg.append(' ').append(d.getPackageId());
    }
    if (d.hasUri()) {
      msg.append(" (").append(d.getUri()).append(')');
    }
    return msg.append(" is missing a required version; it will be omitted from the generated package.json").toString();
  }

  /**
   * Version-line prefixes actually published for each FHIR core package.
   * VersionUtilities deliberately maps pre-ballot lines onto the *following* release's
   * package (e.g. isR4Ver matches 3.2/3.3/3.5), but this class writes the raw version as
   * the dependency value, so an unguarded mapping yields unresolvable entries such as
   * "hl7.fhir.r4.core": "3.5.0". Only emit when the raw version belongs to the matched
   * package's own release line.
   */
  // MIRROR: this class is a deliberate verbatim copy of org.hl7.fhir.r5/.../NPMPackageGenerator's
  // version-mapping and dependency-loop region -- this table, versionIsInPackageFamily,
  // isPublishableVersion, packageFromVersionPrefix, packageForVersion, missingVersionMessage and
  // the dependsOn traversal. The two must be edited together; consolidating them into
  // VersionUtilities was considered and deferred as an upstream API change. dependsOnDeclaresPackage
  // is deliberately r5-only: r4b has no UserDataNames.IG_DEP_ALIASED concept and Gson's
  // JsonObject is last-write-wins, so a versioned core dependsOn already overwrites the auto-add
  // here and the author still wins.
  private static final Map<String, List<String>> CORE_PACKAGE_VERSION_PREFIXES = Map.of(
      "hl7.fhir.r2.core",  List.of("1.0"),
      "hl7.fhir.r2b.core", List.of("1.4"),
      "hl7.fhir.r3.core",  List.of("3.0"),
      "hl7.fhir.r4.core",  List.of("4.0"),
      "hl7.fhir.r4b.core", List.of("4.1", "4.3"),
      "hl7.fhir.r5.core",  List.of("4.5", "5.0"),
      "hl7.fhir.r6.core",  List.of("6.0"));

  private static final String CI_BUILD_LABEL = "cibuild";

  /**
   * Whether v is shaped like a version that gets published to the package registry.
   * VersionUtilities answers "which release line is this?"; that is a different question from
   * "can anyone install this?". Published core packages always carry a full major.minor.patch
   * (or a legacy four-segment build code), and the ci-build label is never published.
   */
  private static boolean isPublishableVersion(String v) {
    int cut = -1;
    for (int i = 0; i < v.length(); i++) {
      char c = v.charAt(i);
      if (c == '-' || c == '+') {
        cut = i;
        break;
      }
    }
    String numeric = cut < 0 ? v : v.substring(0, cut);
    String label = cut < 0 ? null : v.substring(cut + 1);
    // The -1 limit is load-bearing: the default split drops trailing empty strings, so "5.0.0."
    // would pass both checks below and be emitted raw as an unresolvable dependency value.
    String[] parts = numeric.split("\\.", -1);
    if (parts.length < 3) {
      return false;
    }
    for (String p : parts) {
      if (!Utilities.isInteger(p)) {
        return false;
      }
    }
    return label == null || !label.toLowerCase().startsWith(CI_BUILD_LABEL);
  }

  private boolean versionIsInPackageFamily(String packageId, String v) {
    List<String> prefixes = CORE_PACKAGE_VERSION_PREFIXES.get(packageId);
    if (prefixes == null) {
      return false;
    }
    for (String prefix : prefixes) {
      if (v.startsWith(prefix)) {
        return true;
      }
    }
    return false;
  }

  /**
   * The prefixes are mutually exclusive major.minor pairs, so at most one entry can match and
   * the (unordered) Map.of iteration order does not affect the result.
   */
  private String packageFromVersionPrefix(String v) {
    for (Map.Entry<String, List<String>> e : CORE_PACKAGE_VERSION_PREFIXES.entrySet()) {
      for (String prefix : e.getValue()) {
        if (v.startsWith(prefix)) {
          return e.getKey();
        }
      }
    }
    return null;
  }

  private String packageForVersion(String v) {
    // "current" is handled here rather than left to VersionUtilities: that helper's
    // "current" -> hl7.fhir.r5.core branch (VersionUtilities.java:169-171) is unreachable
    // because isR2Ver throws from checkVersionValidWildcards first, so relying on it would
    // make this behaviour depend on an upstream bug. CI-build IGs get no core dependency.
    if (v == null || "current".equals(v)) {
      return null;
    }
    if (!isPublishableVersion(v)) {
      return null;
    }
    try {
      String vp = VersionUtilities.packageForVersion(v);
      return vp != null && versionIsInPackageFamily(vp, v) ? vp : null;
    } catch (FHIRException e) {
      // Non-semver strings that get this far have already cleared isPublishableVersion, so the
      // only ones that reach here are the historical four-segment FHIR build codes such as
      // 3.0.1.11917, which were published and which the pre-change startsWith helper mapped.
      // Everything else that used to land here ("0.01", "0.06", "current") is now rejected
      // before the try.
      return packageFromVersionPrefix(v);
    }
  }

  private String timezone() {
    TimeZone tz = TimeZone.getDefault();
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000),
        Math.abs((offsetInMillis / 60000) % 60));
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
    String path = cat.getDirectory() + name;
    if (path.length() > 100) {
      name = name.substring(0, name.indexOf("-")) + "-" + UUID.randomUUID().toString();
      path = cat.getDirectory() + name;
    }

    if (created.contains(path)) {
      log.warn("Duplicate package file " + path);
    } else {
      created.add(path);
      TarArchiveEntry entry = new TarArchiveEntry(path);
      entry.setSize(content.length);
      tar.putArchiveEntry(entry);
      tar.write(content);
      tar.closeArchiveEntry();
      if (cat == Category.RESOURCE) {
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
    FileUtilities.bytesToFile(OutputStream.toByteArray(), destFile);
    // also, for cache management on current builds, generate a little manifest
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(packageManifest);
    FileUtilities.stringToFile(json, FileUtilities.changeFileExt(destFile, ".manifest.json"));
  }

  private void buildIndexJson() throws IOException {
    byte[] content = FileUtilities.stringToBytes(indexer.build());
    addFile(Category.RESOURCE, ".index.json", content);
    content = FileUtilities.fileToBytes(indexdb);
    ManagedFileAccess.file(indexdb).delete();
    addFile(Category.RESOURCE, ".index.db", content);
  }

  public String filename() {
    return destFile;
  }

  public void loadDir(String rootDir, String name) throws IOException {
    loadFiles(rootDir, ManagedFileAccess.file(Utilities.path(rootDir, name)));
  }

  public void loadFiles(String root, File dir, String... noload) throws IOException {
    for (File f : dir.listFiles()) {
      if (!Utilities.existsInList(f.getName(), noload)) {
        if (f.isDirectory()) {
          loadFiles(root, f);
        } else {
          String path = f.getAbsolutePath().substring(root.length() + 1);
          byte[] content = FileUtilities.fileToBytes(f);
          if (created.contains(path))
            log.warn("Duplicate package file " + path);
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