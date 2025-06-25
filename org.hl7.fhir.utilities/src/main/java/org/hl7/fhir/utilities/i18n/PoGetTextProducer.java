package org.hl7.fhir.utilities.i18n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;

public class PoGetTextProducer extends LanguageFileProducer {

  private int filecount;
  private boolean incLangInFilename;
  private String srcLang;

  public PoGetTextProducer(String rootFolder, String folderName, boolean useLangFolder) {
    super(rootFolder, folderName, useLangFolder);
  }

  public PoGetTextProducer() {
    super();
  }

  public PoGetTextProducer(String srcLang) {
    super();
    this.srcLang = srcLang;
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

    POSource source = new POSource();

    public POGetTextLanguageProducerLanguageSession(String id, String baseLang, String targetLang) {
      super(id, baseLang, targetLang);
    }

    @Override
    public void finish() throws IOException {
      source.savePOFile(getFileName(id, baseLang, targetLang), 1, 0);
      filecount++;
    }


    @Override
    public void entry(TextUnit unit) {
      POObject po = new POObject(unit.getId(), unit.getSrcText(), unit.getTgtText());
      po.setComment(unit.getContext());
      source.getEntries().add(po);      
    }

  }


  @Override
  public int fileCount() {
    return filecount;
  }

  @Override
  public List<TranslationUnit> loadSource(InputStream source) throws IOException {
    List<TranslationUnit> list = new ArrayList<>();
    POSource polist = POSource.loadPOFile(source);
    for (POObject po : polist.getEntries()) {
      TranslationUnit tu = new TranslationUnit(srcLang == null ? polist.getLang() : srcLang, po.getId(), null, po.getMsgid(), po.getMsgstr().isEmpty() ? null : po.getMsgstrFirst());
      if (tu.getId() != null) {
        list.add(tu);
      }
    }
    return list;
  }

  private String getFileName(String id, String baseLang, String targetLang) throws IOException {
    return Utilities.path(getRootFolder(), isUseLangFolder() ? targetLang : ".",  getFolderName(), id+(incLangInFilename ? "-"+baseLang+"-"+targetLang+".po" : ""));
  }

  public boolean isIncLangInFilename() {
    return incLangInFilename;
  }

  public void setIncLangInFilename(boolean incLangInFilename) {
    this.incLangInFilename = incLangInFilename;
  }

  protected void ln(StringBuilder po, String line) {
    po.append(line+"\r\n");  
  }
  
  @Override
  public void produce(String id, String baseLang, String targetLang, List<TranslationUnit> translations, String filename) throws IOException {
    POSource source = new POSource();
    
    for (TranslationUnit unit : translations) {
      POObject po = new POObject(unit.getId(), unit.getSrcText(), unit.getTgtText());
      po.setComment(unit.getContext());
      po.setOldMsgId(unit.getOriginal());
      source.getEntries().add(po);      
    }
    source.savePOFile(getFileName(id, baseLang, targetLang)+".po", 1, 0);      
  }

  private String stripEoln(String s) {
    s = s.replace("\r\n\r\n", " ").replace("\n\n", " ").replace("\r\r", " ");
    s = s.replace("\r\n", " ").replace("\n", " ").replace("\r", " ");
//    // yes, the double escaping is intentional here - it appears necessary
//    s = s.replace("\\r\\n\\r\\n", " ").replace("\\n\\n", " ").replace("\\r\\r", " ");
//    s = s.replace("\\r\\n", " ").replace("\\n", " ").replace("\\r", " ");
    return s;
  }

  

}
