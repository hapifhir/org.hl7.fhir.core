package org.hl7.fhir.validation.special;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r5.utils.structuremap.VariableMode;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;

public class R4R5MapTester {

  private SimpleWorkerContext context;
  private FilesystemPackageCacheManager pcm;
  private StructureMapUtilities utils;
  private List<StructureMap> allMaps;

  public static void main(String[] args) throws JsonException, IOException {
    
    // arg[0] is the location of the fhir-extensions repo
    new R4R5MapTester().testMaps(args[0]);
  }

  private void testMaps(String src) throws JsonException, IOException {
    log("Load Test Outcomes");
    JsonObject json = JsonParser.parseObjectFromFile(Utilities.path(src, "input", "_data", "conversions.json"));
    log("Load R5");
    pcm = new FilesystemPackageCacheManager(true);
    context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(pcm.loadPackage("hl7.fhir.r5.core#current"));
    log("Load Maps");
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.uv.extensions#dev"), null);
    utils = new StructureMapUtilities(context);
    allMaps = context.fetchResourcesByType(StructureMap.class);
    
    log("Resource Count = "+context.getResourceNames().size());
    log("Map Count = "+allMaps.size());
    boolean changed = false;
    for (JsonProperty jp : json.getProperties()) {
      String rn = jp.getName();
      log("  "+rn);
      JsonObject o = json.getJsonObject(rn);
      StructureDefinition sd = context.fetchTypeDefinition(rn);
      List<StructureMap> mapSrc = utils.getMapsForUrl(allMaps, sd.getUrl(), StructureMapInputMode.SOURCE);
      List<StructureMap> mapTgt = utils.getMapsForUrl(allMaps, sd.getUrl(), StructureMapInputMode.TARGET);
      changed = checkMaps(rn, o.getJsonObject("r4"), "http://hl7.org/fhir/4.0", mapSrc, mapTgt) || changed;
      changed = checkMaps(rn, o.getJsonObject("r4b"), "http://hl7.org/fhir/4.0", mapSrc, mapTgt) || changed;
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

  private boolean checkMaps(String rn, JsonObject json, String ns, List<StructureMap> mapSrc, List<StructureMap> mapTgt) {
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
      if (context.getResourceNames().contains(rn)) {
        json.set("testColor", "#ffcccc");
        json.set("testMessage", "To Do");        
      } else {
        json.set("testColor", "#eeeeee");
        json.set("testMessage", "n/a");
      }
    }
    return true;
  }

  private void log(String msg) {
    System.out.println(msg);
  }

}
