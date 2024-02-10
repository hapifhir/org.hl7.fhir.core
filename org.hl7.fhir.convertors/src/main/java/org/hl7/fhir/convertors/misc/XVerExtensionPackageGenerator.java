package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ConceptMapUtilities;
import org.hl7.fhir.r5.terminologies.ConceptMapUtilities.TranslatedCode;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.checkerframework.checker.units.qual.s;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.hl7.fhir.convertors.misc.XVerExtensionPackageGenerator.ElementDefinitionPair;
import org.hl7.fhir.convertors.misc.XVerExtensionPackageGenerator.SourcedStructureDefinition;
import org.hl7.fhir.convertors.misc.XVerExtensionPackageGenerator.TheChainSorter;
import org.hl7.fhir.convertors.misc.XVerExtensionPackageGenerator.TranslatePack;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;

public class XVerExtensionPackageGenerator {

  public static class ElementDefinitionPair {

    private StructureDefinition sd;
    private ElementDefinition ed;
    private ConceptMapRelationship rel;
    private boolean valid;
    private String statusReason;
    private String ver;
    private String startVer;
    private String stopVer;
    private String verList;
    private ElementDefinitionPair repeater;

    public ElementDefinitionPair(StructureDefinition sd, ElementDefinition ed, ConceptMapRelationship relationship) {
      this.sd = sd;
      this.ed = ed;
      this.rel = relationship;
      this.ver = sd.getFhirVersion().toCode();
    }
  }

  public static class TheChainSorter implements Comparator<ElementChain> {

    @Override
    public int compare(ElementChain o1, ElementChain o2) {
      return o1.elements.get(0).ed.getPath().compareTo(o2.elements.get(0).ed.getPath());
    }
  }

  public class SourcedStructureDefinition {

    private TranslatePack tp;
    private StructureDefinition structureDefinition;
    private ConceptMapRelationship relationship;
    protected SourcedStructureDefinition(TranslatePack tp, StructureDefinition structureDefinition, ConceptMapRelationship relationship) {
      super();
      this.tp = tp;
      this.structureDefinition = structureDefinition;
      this.relationship = relationship;
    }
    public TranslatePack getTp() {
      return tp;
    }
    public StructureDefinition getStructureDefinition() {
      return structureDefinition;
    }
    public ConceptMapRelationship getRelationship() {
      return relationship;
    }

  }

  public class TranslatePack {

    private String fn;
    private VersionDefinitions definitions;
    private ConceptMap resMap;
    private ConceptMap elementMap;
    public boolean buildTheChain;

    protected TranslatePack(String fn, VersionDefinitions definitions, ConceptMap resMap, ConceptMap elementMap, boolean buildTheChain) {
      super();
      this.fn = fn;
      this.definitions = definitions;
      this.resMap = resMap;
      this.elementMap = elementMap;
      this.buildTheChain = buildTheChain;
    }
    public String getFn() {
      return fn;
    }
    public VersionDefinitions getDefinitions() {
      return definitions;
    }
    public ConceptMap getResMap() {
      return resMap;
    }
    public ConceptMap getElementMap() {
      return elementMap;
    }
  }

