package org.hl7.fhir.utilities.xhtml;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.

 */



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.IXMLWriter;
import org.w3c.dom.Element;

public class XhtmlComposer {

  protected static Set<String> BLOCK_NAMES =  Set.of("li", "ul", "ol", "tr", "td", "th", "div", "table");
  public static final String XHTML_NS = "http://www.w3.org/1999/xhtml";
  private boolean pretty;
  private boolean xml; 
  private boolean autoLinks;
  private boolean canonical;

  public static final boolean XML = true; 
  public static final boolean HTML = false; 

  public XhtmlComposer(boolean xml, boolean pretty) {
    super();
    this.pretty = pretty;
    this.xml = xml;
  }

  public XhtmlComposer(boolean xml) {
    super();
    this.pretty = false;
    this.xml = xml;
  }

  private Writer dst;

  public String compose(XhtmlDocument doc) {
    if (!xml && !pretty) {
      breakBlocksWithLines(doc);
    }
    StringWriter sdst = new StringWriter();
    dst = sdst;
    try {
      composeDoc(doc);
    } catch (IOException e) {
    }
    return sdst.toString();
  }

  private void breakBlocksWithLines(XhtmlNode node) {
    if (node.hasChildren()) {
      breakBlocksWithLines(node.getChildNodes());
    }
  }

  private void breakBlocksWithLines(List<XhtmlNode> list) {
    for (int i = list.size() -1; i > 0; i--) {
      XhtmlNode node = list.get(i);
      if (node.getNodeType() == NodeType.Element && BLOCK_NAMES.contains(node.getName())) {
        XhtmlNode prev = list.get(i-1);
        if (prev.getNodeType() != NodeType.Text || prev.getContent() == null || !(prev.getContent().endsWith("\r") || prev.getContent().endsWith("\n"))) {
          list.add(i, new XhtmlNode(NodeType.Text).setContent("\r\n"));
        }        
      }
      breakBlocksWithLines(node);
    }    
  }

  public String compose(XhtmlNode node) {
    if (!xml && !pretty) {
      breakBlocksWithLines(node);
    }
    StringWriter sdst = new StringWriter();
    dst = sdst;
    try {
      writeNode("", node, false);
    } catch (IOException e) {
    }
    return sdst.toString();
  }

  public String compose(List<XhtmlNode> nodes) throws IOException  {
    if (!xml && !pretty) {
      breakBlocksWithLines(nodes);
    }
    StringWriter sdst = new StringWriter();
    dst = sdst;
    for (XhtmlNode node : nodes) {      
      writeNode("", node, false);
    }
    return sdst.toString();
  }

  public void compose(OutputStream stream, XhtmlDocument doc) throws IOException  {
    byte[] bom = new byte[] { (byte)0xEF, (byte)0xBB, (byte)0xBF };
    stream.write(bom);
    dst = new OutputStreamWriter(stream, "UTF-8");
    composeDoc(doc);
    dst.flush();
  }

  private void composeDoc(XhtmlDocument doc) throws IOException  {
    if (!xml) {
      breakBlocksWithLines(doc);
    }
    // headers....
    //    dst.append("<html>" + (pretty ? "\r\n" : ""));
    for (XhtmlNode c : doc.getChildNodes()) {
      writeNode("  ", c, false);
    }
    //    dst.append("</html>" + (pretty ? "\r\n" : ""));
  }

  private void writeNode(String indent, XhtmlNode node, boolean noPrettyOverride) throws IOException  {
    if (node.getNodeType() == NodeType.Comment) {
      writeComment(indent, node, noPrettyOverride);
    } else if (node.getNodeType() == NodeType.DocType) {
      writeDocType(node);
    } else if (node.getNodeType() == NodeType.Instruction) {
      writeInstruction(node);
    } else if (node.getNodeType() == NodeType.Element) {
      writeElement(indent, node, noPrettyOverride);
    } else if (node.getNodeType() == NodeType.Document) {
      writeDocument(indent, node);
    } else if (node.getNodeType() == NodeType.Text) {
      writeText(node);
    } else if (node.getNodeType() == null) {
      throw new Error("Null node type");
    } else {
      throw new Error("Unknown node type: "+node.getNodeType().toString());
    }
  }

