package org.hl7.fhir.utilities.xml;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class XmlEscaper {

  private static final int BUFFER_SIZE = 8192;
  private static final byte[] LT = "&lt;".getBytes(StandardCharsets.UTF_8);
  private static final byte[] GT = "&gt;".getBytes(StandardCharsets.UTF_8);
  private static final byte[] AMP = "&amp;".getBytes(StandardCharsets.UTF_8);
  private static final byte[] QUOT = "&quot;".getBytes(StandardCharsets.UTF_8);

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
    try (InputStream input = ManagedFileAccess.inStream(source);
         OutputStream output = new BufferedOutputStream(ManagedFileAccess.outStream(target))) {
      convert(input, output);
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
    // read and write in blocks: the target is often a bare FileOutputStream, where writing a byte at
    // a time means a system call for every character
    BufferedReader buffer = new BufferedReader(new InputStreamReader(source));
    char[] chars = new char[BUFFER_SIZE];
    // an escape is at most 6 bytes
    byte[] bytes = new byte[BUFFER_SIZE * 6];
    int n;
    while ((n = buffer.read(chars)) != -1) {
      int len = 0;
      for (int j = 0; j < n; j++) {
        char c = chars[j];
        if (c == '<')
          len = put(bytes, len, LT);
        else if (c == '>')
          len = put(bytes, len, GT);
        else if (c == '&')
          len = put(bytes, len, AMP);
        else if (c == '"')
          len = put(bytes, len, QUOT);
        else
          bytes[len++] = (byte) c;
      }
      target.write(bytes, 0, len);
    }
  }

  private static int put(byte[] bytes, int len, byte[] escape) {
    System.arraycopy(escape, 0, bytes, len, escape.length);
    return len + escape.length;
  }

}       

