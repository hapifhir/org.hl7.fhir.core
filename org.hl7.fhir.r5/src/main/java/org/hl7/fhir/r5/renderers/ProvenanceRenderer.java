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

import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;


public class ProvenanceRenderer extends ResourceRenderer {

  private static final int MAX_ENTITIES = 10;

  public ProvenanceRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String buildSummary(ResourceWrapper prv) throws UnsupportedEncodingException, IOException {
    return (context.formatPhrase(RenderingI18nContext.PROV_FOR, displayReference(prv.firstChild("target")))+" ");
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper prv) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(prv, x);

    if (prv.has("target")) {
      List<ResourceWrapper> tl = prv.children("target");
      if (tl.size() == 1) {
        XhtmlNode p = x.para();
        p.tx(context.formatPhrase(RenderingI18nContext.PROV_PROV)+" ");
        renderReference(status, p, tl.get(0));
      } else {
        x.para().tx(context.formatPhrase(RenderingI18nContext.PROV_PROVE)+" ");
        XhtmlNode ul = x.ul();
        for (ResourceWrapper ref : tl) {
          renderReference(status, ul.li(), ref);
        }
      }
    }
    // summary table
    x.para().tx(context.formatPhrase(RenderingI18nContext.GENERAL_SUMM));
    XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr;
    if (prv.has("occurred")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.PROV_OCC));
      renderDataType(status, tr.td(), prv.child("occurred"));
    }
    if (prv.has("recorded")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.PROV_REC));
      renderDataType(status, tr.td(), prv.child("recorded"));
    }
    if (prv.has("policy")) {
      List<ResourceWrapper> tl = prv.children("policy");
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.PROV_POL));
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
      tr.td().tx(context.formatPhrase(RenderingI18nContext.GENERAL_LOCATION));
      renderDataType(status, tr.td(), prv.child("location"));
    }
    if (prv.has("activity")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.PROV_ACT));
      renderDataType(status, tr.td(), prv.child("activity"));
    }
    if (prv.has("reason")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.PROV_REASON));
      renderList(status, tr.td(), prv.children("reason"));
    }
    if (prv.has("patient")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.GENERAL_SUBJ));
      renderReference(status, tr.td(), prv.child("patient"));
    }
    if (prv.has("basedOn")) {
      tr = t.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.PROV_BASED_ON));
      XhtmlNode td = tr.td();
      List<ResourceWrapper> tl = prv.children("basedOn");
      if (tl.size() == 1) {
        renderReference(status, td, tl.get(0));
      } else {
        XhtmlNode ul = td.ul();
        for (ResourceWrapper ref : tl) {
          renderReference(status, ul.li(), ref);
        }
      }
    }

    boolean hasType = false;
    boolean hasRole = false;
    boolean hasOnBehalfOf = false;
    for (ResourceWrapper a : prv.children("agent")) {
      hasType = hasType || a.has("type"); 
      hasRole = hasRole || a.has("role"); 
      hasOnBehalfOf = hasOnBehalfOf || a.has("onBehalfOf"); 
    }    
    x.para().b().tx(context.formatPhrase(RenderingI18nContext.PROV_AGE));
    t = x.table("grid", false).markGenerated(!context.forValidResource());
    tr = t.tr();
    if (hasType) {
      tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_TYPE));
    }
    if (hasRole) {
      tr.td().b().tx(context.formatPhrase(RenderingI18nContext.PROV_ROLE));
    }
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.PROV_WHO));
    if (hasOnBehalfOf) {
      tr.td().b().tx(context.formatPhrase(RenderingI18nContext.PROV_BEHALF));
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
        renderList(status, tr.td(), a.children("role"));
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

    List<ResourceWrapper> entities = prv.children("entity");
    if (!entities.isEmpty()) {
      boolean hasEntRole = false;
      boolean hasWhat = false;
      boolean hasEntAgent = false;
      for (ResourceWrapper e : entities) {
        hasEntRole = hasEntRole || e.has("role");
        hasWhat = hasWhat || e.has("what");
        hasEntAgent = hasEntAgent || e.has("agent");
      }
      x.para().b().tx(context.formatPhrase(RenderingI18nContext.PROV_ENT));
      t = x.table("grid", false).markGenerated(!context.forValidResource());
      tr = t.tr();
      if (hasEntRole) {
        tr.td().b().tx(context.formatPhrase(RenderingI18nContext.PROV_ROLE));
      }
      if (hasWhat) {
        tr.td().b().tx(context.formatPhrase(RenderingI18nContext.PROV_WHAT));
      }
      if (hasEntAgent) {
        tr.td().b().tx(context.formatPhrase(RenderingI18nContext.PROV_AGE));
      }
      int limit = Math.min(entities.size(), MAX_ENTITIES);
      for (int i = 0; i < limit; i++) {
        ResourceWrapper e = entities.get(i);
        tr = t.tr();
        if (hasEntRole) {
          XhtmlNode td = tr.td();
          if (e.has("role")) {
            renderDataType(status, td, e.child("role"));
          }
        }
        if (hasWhat) {
          XhtmlNode td = tr.td();
          if (e.has("what")) {
            renderReference(status, td, e.child("what"));
          }
        }
        if (hasEntAgent) {
          XhtmlNode td = tr.td();
          List<ResourceWrapper> al = e.children("agent");
          if (al.size() == 1) {
            renderEntityAgent(status, td, al.get(0));
          } else if (al.size() > 1) {
            XhtmlNode ul = td.ul();
            for (ResourceWrapper a : al) {
              renderEntityAgent(status, ul.li(), a);
            }
          }
        }
      }
      if (entities.size() > MAX_ENTITIES) {
        x.para().i().tx(context.formatPhrase(RenderingI18nContext.PROV_ENT_MORE, MAX_ENTITIES, entities.size()));
      }
    }
  }

  private void renderEntityAgent(RenderingStatus status, XhtmlNode x, ResourceWrapper a) throws FHIRFormatError, DefinitionException, IOException {
    if (a.has("who")) {
      renderReference(status, x, a.child("who"));
    }
    if (a.has("role")) {
      x.tx(" (");
      boolean first = true;
      for (ResourceWrapper r : a.children("role")) {
        if (!first) {
          x.tx(", ");
        }
        first = false;
        renderCodeableConcept(status, x, r);
      }
      x.tx(")");
    }
  }

  private void renderList(RenderingStatus status, XhtmlNode td, List<ResourceWrapper> list) throws FHIRFormatError, DefinitionException, IOException {
    if (list.size() == 1) {
      renderDataType(status, td, list.get(0));
    } else if (list.size() > 1) {
      XhtmlNode ul = td.ul();
      for (ResourceWrapper cc : list) {
        renderDataType(status, ul.li(), cc);
      }
    }
  }


}