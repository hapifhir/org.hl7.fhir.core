package org.hl7.fhir.utilities.i18n.subtag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LanguageSubtagRegistry {


  private final Map<String, LanguageSubtag> languages = new HashMap<>();

  public Set<String> getLanguageKeys() {
    return languages.keySet();
  }

  protected LanguageSubtag addLanguage(String key, LanguageSubtag language) {
    return languages.put(key, language);
  }

  public boolean containsLanguage(String key) {
    return languages.containsKey(key);
  }
  public LanguageSubtag getLanguage(String key) {
    return languages.get(key);
  }

  private final Map<String, ExtLangSubtag> extLangs = new HashMap<>();

  protected ExtLangSubtag addExtLang(String key, ExtLangSubtag extLang) {
    return extLangs.put(key, extLang);
  }

  public Set<String> getExtLangKeys() {
    return extLangs.keySet();
  }

  public boolean containsExtLang(String key) {
    return extLangs.containsKey(key);
  }
  public ExtLangSubtag getExtLang(String key) {
    return extLangs.get(key);
  }

  private final Map<String, ScriptSubtag> scripts = new HashMap<>();

  protected ScriptSubtag addScript(String key, ScriptSubtag script) {
    return scripts.put(key, script);
  }

  public Set<String> getScriptKeys() {
    return scripts.keySet();
  }
  public boolean containsScript(String key) {
    return scripts.containsKey(key);
  }
  public ScriptSubtag getScript(String key) {
    return scripts.get(key);
  }

  private final Map<String, RegionSubtag> regions = new HashMap<>();

  protected RegionSubtag addRegion(String key, RegionSubtag region) {
    return regions.put(key, region);
  }

  public Set<String> getRegionKeys() {
    return regions.keySet();
  }

  public boolean containsRegion(String key) {
    return regions.containsKey(key);
  }
  public RegionSubtag getRegion(String key) {
    return regions.get(key);
  }

  private final Map<String, VariantSubtag> variants = new HashMap<>();

  protected VariantSubtag addVariant(String key, VariantSubtag variant) {
    return variants.put(key, variant);
  }

  public Set<String> getVariantKeys() {
    return variants.keySet();
  }

  public boolean containsVariant(String key) {
    return variants.containsKey(key);
  }
  
  public VariantSubtag getVariant(String key) {
    return variants.get(key);
  }

  public boolean hasLanguage(String subTag) {
    return languages.containsKey(subTag);
  }

  public boolean hasExtLanguage(String subTag) {
    return extLangs.containsKey(subTag);
  }

  public boolean hasScript(String subTag) {
    return scripts.containsKey(subTag);
  }

  public boolean hasRegion(String subTag) {
    return regions.containsKey(subTag);
  }

  public boolean hasVariant(String subTag) {
    return variants.containsKey(subTag);
  }
}

