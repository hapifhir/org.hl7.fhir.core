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
import org.hl7.fhir.instance.model.api.IBaseXhtml;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.primitive.XhtmlDt;

@ca.uhn.fhir.model.api.annotation.DatatypeDef(name="xhtml")
public class XhtmlNode extends XhtmlFluent implements IBaseXhtml {
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
  protected Map<String, String> attributes;
  protected XhtmlNodeList childNodes;
  private String content;
  private boolean notPretty;
  private boolean seperated;  
  private Boolean emptyExpanded;
  private Map<String, XhtmlNode> namedParams;
  private Map<String, String> namedParamValues;

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

  public boolean hasAttributes() {
    return attributes != null && !attributes.isEmpty();
  }
  
  public Map<String, String> getAttributes() {
    if (attributes == null) {
      attributes = new HashMap<String, String>();
    }
    return attributes;
  }

  public boolean hasChildren() {
    return childNodes != null && !childNodes.isEmpty();
  }


  public XhtmlNodeList getChildNodes() {
    if (childNodes == null) {
      childNodes = new XhtmlNodeList();
    }
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
        if (hasAttributes()) {
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
      }
      if (inPara && Utilities.existsInList(name, "div",  "blockquote", "table", "ol", "ul", "p")) {
        errors.add("Error at "+path+": Found "+name+" inside an html paragraph");
      }
      if (inLink && Utilities.existsInList(name, "a")) {
        errors.add("Error at "+path+": Found an <a> inside an <a> paragraph");
      }

      if (hasChildren()) {
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
    if (getChildNodes().isInPara() || name.equals("p")) {
      node.getChildNodes().setInPara(true);
    }
    if (getChildNodes().isInLink() || name.equals("a")) {
      node.getChildNodes().setInLink(true);
    }
    getChildNodes().add(node);
    if (Utilities.existsInList(name, "b", "big", "i", "small", "tt", "abbr", "acronym", "cite", "code", "dfn", "em", "kbd", "strong", "samp", "var", "a", "bdo", "br", "img", "map", "object", "q", "script", "span", "sub", "sup", " button", "input", "label", "select", "textarea")) {
      node.notPretty();
    }
    return node;
  }
  
  
  

  public XhtmlNode addTag(int index, String name)
  {

    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type. is "+nodeType.toString());
    XhtmlNode node = new XhtmlNode(NodeType.Element);
    if (getChildNodes().isInPara() || name.equals("p")) {
      node.getChildNodes().setInPara(true);
    }
    if (getChildNodes().isInLink() || name.equals("a")) {
      node.getChildNodes().setInLink(true);
    }
    node.setName(name);
    getChildNodes().add(index, node);
    return node;
  }

  public XhtmlNode addComment(String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.Comment);
    node.setContent(content);
    getChildNodes().add(node);
    return node;
  }

