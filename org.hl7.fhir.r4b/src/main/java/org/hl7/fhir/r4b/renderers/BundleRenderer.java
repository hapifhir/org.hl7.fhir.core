package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.elementmodel.Element;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.Bundle;
import org.hl7.fhir.r4b.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4b.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r4b.model.Bundle.BundleEntryResponseComponent;
import org.hl7.fhir.r4b.model.Bundle.BundleEntrySearchComponent;
import org.hl7.fhir.r4b.model.Bundle.BundleType;
import org.hl7.fhir.r4b.model.Composition;
import org.hl7.fhir.r4b.model.Composition.SectionComponent;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Property;
import org.hl7.fhir.r4b.model.Provenance;
import org.hl7.fhir.r4b.model.Reference;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class BundleRenderer extends ResourceRenderer {

  
  public BundleRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public BundleRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public boolean render(XhtmlNode x, Resource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    XhtmlNode n = render((Bundle) r);
    x.addChildren(n.getChildNodes());
    return false;
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return null;
  }

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return null;
  }

  @Override
  public boolean render(XhtmlNode x, ResourceWrapper b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    List<BaseWrapper> entries = b.children("entry");
    if ("document".equals(b.get("type").primitiveValue())) {
      if (entries.isEmpty() || (entries.get(0).has("resource") && !"Composition".equals(entries.get(0).get("resource").fhirType())))
        throw new FHIRException("Invalid document '"+b.getId()+"' - first entry is not a Composition ('"+entries.get(0).get("resource").fhirType()+"')");
      return renderDocument(x, b, entries);
    } else if ("collection".equals(b.get("type").primitiveValue()) && allEntriesAreHistoryProvenance(entries)) {
      // nothing
    } else {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ROOT, b.getId(), b.get("type").primitiveValue()));
      int i = 0;
      for (BaseWrapper be : entries) {
        i++;
        if (be.has("fullUrl")) {
          root.an(makeInternalBundleLink(be.get("fullUrl").primitiveValue()));
        }
        if (be.has("resource") && be.getChildByName("resource").getValues().get(0).has("id")) {
          root.an(be.get("resource").fhirType() + "_" + be.getChildByName("resource").getValues().get(0).get("id").primitiveValue());
        }
        root.hr();
        if (be.has("fullUrl")) {
          root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ENTRY_URL, Integer.toString(i), be.get("fullUrl").primitiveValue()));
        } else {
          root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ENTRY, Integer.toString(i)));
        }
