package org.hl7.fhir.r5.renderers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.profile.SnapshotGenerationPreProcessor;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ClassDiagramRenderer {
  private String defnFile;
  private StructureDefinition defnSD;

  public class LinkInfo {

    private boolean use;
    private String pathData;
    private String diamondTransform;
    private String diamondPoints;
  }

  private static final String SLICE_COLOR = "#62A856";

  public enum ClassItemMode {
    NORMAL, SLICE;
  }

  private static final double CHAR_RATIO = 4.4;

  public static class PointSpec {
    private double x;
    private double y;
    public PointSpec(double x, double y) {
      super();
      this.x = x;
      this.y = y;
    }
    public double getX() {
      return x;
    }
    public double getY() {
      return y;
    }    
  }

  private RenderingContext rc;
  private IWorkerContext context;
  private ContextUtilities cutils; 
  private ProfileUtilities putils; 
  private Map<String, PointSpec> layout;
  private Map<String, LinkInfo> linkLayouts;
  private String sourceFolder;  
  private String destFolder;  
  private double minx = 0;
  private double miny = 0;
  private String prefix;
  private String diagramId;
  private Map<String, ClassItem> classes = new HashMap<String, ClassItem>();
  private boolean attributes;
  private boolean innerClasses;
  private boolean constraintMode;
  private int nc = 0;
  private List<Link> links = new ArrayList<Link>();
  private List<String> classNames = new ArrayList<String>();  
  private String lang;

  /**
   * 
   * @param sourceFolder - where to look for existing designs
   * @param destFolder - where to generate .svg and .html for diagram review
   * @param diagramId - the id of the diagram (goes in the filenames and the diagram itself)
   * @param prefix - a prefix to put on all ids to ensure anchor names don't clash. 
   * @param rc - rendering context
   * @param lang
   * 
   * @throws IOException
   */
  public ClassDiagramRenderer(String sourceFolder, String destFolder, String diagramId, String prefix, RenderingContext rc, String lang) throws IOException {
    this.sourceFolder = sourceFolder;
    this.destFolder = destFolder;
    this.rc = rc;
    this.context = rc.getContext();
    this.cutils = rc.getContextUtilities();
    this.putils = rc.getProfileUtilities();
    File f = new File(destFolder);
    if (!f.exists()) {
      FileUtilities.createDirectory(destFolder);
    }
    layout = new HashMap<String, ClassDiagramRenderer.PointSpec>();
    linkLayouts = new HashMap<String, ClassDiagramRenderer.LinkInfo>();
    if (diagramId == null) {
      throw new Error("An id is required");
    }
    this.diagramId = diagramId;
    this.prefix = (prefix == null ? "" : prefix);
    this.lang = lang;
  }

  public boolean hasSource() {
    try {
      File f = new File(Utilities.path(sourceFolder, diagramId+".svg"));
      return f.exists(); 
    } catch (IOException e) {
      return false;
    }   
  }
  
  public String buildClassDiagram(JsonObject control) throws Exception {
    File f = new File(Utilities.path(sourceFolder, diagramId+".svg"));
    if (f.exists()) {
      parseSvgFile(f, f.getAbsolutePath());
    }

    attributes = control.asBoolean("attributes");
    innerClasses = !control.asBoolean("no-inner-classes");
    classNames = control.forceArray("classes").asStrings();
    XhtmlNode doc = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode svg = doc.svg();
    
    minx = 0;
    miny = 0;

    Point size = determineMetrics(classNames);
    adjustAllForMin(size);
    svg.attribute("id", prefix+"n"+(++nc));
    svg.attribute("version", "1.1");
    svg.attribute("width", Integer.toString(Utilities.parseInt(control.forceObject("size").asString("width"), (int) size.x)));
    svg.attribute("height", Integer.toString(Utilities.parseInt(control.forceObject("size").asString("height"), (int) size.y)));

    shadowFilter(svg);
    drawElement(svg, classNames);
    countDuplicateLinks();
    XhtmlNode insertionPoint = svg.getChildNodes().get(0);
    for (Link l : links) {
      drawLink(svg, l, insertionPoint);
    }

    String s = new XhtmlComposer(true, true).compose(doc.getChildNodes());
    produceOutput("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+s);
    return s; 
  }

  public String buildClassDiagram(StructureDefinition sd, String defnFile) throws FHIRException, IOException {
    this.defnFile = defnFile;
    this.defnSD = sd;

    File f = new File(Utilities.path(sourceFolder, diagramId+".svg"));
    if (f.exists()) {
      parseSvgFile(f, f.getAbsolutePath());
    }

    attributes = true;
    innerClasses = true;
    classNames.add(sd.getName());
    XhtmlNode doc = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode svg = doc.svg();
    
    minx = 0;
    miny = 0;

    Point size = determineClassMetrics(sd);
    adjustAllForMin(size);
    svg.attribute("id", prefix+"n"+(++nc));
    svg.attribute("version", "1.1");
    svg.attribute("width", Double.toString(size.x));
    svg.attribute("height", Double.toString(size.y));

    shadowFilter(svg);
    drawClassElement(svg, sd);
    countDuplicateLinks();
    XhtmlNode insertionPoint = svg.getChildNodes().get(0);
    for (Link l : links) {
      drawLink(svg, l, insertionPoint);
    }

    String s = new XhtmlComposer(true, true).compose(doc.getChildNodes());
    produceOutput("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+s);
    return s; 
  }

  private void produceOutput(String s) throws IOException {
    if ("".equals(prefix)) {
      String svg = standaloneSVG(s);
      String html = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
          + "<!DOCTYPE HTML>\n"
          + "<html xml:lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\">\n"
          + "  <head>\n"
          + "    <meta content=\"text/html;charset=utf-8\" http-equiv=\"Content-Type\"/>\n"
          + "    <title>"+diagramId+" Class Diagram</title>\n"
          + "    <link href=\"assets/fhir.css\" rel=\"stylesheet\"/>\n"
          + "  </head>\n"
          + "  <body>\n"
          + "  <h2>Embedded SVG</h2>\n"
          + s+"\r\n"
          + "  <h2>External SVG</h2>\n"
          + "    <embed src=\""+diagramId+".svg\" type=\"image/svg+xml\">\n"
          + "  </body>\n"
          + "</html>";

      FileUtilities.stringToFile(svg, Utilities.path(destFolder, diagramId+".svg"));
      FileUtilities.stringToFile(html, Utilities.path(destFolder, diagramId+".html"));
    }
  }

  private String standaloneSVG(String s) {
    String css = "<?xml-stylesheet href=\"assets/fhir.css\" type=\"text/css\"?>";
    int i = s.indexOf(">")+1;
    s = s.substring(0, i)+css+s.substring(i);
    return s;
  }

  private void countDuplicateLinks() {
    for (int i = 0; i < links.size(); i++) {
      Link l = links.get(i);
      if (l.count == 0) {
        int c = 0;
        for (int j = i+1; j < links.size(); j++) {
          Link l2 = links.get(j);
          if ((l2.source == l.source && l2.target == l.target) ||
              (l2.source == l.target && l2.target == l.source))
            c++;
        }     
        l.count = c;
        if (c > 0) {
          int k = 0;
          for (int j = i+1; j < links.size(); j++) {
            Link l2 = links.get(j);
            if ((l2.source == l.source && l2.target == l.target) ||
                (l2.source == l.target && l2.target == l.source) ) {
              k++;
              l2.count = c;
              l2.index = k;
            }
          }     
        }
      }
    }
  }

  private void adjustAllForMin(Point size) {
    size.x = size.x - minx;
    size.y = size.y - miny;
    for (ClassItem t : classes.values()) {
      t.left = t.left - minx;
      t.top = t.top - miny;
    }
  }

  private void shadowFilter(XhtmlNode svg) throws IOException {
    var defs = svg.addTag("defs");
    var filter = defs.addTag("filter").attribute("id", prefix+"shadow"+diagramId).attribute("x", "0").attribute("y", "0").attribute("width", "200%").attribute("height", "200%");
    var feOffset = filter.addTag("feOffset").attribute("result", "offOut").attribute("in", "SourceGraphic").attribute("dx", "3").attribute("dy", "3");    
    var feColorMatrix = filter.addTag("feColorMatrix").attribute("result", "matrixOut").attribute("in", "offOut").attribute("type", "matrix").attribute("values", "0.2 0 0 0 0 0 0.2 0 0 0 0 0 0.2 0 0 0 0 0 1 0");    
    var feGaussianBlur = filter.addTag("feGaussianBlur").attribute("result", "blurOut").attribute("in", "matrixOut").attribute("stdDeviation", "2");    
    var feBlend = filter.addTag("feBlend").attribute("in", "SourceGraphic").attribute("in2", "blurOut").attribute("mode", "normal");    
  }

  private void parseSvgFile(File f, String name) throws FHIRException, IOException {
    Document svg;
    try {
      svg = XMLUtil.parseFileToDom(f.getAbsolutePath());
    } catch (ParserConfigurationException | SAXException | IOException e) {
      throw new IOException(e);
    }
    readElement(svg.getDocumentElement(), null);
    fixLayout();
  }

  private void fixLayout() {
    double minx = Integer.MAX_VALUE;
    double miny = Integer.MAX_VALUE;
    for (PointSpec ps : layout.values()) {
      if (ps.getX() < minx) {
        minx = ps.getX();
      }
      if (ps.getY() < miny) {
        miny = ps.getY();
      }
    }
    for (String n : layout.keySet()) {
      PointSpec ps = layout.get(n);
      PointSpec nps = new PointSpec(ps.getX() - minx, ps.getY() - miny);
      layout.put(n, nps);
    }
  }

  private void readElement(Element e, Element p) {
    String id = e.getAttribute("id");
    if (!Utilities.noString(id) && Character.isUpperCase(id.charAt(0))) {
      switch (e.getNodeName()) {
      case "rect":
      case "text":
        double x = Double.valueOf(e.getAttribute("x"));
        double y = Double.valueOf(e.getAttribute("y"));
        if (p.hasAttribute("transform")) {
          String s = p.getAttribute("transform");
          if (s.startsWith("translate(")) {
            String[] sp = s.substring(10, s.length()-1).split("\\,");
            double tx = Double.valueOf(sp[0]);
            double ty = sp.length > 1 ? Double.valueOf(sp[1]) : 0;
            x = x + tx;
            y = y + ty;
          }
        }
        layout.put(id, new PointSpec(x, y));
        break;
      case  "path":
        String d = e.getAttribute("d");
        if (d != null) { // 'm ' - means that inkscape has edited it 
          linkLayout(id).pathData = d;
          linkLayout(id).use = d.startsWith("m ");
        }
        break;
      case "polygon": 
        String v = e.getAttribute("transform");
        if (v != null) {
          linkLayout(id.replace("-lpolygon", "")).diamondTransform = v;
        }
        v = e.getAttribute("points");
        if (v != null) {
          linkLayout(id.replace("-lpolygon", "")).diamondPoints = v;
        }
        break;
      }
    }
    Element c = XMLUtil.getFirstChild(e);
    while (c != null) {
      readElement(c, e);
      c = XMLUtil.getNextSibling(c);
    }
  }


  private LinkInfo linkLayout(String id) {
    if (!linkLayouts.containsKey(id)) {      
      LinkInfo res = new LinkInfo();
      linkLayouts.put(id, res);
    }
    return linkLayouts.get(id);
  }


  private static final double LINE_HEIGHT = 16;
  private static final double HEADER_HEIGHT = 20;
  private static final double GAP_HEIGHT = 4;
  private static final double LEFT_MARGIN = 6;
  private static final double SELF_LINK_HEIGHT = 25;
  private static final double SELF_LINK_WIDTH = 60;
  private static final double DUPLICATE_GAP = 50;
  private static final double MARGIN_X = 100;
  private static final double MARGIN_Y = 10;
  private static final double WRAP_INDENT = 20;
  private static final int LINE_MAX = 60;
  public static final int MAX_NEG = -1000000;
  private static final double UML_ROW_HEIGHT = 100;

  private enum PointKind {
    unknown, left, right, top, bottom;
  } 
  private class Point {
    private PointKind kind;
    public Point(double x, double y, PointKind kind) {
      this.x = x;
      this.y = y;
      this.kind = kind;
    }
    private double x;
    private double y;
    private String toPoint() {
      return Double.toString(x)+","+Double.toString(y);
    }
  }

  private class ClassItem {
    public ClassItem(double left, double top, double width, double height, String id, String name, ClassItemMode mode) {
      this.left = left;
      this.top = top;
      this.width = width;
      this.height = height;          
      this.id = id;
      this.name = name;
      this.mode = mode;
      if (layout != null && layout.containsKey(id)) {
        this.left = layout.get(id).getX();
        this.top = layout.get(id).getY();
      }
    }
    private double left;
    private double top;
    private double width;
    private double height;
    private String id;
    private String name;
    private ClassItemMode mode;
    public double right() {
      return left + width;
    }
    public double centerH() {
      return left + width / 2;
    }
    public double centerV() {
      return top + height / 2;
    }
    public double bottom() {
      return top + height;
    }
    public String getId() {
      return id;
    }
    public String getName() {
      return name;
    }
    public ClassItemMode getMode() {
      return mode;
    }
  }

  private class Segment {

    public final Point start, end;
    public final boolean isVertical; 
    public final double slope, intercept; 

    public Segment(Point start, Point end) {
      this.start = start;
      this.end = end;
      //set isVertical, which indicates whether this Line 
      //is vertical or not on the coordinate plane
      if (start.x == end.x)
        isVertical = true;
      else
        isVertical = false;

      //set slope and intercept
      if (!isVertical){
        slope = (this.start.y - this.end.y) / (this.start.x - this.end.x);
        intercept = (this.end.x * this.start.y - this.start.x * this.end.y ) /(this.start.x - this.end.x);
      }
      else {
        slope = Double.MAX_VALUE;
        intercept = - Double.MAX_VALUE;
      }
    }
  }
  private class LineStatus {
    int line = 0;
    int length = 0;
    String current = "";
    List<String> list = new ArrayList<String>();

    public String see(String s) {
      length = length + s.length();
      current = current + s;
      return s;
    }

    public void close() {
      line++;
      list.add(current);
      length = 0;
      current = "";
    }

    public void check(XhtmlNode html, XhtmlNode div, double left, double top, int l, String link) throws IOException {
      if (length + l > LINE_MAX-2) { // always leave space for one or two
        close();
        html.attribute("height", Double.toString(top + LINE_HEIGHT * line));
        div.br();
        see("      ");
        div.nbsp();
        div.nbsp();
        div.nbsp();
        div.nbsp();
        div.nbsp();
        div.nbsp();
      }
    }   
  }
  private enum LinkType {SPECIALIZATION, CONSTRAINT, COMPOSITION, SLICE};
  private class Link {
    private String path;
    private String description;
    public Link(ClassItem source, ClassItem target, LinkType type, String name, String cardinality, PointKind kind, String path, String description) {
      this.source = source;
      this.target = target;
      this.type = type;
      this.name = name;
      this.cardinality = cardinality;
      this.kind = kind;
      this.path = path;
      this.description = description;
    }
    private LinkType type;
    private ClassItem source;
    private ClassItem target;
    private String name;
    private String cardinality;
    private PointKind kind;
    private int count;
    private int index;
  }


  private Point determineMetrics(List<String> classNames) throws Exception {
    double width = textWidth("Element") * 1.8;
    double height = HEADER_HEIGHT + GAP_HEIGHT*2;
    //    if ("true".equals(ini.getStringProperty("diagram", "element-attributes"))) {
    //      height = height + LINE_HEIGHT + GAP_HEIGHT;
    //      width = textWidth("extension : Extension 0..*");
    //    }

    Point p = new Point(0, 0, PointKind.unknown);
    ClassItem item = new ClassItem(p.x, p.y, width, height, diagramId, null, ClassItemMode.NORMAL);
    classes.put(null, item);
    double x = item.right()+MARGIN_X;
    double y = item.bottom()+MARGIN_Y;
    if (classNames != null) {
      for (String cn : classNames) {
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, cn);
        if (sd == null) {
          sd = cutils.fetchStructureByName(cn);
        }
        if (sd == null) {
          throw new FHIRException("Unable to find class '"+cn+"'");
        }
        ElementDefinition ed = sd.getSnapshot().getElementFirstRep();
        StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
        p = determineMetrics(sd, ed, item, ed.getName(), null, base, ClassItemMode.NORMAL);
        x = Math.max(x, p.x+MARGIN_X);
        y = Math.max(y, p.y+MARGIN_Y);
      }
    }
    return new Point(x, y, PointKind.unknown);
  }

  private Point determineClassMetrics(StructureDefinition sd) throws FHIRException, IOException {
    double width = textWidth("Element") * 1.8;
    double height = HEADER_HEIGHT + GAP_HEIGHT*2;
    //    if ("true".equals(ini.getStringProperty("diagram", "element-attributes"))) {
    //      height = height + LINE_HEIGHT + GAP_HEIGHT;
    //      width = textWidth("extension : Extension 0..*");
    //    }

    Point p = new Point(0, 0, PointKind.unknown);
    ClassItem item = new ClassItem(p.x, p.y, width, height, diagramId, null, ClassItemMode.NORMAL);
    classes.put(null, item);
    double x = item.right()+MARGIN_X;
    double y = item.bottom()+MARGIN_Y;
    ElementDefinition ed = sd.getSnapshot().getElementFirstRep();
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    p = determineMetrics(sd, ed, item, ed.getName(), null, base, ClassItemMode.NORMAL);
    x = Math.max(x, p.x+MARGIN_X);
    y = Math.max(y, p.y+MARGIN_Y);
    return new Point(x, y, PointKind.unknown);
  }


  private Point determineMetrics(StructureDefinition sd, ElementDefinition ed, ClassItem source, String path, String name, StructureDefinition base, ClassItemMode mode) throws FHIRException, IOException {

    List<ElementDefinition> children = putils.getChildList(sd, ed);
    String n = name;
    if (n == null) {
      if (!path.contains(".")) {
        n = sd.getName();
      } else if (!constraintMode && !children.isEmpty()) {
        String[] p = path.split("\\.");
        StringBuilder b =  new StringBuilder();
        for (String s : p) {
          b.append(Utilities.capitalize(s));
        }
        n = b.toString();
      } else if (constraintMode && ed.getType().size() == 1) {
        n = ed.getTypeFirstRep().getWorkingCode();
      } else {
        n = "DataType"; 
      }
    }

    String t = n;
    if (path.contains(".")) {
      if (ed.getType().size() == 1) {
        if (!"Base".equals(ed.getTypeFirstRep().getWorkingCode())) {
          t = t + " ("+ed.getTypeFirstRep().getWorkingCode()+")";
        }
      } else {
        t = "";
      }
    } else if (base != null && !classNames.contains(base.getName())) {
       t = t + " ("+base.getName()+")";
    }
    if (sd.hasExtension(ExtensionDefinitions.EXT_RESOURCE_INTERFACE)) {
      t = t + " «Interface»";
    }
    double width = textWidth(t) * 1.8;
    //double width = textWidth(e.getName()) * 1.8 + (isRoot ? textWidth(" (Resource)") : 0);
    double height;
    if (attributes) {
      int i = 0;
      for (ElementDefinition c : children) 
        if (inScope(c) && countsAsAttribute(sd, c)) {
          String[] texts = textForAttribute(sd, c);
          i = i + texts.length;
          double w = textWidth(texts[0]);
          for (int j = 1; j < texts.length; j++)
            w = Math.max(w, textWidth(texts[j]));
          if (w > width)
            width = w;
        }
      height = HEADER_HEIGHT + GAP_HEIGHT*2 + LINE_HEIGHT * i + GAP_HEIGHT * 2;
    }  else
      height = HEADER_HEIGHT + GAP_HEIGHT*2;

//    if (control.forceObject("directions").has(path)) {
//      JsonElement uml = control.forceObject("directions").get(path);
//      if (uml.isJsonObject()) {
//        JsonObject svg = (JsonObject) uml;
//        ed.setUserData(UserDataNames.SvgLeft, svg.asInteger("left"));
//        ed.setUserData(UserDataNames.SvgTop, svg.asInteger("top"));
//      } else {      
//        ed.setUserData(UserDataNames.UmlDir, uml.asString());
//      }
//    }

    Point p = new Point(getSvgLeft(ed), getSvgLeft(ed), PointKind.unknown);
    if (p.y == MAX_NEG || p.x == MAX_NEG) {
      if ("left".equals(ed.getUserString(UserDataNames.UmlDir))) {
        p.x = source.left - 120 - width;
        p.y = source.centerV() - height / 2;
        p = findEmptyPlace(p, width, height, 0, 80);
      } else if ("right".equals(ed.getUserString(UserDataNames.UmlDir))) {
        p.x = source.right() + 120;
        p.y = source.centerV() - height / 2;
        p = findEmptyPlace(p, width, height, 0, 80);
      } else if ("up".equals(ed.getUserString(UserDataNames.UmlDir))) {
        p.x = source.centerH() - width / 2;
        p.y = source.top - height - 80;
        p = findEmptyPlace(p, width, height, 80, 0);
      } else if ("down".equals(ed.getUserString(UserDataNames.UmlDir))) {
        p.x = source.centerH() - width / 2;
        p.y = source.bottom() + 80;
        p = findEmptyPlace(p, width, height, +80, 0);
      } else {
        p.y = 0;
        p.x = 0;
        p = findEmptyPlace(p, width, height, 80, 0);
      }
    }
    miny = Math.min(miny, p.y);
    minx = Math.min(minx, p.x);
    ClassItem item = new ClassItem(p.x, p.y, width, height, path, n, mode);
    classes.put(path, item);
    double x = item.right()+MARGIN_X;
    double y = item.bottom()+MARGIN_Y;

    if (innerClasses) {
      for (ElementDefinition c : children) {  
        if (inScope(c) && countsAsRelationship(sd, c) && !c.hasSliceName()) {
          if (c.hasContentReference()) {
            String cr = c.getContentReference();
            ClassItem target = classes.get(cr.substring(cr.indexOf("#")+1));
            if (target == null) {
              throw new Error("what?");
            }
            // do something about x and y?
          } else {
            p = determineMetrics(sd, c, item, path+"."+c.getName(), null, null, ClassItemMode.NORMAL);
            x = Math.max(x, p.x+MARGIN_X);
            y = Math.max(y, p.y+MARGIN_Y);
            // do we find slices?
            if (c.hasSlicing()) {
              List<ElementDefinition> slices = getSlices(children, c);
              for (ElementDefinition s : slices) {
                p = determineMetrics(sd, s, item, path+"."+c.getName()+":"+s.getSliceName(), s.getSliceName(), null, ClassItemMode.SLICE);
                x = Math.max(x, p.x+MARGIN_X);
                y = Math.max(y, p.y+MARGIN_Y);
              }
            }
          }
        }
      }
    }
    return new Point(x, y, PointKind.unknown);
  }

  private boolean countsAsRelationship(StructureDefinition sd, ElementDefinition c) {
    return !countsAsAttribute(sd, c);
  }

  private boolean countsAsAttribute(StructureDefinition sd, ElementDefinition ed) {
    if (ed.hasContentReference()) {
      return false;
    } else if (ed.prohibited()) {
      return true;
    } else if (ed.getType().isEmpty()) {
      return true; // really shouldn't be the case
    } else {
      List<ElementDefinition> children = putils.getChildList(sd, ed, false);
      if (ed.getType().size() == 1) {
        StructureDefinition sdt = context.fetchTypeDefinition(ed.getTypeFirstRep().getWorkingCode());
        if (sdt == null) {
          return true; // also shouldn't happen
        } else if (sdt.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
          return true;
        } else if (sdt.getAbstract()) {
          return children.size() == 0;
        } else if (sdt.getKind() == StructureDefinitionKind.COMPLEXTYPE && !"Base".equals(sdt.getName())) {
          return !(constraintMode && (ed.hasSlicing() || ed.hasSliceName()));
        } else {
          return children.size() == 0;
        }
      } else {
        return children.size() == 0 || (constraintMode && ed.hasSlicing());
      }      
    }
  }

  private List<ElementDefinition> getSlices(List<ElementDefinition> list, ElementDefinition focus) {
    List<ElementDefinition> slices = new ArrayList<ElementDefinition>();
    for (int i = list.indexOf(focus)+1; i < list.size(); i++) {
      ElementDefinition ed = list.get(i);
      if (ed.getPath().equals(focus.getPath()) && ed.hasSliceName()) {
        slices.add(ed);
      }
    }
    return slices;
  }

  private boolean inScope(ElementDefinition c) {
    return !constraintMode || c.hasUserData(UserDataNames.SNAPSHOT_FROM_DIFF);
  }

  private Point findEmptyPlace(Point p, double width, double height, double dx, double dy) {
    while (overlaps(p.x, p.y, width, height)) {
      p.x = p.x + dx;
      p.y = p.y + dy;
      if (p.x > 600) {
        p.y = p.y + UML_ROW_HEIGHT;
        p.x = 0;
      }
    }
    return p;
  }

  private boolean overlaps(double x, double y, double w, double h) {
    for (ClassItem c : classes.values()) {
      if ((inBounds(x, c.left, c.right()) || inBounds(x+w, c.left, c.right())) &&
          (inBounds(y, c.top, c.bottom()) || inBounds(y+h, c.top, c.bottom())))
        return true;
      if ((inBounds(c.left, x, x+w) || inBounds(c.right(), x, x+w)) &&
          (inBounds(c.top, y, y+h) || inBounds(c.bottom(), y, y+h)))
        return true;
    }
    return false;
  }

  private boolean inBounds(double x, double x1, double x2) {
    return (x1 < x2) ? (x >= x1 && x <= x2) : (x >= x2 && x <= x1);
  }

  private double getSvgLeft(ElementDefinition ed) {
    Integer  i = (Integer) ed.getUserData(UserDataNames.SvgLeft);
    return i == null ? MAX_NEG : i;
  }

  private double getSvgTop(ElementDefinition ed) {
    Integer  i = (Integer) ed.getUserData(UserDataNames.SvgTop);
    return i == null ? MAX_NEG : i;
  }

  private int addAttribute(XhtmlNode g, double left, double top, StructureDefinition sd, ElementDefinition e, String path, double height, double width) throws FHIRException, IOException  {
    LineStatus ls = new LineStatus();
    return addAttribute(g, left, top, sd, e, path, ls, height, width);
  }

  private int addAttribute(XhtmlNode g, double left, double top, StructureDefinition sd, ElementDefinition e, String path, LineStatus ls, double height, double width) throws FHIRException, IOException  {
    if (e.getStandardsStatus() != null) {
      var rect = g.svgRect(null);
      rect.attribute("x", Double.toString(left+1));
      rect.attribute("y", Double.toString(top-height+GAP_HEIGHT));
      rect.attribute("id", prefix+"n"+(++nc));
      rect.attribute("width", Double.toString(width-2));
      rect.attribute("height", Double.toString(height));
      rect.style("fill:"+e.getStandardsStatus().getColorSvg()+";stroke:black;stroke-width:0");
    }
    var html = g.htmlObject(left + LEFT_MARGIN + (ls.line == 0 ? 0 : WRAP_INDENT), top + LINE_HEIGHT * (ls.line-1), width-2, height); 
    var div = html.div().attribute("xmlns", "http://www.w3.org/1999/xhtml");
    div.attribute("class", "diagram-class-detail");
    if (e.prohibited()) {
      div.style("text-decoration: line-through");
    }

    var a = div.ah(urlForAttribute(sd, e, path)).style("text-decoration: none;");
    a.attributeNN("title", getEnhancedDefinition(e));
    a.tx(ls.see(e.getName()));

    div.tx(ls.see(" : "));
    if (e.hasContentReference()) {
      encodeType(div, ls, e.getContentReference().substring(e.getContentReference().indexOf("#")+1));      
    } else {
      encodeType(div, ls, getTypeCodeForElement(e.getType()));
    }
    div.tx(ls.see(" ["+describeCardinality(e)+"]"));

    if (!"0".equals(e.getMax())) {
      if (constraintMode) { 
        // in constraint mode, we're (usually) even more constrained for space, and we have a lot more kinds of constraints 
        // to deal with 
        Set<String> p = new HashSet<>();
        Set<String> tp = new HashSet<>(); 
        for (TypeRefComponent tr : e.getType()) {
          for (CanonicalType ct : tr.getProfile()) {
            p.add(ct.asStringValue());
          }
          for (CanonicalType ct : tr.getTargetProfile()) {
            if (!ct.asStringValue().startsWith("http://hl7.org/fhir/StructureDefinition/")) {
              tp.add(ct.asStringValue());
            }
          }
        }        
        flag(div, ls, !p.isEmpty(), "DP", "black", "#c787ff", rc.formatPhrase(RenderingContext.GENERAL_TYPE_PROFILE, CommaSeparatedStringBuilder.join(",", Utilities.sorted(p))), null);
        flag(div, ls, !tp.isEmpty(), "TP", "black", "#c787ff", rc.formatPhrase(RenderingContext.GENERAL_TYPE_TARGET_PROFILE, CommaSeparatedStringBuilder.join(",", Utilities.sorted(tp))), null);
        
        flag(div, ls, e.getIsModifier(), "?!", "black", "white", rc.formatPhrase(RenderingContext.STRUC_DEF_MOD), null);
//        flag(div, ls, e.getIsSummary(), "\u03A3", "white", "black", rc.formatPhrase(RenderingContext.STRUC_DEF_ELE_INCLUDED), null);
        
        if (e.getMustSupport() && e.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) {
          flag(div, ls, e.getMustSupport(), "SO", "white", "red", rc.formatPhrase(RenderingContext.STRUC_DEF_OBLIG_SUPP), null);        
        } else if (e.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) {
          flag(div, ls, e.getMustSupport(), "O", "white", "red", rc.formatPhrase(RenderingContext.STRUC_DEF_OBLIG), null);
        } else {
          flag(div, ls, e.getMustSupport(), "S", "white", "red", rc.formatPhrase(RenderingContext.STRUC_DEF_ELE_MUST_SUPP), null);
        }
        flag(div, ls, e.getMustHaveValue(), "V", "black", "#f7a3ec", rc.formatPhrase(RenderingContext.STRUC_DEF_ELE), null);
        flag(div, ls, e.hasValueAlternatives(), "?X", "black", "#f7a3ec", rc.formatPhrase(RenderingContext.STRUC_DEF_VALUE_ALT), null);
        flag(div, ls, StructureDefinitionRenderer.hasNonBaseConstraints(e.getConstraint()) || StructureDefinitionRenderer.hasNonBaseConditions(e.getCondition()), "C", "black", "#7779e6", rc.formatPhrase(RenderingContext.STRUC_DEF_ELE_AFFECTED), null);
        flag(div, ls, e.hasFixed(), "F", "black", "#95fc9c", rc.formatPhrase(RenderingContext.GENERAL_FIXED_VALUE, renderDT(e.getFixed())), null);
        flag(div, ls, e.hasPattern(), "P", "black","#95fc9c", rc.formatPhrase(RenderingContext.GENERAL_PATTERN_VALUE, renderDT(e.getPattern())), null);
        if (e.hasMinValue() || e.hasMaxValue()) {
          if (e.hasMinValue() && e.hasMaxValue()) {
            flag(div, ls, true, "L<<H", "black", "green", rc.formatPhrase(RenderingContext.GENERAL_VALUE_BOUNDED, e.getMaxLength()), null);
          } else {
            flag(div, ls, e.hasMaxValue(), "L<", "black", "#95fc9c", rc.formatPhrase(RenderingContext.GENERAL_VALUE_MIN, renderDT(e.getMinValue())), null);            
            flag(div, ls, e.hasMaxValue(), "<H", "black", "#95fc9c", rc.formatPhrase(RenderingContext.GENERAL_VALUE_MAX, renderDT(e.getMaxValue())), null);
          }
        }
        flag(div, ls, e.hasMaxLength(), "<L", "black", "#95fc9c", rc.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH, e.getMaxLength()), null);
        if (e.hasBinding()) {
          ValueSet vs = context.fetchResource(ValueSet.class, path);
          if (e.getBinding().getStrength() == BindingStrength.REQUIRED) {
            flag(div, ls, true, "B!", "black", "#fad570", rc.formatPhrase(RenderingContext.GENERAL_REQUIRED_BINDING, describeVS(e.getBinding().getValueSet(), vs)), vsLink(e.getBinding().getValueSet(), vs));            
          } else if (e.getBinding().getStrength() == BindingStrength.EXTENSIBLE) {
            flag(div, ls, true, "B?", "black", "#fad570", rc.formatPhrase(RenderingContext.GENERAL_REQUIRED_BINDING, describeVS(e.getBinding().getValueSet(), vs)), vsLink(e.getBinding().getValueSet(), vs));                        
          } 
          flag(div, ls, e.hasExtension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL), "B+", "black", "#fad570", rc.formatPhrase(RenderingContext.GENERAL_ADDITIONAL_BINDING), null);
        }
      } else {

        boolean hasTS = !((e.getType().isEmpty()) || (e.getType().size() == 1 && !isReference(e.getType().get(0).getName())));
        boolean hasBinding = e.hasBinding() && e.getBinding().getStrength() != BindingStrength.NULL;
        if (hasTS || hasBinding) {
          div.tx(ls.see(" \u00AB "));
          if (hasTS) {
            if (isReference(e.getTypeFirstRep().getWorkingCode()) && e.getType().size() == 1) {
              boolean first = true;
              for (CanonicalType p : e.getTypeFirstRep().getTargetProfile()) {
                if (first)
                  first = false;
                else 
                  div.tx(ls.see(" | "));
                StructureDefinition sdt = context.fetchResource(StructureDefinition.class, p.asStringValue(), null, sd);
                String s = sdt == null ? tail(p.asStringValue()) : sdt.getName();
                ls.check(html, div, left, top, s.length(), null);
                encodeType(div, ls, s);
              }
            } else {
              boolean firstOuter = true;
              for (TypeRefComponent t : e.getType()) {
                if (firstOuter)
                  firstOuter = false;
                else 
                  div.tx(ls.see(" | "));

                ls.check(html, div, left, top, t.getName().length(), null);
                encodeType(div, ls, t.getWorkingCode());
              }
            }
          }
          if (hasTS && hasBinding) {
            div.tx(ls.see("; "));
          }
          if (hasBinding) {
            ElementDefinitionBindingComponent b = e.getBinding();
            ValueSet vs = context.fetchResource(ValueSet.class, b.getValueSet()); 
            String name = vs != null ? vs.getName() : tail(b.getValueSet());
            if (name.toLowerCase().endsWith(" codes"))
              name = name.substring(0, name.length()-5);
            if (name.length() > 30)
              name = name.substring(0, 29)+"...";
            String link = vs == null ? null : vs.getWebPath();
            String suffix = "";
            suffix = getBindingSuffix(b);
            div.ahOrNot(link, b.getDescription()+" (Strength="+(b.getStrength() == null ? "null " : b.getStrength().getDisplay())+")").tx(ls.see(name+suffix));
          }
          div.tx(ls.see(" \u00BB"));

        }
      }
    }
    return ls.line;
  }

  private String urlForAttribute(StructureDefinition sd, ElementDefinition ed, String path) {
    String fullPath = path+"."+ed.getName(); //.replace("[", "_").replace("]", "_");
    if (!ed.getPath().equals(ed.getBase().getPath()) || (ed.getBase().hasPath() && sd.getDerivation() == StructureDefinition.TypeDerivationRule.CONSTRAINT)) {
      StructureDefinition sdt = context.fetchTypeDefinition(head(ed.getBase().getPath()));
      if (sdt != null && !ExtensionUtilities.hasExtension(sdt, ExtensionDefinitions.EXT_RESOURCE_INTERFACE)) {
        sd = sdt;
        fullPath = ed.getBase().getPath();
      }
    }
    return (sd == defnSD && defnFile != null ? defnFile : sd.getWebPath())+"#"+fullPath;
  }

  private String getBindingSuffix(ElementDefinitionBindingComponent b) {
    String suffix;
    if (b.getStrength() == null) {
      return "??";
    }
    switch (b.getStrength()) {
    case EXAMPLE:
      suffix = "??";
      break;
    case EXTENSIBLE:
      suffix = "+";
      break;
    case PREFERRED:
      suffix = "?";
      break;
    case REQUIRED:
      suffix = "!";
      break;
    case NULL:
    default:
      suffix = "??";
      break;
    }
    return suffix;
  }

  private boolean hasNonBaseProfile(List<CanonicalType> list) {
    for (CanonicalType ct : list) {
      if (!ct.asStringValue().startsWith("http://hl7.org/fhir/StructureDefinition/")) {
        return true;
      }
    }
    return false;
  }

  private String vsLink(String url, ValueSet vs) {
    if (vs != null) {
      return vs.getWebPath();
    } else {
      return url;      
    }
  }

  private String describeVS(String url, ValueSet vs) {
    if (vs != null) {
      return vs.present()+" ("+url+")";
    } else {
      return "("+url+")";      
    }
  }

  private String renderDT(DataType dt) {
    if (dt == null) {
      return "";
    } else if (dt.isPrimitive()) {
      return dt.primitiveValue();
    } else {
      switch (dt.fhirType()) {
      case "Quantity" : return renderQty((Quantity) dt);
      case "Coding" : return renderCoding((Coding) dt);
      case "CodeableConcept" : return renderCC((CodeableConcept) dt);
      default:
        return new DataRenderer(rc).displayDataType(dt);
      }
    }
  }

  private String renderCC(CodeableConcept cc) {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (Coding c : cc.getCoding()) {
      if (first) first = false; else b.append(", ");
      b.append(renderCoding(c));
    }
    if (b.length() > 0 && cc.hasText()) {
      b.append(". ");
    }
    if (cc.hasText()) {
      b.append("text: ");
      b.append(cc.getText());
    }
    return b.toString();
  }

  private String renderCoding(Coding c) {
    StringBuilder b = new StringBuilder();
    if (c.hasSystem()) {
      b.append(new DataRenderer(rc).displaySystem(c.getSystem()));
      if (c.hasCode()) {
        b.append("#");
      }
    }
    if (c.hasCode()) {
      b.append(c.getCode());
    }
    if (c.hasDisplay()) {
      b.append("\"");
      b.append(c.getDisplay());
      b.append("\"");
    }
    return b.toString();
  }

  private String renderQty(Quantity qty) {
    StringBuilder b = new StringBuilder();
    if (qty.hasComparator()) {
      b.append(qty.getComparatorElement().asStringValue());
    }
    b.append(qty.getValueElement().asStringValue());
    if (qty.hasUnit()) {
      b.append(qty.getUnit());
    } else if (qty.hasCode()) {
      b.append(qty.getCode());      
    }
    return b.toString();
  }

  private void flag(XhtmlNode x, LineStatus ls, Boolean show, String code, String foreColor, String backColor, String title, String url) throws IOException {
    if (show) { 
      // <a style="padding-left: 3px; padding-right: 3px; border: 1px maroon solid; font-weight: bold; color: #301212; background-color: #fdf4f4;" href="conformance-rules.html#constraints" title="This element has or is affected by some invariants">C</a>
      x.tx(" ");
      var xx = url == null ? x.span() : x.ah(url).style("text-decoration: none;");
      xx.style("padding-left: 3px; padding-right: 3px; font-weight: bold; font-family: verdana; color: "+foreColor+"; background-color: "+backColor);
      xx.attribute("title", title);
      xx.tx(code);
      ls.see(code+" ");
    }
  }

  private String tail(String url) {
    if (Utilities.noString(url)) {
      return "";
    }
    return url.contains("/") ? url.substring(url.lastIndexOf("/")+1) : url;
  }

  private String describeCardinality(ElementDefinition e) {
    String min = !e.hasMin() ? "" : e.getMinElement().asStringValue();
    String max = !e.hasMax() ? "" : e.getMax();
    return min + ".." + max;
  }

  private int encodeType(XhtmlNode text, LineStatus ls, String tc)  throws FHIRException, IOException {
    if (tc == null) {
      return 0;
    } else if (tc.equals("*")) {
      var a = text.ah(Utilities.pathURL(rc.getLink(KnownLinkType.SPEC, true), "datatypes.html#open")).style("text-decoration: none;");;
      a.tx(ls.see(tc));
      return tc.length();
    } else if (tc.equals("Type")) {
      var a = text.ah(Utilities.pathURL(rc.getLink(KnownLinkType.SPEC, true), "formats.html#umlchoice")).style("text-decoration: none;");;
      a.tx(ls.see(tc));
      return tc.length();
    } else if (tc.startsWith("@")) { 
      var a = text.ah("@"+tc.substring(1)).style("text-decoration: none;");;
      a.tx(ls.see(tc));
      return tc.length();
    } else { 
      StructureDefinition sd = Utilities.isAbsoluteUrl(tc) ? context.fetchTypeDefinition(tc) : null;
      if (sd != null) {
        var a = text.ah(sd.getWebPath()).style("text-decoration: none;");;
        a.tx(ls.see(sd.getName()));
        return tc.length();
      }
      var a = text.ah(makeLink(tc)).style("text-decoration: none;");;
      a.tx(ls.see(tc));
      return tc.length();
    }
  }


  private String makeLink(String tc) {
    StructureDefinition sd = context.fetchTypeDefinition(tc);
    return sd == null ? null : sd.getWebPath();
  }

  private String getEnhancedDefinition(ElementDefinition e) {
    String defn = pvt(e.getDefinitionElement());
    if (e.getIsModifier() && e.getMustSupport()) {
      return Utilities.removePeriod(defn) + " "+rc.formatPhrase(RenderingI18nContext.SDR_MOD_SUPP);
    } else if (e.getIsModifier()) {
      return Utilities.removePeriod(defn) + " "+rc.formatPhrase(RenderingI18nContext.SDR_MOD);
    } else if (e.getMustSupport()) {
      return Utilities.removePeriod(defn) + " "+rc.formatPhrase(RenderingI18nContext.SDR_SUPP);
    } else {
      return Utilities.removePeriod(defn);
    }
  }   

  private String pvt(DataType ed) {
    return ed.getTranslation(lang);
  }

  private String baseUrl(StructureDefinition sd, ElementDefinition ed, String path) throws FHIRException, IOException {
    if (!ed.getPath().equals(ed.getBase().getPath())) {
      StructureDefinition sdt = context.fetchTypeDefinition(head(ed.getBase().getPath()));
      if (sdt != null) {
        sd = sdt;
      }
    }
    return sd.getWebPath()+"#";
  }

  private String head(String path) {
    return path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
  }

  private String[] textForAttribute(StructureDefinition sd, ElementDefinition e) throws FHIRException, IOException {
    LineStatus ls = new LineStatus();
    XhtmlNode svg = new XhtmlNode(NodeType.Element, "svg"); // this is a dummy
    addAttribute(svg.svgG(null), 0, 0, sd, e, "Element.id", ls, 0, 0);
    ls.close();
    return ls.list.toArray(new String[] {});
  }


  private String getTypeCodeForElement(List<TypeRefComponent> tl) {
    if (tl.isEmpty())
      return "??";
    if (tl.size() == 1 && !isReference(tl.get(0).getName()))
      return tl.get(0).getName();
    String t = tl.get(0).getName();
    boolean allSame = true;
    for (int i = 1; i < tl.size(); i++) {
      allSame = t.equals(tl.get(i).getName());
    }
    if (allSame && t.equals("Reference")) {
      return "Reference";
    } else if (allSame && t.equals("canonical")) {
      return "canonical";
    } else if (allSame && t.equals("CodeableReference")) {
      return "CodeableReference";
    }  else {
      boolean allPrimitive = true;
      for (TypeRefComponent tr : tl) {
        StructureDefinition sd = context.fetchTypeDefinition(tr.getWorkingCode());
        if (sd == null || sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE) {
          allPrimitive = false;
        }
      }
      if (VersionUtilities.isR4BVer(context.getVersion())) {
        return "Element";
      } if (allPrimitive) {
        return "PrimitiveType";
      } else {
        return "DataType";
      }
    }
  }

  private boolean isReference(String name) {
    return name != null && (name.equals("Reference") || name.equals("canonical") || name.equals("CodeableReference"));
  }



  private boolean isAttribute(StructureDefinition sd, ElementDefinition c) {
    return putils.getChildList(sd, c).isEmpty();
  }

  private double textWidth(String text) {
    return text.length() * CHAR_RATIO;
  }


  private ClassItem drawElement(XhtmlNode svg, List<String> classNames) throws Exception {
    if (classNames != null) {
      for (String cn : classNames) {
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, cn);
        if (sd == null) {
          sd = cutils.fetchStructureByName(cn);
        }
        ElementDefinition ed = sd.getSnapshot().getElementFirstRep();

        StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());       
        ClassItem parent = base == null ? null : classes.get(base.getName());
        if (parent == null) {
          drawClass(svg, sd, ed, cn, sd.getStandardsStatus(), base);
        } else {
          links.add(new Link(parent, drawClass(svg, sd, ed, cn, sd.getStandardsStatus(), null), LinkType.SPECIALIZATION, null, null, PointKind.unknown, null, null));
        }

      }
    }
    return null;
  }

  private ClassItem drawClassElement(XhtmlNode svg, StructureDefinition sd) throws FHIRException, IOException {
    ElementDefinition ed = sd.getSnapshot().getElementFirstRep();

    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());       
    ClassItem parent = base == null ? null : classes.get(base.getName());
    if (parent == null) {
      drawClass(svg, sd, ed, ed.getName(), sd.getStandardsStatus(), base);
    } else {
      links.add(new Link(parent, drawClass(svg, sd, ed, sd.getName(), sd.getStandardsStatus(), null), LinkType.SPECIALIZATION, null, null, PointKind.unknown, null, null));
    }
    return null;
  }
  
  private ClassItem drawClass(XhtmlNode svg, StructureDefinition sd, ElementDefinition ed, String path, StandardsStatus status, StructureDefinition parent) throws FHIRException, IOException {
    ClassItem item = classes.get(path);
    if (item == null) {
      throw new FHIRException("Unable to find a class for "+path+" from "+CommaSeparatedStringBuilder.join(",", classes.keySet()));
    }

    var g = svg.svgG(null);
    g.attribute("id", prefix+"n"+(++nc));
    var rect = g.svgRect(null);
    rect.attribute("x", Double.toString(item.left));
    rect.attribute("y", Double.toString(item.top));
    rect.attribute("rx", "4");
    rect.attribute("ry", "4");
    rect.attribute("width", Double.toString(item.width));
    rect.attribute("height", Double.toString(item.height));
    rect.attribute("filter", "url(#shadow"+diagramId+")");
    String borderColor = item.getMode() == ClassItemMode.SLICE ? SLICE_COLOR : "black";
    if (status == null) {
      rect.style("fill:"+(status == null ? "#ffffff" : status.getColorSvg())+";stroke:"+borderColor+";stroke-width:1");
    } else {
      rect.style("fill:"+status.getColorSvg()+";stroke:"+borderColor+";stroke-width:1");
    }
    rect.attribute("id", prefix+item.getId());

    var line = g.svgLine(null);
    line.attribute("x1", Double.toString(item.left));
    line.attribute("y1", Double.toString(item.top+HEADER_HEIGHT + GAP_HEIGHT*2));
    line.attribute("x2", Double.toString(item.left+item.width));
    line.attribute("y2", Double.toString(item.top+HEADER_HEIGHT + GAP_HEIGHT*2));
    line.style("stroke:dimgrey;stroke-width:1");
    line.attribute("id", prefix+"n"+(++nc));

    var text = g.svgText(null);
    text.attribute("x", Double.toString(item.left + item.width / 2));
    text.attribute("y", Double.toString(item.top+HEADER_HEIGHT));
    text.attribute("fill", "black");
    if (!path.contains(".")) 
      text.attribute("class", "diagram-class-title  diagram-class-resource");
    else 
      text.attribute("class", "diagram-class-title");
    if (parent == null) {
      text.attribute("id", prefix+"n"+(++nc));
      if (!path.contains(".") && sd.getAbstract()) {
        text.style("font-style: italic");
      }

      var a = text.svgAx(makeLink(item.getName()));
      a.attribute("id", prefix+"n"+(++nc));
      a.tx(item.getName());

      //      if (definitions.getBaseResources().containsKey(e.getName()) && definitions.getBaseResources().get(e.getName()).isInterface()) {
      //        xml.text(" ");
      //        xml.attribute("xlink:href", "uml.html#interface");
      //        xml.enter("a");
      //        xml.text("«Interface»");
      //        xml.exit("a");
      //      }
    } else if (!path.contains(".")) {
      text.attribute("id", prefix+"n"+(++nc));
      if (!path.contains(".") && sd.getAbstract()) {
        text.style("font-style: italic");
      }
      var a = text.svgAx(sd.getWebPath());
      a.tx(item.getName());
      text.tx(" (");
      a = text.svgAx(parent.getWebPath());
      a.attribute("class", "diagram-class-reference");
      a.attribute("id", prefix+"n"+(++nc));
      a.style("font-style: italic");
      a.tx(parent.getName());
      text.tx(")");
    } else {
      text.attribute("id", prefix+"n"+(++nc));
      text.tx(item.getName());
    }

    List<ElementDefinition> children = putils.getChildList(sd, ed);
    if (attributes) {
      int i = 0;
      for (ElementDefinition c : children) {
        if (inScope(c) && countsAsAttribute(sd, c)) {
          i++;
          addAttribute(g, item.left, item.top+HEADER_HEIGHT + GAP_HEIGHT*2 + LINE_HEIGHT * i, sd, c, path, LINE_HEIGHT, item.width);
          String[] texts = textForAttribute(sd, c);
          i = i + texts.length - 1;
        }
      }
    }


    if (innerClasses) {
      for (ElementDefinition c : children) {
        if (inScope(c) && countsAsRelationship(sd, c)) {
          if (!c.hasSliceName()) {
            if (c.hasContentReference()) {
              String cr = c.getContentReference();
              ClassItem target = classes.get(cr.substring(cr.indexOf("#")+1));
              links.add(new Link(item, target, LinkType.COMPOSITION, c.getName(), describeCardinality(c), PointKind.unknown, baseUrl(sd, c, path)+path+"."+c.getName(), getEnhancedDefinition(c)));
            } else { 
              ClassItem cc = drawClass(svg, sd, c, path+"."+c.getName(), status, null);
              links.add(new Link(item, cc, LinkType.COMPOSITION, c.getName(), describeCardinality(c), PointKind.unknown, baseUrl(sd, c, path)+path+"."+c.getName(), getEnhancedDefinition(c)));
              if (c.hasSlicing()) {
                List<ElementDefinition> slices = getSlices(children, c);
                for (ElementDefinition s : slices) {
                  ClassItem cc1 = drawClass(svg, sd, s, path+"."+c.getName()+":"+s.getSliceName(), status, null);
                  links.add(new Link(cc, cc1, LinkType.SLICE, "", describeCardinality(s), PointKind.unknown, baseUrl(sd, s, path)+path+"."+c.getName()+":"+s.getSliceName(), getEnhancedDefinition(c)));
                }
              }
            }
          }
        }
      }
    }
    return item;  
  }

  private void drawLink(XhtmlNode svg, Link l, XhtmlNode insertionPoint) throws FHIRException, IOException {
    Point start;
    Point end;
    Point p1;
    Point p2;
    String id = l.source.id + "-" + l.target.id;
    if (l.source == l.target) {
      start = new Point(l.source.right(), l.source.centerV() - SELF_LINK_HEIGHT, PointKind.unknown);
      end = new Point(l.source.right(), l.source.centerV() + SELF_LINK_HEIGHT, PointKind.right);
      p1 = new Point(l.source.right() + SELF_LINK_WIDTH, l.source.centerV() - SELF_LINK_HEIGHT, PointKind.unknown);
      p2 = new Point(l.source.right() + SELF_LINK_WIDTH, l.source.centerV() + SELF_LINK_HEIGHT, PointKind.unknown);

      var path = svg.svgPath(insertionPoint);
      path.attribute("id", prefix+id);
      path.attribute("d", checkForLinkPathData(id, "M"+start.x+" "+start.y+" L"+p1.x+" "+p1.y+" L"+p1.x+" "+p1.y+" L"+p2.x+" "+p2.y+" L"+end.x+" "+end.y));
      path.style("stroke:navy;stroke-width:1;fill:none");

    } else {
      Point c1 = new Point(l.source.centerH(), l.source.centerV(), PointKind.unknown);
      Point c2 = new Point(l.target.centerH(), l.target.centerV(), PointKind.unknown);

      start = intersection(c1, c2, l.source);
      end = intersection(c1, c2, l.target);
      if (l.count > 0) {
        start.x = adjustForDuplicateX(start.x, start.kind, l.index);
        start.y = adjustForDuplicateY(start.y, start.kind, l.index);
        end.x = adjustForDuplicateX(end.x, end.kind, l.index);
        end.y = adjustForDuplicateY(end.y, end.kind, l.index);

      }
      p1 = end;
      p2 = start;
      if (start != null && end != null) {
        var path = svg.svgPath(insertionPoint);
        path.attribute("d", checkForLinkPathData(id, "M"+Double.toString(start.x)+" "+Double.toString(start.y)+" L"+Double.toString(end.x)+" "+Double.toString(end.y)));
        if (l.type == LinkType.CONSTRAINT)
          path.style("stroke:orange;stroke-width:1;fill:none");
        else if (l.type == LinkType.SLICE)
          path.style("stroke:"+SLICE_COLOR+";stroke-width:2;fill:none");
        else
          path.style("stroke:navy;stroke-width:1;fill:none");
        path.attribute("id", prefix+id);      
      }
    }

    if (start != null && end != null) {
      if (l.name == null) {
        Point pd1 = calcGenRight(start, p1);
        Point pd2 = calcGenLeft(start, p1);
        var polygon = svg.svgPolygon(insertionPoint);
        polygon.attribute("points", start.toPoint() +" " +pd1.toPoint() +" " +pd2.toPoint() +" " +start.toPoint());
        polygon.style("fill:white;stroke:navy;stroke-width:1");
        polygon.attribute("transform", "rotate("+getAngle(start, p1)+" "+Double.toString(start.x)+" "+Double.toString(start.y)+")");
        polygon.attribute("id", prefix+"n"+(++nc));
      } else {
        // draw the diamond
        if (l.type != LinkType.SLICE) {
          Point pd2 = calcDiamondEnd(start, p1);
          Point pd1 = calcDiamondRight(start, p1);
          Point pd3 = calcDiamondLeft(start, p1);
          var polygon = svg.svgPolygon(insertionPoint);
          polygon.attribute("points", checkForLinkPoints(id, start.toPoint() +" " +pd1.toPoint() +" " +pd2.toPoint() +" " +pd3.toPoint()+" "+start.toPoint()));
          polygon.style("fill:navy;stroke:navy;stroke-width:1");
          polygon.attribute("transform", checkForLinkTransform(id, "rotate("+getAngle(start, p1)+" "+Double.toString(start.x)+" "+Double.toString(start.y)+")"));
          polygon.attribute("id", prefix+id+"-lpolygon");
        }

        // draw the name half way along
        double x = (int) (p1.x + p2.x) / 2;
        double y = (int) (p1.y + p2.y) / 2 + LINE_HEIGHT / 2 + LINE_HEIGHT * l.index;
        double w = (int) (textWidth(l.name));    
        var g = svg.svgG(insertionPoint);
        var rect = g.svgRect(null);
        rect.attribute("x", checkForKnownX(id, id+"-lrect", Double.toString(x - w/2)));
        rect.attribute("y", checkForKnownY(id, id+"-lrect", Double.toString(y - LINE_HEIGHT)));
        rect.attribute("width", Double.toString(w));
        rect.attribute("height", Double.toString(LINE_HEIGHT + GAP_HEIGHT));
        rect.style("fill:white;stroke:black;stroke-width:0");
        rect.attribute("id", prefix+id+"-lrect");
        
        var text = g.svgText(null);

        text.attribute("x", checkForKnownX(id, id+"-lname", Double.toString(x)));
        text.attribute("y", checkForKnownY(id, id+"-lname", Double.toString(y - GAP_HEIGHT)));
        text.attribute("fill", "black");
        text.attribute("class", "diagram-class-linkage");
        text.attribute("id", prefix+id+"-lname");
        var a = text.svgAx(l.path);
        a.attribute("id", prefix+"n"+(++nc));        
        a.addTag("title").tx(l.description);
        a.tx(l.name);


        // draw the cardinality at the terminal end
        x = end.x;
        y = end.y;
        if (end.kind == PointKind.left) {
          y = y - GAP_HEIGHT;
          x = x - 20;
        } else if (end.kind == PointKind.top)
          y = y - GAP_HEIGHT;
        else if (end.kind == PointKind.right) {
          y = y - GAP_HEIGHT;
          x = x + 15;
        } else if (end.kind == PointKind.bottom) 
          y = y + LINE_HEIGHT;
        w = 18;        
        text = svg.svgText(insertionPoint);
        text.attribute("x", checkForKnownX(id, id+"-lcard", Double.toString(x)));
        text.attribute("y", checkForKnownY(id, id+"-lcard", Double.toString(y)));
        text.attribute("fill", "black");
        text.attribute("class", "diagram-class-linkage");
        text.attribute("id", prefix+id+"-lcard");
        text.tx("["+l.cardinality+"]");
      }
    }
  }

  private String checkForKnownY(String baseId, String id, String defaultValue) {
    if (linkLayouts.containsKey(baseId) && linkLayouts.get(baseId).use && layout.containsKey(id)) {
      return ""+layout.get(id).y;
    } else {
      return defaultValue;
    }
  }

  private String checkForKnownX(String baseId, String id, String defaultValue) {
    if (linkLayouts.containsKey(baseId) && linkLayouts.get(baseId).use && layout.containsKey(id)) {
      return ""+layout.get(id).x;
    } else {
      return defaultValue;
    }
  }

  private String checkForLinkTransform(String id, String defaultValue) {
    if (linkLayouts.containsKey(id) && linkLayouts.get(id).use && linkLayouts.get(id).diamondTransform != null) {
      return linkLayouts.get(id).diamondTransform;
    } else {
      return defaultValue;
    }
  }

  private String checkForLinkPoints(String id, String defaultValue) {
    if (linkLayouts.containsKey(id) && linkLayouts.get(id).use && linkLayouts.get(id).diamondPoints != null) {
      return linkLayouts.get(id).diamondPoints;
    } else {
      return defaultValue;
    }
  }

  private String checkForLinkPathData(String id, String defaultValue) {
    if (linkLayouts.containsKey(id) && linkLayouts.get(id).use && linkLayouts.get(id).pathData != null) {
      return linkLayouts.get(id).pathData;
    } else {
      return defaultValue;
    }
  }

  private String abs(double d) {
    if (d < 0) {
      return Double.toString(-d);
    } else {
      return Double.toString(d);
    }
  }

  private double adjustForDuplicateX(double x, PointKind kind, int index) {
    switch (kind) {
    case bottom: 
      return x + (DUPLICATE_GAP * (index - 0.5));
    case top:
      return x + (DUPLICATE_GAP * (index - 0.5));
    default:
      return x;        
    }
  }

  private double adjustForDuplicateY(double y, PointKind kind, int index) {
    switch (kind) {
    case left: 
      return y - (DUPLICATE_GAP * (index - 0.5));
    case right:
      return y - (DUPLICATE_GAP * (index - 0.5));
    default:
      return y;        
    }
  }

  private String getAngle(Point start, Point end) {
    double inRads = Math.atan2(end.y - start.y, end.x-start.x);
    //    if (inRads < 0)
    //      inRads = Math.abs(inRads);
    //  else
    //      inRads = 2*Math.PI - inRads;

    return Double.toString(Math.toDegrees(inRads));
  }

  private Point calcDiamondEnd(Point start, Point end) {
    return new Point(start.x+12, start.y+0, PointKind.unknown);
  }

  private Point calcDiamondRight(Point start, Point end) {
    return new Point(start.x+6, start.y+4, PointKind.unknown);
  }

  private Point calcDiamondLeft(Point start, Point end) {
    return new Point(start.x+6, start.y-4, PointKind.unknown);
  }

  private Point calcGenRight(Point start, Point end) {
    return new Point(start.x+8, start.y+6, PointKind.unknown);
  }

  private Point calcGenLeft(Point start, Point end) {
    return new Point(start.x+8, start.y-6, PointKind.unknown);
  }

  private Point intersection(Point start, Point end, ClassItem box) {
    Point p = calculateIntersect(start.x, start.y, end.x, end.y, box.left, box.top, box.left + box.width, box.top, PointKind.top);
    if (p == null)
      p = calculateIntersect(start.x, start.y, end.x, end.y, box.left, box.top+box.height, box.left+box.width, box.top+box.height, PointKind.bottom);
    if (p == null)
      p = calculateIntersect(start.x, start.y, end.x, end.y, box.left, box.top, box.left, box.top+box.height, PointKind.left);
    if (p == null)
      p = calculateIntersect(start.x, start.y, end.x, end.y, box.left+box.width, box.top, box.left+box.width, box.top+box.height, PointKind.right);
    return p;
  }

  private Point calculateIntersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, PointKind kind) {
    Segment s1 = new Segment(new Point(x1,y1, PointKind.unknown),  new Point(x2,y2, PointKind.unknown));
    Segment s2 = new Segment(new Point(x3,y3, PointKind.unknown),  new Point(x4,y4, PointKind.unknown));
    return hasIntersection(s1, s2, kind);
    //    double slope1 = (y2-y1) / (x2-x1);
    //    double slope2 = (y4-y3) / (x4-x3);
    //
    //    if (Math.abs(slope1 - slope2) < 0.000001)
    //      return null;
    //    
    //    double x = ( ( (x4*y3 - y4*x3) / (x4-x3) ) - ( (x2-y1 - y2*x1) / (x2-x1) ) ) / ( slope1 - slope2 );
    //    double y = slope1 * x + ( (x2*y1 - y2*x1) / (x2-x1) );
    //    
    //    if (inBounds(x, x1, x2) && inBounds(x, x3, x4) && inBounds(y, y1, y2) && inBounds(y, y3, y4))
    //      return new Point((int) x, (int) y);
    //    else
    //      return null;
  }

  public Point hasIntersection(Segment segment1, Segment segment2, PointKind kind){

    if (segment1.isVertical){
      if (segment2.isVertical) // ( (segment2.start.x - segment1.start.x)*(segment2.end.x - segment1.start.x) > 0 )
        return null;
      else {
        double fx_at_segment1startx = segment2.slope * segment1.start.x - segment2.intercept;
        if (inBounds(fx_at_segment1startx, segment1.start.y, segment1.end.y) && inBounds(segment1.start.x, segment2.start.x, segment2.end.x))
          return new Point(segment1.start.x, fx_at_segment1startx, kind);
        else
          return null;
      }
    }
    else if (segment2.isVertical){
      return hasIntersection(segment2, segment1, kind);
    }
    else { //both segment1 and segment2 are not vertical 
      if (segment1.slope == segment2.slope)
        return null;
      else {
        double x1 = segment1.start.x;
        double y1 = segment1.start.y;
        double x2 = segment1.end.x;
        double y2 = segment1.end.y;
        double x3 = segment2.start.x;
        double y3 = segment2.start.y;
        double x4 = segment2.end.x;
        double y4 = segment2.end.y;
        double x = ((x4*y3-y4*x3)/(x4-x3) - (x2*y1-y2*x1)/(x2-x1)) /( (y2-y1)/(x2-x1) - (y4-y3)/(x4-x3));

        if (inBounds(x, x1, x2) && inBounds(x, x3, x4)) { 
          return new Point(x, (segment1.slope * x - segment1.intercept), kind);
        } else
          return null; 
      } 
    }
  }

  public String buildConstraintDiagram(StructureDefinition profile, String defnFile) throws FHIRException, IOException {
    this.defnFile = defnFile;
    this.defnSD = profile;
    File f = new File(Utilities.path(sourceFolder, diagramId+".svg"));
    if (f.exists()) {
      parseSvgFile(f, f.getAbsolutePath());
    }
    attributes = true;
    innerClasses = true;
    constraintMode = true;    
    classNames.add(profile.getName());


    XhtmlNode doc = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode svg = doc.svg();
    
    minx = 0;
    miny = 0;

    StructureDefinition sd = new SnapshotGenerationPreProcessor(putils).trimSnapshot(profile);
    
    Point size = determineConstraintMetrics(sd);
    adjustAllForMin(size);

    svg.attribute("id", prefix+"n"+(++nc));
    svg.attribute("version", "1.1");
    svg.attribute("width", Double.toString(size.x));
    svg.attribute("height", Double.toString(size.y));

    shadowFilter(svg);
    drawConstraintElement(svg, sd);
    countDuplicateLinks();
    XhtmlNode insertionPoint = svg.getChildNodes().get(0);
    for (Link l : links) {
      drawLink(svg, l, insertionPoint);
    }


    String s = new XhtmlComposer(true, true).compose(doc.getChildNodes());
    produceOutput("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+s);
    return s; 
  }

  private void drawConstraintElement(XhtmlNode svg, StructureDefinition sd) throws FHIRException, IOException {

    ElementDefinition ed = sd.getSnapshot().getElementFirstRep();

    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());       
    drawClass(svg, sd, ed, ed.getPath(), sd.getStandardsStatus(), base);
  }

  private Point determineConstraintMetrics(StructureDefinition sd) throws FHIRException, IOException {

    double width = textWidth("Element") * 1.8;
    double height = HEADER_HEIGHT + GAP_HEIGHT*2;
    //    if ("true".equals(ini.getStringProperty("diagram", "element-attributes"))) {
    //      height = height + LINE_HEIGHT + GAP_HEIGHT;
    //      width = textWidth("extension : Extension 0..*");
    //    }

    Point p = new Point(0, 0, PointKind.unknown);
    ClassItem item = new ClassItem(p.x, p.y, width, height, diagramId, null, ClassItemMode.NORMAL);
    classes.put(null, item);
    double x = item.right()+MARGIN_X;
    double y = item.bottom()+MARGIN_Y;
    ElementDefinition ed = sd.getSnapshot().getElementFirstRep();
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    p = determineMetrics(sd, ed, item, ed.getName(), null, base, ClassItemMode.NORMAL);
    x = Math.max(x, p.x+MARGIN_X);
    y = Math.max(y, p.y+MARGIN_Y);
    return new Point(x, y, PointKind.unknown);
  }

}
