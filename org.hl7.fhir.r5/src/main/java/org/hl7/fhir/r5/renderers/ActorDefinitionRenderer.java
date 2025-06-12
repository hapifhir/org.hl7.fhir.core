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
    genSummaryTable(status, x, r);
    render(status, x, r);      
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, ResourceWrapper acd) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tbl = x.table("grid", false);
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_ACT, context.getTranslated(acd.child("name")))  + " ");
    tr.td().tx(context.getTranslated(acd.child("title")));
    tr.td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_TYP, acd.primitiveValue("type")) + " ");
    XhtmlNode td = tbl.tr().td().colspan("3");
    addMarkdown(td, context.getTranslated(acd.child("documentation")));
    if (acd.has("reference")) {
      tbl.tr().td().tx(context.formatPhrase(RenderingContext.GENERAL_REFS));
      td = tr.td().colspan("2");
      boolean first = true;
      for (ResourceWrapper t : acd.children("reference")) {
        if (first) first = false; else x.br();
        renderUri(status, td, t);
      }      
    }
    if (acd.has("capabilities")) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_CAP));
      td = tr.td().colspan("2");
      renderCanonical(status, td, acd.child("capabilities"));      
    }
    if (acd.has("derivedFrom")) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_DER));
      td = tr.td().colspan("2");
      boolean first = true;
      for (ResourceWrapper t : acd.children("derivedFrom")) {
        if (first) first = false; else x.br();
        renderUri(status, td, t);
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
