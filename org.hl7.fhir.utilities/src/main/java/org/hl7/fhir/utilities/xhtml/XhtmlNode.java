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
import java.util.Set;

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

  private static boolean checkParaGeneral = false;
  private boolean checkParaTree = false;
  
  public static final String NBSP = Character.toString((char)0xa0);
  public static final String XMLNS = "http://www.w3.org/1999/xhtml";
  private static final String DECL_XMLNS = " xmlns=\""+XMLNS+"\"";
  private static final String NS_SVG = "http://www.w3.org/2000/svg";
  private static final String NS_XLINK = "http://www.w3.org/1999/xlink";

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
    checkParaTree = checkParaGeneral;
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
    if (checkParaTree && "p".equals(name)) {
      isInPara = true;
    }
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
  
  private XhtmlNode makeTag(String name) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document))  {
      throw new Error("Wrong node type - node is "+nodeType.toString()+" ('"+getName()+"/"+getContent()+"')");
    }
//  if (inPara && name.equals("p")) {
//  throw new FHIRException("nested Para");
//}
//if (inLink && name.equals("a")) {
//  throw new FHIRException("Nested Link");
//}
    XhtmlNode node = new XhtmlNode(NodeType.Element);
    node.setName(name);
    if (getChildNodes().isInPara() || name.equals("p")) {
      node.getChildNodes().setInPara(true);
    }
    if (getChildNodes().isInLink() || name.equals("a")) {
      node.getChildNodes().setInLink(true);
    }
    if (Utilities.existsInList(name, "b", "big", "i", "small", "tt", "abbr", "acronym", "cite", "code", "dfn", "em", "kbd", "strong", "samp", "var", "a", "bdo", "br", "img", "map", "object", "q", "script", "span", "sub", "sup", " button", "input", "label", "select", "textarea", "style", "script")) {
      node.notPretty();
    }        
    return node;
  }
  
  public XhtmlNode addTag(String name) {
    XhtmlNode node = makeTag(name);
    addChildNode(node);
    return node;
  }
  
  public XhtmlNode addTag(String name, XhtmlNode insertionPoint) {
    XhtmlNode node = makeTag(name);
    if (insertionPoint != null) {
      addChildNode(getChildNodes().indexOf(insertionPoint), node);
    } else {
      addChildNode(node);
    }
    return node;
  }
  
  

  public XhtmlNode addTag(int index, String name) {
    XhtmlNode node = makeTag(name);
    addChildNode(index, node);
    return node;
  }


  public XhtmlNode addComment(String content) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.Comment);
    node.setContent(content);
    addChildNode(node);
    return node;
  }

  public XhtmlNode addDocType(String content) {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.DocType);
    node.setContent(content);
    addChildNode(node);
    return node;
  }

  public XhtmlNode addInstruction(String content) {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode(NodeType.Instruction);
    node.setContent(content);
    addChildNode(node);
    return node;
  }
  
  public XhtmlNode addText(String content) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content != null) {
      XhtmlNode node = new XhtmlNode(NodeType.Text);
      node.setContent(content);
      addChildNode(node);
      return node;
    } else {
      return null;
    }
  }

  public void addTextWithLineBreaks(String content) {
    if (content != null) {
      boolean first = true;
      for (String line : content.split("\\r?\\n")) {
        if (first) {
          first = false;
        } else {
          br();
        }
        tx(line);
      }
    }
  }

  public XhtmlNode addText(int index, String content) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content == null)
      throw new Error("Content cannot be null");

    XhtmlNode node = new XhtmlNode(NodeType.Text);
    node.setContent(content);
    addChildNode(index, node);
    return node;
  }

  public boolean allChildrenAreText() {
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
        if (!Utilities.existsInList(n.getName(), "img")) {
          b.append(n.allText());          
        } else if (n.hasAttribute("alt")) {
          b.append(n.getAttribute("alt"));
        } else {
          b.append("[image]");
        }
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

  public XhtmlNode attributeNN(String name, String value) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (name == null)
      throw new Error("name is null");
    if (value != null) {
      getAttributes().put(name, value);
    }
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
        dst.addChildNode(n.copy());
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
  private boolean isInPara;
  
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
    if (nodeType == null) {
      return super.toString();
    }
    switch (nodeType) {
    case Document: 
    case Element:
      return new XhtmlComposer(XhtmlComposer.HTML).compose(this);
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
    addChildNode(n);
    return this;
  }


  public XhtmlNode addChildren(List<XhtmlNode> children) {
    addChildNodes(children);
    return this;
  }

  public XhtmlNode addChildren(XhtmlNode x) {
    if (x != null) {
      addChildNodes(x.getChildNodes());
    }
    return this;
  }


  public XhtmlNode input(String name, String type, String placeholder, int size) {
    XhtmlNode p = new XhtmlNode(NodeType.Element, "input");
    if (name != null) {
      p.attribute("name", name);
    }
    p.attribute("type", type);
    if (placeholder != null) {
      p.attribute("placeholder", placeholder);
    }
    if (size > 0) {
        p.attribute("size", Integer.toString(size));
    }
    addChildNode(p);
    return p;
  }

  public XhtmlNode select(String name) {
    XhtmlNode p = new XhtmlNode(NodeType.Element, "select");
    p.attribute("name", name);
    p.attribute("size", "1");
    addChildNode(p);
    return p;
  }
  
  public XhtmlNode option(String value, String text, boolean selected) {
    XhtmlNode p = new XhtmlNode(NodeType.Element, "option");
    p.attribute("value", value);
    p.attribute("selected", Boolean.toString(selected));
    p.tx(text);
    addChildNode(p);
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

  public XhtmlNode rowspan(int n) {
    if (n > 1) {
      return setAttribute("rowspan", Integer.toString(n));      
    } else {
      return this;
    }
  }

  @Override
  protected void addChildren(XhtmlNodeList childNodes) {
    this.addChildNodes(childNodes);    
  }


  public XhtmlNode color(String color) {
    return span("color: "+color, null);
  }
  
  public void startScript(String name) {
    if (namedParams != null) {
      throw new Error("Sequence Error - script is already open @ "+name);
    }
    namedParams = new HashMap<>();    
    namedParamValues = new HashMap<>();
  }
  
  public XhtmlNode param(String name) {
    if (namedParams == null) {
      throw new Error("Sequence Error - script is not already open");
    }
    XhtmlNode node = new XhtmlNode(NodeType.Element, "p"); // this node is dead will never appear anywhere, but we are in paragraph mode
    namedParams.put(name, node);
    return node;
  }


  public void paramValue(String name, String value) {
    if (namedParamValues == null) {
      throw new Error("Sequence Error - script is not already open");
    }
    namedParamValues.put(name, value); 
  }

  public void paramValue(String name, int value) {
    if (namedParamValues == null) {
      throw new Error("Sequence Error - script is not already open");
    }
    namedParamValues.put(name, Integer.toString(value)); 
  }

  /**
   * To set up a script, you do the following:
   * 
   * * call startScript - setting up the parameter infrastructure 
   * * define a set of parameters. Parameter values can be provided as string or integer, or:
   * * you can use param(name) to render an arbitrarily complicated html fragment that will be inserted by the script
   * * you can redefine parameters with the same name 
   * * call execScript() to execute the script. You can call this any number of times
   * * call closeScript
   * 
   * The script format is an xhtml fragment that can have any html in it, and also the following tags:
   *   param: <param name="{name}"/> - replace this tag with the named parameter (or delete it if no value)
   *   if: <if test="{condition}"/> - condition is param op value, where value is a string, and op is =, != <, >
   *   
   * @param structure
   * @throws FHIRException
   * @throws IOException
   */
  public void execScript(String structure) throws FHIRException, IOException {
    XhtmlNode script = new XhtmlParser().parseFragment("<div>"+structure+"</div>");
    parseNodes(script.getChildNodes(), this.getChildNodes());
  }

  private void parseNodes(XhtmlNodeList source, XhtmlNodeList dest) {
    for (XhtmlNode n : source) {
      if ("param".equals(n.getName())) {
        XhtmlNode node = namedParams.get(n.getAttribute("name"));
        if (node != null) {
          parseNodes(node.getChildNodes(), dest);
        }
      } else if ("if".equals(n.getName())) {
        String test = n.getAttribute("test");
        if (passesTest(test)) {
          parseNodes(n.getChildNodes(), dest);
        }
      } else {
        dest.add(n);
      }
    }

  }


  public void closeScript() {
    if (namedParams == null) {
      throw new Error("Sequence Error - script is not already open");
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
    XhtmlNode svg = addTag("svg");
    svg.setAttribute("xmlns", NS_SVG);
    svg.setAttribute("xmlns:xlink", NS_XLINK);
    return svg;
  }


  public XhtmlNode path(String value) {
    return addTag("path").attribute("d", value);
    
  }


  public void copyAllContent(XhtmlNode other) {
    addChildNodes(other.getChildNodes());
    getAttributes().putAll(other.getAttributes());
    if (!Utilities.noString(other.getContent())) {
      tx(other.getContent());
    }    
  }

  public boolean isClass(String name) {
    return hasAttribute("class", name);
  }

  public XhtmlNode clss(String name) {
    if (hasAttribute("class")) {
      setAttribute("class", getAttribute("class")+" "+name);      
    } else {
      setAttribute("class", name);
    }
    return this;
  }

  public void styleCells(XhtmlNode x) {
    setUserData("cells", x);    
  }


  public XhtmlNode td(int index) {
    XhtmlNode x = addTag(index, "td");
    XhtmlNode t = (XhtmlNode) getUserData("cells");
    if (t != null) {
      x.copyAllContent(t);
    }
    return x;    
  }
  
  public XhtmlNode td() {
    XhtmlNode x = addTag("td");
    XhtmlNode t = (XhtmlNode) getUserData("cells");
    if (t != null) {
      x.copyAllContent(t);
    }
    return x;
  }

  public XhtmlNode td(int index, String width) {
    XhtmlNode x = addTag(index, "td");
    x.attribute("width", width);
    XhtmlNode t = (XhtmlNode) getUserData("cells");
    if (t != null) {
      x.copyAllContent(t);
    }
    return x;    
  }
  
  public XhtmlNode tdW(int width) {
    XhtmlNode x = addTag("td");
    x.attribute("width", Integer.toString(width));
    XhtmlNode t = (XhtmlNode) getUserData("cells");
    if (t != null) {
      x.copyAllContent(t);
    }
    return x;
  }



  // differs from tx because it returns the owner node, not the created text
  public XhtmlNode txN(String cnt) {
    addText(cnt);
    return this;
  }
  
  public XhtmlNode txOrCode(boolean code, String cnt) {
    if (code) {
      XhtmlNode c = code();
      boolean first = true;
      for (String line : cnt.split("\\r?\\n")) {
        if (first) first = false; else c.br();
        c.tx(line.replace(" ", Character.toString(0xA0)));
      }
    } else {
      addText(cnt);
    }
    return this;
  }


  public XhtmlNode iff(boolean test) {
    if (test) {
      return this;
    } else {
      return new XhtmlNode(NodeType.Element, "span"); // which will never be connected
    }
  }


  public XhtmlNode button(String class_, String title) {
    XhtmlNode btn = addTag("button");
    if (class_ != null) {
      btn.attribute("class", class_);
    }
    if (title != null) {
      btn.attribute("title", title);
    }
    return btn;
  }


  public XhtmlNode head() {
    return addTag("head");
  }
  
  public XhtmlNode body() {
    return addTag("body");
  }
  public XhtmlNode title(String title) {
    return addTag("title").tx(title);
  }
  
  public XhtmlNode link(String rel, String href) {
    return addTag("link").attribute("rel", rel).attribute("href", href);
  }

  public XhtmlNode ahOrNot(String href) {
    if (href == null) {
      return this;
    }
    XhtmlNode x = addTag("a").attribute("href", href);
    return x;
  }

  public XhtmlNode ahOrNot(String href, String title) {
    if (href == null) {
      return addTag("span").attributeNN("title", title);
    } else {
      return addTag("a").attribute("href", href).attributeNN("title", title);
    }
  }


  public void wbr() {
    addTag("wbr");
    
  }
  
  protected int indexOfNode(XhtmlNode node) {
    return getChildNodes().indexOf(node);
  }
  
  public int compareTo(XhtmlNode other) {
    return compare(this, other);
  }

  private static int compare(XhtmlNode base, XhtmlNode other) {
    if (base == null || other == null) {
      return 0;
    } else if (base.getNodeType() != other.getNodeType()) {
      return base.getNodeType().ordinal() - other.getNodeType().ordinal();
    } else switch (base.getNodeType()) {
    case Comment: return base.getContent().compareTo(other.getContent());
    case DocType: return 0;
    case Element:
      int r = base.getName().compareTo(other.getName());
      if (r != 0) {
        return r;
      }
    case Document:
      if (base.getAttributes().size() != other.getAttributes().size()) {
        return base.getAttributes().size() - other.getAttributes().size();
      } else {
        for (String n : base.getAttributes().keySet()) {
          String vb = base.getAttributes().get(n);
          String vo = other.getAttributes().get(n);
          r = vo == null ? -1 : vb.compareTo(vo);
          if (r != 0) {
            return r;
          }
        }
      }
      if (base.getChildNodes().size() != other.getChildNodes().size()) {
        return base.getChildNodes().size() - other.getChildNodes().size();
      } else {
        for (int i = 0; i < base.getChildNodes().size(); i++) {
          r = compare(base, other);
          if (r != 0) {
            return r;
          }
        }
       }
      return 0;
    case Instruction: return 0;
    case Text: return base.getContent().compareTo(other.getContent());
    default: return 0;
    } 
  }


  public void stripAnchorsByName(Set<String> anchors) {
    if (hasChildren()) {
      childNodes.removeIf(n -> "a".equals(n.getName()) && anchors.contains(n.getAttribute("name")));
      for (XhtmlNode c : childNodes) {
        c.stripAnchorsByName(anchors);
      }
    }
  }

  public void addChildNodes(List<XhtmlNode> nodes) {
    for (XhtmlNode node : nodes) {
      addChildNode(node);
    }
  }

  
  public void addChildNode(XhtmlNode node) {
    checkWhenAddingNode(node);
    getChildNodes().add(node);    
  }


  private void checkWhenAddingNode(XhtmlNode node) {
    node.checkParaTree = checkParaTree;
    if (checkParaTree) {
      if (isInPara) {
        if (Utilities.existsInList(node.name, "div",  "blockquote", "table", "ol", "ul", "p")) {
          throw new Error("Error: attempt to add "+node.name+" inside an html paragraph");
        }
        node.isInPara = true;
      } 
    }
  }

  public void addChildNode(int index, XhtmlNode node) {
    checkWhenAddingNode(node);
    getChildNodes().add(index, node);
  }


  public static boolean isCheckParaGeneral() {
    return checkParaGeneral;
  }


  public static void setCheckParaGeneral(boolean checkParaGeneral) {
    XhtmlNode.checkParaGeneral = checkParaGeneral;
  }


  public boolean isCheckParaTree() {
    return checkParaTree;
  }


  public void setCheckParaTree(boolean checkParaTree) {
    this.checkParaTree = checkParaTree;
  }


  public XhtmlNode id(String id) {
    attribute("id", id);
    return this;
  }


  public XhtmlNode supr(String tx) {
    addTag("sup").tx(tx);
    return this;
  }

  // -- SVG functions ------------

  public XhtmlNode svgG(XhtmlNode insertionPoint) {
    return addTag("g", insertionPoint);
  }


  public XhtmlNode svgRect(XhtmlNode insertionPoint) {
    return addTag("rect", insertionPoint);
  }


  public XhtmlNode svgLine(XhtmlNode insertionPoint) {
    return addTag("line", insertionPoint);
  }


  public XhtmlNode svgText(XhtmlNode insertionPoint) {
    return addTag("text", insertionPoint).attribute("text-anchor", "middle"); // cause browsers just do that, but Inkscape doesn't
  }


  public XhtmlNode svgAx(String link) {
    if (link == null) {
      return this;
    }
    var a = addTag("a");
    a.attribute("xlink:href", link);
    return a;
  }


  public XhtmlNode svgTspan() {
    return addTag("tspan");
  }


  public XhtmlNode svgPolygon(XhtmlNode insertionPoint) {
    return addTag("polygon", insertionPoint);
  }


  public XhtmlNode htmlObject(double left, double top, double width, double height) {
    var x = addTag("foreignObject");
    x.attribute("x", Double.toString(left));
    x.attribute("y", Double.toString(top));
    x.attribute("width", Double.toString(width));
    x.attribute("height", Double.toString(height));
    return x;
  }


  public XhtmlNode svgPath(XhtmlNode insertionPoint) {
    var x = addTag("path", insertionPoint);
    return x;
  }


  public boolean hasContent() {
    if (nodeType == NodeType.Text) {
      return content != null && content.trim().length() > 0;
    }
    if (nodeType == NodeType.Element) {
      for (XhtmlNode n : getChildNodes()) {
        if (n.hasContent()) {
          return true;
        }
      }
    }
    return false;
  }

  public String getPathName() {
    if (getName() == null) {
      return getNodeType().toCode();      
    } else {
      return getName();
    }
  }


  public int countByPathName(XhtmlNode node) {
    int count = 0;
    for (XhtmlNode t : getChildNodes()) {
      if (t.getPathName().equals(node.getPathName())) {
        count++;
      }
    }
    return count;
  }

  public int indexByPathName(XhtmlNode node) {
    int count = 0;
    for (XhtmlNode t : getChildNodes()) {
      if (t == node) {
        return count;        
      }
      if (t.getPathName().equals(node.getPathName())) {
        count++;
      }
    }
    return count;
  }

  public void js(String s) {
    XhtmlNode x = addTag("script");
    x.setContent("\r\n"+s+"\r\n");
  }
  public void jsSrc(String s) {
    XhtmlNode x = addTag("script");
    x.setAttribute("src", s);
    x.setContent(" ");
  }
  public void styles(String s) {
    XhtmlNode x = addTag("style");
    x.setContent("\r\n"+s+"\r\n");
  }

}
