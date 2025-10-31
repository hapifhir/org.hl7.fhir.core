package org.hl7.fhir.utilities.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Locale;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RegionToLocaleMapperTest {
  @ParameterizedTest
  @CsvSource({
    "AR, es-AR",
    "ARG, es-AR",
    "AU, en-AU",
    "AUS, en-AU",
    "AT, de-AT",
    "AUT, de-AT",
    "BR, pt-BR",
    "BRA, pt-BR",
    "CL, es-CL",
    "CHL, es-CL",
    "CN, zh-CN",
    "CHN, zh-CN",
    "CO, es-CO",
    "COL, es-CO",
    "HR, hr-HR",
    "HRV, hr-HR",
    "CZ, cs-CZ",
    "CZE, cs-CZ",
    "DK, da-DK",
    "DNK, da-DK",
    "FI, fi-FI",
    "FIN, fi-FI",
    "FR, fr-FR",
    "FRA, fr-FR",
    "DE, de-DE",
    "DEU, de-DE",
    "GR, el-GR",
    "GRC, el-GR",
    "HK, zh-HK",
    "HKG, zh-HK",
    "IN, hi-IN",
    "IND, hi-IN",
    "IT, it-IT",
    "ITA, it-IT",
    "JP, ja-JP",
    "JPN, ja-JP",
    "KR, ko-KR",
    "KOR, ko-KR",
    "MX, es-MX",
    "MEX, es-MX",
    "NL, nl-NL",
    "NLD, nl-NL",
    "NZ, en-NZ",
    "NZL, en-NZ",
    "NO, no-NO",
    "NOR, no-NO",
    "PE, es-PE",
    "PER, es-PE",
    "PH, es-PH",
    "PHL, es-PH",
    "PL, pl-PL",
    "POL, pl-PL",
    "PT, pt-PT",
    "PRT, pt-PT",
    "RO, hu-RO",
    "ROU, hu-RO",
    "RU, ru-RU",
    "RUS, ru-RU",
    "SG, en-SG",
    "SGP, en-SG",
    "SK, sk-SK",
    "SVK, sk-SK",
    "SI, sl-SI",
    "SVN, sl-SI",
    "ES, es-ES",
    "ESP, es-ES",
    "SE, sv-SE",
    "SWE, sv-SE",
    "TW, zh-TW",
    "TWN, zh-TW",
    "AE, ar-AE",
    "ARE, ar-AE",
    "GB, en-GB",
    "GBR, en-GB",
    "UA, uk-UA",
    "UKR, uk-UA"
  })
  void testOurRegionsToLocales(String countryCode, String locale) {
    assertEquals(Locale.forLanguageTag(locale), RegionToLocaleMapper.getLocaleFromRegion(countryCode));
  }

  @Test
  void testUnmappedRegion() {
    // Sorry Tuvalu, you are a tiny, isolated nation.
    Assertions.assertNull(RegionToLocaleMapper.getLocaleFromRegion("TUV"));
  }

  @Test
  void testGarbageRegion() {
    Assertions.assertNull(RegionToLocaleMapper.getLocaleFromRegion("LIMARIA"));
  }
}
