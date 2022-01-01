package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.Extension;
import org.hl7.fhir.r4b.model.OperationDefinition;
import org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.SearchParameter;
import org.hl7.fhir.r4b.model.SearchParameter.SearchComparator;
import org.hl7.fhir.r4b.model.SearchParameter.SearchModifierCode;
import org.hl7.fhir.r4b.model.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.utils.EOperationOutcome;
import org.hl7.fhir.r4b.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class SearchParameterRenderer extends TerminologyRenderer {

  public SearchParameterRenderer(RenderingContext context) {
    super(context);
  }

  public SearchParameterRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws IOException, FHIRException, EOperationOutcome {
    return render(x, (OperationDefinition) dr);
  }

  public boolean render(XhtmlNode x, SearchParameter spd) throws IOException, FHIRException, EOperationOutcome {
    x.h2().addText(spd.getName());
    XhtmlNode p =  x.para();
    p.tx("Parameter ");
    p.code().tx(spd.getCode());
    p.tx(":");
    p.code().tx(spd.getType().toCode());
    addMarkdown(x, spd.getDescription());

    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();
    tr.td().tx(Utilities.pluralize("Resource", spd.getBase().size()));
    XhtmlNode td = tr.td();
    for (CodeType t : spd.getBase()) {
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(t.toString());
      if (sd != null && sd.hasUserData("path")) {
        td.sep(", ").ah(sd.getUserString("path")).tx(t.getCode());
      } else {
        td.sep(", ").tx(t.getCode());
      }
    }
    tr = tbl.tr();
    tr.td().tx("Expression");
    if (spd.hasExpression()) {
      tr.td().code().tx(spd.getExpression());
    } else {
      tr.td().tx("(none)");
    }
    if (spd.hasXpathUsage()) {
      tr = tbl.tr();
      tr.td().tx("Usage");
      tr.td().tx(spd.getXpathUsage().getDisplay());      
    }
    if (spd.hasXpath()) {
      tr = tbl.tr();
      tr.td().tx("XPath");
      tr.td().code().tx(spd.getXpath());      
    }
    if (spd.hasTarget()) {
      tr = tbl.tr();
      tr.td().tx(Utilities.pluralize("Target Resources", spd.getTarget().size()));
      td = tr.td();
      for (CodeType t : spd.getTarget()) {
        StructureDefinition sd = context.getWorker().fetchTypeDefinition(t.toString());
        if (sd != null && sd.hasUserData("path")) {
          td.sep(", ").ah(sd.getUserString("path")).tx(t.getCode());
        } else {
          td.sep(", ").tx(t.getCode());
        }
      }
    }
    tr = tbl.tr();
    tr.td().tx("Multiples");
    if (spd.getMultipleAnd() && spd.getMultipleOr()) {
      tr.td().tx("The parameter can repeat (and) and can have repeating values (or)");      
    } else if (spd.getMultipleOr()) {
      tr.td().tx("The parameter can repeat (and) but each repeat can only have one value");      
    } else if (spd.getMultipleAnd()) {
      tr.td().tx("The parameter cannot repeat (and) but the single parameter can have multiple values (or)");      
    } else { 
      tr.td().tx("The parameter cannot repeat or have multiple values");
    }
    if (spd.hasComparator()) {
      tr = tbl.tr();
      tr.td().tx("Comparators");
      td = tr.td().tx("Allowed: ");
      for (Enumeration<SearchComparator> t : spd.getComparator()) {
        td.sep(", ").tx(t.asStringValue());
      }      
    }
    if (spd.hasModifier()) {
      tr = tbl.tr();
      tr.td().tx("Modifiers");
      td = tr.td().tx("Allowed: ");
      for (Enumeration<SearchModifierCode> t : spd.getModifier()) {
        td.sep(", ").tx(t.asStringValue());
      }      
    }
    if (spd.hasChain()) {
      tr = tbl.tr();
      tr.td().tx("Chains");
      td = tr.td().tx("Allowed: ");
      for (StringType t : spd.getChain()) {
        td.sep(", ").tx(t.asStringValue());
      }      
    }
    
    if (spd.hasComponent()) {
      x.para().b().tx("Components");
      tbl = x.table("grid");
      for (SearchParameterComponentComponent t : spd.getComponent()) {
        tr = tbl.tr();
        SearchParameter tsp = context.getWorker().fetchResource(SearchParameter.class, t.getDefinition());
        if (tsp != null && tsp.hasUserData("path")) {
          tr.td().ah(tsp.getUserString("path")).tx(tsp.present());          
        } else {
          tr.td().tx(t.getDefinition());
        }
        tr.td().code().tx(t.getExpression());
      }
    }
    return false;
  }

  public void describe(XhtmlNode x, OperationDefinition opd) {
    x.tx(display(opd));
  }

  public String display(OperationDefinition opd) {
    return opd.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((OperationDefinition) r).present();
  }

}
