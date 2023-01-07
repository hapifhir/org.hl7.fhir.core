package org.hl7.fhir.utilities.xhtml;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;

public abstract class XhtmlFluent {

  protected abstract XhtmlNode addTag(String string);
  protected abstract XhtmlNode addText(String cnt);
  protected abstract void addChildren(XhtmlNodeList childNodes);
  
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

  public XhtmlNode tx(int cnt) {
    return addText(Integer.toString(cnt));
  }

  public XhtmlNode ah(String href) {
    return addTag("a").attribute("href", href);
  }

  public XhtmlNode ah(String href, String title) {
    XhtmlNode x = addTag("a").attribute("href", href);
    if (title != null) {
      x.attribute("title", title);
    }
    return x;
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


  
}
