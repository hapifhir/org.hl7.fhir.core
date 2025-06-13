package org.hl7.fhir.r5.renderers; 
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ListResource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode; 
 
@MarkedToMoveToAdjunctPackage
public class ListRenderer extends ResourceRenderer { 
 
  public ListRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    ResourceWrapper c = r.child("code");
    String cd = c == null ? context.formatPhrase(RenderingContext.LIST_UNSPECIFIED_CODE) : displayCodeableConcept(c);
    ResourceWrapper s = r.child("subject");
    String sd = s == null ? context.formatPhrase(RenderingContext.LIST_UNSPECIFIED_SUBJECT) : displayReference(s);
    return context.formatPhrase(RenderingContext.LIST_SUMMARY, cd, sd);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper list) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(list, x);
    if (list.has("title")) { 
      x.h2().tx(list.primitiveValue("title")); 
    } 
    XhtmlNode t = x.table("clstu", false); 
    XhtmlNode tr = t.tr(); 
    if (list.has("date")) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_DATE, displayDateTime(list.child("date")))+" "); 
    }  
    if (list.has("mode")) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_MODE, getTranslatedCode(list.child("mode")))+" "); 
    } 
    if (list.has("status")) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_STAT, getTranslatedCode(list.child("status")))+" "); 
    } 
    if (list.has("code")) { 
      tr.td().tx(context.formatPhrase(RenderingContext.LIST_REND_CODE, displayDataType(list.child("code")))+" "); 
    }     
    tr = t.tr(); 
    XhtmlNode td = tr.td(); 
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
    for (ResourceWrapper a : list.children("note")) { 
      renderAnnotation(status, x, x.para().tx("note"), a); 
    } 
    boolean flag = false; 
    boolean deleted = false; 
    boolean date = false; 
    for (ResourceWrapper e : list.children("entry")) { 
      flag = flag || e.has("flag"); 
      deleted = deleted || e.has("deleted"); 
      date = date || e.has("date"); 
    } 
    t = x.table("grid", false); 
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
    for (ResourceWrapper e : list.children("entry")) { 
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
    
    if (list.has("contained") && context.isTechnicalMode()) {
      x.hr();
      x.para().b().tx(context.formatMessagePlural(list.children("contained").size(), RenderingContext.PAT_CONTAINED));
      addContained(status, x, list.children("contained"));
    }
  } 
  
  public void describe(XhtmlNode x, ListResource list) { 
    x.tx(display(list)); 
  } 
 
  public String display(ListResource list) { 
    return list.getTitle(); 
  } 
 
 
} 
