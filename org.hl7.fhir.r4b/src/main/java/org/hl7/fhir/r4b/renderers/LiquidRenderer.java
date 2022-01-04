package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.utils.EOperationOutcome;
import org.hl7.fhir.r4b.utils.LiquidEngine;
import org.hl7.fhir.r4b.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class LiquidRenderer extends ResourceRenderer {

  private String liquidTemplate;

  public LiquidRenderer(RenderingContext context, String liquidTemplate) {
    super(context);
    this.liquidTemplate = liquidTemplate;
  }

  public LiquidRenderer(RenderingContext context, ResourceContext rcontext, String liquidTemplate) {
    super(context);
    this.rcontext = rcontext;
    this.liquidTemplate = liquidTemplate;
  }
  
  @Override
  public boolean render(XhtmlNode x, Resource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    LiquidEngine engine = new LiquidEngine(context.getWorker(), context.getServices());
    XhtmlNode xn;
    try {
      LiquidDocument doc = engine.parse(liquidTemplate, "template");
      String html = engine.evaluate(doc, r, rcontext);
      xn = new XhtmlParser().parseFragment(html);
      if (!x.getName().equals("div"))
        throw new FHIRException("Error in template: Root element is not 'div'");
    } catch (FHIRException | IOException e) {
      xn = new XhtmlNode(NodeType.Element, "div");
      xn.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    x.getChildNodes().addAll(xn.getChildNodes());
    return true;
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return "not done yet";
  }

  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    if (r.has("name")) {
      return r.children("name").get(0).getBase().primitiveValue();
    }
    return "??";
  }

  @Override
  public boolean render(XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    LiquidEngine engine = new LiquidEngine(context.getWorker(), context.getServices());
    XhtmlNode xn;
    try {
      LiquidDocument doc = engine.parse(liquidTemplate, "template");
      String html = engine.evaluate(doc, r.getBase(), rcontext);
      xn = new XhtmlParser().parseFragment(html);
      if (!x.getName().equals("div"))
        throw new FHIRException("Error in template: Root element is not 'div'");
    } catch (FHIRException | IOException e) {
      xn = new XhtmlNode(NodeType.Element, "div");
      xn.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    x.getChildNodes().addAll(xn.getChildNodes());
    return true;
  }

}
