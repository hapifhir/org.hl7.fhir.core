package org.hl7.fhir.r5.elementmodel;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


class LanguageUtilsTest implements ResourceLoaderTests {

  @Test
  void importFromTranslations() throws Exception {

    IWorkerContext context = TestingUtilities.getSharedWorkerContext();

    org.hl7.fhir.r5.elementmodel.JsonParser jp = new org.hl7.fhir.r5.elementmodel.JsonParser(context);
    InputStream resource = getResourceAsInputStream("languageUtils", "CodeSystem-answer.json");
    Element element = jp.parseSingle(resource, null);

    PoGetTextProducer lp = new PoGetTextProducer();
    List<LanguageFileProducer.TranslationUnit> res = new ArrayList<>();
    res.addAll(lp.loadSource(getResourceAsInputStream("languageUtils", "CodeSystem-answer.po")));

    LanguageUtils languageUtils = new LanguageUtils(context);
    int result = languageUtils.importFromTranslations(element, res, null);

    assert result == 3;

  }

}