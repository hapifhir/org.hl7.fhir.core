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
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.fhir.ucum.Concept;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.renderers.ConceptMapRenderer;
import org.hl7.fhir.r5.renderers.ConceptMapRenderer.IConceptMapInformationProvider;
import org.hl7.fhir.r5.renderers.ConceptMapRenderer.RenderMultiRowSortPolicy;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.ConceptMapUtilities;
import org.hl7.fhir.r5.terminologies.ConceptMapUtilities.TranslatedCode;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.DebugUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlDocument;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import net.sourceforge.plantuml.abel.Link;

/**
 * This class runs as a pre-compile step for the xversion IG
 * 
 * It takes one parameter, the root directory of the cross version IG git repo.
 * It loads R2-R5 definitions, reads all the conceptmaps in the IG source, and then
 * generates the following:
 * 
 *  - page fragments in input/includes with HTML summaries of the content 
 *  - extension definitions in input/extensions 
 *  - 
 */
public class XVerExtensionPackageGenerator implements IConceptMapInformationProvider {

  public class ColumnEntry {


    private ElementDefinitionLink link;
    private ElementDefinition ed;

    public ColumnEntry(ElementDefinitionLink link, ElementDefinition ed) {
      this.link = link;
      this.ed = ed;
    }

  }

  public class ColumnSorter implements Comparator<StructureDefinitionColumn> {

    @Override
    public int compare(StructureDefinitionColumn o1, StructureDefinitionColumn o2) {
      String s1 = o1.sd.getFhirVersion().toCode()+":"+o1.sd.getName();
      String s2 = o2.sd.getFhirVersion().toCode()+":"+o2.sd.getName();
      return s1.compareTo(s2);
    }

  }

  public class SourcedElementDefinitionSorter implements Comparator<SourcedElementDefinition> {

    @Override
    public int compare(SourcedElementDefinition o1, SourcedElementDefinition o2) {
      String s1 = o1.toString();
      String s2 = o2.toString();
      return s1.compareTo(s2);
    }

  }

  public enum MakeLinkMode {
    INWARD, OUTWARD, CHAIN, ORIGIN_CHAIN

  }

  public enum XVersions {
    VER_2_3, VER_3_4, VER_4_4B, VER_4B_5;
  }

  private static  class ElementDefinitionPair {
    ElementDefinition focus;
    ElementDefinition anchor;
    protected ElementDefinitionPair(ElementDefinition focus, ElementDefinition anchor) {
      super();
      this.focus = focus;
      this.anchor = anchor;
    }
    
  }
  
  private static class StructureDefinitionColumn {
    public StructureDefinitionColumn(StructureDefinition sd, boolean root) {
      this.sd = sd;
      this.root = root;
    }
    private StructureDefinition sd;
    private boolean root;
    public List<ElementDefinitionPair> elements = new ArrayList<>();
    public List<ColumnEntry> entries = new ArrayList<XVerExtensionPackageGenerator.ColumnEntry>();

    public void clear() {
      entries.clear();
    }

    public int rowCount() {
      int c = 0;
      for (ColumnEntry entry : entries) {
        if (entry.link == null) {
          c = c + 1;
        } else {
          c = c + entry.link.leftWidth;
        }
      }
      return c;
    }

  }

  public static class CodeChainsSorter implements Comparator<List<ElementDefinitionLink>> {

    @Override
    public int compare(List<ElementDefinitionLink> o1, List<ElementDefinitionLink> o2) {

      return maxSize(o1) - maxSize(o2);
    }

    private int maxSize(List<ElementDefinitionLink> list) {

      int i = 0;
      for (ElementDefinitionLink link : list) {
        if (link.nextCM != null) {
          i = Integer.max(i, ConceptMapUtilities.mapCount(link.nextCM));
        }
      }
      return i;
    }

  }

  public class VSPair {

    private ValueSet vs;
    private CodeSystem cs;
    private String version;

    public VSPair(String version, ValueSet vs, CodeSystem cs) {
      this.version = version;
      this.vs = vs;
      this.cs = cs;
    }

    public String getVersion() {
      return version;
    }

    public ValueSet getVs() {
      return vs;
    }

    public CodeSystem getCs() {
      return cs;
    }
  }

  public static class MatchedElementDefinition {

    private ElementDefinition ed;
    private ConceptMapRelationship rel;

    public MatchedElementDefinition(ElementDefinition ed, ConceptMapRelationship rel) {
      this.ed = ed;
      this.rel = rel;
    }

  }

  public static class SourcedElementDefinition {
    private StructureDefinition sd;
    private ElementDefinition ed;

    private boolean valid;
    private String statusReason;
    private String ver;
    private String startVer;
    private String stopVer;
    private String verList;
    private SourcedElementDefinition repeater;

    public SourcedElementDefinition(StructureDefinition sd, ElementDefinition ed) {
      this.sd = sd;
      this.ed = ed;    
      this.ver = sd.getFhirVersion().toCode();
    }

    @Override
    public String toString() {
      return ed.getPath()+" ("+sd.getFhirVersion().toCode()+")";
    }
  }

  public static class ElementDefinitionLink {
    private XVersions versions;
    private ConceptMapRelationship rel;
    private SourcedElementDefinition next;
    private SourcedElementDefinition prev;
    private ConceptMap nextCM;
    private ConceptMap prevCM;
    private int leftWidth; 
    private Set<String> chainIds = new HashSet<>();

    @Override
    public String toString() {
      return versions+": "+prev.toString()+" "+rel.getSymbol()+" "+next.toString()+" ["+chainIds.toString()+"]";
    }
  }

  public class SourcedStructureDefinition {

    private VersionDefinitions definitions;
    private StructureDefinition structureDefinition;
    private ConceptMapRelationship relationship;
    protected SourcedStructureDefinition(VersionDefinitions definitions, StructureDefinition structureDefinition, ConceptMapRelationship relationship) {
      super();
      this.definitions = definitions;
      this.structureDefinition = structureDefinition;
      this.relationship = relationship;
    }
    public VersionDefinitions getDefinitions() {
      return definitions;
    }
    public StructureDefinition getStructureDefinition() {
      return structureDefinition;
    }
    public ConceptMapRelationship getRelationship() {
      return relationship;
    }

  }

  public static class ElementChain {
    private int id; 
    private String name; // debugging only
    private List<ElementDefinitionLink> links = new ArrayList<ElementDefinitionLink>();

  }

  public static class VersionDefinitions {
    private FhirPublication version;
    private Map<String, StructureDefinition> structures = new HashMap<>();
    private Map<String, ValueSet> valueSets = new HashMap<>();
    private Map<String, CodeSystem> codeSystems = new HashMap<>();
    public void add(CanonicalResource cr) {
      if (cr instanceof CodeSystem) {
        codeSystems.put(cr.getUrl(), (CodeSystem) cr);
        if (cr.hasVersion()) {
          codeSystems.put(cr.getUrl()+"|"+cr.getVersion(), (CodeSystem) cr);
        }
      } else if (cr instanceof ValueSet) {
        valueSets.put(cr.getUrl(), (ValueSet) cr);
        if (cr.hasVersion()) {
          valueSets.put(cr.getUrl()+"|"+cr.getVersion(), (ValueSet) cr);
        }
      } else if (cr instanceof StructureDefinition) {
        structures.put(cr.getName(), (StructureDefinition) cr);
      }      
    }
    public String summary() {
      return ""+structures.size()+" Structures, "+valueSets.size()+" Value Sets, "+codeSystems.size()+" CodeSystems";
    }  
  }

