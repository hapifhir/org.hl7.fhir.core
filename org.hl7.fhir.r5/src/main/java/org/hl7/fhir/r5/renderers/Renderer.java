package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.utils.TranslatingUtilities;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * Rendering framework:
 * 
 *   * boolean render(DomainResource) : produce an HTML representation suitable for runtime / documentation, and insert it into the resource. Return true of any extensions encountered
 *   * boolean render(XhtmlNode, Resource: produce an HTML representation, and fill out the provided node with it. Return true of any extensions encountered
 *   * XhtmlNode build(DomainResource): same as render(DomainResource) but also return the XHtmlNode 
 *   
 *   * String display(Base) : produce a plan text concise representation that serves to describe the resource
 *   * void display(XhtmlNode, Base) : produce a plan text concise representation that serves to describe the resource
 *   
 *   * void describe(XhtmlNode, Resource) : produce a short summary of the resource with key details presented (potentially more verbose than display, but still suitable for a single line)  
 *   
 * if not specific code for rendering a resource has been provided, and there's no liquid script to guide it, a generic rendering based onthe profile will be performed
 *   
 * @author graha
 *
 */
public class Renderer extends TranslatingUtilities {

  protected RenderingContext context;
  
  public Renderer(RenderingContext context) {
    this.context = context;
  }

  public Renderer(IWorkerContext worker) {
    this.context = new RenderingContext(worker, new MarkDownProcessor(Dialect.COMMON_MARK), ValidationOptions.defaults(), "http://hl7.org/fhir/R5", "", null, ResourceRendererMode.END_USER, GenerationRules.IG_PUBLISHER);
  }


  protected static final String RENDER_BUNDLE_HEADER_ROOT = "RENDER_BUNDLE_HEADER_ROOT";
  protected static final String RENDER_BUNDLE_HEADER_ENTRY = "RENDER_BUNDLE_HEADER_ENTRY";
  protected static final String RENDER_BUNDLE_HEADER_ENTRY_URL = "RENDER_BUNDLE_HEADER_ENTRY_URL";
  protected static final String RENDER_BUNDLE_RESOURCE = "RENDER_BUNDLE_RESOURCE";
  protected static final String RENDER_BUNDLE_SEARCH = "RENDER_BUNDLE_SEARCH";
  protected static final String RENDER_BUNDLE_SEARCH_MODE = "RENDER_BUNDLE_SEARCH_MODE"; 
  protected static final String RENDER_BUNDLE_SEARCH_SCORE = "RENDER_BUNDLE_SEARCH_SCORE";
  protected static final String RENDER_BUNDLE_RESPONSE = "RENDER_BUNDLE_RESPONSE";
  protected static final String RENDER_BUNDLE_LOCATION = "RENDER_BUNDLE_LOCATION";
  protected static final String RENDER_BUNDLE_ETAG = "RENDER_BUNDLE_ETAG";
  protected static final String RENDER_BUNDLE_LAST_MOD = "RENDER_BUNDLE_LAST_MOD";
  protected static final String RENDER_BUNDLE_REQUEST = "RENDER_BUNDLE_REQUEST";
  protected static final String RENDER_BUNDLE_IF_NON_MATCH = "RENDER_BUNDLE_IF_NON_MATCH";
  protected static final String RENDER_BUNDLE_IF_MOD = "RENDER_BUNDLE_IF_MOD";
  protected static final String RENDER_BUNDLE_IF_MATCH = "RENDER_BUNDLE_IF_MATCH";
  protected static final String RENDER_BUNDLE_IF_NONE = "RENDER_BUNDLE_IF_NONE";
  protected static final String RENDER_BUNDLE_DOCUMENT_CONTENT = "RENDER_BUNDLE_DOCUMENT_CONTENT";
  protected static final String RENDER_BUNDLE_HEADER_DOC_ENTRY_URD = "RENDER_BUNDLE_HEADER_DOC_ENTRY_URD";
  protected static final String RENDER_BUNDLE_HEADER_DOC_ENTRY_U = "RENDER_BUNDLE_HEADER_DOC_ENTRY_U";
  protected static final String RENDER_BUNDLE_HEADER_DOC_ENTRY_RD = "RENDER_BUNDLE_HEADER_DOC_ENTRY_RD";

  /** the plan here is to make this have it's own implementation of messages, rather than using the 
   * validator messages, for better alignment with publisher I18n strategy
   * 
   * @param theMessage
   * @param theMessageArguments
   * @return
   */
  protected String formatMessage(String theMessage, Object... theMessageArguments) {
    return context.getWorker().formatMessage(theMessage, theMessageArguments);
  }

  public void genStandardsStatus(XhtmlNode td, StandardsStatus ss) {
    if (ss != null) {
      td.tx(" ");
      XhtmlNode a = td.ah(Utilities.pathURL(context.getLink(KnownLinkType.SPEC), "versions.html#std-process"), "Standards Status = "+ss.toDisplay());
      a.style("padding-left: 3px; padding-right: 3px; border: 1px grey solid; font-weight: bold; color: black; background-color: "+ss.getColor());
      a.tx(ss.getAbbrev());
    }
  }

}