  private boolean isValidUrlChar(char c) {
    return Character.isAlphabetic(c) || Character.isDigit(c) || Utilities.existsInList(c, ';', ',', '/', '?', ':', '@', '&', '=', '+', '$', '-', '_', '.', '!', '~', '*', '\'', '(', ')');
  }

  private void writeText(XhtmlNode node) throws IOException  {
    String src = node.getContent();
    int i = 0;
    while (i < src.length()) {
      int ci = src.codePointAt(i);
      char c = (char) ci;
      if (canonical) {
        if (c == '&') {
          dst.append("&amp;");
        } else if (c == '<') {
          dst.append("&lt;");
        } else if (c == '>') {
          dst.append("&gt;");
        } else if (c == '\r') {
          dst.append("#xD;");
        } else {
          dst.append(c);
        }
        i++;
      } else {
        if (ci > 65535) {
          dst.append("&#x");
          dst.append(Integer.toHexString(ci).toUpperCase());
          dst.append(";");
          i += Character.charCount(ci);
        } else {
          if (autoLinks && c == 'h' && Utilities.startsWithInList(src.substring(i), "http://", "https://")) {
            int j = i;
            while (i < src.length() && isValidUrlChar(src.charAt(i))) {
              i++;
            }
            String url = src.substring(j, i);
            if (url.endsWith(".") || url.endsWith(",")) {
              i--;
              url = url.substring(0, url.length()-1);
            }
            url = Utilities.escapeXml(url);
            dst.append("<a href=\""+url+"\">"+ url +"</a>");
          } else {
            i++;
            if (c == '&') {
              dst.append("&amp;");
            } else if (c == '<') {
              dst.append("&lt;");
            } else if (c == '>') {
              dst.append("&gt;");
            } else if (xml) {
              if (c == '"')
                dst.append("&quot;");
              else 
                dst.append(c);
            } else {
              if (c == XhtmlNode.NBSP.charAt(0))
                dst.append("&nbsp;");
              else if (c == (char) 0xA7)
                dst.append("&sect;");
              else if (c == (char) 169)
                dst.append("&copy;");
              else if (c == (char) 8482)
                dst.append("&trade;");
              else if (c == (char) 956)
                dst.append("&mu;");
              else if (c == (char) 174)
                dst.append("&reg;");
              else 
                dst.append(c);            
            }
          }
        }
      }
    }
  }
  
