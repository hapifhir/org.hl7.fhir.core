package org.hl7.fhir.utilities.i18n.subtag;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LanguageSubtagRegistry {

  public static class Record {
    final Map<String, String> fields = new HashMap<>();
    final Map<String, List<String>> multiFields = new HashMap<>();

    public void addField(String field, String value) {
      if (isMultiField(field)) {
        List<String> list = multiFields.get(field);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(value);
        multiFields.put(field, list);
      } else {
        fields.put(field, value);
      }
    }
  }

  //Fields
  //[Type, Added, Description, Scope, Deprecated, Preferred-Value, Suppress-Script, Comments, Macrolanguage, Subtag, Prefix, Tag]

  public static final String TYPE = "Type";
  public static final String ADDED = "Added";
  public static final String DESCRIPTION = "Description";
  public static final String SCOPE = "Scope";
  public static final String DEPRECATED = "Deprecated";
  public static final String PREFERRED_VALUE = "Preferred-Value";
  public static final String SUPPRESS_SCRIPT = "Suppress-Script";
  public static final String COMMENTS = "Comments";
  public static final String MACROLANGUAGE = "Macrolanguage";
  public static final String SUBTAG = "Subtag";
  public static final String PREFIX = "Prefix";
  //public static final String TAG = "Tag";

  //Types
  // [grandfathered, variant, language, region, script, redundant, extlang]
  public static final String VARIANT = "variant";
  public static final String LANGUAGE = "language";
  public static final String REGION = "region";
  public static final String SCRIPT = "script";
  public static final String EXTLANG = "extlang";

  public static final String REDUNDANT = "redundant";

  public static final String GRANDFATHERED = "grandfathered";

  private final Map<String, LanguageSubtag> languages = new HashMap<>();

  public Set<String> getLanguageKeys() {
    return languages.keySet();
  }

  public boolean containsLanguage(String key) {
    return languages.containsKey(key);
  }
  public LanguageSubtag getLanguage(String key) {
    return languages.get(key);
  }

  private final Map<String, ExtLangSubtag> extLangs = new HashMap<>();

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

  public Set<String> getVariantKeys() {
    return variants.keySet();
  }

  public boolean containsVariant(String key) {
    return variants.containsKey(key);
  }
  public VariantSubtag getVariant(String key) {
    return variants.get(key);
  }

  public LanguageSubtagRegistry() throws IOException {
    this("lang.dat.txt");
  }

  public static boolean isMultiField(String field){
	  return DESCRIPTION.equals(field)
			  || COMMENTS.equals(field)
			  || PREFIX.equals(field);
  }

  protected LanguageSubtagRegistry(String resourceName) throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resourceUrl = classLoader.getResource(resourceName);
	  assert resourceUrl != null;
    Scanner scanner = new Scanner(resourceUrl.openStream());

    Record record = null;
    String currentField = null;
    String currentValue = null;
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line.equals("%%")) {
        if (record != null) {
          record.addField(currentField, currentValue);
        }
        record = processRecord(record);
        currentField = null;
        currentValue = null;
      } else {
        if (line.startsWith(" ")) {
          assert currentValue != null;
          currentValue = currentValue + " " + line.trim();
        } else {
          if (currentField != null && currentValue != null) {
            record.addField(currentField, currentValue);
          }
          String[] split = line.split(":\\s");
        if (split.length == 2) {
          currentField = split[0];

         currentValue = split[1];
        }
        }
      }
    }
    if (record != null) {
      record.addField(currentField, currentValue);
    }
    processRecord(record);
  }

  protected Record processRecord(Record record) {
    if (record == null) {
      return new Record();
    }
    String typeValue = record.fields.get(TYPE);

    assert record.fields.containsKey(ADDED);

    final Subtag subtag;
    switch (typeValue) {
      case LANGUAGE:  subtag = processLanguageRecord(record); break;
      case EXTLANG: subtag = processExtLangRecord(record); break;
      case SCRIPT: subtag = processScriptRecord(record); break;
      case REGION: subtag = processRegionRecord(record); break;
      case VARIANT: subtag = processVariantRecord(record); break;
      default: subtag = null;
    }

    assert subtag != null || typeValue.equals(GRANDFATHERED) || typeValue.equals(REDUNDANT);

    if (subtag != null) {
      addSubtag(subtag);
    }
    return new Record();
  }

  protected void addSubtag(Subtag subtag) {
    assert subtag.getSubtag() != null;
   if (subtag instanceof LanguageSubtag)
       languages.put(subtag.getSubtag(), (LanguageSubtag) subtag);
   else if (subtag instanceof  ExtLangSubtag)
     extLangs.put(subtag.getSubtag(), (ExtLangSubtag) subtag);
   else if (subtag instanceof ScriptSubtag)
      scripts.put(subtag.getSubtag(), (ScriptSubtag) subtag);
   else if (subtag instanceof RegionSubtag)
     regions.put(subtag.getSubtag(), (RegionSubtag) subtag);
   else if (subtag instanceof VariantSubtag)
     variants.put(subtag.getSubtag(), (VariantSubtag) subtag);
  }
  protected Subtag processVariantRecord(Record record) {
    assert record.fields.containsKey(SUBTAG);
    VariantSubtag variant = new VariantSubtag(record.fields.get(SUBTAG));
    addCommonFieldsToSubtag(variant, record);
    variant.setPreferredValue(record.fields.get(PREFERRED_VALUE));
    if (record.multiFields.containsKey(PREFIX))
      for (String prefix : record.multiFields.get(PREFIX)) {
        variant.addPrefix(prefix);
      }
    return variant;
  }

  protected Subtag processScriptRecord(Record record) {
    assert record.fields.containsKey(SUBTAG);
    ScriptSubtag script = new ScriptSubtag(record.fields.get(SUBTAG));
    addCommonFieldsToSubtag(script, record);
    return script;
  }


  protected Subtag processRegionRecord(Record record) {
    assert record.fields.containsKey(SUBTAG);
    RegionSubtag region = new RegionSubtag(record.fields.get(SUBTAG));
    addCommonFieldsToSubtag(region, record);
    region.setPreferredValue(record.fields.get(PREFERRED_VALUE));
    return region;
  }


  protected Subtag processExtLangRecord(Record record) {
    assert record.fields.containsKey(SUBTAG);
    ExtLangSubtag extLang = new ExtLangSubtag(record.fields.get(SUBTAG));
    addCommonFieldsToSubtag(extLang, record);
    extLang.setPreferredValue(record.fields.get(PREFERRED_VALUE));
    extLang.setMacrolanguage(record.fields.get(MACROLANGUAGE));
    if (record.multiFields.containsKey(PREFIX)) {
      assert record.multiFields.get(PREFIX).size() == 1;
      extLang.setPrefix(record.multiFields.get(PREFIX).get(0));
    }
    return extLang;
  }

  protected Subtag processLanguageRecord(Record record) {
    assert record.fields.containsKey(SUBTAG);
    LanguageSubtag language = new LanguageSubtag(record.fields.get(SUBTAG));
    addCommonFieldsToSubtag(language, record);
    language.setScope(record.fields.get(SCOPE));
    language.setPreferredValue(record.fields.get(PREFERRED_VALUE));
    language.setSuppressScript(record.fields.get(SUPPRESS_SCRIPT));
    language.setMacrolanguage(record.fields.get(MACROLANGUAGE));
    return language;
  }

  private void addCommonFieldsToSubtag(Subtag subtag, Record record) {
    if (record.multiFields.containsKey(DESCRIPTION))
    for (String description : record.multiFields.get(DESCRIPTION)) {
      subtag.addDescription(description);
    }
    if (record.multiFields.containsKey(COMMENTS))
    for (String comment : record.multiFields.get(COMMENTS)) {
      subtag.addComments(comment);
    }
    subtag.setAdded(record.fields.get(ADDED));
    subtag.setDeprecated(record.fields.get(DEPRECATED));
  }
}

