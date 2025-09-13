package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class ProvenanceRenderer extends ResourceRenderer {

  public ProvenanceRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String buildSummary(ResourceWrapper prv) throws UnsupportedEncodingException, IOException {
    return (context.formatPhrase(RenderingContext.PROV_FOR, displayReference(prv.firstChild("target")))+" ");
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper prv) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(prv, x);

    if (prv.has("target")) {
      List<ResourceWrapper> tl = prv.children("target");
      if (tl.size() == 1) {
        XhtmlNode p = x.para();
        p.tx(context.formatPhrase(RenderingContext.PROV_PROV)+" ");
        renderReference(status, p, tl.get(0));
      } else {
        x.para().tx(context.formatPhrase(RenderingContext.PROV_PROVE)+" ");
        XhtmlNode ul = x.ul();
        for (ResourceWrapper ref : tl) {
          renderReference(status, ul.li(), ref);
        }
      }
    }
    // summary table
    x.para().tx(context.formatPhrase(RenderingContext.GENERAL_SUMM));
    XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr;
    if (prv.has("occurred")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.PROV_OCC));
      renderDataType(status, tr.td(), prv.child("occurred"));
    }
    if (prv.has("recorded")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.PROV_REC));
      renderDataType(status, tr.td(), prv.child("recorded"));
    }
    if (prv.has("policy")) {
      List<ResourceWrapper> tl = prv.children("policy");
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.PROV_POL));
      if (tl.size() == 1) {
        renderDataType(status, tr.td(), tl.get(0));
      } else {
        XhtmlNode ul = tr.td().ul();
        for (ResourceWrapper u : tl) {
          renderDataType(status, ul.li(), u);
        }
      }
    }
    if (prv.has("location")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_LOCATION));
      renderDataType(status, tr.td(), prv.child("location"));
    }
    if (prv.has("activity")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.PROV_ACT));
      renderDataType(status, tr.td(), prv.child("activity"));
    }

    boolean hasType = false;
    boolean hasRole = false;
    boolean hasOnBehalfOf = false;
    for (ResourceWrapper a : prv.children("agent")) {
      hasType = hasType || a.has("type"); 
      hasRole = hasRole || a.has("role"); 
      hasOnBehalfOf = hasOnBehalfOf || a.has("onBehalfOf"); 
    }    
    x.para().b().tx(context.formatPhrase(RenderingContext.PROV_AGE));
    t = x.table("grid", false).markGenerated(!context.forValidResource());
    tr = t.tr();
    if (hasType) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_TYPE));
    }
    if (hasRole) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.PROV_ROLE));
    }
    tr.td().b().tx(context.formatPhrase(RenderingContext.PROV_WHO));
    if (hasOnBehalfOf) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.PROV_BEHALF));
    }
    for (ResourceWrapper a : prv.children("agent")) {
      tr = t.tr();
      if (hasType) {
        if (a.has("type")) {
          renderDataType(status, tr.td(), a.child("type"));         
        } else {
          tr.td();
        }
      }        
      if (hasRole) {
        List<ResourceWrapper> tl = prv.children("role");        
        if (tl.size() == 0) {
          tr.td();
        } else if (tl.size() == 1) {
          renderCodeableConcept(status, tr.td(), tl.get(0));
        } else {
          XhtmlNode ul = tr.td().ul();
          for (ResourceWrapper cc : tl) {
            renderCodeableConcept(status, ul.li(), cc);
          }
        }
      }
      if (a.has("who")) {
        renderReference(status, tr.td(), a.child("who"));         
      } else {
        tr.td();
      }
      if (hasOnBehalfOf) {
        if (a.has("onBehalfOf")) {
          renderReference(status, tr.td(), a.child("onBehalfOf"));         
        } else {
          tr.td();
        }
      }
    }
    // agent table

  }


}