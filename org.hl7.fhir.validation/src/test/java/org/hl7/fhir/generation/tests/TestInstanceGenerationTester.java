package org.hl7.fhir.generation.tests;

import java.io.IOException;

import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.profilemodel.TestInstanceGenerator;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Test;

public class TestInstanceGenerationTester {

  @Test
  public void testBasic() throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    SimpleWorkerContext context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withDefaultParams().fromPackage(pcm.loadPackage("hl7.fhir.r4.core"));
    context.loadFromPackage(pcm.loadPackage("us.nlm.vsac#0.21.0"), new R4ToR5Loader(Utilities.strings("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"),
        new NullLoaderKnowledgeProviderR5(), context.getVersion()));
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.us.core#6.0.0"), new R4ToR5Loader(Utilities.strings("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"),
        new NullLoaderKnowledgeProviderR5(), context.getVersion()));
    
    TestInstanceGenerator gen = new TestInstanceGenerator(context);
    byte[] output = gen.generate(context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient"), FhirFormat.JSON);
    String res = new String(output);
    System.out.println(res);
  }
}
