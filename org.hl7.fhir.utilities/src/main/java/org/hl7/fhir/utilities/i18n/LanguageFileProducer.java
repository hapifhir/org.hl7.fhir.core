package org.hl7.fhir.utilities.i18n;

import java.io.IOException;

public abstract class LanguageFileProducer {

  private String folder;
  
  public LanguageFileProducer(String folder) {
    super();
    this.folder = folder;
  }
  
  public String getFolder() {
    return folder;
  }

  public abstract void start(String fileName, String contextId, String contextDesc, String baseLang, String targetLang) throws IOException;
  public abstract void makeEntry(String id, String ref, String context, String source, String dest) throws IOException;
  public abstract void finish() throws IOException;

}
