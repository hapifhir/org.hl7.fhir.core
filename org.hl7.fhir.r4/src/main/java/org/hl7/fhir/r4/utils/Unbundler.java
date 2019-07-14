package org.hl7.fhir.r4.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.MetadataResource;
import org.hl7.fhir.r4.model.Resource;
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
        if (StringUtils.isBlank(r.getId())) {
          if (r instanceof MetadataResource)
            r.setId(tail((MetadataResource) r));
        }
        if (!StringUtils.isBlank(r.getId())) {
          String tgt = Utilities.path(folder, r.fhirType()+"-"+r.getId()+".json");
          if (!new File(tgt).exists())
            new JsonParser().compose(new FileOutputStream(tgt), r);
        }
      }
    }
  }

  private static String tail(MetadataResource r) {
    return r.getUrl().contains("/") ? r.getUrl().substring(r.getUrl().lastIndexOf("/")+1) : null;
  }
}
