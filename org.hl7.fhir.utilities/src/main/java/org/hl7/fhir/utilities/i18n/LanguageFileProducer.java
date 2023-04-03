package org.hl7.fhir.utilities.i18n;

import java.io.IOException;

public abstract class LanguageFileProducer {

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

    public abstract void entry(String id, String src, String dst);
  }

  public abstract class LanguageProducerSession {

    protected String id;
    protected String baseLang;
    
    protected LanguageProducerSession( String id, String baseLang) {
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

}