//        if (be.hasRequest())
//          renderRequest(root, be.getRequest());
//        if (be.hasSearch())
//          renderSearch(root, be.getSearch());
//        if (be.hasResponse())
//          renderResponse(root, be.getResponse());
        if (be.has("resource")) {
          root.para().addText(formatMessage(RENDER_BUNDLE_RESOURCE, be.get("resource").fhirType()));
          ResourceWrapper rw = be.getChildByName("resource").getAsResource();
          XhtmlNode xn = rw.getNarrative();
          if (xn == null || xn.isEmpty()) {
            ResourceRenderer rr = RendererFactory.factory(rw, context);
            try {
              xn = rr.render(rw);
            } catch (Exception e) {
              xn = new XhtmlNode();
              xn.para().b().tx("Exception generating narrative: "+e.getMessage());
            }
          }
          root.blockquote().addChildren(xn);
        }
      }
    }
    return false;
  }
 

  private boolean renderDocument(XhtmlNode x, ResourceWrapper b, List<BaseWrapper> entries) throws UnsupportedEncodingException, FHIRException, IOException, EOperationOutcome {
    // from the spec:
    //
    // When the document is presented for human consumption, applications SHOULD present the collated narrative portions in order:
    // * The subject resource Narrative
    // * The Composition resource Narrative
    // * The section.text Narratives
    ResourceWrapper comp = (ResourceWrapper) entries.get(0).getChildByName("resource").getAsResource();
    ResourceWrapper subject = resolveReference(entries, comp.get("subject"));
    if (subject != null) {
      if (subject.hasNarrative()) {
        x.addChildren(subject.getNarrative());        
      } else {
        RendererFactory.factory(subject, context).render(x, subject);
      }
    }
    x.hr();
    if (comp.hasNarrative()) {
      x.addChildren(comp.getNarrative());
      x.hr();
    }
    List<BaseWrapper> sections = comp.children("section");
    for (BaseWrapper section : sections) {
      addSection(x, section, 2, false);
    }
    return false;
  }

  private void addSection(XhtmlNode x, BaseWrapper section, int level, boolean nested) throws UnsupportedEncodingException, FHIRException, IOException {
    if (section.has("title") || section.has("code") || section.has("text") || section.has("section")) {
      XhtmlNode div = x.div();
      if (section.has("title")) {
        div.h(level).tx(section.get("title").primitiveValue());        
      } else if (section.has("code")) {
        renderBase(div.h(level), section.get("code"));                
      }
      if (section.has("text")) {
        Base narrative = section.get("text");
        x.addChildren(narrative.getXhtml());
      }      
      if (section.has("section")) {
        List<BaseWrapper> sections = section.children("section");
        for (BaseWrapper child : sections) {
          if (nested) {
            addSection(x.blockquote(), child, level+1, true);
          } else {
            addSection(x, child, level+1, true);
          }
        }
      }      
    }
    // children
  }

  private ResourceWrapper resolveReference(List<BaseWrapper> entries, Base base) throws UnsupportedEncodingException, FHIRException, IOException {
    Property prop = base.getChildByName("reference");
    if (prop.hasValues()) {
      String ref = prop.getValues().get(0).primitiveValue();
      if (ref != null) {
        for (BaseWrapper entry : entries) {
          if (entry.has("fullUrl")) {
            String fu = entry.get("fullUrl").primitiveValue();
            if (ref.equals(fu)) {
              return (ResourceWrapper) entry.getChildByName("resource").getAsResource();
            }
          }
        }
      }
    }
    return null;
  }

  private boolean renderDocument(XhtmlNode x, Bundle b) throws UnsupportedEncodingException, FHIRException, IOException, EOperationOutcome {
    // from the spec:
    //
    // When the document is presented for human consumption, applications SHOULD present the collated narrative portions in order:
    // * The subject resource Narrative
    // * The Composition resource Narrative
    // * The section.text Narratives
    Composition comp = (Composition) b.getEntry().get(0).getResource();
    Resource subject = resolveReference(b, comp.getSubject());
    if (subject != null) {
      XhtmlNode nx = (subject instanceof DomainResource) ? ((DomainResource) subject).getText().getDiv() : null;
      if (nx != null) {
        x.addChildren(nx);        
      } else {
        RendererFactory.factory(subject, context).render(x, subject);
      }
    }
    x.hr();
    if (comp.getText().hasDiv()) {
      x.addChildren(comp.getText().getDiv());
      x.hr();    
    }
    for (SectionComponent section : comp.getSection()) {
      addSection(x, section, 2, false);
    }
    return false;
  }

  private Resource resolveReference(Bundle bnd, Reference reference) {
    String ref = reference.getReference();
    if (ref == null) {
      return null;
    }
    for (BundleEntryComponent be : bnd.getEntry()) {
      if (ref.equals(be.getFullUrl())) {
        return be.getResource();
      }
    }
    return null;
  }


  private void addSection(XhtmlNode x, SectionComponent section, int level, boolean nested) throws UnsupportedEncodingException, FHIRException, IOException {
    if (section.hasTitle() || section.hasCode() || section.hasText() || section.hasSection()) {
      XhtmlNode div = x.div();
      if (section.hasTitle()) {
        div.h(level).tx(section.getTitle());        
      } else if (section.hasCode()) {
        renderBase(div.h(level), section.getCode());                
      }
      if (section.hasText()) {
        x.addChildren(section.getText().getDiv());
      }      
      if (section.hasSection()) {
        List<SectionComponent> sections = section.getSection();
        for (SectionComponent child : sections) {
          if (nested) {
            addSection(x.blockquote(), child, level+1, true);
          } else {
            addSection(x, child, level+1, true);            
          }
        }
      }      
    }
    // children
  }

  
  public XhtmlNode render(Bundle b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (b.getType() == BundleType.DOCUMENT) {
      if (!b.hasEntry() || !(b.getEntryFirstRep().hasResource() && b.getEntryFirstRep().getResource() instanceof Composition)) {
        throw new FHIRException("Invalid document - first entry is not a Composition");
      }
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      renderDocument(x, b);
      return x;
    } else if ((b.getType() == BundleType.COLLECTION && allEntresAreHistoryProvenance(b))) {
      return null;
    } else {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ROOT, b.getId(), b.getType().toCode()));
      int i = 0;
      for (BundleEntryComponent be : b.getEntry()) {
        i++;
        if (be.hasFullUrl())
          root.an(makeInternalBundleLink(be.getFullUrl()));
        if (be.hasResource() && be.getResource().hasId())
          root.an(be.getResource().getResourceType().name() + "_" + be.getResource().getId());
        root.hr();
        if (be.hasFullUrl()) {
          root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ENTRY_URL, Integer.toString(i), be.getFullUrl()));
        } else {
          root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ENTRY, Integer.toString(i)));
        }
        if (be.hasRequest())
          renderRequest(root, be.getRequest());
        if (be.hasSearch())
          renderSearch(root, be.getSearch());
        if (be.hasResponse())
          renderResponse(root, be.getResponse());
        if (be.hasResource()) {
          root.para().addText(formatMessage(RENDER_BUNDLE_RESOURCE, be.getResource().fhirType()));
          if (be.hasResource()) {
            XhtmlNode xn = null;
            if (be.getResource() instanceof DomainResource) {
              DomainResource dr = (DomainResource) be.getResource();
              xn = dr.getText().getDiv();
            }
            if (xn == null || xn.isEmpty()) {
              ResourceRenderer rr = RendererFactory.factory(be.getResource(), context);
              try {
                xn = rr.build(be.getResource());
              } catch (Exception e) {
                xn = makeExceptionXhtml(e, "generating narrative");
              }
            }
            root.blockquote().getChildNodes().addAll(checkInternalLinks(b, xn.getChildNodes()));
          }
        }
      }
      return root;
    }
  }

  public static boolean allEntriesAreHistoryProvenance(List<BaseWrapper> entries) throws UnsupportedEncodingException, FHIRException, IOException {
    for (BaseWrapper be : entries) {
      if (!"Provenance".equals(be.get("resource").fhirType())) {
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

  private void renderSearch(XhtmlNode root, BundleEntrySearchComponent search) {
    StringBuilder b = new StringBuilder();
    b.append(formatMessage(RENDER_BUNDLE_SEARCH));
    if (search.hasMode())
      b.append(formatMessage(RENDER_BUNDLE_SEARCH_MODE, search.getMode().toCode()));
    if (search.hasScore()) {
      if (search.hasMode())
        b.append(",");
      b.append(formatMessage(RENDER_BUNDLE_SEARCH_SCORE, search.getScore()));
    }
    root.para().addText(b.toString());    
  }

  private void renderResponse(XhtmlNode root, BundleEntryResponseComponent response) {
    root.para().addText(formatMessage(RENDER_BUNDLE_RESPONSE));
    StringBuilder b = new StringBuilder();
    b.append(response.getStatus()+"\r\n");
    if (response.hasLocation())
      b.append(formatMessage(RENDER_BUNDLE_LOCATION, response.getLocation())+"\r\n");
    if (response.hasEtag())
      b.append(formatMessage(RENDER_BUNDLE_ETAG, response.getEtag())+"\r\n");
    if (response.hasLastModified())
      b.append(formatMessage(RENDER_BUNDLE_LAST_MOD, response.getEtag())+"\r\n");
    root.pre().addText(b.toString());    
  }

  private void renderRequest(XhtmlNode root, BundleEntryRequestComponent request) {
    root.para().addText(formatMessage(RENDER_BUNDLE_REQUEST));
    StringBuilder b = new StringBuilder();
    b.append(request.getMethod()+" "+request.getUrl()+"\r\n");
    if (request.hasIfNoneMatch())
      b.append(formatMessage(RENDER_BUNDLE_IF_NON_MATCH, request.getIfNoneMatch())+"\r\n");
    if (request.hasIfModifiedSince())
      b.append(formatMessage(RENDER_BUNDLE_IF_MOD, request.getIfModifiedSince())+"\r\n");
    if (request.hasIfMatch())
      b.append(formatMessage(RENDER_BUNDLE_IF_MATCH, request.getIfMatch())+"\r\n");
    if (request.hasIfNoneExist())
      b.append(formatMessage(RENDER_BUNDLE_IF_NONE, request.getIfNoneExist())+"\r\n");
    root.pre().addText(b.toString());    
  }


  public String display(Bundle bundle) throws UnsupportedEncodingException, IOException {
    return "??";
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
