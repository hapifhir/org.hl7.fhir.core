package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Provenance;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class BundleRenderer extends ResourceRenderer {


  public BundleRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return context.formatPhrase(RenderingContext.BUNDLE_SUMMARY, getTranslatedCode(r.child("type")), r.children("entry").size());
  }

  public BundleRenderer setMultiLangMode(boolean multiLangMode) {
    this.multiLangMode = multiLangMode;
    return this;
  }
  
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {

    List<ResourceWrapper> entries = b.children("entry");
    if ("collection".equals(b.primitiveValue("type")) && allEntriesAreHistoryProvenance(entries)) {
      // nothing
    } else {
      int start = 0;
      
      XhtmlNode root = x;
      List<ResourceWrapper> filter = new ArrayList<>();
      if ("document".equals(b.primitiveValue("type"))) {
        if (entries.isEmpty() || (entries.get(0).has("resource") && !"Composition".equals(entries.get(0).child("resource").fhirType())))
          throw new FHIRException(context.formatPhrase(RenderingContext.BUND_REND_INVALID_DOC, b.getId(), entries.get(0).child("resource").fhirType()+"')"));
        renderDocument(status, root, b, entries, filter);
        if (!context.isTechnicalMode()) {
          return;
        }
        root.hr();
        root.h2().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_DOCUMENT_CONTENTS));
      } else {
        renderResourceTechDetails(b, x);
        root.para().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_ROOT, b.getId(), b.primitiveValue("type")));
      }
      int i = 0;
      for (ResourceWrapper be : entries) {
        i++;
        if (!filter.contains(be)) {
          String link = null;
          if (be.has("fullUrl")) {
            link = makeInternalBundleLink(b, be.primitiveValue("fullUrl"));
            if (!context.hasAnchor(link)) {
              context.addAnchor(link);
              root.an(context.prefixAnchor(link));
            }
          }
          ResourceWrapper res = be.child("resource");
          if (be.has("resource")) {
            String id = res.has("id") ? res.primitiveValue("id") : makeIdFromBundleEntry(be.primitiveValue("fullUrl"));
            String anchor = res.fhirType() + "_" + id;
            if (id != null && !context.hasAnchor(anchor)) {
              context.addAnchor(anchor);
              root.an(context.prefixAnchor(anchor));
            }
            anchor = "hc"+anchor;
            if (id != null && !context.hasAnchor(anchor)) {
              context.addAnchor(anchor);
              root.an(context.prefixAnchor(anchor));
            }
            String ver = res.has("meta") ? res.child("meta").primitiveValue("version") : null;
            if (ver != null) {
              if (link != null) {
                link = link + "/"+ver;
                if (!context.hasAnchor(link)) {
                  context.addAnchor(link);
                  root.an(context.prefixAnchor(link));
                }
              }
              if (id != null) {
                anchor = anchor + "/"+ver;
                if (!context.hasAnchor(anchor)) {
                  context.addAnchor(anchor);
                  root.an(context.prefixAnchor(anchor));
                }
              }
            }
          }
          root.hr();
          if (be.has("fullUrl")) {
            root.para().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_ENTRY_URL, Integer.toString(i), be.primitiveValue("fullUrl")));
          } else {
            root.para().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_ENTRY, Integer.toString(i)));
          }
          if (be.has("search")) {
            renderSearch(x, be.child("search"));
          }
          //        if (be.hasRequest())
          //          renderRequest(root, be.getRequest());
          //        if (be.hasSearch())
          //          renderSearch(root, be.getSearch());
          //        if (be.hasResponse())
          //          renderResponse(root, be.getResponse());
          if (be.has("resource")) {
            ResourceWrapper r = res;
            root.para().addText(formatPhrase(RenderingContext.BUNDLE_RESOURCE, r.fhirType()));
            XhtmlNode xn = r.getNarrative();
            if (xn == null || xn.isEmpty()) {
              xn = new XhtmlNode(NodeType.Element, "div");
              ResourceRenderer rr = RendererFactory.factory(r, context);
              try {
                rr.buildNarrative(new RenderingStatus(), xn, r);
              } catch (Exception e) {
                xn.para().b().tx(context.formatPhrase(RenderingContext.BUNDLE_REV_EXCP, e.getMessage()) + " ");
              }
            } else {
              xn.stripAnchorsByName(context.getAnchors());
            }
            root.blockquote().addChildren(xn);
          }
          if (be.has("request")) {
            renderRequest(x, be.child("request"));
          }
          if (be.has("response")) {
            renderResponse(x, be.child("response"));
          }
        }
      }
    }
  }

  private void renderDocument(RenderingStatus status, XhtmlNode x, ResourceWrapper b, List<ResourceWrapper> entries, List<ResourceWrapper> filter) throws UnsupportedEncodingException, FHIRException, IOException, EOperationOutcome {
    
    // from the spec:
    //
    // When the document is presented for human consumption, applications SHOULD present the collated narrative portions in order:
    // * The subject resource Narrative
    // * The Composition resource Narrative
    // * The section.text Narratives

    ResourceWrapper comp = (ResourceWrapper) entries.get(0).child("resource");
    filter.add(entries.get(0));
    
    XhtmlNode sum = renderResourceTechDetails(b, docSection(x, formatPhrase(RenderingI18nContext.BUNDLE_DOCUMENT_DETAILS)), comp.primitiveValueMN("title", "name"));
    List<ResourceWrapper> subjectList = comp.children("subject");
    if (sum != null) {
      XhtmlNode p = sum.para();
      p.startScript("doc");
      renderDataType(status, p.param("status"), comp.child("status"));
      renderDataType(status, p.param("date"), comp.child("date"));
      renderDataTypes(status, p.param("author"), comp.children("author"));
      renderDataTypes(status, p.param("subject"), subjectList);
      if (comp.has("encounter")) {
        renderDataType(status, p.param("encounter"), comp.child("encounter"));
        p.paramValue("has-encounter", "true");
      } else {
        p.paramValue("has-encounter", "false");
      }
      p.execScript(context.formatMessage(RenderingContext.DOCUMENT_SUMMARY));
      p.closeScript();

      // status, type, category, subject, encounter, date, author, 
      x.hr();
    }

    List<ResourceWrapper> subjects = resolveReferences(entries, subjectList, filter);
    int i = 0;
    for (ResourceWrapper subject : subjects) {
      XhtmlNode sec = docSection(x, "Document Subject");
      if (subject != null) {
        if (subject.hasNarrative()) {
          sec.addChildren(subject.getNarrative());        
        } else {
          RendererFactory.factory(subject, context).buildNarrative(status, sec, subject);
        }
      } else {
        sec.para().b().tx("Unable to resolve subject '"+displayReference(subjects.get(i))+"'");
      }
      i++;
    }
    x.hr();
    XhtmlNode sec = docSection(x, formatPhrase(RenderingI18nContext.BUNDLE_DOCUMENT_CONTENT));
    if (comp.hasNarrative()) {
      sec.addChildren(comp.getNarrative());
      sec.hr();
    }
    List<ResourceWrapper> sections = comp.children("section");
    for (ResourceWrapper section : sections) {
      addSection(status, sec, section, 2, false);
    }
  }

  private void renderDataTypes(RenderingStatus status, XhtmlNode param, List<ResourceWrapper> children) throws FHIRFormatError, DefinitionException, IOException {
    if (children != null && !children.isEmpty()) {
      boolean first = true;
      for (ResourceWrapper child : children) {
        if (first) {first = false; } else {param.tx(", "); }
        renderDataType(status, param, child);
      }
    } 
  }

  private XhtmlNode docSection(XhtmlNode x, String name) {
    XhtmlNode div = x.div();
    div.style("border: 1px solid maroon; padding: 10px; background-color: #f2faf9; min-height: 160px;");
    div.para().b().tx(name);
    return div;
  }

  private void addSection(RenderingStatus status, XhtmlNode x, ResourceWrapper section, int level, boolean nested) throws UnsupportedEncodingException, FHIRException, IOException {
    if (section.has("title") || section.has("code") || section.has("text") || section.has("section")) {
      XhtmlNode div = x.div();
      if (section.has("title")) {
        div.h(level).tx(section.primitiveValue("title"));        
      } else if (section.has("code")) {
        renderDataType(status, div.h(level), section.child("code"));                
      }
      if (section.has("text")) {
        ResourceWrapper narrative = section.child("text");
        ResourceWrapper xh = narrative.child("div");
        x.addChildren(xh.getXhtml());
      }      
      if (section.has("section")) {
        List<ResourceWrapper> sections = section.children("section");
        for (ResourceWrapper child : sections) {
          if (nested) {
            addSection(status, x.blockquote().para(), child, level+1, true);
          } else {
            addSection(status, x, child, level+1, true);
          }
        }
      }      
    }
    // children
  }

  private List<ResourceWrapper> resolveReferences(List<ResourceWrapper> entries, List<ResourceWrapper> baselist, List<ResourceWrapper> filter) throws UnsupportedEncodingException, FHIRException, IOException {
    List<ResourceWrapper> list = new ArrayList<>();
    if (baselist != null) {
      for (ResourceWrapper base : baselist) {
        ResourceWrapper res = null;
        ResourceWrapper prop = base.child("reference");
        if (prop != null && prop.hasPrimitiveValue()) {
          String ref = prop.primitiveValue();
          for (ResourceWrapper entry : entries) {
            if (entry.has("fullUrl")) {
              String fu = entry.primitiveValue("fullUrl");
              if (ref.equals(fu)) {
//                filter.add(entry);
                res = entry.child("resource");
              }
            }
            if (entry.has("resource")) {
              String type = entry.child("resource").fhirType();
              String id = entry.child("resource").primitiveValue("id");
              if (ref.equals(type+"/"+id)) {
//                filter.add(entry);
                res = entry.child("resource");
              }
            }
          }
          list.add(res);
        }
      }
    }
    return list;
  }
  
  private ResourceWrapper resolveReference(List<ResourceWrapper> entries, ResourceWrapper base) throws UnsupportedEncodingException, FHIRException, IOException {
    if (base == null) {
      return null;
    }
    ResourceWrapper prop = base.child("reference");
    if (prop != null && prop.hasPrimitiveValue()) {
      for (ResourceWrapper entry : entries) {
        if (entry.has("fullUrl")) {
          String fu = entry.primitiveValue("fullUrl");
          if (prop.primitiveValue().equals(fu)) {
            return entry.child("resource");
          }
        }
      }
    }
    return null;
  }
  
  public static boolean allEntriesAreHistoryProvenance(List<ResourceWrapper> entries) throws UnsupportedEncodingException, FHIRException, IOException {
    for (ResourceWrapper be : entries) {
      if (!be.has("child") || !"Provenance".equals(be.child("resource").fhirType())) {
        return false;
      }
    }
    return !entries.isEmpty();
  }
  
 
  private boolean allEntresAreHistoryProvenance(Bundle b) {
    for (BundleEntryComponent be : b.getEntry()) {
      if (!(be.getResource() instanceof Provenance)) {
        return false;
      }
    }
    return !b.getEntry().isEmpty();
  }

