package org.hl7.fhir.test.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;

import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.renderers.RendererFactory;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.test.NarrativeGenerationTests;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Test;

/**
 * A Reference with only the alternate-reference extension (target type not allowed by the element, e.g. a HealthcareService
 * as performer in R4) is rendered like the Reference in the extension
 */
public class AlternateReferenceRendererTest {

  private static final String PERFORMER = "\"performer\":[{\"extension\":[{\"url\":\"http://hl7.org/fhir/StructureDefinition/alternate-reference\","
    + "\"valueReference\":{\"reference\":\"HealthcareService/example\"}}]}]";
  private static final String LINK = "<a href=\"HealthcareService/example\">HealthcareService/example</a>";

  @Test
  void testR4ConsentPerformer() throws Exception {
    String html = renderR4("{\"resourceType\":\"Consent\",\"id\":\"test-consent\",\"status\":\"active\","
      + "\"scope\":{\"coding\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/consentscope\",\"code\":\"patient-privacy\"}]},"
      + "\"category\":[{\"coding\":[{\"system\":\"http://loinc.org\",\"code\":\"64292-6\"}]}],"
      + "\"patient\":{\"reference\":\"Patient/example\"}," + PERFORMER + ","
      + "\"policy\":[{\"uri\":\"https://example.org/policy\"}]}");
    assertRendersAlternateReference(html);
  }

  @Test
  void testR4ObservationPerformer() throws Exception {
    String html = renderR4("{\"resourceType\":\"Observation\",\"id\":\"test-observation\",\"status\":\"final\","
      + "\"code\":{\"text\":\"Body height\"},"
      + "\"subject\":{\"reference\":\"Patient/example\"}," + PERFORMER + "}");
    assertRendersAlternateReference(html);
  }

  private void assertRendersAlternateReference(String html) {
    assertFalse(html.contains("?rref?"), html);
    assertEquals(1, html.split(LINK, -1).length - 1, "expected the alternate reference to be rendered once as " + LINK + " in: " + html);
  }

  private String renderR4(String json) throws Exception {
    IWorkerContext r4context = TestingUtilities.getSharedWorkerContext("4.0.1");
    Element resource = Manager.parseSingle(r4context, new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);

    RenderingContext rc = new RenderingContext(r4context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new NarrativeGenerationTests.TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    ResourceWrapper rw = ResourceWrapper.forResource(rc.getContextUtilities(), resource);
    XhtmlNode x = new RendererFactory().factory(rw, rc).buildNarrative(rw);
    return new XhtmlComposer(false, false).compose(x);
  }
}
