package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Provenance;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
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
    return render(x, (Bundle) r);
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
      if (entries.isEmpty() || (entries.get(0).has("resource") && "Composition".equals(entries.get(0).get("resource").fhirType())))
        throw new FHIRException("Invalid document - first entry is not a Composition");
      ResourceWrapper r = (ResourceWrapper) entries.get(0).getChildByName("resource").getValues().get(0);
      x.addChildren(r.getNarrative());
    } else if ("collection".equals(b.get("type").primitiveValue()) && allEntriesAreHistoryProvenance(entries)) {
      // nothing
    } else {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ROOT, b.getId(), b.get("type").primitiveValue()));
      int i = 0;
      for (BaseWrapper be : entries) {
        i++;
        if (be.has("fullUrl")) {
          root.an(makeInternalLink(be.get("fullUrl").primitiveValue()));
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
          root.blockquote().addChildren(rw.getNarrative());
        }
      }
    }
    return false;
  }
 

  public XhtmlNode render(Bundle b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (b.getType() == BundleType.DOCUMENT) {
      if (!b.hasEntry() || !(b.getEntryFirstRep().hasResource() && b.getEntryFirstRep().getResource() instanceof Composition)) {
        throw new FHIRException("Invalid document - first entry is not a Composition");
      }
      Composition dr = (Composition) b.getEntryFirstRep().getResource();
      return dr.getText().getDiv();
    } else if ((b.getType() == BundleType.COLLECTION && allEntresAreHistoryProvenance(b))) {
      return null;
    } else {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText(formatMessage(RENDER_BUNDLE_HEADER_ROOT, b.getId(), b.getType().toCode()));
      int i = 0;
      for (BundleEntryComponent be : b.getEntry()) {
        i++;
        if (be.hasFullUrl())
          root.an(makeInternalLink(be.getFullUrl()));
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
          if (be.hasResource() && be.getResource() instanceof DomainResource) {
            DomainResource dr = (DomainResource) be.getResource();
            if ( dr.getText().hasDiv())
              root.blockquote().getChildNodes().addAll(checkInternalLinks(b, dr.getText().getDiv().getChildNodes()));
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
      n.setAttribute("href", "#"+makeInternalLink(n.getAttribute("href")));
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


  
  private String makeInternalLink(String fullUrl) {
    return fullUrl.replace(":", "-");
  }

  public String display(Bundle bundle) throws UnsupportedEncodingException, IOException {
    return "??";
  }

}
