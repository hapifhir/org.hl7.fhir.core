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
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ActorDefinitionRenderer extends ResourceRenderer {


  public ActorDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (ActorDefinition) r.getBase());
      render(status, x, (ActorDefinition) r.getBase(), r);      
    } else {
      throw new Error("ActorDefinitionRenderer only renders native resources directly");
    }
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, ActorDefinition acd, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_ACT, acd.getName())  + " ");
    tr.td().tx(acd.getTitle());
    tr.td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_TYP, acd.getType().toCode()) + " ");
    XhtmlNode td = tbl.tr().td().colspan("3");
    addMarkdown(td, acd.getDocumentation());
    if (acd.hasReference()) {
      tbl.tr().td().tx(context.formatPhrase(RenderingContext.GENERAL_REFS));
      td = tr.td().colspan("2");
      boolean first = true;
      for (UrlType t : acd.getReference()) {
        if (first) first = false; else x.br();
        renderUri(status, td, wrapWC(r, t));
      }      
    }
    if (acd.hasCapabilities()) {
      tbl.tr().td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_CAP));
      td = tr.td().colspan("2");
      renderCanonical(status, r, td, CapabilityStatement.class, acd.getCapabilitiesElement());      
    }
    if (acd.hasDerivedFrom()) {
      tbl.tr().td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_DER));
      td = tr.td().colspan("2");
      boolean first = true;
      for (UrlType t : acd.getReference()) {
        if (first) first = false; else x.br();
        renderUri(status, r, td, t);
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
