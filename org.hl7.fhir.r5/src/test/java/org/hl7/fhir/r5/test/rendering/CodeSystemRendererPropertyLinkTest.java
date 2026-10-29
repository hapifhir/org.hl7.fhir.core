package org.hl7.fhir.r5.test.rendering;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Locale;
import java.util.stream.Stream;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StringType;
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
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Pins what the {@code structuredefinition-display-hint} value {@code no-link} does to the
 * property columns of a CodeSystem's concept table: with the hint, a url-valued string property
 * is shown as code and a {@code parent} property as plain text; without it, the url is resolved
 * and linked, and the parent links to its row.
 */
class CodeSystemRendererPropertyLinkTest {

  private static final String PATIENT = "http://hl7.org/fhir/StructureDefinition/Patient";

  private static SimpleWorkerContext context;

  @BeforeAll
  static void setUp() throws IOException {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
  }

  static Stream<Arguments> hints() {
    // hint on the properties, whether the values are expected to be links
    return Stream.of(
      Arguments.of(null, true),
      Arguments.of("display", true),
      Arguments.of("no-link", false));
  }

  @ParameterizedTest(name = "hint={0}")
  @MethodSource("hints")
  void urlPropertyIsLinkedUnlessNoLink(String hint, boolean linked) throws Exception {
    String html = render(hint);
    // a resolved url links to the resource page, with the versioned url as the title
    String link = "title=\"" + PATIENT + "|";
    String code = "<code>" + PATIENT + "</code>";
    if (linked) {
      assertTrue(html.contains(link), "expected a link to " + PATIENT + ", but got: " + html);
      assertFalse(html.contains(code), "expected no code element for " + PATIENT + ", but got: " + html);
    } else {
      assertTrue(html.contains(code), "expected " + PATIENT + " as code, but got: " + html);
      assertFalse(html.contains(link), "expected no link to " + PATIENT + ", but got: " + html);
    }
  }

  @ParameterizedTest(name = "hint={0}")
  @MethodSource("hints")
  void parentPropertyIsLinkedUnlessNoLink(String hint, boolean linked) throws Exception {
    String html = render(hint);
    String anchor = "<a href=\"#test-cs-a\">a</a>";
    if (linked) {
      assertTrue(html.contains(anchor), "expected the parent to link to its row, but got: " + html);
      assertTrue(html.contains("<a name=\"test-cs-a\">"), "expected the row the parent links to, but got: " + html);
    } else {
      assertFalse(html.contains(anchor), "expected the parent as plain text, but got: " + html);
      assertTrue(html.matches("(?s).*<td>\\s*a\\s*</td>.*"), "expected the parent as plain text, but got: " + html);
    }
  }

  private String render(String hint) throws Exception {
    CodeSystem cs = new CodeSystem();
    cs.setId("test-cs");
    cs.setUrl("http://example.org/fhir/CodeSystem/test-cs");
    cs.setName("TestCS");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    PropertyComponent ref = cs.addProperty().setCode("ref").setType(PropertyType.STRING);
    PropertyComponent parent = cs.addProperty().setCode("parent").setType(PropertyType.CODE);
    if (hint != null) {
      ref.addExtension(ExtensionDefinitions.EXT_DISPLAY_HINT, new StringType(hint));
      parent.addExtension(ExtensionDefinitions.EXT_DISPLAY_HINT, new StringType(hint));
    }
    cs.addConcept().setCode("a").setDisplay("A");
    ConceptDefinitionComponent b = cs.addConcept().setCode("b").setDisplay("B");
    b.addProperty().setCode("ref").setValue(new StringType(PATIENT));
    b.addProperty().setCode("parent").setValue(new CodeType("a"));

    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = new RendererFactory().factory(cs, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), cs));
    return new XhtmlComposer(false, true).compose(x);
  }
}
