package org.hl7.fhir.utilities.xhtml;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

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



import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.instance.model.api.IBaseXhtml;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.primitive.XhtmlDt;

@ca.uhn.fhir.model.api.annotation.DatatypeDef(name="xhtml")
public class XhtmlNode implements IBaseXhtml {
  private static final long serialVersionUID = -4362547161441436492L;


  public static class Location implements Serializable {
    private static final long serialVersionUID = -4079302502900219721L;
    private int line;
    private int column;
    public Location(int line, int column) {
      super();
      this.line = line;
      this.column = column;
    }
    public int getLine() {
      return line;
    }
    public int getColumn() {
      return column;
    }
    @Override
    public String toString() {
      return "Line "+Integer.toString(line)+", column "+Integer.toString(column);
    }
  }

  public static final String NBSP = Character.toString((char)0xa0);
  public static final String XMLNS = "http://www.w3.org/1999/xhtml";
  private static final String DECL_XMLNS = " xmlns=\""+XMLNS+"\"";

  private Location location;
  private NodeType nodeType;
  private String name;
  private Map<String, String> attributes = new HashMap<String, String>();
  private List<XhtmlNode> childNodes = new ArrayList<XhtmlNode>();
  private String content;
  private boolean notPretty;
  private boolean inPara;
  private boolean inLink;
  private boolean seperated;  
  private Boolean emptyExpanded;

  public XhtmlNode() {
    super();
  }


  public XhtmlNode(NodeType nodeType, String name) {
    super();
    this.nodeType = nodeType;
    this.name = name;
  }

  public XhtmlNode(NodeType nodeType) {
    super();
    this.nodeType = nodeType;
  }

  public NodeType getNodeType() {
    return nodeType;
  }

  public void setNodeType(NodeType nodeType) {
    this.nodeType = nodeType;
  }

  public String getName() {
    return name;
  }

  public XhtmlNode setName(String name) {
    assert name.contains(":") == false : "Name should not contain any : but was " + name;
    this.name = name;
    return this;
  }

  public Map<String, String> getAttributes() {
    return attributes;
  }

  public List<XhtmlNode> getChildNodes() {
    return childNodes;
  }

  public String getContent() {
    return content;
  }

  public XhtmlNode setContent(String content) {
    if (!(nodeType != NodeType.Text || nodeType != NodeType.Comment)) 
      throw new Error("Wrong node type");
    this.content = content;
    return this;
  }

  public void validate(List<String> errors, String path, boolean inResource, boolean inPara, boolean inLink) {
    if (nodeType == NodeType.Element || nodeType == NodeType.Document) {
      path = Utilities.noString(path) ? name : path+"/"+name;
      if (inResource) {
        if (!Utilities.existsInList(name, "p", "br", "div", "h1", "h2", "h3", "h4", "h5", "h6", "a", "span", "b", "em", "i", "strong",
            "small", "big", "tt", "small", "dfn", "q", "var", "abbr", "acronym", "cite", "blockquote", "hr", "address", "bdo", "kbd", "q", "sub", "sup",
            "ul", "ol", "li", "dl", "dt", "dd", "pre", "table", "caption", "colgroup", "col", "thead", "tr", "tfoot", "tbody", "th", "td",
            "code", "samp", "img", "map", "area")) {
          errors.add("Error at "+path+": Found "+name+" in a resource");          
        }      
        for (String an : attributes.keySet()) {
          boolean ok = an.startsWith("xmlns") || Utilities.existsInList(an,
              "title", "style", "class", "ID", "lang", "xml:lang", "dir", "accesskey", "tabindex",
              // tables
              "span", "width", "align", "valign", "char", "charoff", "abbr", "axis", "headers", "scope", "rowspan", "colspan") ||
              Utilities.existsInList(name + "." + an, "a.href", "a.name", "img.src", "img.border", "div.xmlns", "blockquote.cite", "q.cite",
                  "a.charset", "a.type", "a.name", "a.href", "a.hreflang", "a.rel", "a.rev", "a.shape", "a.coords", "img.src",
                  "img.alt", "img.longdesc", "img.height", "img.width", "img.usemap", "img.ismap", "map.name", "area.shape",
                  "area.coords", "area.href", "area.nohref", "area.alt", "table.summary", "table.width", "table.border",
                  "table.frame", "table.rules", "table.cellspacing", "table.cellpadding", "pre.space", "td.nowrap"
                  );
          if (!ok)
            errors.add("Error at "+path+": Found attribute "+name+"."+an+" in a resource");          
        }
      }
      if (inPara && Utilities.existsInList(name, "div",  "blockquote", "table", "ol", "ul", "p")) {
        errors.add("Error at "+path+": Found "+name+" inside an html paragraph");
      }
      if (inLink && Utilities.existsInList(name, "a")) {
        errors.add("Error at "+path+": Found an <a> inside an <a> paragraph");
      }

      if (childNodes != null) {
        if ("p".equals(name)) {
          inPara = true;
        }
        if ("a".equals(name)) {
          inLink = true;
        }
        for (XhtmlNode child : childNodes) {
          child.validate(errors, path, inResource, inPara, inLink);
        }
      }
    }
  }
  
