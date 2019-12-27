package org.hl7.fhir.core.generator.loader;

import java.io.IOException;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;

public class DefinitionsLoader {

  public static Definitions load(NpmPackage npm) throws IOException {
    Definitions res = new Definitions();
    
    for (String t : npm.listResources("CodeSystem")) {
      res.getCodeSystems().see((CodeSystem) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("ValueSet")) {
      res.getValuesets().see((ValueSet) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("ConceptMap")) {
      res.getConceptMaps().see((ConceptMap) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("CapabilityStatement")) {
      res.getStatements().see((CapabilityStatement) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("StructureDefinition")) {
      res.getStructures().see((StructureDefinition) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("OperationDefinition")) {
      res.getOperations().see((OperationDefinition) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("SearchParameter")) {
      res.getSearchParams().see((SearchParameter) new JsonParser().parse(npm.loadResource(t)));
    }
    for (String t : npm.listResources("CompartmentDefinition")) {
      res.getCompartments().see((CompartmentDefinition) new JsonParser().parse(npm.loadResource(t)));
    }
    return res;
  }
}
