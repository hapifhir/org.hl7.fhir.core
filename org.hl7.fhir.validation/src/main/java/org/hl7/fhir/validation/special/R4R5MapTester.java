package org.hl7.fhir.validation.special;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode;
import org.hl7.fhir.r5.utils.structuremap.ResolvedGroup;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.instance.InstanceValidator;

public class R4R5MapTester implements IValidatorResourceFetcher {

  public class Stats {

    private Set<String> errors = new HashSet<>();
    private int total;
    private int parsed;
    private int forward;
    private int validated;
    private int error;
    private int back;
    private int elements;
    private int lostElements;
    
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

    public int forwardCount() {
      return forward;
    }

    public int validatedCount() {
      return validated;
    }

    public int errorCount() {
      return error;
    }

    public int backCount() {
      return back;
    }

    public String summary() {
      if (errors.size() == 0) {
        return "All OK (~"+(elements == 0 ? "n/a" : ((lostElements * 100) / elements))+"% lost in "+total+" examples)";
      } else {
        return String.join(", ", errors);
      }
    }

    public boolean ok() {
      return errors.size() == 0;
    }

    public void valid(boolean valid) {
      validated++;
      if (!valid) {
        error++;
      }
    }
    

    public void back() {
      back++;
    }

    public void elements(int i) {
      elements = elements+i;
    }

    public void lost(int i) {
      lostElements = lostElements + i;
    }

    public int elementsCount() {
      return elements;
    }

    public int lostCount() {
      return lostElements;
    }
  }

  private boolean saveProcess = true;

  private SimpleWorkerContext context;
  private FilesystemPackageCacheManager pcm;
  private StructureMapUtilities utils;
  private List<StructureMap> allMaps;

  private InstanceValidator validator;

  private StringBuilder log;

  public static void main(String[] args) throws JsonException, IOException {
    
    // arg[0] is the location of the fhir-extensions repo
    new R4R5MapTester().testMaps(args[0], args[1], args[2]);
  }

