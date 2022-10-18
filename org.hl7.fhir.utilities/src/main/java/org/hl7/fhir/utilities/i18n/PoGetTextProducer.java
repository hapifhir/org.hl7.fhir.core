package org.hl7.fhir.utilities.i18n;

import java.io.IOException;

import org.hl7.fhir.utilities.TextFile;

public class PoGetTextProducer extends LanguageFileProducer {

  
  public PoGetTextProducer(String folder) {
    super(folder);
  }

  private String fileName;
  private StringBuilder po;
  int i = 0;
  
  @Override
  public void start(String fileName, String contextId, String contextDesc, String baseLang, String targetLang) {
    this.fileName = fileName;
    po = new StringBuilder();
  }

  @Override
  public void makeEntry(String id, String ref,  String context, String source, String target) {
    ln("#: "+id);
    if (context != null) {
      ln("#. "+context);
    }
    ln("msgid \""+source+"\"");
    ln("msgstr \""+target+"\"");
    ln("");
  }

  @Override
  public void finish() throws IOException {
    ln("");
    TextFile.stringToFile(po.toString(), fileName);
  }

  protected void ln(String line) {
    po.append(line+"\r\n");  
  }
}
