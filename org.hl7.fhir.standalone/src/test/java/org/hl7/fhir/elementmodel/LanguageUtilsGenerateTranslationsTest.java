package org.hl7.fhir.elementmodel;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.services.elementmodel.LanguageUtils;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The translation units generated for a code system supplement: one per display, definition and designation,
 * without repeats, taking the target text from the first input with the same id, and then the orphans
 */
class LanguageUtilsGenerateTranslationsTest {

  private static String describe(List<TranslationUnit> units) {
    StringBuilder b = new StringBuilder();
    for (TranslationUnit tu : units) {
      b.append(tu.getId()).append('|').append(tu.getSrcText()).append('|').append(tu.getTgtText()).append('|').append(tu.getOriginal()).append('\n');
    }
    return b.toString();
  }

  @Test
  void codeSystemSupplement() {
    CodeSystem cs = new CodeSystem();
    ConceptDefinitionComponent a = cs.addConcept().setCode("a").setDisplay("A").setDefinition("Definition of A");
    a.addDesignation().setUse(new Coding("http://example.org/use", "syn", null)).setValue("Synonym of A");
    // the same designation again doesn't make a second unit
    a.addDesignation().setUse(new Coding("http://example.org/use", "syn", null)).setValue("Synonym of A");
    cs.addConcept().setCode("b").setDisplay("B");
    cs.addConcept().setCode("c").setDisplay("C");
    // a repeated code with the same display doesn't make a second unit either
    cs.addConcept().setCode("a").setDisplay("A");

    List<TranslationUnit> inputs = new ArrayList<>();
    inputs.add(new TranslationUnit("fr", "a", null, "A", "A en français"));
    // only the first input with an id is used
    inputs.add(new TranslationUnit("fr", "a", null, "A", "ignored"));
    // the source text has changed since this was translated
    inputs.add(new TranslationUnit("fr", "b", null, "Old B", "B en français"));
    inputs.add(new TranslationUnit("fr", null, null, "no id", "no id"));

    List<TranslationUnit> orphans = new ArrayList<>();
    orphans.add(new TranslationUnit("fr", "a", null, "A", "already there"));
    orphans.add(new TranslationUnit("fr", "gone", null, "Gone", "Disparu"));
    cs.setUserData(UserDataNames.LANGUTILS_ORPHAN, orphans);

    CodeSystem res = new CodeSystem();
    res.setUserData(UserDataNames.LANGUTILS_SOURCE_SUPPLEMENT, cs);
    res.setUserData(UserDataNames.LANGUTILS_SOURCE_TRANSLATIONS, inputs);

    List<TranslationUnit> units = new LanguageUtils(null).generateTranslations(res, "fr");

    Assertions.assertEquals(
      "a|A|A en français|null\n" +
      "a@definition|Definition of A|null|null\n" +
      "a@syn|Synonym of A|null|null\n" +
      "b|B|!!B en français|Old B\n" +
      "c|C|null|null\n" +
      "!!gone|Gone|Disparu|null\n",
      describe(units));
  }
}
