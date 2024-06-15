package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ParametersRenderer extends ResourceRenderer {

  public ParametersRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return "todo";
  }

  public ParametersRenderer setMultiLangMode(boolean multiLangMode) {
    this.multiLangMode = multiLangMode;
    return this;
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    x.h2().tx(context.formatPhrase(RenderingContext.GENERAL_PARS));
    XhtmlNode tbl = x.table("grid");
    params(status, tbl, r.children("parameter"), 0);
  }

  private void params(RenderingStatus status, XhtmlNode tbl, List<ResourceElement> list, int indent) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    for (ResourceElement p : list) {
      XhtmlNode tr = tbl.tr();
      XhtmlNode td = tr.td();
      for (int i = 0; i < indent; i++) {
        td.tx(XhtmlNode.NBSP);        
      }
      if (p.has("name")) {
        td.tx(p.primitiveValue("name"));
      } else {
        td.tx("???");
      }
      if (p.has("value")) {
        renderDataType(status, tr.td(), p.child("value"));
      } else if (p.has("resource")) {
        ResourceElement rw = p.child("resource");
        td = tr.td();
        XhtmlNode para = td.para();
        para.tx(rw.fhirType()+"/"+rw.getId());
        para.an(rw.fhirType()+"_"+rw.getId()).tx(" ");
        para.an("hc"+rw.fhirType()+"_"+rw.getId()).tx(" ");
        XhtmlNode x = rw.getNarrative();
        if (x != null) {
          td.addChildren(x);
        } else {
          ResourceRenderer rr = RendererFactory.factory(rw, context);
          rr.renderResource(status, td, rw);
        }
      } else if (p.has("part")) {
        tr.td();
        params(status, tbl, p.children("part"), indent+1);
      }
    }
  }

}
