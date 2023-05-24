package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.SearchComparator;
import org.hl7.fhir.r5.model.Enumerations.SearchModifierCode;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.Requirements;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.SubscriptionTopic;
import org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicEventTriggerComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class SubscriptionTopicRenderer extends ResourceRenderer {

  public SubscriptionTopicRenderer(RenderingContext context) {
    super(context);
  }

  public SubscriptionTopicRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (SubscriptionTopic) dr);
  }

  public boolean render(XhtmlNode x, SubscriptionTopic st) throws FHIRFormatError, DefinitionException, IOException {

    if (context.isHeader()) {
      XhtmlNode h = x.h2();
      h.addText(st.hasTitle() ? st.getTitle() : st.getName());
      addMarkdown(x, st.getDescription());
      if (st.hasCopyright())
        generateCopyright(x, st);
    }
    
    if (st.hasResourceTrigger()) {
      TableData td = new TableData("Resource Triggers");
      for (SubscriptionTopicResourceTriggerComponent rt : st.getResourceTrigger()) {
        TableRowData tr = td.addRow();
        if (rt.hasResource()) {
          tr.value("Resource", rt.getResourceElement());
        }
        for (Enumeration<InteractionTrigger> t : rt.getSupportedInteraction()) {          
          tr.value("Interactions", t);
        }
        if (rt.hasQueryCriteria()) {
          StringBuilder md = new StringBuilder();          
          if (rt.getQueryCriteria().hasPrevious()) {
            md.append("* previous = "+rt.getQueryCriteria().getPrevious()+"\r\n");
          }
          if (rt.getQueryCriteria().hasResultForCreate()) {
            md.append("* create result = "+rt.getQueryCriteria().getResultForCreate()+"\r\n");
          }
          if (rt.getQueryCriteria().hasCurrent()) {
            md.append("* create result = "+rt.getQueryCriteria().getCurrent()+"\r\n");
          }
          if (rt.getQueryCriteria().hasPrevious()) {
            md.append("* delete result = "+rt.getQueryCriteria().getResultForDelete()+"\r\n");
          }
          if (rt.getQueryCriteria().hasRequireBoth()) {
            md.append("* require both = "+rt.getQueryCriteria().getRequireBoth()+"\r\n");
          }
          tr.value("Criteria", new MarkdownType(md.toString()));          
        }
        if (rt.hasFhirPathCriteriaElement()) {
          tr.value("FHIR Path", rt.getFhirPathCriteriaElement());
        }
        if (rt.hasDescription()) {
          tr.value("Description", rt.getDescriptionElement());
        }
      }
      renderTable(td, x);
    }

    if (st.hasResourceTrigger()) {
      TableData td = new TableData("Event Triggers");
      for (SubscriptionTopicEventTriggerComponent rt : st.getEventTrigger()) {
        TableRowData tr = td.addRow();
        if (rt.hasResource()) {
          tr.value("Resource", rt.getResourceElement());
        }
        if (rt.hasEvent()) {
          tr.value("Event", rt.getEvent());
        }
        if (rt.hasDescription()) {
          tr.value("Description", rt.getDescriptionElement());
        }
      }
      renderTable(td, x);
    }

    if (st.hasCanFilterBy()) {
      TableData td = new TableData("Can Filter By");
      for (SubscriptionTopicCanFilterByComponent rt : st.getCanFilterBy()) {
        TableRowData tr = td.addRow();
        if (rt.hasResource()) {
          tr.value("Resource", rt.getResourceElement());
        }
        if (rt.hasFilterParameter()) {
          tr.value("Filter Parameter", rt.getFilterParameterElement());
        }
        if (rt.hasFilterDefinition()) {
          tr.value("Filter Definition", rt.getFilterDefinitionElement());
        }
        for (Enumeration<SearchComparator> t : rt.getComparator()) {
          tr.value("Comparators", t);
        }
        for (Enumeration<SearchModifierCode> t : rt.getModifier()) {
          tr.value("Modifiers", t);
        }
      }
      renderTable(td, x);
    }

    if (st.hasNotificationShape()) {
      TableData td = new TableData("Notification Shapes");
      for (SubscriptionTopicNotificationShapeComponent rt : st.getNotificationShape()) {
        TableRowData tr = td.addRow();
        if (rt.hasResource()) {
          tr.value("Resource", rt.getResourceElement());
        }
        for (StringType t : rt.getInclude()) {
          tr.value("Includes", t);
        }
        for (StringType t : rt.getRevInclude()) {
          tr.value("Reverse Includes", t);
        }
      }
      renderTable(td, x);
    }

    return false;
  }

  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((Library) r).present();
  }

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    return "??";
  }

}
