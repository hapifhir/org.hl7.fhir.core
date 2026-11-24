package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;


public class ActorDefinitionRenderer extends ResourceRenderer {


  public ActorDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(r, x);
    boolean summ = genSummaryTable(status, x, r);
    render(status, x, r, summ);      
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, ResourceWrapper acd, boolean summ) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tbl = x.table("grid", false);
    XhtmlNode tr;
    XhtmlNode td;

    // the table has 3 columns:
    //   * name, title - only if neither the summary table nor the IG page header already shows them (#1118)
    //   * type, derived from
    //   * documentation
    //   * category, references, capabilities - if present
    //
    // this renders ActorDefinitions of all versions:
    //   * R5 (also used in R4/R4B IGs): derivedFrom, capabilities
    //   * R6: baseDefinition (was derivedFrom), category; no capabilities
    boolean igMode = context.getRules() == RenderingContext.GenerationRules.IG_PUBLISHER;
    if (!summ && !igMode) {
      tr = tbl.tr();
      xlinkNarrative(tr.td(), acd.child("name")).b().tx(context.formatPhrase(RenderingI18nContext.ACTOR_DEF_ACT, context.getTranslated(acd.child("name")))  + " ");
      xlinkNarrative(tr.td().colspan("2"), acd.child("title")).tx(context.getTranslated(acd.child("title")));
    }

    tr = tbl.tr();
    xlinkNarrative(tr.td(), acd.child("type")).tx(context.formatPhrase(RenderingI18nContext.ACTOR_DEF_TYP, acd.primitiveValue("type")) + " ");
    markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingI18nContext.ACTOR_DERIVED_FROM));
    td = tr.td();
    if (acd.hasMN("derivedFrom", "baseDefinition")) {
      boolean first = true;
      for (ResourceWrapper t : acd.childrenMN("derivedFrom", "baseDefinition")) {
        if (first) first = false; else td.br();
        renderCanonical(status, spanIfTracking(td, t), t);
      }
    } else {
      markGenerated(td).style("opacity: 0.6").tx(context.formatPhrase(RenderingI18nContext.ACTOR_DERIVED_FROM_NONE));
    }

    if (acd.has("documentation")) {
      tr = tbl.tr();
      td = tr.td().colspan("3");
      xlinkNarrative(td, acd.child("documentation"));
      addMarkdown(td, context.getTranslated(acd.child("documentation")));
    }
    if (acd.has("category")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingI18nContext.ACTOR_DEF_CAT));
      td = tr.td().colspan("2");
      boolean first = true;
      for (ResourceWrapper t : acd.children("category")) {
        if (first) first = false; else td.tx(", ");
        renderDataType(status, spanIfTracking(td, t), t);
      }
    }
    if (acd.has("reference")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingI18nContext.GENERAL_REFS));
      td = tr.td().colspan("2");
      boolean first = true;
      for (ResourceWrapper t : acd.children("reference")) {
        if (first) first = false; else td.br();
        renderUri(status, spanIfTracking(td, t), t);
      }
    }
    if (acd.has("capabilities")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingI18nContext.ACTOR_DEF_CAP));
      td = tr.td().colspan("2");
      renderCanonical(status, xlinkNarrative(td, acd.child("capabilities")), acd.child("capabilities"));
    }
  }

  public void describe(XhtmlNode x, Library lib) {
    x.tx(display(lib));
  }

  public String display(Library lib) {
    return lib.present();
  }
  
}
