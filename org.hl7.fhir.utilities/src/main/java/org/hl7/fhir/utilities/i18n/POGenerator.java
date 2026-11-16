package org.hl7.fhir.utilities.i18n;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Usage:
 * <pre>
 *   java org.hl7.fhir.utilities.i18n.POGenerator [core] [igpub] [fhirsmith]
 * </pre>
 * It takes 3 positional parameters, all required:
 * <ol>
 *   <li>core: path to the local copy of the core repo (hapifhir/org.hl7.fhir.core). The
 *       .properties and .po files under org.hl7.fhir.utilities/src/main/resources are
 *       read and updated in place, and the java source is scanned for constant usage</li>
 *   <li>igpub: path to the local copy of the ig-publisher repo (HL7/fhir-ig-publisher).
 *       Only read - the java source is scanned for constant usage</li>
 *   <li>fhirsmith: path to the local copy of the FHIRsmith repo (javascript). Only read -
 *       *.js/mjs/cjs files are scanned for property names used as quoted strings</li>
 * </ol>
 * Run with -h, -help, --help or ? (or with the wrong number of parameters) to get usage help.
 * <br/>
 * The languages that are generated are listed in the [languages] section of
 * translations-control.ini in the same resources folder.
 * <br/>
 * If the consistency check finds errors, the generator reports them and stops without
 * changing any files.
 */
@SuppressWarnings("checkstyle:systemout")
public class POGenerator {

  public static class PropertyValue extends StringPair {
    private boolean used;
    private boolean usedInJavascript;
    private List<ConstantDefinition> constants = new ArrayList<>();

    public PropertyValue(String name, String value) {
      super(name, value);
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
    private boolean usedInCore;
    private boolean usedInIgpub;
  }

  /**
   * Where the messages in one .properties file are used: counted by message (the _one and
   * _other forms of a plural are one message). A message is used in core or the IG publisher
   * if its constant is referenced there, and in FHIRsmith if its id appears as a quoted string
   */
  private static class UsageSummary {
    private String file;
    private int total;
    private int core;
    private int igpub;
    private int fhirsmith;
    private int javaOnly;
    private int fhirsmithOnly;
    private int both;
    private int none;
  }

  private List<UsageSummary> usage = new ArrayList<>();

  public static class POObjectSorter implements Comparator<POObject> {

    @Override
    public int compare(POObject o1, POObject o2) {
      return o1.getId().compareTo(o2.getId());
    }
  }

  /**
   * Stale-translation policy for runtime PO loading.
   * <p>
   * INCLUDE: ship the (possibly out-of-date) translation, mirroring the maintainer's
   *          shipped behaviour. The {@link POUtilities#OUTDATED_PREFIX} marker is stripped.
   * EXCLUDE: drop translations whose English source has drifted, so end users see English.
   * WARN:    behave like INCLUDE but log the mismatched keys.
   */
  public enum StaleHandling {
    INCLUDE, EXCLUDE, WARN
  }

  public static void main(String[] args) throws IOException {
    if (args.length == 1 && Utilities.existsInList(args[0], "-h", "-help", "--help", "?", "-?", "/?")) {
      usage();
      return;
    }
    if (args.length != 3) {
      System.out.println("Error: expected 3 parameters, but found "+args.length);
      System.out.println();
      usage();
      System.exit(1);
    }
    boolean ok = checkFolder("core", args[0], "org.hl7.fhir.utilities/src/main/resources/translations-control.ini");
    ok = checkFolder("igpub", args[1], null) && ok;
    ok = checkFolder("fhirsmith", args[2], null) && ok;
    if (!ok) {
      System.out.println();
      usage();
      System.exit(1);
    }
    new POGenerator().execute(args[0], args[1], args[2]);
  }

  private static boolean checkFolder(String name, String path, String expectedFile) throws IOException {
    File f = ManagedFileAccess.file(path);
    if (!f.exists() || !f.isDirectory()) {
      System.out.println("Error: "+name+" folder '"+path+"' not found");
      return false;
    }
    if (expectedFile != null && !ManagedFileAccess.file(Utilities.path(path, expectedFile)).exists()) {
      System.out.println("Error: "+name+" folder '"+path+"' does not look right - "+expectedFile+" not found");
      return false;
    }
    return true;
  }

