package org.hl7.fhir.utilities.i18n;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerSession;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer.POGetTextLanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer.POGetTextProducerSession;
import org.hl7.fhir.utilities.i18n.XLIFFProducer.XLiffLanguageProducerLanguageSession;

public class PoGetTextProducer extends LanguageFileProducer {

  private int filecount;

  public PoGetTextProducer(String folder) {
    super(folder);
  }

  @Override
  public LanguageProducerSession startSession(String id, String baseLang) throws IOException {
    return new POGetTextProducerSession(id, baseLang);
  }

  @Override
  public void finish() {
    // nothing
  }

  public class POGetTextProducerSession extends LanguageProducerSession {

    public POGetTextProducerSession(String id, String baseLang) {
      super (id, baseLang);
    }

    @Override
    public LanguageProducerLanguageSession forLang(String targetLang) {
      return new POGetTextLanguageProducerLanguageSession(id, baseLang, targetLang);
    }

    @Override
    public void finish() throws IOException {
      // nothing
    }
  }

  public class POGetTextLanguageProducerLanguageSession extends LanguageProducerLanguageSession {


    private StringBuilder po;

    public POGetTextLanguageProducerLanguageSession(String id, String baseLang, String targetLang) {
      super(id, baseLang, targetLang);
      po = new StringBuilder();
      ln("# "+baseLang+" -> "+targetLang);
      ln("");
    }

    protected void ln(String line) {
      po.append(line+"\r\n");  
    }

    @Override
    public void finish() throws IOException {
      TextFile.stringToFile(po.toString(), getFileName(id, baseLang, targetLang));
      filecount++;
    }

    @Override
    public void entry(TextUnit unit) {
      ln("#: "+unit.getContext());
      //    if (context != null) {
      //      ln("#. "+context);
      //    }
      ln("msgid \""+unit.getSrcText()+"\"");
      ln("msgstr \""+(unit.getTgtText() == null ? "" : unit.getTgtText())+"\"");
      ln("");
    }

  }


  @Override
  public int fileCount() {
    return filecount;
  }

  @Override
  public List<TextUnit> loadTranslations(String id, String baseLang, String targetLang) throws IOException {
    List<TextUnit> res = new ArrayList<>();
    File f = new File(getFileName(id, baseLang, targetLang));
    if (f.exists()) {
      
    }
    return res;
  }

  private String getFileName(String id, String baseLang, String targetLang) throws IOException {
    return Utilities.path(getFolder(), id+"-"+baseLang+"-"+targetLang+".po");
  }


}