  private static final boolean OUT = false;
  private static final boolean IN = true;

  public static void main(String[] args) throws Exception {
    new XVerExtensionPackageGenerator().execute(args);
  }

  private List<ElementChain> chains = new ArrayList<>();
  private Map<String, VersionDefinitions> versions = new HashMap<>();
  private Map<String, ConceptMap> conceptMap = new HashMap<>();
  private VersionDefinitions vdr2;
  private VersionDefinitions vdr3;
  private VersionDefinitions vdr4;
  private VersionDefinitions vdr4b;
  private VersionDefinitions vdr5;
  private List<ElementDefinitionLink> allLinks = new ArrayList<>();
  private List<SourcedElementDefinition> terminatingElements = new ArrayList<>();
  private List<SourcedElementDefinition> origins = new ArrayList<>();

  private void execute(String[] args) throws FHIRException, IOException {
    loadVersions();
    loadConceptMaps(args[0]);

    System.out.println("Checking Maps");
    // 1. sanity check on resource and element maps
    checkMaps();

    System.out.println("Building Links");
    // 2. build all the links. At the end, chains are all the terminating elements
    buildLinks(XVersions.VER_2_3, vdr2, cm("resources-2to3"), cm("elements-2to3"), vdr3);
    buildLinks(XVersions.VER_3_4, vdr3, cm("resources-3to4"), cm("elements-3to4"), vdr4);
    buildLinks(XVersions.VER_4_4B, vdr4, cm("resources-4to4b"), cm("elements-4to4b"), vdr4b);
    buildLinks(XVersions.VER_4B_5, vdr4b, cm("resources-4bto5"), cm("elements-4bto5"), vdr5);    

    System.out.println("Building Chains");
    findTerminalElements();    
    for (SourcedElementDefinition te : terminatingElements) {
      identifyChain(te);
    }
    checkAllLinksInChains();
    System.out.println(""+terminatingElements.size()+" terminating elements found");

    for (SourcedElementDefinition te : terminatingElements) {
      scanChainElements(te);
    }


    Collections.sort(origins, new SourcedElementDefinitionSorter());
    genChainsHtml(args[0], "cross-version-chains-all", false, false);
    genChainsHtml(args[0], "cross-version-chains-valid", true, false);
    genChainsHtml(args[0], "cross-version-chains-min", true, true);

    for (String name : Utilities.sorted(vdr5.structures.keySet())) {
      StructureDefinition sd = vdr5.structures.get(name);
      if ((sd.getKind() == StructureDefinitionKind.COMPLEXTYPE || sd.getKind() == StructureDefinitionKind.RESOURCE) && !sd.getAbstract() && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        genVersionType(args[0], sd);
      }
    }
    //    System.out.println("Done");


    genSummaryPage(args[0]);
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

    //    for (ConceptMap cm : conceptMap.values()) {
    //      if (cm.hasUserData("cm.used") && "false".equals(cm.getUserString("cm.used"))) {
    //        if (!cm.getId().contains("4to5") && !cm.getId().contains("5to4")) {
    //          System.out.println("Unused conceptmap: "+cm.getId());
    //        }        
    //      }
    //    }
    System.out.println("Finished");
  }


  private void findTerminalElements() {
    // At this point, the only listed terminal elements are any elements that never had any links at all 
    // check that
    for (SourcedElementDefinition te : terminatingElements) {
      List<ElementDefinitionLink> links = makeEDLinks(te, MakeLinkMode.OUTWARD);
      if (links.size() > 0) {
        throw new Error("Logic error - "+te.toString()+" has outbound links");
      }
    }
    for (ElementDefinitionLink link : allLinks) {
      SourcedElementDefinition tgt = link.next;
      List<ElementDefinitionLink> links = makeEDLinks(tgt.ed, MakeLinkMode.OUTWARD);
      if (links.size() == 0 && !terminatingElements.contains(tgt)) {
        terminatingElements.add(tgt);
      }      
    }
  }


  private void checkAllLinksInChains() {
    for (ElementDefinitionLink link : allLinks) {
      if (link.chainIds.isEmpty()) {
        System.out.println("Link not in chain: "+link.toString());
      }
    }
  }


  private void identifyChain(SourcedElementDefinition te) {
    String id = VersionUtilities.getNameForVersion(te.sd.getFhirVersion().toCode())+"."+te.ed.getPath();

    Queue<ElementDefinitionLink> processList = new ConcurrentLinkedQueue<XVerExtensionPackageGenerator.ElementDefinitionLink>();
    List<ElementDefinitionLink> processed = makeEDLinks(te.ed, MakeLinkMode.CHAIN);
    for (ElementDefinitionLink link : makeEDLinks(te.ed, MakeLinkMode.INWARD)) {
      processList.add(link);

      link.leftWidth = findLeftWidth(link.prev);
    }
    while (!processList.isEmpty()) {
      ElementDefinitionLink link = processList.remove();
      processed.add(link);
      link.chainIds.add(id);
      for (ElementDefinitionLink olink : makeEDLinks(link.prev.ed, MakeLinkMode.INWARD)) {
        if (!processed.contains(olink)) {
          processList.add(olink);
        }
      }
    }
  }


  private int findLeftWidth(SourcedElementDefinition node) {
    List<ElementDefinitionLink> links = makeEDLinks(node, MakeLinkMode.INWARD);
    if (links.size() == 0) {
      return 1; // just this entry
    } else {
      // we group incoming links by source. 
      Map<StructureDefinition, Integer> counts = new HashMap<>();
      for (ElementDefinitionLink link : links) {
        Integer c = counts.get(link.prev.sd);
        if (c == null) {
          c = 0;
        }
        //if (link.leftWidth == 0) {
        link.leftWidth = findLeftWidth(link.prev);            
        //}
        c = c + link.leftWidth;
        counts.put(link.prev.sd, c);
      }
      int res = 1;
      for (Integer c : counts.values()) {
        res = Integer.max(res, c);
      }
      return res;      
    }
  }


  private void checkMaps() throws FileNotFoundException, IOException {
    checkMapsReciprocal(cm("resources-2to3"), cm("resources-3to2"), "resources");
    checkMapsReciprocal(cm("resources-3to4"), cm("resources-4to3"), "resources");
    checkMapsReciprocal(cm("resources-4to4b"), cm("resources-4bto4"), "resources");
    checkMapsReciprocal(cm("resources-4bto5"), cm("resources-5to4b"), "resources");
    checkMapsReciprocal(cm("elements-2to3"), cm("elements-3to2"), "elements");
    checkMapsReciprocal(cm("elements-3to4"), cm("elements-4to3"), "elements");
    checkMapsReciprocal(cm("elements-4to4b"), cm("elements-4bto4"), "elements");
    checkMapsReciprocal(cm("elements-4bto5"), cm("elements-5to4b"), "elements");
  }


  private void checkMapsReciprocal(ConceptMap left, ConceptMap right, String folder) throws FileNotFoundException, IOException {
    List<String> issues = new ArrayList<String>();
    if (ConceptMapUtilities.checkReciprocal(left, right, issues)) {
      // wipes formatting in files
      //      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/work/fhir-cross-version/input/"+folder+"/ConceptMap-"+left.getId()+".json"), left);
      //      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/work/fhir-cross-version/input/"+folder+"/ConceptMap-"+right.getId()+".json"), right);
    }
    if (!issues.isEmpty()) {
      System.out.println("Found issues checking reciprocity of "+left.getId()+" and "+right.getId());
      for (String s : issues) {
        System.out.println("  "+s);
      }
    }
  }


