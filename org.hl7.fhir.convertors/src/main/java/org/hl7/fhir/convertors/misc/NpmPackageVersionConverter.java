package org.hl7.fhir.convertors.misc;

import com.google.common.base.Charsets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.factory.*;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NpmPackageVersionConverter {

  private static final int BUFFER_SIZE = 1024;

  private final String source;
  private final String dest;
  private final String version;
  private final String vCode;
  private final List<String> errors = new ArrayList<>();
  private String currentVersion;

  public NpmPackageVersionConverter(String source, String dest, String version) {
    super();
    this.source = source;
    this.dest = dest;
    this.vCode = version;
    this.version = VersionUtilities.versionFromCode(version);
  }

  public static void main(String[] args) throws IOException {
    NpmPackageVersionConverter self = new NpmPackageVersionConverter(args[0], args[1], args[2]);
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
    GzipCompressorInputStream gzipIn;
    try {
      gzipIn = new GzipCompressorInputStream(new FileInputStream(source));
    } catch (Exception e) {
      throw new IOException("Error reading " + source + ": " + e.getMessage(), e);
    }
    Map<String, byte[]> content = new HashMap<>();

    try (TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
      TarArchiveEntry entry;

      while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null) {
        String n = entry.getName();
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

    Map<String, byte[]> output = new HashMap<>();
    output.put("package/package.json", convertPackage(content.get("package/package.json")));

    for (Entry<String, byte[]> e : content.entrySet()) {
      if (!e.getKey().equals("package/package.json")) {
        byte[] cnv = e.getValue();
        try {
          JsonObject json = JsonTrackingParser.parseJson(e.getValue());
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
        indexer.start();
        indexers.put(n, indexer);
      }
      indexer.seeFile(s, b);
      if (!s.equals(".index.json") && !s.equals("package.json")) {
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

  private byte[] convertPackage(byte[] cnt) throws IOException {
    JsonObject json = JsonTrackingParser.parseJson(cnt);
    currentVersion = json.getAsJsonArray("fhirVersions").get(0).getAsString();
    String name = JsonUtilities.str(json, "name");
    json.remove("name");
    json.addProperty("name", name + "." + vCode);
    json.remove("fhirVersions");
    json.remove("dependencies");
    JsonArray fv = new JsonArray();
    json.add("fhirVersions", fv);
    fv.add(version);
    JsonObject dep = new JsonObject();
    json.add("dependencies", dep);
    dep.addProperty(VersionUtilities.packageForVersion(version), version);
    return JsonTrackingParser.write(json).getBytes(Charsets.UTF_8);
  }

  private byte[] convertResource(String n, byte[] cnt) {
    try {
      if (VersionUtilities.isR2Ver(currentVersion)) {
        org.hl7.fhir.dstu2.model.Resource res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_30.convertResource(VersionConvertorFactory_10_30.convertResource(res)));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_10_30.convertResource(res));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_10_40.convertResource(res));
        } else if (VersionUtilities.isR5Ver(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_10_50.convertResource(res));
        }
      } else if (VersionUtilities.isR2BVer(currentVersion)) {
        org.hl7.fhir.dstu2016may.model.Resource res = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_30.convertResource(VersionConvertorFactory_14_30.convertResource(res)));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_14_30.convertResource(res));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_14_40.convertResource(res));
        } else if (VersionUtilities.isR5Ver(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_14_50.convertResource(res));
        }
      } else if (VersionUtilities.isR3Ver(currentVersion)) {
        org.hl7.fhir.dstu3.model.Resource res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_30.convertResource(res));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_30.convertResource(res));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_30_40.convertResource(res));
        } else if (VersionUtilities.isR5Ver(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_30_50.convertResource(res));
        }
      } else if (VersionUtilities.isR4Ver(currentVersion)) {
        org.hl7.fhir.r4.model.Resource res = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_40.convertResource(res, new PR2Handler()));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_40.convertResource(res));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_30_40.convertResource(res, new BaseAdvisor_30_40(false)));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(res);
        } else if (VersionUtilities.isR5Ver(version)) {
          return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(VersionConvertorFactory_40_50.convertResource(res));
        }
      } else if (VersionUtilities.isR5Ver(currentVersion)) {
        org.hl7.fhir.r5.model.Resource res = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt);
        if (VersionUtilities.isR2Ver(version)) {
          return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(VersionConvertorFactory_10_50.convertResource(res));
        } else if (VersionUtilities.isR2BVer(version)) {
          return new org.hl7.fhir.dstu2016may.formats.JsonParser().composeBytes(VersionConvertorFactory_14_50.convertResource(res));
        } else if (VersionUtilities.isR3Ver(version)) {
          return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(VersionConvertorFactory_30_50.convertResource(res, new BaseAdvisor_30_50(false)));
        } else if (VersionUtilities.isR4Ver(version)) {
          return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(VersionConvertorFactory_40_50.convertResource(res));
        } else if (VersionUtilities.isR5Ver(version)) {
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

}