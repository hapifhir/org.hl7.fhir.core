package org.hl7.fhir.utilities.i18n.subtag;

import lombok.Getter;
import lombok.With;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class LanguageSubtagRegistryLoader {

  @Getter
  private final LanguageSubtagRegistry registry;

  @With
  private final boolean loadLanguages;

  @With
  private final boolean loadScripts;

  @With
  private final boolean loadExtLangs;

  @With
  private final boolean loadRegions;

  @With
  private final boolean loadVariants;

  public static boolean isMultiField(String field){
    return DESCRIPTION.equals(field)
      || COMMENTS.equals(field)
      || PREFIX.equals(field);
  }
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


  public LanguageSubtagRegistryLoader(LanguageSubtagRegistry registry) {
   this(registry, true, true, true, true, true);
  }

  private LanguageSubtagRegistryLoader(LanguageSubtagRegistry registry, boolean loadLanguages, boolean loadScripts, boolean loadExtLangs, boolean loadRegions, boolean loadVariants) {
    this.registry = registry;
    this.loadLanguages = loadLanguages;
    this.loadScripts = loadScripts;
    this.loadExtLangs = loadExtLangs;
    this.loadRegions = loadRegions;
    this.loadVariants = loadVariants;
  }
  public void loadFromDefaultResource() throws IOException {
    loadFromResource("lang.dat.txt");
  }
  public void loadFromResource(String resourceName) throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resourceUrl = classLoader.getResource(resourceName);
    assert resourceUrl != null;
    load(resourceUrl.openStream());
  }
  private void load(InputStream inputStream) throws IOException {

    Scanner scanner = new Scanner(inputStream);

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
    if (subtag instanceof LanguageSubtag && loadLanguages)
      registry.addLanguage(subtag.getSubtag(), (LanguageSubtag) subtag);
    else if (subtag instanceof  ExtLangSubtag && loadExtLangs )
     registry.addExtLang(subtag.getSubtag(), (ExtLangSubtag) subtag);
    else if (subtag instanceof ScriptSubtag && loadScripts)
      registry.addScript(subtag.getSubtag(), (ScriptSubtag) subtag);
    else if (subtag instanceof RegionSubtag && loadRegions)
      registry.addRegion(subtag.getSubtag(), (RegionSubtag) subtag);
    else if (subtag instanceof VariantSubtag && loadVariants)
      registry.addVariant(subtag.getSubtag(), (VariantSubtag) subtag);
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