  public void testMaps(String src, String maps, String filter) throws JsonException, IOException {
    log = new StringBuilder();
    log("Load Test Outcomes");
    JsonObject json = JsonParser.parseObjectFromFile(Utilities.path(src, "input", "_data", "conversions.json"));
    log("Load R5");
    pcm = new FilesystemPackageCacheManager.Builder().build();
    context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(pcm.loadPackage("hl7.fhir.r5.core#current"));
    log("Load Maps");
//     context.loadFromPackage(pcm.loadPackage(), null);
    
    loadPackage("hl7.terminology.r5#5.0.0", false);
    utils = new StructureMapUtilities(context);
    utils.setDebug(false);
        
    loadPackage("hl7.fhir.uv.extensions#dev", maps == null);
    if (maps != null) {
      loadFromFolder(Utilities.path(maps, "r4-2-r5"));
      loadFromFolder(Utilities.path(maps, "r4b-2-r5"));
      loadFromFolder(Utilities.path(maps, "r5-2-r4"));
      loadFromFolder(Utilities.path(maps, "r5-2-r4b"));
    }
    loadPackage("hl7.fhir.r4.core#4.0.1", false);
    loadPackage("hl7.fhir.r4b.core#4.3.0", false);
    
    validator = new InstanceValidator(context, null, null);
    validator.setSuppressLoincSnomedMessages(true);
    validator.setResourceIdRule(IdStatus.REQUIRED);
    validator.setBestPracticeWarningLevel(BestPracticeWarningLevel.Warning);
    validator.getExtensionDomains().add("http://hl7.org/fhir/us");
    validator.setFetcher(this);
    validator.setAllowExamples(true);
    validator.setDebug(false);
    validator.setForPublication(true);
    validator.setNoTerminologyChecks(true);
    context.setExpansionParameters(new Parameters());
    
    log("Load R4 Examples");
    NpmPackage r4Examples = pcm.loadPackage("hl7.fhir.r4.examples");
    log("Load R4B Examples");
    NpmPackage r4bExamples = pcm.loadPackage("hl7.fhir.r4b.examples");

    allMaps = context.fetchResourcesByType(StructureMap.class);
    
    log("Go. "+context.getResourceNames().size()+" types of resources");
    log("Map Count = "+allMaps.size());
    boolean changed = false;
    for (JsonProperty jp : json.getProperties()) {
      String rn = jp.getName();
      if ("*".equals(filter) || rn.equals(filter)) {
        log("  "+rn);
        JsonObject o = json.getJsonObject(rn);
        StructureDefinition sd = context.fetchTypeDefinition(rn);
        if (sd != null) {
          List<StructureMap> mapSrc = utils.getMapsForUrl(allMaps, sd.getUrl(), StructureMapInputMode.SOURCE);
          List<StructureMap> mapTgt = utils.getMapsForUrl(allMaps, sd.getUrl(), StructureMapInputMode.TARGET);
          changed = checkMaps(sd, o.getJsonObject("r4"), "r4", "http://hl7.org/fhir/4.0", mapSrc, mapTgt, r4Examples) || changed;
          changed = checkMaps(sd, o.getJsonObject("r4b"), "r4b", "http://hl7.org/fhir/4.3", mapSrc, mapTgt, r4bExamples) || changed;
          JsonParser.compose(json, new FileOutputStream(Utilities.path(src, "input", "_data", "conversions.json")), true);
        }
        System.out.println("   .. done");
      }
    }
    TextFile.stringToFile(log.toString(), Utilities.path(src, "input", "_data", "validation.log"));
    log("Done!");
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

  private void loadFromFolder(String path) throws FHIRFormatError, FHIRException, FileNotFoundException, IOException {
    log("Load "+path);
    for (File f : new File(path).listFiles()) {
      if (f.getName().endsWith(".json")) {
        context.cacheResource(new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(f)));
      }
      if (f.getName().endsWith(".fml")) {
        context.cacheResource(utils.parse(TextFile.fileToString(f), f.getName()));
      }
    }
    
  }

  private void loadPackage(String pid, boolean loadMaps) throws FHIRException, IOException {
    log("Load "+pid);
    NpmPackage npm = pcm.loadPackage(pid);
    IContextResourceLoader loader = ValidatorUtils.loaderForVersion(npm.fhirVersion());
    if (!loadMaps && loader.getTypes().contains("StructureMap")) {
      loader.getTypes().remove("StructureMap");
    }
    loader.setPatchUrls(VersionUtilities.isCorePackage(npm.id()));
    context.loadFromPackage(npm, loader);
  }