  public XhtmlNode addDocType(String content)
  {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.DocType);
    node.setContent(content);
    getChildNodes().add(node);
    return node;
  }

  public XhtmlNode addInstruction(String content)
  {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.Instruction);
    node.setContent(content);
    getChildNodes().add(node);
    return node;
  }
  public XhtmlNode addText(String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content != null) {
      XhtmlNode node = new XhtmlNode(NodeType.Text);
      node.setContent(content);
      getChildNodes().add(node);
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
    getChildNodes().add(index, node);
    return node;
  }

  public boolean allChildrenAreText()
  {
    boolean res = true;
    if (hasChildren()) {
      for (XhtmlNode n : childNodes)
        res = res && n.getNodeType() == NodeType.Text;
    }
    return res;
  }

  public XhtmlNode getElement(String name) {
    if (hasChildren()) {
      for (XhtmlNode n : childNodes)
        if (n.getNodeType() == NodeType.Element && name.equals(n.getName())) 
          return n;
    }
    return null;
  }

  public XhtmlNode getFirstElement() {
    if (hasChildren()) {
      for (XhtmlNode n : childNodes)
        if (n.getNodeType() == NodeType.Element) 
          return n;
    }
    return null;
  }

  public String allText() {
    if (!hasChildren()) {
      if (getContent() == null) {
        return "";
      } else {
        return getContent();
      }
    }
    
    StringBuilder b = new StringBuilder();
    for (XhtmlNode n : childNodes) {
      if (n.getNodeType() == NodeType.Element && Utilities.existsInList(n.getName(), "li")) {
        b.append("* ");
      }
      if (n.getNodeType() == NodeType.Text) {
        if (n.getContent() != null) {
          b.append(n.getContent());
        }
      } 
      if (n.getNodeType() == NodeType.Element) {
        b.append(n.allText());
        if (Utilities.existsInList(n.getName(), "p", "div", "tr", "th", "ul", "ol", "li", "h1", "h2", "h3", "h4", "h5", "h6")) {
          b.append("\r\n");
        } else if (Utilities.existsInList(n.getName(), "th", "td", "span")) {
          b.append(" ");
        }
      }
    }
    return b.toString();
  }

  public XhtmlNode attribute(String name, String value) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (name == null)
      throw new Error("name is null");
    if (value == null)
      throw new Error("value is null");
    getAttributes().put(name, value);
    return this;
  }

  public boolean hasAttribute(String name) {
    return hasAttributes() && getAttributes().containsKey(name);
  }

  public boolean hasAttribute(String name, String value) {
    return hasAttributes() && getAttributes().containsKey(name) && value.equals(getAttributes().get(name));
  }

  public String getAttribute(String name) {
    return hasAttributes() ? getAttributes().get(name) : null;
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
    if (hasAttributes()) {
      for (String n : attributes.keySet()) {
        dst.getAttributes().put(n, attributes.get(n));
      }
    }
    if (hasChildren()) {
      for (XhtmlNode n : childNodes)
        dst.getChildNodes().add(n.copy());
    }
    dst.content = content;
    return dst;
  }

  @Override
  public boolean isEmpty() {
    return !hasChildren() && content == null;
  }

  public boolean equalsDeep(XhtmlNode other) {
    if (other == null) {
      return false;
    }

    if (!(nodeType == other.nodeType) || !compare(name, other.name) || !compare(content, other.content))
      return false;
    if (hasAttributes() != other.hasAttributes()) {
      return false;
    }
    if (hasAttributes()) {
      if (attributes.size() != other.attributes.size())
        return false;
      for (String an : attributes.keySet())
        if (!attributes.get(an).equals(other.attributes.get(an)))
          return false;
    }
    if (hasChildren() != other.hasChildren()) {
      return false;
    }
    if (hasChildren()) {
      if (childNodes.size() != other.childNodes.size())
        return false;
      for (int i = 0; i < childNodes.size(); i++) {
        if (!compareDeep(childNodes.get(i), other.childNodes.get(i)))
          return false;
      }
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
    if (hasAttributes()) {
      for (String an : attributes.keySet()) {
        if (an.equals("xmlns")) {
          return attributes.get(an);
        }
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
      // Skip the <? .. ?> declaration if one was present
      XhtmlNodeList nodes = fragment.getChildNodes();
      XhtmlNode root = nodes.get((nodes.size() > 0 && nodes.get(0) != null && nodes.get(0).getNodeType() == NodeType.Instruction)  ? 1 : 0);
      this.attributes = root.attributes;
      this.childNodes = root.childNodes;
      this.content = root.getContent();
      this.name = root.getName();
      this.nodeType= root.getNodeType();
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

  private Map<String, Object> userData;
  
  public Object getUserData(String theName) {
    if (hasUserData(theName)) {
      return userData.get(theName);
    } else {
      return null;
    }
  }

  public boolean hasUserData(String theName) {
    return userData != null && userData.containsKey(theName);
  }

  public void setUserData(String theName, Object theValue) {
    if (userData == null) {
      userData = new HashMap<>();
    }
    userData.put(theName, theValue);
  }


  public Location getLocation() {
    return location;
  }


  public void setLocation(Location location) {
    this.location = location;
  }

  // xhtml easy adders -----------------------------------------------
  

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

  public XhtmlNode sep(String separator) {
    // if there's already text, add the separator. otherwise, we'll add it next time
    if (!seperated) {
      seperated = true;
      return this;
    }
    return tx(separator);
  }


  // more fluent
  
  public XhtmlNode colspan(String n) {
    return setAttribute("colspan", n);
  }
  
  public XhtmlNode colspan(int n) {
    return setAttribute("colspan", Integer.toString(n));
  }
  
  // differs from tx because it returns the owner node, not the created text
  public XhtmlNode txN(String cnt) {
    addText(cnt);
    return this;
  }


  @Override
  protected void addChildren(XhtmlNodeList childNodes) {
    this.getChildNodes().addAll(childNodes);    
  }


  public XhtmlNode color(String color) {
    return span("color: "+color, null);
  }
  
  public XhtmlNode param(String name) {
    XhtmlNode node = new XhtmlNode(NodeType.Element, "p"); // this node is dead will never appear anywhere, but we are in paragraph mode
    if (namedParams == null) {
      namedParams = new HashMap<>();
    }
    namedParams.put(name, node);
    return node;
  }


  public void paramValue(String name, String value) {
    if (namedParamValues == null) {
      namedParamValues = new HashMap<>();
    }
    namedParamValues.put(name, value); 
  }

  public void paramValue(String name, int value) {
    if (namedParamValues == null) {
      namedParamValues = new HashMap<>();
    }
    namedParamValues.put(name, Integer.toString(value)); 
  }

  public void sentenceForParams(String structure) throws FHIRException, IOException {
    XhtmlNode script = new XhtmlParser().parseFragment("<div>"+structure+"</div>");
    for (XhtmlNode n : script.getChildNodes()) {
      if ("param".equals(n.getName())) {
        XhtmlNode node = namedParams.get(n.getAttribute("name"));
        if (node != null) {
          this.getChildNodes().addAll(node.getChildNodes());
        }
      } else if ("if".equals(n.getName())) {
        String test = n.getAttribute("test");
        if (passesTest(test)) {
          this.getChildNodes().addAll(n.getChildNodes());
        }
      } else {
        this.getChildNodes().add(n);
      }
    }
    namedParams = null;
    namedParamValues = null;
  }


  private boolean passesTest(String test) {
    String[] p = test.split("\\s+");
    if (p.length != 3) {
      return false;
    }
    if (!namedParamValues.containsKey(p[0])) {
      return false;
    }
    String pv = namedParamValues.get(p[0]);
    switch (p[1]) {
    case "=": return p[2].equalsIgnoreCase(pv);
    case "!=": return !p[2].equalsIgnoreCase(pv);
    case "<": return Utilities.isInteger(p[2]) && Utilities.isInteger(pv) && Integer.parseInt(pv) < Integer.parseInt(p[2]);
    case "<=": return Utilities.isInteger(p[2]) && Utilities.isInteger(pv) && Integer.parseInt(pv) <= Integer.parseInt(p[2]);
    case ">": return Utilities.isInteger(p[2]) && Utilities.isInteger(pv) && Integer.parseInt(pv) > Integer.parseInt(p[2]);
    case ">=": return Utilities.isInteger(p[2]) && Utilities.isInteger(pv) && Integer.parseInt(pv) >= Integer.parseInt(p[2]);
    }
    return false;
  }


  public XhtmlNode getElementById(String id) {
    if (id.equals(getAttribute("id"))) {
      return this;
    }
    if (childNodes != null) {
      for (XhtmlNode x : childNodes) {
        XhtmlNode r = x.getElementById(id);
        if (r != null) {
          return r;
        }   
      }
    }
    return null;
  }


  public List<XhtmlNode> getChildren(String name) {
    List<XhtmlNode> res = new ArrayList<>();
    XhtmlNode x = getFirstElement();
    while (x != null) {
      if (name.equals(x.getName())) {
        res.add(x);
      }
      x = getNextElement(x);
    }
    return res;
  }


  public XhtmlNode strikethrough() {
    return addTag("s");
  }


  public XhtmlNode svg() {
    return addTag("svg");
  }


  public XhtmlNode path(String value) {
    return addTag("path").attribute("d", value);
    
  }


  public void copyAllContent(XhtmlNode other) {
    getChildNodes().addAll(other.getChildNodes());
    getAttributes().putAll(other.getAttributes());
    if (!Utilities.noString(other.getContent())) {
      tx(other.getContent());
    }    
  }

  public boolean isClass(String name) {
    return hasAttribute("class", name);
  }


  public void styleCells(XhtmlNode x) {
    setUserData("cells", x);    
  }


  public XhtmlNode td() {
    XhtmlNode x = addTag("td");
    XhtmlNode t = (XhtmlNode) getUserData("cells");
    if (t != null) {
      x.copyAllContent(t);
    }
    return x;
  }
  
}