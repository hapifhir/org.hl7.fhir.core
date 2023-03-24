package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ActorDefinitionRenderer extends ResourceRenderer {

  public ActorDefinitionRenderer(RenderingContext context) {
    super(context);
  }

  public ActorDefinitionRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (ActorDefinition) dr);
  }


  public boolean render(XhtmlNode x, ActorDefinition acd) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx("Actor: "+acd.getName());
    tr.td().tx(acd.getTitle());
    tr.td().tx("Type: " + acd.getType().toCode());
    XhtmlNode td = tbl.tr().td().colspan("3");
    addMarkdown(td, acd.getDocumentation());
    if (acd.hasReference()) {
      tbl.tr().td().tx("References:");
      td = tr.td().colspan("2");
      boolean first = true;
      for (UrlType t : acd.getReference()) {
        if (first) first = false; else x.br();
        render(td, t);
      }      
    }
    if (acd.hasCapabilities()) {
      tbl.tr().td().tx("Capabilities:");
      td = tr.td().colspan("2");
      CapabilityStatement cs = context.getWorker().fetchResource(CapabilityStatement.class, acd.getCapabilities(), acd);
      if (cs != null) {
        td.ah(cs.getWebPath()).tx(cs.present());
      } else {
        render(td, acd.getCapabilitiesElement());
      }      
    }
    if (acd.hasDerivedFrom()) {
      tbl.tr().td().tx("Derived from:");
      td = tr.td().colspan("2");
      boolean first = true;
      for (UrlType t : acd.getReference()) {
        if (first) first = false; else x.br();
        ActorDefinition df = context.getWorker().fetchResource(ActorDefinition.class, t.getValue(), acd);
        if (df != null) {
          td.ah(df.getWebPath()).tx(df.present());
        } else {
          render(td, t);
        }      
      }      
    }
    return false;
  }
  
  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((Library) r).present();
  }

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    return "??";
  }
  
}
