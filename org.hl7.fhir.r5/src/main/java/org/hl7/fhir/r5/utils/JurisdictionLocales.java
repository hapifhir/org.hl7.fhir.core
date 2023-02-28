package org.hl7.fhir.r5.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * This clas smaps between the jurisdictions defined for CanonicalResource.jurisdiction
 * and Java Locale
 * @author graha
 *
 */

public class JurisdictionLocales {

  private Map<String, String> map = new HashMap<>();

  public JurisdictionLocales() {
    super();
    register();
  }

  private void register() {
    register("USA", "US", "en-US");
    register("AUS", "AU", "en-AU");
    register("NZL", "NZ", "en-NZ");
    register("GBR", "GB", "en-GB");
    register("IND", "IN", "en-IN");
    
    register("AUT", "AT", "de-AT");
    register("CHE", "CH", "de-CH");
    register("DEU", "DE", "de-DE");
    register("NOR", "NO", "no-NO");
    register("SWE", "SE", "sv-SE");
    register("FIN", "FI", "fi-FI");
    register("DNK", "DK", "da-DK");
    register("NLD", "NL", "nl-NL");
    register("BEL", "BE", "nl-BE"); // but will be fr-BE if lang is specified
    register("FRA", "FR", "fr-FR"); 
    register("ITA", "IT", "it-IT"); 
    register("RUS", "RU", "ru-RU"); 
    
    register("ESP", "ES", "es-ES"); 
    register("ARG", "AR", "es-AR"); 
    register("UGY", "UY", "es-UY"); 
    
    register("PRT", "PT", "pt-PT"); 
    register("BRA", "BR", "pt-BR"); 

    register("CHN", "CN", "zh-CN"); 
    register("TWN", "TW", "zh-TW"); 
    register("JPN", "JP", "ja-JP"); 
    register("KOR", "KR", "ko-KR"); 
    register("VNM", "VN", "vn-VN"); 
  }

  private void register(String code3, String code2, String locale) {
    map.put(code3,  locale);
    map.put(code2,  locale);
  }

  public String get(String c) {
    return map.get(c.toUpperCase());
  }
  
}
