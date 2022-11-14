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
import org.hl7.fhir.utilities.xhtml.XhtmlNode.Location;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XhtmlParser {
  public static final String XHTML_NS = "http://www.w3.org/1999/xhtml";
  private static final char END_OF_CHARS = (char) -1;

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
  private Map<String, String> entities = new HashMap<>();


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
  private boolean validatorMode;

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


  public boolean isValidatorMode() {
    return validatorMode;
  }

  public XhtmlParser setValidatorMode(boolean validatorMode) {
    this.validatorMode = validatorMode;
    return this;
  }

  public ParserSecurityPolicy getPolicy() {
    return policy;
  }

  public void setPolicy(ParserSecurityPolicy policy) {
    this.policy = policy; 
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
    if (!validatorMode)
      return null;
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
    if (validatorMode)
      return true;
    boolean ok = attributes.contains(attr) || attributes.contains(elem+"."+attr);
    if (ok)
      return true;
    else switch (policy) {
    case Accept: return true;
    case Drop: return false;
    case Reject: throw new FHIRFormatError("Illegal HTML attribute "+elem+"."+attr);
    }

    if ((elem+"."+attr).equals("img.src") && !(value.startsWith("#") || value.startsWith("http:") || value.startsWith("https:"))) {
      switch (policy) {
      case Accept: return true;
      case Drop: return false;
      case Reject: throw new FHIRFormatError("Illegal Image Reference "+value);
      }
    }
    return false;
  }

  private boolean elementIsOk(String name) throws FHIRFormatError  {
    if (validatorMode)
      return true;
    boolean ok = elements.contains(name);
    if (ok)
      return true;
    else switch (policy) {
    case Accept: return true;
    case Drop: return false;
    case Reject: throw new FHIRFormatError("Illegal HTML element "+name);
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
    } else {
      unwindPoint = null;
      List<XhtmlNode> p = new ArrayList<>();
      parseElementInner(root, p, nsm, true);
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
    } else {
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
      entities.put(n, v);
    }

  }

  private boolean isNameChar(char ch)
  {
    return Character.isLetterOrDigit(ch) || ch == '_' || ch == '-' || ch == ':';
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
        s.append((char) Integer.parseInt(c.substring(1)));
      else if (c.charAt(1) == 'x' && isInteger(c.substring(2), 16))
        s.append((char) Integer.parseInt(c.substring(2), 16));
    } else if (entities.containsKey(c)) {
      s.append(entities.get(c));
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

  private boolean isInteger(String s, int base) {
    try {
      Integer.parseInt(s, base);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public XhtmlNode parseFragment(String source) throws IOException, FHIRException  {
    rdr = new StringReader(source);
    return parseFragment();
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
    entities.put("&AElig;", "\u00C6");
    entities.put("&AMP;", "\u0026");
    entities.put("&Aacute;", "\u00C1");
    entities.put("&Abreve;", "\u0102");
    entities.put("&Acirc;", "\u00C2");
    entities.put("&Acy;", "\u0410");
    entities.put("&Afr;", "\uD835\uDD04");
    entities.put("&Agrave;", "\u00C0");
    entities.put("&Alpha;", "\u0391");
    entities.put("&Amacr;", "\u0100");
    entities.put("&And;", "\u2A53");
    entities.put("&Aogon;", "\u0104");
    entities.put("&Aopf;", "\uD835\uDD38");
    entities.put("&ApplyFunction;", "\u2061");
    entities.put("&Aring;", "\u00C5");
    entities.put("&Ascr;", "\uD835\uDC9C");
    entities.put("&Assign;", "\u2254");
    entities.put("&Atilde;", "\u00C3");
    entities.put("&Auml;", "\u00C4");
    entities.put("&Backslash;", "\u2216");
    entities.put("&Barv;", "\u2AE7");
    entities.put("&Barwed;", "\u2306");
    entities.put("&Bcy;", "\u0411");
    entities.put("&Because;", "\u2235");
    entities.put("&Bernoullis;", "\u212C");
    entities.put("&Beta;", "\u0392");
    entities.put("&Bfr;", "\uD835\uDD05");
    entities.put("&Bopf;", "\uD835\uDD39");
    entities.put("&Breve;", "\u02D8");
    entities.put("&Bscr;", "\u212C");
    entities.put("&Bumpeq;", "\u224E");
    entities.put("&CHcy;", "\u0427");
    entities.put("&COPY;", "\u00A9");
    entities.put("&Cacute;", "\u0106");
    entities.put("&Cap;", "\u22D2");
    entities.put("&CapitalDifferentialD;", "\u2145");
    entities.put("&Cayleys;", "\u212D");
    entities.put("&Ccaron;", "\u010C");
    entities.put("&Ccedil;", "\u00C7");
    entities.put("&Ccirc;", "\u0108");
    entities.put("&Cconint;", "\u2230");
    entities.put("&Cdot;", "\u010A");
    entities.put("&Cedilla;", "\u00B8");
    entities.put("&CenterDot;", "\u00B7");
    entities.put("&Cfr;", "\u212D");
    entities.put("&Chi;", "\u03A7");
    entities.put("&CircleDot;", "\u2299");
    entities.put("&CircleMinus;", "\u2296");
    entities.put("&CirclePlus;", "\u2295");
    entities.put("&CircleTimes;", "\u2297");
    entities.put("&ClockwiseContourIntegral;", "\u2232");
    entities.put("&CloseCurlyDoubleQuote;", "\u201D");
    entities.put("&CloseCurlyQuote;", "\u2019");
    entities.put("&Colon;", "\u2237");
    entities.put("&Colone;", "\u2A74");
    entities.put("&Congruent;", "\u2261");
    entities.put("&Conint;", "\u222F");
    entities.put("&ContourIntegral;", "\u222E");
    entities.put("&Copf;", "\u2102");
    entities.put("&Coproduct;", "\u2210");
    entities.put("&CounterClockwiseContourIntegral;", "\u2233");
    entities.put("&Cross;", "\u2A2F");
    entities.put("&Cscr;", "\uD835\uDC9E");
    entities.put("&Cup;", "\u22D3");
    entities.put("&CupCap;", "\u224D");
    entities.put("&DD;", "\u2145");
    entities.put("&DDotrahd;", "\u2911");
    entities.put("&DJcy;", "\u0402");
    entities.put("&DScy;", "\u0405");
    entities.put("&DZcy;", "\u040F");
    entities.put("&Dagger;", "\u2021");
    entities.put("&Darr;", "\u21A1");
    entities.put("&Dashv;", "\u2AE4");
    entities.put("&Dcaron;", "\u010E");
    entities.put("&Dcy;", "\u0414");
    entities.put("&Del;", "\u2207");
    entities.put("&Delta;", "\u0394");
    entities.put("&Dfr;", "\uD835\uDD07");
    entities.put("&DiacriticalAcute;", "\u00B4");
    entities.put("&DiacriticalDot;", "\u02D9");
    entities.put("&DiacriticalDoubleAcute;", "\u02DD");
    entities.put("&DiacriticalGrave;", "\u0060");
    entities.put("&DiacriticalTilde;", "\u02DC");
    entities.put("&Diamond;", "\u22C4");
    entities.put("&DifferentialD;", "\u2146");
    entities.put("&Dopf;", "\uD835\uDD3B");
    entities.put("&Dot;", "\u00A8");
    entities.put("&DotDot;", "\u20DC");
    entities.put("&DotEqual;", "\u2250");
    entities.put("&DoubleContourIntegral;", "\u222F");
    entities.put("&DoubleDot;", "\u00A8");
    entities.put("&DoubleDownArrow;", "\u21D3");
    entities.put("&DoubleLeftArrow;", "\u21D0");
    entities.put("&DoubleLeftRightArrow;", "\u21D4");
    entities.put("&DoubleLeftTee;", "\u2AE4");
    entities.put("&DoubleLongLeftArrow;", "\u27F8");
    entities.put("&DoubleLongLeftRightArrow;", "\u27FA");
    entities.put("&DoubleLongRightArrow;", "\u27F9");
    entities.put("&DoubleRightArrow;", "\u21D2");
    entities.put("&DoubleRightTee;", "\u22A8");
    entities.put("&DoubleUpArrow;", "\u21D1");
    entities.put("&DoubleUpDownArrow;", "\u21D5");
    entities.put("&DoubleVerticalBar;", "\u2225");
    entities.put("&DownArrow;", "\u2193");
    entities.put("&DownArrowBar;", "\u2913");
    entities.put("&DownArrowUpArrow;", "\u21F5");
    entities.put("&DownBreve;", "\u0311");
    entities.put("&DownLeftRightVector;", "\u2950");
    entities.put("&DownLeftTeeVector;", "\u295E");
    entities.put("&DownLeftVector;", "\u21BD");
    entities.put("&DownLeftVectorBar;", "\u2956");
    entities.put("&DownRightTeeVector;", "\u295F");
    entities.put("&DownRightVector;", "\u21C1");
    entities.put("&DownRightVectorBar;", "\u2957");
    entities.put("&DownTee;", "\u22A4");
    entities.put("&DownTeeArrow;", "\u21A7");
    entities.put("&Downarrow;", "\u21D3");
    entities.put("&Dscr;", "\uD835\uDC9F");
    entities.put("&Dstrok;", "\u0110");
    entities.put("&ENG;", "\u014A");
    entities.put("&ETH;", "\u00D0");
    entities.put("&Eacute;", "\u00C9");
    entities.put("&Ecaron;", "\u011A");
    entities.put("&Ecirc;", "\u00CA");
    entities.put("&Ecy;", "\u042D");
    entities.put("&Edot;", "\u0116");
    entities.put("&Efr;", "\uD835\uDD08");
    entities.put("&Egrave;", "\u00C8");
    entities.put("&Element;", "\u2208");
    entities.put("&Emacr;", "\u0112");
    entities.put("&EmptySmallSquare;", "\u25FB");
    entities.put("&EmptyVerySmallSquare;", "\u25AB");
    entities.put("&Eogon;", "\u0118");
    entities.put("&Eopf;", "\uD835\uDD3C");
    entities.put("&Epsilon;", "\u0395");
    entities.put("&Equal;", "\u2A75");
    entities.put("&EqualTilde;", "\u2242");
    entities.put("&Equilibrium;", "\u21CC");
    entities.put("&Escr;", "\u2130");
    entities.put("&Esim;", "\u2A73");
    entities.put("&Eta;", "\u0397");
    entities.put("&Euml;", "\u00CB");
    entities.put("&Exists;", "\u2203");
    entities.put("&ExponentialE;", "\u2147");
    entities.put("&Fcy;", "\u0424");
    entities.put("&Ffr;", "\uD835\uDD09");
    entities.put("&FilledSmallSquare;", "\u25FC");
    entities.put("&FilledVerySmallSquare;", "\u25AA");
    entities.put("&Fopf;", "\uD835\uDD3D");
    entities.put("&ForAll;", "\u2200");
    entities.put("&Fouriertrf;", "\u2131");
    entities.put("&Fscr;", "\u2131");
    entities.put("&GJcy;", "\u0403");
    entities.put("&GT;", "\u003E");
    entities.put("&Gamma;", "\u0393");
    entities.put("&Gammad;", "\u03DC");
    entities.put("&Gbreve;", "\u011E");
    entities.put("&Gcedil;", "\u0122");
    entities.put("&Gcirc;", "\u011C");
    entities.put("&Gcy;", "\u0413");
    entities.put("&Gdot;", "\u0120");
    entities.put("&Gfr;", "\uD835\uDD0A");
    entities.put("&Gg;", "\u22D9");
    entities.put("&Gopf;", "\uD835\uDD3E");
    entities.put("&GreaterEqual;", "\u2265");
    entities.put("&GreaterEqualLess;", "\u22DB");
    entities.put("&GreaterFullEqual;", "\u2267");
    entities.put("&GreaterGreater;", "\u2AA2");
    entities.put("&GreaterLess;", "\u2277");
    entities.put("&GreaterSlantEqual;", "\u2A7E");
    entities.put("&GreaterTilde;", "\u2273");
    entities.put("&Gscr;", "\uD835\uDCA2");
    entities.put("&Gt;", "\u226B");
    entities.put("&HARDcy;", "\u042A");
    entities.put("&Hacek;", "\u02C7");
    entities.put("&Hat;", "\u005E");
    entities.put("&Hcirc;", "\u0124");
    entities.put("&Hfr;", "\u210C");
    entities.put("&HilbertSpace;", "\u210B");
    entities.put("&Hopf;", "\u210D");
    entities.put("&HorizontalLine;", "\u2500");
    entities.put("&Hscr;", "\u210B");
    entities.put("&Hstrok;", "\u0126");
    entities.put("&HumpDownHump;", "\u224E");
    entities.put("&HumpEqual;", "\u224F");
    entities.put("&IEcy;", "\u0415");
    entities.put("&IJlig;", "\u0132");
    entities.put("&IOcy;", "\u0401");
    entities.put("&Iacute;", "\u00CD");
    entities.put("&Icirc;", "\u00CE");
    entities.put("&Icy;", "\u0418");
    entities.put("&Idot;", "\u0130");
    entities.put("&Ifr;", "\u2111");
    entities.put("&Igrave;", "\u00CC");
    entities.put("&Im;", "\u2111");
    entities.put("&Imacr;", "\u012A");
    entities.put("&ImaginaryI;", "\u2148");
    entities.put("&Implies;", "\u21D2");
    entities.put("&Int;", "\u222C");
    entities.put("&Integral;", "\u222B");
    entities.put("&Intersection;", "\u22C2");
    entities.put("&InvisibleComma;", "\u2063");
    entities.put("&InvisibleTimes;", "\u2062");
    entities.put("&Iogon;", "\u012E");
    entities.put("&Iopf;", "\uD835\uDD40");
    entities.put("&Iota;", "\u0399");
    entities.put("&Iscr;", "\u2110");
    entities.put("&Itilde;", "\u0128");
    entities.put("&Iukcy;", "\u0406");
    entities.put("&Iuml;", "\u00CF");
    entities.put("&Jcirc;", "\u0134");
    entities.put("&Jcy;", "\u0419");
    entities.put("&Jfr;", "\uD835\uDD0D");
    entities.put("&Jopf;", "\uD835\uDD41");
    entities.put("&Jscr;", "\uD835\uDCA5");
    entities.put("&Jsercy;", "\u0408");
    entities.put("&Jukcy;", "\u0404");
    entities.put("&KHcy;", "\u0425");
    entities.put("&KJcy;", "\u040C");
    entities.put("&Kappa;", "\u039A");
    entities.put("&Kcedil;", "\u0136");
    entities.put("&Kcy;", "\u041A");
    entities.put("&Kfr;", "\uD835\uDD0E");
    entities.put("&Kopf;", "\uD835\uDD42");
    entities.put("&Kscr;", "\uD835\uDCA6");
    entities.put("&LJcy;", "\u0409");
    entities.put("&LT;", "\u003C");
    entities.put("&Lacute;", "\u0139");
    entities.put("&Lambda;", "\u039B");
    entities.put("&Lang;", "\u27EA");
    entities.put("&Laplacetrf;", "\u2112");
    entities.put("&Larr;", "\u219E");
    entities.put("&Lcaron;", "\u013D");
    entities.put("&Lcedil;", "\u013B");
    entities.put("&Lcy;", "\u041B");
    entities.put("&LeftAngleBracket;", "\u27E8");
    entities.put("&LeftArrow;", "\u2190");
    entities.put("&LeftArrowBar;", "\u21E4");
    entities.put("&LeftArrowRightArrow;", "\u21C6");
    entities.put("&LeftCeiling;", "\u2308");
    entities.put("&LeftDoubleBracket;", "\u27E6");
    entities.put("&LeftDownTeeVector;", "\u2961");
    entities.put("&LeftDownVector;", "\u21C3");
    entities.put("&LeftDownVectorBar;", "\u2959");
    entities.put("&LeftFloor;", "\u230A");
    entities.put("&LeftRightArrow;", "\u2194");
    entities.put("&LeftRightVector;", "\u294E");
    entities.put("&LeftTee;", "\u22A3");
    entities.put("&LeftTeeArrow;", "\u21A4");
    entities.put("&LeftTeeVector;", "\u295A");
    entities.put("&LeftTriangle;", "\u22B2");
    entities.put("&LeftTriangleBar;", "\u29CF");
    entities.put("&LeftTriangleEqual;", "\u22B4");
    entities.put("&LeftUpDownVector;", "\u2951");
    entities.put("&LeftUpTeeVector;", "\u2960");
    entities.put("&LeftUpVector;", "\u21BF");
    entities.put("&LeftUpVectorBar;", "\u2958");
    entities.put("&LeftVector;", "\u21BC");
    entities.put("&LeftVectorBar;", "\u2952");
    entities.put("&Leftarrow;", "\u21D0");
    entities.put("&Leftrightarrow;", "\u21D4");
    entities.put("&LessEqualGreater;", "\u22DA");
    entities.put("&LessFullEqual;", "\u2266");
    entities.put("&LessGreater;", "\u2276");
    entities.put("&LessLess;", "\u2AA1");
    entities.put("&LessSlantEqual;", "\u2A7D");
    entities.put("&LessTilde;", "\u2272");
    entities.put("&Lfr;", "\uD835\uDD0F");
    entities.put("&Ll;", "\u22D8");
    entities.put("&Lleftarrow;", "\u21DA");
    entities.put("&Lmidot;", "\u013F");
    entities.put("&LongLeftArrow;", "\u27F5");
    entities.put("&LongLeftRightArrow;", "\u27F7");
    entities.put("&LongRightArrow;", "\u27F6");
    entities.put("&Longleftarrow;", "\u27F8");
    entities.put("&Longleftrightarrow;", "\u27FA");
    entities.put("&Longrightarrow;", "\u27F9");
    entities.put("&Lopf;", "\uD835\uDD43");
    entities.put("&LowerLeftArrow;", "\u2199");
    entities.put("&LowerRightArrow;", "\u2198");
    entities.put("&Lscr;", "\u2112");
    entities.put("&Lsh;", "\u21B0");
    entities.put("&Lstrok;", "\u0141");
    entities.put("&Lt;", "\u226A");
    entities.put("&Map;", "\u2905");
    entities.put("&Mcy;", "\u041C");
    entities.put("&MediumSpace;", "\u205F");
    entities.put("&Mellintrf;", "\u2133");
    entities.put("&Mfr;", "\uD835\uDD10");
    entities.put("&MinusPlus;", "\u2213");
    entities.put("&Mopf;", "\uD835\uDD44");
    entities.put("&Mscr;", "\u2133");
    entities.put("&Mu;", "\u039C");
    entities.put("&NJcy;", "\u040A");
    entities.put("&Nacute;", "\u0143");
    entities.put("&Ncaron;", "\u0147");
    entities.put("&Ncedil;", "\u0145");
    entities.put("&Ncy;", "\u041D");
    entities.put("&NegativeMediumSpace;", "\u200B");
    entities.put("&NegativeThickSpace;", "\u200B");
    entities.put("&NegativeThinSpace;", "\u200B");
    entities.put("&NegativeVeryThinSpace;", "\u200B");
    entities.put("&NestedGreaterGreater;", "\u226B");
    entities.put("&NestedLessLess;", "\u226A");
    entities.put("&NewLine;", "\n");
    entities.put("&Nfr;", "\uD835\uDD11");
    entities.put("&NoBreak;", "\u2060");
    entities.put("&NonBreakingSpace;", "\u00A0");
    entities.put("&Nopf;", "\u2115");
    entities.put("&Not;", "\u2AEC");
    entities.put("&NotCongruent;", "\u2262");
    entities.put("&NotCupCap;", "\u226D");
    entities.put("&NotDoubleVerticalBar;", "\u2226");
    entities.put("&NotElement;", "\u2209");
    entities.put("&NotEqual;", "\u2260");
    entities.put("&NotEqualTilde;", "\u2242\u0338");
    entities.put("&NotExists;", "\u2204");
    entities.put("&NotGreater;", "\u226F");
    entities.put("&NotGreaterEqual;", "\u2271");
    entities.put("&NotGreaterFullEqual;", "\u2267\u0033");
    entities.put("&NotGreaterGreater;", "\u226B\u0033");
    entities.put("&NotGreaterLess;", "\u2279");
    entities.put("&NotGreaterSlantEqual;", "\u2A7E\u0338");
    entities.put("&NotGreaterTilde;", "\u2275");
    entities.put("&NotHumpDownHump;", "\u224E\u0338");
    entities.put("&NotHumpEqual;", "\u224F\u0338");
    entities.put("&NotLeftTriangle;", "\u22EA");
    entities.put("&NotLeftTriangleBar;", "\u29CF\u0338");
    entities.put("&NotLeftTriangleEqual;", "\u22EC");
    entities.put("&NotLess;", "\u226E");
    entities.put("&NotLessEqual;", "\u2270");
    entities.put("&NotLessGreater;", "\u2278");
    entities.put("&NotLessLess;", "\u226A\u0338");
    entities.put("&NotLessSlantEqual;", "\u2A7D\u0338");
    entities.put("&NotLessTilde;", "\u2274");
    entities.put("&NotNestedGreaterGreater;", "\u2AA2\u0338");
    entities.put("&NotNestedLessLess;", "\u2AA1\u0338");
    entities.put("&NotPrecedes;", "\u2280");
    entities.put("&NotPrecedesEqual;", "\u2AAF\u0338");
    entities.put("&NotPrecedesSlantEqual;", "\u22E0");
    entities.put("&NotReverseElement;", "\u220C");
    entities.put("&NotRightTriangle;", "\u22EB");
    entities.put("&NotRightTriangleBar;", "\u29D0\u0338");
    entities.put("&NotRightTriangleEqual;", "\u22ED");
    entities.put("&NotSquareSubset;", "\u228F\u0338");
    entities.put("&NotSquareSubsetEqual;", "\u22E2");
    entities.put("&NotSquareSuperset;", "\u2290\u0338");
    entities.put("&NotSquareSupersetEqual;", "\u22E3");
    entities.put("&NotSubset;", "\u2282\u20D2");
    entities.put("&NotSubsetEqual;", "\u2288");
    entities.put("&NotSucceeds;", "\u2281");
    entities.put("&NotSucceedsEqual;", "\u2AB0\u0338");
    entities.put("&NotSucceedsSlantEqual;", "\u22E1");
    entities.put("&NotSucceedsTilde;", "\u227F\u0338");
    entities.put("&NotSuperset;", "\u2283\u20D2");
    entities.put("&NotSupersetEqual;", "\u2289");
    entities.put("&NotTilde;", "\u2241");
    entities.put("&NotTildeEqual;", "\u2244");
    entities.put("&NotTildeFullEqual;", "\u2247");
    entities.put("&NotTildeTilde;", "\u2249");
    entities.put("&NotVerticalBar;", "\u2224");
    entities.put("&Nscr;", "\uD835\uDCA9");
    entities.put("&Ntilde;", "\u00D1");
    entities.put("&Nu;", "\u039D");
    entities.put("&OElig;", "\u0152");
    entities.put("&Oacute;", "\u00D3");
    entities.put("&Ocirc;", "\u00D4");
    entities.put("&Ocy;", "\u041E");
    entities.put("&Odblac;", "\u0150");
    entities.put("&Ofr;", "\uD835\uDD12");
    entities.put("&Ograve;", "\u00D2");
    entities.put("&Omacr;", "\u014C");
    entities.put("&Omega;", "\u03A9");
    entities.put("&Omicron;", "\u039F");
    entities.put("&Oopf;", "\uD835\uDD46");
    entities.put("&OpenCurlyDoubleQuote;", "\u201C");
    entities.put("&OpenCurlyQuote;", "\u2018");
    entities.put("&Or;", "\u2A54");
    entities.put("&Oscr;", "\uD835\uDCAA");
    entities.put("&Oslash;", "\u00D8");
    entities.put("&Otilde;", "\u00D5");
    entities.put("&Otimes;", "\u2A37");
    entities.put("&Ouml;", "\u00D6");
    entities.put("&OverBar;", "\u203E");
    entities.put("&OverBrace;", "\u23DE");
    entities.put("&OverBracket;", "\u23B4");
    entities.put("&OverParenthesis;", "\u23DC");
    entities.put("&PartialD;", "\u2202");
    entities.put("&Pcy;", "\u041F");
    entities.put("&Pfr;", "\uD835\uDD13");
    entities.put("&Phi;", "\u03A6");
    entities.put("&Pi;", "\u03A0");
    entities.put("&PlusMinus;", "\u00B1");
    entities.put("&Poincareplane;", "\u210C");
    entities.put("&Popf;", "\u2119");
    entities.put("&Pr;", "\u2ABB");
    entities.put("&Precedes;", "\u227A");
    entities.put("&PrecedesEqual;", "\u2AAF");
    entities.put("&PrecedesSlantEqual;", "\u227C");
    entities.put("&PrecedesTilde;", "\u227E");
    entities.put("&Prime;", "\u2033");
    entities.put("&Product;", "\u220F");
    entities.put("&Proportion;", "\u2237");
    entities.put("&Proportional;", "\u221D");
    entities.put("&Pscr;", "\uD835\uDCAB");
    entities.put("&Psi;", "\u03A8");
    entities.put("&QUOT;", "\\u0022");
    entities.put("&Qfr;", "\uD835\uDD14");
    entities.put("&Qopf;", "\u211A");
    entities.put("&Qscr;", "\uD835\uDCAC");
    entities.put("&RBarr;", "\u2910");
    entities.put("&REG;", "\u00AE");
    entities.put("&Racute;", "\u0154");
    entities.put("&Rang;", "\u27EB");
    entities.put("&Rarr;", "\u21A0");
    entities.put("&Rarrtl;", "\u2916");
    entities.put("&Rcaron;", "\u0158");
    entities.put("&Rcedil;", "\u0156");
    entities.put("&Rcy;", "\u0420");
    entities.put("&Re;", "\u211C");
    entities.put("&ReverseElement;", "\u220B");
    entities.put("&ReverseEquilibrium;", "\u21CB");
    entities.put("&ReverseUpEquilibrium;", "\u296F");
    entities.put("&Rfr;", "\u211C");
    entities.put("&Rho;", "\u03A1");
    entities.put("&RightAngleBracket;", "\u27E9");
    entities.put("&RightArrow;", "\u2192");
    entities.put("&RightArrowBar;", "\u21E5");
    entities.put("&RightArrowLeftArrow;", "\u21C4");
    entities.put("&RightCeiling;", "\u2309");
    entities.put("&RightDoubleBracket;", "\u27E7");
    entities.put("&RightDownTeeVector;", "\u295D");
    entities.put("&RightDownVector;", "\u21C2");
    entities.put("&RightDownVectorBar;", "\u2955");
    entities.put("&RightFloor;", "\u230B");
    entities.put("&RightTee;", "\u22A2");
    entities.put("&RightTeeArrow;", "\u21A6");
    entities.put("&RightTeeVector;", "\u295B");
    entities.put("&RightTriangle;", "\u22B3");
    entities.put("&RightTriangleBar;", "\u29D0");
    entities.put("&RightTriangleEqual;", "\u22B5");
    entities.put("&RightUpDownVector;", "\u294F");
    entities.put("&RightUpTeeVector;", "\u295C");
    entities.put("&RightUpVector;", "\u21BE");
    entities.put("&RightUpVectorBar;", "\u2954");
    entities.put("&RightVector;", "\u21C0");
    entities.put("&RightVectorBar;", "\u2953");
    entities.put("&Rightarrow;", "\u21D2");
    entities.put("&Ropf;", "\u211D");
    entities.put("&RoundImplies;", "\u2970");
    entities.put("&Rrightarrow;", "\u21DB");
    entities.put("&Rscr;", "\u211B");
    entities.put("&Rsh;", "\u21B1");
    entities.put("&RuleDelayed;", "\u29F4");
    entities.put("&SHCHcy;", "\u0429");
    entities.put("&SHcy;", "\u0428");
    entities.put("&SOFTcy;", "\u042C");
    entities.put("&Sacute;", "\u015A");
    entities.put("&Sc;", "\u2ABC");
    entities.put("&Scaron;", "\u0160");
    entities.put("&Scedil;", "\u015E");
    entities.put("&Scirc;", "\u015C");
    entities.put("&Scy;", "\u0421");
    entities.put("&Sfr;", "\uD835\uDD16");
    entities.put("&ShortDownArrow;", "\u2193");
    entities.put("&ShortLeftArrow;", "\u2190");
    entities.put("&ShortRightArrow;", "\u2192");
    entities.put("&ShortUpArrow;", "\u2191");
    entities.put("&Sigma;", "\u03A3");
    entities.put("&SmallCircle;", "\u2218");
    entities.put("&Sopf;", "\uD835\uDD4A");
    entities.put("&Sqrt;", "\u221A");
    entities.put("&Square;", "\u25A1");
    entities.put("&SquareIntersection;", "\u2293");
    entities.put("&SquareSubset;", "\u228F");
    entities.put("&SquareSubsetEqual;", "\u2291");
    entities.put("&SquareSuperset;", "\u2290");
    entities.put("&SquareSupersetEqual;", "\u2292");
    entities.put("&SquareUnion;", "\u2294");
    entities.put("&Sscr;", "\uD835\uDCAE");
    entities.put("&Star;", "\u22C6");
    entities.put("&Sub;", "\u22D0");
    entities.put("&Subset;", "\u22D0");
    entities.put("&SubsetEqual;", "\u2286");
    entities.put("&Succeeds;", "\u227B");
    entities.put("&SucceedsEqual;", "\u2AB0");
    entities.put("&SucceedsSlantEqual;", "\u227D");
    entities.put("&SucceedsTilde;", "\u227F");
    entities.put("&SuchThat;", "\u220B");
    entities.put("&Sum;", "\u2211");
    entities.put("&Sup;", "\u22D1");
    entities.put("&Superset;", "\u2283");
    entities.put("&SupersetEqual;", "\u2287");
    entities.put("&Supset;", "\u22D1");
    entities.put("&THORN;", "\u00DE");
    entities.put("&TRADE;", "\u2122");
    entities.put("&TSHcy;", "\u040B");
    entities.put("&TScy;", "\u0426");
    entities.put("&Tab;", "\u0009");
    entities.put("&Tau;", "\u03A4");
    entities.put("&Tcaron;", "\u0164");
    entities.put("&Tcedil;", "\u0162");
    entities.put("&Tcy;", "\u0422");
    entities.put("&Tfr;", "\uD835\uDD17");
    entities.put("&Therefore;", "\u2234");
    entities.put("&Theta;", "\u0398");
    entities.put("&ThickSpace;", "\u205F\u200A");
    entities.put("&ThinSpace;", "\u2009");
    entities.put("&Tilde;", "\u223C");
    entities.put("&TildeEqual;", "\u2243");
    entities.put("&TildeFullEqual;", "\u2245");
    entities.put("&TildeTilde;", "\u2248");
    entities.put("&Topf;", "\uD835\uDD4B");
    entities.put("&TripleDot;", "\u20DB");
    entities.put("&Tscr;", "\uD835\uDCAF");
    entities.put("&Tstrok;", "\u0166");
    entities.put("&Uacute;", "\u00DA");
    entities.put("&Uarr;", "\u219F");
    entities.put("&Uarrocir;", "\u2949");
    entities.put("&Ubrcy;", "\u040E");
    entities.put("&Ubreve;", "\u016C");
    entities.put("&Ucirc;", "\u00DB");
    entities.put("&Ucy;", "\u0423");
    entities.put("&Udblac;", "\u0170");
    entities.put("&Ufr;", "\uD835\uDD18");
    entities.put("&Ugrave;", "\u00D9");
    entities.put("&Umacr;", "\u016A");
    entities.put("&UnderBar;", "\u005F");
    entities.put("&UnderBrace;", "\u23DF");
    entities.put("&UnderBracket;", "\u23B5");
    entities.put("&UnderParenthesis;", "\u23DD");
    entities.put("&Union;", "\u22C3");
    entities.put("&UnionPlus;", "\u228E");
    entities.put("&Uogon;", "\u0172");
    entities.put("&Uopf;", "\uD835\uDD4C");
    entities.put("&UpArrow;", "\u2191");
    entities.put("&UpArrowBar;", "\u2912");
    entities.put("&UpArrowDownArrow;", "\u21C5");
    entities.put("&UpDownArrow;", "\u2195");
    entities.put("&UpEquilibrium;", "\u296E");
    entities.put("&UpTee;", "\u22A5");
    entities.put("&UpTeeArrow;", "\u21A5");
    entities.put("&Uparrow;", "\u21D1");
    entities.put("&Updownarrow;", "\u21D5");
    entities.put("&UpperLeftArrow;", "\u2196");
    entities.put("&UpperRightArrow;", "\u2197");
    entities.put("&Upsi;", "\u03D2");
    entities.put("&Upsilon;", "\u03A5");
    entities.put("&Uring;", "\u016E");
    entities.put("&Uscr;", "\uD835\uDCB0");
    entities.put("&Utilde;", "\u0168");
    entities.put("&Uuml;", "\u00DC");
    entities.put("&VDash;", "\u22AB");
    entities.put("&Vbar;", "\u2AEB");
    entities.put("&Vcy;", "\u0412");
    entities.put("&Vdash;", "\u22A9");
    entities.put("&Vdashl;", "\u2AE6");
    entities.put("&Vee;", "\u22C1");
    entities.put("&Verbar;", "\u2016");
    entities.put("&Vert;", "\u2016");
    entities.put("&VerticalBar;", "\u2223");
    entities.put("&VerticalLine;", "\u007C");
    entities.put("&VerticalSeparator;", "\u2758");
    entities.put("&VerticalTilde;", "\u2240");
    entities.put("&VeryThinSpace;", "\u200A");
    entities.put("&Vfr;", "\uD835\uDD19");
    entities.put("&Vopf;", "\uD835\uDD4D");
    entities.put("&Vscr;", "\uD835\uDCB1");
    entities.put("&Vvdash;", "\u22AA");
    entities.put("&Wcirc;", "\u0174");
    entities.put("&Wedge;", "\u22C0");
    entities.put("&Wfr;", "\uD835\uDD1A");
    entities.put("&Wopf;", "\uD835\uDD4E");
    entities.put("&Wscr;", "\uD835\uDCB2");
    entities.put("&Xfr;", "\uD835\uDD1B");
    entities.put("&Xi;", "\u039E");
    entities.put("&Xopf;", "\uD835\uDD4F");
    entities.put("&Xscr;", "\uD835\uDCB3");
    entities.put("&YAcy;", "\u042F");
    entities.put("&YIcy;", "\u0407");
    entities.put("&YUcy;", "\u042E");
    entities.put("&Yacute;", "\u00DD");
    entities.put("&Ycirc;", "\u0176");
    entities.put("&Ycy;", "\u042B");
    entities.put("&Yfr;", "\uD835\uDD1C");
    entities.put("&Yopf;", "\uD835\uDD50");
    entities.put("&Yscr;", "\uD835\uDCB4");
    entities.put("&Yuml;", "\u0178");
    entities.put("&ZHcy;", "\u0416");
    entities.put("&Zacute;", "\u0179");
    entities.put("&Zcaron;", "\u017D");
    entities.put("&Zcy;", "\u0417");
    entities.put("&Zdot;", "\u017B");
    entities.put("&ZeroWidthSpace;", "\u200B");
    entities.put("&Zeta;", "\u0396");
    entities.put("&Zfr;", "\u2128");
    entities.put("&Zopf;", "\u2124");
    entities.put("&Zscr;", "\uD835\uDCB5");
    entities.put("&aacute;", "\u00E1");
    entities.put("&abreve;", "\u0103");
    entities.put("&ac;", "\u223E");
    entities.put("&acE;", "\u223E\u0333");
    entities.put("&acd;", "\u223F");
    entities.put("&acirc;", "\u00E2");
    entities.put("&acute;", "\u00B4");
    entities.put("&acy;", "\u0430");
    entities.put("&aelig;", "\u00E6");
    entities.put("&af;", "\u2061");
    entities.put("&afr;", "\uD835\uDD1E");
    entities.put("&agrave;", "\u00E0");
    entities.put("&alefsym;", "\u2135");
    entities.put("&aleph;", "\u2135");
    entities.put("&alpha;", "\u03B1");
    entities.put("&amacr;", "\u0101");
    entities.put("&amalg;", "\u2A3F");
    entities.put("&amp;", "\u0026");
    entities.put("&and;", "\u2227");
    entities.put("&andand;", "\u2A55");
    entities.put("&andd;", "\u2A5C");
    entities.put("&andslope;", "\u2A58");
    entities.put("&andv;", "\u2A5A");
    entities.put("&ang;", "\u2220");
    entities.put("&ange;", "\u29A4");
    entities.put("&angle;", "\u2220");
    entities.put("&angmsd;", "\u2221");
    entities.put("&angmsdaa;", "\u29A8");
    entities.put("&angmsdab;", "\u29A9");
    entities.put("&angmsdac;", "\u29AA");
    entities.put("&angmsdad;", "\u29AB");
    entities.put("&angmsdae;", "\u29AC");
    entities.put("&angmsdaf;", "\u29AD");
    entities.put("&angmsdag;", "\u29AE");
    entities.put("&angmsdah;", "\u29AF");
    entities.put("&angrt;", "\u221F");
    entities.put("&angrtvb;", "\u22BE");
    entities.put("&angrtvbd;", "\u299D");
    entities.put("&angsph;", "\u2222");
    entities.put("&angst;", "\u00C5");
    entities.put("&angzarr;", "\u237C");
    entities.put("&aogon;", "\u0105");
    entities.put("&aopf;", "\uD835\uDD52");
    entities.put("&ap;", "\u2248");
    entities.put("&apE;", "\u2A70");
    entities.put("&apacir;", "\u2A6F");
    entities.put("&ape;", "\u224A");
    entities.put("&apid;", "\u224B");
    entities.put("&apos;", "\u0027");
    entities.put("&approx;", "\u2248");
    entities.put("&approxeq;", "\u224A");
    entities.put("&aring;", "\u00E5");
    entities.put("&ascr;", "\uD835\uDCB6");
    entities.put("&ast;", "\u002A");
    entities.put("&asymp;", "\u2248");
    entities.put("&asympeq;", "\u224D");
    entities.put("&atilde;", "\u00E3");
    entities.put("&auml;", "\u00E4");
    entities.put("&awconint;", "\u2233");
    entities.put("&awint;", "\u2A11");
    entities.put("&bNot;", "\u2AED");
    entities.put("&backcong;", "\u224C");
    entities.put("&backepsilon;", "\u03F6");
    entities.put("&backprime;", "\u2035");
    entities.put("&backsim;", "\u223D");
    entities.put("&backsimeq;", "\u22CD");
    entities.put("&barvee;", "\u22BD");
    entities.put("&barwed;", "\u2305");
    entities.put("&barwedge;", "\u2305");
    entities.put("&bbrk;", "\u23B5");
    entities.put("&bbrktbrk;", "\u23B6");
    entities.put("&bcong;", "\u224C");
    entities.put("&bcy;", "\u0431");
    entities.put("&bdquo;", "\u201E");
    entities.put("&becaus;", "\u2235");
    entities.put("&because;", "\u2235");
    entities.put("&bemptyv;", "\u29B0");
    entities.put("&bepsi;", "\u03F6");
    entities.put("&bernou;", "\u212C");
    entities.put("&beta;", "\u03B2");
    entities.put("&beth;", "\u2136");
    entities.put("&between;", "\u226C");
    entities.put("&bfr;", "\uD835\uDD1F");
    entities.put("&bigcap;", "\u22C2");
    entities.put("&bigcirc;", "\u25EF");
    entities.put("&bigcup;", "\u22C3");
    entities.put("&bigodot;", "\u2A00");
    entities.put("&bigoplus;", "\u2A01");
    entities.put("&bigotimes;", "\u2A02");
    entities.put("&bigsqcup;", "\u2A06");
    entities.put("&bigstar;", "\u2605");
    entities.put("&bigtriangledown;", "\u25BD");
    entities.put("&bigtriangleup;", "\u25B3");
    entities.put("&biguplus;", "\u2A04");
    entities.put("&bigvee;", "\u22C1");
    entities.put("&bigwedge;", "\u22C0");
    entities.put("&bkarow;", "\u290D");
    entities.put("&blacklozenge;", "\u29EB");
    entities.put("&blacksquare;", "\u25AA");
    entities.put("&blacktriangle;", "\u25B4");
    entities.put("&blacktriangledown;", "\u25BE");
    entities.put("&blacktriangleleft;", "\u25C2");
    entities.put("&blacktriangleright;", "\u25B8");
    entities.put("&blank;", "\u2423");
    entities.put("&blk12;", "\u2592");
    entities.put("&blk14;", "\u2591");
    entities.put("&blk34;", "\u2593");
    entities.put("&block;", "\u2588");
    entities.put("&bne;", "\u003D\u20E5");
    entities.put("&bnequiv;", "\u2261\u20E5");
    entities.put("&bnot;", "\u2310");
    entities.put("&bopf;", "\uD835\uDD53");
    entities.put("&bot;", "\u22A5");
    entities.put("&bottom;", "\u22A5");
    entities.put("&bowtie;", "\u22C8");
    entities.put("&boxDL;", "\u2557");
    entities.put("&boxDR;", "\u2554");
    entities.put("&boxDl;", "\u2556");
    entities.put("&boxDr;", "\u2553");
    entities.put("&boxH;", "\u2550");
    entities.put("&boxHD;", "\u2566");
    entities.put("&boxHU;", "\u2569");
    entities.put("&boxHd;", "\u2564");
    entities.put("&boxHu;", "\u2567");
    entities.put("&boxUL;", "\u255D");
    entities.put("&boxUR;", "\u255A");
    entities.put("&boxUl;", "\u255C");
    entities.put("&boxUr;", "\u2559");
    entities.put("&boxV;", "\u2551");
    entities.put("&boxVH;", "\u256C");
    entities.put("&boxVL;", "\u2563");
    entities.put("&boxVR;", "\u2560");
    entities.put("&boxVh;", "\u256B");
    entities.put("&boxVl;", "\u2562");
    entities.put("&boxVr;", "\u255F");
    entities.put("&boxbox;", "\u29C9");
    entities.put("&boxdL;", "\u2555");
    entities.put("&boxdR;", "\u2552");
    entities.put("&boxdl;", "\u2510");
    entities.put("&boxdr;", "\u250C");
    entities.put("&boxh;", "\u2500");
    entities.put("&boxhD;", "\u2565");
    entities.put("&boxhU;", "\u2568");
    entities.put("&boxhd;", "\u252C");
    entities.put("&boxhu;", "\u2534");
    entities.put("&boxminus;", "\u229F");
    entities.put("&boxplus;", "\u229E");
    entities.put("&boxtimes;", "\u22A0");
    entities.put("&boxuL;", "\u255B");
    entities.put("&boxuR;", "\u2558");
    entities.put("&boxul;", "\u2518");
    entities.put("&boxur;", "\u2514");
    entities.put("&boxv;", "\u2502");
    entities.put("&boxvH;", "\u256A");
    entities.put("&boxvL;", "\u2561");
    entities.put("&boxvR;", "\u255E");
    entities.put("&boxvh;", "\u253C");
    entities.put("&boxvl;", "\u2524");
    entities.put("&boxvr;", "\u251C");
    entities.put("&bprime;", "\u2035");
    entities.put("&breve;", "\u02D8");
    entities.put("&brvbar;", "\u00A6");
    entities.put("&bscr;", "\uD835\uDCB7");
    entities.put("&bsemi;", "\u204F");
    entities.put("&bsim;", "\u223D");
    entities.put("&bsime;", "\u22CD");
    entities.put("&bsol;", "\\u005C");
    entities.put("&bsolb;", "\u29C5");
    entities.put("&bsolhsub;", "\u27C8");
    entities.put("&bull;", "\u2022");
    entities.put("&bullet;", "\u2022");
    entities.put("&bump;", "\u224E");
    entities.put("&bumpE;", "\u2AAE");
    entities.put("&bumpe;", "\u224F");
    entities.put("&bumpeq;", "\u224F");
    entities.put("&cacute;", "\u0107");
    entities.put("&cap;", "\u2229");
    entities.put("&capand;", "\u2A44");
    entities.put("&capbrcup;", "\u2A49");
    entities.put("&capcap;", "\u2A4B");
    entities.put("&capcup;", "\u2A47");
    entities.put("&capdot;", "\u2A40");
    entities.put("&caps;", "\u2229\uFE00");
    entities.put("&caret;", "\u2041");
    entities.put("&caron;", "\u02C7");
    entities.put("&ccaps;", "\u2A4D");
    entities.put("&ccaron;", "\u010D");
    entities.put("&ccedil;", "\u00E7");
    entities.put("&ccirc;", "\u0109");
    entities.put("&ccups;", "\u2A4C");
    entities.put("&ccupssm;", "\u2A50");
    entities.put("&cdot;", "\u010B");
    entities.put("&cedil;", "\u00B8");
    entities.put("&cemptyv;", "\u29B2");
    entities.put("&cent;", "\u00A2");
    entities.put("&centerdot;", "\u00B7");
    entities.put("&cfr;", "\uD835\uDD20");
    entities.put("&chcy;", "\u0447");
    entities.put("&check;", "\u2713");
    entities.put("&checkmark;", "\u2713");
    entities.put("&chi;", "\u03C7");
    entities.put("&cir;", "\u25CB");
    entities.put("&cirE;", "\u29C3");
    entities.put("&circ;", "\u02C6");
    entities.put("&circeq;", "\u2257");
    entities.put("&circlearrowleft;", "\u21BA");
    entities.put("&circlearrowright;", "\u21BB");
    entities.put("&circledR;", "\u00AE");
    entities.put("&circledS;", "\u24C8");
    entities.put("&circledast;", "\u229B");
    entities.put("&circledcirc;", "\u229A");
    entities.put("&circleddash;", "\u229D");
    entities.put("&cire;", "\u2257");
    entities.put("&cirfnint;", "\u2A10");
    entities.put("&cirmid;", "\u2AEF");
    entities.put("&cirscir;", "\u29C2");
    entities.put("&clubs;", "\u2663");
    entities.put("&clubsuit;", "\u2663");
    entities.put("&colon;", "\u003A");
    entities.put("&colone;", "\u2254");
    entities.put("&coloneq;", "\u2254");
    entities.put("&comma;", "\u002C");
    entities.put("&commat;", "\u0040");
    entities.put("&comp;", "\u2201");
    entities.put("&compfn;", "\u2218");
    entities.put("&complement;", "\u2201");
    entities.put("&complexes;", "\u2102");
    entities.put("&cong;", "\u2245");
    entities.put("&congdot;", "\u2A6D");
    entities.put("&conint;", "\u222E");
    entities.put("&copf;", "\uD835\uDD54");
    entities.put("&coprod;", "\u2210");
    entities.put("&copy;", "\u00A9");
    entities.put("&copysr;", "\u2117");
    entities.put("&crarr;", "\u21B5");
    entities.put("&cross;", "\u2717");
    entities.put("&cscr;", "\uD835\uDCB8");
    entities.put("&csub;", "\u2ACF");
    entities.put("&csube;", "\u2AD1");
    entities.put("&csup;", "\u2AD0");
    entities.put("&csupe;", "\u2AD2");
    entities.put("&ctdot;", "\u22EF");
    entities.put("&cudarrl;", "\u2938");
    entities.put("&cudarrr;", "\u2935");
    entities.put("&cuepr;", "\u22DE");
    entities.put("&cuesc;", "\u22DF");
    entities.put("&cularr;", "\u21B6");
    entities.put("&cularrp;", "\u293D");
    entities.put("&cup;", "\u222A");
    entities.put("&cupbrcap;", "\u2A48");
    entities.put("&cupcap;", "\u2A46");
    entities.put("&cupcup;", "\u2A4A");
    entities.put("&cupdot;", "\u228D");
    entities.put("&cupor;", "\u2A45");
    entities.put("&cups;", "\u222A\uFE00");
    entities.put("&curarr;", "\u21B7");
    entities.put("&curarrm;", "\u293C");
    entities.put("&curlyeqprec;", "\u22DE");
    entities.put("&curlyeqsucc;", "\u22DF");
    entities.put("&curlyvee;", "\u22CE");
    entities.put("&curlywedge;", "\u22CF");
    entities.put("&curren;", "\u00A4");
    entities.put("&curvearrowleft;", "\u21B6");
    entities.put("&curvearrowright;", "\u21B7");
    entities.put("&cuvee;", "\u22CE");
    entities.put("&cuwed;", "\u22CF");
    entities.put("&cwconint;", "\u2232");
    entities.put("&cwint;", "\u2231");
    entities.put("&cylcty;", "\u232D");
    entities.put("&dArr;", "\u21D3");
    entities.put("&dHar;", "\u2965");
    entities.put("&dagger;", "\u2020");
    entities.put("&daleth;", "\u2138");
    entities.put("&darr;", "\u2193");
    entities.put("&dash;", "\u2010");
    entities.put("&dashv;", "\u22A3");
    entities.put("&dbkarow;", "\u290F");
    entities.put("&dblac;", "\u02DD");
    entities.put("&dcaron;", "\u010F");
    entities.put("&dcy;", "\u0434");
    entities.put("&dd;", "\u2146");
    entities.put("&ddagger;", "\u2021");
    entities.put("&ddarr;", "\u21CA");
    entities.put("&ddotseq;", "\u2A77");
    entities.put("&deg;", "\u00B0");
    entities.put("&delta;", "\u03B4");
    entities.put("&demptyv;", "\u29B1");
    entities.put("&dfisht;", "\u297F");
    entities.put("&dfr;", "\uD835\uDD21");
    entities.put("&dharl;", "\u21C3");
    entities.put("&dharr;", "\u21C2");
    entities.put("&diam;", "\u22C4");
    entities.put("&diamond;", "\u22C4");
    entities.put("&diamondsuit;", "\u2666");
    entities.put("&diams;", "\u2666");
    entities.put("&die;", "\u00A8");
    entities.put("&digamma;", "\u03DD");
    entities.put("&disin;", "\u22F2");
    entities.put("&div;", "\u00F7");
    entities.put("&divide;", "\u00F7");
    entities.put("&divideontimes;", "\u22C7");
    entities.put("&divonx;", "\u22C7");
    entities.put("&djcy;", "\u0452");
    entities.put("&dlcorn;", "\u231E");
    entities.put("&dlcrop;", "\u230D");
    entities.put("&dollar;", "\u0024");
    entities.put("&dopf;", "\uD835\uDD55");
    entities.put("&dot;", "\u02D9");
    entities.put("&doteq;", "\u2250");
    entities.put("&doteqdot;", "\u2251");
    entities.put("&dotminus;", "\u2238");
    entities.put("&dotplus;", "\u2214");
    entities.put("&dotsquare;", "\u22A1");
    entities.put("&doublebarwedge;", "\u2306");
    entities.put("&downarrow;", "\u2193");
    entities.put("&downdownarrows;", "\u21CA");
    entities.put("&downharpoonleft;", "\u21C3");
    entities.put("&downharpoonright;", "\u21C2");
    entities.put("&drbkarow;", "\u2910");
    entities.put("&drcorn;", "\u231F");
    entities.put("&drcrop;", "\u230C");
    entities.put("&dscr;", "\uD835\uDCB9");
    entities.put("&dscy;", "\u0455");
    entities.put("&dsol;", "\u29F6");
    entities.put("&dstrok;", "\u0111");
    entities.put("&dtdot;", "\u22F1");
    entities.put("&dtri;", "\u25BF");
    entities.put("&dtrif;", "\u25BE");
    entities.put("&duarr;", "\u21F5");
    entities.put("&duhar;", "\u296F");
    entities.put("&dwangle;", "\u29A6");
    entities.put("&dzcy;", "\u045F");
    entities.put("&dzigrarr;", "\u27FF");
    entities.put("&eDDot;", "\u2A77");
    entities.put("&eDot;", "\u2251");
    entities.put("&eacute;", "\u00E9");
    entities.put("&easter;", "\u2A6E");
    entities.put("&ecaron;", "\u011B");
    entities.put("&ecir;", "\u2256");
    entities.put("&ecirc;", "\u00EA");
    entities.put("&ecolon;", "\u2255");
    entities.put("&ecy;", "\u044D");
    entities.put("&edot;", "\u0117");
    entities.put("&ee;", "\u2147");
    entities.put("&efDot;", "\u2252");
    entities.put("&efr;", "\uD835\uDD22");
    entities.put("&eg;", "\u2A9A");
    entities.put("&egrave;", "\u00E8");
    entities.put("&egs;", "\u2A96");
    entities.put("&egsdot;", "\u2A98");
    entities.put("&el;", "\u2A99");
    entities.put("&elinters;", "\u23E7");
    entities.put("&ell;", "\u2113");
    entities.put("&els;", "\u2A95");
    entities.put("&elsdot;", "\u2A97");
    entities.put("&emacr;", "\u0113");
    entities.put("&empty;", "\u2205");
    entities.put("&emptyset;", "\u2205");
    entities.put("&emptyv;", "\u2205");
    entities.put("&emsp13;", "\u2004");
    entities.put("&emsp14;", "\u2005");
    entities.put("&emsp;", "\u2003");
    entities.put("&eng;", "\u014B");
    entities.put("&ensp;", "\u2002");
    entities.put("&eogon;", "\u0119");
    entities.put("&eopf;", "\uD835\uDD56");
    entities.put("&epar;", "\u22D5");
    entities.put("&eparsl;", "\u29E3");
    entities.put("&eplus;", "\u2A71");
    entities.put("&epsi;", "\u03B5");
    entities.put("&epsilon;", "\u03B5");
    entities.put("&epsiv;", "\u03F5");
    entities.put("&eqcirc;", "\u2256");
    entities.put("&eqcolon;", "\u2255");
    entities.put("&eqsim;", "\u2242");
    entities.put("&eqslantgtr;", "\u2A96");
    entities.put("&eqslantless;", "\u2A95");
    entities.put("&equals;", "\u003D");
    entities.put("&equest;", "\u225F");
    entities.put("&equiv;", "\u2261");
    entities.put("&equivDD;", "\u2A78");
    entities.put("&eqvparsl;", "\u29E5");
    entities.put("&erDot;", "\u2253");
    entities.put("&erarr;", "\u2971");
    entities.put("&escr;", "\u212F");
    entities.put("&esdot;", "\u2250");
    entities.put("&esim;", "\u2242");
    entities.put("&eta;", "\u03B7");
    entities.put("&eth;", "\u00F0");
    entities.put("&euml;", "\u00EB");
    entities.put("&euro;", "\u20AC");
    entities.put("&excl;", "\u0021");
    entities.put("&exist;", "\u2203");
    entities.put("&expectation;", "\u2130");
    entities.put("&exponentiale;", "\u2147");
    entities.put("&fallingdotseq;", "\u2252");
    entities.put("&fcy;", "\u0444");
    entities.put("&female;", "\u2640");
    entities.put("&ffilig;", "\uFB03");
    entities.put("&fflig;", "\uFB00");
    entities.put("&ffllig;", "\uFB04");
    entities.put("&ffr;", "\uD835\uDD23");
    entities.put("&filig;", "\uFB01");
    entities.put("&fjlig;", "\u0066\u006A");
    entities.put("&flat;", "\u266D");
    entities.put("&fllig;", "\uFB02");
    entities.put("&fltns;", "\u25B1");
    entities.put("&fnof;", "\u0192");
    entities.put("&fopf;", "\uD835\uDD57");
    entities.put("&forall;", "\u2200");
    entities.put("&fork;", "\u22D4");
    entities.put("&forkv;", "\u2AD9");
    entities.put("&fpartint;", "\u2A0D");
    entities.put("&frac12;", "\u00BD");
    entities.put("&frac13;", "\u2153");
    entities.put("&frac14;", "\u00BC");
    entities.put("&frac15;", "\u2155");
    entities.put("&frac16;", "\u2159");
    entities.put("&frac18;", "\u215B");
    entities.put("&frac23;", "\u2154");
    entities.put("&frac25;", "\u2156");
    entities.put("&frac34;", "\u00BE");
    entities.put("&frac35;", "\u2157");
    entities.put("&frac38;", "\u215C");
    entities.put("&frac45;", "\u2158");
    entities.put("&frac56;", "\u215A");
    entities.put("&frac58;", "\u215D");
    entities.put("&frac78;", "\u215E");
    entities.put("&frasl;", "\u2044");
    entities.put("&frown;", "\u2322");
    entities.put("&fscr;", "\uD835\uDCBB");
    entities.put("&gE;", "\u2267");
    entities.put("&gEl;", "\u2A8C");
    entities.put("&gacute;", "\u01F5");
    entities.put("&gamma;", "\u03B3");
    entities.put("&gammad;", "\u03DD");
    entities.put("&gap;", "\u2A86");
    entities.put("&gbreve;", "\u011F");
    entities.put("&gcirc;", "\u011D");
    entities.put("&gcy;", "\u0433");
    entities.put("&gdot;", "\u0121");
    entities.put("&ge;", "\u2265");
    entities.put("&gel;", "\u22DB");
    entities.put("&geq;", "\u2265");
    entities.put("&geqq;", "\u2267");
    entities.put("&geqslant;", "\u2A7E");
    entities.put("&ges;", "\u2A7E");
    entities.put("&gescc;", "\u2AA9");
    entities.put("&gesdot;", "\u2A80");
    entities.put("&gesdoto;", "\u2A82");
    entities.put("&gesdotol;", "\u2A84");
    entities.put("&gesl;", "\u22DB\uFE00");
    entities.put("&gesles;", "\u2A94");
    entities.put("&gfr;", "\uD835\uDD24");
    entities.put("&gg;", "\u226B");
    entities.put("&ggg;", "\u22D9");
    entities.put("&gimel;", "\u2137");
    entities.put("&gjcy;", "\u0453");
    entities.put("&gl;", "\u2277");
    entities.put("&glE;", "\u2A92");
    entities.put("&gla;", "\u2AA5");
    entities.put("&glj;", "\u2AA4");
    entities.put("&gnE;", "\u2269");
    entities.put("&gnap;", "\u2A8A");
    entities.put("&gnapprox;", "\u2A8A");
    entities.put("&gne;", "\u2A88");
    entities.put("&gneq;", "\u2A88");
    entities.put("&gneqq;", "\u2269");
    entities.put("&gnsim;", "\u22E7");
    entities.put("&gopf;", "\uD835\uDD58");
    entities.put("&grave;", "\u0060");
    entities.put("&gscr;", "\u210A");
    entities.put("&gsim;", "\u2273");
    entities.put("&gsime;", "\u2A8E");
    entities.put("&gsiml;", "\u2A90");
    entities.put("&gt;", "\u003E");
    entities.put("&gtcc;", "\u2AA7");
    entities.put("&gtcir;", "\u2A7A");
    entities.put("&gtdot;", "\u22D7");
    entities.put("&gtlPar;", "\u2995");
    entities.put("&gtquest;", "\u2A7C");
    entities.put("&gtrapprox;", "\u2A86");
    entities.put("&gtrarr;", "\u2978");
    entities.put("&gtrdot;", "\u22D7");
    entities.put("&gtreqless;", "\u22DB");
    entities.put("&gtreqqless;", "\u2A8C");
    entities.put("&gtrless;", "\u2277");
    entities.put("&gtrsim;", "\u2273");
    entities.put("&gvertneqq;", "\u2269\uFE00");
    entities.put("&gvnE;", "\u2269\uFE00");
    entities.put("&hArr;", "\u21D4");
    entities.put("&hairsp;", "\u200A");
    entities.put("&half;", "\u00BD");
    entities.put("&hamilt;", "\u210B");
    entities.put("&hardcy;", "\u044A");
    entities.put("&harr;", "\u2194");
    entities.put("&harrcir;", "\u2948");
    entities.put("&harrw;", "\u21AD");
    entities.put("&hbar;", "\u210F");
    entities.put("&hcirc;", "\u0125");
    entities.put("&hearts;", "\u2665");
    entities.put("&heartsuit;", "\u2665");
    entities.put("&hellip;", "\u2026");
    entities.put("&hercon;", "\u22B9");
    entities.put("&hfr;", "\uD835\uDD25");
    entities.put("&hksearow;", "\u2925");
    entities.put("&hkswarow;", "\u2926");
    entities.put("&hoarr;", "\u21FF");
    entities.put("&homtht;", "\u223B");
    entities.put("&hookleftarrow;", "\u21A9");
    entities.put("&hookrightarrow;", "\u21AA");
    entities.put("&hopf;", "\uD835\uDD59");
    entities.put("&horbar;", "\u2015");
    entities.put("&hscr;", "\uD835\uDCBD");
    entities.put("&hslash;", "\u210F");
    entities.put("&hstrok;", "\u0127");
    entities.put("&hybull;", "\u2043");
    entities.put("&hyphen;", "\u2010");
    entities.put("&iacute;", "\u00ED");
    entities.put("&ic;", "\u2063");
    entities.put("&icirc;", "\u00EE");
    entities.put("&icy;", "\u0438");
    entities.put("&iecy;", "\u0435");
    entities.put("&iexcl;", "\u00A1");
    entities.put("&iff;", "\u21D4");
    entities.put("&ifr;", "\uD835\uDD26");
    entities.put("&igrave;", "\u00EC");
    entities.put("&ii;", "\u2148");
    entities.put("&iiiint;", "\u2A0C");
    entities.put("&iiint;", "\u222D");
    entities.put("&iinfin;", "\u29DC");
    entities.put("&iiota;", "\u2129");
    entities.put("&ijlig;", "\u0133");
    entities.put("&imacr;", "\u012B");
    entities.put("&image;", "\u2111");
    entities.put("&imagline;", "\u2110");
    entities.put("&imagpart;", "\u2111");
    entities.put("&imath;", "\u0131");
    entities.put("&imof;", "\u22B7");
    entities.put("&imped;", "\u01B5");
    entities.put("&in;", "\u2208");
    entities.put("&incare;", "\u2105");
    entities.put("&infin;", "\u221E");
    entities.put("&infintie;", "\u29DD");
    entities.put("&inodot;", "\u0131");
    entities.put("&int;", "\u222B");
    entities.put("&intcal;", "\u22BA");
    entities.put("&integers;", "\u2124");
    entities.put("&intercal;", "\u22BA");
    entities.put("&intlarhk;", "\u2A17");
    entities.put("&intprod;", "\u2A3C");
    entities.put("&iocy;", "\u0451");
    entities.put("&iogon;", "\u012F");
    entities.put("&iopf;", "\uD835\uDD5A");
    entities.put("&iota;", "\u03B9");
    entities.put("&iprod;", "\u2A3C");
    entities.put("&iquest;", "\u00BF");
    entities.put("&iscr;", "\uD835\uDCBE");
    entities.put("&isin;", "\u2208");
    entities.put("&isinE;", "\u22F9");
    entities.put("&isindot;", "\u22F5");
    entities.put("&isins;", "\u22F4");
    entities.put("&isinsv;", "\u22F3");
    entities.put("&isinv;", "\u2208");
    entities.put("&it;", "\u2062");
    entities.put("&itilde;", "\u0129");
    entities.put("&iukcy;", "\u0456");
    entities.put("&iuml;", "\u00EF");
    entities.put("&jcirc;", "\u0135");
    entities.put("&jcy;", "\u0439");
    entities.put("&jfr;", "\uD835\uDD27");
    entities.put("&jmath;", "\u0237");
    entities.put("&jopf;", "\uD835\uDD5B");
    entities.put("&jscr;", "\uD835\uDCBF");
    entities.put("&jsercy;", "\u0458");
    entities.put("&jukcy;", "\u0454");
    entities.put("&kappa;", "\u03BA");
    entities.put("&kappav;", "\u03F0");
    entities.put("&kcedil;", "\u0137");
    entities.put("&kcy;", "\u043A");
    entities.put("&kfr;", "\uD835\uDD28");
    entities.put("&kgreen;", "\u0138");
    entities.put("&khcy;", "\u0445");
    entities.put("&kjcy;", "\u045C");
    entities.put("&kopf;", "\uD835\uDD5C");
    entities.put("&kscr;", "\uD835\uDCC0");
    entities.put("&lAarr;", "\u21DA");
    entities.put("&lArr;", "\u21D0");
    entities.put("&lAtail;", "\u291B");
    entities.put("&lBarr;", "\u290E");
    entities.put("&lE;", "\u2266");
    entities.put("&lEg;", "\u2A8B");
    entities.put("&lHar;", "\u2962");
    entities.put("&lacute;", "\u013A");
    entities.put("&laemptyv;", "\u29B4");
    entities.put("&lagran;", "\u2112");
    entities.put("&lambda;", "\u03BB");
    entities.put("&lang;", "\u27E8");
    entities.put("&langd;", "\u2991");
    entities.put("&langle;", "\u27E8");
    entities.put("&lap;", "\u2A85");
    entities.put("&laquo;", "\u00AB");
    entities.put("&larr;", "\u2190");
    entities.put("&larrb;", "\u21E4");
    entities.put("&larrbfs;", "\u291F");
    entities.put("&larrfs;", "\u291D");
    entities.put("&larrhk;", "\u21A9");
    entities.put("&larrlp;", "\u21AB");
    entities.put("&larrpl;", "\u2939");
    entities.put("&larrsim;", "\u2973");
    entities.put("&larrtl;", "\u21A2");
    entities.put("&lat;", "\u2AAB");
    entities.put("&latail;", "\u2919");
    entities.put("&late;", "\u2AAD");
    entities.put("&lates;", "\u2AAD\uFE00");
    entities.put("&lbarr;", "\u290C");
    entities.put("&lbbrk;", "\u2772");
    entities.put("&lbrace;", "\u007B");
    entities.put("&lbrack;", "\u005B");
    entities.put("&lbrke;", "\u298B");
    entities.put("&lbrksld;", "\u298F");
    entities.put("&lbrkslu;", "\u298D");
    entities.put("&lcaron;", "\u013E");
    entities.put("&lcedil;", "\u013C");
    entities.put("&lceil;", "\u2308");
    entities.put("&lcub;", "\u007B");
    entities.put("&lcy;", "\u043B");
    entities.put("&ldca;", "\u2936");
    entities.put("&ldquo;", "\u201C");
    entities.put("&ldquor;", "\u201E");
    entities.put("&ldrdhar;", "\u2967");
    entities.put("&ldrushar;", "\u294B");
    entities.put("&ldsh;", "\u21B2");
    entities.put("&le;", "\u2264");
    entities.put("&leftarrow;", "\u2190");
    entities.put("&leftarrowtail;", "\u21A2");
    entities.put("&leftharpoondown;", "\u21BD");
    entities.put("&leftharpoonup;", "\u21BC");
    entities.put("&leftleftarrows;", "\u21C7");
    entities.put("&leftrightarrow;", "\u2194");
    entities.put("&leftrightarrows;", "\u21C6");
    entities.put("&leftrightharpoons;", "\u21CB");
    entities.put("&leftrightsquigarrow;", "\u21AD");
    entities.put("&leftthreetimes;", "\u22CB");
    entities.put("&leg;", "\u22DA");
    entities.put("&leq;", "\u2264");
    entities.put("&leqq;", "\u2266");
    entities.put("&leqslant;", "\u2A7D");
    entities.put("&les;", "\u2A7D");
    entities.put("&lescc;", "\u2AA8");
    entities.put("&lesdot;", "\u2A7F");
    entities.put("&lesdoto;", "\u2A81");
    entities.put("&lesdotor;", "\u2A83");
    entities.put("&lesg;", "\u22DA\uFE00");
    entities.put("&lesges;", "\u2A93");
    entities.put("&lessapprox;", "\u2A85");
    entities.put("&lessdot;", "\u22D6");
    entities.put("&lesseqgtr;", "\u22DA");
    entities.put("&lesseqqgtr;", "\u2A8B");
    entities.put("&lessgtr;", "\u2276");
    entities.put("&lesssim;", "\u2272");
    entities.put("&lfisht;", "\u297C");
    entities.put("&lfloor;", "\u230A");
    entities.put("&lfr;", "\uD835\uDD29");
    entities.put("&lg;", "\u2276");
    entities.put("&lgE;", "\u2A91");
    entities.put("&lhard;", "\u21BD");
    entities.put("&lharu;", "\u21BC");
    entities.put("&lharul;", "\u296A");
    entities.put("&lhblk;", "\u2584");
    entities.put("&ljcy;", "\u0459");
    entities.put("&ll;", "\u226A");
    entities.put("&llarr;", "\u21C7");
    entities.put("&llcorner;", "\u231E");
    entities.put("&llhard;", "\u296B");
    entities.put("&lltri;", "\u25FA");
    entities.put("&lmidot;", "\u0140");
    entities.put("&lmoust;", "\u23B0");
    entities.put("&lmoustache;", "\u23B0");
    entities.put("&lnE;", "\u2268");
    entities.put("&lnap;", "\u2A89");
    entities.put("&lnapprox;", "\u2A89");
    entities.put("&lne;", "\u2A87");
    entities.put("&lneq;", "\u2A87");
    entities.put("&lneqq;", "\u2268");
    entities.put("&lnsim;", "\u22E6");
    entities.put("&loang;", "\u27EC");
    entities.put("&loarr;", "\u21FD");
    entities.put("&lobrk;", "\u27E6");
    entities.put("&longleftarrow;", "\u27F5");
    entities.put("&longleftrightarrow;", "\u27F7");
    entities.put("&longmapsto;", "\u27FC");
    entities.put("&longrightarrow;", "\u27F6");
    entities.put("&looparrowleft;", "\u21AB");
    entities.put("&looparrowright;", "\u21AC");
    entities.put("&lopar;", "\u2985");
    entities.put("&lopf;", "\uD835\uDD5D");
    entities.put("&loplus;", "\u2A2D");
    entities.put("&lotimes;", "\u2A34");
    entities.put("&lowast;", "\u2217");
    entities.put("&lowbar;", "\u005F");
    entities.put("&loz;", "\u25CA");
    entities.put("&lozenge;", "\u25CA");
    entities.put("&lozf;", "\u29EB");
    entities.put("&lpar;", "\u0028");
    entities.put("&lparlt;", "\u2993");
    entities.put("&lrarr;", "\u21C6");
    entities.put("&lrcorner;", "\u231F");
    entities.put("&lrhar;", "\u21CB");
    entities.put("&lrhard;", "\u296D");
    entities.put("&lrm;", "\u200E");
    entities.put("&lrtri;", "\u22BF");
    entities.put("&lsaquo;", "\u2039");
    entities.put("&lscr;", "\uD835\uDCC1");
    entities.put("&lsh;", "\u21B0");
    entities.put("&lsim;", "\u2272");
    entities.put("&lsime;", "\u2A8D");
    entities.put("&lsimg;", "\u2A8F");
    entities.put("&lsqb;", "\u005B");
    entities.put("&lsquo;", "\u2018");
    entities.put("&lsquor;", "\u201A");
    entities.put("&lstrok;", "\u0142");
    entities.put("&lt;", "\u003C");
    entities.put("&ltcc;", "\u2AA6");
    entities.put("&ltcir;", "\u2A79");
    entities.put("&ltdot;", "\u22D6");
    entities.put("&lthree;", "\u22CB");
    entities.put("&ltimes;", "\u22C9");
    entities.put("&ltlarr;", "\u2976");
    entities.put("&ltquest;", "\u2A7B");
    entities.put("&ltrPar;", "\u2996");
    entities.put("&ltri;", "\u25C3");
    entities.put("&ltrie;", "\u22B4");
    entities.put("&ltrif;", "\u25C2");
    entities.put("&lurdshar;", "\u294A");
    entities.put("&luruhar;", "\u2966");
    entities.put("&lvertneqq;", "\u2268\uFE00");
    entities.put("&lvnE;", "\u2268\uFE00");
    entities.put("&mDDot;", "\u223A");
    entities.put("&macr;", "\u00AF");
    entities.put("&male;", "\u2642");
    entities.put("&malt;", "\u2720");
    entities.put("&maltese;", "\u2720");
    entities.put("&map;", "\u21A6");
    entities.put("&mapsto;", "\u21A6");
    entities.put("&mapstodown;", "\u21A7");
    entities.put("&mapstoleft;", "\u21A4");
    entities.put("&mapstoup;", "\u21A5");
    entities.put("&marker;", "\u25AE");
    entities.put("&mcomma;", "\u2A29");
    entities.put("&mcy;", "\u043C");
    entities.put("&mdash;", "\u2014");
    entities.put("&measuredangle;", "\u2221");
    entities.put("&mfr;", "\uD835\uDD2A");
    entities.put("&mho;", "\u2127");
    entities.put("&micro;", "\u00B5");
    entities.put("&mid;", "\u2223");
    entities.put("&midast;", "\u002A");
    entities.put("&midcir;", "\u2AF0");
    entities.put("&middot;", "\u00B7");
    entities.put("&minus;", "\u2212");
    entities.put("&minusb;", "\u229F");
    entities.put("&minusd;", "\u2238");
    entities.put("&minusdu;", "\u2A2A");
    entities.put("&mlcp;", "\u2ADB");
    entities.put("&mldr;", "\u2026");
    entities.put("&mnplus;", "\u2213");
    entities.put("&models;", "\u22A7");
    entities.put("&mopf;", "\uD835\uDD5E");
    entities.put("&mp;", "\u2213");
    entities.put("&mscr;", "\uD835\uDCC2");
    entities.put("&mstpos;", "\u223E");
    entities.put("&mu;", "\u03BC");
    entities.put("&multimap;", "\u22B8");
    entities.put("&mumap;", "\u22B8");
    entities.put("&nGg;", "\u22D9\u0338");
    entities.put("&nGt;", "\u226B\u20D2");
    entities.put("&nGtv;", "\u226B\u0338");
    entities.put("&nLeftarrow;", "\u21CD");
    entities.put("&nLeftrightarrow;", "\u21CE");
    entities.put("&nLl;", "\u22D8\u0338");
    entities.put("&nLt;", "\u226A\u20D2");
    entities.put("&nLtv;", "\u226A\u0338");
    entities.put("&nRightarrow;", "\u21CF");
    entities.put("&nVDash;", "\u22AF");
    entities.put("&nVdash;", "\u22AE");
    entities.put("&nabla;", "\u2207");
    entities.put("&nacute;", "\u0144");
    entities.put("&nang;", "\u2220\u20D2");
    entities.put("&nap;", "\u2249");
    entities.put("&napE;", "\u2A70\u0338");
    entities.put("&napid;", "\u224B\u0338");
    entities.put("&napos;", "\u0149");
    entities.put("&napprox;", "\u2249");
    entities.put("&natur;", "\u266E");
    entities.put("&natural;", "\u266E");
    entities.put("&naturals;", "\u2115");
    entities.put("&nbsp;", "\u00A0");
    entities.put("&nbump;", "\u224E\u0338");
    entities.put("&nbumpe;", "\u224F\u0338");
    entities.put("&ncap;", "\u2A43");
    entities.put("&ncaron;", "\u0148");
    entities.put("&ncedil;", "\u0146");
    entities.put("&ncong;", "\u2247");
    entities.put("&ncongdot;", "\u2A6D\u0338");
    entities.put("&ncup;", "\u2A42");
    entities.put("&ncy;", "\u043D");
    entities.put("&ndash;", "\u2013");
    entities.put("&ne;", "\u2260");
    entities.put("&neArr;", "\u21D7");
    entities.put("&nearhk;", "\u2924");
    entities.put("&nearr;", "\u2197");
    entities.put("&nearrow;", "\u2197");
    entities.put("&nedot;", "\u2250\u0338");
    entities.put("&nequiv;", "\u2262");
    entities.put("&nesear;", "\u2928");
    entities.put("&nesim;", "\u2242\u0338");
    entities.put("&nexist;", "\u2204");
    entities.put("&nexists;", "\u2204");
    entities.put("&nfr;", "\uD835\uDD2B");
    entities.put("&ngE;", "\u2267\u0338");
    entities.put("&nge;", "\u2271");
    entities.put("&ngeq;", "\u2271");
    entities.put("&ngeqq;", "\u2267\u0338");
    entities.put("&ngeqslant;", "\u2A7E\u0338");
    entities.put("&nges;", "\u2A7E\u0338");
    entities.put("&ngsim;", "\u2275");
    entities.put("&ngt;", "\u226F");
    entities.put("&ngtr;", "\u226F");
    entities.put("&nhArr;", "\u21CE");
    entities.put("&nharr;", "\u21AE");
    entities.put("&nhpar;", "\u2AF2");
    entities.put("&ni;", "\u220B");
    entities.put("&nis;", "\u22FC");
    entities.put("&nisd;", "\u22FA");
    entities.put("&niv;", "\u220B");
    entities.put("&njcy;", "\u045A");
    entities.put("&nlArr;", "\u21CD");
    entities.put("&nlE;", "\u2266\u0338");
    entities.put("&nlarr;", "\u219A");
    entities.put("&nldr;", "\u2025");
    entities.put("&nle;", "\u2270");
    entities.put("&nleftarrow;", "\u219A");
    entities.put("&nleftrightarrow;", "\u21AE");
    entities.put("&nleq;", "\u2270");
    entities.put("&nleqq;", "\u2266\u0338");
    entities.put("&nleqslant;", "\u2A7D\u0338");
    entities.put("&nles;", "\u2A7D\u0338");
    entities.put("&nless;", "\u226E");
    entities.put("&nlsim;", "\u2274");
    entities.put("&nlt;", "\u226E");
    entities.put("&nltri;", "\u22EA");
    entities.put("&nltrie;", "\u22EC");
    entities.put("&nmid;", "\u2224");
    entities.put("&nopf;", "\uD835\uDD5F");
    entities.put("&not;", "\u00AC");
    entities.put("&notin;", "\u2209");
    entities.put("&notinE;", "\u22F9\u0338");
    entities.put("&notindot;", "\u22F5\u0338");
    entities.put("&notinva;", "\u2209");
    entities.put("&notinvb;", "\u22F7");
    entities.put("&notinvc;", "\u22F6");
    entities.put("&notni;", "\u220C");
    entities.put("&notniva;", "\u220C");
    entities.put("&notnivb;", "\u22FE");
    entities.put("&notnivc;", "\u22FD");
    entities.put("&npar;", "\u2226");
    entities.put("&nparallel;", "\u2226");
    entities.put("&nparsl;", "\u2AFD\u20E5");
    entities.put("&npart;", "\u2202\u0338");
    entities.put("&npolint;", "\u2A14");
    entities.put("&npr;", "\u2280");
    entities.put("&nprcue;", "\u22E0");
    entities.put("&npre;", "\u2AAF\u0338");
    entities.put("&nprec;", "\u2280");
    entities.put("&npreceq;", "\u2AAF\u0338");
    entities.put("&nrArr;", "\u21CF");
    entities.put("&nrarr;", "\u219B");
    entities.put("&nrarrc;", "\u2933\u0338");
    entities.put("&nrarrw;", "\u219D\u0338");
    entities.put("&nrightarrow;", "\u219B");
    entities.put("&nrtri;", "\u22EB");
    entities.put("&nrtrie;", "\u22ED");
    entities.put("&nsc;", "\u2281");
    entities.put("&nsccue;", "\u22E1");
    entities.put("&nsce;", "\u2AB0\u0338");
    entities.put("&nscr;", "\uD835\uDCC3");
    entities.put("&nshortmid;", "\u2224");
    entities.put("&nshortparallel;", "\u2226");
    entities.put("&nsim;", "\u2241");
    entities.put("&nsime;", "\u2244");
    entities.put("&nsimeq;", "\u2244");
    entities.put("&nsmid;", "\u2224");
    entities.put("&nspar;", "\u2226");
    entities.put("&nsqsube;", "\u22E2");
    entities.put("&nsqsupe;", "\u22E3");
    entities.put("&nsub;", "\u2284");
    entities.put("&nsubE;", "\u2AC5\u0338");
    entities.put("&nsube;", "\u2288");
    entities.put("&nsubset;", "\u2282\u20D2");
    entities.put("&nsubseteq;", "\u2288");
    entities.put("&nsubseteqq;", "\u2AC5\u0338");
    entities.put("&nsucc;", "\u2281");
    entities.put("&nsucceq;", "\u2AB0\u0338");
    entities.put("&nsup;", "\u2285");
    entities.put("&nsupE;", "\u2AC6\u0338");
    entities.put("&nsupe;", "\u2289");
    entities.put("&nsupset;", "\u2283\u20D2");
    entities.put("&nsupseteq;", "\u2289");
    entities.put("&nsupseteqq;", "\u2AC6\u0338");
    entities.put("&ntgl;", "\u2279");
    entities.put("&ntilde;", "\u00F1");
    entities.put("&ntlg;", "\u2278");
    entities.put("&ntriangleleft;", "\u22EA");
    entities.put("&ntrianglelefteq;", "\u22EC");
    entities.put("&ntriangleright;", "\u22EB");
    entities.put("&ntrianglerighteq;", "\u22ED");
    entities.put("&nu;", "\u03BD");
    entities.put("&num;", "\u0023");
    entities.put("&numero;", "\u2116");
    entities.put("&numsp;", "\u2007");
    entities.put("&nvDash;", "\u22AD");
    entities.put("&nvHarr;", "\u2904");
    entities.put("&nvap;", "\u224D\u20D2");
    entities.put("&nvdash;", "\u22AC");
    entities.put("&nvge;", "\u2265\u20D2");
    entities.put("&nvgt;", "\u003E\u20D2");
    entities.put("&nvinfin;", "\u29DE");
    entities.put("&nvlArr;", "\u2902");
    entities.put("&nvle;", "\u2264\u20D2");
    entities.put("&nvlt;", "\u003C\u20D2");
    entities.put("&nvltrie;", "\u22B4\u20D2");
    entities.put("&nvrArr;", "\u2903");
    entities.put("&nvrtrie;", "\u22B5\u20D2");
    entities.put("&nvsim;", "\u223C\u20D2");
    entities.put("&nwArr;", "\u21D6");
    entities.put("&nwarhk;", "\u2923");
    entities.put("&nwarr;", "\u2196");
    entities.put("&nwarrow;", "\u2196");
    entities.put("&nwnear;", "\u2927");
    entities.put("&oS;", "\u24C8");
    entities.put("&oacute;", "\u00F3");
    entities.put("&oast;", "\u229B");
    entities.put("&ocir;", "\u229A");
    entities.put("&ocirc;", "\u00F4");
    entities.put("&ocy;", "\u043E");
    entities.put("&odash;", "\u229D");
    entities.put("&odblac;", "\u0151");
    entities.put("&odiv;", "\u2A38");
    entities.put("&odot;", "\u2299");
    entities.put("&odsold;", "\u29BC");
    entities.put("&oelig;", "\u0153");
    entities.put("&ofcir;", "\u29BF");
    entities.put("&ofr;", "\uD835\uDD2C");
    entities.put("&ogon;", "\u02DB");
    entities.put("&ograve;", "\u00F2");
    entities.put("&ogt;", "\u29C1");
    entities.put("&ohbar;", "\u29B5");
    entities.put("&ohm;", "\u03A9");
    entities.put("&oint;", "\u222E");
    entities.put("&olarr;", "\u21BA");
    entities.put("&olcir;", "\u29BE");
    entities.put("&olcross;", "\u29BB");
    entities.put("&oline;", "\u203E");
    entities.put("&olt;", "\u29C0");
    entities.put("&omacr;", "\u014D");
    entities.put("&omega;", "\u03C9");
    entities.put("&omicron;", "\u03BF");
    entities.put("&omid;", "\u29B6");
    entities.put("&ominus;", "\u2296");
    entities.put("&oopf;", "\uD835\uDD60");
    entities.put("&opar;", "\u29B7");
    entities.put("&operp;", "\u29B9");
    entities.put("&oplus;", "\u2295");
    entities.put("&or;", "\u2228");
    entities.put("&orarr;", "\u21BB");
    entities.put("&ord;", "\u2A5D");
    entities.put("&order;", "\u2134");
    entities.put("&orderof;", "\u2134");
    entities.put("&ordf;", "\u00AA");
    entities.put("&ordm;", "\u00BA");
    entities.put("&origof;", "\u22B6");
    entities.put("&oror;", "\u2A56");
    entities.put("&orslope;", "\u2A57");
    entities.put("&orv;", "\u2A5B");
    entities.put("&oscr;", "\u2134");
    entities.put("&oslash;", "\u00F8");
    entities.put("&osol;", "\u2298");
    entities.put("&otilde;", "\u00F5");
    entities.put("&otimes;", "\u2297");
    entities.put("&otimesas;", "\u2A36");
    entities.put("&ouml;", "\u00F6");
    entities.put("&ovbar;", "\u233D");
    entities.put("&par;", "\u2225");
    entities.put("&para;", "\u00B6");
    entities.put("&parallel;", "\u2225");
    entities.put("&parsim;", "\u2AF3");
    entities.put("&parsl;", "\u2AFD");
    entities.put("&part;", "\u2202");
    entities.put("&pcy;", "\u043F");
    entities.put("&percnt;", "\u0025");
    entities.put("&period;", "\u002E");
    entities.put("&permil;", "\u2030");
    entities.put("&perp;", "\u22A5");
    entities.put("&pertenk;", "\u2031");
    entities.put("&pfr;", "\uD835\uDD2D");
    entities.put("&phi;", "\u03C6");
    entities.put("&phiv;", "\u03D5");
    entities.put("&phmmat;", "\u2133");
    entities.put("&phone;", "\u260E");
    entities.put("&pi;", "\u03C0");
    entities.put("&pitchfork;", "\u22D4");
    entities.put("&piv;", "\u03D6");
    entities.put("&planck;", "\u210F");
    entities.put("&planckh;", "\u210E");
    entities.put("&plankv;", "\u210F");
    entities.put("&plus;", "\u002B");
    entities.put("&plusacir;", "\u2A23");
    entities.put("&plusb;", "\u229E");
    entities.put("&pluscir;", "\u2A22");
    entities.put("&plusdo;", "\u2214");
    entities.put("&plusdu;", "\u2A25");
    entities.put("&pluse;", "\u2A72");
    entities.put("&plusmn;", "\u00B1");
    entities.put("&plussim;", "\u2A26");
    entities.put("&plustwo;", "\u2A27");
    entities.put("&pm;", "\u00B1");
    entities.put("&pointint;", "\u2A15");
    entities.put("&popf;", "\uD835\uDD61");
    entities.put("&pound;", "\u00A3");
    entities.put("&pr;", "\u227A");
    entities.put("&prE;", "\u2AB3");
    entities.put("&prap;", "\u2AB7");
    entities.put("&prcue;", "\u227C");
    entities.put("&pre;", "\u2AAF");
    entities.put("&prec;", "\u227A");
    entities.put("&precapprox;", "\u2AB7");
    entities.put("&preccurlyeq;", "\u227C");
    entities.put("&preceq;", "\u2AAF");
    entities.put("&precnapprox;", "\u2AB9");
    entities.put("&precneqq;", "\u2AB5");
    entities.put("&precnsim;", "\u22E8");
    entities.put("&precsim;", "\u227E");
    entities.put("&prime;", "\u2032");
    entities.put("&primes;", "\u2119");
    entities.put("&prnE;", "\u2AB5");
    entities.put("&prnap;", "\u2AB9");
    entities.put("&prnsim;", "\u22E8");
    entities.put("&prod;", "\u220F");
    entities.put("&profalar;", "\u232E");
    entities.put("&profline;", "\u2312");
    entities.put("&profsurf;", "\u2313");
    entities.put("&prop;", "\u221D");
    entities.put("&propto;", "\u221D");
    entities.put("&prsim;", "\u227E");
    entities.put("&prurel;", "\u22B0");
    entities.put("&pscr;", "\uD835\uDCC5");
    entities.put("&psi;", "\u03C8");
    entities.put("&puncsp;", "\u2008");
    entities.put("&qfr;", "\uD835\uDD2E");
    entities.put("&qint;", "\u2A0C");
    entities.put("&qopf;", "\uD835\uDD62");
    entities.put("&qprime;", "\u2057");
    entities.put("&qscr;", "\uD835\uDCC6");
    entities.put("&quaternions;", "\u210D");
    entities.put("&quatint;", "\u2A16");
    entities.put("&quest;", "\u003F");
    entities.put("&questeq;", "\u225F");
    entities.put("&quot;", "\\u0022");
    entities.put("&rAarr;", "\u21DB");
    entities.put("&rArr;", "\u21D2");
    entities.put("&rAtail;", "\u291C");
    entities.put("&rBarr;", "\u290F");
    entities.put("&rHar;", "\u2964");
    entities.put("&race;", "\u223D\u0331");
    entities.put("&racute;", "\u0155");
    entities.put("&radic;", "\u221A");
    entities.put("&raemptyv;", "\u29B3");
    entities.put("&rang;", "\u27E9");
    entities.put("&rangd;", "\u2992");
    entities.put("&range;", "\u29A5");
    entities.put("&rangle;", "\u27E9");
    entities.put("&raquo;", "\u00BB");
    entities.put("&rarr;", "\u2192");
    entities.put("&rarrap;", "\u2975");
    entities.put("&rarrb;", "\u21E5");
    entities.put("&rarrbfs;", "\u2920");
    entities.put("&rarrc;", "\u2933");
    entities.put("&rarrfs;", "\u291E");
    entities.put("&rarrhk;", "\u21AA");
    entities.put("&rarrlp;", "\u21AC");
    entities.put("&rarrpl;", "\u2945");
    entities.put("&rarrsim;", "\u2974");
    entities.put("&rarrtl;", "\u21A3");
    entities.put("&rarrw;", "\u219D");
    entities.put("&ratail;", "\u291A");
    entities.put("&ratio;", "\u2236");
    entities.put("&rationals;", "\u211A");
    entities.put("&rbarr;", "\u290D");
    entities.put("&rbbrk;", "\u2773");
    entities.put("&rbrace;", "\u007D");
    entities.put("&rbrack;", "\u005D");
    entities.put("&rbrke;", "\u298C");
    entities.put("&rbrksld;", "\u298E");
    entities.put("&rbrkslu;", "\u2990");
    entities.put("&rcaron;", "\u0159");
    entities.put("&rcedil;", "\u0157");
    entities.put("&rceil;", "\u2309");
    entities.put("&rcub;", "\u007D");
    entities.put("&rcy;", "\u0440");
    entities.put("&rdca;", "\u2937");
    entities.put("&rdldhar;", "\u2969");
    entities.put("&rdquo;", "\u201D");
    entities.put("&rdquor;", "\u201D");
    entities.put("&rdsh;", "\u21B3");
    entities.put("&real;", "\u211C");
    entities.put("&realine;", "\u211B");
    entities.put("&realpart;", "\u211C");
    entities.put("&reals;", "\u211D");
    entities.put("&rect;", "\u25AD");
    entities.put("&reg;", "\u00AE");
    entities.put("&rfisht;", "\u297D");
    entities.put("&rfloor;", "\u230B");
    entities.put("&rfr;", "\uD835\uDD2F");
    entities.put("&rhard;", "\u21C1");
    entities.put("&rharu;", "\u21C0");
    entities.put("&rharul;", "\u296C");
    entities.put("&rho;", "\u03C1");
    entities.put("&rhov;", "\u03F1");
    entities.put("&rightarrow;", "\u2192");
    entities.put("&rightarrowtail;", "\u21A3");
    entities.put("&rightharpoondown;", "\u21C1");
    entities.put("&rightharpoonup;", "\u21C0");
    entities.put("&rightleftarrows;", "\u21C4");
    entities.put("&rightleftharpoons;", "\u21CC");
    entities.put("&rightrightarrows;", "\u21C9");
    entities.put("&rightsquigarrow;", "\u219D");
    entities.put("&rightthreetimes;", "\u22CC");
    entities.put("&ring;", "\u02DA");
    entities.put("&risingdotseq;", "\u2253");
    entities.put("&rlarr;", "\u21C4");
    entities.put("&rlhar;", "\u21CC");
    entities.put("&rlm;", "\u200F");
    entities.put("&rmoust;", "\u23B1");
    entities.put("&rmoustache;", "\u23B1");
    entities.put("&rnmid;", "\u2AEE");
    entities.put("&roang;", "\u27ED");
    entities.put("&roarr;", "\u21FE");
    entities.put("&robrk;", "\u27E7");
    entities.put("&ropar;", "\u2986");
    entities.put("&ropf;", "\uD835\uDD63");
    entities.put("&roplus;", "\u2A2E");
    entities.put("&rotimes;", "\u2A35");
    entities.put("&rpar;", "\u0029");
    entities.put("&rpargt;", "\u2994");
    entities.put("&rppolint;", "\u2A12");
    entities.put("&rrarr;", "\u21C9");
    entities.put("&rsaquo;", "\u203A");
    entities.put("&rscr;", "\uD835\uDCC7");
    entities.put("&rsh;", "\u21B1");
    entities.put("&rsqb;", "\u005D");
    entities.put("&rsquo;", "\u2019");
    entities.put("&rsquor;", "\u2019");
    entities.put("&rthree;", "\u22CC");
    entities.put("&rtimes;", "\u22CA");
    entities.put("&rtri;", "\u25B9");
    entities.put("&rtrie;", "\u22B5");
    entities.put("&rtrif;", "\u25B8");
    entities.put("&rtriltri;", "\u29CE");
    entities.put("&ruluhar;", "\u2968");
    entities.put("&rx;", "\u211E");
    entities.put("&sacute;", "\u015B");
    entities.put("&sbquo;", "\u201A");
    entities.put("&sc;", "\u227B");
    entities.put("&scE;", "\u2AB4");
    entities.put("&scap;", "\u2AB8");
    entities.put("&scaron;", "\u0161");
    entities.put("&sccue;", "\u227D");
    entities.put("&sce;", "\u2AB0");
    entities.put("&scedil;", "\u015F");
    entities.put("&scirc;", "\u015D");
    entities.put("&scnE;", "\u2AB6");
    entities.put("&scnap;", "\u2ABA");
    entities.put("&scnsim;", "\u22E9");
    entities.put("&scpolint;", "\u2A13");
    entities.put("&scsim;", "\u227F");
    entities.put("&scy;", "\u0441");
    entities.put("&sdot;", "\u22C5");
    entities.put("&sdotb;", "\u22A1");
    entities.put("&sdote;", "\u2A66");
    entities.put("&seArr;", "\u21D8");
    entities.put("&searhk;", "\u2925");
    entities.put("&searr;", "\u2198");
    entities.put("&searrow;", "\u2198");
    entities.put("&sect;", "\u00A7");
    entities.put("&semi;", "\u003B");
    entities.put("&seswar;", "\u2929");
    entities.put("&setminus;", "\u2216");
    entities.put("&setmn;", "\u2216");
    entities.put("&sext;", "\u2736");
    entities.put("&sfr;", "\uD835\uDD30");
    entities.put("&sfrown;", "\u2322");
    entities.put("&sharp;", "\u266F");
    entities.put("&shchcy;", "\u0449");
    entities.put("&shcy;", "\u0448");
    entities.put("&shortmid;", "\u2223");
    entities.put("&shortparallel;", "\u2225");
    entities.put("&shy;", "\u00AD");
    entities.put("&sigma;", "\u03C3");
    entities.put("&sigmaf;", "\u03C2");
    entities.put("&sigmav;", "\u03C2");
    entities.put("&sim;", "\u223C");
    entities.put("&simdot;", "\u2A6A");
    entities.put("&sime;", "\u2243");
    entities.put("&simeq;", "\u2243");
    entities.put("&simg;", "\u2A9E");
    entities.put("&simgE;", "\u2AA0");
    entities.put("&siml;", "\u2A9D");
    entities.put("&simlE;", "\u2A9F");
    entities.put("&simne;", "\u2246");
    entities.put("&simplus;", "\u2A24");
    entities.put("&simrarr;", "\u2972");
    entities.put("&slarr;", "\u2190");
    entities.put("&smallsetminus;", "\u2216");
    entities.put("&smashp;", "\u2A33");
    entities.put("&smeparsl;", "\u29E4");
    entities.put("&smid;", "\u2223");
    entities.put("&smile;", "\u2323");
    entities.put("&smt;", "\u2AAA");
    entities.put("&smte;", "\u2AAC");
    entities.put("&smtes;", "\u2AAC\uFE00");
    entities.put("&softcy;", "\u044C");
    entities.put("&sol;", "\u002F");
    entities.put("&solb;", "\u29C4");
    entities.put("&solbar;", "\u233F");
    entities.put("&sopf;", "\uD835\uDD64");
    entities.put("&spades;", "\u2660");
    entities.put("&spadesuit;", "\u2660");
    entities.put("&spar;", "\u2225");
    entities.put("&sqcap;", "\u2293");
    entities.put("&sqcaps;", "\u2293\uFE00");
    entities.put("&sqcup;", "\u2294");
    entities.put("&sqcups;", "\u2294\uFE00");
    entities.put("&sqsub;", "\u228F");
    entities.put("&sqsube;", "\u2291");
    entities.put("&sqsubset;", "\u228F");
    entities.put("&sqsubseteq;", "\u2291");
    entities.put("&sqsup;", "\u2290");
    entities.put("&sqsupe;", "\u2292");
    entities.put("&sqsupset;", "\u2290");
    entities.put("&sqsupseteq;", "\u2292");
    entities.put("&squ;", "\u25A1");
    entities.put("&square;", "\u25A1");
    entities.put("&squarf;", "\u25AA");
    entities.put("&squf;", "\u25AA");
    entities.put("&srarr;", "\u2192");
    entities.put("&sscr;", "\uD835\uDCC8");
    entities.put("&ssetmn;", "\u2216");
    entities.put("&ssmile;", "\u2323");
    entities.put("&sstarf;", "\u22C6");
    entities.put("&star;", "\u2606");
    entities.put("&starf;", "\u2605");
    entities.put("&straightepsilon;", "\u03F5");
    entities.put("&straightphi;", "\u03D5");
    entities.put("&strns;", "\u00AF");
    entities.put("&sub;", "\u2282");
    entities.put("&subE;", "\u2AC5");
    entities.put("&subdot;", "\u2ABD");
    entities.put("&sube;", "\u2286");
    entities.put("&subedot;", "\u2AC3");
    entities.put("&submult;", "\u2AC1");
    entities.put("&subnE;", "\u2ACB");
    entities.put("&subne;", "\u228A");
    entities.put("&subplus;", "\u2ABF");
    entities.put("&subrarr;", "\u2979");
    entities.put("&subset;", "\u2282");
    entities.put("&subseteq;", "\u2286");
    entities.put("&subseteqq;", "\u2AC5");
    entities.put("&subsetneq;", "\u228A");
    entities.put("&subsetneqq;", "\u2ACB");
    entities.put("&subsim;", "\u2AC7");
    entities.put("&subsub;", "\u2AD5");
    entities.put("&subsup;", "\u2AD3");
    entities.put("&succ;", "\u227B");
    entities.put("&succapprox;", "\u2AB8");
    entities.put("&succcurlyeq;", "\u227D");
    entities.put("&succeq;", "\u2AB0");
    entities.put("&succnapprox;", "\u2ABA");
    entities.put("&succneqq;", "\u2AB6");
    entities.put("&succnsim;", "\u22E9");
    entities.put("&succsim;", "\u227F");
    entities.put("&sum;", "\u2211");
    entities.put("&sung;", "\u266A");
    entities.put("&sup1;", "\u00B9");
    entities.put("&sup2;", "\u00B2");
    entities.put("&sup3;", "\u00B3");
    entities.put("&sup;", "\u2283");
    entities.put("&supE;", "\u2AC6");
    entities.put("&supdot;", "\u2ABE");
    entities.put("&supdsub;", "\u2AD8");
    entities.put("&supe;", "\u2287");
    entities.put("&supedot;", "\u2AC4");
    entities.put("&suphsol;", "\u27C9");
    entities.put("&suphsub;", "\u2AD7");
    entities.put("&suplarr;", "\u297B");
    entities.put("&supmult;", "\u2AC2");
    entities.put("&supnE;", "\u2ACC");
    entities.put("&supne;", "\u228B");
    entities.put("&supplus;", "\u2AC0");
    entities.put("&supset;", "\u2283");
    entities.put("&supseteq;", "\u2287");
    entities.put("&supseteqq;", "\u2AC6");
    entities.put("&supsetneq;", "\u228B");
    entities.put("&supsetneqq;", "\u2ACC");
    entities.put("&supsim;", "\u2AC8");
    entities.put("&supsub;", "\u2AD4");
    entities.put("&supsup;", "\u2AD6");
    entities.put("&swArr;", "\u21D9");
    entities.put("&swarhk;", "\u2926");
    entities.put("&swarr;", "\u2199");
    entities.put("&swarrow;", "\u2199");
    entities.put("&swnwar;", "\u292A");
    entities.put("&szlig;", "\u00DF");
    entities.put("&target;", "\u2316");
    entities.put("&tau;", "\u03C4");
    entities.put("&tbrk;", "\u23B4");
    entities.put("&tcaron;", "\u0165");
    entities.put("&tcedil;", "\u0163");
    entities.put("&tcy;", "\u0442");
    entities.put("&tdot;", "\u20DB");
    entities.put("&telrec;", "\u2315");
    entities.put("&tfr;", "\uD835\uDD31");
    entities.put("&there4;", "\u2234");
    entities.put("&therefore;", "\u2234");
    entities.put("&theta;", "\u03B8");
    entities.put("&thetasym;", "\u03D1");
    entities.put("&thetav;", "\u03D1");
    entities.put("&thickapprox;", "\u2248");
    entities.put("&thicksim;", "\u223C");
    entities.put("&thinsp;", "\u2009");
    entities.put("&thkap;", "\u2248");
    entities.put("&thksim;", "\u223C");
    entities.put("&thorn;", "\u00FE");
    entities.put("&tilde;", "\u02DC");
    entities.put("&times;", "\u00D7");
    entities.put("&timesb;", "\u22A0");
    entities.put("&timesbar;", "\u2A31");
    entities.put("&timesd;", "\u2A30");
    entities.put("&tint;", "\u222D");
    entities.put("&toea;", "\u2928");
    entities.put("&top;", "\u22A4");
    entities.put("&topbot;", "\u2336");
    entities.put("&topcir;", "\u2AF1");
    entities.put("&topf;", "\uD835\uDD65");
    entities.put("&topfork;", "\u2ADA");
    entities.put("&tosa;", "\u2929");
    entities.put("&tprime;", "\u2034");
    entities.put("&trade;", "\u2122");
    entities.put("&triangle;", "\u25B5");
    entities.put("&triangledown;", "\u25BF");
    entities.put("&triangleleft;", "\u25C3");
    entities.put("&trianglelefteq;", "\u22B4");
    entities.put("&triangleq;", "\u225C");
    entities.put("&triangleright;", "\u25B9");
    entities.put("&trianglerighteq;", "\u22B5");
    entities.put("&tridot;", "\u25EC");
    entities.put("&trie;", "\u225C");
    entities.put("&triminus;", "\u2A3A");
    entities.put("&triplus;", "\u2A39");
    entities.put("&trisb;", "\u29CD");
    entities.put("&tritime;", "\u2A3B");
    entities.put("&trpezium;", "\u23E2");
    entities.put("&tscr;", "\uD835\uDCC9");
    entities.put("&tscy;", "\u0446");
    entities.put("&tshcy;", "\u045B");
    entities.put("&tstrok;", "\u0167");
    entities.put("&twixt;", "\u226C");
    entities.put("&twoheadleftarrow;", "\u219E");
    entities.put("&twoheadrightarrow;", "\u21A0");
    entities.put("&uArr;", "\u21D1");
    entities.put("&uHar;", "\u2963");
    entities.put("&uacute;", "\u00FA");
    entities.put("&uarr;", "\u2191");
    entities.put("&ubrcy;", "\u045E");
    entities.put("&ubreve;", "\u016D");
    entities.put("&ucirc;", "\u00FB");
    entities.put("&ucy;", "\u0443");
    entities.put("&udarr;", "\u21C5");
    entities.put("&udblac;", "\u0171");
    entities.put("&udhar;", "\u296E");
    entities.put("&ufisht;", "\u297E");
    entities.put("&ufr;", "\uD835\uDD32");
    entities.put("&ugrave;", "\u00F9");
    entities.put("&uharl;", "\u21BF");
    entities.put("&uharr;", "\u21BE");
    entities.put("&uhblk;", "\u2580");
    entities.put("&ulcorn;", "\u231C");
    entities.put("&ulcorner;", "\u231C");
    entities.put("&ulcrop;", "\u230F");
    entities.put("&ultri;", "\u25F8");
    entities.put("&umacr;", "\u016B");
    entities.put("&uml;", "\u00A8");
    entities.put("&uogon;", "\u0173");
    entities.put("&uopf;", "\uD835\uDD66");
    entities.put("&uparrow;", "\u2191");
    entities.put("&updownarrow;", "\u2195");
    entities.put("&upharpoonleft;", "\u21BF");
    entities.put("&upharpoonright;", "\u21BE");
    entities.put("&uplus;", "\u228E");
    entities.put("&upsi;", "\u03C5");
    entities.put("&upsih;", "\u03D2");
    entities.put("&upsilon;", "\u03C5");
    entities.put("&upuparrows;", "\u21C8");
    entities.put("&urcorn;", "\u231D");
    entities.put("&urcorner;", "\u231D");
    entities.put("&urcrop;", "\u230E");
    entities.put("&uring;", "\u016F");
    entities.put("&urtri;", "\u25F9");
    entities.put("&uscr;", "\uD835\uDCCA");
    entities.put("&utdot;", "\u22F0");
    entities.put("&utilde;", "\u0169");
    entities.put("&utri;", "\u25B5");
    entities.put("&utrif;", "\u25B4");
    entities.put("&uuarr;", "\u21C8");
    entities.put("&uuml;", "\u00FC");
    entities.put("&uwangle;", "\u29A7");
    entities.put("&vArr;", "\u21D5");
    entities.put("&vBar;", "\u2AE8");
    entities.put("&vBarv;", "\u2AE9");
    entities.put("&vDash;", "\u22A8");
    entities.put("&vangrt;", "\u299C");
    entities.put("&varepsilon;", "\u03F5");
    entities.put("&varkappa;", "\u03F0");
    entities.put("&varnothing;", "\u2205");
    entities.put("&varphi;", "\u03D5");
    entities.put("&varpi;", "\u03D6");
    entities.put("&varpropto;", "\u221D");
    entities.put("&varr;", "\u2195");
    entities.put("&varrho;", "\u03F1");
    entities.put("&varsigma;", "\u03C2");
    entities.put("&varsubsetneq;", "\u228A\uFE00");
    entities.put("&varsubsetneqq;", "\u2ACB\uFE00");
    entities.put("&varsupsetneq;", "\u228B\uFE00");
    entities.put("&varsupsetneqq;", "\u2ACC\uFE00");
    entities.put("&vartheta;", "\u03D1");
    entities.put("&vartriangleleft;", "\u22B2");
    entities.put("&vartriangleright;", "\u22B3");
    entities.put("&vcy;", "\u0432");
    entities.put("&vdash;", "\u22A2");
    entities.put("&vee;", "\u2228");
    entities.put("&veebar;", "\u22BB");
    entities.put("&veeeq;", "\u225A");
    entities.put("&vellip;", "\u22EE");
    entities.put("&verbar;", "\u007C");
    entities.put("&vert;", "\u007C");
    entities.put("&vfr;", "\uD835\uDD33");
    entities.put("&vltri;", "\u22B2");
    entities.put("&vnsub;", "\u2282\u20D2");
    entities.put("&vnsup;", "\u2283\u20D2");
    entities.put("&vopf;", "\uD835\uDD67");
    entities.put("&vprop;", "\u221D");
    entities.put("&vrtri;", "\u22B3");
    entities.put("&vscr;", "\uD835\uDCCB");
    entities.put("&vsubnE;", "\u2ACB\uFE00");
    entities.put("&vsubne;", "\u228A\uFE00");
    entities.put("&vsupnE;", "\u2ACC\uFE00");
    entities.put("&vsupne;", "\u228B\uFE00");
    entities.put("&vzigzag;", "\u299A");
    entities.put("&wcirc;", "\u0175");
    entities.put("&wedbar;", "\u2A5F");
    entities.put("&wedge;", "\u2227");
    entities.put("&wedgeq;", "\u2259");
    entities.put("&weierp;", "\u2118");
    entities.put("&wfr;", "\uD835\uDD34");
    entities.put("&wopf;", "\uD835\uDD68");
    entities.put("&wp;", "\u2118");
    entities.put("&wr;", "\u2240");
    entities.put("&wreath;", "\u2240");
    entities.put("&wscr;", "\uD835\uDCCC");
    entities.put("&xcap;", "\u22C2");
    entities.put("&xcirc;", "\u25EF");
    entities.put("&xcup;", "\u22C3");
    entities.put("&xdtri;", "\u25BD");
    entities.put("&xfr;", "\uD835\uDD35");
    entities.put("&xhArr;", "\u27FA");
    entities.put("&xharr;", "\u27F7");
    entities.put("&xi;", "\u03BE");
    entities.put("&xlArr;", "\u27F8");
    entities.put("&xlarr;", "\u27F5");
    entities.put("&xmap;", "\u27FC");
    entities.put("&xnis;", "\u22FB");
    entities.put("&xodot;", "\u2A00");
    entities.put("&xopf;", "\uD835\uDD69");
    entities.put("&xoplus;", "\u2A01");
    entities.put("&xotime;", "\u2A02");
    entities.put("&xrArr;", "\u27F9");
    entities.put("&xrarr;", "\u27F6");
    entities.put("&xscr;", "\uD835\uDCCD");
    entities.put("&xsqcup;", "\u2A06");
    entities.put("&xuplus;", "\u2A04");
    entities.put("&xutri;", "\u25B3");
    entities.put("&xvee;", "\u22C1");
    entities.put("&xwedge;", "\u22C0");
    entities.put("&yacute;", "\u00FD");
    entities.put("&yacy;", "\u044F");
    entities.put("&ycirc;", "\u0177");
    entities.put("&ycy;", "\u044B");
    entities.put("&yen;", "\u00A5");
    entities.put("&yfr;", "\uD835\uDD36");
    entities.put("&yicy;", "\u0457");
    entities.put("&yopf;", "\uD835\uDD6A");
    entities.put("&yscr;", "\uD835\uDCCE");
    entities.put("&yucy;", "\u044E");
    entities.put("&yuml;", "\u00FF");
    entities.put("&zacute;", "\u017A");
    entities.put("&zcaron;", "\u017E");
    entities.put("&zcy;", "\u0437");
    entities.put("&zdot;", "\u017C");
    entities.put("&zeetrf;", "\u2128");
    entities.put("&zeta;", "\u03B6");
    entities.put("&zfr;", "\uD835\uDD37");
    entities.put("&zhcy;", "\u0436");
    entities.put("&zigrarr;", "\u21DD");
    entities.put("&zopf;", "\uD835\uDD6B");
    entities.put("&zscr;", "\uD835\uDCCF");
    entities.put("&zwj;", "\u200D");
    entities.put("&zwnj;", "\u200C");
  }

}