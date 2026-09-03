package org.hl7.fhir.elementmodel;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.utilities.formats.JsonCreatorDirect;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.utilities.formats.IParser;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.LanguageUtils;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestingUtilities;
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

    org.hl7.fhir.services.elementmodel.JsonParser jp = new org.hl7.fhir.services.elementmodel.JsonParser(context);
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
  
  /*
   * Translating to French with 'additional' div and no declared language and default language is English
   * Expected behavior: Keep the English and warn that the div couldn't be translated
   */
  @Test
  void convertCustomDivAdditional() throws Exception {
    checkDivConvert("Patient-div-additional", "ValidationMessage[level=WARNING,type=BUSINESSRULE,location=IG,message=\"The narrative includes custom content for the default language (en), but does not include translated content for the fr language, so the default language has been used]");
  }

  /*
   * Translating to French with 'additional' div and declared language of English
   * Expected behavior: Keep the English and warn that the div couldn't be translated
   */
  @Test
  void convertCustomDivEnglishAdditional() throws Exception {
    checkDivConvert("Patient-div-en-additional", "ValidationMessage[level=WARNING,type=BUSINESSRULE,location=IG,message=\"The narrative includes custom content for the default language (en), but does not include translated content for the fr language, so the default language has been used]");
  }

  /*
   * Translating to French with 'additional' div and included French language div
   * Expected behavior: Strip to just the French div, no warning
   */
  @Test
  void convertCustomFrenchAdditional() throws Exception {
    checkDivConvert("Patient-div-fr-additional");
  }

  /*
   * Translating to French with 'generated' div and no declared language
   * Expected behavior: Wipe the text so it will be re-generated downstream using narrative generator
   */
  @Test
  void convertCustomGenerated() throws Exception {
    checkDivConvert("Patient-div-generated");
  }

  /*
   * Translating to French with 'generated' div and French declared on the root
   * Expected behavior: Keep the existing generated French div
   */
  @Test
  void convertCustomFrenchGenerated() throws Exception {
    checkDivConvert("Patient-div-fr-generated");
  }

  private void checkDivConvert(String fName) throws Exception {
    checkDivConvert(fName, null);
  }
  private void checkDivConvert(String fName, String warning) throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    List<ValidationMessage> lvm = new ArrayList<>();
    LanguageUtils languageUtils = new LanguageUtils(context);

    InputStream resource = getResourceAsInputStream("languageUtils", fName + ".json");
    org.hl7.fhir.model.core.formats.JsonParser jp = new org.hl7.fhir.model.core.formats.JsonParser(TestingUtilities.getSharedWorkerContext());
    Resource origResource = jp.parse(resource);

    InputStream expectedJson = getResourceAsInputStream("languageUtils", fName + "-translated.json");
    String expectedText = new BufferedReader(new InputStreamReader(expectedJson))
      .lines()
      .collect(Collectors.joining("\n"));
    
    Resource newResource = origResource.copy(Base.COPY_DATA);
    Assertions.assertTrue(languageUtils.switchLanguage(newResource, "fr", true, false, "en", "en", lvm));

    if (warning==null)
      Assertions.assertTrue(lvm.isEmpty());
    else {
      Assertions.assertTrue(lvm.size()==1);
      if (!lvm.isEmpty())
        Assertions.assertEquals(lvm.get(0).toString(), warning);
    }
    
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    jp.setOutputStyle(OutputStyle.PRETTY).compose(bs, newResource);
    String actualText = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bs.toByteArray())))
        .lines()
        .collect(Collectors.joining("\n"));

    String msg = new CompareUtilities().checkJsonSrcIsSame("", actualText, expectedText);
    Assertions.assertNull(msg);    
  }
}