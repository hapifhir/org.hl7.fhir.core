package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class ActorDefinitionRenderer extends ResourceRenderer {


  public ActorDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(r, x);
    boolean summ = genSummaryTable(status, x, r);
    render(status, x, r, summ);      
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, ResourceWrapper acd, boolean summ) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tbl = x.table("grid", false);
    XhtmlNode tr = tbl.tr();
    
    XhtmlNode td = null;
    
    // if there's no summary table, then the first 3 rows of the table are 
    //   * name, title, type 
    //   * documentation 
    //   * baseDefinition
    // otherwise, the first row of the table is 
    //   * type, baseDefinition
    //
    // after that
    //   * reference
    if (!summ) {
      // first row, if there's no summary table:
      xlinkNarrative(tr.td(), acd.child("name")).b().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_ACT, context.getTranslated(acd.child("name")))  + " ");
      xlinkNarrative(tr.td(), acd.child("title")).tx(context.getTranslated(acd.child("title")));
      xlinkNarrative(tr.td(), acd.child("type")).tx(context.formatPhrase(RenderingContext.ACTOR_DEF_TYP, acd.primitiveValue("type")) + " ");      
      tr = tbl.tr();
      td = tr.td().colspan("3");
      xlinkNarrative(td, acd.child("documentation"));
      addMarkdown(td, context.getTranslated(acd.child("documentation")));
      if (acd.has("baseDefinition")) {
        markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.ACTOR_DERIVED_FROM));
        td = tr.td().colspan("2");
        boolean first = true;
        for (ResourceWrapper t : acd.children("reference")) {
          if (first) first = false; else x.br();
          renderUri(status, spanIfTracking(td, t), t);
        }      
      }
    } else {
      xlinkNarrative(tr.td(), acd.child("type")).tx(context.formatPhrase(RenderingContext.ACTOR_DEF_TYP, acd.primitiveValue("type")) + " ");      
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.ACTOR_DERIVED_FROM));
      td = tr.td();
      if (acd.has("baseDefinition")) {
        boolean first = true;
        for (ResourceWrapper t : acd.children("reference")) {
          if (first) first = false; else x.br();
          renderUri(status, spanIfTracking(td, t), t);
        }      
      } else {
        markGenerated(td).style("opaque: 0.6").tx(context.formatPhrase(RenderingContext.ACTOR_DERIVED_FROM_NONE));
      }
    }
    if (acd.has("reference")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_REFS));
      td = tr.td().colspan("2");
      boolean first = true;
      for (ResourceWrapper t : acd.children("reference")) {
        if (first) first = false; else x.br();
        renderUri(status, spanIfTracking(td, t), t);
      }      
    }
    if (acd.has("capabilities")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.ACTOR_DEF_CAP));
      td = tr.td().colspan("2");
      renderCanonical(status, xlinkNarrative(td, acd.child("capabilities")), acd.child("capabilities"));      
    }
    if (acd.has("derivedFrom")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.ACTOR_DEF_DER));
      td = tr.td().colspan("2");
      boolean first = true;
      for (ResourceWrapper t : acd.children("derivedFrom")) {
        if (first) first = false; else x.br();
        renderUri(status, spanIfTracking(td, t), t);
      }      
    }
  }
  
  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }
  
}
