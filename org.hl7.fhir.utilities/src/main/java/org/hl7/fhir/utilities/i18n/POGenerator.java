package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class POGenerator {

  public static void main(String[] args) throws IOException {
//    if (true) {
//      throw new Error("This needs to be rewritten for using existing .po files");
//    }
    new POGenerator().execute(args[0], args[1], args[2], args[3], args.length == 5 ? args[4] : null);
  }

  private void execute(String lang, String dest, String source, String current, String altVersion) throws IOException {
    File dst = new File(dest);
    if (dst.exists()) {
      dst.delete();
    }
    Map<String, String> props = loadProperties(source);
    Map<String, String> curr = loadProperties(current);
    Map<String, String> past = loadProperties(altVersion);
    
    StringBuilder b = new StringBuilder();
    b.append("en -> "+lang+"\r\n");
    
    for (String n : Utilities.sorted(curr.keySet())) {
      b.append("\r\n");
      String v = curr.get(n);
      String l = props.get(n);
      if (l != null && past != null) {
        String p = past.get(n);
        if (p != null && !p.equals(v)) {
          // it's changed
          l = "!!"+l;
        }
      }
      b.append("#: "+n+"\r\n");
      b.append("msgid \""+v+"\"\r\n");
      b.append("msgid \""+(l == null ? "" : l)+"\"\r\n");
    }
    TextFile.stringToFile(b.toString(), dst);
  }

  private Map<String, String> loadProperties(String source) throws IOException {
    if (source == null) {
      return null;
    }
    Map<String, String> res = new HashMap<>();
    File src = new File(source);
    List<String> lines = Files.readAllLines(src.toPath());
    for (String line : lines) {
      if (!line.startsWith("#") && line.contains("=")) {
        String n = line.substring(0, line.indexOf("=")).trim();
        String v = line.substring(line.indexOf("=")+1).trim();
        res.put(n,  v);
      }
    }
    return res;
  }

}
