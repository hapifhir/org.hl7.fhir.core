package org.hl7.fhir.validation.packages;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageClient;
import org.hl7.fhir.utilities.npm.PackageInfo;
import org.hl7.fhir.utilities.npm.PackageServer;

@Slf4j
public class PackageValidator {

  public static void main(String[] args) throws IOException {
    new PackageValidator().execute();
  }

  private void execute() throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    
    PackageClient pc = new PackageClient(PackageServer.primaryServer());
    for (PackageInfo t : pc.search(null, null, null, false, null)) {
      log.info("Check Package "+t.getId());
      List<PackageInfo> vl = pc.getVersions(t.getId());
      PackageInfo v = vl.get(vl.size()-1);
      log.info(" v"+v.getVersion());
      try {
        NpmPackage pi = pcm.loadPackage(v.getId(), v.getVersion());        
        if (VersionUtilities.isR4Ver(pi.fhirVersion()) || VersionUtilities.isR3Ver(pi.fhirVersion()) || VersionUtilities.isR2Ver(pi.fhirVersion())) {
          for (String n : pi.list("package")) {
            if (n.endsWith(".json") && !n.equals("ig-r4.json") && !n.equals("ig-r4.jsonX")) {
              InputStream s = pi.load("package", n);
              try {
                parseResource(s, pi.fhirVersion());
              } catch (Exception e) {
                log.info("  error parsing "+n+" for "+pi.fhirVersion()+": "+e.getMessage());
              }
            }
          }
        } else {
          log.info("  Unsupported FHIR version "+pi.fhirVersion());
        }
      } catch (Exception e) {
        log.info("  Error - no FHIR version");
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
