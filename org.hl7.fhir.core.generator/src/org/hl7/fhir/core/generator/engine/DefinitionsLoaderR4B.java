package org.hl7.fhir.core.generator.engine;

import java.io.IOException;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class DefinitionsLoaderR4B {

  public static Definitions load(NpmPackage npm) throws IOException {
    Definitions res = new Definitions();
    
    for (String t : npm.listResources("CodeSystem")) {
      res.getCodeSystems().see((CodeSystem) load(npm, t), null);
    }
    for (String t : npm.listResources("ValueSet")) {
      res.getValuesets().see((ValueSet) load(npm, t), null);
    }
    for (String t : npm.listResources("ConceptMap")) {
      res.getConceptMaps().see((ConceptMap) load(npm, t), null);
    }
    for (String t : npm.listResources("CapabilityStatement")) {
      res.getStatements().see((CapabilityStatement) load(npm, t), null);
    }
    for (String t : npm.listResources("StructureDefinition")) {
      res.getStructures().see((StructureDefinition) load(npm, t), null);
    }
    for (String t : npm.listResources("OperationDefinition")) {
      res.getOperations().see((OperationDefinition) load(npm, t), null);
    }
    for (String t : npm.listResources("SearchParameter")) {
      res.getSearchParams().see((SearchParameter) load(npm, t), null);
    }
    for (String t : npm.listResources("CompartmentDefinition")) {
      res.getCompartments().see((CompartmentDefinition) load(npm, t), null);
    }
//    Bundle bnd = (Bundle) load(npm, "Bundle-searchParams.json");
//    if (bnd != null) {
//      for (BundleEntryComponent be : bnd.getEntry()) {
//        Resource r = be.getResource();
//        if (r instanceof CodeSystem) {
//          res.getCodeSystems().see((CodeSystem) r, null);
//        } else if (r instanceof ValueSet) {
//          res.getValuesets().see((ValueSet) r, null);
//        } else if (r instanceof ConceptMap) {
//          res.getConceptMaps().see((ConceptMap) r, null);
//        } else if (r instanceof CapabilityStatement) {
//          res.getStatements().see((CapabilityStatement) r, null);
//        } else if (r instanceof StructureDefinition) {
//          res.getStructures().see((StructureDefinition) r, null);
//        } else if (r instanceof OperationDefinition) {
//          res.getOperations().see((OperationDefinition) r, null);
//        } else if (r instanceof SearchParameter) {
//          res.getSearchParams().see((SearchParameter) r, null);
//        } else if (r instanceof CompartmentDefinition) {
//          res.getCompartments().see((CompartmentDefinition) r, null);
//        }          
//      }
//    }
    return res;
  }

  public static Resource load(NpmPackage npm, String t) {
    try {
      return VersionConvertorFactory_40_50.convertResource(new JsonParser().parse(npm.loadResource(t)));
    } catch (Exception e) {
      System.out.println("Error reading "+t+": "+e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
}