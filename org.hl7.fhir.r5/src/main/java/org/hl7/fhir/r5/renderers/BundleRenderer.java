package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.Composition.SectionComponent;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Provenance;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.EOperationOutcome;
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
        if (be.has("resource")) {
          if (be.getChildByName("resource").getValues().get(0).has("id")) {
            root.an(be.get("resource").fhirType() + "_" + be.getChildByName("resource").getValues().get(0).get("id").primitiveValue());
          } else {
            String id = makeIdFromBundleEntry(be.get("fullUrl").primitiveValue());
            root.an(be.get("resource").fhirType() + "_" + id);
          }
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
              rr.setRcontext(new ResourceContext(rcontext, rw));
              xn = rr.render(rw);
            } catch (Exception e) {
              xn = new XhtmlNode();
              xn.para().b().tx("Exception generating narrative: "+e.getMessage());
            }
          }
          root.blockquote().para().addChildren(xn);
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
        RendererFactory.factory(subject, context, new ResourceContext(rcontext, subject)).render(x, subject);
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
            addSection(x.blockquote().para(), child, level+1, true);
          } else {
            addSection(x, child, level+1, true);
          }
        }
      }      
    }
    // children
  }

  private ResourceWrapper resolveReference(List<BaseWrapper> entries, Base base) throws UnsupportedEncodingException, FHIRException, IOException {
    if (base == null) {
      return null;
    }
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
    Resource subject = resolveReference(b, comp.getSubjectFirstRep());
    if (subject != null) {
      XhtmlNode nx = (subject instanceof DomainResource) ? ((DomainResource) subject).getText().getDiv() : null;
      if (nx != null && !nx.isEmpty()) {
        x.addChildren(nx);        
      } else {
        RendererFactory.factory(subject, context).setRcontext(new ResourceContext(rcontext, subject)).render(x, subject);
      }
    }
    x.hr();
    if (!comp.getText().hasDiv()) {
      ResourceRenderer rr = RendererFactory.factory(comp, getContext());     
      rr.setRcontext(new ResourceContext(rcontext, comp));
      rr.render(comp);
    }
    if (comp.getText().hasDiv()) {
      x.addChildren(comp.getText().getDiv());
      x.hr();    
    }
    for (SectionComponent section : comp.getSection()) {
      addSection(x, section, 2, false, comp);
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


  private void addSection(XhtmlNode x, SectionComponent section, int level, boolean nested, Composition c) throws UnsupportedEncodingException, FHIRException, IOException {
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
      if (section.hasEntry()) {
        XhtmlNode ul = x.ul();
        for (Reference r : section.getEntry()) {
          renderReference(c, ul.li(), r);
        }
      }
      if (section.hasSection()) {
        List<SectionComponent> sections = section.getSection();
        for (SectionComponent child : sections) {
          if (nested) {
            addSection(x.blockquote().para(), child, level+1, true, c);
          } else {
            addSection(x, child, level+1, true, c);            
          }
        }
      }      
    }
    // children
  }

  
  public XhtmlNode render(Bundle b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if ((b.getType() == BundleType.COLLECTION && allEntresAreHistoryProvenance(b))) {
      return null;
    } else {
      int start = 0;
      boolean docMode = false;
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      if (b.getType() == BundleType.DOCUMENT) {
        if (!b.hasEntry() || !(b.getEntryFirstRep().hasResource() && b.getEntryFirstRep().getResource() instanceof Composition)) {
          throw new FHIRException("Invalid document - first entry is not a Composition");
        }
        renderDocument(x, b);
        start = 1;
        docMode = true;
        x.hr();
        x.h2().addText(formatMessage(RENDER_BUNDLE_DOCUMENT_CONTENT, b.getId(), b.getType().toCode()));
      } else {
        x.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ROOT, b.getId(), b.getType().toCode()));
      }
      int i = 0;
      for (BundleEntryComponent be : b.getEntry()) {
        i++;
        if (i > start) {
          if (be.hasFullUrl())
            x.an(makeInternalBundleLink(be.getFullUrl()));
          if (be.hasResource()) {
            if (be.getResource().hasId()) {
              x.an(be.getResource().getResourceType().name() + "_" + be.getResource().getId());
            } else {
              String id = makeIdFromBundleEntry(be.getFullUrl());
              x.an(be.getResource().getResourceType().name() + "_" + id);
            }
          }
          x.hr();
          if (docMode) {
            if (be.hasFullUrl() && be.hasResource()) {
              x.para().addText(formatMessage(RENDER_BUNDLE_HEADER_DOC_ENTRY_URD, Integer.toString(i), be.getFullUrl(), be.getResource().fhirType(), be.getResource().getIdBase()));
            } else if (be.hasFullUrl()) {
              x.para().addText(formatMessage(RENDER_BUNDLE_HEADER_DOC_ENTRY_U, Integer.toString(i), be.getFullUrl()));
            } else if (be.hasResource()) {
              x.para().addText(formatMessage(RENDER_BUNDLE_HEADER_DOC_ENTRY_RD, Integer.toString(i), be.getResource().fhirType(), be.getResource().getIdBase()));              
            }
          } else {
            if (be.hasFullUrl()) {
              x.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ENTRY_URL, Integer.toString(i), be.getFullUrl()));
            } else {
              x.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ENTRY, Integer.toString(i)));
            }
            if (be.hasRequest())
              renderRequest(x, be.getRequest());
            if (be.hasSearch())
              renderSearch(x, be.getSearch());
            if (be.hasResponse())
              renderResponse(x, be.getResponse());
          }
          if (be.hasResource()) {
            if (!docMode) {
              x.para().addText(formatMessage(RENDER_BUNDLE_RESOURCE, be.getResource().fhirType()));
            }
            if (be.hasResource()) {
              XhtmlNode xn = null;
              if (be.getResource() instanceof DomainResource) {
                DomainResource dr = (DomainResource) be.getResource();
                xn = dr.getText().getDiv();
              }
              if (xn == null || xn.isEmpty()) {
                ResourceRenderer rr = RendererFactory.factory(be.getResource(), context);
                try {
                  rr.setRcontext(new ResourceContext(rcontext, be.getResource()));
                  xn = rr.build(be.getResource());
                } catch (Exception e) {
                  xn = makeExceptionXhtml(e, "generating narrative");
                }
              }
              x.blockquote().para().getChildNodes().addAll(checkInternalLinks(b, xn.getChildNodes()));
            }
          }
        }
      }
      return x;
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
