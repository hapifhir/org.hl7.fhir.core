package org.hl7.fhir.validation.special;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceFactory;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.utils.structuremap.ResolvedGroup;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r5.utils.structuremap.VariableMode;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.special.R4R5MapTester.Stats;

public class R4R5MapTester {

  public class Stats {

    private Set<String> errors = new HashSet<>();
    private int total;
    private int parsed;
    private int forward;
    
    public void example() {
      total++;
    }

    public void parsed() {
      parsed++;
    }

    public void error(String s) {
      errors.add(s);
    }

    public void forward() {
     forward++; 
    }

    public int totalCount() {
      return total;
    }

    public int parseCount() {
      return parsed;
    }

    public String summary() {
      if (errors.size() == 0) {
        return "All OK";
      } else {
        return String.join(", ", errors);
      }
    }

    public boolean ok() {
      return errors.size() == 0;
    }
  }

  private boolean saveProcess = false;

  private SimpleWorkerContext context;
  private FilesystemPackageCacheManager pcm;
  private StructureMapUtilities utils;
  private List<StructureMap> allMaps;

  public static void main(String[] args) throws JsonException, IOException {
    
    // arg[0] is the location of the fhir-extensions repo
    new R4R5MapTester().testMaps(args[0]);
  }

  public void testMaps(String src) throws JsonException, IOException {
    log("Load Test Outcomes");
    JsonObject json = JsonParser.parseObjectFromFile(Utilities.path(src, "input", "_data", "conversions.json"));
    log("Load R5");
    pcm = new FilesystemPackageCacheManager(true);
    context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(pcm.loadPackage("hl7.fhir.r5.core#current"));
    log("Load Maps");
//     context.loadFromPackage(pcm.loadPackage(), null);
    
    loadPackage("hl7.fhir.uv.extensions#dev");
    loadPackage("hl7.fhir.r4.core#4.0.1");
    loadPackage("hl7.fhir.r4b.core#4.3.0");
    
    log("Load R4 Examples");
    NpmPackage r4Examples = pcm.loadPackage("hl7.fhir.r4.examples");
    log("Load R4B Examples");
    NpmPackage r4bExamples = pcm.loadPackage("hl7.fhir.r4b.examples");

    
    utils = new StructureMapUtilities(context);
    allMaps = context.fetchResourcesByType(StructureMap.class);
    
    log("Go. "+context.getResourceNames().size()+" types of resources");
    log("Map Count = "+allMaps.size());
    boolean changed = false;
    for (JsonProperty jp : json.getProperties()) {
      String rn = jp.getName();
      log("  "+rn);
      JsonObject o = json.getJsonObject(rn);
      StructureDefinition sd = context.fetchTypeDefinition(rn);
      List<StructureMap> mapSrc = utils.getMapsForUrl(allMaps, sd.getUrl(), StructureMapInputMode.SOURCE);
      List<StructureMap> mapTgt = utils.getMapsForUrl(allMaps, sd.getUrl(), StructureMapInputMode.TARGET);
      changed = checkMaps(sd, o.getJsonObject("r4"), "http://hl7.org/fhir/4.0", mapSrc, mapTgt, r4Examples) || changed;
      changed = checkMaps(sd, o.getJsonObject("r4b"), "http://hl7.org/fhir/4.3", mapSrc, mapTgt, r4bExamples) || changed;
    }
    if (changed) {
      JsonParser.compose(json, new FileOutputStream(Utilities.path(src, "input", "_data", "conversions.json")), true);
    }
//    load R4
//    load R4B
//    load the maps 
//    load the existing outcomes 
//    
//    for R4: 
//      fetch the examples package
//      for each R5 resource type
//      find the map
//      get the source name
//      iterate the examples
//        find the applicable map
//        do the conversion
//        write outcome
    
  }

  private void loadPackage(String pid) throws FHIRException, IOException {
    log("Load "+pid);
    NpmPackage npm = pcm.loadPackage(pid);
    IContextResourceLoader loader = ValidatorUtils.loaderForVersion(npm.fhirVersion());
    loader.setPatchUrls(VersionUtilities.isCorePackage(npm.id()));
    int count = context.loadFromPackage(npm, loader);
  }

