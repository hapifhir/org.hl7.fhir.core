package org.hl7.fhir.r5.renderers;


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
public class Renderer {

}
