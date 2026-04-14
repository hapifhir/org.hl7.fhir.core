package org.hl7.fhir.r5.test.rendering;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.StructureDefinitionRenderer;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.StructureDefinitionRendererMode;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.test.NarrativeGenerationTests.TestProfileKnowledgeProvider;
import org.hl7.fhir.r5.test.NarrativeGenerationTests.TestTypeParser;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.TerminologyServiceOptions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StructureDefinitionRendererPatternTest {

  private static final String DEF_FILE = "test-def.html";
  private static final String CORE_PATH = "http://hl7.org/fhir/";

  private static IWorkerContext context;
  private static RenderingContext rc;

  @BeforeAll
  public static void setUp() throws IOException {
    context = TestingUtilities.getSharedWorkerContext("5.0.0");
    rc = new RenderingContext(context, null, null, CORE_PATH, "", null, ResourceRendererMode.TECHNICAL, GenerationRules.VALID_RESOURCE);
    rc.setDefinitionsTarget(DEF_FILE);
    rc.setTerminologyServiceOptions(TerminologyServiceOptions.defaults());
    rc.setParser(new TestTypeParser());
    rc.setProfileUtilities(new ProfileUtilities(rc.getContext(), null, new TestProfileKnowledgeProvider(rc.getContext())));
    rc.setStructureMode(StructureDefinitionRendererMode.SUMMARY);
    rc.setTesting(true);

    FileUtilities.createDirectory(Utilities.path("[tmp]", "narrative"));
  }

  @Test
  public void complexPatternAvoidsDuplicateSyntheticRowsInSummaryAndAttributeTables() throws Exception {
    StructureDefinition sd = makeBasePatientProfile("PatientPatternRows");
    HumanName pattern = new HumanName();
    pattern.setFamily("Testmann");
    pattern.addGiven("Simone");
    pattern.addGiven("Maria");
    addNamePattern(sd, pattern);
    addMustSupportGiven(sd);
    generateSnapshot(sd);

    String snapshotTable = render(sd, false, false);
    assertNoSyntheticPatternRowWithGiven(snapshotTable);
    assertPatternVisible(snapshotTable);
    assertMergedPatternValueVisible(snapshotTable);

    String differentialTable = render(sd, true, false);
    assertNoSyntheticPatternRowWithGiven(differentialTable);
    assertPatternVisible(differentialTable);
    assertMergedPatternValueVisible(differentialTable);

    String snapshotAttributeTable = render(sd, false, true);
    assertNoSyntheticPatternRow(snapshotAttributeTable);
    assertPatternVisible(snapshotAttributeTable);

    String differentialAttributeTable = render(sd, true, true);
    assertNoSyntheticPatternRow(differentialAttributeTable);
    assertPatternVisible(differentialAttributeTable);
  }

  @Test
  public void complexPatternKeepsComplexMarkerAndMergesNestedChildValues() throws Exception {
    StructureDefinition sd = makeBasePatientProfile("PatientIdentifierPatternNested");

    Identifier identifierPattern = new Identifier();
    identifierPattern.getType().addCoding(new Coding()
      .setSystem("http://fhir.de/CodeSystem/identifier-type-de-basis")
      .setCode("KVZ10"));

    ElementDefinition identifier = new ElementDefinition();
    identifier.setId("Patient.identifier");
    identifier.setPath("Patient.identifier");
    identifier.setPattern(identifierPattern);
    sd.getDifferential().addElement(identifier);

    addMustSupportElement(sd, "Patient.identifier.type", "Patient.identifier.type");
    addMustSupportElement(sd, "Patient.identifier.type.coding", "Patient.identifier.type.coding");
    addMustSupportElement(sd, "Patient.identifier.type.coding.system", "Patient.identifier.type.coding.system");
    addMustSupportElement(sd, "Patient.identifier.type.coding.code", "Patient.identifier.type.coding.code");
    generateSnapshot(sd);

    String html = render(sd, false, false);
    assertTrue(html.contains("Fixed Value"));
    assertTrue(html.contains("(Complex)"));
    assertTrue(html.contains("http://fhir.de/CodeSystem/identifier-type-de-basis"));
    assertTrue(html.contains("KVZ10"));
    assertFalse(html.contains("Identifier.type.coding"));
  }

  @Test
  public void typePatternCreatesNestedRowsWhenCodingIsOutOfScope() throws Exception {
    StructureDefinition sd = makeBasePatientProfile("PatientIdentifierTypePattern");

    ElementDefinition typePattern = new ElementDefinition();
    typePattern.setId("Patient.identifier.type");
    typePattern.setPath("Patient.identifier.type");
    typePattern.setPattern(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(
      new Coding().setSystem("http://fhir.de/CodeSystem/identifier-type-de-basis").setCode("KVZ10")
    ));
    typePattern.setMustSupport(true);
    sd.getDifferential().addElement(typePattern);
    generateSnapshot(sd);

    String html = render(sd, true, false);
    assertTrue(html.contains("Required Pattern"));
    assertTrue(html.contains(">coding<"));
    assertTrue(html.contains("http://fhir.de/CodeSystem/identifier-type-de-basis"));
    assertTrue(html.contains("KVZ10"));
  }

  private String render(StructureDefinition sd, boolean diff, boolean attributeTable) throws Exception {
    ResourceWrapper resource = ResourceWrapper.forResource(rc.getContextUtilities(), (Resource) sd);
    StructureDefinitionRenderer renderer = new StructureDefinitionRenderer(rc);
    RenderingStatus status = new RenderingStatus();
    XhtmlNode node = attributeTable
      ? renderer.generateAttributeTable(status, DEF_FILE, sd, diff, Utilities.path("[tmp]", "narrative"), true, sd.getId(), !diff, CORE_PATH, "",
        false, false, null, false, rc, "", resource, diff ? "da" : "sa")
      : renderer.generateTable(status, DEF_FILE, sd, diff, Utilities.path("[tmp]", "narrative"), true, sd.getId(), !diff, CORE_PATH, "",
        false, false, null, false, rc, "", resource, diff ? "d" : "s");
    return new XhtmlComposer(true).compose(node);
  }

  private void assertNoSyntheticPatternRowWithGiven(String html) {
    assertTrue(html.contains(">given<"));
    assertFalse(html.contains("HumanName.given"));
  }

  private void assertNoSyntheticPatternRow(String html) {
    assertFalse(html.contains("HumanName.given"));
  }

  private void assertPatternVisible(String html) {
    assertTrue(html.contains("Required Pattern"));
  }

  private void assertMergedPatternValueVisible(String html) {
    assertTrue(html.contains("Simone"));
  }

  private StructureDefinition makeBasePatientProfile(String id) {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(id);
    sd.setUrl("http://example.org/StructureDefinition/"+id);
    sd.setName(id);
    sd.setTitle(id);
    sd.setStatus(PublicationStatus.ACTIVE);
    sd.setType("Patient");
    sd.setKind(StructureDefinitionKind.RESOURCE);
    sd.setAbstract(false);
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Patient");

    StructureDefinitionDifferentialComponent diff = new StructureDefinitionDifferentialComponent();
    sd.setDifferential(diff);

    ElementDefinition root = new ElementDefinition();
    root.setId("Patient");
    root.setPath("Patient");
    diff.addElement(root);
    return sd;
  }

  private void addNamePattern(StructureDefinition sd, HumanName pattern) {
    ElementDefinition name = new ElementDefinition();
    name.setId("Patient.name");
    name.setPath("Patient.name");
    name.setPattern(pattern);
    sd.getDifferential().addElement(name);
  }

  private void addMustSupportGiven(StructureDefinition sd) {
    ElementDefinition given = new ElementDefinition();
    given.setId("Patient.name.given");
    given.setPath("Patient.name.given");
    given.setMustSupport(true);
    sd.getDifferential().addElement(given);
  }

  private void addMustSupportElement(StructureDefinition sd, String id, String path) {
    ElementDefinition element = new ElementDefinition();
    element.setId(id);
    element.setPath(path);
    element.setMustSupport(true);
    sd.getDifferential().addElement(element);
  }

  private void generateSnapshot(StructureDefinition sd) {
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    rc.getProfileUtilities().generateSnapshot(base, sd, sd.getUrl(), "http://example.org", sd.getName());
  }
}
