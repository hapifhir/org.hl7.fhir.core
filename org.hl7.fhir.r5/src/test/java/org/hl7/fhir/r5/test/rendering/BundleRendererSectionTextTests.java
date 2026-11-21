package org.hl7.fhir.r5.test.rendering;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.BundleRenderer;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.test.NarrativeGenerationTests.TestProfileKnowledgeProvider;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * A document section whose text has no div (invalid, but it happens) is rendered without its text, instead of
 * failing with a NullPointerException. That's only possible in the element model - a native Narrative makes an
 * empty div when asked for one
 */
class BundleRendererSectionTextTests {

  private static final String DOCUMENT = """
    {
      "resourceType": "Bundle",
      "id": "doc",
      "type": "document",
      "entry": [{
        "fullUrl": "http://example.org/Composition/comp",
        "resource": {
          "resourceType": "Composition",
          "id": "comp",
          "status": "final",
          "title": "A document",
          "section": [
            { "title": "No div", "text": { "status": "generated" } },
            { "title": "After" }
          ]
        }
      }]
    }
    """;

  private static IWorkerContext context;

  @BeforeAll
  static void setUp() {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void aSectionWithTextButNoDivIsRendered(boolean elementModel) throws Exception {
    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    ResourceWrapper bnd;
    if (elementModel) {
      Element e = Manager.parseSingle(context, new ByteArrayInputStream(DOCUMENT.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);
      bnd = ResourceWrapper.forResource(rc.getContextUtilities(), e);
    } else {
      Resource r = new JsonParser().parse(DOCUMENT);
      bnd = ResourceWrapper.forResource(rc.getContextUtilities(), r);
    }
    XhtmlNode x = new BundleRenderer(rc).buildNarrative(bnd);
    String html = new XhtmlComposer(false, true).compose(x);
    assertTrue(html.contains("No div"), html);
    assertTrue(html.contains("After"), html);
  }
}
