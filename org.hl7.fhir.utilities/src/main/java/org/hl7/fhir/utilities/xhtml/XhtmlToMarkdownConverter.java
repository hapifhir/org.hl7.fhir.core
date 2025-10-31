package org.hl7.fhir.utilities.xhtml;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

import java.util.List;
import java.util.ArrayList;

/**
 * Convert XHTML to GFM flavoured markdown
 * <p>
 * This isn't always possible, but we do our best. The primary issue is that
 * GFM tables cannot be complex - if they contain nested tables, lists, or any other block content, the text format doesn't work
 * There's no much we can do about that, really, so we kid of try to suppress paragraphs but if there is nested content, it'll collapse as
 * a table.
 * <p>
 * Given that the primary target is AI systems this seems like a workable compromise
 * <p>
 * The filters are used by the IG publisher to strip out the common template content from the pages
 */
public class XhtmlToMarkdownConverter {

  private boolean allowForms;

  @Getter
  private List<String> imageFilters = new ArrayList<>();
  @Getter
  private List<String> classFilters = new ArrayList<>();
  @Getter
  private List<String> idFilters = new ArrayList<>();
  @Getter @Setter
  private boolean ignoreGeneratedTables;
  @Getter @Setter
  private boolean aiMode;
  @Getter @Setter
  private boolean processUnknown;

  public XhtmlToMarkdownConverter(boolean allowForms) {
    this.allowForms = allowForms;
  }

  public String convert(XhtmlNode x) {
    StringBuilder b = new StringBuilder();
    convert(b, x, true);
    return b.toString();
  }

  private void convert(StringBuilder b, XhtmlNode x, boolean allowParagraphs) {
    for (XhtmlNode c : x.getChildNodes()) {
      if (c.getNodeType() == NodeType.Text) {
        paragraph(b, c, true, true, true);
      } else if (c.getName() != null) {
        convertNode(b, c, allowParagraphs);
      }
    }

  }

