package org.hl7.fhir.utilities.i18n;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class JsonLangFileProducer extends LanguageFileProducer {

  public JsonLangFileProducer(String folder) {
    super(folder);
  }

  public JsonLangFileProducer() {
    super();
  }

  @Override
  public LanguageProducerSession startSession(String id, String baseLang) throws IOException {
    return new JsonLangProducerSession(id, baseLang);
  }

  @Override
  public void finish() {
    // nothing
  }

  public class JsonLangProducerSession extends LanguageProducerSession {

    JsonObject json = new JsonObject();
    
    public JsonLangProducerSession(String id, String baseLang) {
      super (id, baseLang);
      json.add("id", id);
      json.add("baseLang", baseLang);
    }

    @Override
    public LanguageProducerLanguageSession forLang(String targetLang) {
      return new JsonLangLanguageProducerLanguageSession(id, baseLang, targetLang, json);
    }

    @Override
    public void finish() throws IOException {
      FileOutputStream fs = new FileOutputStream(getFileName(id, baseLang));
      try {
        JsonParser.compose(json, fs);
      } finally {
        fs.close();
      }
    }
  }

  public class JsonLangLanguageProducerLanguageSession extends LanguageProducerLanguageSession {


    private JsonObject json;

    public JsonLangLanguageProducerLanguageSession(String id, String baseLang, String targetLang, JsonObject parent) {
      super(id, baseLang, targetLang);
      json = new JsonObject();
      parent.forceArray("languages").add(json);
      json.add("targetLang", targetLang);
    }


    @Override
    public void finish() throws IOException {
    }

    @Override
    public void entry(TextUnit unit) {
      JsonObject entry = new JsonObject();
      json.forceArray("entries").add(entry);
      entry.add("id", unit.getId());
      if (unit.getContext1() != null) {
        entry.add("context", unit.getContext1());
      }
      entry.add("source", unit.getSrcText());
      entry.add("target", unit.getTgtText());
    }

  }


  @Override
  public List<TranslationUnit> loadSource(InputStream source) throws IOException {
    List<TranslationUnit> list = new ArrayList<>();
    JsonObject json = JsonParser.parseObject(source);
    for (JsonObject lang : json.forceArray("languages").asJsonObjects()) {
      for (JsonObject entry : lang.forceArray("entries").asJsonObjects()) {
        list.add(new TranslationUnit(lang.asString("targetLang"), entry.asString("id"), entry.asString("context"), entry.asString("source"), entry.asString("target")));
      }
    }
    return list;
  }

  private String getFileName(String id, String baseLang) throws IOException {
    return Utilities.path(getFolder(), id+"-"+baseLang+".json");
  }

  @Override
  public int fileCount() {
    return 1;
  }


  @Override
  public void produce(String id, String baseLang, String targetLang, List<TranslationUnit> translations, String filename) throws IOException {

    JsonObject json = new JsonObject();
    json.add("id", id);
    json.add("baseLang", baseLang);
      
    JsonObject lj = new JsonObject();
    json.forceArray("languages").add(lj);
    lj.add("targetLang", targetLang);
      
    for (TranslationUnit tu : translations) {
      JsonObject entry = new JsonObject();
      lj.forceArray("entries").add(entry);
      entry.add("id", tu.getId());
      if (tu.getContext1() != null) { 
        entry.add("context", tu.getContext1());
      }
      entry.add("source", tu.getSrcText());
      entry.add("target", tu.getTgtText());
    }
    TextFile.stringToFile(JsonParser.compose(json, true), Utilities.path(getFolder(), filename));
  }

}
