package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.SearchComparator;
import org.hl7.fhir.r5.model.Enumerations.SearchModifierCode;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class SearchParameterRenderer extends TerminologyRenderer {


  public SearchParameterRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (SearchParameter) r.getBase());

      render(status, x, (SearchParameter) r.getBase());      
    } else {
      // the intention is to change this in the future
      x.para().tx("SearchParameterRenderer only renders native resources directly");
    }
  }
  
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, SearchParameter spd) throws IOException, FHIRException, EOperationOutcome {
    XhtmlNode h2 = x.h2();
    h2.addText(spd.getName());
    StandardsStatus ss = ExtensionUtilities.getStandardsStatus(spd);
    if (context.isShowStandardsStatus() && ss != context.getDefaultStandardsStatus()) {
      genStandardsStatus(h2, ss);
    }
    XhtmlNode p =  x.para();
    p.tx(context.formatPhrase(RenderingContext.GENERAL_PAR)+" ");
    p.code().tx(spd.getCode());
    p.tx(":");
    p.code().tx(spd.getType().toCode());
    addMarkdown(x, spd.getDescription());

    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = tbl.tr();
    tr.td().tx(Utilities.pluralize(context.formatPhrase(RenderingContext.GENERAL_RESOURCE), spd.getBase().size()));
    XhtmlNode td = tr.td();
    for (Enumeration<VersionIndependentResourceTypesAll> t : spd.getBase()) {
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(t.getCode());
      if (sd != null && sd.hasWebPath()) {
        td.sep(", ");
        td.ah(context.prefixLocalHref(context.prefixLocalHref(sd.getWebPath()))).tx(t.getCode());
      } else {
        td.sep(", ");
        td.tx(t.getCode());
      }
    }
    tr = tbl.tr();
    tr.td().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_EXP));
    if (spd.hasExpression()) {
      tr.td().code().tx(spd.getExpression());
    } else {
      tr.td().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_NONE));
    }
    if (spd.hasProcessingMode()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_PROC));
      tr.td().tx(spd.getProcessingMode().getDisplay());      
    }
    if (spd.hasTarget()) {
      tr = tbl.tr();
      tr.td().tx(Utilities.pluralize(context.formatPhrase(RenderingContext.SEARCH_PAR_REND_TARGET), spd.getTarget().size()));
      td = tr.td();
      if (isAllConcreteResources(spd.getTarget())) {
        td.ah(context.prefixLocalHref(Utilities.pathURL(context.getLink(KnownLinkType.SPEC, true), "resourcelist.html"))).tx(context.formatPhrase(RenderingContext.SEARCH_PAR_RES));
      } else {
        for (Enumeration<VersionIndependentResourceTypesAll> t : spd.getTarget()) {
          StructureDefinition sd = context.getWorker().fetchTypeDefinition(t.getCode());
          if (sd != null && sd.hasWebPath()) {
            td.sep(", ");
            td.ah(context.prefixLocalHref(sd.getWebPath())).tx(t.getCode());
          } else {
            td.sep(", ");
            td.tx(t.getCode());
          }
        }
      }
    }
    tr = tbl.tr();    
    tr.td().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLES));
    XhtmlNode ul = tr.td().ul();
    if (!spd.hasMultipleAnd()) {
      ul.li().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLE_AND_SERVER));
    } else if (spd.getMultipleAnd()) {
      ul.li().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLE_AND_REPEAT));
    } else {
      ul.li().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLE_AND_APPEAR));
    }
    if (!spd.hasMultipleOr()) {
      ul.li().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLE_OR_SERVER));
    } else if (spd.getMultipleOr()) {
      ul.li().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLE_OR_MULTIPLE));
    } else {
      ul.li().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_MULTIPLE_OR_ONE));
    }

    if (spd.hasComparator()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_COMPARATORS));
      td = tr.td();
      td.tx(context.formatPhrase(RenderingContext.SEARCH_PAR_ALLOWED)+" ");
      for (Enumeration<SearchComparator> t : spd.getComparator()) {
        td.sep(", ");
        td.tx(t.asStringValue());
      }      
    }
    if (spd.hasModifier()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_MODIFIERS));
      td = tr.td();
      td.tx(context.formatPhrase(RenderingContext.SEARCH_PAR_ALLOWED)+" ");
      for (Enumeration<SearchModifierCode> t : spd.getModifier()) {
        td.sep(", ");
        td.tx(t.asStringValue());
      }      
    }
    if (spd.hasChain()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.SEARCH_PAR_CHAIN));
      td = tr.td();
      td.tx(context.formatPhrase(RenderingContext.SEARCH_PAR_ALLOWED)+" ");
      for (StringType t : spd.getChain()) {
        td.sep(", ");
        td.tx(t.asStringValue());
      }      
    }
    
    if (spd.hasComponent()) {
      x.para().b().tx(context.formatPhrase(RenderingContext.GENERAL_COMPARATORS));
      tbl = x.table("grid", false).markGenerated(!context.forValidResource());
      for (SearchParameterComponentComponent t : spd.getComponent()) {
        tr = tbl.tr();
        SearchParameter tsp = context.getWorker().fetchResource(SearchParameter.class, t.getDefinition(), null, spd);
        if (tsp != null && tsp.hasWebPath()) {
          tr.td().ah(context.prefixLocalHref(tsp.getWebPath())).tx(tsp.present());          
        } else {
          tr.td().tx(t.getDefinition());
        }
        tr.td().code().tx(t.getExpression());
      }
    }
  }

  private boolean isAllConcreteResources(List<Enumeration<VersionIndependentResourceTypesAll>> list) {
    for (String s : context.getWorker().getResourceNames()) {
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(s);
      if (!sd.getAbstract() && !Utilities.existsInList(sd.getType(), context.formatPhrase(RenderingContext.GENERAL_PAR))) {
        boolean found = false;
        for (Enumeration<VersionIndependentResourceTypesAll> c : list) {
          found = found || sd.getName().equals(c.getCode());
        }
        if (!found) {
          return false;
        }
      }
    }
    return true;
  }

  public void describe(XhtmlNode x, OperationDefinition opd) {
    x.tx(display(opd));
  }

  public String display(OperationDefinition opd) {
    return opd.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((SearchParameter) r).present();
  }

}
