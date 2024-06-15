package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ActorDefinitionRenderer extends ResourceRenderer {


  public ActorDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    throw new Error("ActorDefinitionRenderer only renders native resources directly");
  }
  
  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, DomainResource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    render(status, x, (ActorDefinition) r);
  }
  
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, ActorDefinition acd) throws FHIRFormatError, DefinitionException, IOException {
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
        renderUri(status, td, wrap(t));
      }      
    }
    if (acd.hasCapabilities()) {
      tbl.tr().td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_CAP));
      td = tr.td().colspan("2");
      CapabilityStatement cs = context.getWorker().fetchResource(CapabilityStatement.class, acd.getCapabilities(), acd);
      if (cs != null) {
        td.ah(cs.getWebPath()).tx(cs.present());
      } else {
        renderCanonical(status, wrap(acd), td, wrap(acd.getCapabilitiesElement()));
      }      
    }
    if (acd.hasDerivedFrom()) {
      tbl.tr().td().tx(context.formatPhrase(RenderingContext.ACTOR_DEF_DER));
      td = tr.td().colspan("2");
      boolean first = true;
      for (UrlType t : acd.getReference()) {
        if (first) first = false; else x.br();
        ActorDefinition df = context.getWorker().fetchResource(ActorDefinition.class, t.getValue(), acd);
        if (df != null) {
          td.ah(df.getWebPath()).tx(df.present());
        } else {
          renderUri(status, td, wrap(t));
        }      
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
