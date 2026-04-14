package org.hl7.fhir.r5.test.rendering;

import java.io.IOException;
import java.time.ZoneId;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Consent;
import org.hl7.fhir.r5.model.Consent.ConsentState;
import org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType;
import org.hl7.fhir.r5.model.Reference;
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
    consent.setSubject(new Reference("Patient/example"));
    consent.addGrantor(new Reference("Organization/example-org"));
    consent.addManager(new Reference("Organization/example-manager"));
    consent.setDecision(ConsentProvisionType.PERMIT);

    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = RendererFactory.factory(consent, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), consent));
    String html = new XhtmlComposer(false, true).compose(x);

    assertFalse(html.contains("<title"), "Narrative XHTML must not contain a <title> element (violates txt-1 constraint), but found one in: " + html);
  }

  @Test
  public void testNarrativeDoesNotContainQuestionnaireRoot() throws Exception {
    Consent consent = new Consent();
    consent.setId("test-consent");
    consent.setStatus(ConsentState.ACTIVE);
    consent.setSubject(new Reference("Patient/example"));
    consent.setDecision(ConsentProvisionType.PERMIT);

    // Add a provision so the hierarchical table is rendered
    Consent.ProvisionComponent provision = consent.getProvisionFirstRep();
    provision.addPurpose().setSystem("http://example.org").setCode("test");

    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = RendererFactory.factory(consent, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), consent));
    String html = new XhtmlComposer(false, true).compose(x);

    assertFalse(html.contains("QuestionnaireRoot"), "Consent narrative should not reference QuestionnaireRoot, but found it in: " + html);
  }
}
