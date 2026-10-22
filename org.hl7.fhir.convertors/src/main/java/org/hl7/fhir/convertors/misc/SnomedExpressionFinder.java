package org.hl7.fhir.convertors.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.IPackageVisitorProcessor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.PackageContext;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.xml.sax.SAXException;

/**
 * Scans all the published packages (and the current CI builds) looking for any
 * use of SNOMED CT codes that aren't plain concept ids - in particular, any
 * post-coordinated expression using the SNOMED CT compositional grammar.
 * 
 * Looks at:
 *  - anything that looks like a Coding (system + code) anywhere in any resource 
 *    (this covers Coding, CodeableConcept, expansion.contains, fixed/pattern values etc)
 *  - ValueSet.compose.include/exclude.concept.code where the system is SNOMED CT
 *  - ConceptMap group element/target codes where the source/target system is SNOMED CT
 *  - CodeSystem.concept.code where the CodeSystem url is SNOMED CT
 * 
 * Output is a CSV in [tmp]/snomed-expressions.csv
 * 
 * Usage: SnomedExpressionFinder [-nocore] [-old]
 *   -nocore: skip the core / terminology packages
 *   -old: visit all versions of each package, not just the latest 
 */
@SuppressWarnings("checkstyle:systemout")
public class SnomedExpressionFinder implements IPackageVisitorProcessor {

  private static final String SCT = "http://snomed.info/sct";

  public enum CodeKind {
    POST_COORDINATED, // uses compositional grammar operators 
    OTHER;            // not a plain concept id, but not an expression either (e.g. has a |term|, whitespace, etc)
  }
  
  public class Finding {
    private String pvid;
    private String fhirVersion;
    private String rid;
    private String rType;
    private String path;
    private CodeKind kind;
    private String code;
    private String version; // SNOMED CT edition/version, if one was provided alongside the code
    
    public Finding(String pvid, String fhirVersion, String rid, String rType, String path, CodeKind kind, String code, String version) {
      super();
      this.pvid = pvid;
      this.fhirVersion = fhirVersion;
      this.rid = rid;
      this.rType = rType;
      this.path = path;
      this.kind = kind;
      this.code = code;
      this.version = version;
    }
    public String summary() {
      return pvid+" "+rid+"#"+path+" ["+kind+"]: "+code+(version == null ? "" : " (version "+version+")");
    }
    public String csv() {
      return csvCell(pvid)+","+csvCell(fhirVersion)+","+csvCell(rid)+","+csvCell(rType)+","+csvCell(path)+","+kind.toString().toLowerCase()+","+csvCell(code)+","+csvCell(version);
    }
  }

  private static String csvCell(String s) {
    if (s == null) {
      return "";
    }
    if (s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r")) {
      return "\""+s.replace("\"", "\"\"")+"\"";
    }
    return s;
  }
  
  public static void main(String[] args) throws FHIRException, IOException, ParserConfigurationException, SAXException {
    boolean core = true;
    boolean old = false;
    for (String a : args) {
      if ("-nocore".equals(a)) {
        core = false;
      } else if ("-old".equals(a)) {
        old = true;
      }
    }
    new SnomedExpressionFinder().execute(core, old);
  }

  private List<Finding> findings = new ArrayList<>();
  private Map<String, Integer> packageCounts = new HashMap<>();
  private int resourceCount = 0;
  private int packageCount = 0;

  private void execute(boolean core, boolean old) throws FHIRException, IOException, ParserConfigurationException, SAXException {
    PackageVisitor pv = new PackageVisitor();
    pv.setCorePackages(core);
    pv.setOldVersions(old);
    pv.setClientPackageServer(PackageServer.primaryServer());
    // no resource types = all resources
    pv.setProcessor(this);
    pv.visitPackages();
    
    System.out.println("=====================");
    System.out.println("Scanned "+resourceCount+" resources in "+packageCount+" packages");
    System.out.println(findings.size()+" findings in "+packageCounts.size()+" packages");
    for (Finding f : findings) {
      System.out.println(f.summary());
    }
    
    StringBuilder csv = new StringBuilder();
    csv.append("Package,FHIRVersion,Resource,Type,Path,Kind,Code,Version\r\n");
    for (Finding f : findings) {
      csv.append(f.csv());
      csv.append("\r\n");
    }
    String fn = Utilities.path("[tmp]", "snomed-expressions.csv");
    FileUtilities.stringToFile(csv.toString(), fn);
    System.out.println("Output written to "+fn);
  }

