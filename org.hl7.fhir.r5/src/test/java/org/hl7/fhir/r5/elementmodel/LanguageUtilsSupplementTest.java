package org.hl7.fhir.r5.elementmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.junit.jupiter.api.Test;

/**
 * Translation supplements for StructureDefinitions: a CodeSystem that supplements a profile, in a
 * given language, with one concept per element (code = element id, display = translated definition,
 * and {@code id@comment} etc. for the other text properties). LanguageUtils.copyToLanguage applies
 * them, walking up the baseDefinition chain so that a derived profile picks up translations of the
 * text it inherits.
 */
class LanguageUtilsSupplementTest {

  private static final String BASE_URL = "http://example.org/fhir/StructureDefinition/upstream-bundle";
  private static final String DERIVED_URL = "http://example.org/fhir/StructureDefinition/national-bundle";

  private static final String UPSTREAM_DEFINITION = "A persistent identifier for the bundle.";
  private static final String UPSTREAM_COMMENT = "Persistent identity generally only matters for documents.";
  private static final String UPSTREAM_SHORT = "Persistent identifier for the bundle";

  /** id and path are the same for these unsliced elements. */
  private static ElementDefinition element(ElementDefinition ed, String id) {
    ed.setId(id);
    ed.setPath(id);
    return ed;
  }

  private StructureDefinition upstream() {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl(BASE_URL);
    sd.setName("UpstreamBundle");
    sd.setStatus(PublicationStatus.ACTIVE);
    sd.setType("Bundle");
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Bundle");
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    element(sd.getSnapshot().addElement(), "Bundle").setDefinition("A container.");
    element(sd.getSnapshot().addElement(), "Bundle.identifier")
        .setShort(UPSTREAM_SHORT).setDefinition(UPSTREAM_DEFINITION).setComment(UPSTREAM_COMMENT);
    return sd;
  }

  /** Derived profile: inherits the definition and comment, changes only the short. */
  private StructureDefinition derived() {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl(DERIVED_URL);
    sd.setName("NationalBundle");
    sd.setStatus(PublicationStatus.ACTIVE);
    sd.setType("Bundle");
    sd.setBaseDefinition(BASE_URL);
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    element(sd.getSnapshot().addElement(), "Bundle").setDefinition("A container.");
    element(sd.getSnapshot().addElement(), "Bundle.identifier")
        .setShort("Persistent identifier for the national bundle").setDefinition(UPSTREAM_DEFINITION).setComment(UPSTREAM_COMMENT);
    element(sd.getDifferential().addElement(), "Bundle.identifier")
        .setShort("Persistent identifier for the national bundle");
    return sd;
  }

  /** The supplement the IG publisher builds from a translation file for the upstream profile. */
  private CodeSystem supplementFor(String supplementedUrl, String lang) {
    CodeSystem cs = new CodeSystem();
    cs.setUrl(supplementedUrl.replace("StructureDefinition/", "CodeSystem/cs-" + lang + "-"));
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.SUPPLEMENT);
    cs.setSupplements(supplementedUrl);
    cs.setLanguage(lang);
    cs.addConcept().setCode("Bundle.identifier").setDisplay("Um identificador persistente do pacote.");
    cs.addConcept().setCode("Bundle.identifier@comment").setDisplay("A identidade persistente só importa para documentos.");
    return cs;
  }

  private SimpleWorkerContext context(StructureDefinition... sds) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    for (StructureDefinition sd : sds) {
      ctxt.cacheResource(sd);
    }
    return ctxt;
  }

  private ElementDefinition identifier(StructureDefinition sd) {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if ("Bundle.identifier".equals(ed.getId())) {
        return ed;
      }
    }
    throw new IllegalStateException("no Bundle.identifier");
  }

  @Test
  void inheritedTextIsTranslatedBySupplementForTheUpstreamProfile() throws Exception {
    SimpleWorkerContext ctxt = context(upstream(), derived());
    ctxt.cacheResource(supplementFor(BASE_URL, "pt"));

    StructureDefinition pt = (StructureDefinition) new LanguageUtils(ctxt)
        .copyToLanguage(ctxt.fetchResource(StructureDefinition.class, DERIVED_URL), "pt", true, "en", new ArrayList<>());

    ElementDefinition ed = identifier(pt);
    assertEquals("Um identificador persistente do pacote.", ed.getDefinition());
    assertEquals("A identidade persistente só importa para documentos.", ed.getComment());
    // the profile's own short is not in the upstream supplement, and stays as authored
    assertEquals("Persistent identifier for the national bundle", ed.getShort());
    assertEquals("pt", pt.getLanguage());
  }

  @Test
  void textChangedByTheProfileIsNotOverwrittenByTheUpstreamTranslation() throws Exception {
    StructureDefinition derived = derived();
    identifier(derived).setDefinition("A national identifier, assigned by the ministry.");
    SimpleWorkerContext ctxt = context(upstream(), derived);
    ctxt.cacheResource(supplementFor(BASE_URL, "pt"));

    StructureDefinition pt = (StructureDefinition) new LanguageUtils(ctxt)
        .copyToLanguage(ctxt.fetchResource(StructureDefinition.class, DERIVED_URL), "pt", true, "en", new ArrayList<>());

    ElementDefinition ed = identifier(pt);
    assertEquals("A national identifier, assigned by the ministry.", ed.getDefinition());
    // the comment is still the upstream text, so its translation still applies
    assertEquals("A identidade persistente só importa para documentos.", ed.getComment());
  }

  @Test
  void supplementInAnotherLanguageIsIgnored() throws Exception {
    SimpleWorkerContext ctxt = context(upstream(), derived());
    ctxt.cacheResource(supplementFor(BASE_URL, "es"));

    StructureDefinition pt = (StructureDefinition) new LanguageUtils(ctxt)
        .copyToLanguage(ctxt.fetchResource(StructureDefinition.class, DERIVED_URL), "pt", true, "en", new ArrayList<>());

    assertEquals(UPSTREAM_DEFINITION, identifier(pt).getDefinition());
    assertEquals(UPSTREAM_COMMENT, identifier(pt).getComment());
  }

  @Test
  void supplementForTheProfileItselfApplies() throws Exception {
    SimpleWorkerContext ctxt = context(upstream(), derived());
    ctxt.cacheResource(supplementFor(DERIVED_URL, "pt"));

    StructureDefinition pt = (StructureDefinition) new LanguageUtils(ctxt)
        .copyToLanguage(ctxt.fetchResource(StructureDefinition.class, DERIVED_URL), "pt", true, "en", new ArrayList<>());

    assertEquals("Um identificador persistente do pacote.", identifier(pt).getDefinition());
  }

  @Test
  void applyReturnsTheNumberOfReplacements() throws Exception {
    SimpleWorkerContext ctxt = context(upstream(), derived());
    ctxt.cacheResource(supplementFor(BASE_URL, "pt"));
    StructureDefinition copy = ctxt.fetchResource(StructureDefinition.class, DERIVED_URL).copy();

    // definition + comment, in the snapshot only (the differential carries only the short)
    assertEquals(2, new LanguageUtils(ctxt).applyTranslationSupplements(copy, "pt"));
    assertEquals(0, new LanguageUtils(ctxt).applyTranslationSupplements(copy, "fr"));
  }
}
