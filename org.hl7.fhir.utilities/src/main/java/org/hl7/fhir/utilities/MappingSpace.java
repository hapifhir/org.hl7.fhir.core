package org.hl7.fhir.utilities;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Metadata about a mapping space - the target of StructureDefinition.mapping.uri (e.g. http://hl7.org/v2).
 *
 * These are maintained in the core specification source (mappingSpaces.xml) and distributed in the
 * core package as the binary mappingSpaces.details. Use {@link #loadMappingSpaces(byte[])} to read them.
 */
public class MappingSpace {

  private String url; // the formal URL - the value of StructureDefinition.mapping.uri
  private String columnName; // in the spreadsheets
  private String title; // in the specification
  private XhtmlNode preamble; // html to go in spec
  private String id; // internal page reference
  private int sortOrder; 
  private boolean publish;
  private boolean sparse;
  private boolean pattern;
  private String link; // where to find out about the mapping space. If there's no link, this is the url
  
  public MappingSpace(String columnName, String title, String id, int sortOrder, boolean publish, boolean sparse, boolean pattern, String link) {
    super();
    this.columnName = columnName;
    this.title = title;
    this.id = id;
    this.sortOrder = sortOrder;
    this.preamble = null;
    this.publish = publish;
    this.sparse = sparse;
    this.pattern = pattern;
    this.link = link;
  }

  /**
   * Parse the content of mappingSpaces.details (from the core package)
   *
   * @return the mapping spaces, by url (in the order they are in the source)
   */
  public static Map<String, MappingSpace> loadMappingSpaces(byte[] source) {
    Map<String, MappingSpace> res = new LinkedHashMap<>();
    if (source == null) {
      return res;
    }
    try {
      DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
      factory.setNamespaceAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new ByteArrayInputStream(source));
      Element e = XMLUtil.getFirstChild(doc.getDocumentElement());
      while (e != null) {
        String url = XMLUtil.getNamedChild(e, "url").getTextContent().trim();
        Element link = XMLUtil.getNamedChild(e, "link");
        MappingSpace m = new MappingSpace(XMLUtil.getNamedChild(e, "columnName").getTextContent(), XMLUtil.getNamedChild(e, "title").getTextContent(),
            XMLUtil.getNamedChild(e, "id").getTextContent(), Integer.parseInt(XMLUtil.getNamedChild(e, "sort").getTextContent()), true, false, false, 
            link != null ? link.getTextContent().trim() : url);
        m.url = url;
        Element p = XMLUtil.getNamedChild(e, "preamble");
        if (p != null) {
          m.setPreamble(new XhtmlParser().parseHtmlNode(p).setName("div"));
        }
        res.put(url, m);
        e = XMLUtil.getNextSibling(e);
      }
    } catch (Exception e) {
      throw new FHIRException("Error processing mappingSpaces.details: "+e.getMessage(), e);
    }
    return res;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public XhtmlNode getPreamble() {
    return preamble;
  }

  public void setPreamble(XhtmlNode preamble) {
    this.preamble = preamble;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(int sortOrder) {
    this.sortOrder = sortOrder;
  }

  public boolean isPublish() {
    return publish;
  }

  public void setPublish(boolean publish) {
    this.publish = publish;
  }

  public boolean isSparse() {
    return sparse;
  }

  public boolean isPattern() {
    return pattern;
  }   
  
  public String getLink() {
    return link;
  }

  public boolean hasLink() {
    return !Utilities.noString(link);
  }
}