  public XhtmlNode addTag(String name)
  {

    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document))  {
      throw new Error("Wrong node type - node is "+nodeType.toString()+" ('"+getName()+"/"+getContent()+"')");
    }
    
//    if (inPara && name.equals("p")) {
//      throw new FHIRException("nested Para");
//    }
//    if (inLink && name.equals("a")) {
//      throw new FHIRException("Nested Link");
//    }
    XhtmlNode node = new XhtmlNode(NodeType.Element);
    node.setName(name);
    if (inPara || name.equals("p")) {
      node.inPara = true;
    }
    if (inLink || name.equals("a")) {
      node.inLink = true;
    }
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addTag(int index, String name)
  {

    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type. is "+nodeType.toString());
    XhtmlNode node = new XhtmlNode(NodeType.Element);
    if (inPara || name.equals("p")) {
      node.inPara = true;
    }
    if (inLink || name.equals("a")) {
      node.inLink = true;
    }
    node.setName(name);
    childNodes.add(index, node);
    return node;
  }

  public XhtmlNode addComment(String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.Comment);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addDocType(String content)
  {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.DocType);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addInstruction(String content)
  {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.Instruction);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }
  public XhtmlNode addText(String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content != null) {
      XhtmlNode node = new XhtmlNode(NodeType.Text);
      node.setContent(content);
      childNodes.add(node);
      return node;
    } else 
      return null;
  }

  public XhtmlNode addText(int index, String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content == null)
      throw new Error("Content cannot be null");

    XhtmlNode node = new XhtmlNode(NodeType.Text);
    node.setContent(content);
    childNodes.add(index, node);
    return node;
  }

  public boolean allChildrenAreText()
  {
    boolean res = true;
    for (XhtmlNode n : childNodes)
      res = res && n.getNodeType() == NodeType.Text;
    return res;
  }

  public XhtmlNode getElement(String name) {
    for (XhtmlNode n : childNodes)
      if (n.getNodeType() == NodeType.Element && name.equals(n.getName())) 
        return n;
    return null;
  }

  public XhtmlNode getFirstElement() {
    for (XhtmlNode n : childNodes)
      if (n.getNodeType() == NodeType.Element) 
        return n;
    return null;
  }

  public String allText() {
    if (childNodes == null || childNodes.isEmpty())
      return getContent();
    
    StringBuilder b = new StringBuilder();
    for (XhtmlNode n : childNodes)
      if (n.getNodeType() == NodeType.Text)
        b.append(n.getContent());
      else if (n.getNodeType() == NodeType.Element)
        b.append(n.allText());
    return b.toString();
  }

  public XhtmlNode attribute(String name, String value) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (name == null)
      throw new Error("name is null");
    if (value == null)
      throw new Error("value is null");
    attributes.put(name, value);
    return this;
  }

  public boolean hasAttribute(String name) {
    return getAttributes().containsKey(name);
  }

  public String getAttribute(String name) {
    return getAttributes().get(name);
  }

  public XhtmlNode setAttribute(String name, String value) {
    if (nodeType != NodeType.Element) {
      throw new Error("Attempt to set an attribute on something that is not an element");
    }
    getAttributes().put(name, value);
    return this;    
  }

  public XhtmlNode copy() {
    XhtmlNode dst = new XhtmlNode(nodeType);
    dst.name = name;
    for (String n : attributes.keySet()) {
      dst.attributes.put(n, attributes.get(n));
    }
    for (XhtmlNode n : childNodes)
      dst.childNodes.add(n.copy());
    dst.content = content;
    return dst;
  }

  @Override
  public boolean isEmpty() {
    return (childNodes == null || childNodes.isEmpty()) && content == null;
  }

  public boolean equalsDeep(XhtmlNode other) {
    if (other == null) {
      return false;
    }

    if (!(nodeType == other.nodeType) || !compare(name, other.name) || !compare(content, other.content))
      return false;
    if (attributes.size() != other.attributes.size())
      return false;
    for (String an : attributes.keySet())
      if (!attributes.get(an).equals(other.attributes.get(an)))
        return false;
    if (childNodes.size() != other.childNodes.size())
      return false;
    for (int i = 0; i < childNodes.size(); i++) {
      if (!compareDeep(childNodes.get(i), other.childNodes.get(i)))
        return false;
    }
    return true;
  }

  private boolean compare(String s1, String s2) {
    if (s1 == null && s2 == null)
      return true;
    if (s1 == null || s2 == null)
      return false;
    return s1.equals(s2);
  }

  private static boolean compareDeep(XhtmlNode e1, XhtmlNode e2) {
    if (e1 == null && e2 == null)
      return true;
    if (e1 == null || e2 == null)
      return false;
    return e1.equalsDeep(e2);
  }

  public String getNsDecl() {
    for (String an : attributes.keySet()) {
      if (an.equals("xmlns")) {
        return attributes.get(an);
      }
    }
    return null;
  }


  public Boolean getEmptyExpanded() {
    return emptyExpanded;
  }

  public boolean hasEmptyExpanded() {
    return emptyExpanded != null;
  }

  public void setEmptyExpanded(Boolean emptyExpanded) {
    this.emptyExpanded = emptyExpanded;
  }


  @Override
  public String getValueAsString() {
    if (isEmpty()) {
      return null;
    }
    try {
      String retVal = new XhtmlComposer(XhtmlComposer.XML).compose(this);
      retVal = XhtmlDt.preprocessXhtmlNamespaceDeclaration(retVal);
      return retVal;
    } catch (Exception e) {
      // TODO: composer shouldn't throw exception like this
      throw new RuntimeException(e);
    }
  }

  @Override
  public void setValueAsString(String theValue) throws IllegalArgumentException {
    this.attributes = null;
    this.childNodes = null;
    this.content = null;
    this.name = null;
    this.nodeType= null;
    if (theValue == null || theValue.length() == 0) {
      return;
    }

    String val = theValue.trim();

    if (!val.startsWith("<")) {
      val = "<div" + DECL_XMLNS +">" + val + "</div>";
    }
    if (val.startsWith("<?") && val.endsWith("?>")) {
      return;
    }

    val = XhtmlDt.preprocessXhtmlNamespaceDeclaration(val);

    try {
      XhtmlDocument fragment = new XhtmlParser().parse(val, "div");
      this.attributes = fragment.getAttributes();
      this.childNodes = fragment.getChildNodes();
      // Strip the <? .. ?> declaration if one was present
      if (childNodes.size() > 0 && childNodes.get(0) != null && childNodes.get(0).getNodeType() == NodeType.Instruction) {
        childNodes.remove(0);
      }
      this.content = fragment.getContent();
      this.name = fragment.getName();
      this.nodeType= fragment.getNodeType();
    } catch (Exception e) {
      // TODO: composer shouldn't throw exception like this
      throw new RuntimeException(e);
    }

  }

  public XhtmlNode getElementByIndex(int i) {
    int c = 0;
    for (XhtmlNode n : childNodes)
      if (n.getNodeType() == NodeType.Element) {
        if (c == i)
          return n;
        else
          c++;
      }
    return null;
  }

  @Override
  public String getValue() {
    return getValueAsString();
  }

  public boolean hasValue() {
    return isNotBlank(getValueAsString());
  }

  @Override
  public XhtmlNode setValue(String theValue) throws IllegalArgumentException {
    setValueAsString(theValue);
    return this;
  }

  /**
   * Returns false
   */
  public boolean hasFormatComment() {
    return false;
  }

  /**
   * NOT SUPPORTED - Throws {@link UnsupportedOperationException}
   */
  public List<String> getFormatCommentsPre() {
    throw new UnsupportedOperationException();
  }

  /**
   * NOT SUPPORTED - Throws {@link UnsupportedOperationException}
   */
  public List<String> getFormatCommentsPost() {
    throw new UnsupportedOperationException();
  }

  /**
   * NOT SUPPORTED - Throws {@link UnsupportedOperationException}
   */
  public Object getUserData(String theName) {
    throw new UnsupportedOperationException();
  }

  /**
   * NOT SUPPORTED - Throws {@link UnsupportedOperationException}
   */
  public void setUserData(String theName, Object theValue) {
    throw new UnsupportedOperationException();
  }


  public Location getLocation() {
    return location;
  }


  public void setLocation(Location location) {
    this.location = location;
  }

  // xhtml easy adders -----------------------------------------------
  public XhtmlNode h1() {
    return addTag("h1");
  }
  
  public XhtmlNode h2() {
    return addTag("h2");
  }
  
  public XhtmlNode h(int level) {
    if (level < 1 || level > 6) {
      throw new FHIRException("Illegal Header level "+level);
    }
    return addTag("h"+Integer.toString(level));
  }
  
  public XhtmlNode h3() {
    return addTag("h3");
  }
  
  public XhtmlNode h4() {
    return addTag("h4");
  }
  
  public XhtmlNode table(String clss) {
    XhtmlNode res = addTag("table");
    if (!Utilities.noString(clss))
      res.setAttribute("class", clss);
    return res;
  }
  
  public XhtmlNode tr() {
    return addTag("tr");
  }
  
  public XhtmlNode th() {
    return addTag("th");
  }
  
  public XhtmlNode td() {
    return addTag("td");
  }
  
  public XhtmlNode td(String clss) {
    return addTag("td").attribute("class", clss);
  }
  
  public XhtmlNode colspan(String n) {
    return setAttribute("colspan", n);
  }
  
  public XhtmlNode div() {
    return addTag("div");
  }

  public XhtmlNode para() {
    return addTag("p");
  }

  public XhtmlNode pre() {
    return addTag("pre");
  }

  public XhtmlNode pre(String clss) {
    return addTag("pre").setAttribute("class", clss);
  }

  public void br() {
    addTag("br");
  }

  public void hr() {
    addTag("hr");
  }

  public XhtmlNode ul() {
    return addTag("ul");
  }

  public XhtmlNode li() {
    return addTag("li");
  }

  public XhtmlNode b() {
    return addTag("b");
  }

  public XhtmlNode i() {
    return addTag("i");
  }
  
  public XhtmlNode tx(String cnt) {
    return addText(cnt);
  }

  // differs from tx because it returns the owner node, not the created text
  public XhtmlNode txN(String cnt) {
    addText(cnt);
    return this;
  }

  public XhtmlNode tx(int cnt) {
    return addText(Integer.toString(cnt));
  }

  public XhtmlNode ah(String href) {
    return addTag("a").attribute("href", href);
  }

  public XhtmlNode ah(String href, String title) {
    return addTag("a").attribute("href", href).attribute("title", title);
  }

  public XhtmlNode img(String src, String alt) {
    return addTag("img").attribute("src", src).attribute("alt", alt);    
  }

  public XhtmlNode img(String src, String alt, String title) {
    return addTag("img").attribute("src", src).attribute("alt", alt).attribute("title", title);    
  }

  public XhtmlNode an(String href) {
    return an(href, " ");
  }
  
  public XhtmlNode an(String href, String tx) {
    XhtmlNode a = addTag("a").attribute("name", href);
    a.tx(tx);
    return a;
  }

  public XhtmlNode span(String style, String title) {
    XhtmlNode res = addTag("span");
    if (!Utilities.noString(style))
      res.attribute("style", style);
    if (!Utilities.noString(title))
      res.attribute("title", title);
    return res;
  }


  public XhtmlNode code(String text) {
    return addTag("code").tx(text);
  }

  public XhtmlNode code() {
    return addTag("code");
  }


  public XhtmlNode blockquote() {
    return addTag("blockquote");
  }


  @Override
  public String toString() {
    switch (nodeType) {
    case Document: 
    case Element:
      try {
        return new XhtmlComposer(XhtmlComposer.HTML).compose(this);
      } catch (IOException e) {
        return super.toString();
      }
    case Text:
      return this.content;
    case Comment:
      return "<!-- "+this.content+" -->";
    case DocType: 
      return "<? "+this.content+" />";
    case Instruction:
      return "<? "+this.content+" />";
    }
    return super.toString();
  }


  public XhtmlNode getNextElement(XhtmlNode c) {
    boolean f = false;
    for (XhtmlNode n : childNodes) {
      if (n == c)
        f = true;
      else if (f && n.getNodeType() == NodeType.Element) 
        return n;
    }
    return null;
  }


  public XhtmlNode notPretty() {
    notPretty = true;
    return this;
  }


  public boolean isNoPretty() {
    return notPretty;
  }


  public XhtmlNode style(String style) {
    if (hasAttribute("style")) {
      setAttribute("style", getAttribute("style")+"; "+style);
    } else {
      setAttribute("style", style);
    }
    return this;
  }


  public XhtmlNode nbsp() {
    addText(NBSP);
    return this;
  }


  public XhtmlNode para(String text) {
    XhtmlNode p = para();
    p.addText(text);
    return p;
    
  }

  public XhtmlNode add(XhtmlNode n) {
    getChildNodes().add(n);
    return this;
  }


  public XhtmlNode addChildren(List<XhtmlNode> children) {
    getChildNodes().addAll(children);
    return this;
  }

  public XhtmlNode addChildren(XhtmlNode x) {
    if (x != null) {
      getChildNodes().addAll(x.getChildNodes());
    }
    return this;
  }


  public XhtmlNode input(String name, String type, String placeholder, int size) {
    XhtmlNode p = new XhtmlNode(NodeType.Element, "input");
    p.attribute("name", name);
    p.attribute("type", type);
    p.attribute("placeholder", placeholder);
    p.attribute("size", Integer.toString(size));
    getChildNodes().add(p);
    return p;
  }

  public XhtmlNode select(String name) {
    XhtmlNode p = new XhtmlNode(NodeType.Element, "select");
    p.attribute("name", name);
    p.attribute("size", "1");
    getChildNodes().add(p);
    return p;
  }
  
  public XhtmlNode option(String value, String text, boolean selected) {
    XhtmlNode p = new XhtmlNode(NodeType.Element, "option");
    p.attribute("value", value);
    p.attribute("selected", Boolean.toString(selected));
    p.tx(text);
    getChildNodes().add(p);
    return p;
  }


  public XhtmlNode remove(XhtmlNode x) {
    getChildNodes().remove(x);
    return this;
    
  }


  public void clear() {
    getChildNodes().clear();
    
  }


  public XhtmlNode backgroundColor(String color) {
    style("background-color: "+color);
    return this;
  }


  public boolean isPara() {
    return "p".equals(name);
  }


  public void markdown(String md, String source) throws IOException {
   if (md != null) {
      String s = new MarkDownProcessor(Dialect.COMMON_MARK).process(md, source);
      XhtmlParser p = new XhtmlParser();
      XhtmlNode m;
      try {
        m = p.parse("<div>"+s+"</div>", "div");
      } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
        throw new FHIRFormatError(e.getMessage(), e);
      }
      getChildNodes().addAll(m.getChildNodes());
   }        
  }

  public void innerHTML(String html) throws IOException {
    if (html != null) {
       XhtmlParser p = new XhtmlParser();
       XhtmlNode m;
       try {
         m = p.parse("<div>"+html+"</div>", "div");
       } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
         throw new FHIRFormatError(e.getMessage(), e);
       }
       getChildNodes().addAll(m.getChildNodes());
    }        
   }



  public XhtmlNode sep(String separator) {
    // if there's already text, add the separator. otherwise, we'll add it next time
    if (!seperated) {
      seperated = true;
      return this;
    }
    return tx(separator);
  }



  

  
  
}