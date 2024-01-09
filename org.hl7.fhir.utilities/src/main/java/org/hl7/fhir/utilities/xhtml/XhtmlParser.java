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



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.xhtml.XhtmlNode.Location;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XhtmlParser {
  public static final String XHTML_NS = "http://www.w3.org/1999/xhtml";
  private static final char END_OF_CHARS = (char) -1;
  private static final boolean DEBUG = false;

  public class NamespaceNormalizationMap {

    private String defaultNamespace;

    private String originalNamespacePrefix;
    private Map<String, String> map = new HashMap<String, String>();

    public NamespaceNormalizationMap(NamespaceNormalizationMap namespaceMap) {
      if (namespaceMap != null) {
        map.putAll(namespaceMap.map);
        this.defaultNamespace = namespaceMap.defaultNamespace;
        this.originalNamespacePrefix = namespaceMap.originalNamespacePrefix;
      }
    }

    public void setDefaultNamespace(String defaultNamespace) {
      this.defaultNamespace = defaultNamespace;
    }

    /**
     * Keeps track of the original namespace this element had before it was normalized
     *
     * This way, child elements using that prefix will be able recognize that they
     * should use the default namespace.
     *
     * <namespaceA:parentElement xmlns:namespaceA="http://www.somewhere.org/namespaceA">
     *   <namespaceA: childElement/>
     * </namespaceA:parentElement>
     *
     * parentElement's namespaceA would become the default namespace.
     *
     * When normalizing childElement originalNamespacePrefix would be namespaceA,
     * so we would know that childElement should use the default namespace.
     *
     * <parentElement xmlns="http://www.somewhere.org/namespaceA">
     *   <childElement/>
     * </parentElement>
     *
     * @param originalNamespacePrefix
     */
    public void setOriginalNamespacePrefix(String originalNamespacePrefix) {
      this.originalNamespacePrefix = originalNamespacePrefix;
    }

    public void putNamespacePrefix(String prefix, String namespace) {
      map.put(prefix, namespace);
    }

    public String getDefaultNamespace() {
      return defaultNamespace;
    }

    public boolean hasDefaultNamespace() {
      return defaultNamespace != null;
    }

    public String getNamespaceForPrefix(String prefix) {
      if (originalNamespacePrefix != null && originalNamespacePrefix.equals(prefix)) {
        return defaultNamespace;
      }
      return  map.containsKey(prefix) ? map.get(prefix) : "http://error/undefined-namespace";
    }

    public Set<Map.Entry<String, String>> getPrefixNamespaceEntrySet() {
      return map.entrySet();
    }
  }

  public class ElementName {
    private String namespace;
    private String name;

    public ElementName(String src) {
      if (src.contains(":")) {
        namespace = src.substring(0, src.indexOf(":"));
        name = src.substring(src.indexOf(":")+1);
      } else {
        namespace = null;
        name = src;
      }
    }

    public String getName() {
      return name;
    }

    public boolean hasNamespace() {
      return namespace != null;
    }

    public String getNamespace() {
      return namespace;
    }

    @Override
    public String toString() {
      return namespace +"::"+name;
    }

  }

  private Set<String> elements = new HashSet<String>();
  private Set<String> attributes = new HashSet<String>();  
  private Map<String, String> definedEntities = new HashMap<>();
  private Map<String, String> declaredEntities = new HashMap<>();


  public XhtmlParser() {
    super();
    policy = ParserSecurityPolicy.Accept; // for general parsing

    // set up sets
    elements.add("p");
    elements.add("br");
    elements.add("div");
    elements.add("h1");
    elements.add("h2");
    elements.add("h3");
    elements.add("h4");
    elements.add("h5");
    elements.add("h6");
    elements.add("a");
    elements.add("span");
    elements.add("b");
    elements.add("em");
    elements.add("i");
    elements.add("strong");
    elements.add("small");
    elements.add("big");
    elements.add("tt");
    elements.add("small");
    elements.add("dfn");
    elements.add("q");
    elements.add("var");
    elements.add("abbr");
    elements.add("acronym");
    elements.add("cite");
    elements.add("blockquote");
    elements.add("hr");
    elements.add("address");
    elements.add("bdo");
    elements.add("kbd");
    elements.add("q");
    elements.add("sub");
    elements.add("sup");
    elements.add("ul");
    elements.add("ol");
    elements.add("li");
    elements.add("dl");
    elements.add("dt");
    elements.add("dd");
    elements.add("pre");
    elements.add("table");
    elements.add("caption");
    elements.add("colgroup");
    elements.add("col");
    elements.add("thead");
    elements.add("tr");
    elements.add("tfoot");
    elements.add("tbody");
    elements.add("th");
    elements.add("td");
    elements.add("code");
    elements.add("samp");
    elements.add("img");
    elements.add("map");
    elements.add("area");

    attributes.add("title");
    attributes.add("style");
    attributes.add("class");
    attributes.add("id");
    attributes.add("lang");
    attributes.add("xml:lang");
    attributes.add("dir");
    attributes.add("accesskey");
    attributes.add("tabindex");
    // tables:
    attributes.add("span");
    attributes.add("width");
    attributes.add("align");
    attributes.add("valign");
    attributes.add("char");
    attributes.add("charoff");
    attributes.add("abbr");
    attributes.add("axis");
    attributes.add("headers");
    attributes.add("scope");
    attributes.add("rowspan");
    attributes.add("colspan");

    attributes.add("a.href");
    attributes.add("a.name");
    attributes.add("img.src");
    attributes.add("img.border");
    attributes.add("div.xmlns");
    attributes.add("blockquote.cite");
    attributes.add("q.cite");
    attributes.add("a.charset");
    attributes.add("a.type");
    attributes.add("a.name");
    attributes.add("a.href");
    attributes.add("a.hreflang");
    attributes.add("a.rel");
    attributes.add("a.rev");
    attributes.add("a.shape");
    attributes.add("a.coords");
    attributes.add("img.src");
    attributes.add("img.alt");
    attributes.add("img.longdesc");
    attributes.add("img.height");
    attributes.add("img.width");
    attributes.add("img.usemap");
    attributes.add("img.ismap");
    attributes.add("map.name");
    attributes.add("area.shape");
    attributes.add("area.coords");
    attributes.add("area.href");
    attributes.add("area.nohref");
    attributes.add("area.alt");
    attributes.add("table.summary");
    attributes.add("table.width");
    attributes.add("table.border");
    attributes.add("table.frame");
    attributes.add("table.rules");
    attributes.add("table.cellspacing");
    attributes.add("table.cellpadding");

    defineEntities();
  }

  public enum ParserSecurityPolicy {
    Accept,
    Drop,
    Reject
  }

  private ParserSecurityPolicy policy;

  private boolean trimWhitespace;
  private boolean mustBeWellFormed = true;
  private List<StringPair> validationIssues = new ArrayList<>();

  public boolean isTrimWhitespace() {
    return trimWhitespace;
  }

  public void setTrimWhitespace(boolean trimWhitespace) {
    this.trimWhitespace = trimWhitespace;
  }

  public boolean isMustBeWellFormed() {
    return mustBeWellFormed;
  }

  public XhtmlParser setMustBeWellFormed(boolean mustBeWellFormed) {
    this.mustBeWellFormed = mustBeWellFormed;
    return this;
  }

  public boolean isXmlMode() {
    return xmlMode;
  }

  public XhtmlParser setXmlMode(boolean xmlMode) {
    this.xmlMode = xmlMode;
    return this;
  }

  public ParserSecurityPolicy getPolicy() {
    return policy;
  }

  public void setPolicy(ParserSecurityPolicy policy) {
    this.policy = policy; 
  }

  public List<StringPair> getValidationIssues() {
    return validationIssues;
  }

  public XhtmlNode parseHtmlNode(Element node) throws FHIRFormatError  {
    return parseHtmlNode(node, null);
  }

  public XhtmlNode parseHtmlNode(Element node, String defaultNS) throws FHIRFormatError  {
    XhtmlNode res = parseNode(node, defaultNS);
    if (res.getNsDecl() == null)
      res.getAttributes().put("xmlns", XHTML_NS);
    return res;
  }

  private XhtmlNode parseNode(Element node, String defaultNS) throws FHIRFormatError  {
    XhtmlNode res = new XhtmlNode(NodeType.Element);
    res.setName(node.getLocalName());
    defaultNS = checkNS(res, node, defaultNS);
    for (int i = 0; i < node.getAttributes().getLength(); i++) {
      Attr attr = (Attr) node.getAttributes().item(i);
      if (attributeIsOk(res.getName(), attr.getName(), attr.getValue()) && !attr.getLocalName().startsWith("xmlns"))
        res.getAttributes().put(attr.getName(), attr.getValue());
    }
    Node child = node.getFirstChild();
    while (child != null) {
      if (child.getNodeType() == Node.TEXT_NODE) {
        res.addText(child.getTextContent());
      } else if (child.getNodeType() == Node.COMMENT_NODE) {
        res.addComment(child.getTextContent());
      } else if (child.getNodeType() == Node.ELEMENT_NODE) {
        if (elementIsOk(child.getLocalName()))
          res.getChildNodes().add(parseNode((Element) child, defaultNS));
      } else
        throw new FHIRFormatError("Unhandled XHTML feature: "+Integer.toString(child.getNodeType())+descLoc());
      child = child.getNextSibling();
    }
    return res;
  }  

  private String checkNS(XhtmlNode res, Element node, String defaultNS) {
    String ns = node.getNamespaceURI();
    if (ns == null)
      return null;
    if (!ns.equals(defaultNS)) {
      res.getAttributes().put("xmlns", ns);
      return ns;
    }
    return defaultNS;
  }

  public XhtmlNode parseHtmlNode(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError  {
    XhtmlNode res = parseNode(xpp);
    if (res.getNsDecl() == null)
      res.getAttributes().put("xmlns", XHTML_NS);
    return res;

  }
  private XhtmlNode parseNode(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError  {
    XhtmlNode res = new XhtmlNode(NodeType.Element);
    res.setName(xpp.getName());

    for (int i = 0; i < xpp.getAttributeCount(); i++) {
      String an = "xml".equals(xpp.getAttributePrefix(i)) ? "xml:"+xpp.getAttributeName(i) : xpp.getAttributeName(i);
      String av = xpp.getAttributeValue(i);
      if (attributeIsOk(xpp.getName(), an, av)) {
        res.getAttributes().put(an, av);
      }
    }
    int eventType = xpp.next();
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.TEXT) {
        res.addText(xpp.getText());
        xpp.next();
      } else if (eventType == XmlPullParser.COMMENT) {
        res.addComment(xpp.getText());
        xpp.next();
      } else if (eventType == XmlPullParser.START_TAG) {
        if (elementIsOk(xpp.getName()))
          res.getChildNodes().add(parseNode(xpp));
      } else
        throw new FHIRFormatError("Unhandled XHTML feature: "+Integer.toString(eventType)+descLoc());
      eventType = xpp.getEventType();
    }
    xpp.next();
    return res;
  }  

  private boolean attributeIsOk(String elem, String attr, String value) throws FHIRFormatError  {
    boolean ok = attributes.contains(attr) || attributes.contains(elem+"."+attr);
    if (ok)
      return true;
    else switch (policy) {
    case Accept: return true;
    case Drop: return false;
    case Reject: return error(I18nConstants.XHTML_XHTML_ATTRIBUTE_ILLEGAL, elem+"."+attr);
    }

    if ((elem+"."+attr).equals("img.src") && !(value.startsWith("#") || value.startsWith("http:") || value.startsWith("https:"))) {
      switch (policy) {
      case Accept: return true;
      case Drop: return false;
      case Reject: return error(I18nConstants.XHTML_XHTML_Image_Reference_Illegal, value);
      }
    }
    return false;
  }

  private boolean error(String msg, String param) {
    validationIssues.add(new StringPair(msg, param));
    return false;
  }

  private boolean elementIsOk(String name) throws FHIRFormatError  {
    boolean ok = elements.contains(name);
    if (ok)
      return true;
    else switch (policy) {
    case Accept: return true;
    case Drop: return false;
    case Reject: return error(I18nConstants.XHTML_XHTML_ELEMENT_ILLEGAL, name);
    }
    return false;
  }

  private String descLoc() {
    return " at line "+Integer.toString(line)+" column "+Integer.toString(col);
  }

  private Reader rdr;
  private String cache = "";
  private XhtmlNode unwindPoint;
  private String lastText = "";
  private int line = 1;
  private int col = 0;
  private char lastChar;
  private Location lastLoc;
  private boolean xmlMode;

  public XhtmlDocument parse(String source, String entryName) throws FHIRFormatError, IOException  {
    rdr = new StringReader(source);
    return parse(entryName);
  }

  public XhtmlDocument parse(InputStream input, String entryName) throws FHIRFormatError, IOException  {
    rdr = new InputStreamReader(input, StandardCharsets.UTF_8);
    return parse(entryName);
  }

  private XhtmlDocument parse(String entryName) throws FHIRFormatError, IOException 
  {
    XhtmlDocument result = new XhtmlDocument();
    skipWhiteSpaceAndComments(result);
    if (peekChar() != '<')
      throw new FHIRFormatError("Unable to Parse HTML - does not start with tag. Found "+peekChar()+descLoc());
    readChar();
    markLocation();
    ElementName n = new ElementName(readName().toLowerCase());
    if ((entryName != null) && !n.getName().equals(entryName))
      throw new FHIRFormatError("Unable to Parse HTML - starts with '"+n+"' not '"+entryName+"'"+descLoc());
    XhtmlNode root = result.addTag(n.getName());
    root.setLocation(markLocation());
    parseAttributes(root);
    markLocation();
    NamespaceNormalizationMap nsm = normalizeNamespaces(n, root, null, true);
    if (readChar() == '/') {
      if (peekChar() != '>')
        throw new FHIRFormatError("unexpected non-end of element "+n+" "+descLoc());
      readChar();
      root.setEmptyExpanded(false);
    } else {
      unwindPoint = null;
      List<XhtmlNode> p = new ArrayList<>();
      parseElementInner(root, p, nsm, true);
      root.setEmptyExpanded(true);
    }
    return result;
  }

  private Location markLocation() {
    Location res = lastLoc;
    lastLoc = new Location(line, col);
    return res;
  }

  private NamespaceNormalizationMap normalizeNamespaces(ElementName elementName, XhtmlNode node, NamespaceNormalizationMap parentNamespaceMap, boolean nodeIsRoot) {
    // what we do here is strip out any stated namespace attributes, putting them in the namespace map
    // then we figure out what the namespace of this element is, and state it explicitly if it's not the default

    NamespaceNormalizationMap nodeNamespaceMap = new NamespaceNormalizationMap(parentNamespaceMap);
    List<String> namespaceAttributes = new ArrayList<String>();
    for (String an : node.getAttributes().keySet()) {
      if (an.equals("xmlns")) {
        nodeNamespaceMap.setDefaultNamespace(node.getAttribute(an));
        namespaceAttributes.add(an);
      }
      if (an.startsWith("xmlns:")) {
        nodeNamespaceMap.putNamespacePrefix(an.substring(6), node.getAttribute(an));
        namespaceAttributes.add(an);
      }
    }

    for (String s : namespaceAttributes)
      node.getAttributes().remove(s);
    if (elementName.hasNamespace()) {
      String elementNamespace = nodeNamespaceMap.getNamespaceForPrefix(elementName.getNamespace());
      if (!elementNamespace.equals(nodeNamespaceMap.getDefaultNamespace())) {
        node.getAttributes().put("xmlns", elementNamespace);
        nodeNamespaceMap.setDefaultNamespace(elementNamespace);
        nodeNamespaceMap.setOriginalNamespacePrefix(elementName.getNamespace());
        nodeNamespaceMap.map.remove(elementName.getNamespace());
      }
    }
    // Add namespaces back if not defined in parentNamespaceMap (we haven't seen it before, so we need to define it here)
    if (shouldAddXmlnsNamespaceAttribute(parentNamespaceMap, nodeIsRoot, nodeNamespaceMap)) {
      node.getAttributes().put("xmlns", nodeNamespaceMap.getDefaultNamespace());
    }
    for (Map.Entry<String, String> entry : nodeNamespaceMap.getPrefixNamespaceEntrySet() ) {
      if (shouldAddXmlnsNamespacePrefixAttribute(parentNamespaceMap, nodeIsRoot, entry.getKey())) {
        node.getAttributes().put("xmlns:" + entry.getKey(), entry.getValue());
      }
    }

    return nodeNamespaceMap;
  }

  private static boolean shouldAddXmlnsNamespacePrefixAttribute(NamespaceNormalizationMap parentNamespaceMap, boolean nodeIsRoot, String attributeKey) {
    if (nodeIsRoot) {
      return true;
    }
    return  (!parentNamespaceMap.map.containsKey(attributeKey));
  }

  private static boolean shouldAddXmlnsNamespaceAttribute(NamespaceNormalizationMap parentNamespaceMap, boolean nodeIsRoot, NamespaceNormalizationMap nodeNamespaceMap) {
    if (nodeIsRoot) {
      return nodeNamespaceMap.hasDefaultNamespace();
    }
    return nodeNamespaceMap.hasDefaultNamespace() && (parentNamespaceMap == null || !nodeNamespaceMap.getDefaultNamespace().equals(parentNamespaceMap.getDefaultNamespace()));
  }

  private void addTextNode(XhtmlNode node, StringBuilder s)
  {
    String t = isTrimWhitespace() ? s.toString().trim() : s.toString();
    if (t.length() > 0)
    {
      lastText = t;
      // System.out.println(t);
      node.addText(t).setLocation(markLocation());
      s.setLength(0);
    }
  }
  private void parseElementInner(XhtmlNode node, List<XhtmlNode> parents, NamespaceNormalizationMap nsm, boolean escaping) throws FHIRFormatError, IOException
  {
    StringBuilder s = new StringBuilder();
    while (peekChar() != END_OF_CHARS && !parents.contains(unwindPoint) && !(node == unwindPoint))
    {
      if (peekChar() == '<')
      {
        addTextNode(node, s);
        readChar();
        if (peekChar() == '!') {
          String sc = readToCommentEnd();
          // moved the validator
          //          if (sc.startsWith("DOCTYPE"))
          //            throw new FHIRFormatError("Malformed XHTML: Found a DocType declaration, and these are not allowed (XXE security vulnerability protection)");
          node.addComment(sc).setLocation(markLocation());
        } else if (peekChar() == '?')
          node.addComment(readToTagEnd()).setLocation(markLocation());
        else if (peekChar() == '/') {
          readChar();
          ElementName n = new ElementName(readToTagEnd());
          if (node.getName().equals(n.getName()))
            return;
          else
          {
            if (mustBeWellFormed) {
              throw new FHIRFormatError("Malformed XHTML: Found \"</"+n.getName()+">\" expecting \"</"+node.getName()+">\""+descLoc());
            }
            for (int i = parents.size() - 1; i >= 0; i--)
            {
              if (parents.get(i).getName().equals(n))
                unwindPoint = parents.get(i);
            }
            if (unwindPoint != null)
            {
              for (int i = parents.size(); i > 0; i--)
              {
                if (i < parents.size() && parents.get(i) == unwindPoint)
                  return;
                if (i == parents.size())
                {
                  parents.get(i - 1).getChildNodes().addAll(node.getChildNodes());
                  node.getChildNodes().clear();
                }
                else
                {
                  parents.get(i - 1).getChildNodes().addAll(parents.get(i).getChildNodes());
                  parents.get(i).getChildNodes().clear();
                }
              }
            }
          }
        }
        else if (Character.isLetterOrDigit(peekChar()))
        {
          parseElement(node, parents, nsm);
        }
        else
          throw new FHIRFormatError("Unable to Parse HTML - node '" + node.getName() + "' has unexpected content '"+peekChar()+"' (last text = '"+lastText+"'"+descLoc());
      }
      else if (peekChar() == '&') // escaping && 
      {
        parseLiteral(s);
      }
      else
        s.append(readChar());
    }
    addTextNode(node, s);
  }

  private void parseElement(XhtmlNode parent, List<XhtmlNode> parents, NamespaceNormalizationMap namespaceMap) throws IOException, FHIRFormatError
  {
    markLocation();
    ElementName name = new ElementName(readName());
    XhtmlNode node = parent.addTag(name.getName());
    node.setLocation(markLocation());
    List<XhtmlNode> newParents = new ArrayList<XhtmlNode>();
    newParents.addAll(parents);
    newParents.add(parent);
    parseAttributes(node);
    markLocation();
    namespaceMap = normalizeNamespaces(name, node, namespaceMap, false);
    if (readChar() == '/') {
      if (peekChar() != '>')
        throw new FHIRFormatError("unexpected non-end of element "+name+" "+descLoc());
      readChar();
      node.setEmptyExpanded(false);
    } else {
      node.setEmptyExpanded(true);
      parseElementInner(node, newParents, namespaceMap, "script".equals(name.getName()));
    }
  }

  private void parseAttributes(XhtmlNode node) throws FHIRFormatError, IOException 
  {
    while (Character.isWhitespace(peekChar()))
      readChar();
    while (peekChar() != '>' && peekChar() != '/' && peekChar() != END_OF_CHARS)
    {
      String name = readName();
      if (name.length() == 0)
      {
        throw new FHIRFormatError("Unable to read attribute on <"+node.getName()+">"+descLoc());
      }
      while (Character.isWhitespace(peekChar()))
        readChar();

      if (isNameChar(peekChar()) || peekChar() == '>' || peekChar() == '/')
        node.getAttributes().put(name, null);
      else if (peekChar() != '=')
      {
        throw new FHIRFormatError("Unable to read attribute '"+name+"' value on <"+node.getName()+">"+descLoc());
      }
      else
      {
        readChar();
        while (Character.isWhitespace(peekChar()))
          readChar();
        if (peekChar() == '"' || peekChar() == '\'')
          node.getAttributes().put(name, parseAttributeValue(readChar()));
        else
          node.getAttributes().put(name, parseAttributeValue(END_OF_CHARS));
      }
      while (Character.isWhitespace(peekChar()))
        readChar();
    }
  }

  private String parseAttributeValue(char term) throws IOException, FHIRFormatError 
  {
    StringBuilder b = new StringBuilder();
    while (peekChar() != END_OF_CHARS && peekChar() != '>' && (term != END_OF_CHARS || peekChar() != '/') && peekChar() != term)
    {
      if (peekChar() == '&')
      {
        parseLiteral(b);
      }
      else
        b.append(readChar());
    }
    if (peekChar() == term)
      readChar();
    return b.toString();
  }


  private void skipWhiteSpaceAndComments(XhtmlNode focus) throws IOException, FHIRFormatError  {
    while (Character.isWhitespace(peekChar()) || (peekChar() == 0xfeff))
      readChar();
    if (peekChar() == '<')
    {
      char ch = readChar();
      if (peekChar() == '!') {
        readChar();
        if (peekChar() == '-') {
          readChar();
          if (peekChar() == '-') {
            readChar();
            if (peekChar() == ' ')
              readChar();
            focus.addComment(readToCommentEnd());
          } else 
            throw new FHIRFormatError("unrecognised element type <!"+peekChar()+descLoc());
        } else
          focus.addDocType(readToDocTypeEnd());
        skipWhiteSpaceAndComments(focus);
      } else if (peekChar() == '?') {
        String r = readToTagEnd();
        focus.addInstruction(r.substring(1, r.length()-1));
        skipWhiteSpaceAndComments(focus);
      } else 
        pushChar(ch);
    }
  }  

  private void skipWhiteSpace() throws IOException {
    if (trimWhitespace)
      while (Character.isWhitespace(peekChar()) || (peekChar() == 0xfeff))
        readChar();
  }

  private void skipWhiteSpaceInternal() throws IOException {
    while (Character.isWhitespace(peekChar()) || (peekChar() == 0xfeff))
      readChar();
  }

  private void pushChar(char ch) {
    cache = Character.toString(ch)+cache;    
  }

  private char peekChar() throws IOException
  {
    if (cache.length() > 0)
      return cache.charAt(0);
    else if (!rdr.ready())
      return END_OF_CHARS;
    else
    {
      int i = rdr.read();
      if (i == -1)       {
        cache = "";
        return END_OF_CHARS;
      }
      char c = (char) i;
      cache =  Character.toString(c);
      return c;
    }
  }

  private char readChar() throws IOException
  {
    char c;
    if (cache.length() > 0)
    {
      c = cache.charAt(0);
      cache = cache.length() == 1 ? "" : cache.substring(1);
    }
    else if (!rdr.ready())
      c = END_OF_CHARS;
    else
      c = (char)rdr.read();
    if (c == '\r' || c == '\n') {
      if (c == '\r' || lastChar != '\r') {
        line++;
        col = 0;
      }  
      lastChar = c;      
    }      
    col++;
    return c;
  }

  private String readToTagEnd() throws IOException, FHIRFormatError 
  {
    StringBuilder s = new StringBuilder();
    while (peekChar() != '>' && peekChar() != END_OF_CHARS)
      s.append(readChar());
    if (peekChar() != END_OF_CHARS)
    {
      readChar();
      skipWhiteSpace();
    } else if (mustBeWellFormed)
      throw new FHIRFormatError("Unexpected termination of html source"+descLoc());
    return s.toString();
  }

  private String readToDocTypeEnd() throws IOException, FHIRFormatError 
  {
    StringBuilder s = new StringBuilder();

    boolean done = false;
    while (!done) {
      char c = peekChar();
      if (c == '>') {
        done = true;
        readChar();
      } else if (c != END_OF_CHARS)
        s.append(readChar());
      else if (mustBeWellFormed)
        throw new FHIRFormatError("Unexpected termination of html source"+descLoc());
    }
    return s.toString();
  }

  private String readToCommentEnd() throws IOException, FHIRFormatError 
  {
    if (peekChar() == '!')
      readChar();
    StringBuilder s = new StringBuilder();

    boolean simple = true;
    if (peekChar() == '-') {
      readChar();
      simple = peekChar() != '-';
      if (simple)
        s.append('-');
      else
        readChar();
    }

    boolean doctypeEntities = false;

    boolean done = false;
    while (!done) {
      char c = peekChar();
      if (c == '-') {
        readChar();
        if (peekChar() == '-') {
          readChar();
          if (peekChar() == '>') {
            done = true;
          } else {
            pushChar('-');
            s.append("-");
          }
        } else 
          s.append('-');
      } else if (doctypeEntities && c == ']') {
        s.append(readChar());
        if (peekChar() == '>') {
          done = true;
        }
      } else if (simple && peekChar() == '>' && !doctypeEntities) {
        done = true;
      } else if (c == '[' && s.toString().startsWith("DOCTYPE ")) {
        doctypeEntities = true;
        s.append(readChar());
      } else if (c != END_OF_CHARS)
        s.append(readChar());
      else if (mustBeWellFormed)
        throw new FHIRFormatError("Unexpected termination of html source"+descLoc());
    }
    if (peekChar() != END_OF_CHARS)
    {
      readChar();
      skipWhiteSpace();
    }
    if (doctypeEntities) {
      parseDoctypeEntities(s.toString());
    }
    return s.toString();
  }

  private void parseDoctypeEntities(String s) {
    while (s.contains("<!ENTITY")) {
      s = s.substring(s.indexOf("<!ENTITY"));
      int e = s.indexOf(">");
      String ed = s.substring(0, e+1);
      s = s.substring(e+1);
      ed = ed.substring(8).trim();
      e = ed.indexOf(" ");
      String n = ed.substring(0, e).trim();
      ed = ed.substring(e).trim();
      e = ed.indexOf(" "); // SYSTEM
      ed = ed.substring(e).trim();
      String v = ed.substring(0, ed.length()-1);
      declaredEntities.put(n, v);
    }

  }

  private boolean isNameChar(char ch)
  {
    return Character.isLetterOrDigit(ch) || ch == '_' || ch == '-' || ch == ':' || ch == '.';
  }

  private String readName() throws IOException
  {
    StringBuilder s = new StringBuilder();
    while (isNameChar(peekChar()))
      s.append(readChar());
    return s.toString();
  }

  private String readUntil(char ch) throws IOException
  {
    StringBuilder s = new StringBuilder();
    while (peekChar() != 0 && peekChar() != ch)
      s.append(readChar());
    readChar();
    return s.toString();
  }


  private String readUntil(String sc) throws IOException
  {
    StringBuilder s = new StringBuilder();
    while (peekChar() != 0 && sc.indexOf(peekChar()) == -1)
      s.append(readChar());
    readChar();
    return s.toString();
  }

  private void parseLiteral(StringBuilder s) throws IOException, FHIRFormatError {
    // UInt16 w;
    readChar();
    String c = readUntil(";&'\"><");
    if (c.isEmpty())
      throw new FHIRFormatError("Invalid literal declaration following text: " + s);
    else if (c.charAt(0) == '#') {
      if (isInteger(c.substring(1), 10))
        s.append(Character.toString(Integer.parseInt(c.substring(1))));
      else if (c.charAt(1) == 'x' && isInteger(c.substring(2), 16))
        s.append(Character.toString(Integer.parseInt(c.substring(2), 16)));
    } else if (declaredEntities.containsKey(c)) {
      s.append(declaredEntities.get(c));
    } else {
      if (xmlMode) {
        if (!Utilities.existsInList(c, "quot", "amp", "apos", "lt", "gt")) {
          error(I18nConstants.XHTML_XHTML_Entity_Illegal, "&"+c+";");
        }
      }
      if (definedEntities.containsKey("&"+c+";")) {
        s.append(definedEntities.get("&"+c+";"));
        // what's going on here? 
        // the contents that follow already existed, and then I added the routine to populate the entities 
        // which was generated from other code. The code that follows is probably redundant, but I haven't
        // cross checked it. some is welcome to do so... (GG 8-Nov 2021)
      } else if (c.equals("apos"))
        s.append('\'');
      else if (c.equals("quot"))
        s.append('"');
      else if (c.equals("nbsp"))
        s.append(XhtmlNode.NBSP);
      else if (c.equals("amp"))
        s.append('&');
      else if (c.equals("lsquo"))
        s.append((char) 8216); // right single quotation, U+2019 ISOnum 
      else if (c.equals("rsquo"))
        s.append((char) 8217); // right single quotation, U+2019 ISOnum 
      else if (c.equals("gt"))
        s.append('>');
      else if (c.equals("lt"))
        s.append('<');
      else if (c.equals("copy"))
        s.append((char) 169);
      else if (c.equals("reg"))
        s.append((char) 174);
      else if (c.equals("sect"))
        s.append((char) 0xA7);
      else if (c.equals("fnof"))
        s.append((char) 402); // latin small f with hook = function = florin, U+0192 ISOtech -->
      else if (c.equals("Alpha"))
        s.append((char) 913); // greek capital letter alpha, U+0391
      else if (c.equals("Beta"))
        s.append((char) 914); // greek capital letter beta, U+0392
      else if (c.equals("Gamma"))
        s.append((char) 915); // greek capital letter gamma, U+0393 ISOgrk3
      else if (c.equals("Delta"))
        s.append((char) 916); // greek capital letter delta, U+0394 ISOgrk3
      else if (c.equals("Epsilon"))
        s.append((char) 917); // greek capital letter epsilon, U+0395
      else if (c.equals("Zeta"))
        s.append((char) 918); // greek capital letter zeta, U+0396
      else if (c.equals("Eta"))
        s.append((char) 919); // greek capital letter eta, U+0397
      else if (c.equals("Theta"))
        s.append((char) 920); // greek capital letter theta, U+0398 ISOgrk3
      else if (c.equals("Iota"))
        s.append((char) 921); // greek capital letter iota, U+0399
      else if (c.equals("Kappa"))
        s.append((char) 922); // greek capital letter kappa, U+039A
      else if (c.equals("Lambda"))
        s.append((char) 923); // greek capital letter lambda, U+039B ISOgrk3
      else if (c.equals("Mu"))
        s.append((char) 924); // greek capital letter mu, U+039C
      else if (c.equals("Nu"))
        s.append((char) 925); // greek capital letter nu, U+039D
      else if (c.equals("Xi"))
        s.append((char) 926); // greek capital letter xi, U+039E ISOgrk3
      else if (c.equals("Omicron"))
        s.append((char) 927); // greek capital letter omicron, U+039F
      else if (c.equals("Pi"))
        s.append((char) 928); // greek capital letter pi, U+03A0 ISOgrk3
      else if (c.equals("Rho"))
        s.append((char) 929); // greek capital letter rho, U+03A1
      else if (c.equals("Sigma"))
        s.append((char) 931); // greek capital letter sigma, U+03A3 ISOgrk3
      else if (c.equals("Tau"))
        s.append((char) 932); // greek capital letter tau, U+03A4
      else if (c.equals("Upsilon"))
        s.append((char) 933); // greek capital letter upsilon, U+03A5 ISOgrk3
      else if (c.equals("Phi"))
        s.append((char) 934); // greek capital letter phi, U+03A6 ISOgrk3
      else if (c.equals("Chi"))
        s.append((char) 935); // greek capital letter chi, U+03A7
      else if (c.equals("Psi"))
        s.append((char) 936); // greek capital letter psi, U+03A8 ISOgrk3
      else if (c.equals("Omega"))
        s.append((char) 937); // greek capital letter omega, U+03A9 ISOgrk3
      else if (c.equals("alpha"))
        s.append((char) 945); // greek small letter alpha, U+03B1 ISOgrk3
      else if (c.equals("beta"))
        s.append((char) 946); // greek small letter beta, U+03B2 ISOgrk3
      else if (c.equals("gamma"))
        s.append((char) 947); // greek small letter gamma, U+03B3 ISOgrk3
      else if (c.equals("delta"))
        s.append((char) 948); // greek small letter delta, U+03B4 ISOgrk3
      else if (c.equals("epsilon"))
        s.append((char) 949); // greek small letter epsilon, U+03B5 ISOgrk3
      else if (c.equals("zeta"))
        s.append((char) 950); // greek small letter zeta, U+03B6 ISOgrk3
      else if (c.equals("eta"))
        s.append((char) 951); // greek small letter eta, U+03B7 ISOgrk3
      else if (c.equals("theta"))
        s.append((char) 952); // greek small letter theta, U+03B8 ISOgrk3
      else if (c.equals("iota"))
        s.append((char) 953); // greek small letter iota, U+03B9 ISOgrk3
      else if (c.equals("kappa"))
        s.append((char) 954); // greek small letter kappa, U+03BA ISOgrk3
      else if (c.equals("lambda"))
        s.append((char) 955); // greek small letter lambda, U+03BB ISOgrk3
      else if (c.equals("mu"))
        s.append((char) 956); // greek small letter mu, U+03BC ISOgrk3
      else if (c.equals("nu"))
        s.append((char) 957); // greek small letter nu, U+03BD ISOgrk3
      else if (c.equals("xi"))
        s.append((char) 958); // greek small letter xi, U+03BE ISOgrk3
      else if (c.equals("omicron"))
        s.append((char) 959); // greek small letter omicron, U+03BF NEW
      else if (c.equals("pi"))
        s.append((char) 960); // greek small letter pi, U+03C0 ISOgrk3
      else if (c.equals("rho"))
        s.append((char) 961); // greek small letter rho, U+03C1 ISOgrk3
      else if (c.equals("sigmaf"))
        s.append((char) 962); // greek small letter final sigma, U+03C2 ISOgrk3
      else if (c.equals("sigma"))
        s.append((char) 963); // greek small letter sigma, U+03C3 ISOgrk3
      else if (c.equals("tau"))
        s.append((char) 964); // greek small letter tau, U+03C4 ISOgrk3
      else if (c.equals("upsilon"))
        s.append((char) 965); // greek small letter upsilon, U+03C5 ISOgrk3
      else if (c.equals("phi"))
        s.append((char) 966); // greek small letter phi, U+03C6 ISOgrk3
      else if (c.equals("chi"))
        s.append((char) 967); // greek small letter chi, U+03C7 ISOgrk3
      else if (c.equals("psi"))
        s.append((char) 968); // greek small letter psi, U+03C8 ISOgrk3
      else if (c.equals("omega"))
        s.append((char) 969); // greek small letter omega, U+03C9 ISOgrk3
      else if (c.equals("thetasym"))
        s.append((char) 977); // greek small letter theta symbol, U+03D1 NEW
      else if (c.equals("upsih"))
        s.append((char) 978); // greek upsilon with hook symbol, U+03D2 NEW
      else if (c.equals("piv"))
        s.append((char) 982); // greek pi symbol, U+03D6 ISOgrk3
      else if (c.equals("bull"))
        s.append((char) 8226); // bullet = black small circle, U+2022 ISOpub
      else if (c.equals("hellip"))
        s.append((char) 8230); // horizontal ellipsis = three dot leader, U+2026 ISOpub
      else if (c.equals("prime"))
        s.append((char) 8242); // prime = minutes = feet, U+2032 ISOtech
      else if (c.equals("Prime"))
        s.append((char) 8243); // double prime = seconds = inches, U+2033 ISOtech
      else if (c.equals("oline"))
        s.append((char) 8254); // overline = spacing overscore, U+203E NEW
      else if (c.equals("frasl"))
        s.append((char) 8260); // fraction slash, U+2044 NEW
      else if (c.equals("weierp"))
        s.append((char) 8472); // script capital P = power set = Weierstrass p, U+2118 ISOamso
      else if (c.equals("image"))
        s.append((char) 8465); // blackletter capital I = imaginary part, U+2111 ISOamso
      else if (c.equals("real"))
        s.append((char) 8476); // blackletter capital R = real part symbol, U+211C ISOamso
      else if (c.equals("trade"))
        s.append((char) 8482); // trade mark sign, U+2122 ISOnum
      else if (c.equals("alefsym"))
        s.append((char) 8501); // alef symbol = first transfinite cardinal, U+2135 NEW
      else if (c.equals("larr"))
        s.append((char) 8592); // leftwards arrow, U+2190 ISOnum
      else if (c.equals("uarr"))
        s.append((char) 8593); // upwards arrow, U+2191 ISOnum
      else if (c.equals("rarr"))
        s.append((char) 8594); // rightwards arrow, U+2192 ISOnum
      else if (c.equals("darr"))
        s.append((char) 8595); // downwards arrow, U+2193 ISOnum
      else if (c.equals("harr"))
        s.append((char) 8596); // left right arrow, U+2194 ISOamsa
      else if (c.equals("crarr"))
        s.append((char) 8629); // downwards arrow with corner leftwards = carriage return, U+21B5 NEW
      else if (c.equals("lArr"))
        s.append((char) 8656); // leftwards double arrow, U+21D0 ISOtech
      else if (c.equals("uArr"))
        s.append((char) 8657); // upwards double arrow, U+21D1 ISOamsa
      else if (c.equals("rArr"))
        s.append((char) 8658); // rightwards double arrow, U+21D2 ISOtech
      else if (c.equals("dArr"))
        s.append((char) 8659); // downwards double arrow, U+21D3 ISOamsa
      else if (c.equals("hArr"))
        s.append((char) 8660); // left right double arrow, U+21D4 ISOamsa
      else if (c.equals("forall"))
        s.append((char) 8704); // for all, U+2200 ISOtech
      else if (c.equals("part"))
        s.append((char) 8706); // partial differential, U+2202 ISOtech
      else if (c.equals("exist"))
        s.append((char) 8707); // there exists, U+2203 ISOtech
      else if (c.equals("empty"))
        s.append((char) 8709); // empty set = null set = diameter, U+2205 ISOamso
      else if (c.equals("nabla"))
        s.append((char) 8711); // nabla = backward difference, U+2207 ISOtech
      else if (c.equals("isin"))
        s.append((char) 8712); // element of, U+2208 ISOtech
      else if (c.equals("notin"))
        s.append((char) 8713); // not an element of, U+2209 ISOtech
      else if (c.equals("ni"))
        s.append((char) 8715); // contains as member, U+220B ISOtech
      else if (c.equals("prod"))
        s.append((char) 8719); // n-ary product = product sign, U+220F ISOamsb
      else if (c.equals("sum"))
        s.append((char) 8721); // n-ary sumation, U+2211 ISOamsb
      else if (c.equals("minus"))
        s.append((char) 8722); // minus sign, U+2212 ISOtech
      else if (c.equals("lowast"))
        s.append((char) 8727); // asterisk operator, U+2217 ISOtech
      else if (c.equals("radic"))
        s.append((char) 8730); // square root = radical sign, U+221A ISOtech
      else if (c.equals("prop"))
        s.append((char) 8733); // proportional to, U+221D ISOtech
      else if (c.equals("infin"))
        s.append((char) 8734); // infinity, U+221E ISOtech -->
      else if (c.equals("ang"))
        s.append((char) 8736); // angle, U+2220 ISOamso
      else if (c.equals("and"))
        s.append((char) 8743); // logical and = wedge, U+2227 ISOtech
      else if (c.equals("or"))
        s.append((char) 8744); // logical or = vee, U+2228 ISOtech
      else if (c.equals("cap"))
        s.append((char) 8745); // intersection = cap, U+2229 ISOtech
      else if (c.equals("cup"))
        s.append((char) 8746); // union = cup, U+222A ISOtech
      else if (c.equals("int"))
        s.append((char) 8747); // integral, U+222B ISOtech
      else if (c.equals("there4"))
        s.append((char) 8756); // therefore, U+2234 ISOtech
      else if (c.equals("sim"))
        s.append((char) 8764); // tilde operator = varies with = similar t U+223C ISOtech
      else if (c.equals("cong"))
        s.append((char) 8773); // approximately equal to, U+2245 ISOtec
      else if (c.equals("asymp"))
        s.append((char) 8776); // almost equal to = asymptotic to, U+2248 ISOamsr
      else if (c.equals("ne"))
        s.append((char) 8800); // not equal to, U+2260 ISOtech
      else if (c.equals("equiv"))
        s.append((char) 8801); // identical to, U+2261 ISOtech
      else if (c.equals("le"))
        s.append((char) 8804); // less-than or equal to, U+2264 ISOtech
      else if (c.equals("ge"))
        s.append((char) 8805); // greater-than or equal to, U+2265 ISOtech
      else if (c.equals("sub"))
        s.append((char) 8834); // subset of, U+2282 ISOtech
      else if (c.equals("sup"))
        s.append((char) 8835); // superset of, U+2283 ISOtech
      else if (c.equals("nsub"))
        s.append((char) 8836); // not a subset of, U+2284 ISOamsn
      else if (c.equals("sube"))
        s.append((char) 8838); // subset of or equal to, U+2286 ISOtech
      else if (c.equals("supe"))
        s.append((char) 8839); // superset of or equal to, U+2287 ISOtech
      else if (c.equals("oplus"))
        s.append((char) 8853); // circled plus = direct sum, U+2295 ISOamsb
      else if (c.equals("otimes"))
        s.append((char) 8855); // circled times = vector product, U+2297 ISOamsb -->
      else if (c.equals("perp"))
        s.append((char) 8869); // up tack = orthogonal to = perpendicular, U+22A5 ISOtech
      else if (c.equals("sdot"))
        s.append((char) 8901); // dot operator, U+22C5 ISOamsb
      else if (c.equals("lceil"))
        s.append((char) 8968); // left ceiling = apl upstile, U+2308 ISOamsc
      else if (c.equals("rceil"))
        s.append((char) 8969); // right ceiling, U+2309 ISOamsc
      else if (c.equals("lfloor"))
        s.append((char) 8970); // left floor = apl downstile, U+230A ISOamsc
      else if (c.equals("rfloor"))
        s.append((char) 8971); // right floor, U+230B ISOamsc
      else if (c.equals("lang"))
        s.append((char) 9001); // left-pointing angle bracket = bra, U+2329 ISOtech
      else if (c.equals("rang"))
        s.append((char) 9002); // right-pointing angle bracket = ket, U+232A ISOtech
      else if (c.equals("loz"))
        s.append((char) 9674); // lozenge, U+25CA ISOpub
      else if (c.equals("spades"))
        s.append((char) 9824); // black spade suit, U+2660 ISOpub
      else if (c.equals("clubs"))
        s.append((char) 9827); // black club suit = shamrock, U+2663 ISOpub
      else if (c.equals("hearts"))
        s.append((char) 9829); // black heart suit = valentine, U+2665 ISOpub
      else if (c.equals("diams"))
        s.append((char) 9830); // black diamond suit, U+2666 ISOpub --
      else if (c.equals("ndash"))
        s.append((char) 8211); 
      else if (c.equals("mdash"))
        s.append((char) 8212); 
      else if (c.equals("ldquo"))
        s.append((char) 8221); 
      else if (c.equals("rdquo"))
        s.append((char) 201D); 
      else if (c.equals("frac14"))
        s.append((char) 188); 
      else if (!mustBeWellFormed) {
        // we guess that this is an accidentally unescaped &
        s.append("&"+c);
      } else {
        throw new FHIRFormatError("unable to parse character reference '" + c + "'' (last text = '" + lastText + "'" + descLoc());
      }
    }
  }

  private boolean isInteger(String s, int base) {
    try {
      Integer.parseInt(s, base);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public List<XhtmlNode> parseMDFragment(String source) throws IOException, FHIRException  {
    XhtmlNode div = parseFragment( "<div>"+source+"</div>");
    return div.getChildNodes();
  }
  
  public List<XhtmlNode> parseMDFragmentStripParas(String source) throws IOException, FHIRException  {
    XhtmlNode div = parseFragment( "<div>"+source+"</div>");
    List<XhtmlNode> res = new ArrayList<>();
    for (XhtmlNode x : div.getChildNodes()) {
      res.addAll(x.getChildNodes());
    }
    return res;
  }
  
  public XhtmlNode parseFragment(String source) throws IOException, FHIRException  {
    rdr = new StringReader(source);
    try {
      return parseFragment();
    } catch (Exception e) {
      if (DEBUG) {
        TextFile.stringToFile(source, Utilities.path("[tmp]", "html-fail.xhtml"));
      }
      throw e;
    }
  }

  public XhtmlNode parseFragment(InputStream input) throws IOException, FHIRException  {
    rdr = new InputStreamReader(input);
    return parseFragment();
  }

  private XhtmlNode parseFragment() throws IOException, FHIRException 
  {
    skipWhiteSpace();
    if (peekChar() != '<')
      throw new FHIRException("Unable to Parse HTML - does not start with tag. Found "+peekChar()+descLoc());
    readChar();
    if (peekChar() == '?') {
      readToTagEnd();
      skipWhiteSpaceInternal();
      if (peekChar() != '<')
        throw new FHIRException("Unable to Parse HTML - does not start with tag after processing instruction. Found "+peekChar()+descLoc());
      readChar();
    }
    String n = readName().toLowerCase();
    readToTagEnd();
    XhtmlNode result = new XhtmlNode(NodeType.Element);

    int colonIndex = n.indexOf(':');
    if (colonIndex != -1) {
      n = n.substring(colonIndex + 1);
    }

    result.setName(n);
    unwindPoint = null;
    List<XhtmlNode> p = new ArrayList<>();
    parseElementInner(result, p, null, true);

    return result;
  }

  private void defineEntities() {
    definedEntities.put("&AElig;", "\u00C6");
//    definedEntities.put("&AMP;", "\u0026");
    definedEntities.put("&Aacute;", "\u00C1");
    definedEntities.put("&Abreve;", "\u0102");
    definedEntities.put("&Acirc;", "\u00C2");
    definedEntities.put("&Acy;", "\u0410");
    definedEntities.put("&Afr;", "\uD835\uDD04");
    definedEntities.put("&Agrave;", "\u00C0");
    definedEntities.put("&Alpha;", "\u0391");
    definedEntities.put("&Amacr;", "\u0100");
    definedEntities.put("&And;", "\u2A53");
    definedEntities.put("&Aogon;", "\u0104");
    definedEntities.put("&Aopf;", "\uD835\uDD38");
    definedEntities.put("&ApplyFunction;", "\u2061");
    definedEntities.put("&Aring;", "\u00C5");
    definedEntities.put("&Ascr;", "\uD835\uDC9C");
    definedEntities.put("&Assign;", "\u2254");
    definedEntities.put("&Atilde;", "\u00C3");
    definedEntities.put("&Auml;", "\u00C4");
    definedEntities.put("&Backslash;", "\u2216");
    definedEntities.put("&Barv;", "\u2AE7");
    definedEntities.put("&Barwed;", "\u2306");
    definedEntities.put("&Bcy;", "\u0411");
    definedEntities.put("&Because;", "\u2235");
    definedEntities.put("&Bernoullis;", "\u212C");
    definedEntities.put("&Beta;", "\u0392");
    definedEntities.put("&Bfr;", "\uD835\uDD05");
    definedEntities.put("&Bopf;", "\uD835\uDD39");
    definedEntities.put("&Breve;", "\u02D8");
    definedEntities.put("&Bscr;", "\u212C");
    definedEntities.put("&Bumpeq;", "\u224E");
    definedEntities.put("&CHcy;", "\u0427");
    definedEntities.put("&COPY;", "\u00A9");
    definedEntities.put("&Cacute;", "\u0106");
    definedEntities.put("&Cap;", "\u22D2");
    definedEntities.put("&CapitalDifferentialD;", "\u2145");
    definedEntities.put("&Cayleys;", "\u212D");
    definedEntities.put("&Ccaron;", "\u010C");
    definedEntities.put("&Ccedil;", "\u00C7");
    definedEntities.put("&Ccirc;", "\u0108");
    definedEntities.put("&Cconint;", "\u2230");
    definedEntities.put("&Cdot;", "\u010A");
    definedEntities.put("&Cedilla;", "\u00B8");
    definedEntities.put("&CenterDot;", "\u00B7");
    definedEntities.put("&Cfr;", "\u212D");
    definedEntities.put("&Chi;", "\u03A7");
    definedEntities.put("&CircleDot;", "\u2299");
    definedEntities.put("&CircleMinus;", "\u2296");
    definedEntities.put("&CirclePlus;", "\u2295");
    definedEntities.put("&CircleTimes;", "\u2297");
    definedEntities.put("&ClockwiseContourIntegral;", "\u2232");
    definedEntities.put("&CloseCurlyDoubleQuote;", "\u201D");
    definedEntities.put("&CloseCurlyQuote;", "\u2019");
    definedEntities.put("&Colon;", "\u2237");
    definedEntities.put("&Colone;", "\u2A74");
    definedEntities.put("&Congruent;", "\u2261");
    definedEntities.put("&Conint;", "\u222F");
    definedEntities.put("&ContourIntegral;", "\u222E");
    definedEntities.put("&Copf;", "\u2102");
    definedEntities.put("&Coproduct;", "\u2210");
    definedEntities.put("&CounterClockwiseContourIntegral;", "\u2233");
    definedEntities.put("&Cross;", "\u2A2F");
    definedEntities.put("&Cscr;", "\uD835\uDC9E");
    definedEntities.put("&Cup;", "\u22D3");
    definedEntities.put("&CupCap;", "\u224D");
    definedEntities.put("&DD;", "\u2145");
    definedEntities.put("&DDotrahd;", "\u2911");
    definedEntities.put("&DJcy;", "\u0402");
    definedEntities.put("&DScy;", "\u0405");
    definedEntities.put("&DZcy;", "\u040F");
    definedEntities.put("&Dagger;", "\u2021");
    definedEntities.put("&Darr;", "\u21A1");
    definedEntities.put("&Dashv;", "\u2AE4");
    definedEntities.put("&Dcaron;", "\u010E");
    definedEntities.put("&Dcy;", "\u0414");
    definedEntities.put("&Del;", "\u2207");
    definedEntities.put("&Delta;", "\u0394");
    definedEntities.put("&Dfr;", "\uD835\uDD07");
    definedEntities.put("&DiacriticalAcute;", "\u00B4");
    definedEntities.put("&DiacriticalDot;", "\u02D9");
    definedEntities.put("&DiacriticalDoubleAcute;", "\u02DD");
    definedEntities.put("&DiacriticalGrave;", "\u0060");
    definedEntities.put("&DiacriticalTilde;", "\u02DC");
    definedEntities.put("&Diamond;", "\u22C4");
    definedEntities.put("&DifferentialD;", "\u2146");
    definedEntities.put("&Dopf;", "\uD835\uDD3B");
    definedEntities.put("&Dot;", "\u00A8");
    definedEntities.put("&DotDot;", "\u20DC");
    definedEntities.put("&DotEqual;", "\u2250");
    definedEntities.put("&DoubleContourIntegral;", "\u222F");
    definedEntities.put("&DoubleDot;", "\u00A8");
    definedEntities.put("&DoubleDownArrow;", "\u21D3");
    definedEntities.put("&DoubleLeftArrow;", "\u21D0");
    definedEntities.put("&DoubleLeftRightArrow;", "\u21D4");
    definedEntities.put("&DoubleLeftTee;", "\u2AE4");
    definedEntities.put("&DoubleLongLeftArrow;", "\u27F8");
    definedEntities.put("&DoubleLongLeftRightArrow;", "\u27FA");
    definedEntities.put("&DoubleLongRightArrow;", "\u27F9");
    definedEntities.put("&DoubleRightArrow;", "\u21D2");
    definedEntities.put("&DoubleRightTee;", "\u22A8");
    definedEntities.put("&DoubleUpArrow;", "\u21D1");
    definedEntities.put("&DoubleUpDownArrow;", "\u21D5");
    definedEntities.put("&DoubleVerticalBar;", "\u2225");
    definedEntities.put("&DownArrow;", "\u2193");
    definedEntities.put("&DownArrowBar;", "\u2913");
    definedEntities.put("&DownArrowUpArrow;", "\u21F5");
    definedEntities.put("&DownBreve;", "\u0311");
    definedEntities.put("&DownLeftRightVector;", "\u2950");
    definedEntities.put("&DownLeftTeeVector;", "\u295E");
    definedEntities.put("&DownLeftVector;", "\u21BD");
    definedEntities.put("&DownLeftVectorBar;", "\u2956");
    definedEntities.put("&DownRightTeeVector;", "\u295F");
    definedEntities.put("&DownRightVector;", "\u21C1");
    definedEntities.put("&DownRightVectorBar;", "\u2957");
    definedEntities.put("&DownTee;", "\u22A4");
    definedEntities.put("&DownTeeArrow;", "\u21A7");
    definedEntities.put("&Downarrow;", "\u21D3");
    definedEntities.put("&Dscr;", "\uD835\uDC9F");
    definedEntities.put("&Dstrok;", "\u0110");
    definedEntities.put("&ENG;", "\u014A");
    definedEntities.put("&ETH;", "\u00D0");
    definedEntities.put("&Eacute;", "\u00C9");
    definedEntities.put("&Ecaron;", "\u011A");
    definedEntities.put("&Ecirc;", "\u00CA");
    definedEntities.put("&Ecy;", "\u042D");
    definedEntities.put("&Edot;", "\u0116");
    definedEntities.put("&Efr;", "\uD835\uDD08");
    definedEntities.put("&Egrave;", "\u00C8");
    definedEntities.put("&Element;", "\u2208");
    definedEntities.put("&Emacr;", "\u0112");
    definedEntities.put("&EmptySmallSquare;", "\u25FB");
    definedEntities.put("&EmptyVerySmallSquare;", "\u25AB");
    definedEntities.put("&Eogon;", "\u0118");
    definedEntities.put("&Eopf;", "\uD835\uDD3C");
    definedEntities.put("&Epsilon;", "\u0395");
    definedEntities.put("&Equal;", "\u2A75");
    definedEntities.put("&EqualTilde;", "\u2242");
    definedEntities.put("&Equilibrium;", "\u21CC");
    definedEntities.put("&Escr;", "\u2130");
    definedEntities.put("&Esim;", "\u2A73");
    definedEntities.put("&Eta;", "\u0397");
    definedEntities.put("&Euml;", "\u00CB");
    definedEntities.put("&Exists;", "\u2203");
    definedEntities.put("&ExponentialE;", "\u2147");
    definedEntities.put("&Fcy;", "\u0424");
    definedEntities.put("&Ffr;", "\uD835\uDD09");
    definedEntities.put("&FilledSmallSquare;", "\u25FC");
    definedEntities.put("&FilledVerySmallSquare;", "\u25AA");
    definedEntities.put("&Fopf;", "\uD835\uDD3D");
    definedEntities.put("&ForAll;", "\u2200");
    definedEntities.put("&Fouriertrf;", "\u2131");
    definedEntities.put("&Fscr;", "\u2131");
    definedEntities.put("&GJcy;", "\u0403");
//    definedEntities.put("&GT;", "\u003E");
    definedEntities.put("&Gamma;", "\u0393");
    definedEntities.put("&Gammad;", "\u03DC");
    definedEntities.put("&Gbreve;", "\u011E");
    definedEntities.put("&Gcedil;", "\u0122");
    definedEntities.put("&Gcirc;", "\u011C");
    definedEntities.put("&Gcy;", "\u0413");
    definedEntities.put("&Gdot;", "\u0120");
    definedEntities.put("&Gfr;", "\uD835\uDD0A");
    definedEntities.put("&Gg;", "\u22D9");
    definedEntities.put("&Gopf;", "\uD835\uDD3E");
    definedEntities.put("&GreaterEqual;", "\u2265");
    definedEntities.put("&GreaterEqualLess;", "\u22DB");
    definedEntities.put("&GreaterFullEqual;", "\u2267");
    definedEntities.put("&GreaterGreater;", "\u2AA2");
    definedEntities.put("&GreaterLess;", "\u2277");
    definedEntities.put("&GreaterSlantEqual;", "\u2A7E");
    definedEntities.put("&GreaterTilde;", "\u2273");
    definedEntities.put("&Gscr;", "\uD835\uDCA2");
    definedEntities.put("&Gt;", "\u226B");
    definedEntities.put("&HARDcy;", "\u042A");
    definedEntities.put("&Hacek;", "\u02C7");
    definedEntities.put("&Hat;", "\u005E");
    definedEntities.put("&Hcirc;", "\u0124");
    definedEntities.put("&Hfr;", "\u210C");
    definedEntities.put("&HilbertSpace;", "\u210B");
    definedEntities.put("&Hopf;", "\u210D");
    definedEntities.put("&HorizontalLine;", "\u2500");
    definedEntities.put("&Hscr;", "\u210B");
    definedEntities.put("&Hstrok;", "\u0126");
    definedEntities.put("&HumpDownHump;", "\u224E");
    definedEntities.put("&HumpEqual;", "\u224F");
    definedEntities.put("&IEcy;", "\u0415");
    definedEntities.put("&IJlig;", "\u0132");
    definedEntities.put("&IOcy;", "\u0401");
    definedEntities.put("&Iacute;", "\u00CD");
    definedEntities.put("&Icirc;", "\u00CE");
    definedEntities.put("&Icy;", "\u0418");
    definedEntities.put("&Idot;", "\u0130");
    definedEntities.put("&Ifr;", "\u2111");
    definedEntities.put("&Igrave;", "\u00CC");
    definedEntities.put("&Im;", "\u2111");
    definedEntities.put("&Imacr;", "\u012A");
    definedEntities.put("&ImaginaryI;", "\u2148");
    definedEntities.put("&Implies;", "\u21D2");
    definedEntities.put("&Int;", "\u222C");
    definedEntities.put("&Integral;", "\u222B");
    definedEntities.put("&Intersection;", "\u22C2");
    definedEntities.put("&InvisibleComma;", "\u2063");
    definedEntities.put("&InvisibleTimes;", "\u2062");
    definedEntities.put("&Iogon;", "\u012E");
    definedEntities.put("&Iopf;", "\uD835\uDD40");
    definedEntities.put("&Iota;", "\u0399");
    definedEntities.put("&Iscr;", "\u2110");
    definedEntities.put("&Itilde;", "\u0128");
    definedEntities.put("&Iukcy;", "\u0406");
    definedEntities.put("&Iuml;", "\u00CF");
    definedEntities.put("&Jcirc;", "\u0134");
    definedEntities.put("&Jcy;", "\u0419");
    definedEntities.put("&Jfr;", "\uD835\uDD0D");
    definedEntities.put("&Jopf;", "\uD835\uDD41");
    definedEntities.put("&Jscr;", "\uD835\uDCA5");
    definedEntities.put("&Jsercy;", "\u0408");
    definedEntities.put("&Jukcy;", "\u0404");
    definedEntities.put("&KHcy;", "\u0425");
    definedEntities.put("&KJcy;", "\u040C");
    definedEntities.put("&Kappa;", "\u039A");
    definedEntities.put("&Kcedil;", "\u0136");
    definedEntities.put("&Kcy;", "\u041A");
    definedEntities.put("&Kfr;", "\uD835\uDD0E");
    definedEntities.put("&Kopf;", "\uD835\uDD42");
    definedEntities.put("&Kscr;", "\uD835\uDCA6");
    definedEntities.put("&LJcy;", "\u0409");
//    definedEntities.put("&LT;", "\u003C");
    definedEntities.put("&Lacute;", "\u0139");
    definedEntities.put("&Lambda;", "\u039B");
    definedEntities.put("&Lang;", "\u27EA");
    definedEntities.put("&Laplacetrf;", "\u2112");
    definedEntities.put("&Larr;", "\u219E");
    definedEntities.put("&Lcaron;", "\u013D");
    definedEntities.put("&Lcedil;", "\u013B");
    definedEntities.put("&Lcy;", "\u041B");
    definedEntities.put("&LeftAngleBracket;", "\u27E8");
    definedEntities.put("&LeftArrow;", "\u2190");
    definedEntities.put("&LeftArrowBar;", "\u21E4");
    definedEntities.put("&LeftArrowRightArrow;", "\u21C6");
    definedEntities.put("&LeftCeiling;", "\u2308");
    definedEntities.put("&LeftDoubleBracket;", "\u27E6");
    definedEntities.put("&LeftDownTeeVector;", "\u2961");
    definedEntities.put("&LeftDownVector;", "\u21C3");
    definedEntities.put("&LeftDownVectorBar;", "\u2959");
    definedEntities.put("&LeftFloor;", "\u230A");
    definedEntities.put("&LeftRightArrow;", "\u2194");
    definedEntities.put("&LeftRightVector;", "\u294E");
    definedEntities.put("&LeftTee;", "\u22A3");
    definedEntities.put("&LeftTeeArrow;", "\u21A4");
    definedEntities.put("&LeftTeeVector;", "\u295A");
    definedEntities.put("&LeftTriangle;", "\u22B2");
    definedEntities.put("&LeftTriangleBar;", "\u29CF");
    definedEntities.put("&LeftTriangleEqual;", "\u22B4");
    definedEntities.put("&LeftUpDownVector;", "\u2951");
    definedEntities.put("&LeftUpTeeVector;", "\u2960");
    definedEntities.put("&LeftUpVector;", "\u21BF");
    definedEntities.put("&LeftUpVectorBar;", "\u2958");
    definedEntities.put("&LeftVector;", "\u21BC");
    definedEntities.put("&LeftVectorBar;", "\u2952");
    definedEntities.put("&Leftarrow;", "\u21D0");
    definedEntities.put("&Leftrightarrow;", "\u21D4");
    definedEntities.put("&LessEqualGreater;", "\u22DA");
    definedEntities.put("&LessFullEqual;", "\u2266");
    definedEntities.put("&LessGreater;", "\u2276");
    definedEntities.put("&LessLess;", "\u2AA1");
    definedEntities.put("&LessSlantEqual;", "\u2A7D");
    definedEntities.put("&LessTilde;", "\u2272");
    definedEntities.put("&Lfr;", "\uD835\uDD0F");
    definedEntities.put("&Ll;", "\u22D8");
    definedEntities.put("&Lleftarrow;", "\u21DA");
    definedEntities.put("&Lmidot;", "\u013F");
    definedEntities.put("&LongLeftArrow;", "\u27F5");
    definedEntities.put("&LongLeftRightArrow;", "\u27F7");
    definedEntities.put("&LongRightArrow;", "\u27F6");
    definedEntities.put("&Longleftarrow;", "\u27F8");
    definedEntities.put("&Longleftrightarrow;", "\u27FA");
    definedEntities.put("&Longrightarrow;", "\u27F9");
    definedEntities.put("&Lopf;", "\uD835\uDD43");
    definedEntities.put("&LowerLeftArrow;", "\u2199");
    definedEntities.put("&LowerRightArrow;", "\u2198");
    definedEntities.put("&Lscr;", "\u2112");
    definedEntities.put("&Lsh;", "\u21B0");
    definedEntities.put("&Lstrok;", "\u0141");
    definedEntities.put("&Lt;", "\u226A");
    definedEntities.put("&Map;", "\u2905");
    definedEntities.put("&Mcy;", "\u041C");
    definedEntities.put("&MediumSpace;", "\u205F");
    definedEntities.put("&Mellintrf;", "\u2133");
    definedEntities.put("&Mfr;", "\uD835\uDD10");
    definedEntities.put("&MinusPlus;", "\u2213");
    definedEntities.put("&Mopf;", "\uD835\uDD44");
    definedEntities.put("&Mscr;", "\u2133");
    definedEntities.put("&Mu;", "\u039C");
    definedEntities.put("&NJcy;", "\u040A");
    definedEntities.put("&Nacute;", "\u0143");
    definedEntities.put("&Ncaron;", "\u0147");
    definedEntities.put("&Ncedil;", "\u0145");
    definedEntities.put("&Ncy;", "\u041D");
    definedEntities.put("&NegativeMediumSpace;", "\u200B");
    definedEntities.put("&NegativeThickSpace;", "\u200B");
    definedEntities.put("&NegativeThinSpace;", "\u200B");
    definedEntities.put("&NegativeVeryThinSpace;", "\u200B");
    definedEntities.put("&NestedGreaterGreater;", "\u226B");
    definedEntities.put("&NestedLessLess;", "\u226A");
    definedEntities.put("&NewLine;", "\n");
    definedEntities.put("&Nfr;", "\uD835\uDD11");
    definedEntities.put("&NoBreak;", "\u2060");
    definedEntities.put("&NonBreakingSpace;", "\u00A0");
    definedEntities.put("&Nopf;", "\u2115");
    definedEntities.put("&Not;", "\u2AEC");
    definedEntities.put("&NotCongruent;", "\u2262");
    definedEntities.put("&NotCupCap;", "\u226D");
    definedEntities.put("&NotDoubleVerticalBar;", "\u2226");
    definedEntities.put("&NotElement;", "\u2209");
    definedEntities.put("&NotEqual;", "\u2260");
    definedEntities.put("&NotEqualTilde;", "\u2242\u0338");
    definedEntities.put("&NotExists;", "\u2204");
    definedEntities.put("&NotGreater;", "\u226F");
    definedEntities.put("&NotGreaterEqual;", "\u2271");
    definedEntities.put("&NotGreaterFullEqual;", "\u2267\u0033");
    definedEntities.put("&NotGreaterGreater;", "\u226B\u0033");
    definedEntities.put("&NotGreaterLess;", "\u2279");
    definedEntities.put("&NotGreaterSlantEqual;", "\u2A7E\u0338");
    definedEntities.put("&NotGreaterTilde;", "\u2275");
    definedEntities.put("&NotHumpDownHump;", "\u224E\u0338");
    definedEntities.put("&NotHumpEqual;", "\u224F\u0338");
    definedEntities.put("&NotLeftTriangle;", "\u22EA");
    definedEntities.put("&NotLeftTriangleBar;", "\u29CF\u0338");
    definedEntities.put("&NotLeftTriangleEqual;", "\u22EC");
    definedEntities.put("&NotLess;", "\u226E");
    definedEntities.put("&NotLessEqual;", "\u2270");
    definedEntities.put("&NotLessGreater;", "\u2278");
    definedEntities.put("&NotLessLess;", "\u226A\u0338");
    definedEntities.put("&NotLessSlantEqual;", "\u2A7D\u0338");
    definedEntities.put("&NotLessTilde;", "\u2274");
    definedEntities.put("&NotNestedGreaterGreater;", "\u2AA2\u0338");
    definedEntities.put("&NotNestedLessLess;", "\u2AA1\u0338");
    definedEntities.put("&NotPrecedes;", "\u2280");
    definedEntities.put("&NotPrecedesEqual;", "\u2AAF\u0338");
    definedEntities.put("&NotPrecedesSlantEqual;", "\u22E0");
    definedEntities.put("&NotReverseElement;", "\u220C");
    definedEntities.put("&NotRightTriangle;", "\u22EB");
    definedEntities.put("&NotRightTriangleBar;", "\u29D0\u0338");
    definedEntities.put("&NotRightTriangleEqual;", "\u22ED");
    definedEntities.put("&NotSquareSubset;", "\u228F\u0338");
    definedEntities.put("&NotSquareSubsetEqual;", "\u22E2");
    definedEntities.put("&NotSquareSuperset;", "\u2290\u0338");
    definedEntities.put("&NotSquareSupersetEqual;", "\u22E3");
    definedEntities.put("&NotSubset;", "\u2282\u20D2");
    definedEntities.put("&NotSubsetEqual;", "\u2288");
    definedEntities.put("&NotSucceeds;", "\u2281");
    definedEntities.put("&NotSucceedsEqual;", "\u2AB0\u0338");
    definedEntities.put("&NotSucceedsSlantEqual;", "\u22E1");
    definedEntities.put("&NotSucceedsTilde;", "\u227F\u0338");
    definedEntities.put("&NotSuperset;", "\u2283\u20D2");
    definedEntities.put("&NotSupersetEqual;", "\u2289");
    definedEntities.put("&NotTilde;", "\u2241");
    definedEntities.put("&NotTildeEqual;", "\u2244");
    definedEntities.put("&NotTildeFullEqual;", "\u2247");
    definedEntities.put("&NotTildeTilde;", "\u2249");
    definedEntities.put("&NotVerticalBar;", "\u2224");
    definedEntities.put("&Nscr;", "\uD835\uDCA9");
    definedEntities.put("&Ntilde;", "\u00D1");
    definedEntities.put("&Nu;", "\u039D");
    definedEntities.put("&OElig;", "\u0152");
    definedEntities.put("&Oacute;", "\u00D3");
    definedEntities.put("&Ocirc;", "\u00D4");
    definedEntities.put("&Ocy;", "\u041E");
    definedEntities.put("&Odblac;", "\u0150");
    definedEntities.put("&Ofr;", "\uD835\uDD12");
    definedEntities.put("&Ograve;", "\u00D2");
    definedEntities.put("&Omacr;", "\u014C");
    definedEntities.put("&Omega;", "\u03A9");
    definedEntities.put("&Omicron;", "\u039F");
    definedEntities.put("&Oopf;", "\uD835\uDD46");
    definedEntities.put("&OpenCurlyDoubleQuote;", "\u201C");
    definedEntities.put("&OpenCurlyQuote;", "\u2018");
    definedEntities.put("&Or;", "\u2A54");
    definedEntities.put("&Oscr;", "\uD835\uDCAA");
    definedEntities.put("&Oslash;", "\u00D8");
    definedEntities.put("&Otilde;", "\u00D5");
    definedEntities.put("&Otimes;", "\u2A37");
    definedEntities.put("&Ouml;", "\u00D6");
    definedEntities.put("&OverBar;", "\u203E");
    definedEntities.put("&OverBrace;", "\u23DE");
    definedEntities.put("&OverBracket;", "\u23B4");
    definedEntities.put("&OverParenthesis;", "\u23DC");
    definedEntities.put("&PartialD;", "\u2202");
    definedEntities.put("&Pcy;", "\u041F");
    definedEntities.put("&Pfr;", "\uD835\uDD13");
    definedEntities.put("&Phi;", "\u03A6");
    definedEntities.put("&Pi;", "\u03A0");
    definedEntities.put("&PlusMinus;", "\u00B1");
    definedEntities.put("&Poincareplane;", "\u210C");
    definedEntities.put("&Popf;", "\u2119");
    definedEntities.put("&Pr;", "\u2ABB");
    definedEntities.put("&Precedes;", "\u227A");
    definedEntities.put("&PrecedesEqual;", "\u2AAF");
    definedEntities.put("&PrecedesSlantEqual;", "\u227C");
    definedEntities.put("&PrecedesTilde;", "\u227E");
    definedEntities.put("&Prime;", "\u2033");
    definedEntities.put("&Product;", "\u220F");
    definedEntities.put("&Proportion;", "\u2237");
    definedEntities.put("&Proportional;", "\u221D");
    definedEntities.put("&Pscr;", "\uD835\uDCAB");
    definedEntities.put("&Psi;", "\u03A8");
    //definedEntities.put("&QUOT;", "\\u0022");
    definedEntities.put("&Qfr;", "\uD835\uDD14");
    definedEntities.put("&Qopf;", "\u211A");
    definedEntities.put("&Qscr;", "\uD835\uDCAC");
    definedEntities.put("&RBarr;", "\u2910");
    definedEntities.put("&REG;", "\u00AE");
    definedEntities.put("&Racute;", "\u0154");
    definedEntities.put("&Rang;", "\u27EB");
    definedEntities.put("&Rarr;", "\u21A0");
    definedEntities.put("&Rarrtl;", "\u2916");
    definedEntities.put("&Rcaron;", "\u0158");
    definedEntities.put("&Rcedil;", "\u0156");
    definedEntities.put("&Rcy;", "\u0420");
    definedEntities.put("&Re;", "\u211C");
    definedEntities.put("&ReverseElement;", "\u220B");
    definedEntities.put("&ReverseEquilibrium;", "\u21CB");
    definedEntities.put("&ReverseUpEquilibrium;", "\u296F");
    definedEntities.put("&Rfr;", "\u211C");
    definedEntities.put("&Rho;", "\u03A1");
    definedEntities.put("&RightAngleBracket;", "\u27E9");
    definedEntities.put("&RightArrow;", "\u2192");
    definedEntities.put("&RightArrowBar;", "\u21E5");
    definedEntities.put("&RightArrowLeftArrow;", "\u21C4");
    definedEntities.put("&RightCeiling;", "\u2309");
    definedEntities.put("&RightDoubleBracket;", "\u27E7");
    definedEntities.put("&RightDownTeeVector;", "\u295D");
    definedEntities.put("&RightDownVector;", "\u21C2");
    definedEntities.put("&RightDownVectorBar;", "\u2955");
    definedEntities.put("&RightFloor;", "\u230B");
    definedEntities.put("&RightTee;", "\u22A2");
    definedEntities.put("&RightTeeArrow;", "\u21A6");
    definedEntities.put("&RightTeeVector;", "\u295B");
    definedEntities.put("&RightTriangle;", "\u22B3");
    definedEntities.put("&RightTriangleBar;", "\u29D0");
    definedEntities.put("&RightTriangleEqual;", "\u22B5");
    definedEntities.put("&RightUpDownVector;", "\u294F");
    definedEntities.put("&RightUpTeeVector;", "\u295C");
    definedEntities.put("&RightUpVector;", "\u21BE");
    definedEntities.put("&RightUpVectorBar;", "\u2954");
    definedEntities.put("&RightVector;", "\u21C0");
    definedEntities.put("&RightVectorBar;", "\u2953");
    definedEntities.put("&Rightarrow;", "\u21D2");
    definedEntities.put("&Ropf;", "\u211D");
    definedEntities.put("&RoundImplies;", "\u2970");
    definedEntities.put("&Rrightarrow;", "\u21DB");
    definedEntities.put("&Rscr;", "\u211B");
    definedEntities.put("&Rsh;", "\u21B1");
    definedEntities.put("&RuleDelayed;", "\u29F4");
    definedEntities.put("&SHCHcy;", "\u0429");
    definedEntities.put("&SHcy;", "\u0428");
    definedEntities.put("&SOFTcy;", "\u042C");
    definedEntities.put("&Sacute;", "\u015A");
    definedEntities.put("&Sc;", "\u2ABC");
    definedEntities.put("&Scaron;", "\u0160");
    definedEntities.put("&Scedil;", "\u015E");
    definedEntities.put("&Scirc;", "\u015C");
    definedEntities.put("&Scy;", "\u0421");
    definedEntities.put("&Sfr;", "\uD835\uDD16");
    definedEntities.put("&ShortDownArrow;", "\u2193");
    definedEntities.put("&ShortLeftArrow;", "\u2190");
    definedEntities.put("&ShortRightArrow;", "\u2192");
    definedEntities.put("&ShortUpArrow;", "\u2191");
    definedEntities.put("&Sigma;", "\u03A3");
    definedEntities.put("&SmallCircle;", "\u2218");
    definedEntities.put("&Sopf;", "\uD835\uDD4A");
    definedEntities.put("&Sqrt;", "\u221A");
    definedEntities.put("&Square;", "\u25A1");
    definedEntities.put("&SquareIntersection;", "\u2293");
    definedEntities.put("&SquareSubset;", "\u228F");
    definedEntities.put("&SquareSubsetEqual;", "\u2291");
    definedEntities.put("&SquareSuperset;", "\u2290");
    definedEntities.put("&SquareSupersetEqual;", "\u2292");
    definedEntities.put("&SquareUnion;", "\u2294");
    definedEntities.put("&Sscr;", "\uD835\uDCAE");
    definedEntities.put("&Star;", "\u22C6");
    definedEntities.put("&Sub;", "\u22D0");
    definedEntities.put("&Subset;", "\u22D0");
    definedEntities.put("&SubsetEqual;", "\u2286");
    definedEntities.put("&Succeeds;", "\u227B");
    definedEntities.put("&SucceedsEqual;", "\u2AB0");
    definedEntities.put("&SucceedsSlantEqual;", "\u227D");
    definedEntities.put("&SucceedsTilde;", "\u227F");
    definedEntities.put("&SuchThat;", "\u220B");
    definedEntities.put("&Sum;", "\u2211");
    definedEntities.put("&Sup;", "\u22D1");
    definedEntities.put("&Superset;", "\u2283");
    definedEntities.put("&SupersetEqual;", "\u2287");
    definedEntities.put("&Supset;", "\u22D1");
    definedEntities.put("&THORN;", "\u00DE");
    definedEntities.put("&TRADE;", "\u2122");
    definedEntities.put("&TSHcy;", "\u040B");
    definedEntities.put("&TScy;", "\u0426");
    definedEntities.put("&Tab;", "\u0009");
    definedEntities.put("&Tau;", "\u03A4");
    definedEntities.put("&Tcaron;", "\u0164");
    definedEntities.put("&Tcedil;", "\u0162");
    definedEntities.put("&Tcy;", "\u0422");
    definedEntities.put("&Tfr;", "\uD835\uDD17");
    definedEntities.put("&Therefore;", "\u2234");
    definedEntities.put("&Theta;", "\u0398");
    definedEntities.put("&ThickSpace;", "\u205F\u200A");
    definedEntities.put("&ThinSpace;", "\u2009");
    definedEntities.put("&Tilde;", "\u223C");
    definedEntities.put("&TildeEqual;", "\u2243");
    definedEntities.put("&TildeFullEqual;", "\u2245");
    definedEntities.put("&TildeTilde;", "\u2248");
    definedEntities.put("&Topf;", "\uD835\uDD4B");
    definedEntities.put("&TripleDot;", "\u20DB");
    definedEntities.put("&Tscr;", "\uD835\uDCAF");
    definedEntities.put("&Tstrok;", "\u0166");
    definedEntities.put("&Uacute;", "\u00DA");
    definedEntities.put("&Uarr;", "\u219F");
    definedEntities.put("&Uarrocir;", "\u2949");
    definedEntities.put("&Ubrcy;", "\u040E");
    definedEntities.put("&Ubreve;", "\u016C");
    definedEntities.put("&Ucirc;", "\u00DB");
    definedEntities.put("&Ucy;", "\u0423");
    definedEntities.put("&Udblac;", "\u0170");
    definedEntities.put("&Ufr;", "\uD835\uDD18");
    definedEntities.put("&Ugrave;", "\u00D9");
    definedEntities.put("&Umacr;", "\u016A");
    definedEntities.put("&UnderBar;", "\u005F");
    definedEntities.put("&UnderBrace;", "\u23DF");
    definedEntities.put("&UnderBracket;", "\u23B5");
    definedEntities.put("&UnderParenthesis;", "\u23DD");
    definedEntities.put("&Union;", "\u22C3");
    definedEntities.put("&UnionPlus;", "\u228E");
    definedEntities.put("&Uogon;", "\u0172");
    definedEntities.put("&Uopf;", "\uD835\uDD4C");
    definedEntities.put("&UpArrow;", "\u2191");
    definedEntities.put("&UpArrowBar;", "\u2912");
    definedEntities.put("&UpArrowDownArrow;", "\u21C5");
    definedEntities.put("&UpDownArrow;", "\u2195");
    definedEntities.put("&UpEquilibrium;", "\u296E");
    definedEntities.put("&UpTee;", "\u22A5");
    definedEntities.put("&UpTeeArrow;", "\u21A5");
    definedEntities.put("&Uparrow;", "\u21D1");
    definedEntities.put("&Updownarrow;", "\u21D5");
    definedEntities.put("&UpperLeftArrow;", "\u2196");
    definedEntities.put("&UpperRightArrow;", "\u2197");
    definedEntities.put("&Upsi;", "\u03D2");
    definedEntities.put("&Upsilon;", "\u03A5");
    definedEntities.put("&Uring;", "\u016E");
    definedEntities.put("&Uscr;", "\uD835\uDCB0");
    definedEntities.put("&Utilde;", "\u0168");
    definedEntities.put("&Uuml;", "\u00DC");
    definedEntities.put("&VDash;", "\u22AB");
    definedEntities.put("&Vbar;", "\u2AEB");
    definedEntities.put("&Vcy;", "\u0412");
    definedEntities.put("&Vdash;", "\u22A9");
    definedEntities.put("&Vdashl;", "\u2AE6");
    definedEntities.put("&Vee;", "\u22C1");
    definedEntities.put("&Verbar;", "\u2016");
    definedEntities.put("&Vert;", "\u2016");
    definedEntities.put("&VerticalBar;", "\u2223");
    definedEntities.put("&VerticalLine;", "\u007C");
    definedEntities.put("&VerticalSeparator;", "\u2758");
    definedEntities.put("&VerticalTilde;", "\u2240");
    definedEntities.put("&VeryThinSpace;", "\u200A");
    definedEntities.put("&Vfr;", "\uD835\uDD19");
    definedEntities.put("&Vopf;", "\uD835\uDD4D");
    definedEntities.put("&Vscr;", "\uD835\uDCB1");
    definedEntities.put("&Vvdash;", "\u22AA");
    definedEntities.put("&Wcirc;", "\u0174");
    definedEntities.put("&Wedge;", "\u22C0");
    definedEntities.put("&Wfr;", "\uD835\uDD1A");
    definedEntities.put("&Wopf;", "\uD835\uDD4E");
    definedEntities.put("&Wscr;", "\uD835\uDCB2");
    definedEntities.put("&Xfr;", "\uD835\uDD1B");
    definedEntities.put("&Xi;", "\u039E");
    definedEntities.put("&Xopf;", "\uD835\uDD4F");
    definedEntities.put("&Xscr;", "\uD835\uDCB3");
    definedEntities.put("&YAcy;", "\u042F");
    definedEntities.put("&YIcy;", "\u0407");
    definedEntities.put("&YUcy;", "\u042E");
    definedEntities.put("&Yacute;", "\u00DD");
    definedEntities.put("&Ycirc;", "\u0176");
    definedEntities.put("&Ycy;", "\u042B");
    definedEntities.put("&Yfr;", "\uD835\uDD1C");
    definedEntities.put("&Yopf;", "\uD835\uDD50");
    definedEntities.put("&Yscr;", "\uD835\uDCB4");
    definedEntities.put("&Yuml;", "\u0178");
    definedEntities.put("&ZHcy;", "\u0416");
    definedEntities.put("&Zacute;", "\u0179");
    definedEntities.put("&Zcaron;", "\u017D");
    definedEntities.put("&Zcy;", "\u0417");
    definedEntities.put("&Zdot;", "\u017B");
    definedEntities.put("&ZeroWidthSpace;", "\u200B");
    definedEntities.put("&Zeta;", "\u0396");
    definedEntities.put("&Zfr;", "\u2128");
    definedEntities.put("&Zopf;", "\u2124");
    definedEntities.put("&Zscr;", "\uD835\uDCB5");
    definedEntities.put("&aacute;", "\u00E1");
    definedEntities.put("&abreve;", "\u0103");
    definedEntities.put("&ac;", "\u223E");
    definedEntities.put("&acE;", "\u223E\u0333");
    definedEntities.put("&acd;", "\u223F");
    definedEntities.put("&acirc;", "\u00E2");
    definedEntities.put("&acute;", "\u00B4");
    definedEntities.put("&acy;", "\u0430");
    definedEntities.put("&aelig;", "\u00E6");
    definedEntities.put("&af;", "\u2061");
    definedEntities.put("&afr;", "\uD835\uDD1E");
    definedEntities.put("&agrave;", "\u00E0");
    definedEntities.put("&alefsym;", "\u2135");
    definedEntities.put("&aleph;", "\u2135");
    definedEntities.put("&alpha;", "\u03B1");
    definedEntities.put("&amacr;", "\u0101");
    definedEntities.put("&amalg;", "\u2A3F");
//    definedEntities.put("&amp;", "\u0026");
    definedEntities.put("&and;", "\u2227");
    definedEntities.put("&andand;", "\u2A55");
    definedEntities.put("&andd;", "\u2A5C");
    definedEntities.put("&andslope;", "\u2A58");
    definedEntities.put("&andv;", "\u2A5A");
    definedEntities.put("&ang;", "\u2220");
    definedEntities.put("&ange;", "\u29A4");
    definedEntities.put("&angle;", "\u2220");
    definedEntities.put("&angmsd;", "\u2221");
    definedEntities.put("&angmsdaa;", "\u29A8");
    definedEntities.put("&angmsdab;", "\u29A9");
    definedEntities.put("&angmsdac;", "\u29AA");
    definedEntities.put("&angmsdad;", "\u29AB");
    definedEntities.put("&angmsdae;", "\u29AC");
    definedEntities.put("&angmsdaf;", "\u29AD");
    definedEntities.put("&angmsdag;", "\u29AE");
    definedEntities.put("&angmsdah;", "\u29AF");
    definedEntities.put("&angrt;", "\u221F");
    definedEntities.put("&angrtvb;", "\u22BE");
    definedEntities.put("&angrtvbd;", "\u299D");
    definedEntities.put("&angsph;", "\u2222");
    definedEntities.put("&angst;", "\u00C5");
    definedEntities.put("&angzarr;", "\u237C");
    definedEntities.put("&aogon;", "\u0105");
    definedEntities.put("&aopf;", "\uD835\uDD52");
    definedEntities.put("&ap;", "\u2248");
    definedEntities.put("&apE;", "\u2A70");
    definedEntities.put("&apacir;", "\u2A6F");
    definedEntities.put("&ape;", "\u224A");
    definedEntities.put("&apid;", "\u224B");
//    definedEntities.put("&apos;", "\u0027");
    definedEntities.put("&approx;", "\u2248");
    definedEntities.put("&approxeq;", "\u224A");
    definedEntities.put("&aring;", "\u00E5");
    definedEntities.put("&ascr;", "\uD835\uDCB6");
    definedEntities.put("&ast;", "\u002A");
    definedEntities.put("&asymp;", "\u2248");
    definedEntities.put("&asympeq;", "\u224D");
    definedEntities.put("&atilde;", "\u00E3");
    definedEntities.put("&auml;", "\u00E4");
    definedEntities.put("&awconint;", "\u2233");
    definedEntities.put("&awint;", "\u2A11");
    definedEntities.put("&bNot;", "\u2AED");
    definedEntities.put("&backcong;", "\u224C");
    definedEntities.put("&backepsilon;", "\u03F6");
    definedEntities.put("&backprime;", "\u2035");
    definedEntities.put("&backsim;", "\u223D");
    definedEntities.put("&backsimeq;", "\u22CD");
    definedEntities.put("&barvee;", "\u22BD");
    definedEntities.put("&barwed;", "\u2305");
    definedEntities.put("&barwedge;", "\u2305");
    definedEntities.put("&bbrk;", "\u23B5");
    definedEntities.put("&bbrktbrk;", "\u23B6");
    definedEntities.put("&bcong;", "\u224C");
    definedEntities.put("&bcy;", "\u0431");
    definedEntities.put("&bdquo;", "\u201E");
    definedEntities.put("&becaus;", "\u2235");
    definedEntities.put("&because;", "\u2235");
    definedEntities.put("&bemptyv;", "\u29B0");
    definedEntities.put("&bepsi;", "\u03F6");
    definedEntities.put("&bernou;", "\u212C");
    definedEntities.put("&beta;", "\u03B2");
    definedEntities.put("&beth;", "\u2136");
    definedEntities.put("&between;", "\u226C");
    definedEntities.put("&bfr;", "\uD835\uDD1F");
    definedEntities.put("&bigcap;", "\u22C2");
    definedEntities.put("&bigcirc;", "\u25EF");
    definedEntities.put("&bigcup;", "\u22C3");
    definedEntities.put("&bigodot;", "\u2A00");
    definedEntities.put("&bigoplus;", "\u2A01");
    definedEntities.put("&bigotimes;", "\u2A02");
    definedEntities.put("&bigsqcup;", "\u2A06");
    definedEntities.put("&bigstar;", "\u2605");
    definedEntities.put("&bigtriangledown;", "\u25BD");
    definedEntities.put("&bigtriangleup;", "\u25B3");
    definedEntities.put("&biguplus;", "\u2A04");
    definedEntities.put("&bigvee;", "\u22C1");
    definedEntities.put("&bigwedge;", "\u22C0");
    definedEntities.put("&bkarow;", "\u290D");
    definedEntities.put("&blacklozenge;", "\u29EB");
    definedEntities.put("&blacksquare;", "\u25AA");
    definedEntities.put("&blacktriangle;", "\u25B4");
    definedEntities.put("&blacktriangledown;", "\u25BE");
    definedEntities.put("&blacktriangleleft;", "\u25C2");
    definedEntities.put("&blacktriangleright;", "\u25B8");
    definedEntities.put("&blank;", "\u2423");
    definedEntities.put("&blk12;", "\u2592");
    definedEntities.put("&blk14;", "\u2591");
    definedEntities.put("&blk34;", "\u2593");
    definedEntities.put("&block;", "\u2588");
    definedEntities.put("&bne;", "\u003D\u20E5");
    definedEntities.put("&bnequiv;", "\u2261\u20E5");
    definedEntities.put("&bnot;", "\u2310");
    definedEntities.put("&bopf;", "\uD835\uDD53");
    definedEntities.put("&bot;", "\u22A5");
    definedEntities.put("&bottom;", "\u22A5");
    definedEntities.put("&bowtie;", "\u22C8");
    definedEntities.put("&boxDL;", "\u2557");
    definedEntities.put("&boxDR;", "\u2554");
    definedEntities.put("&boxDl;", "\u2556");
    definedEntities.put("&boxDr;", "\u2553");
    definedEntities.put("&boxH;", "\u2550");
    definedEntities.put("&boxHD;", "\u2566");
    definedEntities.put("&boxHU;", "\u2569");
    definedEntities.put("&boxHd;", "\u2564");
    definedEntities.put("&boxHu;", "\u2567");
    definedEntities.put("&boxUL;", "\u255D");
    definedEntities.put("&boxUR;", "\u255A");
    definedEntities.put("&boxUl;", "\u255C");
    definedEntities.put("&boxUr;", "\u2559");
    definedEntities.put("&boxV;", "\u2551");
    definedEntities.put("&boxVH;", "\u256C");
    definedEntities.put("&boxVL;", "\u2563");
    definedEntities.put("&boxVR;", "\u2560");
    definedEntities.put("&boxVh;", "\u256B");
    definedEntities.put("&boxVl;", "\u2562");
    definedEntities.put("&boxVr;", "\u255F");
    definedEntities.put("&boxbox;", "\u29C9");
    definedEntities.put("&boxdL;", "\u2555");
    definedEntities.put("&boxdR;", "\u2552");
    definedEntities.put("&boxdl;", "\u2510");
    definedEntities.put("&boxdr;", "\u250C");
    definedEntities.put("&boxh;", "\u2500");
    definedEntities.put("&boxhD;", "\u2565");
    definedEntities.put("&boxhU;", "\u2568");
    definedEntities.put("&boxhd;", "\u252C");
    definedEntities.put("&boxhu;", "\u2534");
    definedEntities.put("&boxminus;", "\u229F");
    definedEntities.put("&boxplus;", "\u229E");
    definedEntities.put("&boxtimes;", "\u22A0");
    definedEntities.put("&boxuL;", "\u255B");
    definedEntities.put("&boxuR;", "\u2558");
    definedEntities.put("&boxul;", "\u2518");
    definedEntities.put("&boxur;", "\u2514");
    definedEntities.put("&boxv;", "\u2502");
    definedEntities.put("&boxvH;", "\u256A");
    definedEntities.put("&boxvL;", "\u2561");
    definedEntities.put("&boxvR;", "\u255E");
    definedEntities.put("&boxvh;", "\u253C");
    definedEntities.put("&boxvl;", "\u2524");
    definedEntities.put("&boxvr;", "\u251C");
    definedEntities.put("&bprime;", "\u2035");
    definedEntities.put("&breve;", "\u02D8");
    definedEntities.put("&brvbar;", "\u00A6");
    definedEntities.put("&bscr;", "\uD835\uDCB7");
    definedEntities.put("&bsemi;", "\u204F");
    definedEntities.put("&bsim;", "\u223D");
    definedEntities.put("&bsime;", "\u22CD");
    definedEntities.put("&bsol;", "\\u005C");
    definedEntities.put("&bsolb;", "\u29C5");
    definedEntities.put("&bsolhsub;", "\u27C8");
    definedEntities.put("&bull;", "\u2022");
    definedEntities.put("&bullet;", "\u2022");
    definedEntities.put("&bump;", "\u224E");
    definedEntities.put("&bumpE;", "\u2AAE");
    definedEntities.put("&bumpe;", "\u224F");
    definedEntities.put("&bumpeq;", "\u224F");
    definedEntities.put("&cacute;", "\u0107");
    definedEntities.put("&cap;", "\u2229");
    definedEntities.put("&capand;", "\u2A44");
    definedEntities.put("&capbrcup;", "\u2A49");
    definedEntities.put("&capcap;", "\u2A4B");
    definedEntities.put("&capcup;", "\u2A47");
    definedEntities.put("&capdot;", "\u2A40");
    definedEntities.put("&caps;", "\u2229\uFE00");
    definedEntities.put("&caret;", "\u2041");
    definedEntities.put("&caron;", "\u02C7");
    definedEntities.put("&ccaps;", "\u2A4D");
    definedEntities.put("&ccaron;", "\u010D");
    definedEntities.put("&ccedil;", "\u00E7");
    definedEntities.put("&ccirc;", "\u0109");
    definedEntities.put("&ccups;", "\u2A4C");
    definedEntities.put("&ccupssm;", "\u2A50");
    definedEntities.put("&cdot;", "\u010B");
    definedEntities.put("&cedil;", "\u00B8");
    definedEntities.put("&cemptyv;", "\u29B2");
    definedEntities.put("&cent;", "\u00A2");
    definedEntities.put("&centerdot;", "\u00B7");
    definedEntities.put("&cfr;", "\uD835\uDD20");
    definedEntities.put("&chcy;", "\u0447");
    definedEntities.put("&check;", "\u2713");
    definedEntities.put("&checkmark;", "\u2713");
    definedEntities.put("&chi;", "\u03C7");
    definedEntities.put("&cir;", "\u25CB");
    definedEntities.put("&cirE;", "\u29C3");
    definedEntities.put("&circ;", "\u02C6");
    definedEntities.put("&circeq;", "\u2257");
    definedEntities.put("&circlearrowleft;", "\u21BA");
    definedEntities.put("&circlearrowright;", "\u21BB");
    definedEntities.put("&circledR;", "\u00AE");
    definedEntities.put("&circledS;", "\u24C8");
    definedEntities.put("&circledast;", "\u229B");
    definedEntities.put("&circledcirc;", "\u229A");
    definedEntities.put("&circleddash;", "\u229D");
    definedEntities.put("&cire;", "\u2257");
    definedEntities.put("&cirfnint;", "\u2A10");
    definedEntities.put("&cirmid;", "\u2AEF");
    definedEntities.put("&cirscir;", "\u29C2");
    definedEntities.put("&clubs;", "\u2663");
    definedEntities.put("&clubsuit;", "\u2663");
    definedEntities.put("&colon;", "\u003A");
    definedEntities.put("&colone;", "\u2254");
    definedEntities.put("&coloneq;", "\u2254");
    definedEntities.put("&comma;", "\u002C");
    definedEntities.put("&commat;", "\u0040");
    definedEntities.put("&comp;", "\u2201");
    definedEntities.put("&compfn;", "\u2218");
    definedEntities.put("&complement;", "\u2201");
    definedEntities.put("&complexes;", "\u2102");
    definedEntities.put("&cong;", "\u2245");
    definedEntities.put("&congdot;", "\u2A6D");
    definedEntities.put("&conint;", "\u222E");
    definedEntities.put("&copf;", "\uD835\uDD54");
    definedEntities.put("&coprod;", "\u2210");
    definedEntities.put("&copy;", "\u00A9");
    definedEntities.put("&copysr;", "\u2117");
    definedEntities.put("&crarr;", "\u21B5");
    definedEntities.put("&cross;", "\u2717");
    definedEntities.put("&cscr;", "\uD835\uDCB8");
    definedEntities.put("&csub;", "\u2ACF");
    definedEntities.put("&csube;", "\u2AD1");
    definedEntities.put("&csup;", "\u2AD0");
    definedEntities.put("&csupe;", "\u2AD2");
    definedEntities.put("&ctdot;", "\u22EF");
    definedEntities.put("&cudarrl;", "\u2938");
    definedEntities.put("&cudarrr;", "\u2935");
    definedEntities.put("&cuepr;", "\u22DE");
    definedEntities.put("&cuesc;", "\u22DF");
    definedEntities.put("&cularr;", "\u21B6");
    definedEntities.put("&cularrp;", "\u293D");
    definedEntities.put("&cup;", "\u222A");
    definedEntities.put("&cupbrcap;", "\u2A48");
    definedEntities.put("&cupcap;", "\u2A46");
    definedEntities.put("&cupcup;", "\u2A4A");
    definedEntities.put("&cupdot;", "\u228D");
    definedEntities.put("&cupor;", "\u2A45");
    definedEntities.put("&cups;", "\u222A\uFE00");
    definedEntities.put("&curarr;", "\u21B7");
    definedEntities.put("&curarrm;", "\u293C");
    definedEntities.put("&curlyeqprec;", "\u22DE");
    definedEntities.put("&curlyeqsucc;", "\u22DF");
    definedEntities.put("&curlyvee;", "\u22CE");
    definedEntities.put("&curlywedge;", "\u22CF");
    definedEntities.put("&curren;", "\u00A4");
    definedEntities.put("&curvearrowleft;", "\u21B6");
    definedEntities.put("&curvearrowright;", "\u21B7");
    definedEntities.put("&cuvee;", "\u22CE");
    definedEntities.put("&cuwed;", "\u22CF");
    definedEntities.put("&cwconint;", "\u2232");
    definedEntities.put("&cwint;", "\u2231");
    definedEntities.put("&cylcty;", "\u232D");
    definedEntities.put("&dArr;", "\u21D3");
    definedEntities.put("&dHar;", "\u2965");
    definedEntities.put("&dagger;", "\u2020");
    definedEntities.put("&daleth;", "\u2138");
    definedEntities.put("&darr;", "\u2193");
    definedEntities.put("&dash;", "\u2010");
    definedEntities.put("&dashv;", "\u22A3");
    definedEntities.put("&dbkarow;", "\u290F");
    definedEntities.put("&dblac;", "\u02DD");
    definedEntities.put("&dcaron;", "\u010F");
    definedEntities.put("&dcy;", "\u0434");
    definedEntities.put("&dd;", "\u2146");
    definedEntities.put("&ddagger;", "\u2021");
    definedEntities.put("&ddarr;", "\u21CA");
    definedEntities.put("&ddotseq;", "\u2A77");
    definedEntities.put("&deg;", "\u00B0");
    definedEntities.put("&delta;", "\u03B4");
    definedEntities.put("&demptyv;", "\u29B1");
    definedEntities.put("&dfisht;", "\u297F");
    definedEntities.put("&dfr;", "\uD835\uDD21");
    definedEntities.put("&dharl;", "\u21C3");
    definedEntities.put("&dharr;", "\u21C2");
    definedEntities.put("&diam;", "\u22C4");
    definedEntities.put("&diamond;", "\u22C4");
    definedEntities.put("&diamondsuit;", "\u2666");
    definedEntities.put("&diams;", "\u2666");
    definedEntities.put("&die;", "\u00A8");
    definedEntities.put("&digamma;", "\u03DD");
    definedEntities.put("&disin;", "\u22F2");
    definedEntities.put("&div;", "\u00F7");
    definedEntities.put("&divide;", "\u00F7");
    definedEntities.put("&divideontimes;", "\u22C7");
    definedEntities.put("&divonx;", "\u22C7");
    definedEntities.put("&djcy;", "\u0452");
    definedEntities.put("&dlcorn;", "\u231E");
    definedEntities.put("&dlcrop;", "\u230D");
    definedEntities.put("&dollar;", "\u0024");
    definedEntities.put("&dopf;", "\uD835\uDD55");
    definedEntities.put("&dot;", "\u02D9");
    definedEntities.put("&doteq;", "\u2250");
    definedEntities.put("&doteqdot;", "\u2251");
    definedEntities.put("&dotminus;", "\u2238");
    definedEntities.put("&dotplus;", "\u2214");
    definedEntities.put("&dotsquare;", "\u22A1");
    definedEntities.put("&doublebarwedge;", "\u2306");
    definedEntities.put("&downarrow;", "\u2193");
    definedEntities.put("&downdownarrows;", "\u21CA");
    definedEntities.put("&downharpoonleft;", "\u21C3");
    definedEntities.put("&downharpoonright;", "\u21C2");
    definedEntities.put("&drbkarow;", "\u2910");
    definedEntities.put("&drcorn;", "\u231F");
    definedEntities.put("&drcrop;", "\u230C");
    definedEntities.put("&dscr;", "\uD835\uDCB9");
    definedEntities.put("&dscy;", "\u0455");
    definedEntities.put("&dsol;", "\u29F6");
    definedEntities.put("&dstrok;", "\u0111");
    definedEntities.put("&dtdot;", "\u22F1");
    definedEntities.put("&dtri;", "\u25BF");
    definedEntities.put("&dtrif;", "\u25BE");
    definedEntities.put("&duarr;", "\u21F5");
    definedEntities.put("&duhar;", "\u296F");
    definedEntities.put("&dwangle;", "\u29A6");
    definedEntities.put("&dzcy;", "\u045F");
    definedEntities.put("&dzigrarr;", "\u27FF");
    definedEntities.put("&eDDot;", "\u2A77");
    definedEntities.put("&eDot;", "\u2251");
    definedEntities.put("&eacute;", "\u00E9");
    definedEntities.put("&easter;", "\u2A6E");
    definedEntities.put("&ecaron;", "\u011B");
    definedEntities.put("&ecir;", "\u2256");
    definedEntities.put("&ecirc;", "\u00EA");
    definedEntities.put("&ecolon;", "\u2255");
    definedEntities.put("&ecy;", "\u044D");
    definedEntities.put("&edot;", "\u0117");
    definedEntities.put("&ee;", "\u2147");
    definedEntities.put("&efDot;", "\u2252");
    definedEntities.put("&efr;", "\uD835\uDD22");
    definedEntities.put("&eg;", "\u2A9A");
    definedEntities.put("&egrave;", "\u00E8");
    definedEntities.put("&egs;", "\u2A96");
    definedEntities.put("&egsdot;", "\u2A98");
    definedEntities.put("&el;", "\u2A99");
    definedEntities.put("&elinters;", "\u23E7");
    definedEntities.put("&ell;", "\u2113");
    definedEntities.put("&els;", "\u2A95");
    definedEntities.put("&elsdot;", "\u2A97");
    definedEntities.put("&emacr;", "\u0113");
    definedEntities.put("&empty;", "\u2205");
    definedEntities.put("&emptyset;", "\u2205");
    definedEntities.put("&emptyv;", "\u2205");
    definedEntities.put("&emsp13;", "\u2004");
    definedEntities.put("&emsp14;", "\u2005");
    definedEntities.put("&emsp;", "\u2003");
    definedEntities.put("&eng;", "\u014B");
    definedEntities.put("&ensp;", "\u2002");
    definedEntities.put("&eogon;", "\u0119");
    definedEntities.put("&eopf;", "\uD835\uDD56");
    definedEntities.put("&epar;", "\u22D5");
    definedEntities.put("&eparsl;", "\u29E3");
    definedEntities.put("&eplus;", "\u2A71");
    definedEntities.put("&epsi;", "\u03B5");
    definedEntities.put("&epsilon;", "\u03B5");
    definedEntities.put("&epsiv;", "\u03F5");
    definedEntities.put("&eqcirc;", "\u2256");
    definedEntities.put("&eqcolon;", "\u2255");
    definedEntities.put("&eqsim;", "\u2242");
    definedEntities.put("&eqslantgtr;", "\u2A96");
    definedEntities.put("&eqslantless;", "\u2A95");
    definedEntities.put("&equals;", "\u003D");
    definedEntities.put("&equest;", "\u225F");
    definedEntities.put("&equiv;", "\u2261");
    definedEntities.put("&equivDD;", "\u2A78");
    definedEntities.put("&eqvparsl;", "\u29E5");
    definedEntities.put("&erDot;", "\u2253");
    definedEntities.put("&erarr;", "\u2971");
    definedEntities.put("&escr;", "\u212F");
    definedEntities.put("&esdot;", "\u2250");
    definedEntities.put("&esim;", "\u2242");
    definedEntities.put("&eta;", "\u03B7");
    definedEntities.put("&eth;", "\u00F0");
    definedEntities.put("&euml;", "\u00EB");
    definedEntities.put("&euro;", "\u20AC");
    definedEntities.put("&excl;", "\u0021");
    definedEntities.put("&exist;", "\u2203");
    definedEntities.put("&expectation;", "\u2130");
    definedEntities.put("&exponentiale;", "\u2147");
    definedEntities.put("&fallingdotseq;", "\u2252");
    definedEntities.put("&fcy;", "\u0444");
    definedEntities.put("&female;", "\u2640");
    definedEntities.put("&ffilig;", "\uFB03");
    definedEntities.put("&fflig;", "\uFB00");
    definedEntities.put("&ffllig;", "\uFB04");
    definedEntities.put("&ffr;", "\uD835\uDD23");
    definedEntities.put("&filig;", "\uFB01");
    definedEntities.put("&fjlig;", "\u0066\u006A");
    definedEntities.put("&flat;", "\u266D");
    definedEntities.put("&fllig;", "\uFB02");
    definedEntities.put("&fltns;", "\u25B1");
    definedEntities.put("&fnof;", "\u0192");
    definedEntities.put("&fopf;", "\uD835\uDD57");
    definedEntities.put("&forall;", "\u2200");
    definedEntities.put("&fork;", "\u22D4");
    definedEntities.put("&forkv;", "\u2AD9");
    definedEntities.put("&fpartint;", "\u2A0D");
    definedEntities.put("&frac12;", "\u00BD");
    definedEntities.put("&frac13;", "\u2153");
    definedEntities.put("&frac14;", "\u00BC");
    definedEntities.put("&frac15;", "\u2155");
    definedEntities.put("&frac16;", "\u2159");
    definedEntities.put("&frac18;", "\u215B");
    definedEntities.put("&frac23;", "\u2154");
    definedEntities.put("&frac25;", "\u2156");
    definedEntities.put("&frac34;", "\u00BE");
    definedEntities.put("&frac35;", "\u2157");
    definedEntities.put("&frac38;", "\u215C");
    definedEntities.put("&frac45;", "\u2158");
    definedEntities.put("&frac56;", "\u215A");
    definedEntities.put("&frac58;", "\u215D");
    definedEntities.put("&frac78;", "\u215E");
    definedEntities.put("&frasl;", "\u2044");
    definedEntities.put("&frown;", "\u2322");
    definedEntities.put("&fscr;", "\uD835\uDCBB");
    definedEntities.put("&gE;", "\u2267");
    definedEntities.put("&gEl;", "\u2A8C");
    definedEntities.put("&gacute;", "\u01F5");
    definedEntities.put("&gamma;", "\u03B3");
    definedEntities.put("&gammad;", "\u03DD");
    definedEntities.put("&gap;", "\u2A86");
    definedEntities.put("&gbreve;", "\u011F");
    definedEntities.put("&gcirc;", "\u011D");
    definedEntities.put("&gcy;", "\u0433");
    definedEntities.put("&gdot;", "\u0121");
    definedEntities.put("&ge;", "\u2265");
    definedEntities.put("&gel;", "\u22DB");
    definedEntities.put("&geq;", "\u2265");
    definedEntities.put("&geqq;", "\u2267");
    definedEntities.put("&geqslant;", "\u2A7E");
    definedEntities.put("&ges;", "\u2A7E");
    definedEntities.put("&gescc;", "\u2AA9");
    definedEntities.put("&gesdot;", "\u2A80");
    definedEntities.put("&gesdoto;", "\u2A82");
    definedEntities.put("&gesdotol;", "\u2A84");
    definedEntities.put("&gesl;", "\u22DB\uFE00");
    definedEntities.put("&gesles;", "\u2A94");
    definedEntities.put("&gfr;", "\uD835\uDD24");
    definedEntities.put("&gg;", "\u226B");
    definedEntities.put("&ggg;", "\u22D9");
    definedEntities.put("&gimel;", "\u2137");
    definedEntities.put("&gjcy;", "\u0453");
    definedEntities.put("&gl;", "\u2277");
    definedEntities.put("&glE;", "\u2A92");
    definedEntities.put("&gla;", "\u2AA5");
    definedEntities.put("&glj;", "\u2AA4");
    definedEntities.put("&gnE;", "\u2269");
    definedEntities.put("&gnap;", "\u2A8A");
    definedEntities.put("&gnapprox;", "\u2A8A");
    definedEntities.put("&gne;", "\u2A88");
    definedEntities.put("&gneq;", "\u2A88");
    definedEntities.put("&gneqq;", "\u2269");
    definedEntities.put("&gnsim;", "\u22E7");
    definedEntities.put("&gopf;", "\uD835\uDD58");
    definedEntities.put("&grave;", "\u0060");
    definedEntities.put("&gscr;", "\u210A");
    definedEntities.put("&gsim;", "\u2273");
    definedEntities.put("&gsime;", "\u2A8E");
    definedEntities.put("&gsiml;", "\u2A90");
//    definedEntities.put("&gt;", "\u003E");
    definedEntities.put("&gtcc;", "\u2AA7");
    definedEntities.put("&gtcir;", "\u2A7A");
    definedEntities.put("&gtdot;", "\u22D7");
    definedEntities.put("&gtlPar;", "\u2995");
    definedEntities.put("&gtquest;", "\u2A7C");
    definedEntities.put("&gtrapprox;", "\u2A86");
    definedEntities.put("&gtrarr;", "\u2978");
    definedEntities.put("&gtrdot;", "\u22D7");
    definedEntities.put("&gtreqless;", "\u22DB");
    definedEntities.put("&gtreqqless;", "\u2A8C");
    definedEntities.put("&gtrless;", "\u2277");
    definedEntities.put("&gtrsim;", "\u2273");
    definedEntities.put("&gvertneqq;", "\u2269\uFE00");
    definedEntities.put("&gvnE;", "\u2269\uFE00");
    definedEntities.put("&hArr;", "\u21D4");
    definedEntities.put("&hairsp;", "\u200A");
    definedEntities.put("&half;", "\u00BD");
    definedEntities.put("&hamilt;", "\u210B");
    definedEntities.put("&hardcy;", "\u044A");
    definedEntities.put("&harr;", "\u2194");
    definedEntities.put("&harrcir;", "\u2948");
    definedEntities.put("&harrw;", "\u21AD");
    definedEntities.put("&hbar;", "\u210F");
    definedEntities.put("&hcirc;", "\u0125");
    definedEntities.put("&hearts;", "\u2665");
    definedEntities.put("&heartsuit;", "\u2665");
    definedEntities.put("&hellip;", "\u2026");
    definedEntities.put("&hercon;", "\u22B9");
    definedEntities.put("&hfr;", "\uD835\uDD25");
    definedEntities.put("&hksearow;", "\u2925");
    definedEntities.put("&hkswarow;", "\u2926");
    definedEntities.put("&hoarr;", "\u21FF");
    definedEntities.put("&homtht;", "\u223B");
    definedEntities.put("&hookleftarrow;", "\u21A9");
    definedEntities.put("&hookrightarrow;", "\u21AA");
    definedEntities.put("&hopf;", "\uD835\uDD59");
    definedEntities.put("&horbar;", "\u2015");
    definedEntities.put("&hscr;", "\uD835\uDCBD");
    definedEntities.put("&hslash;", "\u210F");
    definedEntities.put("&hstrok;", "\u0127");
    definedEntities.put("&hybull;", "\u2043");
    definedEntities.put("&hyphen;", "\u2010");
    definedEntities.put("&iacute;", "\u00ED");
    definedEntities.put("&ic;", "\u2063");
    definedEntities.put("&icirc;", "\u00EE");
    definedEntities.put("&icy;", "\u0438");
    definedEntities.put("&iecy;", "\u0435");
    definedEntities.put("&iexcl;", "\u00A1");
    definedEntities.put("&iff;", "\u21D4");
    definedEntities.put("&ifr;", "\uD835\uDD26");
    definedEntities.put("&igrave;", "\u00EC");
    definedEntities.put("&ii;", "\u2148");
    definedEntities.put("&iiiint;", "\u2A0C");
    definedEntities.put("&iiint;", "\u222D");
    definedEntities.put("&iinfin;", "\u29DC");
    definedEntities.put("&iiota;", "\u2129");
    definedEntities.put("&ijlig;", "\u0133");
    definedEntities.put("&imacr;", "\u012B");
    definedEntities.put("&image;", "\u2111");
    definedEntities.put("&imagline;", "\u2110");
    definedEntities.put("&imagpart;", "\u2111");
    definedEntities.put("&imath;", "\u0131");
    definedEntities.put("&imof;", "\u22B7");
    definedEntities.put("&imped;", "\u01B5");
    definedEntities.put("&in;", "\u2208");
    definedEntities.put("&incare;", "\u2105");
    definedEntities.put("&infin;", "\u221E");
    definedEntities.put("&infintie;", "\u29DD");
    definedEntities.put("&inodot;", "\u0131");
    definedEntities.put("&int;", "\u222B");
    definedEntities.put("&intcal;", "\u22BA");
    definedEntities.put("&integers;", "\u2124");
    definedEntities.put("&intercal;", "\u22BA");
    definedEntities.put("&intlarhk;", "\u2A17");
    definedEntities.put("&intprod;", "\u2A3C");
    definedEntities.put("&iocy;", "\u0451");
    definedEntities.put("&iogon;", "\u012F");
    definedEntities.put("&iopf;", "\uD835\uDD5A");
    definedEntities.put("&iota;", "\u03B9");
    definedEntities.put("&iprod;", "\u2A3C");
    definedEntities.put("&iquest;", "\u00BF");
    definedEntities.put("&iscr;", "\uD835\uDCBE");
    definedEntities.put("&isin;", "\u2208");
    definedEntities.put("&isinE;", "\u22F9");
    definedEntities.put("&isindot;", "\u22F5");
    definedEntities.put("&isins;", "\u22F4");
    definedEntities.put("&isinsv;", "\u22F3");
    definedEntities.put("&isinv;", "\u2208");
    definedEntities.put("&it;", "\u2062");
    definedEntities.put("&itilde;", "\u0129");
    definedEntities.put("&iukcy;", "\u0456");
    definedEntities.put("&iuml;", "\u00EF");
    definedEntities.put("&jcirc;", "\u0135");
    definedEntities.put("&jcy;", "\u0439");
    definedEntities.put("&jfr;", "\uD835\uDD27");
    definedEntities.put("&jmath;", "\u0237");
    definedEntities.put("&jopf;", "\uD835\uDD5B");
    definedEntities.put("&jscr;", "\uD835\uDCBF");
    definedEntities.put("&jsercy;", "\u0458");
    definedEntities.put("&jukcy;", "\u0454");
    definedEntities.put("&kappa;", "\u03BA");
    definedEntities.put("&kappav;", "\u03F0");
    definedEntities.put("&kcedil;", "\u0137");
    definedEntities.put("&kcy;", "\u043A");
    definedEntities.put("&kfr;", "\uD835\uDD28");
    definedEntities.put("&kgreen;", "\u0138");
    definedEntities.put("&khcy;", "\u0445");
    definedEntities.put("&kjcy;", "\u045C");
    definedEntities.put("&kopf;", "\uD835\uDD5C");
    definedEntities.put("&kscr;", "\uD835\uDCC0");
    definedEntities.put("&lAarr;", "\u21DA");
    definedEntities.put("&lArr;", "\u21D0");
    definedEntities.put("&lAtail;", "\u291B");
    definedEntities.put("&lBarr;", "\u290E");
    definedEntities.put("&lE;", "\u2266");
    definedEntities.put("&lEg;", "\u2A8B");
    definedEntities.put("&lHar;", "\u2962");
    definedEntities.put("&lacute;", "\u013A");
    definedEntities.put("&laemptyv;", "\u29B4");
    definedEntities.put("&lagran;", "\u2112");
    definedEntities.put("&lambda;", "\u03BB");
    definedEntities.put("&lang;", "\u27E8");
    definedEntities.put("&langd;", "\u2991");
    definedEntities.put("&langle;", "\u27E8");
    definedEntities.put("&lap;", "\u2A85");
    definedEntities.put("&laquo;", "\u00AB");
    definedEntities.put("&larr;", "\u2190");
    definedEntities.put("&larrb;", "\u21E4");
    definedEntities.put("&larrbfs;", "\u291F");
    definedEntities.put("&larrfs;", "\u291D");
    definedEntities.put("&larrhk;", "\u21A9");
    definedEntities.put("&larrlp;", "\u21AB");
    definedEntities.put("&larrpl;", "\u2939");
    definedEntities.put("&larrsim;", "\u2973");
    definedEntities.put("&larrtl;", "\u21A2");
    definedEntities.put("&lat;", "\u2AAB");
    definedEntities.put("&latail;", "\u2919");
    definedEntities.put("&late;", "\u2AAD");
    definedEntities.put("&lates;", "\u2AAD\uFE00");
    definedEntities.put("&lbarr;", "\u290C");
    definedEntities.put("&lbbrk;", "\u2772");
    definedEntities.put("&lbrace;", "\u007B");
    definedEntities.put("&lbrack;", "\u005B");
    definedEntities.put("&lbrke;", "\u298B");
    definedEntities.put("&lbrksld;", "\u298F");
    definedEntities.put("&lbrkslu;", "\u298D");
    definedEntities.put("&lcaron;", "\u013E");
    definedEntities.put("&lcedil;", "\u013C");
    definedEntities.put("&lceil;", "\u2308");
    definedEntities.put("&lcub;", "\u007B");
    definedEntities.put("&lcy;", "\u043B");
    definedEntities.put("&ldca;", "\u2936");
    definedEntities.put("&ldquo;", "\u201C");
    definedEntities.put("&ldquor;", "\u201E");
    definedEntities.put("&ldrdhar;", "\u2967");
    definedEntities.put("&ldrushar;", "\u294B");
    definedEntities.put("&ldsh;", "\u21B2");
    definedEntities.put("&le;", "\u2264");
    definedEntities.put("&leftarrow;", "\u2190");
    definedEntities.put("&leftarrowtail;", "\u21A2");
    definedEntities.put("&leftharpoondown;", "\u21BD");
    definedEntities.put("&leftharpoonup;", "\u21BC");
    definedEntities.put("&leftleftarrows;", "\u21C7");
    definedEntities.put("&leftrightarrow;", "\u2194");
    definedEntities.put("&leftrightarrows;", "\u21C6");
    definedEntities.put("&leftrightharpoons;", "\u21CB");
    definedEntities.put("&leftrightsquigarrow;", "\u21AD");
    definedEntities.put("&leftthreetimes;", "\u22CB");
    definedEntities.put("&leg;", "\u22DA");
    definedEntities.put("&leq;", "\u2264");
    definedEntities.put("&leqq;", "\u2266");
    definedEntities.put("&leqslant;", "\u2A7D");
    definedEntities.put("&les;", "\u2A7D");
    definedEntities.put("&lescc;", "\u2AA8");
    definedEntities.put("&lesdot;", "\u2A7F");
    definedEntities.put("&lesdoto;", "\u2A81");
    definedEntities.put("&lesdotor;", "\u2A83");
    definedEntities.put("&lesg;", "\u22DA\uFE00");
    definedEntities.put("&lesges;", "\u2A93");
    definedEntities.put("&lessapprox;", "\u2A85");
    definedEntities.put("&lessdot;", "\u22D6");
    definedEntities.put("&lesseqgtr;", "\u22DA");
    definedEntities.put("&lesseqqgtr;", "\u2A8B");
    definedEntities.put("&lessgtr;", "\u2276");
    definedEntities.put("&lesssim;", "\u2272");
    definedEntities.put("&lfisht;", "\u297C");
    definedEntities.put("&lfloor;", "\u230A");
    definedEntities.put("&lfr;", "\uD835\uDD29");
    definedEntities.put("&lg;", "\u2276");
    definedEntities.put("&lgE;", "\u2A91");
    definedEntities.put("&lhard;", "\u21BD");
    definedEntities.put("&lharu;", "\u21BC");
    definedEntities.put("&lharul;", "\u296A");
    definedEntities.put("&lhblk;", "\u2584");
    definedEntities.put("&ljcy;", "\u0459");
    definedEntities.put("&ll;", "\u226A");
    definedEntities.put("&llarr;", "\u21C7");
    definedEntities.put("&llcorner;", "\u231E");
    definedEntities.put("&llhard;", "\u296B");
    definedEntities.put("&lltri;", "\u25FA");
    definedEntities.put("&lmidot;", "\u0140");
    definedEntities.put("&lmoust;", "\u23B0");
    definedEntities.put("&lmoustache;", "\u23B0");
    definedEntities.put("&lnE;", "\u2268");
    definedEntities.put("&lnap;", "\u2A89");
    definedEntities.put("&lnapprox;", "\u2A89");
    definedEntities.put("&lne;", "\u2A87");
    definedEntities.put("&lneq;", "\u2A87");
    definedEntities.put("&lneqq;", "\u2268");
    definedEntities.put("&lnsim;", "\u22E6");
    definedEntities.put("&loang;", "\u27EC");
    definedEntities.put("&loarr;", "\u21FD");
    definedEntities.put("&lobrk;", "\u27E6");
    definedEntities.put("&longleftarrow;", "\u27F5");
    definedEntities.put("&longleftrightarrow;", "\u27F7");
    definedEntities.put("&longmapsto;", "\u27FC");
    definedEntities.put("&longrightarrow;", "\u27F6");
    definedEntities.put("&looparrowleft;", "\u21AB");
    definedEntities.put("&looparrowright;", "\u21AC");
    definedEntities.put("&lopar;", "\u2985");
    definedEntities.put("&lopf;", "\uD835\uDD5D");
    definedEntities.put("&loplus;", "\u2A2D");
    definedEntities.put("&lotimes;", "\u2A34");
    definedEntities.put("&lowast;", "\u2217");
    definedEntities.put("&lowbar;", "\u005F");
    definedEntities.put("&loz;", "\u25CA");
    definedEntities.put("&lozenge;", "\u25CA");
    definedEntities.put("&lozf;", "\u29EB");
    definedEntities.put("&lpar;", "\u0028");
    definedEntities.put("&lparlt;", "\u2993");
    definedEntities.put("&lrarr;", "\u21C6");
    definedEntities.put("&lrcorner;", "\u231F");
    definedEntities.put("&lrhar;", "\u21CB");
    definedEntities.put("&lrhard;", "\u296D");
    definedEntities.put("&lrm;", "\u200E");
    definedEntities.put("&lrtri;", "\u22BF");
    definedEntities.put("&lsaquo;", "\u2039");
    definedEntities.put("&lscr;", "\uD835\uDCC1");
    definedEntities.put("&lsh;", "\u21B0");
    definedEntities.put("&lsim;", "\u2272");
    definedEntities.put("&lsime;", "\u2A8D");
    definedEntities.put("&lsimg;", "\u2A8F");
    definedEntities.put("&lsqb;", "\u005B");
    definedEntities.put("&lsquo;", "\u2018");
    definedEntities.put("&lsquor;", "\u201A");
    definedEntities.put("&lstrok;", "\u0142");
//    definedEntities.put("&lt;", "\u003C");
    definedEntities.put("&ltcc;", "\u2AA6");
    definedEntities.put("&ltcir;", "\u2A79");
    definedEntities.put("&ltdot;", "\u22D6");
    definedEntities.put("&lthree;", "\u22CB");
    definedEntities.put("&ltimes;", "\u22C9");
    definedEntities.put("&ltlarr;", "\u2976");
    definedEntities.put("&ltquest;", "\u2A7B");
    definedEntities.put("&ltrPar;", "\u2996");
    definedEntities.put("&ltri;", "\u25C3");
    definedEntities.put("&ltrie;", "\u22B4");
    definedEntities.put("&ltrif;", "\u25C2");
    definedEntities.put("&lurdshar;", "\u294A");
    definedEntities.put("&luruhar;", "\u2966");
    definedEntities.put("&lvertneqq;", "\u2268\uFE00");
    definedEntities.put("&lvnE;", "\u2268\uFE00");
    definedEntities.put("&mDDot;", "\u223A");
    definedEntities.put("&macr;", "\u00AF");
    definedEntities.put("&male;", "\u2642");
    definedEntities.put("&malt;", "\u2720");
    definedEntities.put("&maltese;", "\u2720");
    definedEntities.put("&map;", "\u21A6");
    definedEntities.put("&mapsto;", "\u21A6");
    definedEntities.put("&mapstodown;", "\u21A7");
    definedEntities.put("&mapstoleft;", "\u21A4");
    definedEntities.put("&mapstoup;", "\u21A5");
    definedEntities.put("&marker;", "\u25AE");
    definedEntities.put("&mcomma;", "\u2A29");
    definedEntities.put("&mcy;", "\u043C");
    definedEntities.put("&mdash;", "\u2014");
    definedEntities.put("&measuredangle;", "\u2221");
    definedEntities.put("&mfr;", "\uD835\uDD2A");
    definedEntities.put("&mho;", "\u2127");
    definedEntities.put("&micro;", "\u00B5");
    definedEntities.put("&mid;", "\u2223");
    definedEntities.put("&midast;", "\u002A");
    definedEntities.put("&midcir;", "\u2AF0");
    definedEntities.put("&middot;", "\u00B7");
    definedEntities.put("&minus;", "\u2212");
    definedEntities.put("&minusb;", "\u229F");
    definedEntities.put("&minusd;", "\u2238");
    definedEntities.put("&minusdu;", "\u2A2A");
    definedEntities.put("&mlcp;", "\u2ADB");
    definedEntities.put("&mldr;", "\u2026");
    definedEntities.put("&mnplus;", "\u2213");
    definedEntities.put("&models;", "\u22A7");
    definedEntities.put("&mopf;", "\uD835\uDD5E");
    definedEntities.put("&mp;", "\u2213");
    definedEntities.put("&mscr;", "\uD835\uDCC2");
    definedEntities.put("&mstpos;", "\u223E");
    definedEntities.put("&mu;", "\u03BC");
    definedEntities.put("&multimap;", "\u22B8");
    definedEntities.put("&mumap;", "\u22B8");
    definedEntities.put("&nGg;", "\u22D9\u0338");
    definedEntities.put("&nGt;", "\u226B\u20D2");
    definedEntities.put("&nGtv;", "\u226B\u0338");
    definedEntities.put("&nLeftarrow;", "\u21CD");
    definedEntities.put("&nLeftrightarrow;", "\u21CE");
    definedEntities.put("&nLl;", "\u22D8\u0338");
    definedEntities.put("&nLt;", "\u226A\u20D2");
    definedEntities.put("&nLtv;", "\u226A\u0338");
    definedEntities.put("&nRightarrow;", "\u21CF");
    definedEntities.put("&nVDash;", "\u22AF");
    definedEntities.put("&nVdash;", "\u22AE");
    definedEntities.put("&nabla;", "\u2207");
    definedEntities.put("&nacute;", "\u0144");
    definedEntities.put("&nang;", "\u2220\u20D2");
    definedEntities.put("&nap;", "\u2249");
    definedEntities.put("&napE;", "\u2A70\u0338");
    definedEntities.put("&napid;", "\u224B\u0338");
    definedEntities.put("&napos;", "\u0149");
    definedEntities.put("&napprox;", "\u2249");
    definedEntities.put("&natur;", "\u266E");
    definedEntities.put("&natural;", "\u266E");
    definedEntities.put("&naturals;", "\u2115");
    definedEntities.put("&nbsp;", "\u00A0");
    definedEntities.put("&nbump;", "\u224E\u0338");
    definedEntities.put("&nbumpe;", "\u224F\u0338");
    definedEntities.put("&ncap;", "\u2A43");
    definedEntities.put("&ncaron;", "\u0148");
    definedEntities.put("&ncedil;", "\u0146");
    definedEntities.put("&ncong;", "\u2247");
    definedEntities.put("&ncongdot;", "\u2A6D\u0338");
    definedEntities.put("&ncup;", "\u2A42");
    definedEntities.put("&ncy;", "\u043D");
    definedEntities.put("&ndash;", "\u2013");
    definedEntities.put("&ne;", "\u2260");
    definedEntities.put("&neArr;", "\u21D7");
    definedEntities.put("&nearhk;", "\u2924");
    definedEntities.put("&nearr;", "\u2197");
    definedEntities.put("&nearrow;", "\u2197");
    definedEntities.put("&nedot;", "\u2250\u0338");
    definedEntities.put("&nequiv;", "\u2262");
    definedEntities.put("&nesear;", "\u2928");
    definedEntities.put("&nesim;", "\u2242\u0338");
    definedEntities.put("&nexist;", "\u2204");
    definedEntities.put("&nexists;", "\u2204");
    definedEntities.put("&nfr;", "\uD835\uDD2B");
    definedEntities.put("&ngE;", "\u2267\u0338");
    definedEntities.put("&nge;", "\u2271");
    definedEntities.put("&ngeq;", "\u2271");
    definedEntities.put("&ngeqq;", "\u2267\u0338");
    definedEntities.put("&ngeqslant;", "\u2A7E\u0338");
    definedEntities.put("&nges;", "\u2A7E\u0338");
    definedEntities.put("&ngsim;", "\u2275");
    definedEntities.put("&ngt;", "\u226F");
    definedEntities.put("&ngtr;", "\u226F");
    definedEntities.put("&nhArr;", "\u21CE");
    definedEntities.put("&nharr;", "\u21AE");
    definedEntities.put("&nhpar;", "\u2AF2");
    definedEntities.put("&ni;", "\u220B");
    definedEntities.put("&nis;", "\u22FC");
    definedEntities.put("&nisd;", "\u22FA");
    definedEntities.put("&niv;", "\u220B");
    definedEntities.put("&njcy;", "\u045A");
    definedEntities.put("&nlArr;", "\u21CD");
    definedEntities.put("&nlE;", "\u2266\u0338");
    definedEntities.put("&nlarr;", "\u219A");
    definedEntities.put("&nldr;", "\u2025");
    definedEntities.put("&nle;", "\u2270");
    definedEntities.put("&nleftarrow;", "\u219A");
    definedEntities.put("&nleftrightarrow;", "\u21AE");
    definedEntities.put("&nleq;", "\u2270");
    definedEntities.put("&nleqq;", "\u2266\u0338");
    definedEntities.put("&nleqslant;", "\u2A7D\u0338");
    definedEntities.put("&nles;", "\u2A7D\u0338");
    definedEntities.put("&nless;", "\u226E");
    definedEntities.put("&nlsim;", "\u2274");
    definedEntities.put("&nlt;", "\u226E");
    definedEntities.put("&nltri;", "\u22EA");
    definedEntities.put("&nltrie;", "\u22EC");
    definedEntities.put("&nmid;", "\u2224");
    definedEntities.put("&nopf;", "\uD835\uDD5F");
    definedEntities.put("&not;", "\u00AC");
    definedEntities.put("&notin;", "\u2209");
    definedEntities.put("&notinE;", "\u22F9\u0338");
    definedEntities.put("&notindot;", "\u22F5\u0338");
    definedEntities.put("&notinva;", "\u2209");
    definedEntities.put("&notinvb;", "\u22F7");
    definedEntities.put("&notinvc;", "\u22F6");
    definedEntities.put("&notni;", "\u220C");
    definedEntities.put("&notniva;", "\u220C");
    definedEntities.put("&notnivb;", "\u22FE");
    definedEntities.put("&notnivc;", "\u22FD");
    definedEntities.put("&npar;", "\u2226");
    definedEntities.put("&nparallel;", "\u2226");
    definedEntities.put("&nparsl;", "\u2AFD\u20E5");
    definedEntities.put("&npart;", "\u2202\u0338");
    definedEntities.put("&npolint;", "\u2A14");
    definedEntities.put("&npr;", "\u2280");
    definedEntities.put("&nprcue;", "\u22E0");
    definedEntities.put("&npre;", "\u2AAF\u0338");
    definedEntities.put("&nprec;", "\u2280");
    definedEntities.put("&npreceq;", "\u2AAF\u0338");
    definedEntities.put("&nrArr;", "\u21CF");
    definedEntities.put("&nrarr;", "\u219B");
    definedEntities.put("&nrarrc;", "\u2933\u0338");
    definedEntities.put("&nrarrw;", "\u219D\u0338");
    definedEntities.put("&nrightarrow;", "\u219B");
    definedEntities.put("&nrtri;", "\u22EB");
    definedEntities.put("&nrtrie;", "\u22ED");
    definedEntities.put("&nsc;", "\u2281");
    definedEntities.put("&nsccue;", "\u22E1");
    definedEntities.put("&nsce;", "\u2AB0\u0338");
    definedEntities.put("&nscr;", "\uD835\uDCC3");
    definedEntities.put("&nshortmid;", "\u2224");
    definedEntities.put("&nshortparallel;", "\u2226");
    definedEntities.put("&nsim;", "\u2241");
    definedEntities.put("&nsime;", "\u2244");
    definedEntities.put("&nsimeq;", "\u2244");
    definedEntities.put("&nsmid;", "\u2224");
    definedEntities.put("&nspar;", "\u2226");
    definedEntities.put("&nsqsube;", "\u22E2");
    definedEntities.put("&nsqsupe;", "\u22E3");
    definedEntities.put("&nsub;", "\u2284");
    definedEntities.put("&nsubE;", "\u2AC5\u0338");
    definedEntities.put("&nsube;", "\u2288");
    definedEntities.put("&nsubset;", "\u2282\u20D2");
    definedEntities.put("&nsubseteq;", "\u2288");
    definedEntities.put("&nsubseteqq;", "\u2AC5\u0338");
    definedEntities.put("&nsucc;", "\u2281");
    definedEntities.put("&nsucceq;", "\u2AB0\u0338");
    definedEntities.put("&nsup;", "\u2285");
    definedEntities.put("&nsupE;", "\u2AC6\u0338");
    definedEntities.put("&nsupe;", "\u2289");
    definedEntities.put("&nsupset;", "\u2283\u20D2");
    definedEntities.put("&nsupseteq;", "\u2289");
    definedEntities.put("&nsupseteqq;", "\u2AC6\u0338");
    definedEntities.put("&ntgl;", "\u2279");
    definedEntities.put("&ntilde;", "\u00F1");
    definedEntities.put("&ntlg;", "\u2278");
    definedEntities.put("&ntriangleleft;", "\u22EA");
    definedEntities.put("&ntrianglelefteq;", "\u22EC");
    definedEntities.put("&ntriangleright;", "\u22EB");
    definedEntities.put("&ntrianglerighteq;", "\u22ED");
    definedEntities.put("&nu;", "\u03BD");
    definedEntities.put("&num;", "\u0023");
    definedEntities.put("&numero;", "\u2116");
    definedEntities.put("&numsp;", "\u2007");
    definedEntities.put("&nvDash;", "\u22AD");
    definedEntities.put("&nvHarr;", "\u2904");
    definedEntities.put("&nvap;", "\u224D\u20D2");
    definedEntities.put("&nvdash;", "\u22AC");
    definedEntities.put("&nvge;", "\u2265\u20D2");
    definedEntities.put("&nvgt;", "\u003E\u20D2");
    definedEntities.put("&nvinfin;", "\u29DE");
    definedEntities.put("&nvlArr;", "\u2902");
    definedEntities.put("&nvle;", "\u2264\u20D2");
    definedEntities.put("&nvlt;", "\u003C\u20D2");
    definedEntities.put("&nvltrie;", "\u22B4\u20D2");
    definedEntities.put("&nvrArr;", "\u2903");
    definedEntities.put("&nvrtrie;", "\u22B5\u20D2");
    definedEntities.put("&nvsim;", "\u223C\u20D2");
    definedEntities.put("&nwArr;", "\u21D6");
    definedEntities.put("&nwarhk;", "\u2923");
    definedEntities.put("&nwarr;", "\u2196");
    definedEntities.put("&nwarrow;", "\u2196");
    definedEntities.put("&nwnear;", "\u2927");
    definedEntities.put("&oS;", "\u24C8");
    definedEntities.put("&oacute;", "\u00F3");
    definedEntities.put("&oast;", "\u229B");
    definedEntities.put("&ocir;", "\u229A");
    definedEntities.put("&ocirc;", "\u00F4");
    definedEntities.put("&ocy;", "\u043E");
    definedEntities.put("&odash;", "\u229D");
    definedEntities.put("&odblac;", "\u0151");
    definedEntities.put("&odiv;", "\u2A38");
    definedEntities.put("&odot;", "\u2299");
    definedEntities.put("&odsold;", "\u29BC");
    definedEntities.put("&oelig;", "\u0153");
    definedEntities.put("&ofcir;", "\u29BF");
    definedEntities.put("&ofr;", "\uD835\uDD2C");
    definedEntities.put("&ogon;", "\u02DB");
    definedEntities.put("&ograve;", "\u00F2");
    definedEntities.put("&ogt;", "\u29C1");
    definedEntities.put("&ohbar;", "\u29B5");
    definedEntities.put("&ohm;", "\u03A9");
    definedEntities.put("&oint;", "\u222E");
    definedEntities.put("&olarr;", "\u21BA");
    definedEntities.put("&olcir;", "\u29BE");
    definedEntities.put("&olcross;", "\u29BB");
    definedEntities.put("&oline;", "\u203E");
    definedEntities.put("&olt;", "\u29C0");
    definedEntities.put("&omacr;", "\u014D");
    definedEntities.put("&omega;", "\u03C9");
    definedEntities.put("&omicron;", "\u03BF");
    definedEntities.put("&omid;", "\u29B6");
    definedEntities.put("&ominus;", "\u2296");
    definedEntities.put("&oopf;", "\uD835\uDD60");
    definedEntities.put("&opar;", "\u29B7");
    definedEntities.put("&operp;", "\u29B9");
    definedEntities.put("&oplus;", "\u2295");
    definedEntities.put("&or;", "\u2228");
    definedEntities.put("&orarr;", "\u21BB");
    definedEntities.put("&ord;", "\u2A5D");
    definedEntities.put("&order;", "\u2134");
    definedEntities.put("&orderof;", "\u2134");
    definedEntities.put("&ordf;", "\u00AA");
    definedEntities.put("&ordm;", "\u00BA");
    definedEntities.put("&origof;", "\u22B6");
    definedEntities.put("&oror;", "\u2A56");
    definedEntities.put("&orslope;", "\u2A57");
    definedEntities.put("&orv;", "\u2A5B");
    definedEntities.put("&oscr;", "\u2134");
    definedEntities.put("&oslash;", "\u00F8");
    definedEntities.put("&osol;", "\u2298");
    definedEntities.put("&otilde;", "\u00F5");
    definedEntities.put("&otimes;", "\u2297");
    definedEntities.put("&otimesas;", "\u2A36");
    definedEntities.put("&ouml;", "\u00F6");
    definedEntities.put("&ovbar;", "\u233D");
    definedEntities.put("&par;", "\u2225");
    definedEntities.put("&para;", "\u00B6");
    definedEntities.put("&parallel;", "\u2225");
    definedEntities.put("&parsim;", "\u2AF3");
    definedEntities.put("&parsl;", "\u2AFD");
    definedEntities.put("&part;", "\u2202");
    definedEntities.put("&pcy;", "\u043F");
    definedEntities.put("&percnt;", "\u0025");
    definedEntities.put("&period;", "\u002E");
    definedEntities.put("&permil;", "\u2030");
    definedEntities.put("&perp;", "\u22A5");
    definedEntities.put("&pertenk;", "\u2031");
    definedEntities.put("&pfr;", "\uD835\uDD2D");
    definedEntities.put("&phi;", "\u03C6");
    definedEntities.put("&phiv;", "\u03D5");
    definedEntities.put("&phmmat;", "\u2133");
    definedEntities.put("&phone;", "\u260E");
    definedEntities.put("&pi;", "\u03C0");
    definedEntities.put("&pitchfork;", "\u22D4");
    definedEntities.put("&piv;", "\u03D6");
    definedEntities.put("&planck;", "\u210F");
    definedEntities.put("&planckh;", "\u210E");
    definedEntities.put("&plankv;", "\u210F");
    definedEntities.put("&plus;", "\u002B");
    definedEntities.put("&plusacir;", "\u2A23");
    definedEntities.put("&plusb;", "\u229E");
    definedEntities.put("&pluscir;", "\u2A22");
    definedEntities.put("&plusdo;", "\u2214");
    definedEntities.put("&plusdu;", "\u2A25");
    definedEntities.put("&pluse;", "\u2A72");
    definedEntities.put("&plusmn;", "\u00B1");
    definedEntities.put("&plussim;", "\u2A26");
    definedEntities.put("&plustwo;", "\u2A27");
    definedEntities.put("&pm;", "\u00B1");
    definedEntities.put("&pointint;", "\u2A15");
    definedEntities.put("&popf;", "\uD835\uDD61");
    definedEntities.put("&pound;", "\u00A3");
    definedEntities.put("&pr;", "\u227A");
    definedEntities.put("&prE;", "\u2AB3");
    definedEntities.put("&prap;", "\u2AB7");
    definedEntities.put("&prcue;", "\u227C");
    definedEntities.put("&pre;", "\u2AAF");
    definedEntities.put("&prec;", "\u227A");
    definedEntities.put("&precapprox;", "\u2AB7");
    definedEntities.put("&preccurlyeq;", "\u227C");
    definedEntities.put("&preceq;", "\u2AAF");
    definedEntities.put("&precnapprox;", "\u2AB9");
    definedEntities.put("&precneqq;", "\u2AB5");
    definedEntities.put("&precnsim;", "\u22E8");
    definedEntities.put("&precsim;", "\u227E");
    definedEntities.put("&prime;", "\u2032");
    definedEntities.put("&primes;", "\u2119");
    definedEntities.put("&prnE;", "\u2AB5");
    definedEntities.put("&prnap;", "\u2AB9");
    definedEntities.put("&prnsim;", "\u22E8");
    definedEntities.put("&prod;", "\u220F");
    definedEntities.put("&profalar;", "\u232E");
    definedEntities.put("&profline;", "\u2312");
    definedEntities.put("&profsurf;", "\u2313");
    definedEntities.put("&prop;", "\u221D");
    definedEntities.put("&propto;", "\u221D");
    definedEntities.put("&prsim;", "\u227E");
    definedEntities.put("&prurel;", "\u22B0");
    definedEntities.put("&pscr;", "\uD835\uDCC5");
    definedEntities.put("&psi;", "\u03C8");
    definedEntities.put("&puncsp;", "\u2008");
    definedEntities.put("&qfr;", "\uD835\uDD2E");
    definedEntities.put("&qint;", "\u2A0C");
    definedEntities.put("&qopf;", "\uD835\uDD62");
    definedEntities.put("&qprime;", "\u2057");
    definedEntities.put("&qscr;", "\uD835\uDCC6");
    definedEntities.put("&quaternions;", "\u210D");
    definedEntities.put("&quatint;", "\u2A16");
    definedEntities.put("&quest;", "\u003F");
    definedEntities.put("&questeq;", "\u225F");
//    definedEntities.put("&quot;", "\\u0022");
    definedEntities.put("&rAarr;", "\u21DB");
    definedEntities.put("&rArr;", "\u21D2");
    definedEntities.put("&rAtail;", "\u291C");
    definedEntities.put("&rBarr;", "\u290F");
    definedEntities.put("&rHar;", "\u2964");
    definedEntities.put("&race;", "\u223D\u0331");
    definedEntities.put("&racute;", "\u0155");
    definedEntities.put("&radic;", "\u221A");
    definedEntities.put("&raemptyv;", "\u29B3");
    definedEntities.put("&rang;", "\u27E9");
    definedEntities.put("&rangd;", "\u2992");
    definedEntities.put("&range;", "\u29A5");
    definedEntities.put("&rangle;", "\u27E9");
    definedEntities.put("&raquo;", "\u00BB");
    definedEntities.put("&rarr;", "\u2192");
    definedEntities.put("&rarrap;", "\u2975");
    definedEntities.put("&rarrb;", "\u21E5");
    definedEntities.put("&rarrbfs;", "\u2920");
    definedEntities.put("&rarrc;", "\u2933");
    definedEntities.put("&rarrfs;", "\u291E");
    definedEntities.put("&rarrhk;", "\u21AA");
    definedEntities.put("&rarrlp;", "\u21AC");
    definedEntities.put("&rarrpl;", "\u2945");
    definedEntities.put("&rarrsim;", "\u2974");
    definedEntities.put("&rarrtl;", "\u21A3");
    definedEntities.put("&rarrw;", "\u219D");
    definedEntities.put("&ratail;", "\u291A");
    definedEntities.put("&ratio;", "\u2236");
    definedEntities.put("&rationals;", "\u211A");
    definedEntities.put("&rbarr;", "\u290D");
    definedEntities.put("&rbbrk;", "\u2773");
    definedEntities.put("&rbrace;", "\u007D");
    definedEntities.put("&rbrack;", "\u005D");
    definedEntities.put("&rbrke;", "\u298C");
    definedEntities.put("&rbrksld;", "\u298E");
    definedEntities.put("&rbrkslu;", "\u2990");
    definedEntities.put("&rcaron;", "\u0159");
    definedEntities.put("&rcedil;", "\u0157");
    definedEntities.put("&rceil;", "\u2309");
    definedEntities.put("&rcub;", "\u007D");
    definedEntities.put("&rcy;", "\u0440");
    definedEntities.put("&rdca;", "\u2937");
    definedEntities.put("&rdldhar;", "\u2969");
    definedEntities.put("&rdquo;", "\u201D");
    definedEntities.put("&rdquor;", "\u201D");
    definedEntities.put("&rdsh;", "\u21B3");
    definedEntities.put("&real;", "\u211C");
    definedEntities.put("&realine;", "\u211B");
    definedEntities.put("&realpart;", "\u211C");
    definedEntities.put("&reals;", "\u211D");
    definedEntities.put("&rect;", "\u25AD");
    definedEntities.put("&reg;", "\u00AE");
    definedEntities.put("&rfisht;", "\u297D");
    definedEntities.put("&rfloor;", "\u230B");
    definedEntities.put("&rfr;", "\uD835\uDD2F");
    definedEntities.put("&rhard;", "\u21C1");
    definedEntities.put("&rharu;", "\u21C0");
    definedEntities.put("&rharul;", "\u296C");
    definedEntities.put("&rho;", "\u03C1");
    definedEntities.put("&rhov;", "\u03F1");
    definedEntities.put("&rightarrow;", "\u2192");
    definedEntities.put("&rightarrowtail;", "\u21A3");
    definedEntities.put("&rightharpoondown;", "\u21C1");
    definedEntities.put("&rightharpoonup;", "\u21C0");
    definedEntities.put("&rightleftarrows;", "\u21C4");
    definedEntities.put("&rightleftharpoons;", "\u21CC");
    definedEntities.put("&rightrightarrows;", "\u21C9");
    definedEntities.put("&rightsquigarrow;", "\u219D");
    definedEntities.put("&rightthreetimes;", "\u22CC");
    definedEntities.put("&ring;", "\u02DA");
    definedEntities.put("&risingdotseq;", "\u2253");
    definedEntities.put("&rlarr;", "\u21C4");
    definedEntities.put("&rlhar;", "\u21CC");
    definedEntities.put("&rlm;", "\u200F");
    definedEntities.put("&rmoust;", "\u23B1");
    definedEntities.put("&rmoustache;", "\u23B1");
    definedEntities.put("&rnmid;", "\u2AEE");
    definedEntities.put("&roang;", "\u27ED");
    definedEntities.put("&roarr;", "\u21FE");
    definedEntities.put("&robrk;", "\u27E7");
    definedEntities.put("&ropar;", "\u2986");
    definedEntities.put("&ropf;", "\uD835\uDD63");
    definedEntities.put("&roplus;", "\u2A2E");
    definedEntities.put("&rotimes;", "\u2A35");
    definedEntities.put("&rpar;", "\u0029");
    definedEntities.put("&rpargt;", "\u2994");
    definedEntities.put("&rppolint;", "\u2A12");
    definedEntities.put("&rrarr;", "\u21C9");
    definedEntities.put("&rsaquo;", "\u203A");
    definedEntities.put("&rscr;", "\uD835\uDCC7");
    definedEntities.put("&rsh;", "\u21B1");
    definedEntities.put("&rsqb;", "\u005D");
    definedEntities.put("&rsquo;", "\u2019");
    definedEntities.put("&rsquor;", "\u2019");
    definedEntities.put("&rthree;", "\u22CC");
    definedEntities.put("&rtimes;", "\u22CA");
    definedEntities.put("&rtri;", "\u25B9");
    definedEntities.put("&rtrie;", "\u22B5");
    definedEntities.put("&rtrif;", "\u25B8");
    definedEntities.put("&rtriltri;", "\u29CE");
    definedEntities.put("&ruluhar;", "\u2968");
    definedEntities.put("&rx;", "\u211E");
    definedEntities.put("&sacute;", "\u015B");
    definedEntities.put("&sbquo;", "\u201A");
    definedEntities.put("&sc;", "\u227B");
    definedEntities.put("&scE;", "\u2AB4");
    definedEntities.put("&scap;", "\u2AB8");
    definedEntities.put("&scaron;", "\u0161");
    definedEntities.put("&sccue;", "\u227D");
    definedEntities.put("&sce;", "\u2AB0");
    definedEntities.put("&scedil;", "\u015F");
    definedEntities.put("&scirc;", "\u015D");
    definedEntities.put("&scnE;", "\u2AB6");
    definedEntities.put("&scnap;", "\u2ABA");
    definedEntities.put("&scnsim;", "\u22E9");
    definedEntities.put("&scpolint;", "\u2A13");
    definedEntities.put("&scsim;", "\u227F");
    definedEntities.put("&scy;", "\u0441");
    definedEntities.put("&sdot;", "\u22C5");
    definedEntities.put("&sdotb;", "\u22A1");
    definedEntities.put("&sdote;", "\u2A66");
    definedEntities.put("&seArr;", "\u21D8");
    definedEntities.put("&searhk;", "\u2925");
    definedEntities.put("&searr;", "\u2198");
    definedEntities.put("&searrow;", "\u2198");
    definedEntities.put("&sect;", "\u00A7");
    definedEntities.put("&semi;", "\u003B");
    definedEntities.put("&seswar;", "\u2929");
    definedEntities.put("&setminus;", "\u2216");
    definedEntities.put("&setmn;", "\u2216");
    definedEntities.put("&sext;", "\u2736");
    definedEntities.put("&sfr;", "\uD835\uDD30");
    definedEntities.put("&sfrown;", "\u2322");
    definedEntities.put("&sharp;", "\u266F");
    definedEntities.put("&shchcy;", "\u0449");
    definedEntities.put("&shcy;", "\u0448");
    definedEntities.put("&shortmid;", "\u2223");
    definedEntities.put("&shortparallel;", "\u2225");
    definedEntities.put("&shy;", "\u00AD");
    definedEntities.put("&sigma;", "\u03C3");
    definedEntities.put("&sigmaf;", "\u03C2");
    definedEntities.put("&sigmav;", "\u03C2");
    definedEntities.put("&sim;", "\u223C");
    definedEntities.put("&simdot;", "\u2A6A");
    definedEntities.put("&sime;", "\u2243");
    definedEntities.put("&simeq;", "\u2243");
    definedEntities.put("&simg;", "\u2A9E");
    definedEntities.put("&simgE;", "\u2AA0");
    definedEntities.put("&siml;", "\u2A9D");
    definedEntities.put("&simlE;", "\u2A9F");
    definedEntities.put("&simne;", "\u2246");
    definedEntities.put("&simplus;", "\u2A24");
    definedEntities.put("&simrarr;", "\u2972");
    definedEntities.put("&slarr;", "\u2190");
    definedEntities.put("&smallsetminus;", "\u2216");
    definedEntities.put("&smashp;", "\u2A33");
    definedEntities.put("&smeparsl;", "\u29E4");
    definedEntities.put("&smid;", "\u2223");
    definedEntities.put("&smile;", "\u2323");
    definedEntities.put("&smt;", "\u2AAA");
    definedEntities.put("&smte;", "\u2AAC");
    definedEntities.put("&smtes;", "\u2AAC\uFE00");
    definedEntities.put("&softcy;", "\u044C");
    definedEntities.put("&sol;", "\u002F");
    definedEntities.put("&solb;", "\u29C4");
    definedEntities.put("&solbar;", "\u233F");
    definedEntities.put("&sopf;", "\uD835\uDD64");
    definedEntities.put("&spades;", "\u2660");
    definedEntities.put("&spadesuit;", "\u2660");
    definedEntities.put("&spar;", "\u2225");
    definedEntities.put("&sqcap;", "\u2293");
    definedEntities.put("&sqcaps;", "\u2293\uFE00");
    definedEntities.put("&sqcup;", "\u2294");
    definedEntities.put("&sqcups;", "\u2294\uFE00");
    definedEntities.put("&sqsub;", "\u228F");
    definedEntities.put("&sqsube;", "\u2291");
    definedEntities.put("&sqsubset;", "\u228F");
    definedEntities.put("&sqsubseteq;", "\u2291");
    definedEntities.put("&sqsup;", "\u2290");
    definedEntities.put("&sqsupe;", "\u2292");
    definedEntities.put("&sqsupset;", "\u2290");
    definedEntities.put("&sqsupseteq;", "\u2292");
    definedEntities.put("&squ;", "\u25A1");
    definedEntities.put("&square;", "\u25A1");
    definedEntities.put("&squarf;", "\u25AA");
    definedEntities.put("&squf;", "\u25AA");
    definedEntities.put("&srarr;", "\u2192");
    definedEntities.put("&sscr;", "\uD835\uDCC8");
    definedEntities.put("&ssetmn;", "\u2216");
    definedEntities.put("&ssmile;", "\u2323");
    definedEntities.put("&sstarf;", "\u22C6");
    definedEntities.put("&star;", "\u2606");
    definedEntities.put("&starf;", "\u2605");
    definedEntities.put("&straightepsilon;", "\u03F5");
    definedEntities.put("&straightphi;", "\u03D5");
    definedEntities.put("&strns;", "\u00AF");
    definedEntities.put("&sub;", "\u2282");
    definedEntities.put("&subE;", "\u2AC5");
    definedEntities.put("&subdot;", "\u2ABD");
    definedEntities.put("&sube;", "\u2286");
    definedEntities.put("&subedot;", "\u2AC3");
    definedEntities.put("&submult;", "\u2AC1");
    definedEntities.put("&subnE;", "\u2ACB");
    definedEntities.put("&subne;", "\u228A");
    definedEntities.put("&subplus;", "\u2ABF");
    definedEntities.put("&subrarr;", "\u2979");
    definedEntities.put("&subset;", "\u2282");
    definedEntities.put("&subseteq;", "\u2286");
    definedEntities.put("&subseteqq;", "\u2AC5");
    definedEntities.put("&subsetneq;", "\u228A");
    definedEntities.put("&subsetneqq;", "\u2ACB");
    definedEntities.put("&subsim;", "\u2AC7");
    definedEntities.put("&subsub;", "\u2AD5");
    definedEntities.put("&subsup;", "\u2AD3");
    definedEntities.put("&succ;", "\u227B");
    definedEntities.put("&succapprox;", "\u2AB8");
    definedEntities.put("&succcurlyeq;", "\u227D");
    definedEntities.put("&succeq;", "\u2AB0");
    definedEntities.put("&succnapprox;", "\u2ABA");
    definedEntities.put("&succneqq;", "\u2AB6");
    definedEntities.put("&succnsim;", "\u22E9");
    definedEntities.put("&succsim;", "\u227F");
    definedEntities.put("&sum;", "\u2211");
    definedEntities.put("&sung;", "\u266A");
    definedEntities.put("&sup1;", "\u00B9");
    definedEntities.put("&sup2;", "\u00B2");
    definedEntities.put("&sup3;", "\u00B3");
    definedEntities.put("&sup;", "\u2283");
    definedEntities.put("&supE;", "\u2AC6");
    definedEntities.put("&supdot;", "\u2ABE");
    definedEntities.put("&supdsub;", "\u2AD8");
    definedEntities.put("&supe;", "\u2287");
    definedEntities.put("&supedot;", "\u2AC4");
    definedEntities.put("&suphsol;", "\u27C9");
    definedEntities.put("&suphsub;", "\u2AD7");
    definedEntities.put("&suplarr;", "\u297B");
    definedEntities.put("&supmult;", "\u2AC2");
    definedEntities.put("&supnE;", "\u2ACC");
    definedEntities.put("&supne;", "\u228B");
    definedEntities.put("&supplus;", "\u2AC0");
    definedEntities.put("&supset;", "\u2283");
    definedEntities.put("&supseteq;", "\u2287");
    definedEntities.put("&supseteqq;", "\u2AC6");
    definedEntities.put("&supsetneq;", "\u228B");
    definedEntities.put("&supsetneqq;", "\u2ACC");
    definedEntities.put("&supsim;", "\u2AC8");
    definedEntities.put("&supsub;", "\u2AD4");
    definedEntities.put("&supsup;", "\u2AD6");
    definedEntities.put("&swArr;", "\u21D9");
    definedEntities.put("&swarhk;", "\u2926");
    definedEntities.put("&swarr;", "\u2199");
    definedEntities.put("&swarrow;", "\u2199");
    definedEntities.put("&swnwar;", "\u292A");
    definedEntities.put("&szlig;", "\u00DF");
    definedEntities.put("&target;", "\u2316");
    definedEntities.put("&tau;", "\u03C4");
    definedEntities.put("&tbrk;", "\u23B4");
    definedEntities.put("&tcaron;", "\u0165");
    definedEntities.put("&tcedil;", "\u0163");
    definedEntities.put("&tcy;", "\u0442");
    definedEntities.put("&tdot;", "\u20DB");
    definedEntities.put("&telrec;", "\u2315");
    definedEntities.put("&tfr;", "\uD835\uDD31");
    definedEntities.put("&there4;", "\u2234");
    definedEntities.put("&therefore;", "\u2234");
    definedEntities.put("&theta;", "\u03B8");
    definedEntities.put("&thetasym;", "\u03D1");
    definedEntities.put("&thetav;", "\u03D1");
    definedEntities.put("&thickapprox;", "\u2248");
    definedEntities.put("&thicksim;", "\u223C");
    definedEntities.put("&thinsp;", "\u2009");
    definedEntities.put("&thkap;", "\u2248");
    definedEntities.put("&thksim;", "\u223C");
    definedEntities.put("&thorn;", "\u00FE");
    definedEntities.put("&tilde;", "\u02DC");
    definedEntities.put("&times;", "\u00D7");
    definedEntities.put("&timesb;", "\u22A0");
    definedEntities.put("&timesbar;", "\u2A31");
    definedEntities.put("&timesd;", "\u2A30");
    definedEntities.put("&tint;", "\u222D");
    definedEntities.put("&toea;", "\u2928");
    definedEntities.put("&top;", "\u22A4");
    definedEntities.put("&topbot;", "\u2336");
    definedEntities.put("&topcir;", "\u2AF1");
    definedEntities.put("&topf;", "\uD835\uDD65");
    definedEntities.put("&topfork;", "\u2ADA");
    definedEntities.put("&tosa;", "\u2929");
    definedEntities.put("&tprime;", "\u2034");
    definedEntities.put("&trade;", "\u2122");
    definedEntities.put("&triangle;", "\u25B5");
    definedEntities.put("&triangledown;", "\u25BF");
    definedEntities.put("&triangleleft;", "\u25C3");
    definedEntities.put("&trianglelefteq;", "\u22B4");
    definedEntities.put("&triangleq;", "\u225C");
    definedEntities.put("&triangleright;", "\u25B9");
    definedEntities.put("&trianglerighteq;", "\u22B5");
    definedEntities.put("&tridot;", "\u25EC");
    definedEntities.put("&trie;", "\u225C");
    definedEntities.put("&triminus;", "\u2A3A");
    definedEntities.put("&triplus;", "\u2A39");
    definedEntities.put("&trisb;", "\u29CD");
    definedEntities.put("&tritime;", "\u2A3B");
    definedEntities.put("&trpezium;", "\u23E2");
    definedEntities.put("&tscr;", "\uD835\uDCC9");
    definedEntities.put("&tscy;", "\u0446");
    definedEntities.put("&tshcy;", "\u045B");
    definedEntities.put("&tstrok;", "\u0167");
    definedEntities.put("&twixt;", "\u226C");
    definedEntities.put("&twoheadleftarrow;", "\u219E");
    definedEntities.put("&twoheadrightarrow;", "\u21A0");
    definedEntities.put("&uArr;", "\u21D1");
    definedEntities.put("&uHar;", "\u2963");
    definedEntities.put("&uacute;", "\u00FA");
    definedEntities.put("&uarr;", "\u2191");
    definedEntities.put("&ubrcy;", "\u045E");
    definedEntities.put("&ubreve;", "\u016D");
    definedEntities.put("&ucirc;", "\u00FB");
    definedEntities.put("&ucy;", "\u0443");
    definedEntities.put("&udarr;", "\u21C5");
    definedEntities.put("&udblac;", "\u0171");
    definedEntities.put("&udhar;", "\u296E");
    definedEntities.put("&ufisht;", "\u297E");
    definedEntities.put("&ufr;", "\uD835\uDD32");
    definedEntities.put("&ugrave;", "\u00F9");
    definedEntities.put("&uharl;", "\u21BF");
    definedEntities.put("&uharr;", "\u21BE");
    definedEntities.put("&uhblk;", "\u2580");
    definedEntities.put("&ulcorn;", "\u231C");
    definedEntities.put("&ulcorner;", "\u231C");
    definedEntities.put("&ulcrop;", "\u230F");
    definedEntities.put("&ultri;", "\u25F8");
    definedEntities.put("&umacr;", "\u016B");
    definedEntities.put("&uml;", "\u00A8");
    definedEntities.put("&uogon;", "\u0173");
    definedEntities.put("&uopf;", "\uD835\uDD66");
    definedEntities.put("&uparrow;", "\u2191");
    definedEntities.put("&updownarrow;", "\u2195");
    definedEntities.put("&upharpoonleft;", "\u21BF");
    definedEntities.put("&upharpoonright;", "\u21BE");
    definedEntities.put("&uplus;", "\u228E");
    definedEntities.put("&upsi;", "\u03C5");
    definedEntities.put("&upsih;", "\u03D2");
    definedEntities.put("&upsilon;", "\u03C5");
    definedEntities.put("&upuparrows;", "\u21C8");
    definedEntities.put("&urcorn;", "\u231D");
    definedEntities.put("&urcorner;", "\u231D");
    definedEntities.put("&urcrop;", "\u230E");
    definedEntities.put("&uring;", "\u016F");
    definedEntities.put("&urtri;", "\u25F9");
    definedEntities.put("&uscr;", "\uD835\uDCCA");
    definedEntities.put("&utdot;", "\u22F0");
    definedEntities.put("&utilde;", "\u0169");
    definedEntities.put("&utri;", "\u25B5");
    definedEntities.put("&utrif;", "\u25B4");
    definedEntities.put("&uuarr;", "\u21C8");
    definedEntities.put("&uuml;", "\u00FC");
    definedEntities.put("&uwangle;", "\u29A7");
    definedEntities.put("&vArr;", "\u21D5");
    definedEntities.put("&vBar;", "\u2AE8");
    definedEntities.put("&vBarv;", "\u2AE9");
    definedEntities.put("&vDash;", "\u22A8");
    definedEntities.put("&vangrt;", "\u299C");
    definedEntities.put("&varepsilon;", "\u03F5");
    definedEntities.put("&varkappa;", "\u03F0");
    definedEntities.put("&varnothing;", "\u2205");
    definedEntities.put("&varphi;", "\u03D5");
    definedEntities.put("&varpi;", "\u03D6");
    definedEntities.put("&varpropto;", "\u221D");
    definedEntities.put("&varr;", "\u2195");
    definedEntities.put("&varrho;", "\u03F1");
    definedEntities.put("&varsigma;", "\u03C2");
    definedEntities.put("&varsubsetneq;", "\u228A\uFE00");
    definedEntities.put("&varsubsetneqq;", "\u2ACB\uFE00");
    definedEntities.put("&varsupsetneq;", "\u228B\uFE00");
    definedEntities.put("&varsupsetneqq;", "\u2ACC\uFE00");
    definedEntities.put("&vartheta;", "\u03D1");
    definedEntities.put("&vartriangleleft;", "\u22B2");
    definedEntities.put("&vartriangleright;", "\u22B3");
    definedEntities.put("&vcy;", "\u0432");
    definedEntities.put("&vdash;", "\u22A2");
    definedEntities.put("&vee;", "\u2228");
    definedEntities.put("&veebar;", "\u22BB");
    definedEntities.put("&veeeq;", "\u225A");
    definedEntities.put("&vellip;", "\u22EE");
    definedEntities.put("&verbar;", "\u007C");
    definedEntities.put("&vert;", "\u007C");
    definedEntities.put("&vfr;", "\uD835\uDD33");
    definedEntities.put("&vltri;", "\u22B2");
    definedEntities.put("&vnsub;", "\u2282\u20D2");
    definedEntities.put("&vnsup;", "\u2283\u20D2");
    definedEntities.put("&vopf;", "\uD835\uDD67");
    definedEntities.put("&vprop;", "\u221D");
    definedEntities.put("&vrtri;", "\u22B3");
    definedEntities.put("&vscr;", "\uD835\uDCCB");
    definedEntities.put("&vsubnE;", "\u2ACB\uFE00");
    definedEntities.put("&vsubne;", "\u228A\uFE00");
    definedEntities.put("&vsupnE;", "\u2ACC\uFE00");
    definedEntities.put("&vsupne;", "\u228B\uFE00");
    definedEntities.put("&vzigzag;", "\u299A");
    definedEntities.put("&wcirc;", "\u0175");
    definedEntities.put("&wedbar;", "\u2A5F");
    definedEntities.put("&wedge;", "\u2227");
    definedEntities.put("&wedgeq;", "\u2259");
    definedEntities.put("&weierp;", "\u2118");
    definedEntities.put("&wfr;", "\uD835\uDD34");
    definedEntities.put("&wopf;", "\uD835\uDD68");
    definedEntities.put("&wp;", "\u2118");
    definedEntities.put("&wr;", "\u2240");
    definedEntities.put("&wreath;", "\u2240");
    definedEntities.put("&wscr;", "\uD835\uDCCC");
    definedEntities.put("&xcap;", "\u22C2");
    definedEntities.put("&xcirc;", "\u25EF");
    definedEntities.put("&xcup;", "\u22C3");
    definedEntities.put("&xdtri;", "\u25BD");
    definedEntities.put("&xfr;", "\uD835\uDD35");
    definedEntities.put("&xhArr;", "\u27FA");
    definedEntities.put("&xharr;", "\u27F7");
    definedEntities.put("&xi;", "\u03BE");
    definedEntities.put("&xlArr;", "\u27F8");
    definedEntities.put("&xlarr;", "\u27F5");
    definedEntities.put("&xmap;", "\u27FC");
    definedEntities.put("&xnis;", "\u22FB");
    definedEntities.put("&xodot;", "\u2A00");
    definedEntities.put("&xopf;", "\uD835\uDD69");
    definedEntities.put("&xoplus;", "\u2A01");
    definedEntities.put("&xotime;", "\u2A02");
    definedEntities.put("&xrArr;", "\u27F9");
    definedEntities.put("&xrarr;", "\u27F6");
    definedEntities.put("&xscr;", "\uD835\uDCCD");
    definedEntities.put("&xsqcup;", "\u2A06");
    definedEntities.put("&xuplus;", "\u2A04");
    definedEntities.put("&xutri;", "\u25B3");
    definedEntities.put("&xvee;", "\u22C1");
    definedEntities.put("&xwedge;", "\u22C0");
    definedEntities.put("&yacute;", "\u00FD");
    definedEntities.put("&yacy;", "\u044F");
    definedEntities.put("&ycirc;", "\u0177");
    definedEntities.put("&ycy;", "\u044B");
    definedEntities.put("&yen;", "\u00A5");
    definedEntities.put("&yfr;", "\uD835\uDD36");
    definedEntities.put("&yicy;", "\u0457");
    definedEntities.put("&yopf;", "\uD835\uDD6A");
    definedEntities.put("&yscr;", "\uD835\uDCCE");
    definedEntities.put("&yucy;", "\u044E");
    definedEntities.put("&yuml;", "\u00FF");
    definedEntities.put("&zacute;", "\u017A");
    definedEntities.put("&zcaron;", "\u017E");
    definedEntities.put("&zcy;", "\u0437");
    definedEntities.put("&zdot;", "\u017C");
    definedEntities.put("&zeetrf;", "\u2128");
    definedEntities.put("&zeta;", "\u03B6");
    definedEntities.put("&zfr;", "\uD835\uDD37");
    definedEntities.put("&zhcy;", "\u0436");
    definedEntities.put("&zigrarr;", "\u21DD");
    definedEntities.put("&zopf;", "\uD835\uDD6B");
    definedEntities.put("&zscr;", "\uD835\uDCCF");
    definedEntities.put("&zwj;", "\u200D");
    definedEntities.put("&zwnj;", "\u200C");
  }

}