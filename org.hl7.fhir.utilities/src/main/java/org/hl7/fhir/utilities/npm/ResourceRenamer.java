package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;


public class ResourceRenamer {

  public static void main(String[] args) throws IOException {
    new ResourceRenamer().processArg(new File(args[0]));
  }

  private void processArg(File file) throws IOException {
   if (file.isDirectory()) {
     process(file);
   } else {
     unbundle(file);
   }
  }

  private void unbundle(File f) throws IOException {
    JsonObject j = JsonParser.parseObject(f);
    for (JsonObject e : j.getJsonObjects("entry")) {
      JsonObject r = e.getJsonObject("resource");
      String rt = r.asString("resourceType");
      String id = r.asString("id");
      String nn = Utilities.path(Utilities.getDirectoryForFile(f.getAbsolutePath()), rt+"-"+id+".json");
      FileOutputStream fs = new FileOutputStream(nn);
      try {
        JsonParser.compose(r, fs, true);
      } finally {
        fs.close();
      }
    } 
  }

  private void process(File dir) {
    
    for (File f : dir.listFiles()) {
      if (f.getName().endsWith(".json")) {
        try {
          JsonObject j = JsonParser.parseObject(f);
          String rt = j.asString("resourceType");
          String id = j.asString("id");
          String nn = Utilities.path(Utilities.getDirectoryForFile(f.getAbsolutePath()), rt+"-"+id+".json");
          File nf = new File(nn);
          if (!nn.equals(f.getAbsolutePath())) {
            System.out.println("Rename "+f.getName()+" to "+nf.getName());
            f.renameTo(nf);
          }
        } catch (Exception e) {
          System.out.println("Error Processing "+f.getName()+" : "+e.getMessage());
        }
      }
    }
    
  }

}