  private static void usage() {
    System.out.println("POGenerator: checks the i18n constants and declarations are consistent, then");
    System.out.println("generates/updates the .po source files and the translated .properties files.");
    System.out.println("Run it when new i18n constants are added, or when translations are contributed.");
    System.out.println();
    System.out.println("Usage: java org.hl7.fhir.utilities.i18n.POGenerator [core] [igpub] [fhirsmith]");
    System.out.println();
    System.out.println("  [core]       local copy of the core repo (hapifhir/org.hl7.fhir.core). The .properties");
    System.out.println("               and .po files in org.hl7.fhir.utilities/src/main/resources are updated");
    System.out.println("  [igpub]      local copy of the IG publisher repo (HL7/fhir-ig-publisher) - read only,");
    System.out.println("               scanned for use of the constants");
    System.out.println("  [fhirsmith]  local copy of the FHIRsmith repo (javascript) - read only, scanned for");
    System.out.println("               use of the message ids");
    System.out.println();
    System.out.println("Languages come from the [languages] section of translations-control.ini.");
    System.out.println("If the consistency check finds errors, nothing is changed.");
    System.out.println("Use -help to show this message.");
  }

  private int noTrans = 0;

  public void execute(String core, String igpub, String javascript) throws IOException {
    String source = Utilities.path(core, "/org.hl7.fhir.utilities/src/main/resources");
    boolean ok = checkState(source, core, igpub, javascript);
    if (ok) {
      IniFile ini = new IniFile(Utilities.path(source, "translations-control.ini"));
      generate(source, "rendering-phrases.properties",  "rendering-phrases-en.po",       null, 2);
      generate(source, "Messages.properties", "validator-messages-en.po",    null, 2);
      for (String name : ini.getProperties("languages").keySet()) {
        generate(source, "rendering-phrases.properties",  "rendering-phrases-"+name+".po",    "rendering-phrases_"+name+".properties", ini.getIntegerProperty("languages", name));
        generate(source, "Messages.properties", "validator-messages-"+name+".po",    "Messages_"+name+".properties", ini.getIntegerProperty("languages", name));        
      }

      System.out.println("Finished");
    }
    reportUsage();
  }

  private UsageSummary summariseUsage(String file, List<PropertyValue> props) {
    // by message: the plural forms share a base name
    Map<String, boolean[]> byMessage = new LinkedHashMap<>();
    for (PropertyValue p : props) {
      boolean[] where = byMessage.computeIfAbsent(p.getBaseName(), k -> new boolean[3]);
      for (ConstantDefinition cd : p.constants) {
        where[0] = where[0] || cd.usedInCore;
        where[1] = where[1] || cd.usedInIgpub;
      }
      where[2] = where[2] || p.usedInJavascript;
    }
    UsageSummary res = new UsageSummary();
    res.file = file;
    for (boolean[] where : byMessage.values()) {
      boolean java = where[0] || where[1];
      res.total++;
      if (where[0]) {
        res.core++;
      }
      if (where[1]) {
        res.igpub++;
      }
      if (where[2]) {
        res.fhirsmith++;
      }
      if (java && where[2]) {
        res.both++;
      } else if (java) {
        res.javaOnly++;
      } else if (where[2]) {
        res.fhirsmithOnly++;
      } else {
        res.none++;
      }
    }
    return res;
  }

  private void reportUsage() {
    if (usage.isEmpty()) {
      return;
    }
    System.out.println();
    System.out.println("Message usage (by message - plural forms count once):");
    System.out.println(String.format("  %-30s %7s %7s %7s %9s   %9s %13s %7s %7s", "", "total", "core", "igpub", "fhirsmith", "java only", "fhirsmith only", "both", "none"));
    for (UsageSummary u : usage) {
      System.out.println(String.format("  %-30s %7d %7d %7d %9d   %9d %13d %7d %7d", u.file, u.total, u.core, u.igpub, u.fhirsmith, u.javaOnly, u.fhirsmithOnly, u.both, u.none));
    }
    System.out.println("  (core/igpub: the constant is referenced there; java = core or igpub; both = java and fhirsmith)");
  }

