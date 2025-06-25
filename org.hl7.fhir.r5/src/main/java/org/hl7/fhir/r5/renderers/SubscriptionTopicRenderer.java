package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class SubscriptionTopicRenderer extends ResourceRenderer {

  public SubscriptionTopicRenderer(RenderingContext context) { 
    super(context); 
  } 
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper st) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(st, x);
    genSummaryTable(status, x, (CanonicalResource) st.getResourceNative());

    XhtmlNode tbl = x.table("grid", false);
    XhtmlNode ttr = tbl.tr();
    ttr.td().b().tx("SubscriptionTopic");
    ttr.td().tx(context.getTranslated(st.has("title") ? st.child("title") : st.child("name")));
    if (st.has("description")) {
      ttr = tbl.tr();
      ttr.td().b().tx("Description");
      addMarkdown(ttr.td(), st.primitiveValue("description"));
    }
    if (st.has("copyright")) {
      generateCopyrightTableRow(tbl, st);
    }

    
    if (st.has("resourceTrigger")) {
      TableData td = new TableData(context.formatPhrase(RenderingContext.SUB_TOPIC_RES_TRIG));
      for (ResourceWrapper rt : st.children("resourceTrigger")) {
        TableRowData tr = td.addRow();
        if (rt.has("resource")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_RESOURCE), rt.child("resource"));
        }
        for (ResourceWrapper t : rt.children("supportedInteraction")) {          
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_INT), t);
        }
        if (rt.has("queryCriteria")) {
          StringBuilder md = new StringBuilder(); 
          ResourceWrapper qc = rt.child("queryCriteria");
          if (qc.has("previous")) {
            md.append(context.formatPhrase(RenderingContext.SUB_TOPIC_PREV, qc.primitiveValue("previous")+"\r\n")+" ");
          }
          if (qc.has("resultForCreate")) {
            md.append(context.formatPhrase(RenderingContext.SUB_TOPIC_CREATE, qc.primitiveValue("resultForCreate")+"\r\n")+" ");
          }
          if (qc.has("current")) {
            md.append(context.formatPhrase(RenderingContext.SUB_TOPIC_CURR, qc.primitiveValue("current")+"\r\n")+" ");
          }
          if (qc.has("previous")) {
            md.append(context.formatPhrase(RenderingContext.SUB_TOPIC_DELETE, qc.primitiveValue("resultForDelete")+"\r\n")+" ");
          }
          if (qc.has("requireBoth")) {
            md.append(context.formatPhrase(RenderingContext.SUB_TOPIC_REQ, qc.primitiveValue("requireBoth")+"\r\n")+" ");
          }
          tr.value(context.formatPhrase(RenderingContext.GENERAL_CRIT), wrapNC(new MarkdownType(md.toString())));          
        }
        if (rt.has("fhirPathCriteria")) {
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_FHIR_PATH), rt.child("fhirPathCriteria"));
        }
        if (rt.has("description")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_DESC), rt.child("description"));
        }
      }
      renderTable(status, td, x);
    }

    if (st.has("eventTrigger")) {
      TableData td = new TableData("Event Triggers");
      for (ResourceWrapper rt : st.children("eventTrigger")) {
        TableRowData tr = td.addRow();
        if (rt.has("resource")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_RESOURCE), rt.child("resource"));
        }
        if (rt.has("event(")) {
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_EVENT), rt.child("event"));
        }
        if (rt.has("description")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_DESC), rt.child("description"));
        }
      }
      renderTable(status, td, x);
    }

    if (st.has("canFilterBy")) {
      TableData td = new TableData("Can Filter By");
      for (ResourceWrapper rt : st.children("canFilterBy")) {
        TableRowData tr = td.addRow();
        if (rt.has("resource")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_RESOURCE), rt.child("resource"));
        }
        if (rt.has("filterParameter")) {
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_FILT_PAR), rt.child("filterParameter"));
        }
        if (rt.has("filterDefinition")) {
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_FILT_DEF), rt.child("filterDefinition"));
        }
        for (ResourceWrapper t : rt.children("comparator")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_COMPARATORS), t);
        }
        for (ResourceWrapper t : rt.children("modifier")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_MODIFIERS), t);
        }
      }
      renderTable(status, td, x);
    }

    if (st.has("notificationShape")) {
      TableData td = new TableData("Notification Shapes");
      for (ResourceWrapper rt : st.children("notificationShape")) {
        TableRowData tr = td.addRow();
        if (rt.has("resource")) {
          tr.value(context.formatPhrase(RenderingContext.GENERAL_RESOURCE), rt.child("resource"));
        }
        for (ResourceWrapper t : rt.children("include")) {
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_INCL), t);
        }
        for (ResourceWrapper t : rt.children("revInclude")) {
          tr.value(context.formatPhrase(RenderingContext.SUB_TOPIC_REV_INCL), t);
        }
      }
      renderTable(status, td, x);
    }
  }

}
