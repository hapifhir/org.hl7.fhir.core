package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Binary;
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

  public static String getBinContentAsString(byte[] bin) {
    // for now, assume UTF8. To do: extract character encoding from mime type if possible (charset)
    return new String(bin, StandardCharsets.UTF_8);
  }

  public String display(Binary bin) throws IOException {
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    render(div, bin);
    return new XhtmlComposer(false, true).compose(div);
  }

  public String display(Element bin) throws IOException {
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    render(div, bin);
    return new XhtmlComposer(false, true).compose(div);
  }

  public String display(String id, String ct, byte[] cnt) throws IOException {
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    render(div, id, ct, cnt);
    return new XhtmlComposer(false, true).compose(div);
  }

  public void render(XhtmlNode x, Binary bin) throws IOException {
    String ct = bin.getContentType();
    byte[] cnt = bin.getContent();
    render(x, bin.getId(), ct, cnt);
  }

  public void render(XhtmlNode x, Element bin) throws IOException {
    String ct = bin.getNamedChildValue("contentType");
    String id = bin.getNamedChildValue("id");
    byte[] cnt = Base64.getMimeDecoder().decode(bin.getNamedChildValue("data"));
    render(x, id, ct, cnt);
  }
  
  public void render(XhtmlNode x, String id, String ct, byte[] cnt) throws IOException {
    filenames.clear();
    if (ct == null) {
      error(x,"No Content Type");
    } else if (ct.startsWith("image/")) {
      image(x, id, ct, cnt);
    } else if (isXml(ct)) {
      xml(x, cnt);
    } else if (isJson(ct)) {
      json(x, cnt);      
    } else if (isTtl(ct)) {
      ttl(x, cnt);      
    } else if (isText(ct)) {
      text(x, cnt);      
    } else {
      error(x, "The Content Type '"+ct+"' is not rendered in this context");
    }
  }


  private void image(XhtmlNode x, String id, String ct, byte[] cnt) throws IOException {
    String ext = null;
    if (ct.startsWith("image/png")) {
      ext = ".png";
    } else if (ct.startsWith("image/jpeg")) {
      ext = ".jpg";
    } else if (ct.startsWith("image/gif")) {
      ext = ".gif";
    } else if (ct.startsWith("image/svg")) {
      ext = ".svg";
    }
    
    if (ext == null) {
      error(x, "The Image Type '"+ct+"' is not rendered in this context");
    } else {
      String fn = "Binary-Native-"+id+ext;
      TextFile.bytesToFile(cnt, Utilities.path(folder, fn));
      filenames.add(fn);
      x.img("Binary-Native-"+id+ext, "binary");
    }
  }

  private void error(XhtmlNode x, String message) {
    x.tx("["+message+"]");
  }

  private boolean isXml(String ct) {
    return ct.startsWith("text/xml") || ct.startsWith("application/xml") || ct.contains("+xml");
  }

  private void xml(XhtmlNode x, byte[] cnt) {
    String content = "\r\n"+getBinContentAsString(cnt);
    XhtmlNode pre = x.pre("xml");
    pre.code(content);    
  }
  
  private boolean isJson(String ct) {
    return ct.startsWith("text/json") || ct.startsWith("application/json") || ct.contains("+json");
  }
  
  private void json(XhtmlNode x, byte[] cnt) {
    String content = "\r\n"+getBinContentAsString(cnt);
    XhtmlNode pre = x.pre("json");
    pre.code(content);    
  }
  
  private boolean isTtl(String ct) {
    return ct.startsWith("text/rdf") || ct.contains("+turtle");
  }
  
  private void ttl(XhtmlNode x, byte[] cnt) {
    String content = "\r\n"+getBinContentAsString(cnt);
    XhtmlNode pre = x.pre("rdf language-turtle");
    pre.code(content);    
  }
  

  private boolean isText(String ct) {
    return ct.startsWith("text/");
  }
  
  private void text(XhtmlNode x, byte[] cnt) {
    String content = "\r\n"+getBinContentAsString(cnt);
    XhtmlNode pre = x.pre();
    pre.code(content);    
  }
  

}
