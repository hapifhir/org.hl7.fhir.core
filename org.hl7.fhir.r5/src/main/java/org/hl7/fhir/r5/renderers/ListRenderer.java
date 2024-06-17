package org.hl7.fhir.r5.renderers; 
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ListResource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.XhtmlNode; 
 
public class ListRenderer extends ResourceRenderer { 
 
  public ListRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return "todo";
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement list) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (list.has("title")) { 
      x.h2().tx(list.primitiveValue("title")); 
    } 
    XhtmlNode t = x.table("clstu"); 
    XhtmlNode tr = t.tr(); 
    XhtmlNode td = tr.td(); 
    if (list.has("date")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_DATE, displayDateTime(list.child("date")))+" "); 
    }  
    if (list.has("mode")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_MODE, list.primitiveValue("mode"))+" "); 
    } 
    if (list.has("status")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_STAT, list.primitiveValue("status"))+" "); 
    } 
    if (list.has("code")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_CODE, displayDataType(list.child("code")))+" "); 
    }     
    tr = t.tr(); 
    td = tr.td(); 
    if (list.has("subject")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_SUB)+" "); 
      renderReference(status, td, list.child("subject")); 
    } 
    if (list.has("encounter")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_ENC)+" "); 
      renderReference(status, td, list.child("encounter")); 
    } 
    if (list.has("source")) { 
      td.tx(context.formatPhrase(RenderingContext.GENERAL_SRC)+" "); 
      renderReference(status, td, list.child("encounter")); 
    } 
    if (list.has("orderedBy")) { 
      td.tx(context.formatPhrase(RenderingContext.LIST_REND_ORD, displayDataType(list.child("orderedBy")))+" "); 
    } 
    for (ResourceElement a : list.children("note")) { 
      renderAnnotation(status, x, a); 
    } 
    boolean flag = false; 
    boolean deleted = false; 
    boolean date = false; 
    for (ResourceElement e : list.children("entry")) { 
      flag = flag || e.has("flag"); 
      deleted = deleted || e.has("deleted"); 
      date = date || e.has("date"); 
    } 
    t = x.table("grid"); 
    tr = t.tr().style("backgound-color: #eeeeee"); 
    tr.td().b().tx(context.formatPhrase(RenderingContext.LIST_REND_ITEM)); 
    if (date) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_DAT));       
    } 
    if (flag) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_FLAG));       
    } 
    if (deleted) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_DEL));       
    } 
    for (ResourceElement e : list.children("entry")) { 
      tr = t.tr(); 
      renderReference(status, tr.td(), e.child("item")); 
      if (date) { 
        tr.td().tx(e.has("date") ? displayDateTime(e.child("date")) : "");       
      } 
      if (flag) { 
        tr.td().tx(e.has("flag") ? displayDataType(e.child("flag")) : "");       
      } 
      if (deleted) { 
        tr.td().tx(e.has("deleted") ? e.primitiveValue("deleted") : ""); 
      } 
    }     
  } 
  
  public void describe(XhtmlNode x, ListResource list) { 
    x.tx(display(list)); 
  } 
 
  public String display(ListResource list) { 
    return list.getTitle(); 
  } 
 
 
} 
