package org.hl7.fhir.elementmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.LanguageUtils;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.junit.jupiter.api.Test;

/**
 * Pins down what LanguageUtils.generateTranslations produces - which units, in what order, and how
 * duplicates, existing translations and orphans are handled - so that changes to how it is
 * implemented can be checked against it.
 */
class LanguageUtilsTranslationUnitsTest {

  private static String describe(TranslationUnit tu) {
    return tu.getId() + "|" + tu.getSrcText() + "|" + tu.getTgtText() + (tu.getOriginal() == null ? "" : "|was:" + tu.getOriginal());
  }

  private static List<String> describe(List<TranslationUnit> list) {
    return list.stream().map(LanguageUtilsTranslationUnitsTest::describe).collect(Collectors.toList());
  }

  @Test
  void structureDefinition() {
    StructureDefinition sd = new StructureDefinition();
    sd.setName("TestProfile");
    sd.setTitle("Test Profile");
    ElementDefinition ed = sd.getDifferential().addElement();
    ed.setId("Observation.code");
    ed.setPath("Observation.code");
    ed.setShort("The code");
    // two constraints with the same text under the same id: one unit
    ed.addConstraint().setKey("c-1").setHuman("Must be coded");
    ed.addConstraint().setKey("c-2").setHuman("Must be coded");
    // a different text under that id: a second unit
    ed.addConstraint().setKey("c-3").setHuman("Must have a system");

    List<TranslationUnit> orphans = new ArrayList<>();
    // the same id and text as a unit already generated: not added again
    orphans.add(new TranslationUnit("fr", "StructureDefinition.title", null, "Test Profile", "Profil de test"));
    // not generated any more: added, marked with !!
    orphans.add(new TranslationUnit("fr", "StructureDefinition.description", null, "Old description", "Ancienne description"));
    // an orphan with no id never matches a generated unit
    orphans.add(new TranslationUnit("fr", null, null, "No id", "Pas d'id"));
    sd.setUserData(UserDataNames.LANGUTILS_ORPHAN, orphans);

    List<TranslationUnit> list = new LanguageUtils(null).generateTranslations(sd, "fr");

    assertEquals(List.of(
        // with no translation, the target text is the source text
        "StructureDefinition.name|TestProfile|TestProfile",
        "StructureDefinition.title|Test Profile|Test Profile",
        "StructureDefinition.element.Observation.code/short|The code|The code",
        "StructureDefinition.element.Observation.code/constraint|Must be coded|Must be coded",
        "StructureDefinition.element.Observation.code/constraint|Must have a system|Must have a system",
        "!!StructureDefinition.description|Old description|Ancienne description",
        "!!null|No id|Pas d'id"
      ), describe(list));
    for (TranslationUnit tu : list) {
      assertEquals("fr", tu.getLanguage());
    }
  }

  @Test
  void codeSystemSupplement() {
    CodeSystem cs = new CodeSystem();
    cs.addConcept().setCode("a").setDisplay("Alpha").setDefinition("The first");
    cs.addConcept().setCode("b").setDisplay("Beta");
    cs.addConcept().setCode("c").setDisplay("Gamma");
    ConceptDefinitionComponent d = cs.addConcept().setCode("d").setDisplay("Delta");
    d.addDesignation().setValue("D").getUse().setCode("synonym");
    d.addExtension("http://example.org/StructureDefinition/note", new StringType("A note"));
    // the same code and display again: no new unit
    cs.addConcept().setCode("a").setDisplay("Alpha");
    // the same code with a different display: a new unit
    cs.addConcept().setCode("a").setDisplay("Alpha prime");

    List<TranslationUnit> orphans = new ArrayList<>();
    orphans.add(new TranslationUnit("fr", "a", null, "Alpha", "Alpha (orphan)"));
    orphans.add(new TranslationUnit("fr", "z", null, "Zeta", "Zêta"));
    cs.setUserData(UserDataNames.LANGUTILS_ORPHAN, orphans);

    List<TranslationUnit> inputs = new ArrayList<>();
    // two inputs for a: the first one is used
    inputs.add(new TranslationUnit("fr", "a", null, "Alpha", "Alpha-fr"));
    inputs.add(new TranslationUnit("fr", "a", null, "Alpha", "Alpha-fr-2"));
    // the source text has changed since b was translated
    inputs.add(new TranslationUnit("fr", "b", null, "Old Beta", "Bêta"));
    inputs.add(new TranslationUnit("fr", "a@definition", null, "The first", "Le premier"));
    inputs.add(new TranslationUnit("fr", "d@synonym", null, "D", "D-fr"));

    CodeSystem supplement = new CodeSystem();
    supplement.setUserData(UserDataNames.LANGUTILS_SOURCE_SUPPLEMENT, cs);
    supplement.setUserData(UserDataNames.LANGUTILS_SOURCE_TRANSLATIONS, inputs);

    List<TranslationUnit> list = new LanguageUtils(null).generateTranslations(supplement, "fr");

    assertEquals(List.of(
        "a|Alpha|Alpha-fr",
        "a@definition|The first|Le premier",
        "b|Beta|!!Bêta|was:Old Beta",
        "c|Gamma|null",
        "d|Delta|null",
        "d@synonym|D|D-fr",
        "d@note|A note|null",
        "a|Alpha prime|!!Alpha-fr|was:Alpha",
        "!!z|Zeta|Zêta"
      ), describe(list));
  }

  @Test
  void element() throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    String json = "{\"resourceType\":\"CodeSystem\",\"status\":\"draft\",\"content\":\"complete\",\"concept\":["
        + "{\"code\":\"a\",\"display\":\"Same\",\"definition\":\"Same\"},"
        + "{\"code\":\"b\",\"display\":\"Other\"},"
        + "{\"code\":\"c\",\"display\":\"Same\"},"
        + "{\"code\":\"d\",\"display\":\"Other\",\"definition\":\"Different\"}]}";
    Element e = new org.hl7.fhir.services.elementmodel.JsonParser(context).parseSingle(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), null);

    List<TranslationUnit> list = new LanguageUtils(context).generateTranslations(e, "fr");

    // each id and source text appears once, in the order first seen
    List<String> units = list.stream().map(tu -> tu.getId() + "|" + tu.getSrcText()).collect(Collectors.toList());
    Set<String> unique = new HashSet<>(units);
    assertEquals(unique.size(), units.size(), units.toString());
    assertEquals(List.of("CodeSystem.concept.display|Same", "CodeSystem.concept.definition|Same", "CodeSystem.concept.display|Other", "CodeSystem.concept.definition|Different"),
        units.stream().filter(s -> s.startsWith("CodeSystem.concept.")).collect(Collectors.toList()));
  }
}
