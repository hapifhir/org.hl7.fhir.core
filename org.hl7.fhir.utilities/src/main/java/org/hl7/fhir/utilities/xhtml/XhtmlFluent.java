package org.hl7.fhir.utilities.xhtml;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.Utilities;

public abstract class XhtmlFluent {

  protected abstract XhtmlNode addTag(String string);
  protected abstract XhtmlNode addTag(int index, String string);
  protected abstract XhtmlNode addText(String cnt);
  protected abstract void addChildren(XhtmlNodeList childNodes);
  protected abstract void addChild(XhtmlNode childNode);
  protected abstract int indexOfNode(XhtmlNode node);
  
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
  
  /* Add header with an ID */
  public XhtmlNode h(int level, String id) {
    if (level < 1 || level > 6) {
      throw new FHIRException("Illegal Header level "+level);
    }
    XhtmlNode res =  addTag("h"+Integer.toString(level));
    if (!Utilities.noString(id)) {
      res.attribute("id", id);
    }
    return res;
  }

  public XhtmlNode h3() {
    return addTag("h3");
  }
  
  public XhtmlNode h4() {
    return addTag("h4");
  }

  public XhtmlNode table(String clss) {
    return table(clss, false);
  }
  
  public XhtmlNode table(String clss, boolean forPresentation) {
    XhtmlNode res = addTag("table");
    if (!Utilities.noString(clss))
      res.clss(clss);
    if (forPresentation) {
      res.clss("presentation");
    }
    return res;
  }
  
  public XhtmlNode tr() {
    return addTag("tr");
  }
  
  public XhtmlNode tr(XhtmlNode tr) {
    return addTag(indexOfNode(tr)+1, "tr");
  }
  
  public XhtmlNode th(int index) {
    return addTag(index, "th");
  }
  
  public XhtmlNode th() {
    return addTag("th");
  }
  
  public XhtmlNode td() {
    XhtmlNode x = addTag("td");
    return x;
  }
  
  public XhtmlNode td(String clss) {
    return addTag("td").attribute("class", clss);
  }
  
  public XhtmlNode div() {
    return addTag("div");
  }

  public XhtmlNode div(String style) {
    XhtmlNode x = addTag("div");
    if (!Utilities.noString(style))
      x.attribute("style", style);
    return x;
  }

  public XhtmlNode para() {
    return addTag("p");
  }

  public XhtmlNode pre() {
    return addTag("pre");
  }

  public XhtmlNode pre(String clss) {
    XhtmlNode res = addTag("pre");
    if (clss != null) {
      res.setAttribute("class", clss);
    }
    return res;
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

  public XhtmlNode ol() {
    return addTag("ol");
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

  /**
   * used in i18n when we don't know if there'll be text, but if there is, it needs to be separated
   * 
   * @param cnt
   */
  public void stx(String cnt) {
    if (!Utilities.noString(cnt)) {
      addText(" "+cnt);
    }
  }

  public XhtmlNode tx(int cnt) {
    return addText(Integer.toString(cnt));
  }

  public XhtmlNode ah(String href) {
    if (href == null) {
      if (this instanceof XhtmlNode) {
        return (XhtmlNode) this;
      } else {
        return addTag("span");
      }
    } else {
      return addTag("a").attribute("href", href);
    }
  }

  public XhtmlNode ah(String href, String title) {
    XhtmlNode x = addTag("a").attribute("href", href);
    if (title != null) {
      x.attribute("title", title);
    }
    return x;
  }

  public XhtmlNode ahWithText(String preText, String href, String title, String text, String postText) {
    tx(preText);
    XhtmlNode x = addTag("a").attribute("href", href);
    if (title != null) {
      x.attribute("title", title);
    }
    x.tx(text);
    tx(postText);
    return x;
  }

  /**
   * make it a code if it's not a link
   * @param href
   * @param title
   * @return
   */
  public XhtmlNode ahOrCode(String href, String title) {
    if (href != null) {
      return ah(href, title);
    } else if (title != null) {
      return code().setAttribute("title", title);
    } else {
      return code();
    }
  }
  
  public XhtmlNode ahOrCode(String href) {
    return ahOrCode(href, null);
  }

  public XhtmlNode img(String src, String alt) {
    if (alt == null) {
      return addTag("img").attribute("src", src).attribute("alt", ".");
    } else {
      return addTag("img").attribute("src", src).attribute("alt", alt);
    }
  }

  public XhtmlNode imgT(String src, String alt) {
    if (alt == null) {
      return addTag("img").attribute("src", src).attribute("alt", ".");
    } else {
      return addTag("img").attribute("src", src).attribute("alt", alt).attribute("title", alt);
    }
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

  public XhtmlNode span(String style) {
    XhtmlNode res = addTag("span");
    if (!Utilities.noString(style))
      res.attribute("style", style);
    return res;
  }

  public XhtmlNode span() {
    return addTag("span");
  }

  public XhtmlNode spanClss(String clssName) {
    XhtmlNode res = addTag("span");
    if (!Utilities.noString(clssName))
      res.attribute("class", clssName);
    return res;
  }

  public void codeWithText(String preText, String text, String postText) {
    tx(preText);
    XhtmlNode code = addTag("code");
    code.tx(text);
    tx(postText);
  }

  
  public XhtmlNode code(String text) {
    XhtmlNode code = addTag("code");
    code.tx(text);
    return code;
  }

  public XhtmlNode code() {
    return addTag("code");
  }


  public XhtmlNode blockquote() {
    return addTag("blockquote");
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
      addChildren(m.getChildNodes());
   }        
  }

  public void markdownSimple(String md, String source) throws IOException {
    if (md != null) {
      String s = new MarkDownProcessor(Dialect.COMMON_MARK).process(md, source);
      XhtmlParser p = new XhtmlParser();
      XhtmlNode m;
      try {
        m = p.parse("<div>"+s+"</div>", "div");
      } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
        throw new FHIRFormatError(e.getMessage(), e);
      }
      boolean first = true;
      for (XhtmlNode c : m.getChildNodes()) {
        if ("div".equals(c.getName())) {
          for (XhtmlNode c1 : c.getChildNodes()) {
            if ("p".equals(c1.getName())) {
              if (first) first = false;
              else br();
              addChildren(c1.getChildNodes());
            } else {
              addChild(c1);
            }
          }
        } else  if ("p".equals(c.getName())) {
          if (first) first = false; else br();
          addChildren(c.getChildNodes());
        } else {
          addChild(c);
        }
      }
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
       addChildren(m.getChildNodes());
    }        
   }

  // differs from tx because it returns the owner node, not the created text
  public XhtmlFluent txN(String cnt) {
    addText(cnt);
    return this;
  }


  public XhtmlFluent iff(boolean test) {
    if (test) {
      return this;
    } else {
      return new XhtmlNode(NodeType.Element, "span"); // which will never be connected
    }
  }
}
