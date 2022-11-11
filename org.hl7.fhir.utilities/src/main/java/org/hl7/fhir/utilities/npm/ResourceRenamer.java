package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.json.JsonUtilities;

import com.google.gson.JsonObject;

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
    JsonObject j = JsonTrackingParser.parseJson(f);
    for (JsonObject e : JsonUtilities.objects(j, "entry")) {
      JsonObject r = e.getAsJsonObject("resource");
      String rt = r.get("resourceType").getAsString();
      String id = r.get("id").getAsString();
      String nn = Utilities.path(Utilities.getDirectoryForFile(f.getAbsolutePath()), rt+"-"+id+".json");
      JsonTrackingParser.write(r, new File(nn), true); 
    } 
  }

  private void process(File dir) {
    
    for (File f : dir.listFiles()) {
      if (f.getName().endsWith(".json")) {
        try {
          JsonObject j = JsonTrackingParser.parseJson(f);
          String rt = j.get("resourceType").getAsString();
          String id = j.get("id").getAsString();
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
