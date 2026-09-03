package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A ValidationEngine built by the copy constructor gets its own worker context, so that
 * mutations to the copy leave the original alone. That only holds if the copy's IgLoader is
 * bound to the copy's context - IgLoader captures the context it is constructed against, so a
 * loader shared with the original would make the copy's loadIg() write into the original.
 */
class ValidationEngineCopyTests {

  private static final String URL = "http://example.org/test/ValueSet/engine-copy-isolation";

  private static ValidationEngine base;

  @BeforeAll
  static void setup() throws Exception {
    base = TestUtilities.getValidationEngine(
      "hl7.fhir.r4.core#4.0.1",
      FhirSettings.getTxFhirDevelopment(),
      FhirPublication.R4, "4.0.1");
  }

  @Test
  @DisplayName("A copy's IgLoader is bound to the copy's context, not the original's")
  void copyHasItsOwnLoaderBoundToItsOwnContext() throws Exception {
    ValidationEngine copy = new ValidationEngine(base);

    assertNotSame(base.getContext(), copy.getContext(), "copy must have its own context");
    assertNotSame(base.getIgLoader(), copy.getIgLoader(), "copy must have its own IgLoader");
    assertSame(copy.getContext(), copy.getIgLoader().getContext(),
      "the copy's loader must be bound to the copy's context");
    assertSame(base.getContext(), base.getIgLoader().getContext(),
      "the original's loader must still be bound to the original's context");
  }

  @Test
  @DisplayName("Loading a resource through a copy does not register it in the original")
  void loadThroughCopyDoesNotReachOriginal() throws Exception {
    ValidationEngine copy = new ValidationEngine(base);

    File f = File.createTempFile("engine-copy-isolation", ".json");
    f.deleteOnExit();
    Files.write(f.toPath(), ("{\"resourceType\":\"ValueSet\",\"id\":\"engine-copy-isolation\","
      + "\"url\":\"" + URL + "\",\"status\":\"active\"}").getBytes(StandardCharsets.UTF_8));

    copy.getIgLoader().loadIg(copy.getIgs(), copy.getBinaries(), f.getAbsolutePath(), false);

    assertNotNull(copy.getContext().fetchResource(ValueSet.class, URL),
      "the resource should be registered in the copy that loaded it");
    assertNull(base.getContext().fetchResource(ValueSet.class, URL),
      "the resource must not leak into the original engine's context");
  }
}
