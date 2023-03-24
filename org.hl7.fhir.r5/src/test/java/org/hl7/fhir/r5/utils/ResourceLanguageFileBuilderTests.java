package org.hl7.fhir.r5.utils;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.XLIFFProducer;
import org.junit.jupiter.api.Test;

public class ResourceLanguageFileBuilderTests {
  
//  @Test
  public void testXLIFFGeneration() throws FHIRFormatError, IOException {
    Resource res = new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "structuredefinition-language.json"));
    res.setWebPath("test.resource.xml");
    ResourceLanguageFileBuilder lang = new ResourceLanguageFileBuilder();
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "languages", "StructureDefinition-ed-translatable.json")));
    ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResourceStream("r5", "languages", "StructureDefinition-sd-translatable.json")));
    lang.setProfile(ctxt.fetchResource(StructureDefinition.class, "http://hl7.org/tests/fhir/StructureDefinition/sd-translatable"));
    lang.prepare(new XLIFFProducer(Utilities.path("[tmp]", "language")), ctxt, "en", "fr");
    lang.build(res);
  }

}