  public void convertNode(StringBuilder b, XhtmlNode c, boolean allowParagraphs) throws Error {
    if (!elementPasses(c)) {
      return;
    }
    if (allowParagraphs) {
      para(b);
    }
    switch (c.getName()) {
      case "p":
        paragraph(b, c, true, false, allowParagraphs);
        break;
      case "hr":
        b.append("-------\r\n");
        break;
      case "a":
        paragraph(b, c, true, false, allowParagraphs);
        break;
      case "h1":
        b.append("# " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "h2":
        b.append("## " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "h3":
        b.append("### " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "h4":
        b.append("#### " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "h5":
        b.append("##### " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "h6":
        b.append("###### " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "strong":
      case "em":
      case "i":
      case "span":
      case "img":
      case "br":
      case "wbr":
      case "del":
      case "sup":
      case "sub":
      case "u":
      case "b":
        paragraph(b, c, true, false, allowParagraphs);
        break;
      case "code":
        paragraph(b, c, true, false, allowParagraphs);
        break;
      case "div":
        convert(b, c, allowParagraphs);
        if (allowParagraphs) para(b);
        break;
      case "ul":
        convertUL(b, c);
        break;
      case "li":
        convertLI(b, c);
        break;
      case "ol":
        convertOL(b, c);
        break;
      case "table":
      case "tbody":
        convertTable(b, c);
        break;
      case "iframe":
        convertIFrame(b, c);
        break;
      case "form":
      case "select":
      case "input":
      case "textarea":
      case "option":
        if (!allowForms) {
          convert(b, c, allowParagraphs);
        } else {
          convertForm(b, c);
        }
        break;
      case "label":
      case "cite":
        convertLabel(b, c, allowParagraphs);
        break;
      case "figure":
      case "figcaption":
        convert(b, c, allowParagraphs);
        break;
      case "dl":
      case "tt":
        convertDL(b, c);
        break;
      case "blockquote":
        b.append("> ");
        paragraph(b, c, false, true, allowParagraphs);
        b.append("\r\n");
        break;
      case "pre":
        b.append("```\r\n");
        XhtmlNode code = c.getElement("code");
        if (code != null) {
          b.append(code.toLiteralText());
        } else {
          b.append(c.toLiteralText());
        }
        b.append("\r\n```\r\n");
        break;
      case "para":
        // in error....
        convert(b, c, allowParagraphs);
        break;
      case "tr":
      case "td":
      case "th":
        // badly formed tables are ignored
        convert(b, c, allowParagraphs);
        break;
      case "title":
        b.append("# " + toMDText(c.allText()));
        if (allowParagraphs) {para(b); }
        break;
      case "style":
      case "script":
        break;
      // these are ignored if we're in 'page' mode - we just process the content
      case "html":
      case "head":
      case "meta":
      case "link":
      case "stylesheet":
      case "button":
      case "nav":
      case "body":
        if (allowForms) {
          throw new Error("not done yet: " + c.getName());
        } else {
          convert(b, c, allowParagraphs);
          break;
        }
      case "svg":
      case "object": // for svgs?
        // do nothing
        break;
      case "details":
        break;
      case "header":
        break;
      case "footer":
        break;
      case "embed":
        break;
      case "mark":
        break;
      case "map":
        break;
      case "center":
      case "font":
        convert(b, c, allowParagraphs);
        break;
      default:
        if (processUnknown) {
          convert(b, c, allowParagraphs);
        } else {
          throw new FHIRException("Illegal HTML element: " + c.getName());
        }
    }
  }

  private boolean elementPasses(XhtmlNode x) {
    String clss = x.getAttribute("class");
    if (clss != null) {
      for (String f : classFilters) {
        if (clss.matches(f) || clss.contains(f)) {
          return false;
        }
      }
    }
    String id = x.getAttribute("id");
    if (id != null) {
      for (String f : idFilters) {
        if (id.matches(f)) {
          return false;
        }
      }
    }
    if (aiMode && x.hasAttribute("data-fhir")) {
      return !x.getAttribute("data-fhir").startsWith("generated");
    }
    return true;
  }

  private void para(StringBuilder b) {
    if (!atStartOfPara2(b)) {
      b.append("\r\n");
    }
  }

  private void convertDL(StringBuilder b, XhtmlNode c) {
  }

  private void convertIFrame(StringBuilder b, XhtmlNode c) {
    b.append(c.toString());
  }

  private void convertForm(StringBuilder b, XhtmlNode c) {
    b.append(c.toString());
  }

  private void convertLabel(StringBuilder b, XhtmlNode c, boolean allowParagraphs) {
    convert(b, c, allowParagraphs);
  }

  /**
   * we're using the GFM format for tables, which doesn't allow nesting (not even any lists in tables)
   * we'll try to follow that, but if the table is complex, it won't work. Still, better to sort of get it right in markdown
   *
   * @param b
   * @param x
   */
  private void convertTable(StringBuilder b, XhtmlNode x) {
    if (ignoreGeneratedTables && x.hasAttribute("fhir") && x.getAttribute("fhir").startsWith("generated")) {
      return;
    }
    para(b);
    List<XhtmlNode> rows = new ArrayList<>();
    XhtmlNode headerRow = null;
    headerRow = processChildNodesForTable(rows, x, false);
    if (headerRow != null && !cells(headerRow).isEmpty() && aiMode) {
      List<String> headings = new ArrayList<>();
      for (XhtmlNode cell : cells(headerRow)) {
        StringBuilder bh = new StringBuilder();
        paragraph(bh, cell, false, true, false);
        String p = bh.toString().trim();
        headings.add(p);
      }
      for (XhtmlNode row : rows) {
        List<XhtmlNode> cells = cells(row);
        if (!cells.isEmpty()) {
          b.append("* "+headings.get(0) + ": ");
          paragraph(b, cells.get(0), false, true, false);
          b.append("\r\n");
          for (int i = 1; i < cells.size(); i++) {
            String h = i < headings.size() ? headings.get(i) : "?";
            b.append("  * " + h + ": ");
            paragraph(b, cells.get(i), false, true, false);
            b.append("\r\n");
          }
        }
      }
      b.append("\r\n");
    } else {

      int colCount = cells(headerRow).size();
      for (XhtmlNode row : rows) {
        colCount = Integer.max(colCount, cells(row).size());
      }
      // header row always exists but might be empty
      int c = 0;
      if (headerRow != null) {
        for (XhtmlNode cell : cells(headerRow)) {
          b.append("| ");
          paragraph(b, cell, false, true, false);
          b.append(" ");
          c++;
        }
      }
      for (int i = c; i < colCount; i++) {
        b.append("| ");
      }
      b.append("|\r\n");
      for (int i = 0; i < colCount; i++) {
        b.append("| :--- ");
      }
      b.append("|\r\n");
      for (XhtmlNode row : rows) {
        c = 0;
        for (XhtmlNode cell : cells(row)) {
          b.append("| ");
          paragraph(b, cell, false, true, false);
          b.append(" ");
          c++;
        }
        for (int i = c; i < colCount; i++) {
          b.append("| ");
        }
        b.append("|\r\n");
      }
    }
  }

  private List<XhtmlNode> cells(XhtmlNode row) {
    List<XhtmlNode> cells = new ArrayList<>();
    if (row != null) {
      for (XhtmlNode child : row.getChildNodes()) {
        if (Utilities.existsInList(child.getName(), "td", "th")) {
          cells.add(child);
        }
      }
    }
    return cells;
  }

  private XhtmlNode processChildNodesForTable(List<XhtmlNode> rows, XhtmlNode x, boolean header) {
    XhtmlNode headerRow = null;
    for (XhtmlNode child : x.getChildNodes()) {
      if (child.getName() != null) {
        switch (child.getName()) {
          case "tbody":
            headerRow = processChildNodesForTable(rows, child, false);
            break;
          case "thead":
          case "tfoot":
            processChildNodesForTable(rows, child, false);
            break;
          case "tr":
            if (headerRow == null && (header || hasTHs(child)) || hasBoldedTDs(child)) {
              headerRow = child;
            } else {
              rows.add(child);
            }
            break;
          default:
            // ignore
        }
      }
    }
    return headerRow;
  }

  private boolean hasTHs(XhtmlNode x) {
    for (XhtmlNode child : x.getChildNodes()) {
      if ("th".equals(child.getName())) {
        return true;
      }
    }
    return false;
  }

  private boolean hasBoldedTDs(XhtmlNode x) {
    for (XhtmlNode child : x.getChildNodes()) {
      if ("td".equals(child.getName())) {
        return child.firstNamedDescendent("b") != null;
      }
    }
    return false;
  }

  private void convertUL(StringBuilder b, XhtmlNode x) {

    for (XhtmlNode c : x.getChildNodes()) {
      if ("li".equals(c.getName())) {
        b.append("* ");
        int count = c.countChildrenByName("p");
        if (count == 0) {
          paragraph(b, c, true, false, true);
        } else if (count == 1) {
          paragraph(b, c.firstNamedDescendent("p"), true, false, true);
        } else { // count > 1
          boolean first = true;
          for (XhtmlNode g : c.getChildNodes()) {
            if ("p".equals(g.getName())) {
              if (first) {
                first = false;
              } else {
                b.append("\r\n\r\n  ");
              }
              paragraph(b, g, true, false, true);
            }
          }
        }
      }
    }
  }

  private void convertLI(StringBuilder b, XhtmlNode x) {
    b.append("* ");
    paragraph(b, x, true, false, true);
  }

  private void convertOL(StringBuilder b, XhtmlNode x) {

    for (XhtmlNode c : x.getChildNodes()) {
      if ("li".equals(c.getName())) {
        b.append("1. ");
        paragraph(b, c, true, true, true);
      }
    }
  }

  private void paragraph(StringBuilder b, XhtmlNode x, boolean mark, boolean trim, boolean allowParagraphs) {
    if (atStartOfPara2(b) && Utilities.noString(x.allText().trim())) {
      return;
    }
    if (x.getNodeType() == NodeType.Text) {
      addText(b, trim, x.getContent());
    } else if (x.getName() != null && !Utilities.existsInList(x.getName(), "p", "li", "td", "th", "blockquote")) {
      part(b, x, trim, allowParagraphs, true);
    } else {
      for (XhtmlNode c : x.getChildNodes()) {
        if (c.getNodeType() == NodeType.Text) {
          addText(b, trim, c.getContent());
        } else if (c.getName() != null) {
          part(b, c, trim, allowParagraphs, true);
        }
      }
      if (mark && allowParagraphs) {
        b.append("\r\n");
      }
    }
  }

  private boolean atStartOfPara2(StringBuilder b) {
    switch (b.length()) {
      case 0:
        return true;
      case 2:
        return "\r\n".equals(b.substring(b.length() - 2));
      default:
        if (b.length() >= 4) {
          return "\r\n\r\n".equals(b.substring(b.length() - 4));
        } else {
          return false;
        }
    }
  }

  private void addText(StringBuilder b, boolean trim, String content) {
    if (trim) {
      content = content.trim();
    }
    if (!Utilities.noString(content)) {
      b.append(toMDText(content));
    }
  }

  private String toMDText(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }

    StringBuilder result = new StringBuilder(input.length());
    boolean inWhitespace = false;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (Character.isWhitespace(c)) {
        if (!inWhitespace) {
          result.append(' ');
          inWhitespace = true;
        }
        // Skip subsequent whitespace characters
      } else {
        result.append(c);
        inWhitespace = false;
      }
    }

    return result.toString();
  }

  public void part(StringBuilder b, XhtmlNode c, boolean trim, boolean allowParagraphs, boolean inPara) throws Error {
    if (!elementPasses(c)) {
      return;
    }

    switch (c.getName()) {
      case "a":
        if (c.hasAttribute("href") && hasSomeChildren(c)) {
          b.append("[");
          process(b, c, trim, allowParagraphs, inPara);
          b.append("](");
          b.append(fixRef(c.getAttribute("href")));
          b.append(")");
        } else {
          process(b, c, trim, allowParagraphs, inPara);
        }
        break;
      case "img":
        if (imageRefPasses(c.getAttribute("src"))) {
          b.append("![");
          b.append(c.allText());
          b.append("](");
          b.append(c.getAttribute("src"));
          b.append(")");
        }
        break;
      case "samp":
        b.append("`");
        process(b, c, trim, false, inPara);
        b.append("`");
        break;
      case "code":
        String ticks = inPara ? "`" : "```";
        b.append(ticks);
        process(b, c, trim, allowParagraphs, inPara);
        b.append(ticks);
        break;
      case "pre":
        b.append("```");
        process(b, c, trim, allowParagraphs, inPara);
        b.append("```");
        break;
      case "strong":
      case "em":
      case "b":
      case "mark":
        b.append("**");
        process(b, c, trim, allowParagraphs, inPara);
        b.append("**");
        break;
      case "u":
        b.append("_");
        process(b, c, trim, allowParagraphs, inPara);
        b.append("_");
        break;
      case "i":
        b.append("*");
        process(b, c, trim, allowParagraphs, inPara);
        b.append("*");
        break;
      case "span":
      case "sup":
      case "sub":
      case "s":
        process(b, c, trim, allowParagraphs, inPara);
        break;
      case "div":
      case "title":
      case "h1":
      case "h2":
      case "h3":
      case "h4":
      case "h5":
      case "h6":
      case "table":
      case "cite":
        if (allowParagraphs) para(b);
        convertNode(b, c, allowParagraphs);
        if (allowParagraphs) para(b);
        break;
      case "p":
        if (!trim && allowParagraphs) {
          para(b);
        }
        process(b, c, trim, allowParagraphs, inPara);
        break;
      case "ul":
        if (allowParagraphs) para(b);
        convertUL(b, c);
        break;
      case "li":
        if (allowParagraphs) para(b);
        convertLI(b, c);
        break;
      case "ol":
        if (allowParagraphs) para(b);
        convertOL(b, c);
        break;
      case "blockquote":
        if (allowParagraphs) para(b);
        b.append("> ");
        paragraph(b, c, false, trim, allowParagraphs);
        if (allowParagraphs) b.append("\r\n");
        break;
      case "hr":
        if (allowParagraphs) para(b);
        b.append("-------");
        if (allowParagraphs) para(b);
        break;
      case "del":
      case "dl":
      case "dd":
      case "dt":
      case "tt":
      case "font":
        process(b, c, trim, allowParagraphs, inPara);
        break;
      case "tr": // badly formed tables are ignored
      case "td":
      case "th":
        process(b, c, trim, allowParagraphs, inPara);
        break;
      case "br":
        if (allowParagraphs) para(b);
        process(b, c, trim, allowParagraphs, inPara);
        break;
      case "wbr":
        para(b);
        break;
      case "button":
      case "input":
      case "select":
        if (allowForms) {
          throw new Error("not done yet: " + c.getName());
        } else {
          convert(b, c, allowParagraphs);
          break;
        }
      case "svg":
        // not clear what, if anything, we should do with svg
        break;
      case "object": case "embed":
        // not clear what, if anything, we should do with object if it's an svg, else we ignore it
        break;
      case "script":
        // nothing
        break;
      case "base":
        // nothing
        break;
      default:
        if (processUnknown) {
          // for weird stuff found on hl7.org/fhir
          if ("A".equals(c.getName())) {
            if (c.hasAttribute("href") && hasSomeChildren(c)) {
              b.append("[");
              process(b, c, trim, allowParagraphs, inPara);
              b.append("](");
              b.append(fixRef(c.getAttribute("href")));
              b.append(")");
            } else {
              process(b, c, trim, allowParagraphs, inPara);
            }
          } else {
            process(b, c, trim, allowParagraphs, inPara);
          }
        } else {
          throw new FHIRException("illegal html element: " + c.getName() + " (" + c.allText() + ")");
        }
    }
  }

  private String fixRef(String href) {
    if (aiMode && !Utilities.isAbsoluteUrl(href)) {
      return href.replace(".html", ".md");
    } else {
      return href;
    }
  }

  private boolean hasSomeChildren(XhtmlNode c) {
    for (XhtmlNode child : c.getChildNodes()) {
      if ("img".equals(child.getName())) {
        if (imageRefPasses(child.getAttribute("src"))) {
          return false;
        }
      }
      if (elementPasses(child)) {
        if (hasSomeChildren(child)) {
          return true;
        }
      }
      if (child.getContent() != null && !Utilities.noString(child.getContent().trim())) {
        return true;
      }
    }
    return false;
  }

  private boolean imageRefPasses(String src) {
    for (String f : imageFilters) {
      if (src.matches(f)) {
        return false;
      }
    }
    return true;
  }

  private void process(StringBuilder b, XhtmlNode x, boolean trim, boolean allowParagraphs, boolean inPara) {
    for (XhtmlNode c : x.getChildNodes()) {
      if (c.getNodeType() == NodeType.Text) {
        addText(b, true, c.getContent());
      } else if (c.getName() != null) {
        part(b, c, trim, allowParagraphs, inPara);
      }
    }
  }

  public void configureForIGs(boolean processUnknown) {
    getImageFilters().add("^tbl_.*");
    getImageFilters().add("^icon_.*");
    getImageFilters().add("^assets\\/*");
    getImageFilters().add("^https://hl7\\.org/.*");
    getImageFilters().add("^tree-filter");
    getIdFilters().add("^segment-header");
    getIdFilters().add("^segment-navbar");
    getIdFilters().add("^publish-box");
    getIdFilters().add("^segment-footer");
    getIdFilters().add("^ppprofile");
    getClassFilters().add("nav-tabs");
    getClassFilters().add("markdown-toc");
    setIgnoreGeneratedTables(true);
    setAiMode(true);
    this.processUnknown = processUnknown;
  }
}