//  private List<XhtmlNode> checkInternalLinks(Bundle b, List<XhtmlNode> childNodes) {
//    scanNodesForInternalLinks(b, childNodes);
//    return childNodes;
//  }
//
//  private void scanNodesForInternalLinks(Bundle b, List<XhtmlNode> nodes) {
//    for (XhtmlNode n : nodes) {
//      if ("a".equals(n.getName()) && n.hasAttribute("href")) {
//        scanInternalLink(b, n);
//      }
//      scanNodesForInternalLinks(b, n.getChildNodes());
//    }
//  }
//
//  private void scanInternalLink(Bundle b, XhtmlNode n) {
//    boolean fix = false;
//    for (BundleEntryComponent be : b.getEntry()) {
//      if (be.hasFullUrl() && be.getFullUrl().equals(n.getAttribute("href"))) {
//        fix = true;
//      }
//    }
//    if (fix) {
//      n.setAttribute("href", "#"+makeInternalBundleLink(b, n.getAttribute("href")));
//    }
//  }

  private void renderSearch(XhtmlNode root, ResourceWrapper search) {
    StringBuilder b = new StringBuilder();
    b.append(formatPhrase(RenderingContext.BUNDLE_SEARCH));
    if (search.has("mode"))
      b.append(formatPhrase(RenderingContext.BUNDLE_SEARCH_MODE, search.primitiveValue("mode")));
    if (search.has("score")) {
      if (search.has("mode")) {
        b.append(",");
      }
      b.append(formatPhrase(RenderingContext.BUNDLE_SEARCH_SCORE, search.primitiveValue("score")));
    }
    root.para().addText(b.toString());    
  }

  private void renderResponse(XhtmlNode root, ResourceWrapper response) {
    root.para().addText(formatPhrase(RenderingContext.BUNDLE_RESPONSE));
    StringBuilder b = new StringBuilder();
    b.append(response.primitiveValue("status")+"\r\n");
    if (response.has("location"))
      b.append(formatPhrase(RenderingContext.BUNDLE_LOCATION, response.primitiveValue("location"))+"\r\n");
    if (response.has("etag"))
      b.append(formatPhrase(RenderingContext.BUNDLE_ETAG, response.primitiveValue("etag"))+"\r\n");
    if (response.has("lastModified"))
      b.append(formatPhrase(RenderingContext.BUNDLE_LAST_MOD, response.primitiveValue("lastModified"))+"\r\n");
    root.pre().addText(b.toString());    
  }

  private void renderRequest(XhtmlNode root, ResourceWrapper request) {
    root.para().addText(formatPhrase(RenderingContext.BUNDLE_REQUEST));
    StringBuilder b = new StringBuilder();
    b.append(request.primitiveValue("method")+" "+request.primitiveValue("url")+"\r\n");
    if (request.has("ifNoneMatch"))
      b.append(formatPhrase(RenderingContext.BUNDLE_IF_NON_MATCH, request.primitiveValue("ifNoneMatch"))+"\r\n");
    if (request.has("ifModifiedSince"))
      b.append(formatPhrase(RenderingContext.BUNDLE_IF_MOD, request.primitiveValue("ifModifiedSince"))+"\r\n");
    if (request.has("ifMatch"))
      b.append(formatPhrase(RenderingContext.BUNDLE_IF_MATCH, request.primitiveValue("ifMatch"))+"\r\n");
    if (request.has("ifNoneExist"))
      b.append(formatPhrase(RenderingContext.BUNDLE_IF_NONE, request.primitiveValue("ifNoneExist"))+"\r\n");
    root.pre().addText(b.toString());    
  }

  public boolean canRender(Bundle b) {
    for (BundleEntryComponent be : b.getEntry()) {
      if (be.hasResource()) {          
        ResourceRenderer rr = RendererFactory.factory(be.getResource(), context);
        if (!rr.canRender(be.getResource())) {
          return false;
        }
      }
    }
    return true;
  }

}
