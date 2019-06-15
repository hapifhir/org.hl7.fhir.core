package org.hl7.fhir.r4.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Resource;

public class NarrativeRemover {

  public static void main(String[] args) {
    execute(new File(args[0]));

  }

  private static void execute(File folder) {
    for (File f : folder.listFiles()) {
      if (f.isDirectory())
        execute(f);
      else {
        System.out.println(f.getAbsolutePath());
        try {
          Resource r = new JsonParser().parse(new FileInputStream(f));
          if (r instanceof DomainResource) {
            DomainResource d = (DomainResource) r;
            d.setText(null);
            new JsonParser().compose(new FileOutputStream(f), d);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    
  }

}
