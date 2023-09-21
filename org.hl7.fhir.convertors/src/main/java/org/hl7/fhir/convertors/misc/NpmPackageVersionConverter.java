package org.hl7.fhir.convertors.misc;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.annotation.Nonnull;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_30;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_30;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersionEnumFactory;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;

public class NpmPackageVersionConverter {

  private static final int BUFFER_SIZE = 1024;

  private final String source;
  private final String dest;
  private final String version;
  private final String vCode;
  private final List<String> errors = new ArrayList<>();
  private String currentVersion;

  private String packageId;

  public NpmPackageVersionConverter(String source, String dest, String version, String packageId) {
    super();
    this.source = source;
    this.dest = dest;
    this.vCode = version;
    this.packageId = packageId;
    this.version = VersionUtilities.versionFromCode(version);
  }

  public static void main(String[] args) throws IOException {
    NpmPackageVersionConverter self = new NpmPackageVersionConverter(args[0], args[1], args[2], args[3]);
    self.execute();
    System.out.println("Finished");
    for (String s : self.errors) {
      System.out.println(s);
    }
  }

  public List<String> getErrors() {
    return errors;
  }

  public void execute() throws IOException {
    Map<String, byte[]> content = loadContentMap(new FileInputStream(source));

    Map<String, byte[]> output = new HashMap<>();
    output.put("package/package.json", convertPackage(content.get("package/package.json")));
    output.put("package/other/spec.internals", convertSpec(content.get("package/other/spec.internals")));

    for (Entry<String, byte[]> e : content.entrySet()) {
      if (!e.getKey().equals("package/package.json") && !e.getKey().equals("package/other/spec.internals") && !e.getKey().endsWith("ig-r4.json") && !e.getKey().endsWith("ig-r4.jsonX")) {
        byte[] cnv = e.getValue();
        try {
          JsonObject json = JsonParser.parseObject(e.getValue());
          if (json.has("resourceType")) {
            cnv = convertResource(e.getKey(), e.getValue());
          }
        } catch (Exception ex) {
        }
        if (cnv != null && cnv.length > 0) {
          output.put(e.getKey(), cnv);
        }
      }
    }

    TarArchiveOutputStream tar;
    ByteArrayOutputStream OutputStream;
    BufferedOutputStream bufferedOutputStream;
    GzipCompressorOutputStream gzipOutputStream;

    OutputStream = new ByteArrayOutputStream();
    bufferedOutputStream = new BufferedOutputStream(OutputStream);
    gzipOutputStream = new GzipCompressorOutputStream(bufferedOutputStream);
    tar = new TarArchiveOutputStream(gzipOutputStream);


    Map<String, NpmPackageIndexBuilder> indexers = new HashMap<>();
    for (Entry<String, byte[]> e : output.entrySet()) {
      String n = e.getKey().substring(0, e.getKey().lastIndexOf("/"));
      String s = e.getKey().substring(n.length() + 1);
      byte[] b = e.getValue();
      NpmPackageIndexBuilder indexer = indexers.get(n);
      if (indexer == null) {
        indexer = new NpmPackageIndexBuilder();
        indexer.start(Utilities.path("[tmp]", "tmp-"+UUID.randomUUID().toString()+".db"));
        indexers.put(n, indexer);
      }
      indexer.seeFile(s, b);
      if (!s.equals(".index.json") && !s.equals("package.json") && !s.equals(".index.db")) {
        TarArchiveEntry entry = new TarArchiveEntry(e.getKey());
        entry.setSize(b.length);
        tar.putArchiveEntry(entry);
        tar.write(b);
        tar.closeArchiveEntry();
      }
    }
    for (Entry<String, NpmPackageIndexBuilder> e : indexers.entrySet()) {
      byte[] cnt = e.getValue().build().getBytes(StandardCharsets.UTF_8);
      TarArchiveEntry entry = new TarArchiveEntry(e.getKey() + "/.index.json");
      entry.setSize(cnt.length);
      tar.putArchiveEntry(entry);
      tar.write(cnt);
      tar.closeArchiveEntry();
      cnt = TextFile.fileToBytes(e.getValue().getDbFilename());
      new File(e.getValue().getDbFilename()).delete();
      entry = new TarArchiveEntry(e.getKey() + "/.index.db");
      entry.setSize(cnt.length);
      tar.putArchiveEntry(entry);
      tar.write(cnt);
      tar.closeArchiveEntry();
    }

    byte[] cnt = output.get("package/package.json");
    TarArchiveEntry entry = new TarArchiveEntry("package/package.json");
    entry.setSize(cnt.length);
    tar.putArchiveEntry(entry);
    tar.write(cnt);
    tar.closeArchiveEntry();

    tar.finish();
    tar.close();
    gzipOutputStream.close();
    bufferedOutputStream.close();
    OutputStream.close();
    byte[] b = OutputStream.toByteArray();
    TextFile.bytesToFile(b, dest);
  }

