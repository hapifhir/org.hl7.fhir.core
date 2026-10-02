package org.hl7.fhir.test.rendering;

import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.Consent;
import org.hl7.fhir.model.core.Consent.ConsentState;
import org.hl7.fhir.model.core.Reference;
import org.hl7.fhir.services.renderers.RendererFactory;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.test.NarrativeGenerationTests;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ConsentRendererTest {

  private static IWorkerContext context;

  @BeforeAll
  public static void setUp() throws IOException {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
  }

  @Test
  public void testNarrativeDoesNotContainTitleElement() throws Exception {
    Consent consent = new Consent();
    consent.setId("test-consent");
    consent.setStatus(ConsentState.ACTIVE);
    consent.setSubject(new Reference(null, "Patient/example"));
    consent.addGrantor(new Reference(null, "Organization/example-org"));
    consent.addManager(new Reference(null, "Organization/example-manager"));
    consent.setDecision(Consent.ConsentProvisionType.PERMIT);

    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new NarrativeGenerationTests.TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = new RendererFactory().factory(consent, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), consent));
    String html = new XhtmlComposer(false, true).compose(x);

    assertFalse(html.contains("<title"), "Narrative XHTML must not contain a <title> element (violates txt-1 constraint), but found one in: " + html);
  }

  @Test
  public void testNarrativeDoesNotContainQuestionnaireRoot() throws Exception {
    Consent consent = new Consent();
    consent.setId("test-consent");
    consent.setStatus(ConsentState.ACTIVE);
    consent.setSubject(new Reference(null, "Patient/example"));
    consent.setDecision(Consent.ConsentProvisionType.PERMIT);

    // Add a provision so the hierarchical table is rendered
    Consent.ProvisionComponent provision = consent.getProvisionFirstRep();
    provision.addPurpose().setSystem("http://example.org").setCode("test");

    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new NarrativeGenerationTests.TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = new RendererFactory().factory(consent, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), consent));
    String html = new XhtmlComposer(false, true).compose(x);

    assertFalse(html.contains("QuestionnaireRoot"), "Consent narrative should not reference QuestionnaireRoot, but found it in: " + html);
  }
}
