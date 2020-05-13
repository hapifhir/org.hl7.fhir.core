package org.hl7.fhir.validation.packages;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.PackageClient;
import org.hl7.fhir.utilities.cache.PackageClient.PackageInfo;
import org.xml.sax.InputSource;
import org.hl7.fhir.utilities.cache.ToolsVersion;

public class PackageValidator {

  public static void main(String[] args) throws IOException {
    new PackageValidator().execute();
  }

  private void execute() throws IOException {
    PackageCacheManager pcm = new  PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    
    PackageClient pc = new PackageClient(PackageCacheManager.PRIMARY_SERVER);
    for (PackageInfo t : pc.search(null, null, null, false)) {
      System.out.println("Check Package "+t.getId());
      List<PackageInfo> vl = pc.getVersions(t.getId());
      PackageInfo v = vl.get(vl.size()-1);
      System.out.println(" v"+v.getVersion());
      try {
        NpmPackage pi = pcm.loadPackage(v.getId(), v.getVersion());        
        if (VersionUtilities.isR4Ver(pi.fhirVersion()) || VersionUtilities.isR3Ver(pi.fhirVersion()) || VersionUtilities.isR2Ver(pi.fhirVersion())) {
          for (String n : pi.list("package")) {
            if (n.endsWith(".json") && !n.equals("ig-r4.json")) {
              InputStream s = pi.load("package", n);
              try {
                parseResource(s, pi.fhirVersion());
              } catch (Exception e) {
                System.out.println("  error parsing "+n+" for "+pi.fhirVersion()+": "+e.getMessage());
              }
            }
          }
        } else {
          System.out.println("  Unsupported FHIR version "+pi.fhirVersion());
        }
      } catch (Exception e) {
        System.out.println("  Error - no FHIR version");
      }
    }
  }

  private Object parseResource(InputStream s, String fhirVersion) throws FHIRFormatError, IOException {
    if (VersionUtilities.isR4Ver((fhirVersion))) {
      return new org.hl7.fhir.r4.formats.JsonParser().parse(s);
    }
    if (VersionUtilities.isR3Ver((fhirVersion))) {
      return new org.hl7.fhir.dstu3.formats.JsonParser().parse(s);
    }
    if (VersionUtilities.isR2Ver((fhirVersion))) {
      return new org.hl7.fhir.dstu2.formats.JsonParser().parse(s);
    }
    throw new FHIRException("Unknown version "+fhirVersion);
  }
}
