package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4b.model.Binary;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class BinaryRenderer {

  private String folder;
  private List<String> filenames = new ArrayList<String>();

  public BinaryRenderer(String folder) {
    super();
    this.folder = folder;
  }

  public String getFolder() {
    return folder;
  }

  public List<String> getFilenames() {
    return filenames;
  }

  public static String getBinContentAsString(Binary bin) {
    // for now, assume UTF8. To do: extract character encoding from mime type if possible (charset)
    return new String(bin.getContent(), StandardCharsets.UTF_8);
  }

  public String display(Binary bin) throws IOException {
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    render(div, bin);
    return new XhtmlComposer(false, true).compose(div);
  }
  
  
  public void render(XhtmlNode x, Binary bin) throws IOException {
    filenames.clear();
    if (!bin.hasContentType()) {
      error(x, "No Content Type");
    } else if (bin.getContentType().startsWith("image/")) {
      image(x, bin);
    } else if (isXml(bin.getContentType())) {
      xml(x, bin);
    } else if (isJson(bin.getContentType())) {
      json(x, bin);      
    } else if (isTtl(bin.getContentType())) {
      ttl(x, bin);      
    } else if (isText(bin.getContentType())) {
      text(x, bin);      
    } else {
      error(x, "The Content Type '"+bin.getContentType()+"' is not rendered in this context");
    }
  }


  private void image(XhtmlNode x, Binary bin) throws IOException {
    String ext = null;
    if (bin.getContentType().startsWith("image/png")) {
      ext = ".png";
    } else if (bin.getContentType().startsWith("image/jpeg")) {
      ext = ".jpg";
    } else if (bin.getContentType().startsWith("image/gif")) {
      ext = ".gif";
    } else if (bin.getContentType().startsWith("image/svg")) {
      ext = ".svg";
    }
    
    if (ext == null) {
      error(x, "The Image Type '"+bin.getContentType()+"' is not rendered in this context");
    } else {
      String fn = "Binary-Native-"+bin.getId()+ext;
      TextFile.bytesToFile(bin.getContent(), Utilities.path(folder, fn));
      filenames.add(fn);
      x.img("Binary-Native-"+bin.getId()+ext, "Binary");
    }
  }

  private void error(XhtmlNode x, String message) {
    x.tx("["+message+"]");
  }

  private boolean isXml(String ct) {
    return ct.startsWith("text/xml") || ct.startsWith("application/xml") || ct.contains("+xml");
  }

  private void xml(XhtmlNode x, Binary bin) {
    String content = "\r\n"+getBinContentAsString(bin);
    XhtmlNode pre = x.pre("xml");
    pre.code(content);    
  }
  
  private boolean isJson(String ct) {
    return ct.startsWith("text/json") || ct.startsWith("application/json") || ct.contains("+json");
  }
  
  private void json(XhtmlNode x, Binary bin) {
    String content = "\r\n"+getBinContentAsString(bin);
    XhtmlNode pre = x.pre("json");
    pre.code(content);    
  }
  
  private boolean isTtl(String ct) {
    return ct.startsWith("text/rdf") || ct.contains("+turtle");
  }
  
  private void ttl(XhtmlNode x, Binary bin) {
    String content = "\r\n"+getBinContentAsString(bin);
    XhtmlNode pre = x.pre("rdf language-turtle");
    pre.code(content);    
  }
  

  private boolean isText(String ct) {
    return ct.startsWith("text/");
  }
  
  private void text(XhtmlNode x, Binary bin) {
    String content = "\r\n"+getBinContentAsString(bin);
    XhtmlNode pre = x.pre();
    pre.code(content);    
  }
  

}