  @Override
  public Object startPackage(PackageContext context) throws FHIRException, IOException {
    packageCount++;
    return this;
  }

  @Override
  public void processResource(PackageContext context, Object clientContext, String type, String id, byte[] content) throws FHIRException, IOException {
    if (content == null || content.length == 0) {
      return;
    }
    // some old packages have xml in them; we don't bother with those
    int i = 0;
    while (i < content.length && Character.isWhitespace(content[i])) {
      i++;
    }
    if (i == content.length || content[i] != '{') {
      return;
    }
    resourceCount++;
    JsonObject r = JsonParser.parseObject(content);
    String rt = r.asString("resourceType");
    String rid = (rt == null ? type : rt) + "/" + (r.has("id") ? r.asString("id") : id);
    ScanContext sc = new ScanContext(context, rt, rid);
    
    // generic scan for anything that looks like a Coding
    scanElement(sc, r, rt == null ? type : rt);
    
    // then the resource specific places where codes are separated from their systems
    if ("ValueSet".equals(rt)) {
      scanValueSet(sc, r);
    } else if ("ConceptMap".equals(rt)) {
      scanConceptMap(sc, r);
    } else if ("CodeSystem".equals(rt)) {
      scanCodeSystem(sc, r);
    }
  }

  private class ScanContext {
    private PackageContext context;
    private String rt;
    private String rid;
    public ScanContext(PackageContext context, String rt, String rid) {
      this.context = context;
      this.rt = rt;
      this.rid = rid;
    }
  }

  private void scanElement(ScanContext sc, JsonElement e, String path) {
    if (e.isJsonObject()) {
      JsonObject o = e.asJsonObject();
      if (o.hasString("system") && SCT.equals(o.asString("system")) && o.hasString("code")) {
        check(sc, path+".code", o.asString("code"), o.asString("version"));
      }
      for (JsonProperty p : o.getProperties()) {
        scanElement(sc, p.getValue(), path+"."+p.getName());
      }
    } else if (e.isJsonArray()) {
      JsonArray a = e.asJsonArray();
      int i = 0;
      for (JsonElement c : a.getItems()) {
        scanElement(sc, c, path+"["+i+"]");
        i++;
      }
    }
  }

  private void scanValueSet(ScanContext sc, JsonObject vs) {
    JsonObject compose = vs.getJsonObject("compose");
    if (compose != null) {
      for (String n : new String[] {"include", "exclude"}) {
        int i = 0;
        for (JsonObject inc : compose.getJsonObjects(n)) {
          if (SCT.equals(inc.asString("system"))) {
            int j = 0;
            for (JsonObject c : inc.getJsonObjects("concept")) {
              check(sc, "ValueSet.compose."+n+"["+i+"].concept["+j+"].code", c.asString("code"), inc.asString("version"));
              j++;
            }
          }
          i++;
        }
      }
    }
    // expansion.contains is covered by the generic scan (system + code)
  }

  private void scanConceptMap(ScanContext sc, JsonObject cm) {
    // R2/R3: ConceptMap.element.system / target.system
    int i = 0;
    for (JsonObject e : cm.getJsonObjects("element")) {
      String src = e.asString("system"); // R3 
      if (src == null) {
        src = cm.asString("sourceUri"); // R2
      }
      if (SCT.equals(src)) {
        check(sc, "ConceptMap.element["+i+"].code", e.asString("code"), e.asString("version"));
      }
      int j = 0;
      for (JsonObject t : e.getJsonObjects("target")) {
        String tgt = t.asString("system");
        if (tgt == null) {
          tgt = cm.asString("targetUri");
        }
        if (SCT.equals(tgt)) {
          check(sc, "ConceptMap.element["+i+"].target["+j+"].code", t.asString("code"), t.asString("version"));
        }
        j++;
      }
      i++;
    }
    // R4+: ConceptMap.group.source / target
    i = 0;
    for (JsonObject g : cm.getJsonObjects("group")) {
      boolean srcSct = SCT.equals(g.asString("source"));
      boolean tgtSct = SCT.equals(g.asString("target"));
      String srcVer = g.asString("sourceVersion");
      String tgtVer = g.asString("targetVersion");
      if (srcSct || tgtSct) {
        int j = 0;
        for (JsonObject e : g.getJsonObjects("element")) {
          if (srcSct) {
            check(sc, "ConceptMap.group["+i+"].element["+j+"].code", e.asString("code"), srcVer);
          }
          if (tgtSct) {
            int k = 0;
            for (JsonObject t : e.getJsonObjects("target")) {
              check(sc, "ConceptMap.group["+i+"].element["+j+"].target["+k+"].code", t.asString("code"), tgtVer);
              k++;
            }
          }
          j++;
        }
      }
      i++;
    }
  }

