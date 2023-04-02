package org.hl7.fhir.utilities.i18n;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerSession;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer.POGetTextLanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.PoGetTextProducer.POGetTextProducerSession;
import org.hl7.fhir.utilities.i18n.XLIFFProducer.XLiffLanguageProducerLanguageSession;

public class PoGetTextProducer extends LanguageFileProducer {

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
      ln("<?xml version=\"1.0\" ?>\r\n");
      ln("<xliff xmlns=\"urn:oasis:names:tc:xliff:document:2.0\" version=\"2.0\">");
      ln("  <file source-language=\""+baseLang+"\" target-language=\""+targetLang+"\" id=\""+id+"\" original=\"Resource "+id+"\" datatype=\"KEYVALUEJSON\">");
      ln("    <body>");
    }

    protected void ln(String line) {
      po.append(line+"\r\n");  
    }

    @Override
    public void finish() throws IOException {
      ln("");
      TextFile.stringToFile(po.toString(), Utilities.path(getFolder(), id+"-"+baseLang+"-"+targetLang+".po"));
    }

    @Override
    public void entry(TextUnit unit) {
      ln("#: "+unit.getContext());
      //    if (context != null) {
      //      ln("#. "+context);
      //    }
      ln("msgid \""+unit.getSrcText()+"\"");
      ln("msgstr \""+unit.getTgtText()+"\"");
      ln("");
    }

  }


  @Override
  public List<TextUnit> loadTranslations(String baseLang, String tgtLang) {
    return null;
  }


}
