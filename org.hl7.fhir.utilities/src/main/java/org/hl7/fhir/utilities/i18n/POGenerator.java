package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.DebugUtilities;
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
    private boolean orphan = true;
    private boolean duplicate;
    private String id;
    private String msgid;
    private String oldMsgId;
    private String msgidPlural;
    private String comment;
    private List<String> msgstr  = new ArrayList<String>();
  }
  
  public static void main(String[] args) throws IOException {
    new POGenerator().execute(args[0]);
  }

  private List<String> prefixes = new ArrayList<>();

  private void execute(String source) throws IOException {
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(source, "source", "rendering-phrases-de.po"),    Utilities.path(source, "rendering-phrases_de.properties"), true);
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(source, "source", "rendering-phrases-es.po"),    Utilities.path(source, "rendering-phrases_es.properties"), false);
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(source, "source", "rendering-phrases-ja.po"),    Utilities.path(source, "rendering-phrases_ja.properties"), false);
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(source, "source", "rendering-phrases-nl.po"),    Utilities.path(source, "rendering-phrases_nl.properties"), false);
    generate(Utilities.path(source, "rendering-phrases.properties"), Utilities.path(source, "source", "rendering-phrases-pt-BR.po"), Utilities.path(source, "rendering-phrases_pt-BR.properties"), false);

    generate(Utilities.path(source, "Messages.properties"), Utilities.path(source, "source", "validator-messages-de.po"),    Utilities.path(source, "Messages_de.properties"), true);
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(source, "source", "validator-messages-es.po"),    Utilities.path(source, "Messages_es.properties"), false);
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(source, "source", "validator-messages-ja.po"),    Utilities.path(source, "Messages_ja.properties"), false);
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(source, "source", "validator-messages-nl.po"),    Utilities.path(source, "Messages_nl.properties"), false);
    generate(Utilities.path(source, "Messages.properties"), Utilities.path(source, "source", "validator-messages-pt-BR.po"), Utilities.path(source, "Messages_pt-BR.properties"), false);
    
  }

  private void generate(String source, String dest, String tgt, boolean firstRun) throws IOException {
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
        o.comment = name;
        objects.add(o);
        o.msgid = e.getValue();
      } else {
        update(o, mode, e.getValue());
      }
    }
    objects.removeIf(o -> o.orphan);
    Collections.sort(objects, new POObjectSorter());
    Map<String, Integer> sources = new HashMap<>();
    Set<String> dups = new HashSet<>();
    for (POObject o : objects) {
      if (sources.containsKey(o.msgid)) {
        Integer c = sources.get(o.msgid)+1;
        sources.put(o.msgid, c);
        dups.add(o.msgid);
//        System.out.println("Duplicate in "+dest.substring(dest.lastIndexOf("/")+1)+": "+o.msgid+" on ("+CommaSeparatedStringBuilder.join(",", listIds(objects, o.msgid))+")");
      } else {
        sources.put(o.msgid, 1);
      }
    }
    for (POObject o : objects) {
      Integer c = sources.get(o.msgid);
      if (c > 1) {
        o.duplicate = true;
      }
    }
    if (firstRun) {
      for (String s : Utilities.sorted(dups)) {
        String mid = null; 
        boolean first = true;
        for (POObject o : objects) {
          if (o.msgid.equals(s) && o.msgidPlural == null) {
            if (mid == null) {
              mid = o.id;
            } else {
              if (first) {
                System.out.println("");
                System.out.println("// "+s);
                System.out.println("rename(\"/Users/grahamegrieve/work/core\", \""+mid+"\", \""+mid+"\");");
                first = false;
              }
              System.out.println("replace(\"/Users/grahamegrieve/work/core\", \""+o.id+"\", \""+mid+"\");");      
            }
          }
        }
      }
    }
    savePOFile(dest, objects);
    savePropFile(tgt, objects);
  }

  private Set<String> listIds(List<POObject> objects, String msgid) {
    Set<String> res = new HashSet<>();
    for (POObject o : objects) {
      if (o.msgid.equals(msgid)) {
        res.add(o.id);
      }
    }
    return res;
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
      // for POEdit
      b.append("# "+o.comment+"\r\n");
      if (o.oldMsgId != null) {
        b.append("#| "+o.oldMsgId+"\r\n");        
      }
      if (o.duplicate) {
        b.append("msgctxt \""+o.id+"\"\r\n");        
      } 
      b.append("msgid \""+wrapQuotes(o.msgid)+"\"\r\n");
      if (o.msgidPlural != null) {
        b.append("msgid_plural \""+wrapQuotes(o.msgidPlural)+"\"\r\n"); 
        for (int i = 0; i < o.msgstr.size(); i++) {
          b.append("msgstr["+i+"] \""+wrapQuotes(o.msgstr.get(i))+"\"\r\n");
        }
      } else {
        if (o.msgstr.size() == 0) {
          b.append("msgstr \"\"\r\n");                  
        } else {
          b.append("msgstr \""+wrapQuotes(o.msgstr.get(0))+"\"\r\n");                            
        }
      } 
      b.append("\r\n");
    }
    TextFile.stringToFile(b.toString(), dest);
  }

  private String wrapQuotes(String s) {
    return s.replace("\"", "\\\"");
  }

  private void update(POObject o, int mode, String value) {
    o.orphan = false;
    if (o.comment == null) {
      o.comment = o.id;
    }
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
      if (!value.equals(o.msgidPlural)) {
        // the english string has changed, and the other language string is now out of date 
//        if (o.oldMsgId != null) {
//          o.oldMsgId = o.msgid;
//        }
        o.msgidPlural = value;
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
      } else if (line.startsWith("# ")) {
        obj.comment = line.substring(1).trim();
      } else if (line.startsWith("msgid ")) {
        obj.msgid = trimQuotes(line.substring(5).trim());
        if (obj.msgid.endsWith("("+obj.id+")")) {
          obj.msgid = obj.msgid.substring(0, obj.msgid.length() - (obj.id.length()+3));
        }
      } else if (line.startsWith("msgid_plural ")) {
        obj.msgidPlural = trimQuotes(line.substring(12).trim());
      } else if (line.startsWith("msgstr ")) {
        obj.msgstr.add(trimQuotes(line.substring(6).trim()));
      } else if (line.startsWith("msgctxt ")) {
        // ignore this
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
    return s.trim().replace("\\\"", "\"");
  }

  private List<StringPair> loadProperties(String source) throws IOException {
    List<StringPair> res = new ArrayList<>();
    File src = ManagedFileAccess.file(source);
    List<String> lines = Files.readAllLines(src.toPath());
    for (String line : lines) {
      if (!line.startsWith("#") && line.contains("=")) {
        String n = line.substring(0, line.indexOf("=")).trim();
        String v = line.substring(line.indexOf("=")+1).trim();
        if (!(v.length() == 3 && v.startsWith("{") && v.endsWith("}"))) {
          res.add(new StringPair(n, v));
        }
      } 
    }
    return res;
  }

  private void savePropFile(String tgt, List<POObject> objects) throws IOException {
    String nameLine = TextFile.fileToLines(tgt)[0];
    String[] parts = nameLine.substring(1).trim().split("\\=");
    String[] names = parts[1].split("\\,");
    
    StringBuilder b = new StringBuilder();
    b.append(nameLine+"\r\n");
    for (POObject o : objects) {
      if (o.msgidPlural == null) {
        b.append(o.id+" = "+(o.msgstr.size() > 0 ? o.msgstr.get(0) : "")+"\r\n");
      } else {
        for (int i = 0; i < names.length; i++) {
          b.append(o.id+"_"+names[i].trim()+" = "+(o.msgstr.size() > i ? o.msgstr.get(i) : "")+"\r\n");
        }
      }
    }
    
    TextFile.stringToFile(b.toString(), tgt);
    
    
  }

  
}
