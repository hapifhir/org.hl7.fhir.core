package org.hl7.fhir.services.renderers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ConceptMapRendererTest {

  private static final String CS_RELATIONSHIP = "http://hl7.org/fhir/concept-map-relationship";
  private static final String CS_EQUIVALENCE = "http://hl7.org/fhir/concept-map-equivalence";
  private static final String RELATIONSHIP_PAGE = "codesystem-concept-map-relationship.html";
  private static final String EQUIVALENCE_PAGE = "codesystem-concept-map-equivalence.html";
  private static final String SOURCE_SYSTEM = "http://example.org/fhir/CodeSystem/source";
  private static final String TARGET_SYSTEM = "http://example.org/fhir/CodeSystem/target";
  private static final String SOURCE_CODE = "Source.value";
  private static final String TARGET_CODE = "Target.value";

  private enum RenderPath {
    SIMPLE(1, 1, 3), COMPLEX(2, 2, 5), MODEL(1, 3, 7);

    private final int firstDataRow;
    private final int relationshipColumn;
    private final int columns;

    RenderPath(int firstDataRow, int relationshipColumn, int columns) {
      this.firstDataRow = firstDataRow;
      this.relationshipColumn = relationshipColumn;
      this.columns = columns;
    }
  }

  @ParameterizedTest
  @MethodSource("relationshipCases")
  void relationshipLinksUseOwningCodeSystemAcrossRenderPaths(RenderPath path,
      ConceptMapRelationship relationship, String code, String display) throws IOException {
    Fixture fixture = new Fixture(path);
    fixture.target.setRelationship(relationship);

    XhtmlNode narrative = fixture.render();

    assertLink(relationshipCell(narrative, path, 0),
        RELATIONSHIP_PAGE + "#concept-map-relationship-" + code, code, display);
    String html = compose(narrative);
    assertFalse(html.contains("#" + code + "\""), html);
    assertFalse(html.contains(EQUIVALENCE_PAGE + "#"), html);
  }

  static Stream<Arguments> relationshipCases() {
    return Arrays.stream(RenderPath.values()).flatMap(path -> Stream.of(
        arguments(path, ConceptMapRelationship.RELATEDTO, "related-to", "is related to"),
        arguments(path, ConceptMapRelationship.EQUIVALENT, "equivalent", "is equivalent to"),
        arguments(path, ConceptMapRelationship.SOURCEISNARROWERTHANTARGET,
            "source-is-narrower-than-target", "is narrower than"),
        arguments(path, ConceptMapRelationship.SOURCEISBROADERTHANTARGET,
            "source-is-broader-than-target", "is broader than"),
        arguments(path, ConceptMapRelationship.NOTRELATEDTO, "not-related-to", "is not related to")));
  }

  @ParameterizedTest
  @MethodSource("legacyEquivalenceCases")
  void legacyEquivalenceLinksUseOwningCodeSystemAcrossRenderPaths(RenderPath path,
      ConceptMapRelationship relationship, String code, String display) throws IOException {
    Fixture fixture = new Fixture(path);
    fixture.target.setRelationship(relationship);
    fixture.useLegacyEquivalence(code);

    XhtmlNode narrative = fixture.render();
    XhtmlNode cell = relationshipCell(narrative, path, 0);

    assertLink(cell, EQUIVALENCE_PAGE + "#concept-map-equivalence-" + code, code, display);
    assertFalse(compose(narrative).contains("#" + code + "\""));
    assertFalse(compose(cell).contains(RELATIONSHIP_PAGE + "#"));
  }

  static Stream<Arguments> legacyEquivalenceCases() {
    return Arrays.stream(RenderPath.values()).flatMap(path -> Stream.of(
        arguments(path, ConceptMapRelationship.EQUIVALENT, "equivalent", "is equivalent to"),
        arguments(path, ConceptMapRelationship.EQUIVALENT, "equal", "is equal to"),
        arguments(path, ConceptMapRelationship.SOURCEISNARROWERTHANTARGET, "wider", "maps to wider concept"),
        arguments(path, ConceptMapRelationship.SOURCEISBROADERTHANTARGET, "narrower", "maps to narrower concept")));
  }

  @ParameterizedTest
  @MethodSource("missingMappingData")
  void missingRelationshipAndGroupSystemsRenderSafely(RenderPath path, boolean missingSource,
      boolean missingTarget) throws IOException {
    Fixture fixture = new Fixture(path);
    fixture.target.setRelationship(null);
    if (missingSource) {
      fixture.group.setSource(null);
    }
    if (missingTarget) {
      fixture.group.setTarget(null);
    }

    XhtmlNode narrative = fixture.render();
    XhtmlNode cell = relationshipCell(narrative, path, 0);

    assertNull(cell.getElement("a"));
    if (path == RenderPath.COMPLEX) {
      assertTrue(cell.getChildNodes().isEmpty());
      assertEquals("", cell.allText());
      assertLink(relationshipCell(narrative, path, 1),
          RELATIONSHIP_PAGE + "#concept-map-relationship-related-to", "related-to", "is related to");
    } else {
      assertEquals(":(equivalent)", cell.allText());
    }
    List<XhtmlNode> unspecifiedSystems = narrative.getChildren("p").get(1).getChildren("code");
    assertEquals((missingSource ? 1 : 0) + (missingTarget ? 1 : 0), unspecifiedSystems.size());
    for (XhtmlNode unspecified : unspecifiedSystems) {
      assertEquals("unspecified code system", unspecified.allText());
    }
  }

  static Stream<Arguments> missingMappingData() {
    return Stream.of(
        arguments(RenderPath.SIMPLE, false, false),
        arguments(RenderPath.COMPLEX, false, false),
        arguments(RenderPath.MODEL, false, false),
        arguments(RenderPath.SIMPLE, true, false),
        arguments(RenderPath.SIMPLE, false, true),
        arguments(RenderPath.SIMPLE, true, true),
        arguments(RenderPath.COMPLEX, true, false),
        arguments(RenderPath.COMPLEX, false, true),
        arguments(RenderPath.COMPLEX, true, true));
  }

  @ParameterizedTest
  @MethodSource("ownerCases")
  void unresolvedOwnerRendersUnlinkedText(RenderPath path, boolean legacy) throws IOException {
    Fixture fixture = ownerFixture(path, legacy);
    fixture.codeSystems.remove(legacy ? CS_EQUIVALENCE : CS_RELATIONSHIP);

    XhtmlNode cell = relationshipCell(fixture.render(), path, 0);

    assertEquals(legacy ? "maps to narrower concept" : "is broader than", cell.allText());
    assertNull(cell.getElement("a"));
    assertFalse(compose(cell).contains("href="));
  }

  @ParameterizedTest
  @MethodSource("ownerCases")
  void missingWebPathRendersUnlinkedText(RenderPath path, boolean legacy) throws IOException {
    Fixture fixture = ownerFixture(path, legacy);
    fixture.codeSystems.get(legacy ? CS_EQUIVALENCE : CS_RELATIONSHIP).setWebPath(null);

    XhtmlNode cell = relationshipCell(fixture.render(), path, 0);

    assertEquals(legacy ? "maps to narrower concept" : "is broader than", cell.allText());
    assertNull(cell.getElement("a"));
    assertFalse(compose(cell).contains("href="));
    assertFalse(compose(cell).contains("null#"));
    assertEquals(legacy ? "narrower" : "source-is-broader-than-target", cell.getElement("span").getAttribute("title"));
  }

  @ParameterizedTest
  @MethodSource("ownerCases")
  void repeatedFreshRendersDoNotLeakState(RenderPath path, boolean legacy) throws IOException {
    for (int i = 0; i < 2; i++) {
      Fixture fixture = ownerFixture(path, legacy);
      String page = "render-" + i + ".html";
      fixture.codeSystems.get(legacy ? CS_EQUIVALENCE : CS_RELATIONSHIP).setWebPath(page);

      XhtmlNode narrative = fixture.render();

      assertLink(relationshipCell(narrative, path, 0),
          page + (legacy ? "#concept-map-equivalence-narrower"
              : "#concept-map-relationship-source-is-broader-than-target"),
          legacy ? "narrower" : "source-is-broader-than-target",
          legacy ? "maps to narrower concept" : "is broader than");
      if (i == 1) {
        assertFalse(compose(narrative).contains("render-0.html"));
      }
    }
  }

  static Stream<Arguments> ownerCases() {
    return Arrays.stream(RenderPath.values()).flatMap(path -> Stream.of(
        arguments(path, false), arguments(path, true)));
  }

  private static Fixture ownerFixture(RenderPath path, boolean legacy) {
    Fixture fixture = new Fixture(path);
    if (legacy) {
      fixture.useLegacyEquivalence("narrower");
    }
    return fixture;
  }

  private static XhtmlNode relationshipCell(XhtmlNode narrative, RenderPath path, int targetIndex) {
    return narrative.getElement("table").getChildren("tr").get(path.firstDataRow + targetIndex)
        .getChildren("td").get(path.relationshipColumn);
  }

  private static void assertLink(XhtmlNode cell, String href, String code, String display) throws IOException {
    XhtmlNode link = cell.getElement("a");
    assertNotNull(link, compose(cell));
    assertEquals(href, link.getAttribute("href"));
    assertEquals(code, link.getAttribute("title"));
    assertEquals(display, link.allText());
    assertEquals(display, cell.allText());
  }

  private static String compose(XhtmlNode node) throws IOException {
    return new XhtmlComposer(false, true).compose(node);
  }

  private static void assertRenderPath(XhtmlNode narrative, RenderPath path) {
    XhtmlNode table = narrative.getElement("table");
    assertNotNull(table);
    List<XhtmlNode> rows = table.getChildren("tr");
    assertEquals(path == RenderPath.COMPLEX ? 4 : 2, rows.size());
    List<XhtmlNode> cells = rows.get(path.firstDataRow).getChildren("td");
    assertEquals(path.columns, cells.size());
    if (path == RenderPath.MODEL) {
      assertEquals("source-structure.html#s-Source.value", cells.get(0).getElement("a").getAttribute("href"));
      assertEquals("0..1", cells.get(1).allText());
      assertEquals("target-structure.html#s-Target.value", cells.get(4).getElement("a").getAttribute("href"));
      assertEquals("1..*", cells.get(5).allText());
    } else if (path == RenderPath.COMPLEX) {
      assertEquals(SOURCE_CODE, cells.get(0).allText());
      assertEquals(TARGET_CODE, cells.get(3).allText());
      assertEquals("Target.other", rows.get(3).getChildren("td").get(3).allText());
    } else {
      assertEquals(SOURCE_CODE + " (Source display)", cells.get(0).allText());
      assertEquals(TARGET_CODE + " (Target display)", cells.get(2).allText());
    }
  }

  private static class Fixture {
    private final RenderPath path;
    private final IWorkerContext worker = mock(IWorkerContext.class);
    private final Map<String, CodeSystem> codeSystems = new HashMap<>();
    private final Map<String, StructureDefinition> definitions = new HashMap<>();
    private final ConceptMap map = new ConceptMap();
    private final ConceptMapGroupComponent group;
    private final TargetElementComponent target;
    private final RenderingContext context;

    Fixture(RenderPath path) {
      this.path = path;
      addCodeSystem("concept-map-relationship", CS_RELATIONSHIP, RELATIONSHIP_PAGE);
      addCodeSystem("concept-map-equivalence", CS_EQUIVALENCE, EQUIVALENCE_PAGE);
      addCodeSystem("source", SOURCE_SYSTEM, "source-codes.html");
      addCodeSystem("target", TARGET_SYSTEM, "target-codes.html");

      map.setId("test-concept-map");
      map.setName("TestConceptMap");
      map.setStatus(PublicationStatus.ACTIVE);
      group = map.addGroup().setSource(SOURCE_SYSTEM).setTarget(TARGET_SYSTEM);
      if (path == RenderPath.MODEL) {
        group.setSource(addDefinition("Source", "source-structure.html", 0, "1").getUrl());
        group.setTarget(addDefinition("Target", "target-structure.html", 1, "*").getUrl());
      }
      SourceElementComponent source = group.addElement().setCode(SOURCE_CODE).setDisplay("Source display");
      target = source.addTarget().setCode(TARGET_CODE).setDisplay("Target display")
          .setRelationship(ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
      if (path == RenderPath.COMPLEX) {
        source.addTarget().setCode("Target.other").setDisplay("Sibling display")
            .setRelationship(ConceptMapRelationship.RELATEDTO);
      }

      when(worker.getFHIRVersion()).thenReturn("6.0.0");
      // The native default version-resolution rule is null.
      when(worker.fetchCodeSystem(nullable(String.class), nullable(VersionResolutionRules.class)))
          .thenAnswer(invocation -> codeSystems.get(invocation.getArgument(0)));
      when(worker.fetchResource(eq(StructureDefinition.class), anyString(), nullable(VersionResolutionRules.class)))
          .thenAnswer(invocation -> definitions.get(invocation.getArgument(1)));
      when(worker.fetchResource(eq(Resource.class), anyString(), nullable(VersionResolutionRules.class),
          isNull(), any(Resource.class)))
          .thenAnswer(invocation -> codeSystems.get(invocation.getArgument(1)));

      context = new RenderingContext(worker, new RendererFactory(), new MarkDownProcessor(Dialect.COMMON_MARK),
          ValidationOptions.defaults(), "http://hl7.org/fhir/R6", "", Locale.ENGLISH,
          ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE);
      context.setTesting(true);
      context.setShowSummaryTable(false);
    }

    private void addCodeSystem(String id, String url, String page) {
      CodeSystem codeSystem = new CodeSystem();
      codeSystem.setId(id);
      codeSystem.setUrl(url);
      codeSystem.setName(id);
      codeSystem.setWebPath(page);
      codeSystems.put(url, codeSystem);
    }

    private StructureDefinition addDefinition(String type, String page, int min, String max) {
      StructureDefinition definition = new StructureDefinition();
      definition.setId(type);
      definition.setUrl("http://example.org/fhir/StructureDefinition/" + type);
      definition.setName(type);
      definition.setType(type);
      definition.setWebPath(page);
      definition.getSnapshot().addElement().setPath(type).setMin(0).setMax("1").setId(type);
      definition.getSnapshot().addElement().setPath(type + ".value").setMin(min).setMax(max).setId(type + ".value");
      definitions.put(definition.getUrl(), definition);
      return definition;
    }

    private void useLegacyEquivalence(String code) {
      // Use the native modifier-only representation written by legacy converters.
      ExtensionUtilities.setCodeExtensionMod(target, ExtensionDefinitions.EXT_OLD_CONCEPTMAP_EQUIVALENCE, code);
      assertTrue(target.getExtensionsForRead().isEmpty());
      assertEquals(1, target.getModifierExtensionsForRead().size());
    }

    private XhtmlNode render() throws IOException {
      XhtmlNode narrative = new XhtmlNode(NodeType.Element, "div");
      new ConceptMapRenderer(context).render(new RenderingStatus(), ResourceWrapper.forResource(context, map),
          narrative, map, false);
      verify(worker).getFHIRVersion();
      assertRenderPath(narrative, path);
      return narrative;
    }
  }
}
