package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.DirectoryVisitor;
import org.hl7.fhir.utilities.filesystem.DirectoryVisitor.IDirectoryVisitorImplementation;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

/**
 * This class checks that all the i18n constants and declarations are consistent,
 * and then generates / updates the .po source files, and then updates the .properties files
 * 
 * It needs to be run whenever
 *   (a) New constants are added to the java code
 *   (b) An implementer contributes translations in a .po source file
 *   
 * It takes 3 parameters:
 *   * path to the local copy of the core repo
 *   * path to the local copy of the ig-publisher repo
 *   * path to the local copy of the fhirserver repo
 */
public class POGenerator {

  public class PropertyValue extends StringPair {
    private boolean used;
    
    public PropertyValue(String name, String value) {
      super(name, value);
      // TODO Auto-generated constructor stub
    }

    public String getBaseName() {
      String res = getName();
      if (res.endsWith("_one")) {
        res = res.substring(0, res.length()-4);
      } else if (res.endsWith("_other")) {
        res = res.substring(0, res.length()-6);
      }
      return res;
    }

  }

  public class ConstantDefinition {
    private String name;
    private String sname;
    private boolean defined;
    private boolean used;
  }

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
    new POGenerator().execute(args[0], args[1], args[2]);
  }

  private List<String> prefixes = new ArrayList<>();
  private int noTrans = 0;

  private void execute(String core, String igpub, String pascal) throws IOException {
    String source = Utilities.path(core, "/org.hl7.fhir.utilities/src/main/resources");
    if (checkState(source, core, igpub, pascal)) {
      generate(source, "rendering-phrases.properties",  "rendering-phrases-en.po",       null, 2);
      generate(source, "rendering-phrases.properties",  "rendering-phrases-de.po",    "rendering-phrases_de.properties", 2);
      generate(source, "rendering-phrases.properties",  "rendering-phrases-es.po",    "rendering-phrases_es.properties", 3);
      generate(source, "rendering-phrases.properties",  "rendering-phrases-ja.po",    "rendering-phrases_ja.properties", 2);
      generate(source, "rendering-phrases.properties",  "rendering-phrases-fr.po",    "rendering-phrases_fr.properties", 2);
      generate(source, "rendering-phrases.properties",  "rendering-phrases-nl.po",    "rendering-phrases_nl.properties", 2);
      generate(source, "rendering-phrases.properties",  "rendering-phrases-pt_BR.po", "rendering-phrases_pt-BR.properties", 2);

      generate(source, "Messages.properties", "validator-messages-en.po",    null, 2);
      generate(source, "Messages.properties", "validator-messages-de.po",    "Messages_de.properties", 2);
      generate(source, "Messages.properties", "validator-messages-es.po",    "Messages_es.properties", 3);
      generate(source, "Messages.properties", "validator-messages-ja.po",    "Messages_ja.properties", 2);
      generate(source, "Messages.properties", "validator-messages-fr.po",    "Messages_fr.properties", 2);
      generate(source, "Messages.properties", "validator-messages-nl.po",    "Messages_nl.properties", 2);
      generate(source, "Messages.properties", "validator-messages-pt_BR.po", "Messages_pt-BR.properties", 2);

      System.out.println("Finished");
    } 
  }

  private boolean checkState(String source, String core, String igpub, String pascal) throws IOException {
    System.out.println("Checking...");
    List<PropertyValue> props = loadProperties(Utilities.path(source, "rendering-phrases.properties"), true);
    List<ConstantDefinition> consts = loadConstants(Utilities.path(core, "/org.hl7.fhir.utilities/src/main/java/org/hl7/fhir/utilities/i18n/RenderingI18nContext.java"));
    boolean ok = true;
    for (ConstantDefinition cd : consts) {
      boolean found = false;
      for (PropertyValue p : props) {
        String pn = p.getBaseName();        
        if (pn.equals(cd.sname) || p.getName().equals(cd.sname)) {
          found = true;
          p.used = true;
        }
      }
      cd.defined = found;
    }
    scanJavaSource(core, consts, "RenderingI18nContext", "RenderingContext");
    scanJavaSource(igpub, consts, "RenderingI18nContext", "RenderingContext");
    scanPascalSource(pascal, props);
    
    Set<String> pns = new HashSet<>();
    for (PropertyValue p : props) {
      if (!p.used) {
        ok = false;
        System.out.println("Error: PV "+p.getName()+ " provided but not used");   
      }
      if (!pns.contains(p.getName())) {
        pns.add(p.getName());
      } else {
        System.out.println("Error: PV "+p.getName()+ " duplicated");
      }
      if (p.getValue().contains("\\n")) {
        System.out.println("Error: PV "+p.getName()+ " has a \\n");
      }
    }
    
    for (ConstantDefinition cd : consts) {
      if (!cd.defined && !cd.used) {
        System.out.println("Error: "+cd.name+ " not defined or used");        
        ok = false;
      } else if (!cd.defined) {
        ok = false;
        System.out.println("Error: msg for "+cd.name+ " not found at "+cd.sname);
      } else if (!cd.used) {
        System.out.println("Warning: const "+cd.name+ " not used");
        ok = false;
      }
    }

    props = loadProperties(Utilities.path(source, "Messages.properties"), true);
    consts = loadConstants(Utilities.path(core, "/org.hl7.fhir.utilities/src/main/java/org/hl7/fhir/utilities/i18n/I18nConstants.java"));
    for (ConstantDefinition cd : consts) {
      boolean found = false;
      for (PropertyValue p : props) {
        String pn = p.getBaseName();
        if (pn.equals(cd.sname) || p.getName().equals(cd.sname)) {
          found = true;
          p.used = true;
        }
      }
      cd.defined = found;
    }

    scanJavaSource(core, consts, "I18nConstants");
    scanJavaSource(igpub, consts, "I18nConstants");
    scanPascalSource(pascal, props);

    pns = new HashSet<>();
    for (PropertyValue p : props) {
      if (!p.used) {
        ok = false;
        System.out.println("Error: PV "+p.getName()+ " provided but not used");   
      }
      if (!pns.contains(p.getName())) {
        pns.add(p.getName());
      } else {
        System.out.println("Error: PV "+p.getName()+ " duplicated");
      }      
      if (p.getValue().contains("\\n")) {
        System.out.println("Error: PV "+p.getName()+ " has a \\n");
      }

    }
    
    for (ConstantDefinition cd : consts) {
      if (!cd.defined && !cd.used) {
        System.out.println("Error: "+cd.name+ " not defined or used");        
        ok = false;
      } else if (!cd.defined) {
        ok = false;
        System.out.println("Error: msg for "+cd.name+ " not found @ "+cd.sname);
      } else if (!cd.used) {
        System.out.println("Warning: const "+cd.name+ " not used");
        ok = false;
      }
    }
    if (ok) {
      System.out.println("No Errors Found");
    } else {
      System.out.println("Errors Found, so not continuing");  
    }

    return ok;
  }

  private class JavaScanner implements IDirectoryVisitorImplementation {
    List<ConstantDefinition> consts;
    List<String> names;
    
    @Override
    public boolean enterDirectory(File f) throws IOException {
      return !Utilities.existsInList(f.getName(), "model", "formats");
    }

    @Override
    public boolean visitFile(File file) throws IOException {
      String source = TextFile.fileToString(file);
      for (ConstantDefinition cd : consts) {
        if (!cd.used) {
          boolean found = false;
          for (String n : names) {
            if (source.contains(n+"."+cd.name+",")) {
              found = true;
            } 
            if (source.contains(n+"."+cd.name+")")) {
              found = true;
            } 
            if (source.contains(n+"."+cd.name+" :")) {
              found = true;
            } 
            if (source.contains(n+"."+cd.name+";")) {
              found = true;
            } 
          } 
          if (found) {
            cd.used = true;
          }
        }  
      }
      return true;
    }
  }
  
  private void scanJavaSource(String path, List<ConstantDefinition> consts, String... names) throws FileNotFoundException, IOException {
    JavaScanner scanner = new JavaScanner();
    scanner.consts = consts;
    scanner.names = new ArrayList<String>();
    for (String s : names) {
      scanner.names.add(s);
    }
    DirectoryVisitor.visitDirectory(scanner, path, "java");
  }

  private class PascalScanner implements IDirectoryVisitorImplementation {
    private List<PropertyValue> defs;
    
    @Override
    public boolean enterDirectory(File directory) throws IOException {
      return true;
    }

    @Override
    public boolean visitFile(File file) throws IOException {
      String source = TextFile.fileToString(file);
      for (PropertyValue pv : defs) {
        if (!pv.used) {
          boolean found = false;
          String pn = pv.getBaseName();
          if (source.contains("'"+pn+"'")) {
            found = true;
          } 
          if (found) {
            pv.used = true;
          }
        }
      }
      return true;
    }
  }
  
  private void scanPascalSource(String path, List<PropertyValue> defs) throws FileNotFoundException, IOException {
    PascalScanner scanner = new PascalScanner();
    scanner.defs = defs;
    DirectoryVisitor.visitDirectory(scanner, path, "pas");
  }

  
  private List<ConstantDefinition> loadConstants(String path) throws FileNotFoundException, IOException {
    List<ConstantDefinition> res = new ArrayList<POGenerator.ConstantDefinition>();
    for (String line : TextFile.fileToLines(path)) {
      if (line.contains("public static final String") && !line.trim().startsWith("//")) {
        int i = line.indexOf("public static final String") + "public static final String".length();
        String[] p = line.substring(i).split("\\=");
        if (p.length == 2) {
          String n = p[0].trim();
          String v = p[1].trim().replace("\"", "").replace(";", "");
          ConstantDefinition cd = new ConstantDefinition();
          cd.name = n;
          cd.sname = v;
          res.add(cd);
        }
      }
    }
    return res;
  }

  private void generate(String source, String src, String dest, String tgt, int count) throws IOException {
    // load the destination file 
    // load the source file 
    // update the destination object set for changes from the source file
    // save the destination file 
    String fn = Utilities.path(source, "source", dest);
    List<POObject> objects;
    if (new File(fn).exists()) {
      objects = loadPOFile(fn);
    } else {
      objects = new ArrayList<POGenerator.POObject>();
    }
    List<PropertyValue> props = loadProperties(Utilities.path(source, src), false);
    for (PropertyValue e : props) {
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
        o.orphan = false;
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
    savePOFile(Utilities.path(source, "source", dest), objects, count, false);
    if (tgt == null) {
      savePOFile(Utilities.path(source, "source", "transifex", dest), objects, count, true);
    } else {
      savePOFile(Utilities.path(source, "source", "transifex", "translations", dest), objects, count, true);
    }
    if (tgt != null) {
      savePropFile(Utilities.path(source, tgt), objects);
    }
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

  private void savePOFile(String dest, List<POObject> objects, int count, boolean tfxMode) throws IOException {
    prefixes.clear();
    
    StringBuilder b = new StringBuilder();
    for (String p : prefixes) {
      b.append(p);
      b.append("\r\n");
    }
    b.append("\r\n");
    for (POObject o : objects) {
      // for POEdit
      if (o.oldMsgId != null) {
        b.append("# "+o.comment+" (!!when last translated was: "+o.oldMsgId+")\r\n");        
      } else {
        b.append("# "+o.comment+"\r\n");
      }
      b.append("#: "+o.id+"\r\n");
      if (o.duplicate) {
        b.append("msgctxt \""+o.id+"\"\r\n");        
      } 
      String m = tfxMode && Utilities.noString(o.msgid) ? "-- no content: do not translate #"+(++noTrans )+" --" : o.msgid; 
      b.append("msgid \""+wrapQuotes(m)+"\"\r\n");
      if (o.msgidPlural != null) {
        b.append("msgid_plural \""+wrapQuotes(o.msgidPlural)+"\"\r\n"); 
        while (o.msgstr.size() < count) {
          o.msgstr.add("");
        }
        for (int i = 0; i < o.msgstr.size(); i++) {
          String s = o.msgstr.get(i);
//          if (tfxMode && Utilities.noString(s)) {
//            s = Utilities.noString(i == 0 ? o.msgid : o.msgidPlural) ? "-- no content: do not translate --" : "";
//          }
          b.append("msgstr["+i+"] \""+wrapQuotes(s)+"\"\r\n");
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
        o.oldMsgId = null;
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
        o.oldMsgId = null;
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
        o.oldMsgId = null;
      }
    }
  }

  private POObject findObject(List<POObject> objects, String name) {
    for (POObject t : objects) {
      if (t.id != null && t.id.equals(name)) {
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
        if (obj == null || obj.id != null) {
          obj = new POObject();
          list.add(obj);
        }
        obj.id = line.substring(2).trim();  
      } else if (line.startsWith("# ")) {
        if (obj == null || obj.comment != null) {
          obj = new POObject();
          list.add(obj);
        }
        obj.comment = line.substring(1).trim();
        if (obj.comment.contains("!!when")) {
          obj.oldMsgId = obj.comment.substring(obj.comment.indexOf("!!when"));
          obj.comment = obj.comment.substring(0, obj.comment.indexOf("!!when")-1);
          obj.oldMsgId = obj.oldMsgId.substring(obj.oldMsgId.indexOf(": ")+2).trim();
          obj.oldMsgId = obj.oldMsgId.substring(0, obj.oldMsgId.length()-1);
        }
      } else if (obj == null) {
        prefixes.add(line);  
      } else if (line.startsWith("#|")) {
        // retired use of #| because it caused problems with the tools
        obj.oldMsgId = line.substring(2).trim();
        if (obj.oldMsgId.startsWith("msgid ")) {
          obj.oldMsgId = trimQuotes(obj.oldMsgId.substring(6));
        }
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
        while (s.startsWith("!!")) {
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
    s = s.trim();
    if (s.startsWith("\"")) {
      s = s.substring(1);
    }
    if (s.endsWith("\"")) {
      s = s.substring(0, s.length()-1);
    }
    return s.trim().replace("\\\"", "\"");
  }

  private List<PropertyValue> loadProperties(String source, boolean checking) throws IOException {
    List<PropertyValue> res = new ArrayList<>();
    File src = ManagedFileAccess.file(source);
    List<String> lines = Files.readAllLines(src.toPath());
    for (String line : lines) {
      if (!line.startsWith("#") && line.contains("=")) {
        String n = line.substring(0, line.indexOf("=")).trim();
        String v = line.substring(line.indexOf("=")+1).trim();
        if (checking || !(v.length() == 3 && v.startsWith("{") && v.endsWith("}"))) {
          res.add(new PropertyValue(n, v));
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
        String v= o.msgstr.size() > 0 ? o.msgstr.get(0) : "";
        if (!Utilities.noString(v)) {
          b.append(o.id+" = "+v+"\r\n");
        }
      } else {
        for (int i = 0; i < names.length; i++) {
          String v = (o.msgstr.size() > i ? o.msgstr.get(i) : "");
          if (!Utilities.noString(v)) {
            b.append(o.id+"_"+names[i].trim()+" = "+v+"\r\n");
          }
        }
      }
    }
    
    TextFile.stringToFile(b.toString(), tgt);
  }

  
}
