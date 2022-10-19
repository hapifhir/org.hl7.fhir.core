package org.hl7.fhir.utilities.i18n;

import java.io.IOException;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class XLIFFProducer extends LanguageFileProducer {

  
  public XLIFFProducer(String folder) {
    super(folder);
  }

  private String fileName;
  private StringBuilder xml;
  int i = 0;

  @Override
  public void start(String fileName, String contextId, String contextDesc, String baseLang, String targetLang) {
    this.fileName = fileName;
    xml = new StringBuilder();
    ln("<?xml version=\"1.0\" ?>\r\n");
    ln("<xliff xmlns=\"urn:oasis:names:tc:xliff:document:2.0\" version=\"2.0\">");
    ln("  <file source-language=\""+baseLang+"\" target-language=\""+targetLang+"\" id=\""+contextId+"\" original=\""+contextDesc+"\" datatype=\"KEYVALUEJSON\">");
    ln("    <body>");
  }

  @Override
  public void makeEntry(String id, String ref, String context, String source, String target) {
    i++;
    ln("      <trans-unit id=\""+id+"\" resname=\""+ref+"\">");
    if (context != null) {
      ln("        <notes>");
      ln("          <note id=\"n"+i+"\">"+Utilities.escapeXml(context)+"</note>");
      ln("        </notes>");
    }
    ln("        <source>"+Utilities.escapeXml(source)+"</source>");
    ln("        <target>"+Utilities.escapeXml(target)+"</target>");
    ln("      </trans-unit>");
  }

  @Override
  public void finish() throws IOException {
    ln("    </body>");
    ln("  </file>");
    ln("</xliff>");
    TextFile.stringToFile(xml.toString(), Utilities.path(getFolder(), fileName+".xliff"));
  }

  protected void ln(String line) {
    xml.append(line+"\r\n");  
  }
}
