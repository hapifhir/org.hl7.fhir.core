package org.hl7.fhir.utilities.i18n;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class XLIFFProducer extends LanguageFileProducer {

  public class XLiffLanguageProducerLanguageSession extends LanguageProducerLanguageSession {

    private StringBuilder xml;
    int i = 0;

    public XLiffLanguageProducerLanguageSession(String id, String baseLang, String targetLang) {
      super(id, baseLang, targetLang);
      xml = new StringBuilder();
      ln("<?xml version=\"1.0\" ?>\r\n");
      ln("<xliff xmlns=\"urn:oasis:names:tc:xliff:document:2.0\" version=\"2.0\">");
      ln("  <file source-language=\""+baseLang+"\" target-language=\""+targetLang+"\" id=\""+id+"\" original=\"Resource "+id+"\" datatype=\"KEYVALUEJSON\">");
      ln("    <body>");
    }

    protected void ln(String line) {
      xml.append(line+"\r\n");  
    }

    @Override
    public void finish() throws IOException {
      ln("    </body>");
      ln("  </file>");
      ln("</xliff>");
      TextFile.stringToFile(xml.toString(), Utilities.path(getFolder(), id+".xliff"));
    }

    @Override
    public void entry(String id, String src, String dst) {
      i++;
      ln("      <trans-unit id=\""+id+"\" resname=\""+this.id+"\">");
//      if (context != null) {
//        ln("        <notes>");
//        ln("          <note id=\"n"+i+"\">"+Utilities.escapeXml(context)+"</note>");
//        ln("        </notes>");
//      }
      ln("        <source>"+Utilities.escapeXml(src)+"</source>");
      ln("        <target>"+Utilities.escapeXml(dst)+"</target>");
      ln("      </trans-unit>");
    }

  }

  public class XLiffLanguageProducerSession extends LanguageProducerSession {


    public XLiffLanguageProducerSession(String id, String baseLang) {
      super (id, baseLang);
    }

    @Override
    public LanguageProducerLanguageSession forLang(String targetLang) {
      return new XLiffLanguageProducerLanguageSession(id, baseLang, targetLang);
    }

    @Override
    public void finish() throws IOException {
      // nothing
    }

  }

  public XLIFFProducer(String folder) {
    super(folder);
  }

  @Override
  public LanguageProducerSession startSession(String id, String baseLang) throws IOException {
    return new XLiffLanguageProducerSession(id, baseLang);
  }

  @Override
  public void finish() {
    // nothing
  }

  @Override
  public List<Translations> loadTranslations(String id) {
    // TODO Auto-generated method stub
    return null;
  }
}
