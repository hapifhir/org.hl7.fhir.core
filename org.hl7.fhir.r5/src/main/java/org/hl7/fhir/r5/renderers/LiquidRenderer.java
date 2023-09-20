package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.LiquidEngine;
import org.hl7.fhir.r5.utils.LiquidEngine.ILiquidRenderingSupport;
import org.hl7.fhir.r5.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class LiquidRenderer extends ResourceRenderer implements ILiquidRenderingSupport {

  public class LiquidRendererContxt {

    private ResourceContext rcontext;
    private ResourceWrapper resource;

    public LiquidRendererContxt(ResourceContext rcontext, ResourceWrapper r) {
      this.rcontext = rcontext;
      this.resource = r;
    }

    public ResourceWrapper getResource() {
      return resource;
    }

  }

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

  /**
   * This class provides an implementation of the ILiquidEngineIncludeResolver that makes use of the
   * template provider available in the rendering context to support resolving includes.
   */
  private class LiquidRendererIncludeResolver implements LiquidEngine.ILiquidEngineIncludeResolver {
    public LiquidRendererIncludeResolver(RenderingContext context) {
      this.context = context;
    }

    private RenderingContext context;

    @Override
    public String fetchInclude(LiquidEngine engine, String name) {
      return context.getTemplateProvider().findTemplate(context, name);
    }
  }
  
  @Override
  public boolean render(XhtmlNode x, Resource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    LiquidEngine engine = new LiquidEngine(context.getWorker(), context.getServices());
    XhtmlNode xn;
    try {
      engine.setIncludeResolver(new LiquidRendererIncludeResolver(context));
      engine.setRenderingSupport(this);
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
      engine.setIncludeResolver(new LiquidRendererIncludeResolver(context));
      LiquidDocument doc = engine.parse(liquidTemplate, "template");
      engine.setRenderingSupport(this);
      String html = engine.evaluate(doc, r.getBase(), new LiquidRendererContxt(rcontext, r));
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

  public RendererType getRendererType() {
    return RendererType.LIQUID;
  }

  @Override
  public String renderForLiquid(Object appContext, Base base) throws FHIRException {
    try {
      if (base instanceof Element) {
        base = context.getParser().parseType((Element) base);
      }
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      if (base instanceof Reference) {
        renderReference(((LiquidRendererContxt) appContext).getResource(), x, (Reference) base);        
      } else if (base instanceof DataType) {
        render(x, (DataType) base);
      } else {
        x.tx(base.toString());
      }
      String res = new XhtmlComposer(true).compose(x).substring(5);
      return res.substring(0, res.length()-6);
    } catch (FHIRFormatError e) {
      throw new FHIRException(e);
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

}
