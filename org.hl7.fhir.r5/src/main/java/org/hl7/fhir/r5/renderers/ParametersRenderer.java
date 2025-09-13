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
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class ParametersRenderer extends ResourceRenderer {

  public ParametersRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    List<ResourceWrapper> params = r.children("parameter");
    if (params.size() < 8) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (ResourceWrapper p : params) {
        b.append(p.primitiveValue("name"));
      }
      return context.formatMessage(RenderingContext.PARS_SUMMARY_LIST, b.toString());
    } else {
      return context.formatMessage(RenderingContext.PARS_SUMMARY_SIZE, params.size());
    }
  }

  public ParametersRenderer setMultiLangMode(boolean multiLangMode) {
    this.multiLangMode = multiLangMode;
    return this;
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(r, x);
    x.h2().tx(context.formatPhrase(RenderingContext.GENERAL_PARS));
    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    params(status, tbl, r.children("parameter"), 0);
  }

  private void params(RenderingStatus status, XhtmlNode tbl, List<ResourceWrapper> list, int indent) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    for (ResourceWrapper p : list) {
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
        ResourceWrapper rw = p.child("resource");
        td = tr.td();
        XhtmlNode para = td.para();
        para.tx(rw.fhirType()+"/"+rw.getId());
        checkAddLink(para, rw.fhirType()+"_"+rw.getId());
        checkAddLink(para, rw.fhirType()+"_"+rw.getScopedId());
        checkAddLink(para, "hc"+rw.fhirType()+"_"+rw.getId());
        checkAddLink(para, "hc"+rw.fhirType()+"_"+rw.getScopedId());
        if (rw.has("meta")) {
          ResourceWrapper m = rw.child("meta");
          String ver = m.primitiveValue("version");
          if (ver != null) {
            checkAddLink(para, "hc"+rw.fhirType()+"_"+rw.getId()+"/"+ver);
            checkAddLink(para, "hc"+rw.fhirType()+"_"+rw.getScopedId()+"/"+ver);            
          }
        }
        XhtmlNode x = rw.getNarrative();
        if (x != null) {
          td.addChildren(x);
        } else {
          ResourceRenderer rr = RendererFactory.factory(rw, context);
          rr.buildNarrative(status, td, rw);
        }
      } else if (p.has("part")) {
        tr.td();
        params(status, tbl, p.children("part"), indent+1);
      }
    }
  }


  private void checkAddLink(XhtmlNode para, String anchor) {
    if (!context.hasAnchor(anchor)) {
      context.addAnchor(anchor);
      para.an(context.prefixAnchor(anchor)).tx(" ");
    }

    
  }

}
