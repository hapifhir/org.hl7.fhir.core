package org.hl7.fhir.dstu2.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.ValueSet;
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
          if (r instanceof ValueSet)
            r.setId(tail((ValueSet) r));
        }
        if (!StringUtils.isBlank(r.getId())) {
          String tgt = Utilities.path(folder, r.fhirType()+"-"+r.getId()+".json");
          new JsonParser().compose(new FileOutputStream(tgt), r);
        }
      }
    }
  }

  private static String tail(ValueSet r) {
    return r.getUrl().contains("/") ? r.getUrl().substring(r.getUrl().lastIndexOf("/")+1) : null;
  }

}
