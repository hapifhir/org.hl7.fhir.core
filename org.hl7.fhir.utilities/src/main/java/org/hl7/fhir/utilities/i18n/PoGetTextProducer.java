package org.hl7.fhir.utilities.i18n;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer.POGetTextLanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer.POGetTextProducerSession;
import org.hl7.fhir.utilities.i18n.XLIFFProducer.XLiffLanguageProducerLanguageSession;

public class PoGetTextProducer extends LanguageFileProducer {

  private int filecount;
  private boolean incLangInFilename;

  public PoGetTextProducer(String folder) {
    super(folder);
  }

  public PoGetTextProducer() {
    super();
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
      ln("#: "+unit.getId());
      if (unit.getContext1() != null) {
        ln("#. "+unit.getContext1());
      }
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
  public List<TranslationUnit> loadSource(InputStream source) throws IOException {
    List<TranslationUnit> list = new ArrayList<>();
    InputStreamReader r = new InputStreamReader(source, "UTF-8"); // leave charset out for default
    BufferedReader br = new BufferedReader(r);
    String lang = null;
    String s;
    TranslationUnit tu = null;
    while ((s = Utilities.stripBOM(br.readLine())) != null) {
       if (!Utilities.noString(s)) {
         if (s.trim().startsWith("#")) {
           if (lang == null) {
             String[] p = s.substring(1).trim().split("\\-\\>");
             if (p.length != 2) {
               throw new IOException("Encountered unexpected starting line '"+s+"'");
             } else {
               lang = p[1].trim();
             }
           } else if (s.startsWith("#:")) {
             tu = new TranslationUnit(lang, s.substring(2).trim(), null, null, null);
           } else {
             throw new IOException("Encountered unexpected line '"+s+"'");             
           }
       } else if (tu != null && s.startsWith("msgid ")) {
         tu.setSrcText(stripQuotes(s.substring(5).trim()));         
       } else if (tu != null && s.startsWith("msgstr ")) {
         tu.setTgtText(stripQuotes(s.substring(6).trim()));
         if (tu.getTgtText() != null) {
           list.add(tu);
         }
         tu = null;
       } else {
         throw new IOException("Encountered unexpected line '"+s+"'");
       }
       }
    }
    return list;
  }

  private String stripQuotes(String s) {
    if (s.length() <= 2) {
      return null;
    }
    return s.substring(1, s.length()-1);
  }

  private String getFileName(String id, String baseLang, String targetLang) throws IOException {
    return Utilities.path(getFolder(), id+(incLangInFilename ? "-"+baseLang+"-"+targetLang+".po" : ""));
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
    StringBuilder po = new StringBuilder();
    ln(po, "# "+baseLang+" -> "+targetLang);
    ln(po, "");
    for (TranslationUnit tu : translations) {
      ln(po, "#: "+tu.getId());
      if (tu.getContext1() != null) {
        ln(po, "#. "+tu.getContext1());
      }
      ln(po, "msgid \""+tu.getSrcText()+"\"");
      ln(po, "msgstr \""+(tu.getTgtText() == null ? "" : tu.getTgtText())+"\"");
      ln(po, "");
    }
    TextFile.stringToFile(po.toString(), Utilities.path(getFolder(), filename));
  }

  

}