  @Nonnull
  protected Map<String, byte[]> loadContentMap(InputStream inputStream) throws IOException {
    GzipCompressorInputStream gzipIn;
    try {
      gzipIn = new GzipCompressorInputStream(inputStream);
    } catch (Exception e) {
      throw new IOException("Error reading " + source + ": " + e.getMessage(), e);
    }
    Map<String, byte[]> content = new HashMap<>();

    try (TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
      TarArchiveEntry entry;

      while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null) {
        String n = entry.getName();
        if (n.contains("..")) {
          throw new RuntimeException("Entry with an illegal name: " + n);
        }
        if (!entry.isDirectory()) {
          int count;
          byte[] data = new byte[BUFFER_SIZE];
          ByteArrayOutputStream fos = new ByteArrayOutputStream();
          try (BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER_SIZE)) {
            while ((count = tarIn.read(data, 0, BUFFER_SIZE)) != -1) {
              dest.write(data, 0, count);
            }
          }
          fos.close();
          content.put(n, fos.toByteArray());
        }
      }
    }
    return content;
  }

  private byte[] convertPackage(byte[] cnt) throws IOException {
    JsonObject json = JsonParser.parseObject(cnt);
    currentVersion = json.getJsonArray("fhirVersions").get(0).asString();
    String name = json.asString("name");
    assert(packageId.equals(name + "." + vCode));
    json.remove("name");
    json.add("name", name + "." + vCode);
    json.remove("fhirVersions");
    json.remove("dependencies");
    JsonArray fv = new JsonArray();
    json.add("fhirVersions", fv);
    fv.add(version);
    JsonObject dep = new JsonObject();
    json.add("dependencies", dep);
    dep.add(VersionUtilities.packageForVersion(version), version);
    return JsonParser.composeBytes(json);
  }

  private byte[] convertSpec(byte[] cnt) throws IOException {
    JsonObject json = JsonParser.parseObject(cnt);
    json.set("ig-version", version);
    json.set("npm-name", packageId);
    return JsonParser.composeBytes(json, true);
  }

  private byte[] convertResource(String n, byte[] cnt) {
    try {
      if (VersionUtilities.isR2Ver(currentVersion)) {
        org.hl7.fhir.dstu2.model.Resource res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt);
        convertResourceR2(res);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_30.convertResource(VersionConvertorFactory_10_30.convertResource(res)));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_10_30.convertResource(res));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_10_40.convertResource(res));
        } else if (VersionUtilities.isR5Plus(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_10_50.convertResource(res));
        }
      } else if (VersionUtilities.isR2BVer(currentVersion)) {
        org.hl7.fhir.dstu2016may.model.Resource res = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt);
        convertResourceR2B(res);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_30.convertResource(VersionConvertorFactory_14_30.convertResource(res)));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_14_30.convertResource(res));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_14_40.convertResource(res));
        } else if (VersionUtilities.isR5Plus(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_14_50.convertResource(res));
        }
      } else if (VersionUtilities.isR3Ver(currentVersion)) {
        org.hl7.fhir.dstu3.model.Resource res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt);
        convertResourceR3(res);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_30.convertResource(res));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_30.convertResource(res));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_30_40.convertResource(res));
        } else if (VersionUtilities.isR5Plus(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_30_50.convertResource(res));
        }
      } else if (VersionUtilities.isR4Ver(currentVersion)) {
        org.hl7.fhir.r4.model.Resource res = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);
        convertResourceR4(res);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_40.convertResource(res, new PR2Handler()));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_40.convertResource(res));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_30_40.convertResource(res, new BaseAdvisor_30_40(false)));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR5Plus(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_40_50.convertResource(res));
        }
      } else if (VersionUtilities.isR5Plus(currentVersion)) {
        org.hl7.fhir.r5.model.Resource res = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt);
        convertResourceR5(res);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_50.convertResource(res));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_50.convertResource(res));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_30_50.convertResource(res, new BaseAdvisor_30_50(false)));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_40_50.convertResource(res));
        } else if (VersionUtilities.isR5Plus(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(res);
        }
      }
      throw new Error("Unknown version " + currentVersion + " -> " + version);
    } catch (Exception ex) {
      ex.printStackTrace();
      errors.add("Error converting " + n + ": " + ex.getMessage());
      return null;
    }
  }

  private void convertResourceR2(org.hl7.fhir.dstu2.model.Resource res) {
    if (res instanceof org.hl7.fhir.dstu2.model.ImplementationGuide) {
      org.hl7.fhir.dstu2.model.ImplementationGuide ig = (org.hl7.fhir.dstu2.model.ImplementationGuide) res;
      ig.setFhirVersion(version);
    } 
  }

  private void convertResourceR2B(org.hl7.fhir.dstu2016may.model.Resource res) {
    if (res instanceof org.hl7.fhir.dstu2016may.model.ImplementationGuide) {
      org.hl7.fhir.dstu2016may.model.ImplementationGuide ig = (org.hl7.fhir.dstu2016may.model.ImplementationGuide) res;
      ig.setFhirVersion(version);
    } 
  }

  private void convertResourceR3(org.hl7.fhir.dstu3.model.Resource res) {
    if (res instanceof org.hl7.fhir.dstu3.model.ImplementationGuide) {
      org.hl7.fhir.dstu3.model.ImplementationGuide ig = (org.hl7.fhir.dstu3.model.ImplementationGuide) res;
      ig.setFhirVersion(version);
    }    
  }

  private void convertResourceR4(org.hl7.fhir.r4.model.Resource res) {
    if (res instanceof org.hl7.fhir.r4.model.ImplementationGuide) {
      org.hl7.fhir.r4.model.ImplementationGuide ig = (org.hl7.fhir.r4.model.ImplementationGuide) res;
      ig.getFhirVersion().clear();
      ig.getFhirVersion().add(new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.FHIRVersionEnumFactory(), version));
      ig.setPackageId(packageId);
    }
  }

  private void convertResourceR5(Resource res) {
    if (res instanceof ImplementationGuide) {
      ImplementationGuide ig = (ImplementationGuide) res;
      ig.getFhirVersion().clear();
      ig.getFhirVersion().add(new Enumeration<>(new FHIRVersionEnumFactory(), version));
      ig.setPackageId(packageId);
    }
  }

}