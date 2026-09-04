package org.hl7.fhir.utils;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.utilities.ResourceLanguageFileBuilder;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.i18n.XLIFFProducer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ResourceLanguageFileBuilderTests {

  @Disabled("not done yet")
  @Test
  void testXLIFFGeneration() throws FHIRFormatError {
    assertDoesNotThrow(() -> {
      IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
      Resource res = new JsonParser(ctxt).parse(TestingUtilities.loadTestResourceStream("r5", "structuredefinition-language.json"));
      res.setWebPath("test.resource.xml");
      ResourceLanguageFileBuilder lang = new ResourceLanguageFileBuilder();
      ctxt.getManager().cacheResource(new JsonParser(ctxt).parse(TestingUtilities.loadTestResourceStream("r5", "languages", "StructureDefinition-ed-translatable.json")));
      ctxt.getManager().cacheResource(new JsonParser(ctxt).parse(TestingUtilities.loadTestResourceStream("r5", "languages", "StructureDefinition-sd-translatable.json")));
      lang.setProfile(ctxt.fetchResource(StructureDefinition.class, "http://hl7.org/tests/fhir/StructureDefinition/sd-translatable", VersionResolutionRules.defaultRule()));
      lang.prepare(new XLIFFProducer("[tmp]", "language", false), ctxt, "en", "fr");
      lang.build(res);
    });
  }

}
