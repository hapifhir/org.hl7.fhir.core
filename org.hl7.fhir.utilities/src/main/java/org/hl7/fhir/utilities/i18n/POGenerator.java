package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class POGenerator {

  public class POObjectSorter implements Comparator<POObject> {

    @Override
    public int compare(POObject o1, POObject o2) {
      return o1.id.compareTo(o2.id);
    }

  }

  private class POObject {
    private String id;
    private String msgid;
    private String oldMsgId;
    private String msgidPlural;
    private List<String> msgstr  = new ArrayList<String>();
  }

  public static void main(String[] args) throws IOException {
    new POGenerator().execute(args[0], args[1]);
  }

  private List<String> prefixes = new ArrayList<>();

  private void execute(String source, String dest) throws IOException {
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(dest, "rendering-phrases-de.po"));
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(dest, "rendering-phrases-es.po"));
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(dest, "rendering-phrases-ja.po"));
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(dest, "rendering-phrases-nl.po"));

    generate(Utilities.path(source, "Messages.properties"), Utilities.path(dest, "validator-messages-de.po"));
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(dest, "validator-messages-es.po"));
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(dest, "validator-messages-ja.po"));
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(dest, "validator-messages-nl.po"));
  }

  private void generate(String source, String dest) throws IOException {
    // load the destination file 
    // load the source file 
    // update the destination object set for changes from the source file
    // save the destination file 
    List<POObject> objects = loadPOFile(dest);
    List<StringPair> props = loadProperties(source);
    for (StringPair e : props) {
      String name = e.getName();
      int mode = 0;
      if (name.endsWith("_one")) {
        mode = 1;
        name = name.substring(0, name.length() - 4);
      } else if (name.endsWith("_other")) {
        mode = 2;
        name = name.substring(0, name.length() - 6);
      } 

      POObject o = findObject(objects, name);
      if (o == null) {
        if (mode > 1) {
          throw new Error("Not right");
        }
        o = new POObject();
        o.id = name;
        objects.add(o);
        o.msgid = e.getValue();
      } else {
        update(o, mode, e.getValue());
      }
    }
    Collections.sort(objects, new POObjectSorter());
    savePOFile(dest, objects);

    //    File dst = ManagedFileAccess.file(dest);
    //    if (dst.exists()) {
    //      dst.delete();
    //    }
    //    Map<String, String> props = loadProperties(source);
    //    Map<String, String> curr = loadProperties(current);
    //    Map<String, String> past = loadProperties(altVersion);
    //    
    //    StringBuilder b = new StringBuilder();
    //    b.append("en -> "+lang+"\r\n");
    //
    //    Set<String> plurals = new HashSet<>();
    //    
    //    for (String n : Utilities.sorted(curr.keySet())) {
    //      if (n.endsWith("_one") || n.endsWith("_other") || n.endsWith("_many")) {
    //        if (n.endsWith("_one")) {
    //          n = n.substring(0, n.length() - 4);
    //        } else if (n.endsWith("_other")) {
    //          n = n.substring(0, n.length() - 6);
    //        } else if (n.endsWith("_many")) {
    //          n = n.substring(0, n.length() - 5);
    //        }
    //        if (!plurals.contains(n)) {
    //          plurals.add(n);
    //          b.append("\r\n");
    //          String v1 = curr.get(n+"_one");
    //          String vO = curr.get(n+"_other");
    //          List<String> ll = new ArrayList<>();
    //          addToList(ll, props, n+"_one");
    //          addToList(ll, props, n+"_other");
    //          addToList(ll, props, n+"_many");
    //          String p1 = past == null ? null : past.get(n+"_one");
    //          String pO = past == null ? null : past.get(n+"_other");
    //          boolean changed = false;
    //          if (ll.size() > 0 && p1 != null) {
    //            if (!p1.equals(v1)) {
    //              changed = true;
    //              ll.set(0,  "!!"+ll.get(0));
    //            }
    //          }        
    //          if (ll.size() > 1 && pO != null) {
    //            if (!pO.equals(vO)) {
    //              changed = true;
    //              ll.set(1,  "!!"+ll.get(1));
    //              if (ll.size() == 3) {
    //                ll.set(2,  "!!"+ll.get(2));                
    //              }
    //            }
    //          }        
    //          b.append("#: "+n+"\r\n");
    //          if (changed) {
    //            b.append("#| one "+p1+"\r\n");
    //            b.append("#| plural "+pO+"\r\n");
    //          }
    //          b.append("msgid \""+v1+"\"\r\n");
    //          b.append("msgid_plural \""+vO+"\"\r\n");
    //          for (int i = 0; i < count; i++) {
    //            b.append("msgstr["+i+"] \""+(i < ll.size() ? ll.get(i) : "")+"\"\r\n");
    //          }
    //        }
    //      } else {
    //        b.append("\r\n");
    //        String v = curr.get(n);
    //        String l = props.get(n);
    //        String p = past == null ? null : past.get(n);
    //        boolean changed = false;
    //        if (l != null && p != null) {
    //          if (!p.equals(v)) {
    //            changed = true;
    //            l = "!!"+l;
    //          }
    //        }        
    //        b.append("#: "+n+"\r\n");
    //        if (changed) {
    //          b.append("#| "+p+"\r\n");
    //        }
    //        b.append("msgid \""+v+"\"\r\n");
    //        b.append("msgstr \""+(l == null ? "" : l)+"\"\r\n");
    //      }
    //    }
    //    TextFile.stringToFile(b.toString(), dst);
  }

  private void savePOFile(String dest, List<POObject> objects) throws IOException {
    prefixes.clear();
    
    StringBuilder b = new StringBuilder();
    for (String p : prefixes) {
      b.append(p);
      b.append("\r\n");
    }
    b.append("\r\n");
    for (POObject o : objects) {
      b.append("#: "+o.id+"\r\n");
      if (o.oldMsgId != null) {
        b.append("#| "+o.oldMsgId+"\r\n");        
      }
      b.append("msgid \""+o.msgid+"\"\r\n");
      if (o.msgidPlural != null) {
        b.append("msgid_plural \""+o.msgidPlural+"\"\r\n"); 
        for (int i = 0; i < o.msgstr.size(); i++) {
          b.append("msgstr["+i+"] \""+o.msgstr.get(i)+"\"\r\n");
        }
      } else {
        if (o.msgstr.size() == 0) {
          b.append("msgstr \"\"\r\n");                  
        } else {
          b.append("msgstr \""+o.msgstr.get(0)+"\"\r\n");                            
        }
      } 
      b.append("\r\n");
    }
    TextFile.stringToFile(b.toString(), dest);
  }

  private void update(POObject o, int mode, String value) {
    if (mode == 0) {
      if (!value.equals(o.msgid)) {
        // the english string has changed, and the other language string is now out of date
        if (o.oldMsgId != null && !o.msgstr.isEmpty()) {
          o.oldMsgId = o.msgid;
        }
        o.msgid = value;
        for (int i = 0; i < o.msgstr.size(); i++) {
          if (!Utilities.noString(o.msgstr.get(i))) {
            o.msgstr.set(i, "!!"+o.msgstr.get(i));
          }
        }
      } else {
        // we don't care; nothing to do 
      }
    } else if (mode == 1) {
      if (!value.equals(o.msgid)) {
        // the english string has changed, and the other language string is now out of date 
        if (o.oldMsgId != null && !o.msgstr.isEmpty()) {
          o.oldMsgId = o.msgid;
        }
        o.msgid = value;
        if (o.msgstr.size() > 0 && !Utilities.noString(o.msgstr.get(0))) {
          o.msgstr.set(0, "!!"+o.msgstr.get(0));
        }
      } else {
        // we don't care; nothing to do 
      }
    } else if (mode == 2) {
      if (!value.equals(o.msgid)) {
        // the english string has changed, and the other language string is now out of date 
//        if (o.oldMsgId != null) {
//          o.oldMsgId = o.msgid;
//        }
        o.msgid = value;
        if (o.msgstr.size() > 1 && !Utilities.noString(o.msgstr.get(1))) {
          o.msgstr.set(1, "!!"+o.msgstr.get(1));
        }
      } else {
        // we don't care; nothing to do 
      }
    }
  }

  private POObject findObject(List<POObject> objects, String name) {
    for (POObject t : objects) {
      if (t.id.equals(name)) {
        return t;
      }
    }
    return null;
  }

  private List<POObject> loadPOFile(String dest) throws FileNotFoundException, IOException {
    List<POObject> list = new ArrayList<POGenerator.POObject>();
    POObject obj = null;
    for (String line : TextFile.fileToLines(dest)) {
      if (Utilities.noString(line)) {
        // else 
      } else if (line.startsWith("#:")) {
        obj = new POObject();
        obj.id = line.substring(2).trim();
        list.add(obj);
      } else if (obj == null) {
        prefixes.add(line);  
      } else if (line.startsWith("#|")) {
        obj.oldMsgId = line.substring(2).trim();
      } else if (line.startsWith("msgid ")) {
        obj.msgid = trimQuotes(line.substring(5).trim());
      } else if (line.startsWith("msgid_plural ")) {
        obj.msgidPlural = trimQuotes(line.substring(12).trim());
      } else if (line.startsWith("msgstr ")) {
        obj.msgstr.add(trimQuotes(line.substring(6).trim()));
      } else if (line.startsWith("msgstr[")) {
        String s = line.substring(7);
        int i = s.indexOf("]");
        int c = Integer.valueOf(s.substring(0, i));
        s = trimQuotes(s.substring(i+1).trim());
        if (s.startsWith("!!")) {
          s = s.substring(2);
        }
        if (c != obj.msgstr.size()) {
          System.out.println("index issue");   
        } else { // if (!Utilities.noString(s)) {
          obj.msgstr.add(s);          
        }
      } else {
        System.out.println("unknown line: "+line);          
      }
    }
    return list;
  }

  private String trimQuotes(String s) {
    if (s.startsWith("\"")) {
      s = s.substring(1);
    }
    if (s.endsWith("\"")) {
      s = s.substring(0, s.length()-1);
    }
    return s.trim();
  }

  private List<StringPair> loadProperties(String source) throws IOException {
    List<StringPair> res = new ArrayList<>();
    File src = ManagedFileAccess.file(source);
    List<String> lines = Files.readAllLines(src.toPath());
    for (String line : lines) {
      if (!line.startsWith("#") && line.contains("=")) {
        String n = line.substring(0, line.indexOf("=")).trim();
        String v = line.substring(line.indexOf("=")+1).trim();
        res.add(new StringPair(n, v));
      }
    }
    return res;
  }

}
