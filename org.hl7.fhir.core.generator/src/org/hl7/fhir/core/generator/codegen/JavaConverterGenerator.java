package org.hl7.fhir.core.generator.codegen;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.core.generator.analysis.Analysis;
import org.hl7.fhir.core.generator.analysis.EnumInfo;
import org.hl7.fhir.core.generator.analysis.TypeInfo;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

/**
 * Generates the R5 <-> R6 conversion code (conv50_N) in the same idiom as the hand-maintained
 * conv40_N / conv40_50 converters: one class per resource / complex datatype with a pair of
 * static convert methods per type, nested component converters, and enum converters generated
 * as code-by-code switches.
 * 
 * The R6 side is generated from the loaded definitions; the R5 side is emitted on the 
 * assumption that R5 has the same element with the same type (in the R5 accessor idiom - no 
 * List suffix). Where R5 differs, the generated code does not compile, and the compile errors 
 * are the work list for hand-finishing - the same workflow as the conv40_N clone.
 * 
 * The version-independent infrastructure is NOT generated - ConversionContext50_N, 
 * VersionConvertor_50_N, the primitive converters, and Element/BackboneElement/Type are 
 * cloned by hand from conv40_N.
 */
public class JavaConverterGenerator {

  private String destFolder; // the conv50_N folder in the convertors project
  private Definitions definitions;
  private Configuration config;
  private String date;
  private String version;

  // shared enums encountered, for Enumerations50_N: name -> EnumInfo
  private Map<String, EnumInfo> sharedEnums = new HashMap<>();

  private static final String CTXT = "ConversionContext50_N.INSTANCE.getVersionConvertor_50_N()";
  private static final String N_PKG = "org.hl7.fhir.model.core";
  private static final String R5_PKG = "org.hl7.fhir.r5.model";
  private static final String CONV_PKG = "org.hl7.fhir.convertors.conv50_N";

  // resources that have moved out of R6 core into generated logical model packages: 
  // the converters are still generated (from the R5 definitions), targeting these packages
  private static final Map<String, String> N_HOME_OVERRIDES = new HashMap<>();
  static {
    N_HOME_OVERRIDES.put("TestReport", "org.hl7.fhir.model.testing");
    N_HOME_OVERRIDES.put("TestScript", "org.hl7.fhir.model.testing");
    N_HOME_OVERRIDES.put("StructureMap", "org.hl7.fhir.model.fml");
    N_HOME_OVERRIDES.put("GraphDefinition", "org.hl7.fhir.model.api");
  }

  private static final Map<String, String> DT_SUBPKG = new HashMap<>();
  static {
    for (String s : new String[] {"Address", "Age", "Annotation", "Attachment", "CodeableConcept", "CodeableReference", "Coding", "ContactPoint",
        "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "MoneyQuantity", "Period", "Quantity", "Range",
        "Ratio", "RatioRange", "SampledData", "Signature", "SimpleQuantity", "Timing"}) {
      DT_SUBPKG.put(s, "general50_N");
    }
    for (String s : new String[] {"Availability", "ContactDetail", "DataRequirement", "Expression", "ExtendedContactDetail",
        "MonetaryComponent", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "VirtualServiceDetail"}) {
      DT_SUBPKG.put(s, "metadata50_N");
    }
    for (String s : new String[] {"Dosage", "ElementDefinition", "Extension", "Meta", "Narrative", "Reference"}) {
      DT_SUBPKG.put(s, "special50_N");
    }
  }

  private String nHome(String className) {
    return N_HOME_OVERRIDES.getOrDefault(className, N_PKG);
  }

  public JavaConverterGenerator(String destFolder, Definitions definitions, Configuration config, String date, String version) {
    this.destFolder = destFolder;
    this.definitions = definitions;
    this.config = config;
    this.date = date;
    this.version = version;
  }

