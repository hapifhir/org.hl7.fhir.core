package org.hl7.fhir.r5.elementmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Switching a resource to a language its narrative has no content for. A resource narrative that was generated
 * (generated, extensions) is dropped, to be regenerated in the language. One that was written (additional, empty, no
 * status) is kept as it is, in its own language, with a warning - regenerating it would lose what was written. A
 * narrative that isn't a resource's own (Composition.section.text) can't be regenerated, so it's always kept, with a
 * warning
 */
class LanguageUtilsNarrativeKeptTests {

  private static String document(String status) {
    String st = status.isEmpty() ? "" : "\"status\" : \"" + status + "\", ";
    return """
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
            "text" : { STATUS"div" : "<div xmlns='http://www.w3.org/1999/xhtml'><p>Notfallpass</p></div>" },
            "status" : "final",
            "title" : "Notfallpass",
            "section" : [{
              "title" : "Implantate",
              "text" : { "status" : "generated", "div" : "<div xmlns='http://www.w3.org/1999/xhtml'><p>Herzschrittmacher</p></div>" }
            }]
          }
        }]
      }
      """.replace("STATUS", st);
  }

  @ParameterizedTest(name = "{0}, element model {2}")
  @CsvSource({
    "generated,  false, true",
    "extensions, false, true",
    "additional, true,  true",
    "empty,      true,  true",
    "'',         true,  true",
    "generated,  false, false",
    "extensions, false, false",
    "additional, true,  false",
    "empty,      true,  false",
  })
  void narrativeWithNothingForTheLanguage(String status, boolean kept, boolean elementModel) throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    LanguageUtils lu = new LanguageUtils(context);
    List<ValidationMessage> errors = new ArrayList<>();
    String json = document(status);

    XhtmlNode resourceDiv;
    XhtmlNode sectionDiv;
    if (elementModel) {
      Element bundle = new org.hl7.fhir.r5.elementmodel.JsonParser(context).parseSingle(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), null);
      Element comp = lu.copyToLanguage(bundle, "en", true, "de-CH", "en", errors).getNamedChild("entry").getNamedChild("resource");
      Element text = comp.getNamedChild("text");
      resourceDiv = text.hasChild("div") ? text.getNamedChild("div").getXhtml() : null;
      sectionDiv = comp.getNamedChild("section").getNamedChild("text").getNamedChild("div").getXhtml();
    } else {
      Resource bundle = new org.hl7.fhir.r5.formats.JsonParser().parse(json);
      Composition comp = (Composition) ((Bundle) lu.copyToLanguage(bundle, "en", true, "en", errors)).getEntryFirstRep().getResource();
      resourceDiv = comp.hasText() && comp.getText().hasDiv() ? comp.getText().getDiv() : null;
      sectionDiv = comp.getSectionFirstRep().getText().getDiv();
    }

    assertEquals(kept, resourceDiv != null, "resource narrative kept");
    if (kept) {
      assertTrue(new XhtmlComposer(true).compose(resourceDiv).contains("Notfallpass"));
      assertTrue(hasMessage(errors, context.formatMessage(I18nConstants.NARRATIVE_NOT_TRANSLATED_KEPT_AUTHORED, "en", status)), errors.toString());
    }
    assertTrue(new XhtmlComposer(true).compose(sectionDiv).contains("Herzschrittmacher"));
    assertTrue(hasMessage(errors, context.formatMessage(I18nConstants.NARRATIVE_NOT_TRANSLATED_KEPT_SECTION, "en")), errors.toString());
    assertEquals(kept ? 2 : 1, errors.size(), errors.toString());
  }

  private static boolean hasMessage(List<ValidationMessage> errors, String message) {
    for (ValidationMessage vm : errors) {
      if (message.equals(vm.getMessage())) {
        return true;
      }
    }
    return false;
  }
}
