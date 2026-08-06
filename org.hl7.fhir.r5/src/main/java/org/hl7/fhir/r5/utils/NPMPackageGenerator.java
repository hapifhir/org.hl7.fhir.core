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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.eclipse.jgit.ignore.IgnoreNode;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonString;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;

import org.hl7.fhir.utilities.npm.ToolsVersion;


@MarkedToMoveToAdjunctPackage
@Slf4j
public class NPMPackageGenerator {

  public enum Category {
    RESOURCE, EXAMPLE, OPENAPI, SCHEMATRON, RDF, OTHER, TOOL, TEMPLATE, JEKYLL, TEST, ADL, CUSTOM;

    private String getDirectory() {
      switch (this) {
      case RESOURCE: return "package/";
      case EXAMPLE: return "package/example/";
      case OPENAPI: return "package/openapi/";
      case SCHEMATRON: return "package/xml/";
      case RDF: return "package/rdf/";      
      case OTHER: return "package/other/";  
      case ADL: return "package/adl/";      
      case TEMPLATE: return "package/other/";      
      case JEKYLL: return "package/jekyll/";      
      case TEST: return "package/tests/"; 
      case TOOL: return "package/bin/";      
      case CUSTOM: return "package/custom/";      
      }
      return "/";
    }
  }

  private String destFile;
  private Set<String> created = new HashSet<String>();
  public Set<String> getCreated() {
    return created;
  }

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


