package org.hl7.fhir.utilities.xhtml;

import org.hl7.fhir.utilities.DebugUtilities;
import org.hl7.fhir.utilities.Utilities;

public class XhtmlToMarkdownConverter {

  public String convert(XhtmlNode x) {
    StringBuilder b = new StringBuilder();
    convert(b, x);
    return b.toString();
  }

  private void convert(StringBuilder b, XhtmlNode x) {
    for (XhtmlNode c : x.getChildNodes()) {
      if (c.getNodeType() == NodeType.Text) {
        paragraph(b, c, true, false);
      } else if (c.getName() != null) {
        convertNode(b, c);
      }
    }

  }

  public void convertNode(StringBuilder b, XhtmlNode c) throws Error {
    switch (c.getName()) {
    case "p":
      paragraph(b, c, true, false);
      break;
    case "hr":
      b.append("-------\r\n");
      break;
    case "a":
      paragraph(b, c, true, false);
      break;
    case "h1":
      b.append("# "+c.allText());
      break;
    case "h2":
      b.append("## "+c.allText());
      break;
    case "h3":
      b.append("### "+c.allText());
      break;
    case "h4":
      b.append("#### "+c.allText());
      break;
    case "h5":
      b.append("##### "+c.allText());
      break;
    case "h6":
      b.append("###### "+c.allText());
      break;
    case "strong":
    case "em":
    case "i":
    case "span":
    case "img":
    case "br":
    case "wbr":
    case "code":
    case "del":
    case "sup":
    case "sub":
    case "u":
    case "b":
      paragraph(b, c, true, false);
      break;
    case "div":
      convert(b, c);
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
      convertForm(b, c);
      break;
    case "label":
    case "cite":
      convertLabel(b, c);
      break;
    case "figure":
    case "figcaption":
      convert(b, c);
      break;
    case "dl":
    case "tt":
      convertDL(b, c);
      break;
    case "blockquote":
      b.append("\r\n");
      b.append("> ");
      paragraph(b, c, false, true);
      b.append("\r\n");
      break;
    case "pre":
      b.append("````\r\n");
      convert(b, c);
      b.append("\r\n````\r\n");
      break;
    default:
      throw new Error("not done yet: "+c.getName());
    }
  }

  private void convertDL(StringBuilder b, XhtmlNode c) {
    DebugUtilities.breakpoint();   
  }

  private void convertIFrame(StringBuilder b, XhtmlNode c) {
   b.append(c.toString());
  }

  private void convertForm(StringBuilder b, XhtmlNode c) {
    b.append(c.toString());
  }

  private void convertLabel(StringBuilder b, XhtmlNode c) {
    convert(b, c);
  }

  private void convertTable(StringBuilder b, XhtmlNode x) {
    boolean first = true;
    for (XhtmlNode c : x.getChildNodes()) {
      if ("tbody".equals(c.getName())) {
        convertTable(b, c);
      } else if ("tr".equals(c.getName())) {
        if (first) {
          first = false;
          b.append("\r\n");
        }
        boolean header = false;
        for (XhtmlNode g : c.getChildNodes()) {
          if (Utilities.existsInList(g.getName(), "td", "th")) {
            if ("th".equals(g.getName())) {
              header = true;
            }
            b.append("|");
            paragraph(b, g, false, true);
          }
        }
        b.append("\r\n");
        if (header) {
          for (XhtmlNode g : c.getChildNodes()) {
            if (Utilities.existsInList(g.getName(), "td", "th")) {
              b.append("|---");
            }
          }
          b.append("\r\n");
        }
      }
    }

  }

  private void convertUL(StringBuilder b, XhtmlNode x) {

    for (XhtmlNode c : x.getChildNodes()) {
      if ("li".equals(c.getName())) {
        b.append("* ");
        paragraph(b, c, true, true);
      }
    }
  }

  private void convertLI(StringBuilder b, XhtmlNode x) {
    b.append("* ");
    paragraph(b, x, true, true);
  }

  private void convertOL(StringBuilder b, XhtmlNode x) {

    for (XhtmlNode c : x.getChildNodes()) {
      if ("li".equals(c.getName())) {
        b.append("1. ");
        paragraph(b, c, true, true);
      }
    }
  }

  private void paragraph(StringBuilder b, XhtmlNode x, boolean mark, boolean trim) {
    if (x.getNodeType() == NodeType.Text) {
      addText(b, trim, x.getContent());
    } else if (x.getName() != null && !Utilities.existsInList(x.getName(), "p", "li", "td", "th", "blockquote")) {
      part(b, x, trim);
    } else {
      for (XhtmlNode c : x.getChildNodes()) {
        if (c.getNodeType() == NodeType.Text) {
          addText(b, trim, c.getContent());
        } else {
          part(b, c, trim);
        }
      }
      if (mark) {
        b.append("\r\n");
      }
    }
  }

  private void addText(StringBuilder b, boolean trim, String content) {
    if (trim) {
      content = content.trim();
    }
    if (!Utilities.noString(content)) {
      b.append(content);
    }
    
  }

  public void part(StringBuilder b, XhtmlNode c, boolean trim) throws Error {
    switch (c.getName()) {
    case "a":
      b.append("[");
      process(b, c, trim);
      b.append("](");
      b.append(c.getAttribute("href"));
      b.append(")");
      break;
    case "img":
      b.append("![");
      b.append(c.allText());
      b.append("](");
      b.append(c.getAttribute("src"));
      b.append(")");
      break;
    case "code":
    case "pre":
      b.append("```");
      process(b, c, trim);
      b.append("```");
    case "strong":
    case "em":
    case "b":
      b.append("**");
      process(b, c, trim);
      b.append("**");
      break;
    case "u":
      b.append("_");
      process(b, c, trim);
      b.append("_");
      break;
    case "i":
      b.append("*");
      process(b, c, trim);
      b.append("*");
      break;
    case "span":
    case "sup":
    case "sub":
    case "s":
      process(b, c, trim);
      break;
    case "div":
    case "h1":
    case "h2":
    case "h3":
    case "h4":
    case "h5":
    case "h6":
    case "table":
    case "cite":
      b.append("\r\n");
      convertNode(b, c);
      break;
    case "p":
      if (!trim) {
        b.append("\r\n\r\n");
      }
      process(b, c, trim);
      break;
    case "ul":
      b.append("\r\n");
      convertUL(b, c);
      break;
    case "li":
      b.append("\r\n");
      convertLI(b, c);
      break;
    case "ol":
      b.append("\r\n");
      convertOL(b, c);
      break;
    case "blockquote":
      b.append("\r\n");
      b.append("> ");
      paragraph(b, c, false, trim);
      b.append("\r\n");
      break;
    case "del":
    case "dl":
    case "dd":
    case "tt":
      process(b, c, trim);
    case "br":
      b.append("\r\n");
      process(b, c, trim);
      break;
    case "wbr":
      b.append("\r\n");
      break;
    default:
      throw new Error("part not done yet: "+c.getName());
    }
  }

  private void process(StringBuilder b, XhtmlNode x, boolean trim) {
    for (XhtmlNode c : x.getChildNodes()) {
      if (c.getNodeType() == NodeType.Text) {
        b.append(c.getContent());
      } else if (c.getName() != null) {
        part(b, c, trim);
      }
    }
  }

}
