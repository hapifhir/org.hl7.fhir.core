package org.hl7.fhir.convertors.misc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.ResourceMinifier;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

public class PackageMinifier {

  public static void main(String[] args) throws IOException {
    new PackageMinifier().process(args[0], args[1]);
  }

  private void process(String source, String target) throws FileNotFoundException, IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true);
    NpmPackage src = pcm.loadPackage(source);
    NpmPackage tgt = NpmPackage.empty();
    tgt.setNpm(src.getNpm().deepCopy());
    tgt.getNpm().set("name", tgt.getNpm().asString("name")+".min");
  
    ResourceMinifier min = new ResourceMinifier();
    for (PackageResourceInformation pri : src.listIndexedResources()) {
      if (min.isMinified(pri.getResourceType())) {
        Resource res = new JsonParser().parse(src.load(pri));
        if (min.minify(res)) {
          tgt.addFile("package", res.fhirType()+"-"+res.getIdPart()+".json", new JsonParser().composeBytes(res), null);
        }
      }
    }
    tgt.save(new FileOutputStream(target));
  }
  
}
