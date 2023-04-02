package org.hl7.fhir.utilities.i18n;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TextUnit;

import java.util.HashMap;


public abstract class LanguageFileProducer {

  public static class TextUnit {
    private String context;
    private String srcText;
    private String tgtText;
    public TextUnit(String context, String srcText, String tgtText) {
      super();
      this.context = context;
      this.srcText = srcText;
      this.tgtText = tgtText;
    }

    public String getContext() {
      return context;
    }

    public String getSrcText() {
      return srcText;
    }
    public String getTgtText() {
      return tgtText;
    }
    
  }

  public class Translations {
    private String id;
    private Map<String, String> translations = new HashMap<>();
    protected Translations(String id) {
      super();
      this.id = id;
    }
    public String getId() {
      return id;
    }
    public Map<String, String> getTranslations() {
      return translations;
    }
    
  }

  public abstract class LanguageProducerLanguageSession {

    protected String id;
    protected String baseLang;
    protected String targetLang;
    
    protected LanguageProducerLanguageSession(String id, String baseLang, String targetLang) {
      super();
      this.id = id;
      this.baseLang = baseLang;
      this.targetLang = targetLang;
    }

    public String getTargetLang() {
      return targetLang;
    }

    public String getBaseLang() {
      return baseLang;
    }

    public abstract void finish() throws IOException;

    public abstract void entry(TextUnit unit);
  }

  public abstract class LanguageProducerSession {

    protected String id;
    protected String baseLang;
    
    protected LanguageProducerSession(String id, String baseLang) {
      super();
      this.id = id;
      this.baseLang = baseLang;
    }
    public abstract LanguageProducerLanguageSession forLang(String lang);
    public abstract void finish() throws IOException;
  }
  
  private String folder;
  
  public LanguageFileProducer(String folder) {
    super();
    this.folder = folder;
  }
  
  public String getFolder() {
    return folder;
  }

  public abstract LanguageProducerSession startSession(String id, String baseLang) throws IOException;
  public abstract void finish();

  public abstract List<TextUnit> loadTranslations(String baseLang, String targetLang);
}
