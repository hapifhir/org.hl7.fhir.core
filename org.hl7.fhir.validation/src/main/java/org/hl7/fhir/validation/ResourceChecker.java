package org.hl7.fhir.validation;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ResourceChecker {
  protected static Manager.FhirFormat checkIsResource(SimpleWorkerContext context, boolean debug, byte[] cnt, String filename) {
    System.out.println("   ..Detect format for " + filename);
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

  protected static Manager.FhirFormat checkIsResource(SimpleWorkerContext context, boolean debug, String path) throws IOException {
    String ext = Utilities.getFileExtension(path);
    if (Utilities.existsInList(ext, "xml"))
      return Manager.FhirFormat.XML;
    if (Utilities.existsInList(ext, "json"))
      return Manager.FhirFormat.JSON;
    if (Utilities.existsInList(ext, "ttl"))
      return Manager.FhirFormat.TURTLE;
    if (Utilities.existsInList(ext, "map"))
      return Manager.FhirFormat.TEXT;
    if (Utilities.existsInList(ext, "txt"))
      return Manager.FhirFormat.TEXT;

    return checkIsResource(context, debug, TextFile.fileToBytes(path), path);
  }
}
