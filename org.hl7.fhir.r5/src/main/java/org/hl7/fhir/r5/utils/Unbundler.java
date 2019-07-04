package org.hl7.fhir.r5.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.Utilities;

public class Unbundler {

  public static void main(String[] args) throws Exception {
    unbundle(args[0]);
  }

  private static void unbundle(String src) throws FHIRFormatError, FileNotFoundException, IOException {
    String folder = Utilities.getDirectoryForFile(src);
    Bundle bnd = (Bundle) new JsonParser().parse(new FileInputStream(src));
    for (BundleEntryComponent be : bnd.getEntry()) {
      Resource r = be.getResource();
      if (r != null) {
        String tgt = Utilities.path(folder, r.fhirType()+"-"+r.getId()+".json");
        new JsonParser().compose(new FileOutputStream(tgt), r);
      }
    }
  }

}
