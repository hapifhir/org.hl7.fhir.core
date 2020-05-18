package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.DomainResource;
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
  public boolean render(XhtmlNode x, DomainResource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    return false;
  }

  @Override
  public String display(DomainResource r) throws UnsupportedEncodingException, IOException {
    return null;
  }

  public XhtmlNode render(Bundle b) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (b.getType() == BundleType.DOCUMENT) {
      if (!b.hasEntry() || !(b.getEntryFirstRep().hasResource() && b.getEntryFirstRep().getResource() instanceof Composition))
        throw new FHIRException("Invalid document - first entry is not a Composition");
      Composition dr = (Composition) b.getEntryFirstRep().getResource();
      return dr.getText().getDiv();
    } else  {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText("Bundle "+b.getId()+" of type "+b.getType().toCode());
      int i = 0;
      for (BundleEntryComponent be : b.getEntry()) {
        i++;
        if (be.hasFullUrl())
          root.an(makeInternalLink(be.getFullUrl()));
        if (be.hasResource() && be.getResource().hasId())
          root.an(be.getResource().getResourceType().name().toLowerCase() + "_" + be.getResource().getId());
        root.hr();
        root.para().addText("Entry "+Integer.toString(i)+(be.hasFullUrl() ? " - Full URL = " + be.getFullUrl() : ""));
        if (be.hasRequest())
          renderRequest(root, be.getRequest());
        if (be.hasSearch())
          renderSearch(root, be.getSearch());
        if (be.hasResponse())
          renderResponse(root, be.getResponse());
        if (be.hasResource()) {
          root.para().addText("Resource "+be.getResource().fhirType()+":");
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
    b.append("Search: ");
    if (search.hasMode())
      b.append("mode = "+search.getMode().toCode());
    if (search.hasScore()) {
      if (search.hasMode())
        b.append(",");
      b.append("score = "+search.getScore());
    }
    root.para().addText(b.toString());    
  }

  private void renderResponse(XhtmlNode root, BundleEntryResponseComponent response) {
    root.para().addText("Request:");
    StringBuilder b = new StringBuilder();
    b.append(response.getStatus()+"\r\n");
    if (response.hasLocation())
      b.append("Location: "+response.getLocation()+"\r\n");
    if (response.hasEtag())
      b.append("E-Tag: "+response.getEtag()+"\r\n");
    if (response.hasLastModified())
      b.append("LastModified: "+response.getEtag()+"\r\n");
    root.pre().addText(b.toString());    
  }

  private void renderRequest(XhtmlNode root, BundleEntryRequestComponent request) {
    root.para().addText("Response:");
    StringBuilder b = new StringBuilder();
    b.append(request.getMethod()+" "+request.getUrl()+"\r\n");
    if (request.hasIfNoneMatch())
      b.append("If-None-Match: "+request.getIfNoneMatch()+"\r\n");
    if (request.hasIfModifiedSince())
      b.append("If-Modified-Since: "+request.getIfModifiedSince()+"\r\n");
    if (request.hasIfMatch())
      b.append("If-Match: "+request.getIfMatch()+"\r\n");
    if (request.hasIfNoneExist())
      b.append("If-None-Exist: "+request.getIfNoneExist()+"\r\n");
    root.pre().addText(b.toString());    
  }

  private String makeInternalLink(String fullUrl) {
    return fullUrl.replace(":", "-");
  }

  public String display(Bundle bundle) throws UnsupportedEncodingException, IOException {
    return "??";
  }

}