  public void seeClass(Analysis analysis) throws Exception {
    if (analysis.isAbstract() || analysis.isInterface()) {
      return;
    }
    boolean resource = analysis.getStructure().getKind() == org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
    String name = analysis.getClassName();
    String subPkg = resource ? "resources50_N" : "datatypes50_N."+DT_SUBPKG.getOrDefault(analysis.getName(), "general50_N");
    String cn = analysis.getName()+"50_N";

    StringBuilder b = new StringBuilder();
    b.append("package "+CONV_PKG+"."+subPkg+";\r\n");
    b.append("\r\n");
    b.append("import org.hl7.fhir.convertors.context.ConversionContext50_N;\r\n");
    b.append("import org.hl7.fhir.exceptions.FHIRException;\r\n");
    b.append("\r\n");
    b.append("// generated by the converter generator: R5 <-> R6 ("+version+")\r\n");
    b.append("// the R5 side is asserted from the R6 definitions - compile errors mark real version differences\r\n");
    b.append("\r\n");
    b.append("public class "+cn+" {\r\n");
    b.append("\r\n");

    Set<String> localEnums = new HashSet<>();
    genType(b, analysis, analysis.getRootType(), name, resource, localEnums, true);
    for (TypeInfo ti : analysis.getTypeList()) {
      genType(b, analysis, ti, name, resource, localEnums, false);
    }
    for (String en : Utilities.sorted(localEnums)) {
      EnumInfo ei = analysis.getEnums().get(en);
      if (ei != null) {
        genEnumConverter(b, name, en, ei);
      }
    }
    b.append("}\r\n");

    String fn = Utilities.path(destFolder, subPkg.replace(".", "/"), cn+".java");
    FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fn));
    OutputStreamWriter w = new OutputStreamWriter(ManagedFileAccess.outStream(fn), "UTF-8");
    w.write(b.toString());
    w.flush();
    w.close();
  }

  /** shared enums accumulate across classes; written last */
  public void finish() throws Exception {
    StringBuilder b = new StringBuilder();
    b.append("package "+CONV_PKG+".resources50_N;\r\n");
    b.append("\r\n");
    b.append("import org.hl7.fhir.convertors.context.ConversionContext50_N;\r\n");
    b.append("import org.hl7.fhir.exceptions.FHIRException;\r\n");
    b.append("\r\n");
    b.append("public class Enumerations50_N {\r\n");
    b.append("\r\n");
    for (String n : Utilities.sorted(sharedEnums.keySet())) {
      genEnumConverter(b, "Enumerations", n, sharedEnums.get(n));
    }
    b.append("}\r\n");
    String fn = Utilities.path(destFolder, "resources50_N", "Enumerations50_N.java");
    FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fn));
    OutputStreamWriter w = new OutputStreamWriter(ManagedFileAccess.outStream(fn), "UTF-8");
    w.write(b.toString());
    w.flush();
    w.close();
  }

  private void genType(StringBuilder b, Analysis analysis, TypeInfo ti, String className, boolean resource, Set<String> localEnums, boolean root) throws Exception {
    String tn = ti.getName();
    String home = nHome(className);
    String nType = root ? home+"."+className : home+"."+className+"."+tn;
    String r5Type = root ? R5_PKG+"."+className : R5_PKG+"."+className+"."+tn;
    String mn = "convert"+(root ? analysis.getName() : tn);

    String copy;
    if (root) {
      String anc = analysis.getAncestor() == null ? "" : analysis.getAncestor().getName();
      if (resource) {
        copy = Utilities.existsInList(anc, "Resource") ? "copyResource" : "copyDomainResource";
      } else {
        copy = "copyElement";
      }
    } else {
      copy = "BackboneElement".equals(ti.getAncestorName()) ? "copyBackboneElement" : "copyElement";
    }

    // R5 -> R6
    b.append("  public static "+nType+" "+mn+"("+r5Type+" src) throws FHIRException {\r\n");
    b.append("    if (src == null)\r\n");
    b.append("      return null;\r\n");
    b.append("    "+nType+" tgt = new "+nType+"();\r\n");
    b.append("    "+CTXT+"."+copy+"(src, tgt);\r\n");
    for (ElementDefinition ed : ti.getChildren()) {
      genElement(b, analysis, className, ed, localEnums, true);
    }
    b.append("    return tgt;\r\n");
    b.append("  }\r\n");
    b.append("\r\n");

    // R6 -> R5
    b.append("  public static "+r5Type+" "+mn+"("+nType+" src) throws FHIRException {\r\n");
    b.append("    if (src == null)\r\n");
    b.append("      return null;\r\n");
    b.append("    "+r5Type+" tgt = new "+r5Type+"();\r\n");
    b.append("    "+CTXT+"."+copy+"(src, tgt);\r\n");
    for (ElementDefinition ed : ti.getChildren()) {
      genElement(b, analysis, className, ed, localEnums, false);
    }
    b.append("    return tgt;\r\n");
    b.append("  }\r\n");
    b.append("\r\n");
  }

  private void genElement(StringBuilder b, Analysis analysis, String className, ElementDefinition ed, Set<String> localEnums, boolean toN) throws Exception {
    if ("0".equals(ed.getMax())) {
      return;
    }
    String name = ed.getName().replace("[x]", "");
    String an = Utilities.capitalize(getElementName(name)); // accessor stem
    String jt = ed.getUserString("java.type");
    String ts = ed.typeSummary();
    boolean list = ed.unbounded();
    String srcPkg = toN ? R5_PKG : N_PKG;
    String srcList = toN ? "src.get"+an+"()" : "src.get"+an+"List()";
    String tgtAdd = toN ? "tgt.get"+an+"List().add" : "tgt.get"+an+"().add";

    if (jt != null && jt.startsWith("Enumeration<")) {
      EnumInfo ei = (EnumInfo) ed.getUserData("java.enum");
      String en = jt.substring(jt.indexOf("<")+1, jt.length()-1);
      String conv;
      if (en.contains(".")) { // a core/shared enum (e.g. Enumerations.PublicationStatus or a cross-class use)
        String stem = en.substring(en.lastIndexOf(".")+1);
        conv = CONV_PKG+".resources50_N.Enumerations50_N.convert"+stem;
        if (ei != null && ei.getValueSet() != null) {
          sharedEnums.put(stem, ei);
        }
      } else if (ei != null && ei.getValueSet() != null && ei.getValueSet().hasUserData("shared")) {
        conv = CONV_PKG+".resources50_N.Enumerations50_N.convert"+en;
        sharedEnums.put(en, ei);
      } else {
        conv = "convert"+en;
        localEnums.add(en);
      }
      if (list) {
        String enumClass = toN ? R5_PKG : N_PKG; // where Enumeration itself lives
        String enumOwnerPkg = toN ? R5_PKG : nHome(className);
        b.append("    for ("+enumClass+".Enumeration<"+enumOwnerPkg+"."+enumOwner(className, en, toN)+"> t : "+srcList+")\r\n");
        b.append("      "+tgtAdd+"("+conv+"(t));\r\n");
      } else {
        b.append("    if (src.has"+an+"())\r\n");
        b.append("      tgt.set"+an+"Element("+conv+"(src.get"+an+"Element()));\r\n");
      }
    } else if (isPrimitive(ts)) {
      String pc = primClass(ts);
      String conv = CONV_PKG+".datatypes50_N.primitive50_N."+pc+"50_N.convert"+pc;
      if (list) {
        b.append("    for ("+srcPkg+"."+jt+" t : "+srcList+")\r\n");
        b.append("      "+tgtAdd+"("+conv+"(t));\r\n");
      } else {
        b.append("    if (src.has"+an+"())\r\n");
        b.append("      tgt.set"+an+"Element("+conv+"(src.get"+an+"Element()));\r\n");
      }
    } else if ("xhtml".equals(ts)) {
      b.append("    if (src.has"+an+"())\r\n");
      b.append("      tgt.set"+an+"(src.get"+an+"().copy());\r\n");
    } else if (ts.equals("*") || ed.getType().size() > 1 || "DataType".equals(jt) || "Type".equals(jt)) {
      if (list) {
        b.append("    for ("+srcPkg+".DataType t : "+srcList+")\r\n");
        b.append("      "+tgtAdd+"("+CTXT+".convertType(t));\r\n");
      } else {
        b.append("    if (src.has"+an+"())\r\n");
        b.append("      tgt.set"+an+"("+CTXT+".convertType(src.get"+an+"()));\r\n");
      }
    } else if ("Resource".equals(jt) || "DomainResource".equals(jt)) {
      b.append("    if (src.has"+an+"())\r\n");
      b.append("      tgt.set"+an+"("+CTXT+".convertResource(src.get"+an+"()));\r\n");
    } else if (analysis.getTypes().containsKey(jt) || ed.hasContentReference() || jt.endsWith("Component")) {
      // a component of this class
      String comp = ed.hasContentReference() && analysis.getTypes().containsKey(jt) ? jt : jt;
      String srcType = (toN ? R5_PKG : nHome(className))+"."+className+"."+comp;
      if (list) {
        b.append("    for ("+srcType+" t : "+srcList+")\r\n");
        b.append("      "+tgtAdd+"(convert"+comp+"(t));\r\n");
      } else {
        b.append("    if (src.has"+an+"())\r\n");
        b.append("      tgt.set"+an+"(convert"+comp+"(src.get"+an+"()));\r\n");
      }
    } else {
      // another datatype - delegate to its converter class
      String dt = jt.contains("(") ? ts.contains("Reference") ? "Reference" : jt : jt;
      if (dt.startsWith("Reference(") || "Reference".equals(ts) || ts.startsWith("Reference(")) {
        dt = "Reference";
      }
      String conv = CONV_PKG+".datatypes50_N."+DT_SUBPKG.getOrDefault(dt, "general50_N")+"."+dt+"50_N.convert"+dt;
      String srcType = srcPkg+"."+dt;
      if (list) {
        b.append("    for ("+srcType+" t : "+srcList+")\r\n");
        b.append("      "+tgtAdd+"("+conv+"(t));\r\n");
      } else {
        b.append("    if (src.has"+an+"())\r\n");
        b.append("      tgt.set"+an+"("+conv+"(src.get"+an+"()));\r\n");
      }
    }
  }

  private String enumOwner(String className, String en, boolean toN) {
    return className+"."+en;
  }

  private void genEnumConverter(StringBuilder b, String className, String en, EnumInfo ei) throws Exception {
    ValueSet vs = ei.getValueSet();
    ValueSet vse = vs == null ? null : (ValueSet) vs.getUserData(UserDataNames.EXPANSION);
    String nE = nHome(className)+"."+className+"."+en;
    String r5E = R5_PKG+"."+className+"."+en;
    if (vse == null) {
      b.append("  // unable to expand "+(vs == null ? "??" : vs.getUrl())+" - convert"+en+" must be written by hand\r\n\r\n");
      return;
    }
    List<String> consts = new ArrayList<>();
    for (ValueSetExpansionContainsComponent c : vse.getExpansion().getContains()) {
      consts.add(JavaBaseGenerator.makeConst(Utilities.camelCase(c.getCode())).toUpperCase());
    }
    for (int i = 0; i < 2; i++) {
      boolean toN = i == 0;
      String sE = toN ? r5E : nE;
      String tE = toN ? nE : r5E;
      String sPkg = toN ? R5_PKG : N_PKG;
      String tPkg = toN ? N_PKG : R5_PKG;
      b.append("  static public "+tPkg+".Enumeration<"+tE+"> convert"+en+"("+sPkg+".Enumeration<"+sE+"> src) throws FHIRException {\r\n");
      b.append("    if (src == null || src.isEmpty())\r\n");
      b.append("      return null;\r\n");
      b.append("    "+tPkg+".Enumeration<"+tE+"> tgt = new "+tPkg+".Enumeration<>(new "+tE+"EnumFactory());\r\n");
      b.append("    "+CTXT+".copyElement(src, tgt);\r\n");
      b.append("    if (src.getValue() == null) {\r\n");
      b.append("      tgt.setValue(null);\r\n");
      b.append("    } else {\r\n");
      b.append("      switch (src.getValue()) {\r\n");
      for (String c : consts) {
        b.append("        case "+c+":\r\n");
        b.append("          tgt.setValue("+tE+"."+c+");\r\n");
        b.append("          break;\r\n");
      }
      b.append("        default:\r\n");
      b.append("          tgt.setValue("+tE+".NULL);\r\n");
      b.append("          break;\r\n");
      b.append("      }\r\n");
      b.append("    }\r\n");
      b.append("    return tgt;\r\n");
      b.append("  }\r\n");
      b.append("\r\n");
    }
  }

  private boolean isPrimitive(String ts) {
    return Utilities.existsInList(ts, "base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id",
        "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid")
        || ts.startsWith("canonical(");
  }

  private String primClass(String ts) {
    if (ts.startsWith("canonical(")) {
      return "Canonical";
    }
    if ("markdown".equals(ts)) {
      return "MarkDown";
    }
    return Utilities.capitalize(ts);
  }

  private String getElementName(String name) {
    if (Utilities.existsInList(name, "class", "package", "abstract", "for", "extends", "import", "instanceof", "public",
        "private", "protected", "return", "switch", "case", "default", "new", "interface", "assert")) {
      return name+"_";
    }
    return name;
  }
}
