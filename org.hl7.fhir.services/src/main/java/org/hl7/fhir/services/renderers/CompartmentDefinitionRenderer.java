package org.hl7.fhir.services.renderers;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.CompartmentDefinition;
import org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class CompartmentDefinitionRenderer extends ResourceRenderer {

  public CompartmentDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (CompartmentDefinition) r.getBase());
      render(status, x, (CompartmentDefinition) r.getBase());      
    } else {
      // it seems very inlikely this will change
      x.para().tx("CompartmentDefinitionRenderer only renders native resources directly");
    }
  }

  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, CompartmentDefinition cpd) throws FHIRFormatError, DefinitionException, IOException {
    StringBuilder in = new StringBuilder();
    StringBuilder out = new StringBuilder();
    for (CompartmentDefinitionResourceComponent cc: cpd.getResourceList()) {
      CommaSeparatedStringBuilder rules = new CommaSeparatedStringBuilder();
      if (!cc.hasParam()) {
        out.append(" <li><a href=\"").append(cc.getCode().toCode().toLowerCase()).append(".html\">").append(cc.getCode()).append("</a></li>\r\n");
      } else if (!rules.toString().equals("{def}")) {
        for (StringType p : cc.getParamList())
          rules.append(p.asStringValue());
        in.append(" <tr><td><a href=\"").append(cc.getCode().toCode().toLowerCase()).append(".html\">").append(cc.getCode()).append("</a></td><td>").append(rules.toString()).append("</td></tr>\r\n");
      }
    }
    XhtmlNode xn;
    xn = new XhtmlParser().parseFragment("<div><p>\r\nThe following resources may be in this compartment:\r\n</p>\r\n" +
        "<table class=\"grid\">\r\n"+
        " <tr><td><b>Resource</b></td><td><b>Inclusion Criteria</b></td></tr>\r\n"+
        in.toString()+
        "</table>\r\n"+
        "<p>\r\nA resource is in this compartment if the nominated search parameter (or chain) refers to the patient resource that defines the compartment.\r\n</p>\r\n" +
        "<p>\r\n\r\n</p>\r\n" +
        "<p>\r\nThe following resources are never in this compartment:\r\n</p>\r\n" +
        "<ul>\r\n"+
        out.toString()+
        "</ul></div>\r\n");
    x.addChildNodes(xn.getChildNodes());
  }

  public void describe(XhtmlNode x, CompartmentDefinition cd) {
    x.tx(display(cd));
  }

  public String display(CompartmentDefinition cd) {
    return cd.present();
  }

}