  private boolean checkMaps(StructureDefinition sd, JsonObject json, String code, String ns, List<StructureMap> mapSrc, List<StructureMap> mapTgt, NpmPackage examples) throws IOException {
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
              testRoundTrips(sd, json, tgtG, srcG, tsd, examples, code);
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

  private void testRoundTrips(StructureDefinition sd, JsonObject json, ResolvedGroup tgtG, ResolvedGroup srcG, StructureDefinition tsd, NpmPackage examples, String code) throws IOException {
    Stats stats = new Stats();
    for (String s : examples.listResources(tsd.getType())) {
      log("  Test "+examples.id()+"::"+s, false);
      try {
        log("  "+testRoundTrip(json, sd, tsd, tgtG, srcG, stats, examples.load("package", s), code)+"%");
      } catch (Exception e) {
        log("error: "+e.getMessage());
        e.printStackTrace();
        stats.error("Error: "+e.getMessage());
      }
    }
    json.set("totalInstances", stats.totalCount());
    json.set("parsedOk", stats.parseCount());
    json.set("convertToR5OK", stats.forwardCount());
    json.set("testMessage", stats.summary());
    json.set("r5validated", stats.validatedCount());
    json.set("r5InError", stats.errorCount());
    json.remove("r5validatedOK");
    json.set("convertToR4OK", stats.backCount());
    json.set("elementsConverted", stats.elementsCount());
    if (stats.elementsCount() > 0) {
      json.set("elementsLost", (stats.lostCount() * 100) / stats.elementsCount());
    } else {
      json.set("elementsLost", 0);
    }
    if (stats.ok()) {
      json.set("testColor", "#d4ffdf");
    }
  }

  private int testRoundTrip(JsonObject json, StructureDefinition sd, StructureDefinition tsd, ResolvedGroup tgtG, ResolvedGroup srcG, Stats stats, InputStream stream, String code) throws FHIRFormatError, DefinitionException, FHIRException, IOException {
    stats.example();
    Element r4 = new org.hl7.fhir.r5.elementmodel.JsonParser(context).setLogical(tsd).parseSingle(stream, null);
    stats.parsed();
    int elementCountBefore = r4.countDescendents()+1;
    String id = r4.getIdBase();
    json.remove(id);
    checkSave(id+"."+code, "loaded", r4);

    Resource r5 = null;
    try {
      r5 = ResourceFactory.createResource(sd.getType());
      utils.transform(context, r4, tgtG.getTargetMap(), r5);
      stats.forward();
      checkSave(id+"."+code,"converted", r5);
    } catch (Exception e) {
      json.forceObject(id).set("conversion-error", e.getMessage());
      throw e;
    }

    try {
      List<ValidationMessage> r5validationErrors = new ArrayList<ValidationMessage>();
      validator.validate(null, r5validationErrors, r5);
      boolean valid = true;
      for (ValidationMessage vm : r5validationErrors) {
        if (vm.isError()) {
          log.append(vm.summary());
          log.append("\r\n");
          valid = false;
        }
      }
      if (valid) {
        log.append("All OK\r\n");
      }
      log.append("\r\n");
      stats.valid(valid);
    } catch (Exception e) {
      json.forceObject(id).set("validation-error", e.getMessage());
      throw e;
    }
    
    Element rt4 = null;
    try {
      rt4 = Manager.build(context, tsd);
      utils.transform(context, r5, srcG.getTargetMap(), rt4);
      stats.back();
      checkSave(id+"."+code, "returned", r4);
    } catch (Exception e) {
      json.forceObject(id).set("return-error", e.getMessage());
      throw e;
    }   
    int elementCountAfter = rt4.countDescendents()+1;
    stats.elements(elementCountBefore);
    stats.lost(elementCountBefore - elementCountAfter);
    return (elementCountAfter * 100) / elementCountBefore;
  }

  private void checkSave(String id, String state, Element e) throws FHIRException, FileNotFoundException, IOException {
    if (saveProcess) {
      new org.hl7.fhir.r5.elementmodel.JsonParser(context).compose(e, new FileOutputStream(Utilities.path("[tmp]", "r4r5", e.fhirType()+"-"+id+"-"+state+".json")), OutputStyle.PRETTY, id);
    }
  }

  private void checkSave(String id, String state, Resource r) throws FHIRException, FileNotFoundException, IOException {
    if (saveProcess) {
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "r4r5", r.fhirType()+"-"+id+"-"+state+".json")), r);
    }
  }
  
  private void log(String msg) {
    log(msg, true);
  }
  private void log(String msg, boolean ln) {
    log.append(msg+"\r\n");
    if (ln) {
      System.out.println(msg);
    } else {
      System.out.print(msg+" ");
    }
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException, IOException {
    return null;
  }

  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type, boolean canonical)
      throws IOException, FHIRException {
    return true;
  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String url) throws IOException {
    throw new Error("Not done yet");
  }

  @Override
  public IValidatorResourceFetcher setLocale(Locale locale) {
    throw new Error("Not done yet");
  }

  @Override
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, String url) throws URISyntaxException {
    return null;
  }

  @Override
  public boolean fetchesCanonicalResource(IResourceValidator validator, String url) {
    return false;
  }

}
