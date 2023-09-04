package org.hl7.fhir.validation;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.SHCParser;
import org.hl7.fhir.r5.elementmodel.SHCParser.JWT;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class ResourceChecker {

//  protected static Manager.FhirFormat checkIsResource(SimpleWorkerContext context, boolean debug, String path) throws IOException {
//    
//    if (Utilities.existsInList(ext, "json"))
//      return Manager.FhirFormat.JSON;
//    if (Utilities.existsInList(ext, "map"))
//      return Manager.FhirFormat.TEXT;
//    if (Utilities.existsInList(ext, "txt"))
//      return Manager.FhirFormat.TEXT;
//    if (Utilities.existsInList(ext, "jwt", "jws"))
//      return Manager.FhirFormat.SHC;
//
//    return checkIsResource(context, debug, TextFile.fileToBytes(path), path);
//  }
  public static Manager.FhirFormat checkIsResource(SimpleWorkerContext context, boolean debug, byte[] cnt, String filename, boolean guessFromExtension) {
//    System.out.println("   ..Detect format for " + filename);
    if (cnt.length == 0) {
      System.out.println("Loader: " + filename+" is empty");
      return null;
    }
    if (guessFromExtension) {
      String ext = Utilities.getFileExtension(filename);
      if (Utilities.existsInList(ext, "xml")) {
        return FhirFormat.XML;            
      }
      if (Utilities.existsInList(ext, "ttl")) {
        return FhirFormat.TURTLE;            
      }
      if (Utilities.existsInList(ext, "map", "fml")) {
        return Manager.FhirFormat.FML;
      }
      if (Utilities.existsInList(ext, "jwt", "jws")) {
        return Manager.FhirFormat.SHC;
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
          String src = TextFile.bytesToString(cnt);
          if (src.startsWith("shc:/")) {
            return FhirFormat.SHC;
          }
          if (src.startsWith("shlink:/") || src.contains("#shlink:/")) {
            return FhirFormat.SHL;
          }
        } catch (Exception e) {
        }
        return Manager.FhirFormat.TEXT;
      }
    }

    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), Manager.FhirFormat.JSON);
      return Manager.FhirFormat.JSON;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not JSON: " + e.getMessage());
      }
    }
    try {
      ValidatorUtils.parseXml(cnt);
      return Manager.FhirFormat.XML;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not XML: " + e.getMessage());
      }
    }
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), Manager.FhirFormat.TURTLE);
      return Manager.FhirFormat.TURTLE;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not Turtle: " + e.getMessage());
      }
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
      return Manager.FhirFormat.SHC;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not a smart health card: " + e.getMessage());
      }
    }
    try {
      new StructureMapUtilities(context, null, null).parse(TextFile.bytesToString(cnt), null);
      return Manager.FhirFormat.TEXT;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not Text: " + e.getMessage());
      }
    }
    if (debug)
      System.out.println("     .. not a resource: " + filename);
    return null;
  }

 
}
