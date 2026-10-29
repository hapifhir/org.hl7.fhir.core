package org.hl7.fhir.r5.elementmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.junit.jupiter.api.Test;

class LanguageUtilsTranslationOrderTest {

  @Test
  @SuppressWarnings("unchecked")
  void translationsOfOneTextComeInTheOrderTheyAreListed() throws Exception {
    List<TranslationUnit> units = new ArrayList<>();
    List<String> langs = new ArrayList<>();
    for (int i = 0; i < 40; i++) {
      // a translation unit hashes by identity, so with this many a hash order would hardly ever be the list's
      String lang = "l" + i;
      langs.add(lang);
      units.add(new TranslationUnit(lang, "CodeSystem.publisher", null, "Ministry", "Ministry " + lang));
      units.add(new TranslationUnit(lang, "CodeSystem.title", null, "Ministry", "other path " + lang));
    }
    Method m = LanguageUtils.class.getDeclaredMethod("findTranslations", String.class, String.class, List.class);
    m.setAccessible(true);
    Set<TranslationUnit> found = (Set<TranslationUnit>) m.invoke(new LanguageUtils(null), "CodeSystem.publisher", "Ministry", units);
    List<String> order = new ArrayList<>();
    for (TranslationUnit t : found) {
      order.add(t.getLanguage());
    }
    assertEquals(langs, order);
  }
}