  private boolean checkMaps(StructureDefinition sd, JsonObject json, String ns, List<StructureMap> mapSrc, List<StructureMap> mapTgt, NpmPackage examples) throws IOException {
    List<StructureMap> src = utils.getMapsForUrlPrefix(mapSrc, ns, StructureMapInputMode.TARGET);
    List<StructureMap> tgt = utils.getMapsForUrlPrefix(mapTgt, ns, StructureMapInputMode.SOURCE);
    if (src.size() + tgt.size() == 0) {
      json.set("status", "No Maps Defined");
      json.set("testColor", "#dddddd");
      json.set("testMessage", "--");
    } else {
      boolean isDraft = false;
      for (StructureMap map : src) {
        isDraft = map.getStatus() == PublicationStatus.DRAFT || isDraft;
      }
      for (StructureMap map : tgt) {
        isDraft = map.getStatus() == PublicationStatus.DRAFT || isDraft;
      }
      json.set("status", ""+(src.size()+tgt.size())+" Maps Defined"+(isDraft ? " (draft)" : ""));
      json.set("testColor", "#ffcccc");
      if (sd.getKind() == StructureDefinitionKind.RESOURCE) {
        if (tgt.size() == 1 && src.size() == 1) {
          StructureMap tgtM = tgt.get(0);
          ResolvedGroup tgtG = utils.getGroupForUrl(tgtM, sd.getUrl(), StructureMapInputMode.TARGET);
          String tgtU = utils.getInputType(tgtG, StructureMapInputMode.SOURCE);
          assert tgtU.startsWith(ns);
          StructureMap srcM = src.get(0);
          ResolvedGroup srcG = utils.getGroupForUrl(srcM, sd.getUrl(), StructureMapInputMode.SOURCE);
          String srcU = utils.getInputType(srcG, StructureMapInputMode.TARGET);
          assert srcU.startsWith(ns);
          if (!srcU.equals(tgtU)) {
            json.set("testMessage", "Maps do not round trip to same resource ("+Utilities.tail(srcU)+" -> "+Utilities.tail(tgtU)+") - can't test");            
          } else {
            StructureDefinition tsd = context.fetchResource(StructureDefinition.class, srcU);
            if (tsd == null) {
              json.set("testMessage", "Undefined type "+srcU);
            } else {
              testRoundTrips(sd, json, tgtG, srcG, tsd, examples);
            }
          }
        } else {
          json.set("testMessage", "Multiple matching maps ("+src.size()+"/"+tgt.size()+") - no tests performed");
        }
      } else {
        json.set("testColor", "#eeeeee");
        json.set("testMessage", "n/a");
      }
    }
    return true;
  }

  private void testRoundTrips(StructureDefinition sd, JsonObject json, ResolvedGroup tgtG, ResolvedGroup srcG, StructureDefinition tsd, NpmPackage examples) throws IOException {
    
    Stats stats = new Stats();
    for (String s : examples.listResources(tsd.getType())) {
      log("  Test "+examples.id()+"::"+s);
      try {
        testRoundTrip(sd, tsd, tgtG, srcG, stats, examples.load("package", s));
      } catch (Exception e) {
        log("error: "+e.getMessage());
        stats.error("Error: "+e.getMessage());
      }
    }
    json.set("total", stats.totalCount());
    json.set("parsed", stats.parseCount());
    json.set("testMessage", stats.summary());
    if (stats.ok()) {
      json.set("testColor", "#d4ffdf");
    }
  }

  private void testRoundTrip(StructureDefinition sd, StructureDefinition tsd, ResolvedGroup tgtG, ResolvedGroup srcG, Stats stats, InputStream stream) throws FHIRFormatError, DefinitionException, FHIRException, IOException {
    stats.example();
    Element r4 = new org.hl7.fhir.r5.elementmodel.JsonParser(context).setLogical(tsd).parseSingle(stream);
    stats.parsed();
    String id = r4.getIdBase();
    checkSave(id, "src.loaded", r4);

    Resource r5 = ResourceFactory.createResource(sd.getType());
    utils.transform(context, r4, tgtG.getTargetMap(), r4);
    stats.forward();
  }

  private void checkSave(String id, String state, Element e) {
    if (saveProcess) {
//      new org.hl7.fhir.r4.elementmodel.JsonParser(context).compose(r3, bso, OutputStyle.PRETTY, null);
    }
  }
  
  private void log(String msg) {
    System.out.println(msg);
  }

}
