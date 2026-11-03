package org.hl7.fhir.utilities.xml;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class XmlEscaper {

  private static final int BUFFER_SIZE = 8192;
  private static final char[] LT = "&lt;".toCharArray();
  private static final char[] GT = "&gt;".toCharArray();
  private static final char[] AMP = "&amp;".toCharArray();
  private static final char[] QUOT = "&quot;".toCharArray();

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
    // The source is UTF-8 (the IG publisher's JSON includes), so it is decoded as UTF-8 and the
    // result is encoded as UTF-8: not the platform default charset, and not just the low byte of
    // each char, which mangled everything above U+00FF.
    // Read and write in blocks: the target is often a bare FileOutputStream, where writing a byte at
    // a time means a system call for every character. The writer carries a surrogate pair that is
    // split across two blocks over to the next write.
    Reader reader = new InputStreamReader(source, StandardCharsets.UTF_8);
    Writer writer = new OutputStreamWriter(target, StandardCharsets.UTF_8);
    char[] chars = new char[BUFFER_SIZE];
    // an escape is at most 6 chars
    char[] out = new char[BUFFER_SIZE * 6];
    int n;
    while ((n = reader.read(chars)) != -1) {
      int len = 0;
      for (int j = 0; j < n; j++) {
        char c = chars[j];
        if (c == '<')
          len = put(out, len, LT);
        else if (c == '>')
          len = put(out, len, GT);
        else if (c == '&')
          len = put(out, len, AMP);
        else if (c == '"')
          len = put(out, len, QUOT);
        else
          out[len++] = c;
      }
      writer.write(out, 0, len);
    }
    // flush, not close: the caller owns the target
    writer.flush();
  }

  private static int put(char[] out, int len, char[] escape) {
    System.arraycopy(escape, 0, out, len, escape.length);
    return len + escape.length;
  }

}       