  public NPMPackageGenerator(String pid, String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, Date date, Map<String, String> relatedIgs, boolean notForPublication) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    List<String> fhirVersion = new ArrayList<>();
    for (Enumeration<FHIRVersion> v : ig.getFhirVersion())
      fhirVersion.add(v.asStringValue());
    buildPackageJson(pid, canonical, kind, url, date, ig, fhirVersion, notForPublication, relatedIgs);
  }

  public NPMPackageGenerator(String pid, String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, Date date, Map<String, String> relatedIgs, boolean notForPublication, String fhirVersion) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    List<String> fhirVersions = new ArrayList<>();
    fhirVersions.add(fhirVersion);
    buildPackageJson(pid, canonical, kind, url, date, ig, fhirVersions, notForPublication, relatedIgs);
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

  public NPMPackageGenerator(String destFile, String canonical, String url, PackageType kind, ImplementationGuide ig, Date date, List<String> fhirVersion, Map<String, String> relatedIgs, boolean notForPublication) throws FHIRException, IOException {
    super();
    this.destFile = destFile;
    start();
    buildPackageJson(ig.getPackageId(), canonical, kind, url, date, ig, fhirVersion, notForPublication, relatedIgs);
  }

  public NPMPackageGenerator(String destFile, JsonObject npm) throws FHIRException, IOException {
    super();
    log.info("create package file at " + destFile);
    this.destFile = destFile;
    start();
    String json =JsonParser.compose(npm, true);
    try {
      addFile(Category.RESOURCE, "package.json", json.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
    }
    packageJ = npm;
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

  private void buildPackageJson(String pid, String canonical, PackageType kind, String web, Date date, ImplementationGuide ig, List<String> fhirVersion, boolean notForPublication, Map<String, String> relatedIgs) throws FHIRException, IOException {
    String dtHuman = new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(date);
    String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

    JsonObject npm = new JsonObject();
    npm.add("name", pid);
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
    
    // dep is nullable: a CORE package writes no dependencies object, but the dependsOn loop below
    // still has to run for it, because reporting a versionless dependsOn is independent of whether
    // anything is emitted. Hoisting the loop out keeps this fold behaviour-neutral.
    JsonObject dep = null;
    if (kind != PackageType.CORE) {
      dep = new JsonObject();
      npm.add("dependencies", dep);
      for (String v : fhirVersion) { 
        String vp = packageForVersion(v);
        if (vp != null && !dep.has(vp) && !dependsOnDeclaresPackage(ig, vp)) {
          dep.add(vp, v);
        }
      }
    }
    List<ImplementationGuideDependsOnComponent> dependsOn = ig.getDependsOn();
    for (int i = 0; i < dependsOn.size(); i++) {
      ImplementationGuideDependsOnComponent d = dependsOn.get(i);
      if (!d.hasVersion()) {
        dependencyWarnings.add(missingVersionMessage(ig, i, d));
      }
      if (dep != null) {
        String key = d.getPackageIdElement().hasUserData(UserDataNames.IG_DEP_ALIASED)
            ? d.getId() + "@npm:" + d.getPackageId()
            : d.getPackageId();
        if (d.hasVersion()) {
          dep.add(key, d.getVersion());
        } else if (d.hasPackageId() && !dep.has(key) && !dependsOnDeclaresPackage(ig, key)) {
          // Master wrote the key with a JSON null and downstream tooling may key off its
          // presence, so the output shape is preserved deliberately. The three guards are new
          // and are not master-consistent on purpose -- each one is a master crash: without
          // hasPackageId, add() throws "Name is null" (JsonObject.java:82); without has(), it
          // throws on a key the auto-add already took (JsonObject.java:33-35); without
          // dependsOnDeclaresPackage, a *later* versioned entry for the same packageId throws
          // on the duplicate. In all three cases the more complete declaration wins.
          dep.addNull(key);
        }
      }
    }
    for (String w : dependencyWarnings) {
      log.warn(w);
    }
    if (ig.hasPublisher()) {
      npm.add("author", ig.getPublisher());
    }
    JsonArray m = new JsonArray();
    for (ContactDetail t : ig.getContact()) {
      String email = email(t.getTelecom());
      String url = url(t.getTelecom());
      if (t.hasName() && (email != null || url != null)) {
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
    if (ig.hasJurisdiction() && ig.getJurisdiction().size() == 1 && ig.getJurisdictionFirstRep().getCoding().size() == 1) {
      Coding c = ig.getJurisdictionFirstRep().getCodingFirstRep();
      npm.add("jurisdiction", c.getSystem()+"#"+c.getCode());
    }
    if (relatedIgs != null) {
      JsonObject pd = npm.forceObject("peerDependencies");
      for (String n : relatedIgs.keySet()) {
        pd.add(n, relatedIgs.get(n));
      }
    }
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
    if (ig.hasJurisdiction() && ig.getJurisdiction().size() == 1 && ig.getJurisdictionFirstRep().getCoding().size() == 1) {
      Coding c = ig.getJurisdictionFirstRep().getCodingFirstRep();
      packageManifest.add("jurisdiction", c.getSystem()+"#"+c.getCode());
    }
  }


  /**
   * Version-line prefixes actually published for each FHIR core package.
   * VersionUtilities deliberately maps pre-ballot lines onto the *following* release's
   * package (e.g. isR4Ver matches 3.2/3.3/3.5), but this class writes the raw version as
   * the dependency value, so an unguarded mapping yields unresolvable entries such as
   * "hl7.fhir.r4.core": "3.5.0". Only emit when the raw version belongs to the matched
   * package's own release line.
   */
  // MIRROR: org.hl7.fhir.r4b/.../NPMPackageGenerator.java keeps a deliberate verbatim copy of this
  // class's version-mapping and dependency-loop region -- this table, versionIsInPackageFamily,
  // isPublishableVersion, labelStart, hasCiBuildLabel, isResolvableWildcardVersion,
  // packageFromVersionPrefix, packageForVersion, missingVersionMessage and
  // the dependsOn traversal. The two must be edited together; consolidating them into
  // VersionUtilities was considered and deferred as an upstream API change. dependsOnDeclaresPackage
  // below is deliberately r5-only: r4b has no UserDataNames.IG_DEP_ALIASED concept and Gson's
  // JsonObject is last-write-wins, so a versioned core dependsOn already overwrites the auto-add
  // there and the author still wins.
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
    int cut = labelStart(v);
    String numeric = cut < 0 ? v : v.substring(0, cut);
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
    return !hasCiBuildLabel(v);
  }

  /** Index of the first pre-release/build label separator in v, or -1 when it has none. */
  private static int labelStart(String v) {
    for (int i = 0; i < v.length(); i++) {
      char c = v.charAt(i);
      if (c == '-' || c == '+') {
        return i;
      }
    }
    return -1;
  }

  private static boolean hasCiBuildLabel(String v) {
    int cut = labelStart(v);
    return cut >= 0 && v.substring(cut + 1).toLowerCase().startsWith(CI_BUILD_LABEL);
  }

  /**
   * Master emitted a wildcard FHIR version verbatim -- "4.0.x" produced
   * "hl7.fhir.r4.core": "4.0.x", which is a resolvable npm range
   * (PackageCacheTests.java:51-52) -- so the publishable-shape gate must not swallow it.
   * Which wildcard forms are legal is VersionUtilities' question, not this class's, so
   * delegate rather than pattern-match here. Two-segment codes such as "4.0" are still
   * dropped: isSemVerWithWildcards accepts them, but versionHasWildcards does not, and it is
   * the wildcard that makes the difference -- "4.0.x" resolves end-to-end while "4.0" does
   * not (VersionUtilities.versionMatches is exact-arity; VersionUtilitiesTest.java:480-481).
   * A bare "x" or "*" is dropped by isSemVerWithWildcards, which requires an integer major
   * (VersionUtilities.java:480); a minor-level "4.x" is dropped further down, because
   * VersionUtilities.packageForVersion matches on a literal major.minor prefix and returns
   * null. The ci-build exclusion is repeated because a wildcard version never reaches
   * isPublishableVersion.
   */
  private static boolean isResolvableWildcardVersion(String v) {
    return VersionUtilities.versionHasWildcards(v)
        && VersionUtilities.isSemVerWithWildcards(v)
        && !hasCiBuildLabel(v);
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
    if (!isPublishableVersion(v) && !isResolvableWildcardVersion(v)) {
      return null;
    }
    try {
      String vp = VersionUtilities.packageForVersion(v);
      return vp != null && versionIsInPackageFamily(vp, v) ? vp : null;
    } catch (FHIRException e) {
      // Non-semver strings that get this far have already cleared isPublishableVersion, so the
      // only ones that reach here are the historical four-segment FHIR build codes such as
      // 3.0.1.11917, which were published and which the pre-change startsWith helper mapped --
      // plus, in principle, a wildcard admitted by isResolvableWildcardVersion, which the same
      // prefix table resolves to the same package id. Everything else that used to land here
      // ("0.01", "0.06", "current") is now rejected before the try.
      return packageFromVersionPrefix(v);
    }
  }

  private boolean dependsOnDeclaresPackage(ImplementationGuide ig, String packageId) {
    for (ImplementationGuideDependsOnComponent d : ig.getDependsOn()) {
      if (!d.getPackageIdElement().hasUserData(UserDataNames.IG_DEP_ALIASED)
          && d.hasVersion()
          && packageId.equals(d.getPackageId())) {
        return true;
      }
    }
    return false;
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

  public boolean hasFile(Category cat, String name) throws IOException {
    String path = cat.getDirectory()+name;
    if (path.length() > 100) {
      name = name.substring(0, name.indexOf("-"))+"-"+UUID.randomUUID().toString()+".json";
      path = cat.getDirectory()+name;      
    }
      
    return created.contains(path);    
  }
  
  public void addFile(Category cat, String name, byte[] content) throws IOException {
    String path = cat.getDirectory()+name;
    if (path.length() > 100) {
      name = name.substring(0, name.indexOf("-"))+"-"+UUID.randomUUID().toString()+".json";
      path = cat.getDirectory()+name;      
    }
      
    if (created.contains(path)) {
      log.warn("Duplicate package file "+path);
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
      log.warn("Duplicate package file "+path);
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
    FileUtilities.bytesToFile(OutputStream.toByteArray(), destFile);
    // also, for cache management on current builds, generate a little manifest
    if (packageManifest != null) {
      String json = JsonParser.compose(packageManifest, true);
      FileUtilities.stringToFile(json, FileUtilities.changeFileExt(destFile, ".manifest.json"));
    }
  }

  private void buildIndexJson() throws IOException {
    byte[] content = FileUtilities.stringToBytes(indexer.build());
    addFile(Category.RESOURCE, ".index.json", content);
    if (ManagedFileAccess.file(indexdb).exists()) {
      content = FileUtilities.fileToBytes(indexdb);
      ManagedFileAccess.file(indexdb).delete();
      addFile(Category.RESOURCE, ".index.db", content);
    }
  }

  public String filename() {
    return destFile;
  }

  public void loadDir(String rootDir, String name) throws IOException {
    loadFiles(rootDir, null, ManagedFileAccess.file(Utilities.path(rootDir, name)));
  }

    public void loadFiles(String root, String ignoreFile, File dir, String... noload) throws IOException {
        Path rootPath = Paths.get(root);
        Path dirPath = dir == null ? rootPath : dir.toPath();
        // Ensure the directory to scan is inside the root
        Path normalizedRoot = rootPath.toAbsolutePath().normalize();
        Path normalizedDir = dirPath.toAbsolutePath().normalize();
        if (!normalizedDir.startsWith(normalizedRoot)) {
            throw new IllegalArgumentException("dir must be root or a subdirectory of root");
        }
        String ignoreFileName = null;
        IgnoreNode rootIgnoreNode = new IgnoreNode();

        if (ignoreFile != null && !ignoreFile.isEmpty()) {
            if (!Paths.get(ignoreFile).getFileName().toString().equals(ignoreFile)) {
                throw new IllegalArgumentException("ignoreFile must be a simple filename without any path separators");
            }
            ignoreFileName = ignoreFile;
        }

        if (ignoreFileName != null) {
            loadAllIgnorePatternsRecursive(rootPath, rootPath, ignoreFileName, rootIgnoreNode);
            String ignoreFilePattern = "**/" + ignoreFileName + "\n" + ignoreFileName;
            rootIgnoreNode.parse(new ByteArrayInputStream(ignoreFilePattern.getBytes()));
        }

        for (String pattern : noload) {
            String anchoredPattern = pattern.startsWith("/") ? pattern : "/" + pattern;
            rootIgnoreNode.parse(new ByteArrayInputStream(anchoredPattern.getBytes()));
        }

        scanAndFilterFiles(rootPath, dirPath, ignoreFileName, rootIgnoreNode);
    }

    private void loadAllIgnorePatternsRecursive(Path root, Path directory, String ignoreFileName, IgnoreNode rootIgnoreNode) throws IOException {
        Path ignorePath = directory.resolve(ignoreFileName);
        if (Files.exists(ignorePath)) {
            try (var in = Files.newInputStream(ignorePath)) {
                rootIgnoreNode.parse(in);
            }
        }

        try (Stream<Path> paths = Files.list(directory)) {
            paths.filter(Files::isDirectory)
                .filter(p -> !p.getFileName().toString().startsWith("."))
                .forEach(subDir -> {
                    try {
                        loadAllIgnorePatternsRecursive(root, subDir, ignoreFileName, rootIgnoreNode);
                    } catch (IOException e) {
                        // ignore and continue
                    }
                });
        }
    }

    private void scanAndFilterFiles(Path root, Path startDir, String ignoreFileName, IgnoreNode rootIgnoreNode) throws IOException {
        java.util.Map<String, Boolean> directoryIgnoreCache = new java.util.HashMap<>();
        try (Stream<Path> paths = Files.walk(startDir)) {
            paths.filter(Files::isRegularFile).forEach(f -> {
                try {
                    if (isNotIgnored(f, root, rootIgnoreNode, directoryIgnoreCache)) {
                        Path rel = root.relativize(f);
                        String path = rel.toString();
                        if (created.contains(path))
                            log.warn("Duplicate package file "+path);
                        else {
                            byte[] content = FileUtilities.fileToBytes(f.toFile());
                            created.add(path);
                            TarArchiveEntry entry = new TarArchiveEntry(path);
                            entry.setSize(content.length);
                            tar.putArchiveEntry(entry);
                            tar.write(content);
                            tar.closeArchiveEntry();
                        }
                    }
                } catch (IOException e) {
                    // ignore and continue
                }
            });
        }
    }

    private boolean isNotIgnored(Path file, Path root, IgnoreNode rootIgnoreNode, java.util.Map<String, Boolean> directoryIgnoreCache) throws IOException {
        Path relativePath = root.relativize(file);
        String pathString = relativePath.toString().replace(File.separator, "/");

        if (rootIgnoreNode.isIgnored(pathString, false) == IgnoreNode.MatchResult.IGNORED) {
            return false;
        }

        Path parent = relativePath.getParent();
        while (parent != null) {
            String parentPath = parent.toString().replace(File.separator, "/");
            Boolean cached = directoryIgnoreCache.get(parentPath);
            if (cached != null) {
                if (cached) return false;
            } else {
                boolean isIgnored = rootIgnoreNode.isIgnored(parentPath, true) == IgnoreNode.MatchResult.IGNORED;
                directoryIgnoreCache.put(parentPath, isIgnored);
                if (isIgnored) return false;
            }
            parent = parent.getParent();
        }

        return true;
    }


  // public void loadFiles(String root, File dir, String... noload) throws IOException {
  //   for (File f : dir.listFiles()) {
  //     if (!Utilities.existsInList(f.getName(), noload)) {
  //       if (f.isDirectory()) {
  //         loadFiles(root, f);
  //       } else {
  //         String path = f.getAbsolutePath().substring(root.length()+1);
  //         byte[] content = FileUtilities.fileToBytes(f);
  //         if (created.contains(path)) 
  //           log.warn("Duplicate package file "+path);
  //         else {
  //           created.add(path);
  //           TarArchiveEntry entry = new TarArchiveEntry(path);
  //           entry.setSize(content.length);
  //           tar.putArchiveEntry(entry);
  //           tar.write(content);
  //           tar.closeArchiveEntry();
  //         }
  //       }
  //     }
  //   }
  // }

  public String version() {
    return igVersion;
  }


}