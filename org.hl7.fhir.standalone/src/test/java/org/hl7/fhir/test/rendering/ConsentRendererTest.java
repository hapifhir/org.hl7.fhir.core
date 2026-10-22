package org.hl7.fhir.test.rendering;

import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
  private static final String R4_CONSENT_START = "{\"resourceType\":\"Consent\",\"id\":\"test-consent\",";
  private static final String R4_CONSENT_END = "\"status\":\"active\","
    + "\"scope\":{\"coding\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/consentscope\",\"code\":\"research\"}]},"
    + "\"category\":[{\"coding\":[{\"system\":\"http://loinc.org\",\"code\":\"59284-0\"}]}],"
    + "\"patient\":{\"reference\":\"Patient/example\"},"
    + "\"policy\":[{\"uri\":\"https://example.org/policy\"}],";
  private static final String R4_PROVISION_RESEARCH = "\"provision\":{\"purpose\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/v3-ActReason\",\"code\":\"HRESCH\"}]}}";

  private static String r4DecisionExtension(String decision) {
    return "\"modifierExtension\":[{\"url\":\"http://hl7.org/fhir/5.0/StructureDefinition/extension-Consent.decision\",\"valueCode\":\"" + decision + "\"}],";
  }

  @Test
  void testR4DecisionDenyWithProvisionException() throws Exception {
    String json = R4_CONSENT_START + r4DecisionExtension("deny") + R4_CONSENT_END + R4_PROVISION_RESEARCH;
    assertEquals(List.of("deny", "permit"), renderR4ConsentRules(json));
  }

  @Test
  void testR4DecisionPermitWithProvisionException() throws Exception {
    String json = R4_CONSENT_START + r4DecisionExtension("permit") + R4_CONSENT_END + R4_PROVISION_RESEARCH;
    assertEquals(List.of("permit", "deny"), renderR4ConsentRules(json));
  }

  @Test
  void testR4RootProvisionWithoutType() throws Exception {
    String json = R4_CONSENT_START + R4_CONSENT_END
      + "\"provision\":{\"provision\":[{\"type\":\"deny\",\"data\":[{\"meaning\":\"instance\",\"reference\":{\"reference\":\"Encounter/example\"}}]}]}}";
    assertEquals(List.of("permit", "permit", "deny"), renderR4ConsentRules(json));
  }

  /**
   * Renders an R4 Consent and returns the permit/deny column of the rule table, from the base rule down
   */
  private List<String> renderR4ConsentRules(String json) throws Exception {
    IWorkerContext r4context = TestingUtilities.getSharedWorkerContext("4.0.1");
    Element consent = Manager.parseSingle(r4context, new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);

    RenderingContext rc = new RenderingContext(r4context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new NarrativeGenerationTests.TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    ResourceWrapper rw = ResourceWrapper.forResource(rc.getContextUtilities(), consent);
    XhtmlNode x = new RendererFactory().factory(rw, rc).buildNarrative(rw);
    String html = new XhtmlComposer(false, false).compose(x);

    List<String> rules = new ArrayList<>();
    Matcher m = Pattern.compile("(permit|deny)</td>").matcher(html);
    while (m.find()) {
      rules.add(m.group(1));
    }
    return rules;
  }
}