  public static class ElementChain {
    private int id; 
    private List<ElementDefinitionPair> elements = new ArrayList<ElementDefinitionPair>();
    public ElementChain(int id, StructureDefinition sd, ElementDefinition ed) {
      super();
      this.id = id;
      elements.add(new ElementDefinitionPair(sd, ed, null));
    }
    public String summary() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (ElementDefinitionPair p : elements) {
        String s = VersionUtilities.getNameForVersion(p.ver);
        if (p.rel == null) {
          b.append(s);
        } else {
          switch (p.rel) {
          case EQUIVALENT:
            b.append("="+s);
            break;
          case NOTRELATEDTO:
            b.append("!="+s);
            break;
          case RELATEDTO:
            b.append("!"+s);
            break;
          case SOURCEISBROADERTHANTARGET:
            b.append(">"+s);
            break;
          case SOURCEISNARROWERTHANTARGET:
            b.append("<"+s);
            break;
          default:
            b.append(s);
            break;
          }
        }
      }
      return elements.get(0).ed.getPath()+" ("+b.toString()+")";
    }
    public boolean hasAllVersions() {
      boolean r2 = false;
      boolean r3 = false;
      boolean r4 = false;
      boolean r4b = false;
      boolean r5 = false;
      for (ElementDefinitionPair p : elements) {
        switch (p.ver) {
        case "1.0.2" : r2 = true; break;
        case "3.0.2" : r3 = true; break;
        case "4.0.1" : r4 = true; break;
        case "4.3.0" : r4b = true; break;
        case "5.0.0" : r5 = true; break;
        default: 
          throw new Error("What? "+p.ver);
        }
      }
      return r2 && r3 && r4 && r4b && r5;
    }
    public String id() {
      return elements.get(0).ed.getPath();
    }
    public boolean hasValid() {

      for (ElementDefinitionPair p : elements) {
        if (p.valid) {
          return true;
        }
      }
      return false;
    }
  }

  public static class VersionDefinitions {
    private FhirPublication version;
    private Map<String, StructureDefinition> structures = new HashMap<>();
    private Map<String, ValueSet> valueSets = new HashMap<>();
    private Map<String, CodeSystem> codeSystems = new HashMap<>();
    public void add(CanonicalResource cr) {
      if (cr instanceof CodeSystem) {
        codeSystems.put(cr.getUrl(), (CodeSystem) cr);
      } else if (cr instanceof ValueSet) {
        valueSets.put(cr.getUrl(), (ValueSet) cr);
      } else if (cr instanceof StructureDefinition) {
        structures.put(cr.getName(), (StructureDefinition) cr);
      }      
    }
    public String summary() {
      return ""+structures.size()+" Structures, "+valueSets.size()+" Value Sets, "+codeSystems.size()+" CodeSystems";
    }  
  }

  public static void main(String[] args) throws Exception {
    new XVerExtensionPackageGenerator().execute(args);
  }

  private List<ElementChain> chains = new ArrayList<>();
  private Map<String, VersionDefinitions> versions = new HashMap<>();

  private void execute(String[] args) throws FHIRException, IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    VersionDefinitions vdr2 = loadR2(pcm);
    VersionDefinitions vdr3 = loadR3(pcm);
    VersionDefinitions vdr4  = loadR4(pcm);
    VersionDefinitions vdr4b = loadR4B(pcm);
    VersionDefinitions vdr5 = loadR5(pcm);

    versions.put("r2", vdr2);
    versions.put("r3", vdr3);
    versions.put("r4", vdr4);
    versions.put("r4b", vdr4b);
    versions.put("r5", vdr5);

    ConceptMap cmr23 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap2to3.json")));
    ConceptMap cmr32 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap3to2.json")));
    ConceptMap cmr34 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap3to4.json")));
    ConceptMap cmr43 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap4to3.json")));
    ConceptMap cmr45 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap4to5.json")));
    ConceptMap cmr54 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap5to4.json")));
    ConceptMap cmr44b = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap4to4B.json")));
    ConceptMap cmr4b4 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap4Bto4.json")));
    ConceptMap cmr54b = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap5to4B.json")));
    ConceptMap cmr4b5 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap4Bto5.json")));
    ConceptMap cme23 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap2to3.json")));
    ConceptMap cme32 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap3to2.json"))); 
    ConceptMap cme34 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap3to4.json")));
    ConceptMap cme43 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap4to3.json")));
    ConceptMap cme45 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap4to5.json")));
    ConceptMap cme54 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap5to4.json")));
    ConceptMap cme44b = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap4to4B.json")));
    ConceptMap cme4b4 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap4Bto4.json")));
    ConceptMap cme4b5 = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap4Bto5.json")));
    ConceptMap cme54b = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap5to4B.json")));
    ConceptMap cmr53 = ConceptMapUtilities.collapse("resourcemap5to3", "http://hl7.org/fhir/interversion/resourcemap5to3", false, cmr54, cmr43);
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(args[0], "R5-ConceptMap-resourcemap5to3.json")), cmr53);
    ConceptMap cmr52 = ConceptMapUtilities.collapse("resourcemap5to2", "http://hl7.org/fhir/interversion/resourcemap5to2", false, cmr54, cmr43, cmr32);
    ConceptMap cme53 = ConceptMapUtilities.collapse("elementmap5to3", "http://hl7.org/fhir/interversion/elementmap5to3", true, cme54, cme43);
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(args[0], "R5-ConceptMap-elementmap5to3.json")), cme53);
    ConceptMap cme52 = ConceptMapUtilities.collapse("elementmap5to2", "http://hl7.org/fhir/interversion/elementmap5to2", true, cme54, cme43, cme32);

    //    
    //    for (File f : new File(args[0]).listFiles()) {
    //      if (f.getName().startsWith("R5-ConceptMap-")) {
    //        System.out.println("Load "+f.getAbsolutePath());
    //        nameMaps.add(
    //      }
    //    }

    // first, generate html rendition of the maps 
    genVersionHtml(args[1], "r2", vdr2, new TranslatePack("r3", vdr3, cmr23, cme23, true));
    genVersionHtml(args[1], "r3", vdr3, new TranslatePack("r2", vdr2, cmr32, cme32, false), new TranslatePack("r4", vdr4, cmr34, cme34, true));
    genVersionHtml(args[1], "r4", vdr4, new TranslatePack("r3", vdr3, cmr43, cme43, false), new TranslatePack("r4b", vdr4b, cmr44b, cme44b, true), new TranslatePack("r5", vdr5, cmr45, cme45, true));
    genVersionHtml(args[1], "r4b", vdr4b, new TranslatePack("r4", vdr4, cmr4b4, cme4b4, false), new TranslatePack("r5", vdr5, cmr4b5, cme4b5, false));
    genVersionHtml(args[1], "r5", vdr5, new TranslatePack("r4", vdr4, cmr54, cme54, false), new TranslatePack("r4b", vdr4b, cmr54b, cme54b, false));
    genVersionHtml(args[1], "r5x", vdr5,
        new TranslatePack("r4b", vdr4b, cmr54b, cme54b, false), 
        new TranslatePack("r4", vdr4, cmr54, cme54, false), 
        new TranslatePack("r3", vdr3, cmr53, cme53, false), 
        new TranslatePack("r2", vdr2, cmr52, cme52, false));


    for (ElementChain chain : chains) {
      if (chain.elements.get(0).ed.getPath().contains(".")) {
        scanChainElements(chain.elements);
      }
    }
    genChainsHtml(args[1], "chains-all", false, false);
    genChainsHtml(args[1], "chains-valid", true, false);
    genChainsHtml(args[1], "chains-min", true, true);
    //    for (VersionDefinitions src : versions) {
    //      for (VersionDefinitions dst : versions) {
    //        if (src != dst) {
    //          generate(src, dst, args[1]);
    //        }
    //      }      
    //    }
    //
    //    for (ConceptMap cm : nameMaps) {
    //      checkCM(cm);
    //    }    

    System.out.println("Finished");

  }

  private void genChainsHtml(String path, String filename, boolean validOnly, boolean itemsOnly) throws IOException {
    System.out.println("Create "+filename);
    XhtmlNode page = new XhtmlNode(NodeType.Element, "html");
    XhtmlNode head = page.head();
    head.link("stylesheet", "fhir.css");
    head.title("FHIR Cross Version Extensions");
    XhtmlNode body = page.body();
    body.style("background-color: white");
    body.h1().tx("FHIR Cross Version Extensions");
    body.para().tx("something");

    Collections.sort(chains, new TheChainSorter());

    body.h2().tx("Element Chains");
    XhtmlNode ul = null;
    for (ElementChain chain : chains) {
      String n = chain.elements.get(0).ed.getPath();
      if (!n.contains(".")) {
        body.para().tx(n);
        ul = null;
      } else if (!validOnly || chain.hasValid()) { 
        if (ul == null) {
          ul = body.ul();
        }
        XhtmlNode li = ul.li();
        li.tx(chain.id());
        XhtmlNode uli = li.ul();
        for (ElementDefinitionPair ed : chain.elements) {
          if (!itemsOnly || ed.valid) {
            renderElementDefinition(uli.li(), ed);
          }
        }
      }
    }

    TextFile.stringToFile(new XhtmlComposer(false, false).compose(page), Utilities.path(path, filename+".html"));

  }

  private void scanChainElements(List<ElementDefinitionPair> elements) {
    ElementDefinitionPair template = null;
    for (ElementDefinitionPair element : elements) {
      if (template == null) {
        element.statusReason = null;
        element.valid = true;
        template = element;
        template.startVer = element.ver;
        template.stopVer = element.ver; 
      } else {
        if (element.rel != ConceptMapRelationship.EQUIVALENT) {
          element.statusReason = "Not Equivalent";
          element.valid = true;
          template = element;        
          template.startVer = element.ver;
          template.stopVer = element.ver; 
        } else if (!template.ed.repeats() && element.ed.repeats()) {
          element.statusReason = "Element repeats";
          element.valid = true;
          template.repeater = element;
          template = element;        
          template.startVer = element.ver;
          template.stopVer = element.ver; 
        } else {
          List<String> newTypes = findNewTypes(template.ed, element.ed);
          if (!newTypes.isEmpty()) {
            element.statusReason = "New Types "+CommaSeparatedStringBuilder.join("|", newTypes);
            element.valid = true;
            template = element;        
            template.startVer = element.ver;
            template.stopVer = element.ver; 
          } else {
            List<String> newTargets = findNewTargets(template.ed, element.ed);
            if (!newTargets.isEmpty()) {
              element.statusReason = "New Targets "+CommaSeparatedStringBuilder.join("|", newTargets);
              element.valid = true;
              template = element;        
              template.startVer = element.ver;
              template.stopVer = element.ver; 
            } else {
              element.statusReason = "No Change";
              element.valid = false;
              template.stopVer = element.ver; 
            }
          }
        }
      }   
    }
    if (template == elements.get(0) && elements.size() == 5) {
      template.valid = false;
      template.statusReason = "has existed in all versions";
    }
    for (ElementDefinitionPair element : elements) {
      if (element.valid) {
        CommaSeparatedStringBuilder vers = new CommaSeparatedStringBuilder();
        String bv = element.startVer;
        String ev = element.repeater != null ? element.repeater.stopVer : element.stopVer;
        
        if (!VersionUtilities.includedInRange(bv, ev, "1.0.2")) {
          vers.append("R2");
        }
        if (!VersionUtilities.includedInRange(bv, ev, "3.0.2")) {
          vers.append("R3");
        }
        if (!VersionUtilities.includedInRange(bv, ev, "4.0.1")) {
          vers.append("R4");
        }
        if (!VersionUtilities.includedInRange(bv, ev, "4.3.0")) {
          vers.append("R4B");
        }
        if (!VersionUtilities.includedInRange(bv, ev, "5.0.0")) {
          vers.append("R5");
        }
        if (vers.count() == 0) {
          element.valid = false;
          element.statusReason = "??";
        } else {
          element.verList = vers.toString();
        }
      }


    }
  }

  private List<String> findNewTypes(ElementDefinition template, ElementDefinition element) {
    Set<String> types = new HashSet<>();
    for (TypeRefComponent tr : template.getType()) {
      types.add(tr.getWorkingCode());
    }
    List<String> res = new ArrayList<>();
    for (TypeRefComponent tr : element.getType()) {
      if (!types.contains(tr.getWorkingCode())) {
        res.add(tr.getWorkingCode());
      }
    }
    return res;
  }


  private List<String> findNewTargets(ElementDefinition template, ElementDefinition element) {
    Set<String> targets = new HashSet<>();
    for (TypeRefComponent tr : template.getType()) {
      for (CanonicalType c : tr.getTargetProfile()) {
        targets.add(c.asStringValue());
      }
    }
    List<String> res = new ArrayList<>();
    for (TypeRefComponent tr : element.getType()) {
      for (CanonicalType c : tr.getTargetProfile()) {
        if (!targets.contains(c.asStringValue())) {
          res.add(tail(c.asStringValue()));
        }
      }
    }
    return res;
  }

  private void renderElementDefinition(XhtmlNode x, ElementDefinitionPair ed) {
    String ver = VersionUtilities.getMajMin(ed.ver);
    String prefix = VersionUtilities.getNameForVersion(ver).toLowerCase();
    Map<String, StructureDefinition> structures = versions.get(prefix).structures;

    XhtmlNode x1 = ed.valid ? x : x.strikethrough();

    x1.code("http://hl7.org/fhir/"+ver+"/StructureDefinition/extension-"+ed.ed.getPath());

    boolean first = true;
    for (TypeRefComponent t : ed.ed.getType()) {
      StructureDefinition sd = structures.get(t.getWorkingCode());
      if (sd != null && !sd.getAbstract()) {
        if (first) {x1.tx(" : "); first = false; } else { x1.tx("|");  x1.wbr(); }
        x1.ah(prefix+"#"+t.getWorkingCode()).tx(t.getWorkingCode());
        if (t.hasTargetProfile()) {
          x1.tx("(");
          boolean tfirst = true;
          for (CanonicalType u : t.getTargetProfile()) {
            if (tfirst) {tfirst = false; } else { x1.tx("|"); x1.wbr(); }
            String rt = tail(u.getValue());
            x1.ah(prefix+"#"+rt).tx(rt);
          }

          x1.tx(")");
        }
      }
    }
    x1.tx(" : ");
    x1.tx("[");
    x1.tx(ed.ed.getMin());
    x1.tx("..");
    x1.tx(ed.ed.getMax());
    x1.tx("].");

    if (ed.valid) {
      x.tx(" Valid versions: "+ed.verList);
    } else {
      x.tx(" Not valid because "+ed.statusReason);
    }
  }

  private void genVersionHtml(String path, String filename, VersionDefinitions definitions, TranslatePack... translations) throws IOException {
    System.out.println("Create "+filename);
    XhtmlNode page = new XhtmlNode(NodeType.Element, "html");
    XhtmlNode head = page.head();
    head.link("stylesheet", "fhir.css");
    head.title("FHIR Version "+definitions.version.toCode());
    XhtmlNode body = page.body();
    body.style("background-color: white");
    body.h1().tx("FHIR Version "+definitions.version.toCode());
    body.para().tx("something");
    XhtmlNode p = body.para();
    p.ah("#primitives").tx("Primitives");
    p.tx(" | ");
    p.ah("#types").tx("Data Types");
    p.tx(" | ");
    p.ah("#resources").tx("Resources");

    body.h2().tx("Primitive Types");
    body.an("primitives");
    XhtmlNode tbl = body.table("grid");
    XhtmlNode tr = tbl.tr();
    tr.th().tx("Primitive Type");
    for (TranslatePack tp : translations) {
      tr.th().ah(tp.getFn()+".html#primitives").tx(tp.definitions.version.toCode());
    }
    for (String name : Utilities.sorted(definitions.structures.keySet())) {
      StructureDefinition sd = definitions.structures.get(name);
      if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
        tr = tbl.tr();
        tr.td().tx(name);
        for (TranslatePack tp : translations) {          
          tr.td().tx(tp.definitions.structures.containsKey(name) ? name : null);
        }        
      }
    }
    body.an("types");
    body.h2().tx("Complex Types");
    body.para().tx("Index");
    XhtmlNode ndx = body.ul().style("column-count: 5");

    for (String name : Utilities.sorted(definitions.structures.keySet())) {
      StructureDefinition sd = definitions.structures.get(name);
      if (sd.getKind() == StructureDefinitionKind.COMPLEXTYPE && !sd.getAbstract() && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        ndx.li().ah("#"+name).tx(name);
        body.an(name);
        body.h3().tx(name);
        tbl = body.table("grid");
        tr = tbl.tr();
        tr.th().tx(VersionUtilities.getNameForVersion(sd.getFhirVersion().toCode())+" Element");
        List<SourcedStructureDefinition> matches = new ArrayList<>();
        for (TranslatePack tp : translations) {
          matches.add(new SourcedStructureDefinition(tp, tp.getDefinitions().structures.get(name), ConceptMapRelationship.EQUIVALENT));
        }        
        for (SourcedStructureDefinition ssd : matches) {
          tr.th().ah(ssd.tp.getFn()+".html").tx(ssd.tp.definitions.version.toCode());
        }
        for (ElementDefinition ed : sd.getDifferential().getElement()) {
          tr = tbl.tr();
          rendererElement(tr.td(), ed, "", definitions.structures, null, null);
          for (SourcedStructureDefinition ssd : matches) {
            if (ssd.structureDefinition != null) {
              List<ElementDefinitionPair> edtl = findTranslatedElements(ed, ssd.structureDefinition, ssd.tp.elementMap, ssd.tp.elementMap.getId(), ssd.relationship);
              if (edtl.isEmpty()) {
                if (ssd.tp.buildTheChain) {
                  if (!ed.hasUserData("chains")) {
                    ElementChain chain = new ElementChain(chains.size()+1, sd, ed);
                    chains.add(chain);
                    List<ElementChain> echains = new ArrayList<XVerExtensionPackageGenerator.ElementChain>();
                    echains.add(chain);
                    ed.setUserData("chains", echains);
                  }
                }
                tr.td().style("background-color: #eeeeee");
              } else {
                XhtmlNode td = tr.td();
                boolean first = true;
                for (ElementDefinitionPair edt : edtl) {
                  if (ssd.tp.buildTheChain) {
                    if (!ed.hasUserData("chains")) {
                      ElementChain chain = new ElementChain(chains.size()+1, sd, ed);
                      chains.add(chain);
                      List<ElementChain> echains = new ArrayList<XVerExtensionPackageGenerator.ElementChain>();
                      echains.add(chain);
                      ed.setUserData("chains", echains);
                    }
                    List<ElementChain> echains = (List<ElementChain>) edt.ed.getUserData("chains");
                    if (echains == null) {
                      echains = new ArrayList<XVerExtensionPackageGenerator.ElementChain>();
                      edt.ed.setUserData("chains", echains);
                    }
                    for (ElementChain chain : (List<ElementChain>) ed.getUserData("chains")) {
                      chain.elements.add(edt);
                      if (!echains.contains(chain)) {
                        echains.add(chain);
                      }
                    }
                  }
                  if (first) first = false; else td.br();
                  rendererElement(td, edt.ed, ssd.tp.fn+".html", ssd.tp.definitions.structures, ed.getPath(), edt.rel);
                }
              }
            } else if (ed.getPath().contains(".")) {
              tr.td().tx("");
            } else {
              tr.td().style("background-color: #eeeeee");
            }
          }                  
        }
      }
    }
    body.an("resources");
    body.h2().tx("Resources");
    body.para().tx("Index");
    ndx = body.ul().style("column-count: 5");

    for (String name : Utilities.sorted(definitions.structures.keySet())) {
      StructureDefinition sd = definitions.structures.get(name);
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && !sd.getAbstract() && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        ndx.li().ah("#"+name).tx(name);
        body.an(name);
        body.h3().tx(name);
        tbl = body.table("grid");
        tr = tbl.tr();
        tr.th().tx("Element");

        List<SourcedStructureDefinition> matches = new ArrayList<>();
        for (TranslatePack tp : translations) {
          List<TranslatedCode> names = translateResourceName(tp.getResMap(), name);
          if (names.isEmpty()) {
            matches.add(new SourcedStructureDefinition(tp, null, null));
          } else {
            for (TranslatedCode n : names) {
              matches.add(new SourcedStructureDefinition(tp, tp.getDefinitions().structures.get(n.getCode()), n.getRelationship()));
            }
          }
        }        
        for (SourcedStructureDefinition ssd : matches) {
          tr.th().ah(ssd.tp.getFn()+".html").tx(ssd.tp.definitions.version.toCode());
        }        
        for (ElementDefinition ed : sd.getDifferential().getElement()) {
          tr = tbl.tr();
          rendererElement(tr.td(), ed, "", definitions.structures, null, null);
          for (SourcedStructureDefinition ssd : matches) {
            if (ssd.structureDefinition != null) {
              List<ElementDefinitionPair> edtl = findTranslatedElements(ed, ssd.structureDefinition, ssd.tp.elementMap, ssd.tp.elementMap.getId(), ssd.relationship);
              if (edtl.isEmpty()) {
                if (ssd.tp.buildTheChain) {
                  if (!ed.hasUserData("chains")) {
                    ElementChain chain = new ElementChain(chains.size()+1, sd, ed);
                    chains.add(chain);
                    List<ElementChain> echains = new ArrayList<XVerExtensionPackageGenerator.ElementChain>();
                    echains.add(chain);
                    ed.setUserData("chains", echains);
                  }
                }
                tr.td().style("background-color: #eeeeee");
              } else {
                XhtmlNode td = tr.td();
                boolean first = true;
                for (ElementDefinitionPair edt : edtl) {
                  if (ssd.tp.buildTheChain) {
                    if (!ed.hasUserData("chains")) {
                      ElementChain chain = new ElementChain(chains.size()+1, sd, ed);
                      chains.add(chain);
                      List<ElementChain> echains = new ArrayList<XVerExtensionPackageGenerator.ElementChain>();
                      echains.add(chain);
                      ed.setUserData("chains", echains);
                    }
                    List<ElementChain> echains = (List<ElementChain>) edt.ed.getUserData("chains");
                    if (echains == null) {
                      echains = new ArrayList<XVerExtensionPackageGenerator.ElementChain>();
                      edt.ed.setUserData("chains", echains);
                    }
                    for (ElementChain chain : (List<ElementChain>) ed.getUserData("chains")) {
                      chain.elements.add(edt);
                      if (!echains.contains(chain)) {
                        echains.add(chain);
                      }
                    }
                  }
                  if (first) first = false; else td.br();
                  rendererElement(td, edt.ed, ssd.tp.fn+".html", ssd.tp.definitions.structures, ed.getPath(), edt.rel);
                }
              }
            } else if (ed.getPath().contains(".")) {
              tr.td().tx("");
            } else {
              tr.td().style("background-color: #eeeeee");
            }
          }                  
        }      
      }
    }

    TextFile.stringToFile(new XhtmlComposer(false, false).compose(page), Utilities.path(path, filename+".html"));
  }

  private List<ConceptMapUtilities.TranslatedCode> translateResourceName(ConceptMap map, String name) {
    List<ConceptMapUtilities.TranslatedCode> res = new ArrayList<>();
    for (ConceptMapGroupComponent g : map.getGroup()) {
      for (SourceElementComponent e : g.getElement()) {
        if (e.getCode().equals(name)) {
          for (TargetElementComponent t : e.getTarget()) {
            if (t.getRelationship() == ConceptMapRelationship.EQUIVALENT) {
              res.add(new ConceptMapUtilities.TranslatedCode(t.getCode(), t.getRelationship()));
            } else if (t.getRelationship() == ConceptMapRelationship.SOURCEISBROADERTHANTARGET) {
              res.add(new ConceptMapUtilities.TranslatedCode(t.getCode(), t.getRelationship()));
            } else if (t.getRelationship() == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
              res.add(new ConceptMapUtilities.TranslatedCode(t.getCode(), t.getRelationship()));
            }
          }
        }
      }
    }
    return res;
  }

  private List<ElementDefinitionPair> findTranslatedElements(ElementDefinition eds, StructureDefinition structureDefinition, ConceptMap elementMap, String tpid, ConceptMapRelationship resrel) {
    List<ElementDefinitionPair> res = new ArrayList<ElementDefinitionPair>();
    String path = eds.getPath();
    String epath = path.contains(".") ? structureDefinition.getName()+path.substring(path.indexOf(".") ): structureDefinition.getName();
    List<TranslatedCode> names = translateElementName(path, elementMap, epath);
    for (TranslatedCode n : names) {
      ElementDefinition ed = structureDefinition.getDifferential().getElementByPath(n.getCode());
      if (ed != null) {
        res.add(new ElementDefinitionPair(structureDefinition, ed, ConceptMapUtilities.combineRelationships(resrel, n.getRelationship())));
      }
    }
    return res;
  }

  private List<TranslatedCode> translateElementName(String name, ConceptMap map, String def) {
    List<TranslatedCode> res = new ArrayList<>();
    for (ConceptMapGroupComponent g : map.getGroup()) {
      boolean found = false;
      for (SourceElementComponent e : g.getElement()) {
        if (e.getCode().equals(name) || e.getCode().equals(def)) {
          found = true;
          for (TargetElementComponent t : e.getTarget()) {
            if (t.getRelationship() == ConceptMapRelationship.EQUIVALENT || t.getRelationship() == ConceptMapRelationship.SOURCEISBROADERTHANTARGET || t.getRelationship() == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
              res.add(new TranslatedCode(t.getCode(), t.getRelationship()));
            }
          }
        }
      }
      if (!found) {
        res.add(new TranslatedCode(def, ConceptMapRelationship.EQUIVALENT));
      }
    }
    return res;
  }

  private void rendererElement(XhtmlNode td, ElementDefinition ed, String prefix, Map<String, StructureDefinition> structures, String origName, ConceptMapRelationship relationship) {
    if (relationship != null) {
      switch (relationship) {
      case EQUIVALENT:
        td.tx("=");
        break;
      case NOTRELATEDTO:
        td.tx("!=");
        break;
      case RELATEDTO:
        td.tx("~");
        break;
      case SOURCEISBROADERTHANTARGET:
        td.tx(">");
        break;
      case SOURCEISNARROWERTHANTARGET:
        td.tx("<");
        break;
      }
    }

    if (ed.getPath().contains(".")) {
      XhtmlNode span = td.span().attribute("title", ed.getPath());
      if (origName != null && !origName.equals(ed.getPath())) {
        span.style("color: maroon; font-weight: bold");
      }
      String[] p = ed.getPath().split("\\.");
      for (int i = 0; i < p.length; i++) {
        if (i == p.length - 1) {
          span.tx(p[i]);
        } else {
          span.tx(p[i].substring(0, 1));
          span.tx(".");
        }
      }
      boolean first = true;
      for (TypeRefComponent t : ed.getType()) {
        StructureDefinition sd = structures.get(t.getWorkingCode());
        if (sd != null && !sd.getAbstract()) {
          if (first) {td.tx(" : "); first = false; } else { td.tx("|");  td.wbr(); }
          td.ah(prefix+"#"+t.getWorkingCode()).tx(t.getWorkingCode());
          if (t.hasTargetProfile()) {
            td.tx("(");
            boolean tfirst = true;
            for (CanonicalType u : t.getTargetProfile()) {
              if (tfirst) {tfirst = false; } else { td.tx("|"); td.wbr(); }
              String rt = tail(u.getValue());
              td.ah(prefix+"#"+rt).tx(rt);
            }

            td.tx(")");
          }
        }
      }
      td.tx(" : ");
      td.tx("[");
      td.tx(ed.getMin());
      td.tx("..");
      td.tx(ed.getMax());
      td.tx("]");    
    } else {
      if (Utilities.noString(prefix)) {
        td.tx(ed.getPath());
      } else {
        XhtmlNode ah = td.ah(prefix+"#"+ed.getPath());
        if (origName != null && !origName.equals(ed.getPath())) {
          ah.style("color: maroon; font-weight: bold");
        }
        ah.tx(ed.getPath());        
      }
    }
  }

  private String tail(String value) {
    return value.contains("/") ? value.substring(value.lastIndexOf("/")+1) : value;
  }

  private void checkCM(ConceptMap cm) {
    System.out.println("Check: "+cm.getId());
    Set<String> src = new HashSet<>();
    for (ConceptMapGroupComponent g : cm.getGroup()) {
      for (SourceElementComponent e : g.getElement()) {
        if (!e.hasUserData("used")) {          
          System.out.println("  Unused code: "+e.getCode());
        }
        src.add(e.getCode());
      }      
    }
  }

  private VersionDefinitions loadR2(FilesystemPackageCacheManager pcm) throws FHIRException, IOException {
    VersionDefinitions vd = new VersionDefinitions();
    vd.version = FhirPublication.DSTU2;
    System.out.print("Load "+vd.version.toCode());
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r2.core");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem")) {
      BaseAdvisor_10_50 advisor = new BaseAdvisor_10_50();
      CanonicalResource cr = (CanonicalResource) VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(npm.load(n)), advisor);
      for (CodeSystem cs : advisor.getCslist()) {
        vd.add(cs);
      }
      vd.add(cr);
    }    
    System.out.println(": "+vd.summary());
    return vd;
  }

  private VersionDefinitions loadR3(FilesystemPackageCacheManager pcm) throws FHIRException, IOException {
    VersionDefinitions vd = new VersionDefinitions();
    vd.version = FhirPublication.STU3;
    System.out.print("Load "+vd.version.toCode());
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r3.core");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem")) {
      CanonicalResource cr = (CanonicalResource) VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(npm.load(n)));
      vd.add(cr);
    }    
    System.out.println(": "+vd.summary());
    return vd;
  }

  private VersionDefinitions loadR4(FilesystemPackageCacheManager pcm) throws FHIRFormatError, FHIRException, IOException {
    VersionDefinitions vd = new VersionDefinitions();
    vd.version = FhirPublication.R4;
    System.out.print("Load "+vd.version.toCode());
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r4.core");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem")) {
      CanonicalResource cr = (CanonicalResource) VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(npm.load(n)));
      vd.add(cr);
    }    
    System.out.println(": "+vd.summary());
    return vd;
  }

  private VersionDefinitions loadR4B(FilesystemPackageCacheManager pcm) throws FHIRException, IOException {
    VersionDefinitions vd = new VersionDefinitions();
    vd.version = FhirPublication.R4B;
    System.out.print("Load "+vd.version.toCode());
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r4b.core");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem")) {
      CanonicalResource cr = (CanonicalResource) VersionConvertorFactory_43_50.convertResource(new org.hl7.fhir.r4b.formats.JsonParser().parse(npm.load(n)));
      vd.add(cr);
    }    
    System.out.println(": "+vd.summary());
    return vd;
  }

  private VersionDefinitions loadR5(FilesystemPackageCacheManager pcm) throws FHIRException, IOException {
    VersionDefinitions vd = new VersionDefinitions();
    vd.version = FhirPublication.R5;
    System.out.print("Load "+vd.version.toCode());
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r5.core");
    for (String n : npm.listResources("StructureDefinition", "ValueSet", "CodeSystem")) {
      CanonicalResource cr = (CanonicalResource) new org.hl7.fhir.r5.formats.JsonParser().parse(npm.load(n));
      vd.add(cr);
    }    
    System.out.println(": "+vd.summary());
    return vd;
  }

  private void generate(VersionDefinitions src, VersionDefinitions dst, String dstDir) throws IOException {
    String fn = "hl7.fhir.extensions."+VersionUtilities.getNameForVersion(src.version.toCode())+":"+dst.version.toCode()+".tgz";
    String fnt = VersionUtilities.getNameForVersion(src.version.toCode())+"-"+VersionUtilities.getNameForVersion(dst.version.toCode())+".txt";
    StringBuilder s = new StringBuilder();
    s.append("Paths to generate Extensions for:\r\n");
    System.out.println("Generate "+fn);
    Map<String, StructureDefinition> structures = new HashMap<>();
    Map<String, ValueSet> valueSets = new HashMap<>();
    Map<String, CodeSystem> codeSystems = new HashMap<>();
    for (String name : Utilities.sorted(src.structures.keySet())) {
      StructureDefinition sd = src.structures.get(name);
      lookForExtensions(sd, src, dst, structures, valueSets, codeSystems, s);
    }
    TextFile.stringToFile(s.toString(), Utilities.path(dstDir, fnt));
    buildOutputPackage(fn, structures, valueSets, codeSystems); 
  }

  private void lookForExtensions(StructureDefinition sd, VersionDefinitions src, VersionDefinitions dst, Map<String, StructureDefinition> structures, Map<String, ValueSet> valueSets, Map<String, CodeSystem> codeSystems, StringBuilder s) {
    if ((sd.getKind() == StructureDefinitionKind.RESOURCE || sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()
        && !Utilities.existsInList(sd.getName(), "Element", "BackboneElement", "Resource", "DomainResource")) {
      String name = getTargetResourceName(sd.getName(), src.version, dst.version);
      StructureDefinition sdt = dst.structures.get(name);
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        if (!ed.getPath().endsWith(".id") && !ed.getPath().endsWith(".extension") && !ed.getPath().endsWith(".modifierExtension") && !Utilities.existsInList(ed.typeSummary(), "Element", "BackboneElement")) {
          ElementDefinition md = getMatchingDefinition(sd, sdt, name, ed, dst.structures, src.version, dst.version);
          if (md == null) {
            System.out.println("  xve: "+ed.getPath());
            s.append("    { \"code\" : \""+ed.getPath()+"\", \"noMap\" : true },\r\n");
          } else {
            for (TypeRefComponent tr : ed.getType()) {
              if (Utilities.existsInList(tr.getWorkingCode(), "Element", "BackboneElement")) {
                boolean typeFound = false;
                for (TypeRefComponent dtr : md.getType()) {
                  if (typeMatches(dtr.getWorkingCode(), tr.getWorkingCode())) {
                    typeFound = true;
                    break;
                  }
                }
                if (!typeFound) {
                  System.out.println("  xve: "+ed.getPath()+" for "+tr.getCode());
                  // s.append(ed.getPath()+" for "+tr.getCode()+"\r\n");
                }
              }
            }
          }
        }
      }
    }
  }

  private boolean typeMatches(String c1, String c2) {
    if (c1.equals(c2)) {
      return true;
    }
    if (Utilities.existsInList(c1, "string", "markdown") && Utilities.existsInList(c2, "string", "markdown")) {
      return true;
    }
    if (Utilities.existsInList(c1, "url", "uri", "canonical") && Utilities.existsInList(c2, "url", "uri", "canonical")) {
      return true;
    }
    return false;
  }

  private ElementDefinition getMatchingDefinition(StructureDefinition sd, StructureDefinition sdt, String name, ElementDefinition ed, Map<String, StructureDefinition> structures, FhirPublication srcVer, FhirPublication dstVer) {
    if (sdt == null) {
      return null;
    }
    // the resource renaming and element renaming information is a little disjunct :-(
    // so we try it twice 
    String ename = getTargetElementName(ed.getPath(), srcVer, dstVer);
    if (ename != null) {
      ElementDefinition edt = getElementBypath(ename, sdt, structures);
      if (edt != null) {
        return edt;
      }
    }
    if (ed.getPath().contains(".")) {
      ename = name+ed.getPath().substring(ed.getPath().indexOf("."));
    } else {
      ename = name;
    }
    ename = getTargetElementName(ename, srcVer, dstVer);
    return ename == null ? null : getElementBypath(ename, sdt, structures);
  }

  private ElementDefinition getElementBypath(String ename, StructureDefinition sdt,  Map<String, StructureDefinition> structures) {
    ElementDefinition ed = sdt.getSnapshot().getElementByPath(ename);
    if (ed != null) {
      return ed;
    }
    String n = head(ename);
    while (n.contains(".")) {
      ed = sdt.getSnapshot().getElementByPath(n);
      if (ed != null) {
        if (ed.getType().size() != 1) {
          return null;
        }
        StructureDefinition sd = structures.get(ed.getTypeFirstRep().getCode());
        if (sd != null && !sd.getAbstract() && sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
          return getElementBypath(sd.getName()+"."+ename.substring(n.length()+1), sd, structures);
        } else {
          return null;
        }
      } else {
        n = head(n);
      }
    }
    return null;    
  }

  private String head(String n) {
    if (n.contains(".")) {
      return n.substring(0, n.lastIndexOf("."));
    } else {
      return n;
    }
  }


  private String getTargetElementName(String name, FhirPublication srcVer, FhirPublication dstVer) {
    switch (srcVer) {
    case DSTU2:
      switch (dstVer) {
      case DSTU2:
        return name;
      case STU3:
        return tn(name, true, "elementmap2to3");
      case R4:
        return tn(name, true, "elementmap2to3", "elementmap3to4");
      case R4B:
        return tn(name, true, "elementmap2to3", "elementmap3to4", "elementmap4to4B");
      case R5:
        return tn(name, true, "elementmap2to3", "elementmap3to4", "elementmap4to5");
      default:
        throw new Error("Unable to map element name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case STU3:
      switch (dstVer) {
      case DSTU2:
        return tn(name, true, "-elementmap2to3");
      case STU3:
        return name;
      case R4:
        return tn(name, true, "elementmap3to4");
      case R4B:
        return tn(name, true, "elementmap3to4", "elementmap4to4B");
      case R5:
        return tn(name, true, "elementmap3to4", "elementmap4to5");
      default:
        throw new Error("Unable to map element name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case R4:
      switch (dstVer) {
      case DSTU2:
        return tn(name, true, "-elementmap3to4", "-elementmap2to3");
      case STU3:
        return tn(name, true, "-elementmap3to4");
      case R4:
        return name;
      case R4B:
        return tn(name, true, "elementmap4to4B");
      case R5:
        return tn(name, true, "elementmap4to5");
      default:
        throw new Error("Unable to map element name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case R4B:
      switch (dstVer) {
      case DSTU2:
        return tn(name, true, "-elementmap4to4B", "-elementmap3to4", "-elementmap2to3");
      case STU3:
        return tn(name, true, "-elementmap4to4B", "-elementmap3to4");
      case R4:
        return tn(name, true, "-elementmap4to4B");
      case R4B:
        return name;
      case R5:
        return tn(name, true, "elementmap4Bto5");
      default:
        throw new Error("Unable to map element name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case R5:
      switch (dstVer) {
      case DSTU2:
        return tn(name, true, "-elementmap4to5", "-elementmap3to4", "-elementmap2to3");
      case STU3:
        return tn(name, true, "-elementmap4to5", "-elementmap3to4");
      case R4:
        return tn(name, true, "-elementmap4to5");
      case R4B:
        return tn(name, true, "-elementmap4Bto5");
      case R5:
        return name;
      default:
        throw new Error("Unable to map element name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    default:
      throw new Error("Unable to map element name from "+srcVer.toCode()+" to "+dstVer.toCode());    
    }
  }
  private String getTargetResourceName(String name, FhirPublication srcVer, FhirPublication dstVer) {
    if (Utilities.existsInList(name, "base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", 
        "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "CodeableReference", "Coding", 
        "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "RatioRange", "Reference", 
        "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", 
        "TriggerDefinition", "UsageContext", "Availability", "ExtendedContactDetail", "Dosage", "Meta", "Extension", "ElementDefinition", "Narrative", 
        "MarketingStatus", "ProductShelfLife", "ProdCharacteristic", "Population")) {
      return name; // data types that haven't been renamed
    }
    switch (srcVer) {
    case DSTU2:
      switch (dstVer) {
      case DSTU2:
        return name;
      case STU3:
        return tn(name, false, "resourcemap2to3");
      case R4:
        return tn(name, false, "resourcemap2to3", "resourcemap3to4");
      case R4B:
        return tn(name, false, "resourcemap2to3", "resourcemap3to4", "resourcemap4to4B");
      case R5:
        return tn(name, false, "resourcemap2to3", "resourcemap3to4", "resourcemap4to5");
      default:
        throw new Error("Unable to map resource name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case STU3:
      switch (dstVer) {
      case DSTU2:
        return tn(name, false, "resourcemap3to2");
      case STU3:
        return name;
      case R4:
        return tn(name, false, "resourcemap3to4");
      case R4B:
        return tn(name, false, "resourcemap3to4", "resourcemap4to4B");
      case R5:
        return tn(name, false, "resourcemap3to4", "resourcemap4to5");
      default:
        throw new Error("Unable to map resource name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case R4:
      switch (dstVer) {
      case DSTU2:
        return tn(name, false, "resourcemap4to3", "resourcemap3to2");
      case STU3:
        return tn(name, false, "resourcemap4to3");
      case R4:
        return name;
      case R4B:
        return tn(name, false, "resourcemap4to4B");
      case R5:
        return tn(name, false, "resourcemap4to5");
      default:
        throw new Error("Unable to map resource name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case R4B:
      switch (dstVer) {
      case DSTU2:
        return tn(name, false, "resourcemap4Bto4", "resourcemap4to3", "resourcemap3to2");
      case STU3:
        return tn(name, false, "resourcemap4Bto4", "resourcemap4to3");
      case R4:
        return tn(name, false, "resourcemap4Bto4");
      case R4B:
        return name;
      case R5:
        return tn(name, false, "resourcemap4Bto5");
      default:
        throw new Error("Unable to map resource name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    case R5:
      switch (dstVer) {
      case DSTU2:
        return tn(name, false, "resourcemap5to4", "resourcemap4to3", "resourcemap3to2");
      case STU3:
        return tn(name, false, "resourcemap5to4", "resourcemap4to3");
      case R4:
        return tn(name, false, "resourcemap5to4");
      case R4B:
        return tn(name, false, "resourcemap5to4B");
      case R5:
        return name;
      default:
        throw new Error("Unable to map resource name from "+srcVer.toCode()+" to "+dstVer.toCode());      
      }
    default:
      throw new Error("Unable to map resource name from "+srcVer.toCode()+" to "+dstVer.toCode());    
    }
  }

  private String tn(String name, boolean defToName, String... names) {
    String n = name;
    for (String id : names) {
      boolean reverse = false;
      if (id.startsWith("-")) {
        reverse = true;
        id = id.substring(1);
      }
      if (n != null) {
        ConceptMap cm = getCM(id);
        n = translate(cm, n, defToName, reverse);
      }
    }
    return n;
  }

  private String translate(ConceptMap cm, String n, boolean defToName, boolean reverse) {
    for (ConceptMapGroupComponent g : cm.getGroup()) {
      for (SourceElementComponent t : g.getElement()) {
        if (reverse) {
          for (TargetElementComponent m : t.getTarget()) {
            if (n.equals(m.getCode())) {
              t.setUserData("used", true);
              return t.getCode();
            }
          }
        } else {
          if (n.equals(t.getCode())) {
            t.setUserData("used", true);
            for (TargetElementComponent m : t.getTarget()) {
              return m.getCode();
            }
            return null;
          }
        }
      }
    }
    return defToName ? n : null;
  }

  private ConceptMap getCM(String id) {
    //
    //    for (ConceptMap cm : nameMaps) {
    //      if (cm.getId().equals(id)) {
    //        return cm;
    //      }
    //    }
    throw new Error("Unable to resolve map "+id);
  }

  private void buildOutputPackage(String fn, Map<String, StructureDefinition> structures,
      Map<String, ValueSet> valueSets, Map<String, CodeSystem> codeSystems) {
    // TODO Auto-generated method stub

  }

}
