package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.Composition.SectionComponent;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Provenance;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class BundleRenderer extends ResourceRenderer {


  public BundleRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return "Bundle";
  }

  public BundleRenderer setMultiLangMode(boolean multiLangMode) {
    this.multiLangMode = multiLangMode;
    return this;
  }
  
  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    List<ResourceElement> entries = b.children("entry");
    if ("document".equals(b.primitiveValue("type"))) {
      if (entries.isEmpty() || (entries.get(0).has("resource") && !"Composition".equals(entries.get(0).child("resource").fhirType())))
        throw new FHIRException(context.formatPhrase(RenderingContext.BUND_REND_INVALID_DOC, b.getId(), entries.get(0).child("resource").fhirType()+"')"));
      renderDocument(status, x, b, entries);
    } else if ("collection".equals(b.primitiveValue("type")) && allEntriesAreHistoryProvenance(entries)) {
      // nothing
    } else {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_ROOT, b.getId(), b.primitiveValue("type")));
      int i = 0;
      for (ResourceElement be : entries) {
        i++;
        if (be.has("fullUrl")) {
          root.an(makeInternalBundleLink(be.primitiveValue("fullUrl")));
        }
        if (be.has("resource")) {
          if (be.child("resource").has("id")) {
            root.an(be.child("resource").fhirType() + "_" + be.child("resource").primitiveValue("id"));
            root.an("hc"+be.child("resource").fhirType() + "_" + be.child("resource").primitiveValue("id"));
          } else {
            String id = makeIdFromBundleEntry(be.primitiveValue("fullUrl"));
            root.an(be.child("resource").fhirType() + "_" + id);
            root.an("hc"+be.child("resource").fhirType() + "_" + id);
          }
        }
        root.hr();
        if (be.has("fullUrl")) {
          root.para().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_ENTRY_URL, Integer.toString(i), be.primitiveValue("fullUrl")));
        } else {
          root.para().addText(formatPhrase(RenderingContext.BUNDLE_HEADER_ENTRY, Integer.toString(i)));
        }
//        if (be.hasRequest())
//          renderRequest(root, be.getRequest());
//        if (be.hasSearch())
//          renderSearch(root, be.getSearch());
//        if (be.hasResponse())
//          renderResponse(root, be.getResponse());
        if (be.has("resource")) {
          ResourceElement r = be.child("resource");
          root.para().addText(formatPhrase(RenderingContext.BUNDLE_RESOURCE, r.fhirType()));
          XhtmlNode xn = r.getNarrative();
          if (xn == null || xn.isEmpty()) {
            ResourceRenderer rr = RendererFactory.factory(r, context);
            try {
              xn = new XhtmlNode(NodeType.Element, "div"); 
              rr.renderResource(new RenderingStatus(), xn, r);
            } catch (Exception e) {
              xn = new XhtmlNode();
              xn.para().b().tx(context.formatPhrase(RenderingContext.BUNDLE_REV_EXCP, e.getMessage()) + " ");
            }
          }
          root.blockquote().para().addChildren(xn);
        }
        if (be.has("search")) {
          renderSearch(x, be.child("search"));
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
 


  private void renderDocument(RenderingStatus status, XhtmlNode x, ResourceElement b, List<ResourceElement> entries) throws UnsupportedEncodingException, FHIRException, IOException, EOperationOutcome {
    // from the spec:
    //
    // When the document is presented for human consumption, applications SHOULD present the collated narrative portions in order:
    // * The subject resource Narrative
    // * The Composition resource Narrative
    // * The section.text Narratives
    ResourceElement comp = (ResourceElement) entries.get(0).child("resource");
    ResourceElement subject = resolveReference(entries, comp.child("subject"));
    if (subject != null) {
      if (subject.hasNarrative()) {
        x.addChildren(subject.getNarrative());        
      } else {
        RendererFactory.factory(subject, context).renderResource(status, x, subject);
      }
    }
    x.hr();
    if (comp.hasNarrative()) {
      x.addChildren(comp.getNarrative());
      x.hr();
    }
    List<ResourceElement> sections = comp.children("section");
    for (ResourceElement section : sections) {
      addSection(status, x, section, 2, false);
    }
  }

  private void addSection(RenderingStatus status, XhtmlNode x, ResourceElement section, int level, boolean nested) throws UnsupportedEncodingException, FHIRException, IOException {
    if (section.has("title") || section.has("code") || section.has("text") || section.has("section")) {
      XhtmlNode div = x.div();
      if (section.has("title")) {
        div.h(level).tx(section.primitiveValue("title"));        
      } else if (section.has("code")) {
        renderDataType(status, div.h(level), section.child("code"));                
      }
      if (section.has("text")) {
        ResourceElement narrative = section.child("text");
        x.addChildren(narrative.getXhtml());
      }      
      if (section.has("section")) {
        List<ResourceElement> sections = section.children("section");
        for (ResourceElement child : sections) {
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

  private ResourceElement resolveReference(List<ResourceElement> entries, ResourceElement base) throws UnsupportedEncodingException, FHIRException, IOException {
    if (base == null) {
      return null;
    }
    ResourceElement prop = base.child("reference");
    if (prop != null && prop.hasPrimitiveValue()) {
      for (ResourceElement entry : entries) {
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
  
  public static boolean allEntriesAreHistoryProvenance(List<ResourceElement> entries) throws UnsupportedEncodingException, FHIRException, IOException {
    for (ResourceElement be : entries) {
      if (!"Provenance".equals(be.child("resource").fhirType())) {
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

  private List<XhtmlNode> checkInternalLinks(Bundle b, List<XhtmlNode> childNodes) {
    scanNodesForInternalLinks(b, childNodes);
    return childNodes;
  }

  private void scanNodesForInternalLinks(Bundle b, List<XhtmlNode> nodes) {
    for (XhtmlNode n : nodes) {
      if ("a".equals(n.getName()) && n.hasAttribute("href")) {
        scanInternalLink(b, n);
      }
      scanNodesForInternalLinks(b, n.getChildNodes());
    }
  }

  private void scanInternalLink(Bundle b, XhtmlNode n) {
    boolean fix = false;
    for (BundleEntryComponent be : b.getEntry()) {
      if (be.hasFullUrl() && be.getFullUrl().equals(n.getAttribute("href"))) {
        fix = true;
      }
    }
    if (fix) {
      n.setAttribute("href", "#"+makeInternalBundleLink(n.getAttribute("href")));
    }
  }

  private void renderSearch(XhtmlNode root, ResourceElement search) {
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

  private void renderResponse(XhtmlNode root, ResourceElement response) {
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

  private void renderRequest(XhtmlNode root, ResourceElement request) {
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
