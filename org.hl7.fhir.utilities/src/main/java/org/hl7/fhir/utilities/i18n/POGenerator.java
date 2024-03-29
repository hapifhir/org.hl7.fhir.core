package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class POGenerator {

  public static void main(String[] args) throws IOException {
//    if (true) {
//      throw new Error("This needs to be rewritten for using existing .po files");
//    }
    new POGenerator().execute(args[0], Integer.valueOf(args[1]), args[2], args[3], args[4], args.length == 6 ? args[5] : null);
  }

  private void execute(String lang, int count, String dest, String source, String current, String altVersion) throws IOException {
    File dst = new File(dest);
    if (dst.exists()) {
      dst.delete();
    }
    Map<String, String> props = loadProperties(source);
    Map<String, String> curr = loadProperties(current);
    Map<String, String> past = loadProperties(altVersion);
    
    StringBuilder b = new StringBuilder();
    b.append("en -> "+lang+"\r\n");

    Set<String> plurals = new HashSet<>();
    
    for (String n : Utilities.sorted(curr.keySet())) {
      if (n.endsWith("_one") || n.endsWith("_other") || n.endsWith("_many")) {
        if (n.endsWith("_one")) {
          n = n.substring(0, n.length() - 4);
        } else if (n.endsWith("_other")) {
          n = n.substring(0, n.length() - 6);
        } else if (n.endsWith("_many")) {
          n = n.substring(0, n.length() - 5);
        }
        if (!plurals.contains(n)) {
          plurals.add(n);
          b.append("\r\n");
          String v1 = curr.get(n+"_one");
          String vO = curr.get(n+"_other");
          List<String> ll = new ArrayList<>();
          addToList(ll, props, n+"_one");
          addToList(ll, props, n+"_other");
          addToList(ll, props, n+"_many");
          String p1 = past == null ? null : past.get(n+"_one");
          String pO = past == null ? null : past.get(n+"_other");
          boolean changed = false;
          if (ll.size() > 0 && p1 != null) {
            if (!p1.equals(v1)) {
              changed = true;
              ll.set(0,  "!!"+ll.get(0));
            }
          }        
          if (ll.size() > 1 && pO != null) {
            if (!pO.equals(vO)) {
              changed = true;
              ll.set(1,  "!!"+ll.get(1));
              if (ll.size() == 3) {
                ll.set(2,  "!!"+ll.get(2));                
              }
            }
          }        
          b.append("#: "+n+"\r\n");
          if (changed) {
            b.append("#| one "+p1+"\r\n");
            b.append("#| plural "+pO+"\r\n");
          }
          b.append("msgid \""+v1+"\"\r\n");
          b.append("msgid_plural \""+vO+"\"\r\n");
          for (int i = 0; i < count; i++) {
            b.append("msgstr["+i+"] \""+(i < ll.size() ? ll.get(i) : "")+"\"\r\n");
          }
        }
      } else {
        b.append("\r\n");
        String v = curr.get(n);
        String l = props.get(n);
        String p = past == null ? null : past.get(n);
        boolean changed = false;
        if (l != null && p != null) {
          if (!p.equals(v)) {
            changed = true;
            l = "!!"+l;
          }
        }        
        b.append("#: "+n+"\r\n");
        if (changed) {
          b.append("#| "+p+"\r\n");
        }
        b.append("msgid \""+v+"\"\r\n");
        b.append("msgstr \""+(l == null ? "" : l)+"\"\r\n");
      }
    }
    TextFile.stringToFile(b.toString(), dst);
  }

  private void addToList(List<String> l, Map<String, String> props, String string) {
    // TODO Auto-generated method stub
    
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
