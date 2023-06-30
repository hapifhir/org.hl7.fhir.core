package org.hl7.fhir.utilities.xml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class XmlEscaper {

  private InputStream source;
  private OutputStream target;
  
  
  protected XmlEscaper(InputStream source, OutputStream target) {
    super();
    this.source = source;
    this.target = target;
  }
  
  public static void convert(InputStream source, OutputStream target) throws IOException {
    XmlEscaper self = new XmlEscaper(source, target);
    self.process();
  }
  
  public static void convert(String source, String target) throws IOException {
    FileOutputStream fs = new FileOutputStream(target);
    try {
      convertAndClose(new FileInputStream(source), fs);
    } finally {
      fs.close();
    }
  }
  
  public static void convertAndClose(InputStream source, OutputStream target) throws IOException {
    XmlEscaper self = new XmlEscaper(source, target);
    self.process();
    source.close();
    target.close();
  }
  
  public InputStream getSource() {
    return source;
  }
  public void setSource(InputStream source) {
    this.source = source;
  }
  public OutputStream getTarget() {
    return target;
  }
  public void setTarget(OutputStream target) {
    this.target = target;
  }
  
  public void process() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(source));
    int i = 0;
    while ((i = buffer.read()) != -1) {
      char c = (char) i;          
      if (c == '<')
        write("&lt;");
      else if (c == '>')
        write("&gt;");
      else if (c == '&')
        write("&amp;");
      else if (c == '"')
        write("&quot;");
      else
        target.write((byte) i);
    }
  }
  
  private void write(String s) throws IOException {
    target.write(s.getBytes(StandardCharsets.UTF_8));
  }
    
}       