  private void genSummaryPage(String path) throws IOException {
    List<ConceptMap> maps = new ArrayList<>();
    maps.add(cm("resources-2to3"));
    maps.add(cm("resources-3to4"));
    maps.add(cm("resources-4to4b"));
    maps.add(cm("resources-4bto5"));
    XhtmlNode page = ConceptMapRenderer.renderMultipleMaps("Resource", maps, this, RenderMultiRowSortPolicy.FIRST_COL);

    TextFile.stringToFile(new XhtmlComposer(false, false).compose(page), Utilities.path(path, "input", "includes", "cross-version-summary.xhtml"));
    TextFile.stringToFile(new XhtmlComposer(false, false).compose(wrapPage(page, "Resource Map")), Utilities.path(path, "input", "qa", "cross-version-summary.html"));

  }

  private boolean isResourceTypeMap(ConceptMap cm) {
    if (cm.getGroup().size() != 1) {
      return false;
    }
    return cm.getGroupFirstRep().getSource().contains("resource-type") || cm.getGroupFirstRep().getTarget().contains("resource-type");
  }

  private ConceptMap cm(String name) {
    ConceptMap cm = conceptMap.get(name);
    if (cm == null) {
      throw new Error("Concept Map "+name+" not found");
    }
    return cm;
  }

  private void loadConceptMaps(String dir) throws FHIRFormatError, FileNotFoundException, IOException {
    loadConceptMaps(new File(Utilities.path(dir, "input", "resources")), false);
    loadConceptMaps(new File(Utilities.path(dir, "input", "elements")), false);
    loadConceptMaps(new File(Utilities.path(dir, "input", "codes")), true);
    loadConceptMaps(new File(Utilities.path(dir, "input", "search-params")), false);
  }

