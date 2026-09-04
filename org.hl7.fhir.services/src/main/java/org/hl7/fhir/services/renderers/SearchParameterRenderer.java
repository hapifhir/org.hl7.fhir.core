package org.hl7.fhir.services.renderers;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.Enumerations.SearchComparator;
import org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


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
    p.tx(context.formatPhrase(RenderingI18nContext.GENERAL_PAR)+" ");
    p.code().tx(spd.getCode());
    p.tx(":");
    p.code().tx(spd.getType().toCode());
    addMarkdown(x, spd.getDescription());

    XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = tbl.tr();
    tr.td().tx(Utilities.pluralize(context.formatPhrase(RenderingI18nContext.GENERAL_RESOURCE), spd.getBaseList().size()));
    XhtmlNode td = tr.td();
    for (UriType t : spd.getBaseList()) {
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(t.getValue());
      if (sd != null && sd.hasWebPath()) {
        td.sep(", ");
        td.ah(context.prefixLocalHref(context.prefixLocalHref(sd.getWebPath()))).tx(t.getValue());
      } else {
        td.sep(", ");
        td.tx(t.getValue());
      }
    }
    tr = tbl.tr();
    tr.td().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_EXP));
    if (spd.hasExpression()) {
      tr.td().code().tx(spd.getExpression());
    } else {
      tr.td().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_NONE));
    }
    if (spd.hasProcessingMode()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_PROC));
      tr.td().tx(spd.getProcessingMode().getDisplay());      
    }
    if (spd.hasTarget()) {
      tr = tbl.tr();
      tr.td().tx(Utilities.pluralize(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_REND_TARGET), spd.getTargetList().size()));
      td = tr.td();
      if (isAllConcreteResources(spd.getTargetList())) {
        td.ah(context.prefixLocalHref(Utilities.pathURL(context.getLink(KnownLinkType.SPEC, true), "resourcelist.html"))).tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_RES));
      } else {
        for (UriType t : spd.getTargetList()) {
          StructureDefinition sd = context.getWorker().fetchTypeDefinition(t.getValue());
          if (sd != null && sd.hasWebPath()) {
            td.sep(", ");
            td.ah(context.prefixLocalHref(sd.getWebPath())).tx(t.getValue());
          } else {
            td.sep(", ");
            td.tx(t.getValue());
          }
        }
      }
    }
    tr = tbl.tr();    
    tr.td().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLES));
    XhtmlNode ul = tr.td().ul();
    if (!spd.hasMultipleAnd()) {
      ul.li().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLE_AND_SERVER));
    } else if (spd.getMultipleAnd()) {
      ul.li().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLE_AND_REPEAT));
    } else {
      ul.li().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLE_AND_APPEAR));
    }
    if (!spd.hasMultipleOr()) {
      ul.li().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLE_OR_SERVER));
    } else if (spd.getMultipleOr()) {
      ul.li().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLE_OR_MULTIPLE));
    } else {
      ul.li().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_MULTIPLE_OR_ONE));
    }

    if (spd.hasComparator()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.GENERAL_COMPARATORS));
      td = tr.td();
      td.tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_ALLOWED)+" ");
      for (Enumeration<SearchComparator> t : spd.getComparatorList()) {
        td.sep(", ");
        td.tx(t.asStringValue());
      }      
    }
    if (spd.hasModifier()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.GENERAL_MODIFIERS));
      td = tr.td();
      td.tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_ALLOWED)+" ");
      for (Enumeration<SearchParameter.SearchModifierAllCodes> t : spd.getModifierList()) {
        td.sep(", ");
        td.tx(t.asStringValue());
      }      
    }
    if (spd.hasChain()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_CHAIN));
      td = tr.td();
      td.tx(context.formatPhrase(RenderingI18nContext.SEARCH_PAR_ALLOWED)+" ");
      for (StringType t : spd.getChainList()) {
        td.sep(", ");
        td.tx(t.asStringValue());
      }      
    }
    
    if (spd.hasComponent()) {
      x.para().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_COMPONENT));
      tbl = x.table("grid", false).markGenerated(!context.forValidResource());
      for (SearchParameterComponentComponent t : spd.getComponentList()) {
        tr = tbl.tr();
        SearchParameter tsp = context.getWorker().fetchResource(SearchParameter.class, t.getDefinition(), ExtensionUtilities.getVersionResolutionRules(t.getDefinitionElement()), null, spd);
        if (tsp != null && tsp.hasWebPath()) {
          tr.td().ah(context.prefixLocalHref(tsp.getWebPath())).tx(tsp.present());          
        } else {
          tr.td().tx(t.getDefinition());
        }
        tr.td().code().tx(t.getExpression());
        var tdt = tr.td();
        if (tsp != null) {
          tdt.code().tx(tsp.getTypeElement().getCode());
        }
      }
    }
  }

  private boolean isAllConcreteResources(List<UriType> list) {
    for (String s : context.getWorker().getResourceNames()) {
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(s);
      if (!sd.getAbstract() && !Utilities.existsInList(sd.getType(), "Parameters")) {
        boolean found = false;
        for (UriType c : list) {
          found = found || sd.getName().equals(c.getValue());
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
