package org.hl7.fhir.utilities.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Infers an <a href="http://terminology.hl7.org/5.5.0/CodeSystem-v3-ietf3066.html">IETF BCP 47</a> locale from a <a href="http://terminology.hl7.org/5.5.0/CodeSystem-ISO3166Part1.html">ISO3166</a> country code.
 */
public class RegionToLocaleMapper {

  private RegionToLocaleMapper() {
    throw new IllegalStateException("Utility class");
  }

  static final Map<String, Locale> codeToLocale = new HashMap<>();
  static {
    addLocaleForRegions(new Locale("es", "AR"), "AR", "ARG");
    addLocaleForRegions(new Locale("en", "AU"), "AU", "AUS");
    addLocaleForRegions(new Locale("de", "AT"), "AT", "AUT");
    addLocaleForRegions(new Locale("pt", "BR"), "BR", "BRA");
    addLocaleForRegions(new Locale("es", "CL"), "CL", "CHL");
    addLocaleForRegions(new Locale("zh", "CN"), "CN", "CHN");
    addLocaleForRegions(new Locale("es", "CO"), "CO", "COL");
    addLocaleForRegions(new Locale("hr", "HR"), "HR", "HRV");
    addLocaleForRegions(new Locale("cs", "CZ"), "CZ", "CZE");
    addLocaleForRegions(new Locale("da", "DK"), "DK", "DNK");
    addLocaleForRegions(new Locale("fi", "FI"), "FI", "FIN");
    addLocaleForRegions(new Locale("fr", "FR"), "FR", "FRA");
    addLocaleForRegions(new Locale("de", "DE"), "DE", "DEU");
    addLocaleForRegions(new Locale("el", "GR"), "GR", "GRC");
    addLocaleForRegions(new Locale("zh", "HK"), "HK", "HKG");
    addLocaleForRegions(new Locale("hi", "IN"), "IN", "IND");
    addLocaleForRegions(new Locale("it", "IT"), "IT", "ITA");
    addLocaleForRegions(new Locale("ja", "JP"), "JP", "JPN");
    addLocaleForRegions(new Locale("ko", "KR"), "KR", "KOR");
    addLocaleForRegions(new Locale("es", "MX"), "MX", "MEX");
    addLocaleForRegions(new Locale("nl", "NL"), "NL", "NLD");
    addLocaleForRegions(new Locale("en", "NZ"), "NZ", "NZL");
    addLocaleForRegions(new Locale("no", "NO"), "NO", "NOR");
    addLocaleForRegions(new Locale("es", "PE"), "PE", "PER");
    addLocaleForRegions(new Locale("es", "PH"), "PH", "PHL");
    addLocaleForRegions(new Locale("pl", "PL"), "PL", "POL");
    addLocaleForRegions(new Locale("pt", "PT"), "PT", "PRT");
    addLocaleForRegions(new Locale("hu", "RO"), "RO", "ROU");
    addLocaleForRegions(new Locale("ru", "RU"), "RU", "RUS");
    addLocaleForRegions(new Locale("en", "SG"), "SG", "SGP");
    addLocaleForRegions(new Locale("sk", "SK"), "SK", "SVK");
    addLocaleForRegions(new Locale("sl", "SI"), "SI", "SVN");
    addLocaleForRegions(new Locale("es", "ES"), "ES", "ESP");
    addLocaleForRegions(new Locale("sv", "SE"), "SE", "SWE");
    addLocaleForRegions(new Locale("zh", "TW"), "TW", "TWN");
    addLocaleForRegions(new Locale("ar", "AE"), "AE", "ARE");
    addLocaleForRegions(new Locale("en", "GB"), "GB", "GBR");
    addLocaleForRegions(new Locale("uk", "UA"), "UA", "UKR");
  }

  private static void addLocaleForRegions(Locale locale, String... regions) {
    for (String region : regions) {
      codeToLocale.put(region, locale);
    }
  }
  public static Locale getLocaleFromRegion(String countryCode){
    return codeToLocale.get(countryCode);
  }

}