  private void loadConceptMaps(File file, boolean track) throws FHIRFormatError, FileNotFoundException, IOException {
    System.out.print("Load ConceptMaps from "+file.getAbsolutePath()+": ");
    int i = 0;
    for (File f : file.listFiles()) {
      if (f.getName().startsWith("ConceptMap-")) {
        ConceptMap cm = null;
        String id = null;
        try {
          cm = (ConceptMap) new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(f));
          id = f.getName().replace("ConceptMap-", "").replace(".json", "");
          if (!cm.getId().equals(id)) {
            throw new Error("id mismatch - is "+cm.getId()+", should be "+id);
          }
          String url = "http://hl7.org/fhir/cross-version/ConceptMap/"+id;
          if (!cm.getUrl().equals(url)) {
            throw new Error("url mismatch - is "+cm.getUrl()+", should be "+url);
          }
        } catch (Exception e) {
          throw new Error("Error parsing "+f.getAbsolutePath()+": "+e.getMessage(), e);
        }
        if (track) {
          cm.setUserData("cm.used", "false");
        }
        cm.setWebPath("ConceptMap-"+cm.getId()+".html");
        conceptMap.put(id.toLowerCase(), cm);
        i++;
      }
    }
    System.out.println(" "+i+" loaded");
  }

  private void genChainsHtml(String path, String filename, boolean validOnly, boolean itemsOnly) throws IOException {
    System.out.println("Create "+filename);

    XhtmlNode body = new XhtmlNode(NodeType.Element, "div");    
    body.h1().tx("FHIR Cross Version Extensions");
    body.para().tx("something");


    body.h2().tx("Element Chains");
    XhtmlNode ul = null;
    for (SourcedElementDefinition origin : origins) {
      List<ElementDefinitionLink> links = makeEDLinks(origin, MakeLinkMode.ORIGIN_CHAIN);
      String n = origin.ed.getPath();
      if (!n.contains(".")) {
        body.para().tx(n);
        ul = null;
      } else if (!validOnly || hasValid(links)) { 
        if (ul == null) {
          ul = body.ul();
        }
        XhtmlNode li = ul.li();
        li.tx(origin.toString());
        XhtmlNode uli = li.ul();
        renderElementDefinition(uli.li(), origin);
        for (ElementDefinitionLink link : links) {
          if (!itemsOnly || link.next.valid) {
            renderElementDefinition(uli.li(), link.next);
          }
        }
      }
    }
    TextFile.stringToFile(new XhtmlComposer(false, false).compose(body), Utilities.path(path, "input", "includes", filename+".xhtml"));
    TextFile.stringToFile(new XhtmlComposer(false, false).compose(wrapPage(body, "FHIR Cross Version Extensions")), Utilities.path(path, "input", "qa", filename+".html"));
  }

  private boolean hasValid(List<ElementDefinitionLink> links) {
    for (ElementDefinitionLink link : links) {
      if (link.next.valid) {
        return true;
      }
    }
    return false;
  }


  private XhtmlNode wrapPage(XhtmlNode content, String title) {
    XhtmlNode page = new XhtmlNode(NodeType.Element, "html");
    XhtmlNode head = page.head();
    head.link("stylesheet", "fhir.css");
    head.title(title);
    XhtmlNode body = page.body();
    body.style("background-color: white");
    body.add(content);
    return page;
  }

  private void scanChainElements(SourcedElementDefinition terminus) throws FileNotFoundException, IOException {
    List<ElementDefinitionLink> chain = makeEDLinks(terminus, MakeLinkMode.CHAIN);

    // this chain can include multiple logical subchains that all terminate at the same point. 
    // we're going to make a list of all origins, and then build a chain for each origin that only contains links in this chain (because links can be in more than one chain) 
    List<SourcedElementDefinition> origins = new ArrayList<>();
    for (ElementDefinitionLink link : chain) {
      List<ElementDefinitionLink> links = makeEDLinks(link.prev, MakeLinkMode.INWARD);
      if (links.size() == 0) {
        origins.add(link.prev);       
      }
    }
    for (SourcedElementDefinition origin : origins) {
      if (this.origins.contains(origin)) {
        System.out.println("Now what? - ignoring duplicate report origin "+origin.toString()); 
      } else {
        this.origins.add(origin);
        List<ElementDefinitionLink> originChain = makeEDLinks(origin, MakeLinkMode.ORIGIN_CHAIN);
        buildSubChain(originChain, origin, chain);
        scanChainElements(origin, originChain);
      }
    }
  }

  private void buildSubChain(List<ElementDefinitionLink> subChain, SourcedElementDefinition node, List<ElementDefinitionLink> chain) {
    List<ElementDefinitionLink> links = makeEDLinks(node, MakeLinkMode.OUTWARD);
    for (ElementDefinitionLink link : links) {
      if (chain.contains(link)) {
        subChain.add(link);
        buildSubChain(subChain, link.next, chain);
      }
    }
  }

  private void scanChainElements(SourcedElementDefinition origin, List<ElementDefinitionLink> links) throws FileNotFoundException, IOException {
    // now we have a nice single chain across a set of versions
    List<SourcedElementDefinition> all = new ArrayList<XVerExtensionPackageGenerator.SourcedElementDefinition>();

    origin.statusReason = null;
    origin.valid = true;
    origin.startVer = origin.ver;
    origin.stopVer = origin.ver;
    all.add(origin);

    SourcedElementDefinition template = origin;    
    for (ElementDefinitionLink link : links) {
      SourcedElementDefinition element = link.next;
      all.add(element);
      if (link.rel != ConceptMapRelationship.EQUIVALENT) {
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

    for (SourcedElementDefinition element : all) {
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

    for (ElementDefinitionLink link : links) {
      VSPair l = isEnum(link.prev);
      VSPair r = isEnum(link.next);
      if (l != null && r != null) {
        if (l.getCs().getUrl().contains("resource-types") || r.getCs().getUrl().contains("resource-types")) {
          String idF = "resources-"+l.getVersion()+"to"+r.getVersion();
          String idR = "resources-"+r.getVersion()+"to"+l.getVersion();
          link.nextCM = conceptMap.get(idF);
          link.prevCM = conceptMap.get(idR);
        } else {
          String idF = link.next.ed.getPath().equals(link.prev.ed.getPath()) ? link.next.ed.getPath()+"-"+l.getVersion()+"to"+r.getVersion() : link.prev.ed.getPath()+"-"+link.next.ed.getPath()+"-"+l.getVersion()+"to"+r.getVersion();
          String idR = link.next.ed.getPath().equals(link.prev.ed.getPath()) ? link.next.ed.getPath()+"-"+r.getVersion()+"to"+l.getVersion() : link.next.ed.getPath()+"-"+link.prev.ed.getPath()+"-"+r.getVersion()+"to"+l.getVersion();
          ConceptMap cmF = conceptMap.get(idF.toLowerCase());
          ConceptMap cmR = conceptMap.get(idR.toLowerCase());
          Set<String> lset = CodeSystemUtilities.codes(l.cs);
          Set<String> rset = CodeSystemUtilities.codes(r.cs);
          Set<String> lvset = ValueSetUtilities.codes(l.vs, l.cs);
          Set<String> rvset = ValueSetUtilities.codes(r.vs, r.cs);

          if (cmF != null) {
            checkCM(cmF, link.prev, link.next, l, r, lset, rset, lvset, rvset);
          } else { // if (!rset.containsAll(lset)) {
            cmF = makeCM(idF, link.prev, link.next, l, r, lset, rset, lvset, rvset);              
          }

          if (cmR != null) {
            checkCM(cmR, link.next, link.prev, r, l, rset, lset, rvset, lvset);
          } else { // if (!lset.containsAll(rset)) {
            cmR = makeCM(idR, link.next, link.prev, r, l, rset, lset, rvset, lvset);            
          }
          if (cmF != null && cmR != null) {
            List<String> errs = new ArrayList<String>();
            boolean altered = ConceptMapUtilities.checkReciprocal(cmF, cmR, errs);
            for (String s : errs) {
              System.out.println("Error between "+cmF.getId()+" and "+cmR.getId()+" maps: "+s);
            }
            if (altered) {
              new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/work/fhir-cross-version/input/codes/ConceptMap-"+cmR.getId()+".json"), cmR);
              new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/work/fhir-cross-version/input/codes/ConceptMap-"+cmF.getId()+".json"), cmF);
            }
          }
          link.nextCM = cmF;
          link.prevCM = cmR;

        }
      }        
    }
  }

  private ConceptMap makeCM(String id, SourcedElementDefinition se, SourcedElementDefinition de, VSPair s, VSPair d, Set<String> source, Set<String> dest, Set<String> lvset, Set<String> rvset) throws FileNotFoundException, IOException {
    ConceptMap cm = new ConceptMap();
    cm.setId(id);
    cm.setUrl("http://hl7.org/fhir/cross-version/ConceptMap/"+id);
    cm.setName(id.replace("-", ""));
    if (se.ed.getPath().equals(de.ed.getPath())) {
      cm.setTitle("Mapping for "+se.ed.getPath()+" from "+se.ver+" to "+de.ver);
    } else {
      cm.setTitle("Mapping for "+se.ed.getPath()+"/"+de.ed.getPath()+" from "+se.ver+" to "+de.ver);
    }
    String scopeUri = "http://hl7.org/fhir/"+VersionUtilities.getMajMin(se.ver)+"/StructureDefinition/"+se.sd.getName()+"#"+se.ed.getPath();
    cm.setSourceScope(new UriType(scopeUri));
    String targetUri = "http://hl7.org/fhir/"+VersionUtilities.getMajMin(de.ver)+"/StructureDefinition/"+de.sd.getName()+"#"+de.ed.getPath();
    cm.setTargetScope(new UriType(targetUri));
    ConceptMapGroupComponent g = cm.addGroup();
    scopeUri = injectVersionToUri(s.cs.getUrl(), VersionUtilities.getMajMin(se.ver));
    targetUri = injectVersionToUri(d.cs.getUrl(), VersionUtilities.getMajMin(de.ver));
    g.setSource(scopeUri);
    g.setTarget(targetUri);
    Set<String> unmapped = new HashSet<>();    
    for (String c : dest) {
      if (!source.contains(c)) {
        unmapped.add(c);
      }      
    }
    boolean review = false;
    for (String c : source) {
      SourceElementComponent src = g.addElement();
      src.setCode(c);
      if (!dest.contains(c)) {
        src.setNoMap(true);
        review = true;
        src.setDisplay("CHECK! missed = "+CommaSeparatedStringBuilder.join(",", unmapped)+"; all = "+CommaSeparatedStringBuilder.join(",", dest));
        TargetElementComponent tgt = src.addTarget();
        tgt.setCode("CHECK!");
        tgt.setRelationship(ConceptMapRelationship.EQUIVALENT);     
      } else {
        TargetElementComponent tgt = src.addTarget();
        tgt.setCode(c);
        tgt.setRelationship(ConceptMapRelationship.EQUIVALENT);        
      }
    }
    if (review) {
      cm.getMeta().addTag("http://something", "review-needed", null);
    }
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/work/fhir-cross-version/input/codes/ConceptMap-"+cm.getId()+".json"), cm);
    return cm;
  }

  private void checkCM(ConceptMap cm, SourcedElementDefinition se, SourcedElementDefinition de, VSPair s, VSPair d, Set<String> source, Set<String> dest, Set<String> lvset, Set<String> rvset) throws FileNotFoundException, IOException {
    cm.setUserData("cm.used", "true");
    boolean changed = false;
    boolean review = false;
    if (cm.getMeta().getTag().removeIf(c -> c.getCode().equals("review-needed"))) {
      changed = true;
    }    
    String scopeUri = "http://hl7.org/fhir/"+VersionUtilities.getMajMin(se.ver)+"/StructureDefinition/"+se.sd.getName()+"#"+se.ed.getPath();
    String targetUri = "http://hl7.org/fhir/"+VersionUtilities.getMajMin(de.ver)+"/StructureDefinition/"+de.sd.getName()+"#"+de.ed.getPath();
    if (!cm.hasSourceScopeUriType()) {
      System.out.println("Concept Map "+cm.getId()+" does not have a uri source scope");
      cm.setSourceScope(new UriType(scopeUri));
      changed = true;
    } else if (!scopeUri.equals(cm.getSourceScopeUriType().primitiveValue())) {
      System.out.println("Concept Map "+cm.getId()+" source scope is wrong - is "+cm.getSourceScopeUriType().primitiveValue()+" should be "+scopeUri);
      cm.setSourceScope(new UriType(scopeUri));
      changed = true;
    }
    if (!cm.hasTargetScopeUriType()) {
      System.out.println("Concept Map "+cm.getId()+" does not have a uri target scope");
      cm.setTargetScope(new UriType(targetUri));
      changed = true;
    } else if (!targetUri.equals(cm.getTargetScopeUriType().primitiveValue())) {
      System.out.println("Concept Map "+cm.getId()+" target scope is wrong - is "+cm.getTargetScopeUriType().primitiveValue()+" should be "+targetUri);
      cm.setTargetScope(new UriType(targetUri));
      changed = true;
    }
    if (cm.getGroup().size() != 1) {
      System.out.println("Concept Map "+cm.getId()+" should have one and only one group");
    } else {
      ConceptMapGroupComponent g = cm.getGroupFirstRep();
      for (SourceElementComponent src : g.getElement()) {
        if (src.hasDisplay()) {
          src.setDisplay(null);
          changed = true;
        }
        for (TargetElementComponent tgt : src.getTarget()) {
          if (tgt.hasDisplay()) {
            tgt.setDisplay(null);
            changed = true;
          }
        }
        if (src.hasTarget() && src.getNoMap()) {
          src.setNoMapElement(null);
          changed = true;
        }
      }

      scopeUri = injectVersionToUri(s.cs.getUrl(), VersionUtilities.getMajMin(se.ver));
      targetUri = injectVersionToUri(d.cs.getUrl(), VersionUtilities.getMajMin(de.ver));
      if (!scopeUri.equals(g.getSource())) {
        System.out.println("Concept Map "+cm.getId()+" source scope system is wrong - is "+g.getSource()+" should be "+scopeUri);
        g.setSource(scopeUri);
        changed = true;
      }
      if (!targetUri.equals(g.getTarget())) {
        System.out.println("Concept Map "+cm.getId()+" target scope system is wrong - is "+g.getTarget()+" should be "+targetUri);
        g.setTarget(targetUri);
        changed = true;
      }
      Set<String> missed = new HashSet<>();
      Set<String> invalid = new HashSet<>();
      Set<String> mapped = new HashSet<>(); 
      for (String c : source) {
        SourceElementComponent src = getSource(g, c);
        if (src != null) {
          for (TargetElementComponent tgt : src.getTarget()) {
            if (!dest.contains(tgt.getCode())) {
              invalid.add(tgt.getCode());
            } else {
              mapped.add(tgt.getCode());
            }
            if (tgt.hasComment() && tgt.getComment().contains("s:")) {
              changed = true;
              tgt.setComment(null);
            }
          }
        } else if (!dest.contains(c) || !hasUnMapped(g)) {
          missed.add(c);
        }        
      }
      if (!missed.isEmpty()) {
        Set<String> amissed = new HashSet<>();
        for (String c : missed) {
          if ((lvset.isEmpty() || lvset.contains(c)) && !c.startsWith("_") && !c.equals("null") && !CodeSystemUtilities.isNotSelectable(d.cs, c)) {
            g.addElement().setCode(c).setNoMap(true);
            changed = true;
            review = true;
            amissed.add(c);
          }
        }
        if (!amissed.isEmpty()) {
          System.out.println("Concept Map "+cm.getId()+" is missing mappings for "+CommaSeparatedStringBuilder.join(",", amissed));
        }
      }
      if (!invalid.isEmpty()) {
        System.out.println("Concept Map "+cm.getId()+" has invalid mappings to "+CommaSeparatedStringBuilder.join(",", invalid));
        Set<String> unmapped = new HashSet<>();
        for (String c : dest) {
          if (!mapped.contains(c)) {
            unmapped.add(c);
          }
        }
        for (String c : source) {
          SourceElementComponent src = getSource(g, c);
          if (src != null) {
            for (TargetElementComponent tgt : src.getTarget()) {
              if (!dest.contains(tgt.getCode())) {
                tgt.setDisplay("INVALID!");
                tgt.setComment("missed: "+CommaSeparatedStringBuilder.join(",", unmapped));
                changed = true;
                review = true;
              }
            }
            if (src.getNoMap()) {
              src.setDisplay("missed: "+CommaSeparatedStringBuilder.join(",", unmapped));
              changed = true;
              review = true;              
            }
          }        
        }
      }
      invalid.clear();
      for (SourceElementComponent t : g.getElement()) {
        if (!source.contains(t.getCode())) {
          invalid.add(t.getCode());
          t.setDisplay("INVALID!");
          changed = true;
          review = true;
        }
      }
      if (!invalid.isEmpty()) {
        System.out.println("Concept Map "+cm.getId()+" has invalid mappings from "+CommaSeparatedStringBuilder.join(",", invalid));
      }
      if (!lvset.isEmpty()) {
        if (g.getElement().removeIf(src -> !lvset.contains(src.getCode()))) {
          changed = true;
        }
      }
      if (!rvset.isEmpty()) {
        for (SourceElementComponent src : g.getElement()) {
          for (TargetElementComponent tgt : src.getTarget()) {
            if (!"CHECK!".equals(tgt.getCode())) {
              if (!dest.contains(tgt.getCode())) {
                tgt.setComment("The code "+tgt.getCode()+" is not in the target code system - FIX");
                changed = true;
                review = true;
              } else if (!rvset.contains(tgt.getCode())) {
                tgt.setComment("The code "+tgt.getCode()+" is not in the target value set, but is the correct translation - CHECK");
                changed = true;
                review = true;
              }
            }
          }
        }
      }
    }

    if (changed) {
      if (review) {
        boolean tagged = false;
        for (Coding c : cm.getMeta().getTag()) {
          if (c.getCode().equals("review-needed")) {
            tagged = true;
          }
        }
        if (!tagged) {
          cm.getMeta().addTag("http://something", "review-needed", null);
        }
      }
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("/Users/grahamegrieve/work/fhir-cross-version/input/codes/ConceptMap-"+cm.getId()+".json"), cm);
    }
  }


  private boolean hasUnMapped(ConceptMapGroupComponent g) {
    return g.hasUnmapped() && g.getUnmapped().getMode() == ConceptMapGroupUnmappedMode.USESOURCECODE;
  }

  private SourceElementComponent getSource(ConceptMapGroupComponent g, String c) {
    for (SourceElementComponent t : g.getElement()) {
      if (c.equals(t.getCode())) {
        return t;
      }
    }
    return null;
  }
  private String injectVersionToUri(String url, String ver) {
    return url.replace("http://hl7.org/fhir", "http://hl7.org/fhir/"+ver);
  }

  private VSPair isEnum(SourcedElementDefinition pair) {
    String v = VersionUtilities.getNameForVersion(pair.ver).toLowerCase();
    VersionDefinitions vd = versions.get(v);
    if (pair.ed.getBinding().getStrength() == BindingStrength.REQUIRED || pair.ed.getBinding().getStrength() == BindingStrength.EXTENSIBLE) {
      ValueSet vs = vd.valueSets.get(pair.ed.getBinding().getValueSet());
      if (vs != null && vs.getCompose().getInclude().size() == 1) {
        CodeSystem cs = vd.codeSystems.get(vs.getCompose().getIncludeFirstRep().getSystem());
        if (cs != null && cs.getContent() == CodeSystemContentMode.COMPLETE) {
          return new VSPair(v.substring(1), vs, cs);
        }
      }
    }
    return null;
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

  private void renderElementDefinition(XhtmlNode x, SourcedElementDefinition ed) {
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

  private void buildLinks(XVersions ver, VersionDefinitions defsPrev, ConceptMap resFwd, ConceptMap elementFwd, VersionDefinitions defsNext) {
    System.out.println("Build links between "+defsPrev.version.toCode()+" and "+defsNext.version.toCode());

    for (String name : Utilities.sorted(defsPrev.structures.keySet())) {
      StructureDefinition sd = defsPrev.structures.get(name);
      if (sd.getKind() == StructureDefinitionKind.COMPLEXTYPE && (!sd.getAbstract() || Utilities.existsInList(sd.getName(), "Quantity")) && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        List<SourcedStructureDefinition> matches = new ArrayList<>();
        matches.add(new SourcedStructureDefinition(defsNext, defsNext.structures.get(name), ConceptMapRelationship.EQUIVALENT));        
        buildLinksForElements(ver, elementFwd, sd, matches);
      }
    }

    for (String name : Utilities.sorted(defsPrev.structures.keySet())) {
      StructureDefinition sd = defsPrev.structures.get(name);
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && !sd.getAbstract() && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        List<SourcedStructureDefinition> matches = new ArrayList<>();
        List<TranslatedCode> names = translateResourceName(resFwd, name);
        if (names.isEmpty()) {
          matches.add(new SourcedStructureDefinition(defsNext, null, null));
        } else {
          for (TranslatedCode n : names) {
            matches.add(new SourcedStructureDefinition(defsNext, defsNext.structures.get(n.getCode()), n.getRelationship()));
          }
        }
        buildLinksForElements(ver, elementFwd, sd, matches);
      }
    }
  }


  private void buildLinksForElements(XVersions ver, ConceptMap elementFwd, StructureDefinition sd, List<SourcedStructureDefinition> matches) {
    for (ElementDefinition ed : sd.getDifferential().getElement()) {        
      List<ElementDefinitionLink> links = makeEDLinks(ed, MakeLinkMode.OUTWARD);
      for (SourcedStructureDefinition ssd : matches) {
        if (ssd.structureDefinition != null) {
          List<MatchedElementDefinition> edtl = findTranslatedElements(ed, ssd.structureDefinition, elementFwd, ssd.relationship);
          if (edtl.isEmpty()) {
            // no links
          } else {
            for (MatchedElementDefinition edt : edtl) {
              ElementDefinitionLink link = new ElementDefinitionLink();
              link.versions = ver;
              link.prev = makeSED(sd, ed);
              link.next = makeSED(ssd.structureDefinition, edt.ed);
              link.rel = edt.rel;
              allLinks.add(link);
              links.add(link);
              List<ElementDefinitionLink> linksOther = makeEDLinks(edt.ed, MakeLinkMode.INWARD);
              linksOther.add(link);
            }
          }
        }
      }
      if (links.size() == 0) {
        terminatingElements.add(makeSED(sd, ed));
      }
    }
  }

  private SourcedElementDefinition makeSED(StructureDefinition sd, ElementDefinition ed) {
    SourcedElementDefinition sed = (SourcedElementDefinition) ed.getUserData("sed");
    if (sed == null) {
      sed = new SourcedElementDefinition(sd, ed);
      ed.setUserData("sed", sed);
    }
    return sed;
  }


  private List<ElementDefinitionLink> makeEDLinks(SourcedElementDefinition sed, MakeLinkMode mode) {
    return makeEDLinks(sed.ed, mode);
  }

  private List<ElementDefinitionLink> makeEDLinks(ElementDefinition ed, MakeLinkMode mode) {
    String id = "links."+mode;
    List<ElementDefinitionLink> links = (List<ElementDefinitionLink>) ed.getUserData(id);
    if (links == null) {
      links = new ArrayList<>();
      ed.setUserData(id, links);
    }
    return links;
  }


  private void genVersionType(String path, StructureDefinition sd) throws IOException {
    XhtmlNode body = new XhtmlNode(NodeType.Element, "div");  
    body.h1().tx(sd.getName());
    body.para().tx("something");
    XhtmlNode tbl = body.table("grid");
    XhtmlNode tr = tbl.tr();

    // we're going to generate a table with a column for each target structure definition in the chains that terminate in the provided sd
    List<StructureDefinitionColumn> columns = new ArrayList<StructureDefinitionColumn>();
    for (StructureDefinition sdt : findLinkedStructures(sd)) {
      columns.add(new StructureDefinitionColumn(sdt, false));
    }
    Collections.sort(columns, new ColumnSorter());
    columns.add(new StructureDefinitionColumn(sd, true));

    for (StructureDefinitionColumn col : columns) {
      tr.th().colspan(col.root ? 1 : 2).tx(col.sd.getName()+" ("+col.sd.getFhirVersion().toCode()+")");
    }
    List<List<ElementDefinitionLink>> codeChains = new ArrayList<>();

    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      for (StructureDefinitionColumn col : columns) {
        col.clear();
      }
      StructureDefinitionColumn rootCol = getColumn(columns, sd);
      rootCol.entries.add(new ColumnEntry(null, ed));
      List<ElementDefinitionLink> links = makeEDLinks(ed, MakeLinkMode.CHAIN);
      // multiple fields might collapse into one. So there might be more than one row per target structure. 
      // if there are, we add additional rows, and set the existing cells to span the multiple rows
      // we already know what rowspan is needed.  
      for (ElementDefinitionLink link : links) {
        StructureDefinitionColumn col = getColumn(columns, link.prev.sd);
        col.entries.add(new ColumnEntry(link, link.prev.ed));
        // while we're at it, scan for origin chains with translations
        checkForCodeTranslations(codeChains, link);
      }
      int rowCount = 0;
      for (StructureDefinitionColumn col : columns) {
        rowCount = Integer.max(rowCount, col.rowCount());
      }
      List<XhtmlNode> rows = new ArrayList<XhtmlNode>();
      for (int i = 0; i < rowCount; i++) {
        rows.add(tbl.tr());
      }
      ed.setUserData("rows", rows);
      renderElementRow(sd, columns, ed, rowCount, rows);
    }
    
    // ok, now we look for any other terminating elements that didn't make it into the R5 structure, and inject them into the table
    List<SourcedElementDefinition> missingChains = findMissingTerminatingElements(sd, columns);
    for (SourcedElementDefinition m : missingChains) {
      StructureDefinitionColumn rootCol = getColumn(columns, m.sd);
      ElementDefinition prevED = findPreviousElement(m, rootCol.elements); // find the anchor that knows which rows we'll be inserting under
      List<XhtmlNode> rows = (List<XhtmlNode>) prevED.getUserData("rows");
      XhtmlNode lastTR = rows.get(rows.size()-1);
      for (StructureDefinitionColumn col : columns) {
        col.clear();
      }
      rootCol.entries.add(new ColumnEntry(null, m.ed));
      List<ElementDefinitionLink> links = makeEDLinks(m.ed, MakeLinkMode.CHAIN);
      // multiple fields might collapse into one. So there might be more than one row per target structure. 
      // if there are, we add additional rows, and set the existing cells to span the multiple rows
      // we already know what rowspan is needed.  
      for (ElementDefinitionLink link : links) {
        StructureDefinitionColumn col = getColumn(columns, link.prev.sd);
        col.entries.add(new ColumnEntry(link, link.prev.ed));
        // while we're at it, scan for origin chains with translations
        checkForCodeTranslations(codeChains, link);
      }
      int rowCount = 0;
      for (StructureDefinitionColumn col : columns) {
        rowCount = Integer.max(rowCount, col.rowCount());
      }
      rows = new ArrayList<XhtmlNode>();
      for (int i = 0; i < rowCount; i++) {
        rows.add(tbl.tr(lastTR));
      }
      m.ed.setUserData("rows", rows);
      renderElementRow(m.sd, columns, m.ed, rowCount, rows);
    }

    Collections.sort(codeChains, new CodeChainsSorter());
    for (List<ElementDefinitionLink> links : codeChains) {
      String name = null; // links.get(links.size() -1).next.ed.getPath();
      List<ConceptMap> maps = new ArrayList<>();
      for (ElementDefinitionLink link : links) {
        if (link.nextCM != null) {
          if (name == null) {
            String srcscope = link.nextCM.getSourceScope().primitiveValue();
            name = VersionUtilities.getNameForVersion(srcscope)+" "+srcscope.substring(srcscope.lastIndexOf("#")+1);
          }
          String tgtscope = link.nextCM.getTargetScope().primitiveValue();
          link.nextCM.setUserData("presentation",
              VersionUtilities.getNameForVersion(tgtscope)+" "+tgtscope.substring(tgtscope.lastIndexOf("#")+1));
          maps.add(link.nextCM);
        }
      }
      body.hr();
      body.add(ConceptMapRenderer.renderMultipleMaps(name, maps, this, RenderMultiRowSortPolicy.UNSORTED));
    }

    TextFile.stringToFile(new XhtmlComposer(false, false).compose(body), Utilities.path(path, "input", "includes", "cross-version-"+sd.getName()+".xhtml"));
    TextFile.stringToFile(new XhtmlComposer(false, false).compose(wrapPage(body, sd.getName())), Utilities.path(path, "input", "qa", "cross-version-"+sd.getName()+".html"));
  }


  private void checkForCodeTranslations(List<List<ElementDefinitionLink>> codeChains, ElementDefinitionLink link) {
    if (link.prev.ed.hasUserData("links."+MakeLinkMode.ORIGIN_CHAIN)) {
      List<ElementDefinitionLink> originChain = makeEDLinks(link.prev.ed, MakeLinkMode.ORIGIN_CHAIN);
      boolean mappings = false;
      for (ElementDefinitionLink olink : originChain) {
        mappings = mappings || olink.nextCM != null;
      }
      if (mappings) {
        codeChains.add(originChain);
      }
    }
  }


  private void renderElementRow(StructureDefinition sd, List<StructureDefinitionColumn> columns, ElementDefinition ed, int rowCount, List<XhtmlNode> rows) {
    for (StructureDefinitionColumn col : columns) {
      int i = 0;
      for (ColumnEntry entry : col.entries) {
        XhtmlNode ctr = rows.get(i);
        i = i + (entry.link == null ? 1 : entry.link.leftWidth);
        col.elements.add(new ElementDefinitionPair(entry.ed, ed));
        XhtmlNode td1 = rendererElementForType(ctr.td(), col.root ? sd : col.sd, entry.ed, col.root ? vdr5.structures : versions.get(VersionUtilities.getNameForVersion(col.sd.getFhirVersion().toCode()).toLowerCase()).structures, ed.getPath());
        if (entry.link != null && entry.link.leftWidth > 1) {
          td1.rowspan(entry.link.leftWidth);
        }
        if (!col.root) {
          if (entry.link != null) {
            XhtmlNode td = ctr.td().style("background-color: LightGrey; text-align: center; vertical-align: middle; color: white"); // .tx(entry.link.rel.getSymbol());
            if (entry.link.leftWidth > 1) {
              td.rowspan(entry.link.leftWidth);
            }
            if (entry.link.nextCM != null) {
              td.tx("☰");
            } else if (entry.link.rel == null) {
              td.tx("?");
            } else switch (entry.link.rel ) {
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
              td.tx("<");
              break;
            case SOURCEISNARROWERTHANTARGET:
              td.tx(">");
              break;
            }
          } else {
            ctr.td().style("background-color: #eeeeee");
          }
        }
      }
      for (int j = i; j < rowCount; j++ ) {
        rows.get(j).td().style("background-color: #eeeeee");
        if (!col.root) {
          rows.get(j).td().style("background-color: #eeeeee");
        }
      }          
    }
  }

  private ElementDefinition findPreviousElement(SourcedElementDefinition m, List<ElementDefinitionPair> elements) {
    // latest possible parent
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    int parent = 0;  
    for (int i = elements.size()-1; i >= 0; i--) {
      b.append(elements.get(i).focus.getPath());
      if (m.ed.getPath().startsWith(elements.get(i).focus.getPath()+".")) {
        parent = i; 
      }      
    }
    // last descendant of parent
    String path = elements.get(parent).focus.getPath()+".";
    for (int i = elements.size()-1; i >= parent; i--) {
      if (elements.get(i).focus.getPath().startsWith(path)) {
        return elements.get(i).anchor;
      }      
    }
    return elements.get(parent).anchor;
  }


  private List<SourcedElementDefinition> findMissingTerminatingElements(StructureDefinition base, List<StructureDefinitionColumn> columns) {
    List<SourcedElementDefinition> res = new ArrayList<XVerExtensionPackageGenerator.SourcedElementDefinition>();
    for (SourcedElementDefinition t : terminatingElements) {
      if (t.sd != base) { // already rendered them 
        for (StructureDefinitionColumn col : columns) {
          if (t.sd == col.sd) {
            res.add(t);
          }
        }
      }
    }
    return res;
  }

  private StructureDefinitionColumn getColumn(List<StructureDefinitionColumn> columns, StructureDefinition sd) {
    for (StructureDefinitionColumn col : columns) {
      if (col.sd == sd) {
        return col;
      }
    }
    throw new Error("not found");
  }


  private Set<StructureDefinition> findLinkedStructures(StructureDefinition sd) {
    Set<StructureDefinition> res = new HashSet<>();
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      SourcedElementDefinition sed = makeSED(sd, ed);
      findLinkedStructures(res, sed);
    }
    return res;
  }


  private void findLinkedStructures(Set<StructureDefinition> res, SourcedElementDefinition sed) {

    List<ElementDefinitionLink> links = makeEDLinks(sed, MakeLinkMode.CHAIN);
    for (ElementDefinitionLink link : links) {
      res.add(link.prev.sd);
    }

  }


  private XhtmlNode rendererElementForType(XhtmlNode td, StructureDefinition sdt, ElementDefinition ed, Map<String, StructureDefinition> structures, String origName) {
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
          td.ah(linkforType(t.getWorkingCode())).tx(t.getWorkingCode());
          if (t.hasTargetProfile()) {
            td.tx("(");
            boolean tfirst = true;
            for (CanonicalType u : t.getTargetProfile()) {
              if (tfirst) {tfirst = false; } else { td.tx("|"); td.wbr(); }
              String rt = tail(u.getValue());
              td.ah(linkforType(rt)).tx(rt);
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
      XhtmlNode ah = td.ah(pathForType(sdt, ed.getPath()));
      if (origName != null && !origName.equals(ed.getPath())) {
        ah.style("color: maroon; font-weight: bold");
      }
      ah.tx(ed.getPath());        
    }
    return td;
  }

  private String linkforType(String type) {
    if (Utilities.existsInList(type, "instant", "time", "date", "dateTime", "decimal", "boolean", "integer", "string", "uri", "base64Binary", "code", "id", "oid", 
        "unsignedInt", "positiveInt", "markdown", "url", "canonical", "uuid", "integer64")) {
      return "cross-version-primitives.html";
    } else {
      return "cross-version-"+type+".html";
    }
  }


  private String pathForType(StructureDefinition sdt, String type) {
    String sp = VersionUtilities.getSpecUrl(sdt.getFhirVersion().toCode());
    if (Utilities.existsInList(type, "instant", "time", "date", "dateTime", "decimal", "boolean", "integer", "string", "uri", "base64Binary", "code", "id", "oid", 
        "unsignedInt", "positiveInt", "markdown", "url", "canonical", "uuid", "integer64", "Identifier", "HumanName", "Address", "ContactPoint", 
        "Timing", "Quantity", "SimpleQuantity", "Attachment", "Range", "Period", "Ratio", "RatioRange", "CodeableConcept", "Coding", "SampledData", 
        "Age", "Distance", "Duration", "Count", "Money", "MoneyQuantity", "Annotation", "Signature")) {
      return Utilities.pathURL(sp, "datatypes.html#"+type);
    } else if (Utilities.existsInList(type, "ContactDetail", "Contributor", "DataRequirement", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", 
        "UsageContext", "Expression", "ExtendedContactDetail", "VirtualServiceDetail", "Availability", "MonetaryComponent")) {
      return Utilities.pathURL(sp, "metadatatypes.html#"+type);
    } else if (Utilities.existsInList(type, "DataType", "BackboneType", "BackboneElement", "Element")) {
      return Utilities.pathURL(sp, "types.html#"+type);      
    } else if (Utilities.existsInList(type, "Extension")) { 
      return Utilities.pathURL(sp, "extensions.html#"+type);      
    } else if (Utilities.existsInList(type, "Narrative", "xhtml")) {
      return Utilities.pathURL(sp, "narrative.html#"+type);      
    } else if (Utilities.existsInList(type, "Meta")) { 
      return Utilities.pathURL(sp, "resource.html#"+type);      
    } else if (Utilities.existsInList(type, "Reference", "CodeableReference")) { 
      return Utilities.pathURL(sp, "references.html#"+type);      
    } else {
      return Utilities.pathURL(sp, type.toLowerCase()+".html#"+type);
    }
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
  //
  private List<MatchedElementDefinition> findTranslatedElements(ElementDefinition eds, StructureDefinition structureDefinition, ConceptMap elementMap, ConceptMapRelationship resrel) {
    //  String ver = structureDefinition.getFhirVersion().toCode();
    List<MatchedElementDefinition> res = new ArrayList<MatchedElementDefinition>();
    String path = eds.getPath();
    String epath = path.contains(".") ? structureDefinition.getName()+path.substring(path.indexOf(".") ): structureDefinition.getName();
    List<TranslatedCode> names = translateElementName(path, elementMap, epath);
    for (TranslatedCode n : names) {
      ElementDefinition ed = structureDefinition.getDifferential().getElementByPath(n.getCode());
      if (ed != null) {
        res.add(new MatchedElementDefinition(ed, !ed.getPath().contains(".") ? resrel : n.getRelationship()));
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

  private String tail(String value) {
    return value.contains("/") ? value.substring(value.lastIndexOf("/")+1) : value;
  }


  private void loadVersions() throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    vdr2 = loadR2(pcm);
    versions.put("r2", vdr2);
    vdr3 = loadR3(pcm);
    versions.put("r3", vdr3);
    vdr4 = loadR4(pcm);
    versions.put("r4", vdr4);
    vdr4b = loadR4B(pcm);
    versions.put("r4b", vdr4b);
    vdr5 = loadR5(pcm);
    versions.put("r5", vdr5);
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

  @Override
  public String getLink(String system, String code) {
    if (system == null) {
      return null;
    }
    switch (system) {
    case "http://hl7.org/fhir/1.0/resource-types" : return determineResourceLink("1.0", code);
    case "http://hl7.org/fhir/3.0/resource-types" : return determineResourceLink("3.0", code);
    case "http://hl7.org/fhir/4.0/resource-types" : return determineResourceLink("4.0", code);
    case "http://hl7.org/fhir/4.3/resource-types" : return determineResourceLink("4.3", code);
    case "http://hl7.org/fhir/5.0/resource-types" : return determineResourceLink("5.0", code);
    default:
      return null;
    }
  }

  private String determineResourceLink(String version, String code) {
    if ("5.0".equals(version)) {
      return "cross-version-"+code+".html";
    } else {
      if (vdr5.structures.containsKey(code)) {
        return "cross-version-"+code+".html";
      }
      List<String> codes = new ArrayList<>();
      codes.add(code);
      if ("1.0".equals(version)) {
        codes = translateResourceName(codes, cm("resources-2to3"));
        version = "3.0";        
      }
      if ("3.0".equals(version)) {
        codes = translateResourceName(codes, cm("resources-3to4"));
        version = "4.0";        
      }
      if ("4.0".equals(version)) {
        codes = translateResourceName(codes, cm("resources-4to4b"));
        version = "4.3";        
      }
      if ("4.3".equals(version)) {
        codes = translateResourceName(codes, cm("resources-4bto5"));
      }
      for (String c : codes) {
        if (vdr5.structures.containsKey(c)) {
          return "cross-version-"+c+".html";
        } 
      }
    }
    return null;
  }
  
  private List<String> translateResourceName(List<String> codes, ConceptMap cm) {
    List<String> res = new ArrayList<String>();
    for (ConceptMapGroupComponent grp : cm.getGroup()) {
      for (SourceElementComponent src : grp.getElement()) {
        if (codes.contains(src.getCode())) {
          for (TargetElementComponent tgt : src.getTarget()) {
            if (tgt.getRelationship() == ConceptMapRelationship.EQUIVALENT || tgt.getRelationship() == ConceptMapRelationship.RELATEDTO ||
                tgt.getRelationship() == ConceptMapRelationship.SOURCEISBROADERTHANTARGET || tgt.getRelationship() == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
              res.add(tgt.getCode());
            }
          }
        }
      }
    }
    return res;
  }


  @Override
  public List<Coding> getMembers(String uri) {
    String version = VersionUtilities.getNameForVersion(uri);
    VersionDefinitions vd = versions.get(version.toLowerCase());
    if (vd != null) {
      if (uri.contains("#")) {
        String ep = uri.substring(uri.indexOf("#")+1);
        String base = uri.substring(0, uri.indexOf("#"));
        String name = base.substring(44);
        StructureDefinition sd = vd.structures.get(name);
        if (sd != null) {
          ElementDefinition ed = sd.getDifferential().getElementByPath(ep);
          return processVS(vd, ed.getBinding().getValueSet());
        }
      } else {
        // todo
      }
    }
    return null;
  }

  private List<Coding> processVS(VersionDefinitions vd, String url) {
    ValueSet vs = vd.valueSets.get(url);
    if (vs != null && vs.hasCompose() && !vs.getCompose().hasExclude()) {
      List<Coding> list = new ArrayList<>();
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        if (inc.hasValueSet() || inc.hasFilter()) {
          return null;
        }
        String system = inc.getSystem().replace("http://hl7.org/fhir/", "http://hl7.org/fhir/"+VersionUtilities.getMajMin(vd.version.toCode())+"/");
        String vn = VersionUtilities.getNameForVersion(vd.version.toCode());
        if (inc.hasConcept()) {
          for (ConceptReferenceComponent cc : inc.getConcept()) {
            list.add(new Coding().setSystem(system).setCode(cc.getCode()).setDisplay(cc.getDisplay()+" ("+vn+")"));
          }
        } else {
          CodeSystem cs = vd.codeSystems.get(inc.getSystem());
          if (cs == null) {
            return null;
          } else {
            addCodings(system, vn, cs.getConcept(), list);
          }
        }
      }
      return list;
    } else {
      return null;
    }
  }

  private void addCodings(String system, String vn, List<ConceptDefinitionComponent> concepts, List<Coding> list) {
    for (ConceptDefinitionComponent cd : concepts) {
      list.add(new Coding().setSystem(system).setCode(cd.getCode()).setDisplay(cd.getDisplay()+" ("+vn+")"));
      addCodings(system, vn, cd.getConcept(), list);
    }

  }

}
