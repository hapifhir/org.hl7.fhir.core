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
    ln("<xliff xmlns=\"urn:oasis:names:tc:xliff:document:2.0\" version=\"2.0\"");
    ln("  srcLang=\""+baseLang+"\" trgLang=\""+targetLang+"\">");
    ln("  <file id=\""+contextId+"\">");
    ln("    <notes>");
    ln("      <note id=\"n1\">"+Utilities.escapeXml(contextDesc)+"</note>");
    ln("    </notes>");
  }

  @Override
  public void makeEntry(String id, String ref, String context, String source, String target) {
    i++;
    ln("  <unit id=\""+id+"\">");
    if (context != null) {
      ln("  <notes>");
      ln("    <note id=\"n"+i+"\">"+Utilities.escapeXml(context)+"</note>");
      ln("  </notes>");
    }
    ln("    <segment id=\""+ref+"\">");
    ln("      <source><pc id=\"src"+i+"\">"+Utilities.escapeXml(source)+"</source>");
    ln("      <target><pc id=\"tgt"+i+"\">"+Utilities.escapeXml(target)+"</target>");
    ln("    </segment>");
    ln("  </unit>");
  }

  @Override
  public void finish() throws IOException {
    ln("  </file>");
    ln("</xliff>");
    TextFile.stringToFile(xml.toString(), Utilities.path(getFolder(), fileName+".xliff"));
  }

  protected void ln(String line) {
    xml.append(line+"\r\n");  
  }
}