  private void scanCodeSystem(ScanContext sc, JsonObject cs) {
    if (SCT.equals(cs.asString("url"))) {
      scanConcepts(sc, cs.getJsonObjects("concept"), "CodeSystem.concept", cs.asString("version"));
    }
  }

  private void scanConcepts(ScanContext sc, List<JsonObject> concepts, String path, String version) {
    int i = 0;
    for (JsonObject c : concepts) {
      check(sc, path+"["+i+"].code", c.asString("code"), version);
      scanConcepts(sc, c.getJsonObjects("concept"), path+"["+i+"].concept", version);
      i++;
    }
  }

  private void check(ScanContext sc, String path, String code, String version) {
    if (code == null) {
      return;
    }
    CodeKind kind = classify(code);
    if (kind != null) {
      findings.add(new Finding(sc.context.getPid(), sc.context.getVersion(), sc.rid, sc.rt, path, kind, code, version));
      String pid = sc.context.getPid();
      packageCounts.put(pid, packageCounts.containsKey(pid) ? packageCounts.get(pid) + 1 : 1);
    }
  }

  /**
   * @return null if this is a plain concept id, or something that clearly isn't 
   *   an expression (a single word, a decimal, or a word-word code), otherwise what kind of thing it is 
   */
  public static CodeKind classify(String code) {
    String c = code.trim();
    if (c.isEmpty()) {
      return null;
    }
    if (isSingleWord(c) || isDecimal(c) || isWordWord(c)) {
      return null;
    }
    // compositional grammar: refinement (:), attribute (=), attribute group ({ }), 
    // conjunction (+), nested expression (( )), definition status (=== / <<<)
    for (char ch : c.toCharArray()) {
      if (ch == ':' || ch == '=' || ch == '+' || ch == '{' || ch == '}' || ch == '(' || ch == ')' || ch == '<') {
        return CodeKind.POST_COORDINATED;
      }
    }
    return CodeKind.OTHER;
  }

  private static boolean isWordChar(char ch) {
    return Character.isLetterOrDigit(ch) || ch == '_' || ch == '.';
  }
  
  /** a single word - includes a plain concept id, and codes from other systems */
  private static boolean isSingleWord(String c) {
    for (char ch : c.toCharArray()) {
      if (!isWordChar(ch)) {
        return false;
      }
    }
    return true;
  }

  /** a decimal, including exponential form: [+-]digits[.digits][e[+-]digits] */
  private static boolean isDecimal(String c) {
    int i = 0;
    int n = c.length();
    if (i < n && (c.charAt(i) == '+' || c.charAt(i) == '-')) {
      i++;
    }
    int digits = 0;
    while (i < n && Character.isDigit(c.charAt(i))) {
      i++;
      digits++;
    }
    if (i < n && c.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(c.charAt(i))) {
        i++;
        digits++;
      }
    }
    if (digits == 0) {
      return false;
    }
    if (i < n && (c.charAt(i) == 'e' || c.charAt(i) == 'E')) {
      i++;
      if (i < n && (c.charAt(i) == '+' || c.charAt(i) == '-')) {
        i++;
      }
      int exp = 0;
      while (i < n && Character.isDigit(c.charAt(i))) {
        i++;
        exp++;
      }
      if (exp == 0) {
        return false;
      }
    }
    return i == n;
  }

  /** word-word (one or more dashes between alphanumeric words, e.g. SRT codes like G-D705) */
  private static boolean isWordWord(String c) {
    if (!c.contains("-")) {
      return false;
    }
    boolean inWord = false;
    for (char ch : c.toCharArray()) {
      if (Character.isLetterOrDigit(ch)) {
        inWord = true;
      } else if (ch == '-') {
        if (!inWord) {
          return false; // leading dash or double dash
        }
        inWord = false;
      } else {
        return false;
      }
    }
    return inWord; // no trailing dash
  }

  @Override
  public void finishPackage(PackageContext context) throws FHIRException, IOException {
    String pid = context.getPid();
    if (packageCounts.containsKey(pid)) {
      System.out.println(pid+": "+packageCounts.get(pid)+" SNOMED CT expressions");
    }
  }

  @Override
  public void alreadyVisited(String pid) throws FHIRException, IOException {
  }

}
