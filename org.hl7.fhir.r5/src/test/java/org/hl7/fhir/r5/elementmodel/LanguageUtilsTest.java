package org.hl7.fhir.r5.elementmodel;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.JsonCreatorDirect;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    List<ValidationMessage> lvm = new ArrayList<>();
    lvm.add(new ValidationMessage());
    LanguageUtils languageUtils = new LanguageUtils(context);
    int result = languageUtils.importFromTranslations(element, res, lvm);

    Writer generatedResource = new StringWriter();
    jp.compose(element, new JsonCreatorDirect(generatedResource, true, false));

    Assertions.assertEquals(3, result);

    InputStream translatedResource = getResourceAsInputStream("languageUtils", "CodeSystem-answer-translated.json");
    String text = new BufferedReader(new InputStreamReader(translatedResource))
      .lines()
      .collect(Collectors.joining("\n"));

    String msg = new CompareUtilities().checkJsonSrcIsSame("", generatedResource.toString(),text);
    Assertions.assertNull(msg);

  }

}