  private boolean checkState(String source, String core, String igpub, String javascript) throws IOException {
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
          p.constants.add(cd);
        }
      }
      cd.defined = found;
    }
    scanJavaSource(core, true, consts, "RenderingI18nContext", "RenderingContext");
    scanJavaSource(igpub, false, consts, "RenderingI18nContext", "RenderingContext");
    scanJavascriptSource(javascript, props);
    usage.add(summariseUsage("rendering-phrases.properties", props));
    
    Set<String> pns = new HashSet<>();
    for (PropertyValue p : props) {
      if (!p.used) {
        System.out.println("Warning: PV "+p.getName()+ " provided but not used");
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
          p.constants.add(cd);
        }
      }
      cd.defined = found;
    }

    scanJavaSource(core, true, consts, "I18nConstants");
    scanJavaSource(igpub, false, consts, "I18nConstants");
    scanJavascriptSource(javascript, props);
    usage.add(summariseUsage("Messages.properties", props));

    pns = new HashSet<>();
    for (PropertyValue p : props) {
      if (!p.used) {
        System.out.println("Warning: PV "+p.getName()+ " provided but not used");
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

  /**
   * Finds references to the constants as Name.CONSTANT (Name being I18nConstants etc), and
   * records them against the repo being scanned. One pass over each file, so every constant
   * is checked in every repo (not just the ones not yet found), for the usage report
   */
  private class JavaScanner implements IDirectoryVisitorImplementation {
    Map<String, ConstantDefinition> consts;
    Pattern pattern;
    boolean core;

    @Override
    public boolean enterDirectory(File f) throws IOException {
      return !Utilities.existsInList(f.getName(), "model", "formats");
    }

    @Override
    public boolean visitFile(File file) throws IOException {
      String source = FileUtilities.fileToString(file);
      Matcher m = pattern.matcher(source);
      while (m.find()) {
        // the identifier is matched greedily, so it is the whole token: CONST, not CONST_OTHER
        ConstantDefinition cd = consts.get(m.group(1));
        if (cd != null) {
          cd.used = true;
          if (core) {
            cd.usedInCore = true;
          } else {
            cd.usedInIgpub = true;
          }
        }
      }
      return true;
    }
  }

  // names are Pattern.quote()d, so the only regex syntax is the fixed suffix
  @SuppressWarnings("checkstyle:patternUsage")
  private void scanJavaSource(String path, boolean core, List<ConstantDefinition> consts, String... names) throws FileNotFoundException, IOException {
    JavaScanner scanner = new JavaScanner();
    scanner.core = core;
    scanner.consts = new HashMap<>();
    for (ConstantDefinition cd : consts) {
      scanner.consts.put(cd.name, cd);
    }
    StringBuilder b = new StringBuilder();
    for (String s : names) {
      b.append(b.length() == 0 ? "" : "|").append(Pattern.quote(s));
    }
    scanner.pattern = Pattern.compile("(?:" + b + ")\\.([A-Za-z0-9_]+)");
    DirectoryVisitor.visitDirectory(scanner, path, "java");
  }

  /**
   * Finds message ids used as quoted strings ('X', "X" or `X`) in javascript. One pass over each
   * file collecting the quoted strings, then looked up by message (base) name
   */
  private class JavascriptScanner implements IDirectoryVisitorImplementation {
    // a quoted string with no quotes or whitespace in it. The closing quote isn't consumed, so
    // an occurrence that starts on it is still found (as String.contains would)
    @SuppressWarnings("checkstyle:patternUsage")
    private final Pattern quoted = Pattern.compile("(['\"`])([^'\"`\\s]+)(?=\\1)");
    private Map<String, List<PropertyValue>> defs;

    @Override
    public boolean enterDirectory(File directory) throws IOException {
      return !Utilities.existsInList(directory.getName(), "node_modules", ".git");
    }

    @Override
    public boolean visitFile(File file) throws IOException {
      String source = FileUtilities.fileToString(file);
      Matcher m = quoted.matcher(source);
      while (m.find()) {
        List<PropertyValue> pvs = defs.get(m.group(2));
        if (pvs != null) {
          for (PropertyValue pv : pvs) {
            pv.used = true;
            pv.usedInJavascript = true;
          }
        }
      }
      return true;
    }
  }

  private void scanJavascriptSource(String path, List<PropertyValue> defs) throws FileNotFoundException, IOException {
    JavascriptScanner scanner = new JavascriptScanner();
    scanner.defs = new HashMap<>();
    for (PropertyValue pv : defs) {
      scanner.defs.computeIfAbsent(pv.getBaseName(), k -> new ArrayList<>()).add(pv);
    }
    DirectoryVisitor.visitDirectory(scanner, path, "js", "mjs", "cjs");
  }

  
  private List<ConstantDefinition> loadConstants(String path) throws FileNotFoundException, IOException {
    List<ConstantDefinition> res = new ArrayList<POGenerator.ConstantDefinition>();
    for (String line : FileUtilities.fileToLines(path)) {
      if (line.contains("public static final String") && !line.trim().startsWith("//")) {
        int i = line.indexOf("public static final String") + "public static final String".length();
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //single literal character split
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
    mergePOWithEnglish(poObjects, javaProperties);
    noTrans = poObjects.savePOFile(Utilities.path(sourceDirectory, "source", poFileName), count, noTrans);
    if (targetPropertiesFileName != null) {
      savePropertiesFile(Utilities.path(sourceDirectory, targetPropertiesFileName), poObjects.getPOObjects());
    }
  }

  /**
   * Reconcile a {@link POSource} against the current English property set:
   * adds new POObjects for English keys not yet in the .po, removes orphans,
   * marks translations as outdated when the English msgid has drifted, sorts,
   * and flags duplicate msgids.
   * <p>
   * Mutates {@code poObjects} in place. Extracted from {@link #generate} so that
   * the runtime PO loader can apply the same reconciliation without writing files.
   */
  public static void mergePOWithEnglish(POSource poObjects, List<PropertyValue> javaProperties) {
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

  private static void updatePOObject(POObject poObject, PluralMode mode, String originatingMsgid) {
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

  private static POObject findObject(List<POObject> poObjects, String name) {
    for (POObject poObject : poObjects) {
      if (poObject.getId() != null && poObject.getId().equals(name)) {
        return poObject;
      }
    }
    return null;
  }

  private List<PropertyValue> loadProperties(String source, boolean checking) throws IOException {
    File src = ManagedFileAccess.file(source);
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), StandardCharsets.UTF_8))) {
      return loadProperties(reader, checking);
    }
  }

  /**
   * Parse a {@code Messages.properties}-style stream into a list of {@link PropertyValue}s.
   * <p>
   * When {@code checking} is false, placeholder-only entries (e.g. {@code key = {0}}) are
   * skipped, mirroring the maintainer's import behaviour.
   */
  public static List<PropertyValue> loadProperties(BufferedReader reader, boolean checking) throws IOException {
    List<PropertyValue> res = new ArrayList<>();
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
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //single literal character split
    String[] parts = nameLine.substring(1).trim().split("\\=");
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //single literal character split
    String[] names = parts[1].split("\\,");
    List<String> pluralKeywords = new ArrayList<>();
    for (String n : names) {
      pluralKeywords.add(n.trim());
    }

    Map<String, String> flattened = poObjectsToPropertiesMap(objects, pluralKeywords, StaleHandling.INCLUDE, null);

    StringBuilder b = new StringBuilder();
    b.append(nameLine+"\r\n");
    // Preserve the input ordering of POObjects (which generate() has already sorted).
    // poObjectsToPropertiesMap is order-preserving via LinkedHashMap.
    for (Map.Entry<String, String> e : flattened.entrySet()) {
      b.append(e.getKey()+" = "+e.getValue()+"\r\n");
    }

    FileUtilities.stringToFile(b.toString(), tgt);
  }

  /**
   * Flatten a list of reconciled {@link POObject}s into a properties-style key/value map.
   * <p>
   * Singular entries become {@code id = msgstr}. Pluralized entries become
   * {@code id_<keyword> = msgstr[i]} for each keyword in {@code pluralKeywords} in order,
   * matching the indexing used by {@code msgstr[i]} in the .po file.
   * <p>
   * Translations whose English source has drifted (marked with {@link POUtilities#OUTDATED_PREFIX})
   * are handled according to {@code staleHandling}:
   * <ul>
   *   <li>{@link StaleHandling#INCLUDE} (default for the maintainer's import): strip the marker, keep the translation</li>
   *   <li>{@link StaleHandling#EXCLUDE}: omit the entry so the bundle falls back to English</li>
   *   <li>{@link StaleHandling#WARN}: same as INCLUDE, but accumulate the stale keys into {@code staleKeysOut} if non-null</li>
   * </ul>
   * Returned map preserves insertion order.
   */
  public static Map<String, String> poObjectsToPropertiesMap(List<POObject> objects, List<String> pluralKeywords,
                                                             StaleHandling staleHandling, List<String> staleKeysOut) {
    Map<String, String> out = new LinkedHashMap<>();
    for (POObject o : objects) {
      if (o.getMsgidPlural() == null) {
        String v = o.getMsgstr().size() > 0 ? o.getMsgstr().get(0) : "";
        if (!Utilities.noString(v)) {
          boolean stale = isOutdated(v);
          if (stale) {
            v = v.substring(POUtilities.OUTDATED_PREFIX.length());
            if (staleKeysOut != null) {
              staleKeysOut.add(o.getId());
            }
            if (staleHandling == StaleHandling.EXCLUDE) {
              continue;
            }
          }
          out.put(o.getId(), v);
        }
      } else {
        for (int i = 0; i < pluralKeywords.size(); i++) {
          String v = (o.getMsgstr().size() > i ? o.getMsgstr().get(i) : "");
          if (!Utilities.noString(v)) {
            boolean stale = isOutdated(v);
            if (stale) {
              v = v.substring(POUtilities.OUTDATED_PREFIX.length());
              if (staleKeysOut != null) {
                staleKeysOut.add(o.getId() + "_" + pluralKeywords.get(i));
              }
              if (staleHandling == StaleHandling.EXCLUDE) {
                continue;
              }
            }
            out.put(o.getId() + "_" + pluralKeywords.get(i), v);
          }
        }
      }
    }
    return out;
  }

}
