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
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.LiquidEngine;
import org.hl7.fhir.r5.utils.LiquidEngine.ILiquidRenderingSupport;
import org.hl7.fhir.r5.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class LiquidRenderer extends ResourceRenderer implements ILiquidRenderingSupport {

  private String liquidTemplate;

  private class LiquidRendererContext {
    private RenderingStatus status;
    private ResourceElement resource;
    protected LiquidRendererContext(RenderingStatus status, ResourceElement resource) {
      super();
      this.status = status;
      this.resource = resource;
    }
    
  }
  
  public LiquidRenderer(RenderingContext context, String liquidTemplate) { 
    super(context); 
    this.liquidTemplate = liquidTemplate;
  } 
   
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
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
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    LiquidEngine engine = new LiquidEngine(context.getWorker(), context.getServices());
    XhtmlNode xn;
    try {
      engine.setIncludeResolver(new LiquidRendererIncludeResolver(context));
      engine.setRenderingSupport(this);
      LiquidDocument doc = engine.parse(liquidTemplate, "template");
      String html = engine.evaluate(doc, r.getBase(), new LiquidRendererContext(status, r));
      xn = new XhtmlParser().parseFragment(html);
      if (!x.getName().equals("div"))
        throw new FHIRException("Error in template: Root element is not 'div'");
    } catch (FHIRException | IOException e) {
      xn = new XhtmlNode(NodeType.Element, "div");
      xn.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    x.getChildNodes().addAll(xn.getChildNodes());
    status.setExtensions(true);
  }

  public RendererType getRendererType() {
    return RendererType.LIQUID;
  }

  @Override
  public String renderForLiquid(Object appContext, Base base) throws FHIRException {
    try {
      LiquidRendererContext ctxt = (LiquidRendererContext) appContext;
      ResourceElement r = null;
      if (base instanceof Element) {
        r = new ResourceElement(context.getContextUtilities(), context.getProfileUtilities(), (Element) base);
      } else if (base instanceof DataType) {
        r = new ResourceElement(context.getContextUtilities(), context.getProfileUtilities(), (DataType) base);        
      } else {
        return base.toString(); 
      }
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div"); 
      renderDataType(ctxt.status, x, r);
      String res = new XhtmlComposer(true).compose(x);
      res = res.substring(5);
      if (res.length() < 6) {
        return "";
      } else {
        return res.substring(0, res.length()-6);
      }
    } catch (FHIRFormatError e) {
      throw new FHIRException(e);
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

}
