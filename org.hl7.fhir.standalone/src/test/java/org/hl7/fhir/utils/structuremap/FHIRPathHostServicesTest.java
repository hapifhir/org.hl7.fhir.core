package org.hl7.fhir.utils.structuremap;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.fml.FHIRPathHostServices;
import org.hl7.fhir.services.fml.StructureMapTools;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FHIRPathHostServicesTest {
  static private SimpleWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }

  @Test
  public void testrResolveValueSet() throws IOException, FHIRException {
    StructureMapTools scu = new StructureMapTools(context);
    FHIRPathHostServices fphs = new FHIRPathHostServices(scu);
    ValueSet v = fphs.resolveValueSet(null, null, "http://hl7.org/fhir/ValueSet/FHIR-version");
    Assertions.assertNotNull(v);
    Assertions.assertEquals("http://hl7.org/fhir/ValueSet/FHIR-version", v.getUrl());
  }
}
