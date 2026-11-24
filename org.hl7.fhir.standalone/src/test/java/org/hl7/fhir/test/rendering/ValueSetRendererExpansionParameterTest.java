package org.hl7.fhir.test.rendering;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.ZoneId;

import org.hl7.fhir.model.core.DateTimeType;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.UriType;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
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

/**
 * ValueSet.expansion.parameter.value[x] is 0..1, and terminology servers do report parameters without a
 * value (e.g. used-valueset for an inline value set). Rendering the expansion must not fail on them.
 */
public class ValueSetRendererExpansionParameterTest {

  private static IWorkerContext context;

  @BeforeAll
  public static void setUp() throws IOException {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
  }

  @Test
  public void testExpansionParametersWithoutValue() throws Exception {
    ValueSet vs = new ValueSet();
    vs.setId("test-expansion-parameters");
    vs.setUrl("http://example.org/fhir/ValueSet/test-expansion-parameters");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem("http://example.org/fhir/CodeSystem/test");

    ValueSetExpansionComponent exp = vs.getExpansion();
    exp.setTimestampElement(new DateTimeType("2026-11-23T00:00:00Z"));
    exp.addParameter().setName("used-codesystem").setValue(new UriType("http://example.org/fhir/CodeSystem/test|1.0.0"));
    exp.addParameter().setName("used-valueset");
    exp.addParameter().setName("version");
    exp.addParameter().setName("fragment");
    exp.addParameter().setName("displayLanguage");
    exp.addContains().setSystem("http://example.org/fhir/CodeSystem/test").setCode("a").setDisplay("Code A");

    RenderingContext rc = new RenderingContext(context, new RendererFactory(), null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
    rc.setDestDir(Utilities.path("[tmp]", "narrative"));
    rc.setLocale(new java.util.Locale("en", "AU"));
    rc.setTimeZoneId(ZoneId.of("Australia/Sydney"));
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new NarrativeGenerationTests.TestProfileKnowledgeProvider(rc.getContext())));
    rc.setTesting(true);

    XhtmlNode x = new RendererFactory().factory(vs, rc).buildNarrative(ResourceWrapper.forResource(rc.getContextUtilities(), vs));
    String html = new XhtmlComposer(false, true).compose(x);

    assertTrue(html.contains("Code A"), "the expanded code is rendered: " + html);
    assertTrue(html.contains("1.0.0"), "the version of the used code system is reported: " + html);
  }
}