  private String escapeHtml(String s)  {
    if (s == null || s.equals(""))
      return null;
    StringBuilder b = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (canonical) {
        if (c == '<')
          b.append("&lt;");
        else if (c == '"')
          b.append("&quot;");
        else if (c == '&')
          b.append("&amp;");
        else if (c == '\t')
          b.append("#x9;");
        else if (c == '\n')
          b.append("#xA;");
        else if (c == '\r')
          b.append("#xD;");
        else
          b.append(c);
      } else {
        if (c == '<')
          b.append("&lt;");
        else if (c == '>')
          b.append("&gt;");
        else if (c == '"')
          b.append("&quot;");
        else if (c == '&')
          b.append("&amp;");
        else
          b.append(c);
      }
    }
    return b.toString();
  }

  boolean isTwoCharUnicodeCodePoint(char c1, char c2) {
    return false;
  }

  private void writeComment(String indent, XhtmlNode node, boolean noPrettyOverride) throws IOException {
    dst.append(indent + "<!-- " + node.getContent().trim() + " -->" + (pretty && !noPrettyOverride ? "\r\n" : ""));
  }

  private void writeDocType(XhtmlNode node) throws IOException {
    dst.append("<!" + node.getContent() + ">\r\n");
  }

  private void writeInstruction(XhtmlNode node) throws IOException {
    dst.append("<?" + node.getContent() + "?>\r\n");
  }


  private String attributes(XhtmlNode node) {
    StringBuilder s = new StringBuilder();
    for (String n : node.getAttributes().keySet())
      s.append(" " + n + "=\"" + escapeHtml(node.getAttributes().get(n)) + "\"");
    return s.toString();
  }

  private void writeElement(String indent, XhtmlNode node, boolean noPrettyOverride) throws IOException  {
    if (!pretty || noPrettyOverride)
      indent = "";

    boolean concise = false;
    if (!node.hasChildren()) {
      if (this.xml) {
        concise = true;
      } else if (!(node.hasEmptyExpanded() && node.getEmptyExpanded()) && 
          Utilities.existsInList(node.getName(), "area", "base", "br", "col", "command", "embed", "hr", "img", "input", "keygen", "link", "menuitem", "meta", "param", "source", "track", "wbr")) {
        // In HTML5, only these elements can self-close
        // https://developer.mozilla.org/en-US/docs/Glossary/Void_element
        concise = true;
      }
    }
    
    if (concise)
      dst.append(indent + "<" + node.getName() + attributes(node) + "/>" + (pretty && !noPrettyOverride ? "\r\n" : ""));
    else {
      boolean act = node.allChildrenAreText();
      if (act || !pretty ||  noPrettyOverride)
        dst.append(indent + "<" + node.getName() + attributes(node)+">");
      else
        dst.append(indent + "<" + node.getName() + attributes(node) + ">\r\n");
      if (node.getName() == "head" && node.getElement("meta") == null)
        dst.append(indent + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>" + (pretty && !noPrettyOverride ? "\r\n" : ""));

      if (act && Utilities.existsInList(node.getName(), "script", "style")) {
        dst.append(node.allText());
      } else {
        for (XhtmlNode c : node.getChildNodes())
          writeNode(indent + "  ", c, noPrettyOverride || node.isNoPretty());
      }
      if (act)
        dst.append("</" + node.getName() + ">" + (pretty && !noPrettyOverride ? "\r\n" : ""));
      else if (node.getChildNodes().get(node.getChildNodes().size() - 1).getNodeType() == NodeType.Text)
        dst.append((pretty && !noPrettyOverride ? "\r\n"+ indent : "")  + "</" + node.getName() + ">" + (pretty && !noPrettyOverride ? "\r\n" : ""));
      else
        dst.append(indent + "</" + node.getName() + ">" + (pretty && !noPrettyOverride ? "\r\n" : ""));
    }
  }

  private void writeDocument(String indent, XhtmlNode node) throws IOException  {
    indent = "";
    for (XhtmlNode c : node.getChildNodes())
      writeNode(indent, c, false);
  }


  public void compose(IXMLWriter xml, XhtmlNode node) throws IOException  {
    compose(xml, node, false);
  }

  public void compose(IXMLWriter xml, XhtmlNode node, boolean noPrettyOverride) throws IOException  {
    if (node.getNodeType() == NodeType.Comment)
      xml.comment(node.getContent(), pretty && !noPrettyOverride);
    else if (node.getNodeType() == NodeType.Element)
      composeElement(xml, node, noPrettyOverride);
    else if (node.getNodeType() == NodeType.Text)
      xml.text(node.getContent());
    else
      throw new Error("Unhandled node type: "+node.getNodeType().toString());
  }

  private void composeElement(IXMLWriter xml, XhtmlNode node, boolean noPrettyOverride) throws IOException  {
    for (String n : node.getAttributes().keySet()) {
      if (n.equals("xmlns")) 
        xml.setDefaultNamespace(node.getAttributes().get(n));
      else if (n.startsWith("xmlns:")) 
        xml.namespace(n.substring(6), node.getAttributes().get(n));
      else
        xml.attribute(n, node.getAttributes().get(n));
    }
    xml.enter(XHTML_NS, node.getName());
    for (XhtmlNode n : node.getChildNodes())
      compose(xml, n, noPrettyOverride || node.isNoPretty());
    xml.exit(XHTML_NS, node.getName());
  }

  public String composePlainText(XhtmlNode x) {
    StringBuilder b = new StringBuilder();
    composePlainText(x, b, false);
    return b.toString().trim();
  }

  private boolean composePlainText(XhtmlNode x, StringBuilder b, boolean lastWS) {
    if (x.getNodeType() == NodeType.Text) {
      String s = x.getContent();
      if (!lastWS & (s.startsWith(" ") || s.startsWith("\r") || s.startsWith("\n") || s.endsWith("\t"))) {
        b.append(" ");
        lastWS = true;
      }
      String st = s.trim().replace("\r", " ").replace("\n", " ").replace("\t", " ");
      while (st.contains("  "))
        st = st.replace("  ", " ");
      if (!Utilities.noString(st)) {
        b.append(st);
        lastWS = false;
        if (!lastWS & (s.endsWith(" ") || s.endsWith("\r") || s.endsWith("\n") || s.endsWith("\t"))) {
          b.append(" ");
          lastWS = true;
        }
      }
      return lastWS;
    } else if (x.getNodeType() == NodeType.Element) {
      if (x.getName().equals("li")) {
        b.append("* ");
        lastWS = true;
      }

      for (XhtmlNode n : x.getChildNodes()) {
        lastWS = composePlainText(n, b, lastWS);
      }
      if (x.getName().equals("p")) {
        b.append("\r\n\r\n");
        lastWS = true;
      }
      if (x.getName().equals("br") || x.getName().equals("li")) {
        b.append("\r\n");
        lastWS = true;
      }
      return lastWS;
    } else
      return lastWS;
  }

  public void compose(Element div, XhtmlNode x) {
    for (XhtmlNode child : x.getChildNodes()) {
      appendChild(div, child);
    }
  }

  private void appendChild(Element e, XhtmlNode node) {
    if (node.getNodeType() == NodeType.Comment)
      e.appendChild(e.getOwnerDocument().createComment(node.getContent()));
    else if (node.getNodeType() == NodeType.DocType)
      throw new Error("not done yet");
    else if (node.getNodeType() == NodeType.Instruction)
      e.appendChild(e.getOwnerDocument().createProcessingInstruction("", node.getContent()));
    else if (node.getNodeType() == NodeType.Text)
      e.appendChild(e.getOwnerDocument().createTextNode(node.getContent()));
    else if (node.getNodeType() == NodeType.Element) {
      Element child = e.getOwnerDocument().createElementNS(XHTML_NS, node.getName());
      e.appendChild(child);
      for (String n : node.getAttributes().keySet()) {
        child.setAttribute(n,  node.getAttribute(n));
      }
      for (XhtmlNode c : node.getChildNodes()) {
        appendChild(child, c);
      }
    } else
      throw new Error("Unknown node type: "+node.getNodeType().toString());
  }

  public void compose(OutputStream stream, XhtmlNode x) throws IOException {
    byte[] bom = new byte[] { (byte)0xEF, (byte)0xBB, (byte)0xBF };
    stream.write(bom);
    dst = new OutputStreamWriter(stream, "UTF-8");
    dst.append("<html><head><link rel=\"stylesheet\" href=\"fhir.css\"/></head><body>\r\n");
    writeNode("", x, false);
    dst.append("</body></html>\r\n");
    dst.flush();
  }

  public void composeDocument(FileOutputStream f, XhtmlNode xhtml) throws IOException {
    byte[] bom = new byte[] { (byte)0xEF, (byte)0xBB, (byte)0xBF };
    f.write(bom);
    dst = new OutputStreamWriter(f, "UTF-8");
    writeNode("", xhtml, false);
    dst.flush();
    dst.close();
  }

  public String composeEx(XhtmlNode node) {
    return compose(node);
  }

  public String compose(XhtmlNodeList nodes) throws IOException {
    StringWriter sdst = new StringWriter();
    dst = sdst;
    for (XhtmlNode node : nodes) {
      writeNode("", node, false);
    }
    return sdst.toString();
  }

  public boolean isAutoLinks() {
    return autoLinks;
  }

  public XhtmlComposer setAutoLinks(boolean autoLinks) {
    this.autoLinks = autoLinks;
    return this;
  }

  public boolean isCanonical() {
    return canonical;
  }

  public XhtmlComposer setCanonical(boolean canonical) {
    this.canonical = canonical;
    return this;
  }

}