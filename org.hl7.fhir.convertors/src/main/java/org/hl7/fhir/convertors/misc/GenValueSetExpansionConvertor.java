package org.hl7.fhir.convertors.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.dstu2.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.ValueSet;

public class GenValueSetExpansionConvertor {

  public static void main(String[] args) throws FHIRFormatError, FileNotFoundException, IOException {
    String src = args[0];
    String tgt = args[1];
    Bundle bundle = (Bundle) new XmlParser().parse(new FileInputStream(src));
    for (BundleEntryComponent be : bundle.getEntry()) {
      Resource res = be.getResource();
      if (res != null) {
        String id = res.getId();
        if (Utilities.noString(id))
          id = tail(((ValueSet) res).getUrl());
        String dst = Utilities.path(tgt, res.fhirType()+"-"+id+".json");
        System.out.println(dst);
        new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(new FileOutputStream(dst), res);
      }
    }
  }

  private static String tail(String url) {
    return url.substring(url.lastIndexOf("/")+1);
  }

}
