package org.hl7.fhir.utilities.i18n.subtag;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageSubtagRegistryTest {

  @Test
  public void initializationTest() throws IOException {
    /*
    languages.size(): 8259
    extLangs.size(): 253
    scripts.size(): 222
    regions.size(): 305
    variants.size(): 113
     */

    LanguageSubtagRegistry registry = new LanguageSubtagRegistry();

    // pick some random entries.

    /*
      Type: language
      Subtag: ppa
      Description: Pao
      Added: 2009-07-29
      Deprecated: 2016-05-30
      Preferred-Value: bfy
     */
    LanguageSubtag ppa = registry.getLanguage("ppa");
    assertEquals("Pao", ppa.getDescriptions().get(0));
    assertEquals("2009-07-29", ppa.getAdded());
    assertEquals("2016-05-30", ppa.getDeprecated());
    assertEquals("bfy", ppa.getPreferredValue());
    assertNull(ppa.getScope());
    assertNull(ppa.getSuppressScript());
    assertNull(ppa.getMacrolanguage());

    /*
      Type: language
      Subtag: ia
      Description: Interlingua (International Auxiliary Language
        Association)
      Added: 2005-10-16
     */

    LanguageSubtag ia = registry.getLanguage("ia");
    assertEquals("Interlingua (International Auxiliary Language Association)", ia.getDescriptions().get(0));

    /*
      Type: script
      Subtag: Cpmn
      Description: Cypro-Minoan
      Added: 2017-08-13
     */
    ScriptSubtag cpmn = registry.getScript("Cpmn");
    assertEquals("Cypro-Minoan", cpmn.getDescriptions().get(0));
    assertEquals("2017-08-13", cpmn.getAdded());
    //assertNull(cpmn.getComments());
    assertNull(cpmn.getDeprecated());


  }
}
