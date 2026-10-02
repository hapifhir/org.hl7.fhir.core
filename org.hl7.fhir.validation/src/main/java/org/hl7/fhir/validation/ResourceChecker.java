package org.hl7.fhir.validation;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.fml.StructureMapTools;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.elementmodel.SHCParser;
import org.hl7.fhir.services.elementmodel.SHCParser.JWT;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@Slf4j
public class ResourceChecker {

//  protected static FhirFormat checkIsResource(SimpleWorkerContext context, boolean debug, String path) throws IOException {
//    
//    if (Utilities.existsInList(ext, "json"))
//      return FhirFormat.JSON;
//    if (Utilities.existsInList(ext, "map"))
//      return FhirFormat.TEXT;
//    if (Utilities.existsInList(ext, "txt"))
//      return FhirFormat.TEXT;
//    if (Utilities.existsInList(ext, "jwt", "jws"))
//      return FhirFormat.SHC;
//
//    return checkIsResource(context, debug, FileUtilities.fileToBytes(path), path);
//  }
  public static FhirFormat checkIsResource(SimpleWorkerContext context, byte[] cnt, String filename, boolean guessFromExtension) {

    if (cnt.length == 0) {
      log.info("Loader: " + filename+" is empty");
      return null;
    }
    if (guessFromExtension) {
      String ext = Utilities.getFileExtension(filename).toLowerCase();
      if (Utilities.existsInList(ext, "xml")) {
        return FhirFormat.XML;            
      }
      if (Utilities.existsInList(ext, "ttl")) {
        return FhirFormat.TURTLE;            
      }
      if (Utilities.existsInList(ext, "map", "fml")) {
        return FhirFormat.FML;
      }
      if (Utilities.existsInList(ext, "jwt", "jws")) {
        return FhirFormat.SHC;
      }
      if (Utilities.existsInList(ext, "ndjson")) {
        return FhirFormat.NDJSON;
      }
      if (Utilities.existsInList(ext, "json")) {
        if (cnt.length > 2048) {
          return FhirFormat.JSON;                      
        }
        // no, we have to look inside, and decide.
        try {
          JsonObject json = JsonParser.parseObject(cnt);
          if (json.has("verifiableCredential")) {
            return FhirFormat.SHC;
          }        
        } catch (Exception e) {
        }
        return FhirFormat.JSON;            
      }
      if (Utilities.existsInList(ext, "txt")) {
        try {
          String src = FileUtilities.bytesToString(cnt);
          if (src.startsWith("shc:/")) {
            return FhirFormat.SHC;
          }
          if (src.startsWith("shlink:/") || src.contains("#shlink:/")) {
            return FhirFormat.SHL;
          }
        } catch (Exception e) {
        }
        return FhirFormat.TEXT;
      }
    }

    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), FhirFormat.JSON);
      return FhirFormat.JSON;
    } catch (Exception e) {
        log.debug("Not JSON: " + e.getMessage());
    }
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), FhirFormat.NDJSON);
      return FhirFormat.NDJSON;
    } catch (Exception e) {
       log.debug("Not NDJSON: " + e.getMessage());
    }
    try {
      ValidatorUtils.parseXml(cnt);
      return FhirFormat.XML;
    } catch (Exception e) {
      log.debug("Not XML: " + e.getMessage());
    }
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), FhirFormat.TURTLE);
      return FhirFormat.TURTLE;
    } catch (Exception e) {
      log.debug("Not Turtle: " + e.getMessage());
    }
    try {
      String s = new String(cnt, StandardCharsets.UTF_8);
      if (s.startsWith("shlink:/") || s.contains("#shlink:/")) {
        return FhirFormat.SHL;
      }
      if (s.startsWith("shc:/")) {
        s = SHCParser.decodeQRCode(s);
      }
      JWT jwt = new SHCParser(context).decodeJWT(null, s);
      return FhirFormat.SHC;
    } catch (Exception e) {
      log.debug("Not a smart health card: " + e.getMessage());
    }
    try {
      new StructureMapTools(context, null, null).parse(FileUtilities.bytesToString(cnt), null);
      return FhirFormat.TEXT;
    } catch (Exception e) {
      log.debug("Not Text: " + e.getMessage());
    }
    log.debug("     .. not a resource: " + filename);
    return null;
  }

 
}
