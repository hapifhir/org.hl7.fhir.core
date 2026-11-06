package org.hl7.fhir.r5.fhirpath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.TypedElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Behaviour of the extension(url) function when used in a slicing discriminator, exercised through
 * FHIRPathEngine.evaluateDefinition.
 *
 * Each fixture uses a distinct canonical url: the shared worker context caches StructureDefinitions
 * by url, so reusing one would let an earlier fixture satisfy a later assertion.
 */
public class FHIRPathEngineDiscriminatorTests {

  private static final String SUB_EXTENSION_URL = "http://example.org/StructureDefinition/test-sub-function";

  private static IWorkerContext context;
  private static FHIRPathEngine fp;

  @BeforeAll
  public static void setUp() throws Exception {
    context = TestingUtilities.getSharedWorkerContext();
    fp = new FHIRPathEngine(context);
    context.getManager().cacheResource(subExtensionDefinition());
  }

  /** A standalone extension definition, referenced by profile url from a parent extension. */
  private static StructureDefinition subExtensionDefinition() {
    StructureDefinition sd = newExtension(SUB_EXTENSION_URL);
    addElement(sd, "Extension", "Extension");
    addElement(sd, "Extension.url", "Extension.url").setFixed(new UriType(SUB_EXTENSION_URL));
    addElement(sd, "Extension.value[x]", "Extension.value[x]");
    return sd;
  }

  private static StructureDefinition newExtension(String url) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl(url);
    sd.setName(url.substring(url.lastIndexOf('/') + 1).replace("-", ""));
    sd.setStatus(PublicationStatus.DRAFT);
    sd.setKind(StructureDefinitionKind.COMPLEXTYPE);
    sd.setType("Extension");
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Extension");
    return sd;
  }

  private static ElementDefinition addElement(StructureDefinition sd, String id, String path) {
    ElementDefinition ed = sd.getSnapshot().addElement();
    ed.setId(id);
    ed.setPath(path);
    return ed;
  }

  /**
   * A complex extension with one sub-extension slice named 'function'.
   *
   * @param fixedUrl the fixed url on the sub-extension, or null for none
   * @param typeProfile a profile url on the sub-extension's type, or null for none
   */
  private StructureDefinition complexExtension(String canonical, String fixedUrl, String typeProfile) {
    StructureDefinition sd = newExtension(canonical);
    addElement(sd, "Extension", "Extension");
    addElement(sd, "Extension.extension", "Extension.extension");
    ElementDefinition slice = addElement(sd, "Extension.extension:function", "Extension.extension");
    slice.setSliceName("function");
    if (typeProfile != null) {
      slice.addType().setCode("Extension").addProfile(typeProfile);
    }
    ElementDefinition url = addElement(sd, "Extension.extension:function.url", "Extension.extension.url");
    if (fixedUrl != null) {
      url.setFixed(new UriType(fixedUrl));
    }
    addElement(sd, "Extension.extension:function.value[x]", "Extension.extension.value[x]");
    return sd;
  }

  private TypedElementDefinition evaluate(StructureDefinition sd, String expression) throws Exception {
    ExpressionNode expr = fp.parse(expression);
    TypedElementDefinition root = new TypedElementDefinition(sd.getSnapshot().getElementFirstRep());
    return fp.evaluateDefinition(expr, sd, root, sd, false);
  }

  @Test
  public void subExtensionDeclaredByProfileIsResolved() throws Exception {
    StructureDefinition sd = complexExtension("http://example.org/StructureDefinition/test-by-profile", null, SUB_EXTENSION_URL);
    TypedElementDefinition ted = evaluate(sd, "extension('" + SUB_EXTENSION_URL + "')");
    assertNotNull(ted);
    assertEquals("Extension.extension:function", ted.getElement().getId());
  }

  @Test
  public void subExtensionDefinedInlineIsResolvedByItsFixedUrl() throws Exception {
    StructureDefinition sd = complexExtension("http://example.org/StructureDefinition/test-inline", "function", null);
    TypedElementDefinition ted = evaluate(sd, "extension('function')");
    assertNotNull(ted);
    assertEquals("Extension.extension:function", ted.getElement().getId());
  }

  @Test
  public void valueOfAnInlineSubExtensionIsReachable() throws Exception {
    StructureDefinition sd = complexExtension("http://example.org/StructureDefinition/test-inline-value", "function", null);
    TypedElementDefinition ted = evaluate(sd, "extension('function').value");
    assertNotNull(ted);
    assertEquals("Extension.extension:function.value[x]", ted.getElement().getId());
  }

  @Test
  public void subExtensionWithNeitherFixedUrlNorProfileIsNotResolved() throws Exception {
    StructureDefinition sd = complexExtension("http://example.org/StructureDefinition/test-unidentified", null, null);
    assertNull(evaluate(sd, "extension('function')"));
  }

  /**
   * R5 5.1.0.13: a composite discriminator may designate elements that only some slices carry, so an
   * unresolved component contributes an empty value rather than failing.
   */
  @Test
  public void unknownExtensionUrlYieldsEmptyRatherThanThrowing() throws Exception {
    StructureDefinition sd = complexExtension("http://example.org/StructureDefinition/test-absent", "function", null);
    assertNull(evaluate(sd, "extension('absent').value"));
  }

  @Test
  public void unsupportedFunctionInADiscriminatorIsRejected() throws Exception {
    StructureDefinition sd = complexExtension("http://example.org/StructureDefinition/test-bad-fn", "function", null);
    assertThrows(PathEngineException.class, () -> evaluate(sd, "extension.where(url = 'function')"));
  }
}
