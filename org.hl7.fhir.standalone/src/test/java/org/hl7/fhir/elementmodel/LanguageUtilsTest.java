package org.hl7.fhir.elementmodel;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.utilities.formats.JsonCreatorDirect;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.utilities.formats.IParser;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.Composition;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.LanguageUtils;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

  /*
   * A document whose narratives are all in de-CH, switched to the default language (en)
   * (see https://github.com/HL7/fhir-ig-publisher/issues/1487)
   * Expected behavior: the generated resource narrative is dropped so it gets regenerated, but the
   * section narrative can't be regenerated, so it is kept as it is
   */
  private static final String DOCUMENT_DE_CH = """
    {
      "resourceType" : "Bundle",
      "id" : "doc",
      "language" : "de-CH",
      "type" : "document",
      "entry" : [{
        "fullUrl" : "http://example.org/Composition/comp",
        "resource" : {
          "resourceType" : "Composition",
          "id" : "comp",
          "language" : "de-CH",
          "text" : {
            "status" : "generated",
            "div" : "<div xmlns='http://www.w3.org/1999/xhtml' xml:lang='de-CH' lang='de-CH'><p>Notfallpass</p></div>"
          },
          "status" : "final",
          "title" : "Notfallpass",
          "section" : [{
            "title" : "Implantate",
            "text" : {
              "status" : "generated",
              "div" : "<div xmlns='http://www.w3.org/1999/xhtml'><p>Herzschrittmacher</p></div>"
            }
          }]
        }
      }]
    }
    """;

  @Test
  void keepSectionNarrativeElement() throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    List<ValidationMessage> lvm = new ArrayList<>();
    LanguageUtils languageUtils = new LanguageUtils(context);

    org.hl7.fhir.services.elementmodel.JsonParser jp = new org.hl7.fhir.services.elementmodel.JsonParser(context);
    Element bundle = jp.parseSingle(new ByteArrayInputStream(DOCUMENT_DE_CH.getBytes(StandardCharsets.UTF_8)), null);
    Element en = languageUtils.copyToLanguage(bundle, "en", true, "de-CH", "en", lvm);

    Element comp = en.getNamedChild("entry").getNamedChild("resource");
    Assertions.assertFalse(comp.getNamedChild("text").hasChild("div"), "the resource narrative should be dropped so it is regenerated");
    Element sectionText = comp.getNamedChild("section").getNamedChild("text");
    Assertions.assertTrue(sectionText.hasChild("div"), "the section narrative should be kept");
    Assertions.assertTrue(new XhtmlComposer(true).compose(sectionText.getNamedChild("div").getXhtml()).contains("Herzschrittmacher"));

    // the source is not changed
    Assertions.assertTrue(bundle.getNamedChild("entry").getNamedChild("resource").getNamedChild("text").hasChild("div"));
  }

  @Test
  void keepSectionNarrativeResource() throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    List<ValidationMessage> lvm = new ArrayList<>();
    LanguageUtils languageUtils = new LanguageUtils(context);

    org.hl7.fhir.model.core.formats.JsonParser jp = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext());
    Resource bundle = jp.parse(DOCUMENT_DE_CH);
    Bundle en = (Bundle) languageUtils.copyToLanguage(bundle, "en", true, "en", lvm);

    Composition comp = (Composition) en.getEntryFirstRep().getResource();
    Assertions.assertFalse(comp.hasText() && comp.getText().hasDiv(), "the resource narrative should be dropped so it is regenerated");
    Composition.SectionComponent section = comp.getSectionFirstRep();
    Assertions.assertTrue(section.hasText() && section.getText().hasDiv(), "the section narrative should be kept");
    Assertions.assertTrue(new XhtmlComposer(true).compose(section.getText().getDiv()).contains("Herzschrittmacher"));
  }

  private void checkDivConvert(String fName) throws Exception {
    checkDivConvert(fName, null);
  }
  private void checkDivConvert(String fName, String warning) throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    List<ValidationMessage> lvm = new ArrayList<>();
    LanguageUtils languageUtils = new LanguageUtils(context);

    InputStream resource = getResourceAsInputStream("languageUtils", fName + ".json");
    org.hl7.fhir.model.core.formats.JsonParser jp = new org.hl7.fhir.model.core.formats.JsonParser(TestingUtilities.getSharedWorkerContext().getModelContext());
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