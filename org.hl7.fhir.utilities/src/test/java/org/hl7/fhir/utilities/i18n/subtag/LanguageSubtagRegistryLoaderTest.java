package org.hl7.fhir.utilities.i18n.subtag;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LanguageSubtagRegistryLoaderTest {

  @Test
  public void defaultLoaderTest() throws IOException {
    /*
    languages.size(): 8259
    extLangs.size(): 253
    scripts.size(): 222
    regions.size(): 305
    variants.size(): 113
     */

    LanguageSubtagRegistry registry = new LanguageSubtagRegistry();
    LanguageSubtagRegistryLoader loader = new LanguageSubtagRegistryLoader(registry);
    loader.loadFromDefaultResource();

    /*  Test entries of every subtag type (language, script, variant, extLang, region)
        These should cover both simple, and more complex entries with a larger number
        of fields.
    */

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
    assertTrue(cpmn.getComments().isEmpty());
    assertNull(cpmn.getDeprecated());

    /*
      Type: script
      Subtag: Lisu
      Description: Lisu
      Description: Fraser
      Added: 2009-03-13
     */
    ScriptSubtag lisu = registry.getScript("Lisu");
    assertEquals(2, lisu.getDescriptions().size());
    assertEquals("Lisu", lisu.getDescriptions().get(0));
    assertEquals("Fraser", lisu.getDescriptions().get(1));
    assertEquals("2009-03-13", lisu.getAdded());

    /*
      Type: variant
      Subtag: tarask
      Description: Belarusian in Taraskievica orthography
      Added: 2007-04-27
      Prefix: be
      Comments: The subtag represents Branislau Taraskievic's Belarusian
        orthography as published in "Bielaruski klasycny pravapis" by Juras
        Buslakou, Vincuk Viacorka, Zmicier Sanko, and Zmicier Sauka (Vilnia-
        Miensk 2005).
     */

    final String taraskComment = "The subtag represents Branislau Taraskievic's Belarusian orthography as published in \"Bielaruski klasycny pravapis\" by Juras Buslakou, Vincuk Viacorka, Zmicier Sanko, and Zmicier Sauka (Vilnia- Miensk 2005).";

    VariantSubtag tarask = registry.getVariant("tarask");
    assertEquals(1, tarask.getDescriptions().size());
    assertEquals("Belarusian in Taraskievica orthography", tarask.getDescriptions().get(0));
    assertEquals(1, tarask.getPrefixes().size());
    assertEquals("be", tarask.getPrefixes().get(0));
    assertEquals("2007-04-27", tarask.getAdded());
    assertEquals(taraskComment, tarask.getComments().get(0));

    /*
      Type: variant
      Subtag: ao1990
      Description: Portuguese Language Orthographic Agreement of 1990 (Acordo
        Ortográfico da Língua Portuguesa de 1990)
      Added: 2015-05-06
      Prefix: pt
      Prefix: gl
      Comments: Portuguese orthography conventions established in 1990 but
        not brought into effect until 2009
    */

    VariantSubtag ao1990 = registry.getVariant("ao1990");
    assertEquals(1, ao1990.getDescriptions().size());
    assertEquals("Portuguese Language Orthographic Agreement of 1990 (Acordo Ortográfico da Língua Portuguesa de 1990)", ao1990.getDescriptions().get(0));
    assertEquals(2, ao1990.getPrefixes().size());
    assertEquals("pt", ao1990.getPrefixes().get(0));
    assertEquals("gl", ao1990.getPrefixes().get(1));
    assertEquals(1, ao1990.getComments().size());
    assertEquals("Portuguese orthography conventions established in 1990 but not brought into effect until 2009", ao1990.getComments().get(0));

    /*
      Type: extlang
      Subtag: arq
      Description: Algerian Arabic
      Added: 2009-07-29
      Preferred-Value: arq
      Prefix: ar
      Macrolanguage: ar
   */

    ExtLangSubtag arq = registry.getExtLang("arq");
    assertEquals(1, arq.getDescriptions().size());
    assertEquals("Algerian Arabic", arq.getDescriptions().get(0));
    assertEquals("2009-07-29", arq.getAdded());
    assertEquals("arq", arq.getPreferredValue());
    assertEquals("ar", arq.getPrefix());
    assertEquals("ar", arq.getMacrolanguage());

    /*
      Type: extlang
      Subtag: kvk
      Description: Korean Sign Language
      Added: 2009-07-29
      Preferred-Value: kvk
      Prefix: sgn
     */

    ExtLangSubtag kvk = registry.getExtLang("kvk");
    assertEquals(1, kvk.getDescriptions().size());
    assertEquals("Korean Sign Language", kvk.getDescriptions().get(0));
    assertEquals("2009-07-29", kvk.getAdded());
    assertEquals("kvk", kvk.getPreferredValue());
    assertEquals("sgn", kvk.getPrefix());


  /*
    Type: region
    Subtag: YD
    Description: Democratic Yemen
    Added: 2005-10-16
    Deprecated: 1990-08-14
    Preferred-Value: YE
   */

    RegionSubtag yd = registry.getRegion("YD");
    assertEquals(1, yd.getDescriptions().size());
    assertEquals("Democratic Yemen", yd.getDescriptions().get(0));
    assertEquals("2005-10-16", yd.getAdded());
    assertEquals("1990-08-14", yd.getDeprecated());
    assertEquals("YE", yd.getPreferredValue());

    /*
      Type: region
      Subtag: HN
      Description: Honduras
      Added: 2005-10-16
     */

    RegionSubtag hn = registry.getRegion("HN");
    assertEquals(1, hn.getDescriptions().size());
    assertEquals("Honduras", hn.getDescriptions().get(0));
    assertEquals("2005-10-16", hn.getAdded());
  }

  @Test
  public void testNoLanguagesLoading() throws IOException {
    LanguageSubtagRegistry registry = new LanguageSubtagRegistry();
    LanguageSubtagRegistryLoader loader = new LanguageSubtagRegistryLoader(registry).withLoadLanguages(false);

    loader.loadFromDefaultResource();

    assertTrue(registry.getLanguageKeys().isEmpty());
    assertFalse(registry.getExtLangKeys().isEmpty());
    assertFalse(registry.getRegionKeys().isEmpty());
    assertFalse(registry.getVariantKeys().isEmpty());
    assertFalse(registry.getScriptKeys().isEmpty());
  }

  @Test
  public void testNoExtLangsLoading() {
    assertDoesNotThrow(() -> {
      LanguageSubtagRegistry registry = new LanguageSubtagRegistry();
      LanguageSubtagRegistryLoader loader = new LanguageSubtagRegistryLoader(new LanguageSubtagRegistry()).withLoadExtLangs(false);
    });
  }

  private static Stream<Arguments> provideParamsForPartialLoad() {
    return Stream.of(
      Arguments.of(new LanguageSubtagRegistryLoader(new LanguageSubtagRegistry()).withLoadLanguages(false), true, false, false, false, false),
      Arguments.of(new LanguageSubtagRegistryLoader(new LanguageSubtagRegistry()).withLoadExtLangs(false), false, true, false, false, false),
      Arguments.of(new LanguageSubtagRegistryLoader(new LanguageSubtagRegistry()).withLoadRegions(false), false, false, true, false, false),
      Arguments.of(new LanguageSubtagRegistryLoader(new LanguageSubtagRegistry()).withLoadVariants(false), false, false, false, true, false),
      Arguments.of(new LanguageSubtagRegistryLoader(new LanguageSubtagRegistry()).withLoadScripts(false), false, false, false, false, true)
    );
  }

  @ParameterizedTest
  @MethodSource("provideParamsForPartialLoad")
  public void testPartialLoad(LanguageSubtagRegistryLoader loader,
                                  boolean languagesEmpty,
                                  boolean extLangsEmpty,
                                  boolean regionsEmpty,
                                  boolean variantsEmpty,
                                  boolean scriptsEmpty) throws IOException {
    loader.loadFromDefaultResource();

    assertEquals(languagesEmpty, loader.getRegistry().getLanguageKeys().isEmpty());
    assertEquals(extLangsEmpty, loader.getRegistry().getExtLangKeys().isEmpty());
    assertEquals(regionsEmpty, loader.getRegistry().getRegionKeys().isEmpty());
    assertEquals(variantsEmpty, loader.getRegistry().getVariantKeys().isEmpty());
    assertEquals(scriptsEmpty, loader.getRegistry().getScriptKeys().isEmpty());
  }
}
