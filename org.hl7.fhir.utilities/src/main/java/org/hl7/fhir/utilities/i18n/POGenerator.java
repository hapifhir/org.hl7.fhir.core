package org.hl7.fhir.utilities.i18n;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.DirectoryVisitor;
import org.hl7.fhir.utilities.filesystem.DirectoryVisitor.IDirectoryVisitorImplementation;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import static org.hl7.fhir.utilities.i18n.POUtilities.isOutdated;
import static org.hl7.fhir.utilities.i18n.POUtilities.tagAsOutdated;


/**
 * This class checks that all the i18n constants and declarations are consistent,
 * and then generates / updates the .po source files, and then updates the .properties files
 * <br/>
 * It needs to be run whenever
 *   (a) New constants are added to the java code
 *   (b) An implementer contributes translations in a .po source file
 * <br/>
 * It takes 3 parameters:
 *   * path to the local copy of the core repo
 *   * path to the local copy of the ig-publisher repo
 *   * path to the local copy of the fhirserver repo
 */
@SuppressWarnings("checkstyle:systemout")
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
      return o1.getId().compareTo(o2.getId());
    }
  }

  public static void main(String[] args) throws IOException {
    new POGenerator().execute(args[0], args[1], args[2]);
  }

  private int noTrans = 0;

  public void execute(String core, String igpub, String pascal) throws IOException {
    String source = Utilities.path(core, "/org.hl7.fhir.utilities/src/main/resources");
    if (checkState(source, core, igpub, pascal)) {
      IniFile ini = new IniFile(Utilities.path(source, "translations-control.ini"));
      generate(source, "rendering-phrases.properties",  "rendering-phrases-en.po",       null, 2);
      generate(source, "Messages.properties", "validator-messages-en.po",    null, 2);
      for (String name : ini.getProperties("languages").keySet()) {
        generate(source, "rendering-phrases.properties",  "rendering-phrases-"+name+".po",    "rendering-phrases_"+name+".properties", ini.getIntegerProperty("languages", name));
        generate(source, "Messages.properties", "validator-messages-"+name+".po",    "Messages_"+name+".properties", ini.getIntegerProperty("languages", name));        
      }

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
        // ok = false;
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
        // ok = false;
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
      String source = FileUtilities.fileToString(file);
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
      String source = FileUtilities.fileToString(file);
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
    for (String line : FileUtilities.fileToLines(path)) {
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

  enum PluralMode {
    NONE, ONE, OTHER
  }

  private void generate(String sourceDirectory, String propertiesFileName, String poFileName, String targetPropertiesFileName, int count) throws IOException {
    // load the destination file 
    // load the source file 
    // update the destination object set for changes from the source file
    // save the destination file 
    String poFilePath = Utilities.path(sourceDirectory, "source", poFileName);
    POSource poObjects;
    if (ManagedFileAccess.file(poFilePath).exists()) {
      poObjects = POSource.loadPOFile(poFilePath);
    } else {
      poObjects = new POSource();
    }
    List<PropertyValue> javaProperties = loadProperties(Utilities.path(sourceDirectory, propertiesFileName), false);
    for (PropertyValue javaProperty : javaProperties) {
      String name = javaProperty.getName();
      PluralMode pluralMode = PluralMode.NONE;
      if (name.endsWith("_one")) {
        pluralMode = PluralMode.ONE;
        name = name.substring(0, name.length() - 4);
      } else if (name.endsWith("_other")) {
        pluralMode = PluralMode.OTHER;
        name = name.substring(0, name.length() - 6);
      } 

      POObject poObject = findObject(poObjects.getPOObjects(), name);
      if (poObject == null) {
        if (pluralMode == PluralMode.OTHER) {
          throw new Error("Not right");
        }
        poObject = new POObject();
        poObject.setId(name);
        poObject.setComment(name);
        poObjects.getPOObjects().add(poObject);
        poObject.setMsgid(javaProperty.getValue());
        poObject.setOrphan(false);
      } else {
        updatePOObject(poObject, pluralMode, javaProperty.getValue());
      }
    }
    poObjects.getPOObjects().removeIf(o -> o.isOrphan());
    Collections.sort(poObjects.getPOObjects(), new POObjectSorter());
    markDuplicatePOObjects(poObjects);
    noTrans = poObjects.savePOFile(Utilities.path(sourceDirectory, "source", poFileName), count, noTrans);
    if (targetPropertiesFileName != null) {
      savePropertiesFile(Utilities.path(sourceDirectory, targetPropertiesFileName), poObjects.getPOObjects());
    }
  }

  private static void markDuplicatePOObjects(POSource poObjects) {
    Map<String, Integer> sources = new HashMap<>();

    for (POObject poObject : poObjects.getPOObjects()) {
      if (sources.containsKey(poObject.getMsgid())) {
        Integer count = sources.get(poObject.getMsgid())+1;
        sources.put(poObject.getMsgid(), count);
//        System.out.println("Duplicate in "+dest.substring(dest.lastIndexOf("/")+1)+": "+o.msgid+" on ("+CommaSeparatedStringBuilder.join(",", listIds(objects, o.msgid))+")");
      } else {
        sources.put(poObject.getMsgid(), 1);
      }
    }
    for (POObject poObject : poObjects.getPOObjects()) {
      Integer count = sources.get(poObject.getMsgid());
      if (count > 1) {
        poObject.setDuplicate(true);
      }
    }
  }

  private void updatePOObject(POObject poObject, PluralMode mode, String originatingMsgid) {
    poObject.setOrphan(false);
    if (poObject.getComment() == null) {
      poObject.setComment(poObject.getId());
    }
    if (mode == PluralMode.NONE) {
      if (!originatingMsgid.equals(poObject.getMsgid())) {
        // the english string has changed, and the other language string is now out of date
        if (poObject.getOldMsgId() != null && !poObject.getMsgstr().isEmpty()) {
          poObject.setOldMsgId(poObject.getMsgid());
        }
        poObject.setMsgid(originatingMsgid);
        for (int i = 0; i < poObject.getMsgstr().size(); i++) {
          if (!Utilities.noString(poObject.getMsgstr().get(i))) {
            poObject.getMsgstr().set(i, tagAsOutdated(poObject.getMsgstr().get(i)));
          }
        }
      } else {
        poObject.setOldMsgId(null);
      }
    } else if (mode == PluralMode.ONE) {
      if (!originatingMsgid.equals(poObject.getMsgid())) {
        // the english string has changed, and the other language string is now out of date 
        if (poObject.getOldMsgId() != null && !poObject.getMsgstr().isEmpty()) {
          poObject.setOldMsgId(poObject.getMsgid());
        }
        poObject.setMsgid(originatingMsgid);
        if (!poObject.getMsgstr().isEmpty() && !Utilities.noString(poObject.getMsgstr().get(0))) {
          poObject.getMsgstr().set(0, tagAsOutdated(poObject.getMsgstr().get(0)));
        }
      } else {
        poObject.setOldMsgId(null);
      }
    } else if (mode == PluralMode.OTHER) {
      if (!originatingMsgid.equals(poObject.getMsgidPlural())) {
        // the english string has changed, and the other language string is now out of date 
//        if (o.oldMsgId != null) {
//          o.oldMsgId = o.msgid;
//        }
        poObject.setMsgidPlural(originatingMsgid);
        if (poObject.getMsgstr().size() > 1 && !Utilities.noString(poObject.getMsgstr().get(1))) {
          poObject.getMsgstr().set(1, tagAsOutdated(poObject.getMsgstr().get(1)));
        }
      } else {
        poObject.setOldMsgId(null);
      }
    }
  }

  private POObject findObject(List<POObject> poObjects, String name) {
    for (POObject poObject : poObjects) {
      if (poObject.getId() != null && poObject.getId().equals(name)) {
        return poObject;
      }
    }
    return null;
  }

  private List<PropertyValue> loadProperties(String source, boolean checking) throws IOException {
    List<PropertyValue> res = new ArrayList<>();
    File src = ManagedFileAccess.file(source);
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), StandardCharsets.UTF_8));
    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
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

  private void savePropertiesFile(String tgt, List<POObject> objects) throws IOException {
    String nameLine = FileUtilities.fileToLines(tgt).get(0);
    String[] parts = nameLine.substring(1).trim().split("\\=");
    String[] names = parts[1].split("\\,");
    
    StringBuilder b = new StringBuilder();
    b.append(nameLine+"\r\n");
    for (POObject o : objects) {
      if (o.getMsgidPlural() == null) {
        String v= o.getMsgstr().size() > 0 ? o.getMsgstr().get(0) : "";
        if (!Utilities.noString(v)) {
          if (isOutdated(v)) {
            v = v.substring(2);
          }
          b.append(o.getId()+" = "+v+"\r\n");
        }
      } else {
        for (int i = 0; i < names.length; i++) {
          String v = (o.getMsgstr().size() > i ? o.getMsgstr().get(i) : "");
          if (!Utilities.noString(v)) {
            if (isOutdated(v)) {
              v = v.substring(2);
            }
            b.append(o.getId()+"_"+names[i].trim()+" = "+v+"\r\n");
          }
        }
      }
    }
    
    FileUtilities.stringToFile(b.toString(), tgt);
  }

  
}
