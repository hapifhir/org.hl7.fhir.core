package org.hl7.fhir.r5.test.rendering;

import java.io.IOException;
import java.time.ZoneId;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pins the hrefs emitted in a ConceptMap relationship column: the code system that owns the code
 * must be the one linked, and the fragment must use the {@code #<csId>-<code>} form that
 * CodeSystemRenderer publishes, not a bare {@code #<code>}.
 */
class ConceptMapRendererTest {

  private static final String CS_RELATIONSHIP = "http://hl7.org/fhir/concept-map-relationship";
  private static final String CS_EQUIVALENCE = "http://hl7.org/fhir/concept-map-equivalence";
  private static final String RELATIONSHIP_PAGE = "http://hl7.org/fhir/R5/codesystem-concept-map-relationship.html";
  private static final String EQUIVALENCE_PAGE = "http://hl7.org/fhir/R4/codesystem-concept-map-equivalence.html";

  private static SimpleWorkerContext context;

  @BeforeAll
  static void setUp() throws IOException {
    // a fresh, non-shared context: the setup below mutates live loaded resources
    context = TestingUtilities.getWorkerContext("5.0.0");

    // Neither code system has a web path out of the box, because TestingUtilities loads packages
    // without an IContextResourceLoader to supply getResourcePath(). Both are already present and
    // outrank anything cacheResource could add - concept-map-relationship from the R5 core package
    // and concept-map-equivalence from hl7.fhir.uv.extensions - so both are mutated in place.
    CodeSystem relationship = context.fetchCodeSystem(CS_RELATIONSHIP, IWorkerContext.VersionResolutionRules.defaultRule());
    assertNotNull(relationship, "setup: " + CS_RELATIONSHIP + " must resolve");
    relationship.setWebPath(RELATIONSHIP_PAGE);

    CodeSystem equivalence = context.fetchCodeSystem(CS_EQUIVALENCE, IWorkerContext.VersionResolutionRules.defaultRule());
    assertNotNull(equivalence, "setup: " + CS_EQUIVALENCE + " must resolve");
    equivalence.setWebPath(EQUIVALENCE_PAGE);

    // the anchors asserted below are built from the resolved ids, so pin those too
    assertEquals("concept-map-relationship", relationship.getId(), "setup: unexpected relationship code system id");
    assertEquals("concept-map-equivalence", equivalence.getId(), "setup: unexpected equivalence code system id");
    assertEquals(RELATIONSHIP_PAGE,
        context.fetchCodeSystem(CS_RELATIONSHIP, IWorkerContext.VersionResolutionRules.defaultRule()).getWebPath(),
        "setup: relationship web path did not take effect");
    assertEquals(EQUIVALENCE_PAGE,
        context.fetchCodeSystem(CS_EQUIVALENCE, IWorkerContext.VersionResolutionRules.defaultRule()).getWebPath(),
        "setup: equivalence web path did not take effect");
  }

  @Test
  void renderRelationshipUsesPrefixedAnchorOnRelationshipCodeSystem() throws Exception {
    String html = render(ConceptMapRelationship.SOURCEISNARROWERTHANTARGET, null);

    assertTrue(html.contains(RELATIONSHIP_PAGE + "#concept-map-relationship-source-is-narrower-than-target"),
        "relationship link must use the #<csId>-<code> anchor form, but got: " + html);
    assertFalse(html.contains("codesystem-concept-map-relationship.html#source-is-narrower-than-target"),
        "relationship link must not use the bare #<code> fragment, but got: " + html);
  }

  @Test
  void renderLegacyEquivalenceUsesEquivalenceCodeSystem() throws Exception {
    String html = render(ConceptMapRelationship.SOURCEISNARROWERTHANTARGET, "wider");

    assertTrue(html.contains(EQUIVALENCE_PAGE + "#concept-map-equivalence-wider"),
        "legacy equivalence code must link to the equivalence code system, but got: " + html);
    assertFalse(html.contains("concept-map-relationship.html#"),
        "an R4 equivalence code must never link to the R5 relationship page, but got: " + html);
  }

  @Test
  void renderEquivalenceNarrowerHasFriendlyDisplay() throws Exception {
    String html = render(ConceptMapRelationship.SOURCEISBROADERTHANTARGET, "narrower");

    assertTrue(html.contains("maps to narrower concept"),
        "the 'narrower' equivalence code must render its friendly display, but got: " + html);
  }

  private String render(ConceptMapRelationship relationship, String legacyEquivalenceCode) throws Exception {
    ConceptMap cm = new ConceptMap();
    cm.setId("test-concept-map");
    cm.setName("TestConceptMap");
    cm.setStatus(PublicationStatus.ACTIVE);

    ConceptMapGroupComponent grp = cm.addGroup();
    grp.setSource("http://example.org/fhir/CodeSystem/source");
    grp.setTarget("http://example.org/fhir/CodeSystem/target");

    SourceElementComponent src = grp.addElement();
    src.setCode("src-code");

    TargetElementComponent tgt = src.addTarget();
    tgt.setCode("tgt-code");
    tgt.setRelationship(relationship);
    if (legacyEquivalenceCode != null) {
      // the exact call the R4/R4B/STU3 -> R5 converters make: a modifier extension carrying a code
      ExtensionUtilities.setCodeExtensionMod(tgt, ExtensionDefinitions.EXT_OLD_CONCEPTMAP_EQUIVALENCE, legacyEquivalenceCode);
    }

    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = new RendererFactory().factory(cm, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), cm));
    return new XhtmlComposer(false, true).compose(x);
  }
}
